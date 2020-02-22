package com.teamcitrus.fruitsforagingandfarming.common.entity.crabai;

import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class CrackCoconutGoal extends Goal {

    CoconutCrabEntity crabEntity;





    public CrackCoconutGoal(CoconutCrabEntity crabEntity) {
        super();
        this.crabEntity=crabEntity;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {


        return false;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting();
    }

    @Override
    public boolean isPreemptible() {
        return super.isPreemptible();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    @Override
    public void resetTask() {
        super.resetTask();
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void setMutexFlags(EnumSet<Flag> p_220684_1_) {
        super.setMutexFlags(p_220684_1_);
    }

    @Override
    public EnumSet<Flag> getMutexFlags() {
        return super.getMutexFlags();
    }
}
