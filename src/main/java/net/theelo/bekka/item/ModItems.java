package net.theelo.bekka.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.theelo.bekka.BekkaPramheda;
import net.theelo.bekka.item.custom.EightBallItem;
import net.theelo.bekka.item.custom.FragmentOfTheHeavensItem;
import net.theelo.bekka.item.custom.FragmentOfTheUnderworldItem;
import net.theelo.bekka.item.custom.TanzaniteBomberItem;
import net.theelo.bekka.lib0.ModItemGroup;

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


    private static Item registerItems(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(BekkaPramheda.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BekkaPramheda.LOGGER.info("register items: " + BekkaPramheda.MOD_ID);
    }
}
