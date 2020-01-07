package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.RotatedPillarBlock;

public class RotatedPillarBlockBase extends RotatedPillarBlock {
    public RotatedPillarBlockBase(String name, Properties properties) {
        super(properties);

        setRegistryName(FruitsForagingAndFarming.MODID, name);
    }
}
