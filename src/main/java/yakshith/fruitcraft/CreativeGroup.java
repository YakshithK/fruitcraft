package yakshith.fruitcraft;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.ItemStack;
import yakshith.fruitcraft.Fruitcraft;
import yakshith.fruitcraft.blocks.ModBlocks;
import yakshith.fruitcraft.items.ModItems;

public class CreativeGroup {

    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "tab1")
    );

    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.MANGO))
            .title(Component.translatable("Fruits"))
            .displayItems((params, output) -> {
                output.accept(ModItems.MANGO);
                output.accept(ModItems.MANGO_SEEDS);
                output.accept(ModItems.CHERRY);
                output.accept(ModItems.CHERRY_SEEDS);
                output.accept(ModItems.DRAGONFRUIT);
                output.accept(ModItems.DRAGONFRUIT_SEEDS);
                output.accept(ModItems.LYCHEE);
                output.accept(ModItems.LYCHEE_SEEDS);
                output.accept(ModItems.GRAPES);
                output.accept(ModItems.GRAPE_SEEDS);
            })
            .build();

    public static void registerModItemGroup() {
        Fruitcraft.LOGGER.info("Registering Create Tab");

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
    }
}