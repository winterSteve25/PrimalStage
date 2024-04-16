package com.nanokulon.primalstage.init;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements Tier {
    PRIMITIVE(0, 32, 2.0f, 0.0f, 15, () -> {
        return Ingredient.of(ModItems.STONE_PEBBLE.get().asItem());
    }),
    FLINT(1, 186, 4.2f, 1.0f, 5, () -> {
        return Ingredient.of(Items.FLINT.asItem());
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
               int enchantability, Supplier<Ingredient> repairMaterialIn) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyLoadedValue(repairMaterialIn);
    }

    @Override
    public int getUses() {
        return itemDurability;
    }

    @Override
    public float getSpeed() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return miningLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}
