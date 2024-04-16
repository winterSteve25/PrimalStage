package com.nanokulon.primalstage.recipes;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public enum DryingRecipeSerializer implements RecipeSerializer<DryingRecipe> {
    INSTANCE;

    @Override
    public DryingRecipe fromJson(ResourceLocation id, JsonObject json) {
        return DryingRecipe.CODEC.decode(JsonOps.INSTANCE, json).getOrThrow(false, System.err::println).getFirst();
    }

    @Override
    public DryingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return buf.readJsonWithCodec(DryingRecipe.CODEC);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, DryingRecipe recipe) {
        buf.writeJsonWithCodec(DryingRecipe.CODEC, recipe);
    }
}
