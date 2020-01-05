package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.WoodButtonBlock;

public class ButtonBase extends WoodButtonBlock {
    public ButtonBase(String name, Properties properties) {
        super(properties);
        setRegistryName(FruitsForagingAndFarming.MODID,name);
    }
}
