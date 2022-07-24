package net.theelo.bmhi.painting;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.theelo.bmhi.BMHI;

public class ModPaintings {

    public static final PaintingMotive FLAMONDE = registerPainting("flamonde", new PaintingMotive(64, 64));


    public static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(BMHI.MOD_ID, name), paintingMotive);
    }

    public static void registerModPaintings(){
        BMHI.LOGGER.debug("reg. painting");
    }

}
