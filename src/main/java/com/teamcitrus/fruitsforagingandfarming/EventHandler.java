package com.teamcitrus.fruitsforagingandfarming;

import com.teamcitrus.fruitsforagingandfarming.client.config.ClientConfig;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EffectRegistration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler {


    @SubscribeEvent
    public  void foodToolTip(ItemTooltipEvent e) {

        if (e.getItemStack().isFood() && ClientConfig.foodTooltip.get()) {

            e.getToolTip().add(new StringTextComponent(TextFormatting.GOLD + "Shanks: " + TextFormatting.GRAY +  e.getItemStack().getItem().getFood().getHealing()));
            e.getToolTip().add(new StringTextComponent(TextFormatting.GOLD + "Saturation: " + TextFormatting.GRAY +  e.getItemStack().getItem().getFood().getSaturation()));



        }



    }






    @SubscribeEvent
    public void InfestationExplosion(LivingDeathEvent e) {

        if (e.getEntityLiving().getActivePotionEffect(EffectRegistration.INFESTATION) != null) {

            int remainingduration = e.getEntityLiving().getActivePotionEffect(EffectRegistration.INFESTATION).getDuration() % 20;

            for (int i = 0; i < remainingduration * (1 + e.getEntityLiving().getActivePotionEffect(EffectRegistration.INFESTATION).getAmplifier()); i++) {


                SilverfishEntity silverfish = new SilverfishEntity(EntityType.SILVERFISH,e.getEntityLiving().getEntityWorld());
                silverfish.setPositionAndRotation(e.getEntityLiving().posX,e.getEntityLiving().posY,e.getEntityLiving().posZ,e.getEntityLiving().rotationYaw,e.getEntityLiving().rotationPitch);

                e.getEntityLiving().getEntityWorld().addEntity(silverfish);





            }


        }


    }




}
