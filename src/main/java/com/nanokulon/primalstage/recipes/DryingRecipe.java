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

public class DryingRecipe implements Recipe<Container> {

    private final Item input;
    private final int cookingTime;
    private final Item output;
    public static final Codec<DryingRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("input").forGetter(DryingRecipe::getInput),
            Codec.INT.fieldOf("cookingtime").forGetter(DryingRecipe::getCookingTime),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("result").forGetter(DryingRecipe::getOutput)
    ).apply(instance, DryingRecipe::new));

    public DryingRecipe(Item input, int cookingTime, Item output){
        this.input = input;
        this.output = output;
        this.cookingTime = cookingTime;
    }

    public Item getInput() {
        return this.input;
    }

    public Item getOutput() {
        return this.output;
    }

    public int getCookingTime(){
        return this.cookingTime;
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
        if(inventory.getContainerSize() < 1){
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
        return new ResourceLocation(PrimalStage.MOD_ID, output.toString() + "_from_drying");
    }

    @Override
    public RecipeSerializer<? extends DryingRecipe> getSerializer() {
        return DryingRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends DryingRecipe> getType() {
        return ModRecipes.DRYING.get();
    }

    public static class DryingRecipeType implements RecipeType<DryingRecipe> {
    }
}
