package net.nospacehuman.mbc.item.custom.tools.weapons;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.nospacehuman.mbc.util.ModTags;
import net.nospacehuman.mbc.util.Random;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class TanzaniteSwordItem extends SwordItem implements Vanishable {
    public TanzaniteSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public ActionResult useOnBlock(@NotNull ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = Objects.requireNonNull(context.getPlayer());
        Block block = world.getBlockState(blockPos).getBlock();
        Hand hand = player.getActiveHand();
        ItemStack itemStack = player.getStackInHand(hand);
        Vec3d eyePos = player.getEyePos();
        if(!world.isClient()){
            itemStack.damage(1, player, p -> p.sendToolBreakStatus(hand));
        }
        if(isCanInstantlyBreak(block)) {
            world.breakBlock(blockPos, true, player);
            TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
            tntEntity.setPosition(eyePos);
            world.spawnEntity(tntEntity);
        } else {
            player.sendMessage(new LiteralText("oopsie"), true);
            float health = player.getHealth();
            float damage = (float) (health - 0.5);
            player.damage(DamageSource.GENERIC, damage);
            if(!world.isClient()){
                int toolDestroyer = maxTanzaniteToolDurability() - 1000;
                itemStack.damage(toolDestroyer, player, p -> p.sendToolBreakStatus(hand));
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if(attacker instanceof PlayerEntity playerEntity) {
            var calculus = Math.random();
            BigDecimal algebra = new BigDecimal(calculus).setScale(2, RoundingMode.HALF_UP);
            double random = algebra.doubleValue(); //two decimal points
            if(random < 0.05) {
                playerEntity.kill();
                target.teleport(target.getX(), target.getY() + 8, target.getZ());
                playerEntity.sendMessage(new LiteralText("0.05/" + random), true);
                if(target.getWorld().isNight()) {
                    WitherEntity wither = new WitherEntity(EntityType.WITHER, target.getWorld());
                    wither.setPosition(target.getPos());
                    target.getWorld().spawnEntity(wither);
                } else {
                    EnderDragonEntity enderDragon = new EnderDragonEntity(EntityType.ENDER_DRAGON, target.getWorld());
                    enderDragon.setPosition(target.getPos());
                    target.getWorld().spawnEntity(enderDragon);
                }
            } else if (random < 0.1) {
                playerEntity.sendMessage(new LiteralText("1/" + random), true);
            } else if(random < 0.15) {
                playerEntity.addExperience(Random.rand());
                target.setOnFireFor(14);
                target.getWorld().createExplosion(target, target.getX(), target.getY(), target.getZ(), 3f, true, Explosion.DestructionType.DESTROY);
                playerEntity.sendMessage(new LiteralText("1.5/" + random), true);
            } else if(random < 0.2) {
                double d = Math.abs(target.getVelocity().y);
                double e = 13.2 + d * 4.8;
                target.setVelocity(target.getVelocity().multiply(e, 13.0, e));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*15, 25, false, false, false));
                target.setOnFireFor(32767);
                playerEntity.sendMessage(new LiteralText("2/" + random), true);
            } else if(random < 0.25) {
                playerEntity.getWorld().disconnect();
                playerEntity.sendMessage(new LiteralText("2.5/" + random), true);
            } else if(random < 0.3) {
                playerEntity.getInventory().dropAll();
                playerEntity.sendMessage(new LiteralText("3/" + random), true);
            } else if(random < 0.35) {
                playerEntity.sendMessage(new LiteralText("3.5/" + random), true);
            } else if(random < 0.4) {
                playerEntity.sendMessage(new LiteralText("4/" + random), true);
            } else if(random < 0.45) {
                playerEntity.sendMessage(new LiteralText("4.5/" + random), true);
            } else if(random < 0.5) {
                playerEntity.sendMessage(new LiteralText("5/" + random), true);
            } else if(random < 0.55) {
                playerEntity.sendMessage(new LiteralText("5.5/" + random), true);
            } else if(random < 0.6) {
                playerEntity.sendMessage(new LiteralText("6/" + random), true);
            } else if(random < 0.65) {
                playerEntity.sendMessage(new LiteralText("6.5/" + random), true);
            } else if(random < 0.7) {
                playerEntity.sendMessage(new LiteralText("7/" + random), true);
            } else if(random < 0.75) {
                playerEntity.sendMessage(new LiteralText("7.5/" + random), true);
            } else if(random < 0.8) {
                playerEntity.sendMessage(new LiteralText("8/" + random), true);
            } else if(random < 0.85) {
                playerEntity.sendMessage(new LiteralText("8.5/" + random), true);
            } else if(random < 0.9) {
                playerEntity.sendMessage(new LiteralText("9/" + random), true);
            } else if(random < 0.95) {
                playerEntity.sendMessage(new LiteralText("9.5/" + random), true);
            } else {
                playerEntity.sendMessage(new LiteralText("10/" + random), true);
            }



        }




        return super.postHit(stack, target, attacker);
    }

    private boolean isCanInstantlyBreak(Block block) {
        return Registry.BLOCK.getOrCreateEntry(Registry.BLOCK.getKey(block).get()).isIn(ModTags.Blocks.CAN_INSTANTLY_BREAK);
    }
    private int maxTanzaniteToolDurability() {
        return 3514;
    }
}
