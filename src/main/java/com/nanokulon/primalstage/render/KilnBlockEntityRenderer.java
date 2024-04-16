package com.nanokulon.primalstage.render;

import com.nanokulon.primalstage.blocks.entity.KilnBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnBlockEntityRenderer implements BlockEntityRenderer<KilnBlockEntity> {

    private final ItemRenderer itemRenderer;

    public KilnBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(KilnBlockEntity kilnBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j) {
        NonNullList<ItemStack> defaultedList = kilnBlockEntity.getItemsBeingCooked();
        int k = (int)kilnBlockEntity.getBlockPos().asLong();
        ItemStack itemStack = defaultedList.get(0);
        if (itemStack == ItemStack.EMPTY) return;
        matrixStack.pushPose();
        if(itemStack.getItem() instanceof BlockItem){
            matrixStack.translate(0.5f, 0.46f, 0.5f);
        } else matrixStack.translate(0.5f, 0.4f, 0.5f);
        matrixStack.scale(0.6f, 0.6f, 0.6f);
        this.itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i, j, matrixStack,vertexConsumerProvider, kilnBlockEntity.getLevel(), k);
        matrixStack.popPose();
    }
}


