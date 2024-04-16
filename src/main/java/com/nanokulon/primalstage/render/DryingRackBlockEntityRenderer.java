package com.nanokulon.primalstage.render;

import com.nanokulon.primalstage.blocks.entity.DryingRackBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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
public class DryingRackBlockEntityRenderer implements BlockEntityRenderer<DryingRackBlockEntity> {

    private final ItemRenderer itemRenderer;

    public DryingRackBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(DryingRackBlockEntity dryingRackBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j) {
        Direction direction = Direction.NORTH;
        NonNullList<ItemStack> defaultedList = dryingRackBlockEntity.getItemsBeingDrying();
        int k = (int)dryingRackBlockEntity.getBlockPos().asLong();
        for (int l = 0; l < defaultedList.size(); ++l) {
            ItemStack itemStack = defaultedList.get(l);
            if (itemStack == ItemStack.EMPTY) continue;
            matrixStack.pushPose();
            if(itemStack.getItem() instanceof BlockItem
                    && !(itemStack.getItem() instanceof ItemNameBlockItem)
                    && !(itemStack.getItem().equals(Items.KELP))){
                matrixStack.translate(0.5f, 1f, 0.5f);
            } else matrixStack.translate(0.5f, 0.95f, 0.5f);
            Direction direction2 = Direction.from2DDataValue((l + direction.get2DDataValue()) % 4);
            float g = -direction2.toYRot();
            if(itemStack.getItem() instanceof BlockItem
                    && !(itemStack.getItem() instanceof ItemNameBlockItem)
                    && !(itemStack.getItem().equals(Items.KELP))) {
                matrixStack.mulPose(Axis.YP.rotationDegrees(g));
                matrixStack.translate(-0.2f, 0, -0.2f);
                matrixStack.mulPose(Axis.YP.rotationDegrees(-g));
            } else {
                matrixStack.mulPose(Axis.YP.rotationDegrees(g));
                matrixStack.mulPose(Axis.XP.rotationDegrees(90.0f));
                matrixStack.translate(-0.2f, -0.2f, 0.0f);
            }
            matrixStack.scale(0.375f, 0.375f, 0.375f);
            this.itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i, j, matrixStack,vertexConsumerProvider, dryingRackBlockEntity.getLevel(), k + l);
            matrixStack.popPose();
        }
    }
}


