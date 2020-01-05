package com.teamcitrus.fruitsforagingandfarming.client;

import com.teamcitrus.fruitsforagingandfarming.client.render.entity.PalmBoatRenderer;
import com.teamcitrus.fruitsforagingandfarming.common.entity.PalmBoat;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.model.Model;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderRegistration {




    public static void registryEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(PalmBoat.class, new PalmBoatRenderer.RenderFactory());

    }


}
