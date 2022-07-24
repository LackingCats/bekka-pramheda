package net.theelo.bmhi.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.theelo.bmhi.BMHI;
import net.theelo.bmhi.block.custom.*;
import net.theelo.bmhi.block.custom.generic.*;
import net.theelo.bmhi.util.ModItemGroup;

public class ModBlocks {

    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(55f).luminance(11).slipperiness(25f)),
                    ModItemGroup.TANZANITE);
    public static final Block RAW_TANZANITE_BLOCK = registerBlock("raw_tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(50f).luminance(9).slipperiness(0.15f)),
                    ModItemGroup.TANZANITE);
    public static final Block COMPRESSED_TANZANITE_BLOCK = registerBlock("compressed_tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(76f).luminance(13)),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(8f).luminance(7),
                    UniformIntProvider.create(3, 7)),
                            ModItemGroup.TANZANITE);
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(10f).luminance(7),
                    UniformIntProvider.create(5, 10)),
                            ModItemGroup.TANZANITE);
    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("nether_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(8f).luminance(10),
                    UniformIntProvider.create(5, 10)),
                            ModItemGroup.TANZANITE);
    public static final Block FLOATER = registerBlock("floater",
            new FloaterBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(85f).luminance(14)),
                    ModItemGroup.TANZANITE);
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(95f).luminance(15)),
                    ModItemGroup.TANZANITE);
    public static final Block LAUNCH = registerBlock("launch",
            new LaunchBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(85f).luminance(14)),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_BUTTON = registerBlock("tanzanite_button",
            new ModButtonBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(2.0f).luminance(15).noCollision()),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_PRESSURE_PLATE = registerBlock("tanzanite_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL).requiresTool().strength(2.0f).luminance(15)),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_FENCE = registerBlock("tanzanite_fence",
            new FenceBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(2.0f).luminance(15)),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_FENCE_GATE = registerBlock("tanzanite_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(2.0f).luminance(15)),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_WALL = registerBlock("tanzanite_wall",
            new WallBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(2.0f).luminance(15)),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_SLAB = registerBlock("tanzanite_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(2.0f).luminance(15)),
                    ModItemGroup.TANZANITE);
    public static final Block TANZANITE_STAIRS = registerBlock("tanzanite_stairs",
            new ModStairsBlock(ModBlocks.TANZANITE_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL).requiresTool().strength(2.0f).luminance(15)),
                    ModItemGroup.TANZANITE);
    public static final Block LAMPLAMP = registerBlock("lamplamp",
            new LampLampBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(35f).luminance((state) -> state.get(LampLampBlock.CLICKED) ? 15 : 0)),
                    ModItemGroup.TANZANITE);
    public static final Block BLOODWOOD_DOOR = registerBlock("bloodwood_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).luminance(15).nonOpaque()),
                    ModItemGroup.TANZANITE);
    public static final Block BLOODWOOD_TRAPDOOR = registerBlock("bloodwood_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).luminance(15).nonOpaque()),
                    ModItemGroup.TANZANITE);
    public static final Block MOLTEN_FLOWER = registerBlock("molten_flower",
            new MoltenFlowerBlock(StatusEffects.FIRE_RESISTANCE, 3450, FabricBlockSettings.copy(Blocks.POPPY).nonOpaque()),
                    ModItemGroup.TANZANITE);
// public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
//         new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(8f).luminance(8),
//                 UniformIntProvider.create(7, 14)),
//                     ModItemGroup.TANZANITE);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(BMHI.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(BMHI.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        BMHI.LOGGER.debug("Registering ModBlocks for " + BMHI.MOD_ID);
    }
}
