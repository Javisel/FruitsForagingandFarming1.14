package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.teamcitrus.fruitsforagingandfarming.common.block.CakeBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ItemCakeBlock extends ItemBlockBase {

    public  int getFoodlevel() {
        return foodlevel;
    }

    public  float getSaturation() {
        return saturation;
    }

     int foodlevel;
     float saturation;

    public ItemCakeBlock(CakeBase blockIn) {
        super(blockIn, new Item.Properties().maxStackSize(1));
        foodlevel=blockIn.getFoodheal();
        saturation=blockIn.getSaturation();
    }


}
