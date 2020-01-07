package com.teamcitrus.fruitsforagingandfarming.common.entity;

import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityTypeRegistration;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.world.World;

public class FFFBoat extends BoatEntity {


    public FFFBoat(EntityType<Entity> p_i50129_1_, World p_i50129_2_) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.FFF_BOAT, p_i50129_2_);
    }

    public FFFBoat(World worldIn, double x, double y, double z) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.FFF_BOAT, worldIn);
    }

    public FFFBoat(World worldIn) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.FFF_BOAT, worldIn);
    }


}