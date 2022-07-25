package net.theelo.mbc.block.custom;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.theelo.mbc.item.ModItems;

public class BlodFungiBlock extends CropBlock {
    public BlodFungiBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BLOD_SEEDS;
    }
}
