package net.bri4nholl4nd.fafnirmod.block;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.item.ModItems;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FafnirMod.MOD_ID);
    public static final Map<String, DeferredBlock<Block>> COLORED_OAK_PLANKS = new LinkedHashMap<>();
    public static final Map<String, DeferredBlock<Block>> COLORED_DIRTS = new LinkedHashMap<>();

    static {
        for (String color : ModColors.COLORS.keySet()) {
            registerColoredOakPlanks(color, "oak_planks");
            registerColoredDirt(color, "dirt");
        }
    }

    public static final DeferredBlock<Block> LIMESTONE = registerBlock("limestone",
            () -> new Block(BlockBehaviour.Properties.of()));

    private static void registerColoredOakPlanks(String color, String baseName) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new Block(BlockBehaviour.Properties.of()));

        COLORED_OAK_PLANKS.put(name, block);
    }

    private static void registerColoredDirt(String color, String baseName) {
        String name = color + "_" + baseName;

        DeferredBlock<Block> block = registerBlock(name, () -> new Block(BlockBehaviour.Properties.of()));

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
