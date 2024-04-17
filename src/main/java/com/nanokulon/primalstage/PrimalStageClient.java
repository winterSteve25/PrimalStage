package com.nanokulon.primalstage;

import com.nanokulon.primalstage.init.ModBlockEntities;
import com.nanokulon.primalstage.init.ModBlocks;
import com.nanokulon.primalstage.render.*;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PrimalStage.MOD_ID, value = Dist.CLIENT)
public class PrimalStageClient {

    @SubscribeEvent
    public static void onInitializeClient(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BUSH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PRIMITIVE_GRILL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.KILN.get(), RenderType.cutout());

        BlockEntityRendererRegistry.register(ModBlockEntities.PRIMITIVE_GRILL_BLOCK_ENTITY.get(), PrimitiveGrillBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.DRYING_RACK_BLOCK_ENTITY.get(), DryingRackBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.CUTTING_LOG_BLOCK_ENTITY.get(), CuttingLogBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.STONE_ANVIL_BLOCK_ENTITY.get(), StoneAnvilBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), ShelfBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.KILN_BLOCK_ENTITY.get(), KilnBlockEntityRenderer::new);
    }
}
