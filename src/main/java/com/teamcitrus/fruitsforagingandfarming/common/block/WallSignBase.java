package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.WallSignBlock;

public class WallSignBase extends WallSignBlock {

    public WallSignBase(String name, Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID, name);
    }
}
