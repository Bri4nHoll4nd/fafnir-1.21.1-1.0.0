package net.bri4nholl4nd.fafnirmod.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModColors {
    public static final Map<String, Integer> COLORS = new LinkedHashMap<>();

    static {
        COLORS.put("red", 0xCC2A2A);
        COLORS.put("green", 0x4CAF50);
        COLORS.put("blue", 0x4A80FF);
    }

    private ModColors() {}
}
