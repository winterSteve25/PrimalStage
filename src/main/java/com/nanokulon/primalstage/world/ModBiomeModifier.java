package com.nanokulon.primalstage.world;

import com.mojang.serialization.Codec;
import com.nanokulon.primalstage.init.ModConfig;
import com.nanokulon.primalstage.init.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class ModBiomeModifier implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> holder, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (ModConfig.CONFIG.getLeft().twigsAndPebbles.get()) {
            builder.getGenerationSettings().addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModFeatures.PEBBLE_PLACED_KEY.getHolder().get());
            builder.getGenerationSettings().addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModFeatures.TWIG_PILES.getHolder().get());
        }

        if (holder.getTagKeys().anyMatch((t) -> t == ModTags.ALLOWS_BUSH_SPAWN)) {
            builder.getGenerationSettings().addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModFeatures.BUSH_PLACED_KEY.getHolder().get());
        }

        builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModFeatures.SALT.getHolder().get());
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return ModFeatures.BIOME_MODIFIER.get();
    }
}
