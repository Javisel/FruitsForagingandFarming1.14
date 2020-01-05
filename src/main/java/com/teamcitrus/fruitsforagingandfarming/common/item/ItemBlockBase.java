package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ItemBlockBase extends BlockItem {

    public ItemBlockBase(Block blockIn, Properties builder) {
        super(blockIn, builder.group(FruitsForagingAndFarming.itemGroup));
        setRegistryName(blockIn.getRegistryName());

    }
}
