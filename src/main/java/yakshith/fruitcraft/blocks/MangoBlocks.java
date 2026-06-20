package yakshith.fruitcraft.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    private static Block registerDoor(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        ResourceKey<Item> itemKey = keyOfItem(name);

        Block block = blockFactory.apply(settings.setId(blockKey));

        Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                new DoubleHighBlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix())
        );

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

    // MANGO FENCE
    public static final Block MANGO_FENCE = register(
            "mango_fence",
            FenceBlock::new,
            BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS),
            true
    );

    // MANGO FENCE GATE
    public static final Block MANGO_FENCE_GATE = register(
            "mango_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS),
            true
    );

    // MANGO DOOR
    public static final Block MANGO_DOOR = registerDoor(
            "mango_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS).noOcclusion()
    );

    // MANGO TRAPDOOR
    public static final Block MANGO_TRAPDOOR = registerDoor(
            "mango_trapdoor",
            settings -> new TrapDoorBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS).noOcclusion()
    );

    // MANGO BUTTON
    public static final Block MANGO_BUTTON = register(
            "mango_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS).noCollision(),
            true
    );

    // MANGO PRESSURE PLATE
    public static final Block MANGO_PRESSURE_PLATE = register(
            "mango_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(MANGO_PLANKS).noCollision(),
            true
    );

    public static void initialize() {}
}
