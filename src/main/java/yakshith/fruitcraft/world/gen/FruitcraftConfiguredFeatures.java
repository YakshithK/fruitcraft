package yakshith.fruitcraft.world.gen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import yakshith.fruitcraft.Fruitcraft;
import yakshith.fruitcraft.blocks.LycheeBlocks;
import yakshith.fruitcraft.blocks.MangoBlocks;
import yakshith.fruitcraft.blocks.ModBlocks;

public class FruitcraftConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature< ?, ?>> MANGO_TREE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "mango_tree"));
    public static final ResourceKey<ConfiguredFeature< ?, ?>> LYCHEE_TREE_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "lychee_tree"));

    public static void bootstrap(net.minecraft.data.worldgen.BootstrapContext <ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        TreeConfiguration mangoTreeConfig = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(MangoBlocks.MANGO_LOG.defaultBlockState()),
                new StraightTrunkPlacer(5, 2, 0), //base height, random height, extra
                BlockStateProvider.simple(MangoBlocks.MANGO_LEAVES.defaultBlockState()),
                new BlobFoliagePlacer(ConstantInt.of(2),
                        ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
                ).build();

        TreeConfiguration lycheeTreeConfig = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(LycheeBlocks.LYCHEE_LOG.defaultBlockState()),
                new StraightTrunkPlacer(5, 2, 0), //base height, random height, extra
                BlockStateProvider.simple(LycheeBlocks.LYCHEE_LEAVES.defaultBlockState()),
                new BlobFoliagePlacer(ConstantInt.of(2),
                        ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).build();

        context.register(LYCHEE_TREE_KEY, new ConfiguredFeature<>(Feature.TREE, lycheeTreeConfig));
        context.register(MANGO_TREE_KEY, new ConfiguredFeature<>(Feature.TREE, mangoTreeConfig));
    }

    public static void initialize() {}
}
