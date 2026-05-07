package net.bri4nholl4nd.fafnirmod.worldgen.tree;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.block.ModBlocks;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.bri4nholl4nd.fafnirmod.worldgen.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModPlacedFeatures {
    public static final Map<String, ResourceKey<PlacedFeature>> COLORED_TREE_PLACED_KEYS = new LinkedHashMap<>();

    static {
        for (String color : ModColors.COLORS.keySet()) {
            registerColoredTreePlacedKey(color, "oak");
        }
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);

        for (Map.Entry<String, ResourceKey<PlacedFeature>> entry : ModPlacedFeatures.COLORED_TREE_PLACED_KEYS.entrySet()) {
            String color = entry.getKey().replace("_oak_tree_placed", "");

            register(context, entry.getValue(), configuredFeature.getOrThrow(ModConfiguredFeatures.COLORED_TREE_KEYS.get(color + "_oak_tree")),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.025f, 1),
                            ModBlocks.COLORED_OAK_SAPLING.get(color + "_oak_sapling").get()));
        }
    }

    private static void registerColoredTreePlacedKey(String color, String type) {
        String name = color + "_" + type + "_tree_placed";

        ResourceKey<PlacedFeature> key = registerKey(name);

        COLORED_TREE_PLACED_KEYS.put(name, key);
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(FafnirMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
