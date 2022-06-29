package net.theelo.bekka.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EightBallItem extends Item {

    public EightBallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            outputRandomNumber(user);
            user.getItemCooldownManager().set(this, 14);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("item.blodreina.eight_ball.tooltip.shift"));
        } else {
            tooltip.add(new TranslatableText("item.blodreina.eight_ball.tooltip"));
        }
    }
    private void outputRandomNumber(PlayerEntity player) {
        player.sendMessage(new LiteralText("Your random number is " + getRandomNumber()), true);
    }

    private int getRandomNumber() {
        int min = 1;
        int max = 14;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
