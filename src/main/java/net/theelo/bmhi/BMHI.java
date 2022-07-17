package net.theelo.bmhi;

import net.fabricmc.api.ModInitializer;
import net.theelo.bmhi.block.ModBlocks;
import net.theelo.bmhi.item.ModItems;
import net.theelo.bmhi.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BMHI implements ModInitializer {
	public static final String MOD_ID = "bmhi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
	}
}
