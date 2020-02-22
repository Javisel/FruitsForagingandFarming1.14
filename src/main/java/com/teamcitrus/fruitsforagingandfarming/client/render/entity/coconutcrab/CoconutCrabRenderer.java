package com.teamcitrus.fruitsforagingandfarming.client.render.entity.coconutcrab;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.client.model.entity.CoconutCrabModel;
import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class CoconutCrabRenderer extends MobRenderer< CoconutCrabEntity,  CoconutCrabModel<CoconutCrabEntity>> {
    private static final ResourceLocation COCONUT_CRAB_TEXTURES = new ResourceLocation(FruitsForagingAndFarming.MODID + ":" + "textures/entity/coconut_crab.png");

    public CoconutCrabRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new CoconutCrabModel<>(), .5f);
        new CrabHeldItemLayer(this);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(CoconutCrabEntity coconutCrabEntity) {
        return COCONUT_CRAB_TEXTURES;
    }
    public static class RenderFactory implements IRenderFactory<CoconutCrabEntity> {
        @Override
        public EntityRenderer<? super CoconutCrabEntity> createRenderFor(EntityRendererManager manager) {
            return new CoconutCrabRenderer(manager);
        }

    }
}
