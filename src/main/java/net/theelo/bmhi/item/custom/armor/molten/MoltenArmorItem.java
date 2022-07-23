package net.theelo.bmhi.item.custom.armor.molten;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.theelo.bmhi.util.ModArmorMaterials;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.include.com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class MoltenArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.MOLTEN,
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*50, 7)).build();

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TOO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.MOLTEN,
                            new StatusEffectInstance(StatusEffects.REGENERATION, 20*50, 4)).build();
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TOOO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.MOLTEN,
                            new StatusEffectInstance(StatusEffects.SATURATION, 20*50, 255)).build();
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_GURL_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.MOLTEN,
                            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*50, 4)).build();



    public MoltenArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
                LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, player.getWorld());
                lightningEntity.setPosition(positioningX(player), player.getY(), positioningZ(player));
                if(positioningX(player) == player.getX() && positioningZ(player) == player.getZ()) {
                    return;
                } else {
                    player.getWorld().spawnEntity(lightningEntity);
                }
            }
        }

        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TOO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mappArmorMaterial = entry.getKey();
            StatusEffectInstance mappStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mappArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mappArmorMaterial, mappStatusEffect);
                FireballEntity fireballEntity = new FireballEntity(player.getWorld(), player, 0, -25, 0, 8);
                fireballEntity.setVelocity(player, 0, -25, 0,  4.0f, 0.0f);
                fireballEntity.setVelocity(0, -25, 0, 4f, 0f);
                fireballEntity.setPosition(positioningX(player), 150, positioningZ(player));
                player.getWorld().spawnEntity(fireballEntity);
            }
        }

        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TOOO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapppArmorMaterial = entry.getKey();
            StatusEffectInstance mapppStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapppArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapppArmorMaterial, mapppStatusEffect);
            }


        }
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_GURL_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapeppArmorMaterial = entry.getKey();
            StatusEffectInstance mapeppStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapeppArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapeppArmorMaterial, mapeppStatusEffect);
            }


        }
    }

    private void addStatusEffectForMaterial(@NotNull PlayerEntity player, ArmorMaterial mapArmorMaterial, @NotNull StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));

            // if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
            //     player.getInventory().damageArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            // }
        }
    }

    private boolean hasFullSuitOfArmorOn(@NotNull PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, @NotNull PlayerEntity player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
    public double ppositioningX(@NotNull PlayerEntity player) {
        return player.getX() + getRandomNumber();
    }

    public double ppositioningZ(@NotNull PlayerEntity player) {
        return player.getZ() + getRandomNumber();
    }

    public double mpositioningX(@NotNull PlayerEntity player) {
        return player.getX() - getRandomNumber();
    }

    public double mpositioningZ(@NotNull PlayerEntity player) {
        return player.getZ() - getRandomNumber();
    }

    public double positioningX(@NotNull PlayerEntity player) {
        if(getRandomNumber() < 2500){
            return mpositioningX(player);
        } else {
            return ppositioningX(player);
        }
    }

    public double positioningZ(@NotNull PlayerEntity player) {
        if(getRandomNumber() < 2500){
            return mpositioningZ(player);
        } else {
            return ppositioningZ(player);
        }
    }

    private double getRandomNumber() {
        double min = 1;
        double max = 5000;
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }
}
