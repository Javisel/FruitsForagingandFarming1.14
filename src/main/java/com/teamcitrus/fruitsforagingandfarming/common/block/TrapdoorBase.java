package com.teamcitrus.fruitsforagingandfarming.common.block;

import net.minecraft.block.TrapDoorBlock;

public class TrapdoorBase extends TrapDoorBlock {
    public TrapdoorBase(String name, Properties properties) {
        super(properties);
        setRegistryName(name);
    }
}
