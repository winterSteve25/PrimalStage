package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class ModTags {
    public static final TagKey<Biome> ALLOWS_BUSH_SPAWN = TagKey.create(Registries.BIOME, new ResourceLocation(PrimalStage.MOD_ID, "allows_bush_spawn"));
    public static final TagKey<Item> MALLETS = TagKey.create(Registries.ITEM, new ResourceLocation(PrimalStage.MOD_ID, "mallets"));
    public static final TagKey<Item> LOGS = TagKey.create(Registries.ITEM, new ResourceLocation(PrimalStage.MOD_ID, "logs"));
    public static final TagKey<Item> BARK = TagKey.create(Registries.ITEM, new ResourceLocation(PrimalStage.MOD_ID, "bark"));
}
