package com.nanokulon.primalstage.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.nanokulon.primalstage.blocks.entity.CuttingLogBlockEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CuttingLogBlockEntityRenderer implements BlockEntityRenderer<CuttingLogBlockEntity> {

    private final ItemRenderer itemRenderer;

    public CuttingLogBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(CuttingLogBlockEntity cuttingLogBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j) {
        Direction direction = Direction.NORTH;
        NonNullList<ItemStack> defaultedList = cuttingLogBlockEntity.getItemsBeingCutting();
        int k = (int)cuttingLogBlockEntity.getBlockPos().asLong();
        ItemStack itemStack = defaultedList.get(0);
        if (itemStack == ItemStack.EMPTY) return;
        matrixStack.pushPose();
        if(defaultedList.get(0).getItem() instanceof BlockItem
                && !(defaultedList.get(0).getItem() instanceof ItemNameBlockItem)
                && !(defaultedList.get(0).getItem().equals(Items.KELP))){
            matrixStack.translate(0.5f, 0.44f, 0.5f);
        } else matrixStack.translate(0.5f, 0.2f, 0.5f);
        Direction direction2 = Direction.from2DDataValue((direction.get2DDataValue()) % 4);
        float g = -direction2.toYRot();
        if(defaultedList.get(0).getItem() instanceof BlockItem
                && !(defaultedList.get(0).getItem() instanceof ItemNameBlockItem)
                && !(defaultedList.get(0).getItem().equals(Items.KELP))) {
            matrixStack.mulPose(Axis.YP.rotationDegrees(g));
            matrixStack.mulPose(Axis.YP.rotationDegrees(-g));
        } else {
            matrixStack.mulPose(Axis.YP.rotationDegrees(g));
            matrixStack.mulPose(Axis.XP.rotationDegrees(90.0f));
        }
        matrixStack.scale(1f, 1f, 1f);
        this.itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i, j, matrixStack,vertexConsumerProvider, cuttingLogBlockEntity.getLevel(), k);
        matrixStack.popPose();
    }
}


