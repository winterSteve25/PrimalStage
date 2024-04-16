package com.nanokulon.primalstage.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Properties;

public class PrimitiveGrill extends BlockItem {

    public PrimitiveGrill(Block block, Properties settings) {
        super(block, settings);
    }

    @Override
    public void appendHoverText(ItemStack Stack, @Nullable Level world, List<Component> TooltipComponents, TooltipFlag tooltipContext) {
        TooltipComponents.add(Component.translatable("item.primalstage.primitive_grill.tooltip"));
    }
}
