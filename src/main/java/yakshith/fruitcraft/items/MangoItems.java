package yakshith.fruitcraft.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import yakshith.fruitcraft.Fruitcraft;

import java.util.function.Function;

public class MangoItems {

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings){
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    // MANGO
    public static final Consumable MANGO_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 30 * 20, 1), 1.0f))
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

    // DRIED MANGO
    public static final Item DRIED_MANGO = register(
            "dried_mango",
            Item::new,
            new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())
    );

    public static void initialize() {}

}
