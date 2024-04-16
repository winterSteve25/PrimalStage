package com.nanokulon.primalstage.init;

import com.nanokulon.primalstage.config.PrimalConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {
    public static Pair<PrimalConfig, ForgeConfigSpec> CONFIG;

    public static void init() {
        CONFIG = new ForgeConfigSpec.Builder()
                .configure(PrimalConfig::new);
    }
}
