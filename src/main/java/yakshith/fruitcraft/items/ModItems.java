package yakshith.fruitcraft.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import yakshith.fruitcraft.Fruitcraft;

public class ModItems {

    // 1. Create the unique identifier for the mango (fruitcraft:mango)
    public static final Identifier MANGO_ID = Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "mango");

    // 2. Create the unique RegistryKey for the item
    public static final ResourceKey<Item> MANGO_KEY = ResourceKey.create(Registries.ITEM, MANGO_ID);

    // 3. Define and instantiate the item, passing the registryKey directly into Item.Properties
    public static final Item MANGO = new Item(new Item.Properties().setId(MANGO_KEY));

    public static void registerModItems() {
        Fruitcraft.LOGGER.info("Registering Mod Items for " + Fruitcraft.MOD_ID);

        // 4. Register the item using the RegistryKey and the instantiation
        Registry.register(BuiltInRegistries.ITEM, MANGO_KEY, MANGO);
    }
}