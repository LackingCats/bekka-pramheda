package net.theelo.bekka;

import net.fabricmc.api.ModInitializer;
import net.theelo.bekka.block.ModBlocks;
import net.theelo.bekka.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BekkaPramheda implements ModInitializer {
	public static final String MOD_ID = "bekka";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
