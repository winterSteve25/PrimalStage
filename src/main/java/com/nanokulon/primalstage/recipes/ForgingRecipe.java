package com.nanokulon.primalstage.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.init.ModRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class ForgingRecipe implements Recipe<Container> {

    private final Item input;
    private final int totalHits;
    private final Item output;
    public static final Codec<ForgingRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("input").forGetter(ForgingRecipe::getInput),
            Codec.INT.fieldOf("totalhits").forGetter(ForgingRecipe::getTotalHits),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("result").forGetter(ForgingRecipe::getOutput)
    ).apply(instance, ForgingRecipe::new));

    public ForgingRecipe(Item input, int totalHits, Item output) {
        this.input = input;
        this.output = output;
        this.totalHits = totalHits;
    }

    public Item getInput() {
        return this.input;
    }

    public Item getOutput() {
        return this.output;
    }

    public int getTotalHits() {
        return this.totalHits;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredient = NonNullList.create();
        ingredient.add(Ingredient.of(input));
        return ingredient;
    }

    public NonNullList<Ingredient> getOutputIngredients() {
        NonNullList<Ingredient> ingredient = NonNullList.create();
        ingredient.add(Ingredient.of(output));
        return ingredient;
    }

    @Override
    public boolean matches(Container inventory, Level world) {
        if (inventory.getContainerSize() < 1) {
            return false;
        }
        return this.input.equals(inventory.getItem(0).getItem());
    }

    @Override
    public ItemStack assemble(Container inventory, RegistryAccess registryManager) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryManager) {
        return new ItemStack(this.output);
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation(PrimalStage.MOD_ID, output.toString() + "_from_forging");
    }

    @Override
    public RecipeSerializer<? extends ForgingRecipe> getSerializer() {
        return ForgingRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends ForgingRecipe> getType() {
        return ModRecipes.FORGING.get();
    }


    public static class ForgingRecipeType implements RecipeType<ForgingRecipe> {
    }
}
