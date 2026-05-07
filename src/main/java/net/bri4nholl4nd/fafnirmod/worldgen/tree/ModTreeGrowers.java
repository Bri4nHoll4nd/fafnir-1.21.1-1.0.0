package net.bri4nholl4nd.fafnirmod.worldgen.tree;

import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.bri4nholl4nd.fafnirmod.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ModTreeGrowers {
    public static final Map<String, TreeGrower> COLORED_OAK_GROWERS = new LinkedHashMap<>();

    static {
        for (String color : ModColors.COLORS.keySet()) {
            String treeName = color + "_oak_tree";

            ResourceKey<ConfiguredFeature<?, ?>> treeKey =
                    ModConfiguredFeatures.COLORED_TREE_KEYS.get(treeName);

            if (treeKey == null) {
                throw new IllegalStateException("Missing configured tree key: " + treeName
                        + ". Available keys: " + ModConfiguredFeatures.COLORED_TREE_KEYS.keySet());
            }

            COLORED_OAK_GROWERS.put(color, new TreeGrower(color + "_oak", Optional.empty(),
                    Optional.of(treeKey), Optional.empty()));
        }
    }
}
