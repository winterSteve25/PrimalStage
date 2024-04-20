package com.nanokulon.primalstage.events;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.init.ModBlocks;
import com.nanokulon.primalstage.init.ModItems;
import com.nanokulon.primalstage.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = PrimalStage.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataEvents {

    @SubscribeEvent
    public static void onInitializeDataGenerator(GatherDataEvent evt) {
        System.out.println("HALLOOOOOO");

        DataGenerator generator = evt.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = evt.getLookupProvider();

        generator.addProvider(evt.includeServer(), ModLootTablesProvider.create(output));
        ModMineableTagProvider provider = new ModMineableTagProvider(output, lookupProvider, evt.getExistingFileHelper());
        generator.addProvider(evt.includeServer(), provider);
        generator.addProvider(evt.includeServer(), new ModItemTagProvider(output, lookupProvider, provider.contentsGetter()));
    }

    private static class ModLootTablesProvider extends BlockLootSubProvider {

        private static LootTableProvider create(PackOutput output) {
            return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(ModLootTablesProvider::new, LootContextParamSets.BLOCK)));
        }

        protected ModLootTablesProvider() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.REGISTER.getEntries().stream().map(RegistryObject::get)::iterator;
        }

        @Override
        public void generate() {
            this.dropSelf(ModBlocks.BUSH_BLOCK.get());
            this.dropOther(ModBlocks.TWIGS_BLOCK.get(), Items.STICK);
            this.dropOther(ModBlocks.SALT_BLOCK.get(), ModItems.SALT.get());
            this.dropOther(ModBlocks.PEBBLE_BLOCK.get(), ModItems.STONE_PEBBLE.get());
            this.dropSelf(ModBlocks.CHARCOAL_LOG.get());
            this.dropSelf(ModBlocks.KILN_BRICKS.get());
            this.dropSelf(ModBlocks.OAK_HEDGE.get());
            this.dropSelf(ModBlocks.BIRCH_HEDGE.get());
            this.dropSelf(ModBlocks.JUNGLE_HEDGE.get());
            this.dropSelf(ModBlocks.DARK_OAK_HEDGE.get());
            this.dropSelf(ModBlocks.SPRUCE_HEDGE.get());
            this.dropSelf(ModBlocks.ACACIA_HEDGE.get());
            this.dropSelf(ModBlocks.MANGROVE_HEDGE.get());
            this.dropSelf(ModBlocks.CRIMSON_HEDGE.get());
            this.dropSelf(ModBlocks.WARPED_HEDGE.get());
            this.dropSelf(ModBlocks.OAK_LATTICE.get());
            this.dropSelf(ModBlocks.BIRCH_LATTICE.get());
            this.dropSelf(ModBlocks.JUNGLE_LATTICE.get());
            this.dropSelf(ModBlocks.DARK_OAK_LATTICE.get());
            this.dropSelf(ModBlocks.SPRUCE_LATTICE.get());
            this.dropSelf(ModBlocks.ACACIA_LATTICE.get());
            this.dropSelf(ModBlocks.MANGROVE_LATTICE.get());
            this.dropSelf(ModBlocks.CRIMSON_LATTICE.get());
            this.dropSelf(ModBlocks.WARPED_LATTICE.get());
            this.dropSelf(ModBlocks.OAK_LOGS.get());
            this.dropSelf(ModBlocks.BIRCH_LOGS.get());
            this.dropSelf(ModBlocks.JUNGLE_LOGS.get());
            this.dropSelf(ModBlocks.DARK_OAK_LOGS.get());
            this.dropSelf(ModBlocks.SPRUCE_LOGS.get());
            this.dropSelf(ModBlocks.ACACIA_LOGS.get());
            this.dropSelf(ModBlocks.MANGROVE_LOGS.get());
            this.dropSelf(ModBlocks.CRIMSON_LOGS.get());
            this.dropSelf(ModBlocks.WARPED_LOGS.get());
            this.dropSelf(ModBlocks.PRIMITIVE_GRILL.get());
            this.dropSelf(ModBlocks.CUTTING_LOG.get());
            this.dropSelf(ModBlocks.STONE_ANVIL.get());
            this.dropSelf(ModBlocks.OAK_DRYING_RACK.get());
            this.dropSelf(ModBlocks.BIRCH_DRYING_RACK.get());
            this.dropSelf(ModBlocks.JUNGLE_DRYING_RACK.get());
            this.dropSelf(ModBlocks.DARK_OAK_DRYING_RACK.get());
            this.dropSelf(ModBlocks.SPRUCE_DRYING_RACK.get());
            this.dropSelf(ModBlocks.ACACIA_DRYING_RACK.get());
            this.dropSelf(ModBlocks.MANGROVE_DRYING_RACK.get());
            this.dropSelf(ModBlocks.CRIMSON_DRYING_RACK.get());
            this.dropSelf(ModBlocks.WARPED_DRYING_RACK.get());
            this.dropSelf(ModBlocks.KILN.get());
            this.dropSelf(ModBlocks.OAK_SHELF.get());
            this.dropSelf(ModBlocks.BIRCH_SHELF.get());
            this.dropSelf(ModBlocks.JUNGLE_SHELF.get());
            this.dropSelf(ModBlocks.DARK_OAK_SHELF.get());
            this.dropSelf(ModBlocks.SPRUCE_SHELF.get());
            this.dropSelf(ModBlocks.ACACIA_SHELF.get());
            this.dropSelf(ModBlocks.MANGROVE_SHELF.get());
            this.dropSelf(ModBlocks.CRIMSON_SHELF.get());
            this.dropSelf(ModBlocks.WARPED_SHELF.get());
            this.dropSelf(ModBlocks.STRAW_BLOCK.get());
        }

    }

    private static class ModMineableTagProvider extends BlockTagsProvider {
        public ModMineableTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, ExistingFileHelper existingFileHelper) {
            super(output, completableFuture, PrimalStage.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.tag(BlockTags.MINEABLE_WITH_AXE)
                    .add(ModBlocks.BUSH_BLOCK.get())
                    .add(ModBlocks.TWIGS_BLOCK.get())
                    .add(ModBlocks.CHARCOAL_LOG.get())
                    .add(ModBlocks.OAK_HEDGE.get())
                    .add(ModBlocks.BIRCH_HEDGE.get())
                    .add(ModBlocks.JUNGLE_HEDGE.get())
                    .add(ModBlocks.DARK_OAK_HEDGE.get())
                    .add(ModBlocks.SPRUCE_HEDGE.get())
                    .add(ModBlocks.ACACIA_HEDGE.get())
                    .add(ModBlocks.MANGROVE_HEDGE.get())
                    .add(ModBlocks.CRIMSON_HEDGE.get())
                    .add(ModBlocks.WARPED_HEDGE.get())
                    .add(ModBlocks.OAK_LATTICE.get())
                    .add(ModBlocks.BIRCH_LATTICE.get())
                    .add(ModBlocks.JUNGLE_LATTICE.get())
                    .add(ModBlocks.DARK_OAK_LATTICE.get())
                    .add(ModBlocks.SPRUCE_LATTICE.get())
                    .add(ModBlocks.ACACIA_LATTICE.get())
                    .add(ModBlocks.MANGROVE_LATTICE.get())
                    .add(ModBlocks.CRIMSON_LATTICE.get())
                    .add(ModBlocks.WARPED_LATTICE.get())
                    .add(ModBlocks.OAK_LOGS.get())
                    .add(ModBlocks.BIRCH_LOGS.get())
                    .add(ModBlocks.JUNGLE_LOGS.get())
                    .add(ModBlocks.DARK_OAK_LOGS.get())
                    .add(ModBlocks.SPRUCE_LOGS.get())
                    .add(ModBlocks.ACACIA_LOGS.get())
                    .add(ModBlocks.MANGROVE_LOGS.get())
                    .add(ModBlocks.CRIMSON_LOGS.get())
                    .add(ModBlocks.WARPED_LOGS.get())
                    .add(ModBlocks.CUTTING_LOG.get())
                    .add(ModBlocks.OAK_DRYING_RACK.get())
                    .add(ModBlocks.BIRCH_DRYING_RACK.get())
                    .add(ModBlocks.JUNGLE_DRYING_RACK.get())
                    .add(ModBlocks.DARK_OAK_DRYING_RACK.get())
                    .add(ModBlocks.SPRUCE_DRYING_RACK.get())
                    .add(ModBlocks.ACACIA_DRYING_RACK.get())
                    .add(ModBlocks.MANGROVE_DRYING_RACK.get())
                    .add(ModBlocks.CRIMSON_DRYING_RACK.get())
                    .add(ModBlocks.WARPED_DRYING_RACK.get())
                    .add(ModBlocks.OAK_SHELF.get())
                    .add(ModBlocks.BIRCH_SHELF.get())
                    .add(ModBlocks.JUNGLE_SHELF.get())
                    .add(ModBlocks.DARK_OAK_SHELF.get())
                    .add(ModBlocks.SPRUCE_SHELF.get())
                    .add(ModBlocks.ACACIA_SHELF.get())
                    .add(ModBlocks.MANGROVE_SHELF.get())
                    .add(ModBlocks.CRIMSON_SHELF.get())
                    .add(ModBlocks.WARPED_SHELF.get());

            tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ModBlocks.PEBBLE_BLOCK.get())
                    .add(ModBlocks.PRIMITIVE_GRILL.get())
                    .add(ModBlocks.KILN_BRICKS.get())
                    .add(ModBlocks.KILN.get())
                    .add(ModBlocks.STONE_ANVIL.get());

            tag(BlockTags.MINEABLE_WITH_SHOVEL)
                    .add(ModBlocks.SALT_BLOCK.get());
        }
    }

    private static class ModItemTagProvider extends ItemTagsProvider {
        public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> completableFuture2) {
            super(output, completableFuture, completableFuture2);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            tag(ModTags.MALLETS)
                    .add(ModItems.FLINT_MALLET.get());

            tag(ModTags.LOGS)
                    .add(Item.byBlock(ModBlocks.OAK_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.ACACIA_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.SPRUCE_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.JUNGLE_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.DARK_OAK_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.BIRCH_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.MANGROVE_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.CRIMSON_LOGS.get()))
                    .add(Item.byBlock(ModBlocks.WARPED_LOGS.get()));

            tag(ModTags.BARK)
                    .add(ModItems.OAK_BARK.get())
                    .add(ModItems.ACACIA_BARK.get())
                    .add(ModItems.SPRUCE_BARK.get())
                    .add(ModItems.JUNGLE_BARK.get())
                    .add(ModItems.DARK_OAK_BARK.get())
                    .add(ModItems.BIRCH_BARK.get())
                    .add(ModItems.MANGROVE_BARK.get());
        }
    }
}
