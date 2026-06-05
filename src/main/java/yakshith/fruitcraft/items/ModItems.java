package yakshith.fruitcraft.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import yakshith.fruitcraft.Fruitcraft;

public class ModItems {

    // MANGO
    public static final Identifier MANGO_ID = Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "mango");
    public static final ResourceKey<Item> MANGO_KEY = ResourceKey.create(Registries.ITEM, MANGO_ID);
    public static final Item MANGO = new Item(new Item.Properties().setId(MANGO_KEY)
            .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.6f).alwaysEdible().build()));

    // CHERRY
    public static final Identifier CHERRY_ID = Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "cherry");
    public static final ResourceKey<Item> CHERRY_KEY = ResourceKey.create(Registries.ITEM, CHERRY_ID);
    public static final Item CHERRY = new Item(new Item.Properties().setId(CHERRY_KEY)
            .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f).alwaysEdible().build()));

    // GRAPES
    public static final Identifier GRAPES_ID = Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "grapes");
    public static final ResourceKey<Item> GRAPES_KEY = ResourceKey.create(Registries.ITEM, GRAPES_ID);
    public static final Item GRAPES = new Item(new Item.Properties().setId(GRAPES_KEY)
            .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).alwaysEdible().build()));

    // LYCHEE
    public static final Identifier LYCHEE_ID = Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "lychee");
    public static final ResourceKey<Item> LYCHEE_KEY = ResourceKey.create(Registries.ITEM, LYCHEE_ID);
    public static final Item LYCHEE = new Item(new Item.Properties().setId(LYCHEE_KEY)
            .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible().build()));

    // DRAGONFRUIT

    public static final Consumable LEVITATION_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 6 * 20, 1), 1.0f))
            .build();

    public static final FoodProperties LEVITATION_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(6)
            .saturationModifier(0.75f)
            .alwaysEdible()
            .build();

    public static final Identifier DRAGONFRUIT_ID = Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, "dragonfruit");
    public static final ResourceKey<Item> DRAGONFRUIT_KEY = ResourceKey.create(Registries.ITEM, DRAGONFRUIT_ID);
    public static final Item DRAGONFRUIT = new Item(new Item.Properties().setId(DRAGONFRUIT_KEY)
            .food(LEVITATION_COMPONENT, LEVITATION_CONSUMABLE));

    public static void registerModItems() {
        Fruitcraft.LOGGER.info("Registering Mod Items for " + Fruitcraft.MOD_ID);

        Registry.register(BuiltInRegistries.ITEM, MANGO_KEY, MANGO);
        Registry.register(BuiltInRegistries.ITEM, CHERRY_KEY, CHERRY);
        Registry.register(BuiltInRegistries.ITEM, GRAPES_KEY, GRAPES);
        Registry.register(BuiltInRegistries.ITEM, LYCHEE_KEY, LYCHEE);
        Registry.register(BuiltInRegistries.ITEM, DRAGONFRUIT_KEY, DRAGONFRUIT);
    }
}