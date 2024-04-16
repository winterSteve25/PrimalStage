package com.nanokulon.primalstage.blocks;

import com.nanokulon.primalstage.blocks.entity.ShelfBlockEntity;
import com.nanokulon.primalstage.utils.SlotUtils;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import org.jetbrains.annotations.Nullable;

public class ShelfBlock extends BaseEntityBlock implements EntityBlock {

    protected static final VoxelShape SHAPE_NORTH = Block.box(0.1, 0.0, 10, 16.0, 16.0, 16.0);
    protected static final VoxelShape SHAPE_SOUTH = Block.box(0.1, 0.0, 0.1, 16.0, 16.0, 6.0);
    protected static final VoxelShape SHAPE_WEST = Block.box(10, 0.0, 0.1, 16.0, 16.0, 16.0);
    protected static final VoxelShape SHAPE_EAST = Block.box(0.1, 0.0, 0.1, 6.0, 16.0, 16.0);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ShelfBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(hit.getDirection() != state.getValue(FACING)){
            return InteractionResult.CONSUME;
        }
        Direction direction = state.getValue(FACING).getOpposite();
        int slot;
        if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
            slot = getSlot((hit.getBlockPos().getX() % 1), (hit.getBlockPos().getY() % 1), direction);
        } else {
            slot = getSlot((hit.getBlockPos().getZ() % 1), (hit.getBlockPos().getY() % 1), direction);
        }
        if(player.isShiftKeyDown() && blockEntity instanceof ShelfBlockEntity){
            if(!world.isClientSide && ((ShelfBlockEntity) blockEntity).getItem(player, slot)){
                world.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        itemStack = player.getItemInHand(hand);
        if (blockEntity instanceof ShelfBlockEntity){
            if (!world.isClientSide && ((ShelfBlockEntity) blockEntity).addItem(itemStack, slot)) {
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    private int getSlot(double x, double y, Direction direction) {
        return switch (direction) {
            case NORTH -> SlotUtils.getNorthSlot(x, y);
            case SOUTH -> SlotUtils.getSouthSlot(x, y);
            case WEST -> SlotUtils.getWestSlot(x, y);
            default -> SlotUtils.getEastSlot(x, y);
        };
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())) {
            return;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof ShelfBlockEntity) {
            Containers.dropContents(world, pos, ((ShelfBlockEntity)blockEntity).getItemsBeingDrying());
        }
        super.onRemove(state, world, pos, newState, moved);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        if( direction == Direction.SOUTH) return SHAPE_SOUTH;
        if( direction == Direction.WEST) return SHAPE_WEST;
        if( direction == Direction.EAST) return SHAPE_EAST;
        return SHAPE_NORTH;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
