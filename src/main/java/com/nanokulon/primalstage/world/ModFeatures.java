package com.nanokulon.primalstage.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.init.ModBlocks;
import com.nanokulon.primalstage.init.ModConfig;
import com.nanokulon.primalstage.init.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockPileConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModFeatures {

    private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, PrimalStage.MOD_ID);

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registries.PLACED_FEATURE, PrimalStage.MOD_ID);

    private static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_PEBBLE_PILE = CONFIGURED_FEATURES
            .register("pebbles", () -> new ConfiguredFeature<>(Feature.BLOCK_PILE,
                    new BlockPileConfiguration(BlockStateProvider.simple(ModBlocks.PEBBLE_BLOCK.get()))));
    public static final RegistryObject<PlacedFeature> PEBBLE_PLACED_KEY = PLACED_FEATURES
            .register("pebbles", () -> new PlacedFeature(CONFIGURED_PEBBLE_PILE.getHolder().get(), List.of(PlacementUtils.HEIGHTMAP)));

    private static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_TWIGS = CONFIGURED_FEATURES
            .register("twigs", () -> new ConfiguredFeature<>(Feature.BLOCK_PILE,
                    new BlockPileConfiguration(BlockStateProvider.simple(ModBlocks.TWIGS_BLOCK.get()))));
    public static final RegistryObject<PlacedFeature> TWIG_PILES = PLACED_FEATURES
            .register("twigs", () -> new PlacedFeature(CONFIGURED_TWIGS.getHolder().get(), List.of(PlacementUtils.HEIGHTMAP)));

    private static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_BUSH = CONFIGURED_FEATURES
            .register("bush", () -> new ConfiguredFeature<>(Feature.BLOCK_PILE,
                    new BlockPileConfiguration(BlockStateProvider.simple(ModBlocks.BUSH_BLOCK.get()))));
    public static final RegistryObject<PlacedFeature> BUSH_PLACED_KEY = PLACED_FEATURES
            .register("bush", () -> new PlacedFeature(CONFIGURED_BUSH.getHolder().get(), List.of(PlacementUtils.HEIGHTMAP)));

    private static final RegistryObject<ConfiguredFeature<?, ?>> CONFIGURED_SALT = CONFIGURED_FEATURES
            .register("salt", () -> new ConfiguredFeature<>(Feature.BLOCK_PILE,
                    new BlockPileConfiguration(BlockStateProvider.simple(ModBlocks.TWIGS_BLOCK.get()))));
    public static final RegistryObject<PlacedFeature> SALT = PLACED_FEATURES
            .register("salt", () -> new PlacedFeature(CONFIGURED_PEBBLE_PILE.getHolder().get(), List.of(PlacementUtils.HEIGHTMAP)));

    private static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, PrimalStage.MOD_ID);

    public static final RegistryObject<Codec<ModBiomeModifier>> BIOME_MODIFIER = BIOME_MODIFIER_SERIALIZERS.register("biome_stuff", () ->
            RecordCodecBuilder.create(builder -> builder.point(new ModBiomeModifier())));

    public static void init(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
        PLACED_FEATURES.register(bus);
        BIOME_MODIFIER_SERIALIZERS.register(bus);
    }
}
