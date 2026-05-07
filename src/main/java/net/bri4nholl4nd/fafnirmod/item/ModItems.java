package net.bri4nholl4nd.fafnirmod.item;

import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FafnirMod.MOD_ID);

    public static final Map<String, DeferredItem<Item>> COLORED_APPLES = new LinkedHashMap<>();

    static {
        for (String color : ModColors.COLORS.keySet()) {
            registerColoredApple(color);
        }
    }

    public static final DeferredItem<Item> BLUE_PEARL = ITEMS.register("blue_pearl",
            () -> new Item(new Item.Properties()));

    public static void registerColoredApple(String color) {
        String name = color + "_apple";

        DeferredItem<Item> item = ITEMS.register(name, () -> new Item(new Item.Properties().food(ModFoodProperties.APPLES)));

        COLORED_APPLES.put(name, item);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
