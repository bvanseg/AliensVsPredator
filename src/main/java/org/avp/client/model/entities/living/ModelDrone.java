package org.avp.client.model.entities.living;

import com.arisux.mdxlib.lib.client.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;


public class ModelDrone extends Model
{
    public ModelRenderer body1, body2, rightleg1, leftleg1, leftleg2, rightleg2, leftleg3, rightleg3, leftleg4, rightleg4, leftarm1, rightarm1, leftarm2, rightarm2, neck, head1, head2, head3, head4, head5, leftarm3, rightarm3, leftarm4, rightarm4, back1, back2, tail2, tail3, stabber, tail4, tail5, head6, tailSpikes5, tailSpikes4, tailSpikes3, tailSpikes2, tail1, tailSpikes1, backhorn1, backhorn2, backhorn3, backhorn4;

    public ModelDrone()
    {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.body1 = new ModelRenderer(this, 0, 46);
        this.body1.addBox(-4.5F, -2.0F, 0.0F, 9, 8, 10);
        this.body1.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.body1.setTextureSize(64, 32);
        this.body1.mirror = true;
        this.setRotation(this.body1, -0.1919862F, 0.0F, 0.0F);
        this.body2 = new ModelRenderer(this, 0, 27);
        this.body2.addBox(-3.5F, -5.0F, 8.0F, 7, 6, 12);
        this.body2.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.body2.setTextureSize(64, 32);
        this.body2.mirror = true;
        this.setRotation(this.body2, -0.5585054F, 0.0F, 0.0F);
        this.rightleg1 = new ModelRenderer(this, 59, 45);
        this.rightleg1.addBox(-1.5F, -4.0F, -2.5F, 4, 14, 5);
        this.rightleg1.setRotationPoint(-4.5F, 7.0F, 3.0F);
        this.rightleg1.setTextureSize(64, 32);
        this.rightleg1.mirror = true;
        this.setRotation(this.rightleg1, -0.8028515F, 0.2443461F, 0.418879F);
        this.leftleg1 = new ModelRenderer(this, 40, 45);
        this.leftleg1.addBox(-2.5F, -4.0F, -2.5F, 4, 14, 5);
        this.leftleg1.setRotationPoint(4.5F, 7.0F, 3.0F);
        this.leftleg1.setTextureSize(64, 32);
        this.leftleg1.mirror = true;
        this.setRotation(this.leftleg1, -0.8028515F, -0.2443461F, -0.418879F);
        this.leftleg2 = new ModelRenderer(this, 79, 49);
        this.leftleg2.addBox(-2.0F, 8.0F, -5.5F, 3, 3, 12);
        this.leftleg2.setRotationPoint(4.5F, 7.0F, 3.0F);
        this.leftleg2.setTextureSize(64, 32);
        this.leftleg2.mirror = true;
        this.setRotation(this.leftleg2, -0.4014257F, -0.2443461F, -0.418879F);
        this.rightleg2 = new ModelRenderer(this, 79, 33);
        this.rightleg2.addBox(-1.0F, 8.0F, -5.5F, 3, 3, 12);
        this.rightleg2.setRotationPoint(-4.5F, 7.0F, 3.0F);
        this.rightleg2.setTextureSize(64, 32);
        this.rightleg2.mirror = true;
        this.setRotation(this.rightleg2, -0.4014257F, 0.2443461F, 0.418879F);
        this.leftleg3 = new ModelRenderer(this, 113, 40);
        this.leftleg3.addBox(-1.5F, 5.5F, 9.0F, 2, 9, 2);
        this.leftleg3.setRotationPoint(4.5F, 7.0F, 3.0F);
        this.leftleg3.setTextureSize(64, 32);
        this.leftleg3.mirror = true;
        this.setRotation(this.leftleg3, -0.8028515F, -0.2443461F, -0.418879F);
        this.rightleg3 = new ModelRenderer(this, 113, 53);
        this.rightleg3.addBox(-0.5F, 5.5F, 9.0F, 2, 9, 2);
        this.rightleg3.setRotationPoint(-4.5F, 7.0F, 3.0F);
        this.rightleg3.setTextureSize(64, 32);
        this.rightleg3.mirror = true;
        this.setRotation(this.rightleg3, -0.8028515F, 0.2443461F, 0.418879F);
        this.leftleg4 = new ModelRenderer(this, 110, 24);
        this.leftleg4.addBox(5.0F, 15.0F, -8.0F, 2, 2, 5);
        this.leftleg4.setRotationPoint(4.5F, 7.0F, 4.0F);
        this.leftleg4.setTextureSize(64, 32);
        this.leftleg4.mirror = true;
        this.setRotation(this.leftleg4, 0.0F, -0.2443461F, 0.0F);
        this.rightleg4 = new ModelRenderer(this, 95, 24);
        this.rightleg4.addBox(-7.0F, 15.0F, -8.0F, 2, 2, 5);
        this.rightleg4.setRotationPoint(-4.5F, 7.0F, 4.0F);
        this.rightleg4.setTextureSize(64, 32);
        this.rightleg4.mirror = true;
        this.setRotation(this.rightleg4, 0.0F, 0.2443461F, 0.0F);
        this.leftarm1 = new ModelRenderer(this, 40, 29);
        this.leftarm1.addBox(-1.0F, -1.0F, -1.0F, 2, 13, 2);
        this.leftarm1.setRotationPoint(4.5F, 0.0F, -10.0F);
        this.leftarm1.setTextureSize(64, 32);
        this.leftarm1.mirror = true;
        this.setRotation(this.leftarm1, 0.3665191F, 0.0F, -0.5934119F);
        this.rightarm1 = new ModelRenderer(this, 50, 29);
        this.rightarm1.addBox(-1.0F, -1.0F, -1.0F, 2, 13, 2);
        this.rightarm1.setRotationPoint(-4.5F, 0.0F, -10.0F);
        this.rightarm1.setTextureSize(64, 32);
        this.rightarm1.mirror = true;
        this.setRotation(this.rightarm1, 0.3665191F, 0.0F, 0.5934119F);
        this.leftarm2 = new ModelRenderer(this, 83, 24);
        this.leftarm2.addBox(-1.0F, 11.0F, -13.5F, 2, 1, 3);
        this.leftarm2.setRotationPoint(4.5F, 0.0F, -10.0F);
        this.leftarm2.setTextureSize(64, 32);
        this.leftarm2.mirror = true;
        this.setRotation(this.leftarm2, 0.3665191F, 0.0F, -0.5934119F);
        this.rightarm2 = new ModelRenderer(this, 98, 9);
        this.rightarm2.addBox(-1.0F, 10.5F, -10.5F, 2, 2, 11);
        this.rightarm2.setRotationPoint(-4.5F, 0.0F, -10.0F);
        this.rightarm2.setTextureSize(64, 32);
        this.rightarm2.mirror = true;
        this.setRotation(this.rightarm2, 0.3665191F, 0.0F, 0.5934119F);
        this.neck = new ModelRenderer(this, 23, 86);
        this.neck.addBox(-2.0F, -2.0F, -4.0F, 4, 6, 5);
        this.neck.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.neck.setTextureSize(64, 32);
        this.neck.mirror = true;
        this.setRotation(this.neck, -0.1919862F, 0.0F, 0.0F);
        this.head1 = new ModelRenderer(this, 0, 0);
        this.head1.addBox(-2.5F, -5.0F, -3.0F, 5, 10, 5);
        this.head1.setRotationPoint(0.0F, -2.5F, -17.0F);
        this.head1.setTextureSize(64, 32);
        this.head1.mirror = true;
        this.setRotation(this.head1, -((float) Math.PI / 5F), 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 34, 0);
        this.head2.addBox(-2.51F, 3.0F, -5.0F, 3, 3, 5);
        this.head2.setRotationPoint(0.0F, -2.5F, -17.0F);
        this.head2.setTextureSize(64, 32);
        this.head2.mirror = true;
        this.setRotation(this.head2, -0.122173F, 0.0F, 0.0F);
        this.head3 = new ModelRenderer(this, 51, 10);
        this.head3.addBox(-2.5F, 2.8F, -5.0F, 5, 3, 4);
        this.head3.setRotationPoint(0.0F, -2.5F, -17.0F);
        this.head3.setTextureSize(64, 32);
        this.head3.mirror = true;
        this.setRotation(this.head3, 0.122173F, 0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 52, 20);
        this.head4.addBox(-1.5F, 4.1F, -6.1F, 3, 2, 5);
        this.head4.setRotationPoint(0.0F, -2.5F, -17.0F);
        this.head4.setTextureSize(64, 32);
        this.head4.mirror = true;
        this.setRotation(this.head4, 0.122173F, 0.0F, 0.0F);
        this.head5 = new ModelRenderer(this, 28, 10);
        this.head5.addBox(-2.5F, -14.0F, -4.2F, 5, 10, 5);
        this.head5.setRotationPoint(0.0F, -2.5F, -17.0F);
        this.head5.setTextureSize(64, 32);
        this.head5.mirror = true;
        this.setRotation(this.head5, -0.9075712F, 0.0F, 0.0F);
        this.leftarm3 = new ModelRenderer(this, 71, 9);
        this.leftarm3.addBox(-1.0F, 10.5F, -10.5F, 2, 2, 11);
        this.leftarm3.setRotationPoint(4.5F, 0.0F, -10.0F);
        this.leftarm3.setTextureSize(64, 32);
        this.leftarm3.mirror = true;
        this.setRotation(this.leftarm3, 0.3665191F, 0.0F, -0.5934119F);
        this.rightarm3 = new ModelRenderer(this, 72, 24);
        this.rightarm3.addBox(-1.0F, 11.0F, -13.5F, 2, 1, 3);
        this.rightarm3.setRotationPoint(-4.5F, 0.0F, -10.0F);
        this.rightarm3.setTextureSize(64, 32);
        this.rightarm3.mirror = true;
        this.setRotation(this.rightarm3, 0.3665191F, 0.0F, 0.5934119F);
        this.leftarm4 = new ModelRenderer(this, 60, 30);
        this.leftarm4.addBox(-2.0F, 11.5F, -16.5F, 3, 0, 6);
        this.leftarm4.setRotationPoint(4.5F, 0.0F, -10.0F);
        this.leftarm4.setTextureSize(64, 32);
        this.leftarm4.mirror = true;
        this.setRotation(this.leftarm4, 0.3665191F, 0.0F, -0.5934119F);
        this.rightarm4 = new ModelRenderer(this, 60, 38);
        this.rightarm4.addBox(-1.0F, 11.5F, -16.5F, 3, 0, 6);
        this.rightarm4.setRotationPoint(-4.5F, 0.0F, -10.0F);
        this.rightarm4.setTextureSize(64, 32);
        this.rightarm4.mirror = true;
        this.setRotation(this.rightarm4, 0.3665191F, 0.0F, 0.5934119F);
        this.back1 = new ModelRenderer(this, 0, 65);
        this.back1.addBox(0.0F, -10.0F, 0.0F, 0, 8, 10);
        this.back1.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.back1.setTextureSize(64, 32);
        this.back1.mirror = true;
        this.setRotation(this.back1, -0.1919862F, 0.0F, 0.0F);
        this.back2 = new ModelRenderer(this, 23, 65);
        this.back2.addBox(0.0F, -11.0F, 8.0F, 0, 6, 12);
        this.back2.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.back2.setTextureSize(64, 32);
        this.back2.mirror = true;
        this.setRotation(this.back2, -0.5585054F, 0.0F, 0.0F);
        this.head6 = new ModelRenderer(this, 53, 0);
        this.head6.addBox(-0.499F, 3.0F, -5.0F, 3, 3, 5);
        this.head6.setRotationPoint(0.0F, -2.5F, -17.0F);
        this.head6.setTextureSize(64, 32);
        this.head6.mirror = true;
        this.setRotation(this.head6, -0.122173F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 50, 66);
        this.tail1.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 11);
        this.tail1.setRotationPoint(0.0F, 6.5F, 5.5F);
        this.tail1.setTextureSize(64, 32);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, -0.4014257F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 85, 66);
        this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 4, 11);
        this.tail2.setRotationPoint(0.0F, 9.5F, 29.5F);
        this.tail2.setTextureSize(64, 32);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, -((float) Math.PI / 10F), 0.0F, 0.0F);
        this.tail3 = new ModelRenderer(this, 118, 66);
        this.tail3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 11);
        this.tail3.setRotationPoint(0.0F, 13.5F, 30.5F);
        this.tail3.setTextureSize(64, 32);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, -0.2094395F, 0.0F, 0.0F);
        this.tail4 = new ModelRenderer(this, 149, 66);
        this.tail4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 11);
        this.tail4.setRotationPoint(0.0F, 15.5F, 40.5F);
        this.tail4.setTextureSize(64, 32);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, -0.1396263F, 0.0F, 0.0F);
        this.tail5 = new ModelRenderer(this, 178, 66);
        this.tail5.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 11);
        this.tail5.setRotationPoint(0.0F, 17.5F, 50.5F);
        this.tail5.setTextureSize(64, 32);
        this.tail5.mirror = true;
        this.setRotation(this.tail5, -0.0523599F, 0.0F, 0.0F);
        this.tailSpikes5 = new ModelRenderer(this, 178, 96);
        this.tailSpikes5.addBox(0.0F, -1.5F, 0.0F, 0, 3, 11);
        this.tailSpikes5.setRotationPoint(0.0F, 17.5F, 51.5F);
        this.tailSpikes5.setTextureSize(64, 32);
        this.tailSpikes5.mirror = true;
        this.setRotation(this.tailSpikes5, -0.0523599F, 0.0F, 0.0F);
        this.tailSpikes4 = new ModelRenderer(this, 149, 96);
        this.tailSpikes4.addBox(0.0F, -2.0F, 0.0F, 0, 4, 10);
        this.tailSpikes4.setRotationPoint(0.0F, 15.5F, 41.5F);
        this.tailSpikes4.setTextureSize(64, 32);
        this.tailSpikes4.mirror = true;
        this.setRotation(this.tailSpikes4, -0.1396263F, 0.0F, 0.0F);
        this.tailSpikes3 = new ModelRenderer(this, 118, 94);
        this.tailSpikes3.addBox(0.0F, -3.0F, 0.0F, 0, 6, 10);
        this.tailSpikes3.setRotationPoint(0.0F, 13.5F, 31.5F);
        this.tailSpikes3.setTextureSize(64, 32);
        this.tailSpikes3.mirror = true;
        this.setRotation(this.tailSpikes3, -0.2094395F, 0.0F, 0.0F);
        this.tailSpikes2 = new ModelRenderer(this, 90, 93);
        this.tailSpikes2.addBox(0.0F, -3.5F, 0.0F, 0, 8, 11);
        this.tailSpikes2.setRotationPoint(0.0F, 9.5F, 20.5F);
        this.tailSpikes2.setTextureSize(64, 32);
        this.tailSpikes2.mirror = true;
        this.setRotation(this.tailSpikes2, -((float) Math.PI / 10F), 0.0F, 0.0F);
        this.tailSpikes1 = new ModelRenderer(this, 58, 93);
        this.tailSpikes1.addBox(0.0F, -4.5F, 0.0F, 0, 8, 11);
        this.tailSpikes1.setRotationPoint(0.0F, 6.5F, 5.5F);
        this.tailSpikes1.setTextureSize(64, 32);
        this.tailSpikes1.mirror = true;
        this.setRotation(this.tailSpikes1, -0.4014257F, 0.0F, 0.0F);
        this.stabber = new ModelRenderer(this, 205, 66);
        this.stabber.addBox(-1.5F, 0.0F, 0.0F, 3, 0, 11);
        this.stabber.setRotationPoint(0.0F, 18.5F, 61.5F);
        this.stabber.setTextureSize(64, 32);
        this.stabber.mirror = true;
        this.setRotation(this.stabber, -0.0523599F, 0.0F, 0.0F);
        this.backhorn1 = new ModelRenderer(this, 10, 86);
        this.backhorn1.addBox(-4.5F, -11.0F, 7.0F, 2, 9, 2);
        this.backhorn1.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.backhorn1.setTextureSize(64, 32);
        this.backhorn1.mirror = true;
        this.setRotation(this.backhorn1, -0.1919862F, 0.0F, -0.1745329F);
        this.backhorn2 = new ModelRenderer(this, 0, 86);
        this.backhorn2.addBox(2.5F, -11.0F, 7.0F, 2, 9, 2);
        this.backhorn2.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.backhorn2.setTextureSize(64, 32);
        this.backhorn2.mirror = true;
        this.setRotation(this.backhorn2, -0.1919862F, 0.0F, 0.1745329F);
        this.backhorn3 = new ModelRenderer(this, 9, 86);
        this.backhorn3.addBox(-3.5F, -14.0F, 10.0F, 2, 9, 2);
        this.backhorn3.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.backhorn3.setTextureSize(64, 32);
        this.backhorn3.mirror = true;
        this.setRotation(this.backhorn3, -0.5585054F, 0.0F, -0.1745329F);
        this.backhorn4 = new ModelRenderer(this, 0, 86);
        this.backhorn4.addBox(1.5F, -14.0F, 10.0F, 2, 9, 2);
        this.backhorn4.setRotationPoint(0.0F, -2.5F, -13.0F);
        this.backhorn4.setTextureSize(64, 32);
        this.backhorn4.mirror = true;
        this.setRotation(this.backhorn4, -0.5585054F, 0.0F, 0.1745329F);
    }

    @Override
    public void render(Object obj)
    {
        EntityLivingBase base = (EntityLivingBase) obj;
        
        float newangle = MathHelper.cos(idleProgress(obj) * 4.0F * 0.1F) * (float) Math.PI * 0.5F * swingProgressPrev(obj);
        float distMult = 0.25F;

        if (base != null && base.prevPosX == base.posX && base.prevPosY == base.posY && base.prevPosZ == base.posZ)
        {
            newangle = MathHelper.cos(idleProgress(obj) * 0.07F);
            distMult = 0.95F;
        }

        this.doTail(newangle, distMult);
        this.head1.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.head2.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.head3.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.head4.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.head5.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.head6.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.leftleg1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.leftleg2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.4014257F;
        this.leftleg3.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.leftleg4.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj);
        this.rightleg1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.rightleg2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) - 0.4014257F;
        this.rightleg3.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) - 0.8028515F;
        this.rightleg4.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj);
        this.rightarm1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.rightarm2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.rightarm3.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.rightarm4.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.leftarm1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.leftarm2.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.leftarm3.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;
        this.leftarm4.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj) + 0.3665191F;

        draw(body1);
        draw(body2);
        draw(rightleg1);
        draw(leftleg1);
        draw(leftleg2);
        draw(rightleg2);
        draw(leftleg3);
        draw(rightleg3);
        draw(leftleg4);
        draw(rightleg4);
        draw(leftarm1);
        draw(rightarm1);
        draw(leftarm2);
        draw(rightarm2);
        draw(neck);
        draw(head1);
        draw(head2);
        draw(head3);
        draw(head4);
        draw(head5);
        draw(head6);
        draw(leftarm3);
        draw(rightarm3);
        draw(leftarm4);
        draw(rightarm4);
        draw(back1);
        draw(back2);
        draw(tail1);
        draw(tail2);
        draw(tail3);
        draw(tail4);
        draw(tail5);
        draw(tailSpikes1);
        draw(tailSpikes2);
        draw(tailSpikes3);
        draw(tailSpikes4);
        draw(tailSpikes5);
        draw(stabber);
        draw(backhorn1);
        draw(backhorn2);
        draw(backhorn3);
        draw(backhorn4);
    }

    private void doTail(float angle, float distMult)
    {
        float multiplier = 0.25F;
        this.tail1.rotateAngleY = angle / 1.5F;
        this.tailSpikes1.rotateAngleY = angle / 1.5F;
        this.tail2.rotateAngleY = angle * multiplier;
        this.tail2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 10.0F;
        this.tail2.rotationPointX = this.tail1.rotationPointX + (float) Math.sin(this.tail1.rotateAngleY) * 10.0F;
        this.tailSpikes2.rotateAngleY = angle * multiplier;
        this.tailSpikes2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 10.0F;
        this.tailSpikes2.rotationPointX = this.tail1.rotationPointX + (float) Math.sin(this.tail1.rotateAngleY) * 10.0F;
        multiplier = multiplier + distMult;
        this.tail3.rotateAngleY = angle * multiplier;
        this.tail3.rotationPointZ = this.tail2.rotationPointZ + (float) Math.cos(this.tail2.rotateAngleY) * 10.0F;
        this.tail3.rotationPointX = this.tail2.rotationPointX + (float) Math.sin(this.tail2.rotateAngleY) * 10.0F;
        this.tailSpikes3.rotateAngleY = angle * multiplier;
        this.tailSpikes3.rotationPointZ = this.tail2.rotationPointZ + (float) Math.cos(this.tail2.rotateAngleY) * 10.0F;
        this.tailSpikes3.rotationPointX = this.tail2.rotationPointX + (float) Math.sin(this.tail2.rotateAngleY) * 10.0F;
        multiplier = multiplier + distMult;
        this.tail4.rotateAngleY = angle * multiplier;
        this.tail4.rotationPointZ = this.tail3.rotationPointZ + (float) Math.cos(this.tail3.rotateAngleY) * 10.0F;
        this.tail4.rotationPointX = this.tail3.rotationPointX + (float) Math.sin(this.tail3.rotateAngleY) * 10.0F;
        this.tailSpikes4.rotateAngleY = angle * multiplier;
        this.tailSpikes4.rotationPointZ = this.tail3.rotationPointZ + (float) Math.cos(this.tail3.rotateAngleY) * 10.0F;
        this.tailSpikes4.rotationPointX = this.tail3.rotationPointX + (float) Math.sin(this.tail3.rotateAngleY) * 10.0F;
        multiplier = multiplier + distMult;
        this.tail5.rotateAngleY = angle * multiplier;
        this.tail5.rotationPointZ = this.tail4.rotationPointZ + (float) Math.cos(this.tail4.rotateAngleY) * 10.0F;
        this.tail5.rotationPointX = this.tail4.rotationPointX + (float) Math.sin(this.tail4.rotateAngleY) * 10.0F;
        this.tailSpikes5.rotateAngleY = angle * multiplier;
        this.tailSpikes5.rotationPointZ = this.tail4.rotationPointZ + (float) Math.cos(this.tail4.rotateAngleY) * 10.0F;
        this.tailSpikes5.rotationPointX = this.tail4.rotationPointX + (float) Math.sin(this.tail4.rotateAngleY) * 10.0F;
        multiplier = multiplier + distMult;
        this.stabber.rotateAngleY = angle * multiplier;
        this.stabber.rotationPointZ = this.tail5.rotationPointZ + (float) Math.cos(this.tail5.rotateAngleY) * 10.0F;
        this.stabber.rotationPointX = this.tail5.rotationPointX + (float) Math.sin(this.tail5.rotateAngleY) * 10.0F;
    }
}
