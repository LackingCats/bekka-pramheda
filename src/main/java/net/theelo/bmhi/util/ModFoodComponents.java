package net.theelo.bmhi.util;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent SHARD_OF_TANZANITE = new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,20*300, 255, false, false, false), 1f).snack().build();
}
