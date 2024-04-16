package com.nanokulon.primalstage.render;

import com.nanokulon.primalstage.blocks.ShelfBlock;
import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nanokulon.primalstage.blocks.entity.ShelfBlockEntity;
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
public class ShelfBlockEntityRenderer implements BlockEntityRenderer<ShelfBlockEntity> {

    private final ItemRenderer itemRenderer;

    public ShelfBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(ShelfBlockEntity shelfBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j) {
        Direction direction = shelfBlockEntity.getBlockState().getValue(ShelfBlock.FACING);
        NonNullList<ItemStack> defaultedList = shelfBlockEntity.getItemsBeingDrying();
        int k = (int)shelfBlockEntity.getBlockPos().asLong();
        for (int l = 0; l < defaultedList.size(); ++l) {
            ItemStack itemStack = defaultedList.get(l);
            if (itemStack == ItemStack.EMPTY) continue;
            matrixStack.pushPose();
            if ( itemStack.getItem() instanceof BlockItem) {
                matrixStack.translate(0.5f, 0.46f, 0.5f);
            } else {
                matrixStack.translate(0.5f, 0.5f, 0.5f);
            }
            Direction direction2 = Direction.from2DDataValue((l + direction.get2DDataValue()) % 4);
            float g = -direction2.toYRot();
            if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
                matrixStack.mulPose(Axis.ZP.rotationDegrees(g));
                if (direction.equals(Direction.NORTH)){
                    matrixStack.translate(-0.2f, -0.2f, 0.25f);
                } else {
                    matrixStack.translate(-0.2f, -0.2f, -0.25f);
                }
                matrixStack.mulPose(Axis.ZP.rotationDegrees(-g));
                if (direction.equals(Direction.SOUTH)) matrixStack.mulPose(Axis.YP.rotationDegrees(180));
            } else {
                matrixStack.mulPose(Axis.XP.rotationDegrees(g));
                if (direction.equals(Direction.WEST)){
                    matrixStack.translate(0.25f, -0.2f, -0.2f);
                } else {
                    matrixStack.translate(-0.25f, -0.2f, -0.2f);
                }
                matrixStack.mulPose(Axis.XP.rotationDegrees(-g));
                matrixStack.mulPose(Axis.YP.rotationDegrees(90));
                if (direction.equals(Direction.EAST)) matrixStack.mulPose(Axis.YP.rotationDegrees(180));
            }
            if ( itemStack.getItem() instanceof BlockItem && !(itemStack.getItem() instanceof ItemNameBlockItem)) {
                matrixStack.scale(0.375f, 0.375f, 0.375f);
            } else {
                matrixStack.scale(0.325f, 0.325f, 0.325f);
            }
            this.itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i, j, matrixStack,vertexConsumerProvider, shelfBlockEntity.getLevel(), k + l);
            matrixStack.popPose();
        }
    }
}


