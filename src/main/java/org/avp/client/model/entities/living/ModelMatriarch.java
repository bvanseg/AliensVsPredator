package org.avp.client.model.entities.living;

import org.avp.AliensVsPredator;
import org.avp.entities.living.species.xenomorphs.EntityMatriarch;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelMatriarch extends Model
{
    public ModelRenderer sack0,
            torso0,
            sack1,
            sack2,
            sack3,
            sack4,
            sack5,
            sack6,
            sack7,
            torso1,
            bSpines0,
            neck,
            bSpines1,
            lArm0,
            rArm0,
            lArmMini0,
            rArmMini0,
            lBStabber0,
            rBStabber0,
            tail0,
            lThigh,
            rThigh,
            lBStabber1,
            rBStabber1,
            lBStabber2,
            rBStabber2,
            tail1,
            tailSpines0,
            tail2,
            tailSpines1,
            tail3,
            tailSpines2,
            tail4,
            tailSpines3,
            tailSpines4,
            tailStabber,
            lShin0,
            lShinSpike,
            lHip,
            lShin1,
            lFoot,
            rShin0,
            rShinSpike,
            rHip,
            rShin1,
            rFoot,
            head0,
            head1,
            Jaw1,
            headFinL0,
            headFinR0,
            headBase0,
            headWebL,
            headWebR,
            headFinL1,
            headFinR1,
            headFinL2,
            headFinR2,
            headSpinesM,
            headSpinesL,
            headSpinesR,
            lowerJaw,
            innerJaw,
            lArm1,
            lHand,
            lClaw,
            rArm1,
            rHand,
            rClaw,
            lArmMini1,
            lHandMini,
            lClawMini,
            rArmMini1,
            rHandMini,
            rClawMini;

    public ModelMatriarch()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.torso1 = new ModelRenderer(this, 39, 0);
        this.torso1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.torso1.addBox(-3.5F, -1.5F, 8.0F, 7, 6, 12, 0.0F);
        this.setRotation(torso1, 0.15707963267948966F, 0.0F, 0.0F);
        this.sack2 = new ModelRenderer(this, 149, 64);
        this.sack2.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.sack2.addBox(-5.0F, -5.0F, 0.0F, 10, 10, 11, 0.0F);
        this.setRotation(sack2, 0.17453292519943295F, 0.0F, 0.0F);
        this.rBStabber1 = new ModelRenderer(this, 237, 11);
        this.rBStabber1.mirror = true;
        this.rBStabber1.setRotationPoint(-0.1F, 0.6F, 12.0F);
        this.rBStabber1.addBox(0.0F, -19.0F, -1.0F, 0, 18, 2, 0.0F);
        this.setRotation(rBStabber1, 0.05235987755982988F, 0.3490658503988659F, -0.6981317007977318F);
        this.neck = new ModelRenderer(this, 0, 77);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-2.0F, -1.6F, -4.8F, 4, 5, 5, 0.0F);
        this.setRotation(neck, 0.3141592653589793F, 0.0F, 0.0F);
        this.rClaw = new ModelRenderer(this, 204, 23);
        this.rClaw.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.rClaw.addBox(-1.3F, 0.0F, -6.0F, 3, 0, 6, 0.0F);
        this.rThigh = new ModelRenderer(this, 185, 0);
        this.rThigh.setRotationPoint(-3.5F, 4.6F, 17.5F);
        this.rThigh.addBox(-2.5F, -2.0F, -2.5F, 4, 17, 5, 0.0F);
        this.setRotation(rThigh, -0.3141592653589793F, 0.24434609527920614F, 0.41887902047863906F);
        this.lBStabber1 = new ModelRenderer(this, 237, 11);
        this.lBStabber1.setRotationPoint(0.1F, 0.6F, 12.0F);
        this.lBStabber1.addBox(0.0F, -19.0F, -1.0F, 0, 18, 2, 0.0F);
        this.setRotation(lBStabber1, 0.05235987755982988F, -0.3490658503988659F, 0.6981317007977318F);
        this.headSpinesL = new ModelRenderer(this, 63, 18);
        this.headSpinesL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headSpinesL.addBox(1.0F, -6.0F, -1.0F, 0, 4, 24, 0.0F);
        this.setRotation(headSpinesL, 1.3264502315156905F, 0.0F, 0.296705972839036F);
        this.lShin0 = new ModelRenderer(this, 78, 0);
        this.lShin0.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.lShin0.addBox(-1.0F, -1.5F, -2.4F, 3, 3, 14, 0.0F);
        this.tailSpines2 = new ModelRenderer(this, 118, 25);
        this.tailSpines2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines2.addBox(0.0F, -4.0F, 1.4F, 0, 4, 10, 0.0F);
        this.rShin1 = new ModelRenderer(this, 157, 0);
        this.rShin1.setRotationPoint(-0.5F, -0.5F, 11.0F);
        this.rShin1.addBox(-1.0F, 0.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(rShin1, -0.08726646259971647F, 0.0F, 0.0F);
        this.lArmMini1 = new ModelRenderer(this, 0, 34);
        this.lArmMini1.setRotationPoint(0.0F, 5.3F, 0.0F);
        this.lArmMini1.addBox(-1.0F, 0.0F, -0.5F, 2, 4, 1, 0.0F);
        this.setRotation(lArmMini1, -0.8028514559173915F, 0.0F, 0.0F);
        this.lHandMini = new ModelRenderer(this, 0, 49);
        this.lHandMini.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.lHandMini.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotation(lHandMini, 1.0471975511965976F, 0.0F, 0.0F);
        this.bSpines0 = new ModelRenderer(this, 210, 25);
        this.bSpines0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bSpines0.addBox(0.0F, -9.0F, 0.4F, 0, 8, 10, 0.0F);
        this.torso0 = new ModelRenderer(this, 0, 0);
        this.torso0.setRotationPoint(0.0F, -11.5F, -8.0F);
        this.torso0.addBox(-4.5F, -4.0F, 0.0F, 9, 8, 10, 0.0F);
        this.setRotation(torso0, -0.4363323129985824F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 19, 77);
        this.Jaw1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw1.addBox(-1.5F, 5.6F, -8.5F, 3, 2, 6, 0.0F);
        this.setRotation(Jaw1, 0.9773843811168246F, 0.0F, 0.0F);
        this.headSpinesM = new ModelRenderer(this, 112, 18);
        this.headSpinesM.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headSpinesM.addBox(0.0F, -6.0F, -1.0F, 0, 4, 24, 0.0F);
        this.setRotation(headSpinesM, 1.3264502315156905F, 0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 88, 47);
        this.tail3.setRotationPoint(0.0F, 0.1F, 10.9F);
        this.tail3.addBox(-1.0F, -1.0F, -0.2F, 2, 2, 11, 0.0F);
        this.setRotation(tail3, 0.091106186954104F, 0.0F, 0.0F);
        this.rBStabber2 = new ModelRenderer(this, 251, 22);
        this.rBStabber2.mirror = true;
        this.rBStabber2.setRotationPoint(-0.8F, 0.9F, 15.5F);
        this.rBStabber2.addBox(0.0F, -14.0F, -1.0F, 0, 14, 2, 0.0F);
        this.setRotation(rBStabber2, -0.03490658503988659F, 0.4363323129985824F, -0.6981317007977318F);
        this.headWebR = new ModelRenderer(this, 22, 70);
        this.headWebR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headWebR.addBox(-4.8F, -5.0F, -1.2F, 3, 6, 0, 0.0F);
        this.setRotation(headWebR, 0.0F, 0.12217304763960307F, -0.091106186954104F);
        this.tail1 = new ModelRenderer(this, 144, 47);
        this.tail1.setRotationPoint(0.0F, -0.2F, 11.0F);
        this.tail1.addBox(-2.0F, -1.8F, -0.2F, 4, 4, 11, 0.0F);
        this.setRotation(tail1, 0.05235987755982988F, 0.0F, 0.0F);
        this.tailSpines1 = new ModelRenderer(this, 139, 24);
        this.tailSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines1.addBox(0.0F, -4.7F, 0.6F, 0, 5, 11, 0.0F);
        this.head1 = new ModelRenderer(this, 44, 19);
        this.head1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head1.addBox(-2.5F, 3.8F, -5.2F, 5, 5, 6, 0.0F);
        this.setRotation(head1, 0.5009094953223726F, 0.0F, 0.0F);
        this.rArm1 = new ModelRenderer(this, 96, 19);
        this.rArm1.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.rArm1.addBox(-0.99F, -1.0F, -10.5F, 2, 2, 11, 0.0F);
        this.bSpines1 = new ModelRenderer(this, 185, 23);
        this.bSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bSpines1.addBox(0.0F, -6.8F, 9.2F, 0, 6, 12, 0.0F);
        this.setRotation(bSpines1, 0.15707963267948966F, 0.0F, 0.0F);
        this.rBStabber0 = new ModelRenderer(this, 251, 0);
        this.rBStabber0.mirror = true;
        this.rBStabber0.setRotationPoint(-2.3F, -2.0F, 8.4F);
        this.rBStabber0.addBox(0.0F, -19.0F, -1.0F, 0, 21, 2, 0.0F);
        this.setRotation(rBStabber0, 0.3490658503988659F, 0.2617993877991494F, -0.45378560551852565F);
        this.tail4 = new ModelRenderer(this, 63, 47);
        this.tail4.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.tail4.addBox(-0.5F, -0.9F, -0.2F, 1, 1, 11, 0.0F);
        this.setRotation(tail4, 0.091106186954104F, 0.0F, 0.0F);
        this.headBase0 = new ModelRenderer(this, 19, 36);
        this.headBase0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headBase0.addBox(-3.5F, -23.0F, -4.2F, 7, 19, 5, 0.0F);
        this.setRotation(headBase0, -0.2792526803190927F, 0.0F, 0.0F);
        this.headWebL = new ModelRenderer(this, 15, 70);
        this.headWebL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headWebL.addBox(1.8F, -5.0F, -1.2F, 3, 6, 0, 0.0F);
        this.setRotation(headWebL, 0.0F, -0.12217304763960307F, 0.091106186954104F);
        this.lArm1 = new ModelRenderer(this, 123, 19);
        this.lArm1.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.lArm1.addBox(-1.01F, -1.0F, -10.5F, 2, 2, 11, 0.0F);
        this.sack5 = new ModelRenderer(this, 223, 47);
        this.sack5.setRotationPoint(0.0F, 0.0F, 10.5F);
        this.sack5.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 9, 0.0F);
        this.setRotation(sack5, 0.17453292519943295F, 0.0F, 0.0F);
        this.lArm0 = new ModelRenderer(this, 67, 19);
        this.lArm0.setRotationPoint(4.5F, 2.5F, 3.5F);
        this.lArm0.addBox(-1.0F, -2.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(lArm0, 0.6981317007977318F, 0.0F, -0.24434609527920614F);
        this.lFoot = new ModelRenderer(this, 166, 0);
        this.lFoot.setRotationPoint(-0.5F, 13.0F, 0.0F);
        this.lFoot.addBox(-1.5F, -1.0F, -4.5F, 3, 2, 6, 0.0F);
        this.setRotation(lFoot, 0.7330382858376184F, -0.08726646259971647F, 0.3665191429188092F);
        this.head0 = new ModelRenderer(this, 19, 19);
        this.head0.setRotationPoint(0.0F, 0.0F, -5.4F);
        this.head0.addBox(-3.5F, -5.0F, -3.0F, 7, 11, 5, 0.0F);
        this.setRotation(head0, -0.4363323129985824F, 0.0F, 0.0F);
        this.headFinR0 = new ModelRenderer(this, 0, 67);
        this.headFinR0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinR0.addBox(-5.0F, -4.0F, -2.0F, 5, 5, 2, 0.0F);
        this.setRotation(headFinR0, -0.15707963267948966F, 0.091106186954104F, -1.0016444577195458F);
        this.rArmMini1 = new ModelRenderer(this, 9, 34);
        this.rArmMini1.setRotationPoint(0.0F, 5.3F, 0.0F);
        this.rArmMini1.addBox(-1.0F, 0.0F, -0.5F, 2, 4, 1, 0.0F);
        this.setRotation(rArmMini1, -0.8028514559173915F, 0.0F, 0.0F);
        this.tail0 = new ModelRenderer(this, 175, 47);
        this.tail0.setRotationPoint(0.0F, 1.9F, 18.7F);
        this.tail0.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 11, 0.0F);
        this.setRotation(tail0, 0.08726646259971647F, 0.0F, 0.0F);
        this.rHand = new ModelRenderer(this, 85, 24);
        this.rHand.setRotationPoint(0.0F, 0.0F, -10.5F);
        this.rHand.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
        this.lClawMini = new ModelRenderer(this, 0, 19);
        this.lClawMini.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lClawMini.addBox(-2.0F, 0.0F, -6.0F, 3, 0, 6, 0.0F);
        this.headFinR2 = new ModelRenderer(this, 44, 47);
        this.headFinR2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinR2.addBox(-3.6F, -23.0F, -3.0F, 7, 13, 2, 0.0F);
        this.setRotation(headFinR2, -0.31869712141416456F, 0.18203784098300857F, -0.31869712141416456F);
        this.sack1 = new ModelRenderer(this, 192, 64);
        this.sack1.setRotationPoint(0.0F, 0.1F, 4.5F);
        this.sack1.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10, 0.0F);
        this.setRotation(sack1, 0.593411945678072F, 0.0F, 0.0F);
        this.lHip = new ModelRenderer(this, 176, 18);
        this.lHip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lHip.addBox(1.1F, -6.6F, -1.4F, 0, 5, 4, 0.0F);
        this.setRotation(lHip, 0.27314402793711257F, 0.0F, 0.41887902047863906F);
        this.lBStabber2 = new ModelRenderer(this, 251, 22);
        this.lBStabber2.setRotationPoint(0.8F, 0.9F, 15.5F);
        this.lBStabber2.addBox(0.0F, -14.0F, -1.0F, 0, 14, 2, 0.0F);
        this.setRotation(lBStabber2, -0.03490658503988659F, -0.4363323129985824F, 0.6981317007977318F);
        this.lowerJaw = new ModelRenderer(this, 19, 90);
        this.lowerJaw.setRotationPoint(0.0F, 8.0F, -2.5F);
        this.lowerJaw.addBox(-1.5F, -0.5F, -5.9F, 3, 2, 6, 0.0F);
        this.tailSpines0 = new ModelRenderer(this, 162, 24);
        this.tailSpines0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines0.addBox(0.0F, -5.7F, 0.1F, 0, 5, 11, 0.0F);
        this.lShin1 = new ModelRenderer(this, 148, 0);
        this.lShin1.setRotationPoint(0.5F, -0.5F, 11.0F);
        this.lShin1.addBox(-1.0F, 0.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(lShin1, -0.08726646259971647F, 0.0F, 0.0F);
        this.headFinL0 = new ModelRenderer(this, 0, 59);
        this.headFinL0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinL0.addBox(0.0F, -4.0F, -2.0F, 5, 5, 2, 0.0F);
        this.setRotation(headFinL0, -0.15707963267948966F, -0.091106186954104F, 1.0016444577195458F);
        this.lThigh = new ModelRenderer(this, 204, 0);
        this.lThigh.setRotationPoint(3.5F, 4.6F, 17.5F);
        this.lThigh.addBox(-1.5F, -2.0F, -2.5F, 4, 17, 5, 0.0F);
        this.setRotation(lThigh, -0.3141592653589793F, -0.24434609527920614F, -0.41887902047863906F);
        this.sack0 = new ModelRenderer(this, 229, 64);
        this.sack0.setRotationPoint(0.0F, -4.6F, 8.0F);
        this.sack0.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 7, 0.0F);
        this.setRotation(sack0, -0.9075712110370513F, 0.0F, 0.0F);
        this.rFoot = new ModelRenderer(this, 166, 9);
        this.rFoot.setRotationPoint(0.5F, 13.0F, 0.0F);
        this.rFoot.addBox(-1.5F, -1.0F, -4.5F, 3, 2, 6, 0.0F);
        this.setRotation(rFoot, 0.7330382858376184F, 0.08726646259971647F, -0.3665191429188092F);
        this.rClawMini = new ModelRenderer(this, 0, 26);
        this.rClawMini.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rClawMini.addBox(-1.0F, 0.0F, -6.0F, 3, 0, 6, 0.0F);
        this.sack6 = new ModelRenderer(this, 38, 75);
        this.sack6.setRotationPoint(0.0F, 1.0F, 7.6F);
        this.sack6.addBox(-2.5F, -3.0F, 0.0F, 5, 6, 7, 0.0F);
        this.setRotation(sack6, -0.4363323129985824F, 0.0F, 0.0F);
        this.lArmMini0 = new ModelRenderer(this, 0, 40);
        this.lArmMini0.setRotationPoint(2.0F, 4.2F, 5.0F);
        this.lArmMini0.addBox(-1.0F, -0.4F, -0.9F, 2, 6, 2, 0.0F);
        this.setRotation(lArmMini0, 0.4886921905584123F, 0.0F, -0.24434609527920614F);
        this.headSpinesR = new ModelRenderer(this, 161, 18);
        this.headSpinesR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headSpinesR.addBox(-1.0F, -6.0F, -1.0F, 0, 4, 24, 0.0F);
        this.setRotation(headSpinesR, 1.3264502315156905F, 0.0F, -0.296705972839036F);
        this.tail2 = new ModelRenderer(this, 115, 47);
        this.tail2.setRotationPoint(0.0F, 0.3F, 10.9F);
        this.tail2.addBox(-1.5F, -1.5F, -0.2F, 3, 3, 11, 0.0F);
        this.setRotation(tail2, 0.06981317007977318F, 0.0F, 0.0F);
        this.innerJaw = new ModelRenderer(this, 0, 90);
        this.innerJaw.setRotationPoint(0.0F, 7.9F, -3.5F);
        this.innerJaw.addBox(-1.0F, -1.0F, -4.6F, 2, 2, 5, 0.0F);
        this.sack4 = new ModelRenderer(this, 63, 64);
        this.sack4.setRotationPoint(0.0F, -1.0F, 10.5F);
        this.sack4.addBox(-4.5F, -4.5F, 0.0F, 9, 9, 11, 0.0F);
        this.setRotation(sack4, 0.05235987755982988F, 0.0F, 0.0F);
        this.lClaw = new ModelRenderer(this, 185, 23);
        this.lClaw.setRotationPoint(0.0F, 0.2F, 0.0F);
        this.lClaw.addBox(-1.7F, 0.0F, -6.0F, 3, 0, 6, 0.0F);
        this.rHandMini = new ModelRenderer(this, 0, 54);
        this.rHandMini.setRotationPoint(0.0F, 3.8F, 0.0F);
        this.rHandMini.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
        this.setRotation(rHandMini, 1.0471975511965976F, 0.0F, 0.0F);
        this.rArm0 = new ModelRenderer(this, 76, 19);
        this.rArm0.setRotationPoint(-4.5F, 2.5F, 3.5F);
        this.rArm0.addBox(-1.0F, -2.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(rArm0, 0.6981317007977318F, 0.0F, 0.24434609527920614F);
        this.lBStabber0 = new ModelRenderer(this, 251, 0);
        this.lBStabber0.setRotationPoint(2.3F, -2.0F, 8.4F);
        this.lBStabber0.addBox(0.0F, -19.0F, -1.0F, 0, 21, 2, 0.0F);
        this.setRotation(lBStabber0, 0.3490658503988659F, -0.2617993877991494F, 0.45378560551852565F);
        this.sack3 = new ModelRenderer(this, 104, 64);
        this.sack3.setRotationPoint(0.0F, 0.0F, 10.5F);
        this.sack3.addBox(-5.5F, -5.5F, 0.0F, 11, 11, 11, 0.0F);
        this.setRotation(sack3, 0.05235987755982988F, 0.0F, 0.0F);
        this.rArmMini0 = new ModelRenderer(this, 9, 40);
        this.rArmMini0.setRotationPoint(-2.0F, 4.2F, 5.0F);
        this.rArmMini0.addBox(-1.0F, -0.4F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotation(rArmMini0, 0.4886921905584123F, 0.0F, 0.24434609527920614F);
        this.headFinL2 = new ModelRenderer(this, 44, 31);
        this.headFinL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinL2.addBox(-4.3F, -23.0F, -3.0F, 7, 13, 2, 0.0F);
        this.setRotation(headFinL2, -0.31869712141416456F, -0.18203784098300857F, 0.36425021489121656F);
        this.tailSpines3 = new ModelRenderer(this, 97, 25);
        this.tailSpines3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines3.addBox(0.0F, -3.7F, 1.2F, 0, 3, 10, 0.0F);
        this.tailStabber = new ModelRenderer(this, 211, 0);
        this.tailStabber.setRotationPoint(0.0F, -0.5F, 11.0F);
        this.tailStabber.addBox(-2.0F, 0.0F, -0.6F, 4, 0, 12, 0.0F);
        this.setRotation(tailStabber, 0.03490658503988659F, 0.0F, 0.0F);
        this.rShin0 = new ModelRenderer(this, 113, 0);
        this.rShin0.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.rShin0.addBox(-2.0F, -1.5F, -2.4F, 3, 3, 14, 0.0F);
        this.lHand = new ModelRenderer(this, 85, 19);
        this.lHand.setRotationPoint(0.0F, 0.0F, -10.5F);
        this.lHand.addBox(-1.0F, -0.5F, -3.0F, 2, 1, 3, 0.0F);
        this.lShinSpike = new ModelRenderer(this, 150, 17);
        this.lShinSpike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lShinSpike.addBox(0.5F, 7.1F, -15.0F, 0, 3, 5, 0.0F);
        this.setRotation(lShinSpike, 1.5481070465189704F, 0.0F, 0.0F);
        this.rShinSpike = new ModelRenderer(this, 150, 26);
        this.rShinSpike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rShinSpike.addBox(-0.5F, 7.1F, -15.0F, 0, 3, 5, 0.0F);
        this.setRotation(rShinSpike, 1.5481070465189704F, 0.0F, 0.0F);
        this.sack7 = new ModelRenderer(this, 42, 64);
        this.sack7.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.sack7.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F);
        this.setRotation(sack7, -0.6283185307179586F, 0.0F, 0.0F);
        this.headFinR1 = new ModelRenderer(this, 28, 61);
        this.headFinR1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinR1.addBox(-6.0F, -9.6F, -3.1F, 4, 6, 2, 0.0F);
        this.setRotation(headFinR1, -0.27314402793711257F, 0.18203784098300857F, -0.091106186954104F);
        this.tailSpines4 = new ModelRenderer(this, 74, 24);
        this.tailSpines4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines4.addBox(0.0F, -2.5F, -0.1F, 0, 2, 11, 0.0F);
        this.headFinL1 = new ModelRenderer(this, 15, 61);
        this.headFinL1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinL1.addBox(2.5F, -9.6F, -3.1F, 4, 6, 2, 0.0F);
        this.setRotation(headFinL1, -0.27314402793711257F, -0.18203784098300857F, 0.0F);
        this.rHip = new ModelRenderer(this, 167, 18);
        this.rHip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rHip.addBox(-1.1F, -6.6F, -1.4F, 0, 5, 4, 0.0F);
        this.setRotation(rHip, 0.27314402793711257F, 0.0F, -0.41887902047863906F);
        this.torso0.addChild(this.torso1);
        this.sack1.addChild(this.sack2);
        this.torso1.addChild(this.rBStabber1);
        this.torso0.addChild(this.neck);
        this.rHand.addChild(this.rClaw);
        this.torso1.addChild(this.rThigh);
        this.torso1.addChild(this.lBStabber1);
        this.head0.addChild(this.headSpinesL);
        this.lThigh.addChild(this.lShin0);
        this.tail2.addChild(this.tailSpines2);
        this.rShin0.addChild(this.rShin1);
        this.lArmMini0.addChild(this.lArmMini1);
        this.lArmMini1.addChild(this.lHandMini);
        this.torso0.addChild(this.bSpines0);
        this.head0.addChild(this.Jaw1);
        this.head0.addChild(this.headSpinesM);
        this.tail2.addChild(this.tail3);
        this.torso1.addChild(this.rBStabber2);
        this.head0.addChild(this.headWebR);
        this.tail0.addChild(this.tail1);
        this.tail1.addChild(this.tailSpines1);
        this.head0.addChild(this.head1);
        this.rArm0.addChild(this.rArm1);
        this.torso0.addChild(this.bSpines1);
        this.torso0.addChild(this.rBStabber0);
        this.tail3.addChild(this.tail4);
        this.head0.addChild(this.headBase0);
        this.head0.addChild(this.headWebL);
        this.lArm0.addChild(this.lArm1);
        this.sack4.addChild(this.sack5);
        this.torso0.addChild(this.lArm0);
        this.lShin1.addChild(this.lFoot);
        this.neck.addChild(this.head0);
        this.head0.addChild(this.headFinR0);
        this.rArmMini0.addChild(this.rArmMini1);
        this.torso1.addChild(this.tail0);
        this.rArm1.addChild(this.rHand);
        this.lHandMini.addChild(this.lClawMini);
        this.head0.addChild(this.headFinR2);
        this.sack0.addChild(this.sack1);
        this.lThigh.addChild(this.lHip);
        this.torso1.addChild(this.lBStabber2);
        this.Jaw1.addChild(this.lowerJaw);
        this.tail0.addChild(this.tailSpines0);
        this.lShin0.addChild(this.lShin1);
        this.head0.addChild(this.headFinL0);
        this.torso1.addChild(this.lThigh);
        this.rShin1.addChild(this.rFoot);
        this.rHandMini.addChild(this.rClawMini);
        this.sack5.addChild(this.sack6);
        this.torso0.addChild(this.lArmMini0);
        this.head0.addChild(this.headSpinesR);
        this.tail1.addChild(this.tail2);
        this.Jaw1.addChild(this.innerJaw);
        this.sack3.addChild(this.sack4);
        this.lHand.addChild(this.lClaw);
        this.rArmMini1.addChild(this.rHandMini);
        this.torso0.addChild(this.rArm0);
        this.torso0.addChild(this.lBStabber0);
        this.sack2.addChild(this.sack3);
        this.torso0.addChild(this.rArmMini0);
        this.head0.addChild(this.headFinL2);
        this.tail3.addChild(this.tailSpines3);
        this.tail4.addChild(this.tailStabber);
        this.rThigh.addChild(this.rShin0);
        this.lArm1.addChild(this.lHand);
        this.lThigh.addChild(this.lShinSpike);
        this.rThigh.addChild(this.rShinSpike);
        this.sack6.addChild(this.sack7);
        this.head0.addChild(this.headFinR1);
        this.tail4.addChild(this.tailSpines4);
        this.head0.addChild(this.headFinL1);
        this.rThigh.addChild(this.rHip);
    }

    @Override
    public void render(Object obj)
    {
        EntityLivingBase base = (EntityLivingBase) obj;

        float newangle = 0.0F;
        float multiplier = 0.01F;
        newangle = MathHelper.cos(idleProgress(obj) * 4.0F * multiplier) * (float) Math.PI * 0.5F * swingProgressPrev(obj);

        if (base != null && base.prevPosX == base.posX && base.prevPosY == base.posY && base.prevPosZ == base.posZ)
        {
            newangle = MathHelper.cos(idleProgress(obj) * 0.04F);
            multiplier = 0.01F;
        }
        
        this.neck.rotateAngleX = 0.3F + newangle * -0.09F;
        this.torso0.rotateAngleX = -0.5F + newangle * 0.04F;
        this.torso1.rotateAngleX = -0.3F + -this.torso0.rotateAngleX;
        this.bSpines1.rotateAngleX = -0.3F + -this.torso0.rotateAngleX;

        this.doTail(newangle, multiplier);
        
        /** Body Rotation **/
        this.torso0.rotateAngleY = MathHelper.cos(swingProgress(obj) * 0.6662F) * 0.4F * swingProgressPrev(obj) - 0F;
        this.torso0.rotateAngleZ = MathHelper.cos(swingProgress(obj) * 0.6662F) * 0.1F * swingProgressPrev(obj) - 0F;

        /** Head rotation **/
        this.head0.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;

        this.lThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.4662F) * 1.1F * swingProgressPrev(obj) - 0.3028515F;
        this.lShin0.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.4662F) * -0.8F * swingProgressPrev(obj) + 0.0F;
        this.rThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.4662F + (float) Math.PI) * 1.1F * swingProgressPrev(obj) - 0.3028515F;
        this.rShin0.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.4662F + (float) Math.PI) * -0.8F * swingProgressPrev(obj) - 0.0F;

        this.lArm0.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.0662F) * 1F * swingProgressPrev(obj) + 0.6665191F;
        this.lArm1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.0662F) * -1F * swingProgressPrev(obj) - 0.2665191F;

        this.rArm0.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.0662F + (float) Math.PI) * 1F * swingProgressPrev(obj) + 0.6665191F;
        this.rArm1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.0662F + (float) Math.PI) * -1F * swingProgressPrev(obj) - 0.2665191F;

        this.rArmMini0.rotateAngleY = (float) (Math.toRadians(headYaw(obj)) * 0.75F);
        this.rArmMini0.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.0662F) * 1F * swingProgressPrev(obj) + 0.0665191F;
        this.rHandMini.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 2.4665191F;
        this.rArmMini1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 1.9065191F;

        this.lArmMini0.rotateAngleY = (float) (Math.toRadians(headYaw(obj)) * 0.75F);
        this.lArmMini0.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.0662F + (float) Math.PI) * 1F * swingProgressPrev(obj) + 0.0665191F;
        this.lHandMini.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 2.4665191F;
        this.lArmMini1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) - 1.9065191F;

        draw(torso0);
//        draw(sack0);

        if (base != null && base instanceof EntityMatriarch)
        {
            EntityMatriarch queen = (EntityMatriarch) base;

            if (queen.getOvipositorSize() > 0F)
            {
                OpenGL.pushMatrix();
                {
                    OpenGL.translate(0f, Math.min(-0.5f + queen.getOvipositorSize(), 0.25f), 0f);
                    OpenGL.scale(queen.getOvipositorSize(), queen.getOvipositorSize(), queen.getOvipositorSize());
                    OpenGL.enableBlend();
                    OpenGL.blendClear();
                    OpenGL.disableCullFace();
                    OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_DST_COLOR);
                    AliensVsPredator.resources().models().MATRIARCH_MASK.getTexture().bind();
                    draw(sack0);
                    OpenGL.enableCullFace();
                    OpenGL.blendClear();
                }
                OpenGL.popMatrix();
            }
        }
    }

    private void doTail(float angle, float distMult)
    {
        float multiplier = 0.05F;
        this.tail0.rotateAngleY = angle / 5F;
        this.tail1.rotateAngleY = angle * multiplier;
        this.tailSpines2.rotateAngleY = angle * multiplier;
        multiplier = multiplier + distMult;
        this.tail2.rotateAngleY = angle * multiplier;
        this.tailSpines3.rotateAngleY = angle * multiplier;
        multiplier = multiplier + distMult;
        this.tail3.rotateAngleY = angle * multiplier;
        this.tailSpines4.rotateAngleY = angle * multiplier;
        multiplier = multiplier + distMult;
        this.tail4.rotateAngleY = angle * multiplier;
        this.tailSpines4.rotateAngleY = angle * multiplier;
        multiplier = multiplier + distMult;
        this.tailStabber.rotateAngleY = angle * multiplier;
    }
}
