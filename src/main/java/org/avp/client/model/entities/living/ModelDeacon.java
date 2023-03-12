package org.avp.client.model.entities.living;

import org.avp.common.entities.living.species.species223ode.EntityDeacon;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelDeacon extends Model<EntityDeacon>
{
    public ModelRenderer chest;
    public ModelRenderer stomach;
    public ModelRenderer lShoulder;
    public ModelRenderer rShoulder;
    public ModelRenderer neck;
    public ModelRenderer lThigh;
    public ModelRenderer rThigh;
    public ModelRenderer lShin;
    public ModelRenderer lHipBone;
    public ModelRenderer lFoot;
    public ModelRenderer lToes;
    public ModelRenderer rShin;
    public ModelRenderer rHipBone;
    public ModelRenderer rFoot;
    public ModelRenderer rToes;
    public ModelRenderer lUpperArm;
    public ModelRenderer lLowerArm;
    public ModelRenderer lHand;
    public ModelRenderer lFinger01;
    public ModelRenderer lFinger02;
    public ModelRenderer lFinger03;
    public ModelRenderer lFinger04;
    public ModelRenderer lFinger05;
    public ModelRenderer rUpperArm;
    public ModelRenderer rLowerArm;
    public ModelRenderer rHand;
    public ModelRenderer rFinger01;
    public ModelRenderer rFinger02;
    public ModelRenderer rFinger03;
    public ModelRenderer rFinger04;
    public ModelRenderer rFinger05;
    public ModelRenderer head;
    public ModelRenderer head02;
    public ModelRenderer headSlope01;
    public ModelRenderer muzzle;
    public ModelRenderer lowerJaw;
    public ModelRenderer innerJaw;
    public ModelRenderer head03;
    public ModelRenderer head04;
    public ModelRenderer head05;
    public ModelRenderer headSlope02;
    public ModelRenderer headSlope03;
    public ModelRenderer headSlope04;
    public ModelRenderer upperJaw;
    public ModelRenderer lowerJaw02;
    public ModelRenderer innerJaw02;

    public ModelDeacon()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rFoot = new ModelRenderer(this, 38, 33);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(0.0F, 1.0F, 10.2F);
        this.rFoot.addBox(-1.5F, -0.7F, -1.0F, 3, 5, 2, 0.0F);
        this.setRotation(rFoot, 0.5009094953223726F, 0.136659280431156F, 0.045553093477052F);
        this.lFinger02 = new ModelRenderer(this, 65, 39);
        this.lFinger02.setRotationPoint(0.7F, 3.0F, -0.9F);
        this.lFinger02.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(lFinger02, 0.27314402793711257F, 0.0F, -0.045553093477052F);
        this.rHipBone = new ModelRenderer(this, 69, 52);
        this.rHipBone.mirror = true;
        this.rHipBone.setRotationPoint(0.5F, 0.6F, 0.0F);
        this.rHipBone.addBox(-0.9F, -3.3F, -3.0F, 2, 4, 6, 0.0F);
        this.setRotation(rHipBone, 0.6373942428283291F, 0.22759093446006054F, -0.4553564018453205F);
        this.head02 = new ModelRenderer(this, 89, 14);
        this.head02.setRotationPoint(0.0F, -2.9F, 2.6F);
        this.head02.addBox(-2.5F, -2.0F, 0.0F, 5, 3, 3, 0.0F);
        this.rFinger01 = new ModelRenderer(this, 65, 39);
        this.rFinger01.setRotationPoint(-1.3F, 2.7F, -0.9F);
        this.rFinger01.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(rFinger01, 0.27314402793711257F, 0.0F, 0.136659280431156F);
        this.lLowerArm = new ModelRenderer(this, 62, 21);
        this.lLowerArm.setRotationPoint(0.0F, 6.6F, 0.0F);
        this.lLowerArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotation(lLowerArm, -0.40980330836826856F, 0.0F, 0.091106186954104F);
        this.rFinger03 = new ModelRenderer(this, 65, 39);
        this.rFinger03.setRotationPoint(0.3F, 3.0F, -0.9F);
        this.rFinger03.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(rFinger03, 0.27314402793711257F, 0.0F, -0.045553093477052F);
        this.lHand = new ModelRenderer(this, 63, 33);
        this.lHand.setRotationPoint(0.0F, 6.8F, -0.4F);
        this.lHand.addBox(-1.5F, 0.0F, -0.5F, 3, 4, 1, 0.0F);
        this.setRotation(lHand, 0.0F, -0.27314402793711257F, 0.0F);
        this.headSlope03 = new ModelRenderer(this, 118, 45);
        this.headSlope03.setRotationPoint(0.0F, 0.4F, 2.3F);
        this.headSlope03.addBox(-1.0F, -0.5F, -0.7F, 2, 1, 3, 0.0F);
        this.head03 = new ModelRenderer(this, 90, 24);
        this.head03.setRotationPoint(0.0F, -0.3F, 2.5F);
        this.head03.addBox(-2.0F, -1.5F, -0.3F, 4, 2, 3, 0.0F);
        this.setRotation(head03, -0.091106186954104F, 0.0F, 0.0F);
        this.head04 = new ModelRenderer(this, 91, 31);
        this.head04.setRotationPoint(0.0F, -0.4F, 2.5F);
        this.head04.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotation(head04, -0.091106186954104F, 0.0F, 0.0F);
        this.lShoulder = new ModelRenderer(this, 59, 0);
        this.lShoulder.setRotationPoint(3.4F, 1.0F, -0.6F);
        this.lShoulder.addBox(-1.8F, -1.0F, -1.3F, 3, 4, 3, 0.0F);
        this.setRotation(lShoulder, 0.091106186954104F, 0.0F, -0.31869712141416456F);
        this.head = new ModelRenderer(this, 85, 0);
        this.head.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.head.addBox(-2.5F, -5.0F, -3.0F, 5, 5, 6, 0.0F);
        this.setRotation(head, 0.091106186954104F, 0.0F, 0.0F);
        this.lFinger03 = new ModelRenderer(this, 65, 39);
        this.lFinger03.setRotationPoint(-0.3F, 3.0F, -0.9F);
        this.lFinger03.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(lFinger03, 0.27314402793711257F, 0.0F, 0.045553093477052F);
        this.head05 = new ModelRenderer(this, 92, 38);
        this.head05.setRotationPoint(0.0F, -0.1F, 1.8F);
        this.head05.addBox(-1.0F, -0.8F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotation(head05, -0.136659280431156F, 0.0F, 0.0F);
        this.stomach = new ModelRenderer(this, 0, 18);
        this.stomach.setRotationPoint(0.0F, 6.6F, 0.8F);
        this.stomach.addBox(-2.5F, 0.0F, -3.5F, 5, 8, 5, 0.0F);
        this.setRotation(stomach, -0.136659280431156F, 0.0F, 0.0F);
        this.muzzle = new ModelRenderer(this, 0, 49);
        this.muzzle.setRotationPoint(0.0F, -3.9F, -2.4F);
        this.muzzle.addBox(-2.0F, -1.1F, -3.1F, 4, 2, 3, 0.0F);
        this.setRotation(muzzle, 0.5009094953223726F, 0.0F, 0.0F);
        this.rShin = new ModelRenderer(this, 31, 19);
        this.rShin.mirror = true;
        this.rShin.setRotationPoint(-0.2F, 10.4F, 0.0F);
        this.rShin.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        this.setRotation(rShin, -0.6829473363053812F, 0.045553093477052F, -0.091106186954104F);
        this.lowerJaw = new ModelRenderer(this, 19, 48);
        this.lowerJaw.setRotationPoint(0.0F, -1.4F, -2.9F);
        this.lowerJaw.addBox(-1.83F, 0.0F, -2.6F, 3, 1, 4, 0.0F);
        this.lowerJaw02 = new ModelRenderer(this, 19, 56);
        this.lowerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerJaw02.addBox(0.83F, 0.0F, -2.6F, 1, 1, 4, 0.0F);
        this.rToes = new ModelRenderer(this, 36, 42);
        this.rToes.mirror = true;
        this.rToes.setRotationPoint(0.0F, 3.7F, 0.1F);
        this.rToes.addBox(-1.6F, -1.0F, -2.6F, 3, 2, 3, 0.0F);
        this.setRotation(rToes, 0.5462880558742251F, 0.0F, 0.0F);
        this.rLowerArm = new ModelRenderer(this, 62, 21);
        this.rLowerArm.mirror = true;
        this.rLowerArm.setRotationPoint(0.0F, 6.6F, 0.0F);
        this.rLowerArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotation(rLowerArm, -0.40980330836826856F, 0.0F, -0.091106186954104F);
        this.headSlope02 = new ModelRenderer(this, 103, 45);
        this.headSlope02.setRotationPoint(0.0F, -0.1F, 4.6F);
        this.headSlope02.addBox(-1.5F, -1.0F, -0.7F, 3, 2, 3, 0.0F);
        this.setRotation(headSlope02, -0.18203784098300857F, 0.0F, 0.0F);
        this.upperJaw = new ModelRenderer(this, 0, 55);
        this.upperJaw.setRotationPoint(0.0F, 1.2F, -1.0F);
        this.upperJaw.addBox(-2.0F, -1.0F, -2.97F, 4, 2, 3, 0.0F);
        this.setRotation(upperJaw, -0.5009094953223726F, 0.0F, 0.0F);
        this.lFinger01 = new ModelRenderer(this, 65, 39);
        this.lFinger01.setRotationPoint(1.3F, 2.7F, -0.9F);
        this.lFinger01.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(lFinger01, 0.27314402793711257F, 0.0F, -0.136659280431156F);
        this.rFinger04 = new ModelRenderer(this, 65, 39);
        this.rFinger04.setRotationPoint(1.2F, 2.7F, -0.9F);
        this.rFinger04.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(rFinger04, 0.27314402793711257F, 0.0F, -0.136659280431156F);
        this.rUpperArm = new ModelRenderer(this, 62, 10);
        this.rUpperArm.mirror = true;
        this.rUpperArm.setRotationPoint(0.0F, 2.4F, 0.2F);
        this.rUpperArm.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotation(rUpperArm, -0.136659280431156F, 0.0F, 0.0F);
        this.innerJaw02 = new ModelRenderer(this, 41, 56);
        this.innerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.innerJaw02.addBox(0.82F, -1.0F, -4.0F, 1, 2, 4, 0.0F);
        this.innerJaw = new ModelRenderer(this, 39, 48);
        this.innerJaw.setRotationPoint(0.0F, -1.8F, -1.3F);
        this.innerJaw.addBox(-1.82F, -1.0F, -4.0F, 3, 2, 4, 0.0F);
        this.lFinger05 = new ModelRenderer(this, 71, 39);
        this.lFinger05.setRotationPoint(-1.4F, 2.0F, 0.0F);
        this.lFinger05.addBox(0.0F, 0.0F, -1.0F, 0, 4, 2, 0.0F);
        this.setRotation(lFinger05, 0.27314402793711257F, 0.0F, 0.18203784098300857F);
        this.rHand = new ModelRenderer(this, 63, 33);
        this.rHand.mirror = true;
        this.rHand.setRotationPoint(0.0F, 6.8F, -0.4F);
        this.rHand.addBox(-1.5F, 0.0F, -0.5F, 3, 4, 1, 0.0F);
        this.setRotation(rHand, 0.0F, 0.27314402793711257F, 0.0F);
        this.rThigh = new ModelRenderer(this, 35, 0);
        this.rThigh.mirror = true;
        this.rThigh.setRotationPoint(-2.5F, 6.5F, -0.3F);
        this.rThigh.addBox(-1.5F, -1.0F, -2.0F, 3, 13, 4, 0.0F);
        this.setRotation(rThigh, -0.40980330836826856F, 0.045553093477052F, 0.18203784098300857F);
        this.rFinger05 = new ModelRenderer(this, 71, 39);
        this.rFinger05.setRotationPoint(1.4F, 2.0F, 0.0F);
        this.rFinger05.addBox(0.0F, 0.0F, -1.0F, 0, 4, 2, 0.0F);
        this.setRotation(rFinger05, 0.27314402793711257F, 0.0F, -0.18203784098300857F);
        this.lToes = new ModelRenderer(this, 36, 42);
        this.lToes.setRotationPoint(0.0F, 3.7F, 0.1F);
        this.lToes.addBox(-1.4F, -1.0F, -2.6F, 3, 2, 3, 0.0F);
        this.setRotation(lToes, 0.5462880558742251F, 0.0F, 0.0F);
        this.lThigh = new ModelRenderer(this, 35, 0);
        this.lThigh.setRotationPoint(2.5F, 6.5F, -0.3F);
        this.lThigh.addBox(-1.5F, -1.0F, -2.0F, 3, 13, 4, 0.0F);
        this.setRotation(lThigh, -0.40980330836826856F, -0.045553093477052F, -0.18203784098300857F);
        this.headSlope04 = new ModelRenderer(this, 118, 52);
        this.headSlope04.setRotationPoint(0.0F, 0.0F, 1.6F);
        this.headSlope04.addBox(-0.5F, -0.5F, -0.3F, 1, 1, 2, 0.0F);
        this.setRotation(headSlope04, -0.091106186954104F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 38);
        this.neck.setRotationPoint(0.0F, 0.5F, -0.4F);
        this.neck.addBox(-2.0F, -3.1F, -2.5F, 4, 3, 5, 0.0F);
        this.setRotation(neck, -0.136659280431156F, 0.0F, 0.0F);
        this.rFinger02 = new ModelRenderer(this, 65, 39);
        this.rFinger02.setRotationPoint(-0.7F, 3.0F, -0.9F);
        this.rFinger02.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(rFinger02, 0.27314402793711257F, 0.0F, 0.045553093477052F);
        this.headSlope01 = new ModelRenderer(this, 85, 45);
        this.headSlope01.setRotationPoint(0.0F, -1.4F, 0.9F);
        this.headSlope01.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 4, 0.0F);
        this.setRotation(headSlope01, 0.18203784098300857F, 0.0F, 0.0F);
        this.rShoulder = new ModelRenderer(this, 59, 0);
        this.rShoulder.mirror = true;
        this.rShoulder.setRotationPoint(-3.4F, 1.0F, -0.6F);
        this.rShoulder.addBox(-1.2F, -1.0F, -1.3F, 3, 4, 3, 0.0F);
        this.setRotation(rShoulder, 0.091106186954104F, 0.0F, 0.31869712141416456F);
        this.lShin = new ModelRenderer(this, 31, 19);
        this.lShin.setRotationPoint(0.2F, 10.4F, 0.0F);
        this.lShin.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        this.setRotation(lShin, -0.6829473363053812F, -0.045553093477052F, 0.091106186954104F);
        this.lFinger04 = new ModelRenderer(this, 65, 39);
        this.lFinger04.setRotationPoint(-1.2F, 2.7F, -0.9F);
        this.lFinger04.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(lFinger04, 0.27314402793711257F, 0.0F, 0.136659280431156F);
        this.lHipBone = new ModelRenderer(this, 69, 52);
        this.lHipBone.setRotationPoint(0.5F, 0.7F, 0.0F);
        this.lHipBone.addBox(-2.1F, -2.9F, -3.0F, 2, 4, 6, 0.0F);
        this.setRotation(lHipBone, 0.6373942428283291F, -0.22759093446006054F, 0.4553564018453205F);
        this.chest = new ModelRenderer(this, 0, 0);
        this.chest.setRotationPoint(0.0F, -11.8F, 0.0F);
        this.chest.addBox(-3.0F, 0.0F, -4.0F, 6, 7, 7, 0.0F);
        this.setRotation(chest, 0.18203784098300857F, 0.0F, 0.0F);
        this.lFoot = new ModelRenderer(this, 38, 33);
        this.lFoot.setRotationPoint(0.0F, 1.0F, 10.2F);
        this.lFoot.addBox(-1.5F, -0.7F, -1.0F, 3, 5, 2, 0.0F);
        this.setRotation(lFoot, 0.5009094953223726F, -0.136659280431156F, -0.045553093477052F);
        this.lUpperArm = new ModelRenderer(this, 62, 10);
        this.lUpperArm.setRotationPoint(0.0F, 2.4F, 0.2F);
        this.lUpperArm.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotation(lUpperArm, -0.136659280431156F, 0.0F, 0.0F);
        this.rShin.addChild(this.rFoot);
        this.lHand.addChild(this.lFinger02);
        this.rThigh.addChild(this.rHipBone);
        this.head.addChild(this.head02);
        this.rHand.addChild(this.rFinger01);
        this.lUpperArm.addChild(this.lLowerArm);
        this.rHand.addChild(this.rFinger03);
        this.lLowerArm.addChild(this.lHand);
        this.headSlope02.addChild(this.headSlope03);
        this.head02.addChild(this.head03);
        this.head03.addChild(this.head04);
        this.chest.addChild(this.lShoulder);
        this.neck.addChild(this.head);
        this.lHand.addChild(this.lFinger03);
        this.head04.addChild(this.head05);
        this.chest.addChild(this.stomach);
        this.head.addChild(this.muzzle);
        this.rThigh.addChild(this.rShin);
        this.head.addChild(this.lowerJaw);
        this.lowerJaw.addChild(this.lowerJaw02);
        this.rFoot.addChild(this.rToes);
        this.rUpperArm.addChild(this.rLowerArm);
        this.headSlope01.addChild(this.headSlope02);
        this.muzzle.addChild(this.upperJaw);
        this.lHand.addChild(this.lFinger01);
        this.rHand.addChild(this.rFinger04);
        this.rShoulder.addChild(this.rUpperArm);
        this.innerJaw.addChild(this.innerJaw02);
        this.head.addChild(this.innerJaw);
        this.lHand.addChild(this.lFinger05);
        this.rLowerArm.addChild(this.rHand);
        this.stomach.addChild(this.rThigh);
        this.rHand.addChild(this.rFinger05);
        this.lFoot.addChild(this.lToes);
        this.stomach.addChild(this.lThigh);
        this.headSlope03.addChild(this.headSlope04);
        this.chest.addChild(this.neck);
        this.rHand.addChild(this.rFinger02);
        this.head.addChild(this.headSlope01);
        this.chest.addChild(this.rShoulder);
        this.lThigh.addChild(this.lShin);
        this.lHand.addChild(this.lFinger04);
        this.lThigh.addChild(this.lHipBone);
        this.lShin.addChild(this.lFoot);
        this.lShoulder.addChild(this.lUpperArm);
    }

    @Override
    public void render(EntityDeacon obj)
    {
        this.lThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F) * 0.2F * swingProgressPrev(obj) - 0.5028515F;
        this.lShin.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F) * 0.2F * swingProgressPrev(obj) - 0.6F;
        this.lFoot.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F) * 0.2F * swingProgressPrev(obj) + 0.75F;
        this.lToes.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F) * 0.2F * swingProgressPrev(obj) + 0.3F;

        this.rThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F + (float) Math.PI) * 0.2F * swingProgressPrev(obj) - 0.5028515F;
        this.rShin.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F + (float) Math.PI) * 0.2F * swingProgressPrev(obj) - 0.6F;
        this.rFoot.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F + (float) Math.PI) * 0.2F * swingProgressPrev(obj) + 0.75F;
        this.rToes.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6562F + (float) Math.PI) * 0.2F * swingProgressPrev(obj) + 0.3F;
        
        this.rShoulder.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 0.3F * swingProgressPrev(obj);
        this.rLowerArm.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 0.3F * swingProgressPrev(obj) - 0.6F;
        this.lShoulder.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 0.3F * swingProgressPrev(obj);
        this.lLowerArm.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 0.3F * swingProgressPrev(obj) - 0.6F;
        
        this.chest.render(DEFAULT_SCALE);
    }
}
