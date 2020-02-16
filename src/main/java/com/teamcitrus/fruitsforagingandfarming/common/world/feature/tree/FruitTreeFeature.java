package com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree;

import com.mojang.datafixers.Dynamic;
import com.teamcitrus.fruitsforagingandfarming.common.block.HangingFruit;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.JungleTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.JungleTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class FruitTreeFeature extends JungleTreeFeature {

    private static BlockState FRUIT;

    public FruitTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn, boolean doBlockNotifyIn, HangingFruit fruit, IPlantable sapling) {
        super(configIn, doBlockNotifyIn,7, Blocks.JUNGLE_LOG.getDefaultState(),Blocks.JUNGLE_LEAVES.getDefaultState(),true );
        setRegistryName(fruit.getRegistryName().getPath() + "_fruit_tree");
        setSapling(sapling);

        FRUIT = fruit.getStateWithMeta(2);
        System.out.println(this.getRegistryName().toString());
    }

    @Override
    public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox mutableBoundingBox) {


        if (super.place(changedBlocks, worldIn, rand, position, mutableBoundingBox)) {
            BlockPos top = position.up(7);
            for (int x = -5; x<5;x++) {
                for (int y = -5; y < 5; y++) {


                    for (int z = -5; z < 5; z++) {

                        if (isLeaves(worldIn, top.add(x, y, z)) && isAir(worldIn, top.add(x, y - 1, z)) && MathHelper.nextInt(rand, 0, 100) <= 30) {

                            this.setLogState(changedBlocks, worldIn, top.add(x, y - 1, z), FRUIT.with(HangingFruit.age, 2), mutableBoundingBox);


                        }


                    }
                }
            }


            return true;


        }

        return false;
    }
}





