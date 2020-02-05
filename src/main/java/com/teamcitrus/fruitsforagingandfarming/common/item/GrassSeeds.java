package com.teamcitrus.fruitsforagingandfarming.common.item;

import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;

public class GrassSeeds  extends ItemBase{



    public GrassSeeds() {
        super("grass_seeds", new Item.Properties());
    }


    /**
     * Called when this item is used when targetting a Block
     *
     * @param useContext
     */
    @Override
    public ActionResultType onItemUse(ItemUseContext useContext) {


        if (useContext.getPlayer().canPlayerEdit(useContext.getPos(),useContext.getFace(),useContext.getItem())) {



            if (useContext.getWorld().getBlockState(useContext.getPos()).getBlock()== Blocks.DIRT) {

                useContext.getWorld().setBlockState(useContext.getPos(),Blocks.GRASS_BLOCK.getDefaultState());

                return ActionResultType.SUCCESS;

            }
            else if (useContext.getWorld().getBlockState(useContext.getPos()).getBlock()== Blocks.GRASS_BLOCK) {

                useContext.getWorld().setBlockState(useContext.getPos().up(),Blocks.GRASS.getDefaultState());

                return ActionResultType.SUCCESS;

            }
            else if (useContext.getWorld().getBlockState(useContext.getPos()).getBlock()== Blocks.GRASS) {

                useContext.getWorld().setBlockState(useContext.getPos(),Blocks.TALL_GRASS.getDefaultState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
                useContext.getWorld().setBlockState(useContext.getPos().up(),Blocks.TALL_GRASS.getDefaultState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER));

                return ActionResultType.SUCCESS;

            }
        }



            return ActionResultType.FAIL;
    }
}
