package net.theelo.bekka.util;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.theelo.bekka.BekkaPramheda;

public class ModTags {
    public static class Blocks {
        public static final Tag.Identified<Block> ORES = createTag("ores");


        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(BekkaPramheda.MOD_ID, name));
        }

        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {

        public static final Tag.Identified<Item> TANZANITE = createCommonTag("tanzanites");
        public static final Tag.Identified<Item> TANZANITE_NUGGETS = createCommonTag("tanzanite_nuggets");

        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(BekkaPramheda.MOD_ID, name));
        }

        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }
}