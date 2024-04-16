package com.nanokulon.primalstage.mixin;

import com.nanokulon.primalstage.init.ModBlocks;
import com.nanokulon.primalstage.init.ModConfig;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class BlockBreakMixin extends LivingEntity {

	@Shadow
	@Final
	private Inventory inventory;

	protected BlockBreakMixin(EntityType<? extends LivingEntity> entityType, Level world) {
		super(entityType, world);
	}

	@Inject(
			method = "Lnet/minecraft/world/entity/player/Player;getDestroySpeed(Lnet/minecraft/world/level/block/state/BlockState;)F",
			at = @At("RETURN"),
			cancellable = true
	)
	private void blockBreak(BlockState state, CallbackInfoReturnable<Float> cir) {
		Item heldItem = this.inventory.getSelected().getItem();
		boolean isWood = state.getSoundType().equals(SoundType.WOOD) && !state.getBlock().equals(ModBlocks.TWIGS_BLOCK);
		if(isWood && !(heldItem instanceof AxeItem)){
			if (ModConfig.CONFIG.getKey().disableTreePunching.get()) {
				cir.setReturnValue(0.0F);
			}
		}
	}
}