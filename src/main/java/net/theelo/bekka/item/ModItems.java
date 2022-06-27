package net.theelo.bekka.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.theelo.bekka.BekkaPramheda;

public class ModItems {
    public static final Item TANZANITE = registerItems("tanzanite",
            new Item(new FabricItemSettings().maxCount(64).fireproof().group(ItemGroup.MISC)));

    public static final Item RAW_TANZANITE = registerItems("raw_tanzanite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(32)));

    public static final Item SHARD_OF_TANZANITE = registerItems("shard_of_tanzanite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).maxCount(64).food(
                    new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION,20*300, 255, false, false, false), 1f).snack().build())));


    private static Item registerItems(String name, Item item) {

        return Registry.register(Registry.ITEM, new Identifier(BekkaPramheda.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BekkaPramheda.LOGGER.info("register items: " + BekkaPramheda.MOD_ID);
    }
}
