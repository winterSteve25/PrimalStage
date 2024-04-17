package com.nanokulon.primalstage;

import com.google.common.collect.Maps;
import com.nanokulon.primalstage.init.*;
import com.nanokulon.primalstage.mixin.SheepEntityDropsAccessor;
import com.nanokulon.primalstage.world.ModFeatures;

import net.minecraft.Util;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class PrimalStage {

	public static final String MOD_ID = "primalstage";

	public PrimalStage() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ModBlocks.init(bus);
		ModItems.init(bus);
		ModBlockEntities.init(bus);
		ModRecipes.init(bus);
        ModCreativeTab.init(bus);
        ModFeatures.init(bus);

		ModConfig.init();
		ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.CONFIG.getValue());

        bus.addListener(PrimalStage::onInitialize);
	}

	public static void onInitialize(FMLCommonSetupEvent event) {
		if (ModConfig.CONFIG.getLeft().woolScrap.get()) {
			SheepEntityDropsAccessor.setDrops(Util.make(Maps.newEnumMap(DyeColor.class), map -> {
				map.put(DyeColor.WHITE, ModItems.WHITE_WOOL_SCRAP.get());
				map.put(DyeColor.ORANGE, ModItems.ORANGE_WOOL_SCRAP.get());
				map.put(DyeColor.MAGENTA, ModItems.MAGENTA_WOOL_SCRAP.get());
				map.put(DyeColor.LIGHT_BLUE, ModItems.LIGHT_BLUE_WOOL_SCRAP.get());
				map.put(DyeColor.YELLOW, ModItems.YELLOW_WOOL_SCRAP.get());
				map.put(DyeColor.LIME, ModItems.LIME_WOOL_SCRAP.get());
				map.put(DyeColor.PINK, ModItems.PINK_WOOL_SCRAP.get());
				map.put(DyeColor.GRAY, ModItems.GRAY_WOOL_SCRAP.get());
				map.put(DyeColor.LIGHT_GRAY, ModItems.LIGHT_GRAY_WOOL_SCRAP.get());
				map.put(DyeColor.CYAN, ModItems.CYAN_WOOL_SCRAP.get());
				map.put(DyeColor.PURPLE, ModItems.PURPLE_WOOL_SCRAP.get());
				map.put(DyeColor.BLUE, ModItems.BLUE_WOOL_SCRAP.get());
				map.put(DyeColor.BROWN, ModItems.BROWN_WOOL_SCRAP.get());
				map.put(DyeColor.GREEN, ModItems.GREEN_WOOL_SCRAP.get());
				map.put(DyeColor.RED, ModItems.RED_WOOL_SCRAP.get());
				map.put(DyeColor.BLACK, ModItems.BLACK_WOOL_SCRAP.get());
			}));
		}
	}
}
