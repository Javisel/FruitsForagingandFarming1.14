package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class HoneymelonStem extends StemBlock implements IGrowable {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 4.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 8.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 10.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 12.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 14.0D, 9.0D), Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D)};
    private final StemGrownBlock crop;

    public HoneymelonStem() {
        super((StemGrownBlock) BlockRegistration.HONEYMELON_BLOCK,Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT));
        setRegistryName(FruitsForagingAndFarming.MODID,"honeymelon_stem");
        this.crop = (StemGrownBlock) BlockRegistration.HONEYMELON_BLOCK;
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, 0));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(AGE)];
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.FARMLAND;
    }

    protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.down();

        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState iblockstate = worldIn.getBlockState(blockpos.add(i, 0, j));

                if (iblockstate.getBlock().canSustainPlant(iblockstate, worldIn, blockpos.add(i, 0, j), net.minecraft.util.Direction.UP, (net.minecraftforge.common.IPlantable) blockIn)) {
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
    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightSubtracted(pos, 0) >= 9) {
            float f = getGrowthChance(this, worldIn, pos);
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                int i = state.get(AGE);
                if (i < 7) {
                    worldIn.setBlockState(pos, state.with(AGE, i + 1), 2);
                } else {
                    Direction direction = Direction.Plane.HORIZONTAL.random(random);
                    BlockPos blockpos = pos.offset(direction);
                    BlockState soil = worldIn.getBlockState(blockpos.down());
                    Block block = soil.getBlock();
                    Direction placement = direction;
                    HoneymelonBlock honeymelonBlock = (HoneymelonBlock) BlockRegistration.HONEYMELON_BLOCK;
                    if (worldIn.getBlockState(blockpos).isAir(worldIn, blockpos) && (soil.canSustainPlant(worldIn, blockpos.down(), Direction.UP, this) || block == Blocks.FARMLAND || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.GRASS_BLOCK)) {
                        worldIn.setBlockState(blockpos, honeymelonBlock.byDirection(placement));
                        worldIn.setBlockState(pos, this.crop.getAttachedStem().getDefaultState().with(HorizontalBlock.HORIZONTAL_FACING, direction));
                    }
                }
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
            }

        }
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    protected Item getSeedItem() {
        if (this.crop == Blocks.PUMPKIN) {
            return Items.PUMPKIN_SEEDS;
        } else {
            return this.crop == Blocks.MELON ? Items.MELON_SEEDS : null;
        }
    }

    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        Item item = this.getSeedItem();
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) != 7;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(7, state.get(AGE) + MathHelper.nextInt(worldIn.rand, 2, 5));
        BlockState blockstate = state.with(AGE, Integer.valueOf(i));
        worldIn.setBlockState(pos, blockstate, 2);
        if (i == 7) {
            blockstate.tick(worldIn, pos, worldIn.rand);
        }

    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public StemGrownBlock getCrop() {
        return this.crop;
    }

    //FORGE START
    @Override
    public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return net.minecraftforge.common.PlantType.Crop;
    }
}