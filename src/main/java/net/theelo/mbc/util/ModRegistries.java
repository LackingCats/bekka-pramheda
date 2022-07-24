package net.theelo.mbc.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.theelo.mbc.MightBeCursed;
import net.theelo.mbc.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        MightBeCursed.LOGGER.debug("register fuels for " + MightBeCursed.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.FRAGMENT_OF_THE_UNDERWORLD, 32767);
    }
}
