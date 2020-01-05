package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.FenceBlock;

public class FenceBlockBase extends FenceBlock {


    public FenceBlockBase(String name,Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID,name);
    }
}
