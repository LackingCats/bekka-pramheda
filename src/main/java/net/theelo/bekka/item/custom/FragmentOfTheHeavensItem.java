package net.theelo.bekka.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FragmentOfTheHeavensItem extends Item {
    public FragmentOfTheHeavensItem(Settings settings) {
        super(settings);
    }

    public static int rand() {
        int min = 1;
        int max = 100;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    @Override
    public ActionResult useOnEntity(ItemStack itemStack, @NotNull PlayerEntity user, @NotNull LivingEntity entity, Hand hand) {
        if(rand() > 50) { //fifty percent chance
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,20*20, 2, false, false, false));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING,20*40, 2, false, false, false));
            user.sendMessage(new LiteralText("bye"), true);
        } else {
            user.sendMessage(new LiteralText("u are not worthy"), true);
        }
        return super.useOnEntity(itemStack, user, entity, hand);
    }

/*
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("item.bekka.fragment_of_the_heavens.tooltip.shift"));
        } else {
            tooltip.add(new TranslatableText("item.bekka.fragment_of_the_heavens.tooltip"));
        }
    }

 */
}


