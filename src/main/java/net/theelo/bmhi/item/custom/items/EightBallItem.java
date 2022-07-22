package net.theelo.bmhi.item.custom.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.concurrent.ThreadLocalRandom;

public class EightBallItem extends Item {

    public EightBallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 14);
            itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
        }

        return TypedActionResult.success(itemStack);
    }

    /*
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            if(Screen.hasShiftDown()) {
                tooltip.add(new TranslatableText("item.eight_ball.tooltip.shift"));
            } else {
                tooltip.add(new TranslatableText("item.eight_ball.tooltip"));
            }
        }

     */
    private void outputRandomNumber(PlayerEntity player) {
        player.sendMessage(new LiteralText("Your random number is " + getRandomNumber()), true);
    }

    private int getRandomNumber() {
        int min = 1;
        int max = 14;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
