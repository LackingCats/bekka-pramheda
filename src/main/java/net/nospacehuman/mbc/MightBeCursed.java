package net.nospacehuman.mbc;

import net.fabricmc.api.ModInitializer;
import net.nospacehuman.mbc.block.ModBlocks;
import net.nospacehuman.mbc.item.ModItems;
import net.nospacehuman.mbc.item.custom.armor.ModArmorPieces;
import net.nospacehuman.mbc.item.custom.tools.ModTools;
import net.nospacehuman.mbc.painting.ModPaintings;
import net.nospacehuman.mbc.util.ModRegistries;
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
