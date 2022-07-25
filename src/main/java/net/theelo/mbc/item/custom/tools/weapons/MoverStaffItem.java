package net.theelo.mbc.item.custom.tools.weapons;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MoverStaffItem extends SwordItem implements Vanishable {
    public MoverStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, @NotNull LivingEntity attacker) {
        World world = attacker.getWorld();
        Hand hand = attacker.getActiveHand();
        ItemStack itemStack = attacker.getStackInHand(hand);
        world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            EnderPearlEntity moverPearlEntity = new EnderPearlEntity(world, attacker);
            moverPearlEntity.setItem(itemStack);
            moverPearlEntity.setVelocity(attacker, attacker.getPitch(), attacker.getYaw(), 0.0f, 3f, 1.0f);
            world.spawnEntity(moverPearlEntity);

        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult useOnBlock(@NotNull ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity user = Objects.requireNonNull(context.getPlayer());
        Hand hand = user.getActiveHand();
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient()){
            itemStack.damage(6, user, p -> p.sendToolBreakStatus(hand));
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 3f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        user.teleport(blockPos.getX(), blockPos.getY() + 3, blockPos.getZ());
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 3f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        int tpDist;
        var calculus = Math.random();
        BigDecimal algebra = new BigDecimal(calculus).setScale(2, RoundingMode.HALF_UP);
        double random = algebra.doubleValue(); //two decimal points
        if(random < 0.33) {
            tpDist = 6;
        } else if(random < 0.66) {
            tpDist = 7;
        } else {
            tpDist = 8;
        }
        if (!world.isClient()) {
            //this will help a lot lmao
            Vec3d lookVector = user.getRotationVec(0);
            Vec3d offset = lookVector.multiply(tpDist);
            Vec3d destination = user.getPos().add(offset);
            user.requestTeleport(destination.x, destination.y + 3, destination.z);
            user.sendMessage(new LiteralText("/" + tpDist), true);

            if(!world.isClient()){
                itemStack.damage(6, user, p -> p.sendToolBreakStatus(hand));
            }
        }
        return TypedActionResult.success(itemStack);
    }
}