package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class HangingFruit extends BushBlock implements IGrowable {

    public static final IntegerProperty age = IntegerProperty.create("age", 0, 2);

    public HangingFruit(String name) {
        super(Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT));
        setRegistryName(FruitsForagingAndFarming.MODID, name);
        this.setDefaultState(this.getDefaultState().with(age, 0));

    }

    protected static float getGrowthChance(World worldIn, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.up();

        for (int x = -4; x <= 4; ++x) {
            for (int y = -4; y <= 0; y++) {
                for (int z = -4; z <= 4; ++z) {
                    float f1 = 0.0F;
                    BlockState iblockstate = worldIn.getBlockState(blockpos.add(x, y, z));

                    if (iblockstate.isIn(BlockTags.LEAVES)) {

                        f1 = 3.0F;
                    }


                    if (x != 0 || z != 0) {
                        f1 /= 4.0F;
                    }

                    f += f1;
                }
            }
        }


        return f;
    }

    public int getAge(BlockState state) {
        return state.get(age);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(age);
    }

    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {

        if (!world.isRemote() && !world.getBlockState(pos.up()).isIn(BlockTags.LEAVES)) {
            world.getDimension().getWorld().destroyBlock(pos, true);
        }

    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {


        return worldIn.getBlockState(pos.up()).isIn(BlockTags.LEAVES);
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
        return !isClient && getAge(state) < 2;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return canGrow(worldIn, pos, state, worldIn.isRemote);
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        if (!worldIn.isRemote) {
            int i = rand.nextInt(2);
            i += getAge(state);
            int j = 2;

            if (i > j) {
                i = j;
            }

            worldIn.setBlockState(pos, getStateWithMeta(i), 2);
        }
    }

    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {


        if (!worldIn.isAreaLoaded(pos, 1) || worldIn.isRemote) {
            return;
        }
        int i = this.getAge(state);
        if (canGrow(worldIn, pos, state, false)) {
            float f = getGrowthChance(worldIn, pos);

            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                worldIn.setBlockState(pos, this.getStateWithMeta(i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                i = getAge(worldIn.getBlockState(pos));
            }


        }


    }

    public BlockState getStateWithMeta(int meta) {


        return this.getDefaultState().with(age, meta);
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.Crop;
    }
}
