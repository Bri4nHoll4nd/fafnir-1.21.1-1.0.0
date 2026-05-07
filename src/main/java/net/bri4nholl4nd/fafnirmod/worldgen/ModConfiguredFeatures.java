package net.bri4nholl4nd.fafnirmod.worldgen;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModConfiguredFeatures {
    public static final Map<String, ResourceKey<ConfiguredFeature<?, ?>>> COLORED_TREE_KEYS = new LinkedHashMap<>();

    static {
        for (String color : ModColors.COLORS.keySet()) {
            registerColoredTreeKey(color, "oak");
        }
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        for (Map.Entry<String, ResourceKey<ConfiguredFeature<?, ?>>> entry : ModConfiguredFeatures.COLORED_TREE_KEYS.entrySet()) {
            String color = entry.getKey().replace("_oak_tree", "");

            register(context, entry.getValue(), Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.COLORED_OAK_LOGS.get(color + "_oak_log").get()),
                    new StraightTrunkPlacer(3, 2, 0),
                    BlockStateProvider.simple(ModBlocks.COLORED_OAK_LEAVES.get(color + "_oak_leaves").get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)).build());
        }
    }

    private static void registerColoredTreeKey(String color, String type) {
        String name = color + "_" + type + "_tree";

        ResourceKey<ConfiguredFeature<?, ?>> key = registerKey(name);

        COLORED_TREE_KEYS.put(name, key);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(FafnirMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
