package net.theelo.bekka.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.theelo.bekka.BekkaPramheda;
import net.theelo.bekka.item.custom.*;
import net.theelo.bekka.item.custom.generic.ModToolMaterials;
import net.theelo.bekka.util.ModItemGroup;

public class ModItems {
    public static final Item TANZANITE = registerItems("tanzanite",
            new Item(new FabricItemSettings().maxCount(64).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item RAW_TANZANITE = registerItems("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(32)));
    public static final Item SHARD_OF_TANZANITE = registerItems("shard_of_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(64).food(
                    new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,20*300, 255, false, false, false), 1f).snack().build())));
    //BOMBER IS HIGHLY UNSTABLE -- USE WITH CAUTION
    public static final Item TANZANITE_BOMBER = registerItems("tanzanite_bomber",
            new TanzaniteBomberItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(16)));
    public static final Item FRAGMENT_OF_THE_HEAVENS = registerItems("fragment_of_the_heavens",
            new FragmentOfTheHeavensItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).rarity(Rarity.RARE).maxCount(1)));
    public static final Item FRAGMENT_OF_THE_UNDERWORLD = registerItems("fragment_of_the_underworld",
            new FragmentOfTheUnderworldItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).rarity(Rarity.RARE).maxCount(1)));
    public static final Item EIGHT_BALL = registerItems("eight_ball",
            new EightBallItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(1)));
    public static final Item DOWSING_ROD = registerItems("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxDamage(128)));
    public static final Item TANZANITE_POLE = registerItems("tanzanite_pole",
            new Item(new FabricItemSettings().maxCount(64).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE_SWORD = registerItems("tanzanite_sword",
            new TanzaniteSwordItem(ModToolMaterials.TANZANITE, 8, 2f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE))); //6 attack speed, 10 attack damage; public static final Item DIAMOND_SWORD = Items.register("diamond_sword", (Item)new SwordItem(ToolMaterials.DIAMOND, 3, -2.4f, new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item TANZANITE_HYPERION = registerItems("tanzanite_hyperion",
            new TanzaniteHyperionItem(ModToolMaterials.TANZANITE, 12, 1.5f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item MOVER_SWORD = registerItems("mover_sword",
            new MoverSwordItem(ToolMaterials.IRON, 2, -0.5f,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));

    private static Item registerItems(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(BekkaPramheda.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BekkaPramheda.LOGGER.info("register items: " + BekkaPramheda.MOD_ID);
    }
}
