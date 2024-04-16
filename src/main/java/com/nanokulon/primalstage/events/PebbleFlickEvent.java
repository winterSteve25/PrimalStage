package com.nanokulon.primalstage.events;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = PrimalStage.MOD_ID, value = Dist.DEDICATED_SERVER)
public class PebbleFlickEvent {

    private static final Random random = new Random();
    private static final double consumeChance = 0.8;
    private static final double successChance = 0.2;

    @SubscribeEvent
    public static void use(PlayerInteractEvent event) {
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
}
