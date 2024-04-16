package com.nanokulon.primalstage.blocks.entity;

import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.init.ModRecipes;
import com.nanokulon.primalstage.recipes.DryingRecipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

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
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class DryingRackBlockEntity extends BlockEntity {

    private final NonNullList<ItemStack> itemsBeingDrying = NonNullList.withSize(4, ItemStack.EMPTY);
    private final RecipeManager.CachedCheck<Container, DryingRecipe> matchGetter = RecipeManager.createCheck(ModRecipes.DRYING.get());
    private final int[] dryingTimes = new int[4];
    private final int[] dryingTotalTimes = new int[4];

    public DryingRackBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DRYING_RACK_BLOCK_ENTITY.get(), pos, state);
    }

    public NonNullList<ItemStack> getItemsBeingDrying() {
        return this.itemsBeingDrying;
    }

    public static void tick(Level world, BlockPos pos, BlockState state, DryingRackBlockEntity blockEntity) {
        if(!(world.isDay())) return;
        boolean bl = false;
        for (int i = 0; i < blockEntity.itemsBeingDrying.size(); ++i) {
            ItemStack itemStack2;
            ItemStack itemStack = blockEntity.itemsBeingDrying.get(i);
            if (itemStack.isEmpty() ||  blockEntity.dryingTimes[i] >= blockEntity.dryingTotalTimes[i]) continue;
            bl = true;
            blockEntity.dryingTimes[i] = blockEntity.dryingTimes[i] + 1;
            if (blockEntity.dryingTimes[i] < blockEntity.dryingTotalTimes[i]) continue;
            itemStack2 = blockEntity.matchGetter.getRecipeFor(new SimpleContainer(itemStack), world).get().getOutput().getDefaultInstance().copy();
            blockEntity.itemsBeingDrying.set(i, itemStack2);
            world.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
        }
        if (bl) {
            DryingRackBlockEntity.setChanged(world, pos, state);
        }
    }

    public Optional<DryingRecipe> getRecipeFor(ItemStack stack) {
        if (this.itemsBeingDrying.stream().noneMatch(ItemStack::isEmpty)) {
            return Optional.empty();
        }
        return this.matchGetter.getRecipeFor(new SimpleContainer(stack), this.level);
    }

    public boolean addItem(ItemStack stack, int cookTime, int slot) {
        ItemStack itemStack = this.itemsBeingDrying.get(slot);
        if (!itemStack.isEmpty()) return false;
        this.dryingTotalTimes[slot] = cookTime;
        this.dryingTimes[slot] = 0;
        this.itemsBeingDrying.set(slot, stack.split(1));
        this.updateListeners();
        return true;
    }

    public boolean getItem(@Nullable Player user, int slot) {
        ItemStack itemStack = this.itemsBeingDrying.get(slot);
        if (itemStack.isEmpty()) return false;
        if(user != null) user.getInventory().add(itemStack);
        this.itemsBeingDrying.set(slot, ItemStack.EMPTY);
        this.updateListeners();
        return true;
    }

    private void updateListeners() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        ContainerHelper.saveAllItems(nbt, this.itemsBeingDrying, true);
        nbt.putIntArray("DryingTimes", this.dryingTimes);
        nbt.putIntArray("DryingTotalTimes", this.dryingTotalTimes);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        int[] is;
        super.load(nbt);
        this.itemsBeingDrying.clear();
        ContainerHelper.loadAllItems(nbt, this.itemsBeingDrying);
        if (nbt.contains("DryingTimes", Tag.TAG_INT_ARRAY)) {
            is = nbt.getIntArray("DryingTimes");
            System.arraycopy(is, 0, this.dryingTimes, 0, Math.min(this.dryingTotalTimes.length, is.length));
        }
        if (nbt.contains("DryingTotalTimes", Tag.TAG_INT_ARRAY)) {
            is = nbt.getIntArray("DryingTotalTimes");
            System.arraycopy(is, 0, this.dryingTotalTimes, 0, Math.min(this.dryingTotalTimes.length, is.length));
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
        ContainerHelper.saveAllItems(nbtCompound, this.itemsBeingDrying, true);
        return nbtCompound;
    }
}
