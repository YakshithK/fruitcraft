package yakshith.fruitcraft.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import yakshith.fruitcraft.Fruitcraft;

import java.util.function.Function;

public class ModBlocks {

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

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Fruitcraft.MOD_ID, name));
    }

    // MANGO LOG
    public static final Block MANGO_LOG = register(
            "mango_log",
            props -> new
                    net.minecraft.world.level.block.RotatedPillarBlock(props),
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
            props -> new MangoSaplingBlock(props),
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
            props -> new net.minecraft.world.level.block.RotatedPillarBlock(props),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    public static final Block CHERRY_CROP = register(
            "cherry_crop",
            FruitCropBlock::new,
            BlockBehaviour.Properties.of()
                    .noCollision()
                    .instabreak()
                    .randomTicks()
                    .noOcclusion(),
            false
    );

    public static final Block GRAPE_CROP = register(
            "grape_crop",
            FruitCropBlock::new,
            BlockBehaviour.Properties.of()
                    .noCollision()
                    .instabreak()
                    .randomTicks()
                    .noOcclusion(),
            false
    );

    public static final Block LYCHEE_CROP = register(
            "lychee_crop",
            FruitCropBlock::new,
            BlockBehaviour.Properties.of()
                    .noCollision()
                    .instabreak()
                    .randomTicks()
                    .noOcclusion(),
            false
    );

    public static final Block DRAGONFRUIT_CROP = register(
            "dragonfruit_crop",
            FruitCropBlock::new,
            BlockBehaviour.Properties.of()
                    .noCollision()
                    .instabreak()
                    .randomTicks()
                    .noOcclusion(),
            false
    );

    public static void initialize() {

    }

}
