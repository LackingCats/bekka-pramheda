package net.nospacehuman.mbc.item.custom.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

public class VillageItem extends Item {
    public VillageItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        assert player != null;
        Hand hand = player.getActiveHand();
        ItemStack itemStack = player.getStackInHand(hand);
        return ActionResult.SUCCESS;
    }
}
