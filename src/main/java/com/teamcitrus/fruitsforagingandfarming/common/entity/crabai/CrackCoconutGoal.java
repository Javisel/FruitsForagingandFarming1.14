package com.teamcitrus.fruitsforagingandfarming.common.entity.crabai;

import com.teamcitrus.fruitsforagingandfarming.common.block.BlockCoconut;
import com.teamcitrus.fruitsforagingandfarming.common.block.BlockSplitCoconut;
import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import java.util.EnumSet;

public class CrackCoconutGoal extends MoveToBlockGoal {


    private int tickcount=0;



    public CrackCoconutGoal(CoconutCrabEntity crabEntity) {
        super(crabEntity,1,20);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {

        if (this.creature.getAttackTarget() !=null) {
            return false;
        }
        if (this.creature.getEntityWorld().isDaytime()) {
            return  false;
        }




        return super.shouldExecute();
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
    public void tick() {
        if (this.getIsAboveDestination()) {
            if (this.tickcount >= 40) {
                this.destroyCoconutBlock();
            } else {
                ++this.tickcount;
            }
        } else if (!this.getIsAboveDestination() && this.creature.getRNG().nextFloat() < 0.05F) {

        //TODO play coconut crab claw sound
        }

        super.tick();
    }
    /**
     * Return true to set given position as destination
     *
     * @param worldIn
     * @param pos
     */
    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos);

        if (worldIn.isAirBlock(pos.down())){

            return  false;
        }

        if (blockstate.getBlock() == BlockRegistration.COCONUT && BlockCoconut.getStateId(blockstate) >=2  ) {


            return  true;
        }

        if (blockstate.getBlock() ==BlockRegistration.SPLIT_COCONUT) {
            return  true;
        }

        return  false;
    }

    @Override
    public void setMutexFlags(EnumSet<Flag> p_220684_1_) {
        super.setMutexFlags(p_220684_1_);
    }

    @Override
    public EnumSet<Flag> getMutexFlags() {
        return super.getMutexFlags();
    }
    
    
    
    
    protected void destroyCoconutBlock() {
        if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(creature.world, creature)) {
            BlockState blockstate = creature.world.getBlockState(this.destinationBlock);
            if (blockstate.getBlock() == BlockRegistration.COCONUT) {

                BlockState placestate;

                if (this.creature.getHorizontalFacing() == Direction.SOUTH || this.creature.getHorizontalFacing()==Direction.NORTH) {

                    placestate=BlockRegistration.SPLIT_COCONUT.getDefaultState().with(BlockSplitCoconut.HORIZONTAL_FACING,Direction.NORTH);


                }
                 else {

                    placestate=BlockRegistration.SPLIT_COCONUT.getDefaultState().with(BlockSplitCoconut.HORIZONTAL_FACING,Direction.WEST);

                }





                //TODO cracknut sound
                creature.world.setBlockState(this.destinationBlock, placestate, 2);


            }
        }
    }
}
