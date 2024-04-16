package com.nanokulon.primalstage.recipes;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public enum GrillRecipeSerializer implements RecipeSerializer<GrillRecipe> {
    INSTANCE;

    @Override
    public GrillRecipe fromJson(ResourceLocation id, JsonObject json) {
        return GrillRecipe.CODEC.decode(JsonOps.INSTANCE, json).getOrThrow(false, System.err::println).getFirst();
    }

    @Override
    public GrillRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return buf.readJsonWithCodec(GrillRecipe.CODEC);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, GrillRecipe recipe) {
        buf.writeJsonWithCodec(GrillRecipe.CODEC, recipe);
    }
}
