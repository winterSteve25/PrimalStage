package com.nanokulon.primalstage.events;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.init.ModBlocks;
import com.nanokulon.primalstage.render.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PrimalStage.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BUSH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PRIMITIVE_GRILL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KILN.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.PRIMITIVE_GRILL_BLOCK_ENTITY.get(), PrimitiveGrillBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.DRYING_RACK_BLOCK_ENTITY.get(), DryingRackBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CUTTING_LOG_BLOCK_ENTITY.get(), CuttingLogBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.STONE_ANVIL_BLOCK_ENTITY.get(), StoneAnvilBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), ShelfBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.KILN_BLOCK_ENTITY.get(), KilnBlockEntityRenderer::new);
    }
}
