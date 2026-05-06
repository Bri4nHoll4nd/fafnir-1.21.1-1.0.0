package net.bri4nholl4nd.fafnirmod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(FafnirMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
    }
}
