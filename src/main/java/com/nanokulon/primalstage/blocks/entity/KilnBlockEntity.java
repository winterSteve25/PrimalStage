package com.nanokulon.primalstage.blocks.entity;

import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.init.ModRecipes;
import com.nanokulon.primalstage.recipes.KilnRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class KilnBlockEntity extends BlockEntity {

    private final NonNullList<ItemStack> itemsBeingCooked = NonNullList.withSize(1, ItemStack.EMPTY);
    private final RecipeManager.CachedCheck<Container, KilnRecipe> matchGetter = RecipeManager.createCheck(ModRecipes.KILN.get());
    private final int[] cookingTimes = new int[1];
    private final int[] cookingTotalTimes = new int[1];

    public KilnBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.KILN_BLOCK_ENTITY.get(), pos, state);
    }

    public NonNullList<ItemStack> getItemsBeingCooked() {
        return this.itemsBeingCooked;
    }

    public static void tick(Level world, BlockPos pos, BlockState state, KilnBlockEntity blockEntity) {
        if(!blockEntity.isLit(world, pos)) return;
        boolean bl = false;
        for (int i = 0; i < blockEntity.itemsBeingCooked.size(); ++i) {
            ItemStack itemStack2;
            ItemStack itemStack = blockEntity.itemsBeingCooked.get(i);
            if (itemStack.isEmpty() ||  blockEntity.cookingTimes[i] >= blockEntity.cookingTotalTimes[i]) continue;
            bl = true;
            blockEntity.cookingTimes[i] = blockEntity.cookingTimes[i] + 1;
            if (blockEntity.cookingTimes[i] < blockEntity.cookingTotalTimes[i]) continue;
            itemStack2 = blockEntity.matchGetter.getRecipeFor(new SimpleContainer(itemStack), world).get().getOutput().getDefaultInstance().copy();
            blockEntity.itemsBeingCooked.set(i, itemStack2);
            world.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
        }
        if (bl) {
            KilnBlockEntity.setChanged(world, pos, state);
        }
    }

    public boolean isLit(Level world, BlockPos pos){
        return world.getBlockState(pos.below(1)).getBlock().equals(Blocks.FIRE);
    }

    public Optional<KilnRecipe> getRecipeFor(ItemStack stack) {
        if (this.itemsBeingCooked.stream().noneMatch(ItemStack::isEmpty)) {
            return Optional.empty();
        }
        return this.matchGetter.getRecipeFor(new SimpleContainer(stack), this.level);
    }

    public boolean addItem(ItemStack stack, int cookTime, int slot) {
        ItemStack itemStack = this.itemsBeingCooked.get(slot);
        if (!itemStack.isEmpty()) return false;
        this.cookingTotalTimes[slot] = cookTime;
        this.cookingTimes[slot] = 0;
        this.itemsBeingCooked.set(slot, stack.split(1));
        this.updateListeners();
        return true;
    }

    public boolean getItem(@Nullable Player user, int slot) {
        ItemStack itemStack = this.itemsBeingCooked.get(slot);
        if (itemStack.isEmpty()) return false;
        if(user != null) user.getInventory().add(itemStack);
        this.itemsBeingCooked.set(slot, ItemStack.EMPTY);
        this.updateListeners();
        return true;
    }

    private void updateListeners() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        ContainerHelper.saveAllItems(nbt, this.itemsBeingCooked, true);
        nbt.putIntArray("CookingTimes", this.cookingTimes);
        nbt.putIntArray("CookingTotalTimes", this.cookingTotalTimes);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        int[] is;
        super.load(nbt);
        this.itemsBeingCooked.clear();
        ContainerHelper.loadAllItems(nbt, this.itemsBeingCooked);
        if (nbt.contains("CookingTimes", Tag.TAG_INT_ARRAY)) {
            is = nbt.getIntArray("CookingTimes");
            System.arraycopy(is, 0, this.cookingTimes, 0, Math.min(this.cookingTotalTimes.length, is.length));
        }
        if (nbt.contains("CookingTotalTimes", Tag.TAG_INT_ARRAY)) {
            is = nbt.getIntArray("CookingTotalTimes");
            System.arraycopy(is, 0, this.cookingTotalTimes, 0, Math.min(this.cookingTotalTimes.length, is.length));
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
        ContainerHelper.saveAllItems(nbtCompound, this.itemsBeingCooked, true);
        return nbtCompound;
    }
}
