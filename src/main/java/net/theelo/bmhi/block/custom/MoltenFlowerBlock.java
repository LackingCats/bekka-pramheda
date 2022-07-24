package net.theelo.bmhi.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoltenFlowerBlock extends FlowerBlock {
    public MoltenFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10, 18, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*10, 20, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20*10, 5, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*10, 23, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*10, 5, false, false, false));
            livingEntity.setOnFireFor(8);
            livingEntity.damage(DamageSource.ON_FIRE, 1);
            livingEntity.damage(DamageSource.IN_FIRE, 1);
                if(!world.isClient()){
                    world.setBlockState(pos, Blocks.LAVA.getDefaultState());
                }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10, 18, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*10, 20, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20*10, 5, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20*10, 23, false, false, false));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 20*10, 5, false, false, false));
            livingEntity.setOnFireFor(8);
            livingEntity.damage(DamageSource.GENERIC, 1);
            livingEntity.damage(DamageSource.GENERIC, 1);
                if(!world.isClient()){
                    world.setBlockState(pos, Blocks.LAVA.getDefaultState());
                }
        }
        super.onEntityCollision(state, world, pos, entity);
    }
}
