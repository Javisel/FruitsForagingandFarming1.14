package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.StemGrownBlock;
import net.minecraft.block.material.Material;

public class HoneymelonAttachedStem extends AttachedStemBlock {



    public HoneymelonAttachedStem() {
        super((StemGrownBlock) BlockRegistration.HONEYMELON_BLOCK, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT));
        setRegistryName(FruitsForagingAndFarming.MODID,"honeymelon_attached_stem");
    }
}
