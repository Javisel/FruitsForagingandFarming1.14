package com.teamcitrus.fruitsforagingandfarming.common.item;

import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String name,Properties properties) {
        super(properties);
        setRegistryName(name);
    }
}
