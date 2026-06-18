package yakshith.fruitcraft.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import yakshith.fruitcraft.Fruitcraft;

import java.util.function.Function;

public class MangoBlocks {

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, name));
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(settings.setId(blockKey));

        if(shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    // MANGO LOG
    public static final Block MANGO_LOG = register(
            "mango_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F).ignitedByLava(),
            true
    );

    // MANGO LEAVES
    public static final Block MANGO_LEAVES = register(
            "mango_leaves",
            MangoLeavesBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(0.2F)
                    .noOcclusion()
                    .sound(SoundType.GRASS),
            true
    );

    // MANGO SAPLING
    public static final Block MANGO_SAPLING = register(
            "mango_sapling",
            MangoSaplingBlock::new,
            BlockBehaviour.Properties.of()
                    .noCollision()
                    .instabreak()
                    .randomTicks()
                    .sound(SoundType.GRASS),
            true
    );

    // MANGO PLANKS
    public static final Block MANGO_PLANKS = register(
            "mango_planks",
            Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)
                    .ignitedByLava(),
            true
    );

    // MANGO WOOD
    public static final Block MANGO_WOOD = register(
            "mango_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    // STRIPPED MANGO LOG
    public static final Block STRIPPED_MANGO_LOG = register(
            "stripped_mango_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    // MANGO STAIRS
    public static final Block MANGO_STAIRS = register(
            "mango_stairs",
            settings -> new StairBlock(
                    MANGO_PLANKS.defaultBlockState(),
                    settings
            ),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    // MANGO STAIRS
    public static final Block MANGO_SLAB = register(
            "mango_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    public static void initialize() {}
}
