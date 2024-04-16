package com.nanokulon.primalstage.world;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.init.ModConfig;
import com.nanokulon.primalstage.init.ModTags;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;

public class ModFeatures {

    public static final RegistryKey<PlacedFeature> PEBBLE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PrimalStage.MOD_ID,"pebble"));
    public static final RegistryKey<PlacedFeature> TWIGS_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PrimalStage.MOD_ID,"twigs"));
    public static final RegistryKey<PlacedFeature> BUSH_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PrimalStage.MOD_ID,"bush"));
    public static final RegistryKey<PlacedFeature> SALT_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PrimalStage.MOD_ID,"salt"));

    public static void init() {
        if (ModConfig.CONFIG.twigs_and_pebbles) {
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.TOP_LAYER_MODIFICATION, PEBBLE_PLACED_KEY);
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.TOP_LAYER_MODIFICATION, TWIGS_PLACED_KEY);
        }
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.ALLOWS_BUSH_SPAWN), GenerationStep.Feature.TOP_LAYER_MODIFICATION, BUSH_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SALT_PLACED_KEY);
    }
}
