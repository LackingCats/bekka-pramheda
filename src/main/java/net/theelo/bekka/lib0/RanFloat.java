package net.theelo.bekka.lib0;

import java.util.Random;

public class RanFloat {
    public static float number() {
        float leftLimit = 64F;
        float rightLimit = 256F;
        float generatedFloat;
        generatedFloat = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
        return generatedFloat;
    }
}
