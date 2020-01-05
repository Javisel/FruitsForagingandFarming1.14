package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IExtensibleEnum;

public class SaplingBase extends SaplingBlock {
    public SaplingBase(String name,Tree p_i48337_1_, Properties properties) {
        super(p_i48337_1_, properties.doesNotBlockMovement().tickRandomly());
        setRegistryName(FruitsForagingAndFarming.MODID,name);

    }


}
