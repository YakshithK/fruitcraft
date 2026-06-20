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

public class LycheeBlocks {

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

    // LYCHEE LOG
    public static final Block LYCHEE_LOG = register(
            "lychee_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0F).ignitedByLava(),
            true
    );

    // LYCHEE LEAVES
    public static final Block LYCHEE_LEAVES = register(
            "lychee_leaves",
            LycheeLeavesBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(0.2F)
                    .noOcclusion()
                    .sound(SoundType.GRASS),
            true
    );

    // LYCHEE SAPLING
    public static final Block LYCHEE_SAPLING = register(
            "lychee_sapling",
            LycheeSaplingBlock::new,
            BlockBehaviour.Properties.of()
                    .noCollision()
                    .instabreak()
                    .randomTicks()
                    .sound(SoundType.GRASS),
            true
    );

    // LYCHEE PLANKS
    public static final Block LYCHEE_PLANKS = register(
            "lychee_planks",
            Block::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F, 3.0F)
                    .ignitedByLava(),
            true
    );

    // LYCHEE WOOD
    public static final Block LYCHEE_WOOD = register(
            "lychee_wood",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    // STRIPPED LYCHEE LOG
    public static final Block STRIPPED_LYCHEE_LOG = register(
            "stripped_lychee_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    // LYCHEE STAIRS
    public static final Block LYCHEE_STAIRS = register(
            "lychee_stairs",
            settings -> new StairBlock(
                    LYCHEE_PLANKS.defaultBlockState(),
                    settings
            ),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    // LYCHEE STAIRS
    public static final Block LYCHEE_SLAB = register(
            "lychee_slab",
            SlabBlock::new,
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2.0F)
                    .ignitedByLava(),
            true
    );

    // LYCHEE FENCE
    public static final Block LYCHEE_FENCE = register(
            "lychee_fence",
            FenceBlock::new,
            BlockBehaviour.Properties.ofFullCopy(LYCHEE_PLANKS),
            true
    );

    // LYCHEE FENCE GATE
    public static final Block LYCHEE_FENCE_GATE = register(
            "lychee_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(LYCHEE_PLANKS),
            true
    );

    // LYCHEE DOOR
    public static final Block LYCHEE_DOOR = registerDoor(
            "lychee_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(LYCHEE_PLANKS).noOcclusion()
    );

    // LYCHEE TRAPDOOR
    public static final Block LYCHEE_TRAPDOOR = register(
            "lychee_trapdoor",
            settings -> new TrapDoorBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(LYCHEE_PLANKS).noOcclusion(),
            true
    );

    // LYCHEE BUTTON
    public static final Block LYCHEE_BUTTON = register(
            "lychee_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            BlockBehaviour.Properties.ofFullCopy(LYCHEE_PLANKS).noCollision(),
            true
    );

    // LYCHEE PRESSURE PLATE
    public static final Block LYCHEE_PRESSURE_PLATE = register(
            "lychee_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            BlockBehaviour.Properties.ofFullCopy(LYCHEE_PLANKS).noCollision(),
            true
    );

    public static void initialize() {}
}
