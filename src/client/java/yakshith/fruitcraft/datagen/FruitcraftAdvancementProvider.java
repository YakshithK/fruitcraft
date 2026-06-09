package yakshith.fruitcraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import yakshith.fruitcraft.Fruitcraft;
import yakshith.fruitcraft.items.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class FruitcraftAdvancementProvider extends FabricAdvancementProvider {
    protected FruitcraftAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider wrapperLookup, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder infinityBowl = Advancement.Builder.advancement()
                .display(
                        ModItems.FRUIT_SALAD, // The display icon
                        Component.literal("Infinity Bowl"), // The title
                        Component.literal("Snap your fingers and all fruits will cease to exist"), // The description
                        null, // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to cha
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .addCriterion("infinity_bowl", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FRUIT_SALAD))
                // Give the advancement an id
                .save(consumer, Fruitcraft.MOD_ID + ":infinity_bowl");
    }
}