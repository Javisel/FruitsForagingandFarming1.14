package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class CornCropBottom extends BushBlock implements IGrowable {

    public static final IntegerProperty age = IntegerProperty.create("age", 0, 2);
    private static final VoxelShape[] CORN_CROP_SHAPE = {


            //STAGE 0 "Newborn"
            Block.makeCuboidShape(0, 0, 0, 16, 1, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 8, 16),
            Block.makeCuboidShape(0, 0, 0, 16, 16, 16),


    };
    public CornCropBottom() {
        super( Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement().tickRandomly());
        setRegistryName(FruitsForagingAndFarming.MODID,"corn_crop_bottom");
    }
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.FARMLAND;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return CORN_CROP_SHAPE[getAge(state)];
    }



    public boolean isMaxAge(BlockState state){


            return state.get(age) >= this.getMaxAge();

    }



    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {

        if (!worldIn.isAreaLoaded(pos, 1)) return;
        if (worldIn.getNeighborAwareLightSubtracted(pos.up(),0) >= 8) {
            int i = this.getAge(state);


            float f = getGrowthChance(this, worldIn, pos);

            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                if (isMaxAge(state)) {

                    if (worldIn.isAirBlock(pos.up())) {
                        worldIn.setBlockState(pos.up(), BlockRegistration.CORN_CROP_TOP.getDefaultState().with(CornCropTop.age,0));


                    }
                } else if (i< 2) {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                } else {

                }
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, worldIn.getBlockState(pos));
            }

        }



    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(age);
    }




    public int getAge(BlockState state) {
        return state.get(CornCropBottom.age);
    }




    protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.down();


        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState iblockstate = worldIn.getBlockState(blockpos.add(i, 0, j));

                if (iblockstate.getBlock().canSustainPlant(iblockstate, worldIn, blockpos.add(i, 0, j), Direction.UP, (net.minecraftforge.common.IPlantable) blockIn)) {
                    f1 = 1.0F;

                    if (iblockstate.getBlock().isFertile(iblockstate,worldIn, blockpos.add(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock() || blockIn == worldIn.getBlockState(blockpos4).getBlock();
        boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock() || blockIn == worldIn.getBlockState(blockpos2).getBlock();

        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();

            if (flag2) {
                f /= 2.0F;
            }
        }
        return f;
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

            worldIn.setBlockState(pos.up(), BlockRegistration.CORN_CROP_TOP.getDefaultState().with(CornCropTop.age,k), 2);
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
