package net.theelo.bekka.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class FloaterBlock extends Block {
    public FloaterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 20*200, 8, false, false, false));
        }
        if (entity instanceof PlayerEntity player) {
            player.sendMessage(new LiteralText("bye"), true);
        }
        super.onSteppedOn(world, pos, state, entity);
    }


    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightning.setPosition(player.getPos());
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.spawnEntity(lightning);
        world.createExplosion(player, player.getX(), player.getY() - 1, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 10, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 20, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 30, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 40, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 50, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 60, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 70, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 80, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 90, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 100, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 110, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 120, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        world.createExplosion(player, player.getX(), player.getY() - 130, player.getZ(), 25f, false, Explosion.DestructionType.DESTROY);
        super.onBreak(world, pos, state, player);
    }
}
