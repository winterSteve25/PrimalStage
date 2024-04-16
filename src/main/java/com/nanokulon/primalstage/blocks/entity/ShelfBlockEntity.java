package com.nanokulon.primalstage.blocks.entity;

import com.nanokulon.primalstage.init.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;

import org.jetbrains.annotations.Nullable;

public class ShelfBlockEntity extends BlockEntity {

    private final NonNullList<ItemStack> itemsBeingDrying = NonNullList.withSize(4, ItemStack.EMPTY);
    public ShelfBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), pos, state);
    }

    public NonNullList<ItemStack> getItemsBeingDrying() {
        return this.itemsBeingDrying;
    }

    public boolean addItem(ItemStack stack, int slot) {
        ItemStack itemStack = this.itemsBeingDrying.get(slot);
        if (itemStack.isEmpty() || (itemStack.getItem() == stack.getItem() && itemStack.getCount() < stack.getMaxStackSize())) {
            ItemStack stack1 = stack.split(64 - itemStack.getCount());
            stack1.setCount(stack1.getCount() + itemStack.getCount());
            this.itemsBeingDrying.set(slot, stack1);
            this.updateListeners();
            return true;
        }
        return false;
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
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.itemsBeingDrying.clear();
        ContainerHelper.loadAllItems(nbt, this.itemsBeingDrying);
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
