package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

import java.util.function.Supplier;

public class StairsBase extends StairsBlock {
    public StairsBase(String name, BlockState block, Properties properties) {
        super(new Supplier<BlockState>() {
            @Override
            public BlockState get() {
                 return block;
            }
        }, properties);
        setRegistryName(FruitsForagingAndFarming.MODID, name);
    }
}
