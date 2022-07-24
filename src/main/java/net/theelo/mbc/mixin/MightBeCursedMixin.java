package net.theelo.mbc.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.theelo.mbc.MightBeCursed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MightBeCursedMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		MightBeCursed.LOGGER.debug("mix");
	}
}
