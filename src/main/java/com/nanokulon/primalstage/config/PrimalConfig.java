package com.nanokulon.primalstage.config;

import com.nanokulon.primalstage.PrimalStage;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = PrimalStage.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PrimalConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue DISABLE_TREE_PUNCHING = BUILDER
            .comment("Should require tool for tree punching?")
            .define("disable_tree_punching", true);

    private static final ForgeConfigSpec.BooleanValue WOOL_SCRAP = BUILDER
            .comment("Should wool scrap drop instead of wool?")
            .define("wool_scrap", true);

    private static final ForgeConfigSpec.BooleanValue TWIGS_AND_PEBBLES = BUILDER
            .comment("Should twigs and pebbles spawn?")
            .define("twigs_and_pebbles", true);

    public static boolean disableTreePunching;
    public static boolean woolScrap;
    public static boolean twigsAndPebbles;

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent event) {
        disableTreePunching = DISABLE_TREE_PUNCHING.get();
        woolScrap = WOOL_SCRAP.get();
        twigsAndPebbles = TWIGS_AND_PEBBLES.get();
    }
}
