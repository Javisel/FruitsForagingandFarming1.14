package com.teamcitrus.fruitsforagingandfarming.common.block;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;

public class LeavesBlockBase extends LeavesBlock {

    public LeavesBlockBase(String name, Properties properties) {
        super(properties.tickRandomly().sound(SoundType.PLANT));
        setRegistryName(name);
        this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(true)));

    }
}
