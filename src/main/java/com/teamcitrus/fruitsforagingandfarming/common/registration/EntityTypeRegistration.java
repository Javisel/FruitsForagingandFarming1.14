package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import com.teamcitrus.fruitsforagingandfarming.common.entity.FFFBoat;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class EntityTypeRegistration {
    public static EntityType<?> FFF_BOAT = null;
    public static EntityType<?> COCONUT_CRAB = null;

    //EGGS

    public static Item COCONUT_CRAB_SPAWN_EGG = null;


    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {

        FFF_BOAT = EntityType.Builder.<BoatEntity>create(FFFBoat::new, EntityClassification.MONSTER).setCustomClientFactory(FFFBoat::new).size(1.375F, 0.5625F).build(FruitsForagingAndFarming.MODID + ":fff_boat");
        COCONUT_CRAB = EntityType.Builder.create(CoconutCrabEntity::new, EntityClassification.CREATURE).size(0.8f,0.4375f).build(FruitsForagingAndFarming.MODID + ":coconut_crab").setRegistryName(FruitsForagingAndFarming.MODID,"coconut_crab");

        EntityTypeRegistration.FFF_BOAT.setRegistryName(FruitsForagingAndFarming.MODID, "fff_boat");

        event.getRegistry().registerAll(FFF_BOAT,
                COCONUT_CRAB);


    }


    @SubscribeEvent
    public static void registerEggs(final RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(

                COCONUT_CRAB_SPAWN_EGG=registerEntitySpawnEgg(COCONUT_CRAB,9127187, 8388608,"coconut_crab_spawn_egg")

        );


    }



    public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
    {
        SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(FruitsForagingAndFarming.itemGroup));
        item.setRegistryName(name);
        return item;
    }


}