package com.teamcitrus.fruitsforagingandfarming.common.entity.crabai;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.Difficulty;

public class WeakenedMobHunterGoal<T extends LivingEntity>  extends NearestAttackableTargetGoal {




    public WeakenedMobHunterGoal(CreatureEntity creatureEntity, Class<T> target, boolean useLongMemory, float healthThreshold) {
        super( creatureEntity, target, useLongMemory);

        this.targetEntitySelector = new HealthPredicate(healthThreshold);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        return super.shouldExecute() && this.goalOwner.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL;
    }

    protected void findNearestTarget() {
        if (this.targetClass != PlayerEntity.class && this.targetClass != ServerPlayerEntity.class) {
            this.nearestTarget = this.goalOwner.world.<T>func_225318_b(this.targetClass, this.targetEntitySelector, this.goalOwner, this.goalOwner.posX, this.goalOwner.posY + (double)this.goalOwner.getEyeHeight(), this.goalOwner.posZ, this.getTargetableArea(this.getTargetDistance()));


        } else {
            this.nearestTarget = this.goalOwner.world.getClosestPlayer(this.targetEntitySelector, this.goalOwner, this.goalOwner.posX, this.goalOwner.posY + (double)this.goalOwner.getEyeHeight(), this.goalOwner.posZ);
        }

    }


}
