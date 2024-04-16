package com.nanokulon.primalstage;

import com.google.common.collect.Maps;
import com.nanokulon.primalstage.init.*;
import com.nanokulon.primalstage.mixin.SheepEntityDropsAccessor;
import com.nanokulon.primalstage.world.ModFeatures;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class PrimalStage {

	public static final String MOD_ID = "primalstage";
	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "primal_group"));

	public PrimalStage() {
		ModBlocks.init();
		ModItems.init();
		ModEvents.init();
		ModBlockEntities.init(FMLJavaModLoadingContext.get().getModEventBus());
		ModFeatures.init();
		ModRecipes.init();

		ModConfig.init();
		ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON, ModConfig.CONFIG.getValue());
	}

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ModItems.STONE_PEBBLE))
				.displayName(Text.literal("Primal Stage"))
				.entries((enabledFeatures, entries) -> {
					ModItemGroup.entries(entries);
				})
				.build());

		if (ModConfig.CONFIG.wool_scrap) {
			SheepEntityDropsAccessor.setDrops(Util.make(Maps.newEnumMap(DyeColor.class), map -> {
				map.put(DyeColor.WHITE, ModItems.WHITE_WOOL_SCRAP);
				map.put(DyeColor.ORANGE, ModItems.ORANGE_WOOL_SCRAP);
				map.put(DyeColor.MAGENTA, ModItems.MAGENTA_WOOL_SCRAP);
				map.put(DyeColor.LIGHT_BLUE, ModItems.LIGHT_BLUE_WOOL_SCRAP);
				map.put(DyeColor.YELLOW, ModItems.YELLOW_WOOL_SCRAP);
				map.put(DyeColor.LIME, ModItems.LIME_WOOL_SCRAP);
				map.put(DyeColor.PINK, ModItems.PINK_WOOL_SCRAP);
				map.put(DyeColor.GRAY, ModItems.GRAY_WOOL_SCRAP);
				map.put(DyeColor.LIGHT_GRAY, ModItems.LIGHT_GRAY_WOOL_SCRAP);
				map.put(DyeColor.CYAN, ModItems.CYAN_WOOL_SCRAP);
				map.put(DyeColor.PURPLE, ModItems.PURPLE_WOOL_SCRAP);
				map.put(DyeColor.BLUE, ModItems.BLUE_WOOL_SCRAP);
				map.put(DyeColor.BROWN, ModItems.BROWN_WOOL_SCRAP);
				map.put(DyeColor.GREEN, ModItems.GREEN_WOOL_SCRAP);
				map.put(DyeColor.RED, ModItems.RED_WOOL_SCRAP);
				map.put(DyeColor.BLACK, ModItems.BLACK_WOOL_SCRAP);
			}));
		}
	}
}