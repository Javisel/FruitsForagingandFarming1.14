package com.teamcitrus.fruitsforagingandfarming.client.render.entity.coconutcrab;

import com.mojang.blaze3d.platform.GlStateManager;
import com.teamcitrus.fruitsforagingandfarming.client.model.entity.CoconutCrabModel;
import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class CrabHeldItemLayer extends LayerRenderer<CoconutCrabEntity, CoconutCrabModel<CoconutCrabEntity>> {
    public CrabHeldItemLayer(IEntityRenderer<CoconutCrabEntity, CoconutCrabModel<CoconutCrabEntity>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(CoconutCrabEntity entityIn, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {

        ItemStack itemstack = entityIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
        if (!itemstack.isEmpty()) {
            boolean flag1 = entityIn.isChild();
            GlStateManager.pushMatrix();
            if (flag1) {
                float f = 0.75F;
                GlStateManager.scalef(0.75F, 0.75F, 0.75F);
                GlStateManager.translatef(0.0F, 8.0F * p_212842_8_, 3.35F * p_212842_8_);
            }

            GlStateManager.translatef((this.getEntityModel()).clawLeft.rotationPointX / 16.0F, (this.getEntityModel()).clawLeft.rotationPointY / 16.0F, (this.getEntityModel()).clawLeft.rotationPointZ / 16.0F);
            float f1 =  (180F / (float)Math.PI);
            GlStateManager.rotatef(f1, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotatef(p_212842_6_, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotatef(p_212842_7_, 1.0F, 0.0F, 0.0F);
            if (entityIn.isChild()) {

                    GlStateManager.translatef(0.06F, 0.26F, -0.5F);

            } else {
                GlStateManager.translatef(0.06F, 0.27F, -0.5F);
            }

            GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);

            Minecraft.getInstance().getItemRenderer().renderItem(itemstack, entityIn, ItemCameraTransforms.TransformType.GROUND, false);
            GlStateManager.popMatrix();
        }
    }


    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
