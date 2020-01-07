package com.teamcitrus.fruitsforagingandfarming.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;

public class BlockSplitCoconut extends FallingBlock {


    public static final DirectionProperty HORIZONTAL_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    private static final VoxelShape COCONUT_SHAPE = Block.makeCuboidShape(0, 0, 0, 8, 8, 8).withOffset(0.25, 0, 0.25);

    public BlockSplitCoconut() {
        super(Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 0).variableOpacity());
        setRegistryName("split_coconut");
        setDefaultState(this.getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH));

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return COCONUT_SHAPE;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {

        if (context.getPlacementHorizontalFacing() == Direction.NORTH || context.getPlacementHorizontalFacing() == Direction.SOUTH) {

            return this.getDefaultState().with(HORIZONTAL_FACING, Direction.NORTH);


        }

        return this.getDefaultState().with(HORIZONTAL_FACING, Direction.WEST);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return func_220055_a(worldIn, pos.down(), Direction.UP);
    }
}
