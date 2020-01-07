package com.teamcitrus.fruitsforagingandfarming;

import com.teamcitrus.fruitsforagingandfarming.client.config.ClientConfig;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class EventHandler {


    @SubscribeEvent
    public void foodToolTip(ItemTooltipEvent e) {

        if (e.getItemStack().isFood() && ClientConfig.foodTooltip.get()) {

            e.getToolTip().add(new StringTextComponent(TextFormatting.GOLD + "Shanks: " + TextFormatting.GRAY +  e.getItemStack().getItem().getFood().getHealing()));
            e.getToolTip().add(new StringTextComponent(TextFormatting.GOLD + "Saturation: " + TextFormatting.GRAY +  e.getItemStack().getItem().getFood().getSaturation()));



        }



    }










}
