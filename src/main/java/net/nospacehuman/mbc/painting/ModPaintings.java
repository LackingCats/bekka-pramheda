package net.nospacehuman.mbc.painting;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nospacehuman.mbc.MightBeCursed;

public class ModPaintings {

    public static final PaintingMotive FLAMONDE = registerPainting("flamonde", new PaintingMotive(64, 64));


    public static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(MightBeCursed.MOD_ID, name), paintingMotive);
    }

    public static void registerModPaintings(){
        MightBeCursed.LOGGER.debug("reg. painting");
    }

}
