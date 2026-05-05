package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.bri4nholl4nd.fafnirmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, FafnirMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (DeferredHolder<Block, ? extends Block> block : ModBlocks.BLOCKS.getEntries()) {
            add(block.get(), formatName(block.getId().getPath()));
        }

        for (DeferredHolder<Item, ? extends Item> item : ModItems.ITEMS.getEntries()) {
            if (item.get() instanceof BlockItem) continue;

            add(item.get(), formatName(item.getId().getPath()));
        }

        add("creativetab.fafnir.fafnir_mod_tab", "Fafnir Mod");
        add("creativetab.fafnir.more_colored_blocks_tab", "Fafnir Colored Blocks");
    }

    private String formatName(String name) {
        return Arrays.stream(name.split("_"))
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.joining(" "));
    }
}
