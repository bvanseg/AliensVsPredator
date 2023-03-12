package org.alien.client.model.entity.living;

import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.avp.client.render.XenomorphJawState;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.entity.living.xenomorphs.EntityUltramorph;


public class ModelUltramorph extends Model<EntityUltramorph>
{
    public ModelRenderer rArmUpper;
    public ModelRenderer chest;
    public ModelRenderer lThigh;
    public ModelRenderer lArmUpper;
    public ModelRenderer tail1;
    public ModelRenderer rThigh;
    public ModelRenderer rArmLower;
    public ModelRenderer rHand;
    public ModelRenderer rClaws;
    public ModelRenderer stomach;
    public ModelRenderer backSpine;
    public ModelRenderer lDorsalPipe1;
    public ModelRenderer rDorsalPipe1;
    public ModelRenderer lDorsalPipe2;
    public ModelRenderer rDorsalPipe2;
    public ModelRenderer dorsalSpike;
    public ModelRenderer rShoulderRidge;
    public ModelRenderer lShoulderRidge;
    public ModelRenderer neck;
    public ModelRenderer head1;
    public ModelRenderer lBackBlade1;
    public ModelRenderer lBackBlade2;
    public ModelRenderer rBackBlade1;
    public ModelRenderer rBackBlade2;
    public ModelRenderer head5;
    public ModelRenderer head6;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer head4;
    public ModelRenderer jawLower;
    public ModelRenderer innerJaw;
    public ModelRenderer lShin;
    public ModelRenderer lLowerLeg;
    public ModelRenderer lFoot;
    public ModelRenderer lArmLower;
    public ModelRenderer lHand;
    public ModelRenderer lClaws;
    public ModelRenderer tailSpines1;
    public ModelRenderer tail2;
    public ModelRenderer tailSpines2;
    public ModelRenderer tail3;
    public ModelRenderer tailSpines3;
    public ModelRenderer tail4;
    public ModelRenderer tailSpines4;
    public ModelRenderer tail5;
    public ModelRenderer tailSpines5;
    public ModelRenderer stabber;
    public ModelRenderer rShin;
    public ModelRenderer rLowerLeg;
    public ModelRenderer rFoot;

    public ModelUltramorph()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.tailSpines3 = new ModelRenderer(this, 117, 94);
        this.tailSpines3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines3.addBox(0.0F, -2.5F, 0.0F, 0, 6, 10, 0.0F);
        this.head1 = new ModelRenderer(this, 0, 0);
        this.head1.setRotationPoint(0.0F, 2.3F, -5.4F);
        this.head1.addBox(-2.5F, -5.0F, -2.9F, 5, 10, 5, 0.0F);
        this.lDorsalPipe1 = new ModelRenderer(this, 0, 86);
        this.lDorsalPipe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lDorsalPipe1.addBox(1.1F, -11.0F, 7.0F, 2, 9, 2, 0.0F);
        this.setRotation(lDorsalPipe1, 0.0F, 0.0F, 0.06981317007977318F);
        this.lBackBlade2 = new ModelRenderer(this, 155, 0);
        this.lBackBlade2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBackBlade2.addBox(4.0F, -8.5F, -4.2F, 0, 6, 16, 0.0F);
        this.setRotation(lBackBlade2, -0.15707963267948966F, -0.05235987755982988F, 0.0F);
        this.tail2 = new ModelRenderer(this, 85, 66);
        this.tail2.setRotationPoint(0.0F, -1.0F, 10.36F);
        this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 11, 0.0F);
        this.setRotation(tail2, 0.08726646259971647F, 0.0F, 0.0F);
        this.rBackBlade1 = new ModelRenderer(this, 190, 0);
        this.rBackBlade1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBackBlade1.addBox(-6.0F, -7.0F, -2.8F, 0, 6, 16, 0.0F);
        this.setRotation(rBackBlade1, -0.15707963267948966F, 0.20943951023931953F, 0.0F);
        this.rBackBlade2 = new ModelRenderer(this, 190, 0);
        this.rBackBlade2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBackBlade2.addBox(-4.0F, -8.5F, -4.2F, 0, 6, 16, 0.0F);
        this.setRotation(rBackBlade2, -0.15707963267948966F, 0.05235987755982988F, 0.0F);
        this.stabber = new ModelRenderer(this, 205, 66);
        this.stabber.setRotationPoint(0.0F, 0.0F, 9.6F);
        this.stabber.addBox(0.0F, -1.4F, 0.0F, 0, 3, 11, 0.0F);
        this.head3 = new ModelRenderer(this, 51, 10);
        this.head3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head3.addBox(-2.5F, 2.8F, -5.0F, 5, 3, 4, 0.0F);
        this.setRotation(head3, 0.6283185307179586F, 0.0F, 0.0F);
        this.rHand = new ModelRenderer(this, 72, 24);
        this.rHand.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rHand.addBox(-1.0F, -0.7F, -13.5F, 2, 1, 3, 0.0F);
        this.lBackBlade1 = new ModelRenderer(this, 155, 0);
        this.lBackBlade1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBackBlade1.addBox(6.0F, -7.0F, -2.8F, 0, 6, 16, 0.0F);
        this.setRotation(lBackBlade1, -0.15707963267948966F, -0.20943951023931953F, 0.0F);
        this.backSpine = new ModelRenderer(this, 23, 65);
        this.backSpine.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.backSpine.addBox(0.0F, -11.0F, 8.0F, 0, 6, 12, 0.0F);
        this.setRotation(backSpine, -0.3665191429188092F, 0.0F, 0.0F);
        this.lArmLower = new ModelRenderer(this, 71, 9);
        this.lArmLower.setRotationPoint(0.0F, 11.5F, -0.2F);
        this.lArmLower.addBox(-1.0F, -0.7F, -10.5F, 2, 2, 11, 0.0F);
        this.setRotation(lArmLower, 0.6373942428283291F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 23, 86);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-2.0F, -1.4F, -4.4F, 4, 6, 5, 0.0F);
        this.setRotation(neck, 0.136659280431156F, 0.0F, 0.0F);
        this.lClaws = new ModelRenderer(this, 60, 30);
        this.lClaws.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lClaws.addBox(-1.6F, -0.3F, -16.5F, 3, 0, 6, 0.0F);
        this.head6 = new ModelRenderer(this, 53, 0);
        this.head6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head6.addBox(-0.5F, 3.0F, -5.0F, 3, 3, 5, 0.0F);
        this.setRotation(head6, 0.5061454830783556F, 0.0F, 0.0F);

        this.innerJaw = new ModelRenderer(this, 0, 18);
        this.innerJaw.setRotationPoint(0.0F, 4.3F, 2.2F);
        this.innerJaw.addBox(-1.0F, -0.7F, -4.6F, 2, 2, 5, 0.0F);
        this.setRotation(innerJaw, 0.7504915783575618F, 0.0F, 0.0F);

        this.lShoulderRidge = new ModelRenderer(this, 155, 25);
        this.lShoulderRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lShoulderRidge.addBox(3.5F, -2.8F, -2.3F, 2, 9, 5, 0.0F);
        this.setRotation(lShoulderRidge, 0.22759093446006054F, -0.18203784098300857F, 0.13962634015954636F);
        this.rDorsalPipe1 = new ModelRenderer(this, 9, 86);
        this.rDorsalPipe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rDorsalPipe1.addBox(-3.1F, -11.0F, 7.0F, 2, 9, 2, 0.0F);
        this.setRotation(rDorsalPipe1, 0.0F, 0.0F, -0.06981317007977318F);
        this.head5 = new ModelRenderer(this, 28, 10);
        this.head5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head5.addBox(-2.5F, -14.0F, -4.2F, 5, 10, 5, 0.0F);
        this.setRotation(head5, -0.2792526803190927F, 0.0F, 0.0F);
        this.chest = new ModelRenderer(this, 0, 46);
        this.chest.setRotationPoint(0.0F, -9.0F, -5.2F);
        this.chest.addBox(-4.5F, -2.0F, 0.0F, 9, 8, 10, 0.0F);
        this.setRotation(chest, -0.7285004297824331F, 0.0F, 0.0F);
        this.lDorsalPipe2 = new ModelRenderer(this, 0, 86);
        this.lDorsalPipe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lDorsalPipe2.addBox(0.6F, -14.0F, 10.0F, 2, 9, 2, 0.0F);
        this.setRotation(lDorsalPipe2, -0.3665191429188092F, 0.0F, 0.13962634015954636F);
        this.rLowerLeg = new ModelRenderer(this, 113, 53);
        this.rLowerLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rLowerLeg.addBox(-0.5F, 5.5F, 9.0F, 2, 9, 2, 0.0F);
        this.dorsalSpike = new ModelRenderer(this, 0, 65);
        this.dorsalSpike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dorsalSpike.addBox(0.2F, -10.0F, 0.0F, 0, 8, 10, 0.0F);
        this.lLowerLeg = new ModelRenderer(this, 113, 40);
        this.lLowerLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lLowerLeg.addBox(-1.5F, 5.5F, 9.0F, 2, 9, 2, 0.0F);
        this.tailSpines5 = new ModelRenderer(this, 178, 96);
        this.tailSpines5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines5.addBox(0.0F, -1.5F, 0.0F, 0, 3, 11, 0.0F);
        this.stomach = new ModelRenderer(this, 0, 27);
        this.stomach.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stomach.addBox(-3.5F, -5.0F, 8.0F, 7, 6, 12, 0.0F);
        this.setRotation(stomach, -0.3665191429188092F, 0.0F, 0.0F);
        this.tailSpines1 = new ModelRenderer(this, 58, 93);
        this.tailSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines1.addBox(0.0F, -4.5F, 0.0F, 0, 8, 11, 0.0F);
        this.rDorsalPipe2 = new ModelRenderer(this, 9, 86);
        this.rDorsalPipe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rDorsalPipe2.addBox(-2.6F, -14.0F, 10.0F, 2, 9, 2, 0.0F);
        this.setRotation(rDorsalPipe2, -0.3665191429188092F, 0.0F, -0.13962634015954636F);
        this.lHand = new ModelRenderer(this, 83, 24);
        this.lHand.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lHand.addBox(-1.0F, -0.7F, -13.1F, 2, 1, 3, 0.0F);
        this.lThigh = new ModelRenderer(this, 40, 45);
        this.lThigh.setRotationPoint(4.5F, 6.4F, 17.0F);
        this.lThigh.addBox(-2.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F);
        this.setRotation(lThigh, -0.136659280431156F, -0.091106186954104F, -0.18203784098300857F);
        this.tail5 = new ModelRenderer(this, 178, 66);
        this.tail5.setRotationPoint(0.0F, 0.0F, 11.1F);
        this.tail5.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 11, 0.0F);
        this.setRotation(tail5, 0.08726646259971647F, 0.0F, 0.0F);
        this.tailSpines4 = new ModelRenderer(this, 148, 96);
        this.tailSpines4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines4.addBox(0.0F, -2.0F, 0.0F, 0, 4, 10, 0.0F);
        this.rShoulderRidge = new ModelRenderer(this, 172, 25);
        this.rShoulderRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rShoulderRidge.addBox(-5.5F, -2.8F, -2.3F, 2, 9, 5, 0.0F);
        this.setRotation(rShoulderRidge, 0.22759093446006054F, 0.18203784098300857F, -0.13962634015954636F);
        this.tailSpines2 = new ModelRenderer(this, 90, 93);
        this.tailSpines2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines2.addBox(0.0F, -3.5F, 0.0F, 0, 8, 11, 0.0F);
        this.rArmLower = new ModelRenderer(this, 98, 9);
        this.rArmLower.setRotationPoint(0.0F, 11.5F, 0.0F);
        this.rArmLower.addBox(-1.0F, -0.7F, -10.5F, 2, 2, 11, 0.0F);
        this.setRotation(rArmLower, 0.6373942428283291F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 50, 66);
        this.tail1.setRotationPoint(0.0F, 5.6F, 18.3F);
        this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 11, 0.0F);
        this.setRotation(tail1, 0.27314402793711257F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 34, 0);
        this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head2.addBox(-2.51F, 3.0F, -5.0F, 3, 3, 5, 0.0F);
        this.setRotation(head2, 0.5061454830783556F, 0.0F, 0.0F);
        this.rFoot = new ModelRenderer(this, 95, 24);
        this.rFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFoot.addBox(-1.5F, 15.0F, -8.0F, 2, 2, 5, 0.0F);
        this.setRotation(rFoot, 0.8651597102135892F, 0.091106186954104F, 0.0F);
        this.rArmUpper = new ModelRenderer(this, 50, 29);
        this.rArmUpper.setRotationPoint(-4.0F, 1.7F, 3.6F);
        this.rArmUpper.addBox(-1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(rArmUpper, 0.8196066167365371F, 0.0F, 0.31869712141416456F);
        this.rShin = new ModelRenderer(this, 79, 33);
        this.rShin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rShin.addBox(-1.0F, 8.0F, -5.5F, 3, 3, 12, 0.0F);
        this.setRotation(rShin, 0.40142572795869574F, 0.0F, 0.0F);
        this.rThigh = new ModelRenderer(this, 59, 45);
        this.rThigh.setRotationPoint(-4.5F, 6.4F, 17.0F);
        this.rThigh.addBox(-1.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F);
        this.setRotation(rThigh, -0.136659280431156F, 0.091106186954104F, 0.18203784098300857F);
        this.rClaws = new ModelRenderer(this, 60, 38);
        this.rClaws.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rClaws.addBox(-1.0F, -0.3F, -16.5F, 3, 0, 6, 0.0F);
        this.lArmUpper = new ModelRenderer(this, 40, 29);
        this.lArmUpper.setRotationPoint(4.0F, 1.7F, 3.6F);
        this.lArmUpper.addBox(-1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(lArmUpper, 0.8196066167365371F, 0.0F, -0.31869712141416456F);
        this.jawLower = new ModelRenderer(this, 88, 1);
        this.jawLower.setRotationPoint(0.0F, 4.2F, 2.5F);
        this.jawLower.addBox(-1.5F, 0.3F, -5.0F, 3, 1, 5, 0.0F);
        this.setRotation(jawLower, 0.7504915783575618F, 0.0F, 0.0F);
        this.lShin = new ModelRenderer(this, 79, 49);
        this.lShin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lShin.addBox(-2.0F, 8.0F, -5.5F, 3, 3, 12, 0.0F);
        this.setRotation(lShin, 0.40142572795869574F, 0.0F, 0.0F);
        this.tail4 = new ModelRenderer(this, 149, 66);
        this.tail4.setRotationPoint(0.0F, 0.0F, 10.7F);
        this.tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 11, 0.0F);
        this.setRotation(tail4, 0.06981317007977318F, 0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 118, 66);
        this.tail3.setRotationPoint(0.0F, 0.1F, 10.7F);
        this.tail3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 11, 0.0F);
        this.setRotation(tail3, 0.10471975511965977F, 0.0F, 0.0F);
        this.lFoot = new ModelRenderer(this, 110, 24);
        this.lFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFoot.addBox(-0.6F, 15.0F, -8.0F, 2, 2, 5, 0.0F);
        this.setRotation(lFoot, 0.8651597102135892F, -0.091106186954104F, 0.0F);
        this.head4 = new ModelRenderer(this, 52, 20);
        this.head4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head4.addBox(-1.5F, 4.1F, -6.1F, 3, 1, 5, 0.0F);
        this.setRotation(head4, 0.7504915783575618F, 0.0F, 0.0F);
        this.tail3.addChild(this.tailSpines3);
        this.chest.addChild(this.head1);
        this.chest.addChild(this.lDorsalPipe1);
        this.chest.addChild(this.lBackBlade2);
        this.tail1.addChild(this.tail2);
        this.chest.addChild(this.rBackBlade1);
        this.chest.addChild(this.rBackBlade2);
        this.tail5.addChild(this.stabber);
        this.head1.addChild(this.head3);
        this.rArmLower.addChild(this.rHand);
        this.chest.addChild(this.lBackBlade1);
        this.chest.addChild(this.backSpine);
        this.lArmUpper.addChild(this.lArmLower);
        this.chest.addChild(this.neck);
        this.lArmLower.addChild(this.lClaws);
        this.head1.addChild(this.head6);
        this.head1.addChild(this.innerJaw);
        this.chest.addChild(this.lShoulderRidge);
        this.chest.addChild(this.rDorsalPipe1);
        this.head1.addChild(this.head5);
        this.chest.addChild(this.lDorsalPipe2);
        this.rThigh.addChild(this.rLowerLeg);
        this.chest.addChild(this.dorsalSpike);
        this.lThigh.addChild(this.lLowerLeg);
        this.tail5.addChild(this.tailSpines5);
        this.chest.addChild(this.stomach);
        this.tail1.addChild(this.tailSpines1);
        this.chest.addChild(this.rDorsalPipe2);
        this.lArmLower.addChild(this.lHand);
        this.chest.addChild(this.lThigh);
        this.tail4.addChild(this.tail5);
        this.tail4.addChild(this.tailSpines4);
        this.chest.addChild(this.rShoulderRidge);
        this.tail2.addChild(this.tailSpines2);
        this.rArmUpper.addChild(this.rArmLower);
        this.chest.addChild(this.tail1);
        this.head1.addChild(this.head2);
        this.rThigh.addChild(this.rFoot);
        this.chest.addChild(this.rArmUpper);
        this.rThigh.addChild(this.rShin);
        this.chest.addChild(this.rThigh);
        this.rArmLower.addChild(this.rClaws);
        this.chest.addChild(this.lArmUpper);
        this.head1.addChild(this.jawLower);
        this.lThigh.addChild(this.lShin);
        this.tail3.addChild(this.tail4);
        this.tail2.addChild(this.tail3);
        this.lThigh.addChild(this.lFoot);
        this.head1.addChild(this.head4);
    }

    @Override
    public void render(EntityUltramorph obj)
    {
        EntityLivingBase base = (EntityLivingBase) obj;;
        SpeciesXenomorph xenomorph = (SpeciesXenomorph) base;

        float swingProgress = swingProgress(obj);
        float swingProgressPrev = swingProgressPrev(obj);
        float tailAngle = MathHelper.cos((Minecraft.getMinecraft().world.getTotalWorldTime() % 360 + Game.partialTicks()) * (base != null && base.motionX + base.motionZ != 0 ? 0.67F : 0.07F));

        if (xenomorph != null)
        {
            float innerJawDistance = XenomorphJawState.calculateJawOffset(xenomorph.getInnerJawProgress());
            float lowerJawAngle = XenomorphJawState.interpolateLowerJawAngle(xenomorph.getOuterJawProgress());
            float innerJawAngle = XenomorphJawState.interpolateInnerJawAngle(xenomorph.getInnerJawProgress());

            this.jawLower.rotateAngleX = (float) Math.toRadians(lowerJawAngle * Game.partialTicks()) / Game.partialTicks();
            this.innerJaw.rotationPointY = 3.725F;
            this.innerJaw.rotateAngleX = (float) Math.toRadians((10 + innerJawAngle) * Game.partialTicks()) / Game.partialTicks();
            this.innerJaw.offsetY = (0.15F * innerJawDistance * Game.partialTicks()) / Game.partialTicks();
            this.innerJaw.offsetZ = (-0.1F * innerJawDistance * Game.partialTicks()) / Game.partialTicks();
        }

        this.head1.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.rThigh.rotateAngleX = MathHelper.cos(swingProgress * 0.3662F + (float) Math.PI) * 0.9F * swingProgressPrev;
        this.lThigh.rotateAngleX = MathHelper.sin(swingProgress * 0.3662F + (float) Math.PI) * 0.9F * swingProgressPrev;
        this.rArmUpper.rotateAngleX = MathHelper.cos(swingProgress * 0.3662F) * 0.6F * swingProgressPrev + 0.6665191F;
        this.lArmUpper.rotateAngleX = MathHelper.sin(swingProgress * 0.3662F) * 0.6F * swingProgressPrev + 0.6665191F;

        /** Tail Attack Position **/
        {
            // this.tail1.rotateAngleY = tailAngle / 1.5F;
            // this.tail2.rotateAngleY = tailAngle * 1.55F;
            // this.tail3.rotateAngleY = tailAngle * 1.15F;
            // this.tail4.rotateAngleY = tailAngle * 0.25F;
            // this.tail5.rotateAngleY = tailAngle * 0.05F;
            //
            // this.tail3.rotateAngleZ = tailAngle * 0.55F;
            // this.tail4.rotateAngleZ = tailAngle * 0.45F;
        }

        /** Tail Idle Position **/
        {
            float multiplier = 0.15F;

            this.tail1.rotateAngleX = (float) Math.toRadians(0);
            this.tail2.rotateAngleX = (float) Math.toRadians(15);
            this.tail3.rotateAngleX = (float) Math.toRadians(15);
            this.tail4.rotateAngleX = (float) Math.toRadians(0);

            this.tail1.rotateAngleY = tailAngle * multiplier;
            this.tail2.rotateAngleY = tailAngle * multiplier;
            this.tail3.rotateAngleY = tailAngle * multiplier;
            this.tail4.rotateAngleY = tailAngle * multiplier;
            this.tail5.rotateAngleY = tailAngle * multiplier;
        }

        draw(chest);
    }
}
