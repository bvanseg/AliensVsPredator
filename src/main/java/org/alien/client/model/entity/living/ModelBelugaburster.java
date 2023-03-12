package org.alien.client.model.entity.living;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.alien.common.entity.living.vardic.EntityBelugaburster;


public class ModelBelugaburster extends Model<EntityBelugaburster>
{
    public ModelRenderer bodyMid;
    public ModelRenderer body2;
    public ModelRenderer neck;
    public ModelRenderer body3;
    public ModelRenderer rArm1;
    public ModelRenderer lArm1;
    public ModelRenderer lTail1;
    public ModelRenderer rTail1;
    public ModelRenderer lTail2;
    public ModelRenderer lTail3;
    public ModelRenderer lTail4;
    public ModelRenderer rTail2;
    public ModelRenderer rTail3;
    public ModelRenderer rTail4;
    public ModelRenderer rArm2;
    public ModelRenderer rArm3;
    public ModelRenderer rArm4;
    public ModelRenderer rArm5;
    public ModelRenderer rArm6;
    public ModelRenderer lArm2;
    public ModelRenderer lArm3;
    public ModelRenderer lArm4;
    public ModelRenderer lArm5;
    public ModelRenderer lArm6;
    public ModelRenderer neck2;
    public ModelRenderer head1;
    public ModelRenderer head2;
    public ModelRenderer jawUpper;
    public ModelRenderer jawLower;
    public ModelRenderer headBubble;
    public ModelRenderer headBubbleSlope;
    public ModelRenderer headBubbleSlope2;
    public ModelRenderer headBubbleSlope3;

    public ModelBelugaburster()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.neck = new ModelRenderer(this, 0, 31);
        this.neck.setRotationPoint(0.0F, -3.2F, 1.3F);
        this.neck.addBox(-1.5F, -3.3F, -1.6F, 3, 4, 3, 0.0F);
        this.setRotation(neck, -0.8651597102135892F, 0.0F, 0.0F);
        this.lTail1 = new ModelRenderer(this, 47, 2);
        this.lTail1.setRotationPoint(0.8F, 2.3F, 6.0F);
        this.lTail1.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 7, 0.0F);
        this.rArm2 = new ModelRenderer(this, 71, 7);
        this.rArm2.mirror = true;
        this.rArm2.setRotationPoint(-0.5F, 3.5F, -0.2F);
        this.rArm2.addBox(-0.5F, -0.5F, -0.9F, 1, 4, 2, 0.0F);
        this.setRotation(rArm2, -0.22759093446006054F, 0.0F, -0.136659280431156F);
        this.rTail2 = new ModelRenderer(this, 47, 12);
        this.rTail2.mirror = true;
        this.rTail2.setRotationPoint(0.1F, 0.0F, 6.5F);
        this.rTail2.addBox(-0.6F, -1.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotation(rTail2, 0.091106186954104F, 0.0F, 0.0F);
        this.jawLower = new ModelRenderer(this, 25, 55);
        this.jawLower.setRotationPoint(0.0F, 1.5F, -6.3F);
        this.jawLower.addBox(-1.0F, -0.4F, -1.3F, 2, 1, 2, 0.0F);
        this.setRotation(jawLower, 0.22759093446006054F, 0.0F, 0.0F);
        this.lArm1 = new ModelRenderer(this, 70, 0);
        this.lArm1.setRotationPoint(1.0F, -1.1F, 0.0F);
        this.lArm1.addBox(0.0F, -1.7F, -1.0F, 1, 5, 2, 0.0F);
        this.setRotation(lArm1, 0.0F, 0.0F, -0.18203784098300857F);
        this.neck2 = new ModelRenderer(this, 0, 22);
        this.neck2.setRotationPoint(0.0F, -3.1F, 0.0F);
        this.neck2.addBox(-1.5F, -2.9F, -2.1F, 3, 4, 3, 0.0F);
        this.setRotation(neck2, 1.0471975511965976F, 0.0F, 0.0F);
        this.lArm6 = new ModelRenderer(this, 71, 29);
        this.lArm6.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.lArm6.addBox(-0.5F, -5.2F, -0.3F, 1, 5, 1, 0.0F);
        this.setRotation(lArm6, -0.0041887902047863905F, 0.0F, -0.091106186954104F);
        this.headBubbleSlope3 = new ModelRenderer(this, 24, 42);
        this.headBubbleSlope3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headBubbleSlope3.addBox(-1.0F, -1.9F, 2.1F, 2, 1, 3, 0.0F);
        this.setRotation(headBubbleSlope3, -0.7285004297824331F, 0.0F, 0.0F);
        this.lTail3 = new ModelRenderer(this, 47, 22);
        this.lTail3.setRotationPoint(0.0F, 0.0F, 4.6F);
        this.lTail3.addBox(-0.6F, -0.4F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotation(lTail3, -0.22759093446006054F, 0.0F, 0.0F);
        this.jawUpper = new ModelRenderer(this, 25, 49);
        this.jawUpper.setRotationPoint(0.0F, 0.6F, -6.3F);
        this.jawUpper.addBox(-1.0F, 0.1F, -1.4F, 2, 1, 2, 0.0F);
        this.headBubbleSlope = new ModelRenderer(this, 22, 25);
        this.headBubbleSlope.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headBubbleSlope.addBox(-1.5F, -2.1F, -5.9F, 3, 2, 5, 0.0F);
        this.setRotation(headBubbleSlope, -0.18203784098300857F, 0.0F, 0.0F);
        this.rArm6 = new ModelRenderer(this, 71, 29);
        this.rArm6.mirror = true;
        this.rArm6.setRotationPoint(0.0F, -4.5F, 0.0F);
        this.rArm6.addBox(-0.5F, -5.2F, -0.3F, 1, 5, 1, 0.0F);
        this.setRotation(rArm6, -0.0041887902047863905F, 0.0F, 0.091106186954104F);
        this.lArm3 = new ModelRenderer(this, 70, 14);
        this.lArm3.setRotationPoint(-0.2F, 2.9F, 0.1F);
        this.lArm3.addBox(-0.3F, -0.9F, -0.6F, 1, 2, 3, 0.0F);
        this.setRotation(lArm3, -0.5009094953223726F, -0.045553093477052F, 0.0F);
        this.rArm4 = new ModelRenderer(this, 71, 21);
        this.rArm4.mirror = true;
        this.rArm4.setRotationPoint(0.2F, 0.4F, 1.5F);
        this.rArm4.addBox(-0.5F, -3.7F, -0.3F, 1, 4, 2, 0.0F);
        this.setRotation(rArm4, -0.36425021489121656F, -0.045553093477052F, -0.091106186954104F);
        this.rArm5 = new ModelRenderer(this, 71, 29);
        this.rArm5.mirror = true;
        this.rArm5.setRotationPoint(0.0F, -3.4F, 1.0F);
        this.rArm5.addBox(-0.5F, -4.9F, -0.3F, 1, 5, 1, 0.0F);
        this.rArm1 = new ModelRenderer(this, 70, 0);
        this.rArm1.mirror = true;
        this.rArm1.setRotationPoint(-1.0F, -1.1F, 0.0F);
        this.rArm1.addBox(-1.0F, -1.7F, -1.0F, 1, 5, 2, 0.0F);
        this.setRotation(rArm1, 0.0F, 0.0F, 0.18203784098300857F);
        this.rTail3 = new ModelRenderer(this, 47, 22);
        this.rTail3.mirror = true;
        this.rTail3.setRotationPoint(0.0F, 0.0F, 4.6F);
        this.rTail3.addBox(-0.6F, -0.4F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotation(rTail3, -0.22759093446006054F, 0.0F, 0.0F);
        this.lArm4 = new ModelRenderer(this, 71, 21);
        this.lArm4.setRotationPoint(0.2F, 0.4F, 1.6F);
        this.lArm4.addBox(-0.5F, -3.7F, -0.3F, 1, 4, 2, 0.0F);
        this.setRotation(lArm4, -0.36425021489121656F, 0.045553093477052F, 0.091106186954104F);
        this.body3 = new ModelRenderer(this, 22, 0);
        this.body3.setRotationPoint(0.0F, 4.3F, 0.6F);
        this.body3.addBox(-1.5F, 0.2F, -0.8F, 3, 3, 7, 0.0F);
        this.setRotation(body3, 0.4553564018453205F, 0.0F, 0.0F);
        this.headBubbleSlope2 = new ModelRenderer(this, 24, 34);
        this.headBubbleSlope2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headBubbleSlope2.addBox(-1.0F, -1.6F, -1.6F, 2, 2, 4, 0.0F);
        this.setRotation(headBubbleSlope2, -0.5462880558742251F, 0.0F, 0.0F);
        this.lTail4 = new ModelRenderer(this, 47, 29);
        this.lTail4.setRotationPoint(0.0F, 0.2F, 4.0F);
        this.lTail4.addBox(-0.6F, -0.5F, -0.1F, 1, 1, 5, 0.0F);
        this.setRotation(lTail4, 0.136659280431156F, 0.0F, 0.0F);
        this.bodyMid = new ModelRenderer(this, 0, 49);
        this.bodyMid.setRotationPoint(0.0F, 16.6F, 0.0F);
        this.bodyMid.addBox(-1.5F, -0.3F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotation(bodyMid, -0.136659280431156F, 0.0F, 0.0F);
        this.rTail4 = new ModelRenderer(this, 47, 29);
        this.rTail4.mirror = true;
        this.rTail4.setRotationPoint(0.0F, 0.2F, 4.0F);
        this.rTail4.addBox(-0.6F, -0.5F, -0.1F, 1, 1, 5, 0.0F);
        this.setRotation(rTail4, 0.136659280431156F, 0.0F, 0.0F);
        this.body2 = new ModelRenderer(this, 0, 40);
        this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body2.addBox(-1.5F, -3.7F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotation(body2, -0.31869712141416456F, 0.0F, 0.0F);
        this.lTail2 = new ModelRenderer(this, 47, 12);
        this.lTail2.setRotationPoint(0.1F, 0.0F, 6.5F);
        this.lTail2.addBox(-0.6F, -1.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotation(lTail2, 0.091106186954104F, 0.0F, 0.0F);
        this.rTail1 = new ModelRenderer(this, 47, 2);
        this.rTail1.mirror = true;
        this.rTail1.setRotationPoint(-0.8F, 2.3F, 6.0F);
        this.rTail1.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 7, 0.0F);
        this.lArm5 = new ModelRenderer(this, 71, 29);
        this.lArm5.setRotationPoint(0.0F, -3.4F, 1.0F);
        this.lArm5.addBox(-0.5F, -4.9F, -0.3F, 1, 5, 1, 0.0F);
        this.lArm2 = new ModelRenderer(this, 71, 7);
        this.lArm2.setRotationPoint(0.5F, 3.5F, -0.2F);
        this.lArm2.addBox(-0.5F, -0.5F, -0.9F, 1, 4, 2, 0.0F);
        this.setRotation(lArm2, -0.22759093446006054F, 0.0F, 0.136659280431156F);
        this.head1 = new ModelRenderer(this, 0, 12);
        this.head1.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.head1.addBox(-1.5F, -0.8F, -5.4F, 3, 3, 6, 0.0F);
        this.setRotation(head1, -0.5462880558742251F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 0, 0);
        this.head2.setRotationPoint(0.0F, 0.1F, -5.0F);
        this.head2.addBox(-1.5F, -1.5F, -6.8F, 3, 3, 7, 0.0F);
        this.setRotation(head2, 0.5918411493512771F, 0.0F, 0.0F);
        this.rArm3 = new ModelRenderer(this, 70, 14);
        this.rArm3.mirror = true;
        this.rArm3.setRotationPoint(-0.2F, 2.9F, 0.1F);
        this.rArm3.addBox(-0.3F, -0.9F, -0.6F, 1, 2, 3, 0.0F);
        this.setRotation(rArm3, -0.5009094953223726F, 0.045553093477052F, 0.0F);
        this.headBubble = new ModelRenderer(this, 22, 15);
        this.headBubble.setRotationPoint(0.0F, 0.6F, 0.0F);
        this.headBubble.addBox(-2.0F, -6.9F, -6.4F, 4, 3, 4, 0.0F);
        this.setRotation(headBubble, 0.5918411493512771F, 0.0F, 0.0F);
        this.bodyMid.addChild(this.neck);
        this.body3.addChild(this.lTail1);
        this.rArm1.addChild(this.rArm2);
        this.rTail1.addChild(this.rTail2);
        this.head2.addChild(this.jawLower);
        this.body2.addChild(this.lArm1);
        this.neck.addChild(this.neck2);
        this.lArm5.addChild(this.lArm6);
        this.head2.addChild(this.headBubbleSlope3);
        this.lTail2.addChild(this.lTail3);
        this.head2.addChild(this.jawUpper);
        this.head2.addChild(this.headBubbleSlope);
        this.rArm5.addChild(this.rArm6);
        this.lArm2.addChild(this.lArm3);
        this.rArm3.addChild(this.rArm4);
        this.rArm4.addChild(this.rArm5);
        this.body2.addChild(this.rArm1);
        this.rTail2.addChild(this.rTail3);
        this.lArm3.addChild(this.lArm4);
        this.body2.addChild(this.body3);
        this.head2.addChild(this.headBubbleSlope2);
        this.lTail3.addChild(this.lTail4);
        this.rTail3.addChild(this.rTail4);
        this.bodyMid.addChild(this.body2);
        this.lTail1.addChild(this.lTail2);
        this.body3.addChild(this.rTail1);
        this.lArm4.addChild(this.lArm5);
        this.lArm1.addChild(this.lArm2);
        this.neck2.addChild(this.head1);
        this.head1.addChild(this.head2);
        this.rArm2.addChild(this.rArm3);
        this.head2.addChild(this.headBubble);
    }

    @Override
    public void render(EntityBelugaburster obj)
    {
        draw(bodyMid);

        float newangle = MathHelper.cos(idleProgress(obj) * 8.0F * 0.1F) * (float) Math.PI * 0.9F * swingProgressPrev(obj);
        float neckangle = MathHelper.cos(idleProgress(obj) * 4.0F * 0.1F) * (float) Math.PI * 0.9F * swingProgressPrev(obj);
        float distMult = 0.15F;
        float neckdistmult = 0.1F;

        if (obj instanceof EntityLivingBase)
        {
            EntityLivingBase base = (EntityLivingBase) obj;
            
            if (base != null && base.prevPosX == base.posX && base.prevPosY == base.posY && base.prevPosZ == base.posZ)
            {
                newangle = newangle + MathHelper.cos(idleProgress(obj) * 0.15F);
                neckangle = neckangle + MathHelper.cos(idleProgress(obj) * 0.15F);
                distMult = 0.15F;
                neckdistmult = 0.015F;
            }
        }

        float startAngle = 2.5F;

        this.head1.rotateAngleX = (float) (Math.toRadians(-45F) + -neckangle * neckdistmult * 0.25F);
        this.neck.rotateAngleX = (float) (Math.toRadians(-45F) + -neckangle * neckdistmult);

        this.lArm4.rotateAngleZ = (float) (Math.toRadians(5F) + -newangle * 0.1F) * 0.25F;
        this.lArm5.rotateAngleZ = (float) (Math.toRadians(5F) + -newangle * 0.1F) * 0.25F;
        this.lArm6.rotateAngleZ = (float) (Math.toRadians(5F) + -newangle * 0.1F) * 0.25F;

        this.rArm4.rotateAngleZ = (float) (Math.toRadians(-5F) + -newangle * 0.1F) * 0.25F;
        this.rArm5.rotateAngleZ = (float) (Math.toRadians(-5F) + -newangle * 0.1F) * 0.25F;
        this.rArm6.rotateAngleZ = (float) (Math.toRadians(-5F) + -newangle * 0.1F) * 0.25F;

        this.lTail1.rotateAngleY = (float) (Math.toRadians(startAngle) + newangle * distMult) * 0.5F;
        this.lTail2.rotateAngleY = (float) (Math.toRadians(startAngle) + newangle * distMult) * 0.25F;
        this.lTail3.rotateAngleY = (float) (Math.toRadians(startAngle) + newangle * distMult);
        this.lTail4.rotateAngleY = (float) (Math.toRadians(startAngle) + newangle * distMult);

        this.rTail1.rotateAngleY = (float) (Math.toRadians(-startAngle) + newangle * distMult) * 0.5F;
        this.rTail2.rotateAngleY = (float) (Math.toRadians(-startAngle) + newangle * distMult) * 0.25F;
        this.rTail3.rotateAngleY = (float) (Math.toRadians(-startAngle) + newangle * distMult);
        this.rTail4.rotateAngleY = (float) (Math.toRadians(-startAngle) + newangle * distMult);
    }
}
