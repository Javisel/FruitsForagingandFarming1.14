package com.teamcitrus.fruitsforagingandfarming.client;

import com.teamcitrus.fruitsforagingandfarming.client.render.entity.coconutcrab.CoconutCrabRenderer;
import com.teamcitrus.fruitsforagingandfarming.client.render.entity.FFFFBoatRenderer;
import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import com.teamcitrus.fruitsforagingandfarming.common.entity.FFFBoat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderRegistration {


    public static void registryEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(FFFBoat.class, new FFFFBoatRenderer.RenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(CoconutCrabEntity.class,new CoconutCrabRenderer.RenderFactory());
    }


}
