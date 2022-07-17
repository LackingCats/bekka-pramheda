package net.theelo.bmhi.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class TanzaniteHyperionItem extends SwordItem implements Vanishable {
    public TanzaniteHyperionItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 40f, Explosion.DestructionType.NONE);
        if(!world.isClient()){
            int tpDist = 5;
            Vec3d lookVector = user.getRotationVec(0);
            Vec3d offset = lookVector.multiply(tpDist);
            Vec3d destination = user.getPos().add(offset);
            user.requestTeleport(destination.x, destination.y + 3, destination.z);
            user.sendMessage(new LiteralText("/" + tpDist), true);
        }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Vec3d velocity = attacker.getPos();
        ArrowEntity arrowEntity = new ArrowEntity(attacker.getWorld(), attacker);
        arrowEntity.setVelocity(velocity.x, velocity.y, velocity.z, 4f, 0f);
        attacker.getWorld().spawnEntity(arrowEntity);
        return super.postHit(stack, target, attacker);
    }
}