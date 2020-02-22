package com.teamcitrus.fruitsforagingandfarming.common.entity.crabai;

import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;

import javax.annotation.Nullable;

public class HealthPredicate extends EntityPredicate {


    float threshold;

    public HealthPredicate(float threshold) {
        super();
        this.threshold = threshold;
    }

    @Override
    public boolean canTarget(@Nullable LivingEntity attacker, LivingEntity target) {
        System.out.println("Attempted to Target Entity: " + target);

        boolean can=  super.canTarget(attacker, target) && target.getHealth() <=threshold;
        System.out.println("Targetable?: " + can);
        return can;
    }
}
