package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;

public class SeedBase extends BlockNamedItem {
    public SeedBase(String name, Block blockIn, Properties builder) {
        super(blockIn, builder.group(FruitsForagingAndFarming.itemGroup));
        setRegistryName(FruitsForagingAndFarming.MODID,name);
    }






}
