package net.bri4nholl4nd.fafnirmod.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModColors {
    public static final Map<String, Integer> COLORS = new LinkedHashMap<>();

    static {
        COLORS.put("red", 0xCC2A2A);
        COLORS.put("light_red", 0xD95A5A);
        COLORS.put("dark_red", 0x8E1F2F);

        COLORS.put("orange", 0xD97A2B);
        COLORS.put("yellow", 0xE0C23A);

        COLORS.put("green", 0x4CAF50);
        COLORS.put("light_green", 0x74B86A);
        COLORS.put("dark_green", 0x2F6B3F);
        COLORS.put("lime", 0x7FBF3F);

        COLORS.put("blue", 0x4A80FF);
        COLORS.put("light_blue", 0x6FAFE0);
        COLORS.put("dark_blue", 0x263F8F);
        COLORS.put("cyan", 0x3AAFA9);

        COLORS.put("purple", 0x8A4FCC);
        COLORS.put("light_purple", 0xA88AE0);
        COLORS.put("dark_purple", 0x5E3A9B);
        COLORS.put("magenta", 0xC04FA3);
        COLORS.put("pink", 0xE08AAE);

        COLORS.put("brown", 0x8B5A2B);
        COLORS.put("light_brown", 0xB8845A);
        COLORS.put("dark_brown", 0x5A3A24);

        COLORS.put("white", 0xEDEDED);
        COLORS.put("light_gray", 0xB8B8B8);
        COLORS.put("gray", 0x8A8A8A);
        COLORS.put("dark_gray", 0x333333);
        COLORS.put("black", 0x242424);
    }

    private ModColors() {}
}
