package org.avp.client.model.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import org.alien.common.entity.living.xenomorphs.EntityDracomorph;

public class ModelDracomorph extends Model<EntityDracomorph>
{
    public ModelRenderer chest;
    public ModelRenderer sack0;
    public ModelRenderer lWingArm1;
    public ModelRenderer rWingArm1;
    public ModelRenderer abdomen;
    public ModelRenderer backSpines1;
    public ModelRenderer backSpines2;
    public ModelRenderer neck;
    public ModelRenderer lShoulderBlade;
    public ModelRenderer rShoulderBlade;
    public ModelRenderer lArm1;
    public ModelRenderer rArm1;
    public ModelRenderer tail1;
    public ModelRenderer lThigh;
    public ModelRenderer rThigh;
    public ModelRenderer neck1;
    public ModelRenderer headBase;
    public ModelRenderer headTop;
    public ModelRenderer rHead;
    public ModelRenderer lHead;
    public ModelRenderer jaw2;
    public ModelRenderer jawLower;
    public ModelRenderer innerJaw;
    public ModelRenderer lHorn1;
    public ModelRenderer rHorn1;
    public ModelRenderer rHeadFin;
    public ModelRenderer lHeadFin;
    public ModelRenderer lHorn2;
    public ModelRenderer lHorn3;
    public ModelRenderer lHorn4;
    public ModelRenderer rHorn2;
    public ModelRenderer rHorn3;
    public ModelRenderer rHorn4;
    public ModelRenderer lArm2;
    public ModelRenderer lClaw1;
    public ModelRenderer lClaw2;
    public ModelRenderer rArm2;
    public ModelRenderer rClaw1;
    public ModelRenderer rClaw2;
    public ModelRenderer tail2;
    public ModelRenderer tailSpines1;
    public ModelRenderer tailSpines2;
    public ModelRenderer tail3;
    public ModelRenderer tailSpines3;
    public ModelRenderer tail4;
    public ModelRenderer tailSpines4;
    public ModelRenderer tail5;
    public ModelRenderer tailSpines5;
    public ModelRenderer tailStabber;
    public ModelRenderer lShin1;
    public ModelRenderer lShin2;
    public ModelRenderer lFoot;
    public ModelRenderer rShin1;
    public ModelRenderer rShin2;
    public ModelRenderer rFoot;
    public ModelRenderer sack1;
    public ModelRenderer sack2;
    public ModelRenderer sack3;
    public ModelRenderer sack4;
    public ModelRenderer sack5;
    public ModelRenderer sack6;
    public ModelRenderer sack7;
    public ModelRenderer lWingArm2;
    public ModelRenderer lWingMembrane1;
    public ModelRenderer lWingArm3;
    public ModelRenderer lWingMembrane2;
    public ModelRenderer lWingArm4;
    public ModelRenderer lWingMembrane3;
    public ModelRenderer lWingMembrane4;
    public ModelRenderer rWingArm2;
    public ModelRenderer rWingMembrane1;
    public ModelRenderer rWingArm3;
    public ModelRenderer rWingMembrane2;
    public ModelRenderer rWingArm4;
    public ModelRenderer rWingMembrane3;
    public ModelRenderer lWingMembrane4_1;

    public ModelDracomorph()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.tailSpines5 = new ModelRenderer(this, 178, 96);
        this.tailSpines5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines5.addBox(0.0F, -5.3F, 0.0F, 0, 8, 11, 0.0F);
        this.rClaw2 = new ModelRenderer(this, 60, 38);
        this.rClaw2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rClaw2.addBox(-1.0F, 0.5F, -5.6F, 3, 0, 6, 0.0F);
        this.lArm1 = new ModelRenderer(this, 40, 27);
        this.lArm1.setRotationPoint(3.5F, 3.5F, 3.5F);
        this.lArm1.addBox(0.0F, 0.0F, -0.5F, 3, 14, 3, 0.0F);
        this.setRotation(lArm1, 0.12217304763960307F, -0.0F, -0.24434609527920614F);
        this.rHeadFin = new ModelRenderer(this, 43, 111);
        this.rHeadFin.mirror = true;
        this.rHeadFin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rHeadFin.addBox(-7.6F, -16.0F, -4.1F, 7, 15, 0, 0.0F);
        this.setRotation(rHeadFin, -0.3141592653589793F, 0.13456488532876282F, 0.0F);
        this.rHorn4 = new ModelRenderer(this, 238, 44);
        this.rHorn4.mirror = true;
        this.rHorn4.setRotationPoint(0.0F, -2.1F, -0.3F);
        this.rHorn4.addBox(-0.5F, -4.0F, -0.2F, 1, 4, 1, 0.0F);
        this.setRotation(rHorn4, 0.36425021489121656F, 0.0F, 0.0F);
        this.tailStabber = new ModelRenderer(this, 205, 66);
        this.tailStabber.setRotationPoint(0.0F, 0.3F, 10.2F);
        this.tailStabber.addBox(0.0F, -3.0F, -0.4F, 0, 6, 15, 0.0F);
        this.sack3 = new ModelRenderer(this, 84, 82);
        this.sack3.setRotationPoint(0.0F, 0.2F, 7.0F);
        this.sack3.addBox(-5.5F, -2.4F, -3.1F, 11, 10, 11, 0.0F);
        this.setRotation(sack3, -0.045553093477052F, 0.0F, 0.0F);
        this.lClaw2 = new ModelRenderer(this, 60, 30);
        this.lClaw2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lClaw2.addBox(-2.0F, 0.5F, -5.6F, 3, 0, 6, 0.0F);
        this.lHorn4 = new ModelRenderer(this, 238, 44);
        this.lHorn4.setRotationPoint(0.0F, -2.1F, -0.3F);
        this.lHorn4.addBox(-0.4F, -4.0F, -0.2F, 1, 4, 1, 0.0F);
        this.setRotation(lHorn4, 0.36425021489121656F, 0.0F, 0.0F);
        this.lHorn2 = new ModelRenderer(this, 219, 42);
        this.lHorn2.setRotationPoint(0.0F, -2.9F, -0.7F);
        this.lHorn2.addBox(-0.1F, -3.7F, -1.2F, 1, 4, 2, 0.0F);
        this.setRotation(lHorn2, -0.18203784098300857F, -0.045553093477052F, -0.4553564018453205F);
        this.tailSpines3 = new ModelRenderer(this, 117, 94);
        this.tailSpines3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines3.addBox(0.0F, -4.1F, 1.3F, 0, 6, 10, 0.0F);
        this.sack0 = new ModelRenderer(this, 0, 87);
        this.sack0.setRotationPoint(0.0F, 4.9F, 17.4F);
        this.sack0.addBox(-2.0F, -3.8F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotation(sack0, -0.9560913642424937F, 0.0F, 0.0F);
        this.rShoulderBlade = new ModelRenderer(this, 171, 34);
        this.rShoulderBlade.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rShoulderBlade.addBox(-6.0F, -1.0F, -7.2F, 2, 3, 10, 0.0F);
        this.setRotation(rShoulderBlade, 1.4114477660878142F, 0.18203784098300857F, -0.136659280431156F);
        this.rWingArm3 = new ModelRenderer(this, 174, 0);
        this.rWingArm3.mirror = true;
        this.rWingArm3.setRotationPoint(0.0F, 0.0F, 9.4F);
        this.rWingArm3.addBox(-0.5F, -1.1F, 0.0F, 1, 2, 9, 0.0F);
        this.setRotation(rWingArm3, -0.4038691889114879F, 0.0F, 0.0F);
        this.lWingMembrane1 = new ModelRenderer(this, 142, 4);
        this.lWingMembrane1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane1.addBox(0.0F, -7.9F, -2.1F, 0, 11, 11, 0.0F);
        this.setRotation(lWingMembrane1, -0.44872415068774213F, 0.0F, 0.0F);
        this.rWingArm4 = new ModelRenderer(this, 200, 0);
        this.rWingArm4.mirror = true;
        this.rWingArm4.setRotationPoint(0.0F, 0.0F, 8.3F);
        this.rWingArm4.addBox(-0.5F, -0.7F, 0.0F, 1, 1, 10, 0.0F);
        this.setRotation(rWingArm4, -0.3141592653589793F, 0.0F, 0.0F);
        this.lWingArm2 = new ModelRenderer(this, 149, 0);
        this.lWingArm2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.lWingArm2.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 10, 0.0F);
        this.setRotation(lWingArm2, 0.13456488532876282F, 0.18203784098300857F, -0.045553093477052F);
        this.lWingMembrane4 = new ModelRenderer(this, 208, 3);
        this.lWingMembrane4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane4.addBox(0.0F, 0.0F, 1.4F, 0, 17, 14, 0.0F);
        this.jawLower = new ModelRenderer(this, 88, 1);
        this.jawLower.setRotationPoint(0.0F, 6.7F, 2.3F);
        this.jawLower.addBox(-1.5F, -0.5F, -5.2F, 3, 1, 5, 0.0F);
        this.setRotation(jawLower, 0.7740535232594852F, 0.0F, 0.0F);
        this.rWingArm1 = new ModelRenderer(this, 134, 0);
        this.rWingArm1.mirror = true;
        this.rWingArm1.setRotationPoint(-2.3F, -1.3F, 6.3F);
        this.rWingArm1.addBox(-1.0F, -9.0F, -1.5F, 2, 9, 3, 0.0F);
        this.setRotation(rWingArm1, 0.26930430358272506F, 0.0F, -0.1795943800302165F);
        this.abdomen = new ModelRenderer(this, 0, 27);
        this.abdomen.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.abdomen.addBox(-3.5F, 0.5F, 8.0F, 7, 6, 12, 0.0F);
        this.lWingArm3 = new ModelRenderer(this, 174, 0);
        this.lWingArm3.setRotationPoint(0.0F, 0.0F, 9.4F);
        this.lWingArm3.addBox(-0.5F, -1.1F, 0.0F, 1, 2, 9, 0.0F);
        this.setRotation(lWingArm3, -0.4038691889114879F, 0.0F, 0.0F);
        this.innerJaw = new ModelRenderer(this, 0, 18);
        this.innerJaw.setRotationPoint(0.0F, 6.4F, 1.2F);
        this.innerJaw.addBox(-1.0F, -0.7F, -4.6F, 2, 2, 5, 0.0F);
        this.setRotation(innerJaw, 0.7740535232594852F, 0.0F, 0.0F);
        this.tailSpines1 = new ModelRenderer(this, 58, 94);
        this.tailSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines1.addBox(0.0F, -5.5F, 0.0F, 0, 8, 11, 0.0F);
        this.chest = new ModelRenderer(this, 1, 55);
        this.chest.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.chest.addBox(-5.0F, 0.0F, 0.0F, 10, 8, 11, 0.0F);
        this.tail3 = new ModelRenderer(this, 118, 66);
        this.tail3.setRotationPoint(0.0F, 0.0F, 10.4F);
        this.tail3.addBox(-1.5F, -1.8F, 0.0F, 3, 3, 11, 0.0F);
        this.setRotation(tail3, 0.10175269539126941F, -0.0F, 0.0F);
        this.lFoot = new ModelRenderer(this, 110, 24);
        this.lFoot.setRotationPoint(1.0F, 8.2F, 0.0F);
        this.lFoot.addBox(-1.0F, -1.0F, -4.5F, 2, 2, 5, 0.0F);
        this.setRotation(lFoot, 0.5462880558742251F, 0.0F, 0.136659280431156F);
        this.lWingArm4 = new ModelRenderer(this, 200, 0);
        this.lWingArm4.setRotationPoint(0.0F, 0.0F, 8.3F);
        this.lWingArm4.addBox(-0.5F, -0.7F, 0.0F, 1, 1, 10, 0.0F);
        this.setRotation(lWingArm4, -0.3141592653589793F, 0.0F, 0.0F);
        this.neck1 = new ModelRenderer(this, 65, 86);
        this.neck1.setRotationPoint(0.0F, 0.0F, -3.6F);
        this.neck1.addBox(-2.5F, -3.0F, -3.6F, 5, 6, 4, 0.0F);
        this.setRotation(neck1, -0.136659280431156F, 0.0F, 0.0F);
        this.lWingMembrane3 = new ModelRenderer(this, 188, 8);
        this.lWingMembrane3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane3.addBox(0.0F, 0.0F, 0.7F, 0, 15, 9, 0.0F);
        this.jaw2 = new ModelRenderer(this, 52, 20);
        this.jaw2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.jaw2.addBox(-1.5F, 5.0F, -8.4F, 3, 1, 5, 0.0F);
        this.setRotation(jaw2, 0.7740535232594852F, -0.0F, 0.0F);
        this.lHeadFin = new ModelRenderer(this, 43, 111);
        this.lHeadFin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lHeadFin.addBox(0.6F, -16.0F, -4.1F, 7, 15, 0, 0.0F);
        this.setRotation(lHeadFin, -0.3141592653589793F, -0.13456488532876282F, 0.0F);
        this.lHead = new ModelRenderer(this, 53, 0);
        this.lHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lHead.addBox(-0.5F, 4.1F, -6.7F, 3, 3, 5, 0.0F);
        this.setRotation(lHead, 0.5009094953223726F, -0.0F, 0.0F);
        this.rArm2 = new ModelRenderer(this, 103, 6);
        this.rArm2.setRotationPoint(-0.2F, 13.8F, 0.7F);
        this.rArm2.addBox(-1.7F, -1.4F, -10.1F, 3, 3, 11, 0.0F);
        this.setRotation(rArm2, 0.9560913642424937F, -0.0F, -0.045553093477052F);
        this.tail2 = new ModelRenderer(this, 85, 66);
        this.tail2.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.tail2.addBox(-2.0F, -2.5F, -0.1F, 4, 4, 11, 0.0F);
        this.setRotation(tail2, 0.091106186954104F, -0.0F, 0.0F);
        this.rShin1 = new ModelRenderer(this, 79, 33);
        this.rShin1.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.rShin1.addBox(-1.0F, 0.0F, -0.5F, 3, 3, 12, 0.0F);
        this.lThigh = new ModelRenderer(this, 40, 45);
        this.lThigh.setRotationPoint(4.5F, 3.5F, 17.0F);
        this.lThigh.addBox(-2.5F, -2.0F, -1.0F, 4, 14, 5, 0.0F);
        this.setRotation(lThigh, -0.4923573819876004F, -0.2228785454796759F, -0.43022366061660217F);
        this.rShin2 = new ModelRenderer(this, 113, 53);
        this.rShin2.setRotationPoint(0.3F, 1.5F, 10.4F);
        this.rShin2.addBox(-1.0F, -0.2F, -1.1F, 2, 9, 2, 0.0F);
        this.setRotation(rShin2, 0.0F, 0.0F, -0.36425021489121656F);
        this.headTop = new ModelRenderer(this, 28, 10);
        this.headTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headTop.addBox(-2.5F, -11.8F, -4.7F, 5, 10, 5, 0.0F);
        this.setRotation(headTop, -0.31869712141416456F, -0.0F, 0.0F);
        this.backSpines2 = new ModelRenderer(this, 22, 65);
        this.backSpines2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.backSpines2.addBox(0.0F, -5.5F, 8.5F, 0, 6, 12, 0.0F);
        this.tailSpines4 = new ModelRenderer(this, 148, 96);
        this.tailSpines4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines4.addBox(0.0F, -5.3F, 1.0F, 0, 8, 10, 0.0F);
        this.sack2 = new ModelRenderer(this, 0, 111);
        this.sack2.setRotationPoint(0.0F, 0.2F, 4.5F);
        this.sack2.addBox(-5.0F, -2.4F, -1.3F, 10, 9, 8, 0.0F);
        this.setRotation(sack2, 0.27314402793711257F, 0.0F, 0.0F);
        this.rWingMembrane1 = new ModelRenderer(this, 142, 4);
        this.rWingMembrane1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWingMembrane1.addBox(0.0F, -7.9F, -2.1F, 0, 11, 11, 0.0F);
        this.setRotation(rWingMembrane1, -0.44872415068774213F, 0.0F, 0.0F);
        this.rWingArm2 = new ModelRenderer(this, 149, 0);
        this.rWingArm2.mirror = true;
        this.rWingArm2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.rWingArm2.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 10, 0.0F);
        this.setRotation(rWingArm2, 0.13456488532876282F, -0.18203784098300857F, -0.045553093477052F);
        this.rHorn2 = new ModelRenderer(this, 219, 42);
        this.rHorn2.mirror = true;
        this.rHorn2.setRotationPoint(0.0F, -2.9F, -0.7F);
        this.rHorn2.addBox(-1.0F, -3.6F, -1.2F, 1, 4, 2, 0.0F);
        this.setRotation(rHorn2, -0.18203784098300857F, 0.045553093477052F, 0.4553564018453205F);
        this.rFoot = new ModelRenderer(this, 95, 24);
        this.rFoot.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.rFoot.addBox(-1.0F, -1.0F, -4.4F, 2, 2, 5, 0.0F);
        this.setRotation(rFoot, 0.5462880558742251F, 0.0F, -0.136659280431156F);
        this.lHorn3 = new ModelRenderer(this, 228, 41);
        this.lHorn3.setRotationPoint(0.2F, -3.5F, 0.0F);
        this.lHorn3.addBox(-0.4F, -2.6F, -1.2F, 1, 3, 2, 0.0F);
        this.setRotation(lHorn3, -0.4553564018453205F, -0.045553093477052F, -0.136659280431156F);
        this.rHorn3 = new ModelRenderer(this, 228, 41);
        this.rHorn3.mirror = true;
        this.rHorn3.setRotationPoint(-0.4F, -3.5F, 0.0F);
        this.rHorn3.addBox(-0.5F, -2.6F, -1.1F, 1, 3, 2, 0.0F);
        this.setRotation(rHorn3, -0.4553564018453205F, 0.045553093477052F, 0.136659280431156F);
        this.backSpines1 = new ModelRenderer(this, 0, 67);
        this.backSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.backSpines1.addBox(0.0F, -5.8F, 0.0F, 0, 6, 10, 0.0F);
        this.rThigh = new ModelRenderer(this, 59, 45);
        this.rThigh.setRotationPoint(-4.5F, 3.5F, 16.0F);
        this.rThigh.addBox(-1.5F, -2.0F, -1.0F, 4, 14, 5, 0.0F);
        this.setRotation(rThigh, -0.4923573819876004F, 0.2228785454796759F, 0.43022366061660217F);
        this.headBase = new ModelRenderer(this, 0, 0);
        this.headBase.setRotationPoint(0.0F, -0.8F, -4.0F);
        this.headBase.addBox(-2.5F, -3.2F, -3.9F, 5, 10, 5, 0.0F);
        this.setRotation(headBase, -0.22444934180647075F, -0.0F, 0.0F);
        this.sack1 = new ModelRenderer(this, 0, 98);
        this.sack1.setRotationPoint(0.0F, -3.4F, 4.2F);
        this.sack1.addBox(-3.5F, -1.2F, -1.3F, 7, 6, 6, 0.0F);
        this.setRotation(sack1, 0.5009094953223726F, 0.0F, 0.0F);
        this.rWingMembrane2 = new ModelRenderer(this, 166, 5);
        this.rWingMembrane2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWingMembrane2.addBox(0.0F, 0.0F, 0.0F, 0, 13, 10, 0.0F);
        this.rHorn1 = new ModelRenderer(this, 207, 41);
        this.rHorn1.mirror = true;
        this.rHorn1.setRotationPoint(-1.5F, -1.6F, -1.6F);
        this.rHorn1.addBox(-1.2F, -3.2F, -1.9F, 2, 3, 2, 0.0F);
        this.setRotation(rHorn1, 0.36425021489121656F, -0.136659280431156F, -0.7285004297824331F);
        this.sack6 = new ModelRenderer(this, 217, 90);
        this.sack6.setRotationPoint(0.0F, 0.0F, 6.9F);
        this.sack6.addBox(-2.3F, -1.7F, 0.0F, 5, 6, 8, 0.0F);
        this.setRotation(sack6, -0.22759093446006054F, 0.0F, 0.0F);
        this.sack4 = new ModelRenderer(this, 132, 82);
        this.sack4.setRotationPoint(0.0F, -0.4F, 8.0F);
        this.sack4.addBox(-4.5F, -2.4F, -1.8F, 9, 10, 10, 0.0F);
        this.setRotation(sack4, 0.18203784098300857F, 0.0F, 0.0F);
        this.lHorn1 = new ModelRenderer(this, 207, 41);
        this.lHorn1.setRotationPoint(1.5F, -1.6F, -1.6F);
        this.lHorn1.addBox(-1.0F, -3.2F, -1.9F, 2, 3, 2, 0.0F);
        this.setRotation(lHorn1, 0.36425021489121656F, 0.136659280431156F, 0.7285004297824331F);
        this.lArm2 = new ModelRenderer(this, 71, 6);
        this.lArm2.setRotationPoint(1.7F, 13.8F, 0.7F);
        this.lArm2.addBox(-1.7F, -1.4F, -10.1F, 3, 3, 11, 0.0F);
        this.setRotation(lArm2, 0.9560913642424937F, -0.0F, 0.045553093477052F);
        this.tailSpines2 = new ModelRenderer(this, 89, 94);
        this.tailSpines2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines2.addBox(0.0F, -4.9F, 0.2F, 0, 8, 11, 0.0F);
        this.sack7 = new ModelRenderer(this, 215, 108);
        this.sack7.setRotationPoint(0.0F, 1.2F, 8.0F);
        this.sack7.addBox(-1.5F, -0.9F, -0.7F, 3, 3, 7, 0.0F);
        this.setRotation(sack7, -0.5918411493512771F, 0.0F, 0.0F);
        this.lShin1 = new ModelRenderer(this, 79, 49);
        this.lShin1.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.lShin1.addBox(-2.0F, 0.0F, -0.5F, 3, 3, 12, 0.0F);
        this.rClaw1 = new ModelRenderer(this, 72, 24);
        this.rClaw1.setRotationPoint(-0.2F, 0.1F, -10.0F);
        this.rClaw1.addBox(-1.0F, -0.2F, -2.6F, 2, 1, 3, 0.0F);
        this.setRotation(rClaw1, -1.0471975511965976F, -0.045553093477052F, -0.22759093446006054F);
        this.lClaw1 = new ModelRenderer(this, 83, 24);
        this.lClaw1.setRotationPoint(-0.2F, 0.1F, -10.0F);
        this.lClaw1.addBox(-1.0F, -0.2F, -2.6F, 2, 1, 3, 0.0F);
        this.setRotation(lClaw1, -1.0471975511965976F, 0.045553093477052F, 0.22759093446006054F);
        this.tail4 = new ModelRenderer(this, 149, 66);
        this.tail4.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 11, 0.0F);
        this.setRotation(tail4, 0.091106186954104F, -0.0F, 0.0F);
        this.lWingArm1 = new ModelRenderer(this, 134, 0);
        this.lWingArm1.setRotationPoint(2.3F, -1.3F, 6.3F);
        this.lWingArm1.addBox(-1.0F, -9.0F, -1.5F, 2, 9, 3, 0.0F);
        this.setRotation(lWingArm1, 0.22759093446006054F, 0.0F, 0.1795943800302165F);
        this.rArm1 = new ModelRenderer(this, 50, 85);
        this.rArm1.setRotationPoint(-3.5F, 3.5F, 3.5F);
        this.rArm1.addBox(-2.0F, 0.0F, -0.5F, 3, 14, 3, 0.0F);
        this.setRotation(rArm1, 0.12217304763960307F, -0.0F, 0.24434609527920614F);
        this.lWingMembrane2 = new ModelRenderer(this, 166, 5);
        this.lWingMembrane2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane2.addBox(0.0F, 0.0F, 0.0F, 0, 13, 10, 0.0F);
        this.rWingMembrane3 = new ModelRenderer(this, 188, 8);
        this.rWingMembrane3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWingMembrane3.addBox(0.0F, 0.0F, 0.7F, 0, 15, 9, 0.0F);
        this.lWingMembrane4_1 = new ModelRenderer(this, 208, 3);
        this.lWingMembrane4_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane4_1.addBox(0.0F, 0.0F, 1.4F, 0, 17, 14, 0.0F);
        this.neck = new ModelRenderer(this, 23, 86);
        this.neck.setRotationPoint(0.0F, 3.2F, -0.8F);
        this.neck.addBox(-3.0F, -3.3F, -3.7F, 6, 7, 5, 0.0F);
        this.setRotation(neck, -0.19198621771937624F, -0.0F, 0.0F);
        this.tail5 = new ModelRenderer(this, 178, 66);
        this.tail5.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.tail5.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 11, 0.0F);
        this.setRotation(tail5, 0.091106186954104F, -0.0F, 0.0F);
        this.rHead = new ModelRenderer(this, 34, 0);
        this.rHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rHead.addBox(-2.51F, 4.1F, -6.7F, 3, 3, 5, 0.0F);
        this.setRotation(rHead, 0.5009094953223726F, -0.0F, 0.0F);
        this.lShoulderBlade = new ModelRenderer(this, 146, 34);
        this.lShoulderBlade.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lShoulderBlade.addBox(4.1F, -1.0F, -7.2F, 2, 3, 10, 0.0F);
        this.setRotation(lShoulderBlade, 1.4114477660878142F, -0.18203784098300857F, 0.136659280431156F);
        this.tail1 = new ModelRenderer(this, 50, 66);
        this.tail1.setRotationPoint(0.0F, 3.5F, 18.5F);
        this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 11, 0.0F);
        this.setRotation(tail1, -0.40142572795869574F, -0.0F, 0.0F);
        this.lShin2 = new ModelRenderer(this, 113, 40);
        this.lShin2.setRotationPoint(-1.3F, 1.5F, 10.4F);
        this.lShin2.addBox(0.0F, -0.2F, -1.1F, 2, 9, 2, 0.0F);
        this.setRotation(lShin2, 0.0F, 0.0F, 0.36425021489121656F);
        this.sack5 = new ModelRenderer(this, 177, 83);
        this.sack5.setRotationPoint(0.0F, 1.6F, 9.3F);
        this.sack5.addBox(-3.5F, -2.4F, -1.2F, 7, 8, 9, 0.0F);
        this.setRotation(sack5, -0.045553093477052F, 0.0F, 0.0F);
        this.tail5.addChild(this.tailSpines5);
        this.rClaw1.addChild(this.rClaw2);
        this.chest.addChild(this.lArm1);
        this.headBase.addChild(this.rHeadFin);
        this.rHorn3.addChild(this.rHorn4);
        this.tail5.addChild(this.tailStabber);
        this.sack2.addChild(this.sack3);
        this.lClaw1.addChild(this.lClaw2);
        this.lHorn3.addChild(this.lHorn4);
        this.lHorn1.addChild(this.lHorn2);
        this.tail3.addChild(this.tailSpines3);
        this.chest.addChild(this.rShoulderBlade);
        this.rWingArm2.addChild(this.rWingArm3);
        this.lWingArm1.addChild(this.lWingMembrane1);
        this.rWingArm3.addChild(this.rWingArm4);
        this.lWingArm1.addChild(this.lWingArm2);
        this.lWingArm4.addChild(this.lWingMembrane4);
        this.headBase.addChild(this.jawLower);
        this.chest.addChild(this.abdomen);
        this.lWingArm2.addChild(this.lWingArm3);
        this.headBase.addChild(this.innerJaw);
        this.tail1.addChild(this.tailSpines1);
        this.tail2.addChild(this.tail3);
        this.lShin2.addChild(this.lFoot);
        this.lWingArm3.addChild(this.lWingArm4);
        this.neck.addChild(this.neck1);
        this.lWingArm3.addChild(this.lWingMembrane3);
        this.headBase.addChild(this.jaw2);
        this.headBase.addChild(this.lHeadFin);
        this.headBase.addChild(this.lHead);
        this.rArm1.addChild(this.rArm2);
        this.tail1.addChild(this.tail2);
        this.rThigh.addChild(this.rShin1);
        this.chest.addChild(this.lThigh);
        this.rShin1.addChild(this.rShin2);
        this.headBase.addChild(this.headTop);
        this.chest.addChild(this.backSpines2);
        this.tail4.addChild(this.tailSpines4);
        this.sack1.addChild(this.sack2);
        this.rWingArm1.addChild(this.rWingMembrane1);
        this.rWingArm1.addChild(this.rWingArm2);
        this.rHorn1.addChild(this.rHorn2);
        this.rShin2.addChild(this.rFoot);
        this.lHorn2.addChild(this.lHorn3);
        this.rHorn2.addChild(this.rHorn3);
        this.chest.addChild(this.backSpines1);
        this.chest.addChild(this.rThigh);
        this.neck1.addChild(this.headBase);
        this.sack0.addChild(this.sack1);
        this.rWingArm2.addChild(this.rWingMembrane2);
        this.headBase.addChild(this.rHorn1);
        this.sack5.addChild(this.sack6);
        this.sack3.addChild(this.sack4);
        this.headBase.addChild(this.lHorn1);
        this.lArm1.addChild(this.lArm2);
        this.tail2.addChild(this.tailSpines2);
        this.sack6.addChild(this.sack7);
        this.lThigh.addChild(this.lShin1);
        this.rArm2.addChild(this.rClaw1);
        this.lArm2.addChild(this.lClaw1);
        this.tail3.addChild(this.tail4);
        this.chest.addChild(this.rArm1);
        this.lWingArm2.addChild(this.lWingMembrane2);
        this.rWingArm3.addChild(this.rWingMembrane3);
        this.rWingArm4.addChild(this.lWingMembrane4_1);
        this.chest.addChild(this.neck);
        this.tail4.addChild(this.tail5);
        this.headBase.addChild(this.rHead);
        this.chest.addChild(this.lShoulderBlade);
        this.chest.addChild(this.tail1);
        this.lShin1.addChild(this.lShin2);
        this.sack4.addChild(this.sack5);
    }

    @Override
    public void render(EntityDracomorph obj)
    {
        draw(sack0);
        OpenGL.pushMatrix();
        OpenGL.translate(this.rWingArm1.offsetX, this.rWingArm1.offsetY, this.rWingArm1.offsetZ);
        OpenGL.translate(this.rWingArm1.rotationPointX * DEFAULT_SCALE, this.rWingArm1.rotationPointY * DEFAULT_SCALE, this.rWingArm1.rotationPointZ * DEFAULT_SCALE);
        OpenGL.scale(1.5D, 1.5D, 1.5D);
        OpenGL.translate(-this.rWingArm1.offsetX, -this.rWingArm1.offsetY, -this.rWingArm1.offsetZ);
        OpenGL.translate(-this.rWingArm1.rotationPointX * DEFAULT_SCALE, -this.rWingArm1.rotationPointY * DEFAULT_SCALE, -this.rWingArm1.rotationPointZ * DEFAULT_SCALE);
        draw(rWingArm1);
        OpenGL.popMatrix();
        draw(chest);
        OpenGL.pushMatrix();
        OpenGL.translate(this.lWingArm1.offsetX, this.lWingArm1.offsetY, this.lWingArm1.offsetZ);
        OpenGL.translate(this.lWingArm1.rotationPointX * DEFAULT_SCALE, this.lWingArm1.rotationPointY * DEFAULT_SCALE, this.lWingArm1.rotationPointZ * DEFAULT_SCALE);
        OpenGL.scale(1.5D, 1.5D, 1.5D);
        OpenGL.translate(-this.lWingArm1.offsetX, -this.lWingArm1.offsetY, -this.lWingArm1.offsetZ);
        OpenGL.translate(-this.lWingArm1.rotationPointX * DEFAULT_SCALE, -this.lWingArm1.rotationPointY * DEFAULT_SCALE, -this.lWingArm1.rotationPointZ * DEFAULT_SCALE);
        draw(lWingArm1);
        OpenGL.popMatrix();
    }
}
