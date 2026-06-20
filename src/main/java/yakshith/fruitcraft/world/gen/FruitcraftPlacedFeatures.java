package yakshith.fruitcraft.world.gen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import yakshith.fruitcraft.Fruitcraft;

import java.lang.module.Configuration;
import java.util.List;

public class FruitcraftPlacedFeatures {

    public static final ResourceKey<PlacedFeature> MANGO_TREE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "mango_tree_placed")
            );

    public static final ResourceKey<PlacedFeature> LYCHEE_TREE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "lychee_tree_placed")
            );

    public static void bootstrap(net.minecraft.data.worldgen.BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                MANGO_TREE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(FruitcraftConfiguredFeatures.MANGO_TREE_KEY),
                        List.of(
                                RarityFilter.onAverageOnceEvery(2),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                BiomeFilter.biome()
                        )
                )
        );

        context.register(
                LYCHEE_TREE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(FruitcraftConfiguredFeatures.LYCHEE_TREE_KEY),
                        List.of(
                                RarityFilter.onAverageOnceEvery(4),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                                BiomeFilter.biome()
                        )
                )
        );

    }

    public static void initialize() {};
}