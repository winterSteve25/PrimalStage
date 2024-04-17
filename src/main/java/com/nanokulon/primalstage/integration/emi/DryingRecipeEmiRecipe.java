package com.nanokulon.primalstage.integration.emi;

import com.nanokulon.primalstage.recipes.DryingRecipe;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DryingRecipeEmiRecipe implements EmiRecipe {
    private final ResourceLocation id;
    private final List<EmiIngredient> input;
    private final List<EmiStack> output;
    private final int cookingTime;

    public DryingRecipeEmiRecipe(DryingRecipe recipe) {
        this.id = recipe.getId();
        this.input = List.of(EmiIngredient.of(recipe.getIngredients().get(0)));
        this.output = List.of(EmiStack.of(recipe.getOutput()));
        this.cookingTime = recipe.getCookingTime();
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return ModEmiPlugin.DRYING_CATEGORY;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return input;
    }

    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }

    @Override
    public int getDisplayWidth() {
        return 118;
    }

    @Override
    public int getDisplayHeight() {
        return 58;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addSlot(input.get(0), 16, 8);
        widgets.addAnimatedTexture(EmiTexture.FULL_FLAME, 18, 28, 10000, false, true, true);
        widgets.addFillingArrow(54, 20, cookingTime * 50);
        widgets.addSlot(output.get(0), 90, 20);
    }
}
