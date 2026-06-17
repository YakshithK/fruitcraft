package yakshith.fruitcraft.world.gen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import yakshith.fruitcraft.Fruitcraft;

import java.lang.module.Configuration;
import java.util.List;

public class FruitcraftPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MANGO_TREE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "mango_tree_placed")
            );
    public static void bootstrap(net.minecraft.data.worldgen.BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                MANGO_TREE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(FruitcraftConfiguredFeatures.MANGO_TREE_KEY),
                        List.of(
                                CountPlacement.of(1),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                BiomeFilter.biome()
                        )
                )
        );
    }

    public static void initialize() {};
}