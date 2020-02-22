package com.teamcitrus.fruitsforagingandfarming.common.entity.crabai;

import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.Difficulty;

import javax.annotation.Nullable;

public class HealthPredicate extends EntityPredicate {


    float threshold;

    public HealthPredicate(float threshold) {
        super();
        this.threshold = threshold;
    }

    @Override
    public boolean canTarget(@Nullable LivingEntity attacker, LivingEntity target) {

        return super.canTarget(attacker, target) && target.getHealth() <=threshold && attacker.getEntityWorld().getDifficulty()!= Difficulty.PEACEFUL;
    }
}
