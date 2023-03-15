package org.alien.client.model.entity.living;

import com.asx.mdx.lib.client.util.models.Model;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;

import static com.asx.mdx.lib.client.model.animations.AnimationHelper.*;

public class ModelDeaconAdult extends Model<EntityDeaconAdult>
{
    public final Part chest01;
    public final Part chest02;
    public final Part neck;
    public final Part lShoulder;
    public final Part lShoulderRidge01;
    public final Part rShoulderRidge01;
    public final Part rShoulder;
    public final Part stomach;
    public final Part hips;
    public final Part lHipBone;
    public final Part rHipBone;
    public final Part lThigh;
    public final Part rThigh;
    public final Part tail01a;
    public final Part lShin;
    public final Part lFoot01;
    public final Part lFoot02;
    public final Part rShin;
    public final Part rFoot01;
    public final Part rFoot02;
    public final Part tail01b;
    public final Part tail01c;
    public final Part tail01d;
    public final Part tail02a;
    public final Part tail02b;
    public final Part tail02c;
    public final Part tail02d;
    public final Part tail03;
    public final Part tailBlade01;
    public final Part tailBlade02;
    public final Part head;
    public final Part upperJaw;
    public final Part muzzle;
    public final Part lowerJaw;
    public final Part jawTendon01;
    public final Part head01;
    public final Part headLower01;
    public final Part innerJaw01;
    public final Part lowerJaw02;
    public final Part lowerTeeth01;
    public final Part lowerTeeth02;
    public final Part jawTendon02;
    public final Part head02;
    public final Part head03;
    public final Part head04;
    public final Part headLower02;
    public final Part headLower03;
    public final Part innerJaw02;
    public final Part lUpperArm;
    public final Part lLowerArm;
    public final Part lHand;
    public final Part lArmSpike;
    public final Part lFinger01;
    public final Part lFinger02;
    public final Part lFinger03;
    public final Part lFinger04;
    public final Part lFinger05;
    public final Part lShoulderRidge02;
    public final Part lShoulderRidge03;
    public final Part rShoulderRidge02;
    public final Part rShoulderRidge03;
    public final Part rUpperArm;
    public final Part rLowerArm;
    public final Part rHand;
    public final Part lArmSpike_1;
    public final Part rFinger01;
    public final Part rFinger02;
    public final Part rFinger03;
    public final Part rFinger04;
    public final Part rFinger05;

    public ModelDeaconAdult()
    {
        super();
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rFinger01 = new Part(this, 67, 53);
        this.rFinger01.setRotationPoint(-1.2F, 3.1F, -1.0F);
        this.rFinger01.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(rFinger01, 0.22759093446006054F, 0.0F, 0.136659280431156F);
        this.neck = new Part(this, 33, 0);
        this.neck.setRotationPoint(0.0F, -8.6F, 0.0F);
        this.neck.addBox(-2.5F, -4.1F, -3.0F, 5, 4, 6, 0.0F);
        this.setRotation(neck, 0.045553093477052F, 0.0F, 0.0F);
        this.hips = new Part(this, 30, 13);
        this.hips.setRotationPoint(0.0F, 10.0F, 1.7F);
        this.hips.addBox(-3.5F, -4.7F, -4.2F, 7, 4, 6, 0.0F);
        this.setRotation(hips, 0.091106186954104F, 0.0F, 0.0F);
        this.rFoot01 = new Part(this, 117, 0);
        this.rFoot01.mirror = true;
        this.rFoot01.setRotationPoint(-0.1F, 10.9F, 0.0F);
        this.rFoot01.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotation(rFoot01, -0.7285004297824331F, 0.045553093477052F, 0.0F);
        this.rFoot02 = new Part(this, 107, 10);
        this.rFoot02.mirror = true;
        this.rFoot02.setRotationPoint(0.0F, 4.4F, -0.7F);
        this.rFoot02.addBox(-1.5F, 0.0F, -4.5F, 3, 2, 7, 0.0F);
        this.setRotation(rFoot02, 0.22759093446006054F, 0.18203784098300857F, 0.045553093477052F);
        this.headLower01 = new Part(this, 73, 58);
        this.headLower01.setRotationPoint(0.0F, -0.9F, 2.7F);
        this.headLower01.addBox(-2.0F, -0.2F, 0.0F, 4, 1, 4, 0.0F);
        this.rShoulderRidge03 = new Part(this, 31, 41);
        this.rShoulderRidge03.mirror = true;
        this.rShoulderRidge03.setRotationPoint(0.0F, 0.1F, 3.7F);
        this.rShoulderRidge03.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotation(rShoulderRidge03, -0.18203784098300857F, -0.18203784098300857F, -0.7853981633974483F);
        this.rShin = new Part(this, 88, 0);
        this.rShin.mirror = true;
        this.rShin.setRotationPoint(-1.9F, 13.4F, 0.5F);
        this.rShin.addBox(-1.5F, -1.0F, -2.0F, 3, 13, 4, 0.0F);
        this.setRotation(rShin, 0.8196066167365371F, 0.0F, -0.27314402793711257F);
        this.tailBlade01 = new Part(this, 22, 56);
        this.tailBlade01.setRotationPoint(0.0F, 4.3F, 0.3F);
        this.tailBlade01.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotation(tailBlade01, -0.136659280431156F, 0.0F, 0.0F);
        this.head02 = new Part(this, 66, 31);
        this.head02.setRotationPoint(0.0F, 0.0F, 3.9F);
        this.head02.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 3, 0.0F);
        this.setRotation(head02, -0.045553093477052F, 0.0F, 0.0F);
        this.lShoulderRidge01 = new Part(this, 31, 25);
        this.lShoulderRidge01.setRotationPoint(3.5F, -8.1F, -1.9F);
        this.lShoulderRidge01.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 4, 0.0F);
        this.setRotation(lShoulderRidge01, 0.36425021489121656F, 0.0F, 0.7740535232594852F);
        this.lowerTeeth01 = new Part(this, 30, 54);
        this.lowerTeeth01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerTeeth01.addBox(-1.75F, -1.1F, -3.8F, 3, 1, 2, 0.0F);
        this.rFinger02 = new Part(this, 67, 53);
        this.rFinger02.mirror = true;
        this.rFinger02.setRotationPoint(-0.5F, 3.4F, -1.0F);
        this.rFinger02.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(rFinger02, 0.22759093446006054F, 0.0F, 0.091106186954104F);
        this.lArmSpike_1 = new Part(this, 32, 47);
        this.lArmSpike_1.mirror = true;
        this.lArmSpike_1.setRotationPoint(0.0F, 0.7F, 0.0F);
        this.lArmSpike_1.addBox(-1.0F, -3.1F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotation(lArmSpike_1, -0.5009094953223726F, -0.7853981633974483F, 0.31869712141416456F);
        this.lUpperArm = new Part(this, 45, 49);
        this.lUpperArm.setRotationPoint(1.5F, 3.6F, 0.0F);
        this.lUpperArm.addBox(-1.0F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
        this.setRotation(lUpperArm, -0.091106186954104F, 0.0F, 0.136659280431156F);
        this.lHand = new Part(this, 67, 49);
        this.lHand.setRotationPoint(0.0F, 9.5F, 0.0F);
        this.lHand.addBox(-1.5F, 0.0F, -1.0F, 3, 4, 1, 0.0F);
        this.setRotation(lHand, 0.27314402793711257F, -0.8196066167365371F, 0.0F);
        this.tail02b = new Part(this, 16, 49);
        this.tail02b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail02b.addBox(-0.75F, 0.0F, -0.2F, 1, 4, 1, 0.0F);
        this.tail02c = new Part(this, 11, 55);
        this.tail02c.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail02c.addBox(-0.25F, 0.0F, -0.8F, 1, 4, 1, 0.0F);
        this.tail02d = new Part(this, 16, 55);
        this.tail02d.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail02d.addBox(-0.75F, 0.0F, -0.8F, 1, 4, 1, 0.0F);
        this.innerJaw02 = new Part(this, 115, 28);
        this.innerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.innerJaw02.addBox(0.88F, -1.8F, -5.1F, 1, 2, 5, 0.0F);
        this.lShoulderRidge03 = new Part(this, 31, 41);
        this.lShoulderRidge03.setRotationPoint(0.0F, 0.1F, 3.7F);
        this.lShoulderRidge03.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotation(lShoulderRidge03, -0.18203784098300857F, 0.18203784098300857F, 0.7853981633974483F);
        this.rShoulderRidge02 = new Part(this, 31, 33);
        this.rShoulderRidge02.mirror = true;
        this.rShoulderRidge02.setRotationPoint(0.0F, -1.1F, 1.6F);
        this.rShoulderRidge02.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4, 0.0F);
        this.setRotation(rShoulderRidge02, -0.36425021489121656F, 0.0F, 0.0F);
        this.tail01c = new Part(this, 0, 54);
        this.tail01c.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail01c.addBox(-0.25F, 0.0F, -0.8F, 1, 3, 1, 0.0F);
        this.lShoulder = new Part(this, 45, 38);
        this.lShoulder.setRotationPoint(3.0F, -6.6F, 0.0F);
        this.lShoulder.addBox(0.0F, -1.0F, -2.0F, 3, 5, 4, 0.0F);
        this.setRotation(lShoulder, 0.045553093477052F, 0.0F, -0.36425021489121656F);
        this.rFinger05 = new Part(this, 72, 53);
        this.rFinger05.setRotationPoint(1.2F, 1.5F, -0.6F);
        this.rFinger05.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(rFinger05, 0.22759093446006054F, 0.0F, -0.136659280431156F);
        this.tailBlade02 = new Part(this, 21, 60);
        this.tailBlade02.setRotationPoint(0.0F, 0.7F, 0.0F);
        this.tailBlade02.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotation(tailBlade02, -0.18203784098300857F, 0.7853981633974483F, -0.136659280431156F);
        this.tail02a = new Part(this, 11, 49);
        this.tail02a.setRotationPoint(0.0F, 2.7F, 0.0F);
        this.tail02a.addBox(-0.25F, 0.0F, -0.2F, 1, 4, 1, 0.0F);
        this.setRotation(tail02a, -0.18203784098300857F, 0.0F, 0.0F);
        this.lowerJaw02 = new Part(this, 104, 53);
        this.lowerJaw02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerJaw02.addBox(0.88F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.lArmSpike = new Part(this, 32, 47);
        this.lArmSpike.setRotationPoint(0.0F, 0.7F, 0.0F);
        this.lArmSpike.addBox(-1.0F, -3.1F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotation(lArmSpike, -0.5009094953223726F, 0.7853981633974483F, -0.31869712141416456F);
        this.rFinger04 = new Part(this, 67, 53);
        this.rFinger04.setRotationPoint(1.2F, 3.1F, -1.0F);
        this.rFinger04.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(rFinger04, 0.22759093446006054F, 0.0F, 0.0F);
        this.innerJaw01 = new Part(this, 106, 36);
        this.innerJaw01.setRotationPoint(0.0F, -1.3F, -1.9F);
        this.innerJaw01.addBox(-1.78F, -1.8F, -5.1F, 3, 2, 5, 0.0F);
        this.rShoulderRidge01 = new Part(this, 31, 25);
        this.rShoulderRidge01.mirror = true;
        this.rShoulderRidge01.setRotationPoint(-3.5F, -8.1F, -1.9F);
        this.rShoulderRidge01.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 4, 0.0F);
        this.setRotation(rShoulderRidge01, 0.36425021489121656F, 0.0F, -0.7740535232594852F);
        this.lFinger04 = new Part(this, 67, 53);
        this.lFinger04.setRotationPoint(-1.2F, 3.1F, -1.0F);
        this.lFinger04.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(lFinger04, 0.22759093446006054F, 0.0F, 0.0F);
        this.rHand = new Part(this, 67, 49);
        this.rHand.setRotationPoint(0.0F, 9.5F, 0.0F);
        this.rHand.addBox(-1.5F, 0.0F, -1.0F, 3, 4, 1, 0.0F);
        this.setRotation(rHand, 0.27314402793711257F, 0.8196066167365371F, 0.0F);
        this.jawTendon02 = new Part(this, 104, 45);
        this.jawTendon02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.jawTendon02.addBox(0.98F, 0.1F, -2.5F, 1, 2, 4, 0.0F);
        this.chest02 = new Part(this, 0, 20);
        this.chest02.setRotationPoint(0.0F, -1.9F, 0.0F);
        this.chest02.addBox(-3.5F, 0.3F, -3.7F, 7, 2, 7, 0.0F);
        this.setRotation(chest02, -0.045553093477052F, 0.0F, 0.0F);
        this.tail01a = new Part(this, 0, 49);
        this.tail01a.setRotationPoint(0.0F, -1.3F, 1.2F);
        this.tail01a.addBox(-0.25F, 0.0F, -0.2F, 1, 3, 1, 0.0F);
        this.setRotation(tail01a, 0.22759093446006054F, 0.0F, 0.0F);
        this.tail03 = new Part(this, 22, 49);
        this.tail03.setRotationPoint(0.0F, 3.6F, 0.0F);
        this.tail03.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.setRotation(tail03, -0.18203784098300857F, 0.0F, 0.0F);
        this.lFinger01 = new Part(this, 67, 53);
        this.lFinger01.setRotationPoint(1.2F, 3.1F, -1.0F);
        this.lFinger01.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(lFinger01, 0.22759093446006054F, 0.0F, -0.136659280431156F);
        this.lowerJaw = new Part(this, 86, 53);
        this.lowerJaw.setRotationPoint(0.0F, -0.9F, -3.1F);
        this.lowerJaw.addBox(-1.78F, -0.5F, -4.0F, 3, 1, 4, 0.0F);
        this.lShin = new Part(this, 88, 0);
        this.lShin.setRotationPoint(1.9F, 13.4F, 0.5F);
        this.lShin.addBox(-1.5F, -1.0F, -2.0F, 3, 13, 4, 0.0F);
        this.setRotation(lShin, 0.8196066167365371F, 0.0F, 0.27314402793711257F);
        this.rFinger03 = new Part(this, 67, 53);
        this.rFinger03.setRotationPoint(0.4F, 3.4F, -1.0F);
        this.rFinger03.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(rFinger03, 0.22759093446006054F, 0.0F, 0.045553093477052F);
        this.rUpperArm = new Part(this, 45, 49);
        this.rUpperArm.mirror = true;
        this.rUpperArm.setRotationPoint(-1.5F, 3.6F, 0.0F);
        this.rUpperArm.addBox(-1.0F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
        this.setRotation(rUpperArm, -0.091106186954104F, 0.0F, -0.136659280431156F);
        this.lShoulderRidge02 = new Part(this, 31, 33);
        this.lShoulderRidge02.setRotationPoint(0.0F, -1.1F, 1.6F);
        this.lShoulderRidge02.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 4, 0.0F);
        this.setRotation(lShoulderRidge02, -0.36425021489121656F, 0.0F, 0.0F);
        this.headLower03 = new Part(this, 109, 59);
        this.headLower03.setRotationPoint(0.0F, -0.1F, 3.8F);
        this.headLower03.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 4, 0.0F);
        this.setRotation(headLower03, -0.091106186954104F, 0.0F, 0.0F);
        this.tail01b = new Part(this, 5, 49);
        this.tail01b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail01b.addBox(-0.75F, 0.0F, -0.2F, 1, 3, 1, 0.0F);
        this.head01 = new Part(this, 73, 21);
        this.head01.setRotationPoint(0.0F, -3.0F, 2.7F);
        this.head01.addBox(-2.5F, -1.7F, 0.0F, 5, 4, 4, 0.0F);
        this.setRotation(head01, -0.136659280431156F, 0.0F, 0.0F);
        this.rThigh = new Part(this, 57, 0);
        this.rThigh.mirror = true;
        this.rThigh.setRotationPoint(-0.3F, -1.8F, -0.5F);
        this.rThigh.addBox(-4.0F, -1.0F, -2.5F, 4, 15, 5, 0.0F);
        this.setRotation(rThigh, -0.5462880558742251F, 0.0F, 0.22759093446006054F);
        this.rLowerArm = new Part(this, 58, 49);
        this.rLowerArm.mirror = true;
        this.rLowerArm.setRotationPoint(0.0F, 6.8F, 0.0F);
        this.rLowerArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        this.setRotation(rLowerArm, -0.5009094953223726F, 0.0F, -0.045553093477052F);
        this.jawTendon01 = new Part(this, 86, 45);
        this.jawTendon01.setRotationPoint(0.0F, -2.3F, -4.6F);
        this.jawTendon01.addBox(-1.98F, 0.1F, -2.5F, 3, 2, 4, 0.0F);
        this.lFinger02 = new Part(this, 67, 53);
        this.lFinger02.setRotationPoint(0.5F, 3.4F, -1.0F);
        this.lFinger02.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(lFinger02, 0.22759093446006054F, 0.0F, -0.091106186954104F);
        this.lFinger03 = new Part(this, 67, 53);
        this.lFinger03.setRotationPoint(-0.4F, 3.4F, -1.0F);
        this.lFinger03.addBox(0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F);
        this.setRotation(lFinger03, 0.22759093446006054F, 0.0F, -0.045553093477052F);
        this.chest01 = new Part(this, 0, 0);
        this.chest01.setRotationPoint(0.0F, -11.4F, 1.0F);
        this.chest01.addBox(-4.0F, -9.0F, -4.3F, 8, 8, 8, 0.0F);
        this.setRotation(chest01, 0.27314402793711257F, 0.0F, 0.0F);
        this.rShoulder = new Part(this, 45, 38);
        this.rShoulder.mirror = true;
        this.rShoulder.setRotationPoint(-3.0F, -6.6F, 0.0F);
        this.rShoulder.addBox(-3.0F, -1.0F, -2.0F, 3, 5, 4, 0.0F);
        this.setRotation(rShoulder, 0.045553093477052F, 0.0F, 0.36425021489121656F);
        this.lFoot02 = new Part(this, 107, 10);
        this.lFoot02.setRotationPoint(0.0F, 4.4F, -0.7F);
        this.lFoot02.addBox(-1.5F, 0.0F, -4.5F, 3, 2, 7, 0.0F);
        this.setRotation(lFoot02, 0.27314402793711257F, -0.18203784098300857F, -0.045553093477052F);
        this.tail01d = new Part(this, 5, 54);
        this.tail01d.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail01d.addBox(-0.75F, 0.0F, -0.8F, 1, 3, 1, 0.0F);
        this.lFinger05 = new Part(this, 72, 53);
        this.lFinger05.setRotationPoint(-1.2F, 1.5F, -0.6F);
        this.lFinger05.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotation(lFinger05, 0.22759093446006054F, 0.0F, 0.136659280431156F);
        this.rHipBone = new Part(this, 46, 26);
        this.rHipBone.mirror = true;
        this.rHipBone.setRotationPoint(-2.5F, 7.0F, 0.5F);
        this.rHipBone.addBox(-1.5F, -3.0F, -3.0F, 2, 3, 6, 0.0F);
        this.setRotation(rHipBone, 0.045553093477052F, 0.0F, -0.7285004297824331F);
        this.head = new Part(this, 92, 20);
        this.head.setRotationPoint(0.0F, -3.1F, 0.0F);
        this.head.addBox(-3.0F, -5.0F, -4.0F, 6, 5, 7, 0.0F);
        this.setRotation(head, -0.18203784098300857F, 0.0F, 0.0F);
        this.muzzle = new Part(this, 112, 49);
        this.muzzle.setRotationPoint(0.0F, -4.0F, -3.8F);
        this.muzzle.addBox(-2.0F, -0.54F, -3.4F, 4, 2, 4, 0.0F);
        this.setRotation(muzzle, 0.36425021489121656F, 0.0F, 0.0F);
        this.upperJaw = new Part(this, 89, 37);
        this.upperJaw.setRotationPoint(0.0F, -1.9F, -4.3F);
        this.upperJaw.addBox(-2.0F, -1.5F, -2.9F, 4, 2, 4, 0.0F);
        this.lThigh = new Part(this, 57, 0);
        this.lThigh.setRotationPoint(0.3F, -1.8F, -0.5F);
        this.lThigh.addBox(0.0F, -1.0F, -2.5F, 4, 15, 5, 0.0F);
        this.setRotation(lThigh, -0.5462880558742251F, 0.0F, -0.22759093446006054F);
        this.lowerTeeth02 = new Part(this, 30, 59);
        this.lowerTeeth02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerTeeth02.addBox(0.85F, -1.1F, -3.8F, 1, 1, 2, 0.0F);
        this.head04 = new Part(this, 76, 39);
        this.head04.setRotationPoint(0.0F, 0.1F, 2.9F);
        this.head04.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotation(head04, -0.045553093477052F, 0.0F, 0.0F);
        this.head03 = new Part(this, 62, 39);
        this.head03.setRotationPoint(0.0F, -0.2F, 2.9F);
        this.head03.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 3, 0.0F);
        this.setRotation(head03, -0.045553093477052F, 0.0F, 0.0F);
        this.lFoot01 = new Part(this, 117, 0);
        this.lFoot01.setRotationPoint(0.1F, 10.9F, 0.0F);
        this.lFoot01.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotation(lFoot01, -0.7285004297824331F, -0.045553093477052F, 0.0F);
        this.headLower02 = new Part(this, 91, 59);
        this.headLower02.setRotationPoint(0.0F, 0.2F, 2.9F);
        this.headLower02.addBox(-1.5F, -0.5F, 0.0F, 3, 1, 4, 0.0F);
        this.lHipBone = new Part(this, 46, 26);
        this.lHipBone.setRotationPoint(2.5F, 7.0F, 0.5F);
        this.lHipBone.addBox(-0.5F, -3.0F, -3.0F, 2, 3, 6, 0.0F);
        this.setRotation(lHipBone, 0.045553093477052F, 0.0F, 0.7285004297824331F);
        this.stomach = new Part(this, 0, 33);
        this.stomach.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.stomach.addBox(-3.0F, 0.0F, -3.0F, 6, 9, 6, 0.0F);
        this.setRotation(stomach, -0.136659280431156F, 0.0F, 0.0F);
        this.lLowerArm = new Part(this, 58, 49);
        this.lLowerArm.setRotationPoint(0.0F, 6.8F, 0.0F);
        this.lLowerArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
        this.setRotation(lLowerArm, -0.5009094953223726F, 0.0F, 0.045553093477052F);
        
        this.rHand.addChild(this.rFinger01);
        this.chest01.addChild(this.neck);
        this.stomach.addChild(this.hips);
        this.rShin.addChild(this.rFoot01);
        this.rFoot01.addChild(this.rFoot02);
        this.head.addChild(this.headLower01);
        this.rShoulderRidge02.addChild(this.rShoulderRidge03);
        this.rThigh.addChild(this.rShin);
        this.tail03.addChild(this.tailBlade01);
        this.head01.addChild(this.head02);
        this.chest01.addChild(this.lShoulderRidge01);
        this.lowerJaw.addChild(this.lowerTeeth01);
        this.rHand.addChild(this.rFinger02);
        this.rLowerArm.addChild(this.lArmSpike_1);
        this.lShoulder.addChild(this.lUpperArm);
        this.lLowerArm.addChild(this.lHand);
        this.tail02a.addChild(this.tail02b);
        this.tail02a.addChild(this.tail02c);
        this.tail02a.addChild(this.tail02d);
        this.innerJaw01.addChild(this.innerJaw02);
        this.lShoulderRidge02.addChild(this.lShoulderRidge03);
        this.rShoulderRidge01.addChild(this.rShoulderRidge02);
        this.tail01a.addChild(this.tail01c);
        this.chest01.addChild(this.lShoulder);
        this.rHand.addChild(this.rFinger05);
        this.tailBlade01.addChild(this.tailBlade02);
        this.tail01a.addChild(this.tail02a);
        this.lowerJaw.addChild(this.lowerJaw02);
        this.lLowerArm.addChild(this.lArmSpike);
        this.rHand.addChild(this.rFinger04);
        this.head.addChild(this.innerJaw01);
        this.chest01.addChild(this.rShoulderRidge01);
        this.lHand.addChild(this.lFinger04);
        this.rLowerArm.addChild(this.rHand);
        this.jawTendon01.addChild(this.jawTendon02);
        this.chest01.addChild(this.chest02);
        this.hips.addChild(this.tail01a);
        this.tail02a.addChild(this.tail03);
        this.lHand.addChild(this.lFinger01);
        this.head.addChild(this.lowerJaw);
        this.lThigh.addChild(this.lShin);
        this.rHand.addChild(this.rFinger03);
        this.rShoulder.addChild(this.rUpperArm);
        this.lShoulderRidge01.addChild(this.lShoulderRidge02);
        this.headLower02.addChild(this.headLower03);
        this.tail01a.addChild(this.tail01b);
        this.head.addChild(this.head01);
        this.hips.addChild(this.rThigh);
        this.rUpperArm.addChild(this.rLowerArm);
        this.head.addChild(this.jawTendon01);
        this.lHand.addChild(this.lFinger02);
        this.lHand.addChild(this.lFinger03);
        this.chest01.addChild(this.rShoulder);
        this.lFoot01.addChild(this.lFoot02);
        this.tail01a.addChild(this.tail01d);
        this.lHand.addChild(this.lFinger05);
        this.stomach.addChild(this.rHipBone);
        this.neck.addChild(this.head);
        this.head.addChild(this.muzzle);
        this.head.addChild(this.upperJaw);
        this.hips.addChild(this.lThigh);
        this.lowerJaw.addChild(this.lowerTeeth02);
        this.head03.addChild(this.head04);
        this.head02.addChild(this.head03);
        this.lShin.addChild(this.lFoot01);
        this.headLower01.addChild(this.headLower02);
        this.stomach.addChild(this.lHipBone);
        this.chest02.addChild(this.stomach);
        this.lUpperArm.addChild(this.lLowerArm);
        
        updateDefaultPose();
    }
    
    @Override
    public void render(EntityDeaconAdult deacon)
    {
        updateAnimations(deacon);

        float speed = (float) (Math.PI * 0.225);
        float mult = 0.8F;

        bob(chest01, 2F * speed, 1 * 0.75F, false, swingProgress(deacon), swingProgressPrev(deacon));
        swing(chest01, 1F * speed, 0.3F * mult, false, 0, 0, swingProgress(deacon), swingProgressPrev(deacon));
        swing(chest02, 1F * speed, 0.3F * mult, true, 0, 0, swingProgress(deacon), swingProgressPrev(deacon));
        swing(stomach, 1F * speed, 0.6F * mult, false, 0, 0, swingProgress(deacon), swingProgressPrev(deacon));
        swing(hips, 1F * speed, 0.3F * mult, false, 0, 0, swingProgress(deacon), swingProgressPrev(deacon));

        oscillate(lThigh, 1F * speed, 0.6F * mult, false, 0, 0.3F * mult, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(lShin, 1F * speed, 0.6F * mult, false, -2.2F, 0.1F * mult, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(lFoot01, 1F * speed, 0.4F * mult, false, -2.1F, 0.26F * mult, swingProgress(deacon), swingProgressPrev(deacon));

        oscillate(rThigh, 1F * speed, 0.6F * mult, true, 0, -0.3F * mult, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(rShin, 1F * speed, 0.6F * mult, true, -2.2F, -0.1F * mult, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(rFoot01, 1F * speed, 0.4F * mult, true, -2.1F, -0.26F * mult, swingProgress(deacon), swingProgressPrev(deacon));

        oscillate(neck, 2F * speed, 0.08F * 0.8F, true, -0.5F, 0.1F, swingProgress(deacon), swingProgressPrev(deacon));
        
        oscillate(tail01a, 2F * speed, 0.1F * 0.8F, false, -0.5F, 0.1F, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(tail02a, 2F * speed, 0.3F * 0.8F, false, -0.5F, 0.1F, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(tail03, 2F * speed, 0.5F * 0.8F, false, -0.5F, 0.1F, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(tailBlade01, 2F * speed, 0.2F * 0.8F, false, -0.5F, 0.1F, swingProgress(deacon), swingProgressPrev(deacon));

        flap(lShoulder, 2F * speed, 0.05F * 0.8F, false, -0.5F, 0F, swingProgress(deacon), swingProgressPrev(deacon));
        swing(lShoulder, 1F * speed, 0.1F * 0.8F, true, 0F, 0.3F, swingProgress(deacon), swingProgressPrev(deacon));
        flap(lUpperArm, 2F * speed, 0.05F * 0.8F, true, -1F, 0F, swingProgress(deacon), swingProgressPrev(deacon));
        flap(lHand, 2F * speed, 0.2F, false, 0F, 0.5F, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(lLowerArm, 2F * speed, 0.1F * mult, true, 0F, 1.25F, swingProgress(deacon), swingProgressPrev(deacon));

        flap(rShoulder, 2F * speed, 0.05F * 0.8F, false, -0.5F, 0F, swingProgress(deacon), swingProgressPrev(deacon));
        swing(rShoulder, 1F * speed, 0.1F * 0.8F, true, 0F, -0.3F, swingProgress(deacon), swingProgressPrev(deacon));
        flap(rUpperArm, 2F * speed, 0.05F * 0.8F, true, -1F, 0F, swingProgress(deacon), swingProgressPrev(deacon));
        flap(rHand, 2F * speed, 0.2F, false, 0F, -0.5F, swingProgress(deacon), swingProgressPrev(deacon));
        oscillate(rLowerArm, 2F * speed, 0.1F * mult, true, 0F, 1.25F, swingProgress(deacon), swingProgressPrev(deacon));
        
        draw(chest01);
    }
}