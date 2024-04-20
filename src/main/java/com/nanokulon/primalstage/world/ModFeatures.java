package com.nanokulon.primalstage.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nanokulon.primalstage.PrimalStage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {

//    public static final ResourceKey<PlacedFeature> PEBBLE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PrimalStage.MOD_ID,"pebble"));
//    public static final ResourceKey<PlacedFeature> TWIGS_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PrimalStage.MOD_ID,"twigs"));
//    public static final ResourceKey<PlacedFeature> BUSH_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PrimalStage.MOD_ID,"bush"));
//    public static final ResourceKey<PlacedFeature> SALT_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PrimalStage.MOD_ID,"salt"));
//
//    private static final DeferredRegister<Codec<? extends BiomeModifier>> REGISTER = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, PrimalStage.MOD_ID);
//    public static final RegistryObject<Codec<ModBiomeModifier>> BIOME_MODIFIER = REGISTER.register("biome_stuff", () ->
//            RecordCodecBuilder.create(builder -> builder.point(new ModBiomeModifier())));

    public static void init(IEventBus bus) {
//        REGISTER.register(bus);
    }
}
