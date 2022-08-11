package net.nospacehuman.mbc.item.custom.armor;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nospacehuman.mbc.MightBeCursed;
import net.nospacehuman.mbc.item.custom.armor.molten.MoltenArmorItem;
import net.nospacehuman.mbc.util.ModArmorMaterials;
import net.nospacehuman.mbc.util.ModItemGroup;

public class ModArmorPieces {


    public static final Item MOLTEN_HELMET = registerArmor("molten_helmet",
            new MoltenArmorItem(ModArmorMaterials.MOLTEN, EquipmentSlot.HEAD,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item MOLTEN_CHESTPLATE = registerArmor("molten_chestplate",
            new MoltenArmorItem(ModArmorMaterials.MOLTEN, EquipmentSlot.CHEST,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item MOLTEN_LEGGINGS = registerArmor("molten_leggings",
            new MoltenArmorItem(ModArmorMaterials.MOLTEN, EquipmentSlot.LEGS,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));
    public static final Item MOLTEN_BOOTS = registerArmor("molten_boots",
            new MoltenArmorItem(ModArmorMaterials.MOLTEN, EquipmentSlot.FEET,
                    new FabricItemSettings().maxCount(1).fireproof().group(ModItemGroup.TANZANITE)));

    private static Item registerArmor(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MightBeCursed.MOD_ID, name), item);
    }
    public static void registerModArmorPieces() {
        MightBeCursed.LOGGER.debug("register items: " + MightBeCursed.MOD_ID);
    }
}
