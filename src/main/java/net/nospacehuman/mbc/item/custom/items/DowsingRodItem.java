package net.nospacehuman.mbc.item.custom.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.nospacehuman.mbc.item.ModItems;
import net.nospacehuman.mbc.sound.ModSounds;
import net.nospacehuman.mbc.util.InventoryUtil;
import net.nospacehuman.mbc.util.ModTags;
import org.jetbrains.annotations.NotNull;

public class DowsingRodItem extends Item {

    public DowsingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(@NotNull ItemUsageContext context) {
        BlockPos positionClicked = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        assert player != null;
        Hand hand = player.getActiveHand();
        ItemStack itemStack = player.getStackInHand(hand);
        if(!context.getWorld().isClient()){
            itemStack.damage(1, player, p -> p.sendToolBreakStatus(hand));
        }
        if(context.getWorld().isClient()) {
            boolean foundBlock = false;
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoords(positionClicked.down(i), player, blockBelow);
                    foundBlock = true;
                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DOWSING_DATA_TABLET)) {
                        addNbtToDataTablet(player, positionClicked.add(0, -i, 0), blockBelow);
                    }

                    context.getWorld().playSound(player, positionClicked, ModSounds.DOWSING_FOUND_VALUABLE, SoundCategory.BLOCKS, 1f, 1f);

                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(new TranslatableText("item.mbc.dowsing_rod.no_valuables"), false);
            }
        }
        return super.useOnBlock(context);
    }

    private void addNbtToDataTablet(PlayerEntity player, BlockPos pos, Block blockBelow) {
        ItemStack dataTablet =
                player.getInventory().getStack(InventoryUtil.getFirstInventoryIndex(player, ModItems.DOWSING_DATA_TABLET));

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("mbc.dowsing_rod.last_ore", "Found " + blockBelow.asItem().getName().getString() + " at (" +
                pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");

        dataTablet.setNbt(nbtData);
    }

    private void outputValuableCoords(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(new LiteralText("Found " + blockBelow.asItem().getName().getString() + " at "
            + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), true);
    }

    private boolean isValuableBlock(Block block) {
        return Registry.BLOCK.getOrCreateEntry(Registry.BLOCK.getKey(block).get()).isIn(ModTags.Blocks.ORES);
    }
}
