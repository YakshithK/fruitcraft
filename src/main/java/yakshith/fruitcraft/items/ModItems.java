package yakshith.fruitcraft.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import yakshith.fruitcraft.Fruitcraft;
import yakshith.fruitcraft.blocks.ModBlocks;

import java.util.function.Function;

public class ModItems {
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    // MANGO
    public static final Consumable MANGO_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 6 * 20, 1), 1.0f))
            .build();

    public static final FoodProperties MANGO_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(0.6f)
            .alwaysEdible()
            .build();

    public static final Item MANGO = register(
            "mango",
            Item::new,
            new Item.Properties().food(MANGO_COMPONENT, MANGO_CONSUMABLE)
    );

    // MANGO SEEDS
    public static final Item MANGO_SEEDS = register(
            "mango_seeds",
            props -> new BlockItem(
                    ModBlocks.MANGO_CROP,
                    props
            ),
            new Item.Properties()
    );

    // DRIED MANGO
    public static final Item DRIED_MANGO = register(
            "dried_mango",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())
    );

    // CHERRY
    public static final Consumable CHERRY_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 6 * 20, 1), 1.0f))
            .build();

    public static final FoodProperties CHERRY_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(3)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .build();

    public static final Item CHERRY = register(
            "cherry",
            Item::new,
            new Item.Properties().food(CHERRY_COMPONENT, CHERRY_CONSUMABLE)
    );

    // CHERRY SEEDS
    public static final Item CHERRY_SEEDS = register(
            "cherry_seeds",
            props -> new BlockItem(
                    ModBlocks.CHERRY_CROP,
                    props
            ),
            new Item.Properties()
    );

    // GRAPES
    public static final Consumable GRAPE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 6 * 20, 1), 1.0f))
            .build();

    public static final FoodProperties GRAPE_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(3)
            .saturationModifier(0.4f)
            .alwaysEdible()
            .build();

    public static final Item GRAPES = register(
            "grapes",
            Item::new,
            new Item.Properties().food(GRAPE_COMPONENT, GRAPE_CONSUMABLE)
    );

    // GRAPE SEEDS
    public static final Item GRAPE_SEEDS = register(
            "grape_seeds",
            props -> new BlockItem(
                    ModBlocks.GRAPE_CROP,
                    props
            ),
            new Item.Properties()
    );

    // LYCHEE
    public static final Consumable LYCHEE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 6 * 20, 1), 1.0f))
            .build();

    public static final FoodProperties LYCHEE_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .build();

    public static final Item LYCHEE = register(
            "lychee",
            Item::new,
            new Item.Properties().food(LYCHEE_COMPONENT, LYCHEE_CONSUMABLE)
    );

    // LYCHEE SEEDS
    public static final Item LYCHEE_SEEDS = register(
            "lychee_seeds",
            props -> new BlockItem(
                    ModBlocks.LYCHEE_CROP,
                    props
            ),
            new Item.Properties()
    );

    // DRAGONFRUIT
    public static final Consumable DRAGONFRUIT_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 6 * 20, 1), 1.0f))
            .build();

    public static final FoodProperties DRAGONFRUIT_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(6)
            .saturationModifier(0.75f)
            .alwaysEdible()
            .build();

    public static final Item DRAGONFRUIT = register(
            "dragonfruit",
            Item::new,
            new Item.Properties().food(DRAGONFRUIT_COMPONENT, DRAGONFRUIT_CONSUMABLE)
    );

    // DRAGONFRUIT SEEDS
    public static final Item DRAGONFRUIT_SEEDS = register(
            "dragonfruit_seeds",
            props -> new BlockItem(
                    ModBlocks.DRAGONFRUIT_CROP,
                    props
            ),
            new Item.Properties()
    );

    public static final Item FRUIT_SALAD = register(
            "fruit_salad",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())
    );

    public static void initialize() {
    }
}