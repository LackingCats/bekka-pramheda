package net.theelo.bekka.item.custom;

import net.minecraft.entity.player.PlayerEntity;
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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MoverSwordItem extends SwordItem implements Vanishable {
    public MoverSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity user = Objects.requireNonNull(context.getPlayer());
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 3f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        user.teleport(blockPos.getX(), blockPos.getY() + 3, blockPos.getZ());
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
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
        }
        return TypedActionResult.success(itemStack);
    }
}
/*
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            EnderPearlEntity moverPearlEntity = new EnderPearlEntity(world, user);
            moverPearlEntity.setItem(itemStack);
            moverPearlEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 3f, 1.0f);
            world.spawnEntity(moverPearlEntity);
        }
 */