package com.nanokulon.primalstage.mixin;

import com.google.common.collect.ImmutableMap;
import com.nanokulon.primalstage.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.InteractionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.World;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Optional;

@Mixin(AxeItem.class)
public abstract class UseOnBlockMixin extends DiggerItem {

    @Unique
    private static final Map<Block, RegistryObject<Item>> BARK_TYPES = new ImmutableMap.Builder<Block, RegistryObject<Item>>()
            .put(Blocks.OAK_LOG, ModItems.OAK_BARK)
            .put(Blocks.BIRCH_LOG, ModItems.BIRCH_BARK)
            .put(Blocks.JUNGLE_LOG, ModItems.JUNGLE_BARK)
            .put(Blocks.DARK_OAK_LOG, ModItems.DARK_OAK_BARK)
            .put(Blocks.SPRUCE_LOG, ModItems.SPRUCE_BARK)
            .put(Blocks.ACACIA_LOG, ModItems.ACACIA_BARK)
            .put(Blocks.MANGROVE_LOG, ModItems.MANGROVE_BARK).build();

    public UseOnBlockMixin(float attackDamage, float attackSpeed, Tier material, Properties settings) {
        super(attackDamage, attackSpeed, material, BlockTags.MINEABLE_WITH_AXE, settings);
    }

    @Inject(
            method = "useOn(Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;",
            at = @At("HEAD")
    )
    private void useItem(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<Item> optional = getBarkType(blockState);
        if(optional.isPresent()){
            ItemStack itemStack = new ItemStack(optional.get());
            Containers.dropItemStack(world, (double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), itemStack);
        }
    }

    @Unique
    private Optional<Item> getBarkType(BlockState state) {
        return Optional.ofNullable(BARK_TYPES.get(state.getBlock()).get());
    }
}
