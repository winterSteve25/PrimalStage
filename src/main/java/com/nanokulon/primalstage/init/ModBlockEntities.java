package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.blocks.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    private static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PrimalStage.MOD_ID);

    public static final RegistryObject<BlockEntityType<PrimitiveGrillBlockEntity>> PRIMITIVE_GRILL_BLOCK_ENTITY = REGISTER
            .register("primitive_grill_block_entity", () -> BlockEntityType.Builder.of(PrimitiveGrillBlockEntity::new, ModBlocks.PRIMITIVE_GRILL.get()).build(null));

    public static final RegistryObject<BlockEntityType<DryingRackBlockEntity>> DRYING_RACK_BLOCK_ENTITY = REGISTER
            .register("drying_rack_block_entity", () -> BlockEntityType.Builder.of(DryingRackBlockEntity::new,
                    ModBlocks.DARK_OAK_DRYING_RACK.get(), ModBlocks.ACACIA_DRYING_RACK.get(), ModBlocks.BIRCH_DRYING_RACK.get(),
                    ModBlocks.OAK_DRYING_RACK.get(), ModBlocks.JUNGLE_DRYING_RACK.get(), ModBlocks.CRIMSON_DRYING_RACK.get(),
                    ModBlocks.MANGROVE_DRYING_RACK.get(), ModBlocks.SPRUCE_DRYING_RACK.get(), ModBlocks.WARPED_DRYING_RACK.get()).build(null));

    public static final RegistryObject<BlockEntityType<CuttingLogBlockEntity>> CUTTING_LOG_BLOCK_ENTITY = REGISTER
            .register("cutting_log_block_entity", () -> BlockEntityType.Builder.of(CuttingLogBlockEntity::new, ModBlocks.CUTTING_LOG.get()).build(null));

    public static final RegistryObject<BlockEntityType<StoneAnvilBlockEntity>> STONE_ANVIL_BLOCK_ENTITY = REGISTER
            .register("stone_anvil_block_entity", ()-> BlockEntityType.Builder.of(StoneAnvilBlockEntity::new, ModBlocks.STONE_ANVIL.get()).build(null));

    public static final RegistryObject<BlockEntityType<ShelfBlockEntity>> SHELF_BLOCK_ENTITY = REGISTER
            .register("shelf_block_entity", () -> BlockEntityType.Builder.of(ShelfBlockEntity::new, ModBlocks.OAK_SHELF.get(), ModBlocks.ACACIA_SHELF.get(), ModBlocks.DARK_OAK_SHELF.get(),
                    ModBlocks.JUNGLE_SHELF.get(), ModBlocks.BIRCH_SHELF.get(), ModBlocks.SPRUCE_SHELF.get(),
                    ModBlocks.MANGROVE_SHELF.get(), ModBlocks.WARPED_SHELF.get(), ModBlocks.CRIMSON_SHELF.get()).build(null));

    public static final RegistryObject<BlockEntityType<KilnBlockEntity>> KILN_BLOCK_ENTITY = REGISTER
            .register("kiln_block_entity", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ModBlocks.KILN.get()).build(null));

    public static void init(IEventBus bus) {
        REGISTER.register(bus);
    }
}
