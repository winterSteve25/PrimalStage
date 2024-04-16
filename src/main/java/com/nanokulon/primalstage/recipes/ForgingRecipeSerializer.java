package com.nanokulon.primalstage.recipes;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public enum ForgingRecipeSerializer implements RecipeSerializer<ForgingRecipe> {
    INSTANCE;

    @Override
    public ForgingRecipe fromJson(ResourceLocation id, JsonObject json) {
        return ForgingRecipe.CODEC.decode(JsonOps.INSTANCE, json).getOrThrow(false, System.err::println).getFirst();
    }

    @Override
    public ForgingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return buf.readJsonWithCodec(ForgingRecipe.CODEC);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, ForgingRecipe recipe) {
        buf.writeJsonWithCodec(ForgingRecipe.CODEC, recipe);
    }
}
