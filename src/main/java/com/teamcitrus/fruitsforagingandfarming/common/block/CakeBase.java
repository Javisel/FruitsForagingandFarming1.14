package com.teamcitrus.fruitsforagingandfarming.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class CakeBase extends CakeBlock {
    int foodheal;
    float saturation;

    public CakeBase(String name, int foodheal, float saturation) {
        super(Block.Properties.create(Material.CAKE).hardnessAndResistance(5).sound(SoundType.SLIME));
        setRegistryName(name);

        this.foodheal = foodheal;
        this.saturation = saturation;
    }

    public int getFoodheal() {
        return foodheal;
    }

    public float getSaturation() {
        return saturation;
    }



    @Override
    public boolean onBlockActivated(BlockState p_220051_1_, World p_220051_2_, BlockPos p_220051_3_, PlayerEntity p_220051_4_, Hand p_220051_5_, BlockRayTraceResult p_220051_6_) {
        if (!p_220051_2_.isRemote) {
            return this.eatCake(p_220051_2_, p_220051_3_, p_220051_1_, p_220051_4_);
        } else {
            ItemStack lvt_7_1_ = p_220051_4_.getHeldItem(p_220051_5_);
            return this.eatCake(p_220051_2_, p_220051_3_, p_220051_1_, p_220051_4_) || lvt_7_1_.isEmpty();
        }
    }

    private boolean eatCake(IWorld p_180682_1_, BlockPos p_180682_2_, BlockState p_180682_3_, PlayerEntity p_180682_4_) {
        if (!p_180682_4_.canEat(false)) {
            return false;
        } else {
            p_180682_4_.addStat(Stats.EAT_CAKE_SLICE);
            p_180682_4_.getFoodStats().addStats(foodheal, saturation);
            int lvt_5_1_ = (Integer)p_180682_3_.get(BITES);
            if (lvt_5_1_ < 6) {
                p_180682_1_.setBlockState(p_180682_2_, (BlockState)p_180682_3_.with(BITES, lvt_5_1_ + 1), 3);
            } else {
                p_180682_1_.removeBlock(p_180682_2_, false);
            }

            return true;
        }
    }
}
