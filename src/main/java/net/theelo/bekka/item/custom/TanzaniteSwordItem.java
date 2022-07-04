package net.theelo.bekka.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.LiteralText;
import net.minecraft.world.explosion.Explosion;
import net.theelo.bekka.util.Random;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TanzaniteSwordItem extends SwordItem implements Vanishable {
    public TanzaniteSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if(attacker instanceof PlayerEntity playerEntity) {
            var calculus = Math.random();
            BigDecimal algebra = new BigDecimal(calculus).setScale(2, RoundingMode.HALF_UP);
            double random = algebra.doubleValue();

            if(random < 0.1) {
                playerEntity.kill();
                target.teleport(target.getX(), target.getY() + 8, target.getZ());
                playerEntity.sendMessage(new LiteralText("1/" + random), true);
            } else if(random < 0.2){
                playerEntity.addExperience(Random.rand());
                target.setOnFireFor(14);
                target.getWorld().createExplosion(target, target.getX(), target.getY(), target.getZ(), 3f, true, Explosion.DestructionType.DESTROY);
                playerEntity.sendMessage(new LiteralText("2/" + random), true);
            } else if(random < 0.3){
                playerEntity.sendMessage(new LiteralText("3/" + random), true);
            } else if(random < 0.4){
                playerEntity.sendMessage(new LiteralText("4/" + random), true);
            } else if(random < 0.5){
                playerEntity.sendMessage(new LiteralText("5/" + random), true);
            } else if(random < 0.6){
                playerEntity.sendMessage(new LiteralText("6/" + random), true);
            } else if(random < 0.7){
                playerEntity.sendMessage(new LiteralText("7/" + random), true);
            } else if(random < 0.8){
                playerEntity.sendMessage(new LiteralText("8/" + random), true);
            } else if(random < 0.9){
                playerEntity.sendMessage(new LiteralText("9/" + random), true);
            } else {
                playerEntity.sendMessage(new LiteralText("10/" + random), true);
            }


        }
        return super.postHit(stack, target, attacker);
    }
}
