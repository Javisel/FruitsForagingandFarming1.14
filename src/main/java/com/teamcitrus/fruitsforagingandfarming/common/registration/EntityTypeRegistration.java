package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.entity.FFFBoat;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class EntityTypeRegistration {
    public static  EntityType<BoatEntity> FFF_BOAT = (EntityType<BoatEntity>) EntityType.Builder.<BoatEntity>create(FFFBoat::new, EntityClassification.MISC).size(1.375F, 0.5625F).build(FruitsForagingAndFarming.MODID + ":palm_boat").setRegistryName(FruitsForagingAndFarming.MODID + ":palm_boat");


    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {

        event.getRegistry().registerAll(FFF_BOAT);

    }


}
