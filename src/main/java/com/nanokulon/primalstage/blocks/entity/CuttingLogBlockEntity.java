package com.nanokulon.primalstage.blocks.entity;

import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.init.ModRecipes;
import com.nanokulon.primalstage.recipes.CuttingRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CuttingLogBlockEntity extends BlockEntity {

    private final NonNullList<ItemStack> itemBeingCutting = NonNullList.withSize(1, ItemStack.EMPTY);
    private final RecipeManager.CachedCheck<Container, CuttingRecipe> matchGetter = RecipeManager.createCheck(ModRecipes.CUTTING.get());
    private final int[] hitCount = new int[1];
    private final int[] hitTotalCount = new int[1];

    public CuttingLogBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CUTTING_LOG_BLOCK_ENTITY.get(), pos, state);
    }

    public NonNullList<ItemStack> getItemsBeingCutting() {
        return this.itemBeingCutting;
    }

    public static void tick(Level world, BlockPos pos, BlockState state, CuttingLogBlockEntity blockEntity) {
        ItemStack itemStack2;
        ItemStack itemStack = blockEntity.itemBeingCutting.get(0);
        if (itemStack.isEmpty() ||  blockEntity.hitTotalCount[0] == 0) return;
        CuttingLogBlockEntity.setChanged(world, pos, state);
        if (blockEntity.hitCount[0] < blockEntity.hitTotalCount[0]) return;
        itemStack2 = blockEntity.matchGetter.getRecipeFor(new SimpleContainer(itemStack), world).get().getOutput().getDefaultInstance().copy();
        Containers.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
        blockEntity.itemBeingCutting.set(0, ItemStack.EMPTY);
        world.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
        CuttingLogBlockEntity.setChanged(world, pos, state);
    }

    public boolean addHit(){
        if (this.hitCount[0] < this.hitTotalCount[0]) {
            this.hitCount[0] = this.hitCount[0] + 1;
            return true;
        }
        return false;
    }

    public Optional<CuttingRecipe> getRecipeFor(ItemStack stack) {
        if (this.itemBeingCutting.isEmpty()) {
            return Optional.empty();
        }
        return this.matchGetter.getRecipeFor(new SimpleContainer(stack), this.level);
    }

    public boolean addItem(ItemStack stack, int cookTime) {
        ItemStack itemStack = this.itemBeingCutting.get(0);
        if (!itemStack.isEmpty()) return false;
        this.hitTotalCount[0] = cookTime;
        this.hitCount[0] = 0;
        this.itemBeingCutting.set(0, stack.split(1));
        this.updateListeners();
        return true;
    }

    public boolean getItem(@Nullable Player user) {
        ItemStack itemStack = this.itemBeingCutting.get(0);
        if (itemStack.isEmpty()) return false;
        if(user != null) user.getInventory().add(itemStack);
        this.itemBeingCutting.set(0, ItemStack.EMPTY);
        this.updateListeners();
        return true;
    }

    private void updateListeners() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        ContainerHelper.saveAllItems(nbt, this.itemBeingCutting, true);
        nbt.putIntArray("HitCount", this.hitCount);
        nbt.putIntArray("HitTotalCount", this.hitTotalCount);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        int[] is;
        super.load(nbt);
        this.itemBeingCutting.clear();
        ContainerHelper.loadAllItems(nbt, this.itemBeingCutting);
        if (nbt.contains("HitCount", Tag.TAG_INT_ARRAY)) {
            is = nbt.getIntArray("HitCount");
            System.arraycopy(is, 0, this.hitCount, 0, Math.min(this.hitTotalCount.length, is.length));
        }
        if (nbt.contains("HitTotalCount", Tag.TAG_INT_ARRAY)) {
            is = nbt.getIntArray("HitTotalCount");
            System.arraycopy(is, 0, this.hitTotalCount, 0, Math.min(this.hitTotalCount.length, is.length));
        }
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbtCompound = new CompoundTag();
        ContainerHelper.saveAllItems(nbtCompound, this.itemBeingCutting, true);
        return nbtCompound;
    }
}
