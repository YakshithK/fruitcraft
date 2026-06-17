package yakshith.fruitcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import yakshith.fruitcraft.world.gen.FruitcraftConfiguredFeatures;
import yakshith.fruitcraft.world.gen.FruitcraftPlacedFeatures;

public class FruitcraftDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(FruitcraftRecipeProvider::new);
        pack.addProvider(FruitcraftAdvancementProvider::new);
        pack.addProvider((output, lookup) -> new FabricDynamicRegistryProvider(output, lookup) {
            @Override
            protected void configure(HolderLookup.Provider registries, Entries entries) {
                entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE));
                entries.addAll(registries.lookupOrThrow(Registries.PLACED_FEATURE));
            }

            @Override
            public String getName() {
                return "Fruitcraft World Generation";
            }
        });
    }

    @Override
    public void buildRegistry(RegistrySetBuilder builder) {
        builder.add(Registries.CONFIGURED_FEATURE, FruitcraftConfiguredFeatures::bootstrap);
        builder.add(Registries.PLACED_FEATURE, FruitcraftPlacedFeatures::bootstrap);
    }
}
