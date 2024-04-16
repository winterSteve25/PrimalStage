package com.nanokulon.primalstage.blocks;

import com.nanokulon.primalstage.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import org.jetbrains.annotations.Nullable;

public class Logs extends Block {

    private static final VoxelShape SHAPE_1 = Block.box(0.1D, 0.0D, 0.1D, 16.0D, 4.0D, 16.0D);
    private static final VoxelShape SHAPE_2 = Block.box(0.1D, 0.0D, 0.1D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape SHAPE_3 = Block.box(0.1D, 0.0D, 0.1D, 16.0D, 12.0D, 16.0D);
    private static final VoxelShape SHAPE_4 = Block.box(0.1D, 0.0D, 0.1D, 16.0D, 16.0D, 16.0D);
    public static final IntegerProperty LOGS = IntegerProperty.create("logs", 1, 12);

    public Logs(Properties settings){
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LOGS, 1));
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(LOGS, Math.min(12, blockState.getValue(LOGS) + 1));
        }
        return super.getStateForPlacement(ctx);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (!context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && state.getValue(LOGS) < 12) {
            return true;
        }
        return super.canBeReplaced(state, context);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if(player.isShiftKeyDown() && this.getItem(player, world, pos, state)){
            world.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())) {
            return;
        }
        int count = state.getValue(LOGS);
        if (count > 1) {
            ItemStack items = this.getWoodType(state);
            items.setCount(count-1);
            Containers.dropContents(world, pos, new SimpleContainer(items));
        }
        super.onRemove(state, world, pos, newState, moved);
    }

    public boolean getItem(Player player, Level world, BlockPos pos, BlockState state) {
        ItemStack itemStack = this.getWoodType(state);
        int i = state.getValue(LOGS);
        if(player != null) player.getInventory().add(itemStack);
        if(i == 1) {
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_CLIENTS);
        } else world.setBlock(pos, state.setValue(LOGS, i - 1), Block.UPDATE_CLIENTS);
        return true;
    }

    public ItemStack getWoodType(BlockState state){
        if(state.getBlock().equals(ModBlocks.BIRCH_LOGS)) return new ItemStack(ModBlocks.BIRCH_LOGS.get());
        if(state.getBlock().equals(ModBlocks.SPRUCE_LOGS)) return new ItemStack(ModBlocks.SPRUCE_LOGS.get());
        if(state.getBlock().equals(ModBlocks.DARK_OAK_LOGS)) return new ItemStack(ModBlocks.DARK_OAK_LOGS.get());
        if(state.getBlock().equals(ModBlocks.JUNGLE_LOGS)) return new ItemStack(ModBlocks.JUNGLE_LOGS.get());
        if(state.getBlock().equals(ModBlocks.ACACIA_LOGS)) return new ItemStack(ModBlocks.ACACIA_LOGS.get());
        if(state.getBlock().equals(ModBlocks.MANGROVE_LOGS)) return new ItemStack(ModBlocks.MANGROVE_LOGS.get());
        if(state.getBlock().equals(ModBlocks.CRIMSON_LOGS)) return new ItemStack(ModBlocks.CRIMSON_LOGS.get());
        if(state.getBlock().equals(ModBlocks.WARPED_LOGS)) return new ItemStack(ModBlocks.WARPED_LOGS.get());
        return new ItemStack(ModBlocks.OAK_LOGS.get());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LOGS);
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if(state.getValue(LOGS) > 9){
            return SHAPE_4;
        }
        if(state.getValue(LOGS) > 6){
            return SHAPE_3;
        }
        if(state.getValue(LOGS) > 3){
            return SHAPE_2;
        }
        return SHAPE_1;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
