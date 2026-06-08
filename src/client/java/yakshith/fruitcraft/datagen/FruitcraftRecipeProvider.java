package yakshith.fruitcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import yakshith.fruitcraft.items.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FruitcraftRecipeProvider extends FabricRecipeProvider {
    public FruitcraftRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                // Mango -> Dried Mango furnace recipe
                oreSmelting(
                        List.of(ModItems.MANGO),          // inputs
                        RecipeCategory.FOOD,              // category in the recipe book
                        ModItems.DRIED_MANGO,   // output (or ModItems.DRIED_MANGO)
                        0.35f,                            // exp
                        200,                              // cook time in ticks (10 sec)
                        "mango_drying"                    // group id
                );
            }
        };
    }

    @Override
    public String getName() {
        return "FruitcraftRecipeProvider";
    }
}
