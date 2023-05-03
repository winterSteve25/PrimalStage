package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.blocks.*;
import com.nanokulon.primalstage.items.CharcoalLog;
import com.nanokulon.primalstage.items.PrimitiveGrill;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // Misc Blocks
    public static final Block BUSH_BLOCK = new BushBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.3f).sounds(BlockSoundGroup.CAVE_VINES).nonOpaque());
    public static final Block TWIGS_BLOCK = new TwigsBlock(FabricBlockSettings.of(Material.WOOD).strength(0.1f).sounds(BlockSoundGroup.WOOD));
    public static final Block PEBBLE_BLOCK = new PebbleBlock(FabricBlockSettings.of(Material.STONE).strength(0.1f).sounds(BlockSoundGroup.STONE));
    public static final Block OAK_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block BIRCH_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block JUNGLE_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_OAK_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block SPRUCE_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block ACACIA_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block MANGROVE_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block CRIMSON_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block WARPED_HEDGE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block OAK_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block BIRCH_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block JUNGLE_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_OAK_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block SPRUCE_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block ACACIA_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block MANGROVE_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block CRIMSON_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block WARPED_LATTICE = new HedgeBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block OAK_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block BIRCH_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block JUNGLE_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_OAK_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block SPRUCE_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block ACACIA_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block MANGROVE_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block CRIMSON_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block WARPED_LOGS = new Logs(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block CHARCOAL_LOG = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block KILN_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(2.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block SALT_BLOCK = new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.6f).sounds(BlockSoundGroup.GRAVEL));
    public static final Block STRAW_BLOCK = new HayBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.5f).sounds(BlockSoundGroup.GRASS));
    // Machines
    public static final Block PRIMITIVE_GRILL = new PrimitiveGrillBlock(2, FabricBlockSettings.of(Material.STONE).strength(2.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block CUTTING_LOG = new CuttingLogBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block STONE_ANVIL = new StoneAnvilBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block OAK_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block BIRCH_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block JUNGLE_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_OAK_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block SPRUCE_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block ACACIA_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block MANGROVE_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block CRIMSON_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block WARPED_DRYING_RACK = new DryingRackBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block OAK_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block BIRCH_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block JUNGLE_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block DARK_OAK_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block SPRUCE_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block ACACIA_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block MANGROVE_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block CRIMSON_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block WARPED_SHELF = new ShelfBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block KILN = new KilnBlock(FabricBlockSettings.of(Material.STONE).strength(2.0f).sounds(BlockSoundGroup.STONE).requiresTool());

    public static void init(){
        // Misc Blocks
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "bush_block"), BUSH_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "twigs_block"), TWIGS_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "pebble_block"), PEBBLE_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "oak_hedge"), OAK_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "birch_hedge"), BIRCH_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "jungle_hedge"), JUNGLE_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "dark_oak_hedge"), DARK_OAK_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "spruce_hedge"), SPRUCE_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "acacia_hedge"), ACACIA_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "mangrove_hedge"), MANGROVE_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "crimson_hedge"), CRIMSON_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "warped_hedge"), WARPED_HEDGE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "oak_lattice"), OAK_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "birch_lattice"), BIRCH_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "jungle_lattice"), JUNGLE_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "dark_oak_lattice"), DARK_OAK_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "spruce_lattice"), SPRUCE_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "acacia_lattice"), ACACIA_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "mangrove_lattice"), MANGROVE_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "crimson_lattice"), CRIMSON_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "warped_lattice"), WARPED_LATTICE);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "oak_logs"), OAK_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "birch_logs"), BIRCH_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "jungle_logs"), JUNGLE_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "dark_oak_logs"), DARK_OAK_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "spruce_logs"), SPRUCE_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "acacia_logs"), ACACIA_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "mangrove_logs"), MANGROVE_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "crimson_logs"), CRIMSON_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "warped_logs"), WARPED_LOGS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "charcoal_log"), CHARCOAL_LOG);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "kiln_bricks"), KILN_BRICKS);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "salt_block"), SALT_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "straw_block"), STRAW_BLOCK);
        // Machines
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "primitive_grill"), PRIMITIVE_GRILL);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "cutting_log"), CUTTING_LOG);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "stone_anvil"), STONE_ANVIL);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "oak_drying_rack"), OAK_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "birch_drying_rack"), BIRCH_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "jungle_drying_rack"), JUNGLE_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "dark_oak_drying_rack"), DARK_OAK_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "spruce_drying_rack"), SPRUCE_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "acacia_drying_rack"), ACACIA_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "mangrove_drying_rack"), MANGROVE_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "crimson_drying_rack"), CRIMSON_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "warped_drying_rack"), WARPED_DRYING_RACK);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "oak_shelf"), OAK_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "birch_shelf"), BIRCH_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "jungle_shelf"), JUNGLE_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "dark_oak_shelf"), DARK_OAK_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "spruce_shelf"), SPRUCE_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "acacia_shelf"), ACACIA_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "mangrove_shelf"), MANGROVE_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "crimson_shelf"), CRIMSON_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "warped_shelf"), WARPED_SHELF);
        Registry.register(Registries.BLOCK, new Identifier(PrimalStage.MOD_ID, "kiln"), KILN);
        // Misc BlockItems
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "bush_block"), new BlockItem(BUSH_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "twigs_block"), new BlockItem(TWIGS_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "pebble_block"), new BlockItem(PEBBLE_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "oak_hedge"), new BlockItem(OAK_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "birch_hedge"), new BlockItem(BIRCH_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "jungle_hedge"), new BlockItem(JUNGLE_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "dark_oak_hedge"), new BlockItem(DARK_OAK_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "spruce_hedge"), new BlockItem(SPRUCE_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "acacia_hedge"), new BlockItem(ACACIA_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "mangrove_hedge"), new BlockItem(MANGROVE_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "crimson_hedge"), new BlockItem(CRIMSON_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "warped_hedge"), new BlockItem(WARPED_HEDGE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "oak_lattice"), new BlockItem(OAK_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "birch_lattice"), new BlockItem(BIRCH_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "jungle_lattice"), new BlockItem(JUNGLE_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "dark_oak_lattice"), new BlockItem(DARK_OAK_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "spruce_lattice"), new BlockItem(SPRUCE_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "acacia_lattice"), new BlockItem(ACACIA_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "mangrove_lattice"), new BlockItem(MANGROVE_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "crimson_lattice"), new BlockItem(CRIMSON_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "warped_lattice"), new BlockItem(WARPED_LATTICE, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "oak_logs"), new BlockItem(OAK_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "birch_logs"), new BlockItem(BIRCH_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "jungle_logs"), new BlockItem(JUNGLE_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "dark_oak_logs"), new BlockItem(DARK_OAK_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "spruce_logs"), new BlockItem(SPRUCE_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "acacia_logs"), new BlockItem(ACACIA_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "mangrove_logs"), new BlockItem(MANGROVE_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "crimson_logs"), new BlockItem(CRIMSON_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "warped_logs"), new BlockItem(WARPED_LOGS, new FabricItemSettings().maxCount(16)));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "charcoal_log"), new CharcoalLog(CHARCOAL_LOG, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "kiln_bricks"), new BlockItem(KILN_BRICKS, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "salt_block"), new BlockItem(SALT_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "straw_block"), new BlockItem(STRAW_BLOCK, new FabricItemSettings()));
        // Machines BlockItems
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "primitive_grill"), new PrimitiveGrill(PRIMITIVE_GRILL, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "cutting_log"), new BlockItem(CUTTING_LOG, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "stone_anvil"), new BlockItem(STONE_ANVIL, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "oak_drying_rack"), new BlockItem(OAK_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "birch_drying_rack"), new BlockItem(BIRCH_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "jungle_drying_rack"), new BlockItem(JUNGLE_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "dark_oak_drying_rack"), new BlockItem(DARK_OAK_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "spruce_drying_rack"), new BlockItem(SPRUCE_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "acacia_drying_rack"), new BlockItem(ACACIA_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "mangrove_drying_rack"), new BlockItem(MANGROVE_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "crimson_drying_rack"), new BlockItem(CRIMSON_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "warped_drying_rack"), new BlockItem(WARPED_DRYING_RACK, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "oak_shelf"), new BlockItem(OAK_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "birch_shelf"), new BlockItem(BIRCH_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "jungle_shelf"), new BlockItem(JUNGLE_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "dark_oak_shelf"), new BlockItem(DARK_OAK_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "spruce_shelf"), new BlockItem(SPRUCE_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "acacia_shelf"), new BlockItem(ACACIA_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "mangrove_shelf"), new BlockItem(MANGROVE_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "crimson_shelf"), new BlockItem(CRIMSON_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "warped_shelf"), new BlockItem(WARPED_SHELF, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(PrimalStage.MOD_ID, "kiln"), new BlockItem(KILN, new FabricItemSettings()));
    }
}
