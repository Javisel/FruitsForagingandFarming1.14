package com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree;

import com.mojang.datafixers.Dynamic;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class PalmTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {
    private static final BlockState LOG = BlockRegistration.PALM_LOG.getDefaultState();
    private static final BlockState LEAF = BlockRegistration.PALM_LEAVES.getDefaultState();

    public PalmTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn) {
        super(configIn, doBlockNotifyIn);
        setRegistryName("palm_tree");
    }

    @Override
    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox mutableBoundingBox) {


        if (MathHelper.nextInt(rand, 0, 100) >= 50) {
            place2(changedBlocks, worldIn, rand, position, mutableBoundingBox);
        } else {

            for (int i = 0; i < 8; i++) {


                this.setLogState(changedBlocks, worldIn, position.up(i), LOG, mutableBoundingBox);
                if (i == 7) {

                    this.setLogState(changedBlocks, worldIn, position.up(i), LEAF, mutableBoundingBox);


                }
            }

            BlockPos top = position.up(7);

            treeCanopy(changedBlocks, worldIn, rand, top, mutableBoundingBox);
        }
        return true;


    }


    public boolean place2(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox mutableBoundingBox) {


        for (int i = 0; i < 3; i++) {


            this.setLogState(changedBlocks, worldIn, position.up(i), LOG, mutableBoundingBox);

        }

        position = position.up(3);
        Direction newdirection = Direction.random(rand);
        while (newdirection == Direction.UP || newdirection == Direction.DOWN) {
            newdirection = Direction.random(rand);
        }

        position = position.offset(newdirection);
        for (int i = 0; i < 3; i++) {


            this.setLogState(changedBlocks, worldIn, position.up(i), LOG, mutableBoundingBox);

        }
        position = position.offset(newdirection);
        position = position.up(3);
        this.setLogState(changedBlocks, worldIn, position, LOG, mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, position.up(), LEAF, mutableBoundingBox);
        position = position.up();
        treeCanopy(changedBlocks, worldIn, rand, position, mutableBoundingBox);
        return true;


    }

    public void treeCanopy(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox mutableBoundingBox) {

        for (int x1 = -1; x1 < 2; x1++) {

            for (int z1 = -1; z1 < 2; z1++) {

                this.setLogState(changedBlocks, worldIn, position.add(x1, 0, z1), LEAF, mutableBoundingBox);


            }

        }

        this.setLogState(changedBlocks, worldIn, position.north(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.north(3).down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.north(4).down(2), LEAF, mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, position.south(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south(3).down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south(4).down(2), LEAF, mutableBoundingBox);


        this.setLogState(changedBlocks, worldIn, position.east(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.east(3).down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.east(4).down(2), LEAF, mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, position.west(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.west(3).down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.west(4).down(2), LEAF, mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, position.east(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.east(3).down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.east(4).down(2), LEAF, mutableBoundingBox);


        this.setLogState(changedBlocks, worldIn, position.north(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.north(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.north(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.north(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, position.south(2).east(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south(3).east(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south(2).west(2).down(), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south(3).west(3).down(2), BlockRegistration.PALM_LEAVES.getDefaultState(), mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, position.north().down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.east().down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south().down(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.west().down(), LEAF, mutableBoundingBox);


        this.setLogState(changedBlocks, worldIn, position.north().down(2).east(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.north().down(2).west(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south().down(2).east(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, position.south().down(2).west(), LEAF, mutableBoundingBox);


        for (int x = -4; x <= 4; x++) {
            for (int y = -2; y < 2; y++) {

                for (int z = -4; z <= 4; z++) {
                    if (worldIn.hasBlockState(position.add(x, y, z), Predicate.isEqual(BlockRegistration.PALM_LEAVES.getDefaultState())) && worldIn.hasBlockState(position.add(x, y - 1, z), BlockState::isAir)) {

                        if (MathHelper.nextInt(rand, 0, 100) <= 20) {
                            this.setLogState(changedBlocks, worldIn, position.add(x, y - 1, z), BlockRegistration.COCONUT.getStateWithMeta(MathHelper.nextInt(rand, 0, 2)), mutableBoundingBox);
                        }
                    }

                }
            }


        }


    }

}

