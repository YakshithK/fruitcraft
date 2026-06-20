package yakshith.fruitcraft.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class LycheeLeavesBlock extends LeavesBlock {
    public static final MapCodec<LycheeLeavesBlock> CODEC = simpleCodec(LycheeLeavesBlock::new);

    public LycheeLeavesBlock(BlockBehaviour.Properties properties) {
        super(0.0F, properties);
    }

    @Override
    public MapCodec<? extends  LeavesBlock> codec() {
        return CODEC;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random){}
}
