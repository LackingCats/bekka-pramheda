package net.theelo.bekka.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.theelo.bekka.BekkaPramheda;
import net.theelo.bekka.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        BekkaPramheda.LOGGER.info("register fuels for " + BekkaPramheda.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.FRAGMENT_OF_THE_UNDERWORLD, 20*24000000);
    }
}
