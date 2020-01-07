package com.teamcitrus.fruitsforagingandfarming.common.effect;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectType;
import net.minecraft.world.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Infestation extends EffectBase {

    public Infestation() {
        super("infestation", EffectType.HARMFUL, 0x7F7F7F);
    }



    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {

        if (!entityLivingBaseIn.getEntityWorld().isRemote) {

            if (entityLivingBaseIn.getEntityWorld().getDifficulty() == Difficulty.PEACEFUL) {
                entityLivingBaseIn.removePotionEffect(this);
                return;
            }
            for (int i = 0; i < 1 + amplifier; i++) {
                entityLivingBaseIn.attackEntityFrom(FruitsForagingAndFarming.silverfishAlien, 1f);

                SilverfishEntity silverfish = new SilverfishEntity(EntityType.SILVERFISH,entityLivingBaseIn.getEntityWorld());
                    silverfish.setPositionAndRotation(entityLivingBaseIn.posX,entityLivingBaseIn.posY,entityLivingBaseIn.posZ,entityLivingBaseIn.rotationYaw,entityLivingBaseIn.rotationPitch);

                entityLivingBaseIn.getEntityWorld().addEntity(silverfish);

                silverfish.setAttackTarget(entityLivingBaseIn);
            }
        }


    }

    @Override

    public boolean isReady(int duration, int amplifier) {

        return duration % 20 == 0;
    }



    @Override
    public List<ItemStack> getCurativeItems() {

        ArrayList<ItemStack> cures = new ArrayList<>();
        cures.add(new ItemStack(Items.MILK_BUCKET));

        return  cures;
    }
}
