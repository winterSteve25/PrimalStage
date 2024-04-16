package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PrimalStage.MOD_ID, value = Dist.CLIENT)
public class ColorProvider {
    @SubscribeEvent
    public static void registerBlock(RegisterColorHandlersEvent.Block event){
        event.register((state, view, pos, tintIndex) -> {
            assert view != null;
            return BiomeColors.getAverageFoliageColor(view, pos);
        }, ModBlocks.BUSH_BLOCK.get());
    }

    @SubscribeEvent
    public static void registerItem(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> 0x5E9D34, ModBlocks.BUSH_BLOCK.get());
    }
}
