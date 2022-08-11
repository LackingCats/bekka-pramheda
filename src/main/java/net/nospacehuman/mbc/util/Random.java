package net.nospacehuman.mbc.util;

public class Random {
    public static float randfloat() {
        float leftLimit = 64F;
        float rightLimit = 256F;
        float generatedFloat;
        generatedFloat = leftLimit + new java.util.Random().nextFloat() * (rightLimit - leftLimit);
        return generatedFloat;
    }

    public static int rand() {
        int min = 1;
        int max = 100;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}
