package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

import java.util.function.Supplier;

public class StairsBase extends StairsBlock {
    public StairsBase(String name, Supplier<BlockState> state, Properties properties) {
        super(state, properties);
        setRegistryName(FruitsForagingAndFarming.MODID, name);
    }
}
