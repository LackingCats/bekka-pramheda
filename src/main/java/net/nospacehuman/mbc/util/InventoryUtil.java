package net.nospacehuman.mbc.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class InventoryUtil {
    public static boolean hasPlayerStackInInventory(@NotNull PlayerEntity player, Item item) {
        for(int i = 0; i < player.getInventory().size(); i++) {
            ItemStack currentStack = player.getInventory().getStack(i);
            if (!currentStack.isEmpty() && currentStack.isItemEqual(new ItemStack(item))) {
                return true;
            }
        }

        return false;
    }

    public static int getFirstInventoryIndex(PlayerEntity player, Item item) {
        for(int i = 0; i < player.getInventory().size(); i++) {
            ItemStack currentStack = player.getInventory().getStack(i);
            if (!currentStack.isEmpty() && currentStack.isItemEqual(new ItemStack(item))) {
                return i;
            }
        }

        return -1;
    }
}