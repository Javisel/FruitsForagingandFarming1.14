package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class StripableBlock extends RotatedPillarBlockBase {
    
  public  static RotatedPillarBlock stripped;
    public StripableBlock(String name, RotatedPillarBlock strippedblock, Properties properties) {
        super(name, properties);
        stripped=strippedblock;
    }
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
     
        if (player.getHeldItem(handIn).getItem() instanceof AxeItem) {
            
            


            worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if (!worldIn.isRemote) {
                worldIn.setBlockState(pos, stripped.getDefaultState().with(RotatedPillarBlock.AXIS, state.get(RotatedPillarBlock.AXIS)), 11);

                  player.getHeldItem(handIn).damageItem(1, player, (p_220040_1_) -> {
                        p_220040_1_.sendBreakAnimation(handIn);
                    });

            }
            
            return  true;
        }
        
        
        
        return  false;
    }
    
    
    
}
