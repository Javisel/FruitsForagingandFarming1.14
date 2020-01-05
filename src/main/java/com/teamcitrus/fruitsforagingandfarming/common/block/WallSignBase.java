package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.WallSignBlock;
import net.minecraftforge.client.model.generators.ModelBuilder;

public class WallSignBase extends WallSignBlock {

    public WallSignBase(String name,Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID,name);
    }
}
