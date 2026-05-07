package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_SAPLING.entrySet()) {
            String name = entry.getKey();
            SaplingBlock block = (SaplingBlock) entry.getValue().get();

            simpleBlock(block, models().cross(name, modLoc("block/" + name)).renderType("cutout"));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_PLANKS.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();

            simpleBlockWithItem(block, models().cubeAll(name, modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_STAIRS.entrySet()) {
            String name = entry.getKey();
            String planks = name.replace("_stairs", "_planks");
            StairBlock block = (StairBlock) entry.getValue().get();

            stairsBlock(block, modLoc("block/" + planks));
            simpleBlockItem(block, models().getExistingFile(modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_SLABS.entrySet()) {
            String name = entry.getKey();
            String planks = name.replace("_slab", "_planks");
            SlabBlock block = (SlabBlock) entry.getValue().get();

            slabBlock(block, modLoc("block/" + planks), modLoc("block/" + planks));
            simpleBlockItem(block, models().getExistingFile(modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_FENCES.entrySet()) {
            String name = entry.getKey();
            String planks = name.replace("_fence", "_planks");
            FenceBlock block = (FenceBlock) entry.getValue().get();

            fenceBlock(block, modLoc("block/" + planks));
            simpleBlockItem(block, models().fenceInventory(name, modLoc("block/" + planks)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_FENCE_GATES.entrySet()) {
            String name = entry.getKey();
            String planks = name.replace("_fence_gate", "_planks");
            FenceGateBlock block = (FenceGateBlock) entry.getValue().get();

            fenceGateBlock(block, modLoc("block/" + planks));
            simpleBlockItem(block, models().getExistingFile(modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_DOORS.entrySet()) {
            String name = entry.getKey();
            DoorBlock block = (DoorBlock) entry.getValue().get();

            doorBlockWithRenderType(block, modLoc("block/" + name + "_bottom"), modLoc("block/" + name + "_top"), "cutout");
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_TRAPDOORS.entrySet()) {
            String name = entry.getKey();
            TrapDoorBlock block = (TrapDoorBlock) entry.getValue().get();

            trapdoorBlockWithRenderType(block, modLoc("block/" + name), true, "cutout");
            simpleBlockItem(block, new ModelFile.UncheckedModelFile(FafnirMod.MOD_ID + ":block/" + name + "_bottom"));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_PRESSURE_PLATES.entrySet()) {
            String name = entry.getKey();
            String planks = name.replace("_pressure_plate", "_planks");
            PressurePlateBlock block = (PressurePlateBlock) entry.getValue().get();

            pressurePlateBlock(block, modLoc("block/" + planks));
            simpleBlockItem(block, new ModelFile.UncheckedModelFile(FafnirMod.MOD_ID + ":block/" + name));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_BUTTONS.entrySet()) {
            String name = entry.getKey();
            String planks = name.replace("_button", "_planks");
            ButtonBlock block = (ButtonBlock) entry.getValue().get();

            buttonBlock(block, modLoc("block/" + planks));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_DIRTS.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();

            simpleBlockWithItem(block, models().cubeAll(name, modLoc("block/" + name)));
        }

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_GRASS_BLOCK.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();
            String color = name.replace("_grass_block", "");

            simpleBlockWithItem(block, models().cubeBottomTop(name, modLoc("block/" + name + "_side"),
                    modLoc("block/" + color + "_dirt"), modLoc("block/" + name + "_top")));
        }
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
