package org.avp.client.model.entities.living;

import org.avp.common.entities.living.species.xenomorphs.EntityCrusher;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class ModelCrusher extends Model<EntityCrusher>
{
    public ModelRenderer sTorso, sTorso2, sRightThigh, sLeftThigh, sLeftShin, sRightShin, sLeftShin2, sRightShin2, sLeftFoot, sRightFoot, sLeftArm, sRightArm, sLeftClaw, sRightArm2, sNeck, sHead, sHead2, sJaw1, sLeftArm2, sRightClaw, sLeftClaw2, sRightClaw2, sVertibrae1, sTail1, sTail2, sTail3, sStabber, sTail4, sTail5, sVertibrae2, sSpike3, sSpike4, sSpike2, sSpike5, sHead4, crest0, crest1, crest2, crest3, crest4, crest5, sArmCrusher1, sArmCrusher;

    public ModelCrusher()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.sTorso = new ModelRenderer(this, 50, 0);
        this.sTorso.addBox(-4.5F, -2.0F, 0.0F, 10, 9, 11);
        this.sTorso.setRotationPoint(-1.0F, -7.5F, 0.0F);
        this.sTorso.setTextureSize(256, 128);
        this.sTorso.mirror = true;
        this.setRotation(this.sTorso, -0.117629F, 0.0F, 0.0F);
        this.sTorso2 = new ModelRenderer(this, 93, 0);
        this.sTorso2.addBox(-3.5F, -9.0F, 6.0F, 7, 6, 12);
        this.sTorso2.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.sTorso2.setTextureSize(256, 128);
        this.sTorso2.mirror = true;
        this.setRotation(this.sTorso2, -0.5585054F, 0.0F, 0.0F);
        this.sRightThigh = new ModelRenderer(this, 31, 0);
        this.sRightThigh.addBox(-1.5F, -4.0F, -2.5F, 4, 14, 5);
        this.sRightThigh.setRotationPoint(-4.5F, 2.0F, 16.0F);
        this.sRightThigh.setTextureSize(256, 128);
        this.sRightThigh.mirror = true;
        this.setRotation(this.sRightThigh, -0.8028515F, 0.2443461F, 0.418879F);
        this.sLeftThigh = new ModelRenderer(this, 132, 0);
        this.sLeftThigh.addBox(-2.5F, -4.0F, -2.5F, 4, 14, 5);
        this.sLeftThigh.setRotationPoint(4.5F, 2.0F, 16.0F);
        this.sLeftThigh.setTextureSize(256, 128);
        this.sLeftThigh.mirror = true;
        this.setRotation(this.sLeftThigh, -0.8028515F, -0.2443461F, -0.418879F);
        this.sLeftShin = new ModelRenderer(this, 155, 0);
        this.sLeftShin.addBox(-2.0F, 8.0F, -5.5F, 3, 3, 12);
        this.sLeftShin.setRotationPoint(4.5F, 2.0F, 16.0F);
        this.sLeftShin.setTextureSize(256, 128);
        this.sLeftShin.mirror = true;
        this.setRotation(this.sLeftShin, -0.4014257F, -0.2443461F, -0.418879F);
        this.sRightShin = new ModelRenderer(this, 186, 0);
        this.sRightShin.addBox(-1.0F, 8.0F, -5.5F, 3, 3, 12);
        this.sRightShin.setRotationPoint(-4.5F, 2.0F, 16.0F);
        this.sRightShin.setTextureSize(256, 128);
        this.sRightShin.mirror = true;
        this.setRotation(this.sRightShin, -0.4014257F, 0.2443461F, 0.418879F);
        this.sLeftShin2 = new ModelRenderer(this, 217, 0);
        this.sLeftShin2.addBox(-1.5F, 5.5F, 9.0F, 2, 9, 2);
        this.sLeftShin2.setRotationPoint(4.5F, 2.0F, 16.0F);
        this.sLeftShin2.setTextureSize(256, 128);
        this.sLeftShin2.mirror = true;
        this.setRotation(this.sLeftShin2, -0.8028515F, -0.2443461F, -0.418879F);
        this.sRightShin2 = new ModelRenderer(this, 226, 0);
        this.sRightShin2.addBox(-0.5F, 5.5F, 9.0F, 2, 9, 2);
        this.sRightShin2.setRotationPoint(-4.5F, 2.0F, 16.0F);
        this.sRightShin2.setTextureSize(256, 128);
        this.sRightShin2.mirror = true;
        this.setRotation(this.sRightShin2, -0.8028515F, 0.2443461F, 0.418879F);
        this.sLeftFoot = new ModelRenderer(this, 235, 0);
        this.sLeftFoot.addBox(5.0F, 15.0F, -7.0F, 2, 2, 5);
        this.sLeftFoot.setRotationPoint(4.5F, 2.0F, 16.0F);
        this.sLeftFoot.setTextureSize(256, 128);
        this.sLeftFoot.mirror = true;
        this.setRotation(this.sLeftFoot, 0.0F, -0.2443461F, 0.0F);
        this.sRightFoot = new ModelRenderer(this, 242, 8);
        this.sRightFoot.addBox(-7.0F, 15.0F, -7.0F, 2, 2, 5);
        this.sRightFoot.setRotationPoint(-4.5F, 2.0F, 16.0F);
        this.sRightFoot.setTextureSize(256, 128);
        this.sRightFoot.mirror = true;
        this.setRotation(this.sRightFoot, 0.0F, 0.2443461F, 0.0F);
        this.sLeftArm = new ModelRenderer(this, 243, 16);
        this.sLeftArm.addBox(-1.0F, -1.0F, 1.0F, 3, 13, 3);
        this.sLeftArm.setRotationPoint(5.5F, -5.0F, 1.0F);
        this.sLeftArm.setTextureSize(256, 128);
        this.sLeftArm.mirror = true;
        this.setRotation(this.sLeftArm, 0.1806261F, 0.0F, -0.2443461F);
        this.sRightArm = new ModelRenderer(this, 229, 12);
        this.sRightArm.addBox(-1.0F, -1.0F, 1.0F, 3, 13, 3);
        this.sRightArm.setRotationPoint(-5.5F, -5.0F, 1.0F);
        this.sRightArm.setTextureSize(256, 128);
        this.sRightArm.mirror = true;
        this.setRotation(this.sRightArm, 0.2792527F, -0.1092638F, 0.2246208F);
        this.sLeftClaw = new ModelRenderer(this, 217, 12);
        this.sLeftClaw.addBox(-1.0F, 11.0F, -13.5F, 2, 1, 3);
        this.sLeftClaw.setRotationPoint(5.5F, -5.0F, 1.0F);
        this.sLeftClaw.setTextureSize(256, 128);
        this.sLeftClaw.mirror = true;
        this.setRotation(this.sLeftClaw, 0.3665191F, 0.0F, -0.2443461F);
        this.sRightArm2 = new ModelRenderer(this, 198, 17);
        this.sRightArm2.addBox(-1.0F, 10.5F, -9.5F, 3, 3, 12);
        this.sRightArm2.setRotationPoint(-5.5F, -5.0F, 1.0F);
        this.sRightArm2.setTextureSize(256, 128);
        this.sRightArm2.mirror = true;
        this.setRotation(this.sRightArm2, 0.3665191F, 0.0F, 0.2443461F);
        this.sNeck = new ModelRenderer(this, 179, 16);
        this.sNeck.addBox(-2.0F, -2.0F, -1.0F, 4, 6, 5);
        this.sNeck.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.sNeck.setTextureSize(256, 128);
        this.sNeck.mirror = true;
        this.setRotation(this.sNeck, -0.1919862F, 0.0F, 0.0F);
        this.sHead = new ModelRenderer(this, 152, 21);
        this.sHead.addBox(-3.0F, -4.0F, -4.5F, 6, 10, 7);
        this.sHead.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.sHead.setTextureSize(256, 128);
        this.sHead.mirror = true;
        this.setRotation(this.sHead, -((float) Math.PI / 5F), 0.0F, 0.0F);
        this.sHead2 = new ModelRenderer(this, 131, 21);
        this.sHead2.addBox(-2.5F, 3.0F, -7.0F, 5, 3, 5);
        this.sHead2.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.sHead2.setTextureSize(256, 128);
        this.sHead2.mirror = true;
        this.setRotation(this.sHead2, -0.122173F, 0.0F, 0.0F);
        this.sJaw1 = new ModelRenderer(this, 95, 19);
        this.sJaw1.addBox(-1.5F, 4.1F, -8.1F, 3, 2, 5);
        this.sJaw1.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.sJaw1.setTextureSize(256, 128);
        this.sJaw1.mirror = true;
        this.setRotation(this.sJaw1, 0.122173F, 0.0F, 0.0F);
        this.sLeftArm2 = new ModelRenderer(this, 64, 21);
        this.sLeftArm2.addBox(-1.0F, 10.5F, -10.5F, 3, 3, 12);
        this.sLeftArm2.setRotationPoint(5.5F, -5.0F, 1.0F);
        this.sLeftArm2.setTextureSize(256, 128);
        this.sLeftArm2.mirror = true;
        this.setRotation(this.sLeftArm2, 0.3665191F, 0.0F, -0.2443461F);
        this.sRightClaw = new ModelRenderer(this, 158, 16);
        this.sRightClaw.addBox(-1.0F, 11.0F, -12.5F, 2, 1, 3);
        this.sRightClaw.setRotationPoint(-5.5F, -5.0F, 1.0F);
        this.sRightClaw.setTextureSize(256, 128);
        this.sRightClaw.mirror = true;
        this.setRotation(this.sRightClaw, 0.3665191F, 0.0F, 0.2443461F);
        this.sLeftClaw2 = new ModelRenderer(this, 45, 21);
        this.sLeftClaw2.addBox(-2.0F, 11.5F, -16.5F, 3, 0, 6);
        this.sLeftClaw2.setRotationPoint(5.5F, -5.0F, 1.0F);
        this.sLeftClaw2.setTextureSize(256, 128);
        this.sLeftClaw2.mirror = true;
        this.setRotation(this.sLeftClaw2, 0.3665191F, 0.0F, -0.2443461F);
        this.sRightClaw2 = new ModelRenderer(this, 26, 20);
        this.sRightClaw2.addBox(-1.0F, 11.5F, -15.5F, 3, 0, 6);
        this.sRightClaw2.setRotationPoint(-5.5F, -5.0F, 1.0F);
        this.sRightClaw2.setTextureSize(256, 128);
        this.sRightClaw2.mirror = true;
        this.setRotation(this.sRightClaw2, 0.3665191F, 0.0F, 0.2443461F);
        this.sVertibrae1 = new ModelRenderer(this, 43, 28);
        this.sVertibrae1.addBox(0.0F, -10.0F, 0.0F, 0, 8, 10);
        this.sVertibrae1.setRotationPoint(0.0F, -7.5F, 0.0F);
        this.sVertibrae1.setTextureSize(256, 128);
        this.sVertibrae1.mirror = true;
        this.setRotation(this.sVertibrae1, -0.1919862F, 0.0F, 0.0F);
        this.sTail1 = new ModelRenderer(this, 21, 70);
        this.sTail1.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 11);
        this.sTail1.setRotationPoint(0.0F, 1.5F, 18.5F);
        this.sTail1.setTextureSize(256, 128);
        this.sTail1.mirror = true;
        this.setRotation(this.sTail1, -0.3665191F, 0.0F, 0.0F);
        this.sTail2 = new ModelRenderer(this, 5, 27);
        this.sTail2.addBox(-2.0F, -1.5F, 11.0F, 4, 4, 11);
        this.sTail2.setRotationPoint(0.0F, 1.5F, 18.5F);
        this.sTail2.setTextureSize(256, 128);
        this.sTail2.mirror = true;
        this.setRotation(this.sTail2, -((float) Math.PI / 10F), 0.0F, 0.0F);
        this.sTail3 = new ModelRenderer(this, 7, 43);
        this.sTail3.addBox(-1.5F, 1.5F, 21.0F, 3, 3, 11);
        this.sTail3.setRotationPoint(0.0F, 1.5F, 18.5F);
        this.sTail3.setTextureSize(256, 128);
        this.sTail3.mirror = true;
        this.setRotation(this.sTail3, -0.2094395F, 0.0F, 0.0F);
        this.sStabber = new ModelRenderer(this, 95, 27);
        this.sStabber.addBox(-1.5F, 9.0F, 52.0F, 3, 0, 11);
        this.sStabber.setRotationPoint(0.0F, 1.5F, 18.5F);
        this.sStabber.setTextureSize(256, 128);
        this.sStabber.mirror = true;
        this.setRotation(this.sStabber, -0.0523599F, 0.0F, 0.0F);
        this.sTail4 = new ModelRenderer(this, 64, 37);
        this.sTail4.addBox(-1.0F, 4.0F, 31.0F, 2, 2, 11);
        this.sTail4.setRotationPoint(0.0F, 1.5F, 18.5F);
        this.sTail4.setTextureSize(256, 128);
        this.sTail4.mirror = true;
        this.setRotation(this.sTail4, -0.1396263F, 0.0F, 0.0F);
        this.sTail5 = new ModelRenderer(this, 124, 30);
        this.sTail5.addBox(-0.5F, 8.5F, 41.0F, 1, 1, 11);
        this.sTail5.setRotationPoint(0.0F, 1.5F, 18.5F);
        this.sTail5.setTextureSize(256, 128);
        this.sTail5.mirror = true;
        this.setRotation(this.sTail5, -0.0523599F, 0.0F, 0.0F);
        this.sVertibrae2 = new ModelRenderer(this, 101, 39);
        this.sVertibrae2.addBox(0.0F, 6.8F, 40.8F, 0, 2, 11);
        this.sVertibrae2.setRotationPoint(0.0F, 1.5F, 18.5F);
        this.sVertibrae2.setTextureSize(256, 128);
        this.sVertibrae2.mirror = true;
        this.setRotation(this.sVertibrae2, -0.0523599F, 0.0F, 0.0F);
        this.sSpike3 = new ModelRenderer(this, 0, 43);
        this.sSpike3.addBox(0.0F, -15.0F, 0.0F, 2, 19, 1);
        this.sSpike3.setRotationPoint(4.0F, -10.33333F, 8.0F);
        this.sSpike3.setTextureSize(256, 128);
        this.sSpike3.mirror = true;
        this.setRotation(this.sSpike3, 0.3490659F, -((float) Math.PI / 2F), 0.1745329F);
        this.sSpike4 = new ModelRenderer(this, 0, 64);
        this.sSpike4.addBox(0.0F, -15.0F, 0.0F, 2, 19, 1);
        this.sSpike4.setRotationPoint(-4.0F, -10.33333F, 8.0F);
        this.sSpike4.setTextureSize(256, 128);
        this.sSpike4.mirror = true;
        this.setRotation(this.sSpike4, -0.3490659F, -((float) Math.PI / 2F), 0.1745329F);
        this.sSpike2 = new ModelRenderer(this, 0, 85);
        this.sSpike2.addBox(0.0F, -15.0F, 0.0F, 2, 16, 1);
        this.sSpike2.setRotationPoint(3.0F, -6.333333F, 10.0F);
        this.sSpike2.setTextureSize(256, 128);
        this.sSpike2.mirror = true;
        this.setRotation(this.sSpike2, 0.4014257F, -1.902409F, 0.4537856F);
        this.sSpike5 = new ModelRenderer(this, 7, 58);
        this.sSpike5.addBox(0.0F, -15.0F, 0.0F, 2, 16, 1);
        this.sSpike5.setRotationPoint(-3.0F, -6.333333F, 10.0F);
        this.sSpike5.setTextureSize(256, 128);
        this.sSpike5.mirror = true;
        this.setRotation(this.sSpike5, -0.4014257F, -1.239184F, 0.4537856F);
        this.sHead4 = new ModelRenderer(this, 36, 47);
        this.sHead4.addBox(-2.5F, -19.0F, -5.2F, 5, 16, 6);
        this.sHead4.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.sHead4.setTextureSize(256, 128);
        this.sHead4.mirror = true;
        this.setRotation(this.sHead4, -0.7960354F, 0.0F, 0.0F);
        this.crest0 = new ModelRenderer(this, 5, 20);
        this.crest0.addBox(-4.0F, -3.0F, -5.0F, 8, 4, 2);
        this.crest0.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.crest0.setTextureSize(256, 128);
        this.crest0.mirror = true;
        this.setRotation(this.crest0, -0.4029748F, 0.0F, 0.0F);
        this.crest1 = new ModelRenderer(this, 80, 53);
        this.crest1.addBox(-5.0F, -6.0F, -5.2F, 10, 4, 2);
        this.crest1.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.crest1.setTextureSize(256, 128);
        this.crest1.mirror = true;
        this.setRotation(this.crest1, -0.5516893F, 0.0F, 0.0F);
        this.crest2 = new ModelRenderer(this, 80, 60);
        this.crest2.addBox(-5.0F, -10.0F, -6.0F, 10, 5, 2);
        this.crest2.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.crest2.setTextureSize(256, 128);
        this.crest2.mirror = true;
        this.setRotation(this.crest2, -0.7004037F, 0.0F, 0.0F);
        this.crest3 = new ModelRenderer(this, 105, 57);
        this.crest3.addBox(-6F, -12F, -6F, 12, 4, 2);
        this.crest3.setRotationPoint(0F, -5.5F, -2.2F);
        this.crest3.setTextureSize(256, 128);
        this.crest3.mirror = true;
        this.crest3.offsetY = -0.22F;
        setRotation(crest3, -0.8119396F, 0F, 0F);
        this.crest4 = new ModelRenderer(this, 134, 57);
        this.crest4.addBox(-7.0F, -17.0F, -5.0F, 14, 5, 2);
        this.crest4.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.crest4.setTextureSize(256, 128);
        this.crest4.mirror = true;
        this.crest4.offsetY = -0.1F;
        this.setRotation(this.crest4, -0.7375823F, 0.0F, 0.0F);
        this.crest5 = new ModelRenderer(this, 167, 57);
        this.crest5.addBox(-6.0F, -19.5F, -9.0F, 12, 4, 2);
        this.crest5.setRotationPoint(0.0F, -7.5F, -2.2F);
        this.crest5.setTextureSize(256, 128);
        this.crest5.mirror = true;
        this.setRotation(this.crest5, -0.9234754F, 0.0F, 0.0F);
        this.sArmCrusher1 = new ModelRenderer(this, 212, 36);
        this.sArmCrusher1.addBox(0.0F, 0.0F, 0.0F, 3, 11, 4);
        this.sArmCrusher1.setRotationPoint(6.066667F, -11.0F, -1.733333F);
        this.sArmCrusher1.setTextureSize(256, 128);
        this.sArmCrusher1.mirror = true;
        this.setRotation(this.sArmCrusher1, 0.1318525F, -0.7304083F, 0.1336492F);
        this.sArmCrusher = new ModelRenderer(this, 195, 36);
        this.sArmCrusher.addBox(0.0F, 0.0F, 0.0F, 3, 11, 4);
        this.sArmCrusher.setRotationPoint(-8.866667F, -10.5F, 0.3333333F);
        this.sArmCrusher.setTextureSize(256, 128);
        this.sArmCrusher.mirror = true;
        this.setRotation(this.sArmCrusher, 0.1213327F, 0.7502525F, -0.1919862F);
    }

    @Override
    public void render(EntityCrusher obj)
    {
        this.sSpike3.rotateAngleX = 0.52F + Math.abs(0.0F);
        this.sSpike4.rotateAngleX = -0.8F - Math.abs(0.0F);
        this.sSpike2.rotateAngleX = 0.35F + Math.abs(0.2F);
        this.sSpike5.rotateAngleX = -1.3F - Math.abs(0.0F);
        this.sJaw1.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.sHead.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.sHead2.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.sHead2.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.sHead4.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.crest5.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.crest0.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.crest1.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.crest2.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.crest3.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.crest4.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.sLeftThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.sLeftShin.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.4014257F;
        this.sLeftShin2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.sLeftFoot.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj);
        this.sRightThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.sRightShin.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) - 0.4014257F;
        this.sRightShin2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.sRightFoot.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj);
        this.sRightArm.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.sRightArm2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.sRightClaw.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.sRightClaw2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.sLeftArm.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.sLeftArm2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.sLeftClaw.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.sLeftClaw2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;   

        draw(sTorso);
        draw(sTorso2);
        draw(sRightThigh);
        draw(sLeftThigh);
        draw(sLeftShin);
        draw(sRightShin);
        draw(sLeftShin2);
        draw(sRightShin2);
        draw(sLeftFoot);
        draw(sRightFoot);
        draw(sLeftArm);
        draw(sRightArm);
        draw(sLeftClaw);
        draw(sRightArm2);
        draw(sNeck);
        draw(sHead);
        draw(sHead2);
        draw(sJaw1);
        draw(sLeftArm2);
        draw(sRightClaw);
        draw(sLeftClaw2);
        draw(sRightClaw2);
        draw(sVertibrae1);
        draw(sTail1);
        draw(sTail2);
        draw(sTail3);
        draw(sStabber);
        draw(sTail4);
        draw(sTail5);
        draw(sVertibrae2);
        draw(sSpike3);
        draw(sSpike4);
        draw(sSpike2);
        draw(sSpike5);
        draw(sHead4);
        draw(crest0);
        draw(crest1);
        draw(crest2);
        draw(crest3);
        draw(crest4);
        draw(crest5);
        draw(sArmCrusher1);
        draw(sArmCrusher);     
    }
}
