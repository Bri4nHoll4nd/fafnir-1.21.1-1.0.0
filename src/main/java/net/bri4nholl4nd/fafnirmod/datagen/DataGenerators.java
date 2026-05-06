package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class DataGenerators {
    public static void gatherData(GatherDataEvent dataEvent) {
        DataGenerator generator = dataEvent.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = dataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = dataEvent.getLookupProvider();

        generator.addProvider(dataEvent.includeClient(), new ModRecoloredTextureProvider(packOutput));

        String[] blockBases = {
                "oak_log",
                "oak_log_top",
                "oak_wood",
                "stripped_oak_log",
                "stripped_oak_log_top",
                "stripped_oak_wood",
                "oak_leaves",
                "oak_planks",
                "dirt"
        };

        for (String base : blockBases) {
            trackGeneratedTintedTextures(existingFileHelper, ModColors.COLORS, base, "block");
        }

        generator.addProvider(
                dataEvent.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                        List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new,
                                LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(dataEvent.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(dataEvent.includeServer(), blockTagsProvider);
        generator.addProvider(dataEvent.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(dataEvent.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(dataEvent.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(dataEvent.includeClient(), new ModLanguageProvider(packOutput));
    }

    private static void trackGeneratedTintedTextures(
            ExistingFileHelper existingFileHelper,
            Map<String, Integer> colors,
            String baseTexture,
            String type) {
        for (String color : colors.keySet()) {
            ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(
                    FafnirMod.MOD_ID,
                    type + "/" + color + "_" + baseTexture
            );

            existingFileHelper.trackGenerated(
                    loc,
                    PackType.CLIENT_RESOURCES,
                    ".png",
                    "textures"
            );
        }
    }
}
