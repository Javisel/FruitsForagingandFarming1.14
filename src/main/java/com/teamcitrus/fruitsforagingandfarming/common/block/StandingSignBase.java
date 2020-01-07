package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.StandingSignBlock;

public class StandingSignBase extends StandingSignBlock {
    public StandingSignBase(String name, Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID, name);
    }
}
