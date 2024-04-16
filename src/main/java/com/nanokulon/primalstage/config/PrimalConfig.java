package com.nanokulon.primalstage.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PrimalConfig {
    public final ForgeConfigSpec.BooleanValue disableTreePunching;
    public final ForgeConfigSpec.BooleanValue woolScrap;
    public final ForgeConfigSpec.BooleanValue twigsAndPebbles;

    public PrimalConfig(ForgeConfigSpec.Builder builder) {
        disableTreePunching = builder
                .comment("Defines requirement tools for tree mining")
                .define("disable_tree_punching", true);

        woolScrap = builder
                .comment("Defines drop wool scrap instead wool")
                .define("wool_scrap", true);

        twigsAndPebbles = builder
                .comment("Defines twigs and pebbles spawning")
                .define("twigs_and_pebbles", true);
    }
}
