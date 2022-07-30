package net.theelo.mbc.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.theelo.mbc.MightBeCursed;

public class ModSounds {

    public static SoundEvent DOWSING_FOUND_VALUABLE = registerSoundEvent("dowsing_found_valuable");

    public static SoundEvent LAMPLAMP_BREAK = registerSoundEvent("lamplamp_break");
    public static SoundEvent LAMPLAMP_STEP = registerSoundEvent("lamplamp_step");
    public static SoundEvent LAMPLAMP_PLACE = registerSoundEvent("lamplamp_place");
    public static SoundEvent LAMPLAMP_HIT = registerSoundEvent("lamplamp_hit");
    public static SoundEvent LAMPLAMP_FALL = registerSoundEvent("lamplamp_fall");
    //pepezabala
    public static SoundEvent BERIMBAU = registerSoundEvent("berimbau");


    public static final BlockSoundGroup LAMPLAMP_SOUNDS = new BlockSoundGroup(1f, 1f,
            ModSounds.LAMPLAMP_BREAK, ModSounds.LAMPLAMP_STEP, ModSounds.LAMPLAMP_FALL, ModSounds.LAMPLAMP_HIT, ModSounds.LAMPLAMP_PLACE);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(MightBeCursed.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
