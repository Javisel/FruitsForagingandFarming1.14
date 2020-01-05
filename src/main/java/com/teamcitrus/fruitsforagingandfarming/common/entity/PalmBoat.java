package com.teamcitrus.fruitsforagingandfarming.common.entity;

import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityTypeRegistration;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.world.World;

public class PalmBoat extends BoatEntity {


    public PalmBoat(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }




    public PalmBoat(EntityType<Entity> entityEntityType, World world) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.PALM_BOAT,world);
    }










}
