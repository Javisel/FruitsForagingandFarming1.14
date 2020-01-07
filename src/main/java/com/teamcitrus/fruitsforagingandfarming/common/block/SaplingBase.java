package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;

public class SaplingBase extends SaplingBlock {
    public SaplingBase(String name, Tree p_i48337_1_, Properties properties) {
        super(p_i48337_1_, properties.doesNotBlockMovement().tickRandomly());
        setRegistryName(FruitsForagingAndFarming.MODID, name);

    }


}
