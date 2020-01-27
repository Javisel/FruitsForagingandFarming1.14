package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.config.Config;
import com.teamcitrus.fruitsforagingandfarming.common.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ItemRegistration {

    //MANUFACTURED ITEMS
    public static final Item CHOCOLATE_MILK_BUCKET = null;
    public static final Item CHOCOLATE_MILK_BOTTLE = null;
    //FRUITS
    public static Item AVOCADO = null;
    public static Item BANANA = null;
    public static Item BLUEBERRY = null;
    public static Item KIWANO = null;
    public static Item COCONUT_CHUNK = null;
    public static Item CORN = null;
    public static Item DURIAN = null;
    public static Item HONEYMELON_SLICE = null;
    public static Item KIWI = null;
    public static Item LEMON = null;
    public static Item LIME = null;
    public static Item MANGO = null;
    public static Item ORANGE = null;
    public static Item PEAR = null;
    public static Item PINEAPPLE = null;
    public static Item PLUM = null;
    public static Item TURNIP = null;
    public static Item INFESTED_EGGS = null;
    public static Item PALM_BOAT = null;
    //SEED
    public static Item HONEYMELON_SEEDS = null;
    public static Item GRASS_SEEDS = null;
    public static Item TURNIP_SEEDS = null;
    public static Item CORN_KERNEL = null;

    //SCYTHE
    public static Item WOOD_SCYTHE = null;
    public static Item STONE_SCYTHE = null;
    public static Item IRON_SCYTHE = null;
    public static Item GOLD_SCYTHE = null;
    public static Item DIAMOND_SCYTHE = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll
                (


                        AVOCADO = new ItemBase("avocado", new Item.Properties().food(Config.AVOCADO.getDefaultFood())),
                        BANANA = new ItemBase("banana", new Item.Properties().food(Config.BANANA.getDefaultFood())),
                        BLUEBERRY = new ItemBase("blueberry", new Item.Properties().food(Config.BLUEBERRY.getDefaultFood())),
                        COCONUT_CHUNK = new ItemBase("coconut_chunk", new Item.Properties().food(Config.COCONUT_CHUNK.getDefaultFood())),
                        CORN = new ItemBase("corn", new Item.Properties().food(Config.CORN.getDefaultFood())),
                        DURIAN = new ItemBase("durian", new Item.Properties().food(Config.DURIAN.getDefaultFood())),
                        HONEYMELON_SLICE = new ItemBase("honeymelon_slice", new Item.Properties().food(Config.HONEYMELON_SLICE.getDefaultFood())),
                        INFESTED_EGGS = new InfestedEggs(),
                        KIWI = new ItemBase("kiwi", new Item.Properties().food(Config.KIWI.getDefaultFood())),
                        KIWANO = new ItemBase("kiwano", new Item.Properties().food(Config.KIWANO.getDefaultFood())),
                        LEMON = new ItemBase("lemon", new Item.Properties().food(Config.LEMON.getDefaultFood())),
                        LIME = new ItemBase("lime", new Item.Properties().food(Config.LIME.getDefaultFood())),
                        MANGO = new ItemBase("mango", new Item.Properties().food(Config.MANGO.getDefaultFood())),
                        ORANGE = new ItemBase("orange", new Item.Properties().food(Config.ORANGE.getDefaultFood())),
                        PEAR = new ItemBase("pear", new Item.Properties().food(Config.PEAR.getDefaultFood())),
                        PINEAPPLE = new ItemBase("pineapple", new Item.Properties().food(Config.PINEAPPLE.getDefaultFood())),
                        PLUM = new ItemBase("plum", new Item.Properties().food(Config.PLUM.getDefaultFood())),
                        TURNIP = new ItemBase("turnip", new Item.Properties().food(Config.TURNIP.getDefaultFood())),
                        //TODO chocolate milk bucket & bottle

                        PALM_BOAT = new PalmBoatItem("palm_boat", new Item.Properties().maxStackSize(1)),
                        WOOD_SCYTHE = new ScytheItem("wooden_scythe", ItemTier.WOOD, -3),
                        STONE_SCYTHE = new ScytheItem("stone_scythe", ItemTier.STONE, -3),
                        GOLD_SCYTHE = new ScytheItem("golden_scythe", ItemTier.GOLD, -3),
                        IRON_SCYTHE = new ScytheItem("iron_scythe", ItemTier.IRON, -3),
                        DIAMOND_SCYTHE = new ScytheItem("diamond_scythe", ItemTier.DIAMOND, -3),

                        //SEEDS
                        CORN_KERNEL = new SeedBase("corn_kernel",BlockRegistration.CORN_CROP_BOTTOM, new Item.Properties()),
                        TURNIP_SEEDS = new SeedBase("turnip_seeds",BlockRegistration.TURNIP_CROP,new Item.Properties())
                );
    }


}

