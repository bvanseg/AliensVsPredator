package org.avp.client.model.entities.living;

import org.avp.common.entities.living.vardic.EntityBabyhead;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelBabyhead extends Model<EntityBabyhead>
{
    public ModelRenderer chest;
    public ModelRenderer lowerbody;
    public ModelRenderer lBackSpike;
    public ModelRenderer rBackSpike;
    public ModelRenderer uTube1;
    public ModelRenderer lTube1;
    public ModelRenderer rTube1;
    public ModelRenderer bTube1;
    public ModelRenderer spines;
    public ModelRenderer neck;
    public ModelRenderer head1;
    public ModelRenderer lShoulder;
    public ModelRenderer rShoulder;
    public ModelRenderer lLeg1;
    public ModelRenderer rLeg1;
    public ModelRenderer uTube2;
    public ModelRenderer bTube2;
    public ModelRenderer head2;
    public ModelRenderer lowerJaw;
    public ModelRenderer upperJaw;
    public ModelRenderer rheadFront;
    public ModelRenderer lheadFront;
    public ModelRenderer upperJawBone;
    public ModelRenderer lowerJawBone;
    public ModelRenderer lArmUpper;
    public ModelRenderer lArmLower;
    public ModelRenderer lHand;
    public ModelRenderer lMuscle;
    public ModelRenderer lFinger1;
    public ModelRenderer lFinger2;
    public ModelRenderer rArmUpper;
    public ModelRenderer rArmLower;
    public ModelRenderer rHand;
    public ModelRenderer rMuscle;
    public ModelRenderer rFinger1;
    public ModelRenderer rFinger2;
    public ModelRenderer lLeg2;
    public ModelRenderer lLeg3;
    public ModelRenderer lLeg4;
    public ModelRenderer lfoot;
    public ModelRenderer lToe1;
    public ModelRenderer lToe2;
    public ModelRenderer rLeg2;
    public ModelRenderer rLeg3;
    public ModelRenderer rLeg4;
    public ModelRenderer rfoot;
    public ModelRenderer rToe1;
    public ModelRenderer rToe2;

    public ModelBabyhead()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.lHand = new ModelRenderer(this, 60, 35);
        this.lHand.setRotationPoint(0.0F, 14.9F, 0.0F);
        this.lHand.addBox(-1.1F, 0.0F, -0.7F, 2, 3, 1, 0.0F);
        this.setRotation(lHand, 0.18203784098300857F, 0.0F, 0.0F);
        this.bTube2 = new ModelRenderer(this, 26, 45);
        this.bTube2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bTube2.addBox(-0.5F, -2.5F, 3.6F, 1, 1, 3, 0.0F);
        this.setRotation(bTube2, -0.18203784098300857F, 0.0F, 0.0F);
        this.rLeg4 = new ModelRenderer(this, 41, 28);
        this.rLeg4.mirror = true;
        this.rLeg4.setRotationPoint(0.0F, 4.4F, 0.4F);
        this.rLeg4.addBox(-0.5F, -0.1F, -0.5F, 1, 8, 1, 0.0F);
        this.setRotation(rLeg4, -0.6373942428283291F, 0.0F, 0.0F);
        this.uTube1 = new ModelRenderer(this, 5, 45);
        this.uTube1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.uTube1.addBox(-1.0F, -4.3F, 2.4F, 2, 2, 2, 0.0F);
        this.setRotation(uTube1, -0.136659280431156F, 0.0F, 0.0F);
        this.lMuscle = new ModelRenderer(this, 75, 0);
        this.lMuscle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lMuscle.addBox(-0.6F, 4.2F, 1.6F, 1, 3, 1, 0.0F);
        this.setRotation(lMuscle, -0.27314402793711257F, 0.0F, 0.0F);
        this.lowerbody = new ModelRenderer(this, 0, 14);
        this.lowerbody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerbody.addBox(-2.5F, 0.3F, -2.0F, 5, 4, 5, 0.0F);
        this.setRotation(lowerbody, -0.136659280431156F, 0.0F, 0.0F);
        this.lToe2 = new ModelRenderer(this, 42, 44);
        this.lToe2.setRotationPoint(-0.5F, 1.6F, 0.0F);
        this.lToe2.addBox(-0.7F, 0.2F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotation(lToe2, 0.22759093446006054F, 0.0F, 0.0F);
        this.head1 = new ModelRenderer(this, 87, 0);
        this.head1.setRotationPoint(0.0F, -4.4F, 0.0F);
        this.head1.addBox(-2.5F, -4.9F, -2.3F, 5, 4, 5, 0.0F);
        this.lLeg2 = new ModelRenderer(this, 37, 10);
        this.lLeg2.setRotationPoint(1.0F, 3.6F, 0.0F);
        this.lLeg2.addBox(-1.1F, -1.2F, -4.4F, 2, 2, 5, 0.0F);
        this.setRotation(lLeg2, 0.5918411493512771F, 0.0F, 0.0F);
        this.lLeg4 = new ModelRenderer(this, 41, 28);
        this.lLeg4.setRotationPoint(0.0F, 4.4F, 0.4F);
        this.lLeg4.addBox(-0.5F, -0.1F, -0.5F, 1, 8, 1, 0.0F);
        this.setRotation(lLeg4, -0.6373942428283291F, 0.0F, 0.0F);
        this.lBackSpike = new ModelRenderer(this, 5, 45);
        this.lBackSpike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBackSpike.addBox(1.5F, -4.0F, 3.2F, 0, 3, 7, 0.0F);
        this.setRotation(lBackSpike, 0.0F, 0.18203784098300857F, 0.0F);
        this.rFinger1 = new ModelRenderer(this, 60, 40);
        this.rFinger1.mirror = true;
        this.rFinger1.setRotationPoint(-0.6F, 2.6F, -0.3F);
        this.rFinger1.addBox(-0.6F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.spines = new ModelRenderer(this, 25, 50);
        this.spines.setRotationPoint(0.0F, -0.2F, 0.0F);
        this.spines.addBox(0.0F, 0.5F, 3.0F, 0, 4, 1, 0.0F);
        this.setRotation(spines, -0.136659280431156F, 0.0F, 0.0F);
        this.lShoulder = new ModelRenderer(this, 60, 0);
        this.lShoulder.setRotationPoint(2.2F, -3.0F, 0.1F);
        this.lShoulder.addBox(-0.5F, -0.3F, -1.5F, 2, 4, 3, 0.0F);
        this.setRotation(lShoulder, 0.18203784098300857F, 0.0F, -0.31869712141416456F);
        this.rBackSpike = new ModelRenderer(this, 5, 45);
        this.rBackSpike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBackSpike.addBox(-1.5F, -4.0F, 3.2F, 0, 3, 7, 0.0F);
        this.setRotation(rBackSpike, 0.0F, -0.18203784098300857F, 0.0F);
        this.lheadFront = new ModelRenderer(this, 88, 22);
        this.lheadFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lheadFront.addBox(-0.6F, -5.4F, -2.6F, 3, 3, 3, 0.0F);
        this.setRotation(lheadFront, 0.5009094953223726F, 0.0F, 0.0F);
        this.lfoot = new ModelRenderer(this, 41, 39);
        this.lfoot.setRotationPoint(0.0F, 7.6F, 0.0F);
        this.lfoot.addBox(-1.0F, -0.1F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotation(lfoot, -0.27314402793711257F, 0.0F, 0.0F);
        this.rfoot = new ModelRenderer(this, 41, 39);
        this.rfoot.mirror = true;
        this.rfoot.setRotationPoint(0.0F, 7.6F, 0.0F);
        this.rfoot.addBox(-1.0F, -0.1F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotation(rfoot, -0.27314402793711257F, 0.0F, 0.0F);
        this.lToe1 = new ModelRenderer(this, 42, 44);
        this.lToe1.mirror = true;
        this.lToe1.setRotationPoint(0.5F, 1.6F, 0.0F);
        this.lToe1.addBox(-0.4F, 0.2F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotation(lToe1, 0.22759093446006054F, 0.0F, 0.0F);
        this.rLeg2 = new ModelRenderer(this, 37, 10);
        this.rLeg2.mirror = true;
        this.rLeg2.setRotationPoint(-1.0F, 3.6F, 0.0F);
        this.rLeg2.addBox(-0.9F, -1.2F, -4.4F, 2, 2, 5, 0.0F);
        this.setRotation(rLeg2, 0.5918411493512771F, 0.0F, 0.0F);
        this.lFinger2 = new ModelRenderer(this, 60, 40);
        this.lFinger2.setRotationPoint(-0.6F, 2.6F, -0.3F);
        this.lFinger2.addBox(-0.6F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.lLeg1 = new ModelRenderer(this, 37, 0);
        this.lLeg1.setRotationPoint(1.6F, 4.0F, 0.3F);
        this.lLeg1.addBox(0.0F, -1.1F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotation(lLeg1, -0.6829473363053812F, 0.0F, 0.0F);
        this.lArmUpper = new ModelRenderer(this, 60, 9);
        this.lArmUpper.setRotationPoint(0.0F, 3.6F, 0.5F);
        this.lArmUpper.addBox(-0.5F, -0.4F, -1.3F, 2, 5, 2, 0.0F);
        this.setRotation(lArmUpper, -0.4553564018453205F, 0.0F, 0.0F);
        this.lArmLower = new ModelRenderer(this, 60, 17);
        this.lArmLower.setRotationPoint(0.6F, 4.3F, -0.3F);
        this.lArmLower.addBox(-0.5F, 0.0F, -0.5F, 1, 15, 1, 0.0F);
        this.setRotation(lArmLower, -0.31869712141416456F, 0.0F, 0.27314402793711257F);
        this.lTube1 = new ModelRenderer(this, 15, 45);
        this.lTube1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lTube1.addBox(1.0F, -1.4F, 2.7F, 1, 1, 3, 0.0F);
        this.setRotation(lTube1, -0.27314402793711257F, 0.18203784098300857F, 0.0F);
        this.chest = new ModelRenderer(this, 0, 0);
        this.chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.chest.addBox(-3.0F, -4.2F, -3.0F, 6, 5, 6, 0.0F);
        this.setRotation(chest, 0.40980330836826856F, 0.0F, 0.0F);
        this.lowerJawBone = new ModelRenderer(this, 88, 48);
        this.lowerJawBone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerJawBone.addBox(-1.0F, -1.0F, -1.4F, 2, 1, 3, 0.0F);
        this.lFinger1 = new ModelRenderer(this, 60, 40);
        this.lFinger1.setRotationPoint(0.6F, 2.6F, -0.3F);
        this.lFinger1.addBox(-0.6F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.rTube1 = new ModelRenderer(this, 15, 45);
        this.rTube1.mirror = true;
        this.rTube1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rTube1.addBox(-2.0F, -1.4F, 2.7F, 1, 1, 3, 0.0F);
        this.setRotation(rTube1, -0.27314402793711257F, -0.18203784098300857F, 0.0F);
        this.rheadFront = new ModelRenderer(this, 102, 22);
        this.rheadFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rheadFront.addBox(-2.4F, -5.4F, -2.6F, 2, 3, 3, 0.0F);
        this.setRotation(rheadFront, 0.5009094953223726F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 88, 10);
        this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head2.addBox(-2.5F, -5.5F, 0.2F, 5, 4, 4, 0.0F);
        this.setRotation(head2, -0.4553564018453205F, 0.0F, 0.0F);
        this.rShoulder = new ModelRenderer(this, 60, 0);
        this.rShoulder.mirror = true;
        this.rShoulder.setRotationPoint(-2.2F, -3.0F, 0.1F);
        this.rShoulder.addBox(-1.5F, -0.3F, -1.5F, 2, 4, 3, 0.0F);
        this.setRotation(rShoulder, 0.18203784098300857F, 0.0F, 0.31869712141416456F);
        this.upperJaw = new ModelRenderer(this, 88, 29);
        this.upperJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperJaw.addBox(-1.5F, -2.1F, -4.1F, 3, 1, 2, 0.0F);
        this.uTube2 = new ModelRenderer(this, 26, 45);
        this.uTube2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.uTube2.addBox(-0.5F, -4.8F, 3.0F, 1, 1, 3, 0.0F);
        this.setRotation(uTube2, -0.18203784098300857F, 0.0F, 0.0F);
        this.rMuscle = new ModelRenderer(this, 75, 0);
        this.rMuscle.mirror = true;
        this.rMuscle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rMuscle.addBox(-0.4F, 4.2F, 1.6F, 1, 3, 1, 0.0F);
        this.setRotation(rMuscle, -0.27314402793711257F, 0.0F, 0.0F);
        this.rFinger2 = new ModelRenderer(this, 60, 40);
        this.rFinger2.mirror = true;
        this.rFinger2.setRotationPoint(0.6F, 2.6F, -0.3F);
        this.rFinger2.addBox(-0.6F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.rLeg3 = new ModelRenderer(this, 39, 19);
        this.rLeg3.mirror = true;
        this.rLeg3.setRotationPoint(0.0F, 0.4F, -3.7F);
        this.rLeg3.addBox(-0.9F, 0.0F, -0.7F, 2, 5, 2, 0.0F);
        this.setRotation(rLeg3, 0.36425021489121656F, 0.0F, 0.0F);
        this.rToe1 = new ModelRenderer(this, 42, 44);
        this.rToe1.setRotationPoint(-0.5F, 1.6F, 0.0F);
        this.rToe1.addBox(-0.7F, 0.2F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotation(rToe1, 0.22759093446006054F, 0.0F, 0.0F);
        this.rLeg1 = new ModelRenderer(this, 37, 0);
        this.rLeg1.mirror = true;
        this.rLeg1.setRotationPoint(-1.6F, 4.0F, 0.3F);
        this.rLeg1.addBox(-2.0F, -1.1F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotation(rLeg1, -0.6829473363053812F, 0.0F, 0.0F);
        this.bTube1 = new ModelRenderer(this, 5, 45);
        this.bTube1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bTube1.addBox(-1.0F, -2.3F, 2.4F, 2, 2, 2, 0.0F);
        this.setRotation(bTube1, -0.31869712141416456F, 0.0F, 0.0F);
        this.rHand = new ModelRenderer(this, 60, 35);
        this.rHand.setRotationPoint(0.0F, 14.9F, 0.0F);
        this.rHand.addBox(-1.1F, 0.0F, -0.7F, 2, 3, 1, 0.0F);
        this.setRotation(rHand, 0.18203784098300857F, 0.0F, 0.0F);
        this.rArmLower = new ModelRenderer(this, 60, 17);
        this.rArmLower.mirror = true;
        this.rArmLower.setRotationPoint(-0.6F, 4.3F, -0.3F);
        this.rArmLower.addBox(-0.5F, 0.0F, -0.5F, 1, 15, 1, 0.0F);
        this.setRotation(rArmLower, -0.31869712141416456F, 0.0F, -0.27314402793711257F);
        this.rToe2 = new ModelRenderer(this, 42, 44);
        this.rToe2.mirror = true;
        this.rToe2.setRotationPoint(0.5F, 1.6F, 0.0F);
        this.rToe2.addBox(-0.4F, 0.2F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotation(rToe2, 0.22759093446006054F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 27);
        this.neck.setRotationPoint(0.0F, -4.1F, 0.0F);
        this.neck.addBox(-2.0F, -1.7F, -2.0F, 4, 2, 4, 0.0F);
        this.setRotation(neck, -0.136659280431156F, 0.0F, 0.0F);
        this.rArmUpper = new ModelRenderer(this, 60, 9);
        this.rArmUpper.mirror = true;
        this.rArmUpper.setRotationPoint(0.0F, 3.6F, 0.5F);
        this.rArmUpper.addBox(-1.5F, -0.4F, -1.3F, 2, 5, 2, 0.0F);
        this.setRotation(rArmUpper, -0.4553564018453205F, 0.0F, 0.0F);
        this.lLeg3 = new ModelRenderer(this, 39, 19);
        this.lLeg3.setRotationPoint(0.0F, 0.4F, -3.7F);
        this.lLeg3.addBox(-1.1F, 0.0F, -0.7F, 2, 5, 2, 0.0F);
        this.setRotation(lLeg3, 0.36425021489121656F, 0.0F, 0.0F);
        this.upperJawBone = new ModelRenderer(this, 87, 40);
        this.upperJawBone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperJawBone.addBox(-1.0F, -1.9F, -3.7F, 2, 1, 3, 0.0F);
        this.lowerJaw = new ModelRenderer(this, 88, 33);
        this.lowerJaw.setRotationPoint(0.0F, -0.6F, -2.4F);
        this.lowerJaw.addBox(-1.5F, -0.8F, -1.5F, 3, 1, 2, 0.0F);
        this.lArmLower.addChild(this.lHand);
        this.bTube1.addChild(this.bTube2);
        this.rLeg3.addChild(this.rLeg4);
        this.chest.addChild(this.uTube1);
        this.lArmLower.addChild(this.lMuscle);
        this.chest.addChild(this.lowerbody);
        this.lfoot.addChild(this.lToe2);
        this.chest.addChild(this.head1);
        this.lLeg1.addChild(this.lLeg2);
        this.lLeg3.addChild(this.lLeg4);
        this.chest.addChild(this.lBackSpike);
        this.rHand.addChild(this.rFinger1);
        this.chest.addChild(this.spines);
        this.chest.addChild(this.lShoulder);
        this.chest.addChild(this.rBackSpike);
        this.head1.addChild(this.lheadFront);
        this.lLeg4.addChild(this.lfoot);
        this.rLeg4.addChild(this.rfoot);
        this.lfoot.addChild(this.lToe1);
        this.rLeg1.addChild(this.rLeg2);
        this.lHand.addChild(this.lFinger2);
        this.chest.addChild(this.lLeg1);
        this.lShoulder.addChild(this.lArmUpper);
        this.lArmUpper.addChild(this.lArmLower);
        this.chest.addChild(this.lTube1);
        this.lowerJaw.addChild(this.lowerJawBone);
        this.lHand.addChild(this.lFinger1);
        this.chest.addChild(this.rTube1);
        this.head1.addChild(this.rheadFront);
        this.head1.addChild(this.head2);
        this.chest.addChild(this.rShoulder);
        this.head1.addChild(this.upperJaw);
        this.uTube1.addChild(this.uTube2);
        this.rArmLower.addChild(this.rMuscle);
        this.rHand.addChild(this.rFinger2);
        this.rLeg2.addChild(this.rLeg3);
        this.rfoot.addChild(this.rToe1);
        this.chest.addChild(this.rLeg1);
        this.chest.addChild(this.bTube1);
        this.rArmLower.addChild(this.rHand);
        this.rArmUpper.addChild(this.rArmLower);
        this.rfoot.addChild(this.rToe2);
        this.chest.addChild(this.neck);
        this.rShoulder.addChild(this.rArmUpper);
        this.lLeg2.addChild(this.lLeg3);
        this.head1.addChild(this.upperJawBone);
        this.head1.addChild(this.lowerJaw);
    }

    @Override
    public void render(EntityBabyhead obj)
    {
        draw(chest);
    }
}
