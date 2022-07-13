package net.theelo.bekka.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.theelo.bekka.BekkaPramheda;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class BekkaPramhedaMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		BekkaPramheda.LOGGER.debug("mix");
	}
}
