package com.nanokulon.primalstage.recipes;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public enum KilnRecipeSerializer implements RecipeSerializer<KilnRecipe> {
    INSTANCE;

    @Override
    public KilnRecipe fromJson(ResourceLocation id, JsonObject json) {
        return KilnRecipe.CODEC.decode(JsonOps.INSTANCE, json).getOrThrow(false, System.err::println).getFirst();
    }

    @Override
    public KilnRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        return buf.readJsonWithCodec(KilnRecipe.CODEC);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, KilnRecipe recipe) {
        buf.writeJsonWithCodec(KilnRecipe.CODEC, recipe);
    }
}
