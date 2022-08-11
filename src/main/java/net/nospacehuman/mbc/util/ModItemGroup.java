package net.nospacehuman.mbc.util;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nospacehuman.mbc.MightBeCursed;
import net.nospacehuman.mbc.item.ModItems;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(new Identifier(MightBeCursed.MOD_ID, "tanzanite"),
            () -> new ItemStack(ModItems.TANZANITE));
}
