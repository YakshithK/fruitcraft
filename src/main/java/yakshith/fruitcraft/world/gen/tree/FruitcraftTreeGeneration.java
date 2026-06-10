package yakshith.fruitcraft.world.gen.tree;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;
import yakshith.fruitcraft.world.gen.FruitcraftPlacedFeatures;

public class FruitcraftTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                FruitcraftPlacedFeatures.MANGO_TREE_PLACED_KEY
        );
    }
}
