package yakshith.fruitcraft.world.gen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import yakshith.fruitcraft.world.gen.FruitcraftConfiguredFeatures;

import java.util.Optional;

public class FruitcraftTreeGrowers {
    public static final TreeGrower MANGO = new TreeGrower(
            "mango",
            Optional.empty(),
            Optional.of(FruitcraftConfiguredFeatures.MANGO_TREE_KEY),
            Optional.empty()
    );

    public static void initialize() {}
}
