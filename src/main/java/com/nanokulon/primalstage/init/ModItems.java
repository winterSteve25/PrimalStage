package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.items.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PrimalStage.MOD_ID);

    public static final RegistryObject<? extends Item> STONE_PEBBLE = REGISTER.register("stone_pebble", () -> new PebbleItem(new Item.Properties()));
    public static final RegistryObject<Item> PLANT_FIBER = REGISTER.register("plant_fiber", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> PLANT_TWINE = REGISTER.register("plant_twine", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> SAND_DUST = REGISTER.register("sand_dust", () -> new SandDust(new Item.Properties()));
    public static final RegistryObject<Item> PELT = REGISTER.register("pelt", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> SKIMMED_PELT = REGISTER.register("skimmed_pelt", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> SALTED_PELT = REGISTER.register("salted_pelt", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> DRIED_PELT = REGISTER.register("dried_pelt", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> TANNED_PELT = REGISTER.register("tanned_pelt", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> SANDY_CLAY_COMPOUND = REGISTER.register("sandy_clay_compound", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> KILN_BRICK = REGISTER.register("kiln_brick", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> OAK_BARK = REGISTER.register("oak_bark", () -> new BarkItem(new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_BARK = REGISTER.register("birch_bark", () -> new BarkItem(new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_BARK = REGISTER.register("jungle_bark", () -> new BarkItem(new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_BARK = REGISTER.register("dark_oak_bark", () -> new BarkItem(new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_BARK = REGISTER.register("spruce_bark", () -> new BarkItem(new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_BARK = REGISTER.register("acacia_bark", () -> new BarkItem(new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_BARK = REGISTER.register("mangrove_bark", () -> new BarkItem(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_WOOL_SCRAP = REGISTER.register("black_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_WOOL_SCRAP = REGISTER.register("blue_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> BROWN_WOOL_SCRAP = REGISTER.register("brown_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> CYAN_WOOL_SCRAP = REGISTER.register("cyan_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> GRAY_WOOL_SCRAP = REGISTER.register("gray_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_WOOL_SCRAP = REGISTER.register("green_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_BLUE_WOOL_SCRAP = REGISTER.register("light_blue_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> LIGHT_GRAY_WOOL_SCRAP = REGISTER.register("light_gray_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> LIME_WOOL_SCRAP = REGISTER.register("lime_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> MAGENTA_WOOL_SCRAP = REGISTER.register("magenta_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> ORANGE_WOOL_SCRAP = REGISTER.register("orange_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> PINK_WOOL_SCRAP = REGISTER.register("pink_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> PURPLE_WOOL_SCRAP = REGISTER.register("purple_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> RED_WOOL_SCRAP = REGISTER.register("red_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> WHITE_WOOL_SCRAP = REGISTER.register("white_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_WOOL_SCRAP = REGISTER.register("yellow_wool_scrap", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> SALT = REGISTER.register("salt", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> STRAW = REGISTER.register("straw", () -> new BaseItem(new Item.Properties()));

    // Plates
    public static final RegistryObject<Item> COPPER_PLATE = REGISTER.register("copper_plate", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> IRON_PLATE = REGISTER.register("iron_plate", () -> new BaseItem(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_PLATE = REGISTER.register("diamond_plate", () -> new BaseItem(new Item.Properties()));

    // Food
    public static final RegistryObject<Item> BLUEBERRY = REGISTER.register("blueberry", () -> new BaseItem(new Item.Properties().food(ModFoodComponents.BLUEBERRY)));

    // Tools
    public static final RegistryObject<Item> FIRE_STICKS = REGISTER.register("fire_sticks", () -> new FlintAndSteelItem(new Item.Properties().durability(1)));
    public static final RegistryObject<Item> STONE_CLUB = REGISTER.register("stone_club", () -> new AxeItem(ModToolMaterials.PRIMITIVE, 5.0f, -3.2f, new Item.Properties()));
    public static final RegistryObject<Item> FLINT_HATCHET = REGISTER.register("flint_hatchet", () -> new AxeItem(ModToolMaterials.FLINT, 7.0f, -3.2f, new Item.Properties()));
    public static final RegistryObject<Item> FLINT_PICKAXE = REGISTER.register("flint_pickaxe", () -> new PickaxeItem(ModToolMaterials.FLINT, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> FLINT_SHOVEL = REGISTER.register("flint_shovel", () -> new ShovelItem(ModToolMaterials.FLINT, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> FLINT_MALLET = REGISTER.register("flint_mallet", () -> new MalletItem(ModToolMaterials.FLINT, new Item.Properties()));

    // Tool Parts
    public static final RegistryObject<Item> STONE_CLUB_HEAD = REGISTER.register("stone_club_head", () -> new PartItem(new Item.Properties()));

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
    }
}
