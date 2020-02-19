package com.teamcitrus.fruitsforagingandfarming.client.model.entity;

import com.teamcitrus.fruitsforagingandfarming.common.entity.CoconutCrabEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CoconutCrabModel<T extends CoconutCrabEntity> extends EntityModel<CoconutCrabEntity> {
    public RendererModel body;
    public RendererModel armLeft;
    public RendererModel armRight;
    public RendererModel legLeft1;
    public RendererModel legLeft2;
    public RendererModel legLeft3;
    public RendererModel legRight3;
    public RendererModel legRight2;
    public RendererModel legRight1;
    public RendererModel head;
    public RendererModel clawLeft;
    public RendererModel clawLeft_1;
    public RendererModel antenna;

    public CoconutCrabModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.armLeft = new RendererModel(this, 20, 7);
        this.armLeft.mirror = true;
        this.armLeft.setRotationPoint(2.0F, 0.0F, -2.0F);
        this.armLeft.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(armLeft, 0.0F, -0.5235987755982988F, 0.17453292519943295F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 20.0F, 1.0F);
        this.body.addBox(-3.5F, -2.0F, -3.0F, 7, 4, 6, 0.0F);
        this.legLeft1 = new RendererModel(this, 30, 8);
        this.legLeft1.mirror = true;
        this.legLeft1.setRotationPoint(2.5F, 0.0F, -1.5F);
        this.legLeft1.addBox(0.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legLeft1, 0.0F, 0.6981317007977318F, 0.6981317007977318F);
        this.legRight1 = new RendererModel(this, 30, 8);
        this.legRight1.setRotationPoint(-2.5F, 0.0F, -1.5F);
        this.legRight1.addBox(-7.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legRight1, 0.0F, -0.6981317007977318F, -0.6981317007977318F);
        this.legRight2 = new RendererModel(this, 0, 10);
        this.legRight2.setRotationPoint(-2.5F, 0.0F, 0.2F);
        this.legRight2.addBox(-7.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legRight2, 0.0F, 0.0F, -0.6981317007977318F);
        this.legLeft3 = new RendererModel(this, 46, 10);
        this.legLeft3.mirror = true;
        this.legLeft3.setRotationPoint(2.5F, 0.0F, 1.5F);
        this.legLeft3.addBox(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
        this.setRotateAngle(legLeft3, 0.0F, -0.6108652381980153F, 1.0471975511965976F);
        this.clawLeft_1 = new RendererModel(this, 30, 18);
        this.clawLeft_1.setRotationPoint(0.0F, 0.0F, -5.5F);
        this.clawLeft_1.addBox(-1.5F, -0.5F, -4.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(clawLeft_1, 0.0F, -0.2617993877991494F, 0.0F);
        this.antenna = new RendererModel(this, 47, 14);
        this.antenna.setRotationPoint(0.0F, -1.0F, -3.5F);
        this.antenna.addBox(-1.0F, -0.5F, -5.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(antenna, -0.2617993877991494F, 0.0F, 0.0F);
        this.armRight = new RendererModel(this, 20, 7);
        this.armRight.setRotationPoint(-2.0F, 0.0F, -2.0F);
        this.armRight.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(armRight, 0.0F, 0.5235987755982988F, -0.17453292519943295F);
        this.legRight3 = new RendererModel(this, 46, 10);
        this.legRight3.setRotationPoint(-2.5F, 0.0F, 1.5F);
        this.legRight3.addBox(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
        this.setRotateAngle(legRight3, 0.0F, 0.6108652381980153F, -1.0471975511965976F);
        this.legLeft2 = new RendererModel(this, 0, 10);
        this.legLeft2.mirror = true;
        this.legLeft2.setRotationPoint(2.5F, 0.0F, 0.2F);
        this.legLeft2.addBox(0.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legLeft2, 0.0F, 0.0F, 0.6981317007977318F);
        this.head = new RendererModel(this, 26, 0);
        this.head.setRotationPoint(0.0F, -0.5F, -3.0F);
        this.head.addBox(-1.5F, -1.5F, -4.0F, 3, 3, 4, 0.0F);
        this.clawLeft = new RendererModel(this, 30, 18);
        this.clawLeft.mirror = true;
        this.clawLeft.setRotationPoint(0.0F, 0.0F, -5.5F);
        this.clawLeft.addBox(-1.5F, -0.5F, -4.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(clawLeft, 0.0F, 0.2617993877991494F, 0.0F);
        this.body.addChild(this.armLeft);
        this.body.addChild(this.legLeft1);
        this.body.addChild(this.legRight1);
        this.body.addChild(this.legRight2);
        this.body.addChild(this.legLeft3);
        this.armRight.addChild(this.clawLeft_1);
        this.head.addChild(this.antenna);
        this.body.addChild(this.armRight);
        this.body.addChild(this.legRight3);
        this.body.addChild(this.legLeft2);
        this.body.addChild(this.head);
        this.armLeft.addChild(this.clawLeft);
    }

    @Override
    public void render(CoconutCrabEntity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
       this.body.render(p_78088_7_);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;

    }

    @Override
    public void setLivingAnimations(CoconutCrabEntity p_212843_1_, float limbswing, float limbswingamount, float partialtick) {



    }

    @Override
    public void setRotationAngles(CoconutCrabEntity crabEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {

        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);


        this.legRight3.rotateAngleZ = (-(float)Math.PI / 4F);
        this.legLeft3.rotateAngleZ = ((float)Math.PI / 4F);
        this.legRight2.rotateAngleZ = -0.58119464F;
        this.legLeft2.rotateAngleZ = 0.58119464F;
        this.legRight1.rotateAngleZ = (-(float)Math.PI / 4F);
        this.legLeft1.rotateAngleZ = ((float)Math.PI / 4F);

        this.legRight3.rotateAngleY = ((float)Math.PI / 4F);
        this.legLeft3.rotateAngleY = (-(float)Math.PI / 4F);
        this.legRight2.rotateAngleY = (-(float)Math.PI / 8F);
        this.legLeft2.rotateAngleY = ((float)Math.PI / 8F);
        this.legRight1.rotateAngleY = (-(float)Math.PI / 4F);
        this.legLeft1.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        this.legRight3.rotateAngleY += f3;
        this.legLeft3.rotateAngleY += -f3;
        this.legRight2.rotateAngleY += f5;
        this.legLeft2.rotateAngleY += -f5;
        this.legRight1.rotateAngleY += f6;
        this.legLeft1.rotateAngleY += -f6;
        this.legRight3.rotateAngleZ += f7;
        this.legLeft3.rotateAngleZ += -f7;
        this.legRight2.rotateAngleZ += f9;
        this.legLeft2.rotateAngleZ += -f9;
        this.legRight1.rotateAngleZ += f10;
        this.legLeft1.rotateAngleZ += -f10;

    }
}

