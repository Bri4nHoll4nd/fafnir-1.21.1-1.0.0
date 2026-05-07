package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.bri4nholl4nd.fafnirmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FafnirMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLUE_PEARL.get());
        ModItems.COLORED_APPLES.values().forEach(this::simpleItem);
        ModBlocks.COLORED_OAK_SAPLING.values().forEach(this::saplingItem);
        ModBlocks.COLORED_OAK_DOORS.values().forEach(this::simpleBlockItem);
        ModBlocks.COLORED_OAK_BUTTONS.forEach((name, block) -> {
            String planks = name.replace("_button", "_planks");
            DeferredBlock<Block> planksBlock = ModBlocks.COLORED_OAK_PLANKS.get(planks);

            if (planksBlock == null) {
                throw new IllegalStateException("Missing plank block for button item: " + planks
                        + ". Available plank keys: " + ModBlocks.COLORED_OAK_PLANKS.keySet());
            }

            buttonItem(block, planksBlock);
        });
        ModBlocks.COLORED_STONE_BUTTON.forEach((name, block) -> {
            String stone = name.replace("_button", "");
            DeferredBlock<Block> stoneBlock = ModBlocks.COLORED_STONE.get(stone);

            if (stoneBlock == null) {
                throw new IllegalStateException("Missing stone block for button item: " + stone
                        + ". Available stone keys: " + ModBlocks.COLORED_STONE.keySet());
            }

            buttonItem(block, stoneBlock);
        });
    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item) {
        return withExistingParent(
                item.getId().getPath(),
                mcLoc("item/generated")
        ).texture("layer0", modLoc("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> block) {
        return withExistingParent(
                block.getId().getPath(),
                mcLoc("item/generated")
        ).texture("layer0", modLoc("block/" + block.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<? extends Block> block) {
        return withExistingParent(
                block.getId().getPath(),
                mcLoc("item/generated")
        ).texture("layer0", modLoc("item/" + block.getId().getPath()));
    }

    private void buttonItem(DeferredBlock<? extends Block> block, DeferredBlock<? extends Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", modLoc("block/" + baseBlock.getId().getPath()));
    }
}
