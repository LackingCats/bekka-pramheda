package net.nospacehuman.mbc.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nospacehuman.mbc.MightBeCursed;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ORES = createTag("ores");
        public static final TagKey<Block> CAN_INSTANTLY_BREAK = createTag("can_instantly_break");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(MightBeCursed.MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items {
        //might use later??
        public static final TagKey<Item> TANZANITE = createCommonTag("tanzanites");
        public static final TagKey<Item> TANZANITE_NUGGETS = createCommonTag("tanzanite_nuggets");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(MightBeCursed.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }
}
