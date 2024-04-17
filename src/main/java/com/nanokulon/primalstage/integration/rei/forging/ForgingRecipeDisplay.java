package com.nanokulon.primalstage.integration.rei.forging;

import com.google.common.collect.ImmutableList;
import com.nanokulon.primalstage.init.ModTags;
import com.nanokulon.primalstage.integration.rei.ModReiPlugin;
import com.nanokulon.primalstage.recipes.ForgingRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ForgingRecipeDisplay extends BasicDisplay {

    private final EntryIngredient toolInput;

    public ForgingRecipeDisplay(ForgingRecipe recipe) {
        super(EntryIngredients.ofIngredients(recipe.getIngredients()), EntryIngredients.ofIngredients(recipe.getOutputIngredients()));
        this.toolInput = EntryIngredients.ofIngredient(Ingredient.of(ModTags.MALLETS));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ModReiPlugin.FORGING;
    }

    @Override
    public List<EntryIngredient> getRequiredEntries() {
        List<EntryIngredient> requiredEntries = new ArrayList<>(super.getRequiredEntries());
        requiredEntries.add(getToolInput());

        return ImmutableList.copyOf(requiredEntries);
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        List<EntryIngredient> inputEntryList = new ArrayList<>(super.getInputEntries());
        inputEntryList.add(getToolInput());

        return ImmutableList.copyOf(inputEntryList);
    }

    public List<EntryIngredient> getIngredientEntries() {
        return super.getInputEntries();
    }

    public EntryIngredient getToolInput() {
        return toolInput;
    }

    public List<EntryIngredient> getOutput() {
        return super.getOutputEntries();
    }

}
