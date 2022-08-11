package net.nospacehuman.mbc.item.custom.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nospacehuman.mbc.MightBeCursed;
import net.nospacehuman.mbc.item.custom.tools.axes.TanzaniteAxeItem;
import net.nospacehuman.mbc.item.custom.tools.hoes.TanzaniteHoeItem;
import net.nospacehuman.mbc.item.custom.tools.pickaxes.TanzanitePickaxeItem;
import net.nospacehuman.mbc.item.custom.tools.shovels.TanzaniteShovelItem;
import net.nospacehuman.mbc.item.custom.tools.weapons.EmberRodItem;
import net.nospacehuman.mbc.item.custom.tools.weapons.MoverStaffItem;
import net.nospacehuman.mbc.item.custom.tools.weapons.TanzaniteHyperionItem;
import net.nospacehuman.mbc.item.custom.tools.weapons.TanzaniteSwordItem;
import net.nospacehuman.mbc.util.ModItemGroup;
import net.nospacehuman.mbc.util.ModToolMaterials;

public class ModTools {

    public static final Item TANZANITE_SWORD = registerTools("tanzanite_sword",
            new TanzaniteSwordItem(ModToolMaterials.TANZANITE, 8, 2f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE))); //6 attack speed, 10 attack damage; public static final Item DIAMOND_SWORD = Items.register("diamond_sword", (Item)new SwordItem(ToolMaterials.DIAMOND, 3, -2.4f, new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item TANZANITE_HYPERION = registerTools("tanzanite_hyperion",
            new TanzaniteHyperionItem(ModToolMaterials.TANZANITE, 12, 1.5f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item MOVER_STAFF = registerTools("mover_staff",
            new MoverStaffItem(ModToolMaterials.TANZANITE, 2, -0.5f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item EMBER_ROD = registerTools("ember_rod",
            new EmberRodItem(ModToolMaterials.TANZANITE, 6, 4f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE_PICKAXE = registerTools("tanzanite_pickaxe",
            new TanzanitePickaxeItem(ModToolMaterials.TANZANITE, 3, -2.8f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE_AXE = registerTools("tanzanite_axe",
            new TanzaniteAxeItem(ModToolMaterials.TANZANITE, 10.0f, -3.0f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE_SHOVEL = registerTools("tanzanite_shovel",
            new TanzaniteShovelItem(ModToolMaterials.TANZANITE, 3.0f, -2f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE_HOE = registerTools("tanzanite_hoe",
            new TanzaniteHoeItem(ModToolMaterials.TANZANITE, -2, 0f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    /*
    public static final Item BOOMBOW = registerTools("boombow",
            new BoomBowItemBoom(new FabricItemSettings().fireproof().group(ModItemGroup.TANZANITE).maxDamage(5240)));

     */
    private static Item registerTools(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MightBeCursed.MOD_ID, name), item);
    }
    public static void registerModTools() {
        MightBeCursed.LOGGER.debug("register tools: " + MightBeCursed.MOD_ID);
    }
}
