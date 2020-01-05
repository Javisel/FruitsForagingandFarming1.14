package com.teamcitrus.fruitsforagingandfarming.common.block;


import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.Block;

public class BlockBase extends Block {
    public BlockBase(String name, Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID,name);
    }
}
