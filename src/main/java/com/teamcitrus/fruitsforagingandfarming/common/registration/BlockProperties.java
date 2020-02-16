package com.teamcitrus.fruitsforagingandfarming.common.registration;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockProperties {
    public static final Block.Properties WOOD_BLOCK_PROPERTY = Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F);
    public static final Block.Properties WOOD_SIGN_PROPERTIES = Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement();

    public static final Block.Properties SANDSTONE_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(0.8F);
    public static final Block.Properties SAPLING_PROPERTIES = Block.Properties.create(Material.PLANTS, MaterialColor.GREEN).sound(SoundType.PLANT);
    public static final Block.Properties CROP_PROPERTY = Block.Properties.create(Material.PLANTS,MaterialColor.GREEN).doesNotBlockMovement().sound(SoundType.CROP).tickRandomly();

}
