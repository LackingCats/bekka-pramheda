package net.nospacehuman.mbc.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class SpeedyBlock extends Block {
    public SpeedyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, @NotNull World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if(world.isClient()) {
            if(hand == Hand.MAIN_HAND) {
                player.sendMessage(new LiteralText("client: main hand"), true);
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*200, 8, false, false, false));
            } else {
                player.sendMessage(new LiteralText("client: off hand"), true);
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*200, 127, false, false, false));
            }
        }

        return ActionResult.SUCCESS;
    }


    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClient()){
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*15, 127, false, false, false));
            }
            if (entity instanceof PlayerEntity player) {
                player.sendMessage(new LiteralText("speeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeed"), true);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
