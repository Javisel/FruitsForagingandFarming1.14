package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.block.*;
import com.teamcitrus.fruitsforagingandfarming.common.item.ItemBlockBase;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.PalmTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistration {

    private static final Block.Properties WOOD_BLOCK_PROPERTY = Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F);
    public static Block PALM_LOG = null;
    public static Block STRIPPED_PALM_LOG = null;
    public static Block PALM_WOOD = null;
    public static Block STRIPPED_PALM_WOOD = null;
    //TODO - Stripped Palm Log, Stripped Palm Wood
    public static Block PALM_PLANKS = null;
    public static Block PALM_LEAVES = null;
    public static Block PALM_SAPLING = null;
    public static Block PALM_STAIRS = null;
    public static Block PALM_SLAB = null;
    public static Block PALM_BUTTON = null;
    public static Block PALM_PRESSURE_PLATE = null;
    public static Block PALM_FENCE = null;
    public static Block PALM_FENCE_GATE = null;
    public static Block PALM_SIGN = null;
    public static Block PALM_WALL_SIGN = null;
    public static Block PALM_DOOR = null;
    public static Block PALM_TRAPDOOR = null;

    //COCONUT
    public static Block COCONUT = null;
    public static Block SPLIT_COCONUT = null;


    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll
                (
                        PALM_LOG = new RotatedPillarBlockBase("palm_log", WOOD_BLOCK_PROPERTY),
                        STRIPPED_PALM_LOG = new RotatedPillarBlockBase("stripped_palm_log", WOOD_BLOCK_PROPERTY),
                        PALM_WOOD = new RotatedPillarBlockBase("palm_wood", WOOD_BLOCK_PROPERTY),
                        STRIPPED_PALM_WOOD = new RotatedPillarBlockBase("stripped_palm_wood", WOOD_BLOCK_PROPERTY),
                        PALM_PLANKS = new BlockBase("palm_planks", WOOD_BLOCK_PROPERTY),
                        PALM_LEAVES = new LeavesBlockBase("palm_leaves", Block.Properties.create(Material.LEAVES, MaterialColor.GREEN)),
                        PALM_SAPLING = new SaplingBase("palm_sapling", new PalmTree(), Block.Properties.create(Material.PLANTS, MaterialColor.GREEN).sound(SoundType.PLANT)),
                        PALM_STAIRS = new StairsBase("palm_stairs", new Supplier<BlockState>() {
                            @Override
                            public BlockState get() {
                                return BlockRegistration.PALM_PLANKS.getDefaultState();
                            }
                        }, WOOD_BLOCK_PROPERTY),
                        PALM_SLAB = new SlabBase("palm_slab", WOOD_BLOCK_PROPERTY),
                        PALM_BUTTON = new ButtonBase("palm_button", WOOD_BLOCK_PROPERTY),
                        PALM_PRESSURE_PLATE = new PressurePlateBase("palm_pressure_plate", PressurePlateBlock.Sensitivity.EVERYTHING, WOOD_BLOCK_PROPERTY),
                        PALM_FENCE = new FenceBlockBase("palm_fence", WOOD_BLOCK_PROPERTY),
                        PALM_FENCE_GATE = new FenceGateBlockBase("palm_fence_gate", WOOD_BLOCK_PROPERTY),
                        PALM_SIGN = new StandingSignBase("palm_sign", WOOD_BLOCK_PROPERTY),
                        PALM_WALL_SIGN = new WallSignBase("palm_wall_sign", WOOD_BLOCK_PROPERTY),
                        PALM_DOOR = new DoorBase("palm_door", WOOD_BLOCK_PROPERTY),
                        PALM_TRAPDOOR = new TrapdoorBase("palm_trapdoor", WOOD_BLOCK_PROPERTY),
                        COCONUT = new BlockCoconut(),
                        SPLIT_COCONUT = new BlockSplitCoconut()
                );
    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll
                (

                        new ItemBlockBase(PALM_LOG, new Item.Properties()),
                        new ItemBlockBase(STRIPPED_PALM_LOG, new Item.Properties()),
                        new ItemBlockBase(STRIPPED_PALM_WOOD, new Item.Properties()),
                        new ItemBlockBase(PALM_WOOD, new Item.Properties()),
                        new ItemBlockBase(PALM_PLANKS, new Item.Properties()),
                        new ItemBlockBase(PALM_LEAVES, new Item.Properties()),
                        new ItemBlockBase(PALM_SAPLING, new Item.Properties()),
                        new ItemBlockBase(PALM_SLAB, new Item.Properties()),
                        new ItemBlockBase(PALM_STAIRS, new Item.Properties()),
                        new ItemBlockBase(PALM_BUTTON, new Item.Properties()),
                        new ItemBlockBase(PALM_PRESSURE_PLATE, new Item.Properties()),
                        new ItemBlockBase(PALM_FENCE, new Item.Properties()),
                        new ItemBlockBase(PALM_FENCE_GATE, new Item.Properties()),
                        new SignItem(new Item.Properties().group(FruitsForagingAndFarming.itemGroup), PALM_SIGN, PALM_WALL_SIGN).setRegistryName(FruitsForagingAndFarming.MODID, "palm_sign"),
                        new ItemBlockBase(PALM_DOOR, new Item.Properties()),
                        new ItemBlockBase(PALM_TRAPDOOR, new Item.Properties()),
                        new ItemBlockBase(COCONUT, new Item.Properties()),
                        new ItemBlockBase(SPLIT_COCONUT, new Item.Properties())

                );


    }


}
