package net.nospacehuman.mbc.util;

import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class Functions {
    public static float randfloat64to256() {
        float leftLimit = 64F;
        float rightLimit = 256F;
        float generatedFloat;
        generatedFloat = leftLimit + new java.util.Random().nextFloat() * (rightLimit - leftLimit);
        return generatedFloat;
    }

    public static int randint1to100() {
        int min = 1;
        int max = 100;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    public static int randint1to99999() {
        int min = 1;
        int max = 99999;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    public static int randIntPosMinus300000() {
        int min = -300000;
        int max = 300000;
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    public static long randLong1to24000() {
        long min = 1;
        long max = 24000;
        return (long)Math.floor(Math.random()*(max-min+1)+min);
    }
    public static void spawnCreeperFifty(@NotNull World world, CreeperEntity creeperEntity) {
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
        world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);world.spawnEntity(creeperEntity);
    }
}
