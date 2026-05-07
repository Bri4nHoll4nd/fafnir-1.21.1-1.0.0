package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FafnirMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LIMESTONE.get());

        for (DeferredBlock<Block> block : ModBlocks.COLORED_OAK_LOGS.values()) {
            tag(BlockTags.OAK_LOGS).add(block.get());
            tag(BlockTags.LOGS_THAT_BURN).add(block.get());
        }
        for (DeferredBlock<Block> block : ModBlocks.COLORED_OAK_LEAVES.values()) {
            tag(BlockTags.LEAVES).add(block.get());
        }
        for (DeferredBlock<Block> block : ModBlocks.COLORED_OAK_FENCES.values()) {
            tag(BlockTags.FENCES).add(block.get());
        }
        for (DeferredBlock<Block> block : ModBlocks.COLORED_OAK_FENCE_GATES.values()) {
            tag(BlockTags.FENCE_GATES).add(block.get());
        }
        for (DeferredBlock<Block> block : ModBlocks.COLORED_DIRTS.values()) {
            tag(BlockTags.DIRT).add(block.get());
        }
        for (DeferredBlock<Block> block : ModBlocks.COLORED_GRASS_BLOCK.values()) {
            tag(BlockTags.DIRT).add(block.get());
        }
    }
}
