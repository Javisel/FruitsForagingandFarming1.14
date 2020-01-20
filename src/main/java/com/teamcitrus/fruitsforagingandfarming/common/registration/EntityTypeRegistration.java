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
    public static EntityType<?> FFF_BOAT = null;

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {

        FFF_BOAT = EntityType.Builder.<BoatEntity>create(FFFBoat::new, EntityClassification.MONSTER).setCustomClientFactory(FFFBoat::new).size(1.375F, 0.5625F).build(FruitsForagingAndFarming.MODID + ":fff_boat");

        EntityTypeRegistration.FFF_BOAT.setRegistryName(FruitsForagingAndFarming.MODID, "fff_boat");

        event.getRegistry().registerAll(FFF_BOAT);


    }


}
