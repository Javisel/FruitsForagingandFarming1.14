package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration.HONEYMELON_ATTACHED_STEM;

public class HoneymelonBlock extends StemGrownBlock {

    public static final IntegerProperty ROTATION = IntegerProperty.create("rotation", 0, 4);

    private static final VoxelShape[] HONEY_MELONAABB = {

            //STANDING
          Block.makeCuboidShape(0,0,0,12,12,12).withOffset(0.125,0,0.125),
            Block.makeCuboidShape(0,0,0,12,12,12).withOffset(0.125,0,0.25),
            Block.makeCuboidShape(0,0,0,12,12,12).withOffset(0,0,.125),
            Block.makeCuboidShape(0,0,0,12,12,12).withOffset(.125,0,0),
            Block.makeCuboidShape(0,0,0,12,12,12).withOffset(.25,0,.125)






            //

    };

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {

        return HONEY_MELONAABB[p_220053_1_.get(ROTATION)];
    }

    public HoneymelonBlock() {
        super(Block.Properties.create(Material.PLANTS).hardnessAndResistance(3).sound(SoundType.PLANT));
        this.setDefaultState(this.getDefaultState().with(ROTATION, 0));
            setRegistryName(FruitsForagingAndFarming.MODID,"honeymelon_block");


    }



    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ROTATION);
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {

        Direction facing = p_196258_1_.getFace();
        if (facing == Direction.DOWN || facing == Direction.UP) {
            return withType(0);
        } else if (facing == Direction.NORTH) {
            return withType(1);
        } else if (facing == Direction.EAST) {
            return withType(2);
        } else if (facing == Direction.SOUTH) {
            return withType(3);
        } else if (facing == Direction.WEST) {
            return withType(4);
        } else {
            return withType(0);
        }

    }

    public BlockState byDirection(Direction direction) {

        if (direction == Direction.DOWN || direction == Direction.UP) {
            return withType(0);
        } else if (direction == Direction.NORTH) {
            return withType(1);
        } else if (direction == Direction.EAST) {
            return withType(2);
        } else if (direction == Direction.SOUTH) {
            return withType(3);
        } else if (direction == Direction.WEST) {
            return withType(4);
        } else {
            return withType(0);
        }



    }


    public BlockState withType(int type) {
        return this.getDefaultState().with(ROTATION, type);
    }


    @Override
    public StemBlock getStem() {
        return (StemBlock) BlockRegistration.HONEYMELON_STEM;
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) HONEYMELON_ATTACHED_STEM;
    }
}
