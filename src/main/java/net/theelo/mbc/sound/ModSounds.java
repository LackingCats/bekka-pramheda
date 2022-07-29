package net.theelo.mbc.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.theelo.mbc.MightBeCursed;

public class ModSounds {

    public static SoundEvent DOWSING_FOUND_VALUABLE = registerSoundEvent("dowsing_found_valuable");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MightBeCursed.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
