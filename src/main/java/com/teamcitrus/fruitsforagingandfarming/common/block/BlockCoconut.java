package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BlockCoconut extends FallingBlock implements IGrowable {


    public static final IntegerProperty state = IntegerProperty.create("state", 0, 4);


    private static final VoxelShape[] COCONUT_SHAPE = {


            //STAGE 0 "Newborn"
            Block.makeCuboidShape(0, 0, 0, 4, 4, 4).withOffset(0.375, .75, 0.375),
            //Stage 1: Mid-Way
            Block.makeCuboidShape(0, 0, 0, 6, 6, 6).withOffset(0.3125, 0.625, 0.3125),
            //Stage 2 Adult, on Tree, Ready to Fall
            Block.makeCuboidShape(0, 0, 0, 8, 8, 8).withOffset(.25, .5, .25),
            //Stage 3 Adult, Placed. Will not fall.
            Block.makeCuboidShape(0, 0, 0, 8, 8, 8).withOffset(.25, .5, .25),

            //Stage 4, On Ground
            Block.makeCuboidShape(0, 0, 0, 8, 8, 8).withOffset(0.25, 0, 0.25)

    };

    public BlockCoconut() {
        super(Properties.create(Material.PLANTS).hardnessAndResistance(0.5F, 0).variableOpacity().tickRandomly());
        this.setRegistryName("coconut");

        this.setDefaultState(this.getDefaultState().with(state, 0));

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
                        f1 = 1.0F;


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

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(state);
    }

    protected IntegerProperty getStateProperty() {
        return state;
    }

    public int getState(BlockState state) {
        return state.get(BlockCoconut.state);
    }


    public int quantityDropped(Random random) {
        return 1;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getFace() == Direction.DOWN) {
            return this.getDefaultState().with(state, 3);
        } else {
            return this.getDefaultState().with(state, 4);
        }


    }


    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {

        return !isClient && getState(state) < 2;

    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return getState(state) < 2;

    }


    public BlockState getStateWithMeta(int meta) {


        return this.getDefaultState().with(state, meta);
    }


    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        if (!worldIn.isRemote) {
            int i = rand.nextInt(2);
            i += getState(state);
            int j = 2;

            if (i > j) {
                i = j;
            }

            worldIn.setBlockState(pos, getStateWithMeta(i), 2);
        }
    }


    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {

        checkFallable(worldIn, pos);

        if (!worldIn.isAreaLoaded(pos, 1) || worldIn.isRemote) {
            return;
        }
        int i = this.getState(state);
        if (canGrow(worldIn, pos, state, false)) {
            float f = getGrowthChance(worldIn, pos);

            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                worldIn.setBlockState(pos, this.getStateWithMeta(i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                i = getState(worldIn.getBlockState(pos));
            }


        }

        if (i >= 4 && worldIn.isAirBlock(pos.down())) {


            FallingBlockEntity entityfallingblock = new FallingBlockEntity(worldIn, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, this.getStateWithMeta(i));
            entityfallingblock.setHurtEntities(true);
            worldIn.addEntity(entityfallingblock);


        }


    }

    /**
     * Called when a tile entity on a side of this block changes is created or is destroyed.
     *
     * @param state
     * @param world    The world
     * @param pos      Block position in world
     * @param neighbor Block position of neighbor
     */
    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {

        if (!world.isRemote()) {
            checkFallable(world.getDimension().getWorld(), pos);
        }

    }

    private void checkFallable(World worldIn, BlockPos pos) {
        if (canFallThrough(worldIn.getBlockState(pos.down())) && !worldIn.getBlockState(pos.up()).isIn(BlockTags.LEAVES) && pos.getY() >= 0) {
            if (!worldIn.isRemote) {
                System.out.println(worldIn.getBlockState(pos.up()).getBlock().getTags().contains(BlockTags.LEAVES));
                if (this.getState(worldIn.getBlockState(pos)) < 2) {
                    worldIn.removeBlock(pos, false);
                } else {
                    FallingBlockEntity fallingblockentity = new FallingBlockEntity(worldIn, (double) pos.getX() + 0.5D, pos.getY(), (double) pos.getZ() + 0.5D, this.getStateWithMeta(4));
                    this.onStartFalling(fallingblockentity);
                    worldIn.addEntity(fallingblockentity);
                }
            }

        }
    }

    protected void onStartFalling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtEntities(true);

    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        {
            if (rand.nextInt(16) == 0) {
                BlockPos blockpos = pos.down();

                if (canFallThrough(worldIn.getBlockState(blockpos)) && getState(stateIn) == 2) {
                    double d0 = (float) pos.getX() + rand.nextFloat();
                    double d1 = (double) pos.getY() - 0.05D;
                    double d2 = (float) pos.getZ() + rand.nextFloat();
                    worldIn.addParticle(new BlockParticleData(ParticleTypes.FALLING_DUST, stateIn), d0, d1, d2, 0.0D, 0.0D, 0.0D);

                }
            }
        }

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return COCONUT_SHAPE[getState(state)];
    }


    @Override
    public void onEndFalling(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState) {
        {
            if (!worldIn.isRemote && worldIn.getBlockState(pos.down()).getBlock().getMaterial(worldIn.getBlockState(pos.down())) == Material.ROCK) {


                worldIn.destroyBlock(pos, false);

                ItemStack stack = new ItemStack(ItemRegistration.COCONUT_CHUNK, 4);
                ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
                worldIn.addEntity(itemEntity);

            }
        }


    }


}

