package com.teamcitrus.fruitsforagingandfarming.common;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FruitsForagingAndFarmingItemGroup extends ItemGroup {
    public FruitsForagingAndFarmingItemGroup() {
        super(FruitsForagingAndFarming.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.PUMPKIN_SEEDS);
    }
}
