
package com.nanokulon.primalstage.blocks;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HedgeBlock extends CrossCollisionBlock {

    private final VoxelShape[] cullingShapes;

    public HedgeBlock(Properties settings) {
        super(1.0f, 1.0f, 16.0f, 16.0f, 24.0f, settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false));
        this.cullingShapes = this.makeShapes(2.0f, 1.0f, 16.0f, 6.0f, 15.0f);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return this.cullingShapes[this.getAABBIndex(state)];
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return this.getShape(state, world, pos, context);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return false;
    }

    public boolean canConnect(BlockState state, boolean neighborIsFullSquare, Direction dir) {
        Block block = state.getBlock();
        boolean bl2 = block instanceof HedgeBlock;
        return !HedgeBlock.isExceptionForConnection(state) && neighborIsFullSquare || bl2;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide) {
            ItemStack itemStack = player.getItemInHand(hand);
            if (itemStack.is(Items.LEAD)) {
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }
        return LeadItem.bindPlayerMobs(player, world, pos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level blockView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockState blockState = blockView.getBlockState(blockPos2);
        BlockState blockState2 = blockView.getBlockState(blockPos3);
        BlockState blockState3 = blockView.getBlockState(blockPos4);
        BlockState blockState4 = blockView.getBlockState(blockPos5);
        return super.getStateForPlacement(ctx).setValue(NORTH, this.canConnect(blockState, blockState.isFaceSturdy(blockView, blockPos2, Direction.SOUTH), Direction.SOUTH)).setValue(EAST, this.canConnect(blockState2, blockState2.isFaceSturdy(blockView, blockPos3, Direction.WEST), Direction.WEST)).setValue(SOUTH, this.canConnect(blockState3, blockState3.isFaceSturdy(blockView, blockPos4, Direction.NORTH), Direction.NORTH)).setValue(WEST, this.canConnect(blockState4, blockState4.isFaceSturdy(blockView, blockPos5, Direction.EAST), Direction.EAST)).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        if (direction.getAxis().getPlane() == Direction.Plane.HORIZONTAL) {
            return state.setValue(PROPERTY_BY_DIRECTION.get(direction), this.canConnect(neighborState, neighborState.isFaceSturdy(world, neighborPos, direction.getOpposite()), direction.getOpposite()));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}

