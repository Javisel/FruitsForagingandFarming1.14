package com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree;

import com.mojang.datafixers.Dynamic;
import com.teamcitrus.fruitsforagingandfarming.common.block.HangingFruit;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class FruitTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {
    private static final BlockState LOG = BlockRegistration.PALM_LOG.getDefaultState();
    private static final BlockState LEAF = BlockRegistration.PALM_LEAVES.getDefaultState();
    private static BlockState FRUIT;

    public FruitTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn, HangingFruit fruit) {
        super(configIn, doBlockNotifyIn);
        setRegistryName(fruit.getRegistryName().getPath() + "_fruit_tree");
        FRUIT = fruit.getStateWithMeta(2);
        System.out.println(this.getRegistryName().toString());
    }

    @Override
    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox mutableBoundingBox) {


        for (int i = 0; i < 6; i++) {


            this.setLogState(changedBlocks, worldIn, position.up(i), LOG, mutableBoundingBox);
            if (i == 5) {

                this.setLogState(changedBlocks, worldIn, position.up(i), LEAF, mutableBoundingBox);


            }
        }

        BlockPos top = position.up(5);

        for (int x = -1; x < 2; x++) {

            this.setLogState(changedBlocks, worldIn, top.add(x, 0, 0), LEAF, mutableBoundingBox);


        }

        for (int z = -1; z < 2; z++) {

            this.setLogState(changedBlocks, worldIn, top.add(0, 0, z), LEAF, mutableBoundingBox);


        }

        top = top.down();
        this.setLogState(changedBlocks, worldIn, top.north().east(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.south().east(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.north().west(), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.south().west(), LEAF, mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, top.north(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.east(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.south(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.west(2), LEAF, mutableBoundingBox);


        top = top.down();
        this.setLogState(changedBlocks, worldIn, top.north(3), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.east(3), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.south(3), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.west(3), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.north(2).east(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.north(2).west(2), LEAF, mutableBoundingBox);

        this.setLogState(changedBlocks, worldIn, top.south(2).east(2), LEAF, mutableBoundingBox);
        this.setLogState(changedBlocks, worldIn, top.south(2).west(2), LEAF, mutableBoundingBox);


            for (int x =-5; x <5; x++) {

                for (int y =-5; y <5; y++) {


                    for (int z = -5; z < 5; z++) {

                        if (isLeaves(worldIn, top.add(x, y, z)) && isAir(worldIn,top.add(x,y-1,z)) && MathHelper.nextInt(rand,0,100) <=30) {

                            this.setLogState(changedBlocks,worldIn,top.add(x,y-1,z),FRUIT.with(HangingFruit.age,2),mutableBoundingBox);



                        }


                    }
                }
            }




        return true;


    }


}

