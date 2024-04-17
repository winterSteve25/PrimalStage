package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.recipes.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    private static final DeferredRegister<RecipeType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, PrimalStage.MOD_ID);

    public static final RegistryObject<RecipeType<GrillRecipe>> GRILL = REGISTER.register("grill", GrillRecipe.GrillRecipeType::new);
    public static final RegistryObject<RecipeType<DryingRecipe>> DRYING = REGISTER.register("drying", DryingRecipe.DryingRecipeType::new);
    public static final RegistryObject<RecipeType<CuttingRecipe>> CUTTING = REGISTER.register("cutting", CuttingRecipe.CuttingRecipeType::new);
    public static final RegistryObject<RecipeType<ForgingRecipe>> FORGING = REGISTER.register("forging", ForgingRecipe.ForgingRecipeType::new);
    public static final RegistryObject<RecipeType<KilnRecipe>> KILN = REGISTER.register("kiln", KilnRecipe.KilnRecipeType::new);

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
    }
}
