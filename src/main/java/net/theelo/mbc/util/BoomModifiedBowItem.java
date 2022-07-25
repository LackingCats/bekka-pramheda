package net.theelo.mbc.util;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Predicate;

public class BoomModifiedBowItem extends RangedWeaponItem
        implements Vanishable {
    public static final int field_30855 = 20;
    public static final int RANGE = 15;

    public BoomModifiedBowItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        boolean bl2;
        int i;
        float f;
        var calculus = Math.random();
        BigDecimal algebra = new BigDecimal(calculus).setScale(2, RoundingMode.HALF_UP);
        double random = algebra.doubleValue(); //two decimal points
        if (!(user instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity playerEntity = (PlayerEntity)user;
        boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
        ItemStack itemStack = playerEntity.getArrowType(stack);
        if (itemStack.isEmpty() && !bl) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Items.ARROW);
        }
        if ((double)(f = BowItem.getPullProgress(i = this.getMaxUseTime(stack) - remainingUseTicks)) < 0.1) {
            return;
        }
        boolean bl3 = bl2 = bl && itemStack.isOf(Items.ARROW);
        if (!world.isClient) {
            int k;
            int j;
            ArrowItem arrowItem = (ArrowItem)(itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
            PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, itemStack, playerEntity);
            persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f, f * 3.0f, 1.0f);
            persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + random * 6 + 0.5);
            if (f == 1.0f) {
                persistentProjectileEntity.setCritical(true);
            }
            if ((j = EnchantmentHelper.getLevel(Enchantments.POWER, stack)) > 0) {
                persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (double)j * 18 * random + 0.5);
            }
            if ((k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack)) > 0) {
                k = k + 24;
                persistentProjectileEntity.setPunch(k);
            }
            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                persistentProjectileEntity.setOnFireFor(23300);
            }
            stack.damage(1, playerEntity, p -> p.sendToolBreakStatus(playerEntity.getActiveHand()));
            if (bl2 || playerEntity.getAbilities().creativeMode && (itemStack.isOf(Items.SPECTRAL_ARROW) || itemStack.isOf(Items.TIPPED_ARROW))) {
                persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
            e(world, persistentProjectileEntity);
            if (persistentProjectileEntity.verticalCollision || persistentProjectileEntity.horizontalCollision) {
                world.createExplosion(user, persistentProjectileEntity.getX(), persistentProjectileEntity.getY(), persistentProjectileEntity.getZ(), 16f, Explosion.DestructionType.NONE);
            }
        }
        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
        if (!bl2 && !playerEntity.getAbilities().creativeMode) {
            itemStack.decrement(1);
            if (itemStack.isEmpty()) {
                playerEntity.getInventory().removeOne(itemStack);
            }
        }
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
    }

    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.0f;
        if ((f = (f * f + f * 2.0f) / 3.0f) > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        boolean bl;
        ItemStack itemStack = user.getStackInHand(hand);
        boolean bl2 = bl = !user.getArrowType(itemStack).isEmpty();
        if (user.getAbilities().creativeMode || bl) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return BOW_PROJECTILES;
    }

    @Override
    public int getRange() {
        return 15;
    }
    public void e(World world, PersistentProjectileEntity persistentProjectileEntity){
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
        world.spawnEntity(persistentProjectileEntity);world.spawnEntity(persistentProjectileEntity);
    }
}