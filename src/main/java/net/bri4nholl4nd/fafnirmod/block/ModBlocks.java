package net.bri4nholl4nd.fafnirmod.block;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.custom.*;
import net.bri4nholl4nd.fafnirmod.item.ModItems;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.bri4nholl4nd.fafnirmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
    public static final Map<String, DeferredBlock<Block>> COLORED_GRASS_BLOCK = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_GRASS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_TALL_GRASS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_STAIRS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_SLAB = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_PRESSURE_PLATE = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_BUTTON = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_COBBLESTONE = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_COBBLESTONE_STAIRS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_COBBLESTONE_SLAB = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_COBBLESTONE_WALL = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_SMOOTH_STONE = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_SMOOTH_STONE_SLAB = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_BRICKS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_CRACKED_STONE_BRICKS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_BRICK_STAIRS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_BRICK_SLAB = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_STONE_BRICK_WALL = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_CHISELED_STONE_BRICKS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_BRICKS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_BRICK_STAIRS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_BRICK_SLAB = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_BRICK_WALL = new LinkedHashMap<>();

    static {
        for (String color : ModColors.COLORS.keySet()) {
            registerColoredLog(color, "oak_log", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
            registerColoredWood(color, "oak_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
            registerColoredLog(color, "stripped_oak_log", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
            registerColoredWood(color, "stripped_oak_wood", BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));
            registerColoredLeaves(color, "oak_leaves", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
            registerColoredSapling(color, "oak_sapling");
            registerColoredWoodBlockAndStairs(color, "oak_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), "oak_stairs", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));
            registerColoredWoodSlab(color, "oak_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));
            registerColoredFence(color, "oak_fence", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE), COLORED_OAK_FENCES);
            registerColoredFenceGate(color, "oak_fence_gate", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE), COLORED_OAK_FENCE_GATES);
            registerColoredDoor(color, "oak_door", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR), COLORED_OAK_DOORS, BlockSetType.OAK);
            registerColoredTrapDoor(color, "oak_trapdoor", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR), COLORED_OAK_TRAPDOORS, BlockSetType.OAK);
            registerColoredPressurePlate(color, "oak_pressure_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), COLORED_OAK_PRESSURE_PLATES, BlockSetType.OAK);
            registerColoredButton(color, "oak_button", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), COLORED_OAK_BUTTONS, BlockSetType.OAK, 30);
            registerColoredBlock(color, "dirt", BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT), COLORED_DIRTS);
            registerColoredGrassBlock(color, "grass_block");
            registerColoredBlockAndStairs(color, "stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), "stone_stairs", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS), COLORED_STONE, COLORED_STONE_STAIRS);
            registerColoredSlab(color, "stone_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB), COLORED_STONE_SLAB);
            registerColoredPressurePlate(color, "stone_pressure_plate", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE), COLORED_STONE_PRESSURE_PLATE, BlockSetType.STONE);
            registerColoredButton(color, "stone_button", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON), COLORED_STONE_BUTTON, BlockSetType.STONE, 20);
            registerColoredBlockAndStairs(color, "cobblestone", BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE), "cobblestone_stairs", BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_STAIRS), COLORED_COBBLESTONE, COLORED_COBBLESTONE_STAIRS);
            registerColoredSlab(color, "cobblestone_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_SLAB), COLORED_COBBLESTONE_SLAB);
            registerColoredWall(color, "cobblestone_wall", BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL), COLORED_COBBLESTONE_WALL);
            registerColoredBlock(color, "smooth_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE), COLORED_SMOOTH_STONE);
            registerColoredSlab(color, "smooth_stone_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_STONE_SLAB), COLORED_SMOOTH_STONE_SLAB);
            registerColoredBlockAndStairs(color, "stone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS), "stone_brick_stairs", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS), COLORED_STONE_BRICKS, COLORED_STONE_BRICK_STAIRS);
            registerColoredBlock(color, "cracked_stone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS), COLORED_CRACKED_STONE_BRICKS);
            registerColoredSlab(color, "stone_brick_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB), COLORED_STONE_BRICK_SLAB);
            registerColoredWall(color, "stone_brick_wall", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL), COLORED_STONE_BRICK_WALL);
            registerColoredBlock(color, "chiseled_stone_bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_STONE_BRICKS), COLORED_CHISELED_STONE_BRICKS);
            registerColoredBlockAndStairs(color, "bricks", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS), "brick_stairs", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_STAIRS), COLORED_BRICKS, COLORED_BRICK_STAIRS);
            registerColoredSlab(color, "brick_slab", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_SLAB), COLORED_BRICK_SLAB);
            registerColoredWall(color, "brick_wall", BlockBehaviour.Properties.ofFullCopy(Blocks.BRICK_WALL), COLORED_BRICK_WALL);
            registerColoredShortAndTallGrass(color, "grass");
        }
    }

    public static final DeferredBlock<Block> LIMESTONE = registerBlock("limestone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    private static void registerColoredBlock(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new Block(properties));

        map.put(name, block);
    }

    private static void registerColoredLog(String color, String blockName, BlockBehaviour.Properties properties) {
        String name = color + "_" + blockName;

        DeferredBlock<Block> block = registerBlock(name, () -> new ModFlammableLog(properties));

        COLORED_OAK_LOGS.put(name, block);
    }

    private static void registerColoredWood(String color, String blockName, BlockBehaviour.Properties properties) {
        String name = color + "_" + blockName;

        DeferredBlock<Block> block = registerBlock(name, () -> new ModFlammableBlock(properties));

        COLORED_BLOCKS.put(name, block);
    }

    private static void registerColoredLeaves(String color, String blockName, BlockBehaviour.Properties properties) {
        String name = color + "_" + blockName;

        DeferredBlock<Block> block = registerBlock(name, () -> new ModFlammableLeaves(properties));

        COLORED_OAK_LEAVES.put(name, block);
    }

    private static void registerColoredSapling(String color, String baseName) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new SaplingBlock(ModTreeGrowers.COLORED_OAK_GROWERS.get(color), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

        COLORED_OAK_SAPLING.put(name, block);
    }

    private static void registerColoredWoodBlockAndStairs(String color, String blockName,
                                                          BlockBehaviour.Properties blockProperties, String stairName,
                                                          BlockBehaviour.Properties stairProperties) {
        String nameBlock = color + "_" + blockName;
        String nameStair = color + "_" + stairName;

        DeferredBlock<Block> block = registerBlock(nameBlock, () -> new ModFlammableBlock(blockProperties));
        DeferredBlock<Block> stairBlock = registerBlock(nameStair, () -> new ModFlammableStairs(block.get().defaultBlockState(), stairProperties));

        COLORED_OAK_PLANKS.put(nameBlock, block);
        COLORED_OAK_STAIRS.put(nameStair, stairBlock);
    }

    private static void registerColoredBlockAndStairs(String color, String blockName,
                                                      BlockBehaviour.Properties blockProperties, String stairName,
                                                      BlockBehaviour.Properties stairProperties, Map<String,
                    DeferredBlock<Block>> blockMap, Map<String, DeferredBlock<Block>> stairMap) {
        String nameBlock = color + "_" + blockName;
        String nameStair = color + "_" + stairName;

        DeferredBlock<Block> block = registerBlock(nameBlock, () -> new Block(blockProperties));
        DeferredBlock<Block> stairBlock = registerBlock(nameStair, () -> new StairBlock(block.get().defaultBlockState(), stairProperties));

        blockMap.put(nameBlock, block);
        stairMap.put(nameStair, stairBlock);
    }

    private static void registerColoredWoodSlab(String color, String baseName, BlockBehaviour.Properties properties) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new ModFlammableSlab(properties));

        COLORED_OAK_SLABS.put(name, block);
    }

    private static void registerColoredSlab(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new SlabBlock(properties));

        map.put(name, block);
    }

    private static void registerColoredFence(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new FenceBlock(properties));

        map.put(name, block);
    }

    private static void registerColoredFenceGate(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new FenceGateBlock(properties, SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

        map.put(name, block);
    }

    private static void registerColoredDoor(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map, BlockSetType blockSetType) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new DoorBlock(blockSetType, properties));

        map.put(name, block);
    }

    private static void registerColoredTrapDoor(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map, BlockSetType blockSetType) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new TrapDoorBlock(blockSetType, properties));

        map.put(name, block);
    }

    private static void registerColoredPressurePlate(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map, BlockSetType blockSetType) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new PressurePlateBlock(blockSetType, properties));

        map.put(name, block);
    }

    private static void registerColoredButton(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map, BlockSetType blockSetType, Integer ticks) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new ButtonBlock(blockSetType, ticks, properties));

        map.put(name, block);
    }

    private static void registerColoredGrassBlock(String color, String baseName) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new GrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));

        COLORED_GRASS_BLOCK.put(name, block);
    }

    private static void registerColoredShortAndTallGrass(String color, String baseName) {
        String shortGrassName = color + "_" + baseName;
        String tallGrassName = color + "_tall_" + baseName;

        DeferredBlock<Block> tallGrass = registerBlock(tallGrassName, () -> new DoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
        DeferredBlock<Block> shortGrass = registerBlock(shortGrassName, () -> new ModShortGrass(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS), tallGrass));

        COLORED_GRASS.put(shortGrassName, shortGrass);
        COLORED_TALL_GRASS.put(tallGrassName, tallGrass);
    }

    private static void registerColoredWall(String color, String baseName, BlockBehaviour.Properties properties, Map<String, DeferredBlock<Block>> map) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new WallBlock(properties));

        map.put(name, block);
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
