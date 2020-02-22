package com.teamcitrus.fruitsforagingandfarming.common.entity.crabai;

import com.teamcitrus.fruitsforagingandfarming.common.block.BlockSplitCoconut;
import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import org.lwjgl.system.CallbackI;

import java.util.EnumSet;

public class CrackCoconutGoal extends MoveToBlockGoal {

    protected int field_220731_g;

    public CrackCoconutGoal(CoconutCrabEntity crab, double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
        super(crab, p_i50737_2_, p_i50737_4_, p_i50737_5_);
    }

    public double getTargetDistanceSq() {
        return 2.0D;
    }

    public boolean shouldMove() {
        return this.timeoutCounter % 100 == 0;
    }

    /**
     * Return true to set given position as destination
     */
    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos);

        return blockstate.getBlock() == BlockRegistration.COCONUT && BlockRegistration.COCONUT.getMetaFromState(blockstate) >= 2;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        if (this.getIsAboveDestination()) {
            if (this.field_220731_g >= 40) {
                this.func_220730_m();
            } else {
                ++this.field_220731_g;
            }
        } else if (!this.getIsAboveDestination() && super.creature.getRNG().nextFloat() < 0.05F) {


        }

        super.tick();
    }

    protected void func_220730_m() {
        if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(super.creature.world, super.creature)) {
            BlockState blockstate = super.creature.world.getBlockState(this.destinationBlock);
            if (blockstate.getBlock() == BlockRegistration.COCONUT) {

                BlockState state;

                if (this.creature.getHorizontalFacing()==Direction.NORTH || this.creature.getHorizontalFacing() == Direction.SOUTH) {

                    state=BlockRegistration.SPLIT_COCONUT.getDefaultState().with(BlockSplitCoconut.HORIZONTAL_FACING,Direction.NORTH);

                }
                 else {
                    state=BlockRegistration.SPLIT_COCONUT.getDefaultState().with(BlockSplitCoconut.HORIZONTAL_FACING,Direction.WEST);

                }


                super.creature.playSound(SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, 1.0F, 1.0F);
                super.creature.world.setBlockState(this.destinationBlock, state, 2);
            }
        }
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.field_220731_g = 0;
        super.startExecuting();
    }
}