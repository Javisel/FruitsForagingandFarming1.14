package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.effect.Infestation;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FruitsForagingAndFarming.MODID)
@ObjectHolder(FruitsForagingAndFarming.MODID)
public class EffectRegistration {


    public static  Effect INFESTATION = null;

    @SubscribeEvent
    public static final void register(@Nonnull final RegistryEvent.Register<Effect> event) {

        event.getRegistry().registerAll(
               INFESTATION = new Infestation()
        );

    }
}
