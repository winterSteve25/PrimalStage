package com.nanokulon.primalstage.integration.rei.grill;

import com.nanokulon.primalstage.PrimalStage;
import com.nanokulon.primalstage.init.ModBlocks;
import com.nanokulon.primalstage.integration.rei.ModReiPlugin;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@OnlyIn(Dist.CLIENT)
public class GrillRecipeCategory implements DisplayCategory<GrillRecipeDisplay> {

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.PRIMITIVE_GRILL.get());
    }

    @Override
    public Component getTitle() {
        return Component.translatable("primalstage.rei.grill");
    }

    @Override
    public CategoryIdentifier<? extends GrillRecipeDisplay> getCategoryIdentifier() {
        return ModReiPlugin.GRILL;
    }

    @Override
    public List<Widget> setupDisplay(GrillRecipeDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.y + 10);
        final double cookingTime = display.getCookTime();
        DecimalFormat df = new DecimalFormat("###.##");
        List<Widget> widgets = new ArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 9)));
        widgets.add(Widgets.createLabel(new Point(bounds.x + bounds.width - 5, bounds.y + 5),
                Component.translatable("category.rei.campfire.time", df.format(cookingTime / 20d))).noShadow().rightAligned().color(0xFF404040, 0xFFBBBBBB));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 24, startPoint.y + 8)).animationDurationTicks(cookingTime));
        widgets.add(Widgets.createBurningFire(new Point(startPoint.x + 1, startPoint.y + 20)).animationDurationMS(10000));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 1, startPoint.y + 1)).entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 9)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 49;
    }
}
