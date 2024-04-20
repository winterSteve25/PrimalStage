package com.nanokulon.primalstage;

import com.nanokulon.primalstage.config.PrimalConfig;
import com.nanokulon.primalstage.events.ServerEvents;
import com.nanokulon.primalstage.init.*;

import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PrimalStage.MOD_ID)
public class PrimalStage {
    public static final String MOD_ID = "primalstage";

    public PrimalStage() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(PrimalStage::onInitialize);

        ModBlocks.init(bus);
        ModItems.init(bus);
        ModBlockEntities.init(bus);
        ModRecipes.init(bus);
        ModCreativeTab.init(bus);

        MinecraftForge.EVENT_BUS.addListener(ServerEvents::createBark);
        MinecraftForge.EVENT_BUS.addListener(ServerEvents::getDigSpeed);

        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, PrimalConfig.SPEC);
    }

    public static void onInitialize(FMLCommonSetupEvent event) {
        if (PrimalConfig.woolScrap) {
            Sheep.ITEM_BY_DYE.put(DyeColor.WHITE, ModItems.WHITE_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.ORANGE, ModItems.ORANGE_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.MAGENTA, ModItems.MAGENTA_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.LIGHT_BLUE, ModItems.LIGHT_BLUE_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.YELLOW, ModItems.YELLOW_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.LIME, ModItems.LIME_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.PINK, ModItems.PINK_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.GRAY, ModItems.GRAY_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.LIGHT_GRAY, ModItems.LIGHT_GRAY_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.CYAN, ModItems.CYAN_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.PURPLE, ModItems.PURPLE_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.BLUE, ModItems.BLUE_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.BROWN, ModItems.BROWN_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.GREEN, ModItems.GREEN_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.RED, ModItems.RED_WOOL_SCRAP.get());
            Sheep.ITEM_BY_DYE.put(DyeColor.BLACK, ModItems.BLACK_WOOL_SCRAP.get());
        }
    }
}
