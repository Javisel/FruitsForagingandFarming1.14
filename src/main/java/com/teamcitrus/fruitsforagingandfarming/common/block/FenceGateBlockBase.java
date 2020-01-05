package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.FenceGateBlock;

public class FenceGateBlockBase extends FenceGateBlock {
    public FenceGateBlockBase(String name,Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID,name);
    }
}
