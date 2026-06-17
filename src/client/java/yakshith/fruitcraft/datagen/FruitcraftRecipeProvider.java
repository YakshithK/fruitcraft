package yakshith.fruitcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import yakshith.fruitcraft.blocks.ModBlocks;
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

                oreBlasting(
                        List.of(ModItems.MANGO),
                        RecipeCategory.FOOD,
                        ModItems.DRIED_MANGO,
                        0.35f,
                        100,
                        "mango_drying"
                );

                shaped(RecipeCategory.FOOD, ModItems.FRUIT_SALAD)
                        .pattern("fmf")
                        .pattern("dad")
                        .pattern(" b ")
                        .define('f', ModItems.MANGO)
                        .define('m', ModItems.CHERRY)
                        .define('b', Items.BOWL)
                        .define('a', ModItems.LYCHEE)
                        .define('d', ModItems.DRAGONFRUIT)
                        .unlockedBy(getHasName(ModItems.MANGO), has(ModItems.MANGO))
                        .save(output);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGO_PLANKS.asItem(), 4)
                        .requires(ModBlocks.MANGO_LOG.asItem())
                        .group("planks")
                        .unlockedBy(getHasName(ModBlocks.MANGO_LOG.asItem()), has(ModBlocks.MANGO_LOG.asItem()))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGO_WOOD.asItem(), 3)
                        .pattern("LL")
                        .pattern("LL")
                        .define('L', ModBlocks.MANGO_LOG.asItem())
                        .group("bark")
                        .unlockedBy(getHasName(ModBlocks.MANGO_LOG.asItem()), has(ModBlocks.MANGO_LOG.asItem()))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "FruitcraftRecipeProvider";
    }
}
