package com.teamcitrus.fruitsforagingandfarming;

import com.teamcitrus.fruitsforagingandfarming.client.config.ClientConfig;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EffectRegistration;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
    public void sliceCoconut(PlayerInteractEvent.LeftClickBlock e){

        if ((e.getItemStack().getItem() instanceof SwordItem || e.getItemStack().getItem() instanceof AxeItem) && e.getWorld().getBlockState(e.getPos()).getBlock() == BlockRegistration.COCONUT) {

            e.getWorld().setBlockState(e.getPos(),BlockRegistration.SPLIT_COCONUT.getStateForPlacement(e.getWorld().getBlockState(e.getPos()),e.getFace(),e.getWorld().getBlockState(e.getPos()),e.getWorld(),e.getPos(),e.getPos(),null));



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
