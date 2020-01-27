package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.block.*;
import com.teamcitrus.fruitsforagingandfarming.common.item.ItemBlockBase;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.BananaTree;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.LemonTree;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.PalmTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistration {

    private static final Block.Properties WOOD_BLOCK_PROPERTY = Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F);
    private static final Block.Properties WOOD_SIGN_PROPERTIES = Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement();

    private static final Block.Properties SANDSTONE_PROPERTIES = Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(0.8F);
    private static final Block.Properties SAPLING_PROPERTIES = Block.Properties.create(Material.PLANTS, MaterialColor.GREEN).sound(SoundType.PLANT);
    private static final Block.Properties CROP_PROPERTY = Block.Properties.create(Material.PLANTS,MaterialColor.GREEN).doesNotBlockMovement().sound(SoundType.CROP).tickRandomly();
    public static Block PALM_LOG = null;
    public static Block STRIPPED_PALM_LOG = null;
    public static Block PALM_WOOD = null;
    public static Block STRIPPED_PALM_WOOD = null;
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

    //BLACK SAND
    public static Block BLACK_SAND = null;
    public static Block BLACK_SANDSTONE = null;
    public static Block SMOOTH_BLACK_SANDSTONE = null;
    public static Block CHISELED_BLACK_SANDSTONE = null;
    public static Block CUT_BLACK_SANDSTONE = null;
    public static Block BLACK_SANDSTONE_SLAB = null;
    public static Block CUT_BLACK_SANDSTONE_SLAB = null;
    public static Block SMOOTH_BLACK_SANDSTONE_SLAB = null;
    public static Block BLACK_SANDSTONE_STAIRS = null;
    public static Block SMOOTH_BLACK_SANDSTONE_STAIRS = null;
    public static Block ACTIVATED_BLACK_SANDSTONE = null;
    public static Block BLACK_SANDSTONE_WALL = null;

    //COCONUT
    public static BlockCoconut COCONUT = null;
    public static Block SPLIT_COCONUT = null;
    //HANGING FRUITS
    public static Block BANANA_FRUIT = null;
    public static Block BANANA_SAPLING = null;

    public static Block LEMON_FRUIT = null;
    public static Block LEMON_SAPLING = null;

    //CROP
    public static Block CORN_CROP_BOTTOM = null;
    public static CornCropTop CORN_CROP_TOP = null;

    public static Block TURNIP_CROP = null;


    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll
                (
                        STRIPPED_PALM_LOG = new RotatedPillarBlockBase("stripped_palm_log", WOOD_BLOCK_PROPERTY),
                        PALM_LOG = new StripableBlock("palm_log", (RotatedPillarBlock) STRIPPED_PALM_LOG, WOOD_BLOCK_PROPERTY),

                        STRIPPED_PALM_WOOD = new RotatedPillarBlockBase("stripped_palm_wood", WOOD_BLOCK_PROPERTY),
                        PALM_WOOD = new StripableBlock("palm_wood", (RotatedPillarBlock) STRIPPED_PALM_WOOD, WOOD_BLOCK_PROPERTY),
                        BANANA_SAPLING = new SaplingBase("banana_sapling", new BananaTree(), SAPLING_PROPERTIES),
                        LEMON_SAPLING = new SaplingBase("lemon_sapling", new LemonTree(), SAPLING_PROPERTIES),
                        PALM_PLANKS = new BlockBase("palm_planks", WOOD_BLOCK_PROPERTY),
                        PALM_LEAVES = new LeavesBlockBase("palm_leaves", Block.Properties.create(Material.LEAVES, MaterialColor.GREEN)),
                        PALM_SAPLING = new SaplingBase("palm_sapling", new PalmTree(), SAPLING_PROPERTIES),
                        PALM_STAIRS = new StairsBase("palm_stairs", BlockRegistration.PALM_PLANKS.getDefaultState(), WOOD_BLOCK_PROPERTY),
                        PALM_SLAB = new SlabBase("palm_slab", WOOD_BLOCK_PROPERTY),
                        PALM_BUTTON = new ButtonBase("palm_button", WOOD_BLOCK_PROPERTY),
                        PALM_PRESSURE_PLATE = new PressurePlateBase("palm_pressure_plate", PressurePlateBlock.Sensitivity.EVERYTHING, WOOD_BLOCK_PROPERTY),
                        PALM_FENCE = new FenceBlockBase("palm_fence", WOOD_BLOCK_PROPERTY),
                        PALM_FENCE_GATE = new FenceGateBlockBase("palm_fence_gate", WOOD_BLOCK_PROPERTY),
                        PALM_SIGN = new StandingSignBase("palm_sign", WOOD_SIGN_PROPERTIES),
                        PALM_WALL_SIGN = new WallSignBase("palm_wall_sign", WOOD_SIGN_PROPERTIES),
                        PALM_DOOR = new DoorBase("palm_door", WOOD_BLOCK_PROPERTY),
                        PALM_TRAPDOOR = new TrapdoorBase("palm_trapdoor", WOOD_BLOCK_PROPERTY),
                        COCONUT = new BlockCoconut(),
                        SPLIT_COCONUT = new BlockSplitCoconut(),
                        BLACK_SAND = new FallingBlock(Block.Properties.create(Material.SAND, MaterialColor.BLACK).sound(SoundType.SAND).hardnessAndResistance(0.5F)).setRegistryName("black_sand"),
                        BLACK_SANDSTONE = new BlockBase("black_sandstone", SANDSTONE_PROPERTIES),
                        SMOOTH_BLACK_SANDSTONE = new BlockBase("smooth_black_sandstone", SANDSTONE_PROPERTIES),
                        CHISELED_BLACK_SANDSTONE = new ChiseledBlackSandstone(SANDSTONE_PROPERTIES),
                        CUT_BLACK_SANDSTONE = new BlockBase("cut_black_sandstone", SANDSTONE_PROPERTIES),
                        BLACK_SANDSTONE_SLAB = new SlabBase("black_sandstone_slab", SANDSTONE_PROPERTIES),
                        CUT_BLACK_SANDSTONE_SLAB = new SlabBase("cut_black_sandstone_slab", SANDSTONE_PROPERTIES),
                        SMOOTH_BLACK_SANDSTONE_SLAB = new SlabBase("smooth_black_sandstone_slab", SANDSTONE_PROPERTIES),
                        BLACK_SANDSTONE_STAIRS = new StairsBase("black_sandstone_stairs", BlockRegistration.BLACK_SANDSTONE.getDefaultState(), SANDSTONE_PROPERTIES),
                        SMOOTH_BLACK_SANDSTONE_STAIRS = new StairsBase("smooth_black_sandstone_stairs", BlockRegistration.SMOOTH_BLACK_SANDSTONE.getDefaultState(), SANDSTONE_PROPERTIES),
                        ACTIVATED_BLACK_SANDSTONE = new BlockBase("activated_black_sandstone", SANDSTONE_PROPERTIES),
                        BLACK_SANDSTONE_WALL = new WallBase("black_sandstone_wall", SANDSTONE_PROPERTIES),
                        BANANA_FRUIT = new HangingFruit("banana_fruit"),
                        LEMON_FRUIT = new HangingFruit("lemon_fruit"),
                        CORN_CROP_BOTTOM = new CornCropBottom(),
                        CORN_CROP_TOP = new CornCropTop(),
                        TURNIP_CROP = new CropsBase("turnip_crop",CROP_PROPERTY)

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
                        new ItemBlockBase(BANANA_SAPLING, new Item.Properties()),
                        new ItemBlockBase(LEMON_SAPLING, new Item.Properties()),

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
                        new ItemBlockBase(SPLIT_COCONUT, new Item.Properties()),
                        new ItemBlockBase(BLACK_SAND, new Item.Properties()),
                        new ItemBlockBase(BLACK_SANDSTONE, new Item.Properties()),
                        new ItemBlockBase(BLACK_SANDSTONE_SLAB, new Item.Properties()),
                        new ItemBlockBase(BLACK_SANDSTONE_STAIRS, new Item.Properties()),
                        new ItemBlockBase(SMOOTH_BLACK_SANDSTONE, new Item.Properties()),
                        new ItemBlockBase(CHISELED_BLACK_SANDSTONE, new Item.Properties()),
                        new ItemBlockBase(CUT_BLACK_SANDSTONE, new Item.Properties()),
                        new ItemBlockBase(CUT_BLACK_SANDSTONE_SLAB, new Item.Properties()),
                        new ItemBlockBase(SMOOTH_BLACK_SANDSTONE_SLAB, new Item.Properties()),
                        new ItemBlockBase(SMOOTH_BLACK_SANDSTONE_STAIRS, new Item.Properties()),
                        new ItemBlockBase(ACTIVATED_BLACK_SANDSTONE, new Item.Properties()),
                        new ItemBlockBase(BLACK_SANDSTONE_WALL, new Item.Properties())


                );


    }


}
