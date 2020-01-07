package com.teamcitrus.fruitsforagingandfarming.common.block;

import net.minecraft.block.DoorBlock;

public class DoorBase extends DoorBlock {
    public DoorBase(String name, Properties builder) {
        super(builder);
        setRegistryName(name);

    }
}
