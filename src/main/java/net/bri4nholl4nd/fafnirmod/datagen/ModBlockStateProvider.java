package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FafnirMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LIMESTONE);

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_BLOCKS.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();

            simpleBlockWithItem(block, models().cubeAll(name, modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_LOGS.entrySet()) {
            String name = entry.getKey();
            RotatedPillarBlock block = (RotatedPillarBlock) entry.getValue().get();

            axisBlock(block, modLoc("block/" + name), modLoc("block/" + name + "_top"));

            simpleBlockItem(block, models().getExistingFile(modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_LEAVES.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();

            simpleBlockWithItem(block, models().cubeAll(name, modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_PLANKS.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();

            simpleBlockWithItem(block, models().cubeAll(name, modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_DIRTS.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();

            simpleBlockWithItem(block, models().cubeAll(name, modLoc("block/" + name)));
        }
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
