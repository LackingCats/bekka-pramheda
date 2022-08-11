package net.nospacehuman.mbc.block.custom;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.nospacehuman.mbc.item.ModItems;

public class BlodFungiBlock extends CropBlock {
    public BlodFungiBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BLOD_SEEDS;
    }
}
