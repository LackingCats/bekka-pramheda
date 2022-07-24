package net.theelo.mbc;

import net.fabricmc.api.ModInitializer;
import net.theelo.mbc.block.ModBlocks;
import net.theelo.mbc.item.ModItems;
import net.theelo.mbc.item.custom.armor.ModArmorPieces;
import net.theelo.mbc.item.custom.tools.ModTools;
import net.theelo.mbc.painting.ModPaintings;
import net.theelo.mbc.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MightBeCursed implements ModInitializer {
	public static final String MOD_ID = "mbc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModTools.registerModTools();
		ModArmorPieces.registerModArmorPieces();
		ModPaintings.registerModPaintings();
	}
}
