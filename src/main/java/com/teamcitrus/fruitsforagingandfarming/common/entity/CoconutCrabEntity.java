package com.teamcitrus.fruitsforagingandfarming.common.entity;

import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityTypeRegistration;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class CoconutCrabEntity extends MobEntity {



    public CoconutCrabEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        super((EntityType<? extends MobEntity>) EntityTypeRegistration.COCONUT_CRAB,world);


    }

    public CoconutCrabEntity(EntityType<Entity> entityEntityType, World world) {
        super((EntityType<? extends MobEntity>) EntityTypeRegistration.COCONUT_CRAB,world);
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {

        return  CreatureAttribute.ARTHROPOD;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
       // this.goalSelector.addGoal(3, new EntityAINocturnalTerrestrial(this, 0.5));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
       // this.tasks.addTask(5, new EntityAINocturnal(this,2));
    }
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(5);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1);
    }




}
