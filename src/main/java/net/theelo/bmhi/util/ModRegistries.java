package net.theelo.bmhi.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.theelo.bmhi.BMHI;
import net.theelo.bmhi.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        BMHI.LOGGER.info("register fuels for " + BMHI.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.FRAGMENT_OF_THE_UNDERWORLD, 32767);
    }
}
