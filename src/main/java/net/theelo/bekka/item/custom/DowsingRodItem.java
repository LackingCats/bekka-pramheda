package net.theelo.bekka.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class DowsingRodItem extends Item {

    public DowsingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoords(positionClicked.down(i), player, blockBelow);
                    foundBlock = true;
                    player.getItemCooldownManager().set(this, 20*20);
                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(new TranslatableText("item.bekka.dowsing_rod.no_valuables"), false);
                player.getItemCooldownManager().set(this, 20*20);
            }
        }


        return super.useOnBlock(context);
    }

    private void outputValuableCoords(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(new LiteralText("Found " + blockBelow.asItem().getName().getString() + " at "
            + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), true);
    }

    private boolean isValuableBlock(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.IRON_ORE || block == Blocks.LAPIS_ORE || block == Blocks.GOLD_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.REDSTONE_ORE || block == Blocks.COPPER_ORE
                || block == Blocks.DEEPSLATE_COAL_ORE || block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.DEEPSLATE_COPPER_ORE;
    }
}
