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
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
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

    /**
     * Called when a user uses the creative pick block button on this entity.
     *
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, empty ItemStack if nothing should be added.
     */
    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return   new ItemStack(EntityTypeRegistration.COCONUT_CRAB_SPAWN_EGG);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(3, new NocturnalGoal(this, 1));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1D, false));
        this.targetSelector.addGoal(3, new WeakenedMobHunterGoal<>(this, LivingEntity.class, false,5));
        this.goalSelector.addGoal(2, new CrackCoconutGoal(this,1.2,20,2));

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
