package net.theelo.bmhi.util;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.theelo.bmhi.BMHI;
import net.theelo.bmhi.item.ModItems;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(new Identifier(BMHI.MOD_ID, "tanzanite"),
            () -> new ItemStack(ModItems.TANZANITE));
}
