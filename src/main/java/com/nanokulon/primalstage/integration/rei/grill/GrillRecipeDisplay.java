package com.nanokulon.primalstage.integration.rei.grill;

import com.google.common.collect.ImmutableList;
import com.nanokulon.primalstage.integration.rei.ModReiPlugin;
import com.nanokulon.primalstage.recipes.GrillRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class GrillRecipeDisplay extends BasicDisplay {

    private double cookTime;

    public GrillRecipeDisplay(GrillRecipe recipe) {
        super(EntryIngredients.ofIngredients(recipe.getIngredients()), EntryIngredients.ofIngredients(recipe.getOutputIngredients()));
        this.cookTime = recipe.getCookingTime();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ModReiPlugin.GRILL;
    }

    @Override
    public List<EntryIngredient> getRequiredEntries() {
        List<EntryIngredient> requiredEntries = new ArrayList<>(super.getRequiredEntries());

        return ImmutableList.copyOf(requiredEntries);
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        List<EntryIngredient> inputEntryList = new ArrayList<>(super.getInputEntries());

        return ImmutableList.copyOf(inputEntryList);
    }

    public double getCookTime() {
        return cookTime;
    }

    public List<EntryIngredient> getOutput() {
        return super.getOutputEntries();
    }

}
