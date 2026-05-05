package net.bri4nholl4nd.fafnirmod.datagen;

import net.bri4nholl4nd.fafnirmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUE_PEARL.get(), 1)
                .requires(Items.ENDER_PEARL)
                .requires(Items.BLUE_DYE)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL)).save(recipeOutput);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUE_PEARL.get(), 1)
//                .requires(Items.ENDER_PEARL)
//                .requires(Items.BLUE_DYE)
//                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL)).save(recipeOutput, "templatemod:recipe_id");
    }
}
