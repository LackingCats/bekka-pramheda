package net.nospacehuman.mbc.item.custom.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.nospacehuman.mbc.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class MoltenTanzaniteItem extends Item {
    public MoltenTanzaniteItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(user.isHolding(ModItems.MOLTEN_TANZANITE)) {
            user.setOnFireFor(218);
        }
        return TypedActionResult.success(itemStack);
    }
}
