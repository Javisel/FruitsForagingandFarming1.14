package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.util.math.shapes.ISelectionContext;

public class SeedBase extends BlockNamedItem {
    public SeedBase(String name, Block blockIn, Properties builder) {
        super(blockIn, builder.group(FruitsForagingAndFarming.itemGroup));
        setRegistryName(FruitsForagingAndFarming.MODID,name);
    }


@Override
protected boolean canPlace(BlockItemUseContext p_195944_1_, BlockState p_195944_2_) {
 return super.canPlace(p_195944_1_,p_195944_2_) && p_195944_1_.getWorld().getBlockState(p_195944_1_.getPos().down()).getBlock() ==Blocks.FARMLAND;
    }



}
