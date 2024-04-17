package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    private static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PrimalStage.MOD_ID);
    public static final RegistryObject<CreativeModeTab> TAB = REGISTER.register("primal_group", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.STONE_PEBBLE.get()))
            .title(Component.translatable("item_group." + PrimalStage.MOD_ID + ".primal_group"))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.BUSH_BLOCK.get());
                output.accept(ModBlocks.TWIGS_BLOCK.get());
                output.accept(ModBlocks.PEBBLE_BLOCK.get());
                output.accept(ModBlocks.OAK_HEDGE.get());
                output.accept(ModBlocks.BIRCH_HEDGE.get());
                output.accept(ModBlocks.JUNGLE_HEDGE.get());
                output.accept(ModBlocks.DARK_OAK_HEDGE.get());
                output.accept(ModBlocks.SPRUCE_HEDGE.get());
                output.accept(ModBlocks.ACACIA_HEDGE.get());
                output.accept(ModBlocks.MANGROVE_HEDGE.get());
                output.accept(ModBlocks.CRIMSON_HEDGE.get());
                output.accept(ModBlocks.WARPED_HEDGE.get());
                output.accept(ModBlocks.OAK_LATTICE.get());
                output.accept(ModBlocks.BIRCH_LATTICE.get());
                output.accept(ModBlocks.JUNGLE_LATTICE.get());
                output.accept(ModBlocks.DARK_OAK_LATTICE.get());
                output.accept(ModBlocks.SPRUCE_LATTICE.get());
                output.accept(ModBlocks.ACACIA_LATTICE.get());
                output.accept(ModBlocks.MANGROVE_LATTICE.get());
                output.accept(ModBlocks.CRIMSON_LATTICE.get());
                output.accept(ModBlocks.WARPED_LATTICE.get());
                output.accept(ModBlocks.OAK_LOGS.get());
                output.accept(ModBlocks.BIRCH_LOGS.get());
                output.accept(ModBlocks.JUNGLE_LOGS.get());
                output.accept(ModBlocks.DARK_OAK_LOGS.get());
                output.accept(ModBlocks.SPRUCE_LOGS.get());
                output.accept(ModBlocks.ACACIA_LOGS.get());
                output.accept(ModBlocks.MANGROVE_LOGS.get());
                output.accept(ModBlocks.CRIMSON_LOGS.get());
                output.accept(ModBlocks.WARPED_LOGS.get());
                output.accept(ModBlocks.OAK_DRYING_RACK.get());
                output.accept(ModBlocks.BIRCH_DRYING_RACK.get());
                output.accept(ModBlocks.JUNGLE_DRYING_RACK.get());
                output.accept(ModBlocks.DARK_OAK_DRYING_RACK.get());
                output.accept(ModBlocks.SPRUCE_DRYING_RACK.get());
                output.accept(ModBlocks.ACACIA_DRYING_RACK.get());
                output.accept(ModBlocks.MANGROVE_DRYING_RACK.get());
                output.accept(ModBlocks.CRIMSON_DRYING_RACK.get());
                output.accept(ModBlocks.WARPED_DRYING_RACK.get());
                output.accept(ModBlocks.OAK_SHELF.get());
                output.accept(ModBlocks.BIRCH_SHELF.get());
                output.accept(ModBlocks.JUNGLE_SHELF.get());
                output.accept(ModBlocks.DARK_OAK_SHELF.get());
                output.accept(ModBlocks.SPRUCE_SHELF.get());
                output.accept(ModBlocks.ACACIA_SHELF.get());
                output.accept(ModBlocks.MANGROVE_SHELF.get());
                output.accept(ModBlocks.CRIMSON_SHELF.get());
                output.accept(ModBlocks.WARPED_SHELF.get());
                output.accept(ModBlocks.CHARCOAL_LOG.get());
                output.accept(ModBlocks.KILN_BRICKS.get());
                output.accept(ModBlocks.SALT_BLOCK.get());
                output.accept(ModBlocks.STRAW_BLOCK.get());
                output.accept(ModBlocks.PRIMITIVE_GRILL.get());
                output.accept(ModBlocks.CUTTING_LOG.get());
                output.accept(ModBlocks.STONE_ANVIL.get());
                output.accept(ModBlocks.KILN.get());
                output.accept(ModItems.STONE_PEBBLE.get());
                output.accept(ModItems.PLANT_FIBER.get());
                output.accept(ModItems.PLANT_TWINE.get());
                output.accept(ModItems.SAND_DUST.get());
                output.accept(ModItems.PELT.get());
                output.accept(ModItems.SKIMMED_PELT.get());
                output.accept(ModItems.SALTED_PELT.get());
                output.accept(ModItems.DRIED_PELT.get());
                output.accept(ModItems.TANNED_PELT.get());
                output.accept(ModItems.SANDY_CLAY_COMPOUND.get());
                output.accept(ModItems.KILN_BRICK.get());
                output.accept(ModItems.OAK_BARK.get());
                output.accept(ModItems.BIRCH_BARK.get());
                output.accept(ModItems.JUNGLE_BARK.get());
                output.accept(ModItems.DARK_OAK_BARK.get());
                output.accept(ModItems.SPRUCE_BARK.get());
                output.accept(ModItems.ACACIA_BARK.get());
                output.accept(ModItems.MANGROVE_BARK.get());
                output.accept(ModItems.BLACK_WOOL_SCRAP.get());
                output.accept(ModItems.BLUE_WOOL_SCRAP.get());
                output.accept(ModItems.BROWN_WOOL_SCRAP.get());
                output.accept(ModItems.CYAN_WOOL_SCRAP.get());
                output.accept(ModItems.GRAY_WOOL_SCRAP.get());
                output.accept(ModItems.GREEN_WOOL_SCRAP.get());
                output.accept(ModItems.LIGHT_BLUE_WOOL_SCRAP.get());
                output.accept(ModItems.LIGHT_GRAY_WOOL_SCRAP.get());
                output.accept(ModItems.LIME_WOOL_SCRAP.get());
                output.accept(ModItems.MAGENTA_WOOL_SCRAP.get());
                output.accept(ModItems.ORANGE_WOOL_SCRAP.get());
                output.accept(ModItems.PINK_WOOL_SCRAP.get());
                output.accept(ModItems.PURPLE_WOOL_SCRAP.get());
                output.accept(ModItems.RED_WOOL_SCRAP.get());
                output.accept(ModItems.WHITE_WOOL_SCRAP.get());
                output.accept(ModItems.YELLOW_WOOL_SCRAP.get());
                output.accept(ModItems.SALT.get());
                output.accept(ModItems.STRAW.get());
                output.accept(ModItems.COPPER_PLATE.get());
                output.accept(ModItems.IRON_PLATE.get());
                output.accept(ModItems.DIAMOND_PLATE.get());
                output.accept(ModItems.BLUEBERRY.get());
                output.accept(ModItems.FIRE_STICKS.get());
                output.accept(ModItems.STONE_CLUB.get());
                output.accept(ModItems.FLINT_HATCHET.get());
                output.accept(ModItems.FLINT_PICKAXE.get());
                output.accept(ModItems.FLINT_SHOVEL.get());
                output.accept(ModItems.FLINT_MALLET.get());
                output.accept(ModItems.STONE_CLUB_HEAD.get());
            })
            .build());

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
    }
}
