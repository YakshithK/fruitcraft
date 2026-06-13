package yakshith.fruitcraft.world.gen;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import yakshith.fruitcraft.items.ModItems;

public class ModLootTableModifiers {
    public static void initialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && Blocks.CHERRY_LEAVES.getLootTable().map(k -> k.equals(key)).orElse(false)) {
                tableBuilder.pool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.CHERRY))
                        .when(ExplosionCondition.survivesExplosion())
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .build()
                );
            }
        });
    }
}
