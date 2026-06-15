package yakshith.fruitcraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yakshith.fruitcraft.items.MangoItems;
import yakshith.fruitcraft.blocks.MangoBlocks;
import yakshith.fruitcraft.blocks.ModBlocks;
import yakshith.fruitcraft.items.ModItems;
import yakshith.fruitcraft.world.gen.FruitcraftConfiguredFeatures;
import yakshith.fruitcraft.world.gen.FruitcraftPlacedFeatures;
import yakshith.fruitcraft.world.ModLootTableModifiers;
import yakshith.fruitcraft.world.gen.tree.FruitcraftTreeGrowers;

public class Fruitcraft implements ModInitializer {
	public static final String MOD_ID = "fruitcraft";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();
		MangoItems.initialize();
		ModBlocks.initialize();
		MangoItems.initialize();
		StrippableBlockRegistry.register(MangoBlocks.MANGO_LOG, MangoBlocks.STRIPPED_MANGO_LOG);
		FruitcraftTreeGrowers.initialize();
		FruitcraftConfiguredFeatures.initialize();
		FruitcraftPlacedFeatures.initialize();

		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				FruitcraftPlacedFeatures.MANGO_TREE_PLACED_KEY
		);

		ModLootTableModifiers.initialize();

		CreativeGroup.registerModItemGroup();
	}
}