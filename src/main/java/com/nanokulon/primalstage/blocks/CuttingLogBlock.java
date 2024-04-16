package com.nanokulon.primalstage.blocks;

import com.nanokulon.primalstage.blocks.entity.CuttingLogBlockEntity;
import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.recipes.CuttingRecipe;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

public class CuttingLogBlock extends BaseEntityBlock implements EntityBlock {

    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);

    public CuttingLogBlock(BlockBehaviour.Properties settings){
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CuttingLogBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.CUTTING_LOG_BLOCK_ENTITY.get(), CuttingLogBlockEntity::tick);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        Optional<CuttingRecipe> optional;
        ItemStack itemHeld = player.getItemInHand(hand);
        if(!(blockEntity instanceof CuttingLogBlockEntity cuttingLogBlockEntity)){
            return InteractionResult.CONSUME;
        }
        if(!(hit.getDirection() == Direction.UP)){
            return InteractionResult.CONSUME;
        }
        if (player.isShiftKeyDown()) {
            if (!world.isClientSide && cuttingLogBlockEntity.getItem(player)){
                world.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        if(hand.equals(InteractionHand.MAIN_HAND) && itemHeld.getItem() instanceof AxeItem){
            if(!world.isClientSide && cuttingLogBlockEntity.addHit()){
                itemHeld.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
                world.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }
        if ((optional = cuttingLogBlockEntity.getRecipeFor(itemStack = player.getItemInHand(hand))).isPresent()) {
            if (!world.isClientSide && cuttingLogBlockEntity.addItem(player.getAbilities().instabuild ? itemStack.copy() : itemStack, optional.get().getTotalHits())) {
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
        if (blockEntity instanceof CuttingLogBlockEntity) {
            Containers.dropContents(world, pos, ((CuttingLogBlockEntity)blockEntity).getItemsBeingCutting());
        }
        super.onRemove(state, world, pos, newState, moved);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState stateUnder = world.getBlockState(pos.below());
        return stateUnder.isFaceSturdy(world, pos.below(), Direction.UP);
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
