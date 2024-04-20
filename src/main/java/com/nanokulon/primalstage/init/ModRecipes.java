package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.recipes.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    private static final DeferredRegister<RecipeType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, PrimalStage.MOD_ID);
    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PrimalStage.MOD_ID);

    public static final RegistryObject<RecipeType<GrillRecipe>> GRILL = REGISTER.register("grill", GrillRecipe.GrillRecipeType::new);
    public static final RegistryObject<RecipeType<DryingRecipe>> DRYING = REGISTER.register("drying", DryingRecipe.DryingRecipeType::new);
    public static final RegistryObject<RecipeType<CuttingRecipe>> CUTTING = REGISTER.register("cutting", CuttingRecipe.CuttingRecipeType::new);
    public static final RegistryObject<RecipeType<ForgingRecipe>> FORGING = REGISTER.register("forging", ForgingRecipe.ForgingRecipeType::new);
    public static final RegistryObject<RecipeType<KilnRecipe>> KILN = REGISTER.register("kiln", KilnRecipe.KilnRecipeType::new);

    public static final RegistryObject<GrillRecipeSerializer> GRILL_RECIPE_SERIALIZER = SERIALIZER_REGISTER.register("grill", () -> GrillRecipeSerializer.INSTANCE);
    public static final RegistryObject<DryingRecipeSerializer> DRYING_RECIPE_SERIALIZER = SERIALIZER_REGISTER.register("drying", () -> DryingRecipeSerializer.INSTANCE);
    public static final RegistryObject<CuttingRecipeSerializer> CUTTING_RECIPE_SERIALIZER = SERIALIZER_REGISTER.register("cutting", () -> CuttingRecipeSerializer.INSTANCE);
    public static final RegistryObject<ForgingRecipeSerializer> FORGING_RECIPE_SERIALIZER = SERIALIZER_REGISTER.register("forging", () -> ForgingRecipeSerializer.INSTANCE);
    public static final RegistryObject<KilnRecipeSerializer> KILN_RECIPE_SERIALIZER = SERIALIZER_REGISTER.register("kiln", () -> KilnRecipeSerializer.INSTANCE);

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
        SERIALIZER_REGISTER.register(bus);
    }
}
