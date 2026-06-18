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
import yakshith.fruitcraft.blocks.MangoBlocks;
import yakshith.fruitcraft.blocks.ModBlocks;
import yakshith.fruitcraft.items.MangoItems;
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
                        List.of(MangoItems.MANGO),          // inputs
                        RecipeCategory.FOOD,              // category in the recipe book
                        MangoItems.DRIED_MANGO,   // output (or ModItems.DRIED_MANGO)
                        0.35f,                            // exp
                        200,                              // cook time in ticks (10 sec)
                        "mango_drying"                    // group id
                );

                oreBlasting(
                        List.of(MangoItems.MANGO),
                        RecipeCategory.FOOD,
                        MangoItems.DRIED_MANGO,
                        0.35f,
                        100,
                        "mango_drying"
                );

                shaped(RecipeCategory.FOOD, ModItems.FRUIT_SALAD)
                        .pattern("fmf")
                        .pattern("dad")
                        .pattern(" b ")
                        .define('f', MangoItems.MANGO)
                        .define('m', ModItems.CHERRY)
                        .define('b', Items.BOWL)
                        .define('a', ModItems.LYCHEE)
                        .define('d', ModItems.DRAGONFRUIT)
                        .unlockedBy(getHasName(MangoItems.MANGO), has(MangoItems.MANGO))
                        .save(output);

                shapeless(RecipeCategory.BUILDING_BLOCKS, MangoBlocks.MANGO_PLANKS.asItem(), 4)
                        .requires(MangoBlocks.MANGO_LOG.asItem())
                        .group("planks")
                        .unlockedBy(getHasName(MangoBlocks.MANGO_LOG.asItem()), has(MangoBlocks.MANGO_LOG.asItem()))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, MangoBlocks.MANGO_WOOD.asItem(), 3)
                        .pattern("LL")
                        .pattern("LL")
                        .define('L', MangoBlocks.MANGO_LOG.asItem())
                        .group("bark")
                        .unlockedBy(getHasName(MangoBlocks.MANGO_LOG.asItem()), has(MangoBlocks.MANGO_LOG.asItem()))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, MangoBlocks.MANGO_STAIRS.asItem(), 3)
                        .pattern("P  ")
                        .pattern("PP ")
                        .pattern("PPP")
                        .define('P', MangoBlocks.MANGO_PLANKS.asItem())
                        .group("wooden_stairs")
                        .unlockedBy(getHasName(MangoBlocks.MANGO_PLANKS.asItem()), has(MangoBlocks.MANGO_PLANKS.asItem()))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, MangoBlocks.MANGO_SLAB.asItem(), 6)
                        .pattern("PPP")
                        .define('P', MangoBlocks.MANGO_PLANKS.asItem())
                        .group("wooden_slab")
                        .unlockedBy(getHasName(MangoBlocks.MANGO_PLANKS.asItem()), has(MangoBlocks.MANGO_PLANKS.asItem()))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "FruitcraftRecipeProvider";
    }
}
