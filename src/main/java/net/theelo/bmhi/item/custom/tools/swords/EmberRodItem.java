package net.theelo.bmhi.item.custom.tools.swords;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class EmberRodItem extends SwordItem implements Vanishable {
    public EmberRodItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, @NotNull PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if(!world.isClient()){
            itemStack.damage(1, user, p -> p.sendToolBreakStatus(hand));
        }
        Vec3d vec3d = user.getRotationVec(1.0f);
        FireballEntity fireballEntity = new FireballEntity(world, user, vec3d.x, vec3d.y, vec3d.z, 4);
        fireballEntity.setVelocity(user, user.getPitch(), user.getYaw(), user.getRoll(),  4.0f, 0.0f);
        fireballEntity.setPosition(user.getX() + vec3d.x * 4.0, user.getBodyY(0.5) + 0.5, fireballEntity.getZ() + vec3d.z * 4.0);
        user.getWorld().spawnEntity(fireballEntity);
        return TypedActionResult.success(itemStack);
    }
}
