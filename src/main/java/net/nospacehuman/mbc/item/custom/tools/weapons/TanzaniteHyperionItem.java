package net.nospacehuman.mbc.item.custom.tools.weapons;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.NotNull;

public class TanzaniteHyperionItem extends SwordItem implements Vanishable {
    public TanzaniteHyperionItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient()){
            itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
        }
        if(!world.isClient() && !world.isRaining() && !world.isThundering()){
            int tpDist = 5;
            Vec3d lookVector = user.getRotationVec(0);
            Vec3d offset = lookVector.multiply(tpDist);
            Vec3d destination = user.getPos().add(offset);
            user.requestTeleport(destination.x, destination.y + 3, destination.z);
            user.sendMessage(new LiteralText("/" + tpDist), true);
        }
        if(world.isRaining()){
            ArrowItem arrowItem = (ArrowItem)(Items.ARROW);
            PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, itemStack, user);
            persistentProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f,  4.0f, 1.0f);
            double x = persistentProjectileEntity.getX();
            double y = persistentProjectileEntity.getY();
            double z = persistentProjectileEntity.getZ();
            world.spawnEntity(persistentProjectileEntity);
            if(!persistentProjectileEntity.horizontalCollision || !persistentProjectileEntity.verticalCollision){
                TntEntity tntEntity = new TntEntity(EntityType.TNT, world);
                tntEntity.setPosition(x, y, z);
                persistentProjectileEntity.getWorld().spawnEntity(tntEntity);
            }
        }
        if(world.isThundering()){
            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 40f, Explosion.DestructionType.NONE);
        }
        return TypedActionResult.success(itemStack);
    }

}