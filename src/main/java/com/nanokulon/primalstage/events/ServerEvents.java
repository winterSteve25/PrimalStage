package com.nanokulon.primalstage.events;

import com.google.common.collect.ImmutableMap;
import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.config.PrimalConfig;
import com.nanokulon.primalstage.init.ModBlocks;
import com.nanokulon.primalstage.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class ServerEvents {
    private static final Random random = new Random();
    private static final double consumeChance = 0.8;
    private static final double successChance = 0.2;

    private static void flick(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);
        ItemStack stack = player.getItemInHand(event.getHand());
        Level world = event.getLevel();

        double r1 = random.nextDouble();
        double r2 = random.nextDouble();

        if (state == null || player == null)
            event.setCancellationResult(InteractionResult.PASS);

        if (player.getInventory().getSelected().getItem().equals(ModItems.STONE_PEBBLE) && state.getSoundType().equals(SoundType.STONE)) {
            if (!world.isClientSide) {
                if (r1 <= consumeChance) {
                    stack.shrink(1);
                    player.setItemInHand(event.getHand(), stack);
                }
                if (r2 <= successChance) {
                    ItemEntity itemEntity = new ItemEntity(
                            world,
                            pos.getX(),
                            pos.getY(),
                            pos.getZ(),
                            new ItemStack(ModItems.STONE_CLUB_HEAD.get(), 1)
                    );
                    world.addFreshEntity(itemEntity);
                    world.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.PLAYERS, 1.0F, 0.5F);
                } else world.playSound(null, pos, SoundEvents.STONE_HIT, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
            event.setCancellationResult(InteractionResult.SUCCESS);
        }
        event.setCancellationResult(InteractionResult.PASS);
    }

    public static void getDigSpeed(PlayerEvent.BreakSpeed event) {
        Item heldItem = event.getEntity().getInventory().getSelected().getItem();
        BlockState state = event.getState();

        boolean isWood = state.getSoundType().equals(SoundType.WOOD) && !state.getBlock().equals(ModBlocks.TWIGS_BLOCK);
        if(isWood && !(heldItem instanceof AxeItem)){
            if (PrimalConfig.disableTreePunching) {
                event.setNewSpeed(0.0f);
            }
        }
    }

    public static void createBark(PlayerInteractEvent.RightClickBlock event) {
        if (!(event.getItemStack().getItem() instanceof AxeItem)) {
            flick(event);
            return;
        }

        Level world = event.getEntity().level();
        BlockPos blockPos = event.getPos();
        BlockState blockState = world.getBlockState(blockPos);
        Optional<Item> optional = getBarkType(blockState);
        if(optional.isPresent()){
            ItemStack itemStack = new ItemStack(optional.get());
            Containers.dropItemStack(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), itemStack);
        }
    }

    private static final Map<Block, RegistryObject<Item>> BARK_TYPES = new ImmutableMap.Builder<Block, RegistryObject<Item>>()
            .put(Blocks.OAK_LOG, ModItems.OAK_BARK)
            .put(Blocks.BIRCH_LOG, ModItems.BIRCH_BARK)
            .put(Blocks.JUNGLE_LOG, ModItems.JUNGLE_BARK)
            .put(Blocks.DARK_OAK_LOG, ModItems.DARK_OAK_BARK)
            .put(Blocks.SPRUCE_LOG, ModItems.SPRUCE_BARK)
            .put(Blocks.ACACIA_LOG, ModItems.ACACIA_BARK)
            .put(Blocks.MANGROVE_LOG, ModItems.MANGROVE_BARK).build();

    private static Optional<Item> getBarkType(BlockState state) {
        if (!BARK_TYPES.containsKey(state.getBlock())) {
            return Optional.empty();
        }

        return Optional.of(BARK_TYPES.get(state.getBlock()).get());
    }
}
