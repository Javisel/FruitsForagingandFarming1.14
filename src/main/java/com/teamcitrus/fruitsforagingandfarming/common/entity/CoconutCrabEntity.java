package com.teamcitrus.fruitsforagingandfarming.common.entity;

import com.teamcitrus.fruitsforagingandfarming.common.entity.crabai.CrackCoconutGoal;
import com.teamcitrus.fruitsforagingandfarming.common.entity.crabai.WeakenedMobHunterGoal;
import com.teamcitrus.fruitsforagingandfarming.common.entity.crabai.NocturnalGoal;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityTypeRegistration;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class CoconutCrabEntity extends CreatureEntity {


    public CoconutCrabEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {

        return  CreatureAttribute.ARTHROPOD;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(3, new NocturnalGoal(this, 1));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 2.5D, false));
        this.targetSelector.addGoal(2, new WeakenedMobHunterGoal<>(this, LivingEntity.class, false,5));
        this.goalSelector.addGoal(4, new CrackCoconutGoal(this));

    }
    @Override
    protected void registerAttributes() {
        super.registerAttributes();

        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(5);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);

    }




}
