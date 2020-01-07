package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.SlabBlock;

public class SlabBase extends SlabBlock {
    public SlabBase(String name, Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID, name);
    }
}
