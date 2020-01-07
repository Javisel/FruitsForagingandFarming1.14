package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.config.Config;
import com.teamcitrus.fruitsforagingandfarming.common.item.InfestedEggs;
import com.teamcitrus.fruitsforagingandfarming.common.item.ItemBase;
import com.teamcitrus.fruitsforagingandfarming.common.item.ItemBlockBase;
import com.teamcitrus.fruitsforagingandfarming.common.item.PalmBoatItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ItemRegistration {

    //FOOD
    public static Item AVOCADO = null;
    public static Item COCONUT_CHUNK = null;
    public static Item CORN = null;

    public static Item HONEYMELON_SLICE = null;

    public static Item PALM_BOAT = null;

    public static Item INFESTED_EGGS = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll
                (


                       PALM_BOAT = new PalmBoatItem("palm_boat", new Item.Properties().maxStackSize(1)),
                        AVOCADO = new ItemBase("avocado",new Item.Properties().food(Config.AVOCADO_DATA.getDefaultFood())),
                        COCONUT_CHUNK = new ItemBase("coconut_chunk",new Item.Properties().food(Config.COCONUT_CHUNK_DATA.getDefaultFood())),
                        CORN = new ItemBase("corn", new Item.Properties().food(Config.CORN.getDefaultFood())),
                        HONEYMELON_SLICE = new ItemBase("honeymelon_slice", new Item.Properties().food(Config.HONEYMELON_SLICE.getDefaultFood())),
                        INFESTED_EGGS = new InfestedEggs()




                );
    }


}

