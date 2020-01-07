package com.teamcitrus.fruitsforagingandfarming.common.item;

import com.teamcitrus.fruitsforagingandfarming.common.config.Config;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EffectRegistration;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class InfestedEggs extends ItemBase {



    public InfestedEggs() {
        super("infested_eggs", new Item.Properties().food(new Food.Builder().hunger(Config.INFESTED_EGGS.getShanks()).saturation(
                Config.INFESTED_EGGS.getSaturation()
        ).setAlwaysEdible().fastToEat().build()));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
       ItemStack stack1 = super.onItemUseFinish(stack,worldIn,entityLiving);

       entityLiving.addPotionEffect(new EffectInstance(EffectRegistration.INFESTATION,100,0));
       return  stack1;
    }

}
