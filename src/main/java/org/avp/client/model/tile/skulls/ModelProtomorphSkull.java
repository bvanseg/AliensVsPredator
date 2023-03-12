package org.avp.client.model.tile.skulls;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.avp.common.tile.TileEntitySkull;

public class ModelProtomorphSkull extends Model<TileEntitySkull>
{
    public ModelRenderer head1;
    public ModelRenderer head2;
    public ModelRenderer face1;
    public ModelRenderer jawUpper;
    public ModelRenderer jawLower;
    public ModelRenderer face2;
    public ModelRenderer jawLower2;
    public ModelRenderer innerJaw;

    public ModelProtomorphSkull()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.head1 = new ModelRenderer(this, 83, 47);
        this.head1.setRotationPoint(0.0F, 23.4F, -2.5F);
        this.head1.addBox(-2.0F, -4.1F, -3.3F, 4, 4, 8, 0.0F);
        this.setRotation(head1, 0.06981317007977318F, 0.0F, 0.0F);
        this.face1 = new ModelRenderer(this, 144, 50);
        this.face1.setRotationPoint(0.1F, -2.8F, -2.0F);
        this.face1.addBox(-2.25F, -1.9F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotation(face1, 0.7740535232594852F, 0.0F, 0.0F);
        this.face2 = new ModelRenderer(this, 161, 50);
        this.face2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.face2.addBox(0.05F, -1.9F, -3.0F, 2, 2, 3, 0.0F);
        this.innerJaw = new ModelRenderer(this, 155, 60);
        this.innerJaw.setRotationPoint(0.0F, -0.4F, 0.0F);
        this.innerJaw.addBox(-1.0F, -1.0F, -2.8F, 2, 2, 5, 0.0F);
        this.setRotation(innerJaw, 0.22759093446006054F, 0.0F, 0.0F);
        this.jawUpper = new ModelRenderer(this, 184, 51);
        this.jawUpper.setRotationPoint(0.0F, -0.6F, -2.4F);
        this.jawUpper.addBox(-2.0F, -1.5F, -3.1F, 4, 2, 3, 0.0F);
        this.jawLower = new ModelRenderer(this, 184, 61);
        this.jawLower.setRotationPoint(0.0F, -1.1F, -2.4F);
        this.jawLower.addBox(-1.8F, 0.3F, -3.0F, 3, 1, 3, 0.0F);
        this.setRotation(jawLower, 0.045553093477052F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 112, 47);
        this.head2.setRotationPoint(0.0F, -2.13F, 4.7F);
        this.head2.addBox(-2.0F, -1.88F, -0.63F, 4, 4, 7, 0.0F);
        this.setRotation(head2, -0.27314402793711257F, 0.0F, 0.0F);
        this.jawLower2 = new ModelRenderer(this, 203, 61);
        this.jawLower2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.jawLower2.addBox(0.86F, 0.3F, -3.0F, 1, 1, 3, 0.0F);
        this.head1.addChild(this.face1);
        this.face1.addChild(this.face2);
        this.jawLower.addChild(this.innerJaw);
        this.head1.addChild(this.jawUpper);
        this.head1.addChild(this.jawLower);
        this.head1.addChild(this.head2);
        this.jawLower.addChild(this.jawLower2);
    }

    @Override
    public void render(TileEntitySkull obj)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.head1.offsetX, this.head1.offsetY, this.head1.offsetZ);
        GlStateManager.translate(this.head1.rotationPointX * Model.DEFAULT_SCALE, this.head1.rotationPointY * Model.DEFAULT_SCALE, this.head1.rotationPointZ * Model.DEFAULT_SCALE);
        GlStateManager.scale(1.1D, 1.1D, 1.0D);
        GlStateManager.translate(-this.head1.offsetX, -this.head1.offsetY, -this.head1.offsetZ);
        GlStateManager.translate(-this.head1.rotationPointX * Model.DEFAULT_SCALE, -this.head1.rotationPointY * Model.DEFAULT_SCALE, -this.head1.rotationPointZ * Model.DEFAULT_SCALE);
        this.head1.render(Model.DEFAULT_SCALE);
        GlStateManager.popMatrix();
    }
}
