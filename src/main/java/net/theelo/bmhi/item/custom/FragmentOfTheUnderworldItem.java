package net.theelo.bmhi.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.theelo.bmhi.util.Random;
import org.jetbrains.annotations.NotNull;

public class FragmentOfTheUnderworldItem extends Item {
    public FragmentOfTheUnderworldItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack itemStack, @NotNull PlayerEntity user, @NotNull LivingEntity entity, Hand hand) {
        if(Random.rand() > 50) { //fifty percent chance
            entity.teleport(entity.getX(), -70, entity.getZ());
            user.sendMessage(new LiteralText("bye"), true);
        } else {
            user.sendMessage(new LiteralText("u are not worthy"), true);
        }
        user.getItemCooldownManager().set(this, 20*5);
        return super.useOnEntity(itemStack, user, entity, hand);
    }
/*
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("item.bekka.fragment_of_the_underworld.tooltip.shift"));
        } else {
            tooltip.add(new TranslatableText("item.bekka.fragment_of_the_underworld.tooltip"));
        }
    }

 */
}
