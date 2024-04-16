package com.nanokulon.primalstage.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class SandDust extends BaseItem{

    public SandDust(Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack Stack, @Nullable Level world, List<Component> TooltipComponents, TooltipFlag isAdvanced) {
        TooltipComponents.add(Component.translatable("item.primalstage.sand_dust.tooltip"));
    }
}
