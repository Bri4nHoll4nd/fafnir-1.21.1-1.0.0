package net.bri4nholl4nd.fafnirmod.block;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.custom.ModFlammableLeaves;
import net.bri4nholl4nd.fafnirmod.block.custom.ModFlammableLog;
import net.bri4nholl4nd.fafnirmod.item.ModItems;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FafnirMod.MOD_ID);

    public static final Map<String, DeferredBlock<Block>> COLORED_BLOCKS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_LOGS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_LEAVES = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_SAPLING = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_PLANKS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_STAIRS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_SLABS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_FENCES = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_FENCE_GATES = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_DOORS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_TRAPDOORS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_PRESSURE_PLATES = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_BUTTONS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_DIRTS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_GRASS = new LinkedHashMap<>();

    static {
        for (String color : ModColors.COLORS.keySet()) {
            registerColoredOakLog(color, "oak_log", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
            registerColoredOakWood(color, "oak_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
            registerColoredOakLog(color, "stripped_oak_log", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
            registerColoredOakWood(color, "stripped_oak_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));
            registerColoredOakLeaves(color, "oak_leaves");
            registerColoredOakPlanks(color, "oak_planks");
            registerColoredDirt(color, "dirt");
        }
    }

    public static final DeferredBlock<Block> LIMESTONE = registerBlock("limestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    private static void registerColoredOakLog(String color, String baseName, BlockBehaviour.Properties properties) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new ModFlammableLog(properties));

        COLORED_OAK_LOGS.put(name, block);
    }

    private static void registerColoredOakWood(String color, String baseName, BlockBehaviour.Properties properties) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new Block(properties));

        COLORED_BLOCKS.put(name, block);
    }

    private static void registerColoredOakLeaves(String color, String baseName) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new ModFlammableLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

        COLORED_OAK_LEAVES.put(name, block);
    }

//    private static void registerColoredOakSapling(String color, String baseName) {
//        String name = color + "_" + baseName;
//
//        DeferredBlock<Block> block = registerBlock(name, () -> new SaplingBlock(ModTreeGrowers.COLORED_OAK_GROWERS.get(color), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
//
//        COLORED_OAK_PLANKS.put(name, block);
//    }

    private static void registerColoredOakPlanks(String color, String baseName) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

        COLORED_OAK_PLANKS.put(name, block);
    }

    private static void registerColoredDirt(String color, String baseName) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

        COLORED_DIRTS.put(name, block);
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
