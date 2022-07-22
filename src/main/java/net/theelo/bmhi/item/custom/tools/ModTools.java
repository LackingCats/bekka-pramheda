package net.theelo.bmhi.item.custom.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.theelo.bmhi.BMHI;
import net.theelo.bmhi.item.custom.tools.constructors.ModToolMaterials;
import net.theelo.bmhi.item.custom.tools.swords.EmberRodItem;
import net.theelo.bmhi.item.custom.tools.swords.MoverStaffItem;
import net.theelo.bmhi.item.custom.tools.swords.TanzaniteHyperionItem;
import net.theelo.bmhi.item.custom.tools.swords.TanzaniteSwordItem;
import net.theelo.bmhi.util.ModItemGroup;

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
    private static Item registerTools(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(BMHI.MOD_ID, name), item);
    }
    public static void registerModTools() {
        BMHI.LOGGER.debug("register tools: " + BMHI.MOD_ID);
    }
}
