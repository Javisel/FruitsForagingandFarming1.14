package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Random;
public class CornCropTop extends BushBlock implements IPlantable, IGrowable {

    public static final IntegerProperty age = IntegerProperty.create("age", 0, 2);
    private static final VoxelShape[] CORN_CROP_SHAPE = {


            //STAGE 0 "Newborn"
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 8, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 16, 16),


    };
    public CornCropTop() {
        super( Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement().tickRandomly());
        setRegistryName(FruitsForagingAndFarming.MODID,"corn_crop_top");
    }
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == BlockRegistration.CORN_CROP_BOTTOM;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return CORN_CROP_SHAPE[getAge(state)];
    }

    @Override
    public void neighborChanged(BlockState p_220069_1_, World p_220069_2_, BlockPos p_220069_3_, Block p_220069_4_, BlockPos p_220069_5_, boolean p_220069_6_) {
        super.neighborChanged(p_220069_1_, p_220069_2_, p_220069_3_, p_220069_4_, p_220069_5_, p_220069_6_);
        if (!isValidGround(p_220069_1_,p_220069_2_,p_220069_3_)){

            p_220069_2_.destroyBlock(p_220069_3_,false);

        }
    }

    public boolean isMaxAge(BlockState state){


        return state.get(age) >= this.getMaxAge();

    }





    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(age);
    }




    public int getAge(BlockState state) {
        return state.get(this.age);
    }






    /**
     * Whether this IGrowable can grow
     *
     * @param worldIn
     * @param pos
     * @param state
     * @param isClient
     */
    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return  worldIn.getBlockState(pos.up()).isAir(worldIn,pos.up()) &&  getAge(state) < 2;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return canGrow(worldIn,pos,state,worldIn.isRemote());
    }
    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.nextInt(worldIn.rand, 1, 4);
    }

    public int getMaxAge() {

        return  2;
    }
    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
        int k = 0;
        if (i > j) {
            k = i - j;
            i=j;

            //worldIn.setBlockState(pos.up(), BlockRegistration.CORN_CROP_TOP.withAge(k), 2);
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);

    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.Crop;
    }


    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.age, age);
    }

}
