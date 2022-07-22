package net.theelo.bmhi.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.theelo.bmhi.BMHI;
import net.theelo.bmhi.item.custom.items.*;
import net.theelo.bmhi.util.ModFoodComponents;
import net.theelo.bmhi.util.ModItemGroup;

public class ModItems {
    public static final Item TANZANITE = registerItems("tanzanite",
            new Item(new FabricItemSettings().maxCount(64).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item MOLTEN_TANZANITE = registerItems("molten_tanzanite",
            new MoltenTanzaniteItem(new FabricItemSettings().maxCount(64).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item RAW_TANZANITE = registerItems("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(32)));
    public static final Item SHARD_OF_TANZANITE = registerItems("shard_of_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(64).food(ModFoodComponents.SHARD_OF_TANZANITE)));
    //BOMBER IS HIGHLY UNSTABLE -- USE WITH CAUTION
    public static final Item TANZANITE_BOMBER = registerItems("tanzanite_bomber",
            new TanzaniteBomberItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(16)));
    public static final Item FRAGMENT_OF_THE_HEAVENS = registerItems("fragment_of_the_heavens",
            new FragmentOfTheHeavensItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).rarity(Rarity.RARE).maxCount(1).maxDamage(500)));
    public static final Item FRAGMENT_OF_THE_UNDERWORLD = registerItems("fragment_of_the_underworld",
            new FragmentOfTheUnderworldItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).rarity(Rarity.RARE).maxCount(1).maxDamage(500)));
    public static final Item EIGHT_BALL = registerItems("eight_ball",
            new EightBallItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(1).maxDamage(500)));
    public static final Item DOWSING_ROD = registerItems("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxDamage(128)));
    public static final Item TANZANITE_POLE = registerItems("tanzanite_pole",
            new Item(new FabricItemSettings().maxCount(64).fireproof().group(ModItemGroup.TANZANITE)));

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(BMHI.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BMHI.LOGGER.debug("register items: " + BMHI.MOD_ID);
    }
}
