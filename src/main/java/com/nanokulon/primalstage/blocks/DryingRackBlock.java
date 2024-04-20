package com.nanokulon.primalstage.blocks;

import com.nanokulon.primalstage.blocks.entity.DryingRackBlockEntity;
import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.recipes.DryingRecipe;
import com.nanokulon.primalstage.utils.SlotUtils;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class DryingRackBlock extends BaseEntityBlock implements EntityBlock  {

    private static final VoxelShape SHAPE = Block.box(0.1, 0.0, 0.1, 16.0, 16.0, 16.0);

    public DryingRackBlock(Properties settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DryingRackBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.DRYING_RACK_BLOCK_ENTITY.get(), DryingRackBlockEntity::tick);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if(!(blockEntity instanceof DryingRackBlockEntity dryingRackBE)){
            return InteractionResult.CONSUME;
        }
        if(!(hit.getDirection() == Direction.UP)){
            return InteractionResult.CONSUME;
        }

        int slot = SlotUtils.getSlot((hit.getLocation().x() % 1), (hit.getLocation().z() % 1));
        if(player.isShiftKeyDown()){
            if(!world.isClientSide && ((DryingRackBlockEntity) blockEntity).getItem(player, slot)){
                world.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }

        Optional<DryingRecipe> recipe = dryingRackBE.getRecipeFor(itemStack);

        if (recipe.isPresent()) {
            if (!world.isClientSide && dryingRackBE.addItem(player.getAbilities().instabuild ? itemStack.copy() : itemStack, recipe.get().getCookingTime(), slot)) {
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())) {
            return;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof DryingRackBlockEntity) {
            Containers.dropContents(world, pos, ((DryingRackBlockEntity)blockEntity).getItemsBeingDrying());
        }
        super.onRemove(state, world, pos, newState, moved);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
