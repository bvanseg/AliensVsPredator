package org.avp.client.model.entities.living;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.avp.common.entities.living.vardic.EntityGooMutant;


public class ModelGooMutant extends Model<EntityGooMutant>
{
    public ModelRenderer headOverlay;
    public ModelRenderer rArm;
    public ModelRenderer lLeg;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer lArm;
    public ModelRenderer rLeg;
    public ModelRenderer head2;
    public ModelRenderer head3;
    public ModelRenderer lspike;
    public ModelRenderer rspike;
    public ModelRenderer spines;
    public int           heldItemLeft;
    public int           heldItemRight;
    public boolean       isSneak;

    public ModelGooMutant()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.headOverlay = new ModelRenderer(this, 32, 0);
        this.headOverlay.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headOverlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.rLeg = new ModelRenderer(this, 0, 16);
        this.rLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.rLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.spines = new ModelRenderer(this, 0, 48);
        this.spines.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spines.addBox(0.0F, 0.7F, 2.0F, 0, 10, 2, 0.0F);
        this.head3 = new ModelRenderer(this, 67, 13);
        this.head3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head3.addBox(-3.0F, -8.6F, 5.4F, 6, 6, 4, 0.0F);
        this.setRotation(head3, -0.18203784098300857F, 0.0F, 0.0F);
        this.rArm = new ModelRenderer(this, 40, 16);
        this.rArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.rArm.addBox(-2.9F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.lspike = new ModelRenderer(this, 0, 36);
        this.lspike.mirror = true;
        this.lspike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lspike.addBox(2.5F, 0.8F, 1.1F, 0, 5, 7, 0.0F);
        this.setRotation(lspike, 0.0F, 0.22759093446006054F, 0.0F);
        this.rspike = new ModelRenderer(this, 0, 36);
        this.rspike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rspike.addBox(-2.5F, 0.8F, 1.1F, 0, 5, 7, 0.0F);
        this.setRotation(rspike, 0.0F, -0.22759093446006054F, 0.0F);
        this.lLeg = new ModelRenderer(this, 0, 16);
        this.lLeg.mirror = true;
        this.lLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.lLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.lArm = new ModelRenderer(this, 40, 16);
        this.lArm.mirror = true;
        this.lArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.lArm.addBox(-1.1F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head2 = new ModelRenderer(this, 67, 0);
        this.head2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head2.addBox(-3.5F, -8.2F, 3.2F, 7, 7, 3, 0.0F);
        this.setRotation(head2, -0.091106186954104F, 0.0F, 0.0F);
        this.body.addChild(this.spines);
        this.head.addChild(this.head3);
        this.body.addChild(this.lspike);
        this.body.addChild(this.rspike);
        this.head.addChild(this.head2);
    }

    @Override
    public void render(EntityGooMutant obj)
    {
        EntityLivingBase base = (EntityLivingBase) obj;

        this.head.rotateAngleY = headYaw(obj) / (180F / (float) Math.PI);
        this.head.rotateAngleX = headPitch(obj) / (180F / (float) Math.PI);
        this.headOverlay.rotateAngleY = this.head.rotateAngleY;
        this.headOverlay.rotateAngleX = this.head.rotateAngleX;
        this.rArm.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 2.0F * swingProgressPrev(obj) * 0.5F;
        this.lArm.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 2.0F * swingProgressPrev(obj) * 0.5F;
        this.rArm.rotateAngleZ = 0.0F;
        this.lArm.rotateAngleZ = 0.0F;
        this.rLeg.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj);
        this.lLeg.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.4F * swingProgressPrev(obj);
        this.rLeg.rotateAngleY = 0.0F;
        this.lLeg.rotateAngleY = 0.0F;

        if (this.isRiding)
        {
            this.rArm.rotateAngleX += -((float) Math.PI / 5F);
            this.lArm.rotateAngleX += -((float) Math.PI / 5F);
            this.rLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
            this.lLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
            this.rLeg.rotateAngleY = ((float) Math.PI / 10F);
            this.lLeg.rotateAngleY = -((float) Math.PI / 10F);
        }

        if (this.heldItemLeft != 0)
        {
            this.lArm.rotateAngleX = this.lArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * this.heldItemLeft;
        }

        if (this.heldItemRight != 0)
        {
            this.rArm.rotateAngleX = this.rArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F) * this.heldItemRight;
        }

        this.rArm.rotateAngleY = 0.0F;
        this.lArm.rotateAngleY = 0.0F;
        float var8;
        float var9;

        if (this.swingProgress > -9990.0F)
        {
            var8 = this.swingProgress;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(var8) * (float) Math.PI * 2.0F) * 0.2F;
            this.rArm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.rArm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.lArm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.lArm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.rArm.rotateAngleY += this.body.rotateAngleY;
            this.lArm.rotateAngleY += this.body.rotateAngleY;
            this.lArm.rotateAngleX += this.body.rotateAngleY;
            var8 = 1.0F - this.swingProgress;
            var8 *= var8;
            var8 *= var8;
            var8 = 1.0F - var8;
            var9 = MathHelper.sin(var8 * (float) Math.PI);
            float var10 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            this.rArm.rotateAngleX = (float) (this.rArm.rotateAngleX - (var9 * 1.2D + var10));
            this.rArm.rotateAngleY += this.body.rotateAngleY * 2.0F;
            this.rArm.rotateAngleZ = MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
        }

        this.body.rotateAngleX = 0.0F;
        this.rLeg.rotationPointZ = 0.1F;
        this.lLeg.rotationPointZ = 0.1F;
        this.rLeg.rotationPointY = 12.0F;
        this.lLeg.rotationPointY = 12.0F;
        this.head.rotationPointY = 0.0F;
        this.headOverlay.rotationPointY = 0.0F;

        this.rArm.rotateAngleZ += MathHelper.cos(idleProgress(obj) * 0.09F) * 0.05F + 0.05F;
        this.lArm.rotateAngleZ -= MathHelper.cos(idleProgress(obj) * 0.09F) * 0.05F + 0.05F;
        this.rArm.rotateAngleX += MathHelper.sin(idleProgress(obj) * 0.067F) * 0.05F;
        this.lArm.rotateAngleX -= MathHelper.sin(idleProgress(obj) * 0.067F) * 0.05F;

        draw(head);
        draw(body);
        draw(rArm);
        draw(lArm);
        draw(rLeg);
        draw(lLeg);
        draw(headOverlay);
    }
}
