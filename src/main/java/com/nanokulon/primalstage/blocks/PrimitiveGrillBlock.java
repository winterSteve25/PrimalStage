package com.nanokulon.primalstage.blocks;

import com.nanokulon.primalstage.blocks.entity.PrimitiveGrillBlockEntity;
import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.recipes.GrillRecipe;
import com.nanokulon.primalstage.utils.SlotUtils;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;
import java.util.Random;

public class PrimitiveGrillBlock extends BaseEntityBlock implements EntityBlock {

    private final VoxelShape SHAPE = Block.box(0.1, 0.0, 0.1, 16.0, 4.0, 16.0);
    private final int fireDamage;

    public PrimitiveGrillBlock(int fireDamage, Properties settings) {
        super(settings);
        this.fireDamage = fireDamage;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PrimitiveGrillBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.PRIMITIVE_GRILL_BLOCK_ENTITY.get(), PrimitiveGrillBlockEntity::tick);
    }

    public boolean isLit(Level world, BlockPos pos){
        return world.getBlockState(pos.below(1)).getBlock().equals(Blocks.FIRE);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if(!isLit(world, pos)){
            return;
        }
        if (random.nextInt(10) == 0) {
            world.playLocalSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 0.5f + random.nextFloat(), random.nextFloat() * 0.7f + 0.6f, false);
        }
        if (random.nextInt(5) == 0) {
            for (int i = 0; i < random.nextInt(1) + 1; ++i) {
                world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, random.nextFloat() / 2.0f, 5.0E-5, random.nextFloat() / 2.0f);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack;
        PrimitiveGrillBlockEntity primitiveGrillBlockEntity;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        Optional<GrillRecipe> optional;
        if(!(blockEntity instanceof PrimitiveGrillBlockEntity)){
            return InteractionResult.CONSUME;
        }
        if(!(hit.getDirection() == Direction.UP)){
            return InteractionResult.CONSUME;
        }
        int slot = SlotUtils.getSlot((hit.getBlockPos().getX() % 1), (hit.getBlockPos().getZ() % 1));
        if(player.isShiftKeyDown()){
            if(!world.isClientSide && ((PrimitiveGrillBlockEntity) blockEntity).getItem(player, slot)){
                world.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        if ((optional = (primitiveGrillBlockEntity = (PrimitiveGrillBlockEntity) blockEntity).getRecipeFor(itemStack = player.getItemInHand(hand))).isPresent()) {
            if (!world.isClientSide && primitiveGrillBlockEntity.addItem(player.getAbilities().instabuild ? itemStack.copy() : itemStack, optional.get().getCookingTime(), slot)) {
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (isLit(world, pos) && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.hurt(world.damageSources().onFire(), this.fireDamage);
        }
        super.entityInside(state, world, pos, entity);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())) {
            return;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof PrimitiveGrillBlockEntity) {
            Containers.dropContents(world, pos, ((PrimitiveGrillBlockEntity) blockEntity).getItemsBeingCooked());
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
