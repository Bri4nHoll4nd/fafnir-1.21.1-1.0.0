package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LIMESTONE.get());
        ModBlocks.COLORED_OAK_PLANKS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));
        ModBlocks.COLORED_DIRTS.values().forEach(defBlock ->
                this.dropSelf(defBlock.get()));

//        add(ModBlocks.TEMPLATEIUM_ORE.get(),
//                block -> createOreDrop(ModBlocks.TEMPLATEIUM_ORE.get(), ModItems.RAW_TEMPLATEIUM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
