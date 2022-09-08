package net.nospacehuman.mbc.item.custom.items;

import net.minecraft.SharedConstants;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nospacehuman.mbc.util.Functions;
import org.jetbrains.annotations.NotNull;

public class TimeTravellerItem extends Item {
    public TimeTravellerItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
        int spawnPos = Functions.randIntPosMinus300000();
        MinecraftServer minecraftServer = world.getServer();
        user.sendMessage(new LiteralText("Minecraft Version: " + SharedConstants.VERSION_NAME + " | Ticks per Second/Minute/InGameDay: " + SharedConstants.TICKS_PER_SECOND + "/" + SharedConstants.TICKS_PER_MINUTE + "/" + SharedConstants.TICKS_PER_IN_GAME_DAY + ", Max Command Length: " + SharedConstants.COMMAND_MAX_LENGTH), true);
        BlockPos blockPos = new BlockPos(spawnPos, spawnPos, spawnPos);
        if(minecraftServer.getWorld(world.getRegistryKey()) != null) {
            ServerWorld serverWorld = minecraftServer.getWorld(world.getRegistryKey());
            serverWorld.setTimeOfDay(Functions.randLong1to24000());
            //serverWorld.setWeather(0, Functions.randint1to99999(), false, true);
            serverWorld.setSpawnPos(blockPos, Functions.randfloat64to256());
            user.requestTeleport(spawnPos, spawnPos, spawnPos);
        } else {
            ClientWorld clientWorld = (ClientWorld) world;
            clientWorld.setTime(Functions.randLong1to24000());
            clientWorld.setSpawnPos(blockPos, Functions.randfloat64to256());
            user.requestTeleport(spawnPos, spawnPos, spawnPos);
        }

        return TypedActionResult.success(itemStack);
    }
}
