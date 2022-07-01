package net.theelo.bekka.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LaunchBlock extends Block {
    public LaunchBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        if(!world.isClient()){
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addVelocity(livingEntity.getX(), livingEntity.getY() + 480, livingEntity.getZ());
            }
            if (entity instanceof PlayerEntity player) {
                player.sendMessage(new LiteralText("boing"), true);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
