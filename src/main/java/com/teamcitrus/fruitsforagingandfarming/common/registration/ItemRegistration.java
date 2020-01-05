package com.teamcitrus.fruitsforagingandfarming.common.registration;


import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.item.PalmBoatItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ItemRegistration {

    public static Item PALM_BOAT = null;


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        System.out.println("ITEM REGISTRY!");
        event.getRegistry().registerAll
                (
                        PALM_BOAT = new PalmBoatItem("palm_boat", new Item.Properties().maxStackSize(1).group(FruitsForagingAndFarming.itemGroup))
                );
    }





}

