package com.nanokulon.primalstage.recipes;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public enum CuttingRecipeSerializer implements RecipeSerializer<CuttingRecipe> {
    INSTANCE;

    @Override
    public CuttingRecipe fromJson(ResourceLocation id, JsonObject json) {
        return CuttingRecipe.CODEC.decode(JsonOps.INSTANCE, json).getOrThrow(false, System.err::println).getFirst();
    }

    @Override
    public CuttingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return buf.readJsonWithCodec(CuttingRecipe.CODEC);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, CuttingRecipe recipe) {
        buf.writeJsonWithCodec(CuttingRecipe.CODEC, recipe);
    }
}
