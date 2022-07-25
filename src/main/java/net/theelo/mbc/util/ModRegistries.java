package net.theelo.mbc.util;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.theelo.mbc.MightBeCursed;
import net.theelo.mbc.command.ReturnHomeCommand;
import net.theelo.mbc.command.SetHomeCommand;
import net.theelo.mbc.event.ModPlayerEventCopyFrom;
import net.theelo.mbc.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerCommands();
        registerEvents();
    }

    private static void registerFuels() {
        MightBeCursed.LOGGER.debug("register fuels for " + MightBeCursed.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.FRAGMENT_OF_THE_UNDERWORLD, 32767);
    }

    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }
    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}
