package net.theelo.bekka;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BekkaPramheda implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("bekka");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}
