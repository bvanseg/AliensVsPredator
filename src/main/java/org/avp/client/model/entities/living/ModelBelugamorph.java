package org.avp.client.model.entities.living;

import org.avp.client.render.XenomorphJawState;
import org.avp.entities.living.EntityXenomorph;

import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class ModelBelugamorph extends Model
{
    public ModelRenderer chest;
    public ModelRenderer quill2A;
    public ModelRenderer quill2C;
    public ModelRenderer neck;
    public ModelRenderer ribs;
    public ModelRenderer lArmUpper;
    public ModelRenderer rArmUpper;
    public ModelRenderer quill1A;
    public ModelRenderer lQuillA;
    public ModelRenderer rQuillA;
    public ModelRenderer spines;
    public ModelRenderer headBase;
    public ModelRenderer lFaceBubble;
    public ModelRenderer head2;
    public ModelRenderer headLower1;
    public ModelRenderer rFaceBubble;
    public ModelRenderer mFaceBubble;
    public ModelRenderer headSlope;
    public ModelRenderer upperJaw0;
    public ModelRenderer lowerJaw;
    public ModelRenderer mFaceBubble2a;
    public ModelRenderer mFaceBubble2b;
    public ModelRenderer upperJaw;
    public ModelRenderer innerJaw02;
    public ModelRenderer lowerJaw2;
    public ModelRenderer lowerTeeth;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer headLower2;
    public ModelRenderer headLower3;
    public ModelRenderer lHip;
    public ModelRenderer rHip;
    public ModelRenderer stomach;
    public ModelRenderer lThigh;
    public ModelRenderer rThigh;
    public ModelRenderer lShin;
    public ModelRenderer lThigh2;
    public ModelRenderer lFoot;
    public ModelRenderer lToes01;
    public ModelRenderer lToes02;
    public ModelRenderer rShin;
    public ModelRenderer rThigh2;
    public ModelRenderer rFoot;
    public ModelRenderer rToes;
    public ModelRenderer rToes02;
    public ModelRenderer lUpperArm;
    public ModelRenderer lForearm;
    public ModelRenderer lArmjoint;
    public ModelRenderer lHand;
    public ModelRenderer lFinger01;
    public ModelRenderer lFinger02;
    public ModelRenderer lFinger03;
    public ModelRenderer lFinger04;
    public ModelRenderer lFinger05;
    public ModelRenderer rUpperArm;
    public ModelRenderer rForearm;
    public ModelRenderer rArmjoint;
    public ModelRenderer rHand;
    public ModelRenderer rFinger01;
    public ModelRenderer rFinger02;
    public ModelRenderer rFinger03;
    public ModelRenderer rFinger04;
    public ModelRenderer rFinger05;
    public ModelRenderer quill1B;
    public ModelRenderer quill1C;
    public ModelRenderer quill1D;
    public ModelRenderer lQuillB;
    public ModelRenderer lQuillC;
    public ModelRenderer lQuillD;
    public ModelRenderer rQuillB;
    public ModelRenderer rQuillC;
    public ModelRenderer rQuillD;
    public ModelRenderer quill2B;

    public ModelBelugamorph() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rQuillC = new ModelRenderer(this, 24, 50);
        this.rQuillC.mirror = true;
        this.rQuillC.setRotationPoint(-0.01F, 0.2F, 2.5F);
        this.rQuillC.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 3, 0.0F);
        this.setRotation(rQuillC, -0.091106186954104F, 0.0F, 0.0F);
        this.rFinger04 = new ModelRenderer(this, 92, 28);
        this.rFinger04.setRotationPoint(0.7F, 3.5F, 0.0F);
        this.rFinger04.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.rHip = new ModelRenderer(this, 68, 0);
        this.rHip.mirror = true;
        this.rHip.setRotationPoint(-1.8F, 6.3F, -0.1F);
        this.rHip.addBox(-1.0F, -1.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotation(rHip, 0.091106186954104F, 0.0F, -0.31869712141416456F);
        this.rQuillD = new ModelRenderer(this, 24, 57);
        this.rQuillD.mirror = true;
        this.rQuillD.setRotationPoint(0.0F, -0.5F, 0.2F);
        this.rQuillD.addBox(-0.51F, -0.5F, -0.4F, 1, 1, 2, 0.0F);
        this.setRotation(rQuillD, -0.136659280431156F, 0.0F, 0.0F);
        this.quill2B = new ModelRenderer(this, 13, 50);
        this.quill2B.setRotationPoint(0.0F, 0.2F, 2.5F);
        this.quill2B.addBox(-0.5F, -1.0F, -0.4F, 1, 1, 3, 0.0F);
        this.setRotation(quill2B, -0.091106186954104F, 0.0F, 0.0F);
        this.lThigh = new ModelRenderer(this, 37, 0);
        this.lThigh.setRotationPoint(2.5F, 4.9F, 0.0F);
        this.lThigh.addBox(-2.1F, -0.5F, -2.0F, 3, 14, 4, 0.0F);
        this.setRotation(lThigh, -0.045553093477052F, 0.0F, -0.18203784098300857F);
        this.rFinger05 = new ModelRenderer(this, 92, 28);
        this.rFinger05.setRotationPoint(1.4F, 2.4F, -0.1F);
        this.rFinger05.addBox(0.0F, 0.0F, -0.8F, 0, 4, 2, 0.0F);
        this.setRotation(rFinger05, 0.091106186954104F, 0.0F, -0.136659280431156F);
        this.mFaceBubble2a = new ModelRenderer(this, 101, 27);
        this.mFaceBubble2a.setRotationPoint(0.0F, -1.2F, -0.45F);
        this.mFaceBubble2a.addBox(-3.8F, -1.1F, -6.5F, 4, 1, 3, 0.0F);
        this.setRotation(mFaceBubble2a, 0.7285004297824331F, 0.0F, 0.0F);
        this.lThigh2 = new ModelRenderer(this, 55, 0);
        this.lThigh2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lThigh2.addBox(-2.75F, -0.5F, -2.0F, 1, 14, 4, 0.0F);
        this.rUpperArm = new ModelRenderer(this, 90, 10);
        this.rUpperArm.mirror = true;
        this.rUpperArm.setRotationPoint(-1.8F, 3.1F, 0.0F);
        this.rUpperArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotation(rUpperArm, -0.136659280431156F, 0.0F, -0.136659280431156F);
        this.lQuillA = new ModelRenderer(this, 0, 50);
        this.lQuillA.setRotationPoint(2.0F, -5.2F, 3.1F);
        this.lQuillA.addBox(-1.0F, -1.0F, -0.4F, 2, 2, 4, 0.0F);
        this.setRotation(lQuillA, -0.136659280431156F, 0.136659280431156F, 0.0F);
        this.innerJaw02 = new ModelRenderer(this, 87, 50);
        this.innerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.innerJaw02.addBox(0.35F, -0.5F, -2.91F, 1, 1, 3, 0.0F);
        this.lArmUpper = new ModelRenderer(this, 87, 0);
        this.lArmUpper.setRotationPoint(2.1F, -7.9F, 0.0F);
        this.lArmUpper.addBox(0.0F, -0.5F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotation(lArmUpper, 0.27314402793711257F, 0.0F, -0.36425021489121656F);
        this.chest = new ModelRenderer(this, 0, 10);
        this.chest.setRotationPoint(-0.5F, -8.2F, 0.0F);
        this.chest.addBox(-3.0F, -9.0F, -3.5F, 7, 8, 7, 0.0F);
        this.setRotation(chest, -0.045553093477052F, 0.0F, 0.0F);
        this.quill2C = new ModelRenderer(this, 24, 43);
        this.quill2C.setRotationPoint(0.0F, -17.8F, 3.2F);
        this.quill2C.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 5, 0.0F);
        this.setRotation(quill2C, 0.5009094953223726F, 0.0F, 0.0F);
        this.lFinger04 = new ModelRenderer(this, 92, 28);
        this.lFinger04.setRotationPoint(-0.7F, 3.5F, 0.0F);
        this.lFinger04.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.quill1D = new ModelRenderer(this, 26, 37);
        this.quill1D.setRotationPoint(0.0F, -0.3F, 3.4F);
        this.quill1D.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 4, 0.0F);
        this.setRotation(quill1D, -0.22759093446006054F, 0.0F, 0.0F);
        this.rFoot = new ModelRenderer(this, 41, 36);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(0.0F, 9.7F, 0.0F);
        this.rFoot.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotation(rFoot, -0.6829473363053812F, 0.136659280431156F, 0.0F);
        this.lFinger05 = new ModelRenderer(this, 92, 28);
        this.lFinger05.setRotationPoint(-1.4F, 2.4F, -0.1F);
        this.lFinger05.addBox(0.0F, 0.0F, -0.8F, 0, 4, 2, 0.0F);
        this.setRotation(lFinger05, 0.091106186954104F, 0.0F, 0.136659280431156F);
        this.mFaceBubble = new ModelRenderer(this, 106, 19);
        this.mFaceBubble.setRotationPoint(0.0F, 1.9F, 1.5F);
        this.mFaceBubble.addBox(-4.0F, 0.3F, -6.05F, 5, 2, 2, 0.0F);
        this.setRotation(mFaceBubble, -0.7740535232594852F, 0.0F, 0.0F);
        this.headSlope = new ModelRenderer(this, 104, 53);
        this.headSlope.setRotationPoint(-1.5F, -1.4F, -1.6F);
        this.headSlope.addBox(-2.5F, -0.8F, 0.0F, 5, 1, 1, 0.0F);
        this.setRotation(headSlope, -0.6373942428283291F, 0.0F, 0.0F);
        this.lowerJaw2 = new ModelRenderer(this, 110, 45);
        this.lowerJaw2.setRotationPoint(0.0F, 0.0F, -0.0F);
        this.lowerJaw2.addBox(1.2F, -0.1F, -3.0F, 1, 1, 3, 0.0F);
        this.ribs = new ModelRenderer(this, 21, 27);
        this.ribs.setRotationPoint(0.0F, -1.4F, 0.2F);
        this.ribs.addBox(-2.6F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
        this.setRotation(ribs, 0.091106186954104F, 0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 59, 52);
        this.head4.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.head4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
        this.setRotation(head4, -0.091106186954104F, 0.0F, 0.0F);
        this.rThigh2 = new ModelRenderer(this, 55, 0);
        this.rThigh2.mirror = true;
        this.rThigh2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rThigh2.addBox(1.75F, -0.5F, -2.0F, 1, 14, 4, 0.0F);
        this.lUpperArm = new ModelRenderer(this, 90, 10);
        this.lUpperArm.setRotationPoint(1.8F, 3.1F, 0.0F);
        this.lUpperArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotation(lUpperArm, -0.136659280431156F, 0.0F, 0.136659280431156F);
        this.rFinger01 = new ModelRenderer(this, 92, 28);
        this.rFinger01.setRotationPoint(-1.3F, 3.5F, 0.0F);
        this.rFinger01.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.rShin = new ModelRenderer(this, 47, 19);
        this.rShin.mirror = true;
        this.rShin.setRotationPoint(0.8F, 13.2F, -0.1F);
        this.rShin.addBox(-1.5F, -0.5F, -1.5F, 3, 11, 3, 0.0F);
        this.setRotation(rShin, 0.31869712141416456F, 0.0F, -0.18203784098300857F);
        this.quill1A = new ModelRenderer(this, 0, 42);
        this.quill1A.setRotationPoint(0.5F, -7.7F, 3.0F);
        this.quill1A.addBox(-1.0F, -1.5F, -0.4F, 2, 3, 4, 0.0F);
        this.setRotation(quill1A, 0.27314402793711257F, 0.0F, 0.0F);
        this.spines = new ModelRenderer(this, 37, 50);
        this.spines.setRotationPoint(0.0F, -4.9F, 2.3F);
        this.spines.addBox(0.5F, 0.0F, 0.0F, 0, 7, 3, 0.0F);
        this.mFaceBubble2b = new ModelRenderer(this, 117, 27);
        this.mFaceBubble2b.setRotationPoint(0.0F, -0.0F, 0.0F);
        this.mFaceBubble2b.addBox(-0.2F, -1.1F, -6.5F, 1, 1, 3, 0.0F);
        this.lToes01 = new ModelRenderer(this, 38, 45);
        this.lToes01.setRotationPoint(0.1F, 4.3F, 0.5F);
        this.lToes01.addBox(-1.5F, -1.0F, -2.8F, 3, 2, 3, 0.0F);
        this.setRotation(lToes01, 0.40980330836826856F, 0.0F, 0.045553093477052F);
        this.rFaceBubble = new ModelRenderer(this, 101, 9);
        this.rFaceBubble.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFaceBubble.addBox(-4.15F, -2.1F, -3.0F, 2, 4, 2, 0.0F);
        this.rHand = new ModelRenderer(this, 90, 23);
        this.rHand.mirror = true;
        this.rHand.setRotationPoint(-0.3F, 7.6F, -0.5F);
        this.rHand.addBox(-1.5F, 0.0F, -0.5F, 3, 4, 1, 0.0F);
        this.setRotation(rHand, 0.27314402793711257F, 0.4553564018453205F, 0.0F);
        this.lQuillB = new ModelRenderer(this, 13, 50);
        this.lQuillB.setRotationPoint(0.0F, 0.1F, 3.4F);
        this.lQuillB.addBox(-0.5F, -1.0F, -0.4F, 1, 2, 3, 0.0F);
        this.setRotation(lQuillB, -0.136659280431156F, 0.0F, 0.0F);
        this.quill1B = new ModelRenderer(this, 13, 43);
        this.quill1B.setRotationPoint(0.0F, -0.2F, 3.4F);
        this.quill1B.addBox(-0.5F, -1.0F, -0.4F, 1, 2, 4, 0.0F);
        this.setRotation(quill1B, -0.091106186954104F, 0.0F, 0.0F);
        this.rFinger02 = new ModelRenderer(this, 92, 28);
        this.rFinger02.setRotationPoint(-0.7F, 3.5F, 0.0F);
        this.rFinger02.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.lArmjoint = new ModelRenderer(this, 102, 0);
        this.lArmjoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lArmjoint.addBox(-0.9F, -0.5F, -0.4F, 2, 2, 2, 0.0F);
        this.setRotation(lArmjoint, -0.27314402793711257F, 0.0F, 0.0F);
        this.rArmjoint = new ModelRenderer(this, 102, 0);
        this.rArmjoint.mirror = true;
        this.rArmjoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rArmjoint.addBox(-1.1F, -0.5F, -0.4F, 2, 2, 2, 0.0F);
        this.setRotation(rArmjoint, -0.27314402793711257F, 0.0F, 0.0F);
        this.lQuillC = new ModelRenderer(this, 24, 50);
        this.lQuillC.setRotationPoint(0.01F, 0.2F, 2.5F);
        this.lQuillC.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 3, 0.0F);
        this.setRotation(lQuillC, -0.091106186954104F, 0.0F, 0.0F);
        this.quill2A = new ModelRenderer(this, 1, 51);
        this.quill2A.setRotationPoint(0.0F, -17.5F, 2.2F);
        this.quill2A.addBox(-1.0F, -1.0F, -0.4F, 2, 2, 3, 0.0F);
        this.setRotation(quill2A, 0.5009094953223726F, 0.0F, 0.0F);
        this.headLower1 = new ModelRenderer(this, 20, 0);
        this.headLower1.setRotationPoint(0.0F, -1.6F, 2.5F);
        this.headLower1.addBox(-1.5F, -1.1F, -0.7F, 3, 2, 4, 0.0F);
        this.quill1C = new ModelRenderer(this, 24, 43);
        this.quill1C.setRotationPoint(0.0F, 0.2F, 3.3F);
        this.quill1C.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 5, 0.0F);
        this.setRotation(quill1C, -0.136659280431156F, 0.0F, 0.0F);
        this.lHand = new ModelRenderer(this, 90, 23);
        this.lHand.setRotationPoint(0.3F, 7.6F, -0.5F);
        this.lHand.addBox(-1.5F, 0.0F, -0.5F, 3, 4, 1, 0.0F);
        this.setRotation(lHand, 0.27314402793711257F, -0.4553564018453205F, 0.0F);
        this.lowerTeeth = new ModelRenderer(this, 81, 57);
        this.lowerTeeth.setRotationPoint(0.4F, -0.3F, -2.1F);
        this.lowerTeeth.addBox(-1.5F, -0.8F, -0.8F, 3, 1, 2, 0.0F);
        this.lHip = new ModelRenderer(this, 68, 0);
        this.lHip.setRotationPoint(2.8F, 6.3F, -0.1F);
        this.lHip.addBox(0.0F, -1.5F, -2.5F, 1, 3, 5, 0.0F);
        this.setRotation(lHip, 0.091106186954104F, 0.0F, 0.31869712141416456F);
        this.lForearm = new ModelRenderer(this, 85, 35);
        this.lForearm.setRotationPoint(0.0F, 7.7F, 0.0F);
        this.lForearm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotation(lForearm, -0.27314402793711257F, 0.0F, 0.091106186954104F);
        this.rToes02 = new ModelRenderer(this, 45, 53);
        this.rToes02.mirror = true;
        this.rToes02.setRotationPoint(0.0F, -0.2F, -2.7F);
        this.rToes02.addBox(-1.5F, -0.4F, -2.0F, 3, 1, 2, 0.0F);
        this.headLower3 = new ModelRenderer(this, 28, 14);
        this.headLower3.setRotationPoint(0.0F, 1.0F, 1.1F);
        this.headLower3.addBox(-0.5F, -0.41F, -0.5F, 1, 1, 2, 0.0F);
        this.setRotation(headLower3, 0.136659280431156F, 0.0F, 0.0F);
        this.lShin = new ModelRenderer(this, 47, 19);
        this.lShin.setRotationPoint(-0.8F, 13.2F, -0.1F);
        this.lShin.addBox(-1.5F, -0.5F, -1.5F, 3, 11, 3, 0.0F);
        this.setRotation(lShin, 0.31869712141416456F, 0.0F, 0.18203784098300857F);
        this.rToes = new ModelRenderer(this, 38, 45);
        this.rToes.mirror = true;
        this.rToes.setRotationPoint(-0.1F, 4.3F, 0.5F);
        this.rToes.addBox(-1.5F, -1.0F, -2.8F, 3, 2, 3, 0.0F);
        this.setRotation(rToes, 0.40980330836826856F, 0.0F, -0.045553093477052F);
        this.neck = new ModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.5F, -8.7F, 0.0F);
        this.neck.addBox(-2.0F, -3.2F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotation(neck, 0.4553564018453205F, 0.0F, 0.0F);
        this.upperJaw0 = new ModelRenderer(this, 104, 36);
        this.upperJaw0.setRotationPoint(-1.5F, 3.6F, -0.4F);
        this.upperJaw0.addBox(-2.0F, -2.1F, -5.0F, 4, 2, 4, 0.0F);
        this.setRotation(upperJaw0, -0.5462880558742251F, 0.0F, 0.0F);
        this.stomach = new ModelRenderer(this, 0, 27);
        this.stomach.setRotationPoint(0.5F, 1.8F, 0.0F);
        this.stomach.addBox(-2.5F, 0.0F, -2.5F, 5, 6, 5, 0.0F);
        this.setRotation(stomach, -0.045553093477052F, 0.0F, 0.0F);
        this.rQuillA = new ModelRenderer(this, 0, 50);
        this.rQuillA.mirror = true;
        this.rQuillA.setRotationPoint(-1.2F, -5.2F, 3.1F);
        this.rQuillA.addBox(-1.0F, -1.0F, -0.4F, 2, 2, 4, 0.0F);
        this.setRotation(rQuillA, -0.136659280431156F, -0.136659280431156F, 0.0F);
        this.lToes02 = new ModelRenderer(this, 45, 53);
        this.lToes02.setRotationPoint(0.0F, -0.2F, -2.7F);
        this.lToes02.addBox(-1.5F, -0.4F, -2.0F, 3, 1, 2, 0.0F);
        this.rArmUpper = new ModelRenderer(this, 87, 0);
        this.rArmUpper.mirror = true;
        this.rArmUpper.setRotationPoint(-1.1F, -7.9F, 0.0F);
        this.rArmUpper.addBox(-3.0F, -0.5F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotation(rArmUpper, 0.27314402793711257F, 0.0F, 0.36425021489121656F);
        this.head2 = new ModelRenderer(this, 58, 34);
        this.head2.setRotationPoint(0.0F, -2.9F, 2.2F);
        this.head2.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotation(head2, -0.136659280431156F, 0.0F, 0.0F);
        this.lFinger03 = new ModelRenderer(this, 92, 28);
        this.lFinger03.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.lFinger03.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.rQuillB = new ModelRenderer(this, 13, 50);
        this.rQuillB.mirror = true;
        this.rQuillB.setRotationPoint(0.0F, 0.1F, 3.4F);
        this.rQuillB.addBox(-0.5F, -1.0F, -0.4F, 1, 2, 3, 0.0F);
        this.setRotation(rQuillB, -0.136659280431156F, 0.0F, 0.0F);
        this.upperJaw = new ModelRenderer(this, 73, 50);
        this.upperJaw.setRotationPoint(0.3F, -0.3F, -1.9F);
        this.upperJaw.addBox(-1.95F, -0.5F, -2.91F, 3, 1, 3, 0.0F);
        this.lowerJaw = new ModelRenderer(this, 94, 45);
        this.lowerJaw.setRotationPoint(-1.9F, 2.3F, -1.8F);
        this.lowerJaw.addBox(-1.4F, -0.1F, -3.0F, 3, 1, 3, 0.0F);
        this.setRotation(lowerJaw, -0.22759093446006054F, 0.0F, 0.0F);
        this.rForearm = new ModelRenderer(this, 85, 35);
        this.rForearm.mirror = true;
        this.rForearm.setRotationPoint(0.0F, 7.7F, 0.0F);
        this.rForearm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotation(rForearm, -0.27314402793711257F, 0.0F, -0.091106186954104F);
        this.headBase = new ModelRenderer(this, 60, 20);
        this.headBase.setRotationPoint(0.0F, -2.2F, 1.1F);
        this.headBase.addBox(-2.5F, -4.6F, -4.5F, 5, 4, 7, 0.0F);
        this.setRotation(headBase, -0.136659280431156F, 0.0F, 0.0F);
        this.lFaceBubble = new ModelRenderer(this, 112, 9);
        this.lFaceBubble.setRotationPoint(1.5F, -3.4F, -3.2F);
        this.lFaceBubble.addBox(-2.85F, -2.1F, -3.0F, 4, 4, 2, 0.0F);
        this.setRotation(lFaceBubble, 0.5009094953223726F, 0.0F, 0.0F);
        this.rThigh = new ModelRenderer(this, 37, 0);
        this.rThigh.mirror = true;
        this.rThigh.setRotationPoint(-2.5F, 4.9F, 0.0F);
        this.rThigh.addBox(-0.9F, -0.5F, -2.0F, 3, 14, 4, 0.0F);
        this.setRotation(rThigh, -0.045553093477052F, 0.0F, 0.18203784098300857F);
        this.headLower2 = new ModelRenderer(this, 24, 7);
        this.headLower2.setRotationPoint(0.0F, 0.9F, 0.7F);
        this.headLower2.addBox(-1.0F, -1.01F, -0.7F, 2, 2, 3, 0.0F);
        this.setRotation(headLower2, 0.045553093477052F, 0.0F, 0.0F);
        this.rFinger03 = new ModelRenderer(this, 92, 28);
        this.rFinger03.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.rFinger03.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.lQuillD = new ModelRenderer(this, 24, 57);
        this.lQuillD.setRotationPoint(0.0F, -0.5F, 0.2F);
        this.lQuillD.addBox(-0.49F, -0.5F, -0.4F, 1, 1, 2, 0.0F);
        this.setRotation(lQuillD, -0.136659280431156F, 0.0F, 0.0F);
        this.lFinger01 = new ModelRenderer(this, 92, 28);
        this.lFinger01.setRotationPoint(1.3F, 3.5F, 0.0F);
        this.lFinger01.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.lFoot = new ModelRenderer(this, 41, 36);
        this.lFoot.setRotationPoint(0.0F, 9.7F, 0.0F);
        this.lFoot.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotation(lFoot, -0.6829473363053812F, -0.136659280431156F, 0.0F);
        this.lFinger02 = new ModelRenderer(this, 92, 28);
        this.lFinger02.setRotationPoint(0.7F, 3.5F, 0.0F);
        this.lFinger02.addBox(0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F);
        this.head3 = new ModelRenderer(this, 59, 44);
        this.head3.setRotationPoint(0.0F, -0.2F, 3.7F);
        this.head3.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 3, 0.0F);
        this.setRotation(head3, -0.045553093477052F, 0.0F, 0.0F);
        this.rQuillB.addChild(this.rQuillC);
        this.rHand.addChild(this.rFinger04);
        this.ribs.addChild(this.rHip);
        this.rQuillC.addChild(this.rQuillD);
        this.quill2A.addChild(this.quill2B);
        this.stomach.addChild(this.lThigh);
        this.rHand.addChild(this.rFinger05);
        this.mFaceBubble.addChild(this.mFaceBubble2a);
        this.lThigh.addChild(this.lThigh2);
        this.rArmUpper.addChild(this.rUpperArm);
        this.chest.addChild(this.lQuillA);
        this.upperJaw.addChild(this.innerJaw02);
        this.chest.addChild(this.lArmUpper);
        this.lHand.addChild(this.lFinger04);
        this.quill1B.addChild(this.quill1D);
        this.rShin.addChild(this.rFoot);
        this.lHand.addChild(this.lFinger05);
        this.lFaceBubble.addChild(this.mFaceBubble);
        this.lFaceBubble.addChild(this.headSlope);
        this.lowerJaw.addChild(this.lowerJaw2);
        this.chest.addChild(this.ribs);
        this.head3.addChild(this.head4);
        this.rThigh.addChild(this.rThigh2);
        this.lArmUpper.addChild(this.lUpperArm);
        this.rHand.addChild(this.rFinger01);
        this.rThigh.addChild(this.rShin);
        this.chest.addChild(this.quill1A);
        this.chest.addChild(this.spines);
        this.mFaceBubble2a.addChild(this.mFaceBubble2b);
        this.lFoot.addChild(this.lToes01);
        this.lFaceBubble.addChild(this.rFaceBubble);
        this.rForearm.addChild(this.rHand);
        this.lQuillA.addChild(this.lQuillB);
        this.quill1A.addChild(this.quill1B);
        this.rHand.addChild(this.rFinger02);
        this.lForearm.addChild(this.lArmjoint);
        this.rForearm.addChild(this.rArmjoint);
        this.lQuillB.addChild(this.lQuillC);
        this.headBase.addChild(this.headLower1);
        this.quill1B.addChild(this.quill1C);
        this.lForearm.addChild(this.lHand);
        this.lowerJaw.addChild(this.lowerTeeth);
        this.ribs.addChild(this.lHip);
        this.lUpperArm.addChild(this.lForearm);
        this.rToes.addChild(this.rToes02);
        this.head4.addChild(this.headLower3);
        this.lThigh.addChild(this.lShin);
        this.rFoot.addChild(this.rToes);
        this.chest.addChild(this.neck);
        this.lFaceBubble.addChild(this.upperJaw0);
        this.ribs.addChild(this.stomach);
        this.chest.addChild(this.rQuillA);
        this.lToes01.addChild(this.lToes02);
        this.chest.addChild(this.rArmUpper);
        this.headBase.addChild(this.head2);
        this.lHand.addChild(this.lFinger03);
        this.rQuillA.addChild(this.rQuillB);
        this.upperJaw0.addChild(this.upperJaw);
        this.lFaceBubble.addChild(this.lowerJaw);
        this.rUpperArm.addChild(this.rForearm);
        this.neck.addChild(this.headBase);
        this.headBase.addChild(this.lFaceBubble);
        this.stomach.addChild(this.rThigh);
        this.head3.addChild(this.headLower2);
        this.rHand.addChild(this.rFinger03);
        this.lQuillC.addChild(this.lQuillD);
        this.lHand.addChild(this.lFinger01);
        this.lShin.addChild(this.lFoot);
        this.lHand.addChild(this.lFinger02);
        this.head2.addChild(this.head3);

    }
    
    @Override
    public void render(Object obj)
    {
        EntityXenomorph xenomorph = (EntityXenomorph) obj;
        float swingProgress = swingProgress(obj);
        float swingProgressPrev = swingProgressPrev(obj);

        if (xenomorph != null)
        {
            float innerJawDistance = XenomorphJawState.calculateJawOffset(xenomorph.getInnerJawProgress());
            float lowerJawAngle = XenomorphJawState.interpolateLowerJawAngle(xenomorph.getOuterJawProgress());

            this.upperJaw.offsetY = (0.025F * innerJawDistance * Game.partialTicks()) / Game.partialTicks();
            this.upperJaw.offsetZ = (-0.075F * innerJawDistance * Game.partialTicks()) / Game.partialTicks();
            this.lowerJaw.offsetY = (0.055F * innerJawDistance * Game.partialTicks()) / Game.partialTicks();
            this.lowerJaw.offsetZ = (-0.075F * innerJawDistance * Game.partialTicks()) / Game.partialTicks();
            this.lowerJaw.rotateAngleX = (float) Math.toRadians((lowerJawAngle - 70) * Game.partialTicks()) / Game.partialTicks();
        }
        this.headBase.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.rThigh.rotateAngleX = MathHelper.cos(swingProgress * 0.8662F + (float) Math.PI) * 0.9F * swingProgressPrev - 0.3F;
        this.lThigh.rotateAngleX = MathHelper.sin(swingProgress * 0.8662F + (float) Math.PI) * 0.9F * swingProgressPrev - 0.3F;
        this.rArmUpper.rotateAngleX = MathHelper.cos(swingProgress * 0.3662F) * 0.6F * swingProgressPrev;
        this.lArmUpper.rotateAngleX = MathHelper.sin(swingProgress * 0.3662F) * 0.6F * swingProgressPrev;
        this.rShin.rotateAngleX = -this.rThigh.rotateAngleX + 0.3F;
        this.lShin.rotateAngleX = -this.lThigh.rotateAngleX + 0.3F;
        
        draw(chest);
    }
}
