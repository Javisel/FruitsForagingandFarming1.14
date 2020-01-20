package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String name, Properties properties) {
        super(properties.group(FruitsForagingAndFarming.itemGroup));
        setRegistryName(name);
    }
}
