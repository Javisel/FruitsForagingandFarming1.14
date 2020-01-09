package com.teamcitrus.fruitsforagingandfarming.common.entity;


import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityTypeRegistration;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FFFBoat extends BoatEntity{





    public FFFBoat(EntityType<? extends BoatEntity> p_i50129_1_, World p_i50129_2_) {
        super(p_i50129_1_, p_i50129_2_);
        this.preventEntitySpawning = true;
    }

    public FFFBoat(World worldIn, double x, double y, double z) {
        this(EntityTypeRegistration.FFF_BOAT, worldIn);
        this.setPosition(x, y, z);
        this.setMotion(Vec3d.ZERO);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }
}










