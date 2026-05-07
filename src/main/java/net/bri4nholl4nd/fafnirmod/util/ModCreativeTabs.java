package net.bri4nholl4nd.fafnirmod.util;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.bri4nholl4nd.fafnirmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;
import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FafnirMod.MOD_ID);

    public static final Supplier<CreativeModeTab> FAFNIR_MOD_TAB = CREATIVE_MODE_TABS.register("fafnir_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLUE_PEARL.get()))
                    .title(Component.translatable("creativetab.fafnir.fafnir_mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLUE_PEARL);
                        output.accept(ModBlocks.LIMESTONE);
                        for (String color : ModColors.COLORS.keySet()) {
                            addColorItemSet(output, color);
                        }
                    }).build());

    public static final Supplier<CreativeModeTab> COLORED_BLOCKS_TAB = CREATIVE_MODE_TABS.register("fafnir_colored_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.COLORED_OAK_LOGS.get("red_oak_log").get()))
                    .title(Component.translatable("creativetab.fafnir.fafnir_colored_blocks_tab"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(FafnirMod.MOD_ID, "fafnir_mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for (String color : ModColors.COLORS.keySet()) {
                            addColorBlocksSet(output, color);
                        }
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    private static void addColorBlocksSet(CreativeModeTab.Output output, String color) {
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_LOGS, color + "_oak_log");
        acceptBlockIfPresent(output, ModBlocks.COLORED_BLOCKS, color + "_oak_wood");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_LOGS, color + "_stripped_oak_log");
        acceptBlockIfPresent(output, ModBlocks.COLORED_BLOCKS, color + "_stripped_oak_wood");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_LEAVES, color + "_oak_leaves");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_SAPLING, color + "_oak_sapling");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_PLANKS, color + "_oak_planks");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_STAIRS, color + "_oak_stairs");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_SLABS, color + "_oak_slab");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_FENCES, color + "_oak_fence");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_FENCE_GATES, color + "_oak_fence_gate");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_DOORS, color + "_oak_door");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_TRAPDOORS, color + "_oak_trapdoor");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_PRESSURE_PLATES, color + "_oak_pressure_plate");
        acceptBlockIfPresent(output, ModBlocks.COLORED_OAK_BUTTONS, color + "_oak_button");
        acceptBlockIfPresent(output, ModBlocks.COLORED_DIRTS, color + "_dirt");
        acceptBlockIfPresent(output, ModBlocks.COLORED_GRASS_BLOCK, color + "_grass_block");
        acceptBlockIfPresent(output, ModBlocks.COLORED_GRASS, color + "_grass");
        acceptBlockIfPresent(output, ModBlocks.COLORED_TALL_GRASS, color + "_tall_grass");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE, color + "_stone");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_STAIRS, color + "_stone_stairs");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_SLAB, color + "_stone_slab");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_PRESSURE_PLATE, color + "_stone_pressure_plate");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_BUTTON, color + "_stone_button");
        acceptBlockIfPresent(output, ModBlocks.COLORED_COBBLESTONE, color + "_cobblestone");
        acceptBlockIfPresent(output, ModBlocks.COLORED_COBBLESTONE_STAIRS, color + "_cobblestone_stairs");
        acceptBlockIfPresent(output, ModBlocks.COLORED_COBBLESTONE_SLAB, color + "_cobblestone_slab");
        acceptBlockIfPresent(output, ModBlocks.COLORED_COBBLESTONE_WALL, color + "_cobblestone_wall");
        acceptBlockIfPresent(output, ModBlocks.COLORED_SMOOTH_STONE, color + "_smooth_stone");
        acceptBlockIfPresent(output, ModBlocks.COLORED_SMOOTH_STONE_SLAB, color + "_smooth_stone_slab");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_BRICKS, color + "_stone_bricks");
        acceptBlockIfPresent(output, ModBlocks.COLORED_CRACKED_STONE_BRICKS, color + "_cracked_stone_bricks");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_BRICK_STAIRS, color + "_stone_brick_stairs");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_BRICK_SLAB, color + "_stone_brick_slab");
        acceptBlockIfPresent(output, ModBlocks.COLORED_STONE_BRICK_WALL, color + "_stone_brick_wall");
        acceptBlockIfPresent(output, ModBlocks.COLORED_CHISELED_STONE_BRICKS, color + "_chiseled_stone_bricks");
        acceptBlockIfPresent(output, ModBlocks.COLORED_BRICKS, color + "_bricks");
        acceptBlockIfPresent(output, ModBlocks.COLORED_BRICK_STAIRS, color + "_brick_stairs");
        acceptBlockIfPresent(output, ModBlocks.COLORED_BRICK_SLAB, color + "_brick_slab");
        acceptBlockIfPresent(output, ModBlocks.COLORED_BRICK_WALL, color + "_brick_wall");
    }

    private static void addColorItemSet(CreativeModeTab.Output output, String color) {
        acceptItemIfPresent(output, ModItems.COLORED_APPLES, color + "_apple");
    }

    private static void acceptBlockIfPresent(CreativeModeTab.Output output, Map<String, DeferredBlock<Block>> map, String key) {
        DeferredBlock<Block> defBlock = map.get(key);
        if (defBlock != null) {
            output.accept(defBlock.get());
        } else {
            System.out.println("Missing creative tab block key: \" + key");
        }
    }

    private static void acceptItemIfPresent(CreativeModeTab.Output output, Map<String, DeferredItem<Item>> map, String key) {
        DeferredItem<Item> defItem = map.get(key);
        if (defItem != null) {
            output.accept(defItem.get());
        } else {
            System.out.println("Missing creative tab block key: \" + key");
        }
    }
}
