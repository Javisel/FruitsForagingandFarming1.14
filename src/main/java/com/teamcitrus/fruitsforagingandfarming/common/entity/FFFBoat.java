package com.teamcitrus.fruitsforagingandfarming.common.entity;


import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityTypeRegistration;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.network.IPacket;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class FFFBoat extends BoatEntity {



    public FFFBoat(World worldIn, double x, double y, double z) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.FFF_BOAT,worldIn);
        setPositionAndUpdate(x, y, z);
    }


    public FFFBoat(EntityType<BoatEntity> boatEntityEntityType, World world) {
        super(boatEntityEntityType ,world);

    }

    public FFFBoat(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.FFF_BOAT,world);


    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}