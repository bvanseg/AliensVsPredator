package org.alien.client.model.entity.living;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;


public class ModelOvamorph extends Model<EntityOvamorph>
{
    public final ModelRenderer base;
    public final ModelRenderer center;
    public final ModelRenderer lFrontLobe2;
    public final ModelRenderer rFrontLobe2;
    public final ModelRenderer rBackLobe2;
    public final ModelRenderer lBackLobe2;
    public final ModelRenderer lFrontLobe;
    public final ModelRenderer rFrontLobe;
    public final ModelRenderer rBackLobe;
    public final ModelRenderer lBackLobe;

    public ModelOvamorph()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rFrontLobe2 = new ModelRenderer(this, 35, 12);
        this.rFrontLobe2.setRotationPoint(-1.5F, 18.0F, -1.5F);
        this.rFrontLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.lBackLobe2 = new ModelRenderer(this, 22, 18);
        this.lBackLobe2.setRotationPoint(1.5F, 18.0F, 1.5F);
        this.lBackLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.base = new ModelRenderer(this, 0, 15);
        this.base.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.base.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5, 0.0F);
        this.lFrontLobe2 = new ModelRenderer(this, 22, 12);
        this.lFrontLobe2.setRotationPoint(1.5F, 18.0F, -1.5F);
        this.lFrontLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.lFrontLobe = new ModelRenderer(this, 28, 0);
        this.lFrontLobe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFrontLobe.addBox(-1.5F, -3.0F, -0.5F, 2, 2, 2, 0.0F);
        this.rBackLobe = new ModelRenderer(this, 37, 6);
        this.rBackLobe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBackLobe.addBox(-0.5F, -3.0F, -1.5F, 2, 2, 2, 0.0F);
        this.lBackLobe = new ModelRenderer(this, 28, 6);
        this.lBackLobe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBackLobe.addBox(-1.5F, -3.0F, -1.5F, 2, 2, 2, 0.0F);
        this.center = new ModelRenderer(this, 0, 0);
        this.center.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.center.addBox(-3.5F, -6.0F, -3.5F, 7, 5, 7, 0.0F);
        this.rBackLobe2 = new ModelRenderer(this, 35, 18);
        this.rBackLobe2.setRotationPoint(-1.5F, 18.0F, 1.5F);
        this.rBackLobe2.addBox(-1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F);
        this.rFrontLobe = new ModelRenderer(this, 37, 0);
        this.rFrontLobe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFrontLobe.addBox(-0.5F, -3.0F, -0.5F, 2, 2, 2, 0.0F);
        this.lFrontLobe2.addChild(this.lFrontLobe);
        this.rBackLobe2.addChild(this.rBackLobe);
        this.lBackLobe2.addChild(this.lBackLobe);
        this.rFrontLobe2.addChild(this.rFrontLobe);
    }

    @Override
    public void render(EntityOvamorph ovamorph)
    {

        if (ovamorph != null)
        {
            float progressPrev = ovamorph.renderOpenProgress;
            ovamorph.renderOpenProgress = ovamorph.openProgress.get();
            ovamorph.renderOpenProgress = progressPrev + (ovamorph.renderOpenProgress - progressPrev) * ClientGame.instance.partialTicks();

            float openAngle = 37.5F;
            float rotateAngle = openAngle * (ovamorph.renderOpenProgress / EntityOvamorph.MAX_OPEN_PROGRESS);
            float rotation = (float) Math.toRadians(rotateAngle);

            this.lFrontLobe2.rotateAngleX = rotation;
            this.lFrontLobe2.rotateAngleZ = rotation;
            this.lFrontLobe.rotateAngleX = rotation * 0.45F;
            this.lFrontLobe.rotateAngleZ = rotation * 0.45F;

            this.rFrontLobe2.rotateAngleX = rotation;
            this.rFrontLobe2.rotateAngleZ = -rotation;
            this.rFrontLobe.rotateAngleX = rotation * 0.45F;
            this.rFrontLobe.rotateAngleZ = -rotation * 0.45F;

            this.rBackLobe2.rotateAngleX = -rotation;
            this.rBackLobe2.rotateAngleZ = -rotation;
            this.rBackLobe.rotateAngleX = -rotation * 0.45F;
            this.rBackLobe.rotateAngleZ = -rotation * 0.45F;

            this.lBackLobe2.rotateAngleX = -rotation;
            this.lBackLobe2.rotateAngleZ = rotation;
            this.lBackLobe.rotateAngleX = -rotation * 0.45F;
            this.lBackLobe.rotateAngleZ = rotation * 0.45F;
        }

        draw(this.rFrontLobe2);
        draw(this.lBackLobe2);
        draw(this.base);
        draw(this.lFrontLobe2);
        draw(this.center);
        draw(this.rBackLobe2);
    }
}
