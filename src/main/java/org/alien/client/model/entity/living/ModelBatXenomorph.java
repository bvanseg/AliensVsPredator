package org.alien.client.model.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import org.alien.common.entity.living.xenomorph.EntityBatXeno;

public class ModelBatXenomorph extends Model<EntityBatXeno>
{
    public final ModelRenderer chest;
    public final ModelRenderer lArmUpper;
    public final ModelRenderer rArmUpper;
    public final ModelRenderer stomach;
    public final ModelRenderer dorsalSpike;
    public final ModelRenderer rShoulderRidge;
    public final ModelRenderer lShoulderRidge;
    public final ModelRenderer neck;
    public final ModelRenderer head1;
    public final ModelRenderer tail1;
    public final ModelRenderer lThigh;
    public final ModelRenderer rThigh;
    public final ModelRenderer backSpine;
    public final ModelRenderer tailSpines1;
    public final ModelRenderer tail2;
    public final ModelRenderer tailSpines2;
    public final ModelRenderer tail3;
    public final ModelRenderer tailSpines3;
    public final ModelRenderer tail4;
    public final ModelRenderer tailSpines4;
    public final ModelRenderer tail5;
    public final ModelRenderer tailSpines5;
    public final ModelRenderer stabber;
    public final ModelRenderer lShin;
    public final ModelRenderer lLowerLeg;
    public final ModelRenderer lFoot;
    public final ModelRenderer rShin;
    public final ModelRenderer rLowerLeg;
    public final ModelRenderer rFoot;
    public final ModelRenderer head5;
    public final ModelRenderer head6;
    public final ModelRenderer head2;
    public final ModelRenderer head3;
    public final ModelRenderer head4;
    public final ModelRenderer lHeadFin;
    public final ModelRenderer rHeadFin;
    public final ModelRenderer jawLower;
    public final ModelRenderer innerJaw;
    public final ModelRenderer lArmLower;
    public final ModelRenderer lWing01;
    public final ModelRenderer lWing02;
    public final ModelRenderer rArmLower;
    public final ModelRenderer rWing01;
    public final ModelRenderer rWing02;

    public ModelBatXenomorph()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.rWing02 = new ModelRenderer(this, 186, 14);
        this.rWing02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWing02.addBox(0.0F, 0.3F, -16.3F, 0, 13, 28, 0.0F);
        this.innerJaw = new ModelRenderer(this, 0, 18);
        this.innerJaw.setRotationPoint(0.0F, 4.3F, 2.2F);
        this.innerJaw.addBox(-1.0F, -0.7F, -4.6F, 2, 2, 5, 0.0F);
        this.setRotation(innerJaw, 0.7504915783575618F, 0.0F, 0.0F);
        this.lHeadFin = new ModelRenderer(this, 144, 0);
        this.lHeadFin.mirror = true;
        this.lHeadFin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lHeadFin.addBox(0.8F, -12.3F, -3.4F, 5, 9, 0, 0.0F);
        this.setRotation(lHeadFin, -0.2792526803190927F, -0.4553564018453205F, 0.136659280431156F);
        this.tailSpines5 = new ModelRenderer(this, 178, 96);
        this.tailSpines5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines5.addBox(0.0F, -5.2F, -0.4F, 0, 8, 11, 0.0F);
        this.stomach = new ModelRenderer(this, 0, 27);
        this.stomach.setRotationPoint(0.0F, 0.9F, 8.0F);
        this.stomach.addBox(-3.5F, -3.0F, 0.0F, 7, 6, 12, 0.0F);
        this.setRotation(stomach, -0.3665191429188092F, 0.0F, 0.0F);
        this.dorsalSpike = new ModelRenderer(this, 0, 65);
        this.dorsalSpike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dorsalSpike.addBox(0.0F, -10.0F, 0.0F, 0, 8, 10, 0.0F);
        this.lShoulderRidge = new ModelRenderer(this, 155, 25);
        this.lShoulderRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lShoulderRidge.addBox(3.5F, -2.8F, -2.3F, 2, 9, 5, 0.0F);
        this.setRotation(lShoulderRidge, 0.22759093446006054F, -0.18203784098300857F, 0.13962634015954636F);
        this.rHeadFin = new ModelRenderer(this, 144, 0);
        this.rHeadFin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rHeadFin.addBox(-5.7F, -12.3F, -3.4F, 5, 9, 0, 0.0F);
        this.setRotation(rHeadFin, -0.2792526803190927F, 0.4553564018453205F, -0.136659280431156F);
        this.tailSpines4 = new ModelRenderer(this, 148, 96);
        this.tailSpines4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines4.addBox(0.0F, -5.2F, 0.8F, 0, 8, 10, 0.0F);
        this.tail1 = new ModelRenderer(this, 50, 66);
        this.tail1.setRotationPoint(0.0F, 0.6F, 11.7F);
        this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 11, 0.0F);
        this.setRotation(tail1, 0.15707963267948966F, 0.0F, 0.0F);
        this.tailSpines3 = new ModelRenderer(this, 117, 94);
        this.tailSpines3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines3.addBox(0.0F, -2.5F, 1.1F, 0, 6, 10, 0.0F);
        this.rLowerLeg = new ModelRenderer(this, 113, 53);
        this.rLowerLeg.setRotationPoint(0.0F, 1.5F, 9.3F);
        this.rLowerLeg.addBox(-0.5F, 0.4F, -1.5F, 2, 9, 2, 0.0F);
        this.setRotation(rLowerLeg, -0.22759093446006054F, 0.0F, 0.0F);
        this.rArmUpper = new ModelRenderer(this, 50, 29);
        this.rArmUpper.setRotationPoint(-4.3F, -0.2F, -10.9F);
        this.rArmUpper.addBox(-1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(rArmUpper, 0.0F, 0.0F, 0.593411945678072F);
        this.head1 = new ModelRenderer(this, 0, 0);
        this.head1.setRotationPoint(0.0F, -0.5F, -3.7F);
        this.head1.addBox(-2.5F, -5.0F, -3.0F, 5, 10, 5, 0.0F);
        this.setRotation(head1, -0.5462880558742251F, 0.0F, 0.0F);
        this.lFoot = new ModelRenderer(this, 110, 24);
        this.lFoot.setRotationPoint(-0.5F, 8.9F, -0.4F);
        this.lFoot.addBox(-1.0F, -0.9F, -3.5F, 2, 2, 5, 0.0F);
        this.setRotation(lFoot, 0.6829473363053812F, -0.136659280431156F, 0.31869712141416456F);
        this.lArmLower = new ModelRenderer(this, 71, 9);
        this.lArmLower.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.lArmLower.addBox(-1.0F, 0.0F, -10.5F, 2, 2, 11, 0.0F);
        this.tailSpines2 = new ModelRenderer(this, 90, 93);
        this.tailSpines2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines2.addBox(0.0F, -3.5F, 0.6F, 0, 8, 11, 0.0F);
        this.tail3 = new ModelRenderer(this, 118, 66);
        this.tail3.setRotationPoint(0.0F, 0.1F, 10.7F);
        this.tail3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 11, 0.0F);
        this.setRotation(tail3, 0.10471975511965977F, 0.0F, 0.0F);
        this.rShin = new ModelRenderer(this, 79, 33);
        this.rShin.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.rShin.addBox(-1.0F, 0.7F, -2.1F, 3, 3, 12, 0.0F);
        this.setRotation(rShin, 0.40142572795869574F, 0.0F, 0.0F);
        this.rShoulderRidge = new ModelRenderer(this, 172, 25);
        this.rShoulderRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rShoulderRidge.addBox(-5.5F, -2.8F, -2.3F, 2, 9, 5, 0.0F);
        this.setRotation(rShoulderRidge, 0.22759093446006054F, 0.18203784098300857F, -0.13962634015954636F);
        this.chest = new ModelRenderer(this, 0, 46);
        this.chest.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.chest.addBox(-4.5F, -2.0F, 0.0F, 9, 8, 10, 0.0F);
        this.setRotation(chest, -0.19198621771937624F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 85, 66);
        this.tail2.setRotationPoint(0.0F, -1.0F, 10.36F);
        this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 11, 0.0F);
        this.setRotation(tail2, 0.08726646259971647F, 0.0F, 0.0F);
        this.backSpine = new ModelRenderer(this, 23, 65);
        this.backSpine.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.backSpine.addBox(0.0F, -8.9F, 1.0F, 0, 6, 12, 0.0F);
        this.lLowerLeg = new ModelRenderer(this, 113, 40);
        this.lLowerLeg.setRotationPoint(0.0F, 1.5F, 9.3F);
        this.lLowerLeg.addBox(-1.5F, 0.4F, -1.5F, 2, 9, 2, 0.0F);
        this.setRotation(lLowerLeg, -0.22759093446006054F, 0.0F, 0.0F);
        this.tail4 = new ModelRenderer(this, 149, 66);
        this.tail4.setRotationPoint(0.0F, 0.0F, 10.7F);
        this.tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 11, 0.0F);
        this.setRotation(tail4, 0.06981317007977318F, 0.0F, 0.0F);
        this.rWing01 = new ModelRenderer(this, 188, 0);
        this.rWing01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rWing01.addBox(0.0F, -1.7F, 0.0F, 0, 13, 12, 0.0F);
        this.head2 = new ModelRenderer(this, 34, 0);
        this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head2.addBox(-2.51F, 3.0F, -5.0F, 3, 3, 5, 0.0F);
        this.setRotation(head2, 0.5061454830783556F, 0.0F, 0.0F);
        this.tailSpines1 = new ModelRenderer(this, 58, 93);
        this.tailSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines1.addBox(0.0F, -4.5F, 0.0F, 0, 8, 11, 0.0F);
        this.rThigh = new ModelRenderer(this, 59, 45);
        this.rThigh.setRotationPoint(-4.0F, 1.5F, 11.1F);
        this.rThigh.addBox(-1.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F);
        this.setRotation(rThigh, -0.31869712141416456F, 0.06981317007977318F, 0.41887902047863906F);
        this.rFoot = new ModelRenderer(this, 95, 24);
        this.rFoot.setRotationPoint(-0.5F, 8.9F, -0.4F);
        this.rFoot.addBox(0.0F, -0.6F, -3.5F, 2, 2, 5, 0.0F);
        this.setRotation(rFoot, 0.6829473363053812F, 0.136659280431156F, -0.31869712141416456F);
        this.head6 = new ModelRenderer(this, 53, 0);
        this.head6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head6.addBox(-0.5F, 3.0F, -5.0F, 3, 3, 5, 0.0F);
        this.setRotation(head6, 0.5061454830783556F, 0.0F, 0.0F);
        this.lWing01 = new ModelRenderer(this, 188, 0);
        this.lWing01.mirror = true;
        this.lWing01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWing01.addBox(0.0F, -1.7F, 0.0F, 0, 13, 12, 0.0F);
        this.jawLower = new ModelRenderer(this, 88, 1);
        this.jawLower.setRotationPoint(0.0F, 4.2F, 2.5F);
        this.jawLower.addBox(-1.5F, 0.3F, -5.0F, 3, 1, 5, 0.0F);
        this.setRotation(jawLower, 0.7504915783575618F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 23, 86);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-2.0F, -2.0F, -4.0F, 4, 6, 5, 0.0F);
        this.lArmUpper = new ModelRenderer(this, 40, 29);
        this.lArmUpper.setRotationPoint(4.3F, -0.2F, -10.9F);
        this.lArmUpper.addBox(-1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F);
        this.setRotation(lArmUpper, 0.0F, 0.0F, -0.593411945678072F);
        this.head3 = new ModelRenderer(this, 51, 10);
        this.head3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head3.addBox(-2.5F, 2.8F, -5.0F, 5, 3, 4, 0.0F);
        this.setRotation(head3, 0.6283185307179586F, 0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 52, 20);
        this.head4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head4.addBox(-1.5F, 4.1F, -6.1F, 3, 1, 5, 0.0F);
        this.setRotation(head4, 0.7504915783575618F, 0.0F, 0.0F);
        this.tail5 = new ModelRenderer(this, 178, 66);
        this.tail5.setRotationPoint(0.0F, 0.0F, 11.1F);
        this.tail5.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 11, 0.0F);
        this.setRotation(tail5, 0.08726646259971647F, 0.0F, 0.0F);
        this.head5 = new ModelRenderer(this, 28, 10);
        this.head5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head5.addBox(-2.5F, -14.0F, -4.2F, 5, 10, 5, 0.0F);
        this.setRotation(head5, -0.2792526803190927F, 0.0F, 0.0F);
        this.lWing02 = new ModelRenderer(this, 186, 14);
        this.lWing02.mirror = true;
        this.lWing02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lWing02.addBox(0.0F, 0.3F, -16.3F, 0, 13, 28, 0.0F);
        this.rArmLower = new ModelRenderer(this, 98, 9);
        this.rArmLower.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.rArmLower.addBox(-1.0F, 0.0F, -10.5F, 2, 2, 11, 0.0F);
        this.stabber = new ModelRenderer(this, 205, 66);
        this.stabber.setRotationPoint(0.0F, 0.0F, 9.6F);
        this.stabber.addBox(0.0F, -1.5F, 0.0F, 0, 3, 11, 0.0F);
        this.lThigh = new ModelRenderer(this, 40, 45);
        this.lThigh.setRotationPoint(4.0F, 1.5F, 11.1F);
        this.lThigh.addBox(-2.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F);
        this.setRotation(lThigh, -0.31869712141416456F, 0.06981317007977318F, -0.41887902047863906F);
        this.lShin = new ModelRenderer(this, 79, 49);
        this.lShin.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.lShin.addBox(-2.0F, 0.7F, -2.1F, 3, 3, 12, 0.0F);
        this.setRotation(lShin, 0.40142572795869574F, 0.0F, 0.0F);
        this.rArmLower.addChild(this.rWing02);
        this.head1.addChild(this.innerJaw);
        this.head1.addChild(this.lHeadFin);
        this.tail5.addChild(this.tailSpines5);
        this.chest.addChild(this.stomach);
        this.chest.addChild(this.dorsalSpike);
        this.chest.addChild(this.lShoulderRidge);
        this.head1.addChild(this.rHeadFin);
        this.tail4.addChild(this.tailSpines4);
        this.stomach.addChild(this.tail1);
        this.tail3.addChild(this.tailSpines3);
        this.rShin.addChild(this.rLowerLeg);
        this.chest.addChild(this.head1);
        this.lLowerLeg.addChild(this.lFoot);
        this.lArmUpper.addChild(this.lArmLower);
        this.tail2.addChild(this.tailSpines2);
        this.tail2.addChild(this.tail3);
        this.rThigh.addChild(this.rShin);
        this.chest.addChild(this.rShoulderRidge);
        this.tail1.addChild(this.tail2);
        this.stomach.addChild(this.backSpine);
        this.lShin.addChild(this.lLowerLeg);
        this.tail3.addChild(this.tail4);
        this.rArmUpper.addChild(this.rWing01);
        this.head1.addChild(this.head2);
        this.tail1.addChild(this.tailSpines1);
        this.stomach.addChild(this.rThigh);
        this.rLowerLeg.addChild(this.rFoot);
        this.head1.addChild(this.head6);
        this.lArmUpper.addChild(this.lWing01);
        this.head1.addChild(this.jawLower);
        this.chest.addChild(this.neck);
        this.head1.addChild(this.head3);
        this.head1.addChild(this.head4);
        this.tail4.addChild(this.tail5);
        this.head1.addChild(this.head5);
        this.lArmLower.addChild(this.lWing02);
        this.rArmUpper.addChild(this.rArmLower);
        this.tail5.addChild(this.stabber);
        this.stomach.addChild(this.lThigh);
        this.lThigh.addChild(this.lShin);
    }

    @Override
    public void render(EntityBatXeno obj)
    {
        OpenGL.pushMatrix();
        OpenGL.translate(this.rArmUpper.offsetX, this.rArmUpper.offsetY, this.rArmUpper.offsetZ);
        OpenGL.translate(this.rArmUpper.rotationPointX * DEFAULT_SCALE, this.rArmUpper.rotationPointY * DEFAULT_SCALE, this.rArmUpper.rotationPointZ * DEFAULT_SCALE);
        OpenGL.scale(1.5D, 1.0D, 1.5D);
        OpenGL.translate(-this.rArmUpper.offsetX, -this.rArmUpper.offsetY, -this.rArmUpper.offsetZ);
        OpenGL.translate(-this.rArmUpper.rotationPointX * DEFAULT_SCALE, -this.rArmUpper.rotationPointY * DEFAULT_SCALE, -this.rArmUpper.rotationPointZ * DEFAULT_SCALE);
        this.rArmUpper.render(DEFAULT_SCALE);
        OpenGL.popMatrix();
        this.chest.render(DEFAULT_SCALE);
        OpenGL.pushMatrix();
        OpenGL.translate(this.lArmUpper.offsetX, this.lArmUpper.offsetY, this.lArmUpper.offsetZ);
        OpenGL.translate(this.lArmUpper.rotationPointX * DEFAULT_SCALE, this.lArmUpper.rotationPointY * DEFAULT_SCALE, this.lArmUpper.rotationPointZ * DEFAULT_SCALE);
        OpenGL.scale(1.5D, 1.0D, 1.5D);
        OpenGL.translate(-this.lArmUpper.offsetX, -this.lArmUpper.offsetY, -this.lArmUpper.offsetZ);
        OpenGL.translate(-this.lArmUpper.rotationPointX * DEFAULT_SCALE, -this.lArmUpper.rotationPointY * DEFAULT_SCALE, -this.lArmUpper.rotationPointZ * DEFAULT_SCALE);
        this.lArmUpper.render(DEFAULT_SCALE);
        OpenGL.popMatrix();
    }
}
