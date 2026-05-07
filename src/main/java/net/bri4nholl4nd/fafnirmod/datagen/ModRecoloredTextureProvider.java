package net.bri4nholl4nd.fafnirmod.datagen;

import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import net.bri4nholl4nd.fafnirmod.FafnirMod;
import net.bri4nholl4nd.fafnirmod.util.ModColors;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class ModRecoloredTextureProvider implements DataProvider {
    private final PackOutput.PathProvider blockTextureOutput;
    private final PackOutput.PathProvider itemTextureOutput;

    public ModRecoloredTextureProvider(PackOutput packOutput) {
        this.blockTextureOutput = packOutput.createPathProvider(
                PackOutput.Target.RESOURCE_PACK,
                "textures/block"
        );

        this.itemTextureOutput = packOutput.createPathProvider(
                PackOutput.Target.RESOURCE_PACK,
                "textures/item"
        );
    }



    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        return CompletableFuture.runAsync(() -> {
            try {
                generateBlockTexture(cachedOutput, "oak_log");
                generateBlockTexture(cachedOutput, "oak_log_top");
                generateBlockTexture(cachedOutput, "oak_wood");
                generateBlockTexture(cachedOutput, "stripped_oak_log");
                generateBlockTexture(cachedOutput, "stripped_oak_log_top");
                generateBlockTexture(cachedOutput, "stripped_oak_wood");
                generateBlockTexture(cachedOutput, "oak_leaves");
                generateBlockTexture(cachedOutput, "oak_sapling");
                generateBlockTexture(cachedOutput, "oak_planks");
                generateBlockTexture(cachedOutput, "oak_door_bottom");
                generateBlockTexture(cachedOutput, "oak_door_top");
                generateBlockTexture(cachedOutput, "oak_trapdoor");
                generateBlockTexture(cachedOutput, "dirt");
                generateBlockTexture(cachedOutput, "grass_block_side");
                generateBlockTexture(cachedOutput, "grass_block_top");

                generateItemTexture(cachedOutput, "apple");
                generateItemTexture(cachedOutput, "oak_door");
            } catch (IOException e) {
                throw new RuntimeException("Failed to generate recolored textures", e);
            }
        });
    }

    private void generateBlockTexture(CachedOutput cache, String baseName) throws IOException {
        BufferedImage baseImage = loadBaseImage(
                "assets/" + FafnirMod.MOD_ID + "/textures/base/block/" + baseName + ".png"
        );

        for (var entry : ModColors.COLORS.entrySet()) {
            String colorName = entry.getKey();
            int color = entry.getValue();

            BufferedImage recoloredImage = recolor(baseImage, color);

            ResourceLocation textureId = ResourceLocation.fromNamespaceAndPath(
                    FafnirMod.MOD_ID,
                    colorName + "_" + baseName
            );

            Path outputPath = blockTextureOutput.file(textureId, "png");

            writeImage(cache, outputPath, recoloredImage);
        }
    }

    private void generateItemTexture(CachedOutput cache, String baseName) throws IOException {
        BufferedImage baseImage = loadBaseImage(
                "assets/" + FafnirMod.MOD_ID + "/textures/base/item/" + baseName + ".png"
        );

        for (var entry : ModColors.COLORS.entrySet()) {
            String colorName = entry.getKey();
            int color = entry.getValue();

            BufferedImage recoloredImage = recolor(baseImage, color);

            ResourceLocation textureId = ResourceLocation.fromNamespaceAndPath(
                    FafnirMod.MOD_ID,
                    colorName + "_" + baseName
            );

            Path outputPath = itemTextureOutput.file(textureId, "png");

            writeImage(cache, outputPath, recoloredImage);
        }
    }

    private BufferedImage loadBaseImage(String resourcePath) throws IOException {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (stream == null) {
                throw new IOException("Missing base texture: " + resourcePath);
            }

            BufferedImage image = ImageIO.read(stream);

            if (image == null) {
                throw new IOException("Could not read base texture as image: " + resourcePath);
            }

            return image;
        }
    }

    private BufferedImage recolor(BufferedImage input, int rgbColor) {
        int width = input.getWidth();
        int height = input.getHeight();

        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        int tintR = (rgbColor >> 16) & 0xFF;
        int tintG = (rgbColor >> 8) & 0xFF;
        int tintB = rgbColor & 0xFF;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int argb = input.getRGB(x, y);

                int a = (argb >> 24) & 0xFF;
                int r = (argb >> 16) & 0xFF;
                int g = (argb >> 8) & 0xFF;
                int b = argb & 0xFF;

                if (a == 0) {
                    output.setRGB(x, y, 0);
                    continue;
                }

                int newR = (r * tintR) / 255;
                int newG = (g * tintG) / 255;
                int newB = (b * tintB) / 255;

                int newArgb = (a << 24) | (newR << 16) | (newG << 8) | newB;
                output.setRGB(x, y, newArgb);
            }
        }

        return output;
    }

    private void writeImage(CachedOutput cache, Path path, BufferedImage image) throws IOException {
        Files.createDirectories(path.getParent());

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        HashingOutputStream hashingStream = new HashingOutputStream(
                Hashing.sha256(),
                byteStream
        );

        try (hashingStream) {
            ImageIO.write(image, "png", hashingStream);
        }

        cache.writeIfNeeded(path, byteStream.toByteArray(), hashingStream.hash());
    }

    @Override
    public String getName() {
        return "Recolored Textures";
    }
}
