package yakshith.fruitcraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MangoLeavesBlock extends LeavesBlock {
    public static final MapCodec<MangoLeavesBlock> CODEC = simpleCodec(MangoLeavesBlock::new);

    public MangoLeavesBlock(BlockBehaviour.Properties properties) {
        super(0.0F, properties);
    }

    @Override
    public MapCodec<? extends  LeavesBlock> codec() {
        return CODEC;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random){}
}
