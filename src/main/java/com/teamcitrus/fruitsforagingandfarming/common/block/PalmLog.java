package com.teamcitrus.fruitsforagingandfarming.common.block;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.teamcitrus.fruitsforagingandfarming.common.registration.BlockProperties.WOOD_BLOCK_PROPERTY;
import static com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration.STRIPPED_PALM_LOG;

public class PalmLog extends StripableBlock {
    public PalmLog() {
        super("palm_log", (RotatedPillarBlock) STRIPPED_PALM_LOG,WOOD_BLOCK_PROPERTY);
    }

    @Override
    public void onBlockClicked(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity) {

        if (!world.isRemote) {


            for (int y = 0; y <= 7; y++) {

                for (int x = -4; x <= 4; x++) {

                    for (int z = -4; z <= 4; z++) {
                        BlockPos newpos = new BlockPos(blockPos.getX()+x, blockPos.getY()+y, blockPos.getZ()+z);
                        if (world.getBlockState(newpos).getBlock()== BlockRegistration.COCONUT && world.getBlockState(newpos.up()).getBlock()==BlockRegistration.PALM_LEAVES && BlockRegistration.COCONUT.getState(world.getBlockState(newpos))>=2) {


                            FallingBlockEntity entityfallingblock = new FallingBlockEntity(world, (double) newpos.getX() + 0.5D, (double) newpos.getY(), (double) newpos.getZ() + 0.5D, BlockRegistration.COCONUT.getStateWithMeta(4));
                            entityfallingblock.setHurtEntities(true);
                            world.addEntity(entityfallingblock);


                        }


                    }

                }

            }


        }

    }
}
