package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
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

        ModBlocks.COLORED_BLOCKS.entrySet().forEach(this::generateBlockStateCubeAll);

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_LOGS.entrySet()) {
            String name = entry.getKey();
            RotatedPillarBlock block = (RotatedPillarBlock) entry.getValue().get();

            axisBlock(block, modLoc("block/" + name), modLoc("block/" + name + "_top"));
            simpleBlockItem(block, models().getExistingFile(modLoc("block/" + name)));
        }

        ModBlocks.COLORED_OAK_LEAVES.entrySet().forEach(this::generateBlockStateCubeAll);

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_OAK_SAPLING.entrySet()) {
            String name = entry.getKey();
            SaplingBlock block = (SaplingBlock) entry.getValue().get();

            simpleBlock(block, models().cross(name, modLoc("block/" + name)).renderType("cutout"));
        }

        ModBlocks.COLORED_OAK_PLANKS.entrySet().forEach(this::generateBlockStateCubeAll);

        ModBlocks.COLORED_OAK_STAIRS.entrySet()
                .forEach(entry -> generateBlockStateStairs(entry, "_planks"));

        ModBlocks.COLORED_OAK_SLABS.entrySet()
                .forEach(entry -> generateBlockStateSlab(entry, "_planks"));

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

        ModBlocks.COLORED_OAK_PRESSURE_PLATES.entrySet()
                .forEach(entry -> generateBlockStatePressurePlate(entry, "_planks"));

        ModBlocks.COLORED_OAK_BUTTONS.entrySet()
                .forEach(entry -> generateBlockStateButton(entry, "_planks"));

        ModBlocks.COLORED_DIRTS.entrySet().forEach(this::generateBlockStateCubeAll);

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_GRASS_BLOCK.entrySet()) {
            String name = entry.getKey();
            Block block = entry.getValue().get();
            String color = name.replace("_grass_block", "");

            simpleBlockWithItem(block, models().cubeBottomTop(name, modLoc("block/" + name + "_side"),
                    modLoc("block/" + color + "_dirt"), modLoc("block/" + name + "_top")));
        }

        ModBlocks.COLORED_GRASS.entrySet().forEach(this::generateBlockStateGrass);

        ModBlocks.COLORED_TALL_GRASS.entrySet().forEach(this::generateBlockStateTallGrass);

        ModBlocks.COLORED_STONE.entrySet().forEach(this::generateBlockStateCubeAll);

        ModBlocks.COLORED_STONE_STAIRS.entrySet()
                .forEach(entry -> generateBlockStateStairs(entry, ""));

        ModBlocks.COLORED_STONE_SLAB.entrySet()
                .forEach(entry -> generateBlockStateSlab(entry, ""));

        ModBlocks.COLORED_STONE_PRESSURE_PLATE.entrySet()
                .forEach(entry -> generateBlockStatePressurePlate(entry, ""));

        ModBlocks.COLORED_STONE_BUTTON.entrySet()
                .forEach(entry -> generateBlockStateButton(entry, ""));

        ModBlocks.COLORED_COBBLESTONE.entrySet().forEach(this::generateBlockStateCubeAll);

        ModBlocks.COLORED_COBBLESTONE_STAIRS.entrySet()
                .forEach(entry -> generateBlockStateStairs(entry, ""));

        ModBlocks.COLORED_COBBLESTONE_SLAB.entrySet()
                .forEach(entry -> generateBlockStateSlab(entry, ""));

        ModBlocks.COLORED_COBBLESTONE_WALL.entrySet()
                .forEach(entry -> generateBlockStateWall(entry, ""));

        ModBlocks.COLORED_SMOOTH_STONE.entrySet().forEach(this::generateBlockStateCubeAll);

        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.COLORED_SMOOTH_STONE_SLAB.entrySet()) {
            String name = entry.getKey();
            String textureBlock = name.replace("_slab", "");
            ResourceLocation topBottom = modLoc("block/" + textureBlock);
            ResourceLocation side = modLoc("block/" + name + "_side");
            SlabBlock block = (SlabBlock) entry.getValue().get();

            ModelFile bottomModel = models().slab(name, side, topBottom, topBottom);
            ModelFile topModel = models().slabTop(name + "_top", side, topBottom, topBottom);
            ModelFile doubleModel = models().cubeBottomTop(name + "_double", side, topBottom, topBottom);

            slabBlock(block, bottomModel, topModel, doubleModel);
            simpleBlockItem(block, bottomModel);
        }

        ModBlocks.COLORED_STONE_BRICKS.entrySet().forEach(this::generateBlockStateCubeAll);

        ModBlocks.COLORED_CRACKED_STONE_BRICKS.entrySet().forEach(this::generateBlockStateCubeAll);

        ModBlocks.COLORED_STONE_BRICK_STAIRS.entrySet()
                .forEach(entry -> generateBlockStateStairs(entry, "s"));

        ModBlocks.COLORED_STONE_BRICK_SLAB.entrySet()
                .forEach(entry -> generateBlockStateSlab(entry, "s"));

        ModBlocks.COLORED_STONE_BRICK_WALL.entrySet()
                .forEach(entry -> generateBlockStateWall(entry, "s"));

        ModBlocks.COLORED_CHISELED_STONE_BRICKS.entrySet().forEach(this::generateBlockStateCubeAll);

        ModBlocks.COLORED_BRICKS.entrySet().forEach(this::generateBlockStateCubeAll);

        ModBlocks.COLORED_BRICK_STAIRS.entrySet()
                .forEach(entry -> generateBlockStateStairs(entry, "s"));

        ModBlocks.COLORED_BRICK_SLAB.entrySet()
                .forEach(entry -> generateBlockStateSlab(entry, "s"));

        ModBlocks.COLORED_BRICK_WALL.entrySet()
                .forEach(entry -> generateBlockStateWall(entry, "s"));
    }

    private void generateBlockStateCubeAll(Map.Entry<String, DeferredBlock<Block>> entry) {
        String name = entry.getKey();
        Block block = entry.getValue().get();

        simpleBlockWithItem(block, models().cubeAll(name, modLoc("block/" + name)));
    }

    private void generateBlockStateGrass(Map.Entry<String, DeferredBlock<Block>> entry) {
        String name = entry.getKey();
        Block block = entry.getValue().get();

        ModelFile model = models().cross(name, modLoc("block/" + name)).renderType("cutout");

        simpleBlock(block, model);

        itemModels().withExistingParent(name, mcLoc("item/generated")).texture("layer0", modLoc("block/" + name));
    }

    private void generateBlockStateTallGrass(Map.Entry<String, DeferredBlock<Block>> entry) {
        String name = entry.getKey();
        Block block = entry.getValue().get();

        ModelFile bottom = models().cross(name + "_bottom", modLoc("block/" + name + "_bottom")).renderType("cutout");
        ModelFile top = models().cross(name + "_top", modLoc("block/" + name + "_top")).renderType("cutout");

        getVariantBuilder(block).forAllStates(state -> {
            boolean isLower = state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.LOWER;

            return ConfiguredModel.builder().modelFile(isLower ? bottom : top).build();
        });

        itemModels().withExistingParent(name, mcLoc("item/generated")).texture("layer0", modLoc("block/" + name + "_top"));
    }

    private void generateBlockStateStairs(Map.Entry<String, DeferredBlock<Block>> entry, String replacementName) {
        String name = entry.getKey();
        String textureBlock = name.replace("_stairs", replacementName);
        StairBlock block = (StairBlock) entry.getValue().get();

        stairsBlock(block, modLoc("block/" + textureBlock));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + name)));
    }

    private void generateBlockStateSlab(Map.Entry<String, DeferredBlock<Block>> entry, String replacementName) {
        String name = entry.getKey();
        String textureBlock = name.replace("_slab", replacementName);
        SlabBlock block = (SlabBlock) entry.getValue().get();

        slabBlock(block, modLoc("block/" + textureBlock), modLoc("block/" + textureBlock));
        simpleBlockItem(block, models().getExistingFile(modLoc("block/" + name)));
    }

    private void generateBlockStatePressurePlate(Map.Entry<String, DeferredBlock<Block>> entry, String replacementName) {
        String name = entry.getKey();
        String textureBlock = name.replace("_pressure_plate", replacementName);
        PressurePlateBlock block = (PressurePlateBlock) entry.getValue().get();

        pressurePlateBlock(block, modLoc("block/" + textureBlock));
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(FafnirMod.MOD_ID + ":block/" + name));
    }

    private void generateBlockStateButton(Map.Entry<String, DeferredBlock<Block>> entry, String replacementName) {
        String name = entry.getKey();
        String textureBlock = name.replace("_button", replacementName);
        ButtonBlock block = (ButtonBlock) entry.getValue().get();

        buttonBlock(block, modLoc("block/" + textureBlock));
    }

    private void generateBlockStateWall(Map.Entry<String, DeferredBlock<Block>> entry, String replacementName) {
        String name = entry.getKey();
        String textureBlock = name.replace("_wall", replacementName);
        WallBlock block = (WallBlock) entry.getValue().get();

        wallBlock(block, modLoc("block/" + textureBlock));
        simpleBlockItem(block, models().wallInventory(name, modLoc("block/" + textureBlock)));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
