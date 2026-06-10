package yakshith.fruitcraft.blocks;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import yakshith.fruitcraft.world.gen.tree.FruitcraftTreeGrowers;

public class MangoSaplingBlock extends SaplingBlock {
    public MangoSaplingBlock(BlockBehaviour.Properties properties) {
        super(FruitcraftTreeGrowers.MANGO, properties);
    }
}
