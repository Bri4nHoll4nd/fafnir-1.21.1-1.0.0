package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LIMESTONE.get());
        ModBlocks.COLORED_BLOCKS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_LOGS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_LEAVES.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_SAPLING.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_PLANKS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_STAIRS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_SLABS.values().forEach(defBlock ->
                this.add(defBlock.get(), block -> createSlabItemTable(defBlock.get())));
        ModBlocks.COLORED_OAK_FENCES.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_FENCE_GATES.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_DOORS.values().forEach(defBlock ->
                this.add(defBlock.get(), block -> createDoorTable(defBlock.get())));
        ModBlocks.COLORED_OAK_TRAPDOORS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_PRESSURE_PLATES.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_OAK_BUTTONS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_DIRTS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_GRASS_BLOCK.values().forEach(defBlock -> {
            String name = defBlock.getId().getPath();
            String color = name.replace("_grass_block", "");

            this.add(defBlock.get(), block -> createGrassLikeDrops(defBlock.get(), ModBlocks.COLORED_DIRTS.get(color + "_dirt").get()));
        });
        ModBlocks.COLORED_GRASS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_TALL_GRASS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_STONE.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_STONE_STAIRS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_STONE_SLAB.values().forEach(defBlock ->
                this.add(defBlock.get(), block -> createSlabItemTable(defBlock.get())));
        ModBlocks.COLORED_STONE_PRESSURE_PLATE.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_STONE_BUTTON.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_COBBLESTONE.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_COBBLESTONE_STAIRS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_COBBLESTONE_SLAB.values().forEach(defBlock ->
                this.add(defBlock.get(), block -> createSlabItemTable(defBlock.get())));
        ModBlocks.COLORED_COBBLESTONE_WALL.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_SMOOTH_STONE.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_SMOOTH_STONE_SLAB.values().forEach(defBlock ->
                this.add(defBlock.get(), block -> createSlabItemTable(defBlock.get())));
        ModBlocks.COLORED_STONE_BRICKS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_CRACKED_STONE_BRICKS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_STONE_BRICK_STAIRS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_STONE_BRICK_SLAB.values().forEach(defBlock ->
                this.add(defBlock.get(), block -> createSlabItemTable(defBlock.get())));
        ModBlocks.COLORED_STONE_BRICK_WALL.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_CHISELED_STONE_BRICKS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_BRICKS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_BRICK_STAIRS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_BRICK_SLAB.values().forEach(defBlock ->
                this.add(defBlock.get(), block -> createSlabItemTable(defBlock.get())));
        ModBlocks.COLORED_BRICK_WALL.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
//        add(ModBlocks.TEMPLATEIUM_ORE.get(),
//                block -> createOreDrop(ModBlocks.TEMPLATEIUM_ORE.get(), ModItems.RAW_TEMPLATEIUM.get()));
    }

    private LootTable.Builder createGrassLikeDrops(Block grassBlock, Block dirt) {
        return createSilkTouchDispatchTable(grassBlock,
                applyExplosionDecay(grassBlock,
                        LootItem.lootTableItem(dirt)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
