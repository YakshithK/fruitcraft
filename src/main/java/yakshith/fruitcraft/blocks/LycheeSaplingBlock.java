package yakshith.fruitcraft.blocks;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import yakshith.fruitcraft.world.gen.tree.FruitcraftTreeGrowers;

public class LycheeSaplingBlock extends SaplingBlock {
    public LycheeSaplingBlock(BlockBehaviour.Properties properties) {
        super(FruitcraftTreeGrowers.LYCHEE, properties);
    }
}
