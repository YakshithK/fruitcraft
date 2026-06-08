package yakshith.fruitcraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FruitCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);

    public static final int MAX_HEIGHT = 7;
    public static final IntegerProperty HEIGHT = IntegerProperty.create("height", 2, MAX_HEIGHT);

    public FruitCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0).setValue(HEIGHT, 2));
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int h = state.getValue(HEIGHT); // 2-7
        // 0–16 coordinates; this makes it h “pixels” tall
        return Block.box(0, 0, 0, 16, h, 16);
    }

    @Override
    public BlockState getStateForAge(int age){
        int height;
        switch (age){
            case 1 -> height = 5;
            case 2 -> height = 6;
            case 3 -> height = 7;
            default -> height = 2;
        }
        return this.defaultBlockState()
                .setValue(AGE, age)
                .setValue(HEIGHT, height);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, HEIGHT);
    }
}
