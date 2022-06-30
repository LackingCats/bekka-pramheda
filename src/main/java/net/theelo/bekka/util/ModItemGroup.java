package net.theelo.bekka.util;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.theelo.bekka.BekkaPramheda;
import net.theelo.bekka.item.ModItems;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(new Identifier(BekkaPramheda.MOD_ID, "tanzanite"),
            () -> new ItemStack(ModItems.TANZANITE));
}
