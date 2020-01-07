package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ChiseledBlackSandstone extends BlockBase{


    public ChiseledBlackSandstone(Properties properties) {
        super("chiseled_black_sandstone", properties);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if ( player.getHeldItem(handIn).getItem() instanceof EnderEyeItem) {

                worldIn.setBlockState(pos, BlockRegistration.ACTIVATED_BLACK_SANDSTONE.getDefaultState());

                worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS,1,1,false);

            return  true;
        }

        return  false;
    }
}
