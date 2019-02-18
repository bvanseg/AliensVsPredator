package org.avp.client.model.entities.living;

import org.avp.entities.living.EntityAethon;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class ModelAethon extends Model
{
    public ModelRenderer chest;
    public ModelRenderer lArm;
    public ModelRenderer lWingArm;
    public ModelRenderer rArm;
    public ModelRenderer rWingArm;
    public ModelRenderer stomach;
    public ModelRenderer neck1;
    public ModelRenderer lCollar;
    public ModelRenderer rCollar;
    public ModelRenderer tail1;
    public ModelRenderer lThigh;
    public ModelRenderer rThigh;
    public ModelRenderer neck2;
    public ModelRenderer neck3;
    public ModelRenderer neck4;
    public ModelRenderer head1;
    public ModelRenderer beakUpper;
    public ModelRenderer headSlope;
    public ModelRenderer beakFang1;
    public ModelRenderer beakFang2;
    public ModelRenderer beakFang3;
    public ModelRenderer beakFang4;
    public ModelRenderer beakLower;
    public ModelRenderer beakFangLower1;
    public ModelRenderer beakFangLower2;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer tail4;
    public ModelRenderer tail5;
    public ModelRenderer lShin;
    public ModelRenderer lshin2;
    public ModelRenderer lFoot;
    public ModelRenderer lToe1;
    public ModelRenderer lToe2;
    public ModelRenderer lToe3;
    public ModelRenderer rShin;
    public ModelRenderer rshin2;
    public ModelRenderer rFoot;
    public ModelRenderer rToe1;
    public ModelRenderer rToe2;
    public ModelRenderer rToe3;
    public ModelRenderer lForearm;
    public ModelRenderer lHand;
    public ModelRenderer lFinger1;
    public ModelRenderer lFinger2;
    public ModelRenderer lFinger3;
    public ModelRenderer lFinger4;
    public ModelRenderer lThumb1;
    public ModelRenderer lThumb2;
    public ModelRenderer lWingArm2;
    public ModelRenderer lWingArm3;
    public ModelRenderer lWingMembrane1;
    public ModelRenderer lWingArm4;
    public ModelRenderer lWingMembrane2;
    public ModelRenderer lWingMembrane3;
    public ModelRenderer lWingArm5;
    public ModelRenderer lWingArm6;
    public ModelRenderer rForearm;
    public ModelRenderer rHand;
    public ModelRenderer rFinger1;
    public ModelRenderer rFinger2;
    public ModelRenderer rFinger3;
    public ModelRenderer rFinger4;
    public ModelRenderer rThumb1;
    public ModelRenderer rThumb2;
    public ModelRenderer rWingArm2;
    public ModelRenderer rWingArm3;
    public ModelRenderer rWingMembrane1;
    public ModelRenderer rWingArm4;
    public ModelRenderer rWingMembrane2;
    public ModelRenderer rWingMembrane3;
    public ModelRenderer rWingArm5;
    public ModelRenderer rWingArm6;

    public ModelAethon()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.rHand = new ModelRenderer(this, 89, 37);
        this.rHand.mirror = true;
        this.rHand.setRotationPoint(0.0F, 12.2F, -1.1F);
        this.rHand.addBox(-2.0F, -0.4F, -0.6F, 4, 5, 1, 0.0F);
        this.setRotation(rHand, 0.22759093446006054F, 0.0F, 0.0F);
        this.rThumb2 = new ModelRenderer(this, 106, 9);
        this.rThumb2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rThumb2.addBox(1.8F, 1.5F, -1.8F, 0, 5, 2, 0.0F);
        this.setRotation(rThumb2, 0.31869712141416456F, 0.0F, -0.136659280431156F);
        this.lWingArm2 = new ModelRenderer(this, 34, 85);
        this.lWingArm2.setRotationPoint(1.4F, -2.7F, -9.3F);
        this.lWingArm2.addBox(-1.0F, -1.5F, 0.0F, 2, 4, 16, 0.0F);
        this.setRotation(lWingArm2, 0.40980330836826856F, 0.1795943800302165F, -0.22444934180647075F);
        this.beakFang2 = new ModelRenderer(this, 31, 45);
        this.beakFang2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beakFang2.addBox(1.5F, -5.1F, -13.2F, 0, 2, 4, 0.0F);
        this.setRotation(beakFang2, 0.4038691889114879F, 0.08970992355250852F, 0.0F);
        this.rFinger1 = new ModelRenderer(this, 106, 0);
        this.rFinger1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFinger1.addBox(-1.4F, 3.2F, -2.8F, 0, 6, 3, 0.0F);
        this.setRotation(rFinger1, 0.31869712141416456F, 0.0F, 0.0F);
        this.rFinger2 = new ModelRenderer(this, 106, 0);
        this.rFinger2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFinger2.addBox(-0.5F, 3.6F, -3.3F, 0, 6, 3, 0.0F);
        this.setRotation(rFinger2, 0.31869712141416456F, 0.0F, 0.0F);
        this.beakFang4 = new ModelRenderer(this, 31, 41);
        this.beakFang4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beakFang4.addBox(-2.8F, -4.9F, -12.2F, 0, 2, 3, 0.0F);
        this.setRotation(beakFang4, 0.4038691889114879F, -0.13456488532876282F, 0.0F);
        this.rWingArm3 = new ModelRenderer(this, 74, 87);
        this.rWingArm3.mirror = true;
        this.rWingArm3.setRotationPoint(0.0F, 0.2F, 15.6F);
        this.rWingArm3.addBox(-1.0F, -1.5F, 0.0F, 2, 4, 13, 0.0F);
        this.setRotation(rWingArm3, -0.27314402793711257F, 0.0F, 0.0F);
        this.lWingArm3 = new ModelRenderer(this, 74, 87);
        this.lWingArm3.setRotationPoint(0.0F, 0.2F, 15.6F);
        this.lWingArm3.addBox(-1.0F, -1.5F, 0.0F, 2, 4, 13, 0.0F);
        this.setRotation(lWingArm3, -0.27314402793711257F, 0.0F, 0.0F);
        this.rCollar = new ModelRenderer(this, 0, 45);
        this.rCollar.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rCollar.addBox(-6.1F, -3.5F, -3.6F, 2, 5, 9, 0.0F);
        this.setRotation(rCollar, 0.31869712141416456F, 0.0F, -0.4553564018453205F);
        this.rWingArm6 = new ModelRenderer(this, 114, 94);
        this.rWingArm6.setRotationPoint(0.0F, 0.0F, 5.4F);
        this.rWingArm6.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 7, 0.0F);
        this.beakFangLower2 = new ModelRenderer(this, 31, 51);
        this.beakFangLower2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beakFangLower2.addBox(-0.8F, -0.3F, -6.7F, 0, 2, 4, 0.0F);
        this.setRotation(beakFangLower2, 0.0F, -0.08970992355250852F, 0.0F);
        this.lHand = new ModelRenderer(this, 89, 37);
        this.lHand.setRotationPoint(0.0F, 12.2F, -1.1F);
        this.lHand.addBox(-2.0F, -0.4F, -0.6F, 4, 5, 1, 0.0F);
        this.setRotation(lHand, 0.22759093446006054F, 0.0F, 0.0F);
        this.rThigh = new ModelRenderer(this, 116, 0);
        this.rThigh.mirror = true;
        this.rThigh.setRotationPoint(-1.9F, 19.6F, 0.5F);
        this.rThigh.addBox(-3.3F, -0.5F, -3.3F, 5, 14, 6, 0.0F);
        this.setRotation(rThigh, -0.7740535232594852F, 0.0F, 0.136659280431156F);
        this.rFinger4 = new ModelRenderer(this, 106, 0);
        this.rFinger4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFinger4.addBox(1.5F, 3.2F, -2.8F, 0, 6, 3, 0.0F);
        this.setRotation(rFinger4, 0.31869712141416456F, 0.0F, 0.0F);
        this.rToe3 = new ModelRenderer(this, 102, 16);
        this.rToe3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rToe3.addBox(0.0F, 0.0F, -10.5F, 0, 2, 5, 0.0F);
        this.setRotation(rToe3, 0.045553093477052F, -0.18203784098300857F, 0.0F);
        this.lWingMembrane2 = new ModelRenderer(this, 206, 23);
        this.lWingMembrane2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane2.addBox(0.0F, 0.9F, 0.0F, 0, 14, 15, 0.0F);
        this.lshin2 = new ModelRenderer(this, 122, 40);
        this.lshin2.setRotationPoint(1.0F, 2.9F, 3.5F);
        this.lshin2.addBox(-1.0F, -0.4F, -1.3F, 3, 11, 3, 0.0F);
        this.setRotation(lshin2, -0.18203784098300857F, 0.0F, 0.0F);
        this.rFinger3 = new ModelRenderer(this, 106, 0);
        this.rFinger3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFinger3.addBox(0.6F, 3.6F, -3.2F, 0, 6, 3, 0.0F);
        this.setRotation(rFinger3, 0.31869712141416456F, 0.0F, 0.0F);
        this.lForearm = new ModelRenderer(this, 89, 19);
        this.lForearm.setRotationPoint(0.8F, 12.4F, 0.0F);
        this.lForearm.addBox(-1.0F, -1.7F, -1.7F, 2, 14, 3, 0.0F);
        this.setRotation(lForearm, -0.8196066167365371F, 0.0F, 0.0F);
        this.rWingArm = new ModelRenderer(this, 0, 87);
        this.rWingArm.mirror = true;
        this.rWingArm.setRotationPoint(-3.5F, -21.3F, 5.7F);
        this.rWingArm.addBox(-2.9F, -4.3F, -10.5F, 3, 5, 13, 0.0F);
        this.setRotation(rWingArm, -0.7285004297824331F, 0.0F, -0.40980330836826856F);
        this.stomach = new ModelRenderer(this, 0, 23);
        this.stomach.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stomach.addBox(-4.5F, 9.7F, 0.0F, 9, 11, 8, 0.0F);
        this.setRotation(stomach, -0.22759093446006054F, 0.0F, 0.0F);
        this.neck2 = new ModelRenderer(this, 47, 19);
        this.neck2.setRotationPoint(0.0F, -7.5F, 0.8F);
        this.neck2.addBox(-4.0F, -7.6F, -2.9F, 8, 9, 6, 0.0F);
        this.setRotation(neck2, 0.5009094953223726F, 0.0F, 0.0F);
        this.head1 = new ModelRenderer(this, 0, 65);
        this.head1.setRotationPoint(0.0F, -3.5F, 0.4F);
        this.head1.addBox(-3.5F, -2.5F, -7.0F, 7, 5, 7, 0.0F);
        this.setRotation(head1, -1.3658946726107624F, 0.0F, 0.0F);
        this.lShin = new ModelRenderer(this, 116, 24);
        this.lShin.setRotationPoint(0.0F, 11.8F, 0.0F);
        this.lShin.addBox(-0.7F, 0.1F, -3.6F, 4, 3, 9, 0.0F);
        this.setRotation(lShin, 0.40980330836826856F, 0.0F, 0.0F);
        this.lToe2 = new ModelRenderer(this, 102, 16);
        this.lToe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lToe2.addBox(0.7F, 0.0F, -10.8F, 0, 2, 5, 0.0F);
        this.setRotation(lToe2, 0.045553093477052F, 0.0F, 0.0F);
        this.rWingArm5 = new ModelRenderer(this, 115, 95);
        this.rWingArm5.setRotationPoint(0.0F, -0.2F, 13.6F);
        this.rWingArm5.addBox(-0.5F, -0.9F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotation(rWingArm5, -0.22759093446006054F, 0.0F, 0.0F);
        this.lFinger4 = new ModelRenderer(this, 106, 0);
        this.lFinger4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFinger4.addBox(-1.5F, 3.2F, -2.8F, 0, 6, 3, 0.0F);
        this.setRotation(lFinger4, 0.31869712141416456F, 0.0F, 0.0F);
        this.tail5 = new ModelRenderer(this, 160, 78);
        this.tail5.setRotationPoint(0.0F, 0.0F, 6.8F);
        this.tail5.addBox(-3.0F, -2.8F, 0.0F, 6, 5, 7, 0.0F);
        this.setRotation(tail5, 0.22444934180647075F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 160, 0);
        this.tail1.setRotationPoint(0.0F, 19.8F, 1.3F);
        this.tail1.addBox(-3.0F, -2.5F, 0.0F, 6, 6, 12, 0.0F);
        this.setRotation(tail1, -1.2566370614359172F, 0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 160, 40);
        this.tail3.setRotationPoint(0.0F, 0.0F, 11.4F);
        this.tail3.addBox(-2.5F, -1.7F, 0.0F, 5, 4, 9, 0.0F);
        this.setRotation(tail3, 0.22444934180647075F, 0.0F, 0.0F);
        this.rArm = new ModelRenderer(this, 89, 0);
        this.rArm.mirror = true;
        this.rArm.setRotationPoint(-4.1F, -18.0F, 2.0F);
        this.rArm.addBox(-1.9F, -0.3F, -2.0F, 3, 13, 4, 0.0F);
        this.setRotation(rArm, 0.5009094953223726F, 0.0F, 0.22759093446006054F);
        this.lFinger3 = new ModelRenderer(this, 106, 0);
        this.lFinger3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFinger3.addBox(-0.6F, 3.6F, -3.2F, 0, 6, 3, 0.0F);
        this.setRotation(lFinger3, 0.31869712141416456F, 0.0F, 0.0F);
        this.lWingMembrane3 = new ModelRenderer(this, 206, 40);
        this.lWingMembrane3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane3.addBox(0.0F, 1.1F, 3.0F, 0, 11, 16, 0.0F);
        this.lWingMembrane1 = new ModelRenderer(this, 206, 0);
        this.lWingMembrane1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWingMembrane1.addBox(0.0F, -0.4F, -0.9F, 0, 14, 18, 0.0F);
        this.setRotation(lWingMembrane1, -0.136659280431156F, 0.0F, 0.0F);
        this.rThumb1 = new ModelRenderer(this, 106, 9);
        this.rThumb1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rThumb1.addBox(-1.8F, 1.5F, -1.8F, 0, 5, 2, 0.0F);
        this.setRotation(rThumb1, 0.31869712141416456F, 0.0F, 0.136659280431156F);
        this.lThumb1 = new ModelRenderer(this, 106, 9);
        this.lThumb1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lThumb1.addBox(1.8F, 1.5F, -1.8F, 0, 5, 2, 0.0F);
        this.setRotation(lThumb1, 0.31869712141416456F, 0.0F, -0.136659280431156F);
        this.rShin = new ModelRenderer(this, 116, 24);
        this.rShin.mirror = true;
        this.rShin.setRotationPoint(0.0F, 11.8F, 0.0F);
        this.rShin.addBox(-2.7F, 0.1F, -3.6F, 4, 3, 9, 0.0F);
        this.setRotation(rShin, 0.40980330836826856F, 0.0F, 0.0F);
        this.rWingMembrane2 = new ModelRenderer(this, 206, 23);
        this.rWingMembrane2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWingMembrane2.addBox(0.0F, 0.9F, 0.0F, 0, 14, 15, 0.0F);
        this.lFinger2 = new ModelRenderer(this, 106, 0);
        this.lFinger2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFinger2.addBox(0.5F, 3.6F, -3.3F, 0, 6, 3, 0.0F);
        this.setRotation(lFinger2, 0.31869712141416456F, 0.0F, 0.0F);
        this.lWingArm5 = new ModelRenderer(this, 115, 95);
        this.lWingArm5.setRotationPoint(0.0F, -0.2F, 13.6F);
        this.lWingArm5.addBox(-0.5F, -0.9F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotation(lWingArm5, -0.22759093446006054F, 0.0F, 0.0F);
        this.lWingArm = new ModelRenderer(this, 0, 87);
        this.lWingArm.setRotationPoint(3.5F, -21.3F, 5.7F);
        this.lWingArm.addBox(0.0F, -4.3F, -10.5F, 3, 5, 13, 0.0F);
        this.setRotation(lWingArm, -0.7285004297824331F, 0.0F, 0.40980330836826856F);
        this.rWingMembrane3 = new ModelRenderer(this, 206, 40);
        this.rWingMembrane3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWingMembrane3.addBox(0.0F, 1.1F, 3.0F, 0, 11, 16, 0.0F);
        this.lWingArm4 = new ModelRenderer(this, 107, 87);
        this.lWingArm4.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.lWingArm4.addBox(-0.5F, -1.5F, 0.0F, 1, 3, 14, 0.0F);
        this.setRotation(lWingArm4, -0.22444934180647075F, 0.0F, 0.0F);
        this.rshin2 = new ModelRenderer(this, 122, 40);
        this.rshin2.mirror = true;
        this.rshin2.setRotationPoint(0.0F, 2.9F, 3.5F);
        this.rshin2.addBox(-2.2F, -0.4F, -1.3F, 3, 11, 3, 0.0F);
        this.setRotation(rshin2, -0.18203784098300857F, 0.0F, 0.0F);
        this.neck3 = new ModelRenderer(this, 47, 38);
        this.neck3.setRotationPoint(0.0F, -5.5F, 0.6F);
        this.neck3.addBox(-3.5F, -7.3F, -2.5F, 7, 6, 5, 0.0F);
        this.setRotation(neck3, 0.27314402793711257F, 0.0F, 0.0F);
        this.beakFang1 = new ModelRenderer(this, 31, 41);
        this.beakFang1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beakFang1.addBox(2.8F, -4.9F, -12.2F, 0, 2, 3, 0.0F);
        this.setRotation(beakFang1, 0.4038691889114879F, 0.13456488532876282F, 0.0F);
        this.lToe3 = new ModelRenderer(this, 102, 16);
        this.lToe3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lToe3.addBox(0.0F, 0.0F, -10.5F, 0, 2, 5, 0.0F);
        this.setRotation(lToe3, 0.045553093477052F, 0.18203784098300857F, 0.0F);
        this.lToe1 = new ModelRenderer(this, 102, 16);
        this.lToe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lToe1.addBox(1.4F, 0.0F, -10.5F, 0, 2, 5, 0.0F);
        this.setRotation(lToe1, 0.045553093477052F, -0.18203784098300857F, 0.0F);
        this.headSlope = new ModelRenderer(this, 32, 75);
        this.headSlope.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headSlope.addBox(-2.5F, -5.3F, -9.4F, 5, 2, 4, 0.0F);
        this.setRotation(headSlope, 0.44872415068774213F, 0.0F, 0.0F);
        this.beakFangLower1 = new ModelRenderer(this, 31, 51);
        this.beakFangLower1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beakFangLower1.addBox(0.7F, -0.3F, -6.7F, 0, 2, 4, 0.0F);
        this.setRotation(beakFangLower1, 0.0F, 0.08970992355250852F, 0.0F);
        this.rWingArm4 = new ModelRenderer(this, 107, 87);
        this.rWingArm4.mirror = true;
        this.rWingArm4.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.rWingArm4.addBox(-0.5F, -1.5F, 0.0F, 1, 3, 14, 0.0F);
        this.setRotation(rWingArm4, -0.22444934180647075F, 0.0F, 0.0F);
        this.lFoot = new ModelRenderer(this, 116, 63);
        this.lFoot.setRotationPoint(0.0F, 9.6F, 0.0F);
        this.lFoot.addBox(-1.4F, 0.5F, -5.8F, 4, 2, 7, 0.0F);
        this.setRotation(lFoot, 0.091106186954104F, -0.136659280431156F, 0.136659280431156F);
        this.neck1 = new ModelRenderer(this, 47, 0);
        this.neck1.setRotationPoint(0.0F, 0.8F, 1.5F);
        this.neck1.addBox(-4.5F, -7.8F, -2.8F, 9, 10, 7, 0.0F);
        this.setRotation(neck1, 0.6373942428283291F, 0.0F, 0.0F);
        this.beakFang3 = new ModelRenderer(this, 31, 45);
        this.beakFang3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beakFang3.addBox(-1.5F, -5.1F, -13.2F, 0, 2, 4, 0.0F);
        this.setRotation(beakFang3, 0.4038691889114879F, -0.08970992355250852F, 0.0F);
        this.rWingMembrane1 = new ModelRenderer(this, 206, 0);
        this.rWingMembrane1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWingMembrane1.addBox(0.0F, 0.0F, 0.0F, 0, 14, 18, 0.0F);
        this.setRotation(rWingMembrane1, -0.136659280431156F, 0.0F, 0.0F);
        this.tail4 = new ModelRenderer(this, 160, 60);
        this.tail4.setRotationPoint(0.0F, 0.0F, 9.2F);
        this.tail4.addBox(-2.5F, -1.9F, -0.6F, 5, 4, 8, 0.0F);
        this.setRotation(tail4, 0.22444934180647075F, 0.0F, 0.0F);
        this.lArm = new ModelRenderer(this, 89, 0);
        this.lArm.setRotationPoint(4.1F, -18.0F, 2.0F);
        this.lArm.addBox(-0.9F, -0.3F, -2.0F, 3, 13, 4, 0.0F);
        this.setRotation(lArm, 0.5009094953223726F, 0.0F, -0.22759093446006054F);
        this.rToe2 = new ModelRenderer(this, 102, 16);
        this.rToe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rToe2.addBox(-0.7F, 0.0F, -10.8F, 0, 2, 5, 0.0F);
        this.setRotation(rToe2, 0.045553093477052F, 0.0F, 0.0F);
        this.rWingArm2 = new ModelRenderer(this, 34, 85);
        this.rWingArm2.mirror = true;
        this.rWingArm2.setRotationPoint(-1.4F, -2.7F, -9.3F);
        this.rWingArm2.addBox(-1.0F, -1.5F, 0.0F, 2, 4, 16, 0.0F);
        this.setRotation(rWingArm2, 0.40980330836826856F, -0.1795943800302165F, 0.22444934180647075F);
        this.rForearm = new ModelRenderer(this, 89, 19);
        this.rForearm.mirror = true;
        this.rForearm.setRotationPoint(0.0F, 12.4F, 0.0F);
        this.rForearm.addBox(-1.0F, -1.7F, -1.7F, 2, 14, 3, 0.0F);
        this.setRotation(rForearm, -0.8196066167365371F, 0.0F, 0.0F);
        this.lThigh = new ModelRenderer(this, 116, 0);
        this.lThigh.setRotationPoint(1.7F, 19.6F, 0.5F);
        this.lThigh.addBox(-1.3F, -0.5F, -3.3F, 5, 14, 6, 0.0F);
        this.setRotation(lThigh, -0.7740535232594852F, 0.0F, -0.136659280431156F);
        this.lCollar = new ModelRenderer(this, 0, 45);
        this.lCollar.mirror = true;
        this.lCollar.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lCollar.addBox(4.1F, -3.5F, -3.6F, 2, 5, 9, 0.0F);
        this.setRotation(lCollar, 0.31869712141416456F, 0.0F, 0.4553564018453205F);
        this.lFinger1 = new ModelRenderer(this, 106, 0);
        this.lFinger1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFinger1.addBox(1.4F, 3.2F, -2.8F, 0, 6, 3, 0.0F);
        this.setRotation(lFinger1, 0.31869712141416456F, 0.0F, 0.0F);
        this.chest = new ModelRenderer(this, 0, 0);
        this.chest.setRotationPoint(0.0F, -19.0F, 0.0F);
        this.chest.addBox(-5.5F, 0.0F, -3.6F, 11, 11, 10, 0.0F);
        this.setRotation(chest, 0.4553564018453205F, 0.0F, 0.0F);
        this.beakLower = new ModelRenderer(this, 51, 63);
        this.beakLower.setRotationPoint(0.0F, 1.2F, -6.5F);
        this.beakLower.addBox(-1.5F, 0.0F, -3.5F, 3, 1, 3, 0.0F);
        this.setRotation(beakLower, 0.22444934180647075F, 0.0F, 0.0F);
        this.beakUpper = new ModelRenderer(this, 32, 63);
        this.beakUpper.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beakUpper.addBox(-2.0F, -2.3F, -10.6F, 4, 2, 4, 0.0F);
        this.setRotation(beakUpper, 0.22444934180647075F, 0.0F, 0.0F);
        this.lThumb2 = new ModelRenderer(this, 106, 9);
        this.lThumb2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lThumb2.addBox(-1.8F, 1.5F, -1.8F, 0, 5, 2, 0.0F);
        this.setRotation(lThumb2, 0.31869712141416456F, 0.0F, 0.136659280431156F);
        this.lWingArm6 = new ModelRenderer(this, 114, 94);
        this.lWingArm6.setRotationPoint(0.0F, 0.0F, 5.4F);
        this.lWingArm6.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 7, 0.0F);
        this.rFoot = new ModelRenderer(this, 116, 63);
        this.rFoot.mirror = true;
        this.rFoot.setRotationPoint(0.0F, 9.6F, 0.0F);
        this.rFoot.addBox(-2.8F, 0.5F, -5.8F, 4, 2, 7, 0.0F);
        this.setRotation(rFoot, 0.091106186954104F, 0.136659280431156F, -0.091106186954104F);
        this.tail2 = new ModelRenderer(this, 160, 20);
        this.tail2.setRotationPoint(0.0F, 0.3F, 10.6F);
        this.tail2.addBox(-3.0F, -2.2F, 0.0F, 6, 5, 12, 0.0F);
        this.setRotation(tail2, 0.22444934180647075F, 0.0F, 0.0F);
        this.rToe1 = new ModelRenderer(this, 102, 16);
        this.rToe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rToe1.addBox(-1.4F, 0.0F, -10.5F, 0, 2, 5, 0.0F);
        this.setRotation(rToe1, 0.045553093477052F, 0.18203784098300857F, 0.0F);
        this.neck4 = new ModelRenderer(this, 47, 52);
        this.neck4.setRotationPoint(0.0F, -6.4F, 0.0F);
        this.neck4.addBox(-3.0F, -4.2F, -1.6F, 6, 4, 4, 0.0F);
        this.setRotation(neck4, 0.27314402793711257F, 0.0F, 0.0F);
        this.rForearm.addChild(this.rHand);
        this.rHand.addChild(this.rThumb2);
        this.lWingArm.addChild(this.lWingArm2);
        this.head1.addChild(this.beakFang2);
        this.rHand.addChild(this.rFinger1);
        this.rHand.addChild(this.rFinger2);
        this.head1.addChild(this.beakFang4);
        this.rWingArm2.addChild(this.rWingArm3);
        this.lWingArm2.addChild(this.lWingArm3);
        this.chest.addChild(this.rCollar);
        this.rWingArm5.addChild(this.rWingArm6);
        this.beakLower.addChild(this.beakFangLower2);
        this.lForearm.addChild(this.lHand);
        this.chest.addChild(this.rThigh);
        this.rHand.addChild(this.rFinger4);
        this.rFoot.addChild(this.rToe3);
        this.lWingArm3.addChild(this.lWingMembrane2);
        this.lShin.addChild(this.lshin2);
        this.rHand.addChild(this.rFinger3);
        this.lArm.addChild(this.lForearm);
        this.chest.addChild(this.stomach);
        this.neck1.addChild(this.neck2);
        this.neck4.addChild(this.head1);
        this.lThigh.addChild(this.lShin);
        this.lFoot.addChild(this.lToe2);
        this.rWingArm4.addChild(this.rWingArm5);
        this.lHand.addChild(this.lFinger4);
        this.tail4.addChild(this.tail5);
        this.chest.addChild(this.tail1);
        this.tail2.addChild(this.tail3);
        this.lHand.addChild(this.lFinger3);
        this.lWingArm4.addChild(this.lWingMembrane3);
        this.lWingArm2.addChild(this.lWingMembrane1);
        this.rHand.addChild(this.rThumb1);
        this.lHand.addChild(this.lThumb1);
        this.rThigh.addChild(this.rShin);
        this.rWingArm3.addChild(this.rWingMembrane2);
        this.lHand.addChild(this.lFinger2);
        this.lWingArm4.addChild(this.lWingArm5);
        this.rWingArm4.addChild(this.rWingMembrane3);
        this.lWingArm3.addChild(this.lWingArm4);
        this.rShin.addChild(this.rshin2);
        this.neck2.addChild(this.neck3);
        this.head1.addChild(this.beakFang1);
        this.lFoot.addChild(this.lToe3);
        this.lFoot.addChild(this.lToe1);
        this.head1.addChild(this.headSlope);
        this.beakLower.addChild(this.beakFangLower1);
        this.rWingArm3.addChild(this.rWingArm4);
        this.lshin2.addChild(this.lFoot);
        this.chest.addChild(this.neck1);
        this.head1.addChild(this.beakFang3);
        this.rWingArm2.addChild(this.rWingMembrane1);
        this.tail3.addChild(this.tail4);
        this.rFoot.addChild(this.rToe2);
        this.rWingArm.addChild(this.rWingArm2);
        this.rArm.addChild(this.rForearm);
        this.chest.addChild(this.lThigh);
        this.chest.addChild(this.lCollar);
        this.lHand.addChild(this.lFinger1);
        this.head1.addChild(this.beakLower);
        this.head1.addChild(this.beakUpper);
        this.lHand.addChild(this.lThumb2);
        this.lWingArm5.addChild(this.lWingArm6);
        this.rshin2.addChild(this.rFoot);
        this.tail1.addChild(this.tail2);
        this.rFoot.addChild(this.rToe1);
        this.neck3.addChild(this.neck4);
    }

    @Override
    public void render(Object o)
    {
        if (o != null && o instanceof EntityAethon)
        {
            EntityAethon aethon = (EntityAethon) o;

            boolean isFlying = aethon.isFlying();
            float swingProgress = swingProgress(aethon);
            float swingProgressPrev = swingProgressPrev(aethon);
            float wingDistMulti = 5F;
            float wingSpeed = isFlying ? 1.75F : 20F;
            float neckSpeed = isFlying ? 8F : 18F;
            float tailSpeed = isFlying ? 4F : 18F;
            long ticks = aethon.ticksExisted;

            if (isFlying)
            {
                this.rThigh.rotateAngleX = (float) Math.toRadians(-44F);
                this.lThigh.rotateAngleX = (float) Math.toRadians(-44F);
                this.rArm.rotateAngleX = (float) Math.toRadians(-18F);
                this.lArm.rotateAngleX = (float) Math.toRadians(-18F);
                
                this.neck1.rotateAngleX = (float) Math.toRadians((Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));
                this.neck2.rotateAngleX = (float) Math.toRadians((Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));
                this.neck3.rotateAngleX = (float) Math.toRadians((Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));
                this.neck4.rotateAngleX = (float) Math.toRadians((Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));

                this.tail1.rotateAngleX = (float) Math.toRadians(-82F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail2.rotateAngleX = (float) Math.toRadians(-12F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail3.rotateAngleX = (float) Math.toRadians(0F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail4.rotateAngleX = (float) Math.toRadians(0F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail5.rotateAngleX = (float) Math.toRadians(0F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));

                this.lWingArm.rotateAngleY = (float) Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 3F) * wingDistMulti));
                this.lWingArm.rotateAngleZ = (float) Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 2F) * wingDistMulti));
                this.lWingArm.rotateAngleZ = (float) Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 10F) * wingDistMulti));
                this.lWingArm2.rotateAngleX = (float) Math.toRadians((100F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 6F) * wingDistMulti));
                this.lWingArm2.rotateAngleY = (float) -Math.toRadians((30F + (Math.cos((ticks + Game.partialTicks()) / (wingSpeed)) * 4F) * wingDistMulti));
                this.lWingArm2.rotateAngleZ = (float) Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 4F) * wingDistMulti));

                this.rWingArm.rotateAngleY = (float) -Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 3F) * wingDistMulti));
                this.rWingArm.rotateAngleZ = (float) -Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 2F) * wingDistMulti));
                this.rWingArm.rotateAngleZ = (float) -Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 10F) * wingDistMulti));
                this.rWingArm2.rotateAngleX = (float) Math.toRadians((100F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 6F) * wingDistMulti));
                this.rWingArm2.rotateAngleY = (float) Math.toRadians((30F + (Math.cos((ticks + Game.partialTicks()) / (wingSpeed)) * 4F) * wingDistMulti));
                this.rWingArm2.rotateAngleZ = (float) -Math.toRadians((40F + (Math.sin((ticks + Game.partialTicks()) / (wingSpeed)) * 4F) * wingDistMulti));
            }
            else
            {
                this.rThigh.rotateAngleX = (float) (Math.toRadians(-44F) + MathHelper.cos(swingProgress * 0.3662F) * 0.9F * swingProgressPrev);
                this.lThigh.rotateAngleX = (float) (Math.toRadians(-44F) + MathHelper.sin(swingProgress * 0.3662F) * 0.9F * swingProgressPrev);
                this.rArm.rotateAngleX = (float) (Math.toRadians(-18F) + MathHelper.cos(swingProgress * 0.3662F) * 0.6F * swingProgressPrev + 0.6665191F);
                this.lArm.rotateAngleX = (float) (Math.toRadians(-18F) + MathHelper.sin(swingProgress * 0.3662F) * 0.6F * swingProgressPrev + 0.6665191F);
                
                this.neck1.rotateAngleX = (float) Math.toRadians((Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));
                this.neck2.rotateAngleX = (float) Math.toRadians(16F + (Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));
                this.neck3.rotateAngleX = (float) Math.toRadians(16F + (Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));
                this.neck4.rotateAngleX = (float) Math.toRadians(19F + (Math.sin((ticks + Game.partialTicks()) / (neckSpeed)) * 3F));

                this.tail1.rotateAngleX = (float) Math.toRadians(-72F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail2.rotateAngleX = (float) Math.toRadians(16F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail3.rotateAngleX = (float) Math.toRadians(16F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail4.rotateAngleX = (float) Math.toRadians(19F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));
                this.tail5.rotateAngleX = (float) Math.toRadians(19F + (Math.sin((ticks + Game.partialTicks()) / (tailSpeed)) * 3F));

                this.lWingArm.rotateAngleX = (float) Math.toRadians(-41.74F);
                this.lWingArm.rotateAngleY = (float) Math.toRadians(0F);
                this.lWingArm.rotateAngleZ = (float) Math.toRadians(23.48F);
                this.lWingArm2.rotateAngleX = (float) Math.toRadians(23.48F);
                this.lWingArm2.rotateAngleY = (float) Math.toRadians(10.29F);
                this.lWingArm2.rotateAngleZ = (float) Math.toRadians(-12.86F);

                this.rWingArm.rotateAngleX = (float) Math.toRadians(-41.74F);
                this.rWingArm.rotateAngleY = (float) Math.toRadians(0F);
                this.rWingArm.rotateAngleZ = (float) Math.toRadians(-23.48F);
                this.rWingArm2.rotateAngleX = (float) Math.toRadians(23.48F);
                this.rWingArm2.rotateAngleY = (float) Math.toRadians(-10.29F);
                this.rWingArm2.rotateAngleZ = (float) Math.toRadians(12.86F);
            }

            OpenGL.pushMatrix();
            {
                if (isFlying)
                {
                    OpenGL.rotate(75F, 1, 0, 0);
                }

                draw(this.rWingArm);
                draw(this.rArm);
                draw(this.lWingArm);
                draw(this.lArm);
                draw(this.chest);
            }
            OpenGL.popMatrix();
        }
        else
        {
            draw(this.rWingArm);
            draw(this.rArm);
            draw(this.lWingArm);
            draw(this.lArm);
            draw(this.chest);
        }
    }
}
