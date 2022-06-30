package net.theelo.bekka.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.theelo.bekka.util.RanFloat;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class TanzaniteBomberItem extends Item {
    // HIGHLY UNSTABLE ___ USE WITH CAUTION
    public TanzaniteBomberItem(Settings settings) {
        super(settings);
    }

    private int getRandomNumber() {
        int min = 1;
        int max = 48;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public double positioningX(@NotNull PlayerEntity user) {
        return user.getX() + getRandomNumber();
    }

    public double positioningY(@NotNull PlayerEntity user) {
        return user.getY() + getRandomNumber();
    }

    public double positioningZ(@NotNull PlayerEntity user) {
        return user.getZ() + getRandomNumber();
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.NEUTRAL, 14F, 2);

        if(!world.isClient) {
            world.createExplosion(user, positioningX(user), positioningY(user), positioningZ(user), RanFloat.number(), true, Explosion.DestructionType.BREAK);
            user.getItemCooldownManager().set(this, 20*40);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if(!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
/*
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("item.bekka.tanzanite_bomber.tooltip.shift"));
        } else {
            tooltip.add(new TranslatableText("item.bekka.tanzanite_bomber.tooltip"));
        }
    }

 */
}
