package com.teamcitrus.fruitsforagingandfarming.common.block;

import net.minecraft.block.WallBlock;

public class WallBase extends WallBlock {
    public WallBase(String name, Properties properties) {
        super(properties);
        setRegistryName(name);
    }
}
