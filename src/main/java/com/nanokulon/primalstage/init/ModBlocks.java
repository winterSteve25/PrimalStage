package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.blocks.*;
import com.nanokulon.primalstage.items.CharcoalLog;
import com.nanokulon.primalstage.items.PrimitiveGrill;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, PrimalStage.MOD_ID);
    public static final DeferredRegister<Item> BLOCK_ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PrimalStage.MOD_ID);

    // Misc Blocks
    public static final RegistryObject<Block> BUSH_BLOCK = REGISTER.register("bush_block", () -> new BushBlock(BlockBehaviour.Properties.of().strength(0.3f).sound(SoundType.CAVE_VINES).noOcclusion()));
    public static final RegistryObject<Block> TWIGS_BLOCK = REGISTER.register("twigs_block", () -> new TwigsBlock(BlockBehaviour.Properties.of().strength(0.1f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PEBBLE_BLOCK = REGISTER.register("pebble_block", () -> new PebbleBlock(BlockBehaviour.Properties.of().strength(0.1f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> OAK_HEDGE = REGISTER.register("oak_hedge", () -> new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_HEDGE = REGISTER.register("birch_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_HEDGE = REGISTER.register("jungle_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)) );
    public static final RegistryObject<Block> DARK_OAK_HEDGE = REGISTER.register("dark_oak_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)) );
    public static final RegistryObject<Block> SPRUCE_HEDGE = REGISTER.register("spruce_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_HEDGE = REGISTER.register("acacia_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_HEDGE = REGISTER.register("mangrove_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_HEDGE = REGISTER.register("crimson_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_HEDGE = REGISTER.register("warped_hedge", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OAK_LATTICE = REGISTER.register("oak_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_LATTICE = REGISTER.register("birch_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_LATTICE = REGISTER.register("jungle_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_LATTICE = REGISTER.register("dark_oak_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_LATTICE = REGISTER.register("spruce_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_LATTICE = REGISTER.register("acacia_lattice", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)) );
    public static final RegistryObject<Block> MANGROVE_LATTICE = REGISTER.register("mangrove_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_LATTICE = REGISTER.register("crimson_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_LATTICE = REGISTER.register("warped_lattice", () ->new HedgeBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OAK_LOGS = REGISTER.register("oak_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_LOGS = REGISTER.register("birch_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_LOGS = REGISTER.register("jungle_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_LOGS = REGISTER.register("dark_oak_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_LOGS = REGISTER.register("spruce_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_LOGS = REGISTER.register("acacia_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_LOGS = REGISTER.register("mangrove_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_LOGS = REGISTER.register("crimson_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_LOGS = REGISTER.register("warped_logs", () ->new Logs(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHARCOAL_LOG = REGISTER.register("charcoal_log", () ->new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> KILN_BRICKS = REGISTER.register("kiln_bricks", () ->new Block(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SALT_BLOCK = REGISTER.register("salt_block", () ->new Block(BlockBehaviour.Properties.of().strength(0.6f).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> STRAW_BLOCK = REGISTER.register("straw_block", () ->new HayBlock(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.GRASS)));

    // Machines
    public static final RegistryObject<Block> PRIMITIVE_GRILL = REGISTER.register("primitive_grill", () ->new PrimitiveGrillBlock(2, BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUTTING_LOG = REGISTER.register("cutting_log", () ->new CuttingLogBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STONE_ANVIL = REGISTER.register("stone_anvil", () ->new StoneAnvilBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OAK_DRYING_RACK = REGISTER.register("oak_drying_rack", () ->new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_DRYING_RACK = REGISTER.register("birch_drying_rack", () ->new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_DRYING_RACK =  REGISTER.register("jungle_drying_rack", () ->new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_DRYING_RACK = REGISTER.register("dark_oak_drying_rack", () -> new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_DRYING_RACK = REGISTER.register("spruce_drying_rack", () -> new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_DRYING_RACK = REGISTER.register("acacia_drying_rack", () -> new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_DRYING_RACK = REGISTER.register("mangrove_drying_rack", () -> new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_DRYING_RACK = REGISTER.register("crimson_drying_rack", () -> new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_DRYING_RACK = REGISTER.register("warped_drying_rack", () -> new DryingRackBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OAK_SHELF = REGISTER.register("oak_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_SHELF = REGISTER.register("birch_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_SHELF = REGISTER.register("jungle_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_SHELF = REGISTER.register("dark_oak_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_SHELF = REGISTER.register("spruce_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_SHELF = REGISTER.register("acacia_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_SHELF = REGISTER.register("mangrove_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_SHELF = REGISTER.register("crimson_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_SHELF = REGISTER.register("warped_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> KILN = REGISTER.register("kiln", () -> new KilnBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final RegistryObject<BlockItem> BUSH_BLOCK_BLOCK_ITEM = registerBlockItem(BUSH_BLOCK);
    public static final RegistryObject<BlockItem> TWIGS_BLOCK_BLOCK_ITEM = registerBlockItem(TWIGS_BLOCK);
    public static final RegistryObject<BlockItem> PEBBLE_BLOCK_BLOCK_ITEM = registerBlockItem(PEBBLE_BLOCK);
    public static final RegistryObject<BlockItem> OAK_HEDGE_BLOCK_ITEM = registerBlockItem(OAK_HEDGE);
    public static final RegistryObject<BlockItem> BIRCH_HEDGE_BLOCK_ITEM = registerBlockItem(BIRCH_HEDGE);
    public static final RegistryObject<BlockItem> JUNGLE_HEDGE_BLOCK_ITEM = registerBlockItem(JUNGLE_HEDGE);
    public static final RegistryObject<BlockItem> DARK_OAK_HEDGE_BLOCK_ITEM = registerBlockItem(DARK_OAK_HEDGE);
    public static final RegistryObject<BlockItem> SPRUCE_HEDGE_BLOCK_ITEM = registerBlockItem(SPRUCE_HEDGE);
    public static final RegistryObject<BlockItem> ACACIA_HEDGE_BLOCK_ITEM = registerBlockItem(ACACIA_HEDGE);
    public static final RegistryObject<BlockItem> MANGROVE_HEDGE_BLOCK_ITEM = registerBlockItem(MANGROVE_HEDGE);
    public static final RegistryObject<BlockItem> CRIMSON_HEDGE_BLOCK_ITEM = registerBlockItem(CRIMSON_HEDGE);
    public static final RegistryObject<BlockItem> WARPED_HEDGE_BLOCK_ITEM = registerBlockItem(WARPED_HEDGE);
    public static final RegistryObject<BlockItem> OAK_LATTICE_BLOCK_ITEM = registerBlockItem(OAK_LATTICE);
    public static final RegistryObject<BlockItem> BIRCH_LATTICE_BLOCK_ITEM = registerBlockItem(BIRCH_LATTICE);
    public static final RegistryObject<BlockItem> JUNGLE_LATTICE_BLOCK_ITEM = registerBlockItem(JUNGLE_LATTICE);
    public static final RegistryObject<BlockItem> DARK_OAK_LATTICE_BLOCK_ITEM = registerBlockItem(DARK_OAK_LATTICE);
    public static final RegistryObject<BlockItem> SPRUCE_LATTICE_BLOCK_ITEM = registerBlockItem(SPRUCE_LATTICE);
    public static final RegistryObject<BlockItem> ACACIA_LATTICE_BLOCK_ITEM = registerBlockItem(ACACIA_LATTICE);
    public static final RegistryObject<BlockItem> MANGROVE_LATTICE_BLOCK_ITEM = registerBlockItem(MANGROVE_LATTICE);
    public static final RegistryObject<BlockItem> CRIMSON_LATTICE_BLOCK_ITEM  = registerBlockItem(CRIMSON_LATTICE);
    public static final RegistryObject<BlockItem> WARPED_LATTICE_BLOCK_ITEM = registerBlockItem(WARPED_LATTICE);
    public static final RegistryObject<BlockItem> OAK_LOGS_BLOCK_ITEM = registerBlockItem(OAK_LOGS);
    public static final RegistryObject<BlockItem> BIRCH_LOGS_BLOCK_ITEM = registerBlockItem(BIRCH_LOGS);
    public static final RegistryObject<BlockItem> JUNGLE_LOGS_BLOCK_ITEM = registerBlockItem(JUNGLE_LOGS);
    public static final RegistryObject<BlockItem> DARK_OAK_LOGS_BLOCK_ITEM = registerBlockItem(DARK_OAK_LOGS);
    public static final RegistryObject<BlockItem> SPRUCE_LOGS_BLOCK_ITEM = registerBlockItem(SPRUCE_LOGS);
    public static final RegistryObject<BlockItem> ACACIA_LOGS_BLOCK_ITEM = registerBlockItem(ACACIA_LOGS);
    public static final RegistryObject<BlockItem> MANGROVE_LOGS_BLOCK_ITEM = registerBlockItem(MANGROVE_LOGS);
    public static final RegistryObject<BlockItem> CRIMSON_LOGS_BLOCK_ITEM = registerBlockItem(CRIMSON_LOGS);
    public static final RegistryObject<BlockItem> WARPED_LOGS_BLOCK_ITEM = registerBlockItem(WARPED_LOGS);
    public static final RegistryObject<BlockItem> CHARCOAL_LOG_BLOCK_ITEM = BLOCK_ITEM_REGISTER.register("charcoal_log", () -> new CharcoalLog(CHARCOAL_LOG.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> KILN_BRICKS_BLOCK_ITEM = registerBlockItem(KILN_BRICKS);
    public static final RegistryObject<BlockItem> SALT_BLOCK_BLOCK_ITEM = registerBlockItem(SALT_BLOCK);
    public static final RegistryObject<BlockItem> STRAW_BLOCK_BLOCK_ITEM = registerBlockItem(STRAW_BLOCK);

    // Machines
    public static final RegistryObject<BlockItem> PRIMITIVE_GRILL_BLOCK_ITEM = BLOCK_ITEM_REGISTER.register("primitive_grill", () -> new PrimitiveGrill(PRIMITIVE_GRILL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CUTTING_LOG_BLOCK_ITEM = registerBlockItem(CUTTING_LOG);
    public static final RegistryObject<BlockItem> STONE_ANVIL_BLOCK_ITEM = registerBlockItem(STONE_ANVIL);
    public static final RegistryObject<BlockItem> OAK_DRYING_RACK_BLOCK_ITEM = registerBlockItem(OAK_DRYING_RACK);
    public static final RegistryObject<BlockItem> BIRCH_DRYING_RACK_BLOCK_ITEM = registerBlockItem(BIRCH_DRYING_RACK);
    public static final RegistryObject<BlockItem> JUNGLE_DRYING_RACK_BLOCK_ITEM = registerBlockItem(JUNGLE_DRYING_RACK);
    public static final RegistryObject<BlockItem> DARK_OAK_DRYING_RACK_BLOCK_ITEM = registerBlockItem(DARK_OAK_DRYING_RACK);
    public static final RegistryObject<BlockItem> SPRUCE_DRYING_RACK_BLOCK_ITEM = registerBlockItem(SPRUCE_DRYING_RACK);
    public static final RegistryObject<BlockItem> ACACIA_DRYING_RACK_BLOCK_ITEM = registerBlockItem(ACACIA_DRYING_RACK);
    public static final RegistryObject<BlockItem> MANGROVE_DRYING_RACK_BLOCK_ITEM = registerBlockItem(MANGROVE_DRYING_RACK);
    public static final RegistryObject<BlockItem> CRIMSON_DRYING_RACK_BLOCK_ITEM = registerBlockItem(CRIMSON_DRYING_RACK);
    public static final RegistryObject<BlockItem> WARPED_DRYING_RACK_BLOCK_ITEM = registerBlockItem(WARPED_DRYING_RACK);
    public static final RegistryObject<BlockItem> OAK_SHELF_BLOCK_ITEM = registerBlockItem(OAK_SHELF);
    public static final RegistryObject<BlockItem> BIRCH_SHELF_BLOCK_ITEM = registerBlockItem(BIRCH_SHELF);
    public static final RegistryObject<BlockItem> JUNGLE_SHELF_BLOCK_ITEM = registerBlockItem(JUNGLE_SHELF);
    public static final RegistryObject<BlockItem> DARK_OAK_SHELF_BLOCK_ITEM = registerBlockItem(DARK_OAK_SHELF);
    public static final RegistryObject<BlockItem> SPRUCE_SHELF_BLOCK_ITEM = registerBlockItem(SPRUCE_SHELF);
    public static final RegistryObject<BlockItem> ACACIA_SHELF_BLOCK_ITEM = registerBlockItem(ACACIA_SHELF);
    public static final RegistryObject<BlockItem> MANGROVE_SHELF_BLOCK_ITEM = registerBlockItem(MANGROVE_SHELF);
    public static final RegistryObject<BlockItem> CRIMSON_SHELF_BLOCK_ITEM = registerBlockItem(CRIMSON_SHELF);
    public static final RegistryObject<BlockItem> WARPED_SHELF_BLOCK_ITEM = registerBlockItem(WARPED_SHELF);
    public static final RegistryObject<BlockItem> KILN_BLOCK_ITEM = registerBlockItem(KILN);

    private static RegistryObject<BlockItem> registerBlockItem(RegistryObject<Block> source) {
        return BLOCK_ITEM_REGISTER.register(source.getId().getPath(), () -> new BlockItem(source.get(), new Item.Properties()));
    }

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
        BLOCK_ITEM_REGISTER.register(bus);
    }
}
