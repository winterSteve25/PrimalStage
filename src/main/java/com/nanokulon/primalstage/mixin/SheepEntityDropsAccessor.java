package com.nanokulon.primalstage.mixin;

import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(Sheep.class)
public interface SheepEntityDropsAccessor {
    @Mutable
    @Accessor("ITEM_BY_DYE")
    static void setDrops(Map<DyeColor, ItemLike> map){
        throw new AssertionError();
    }
}
