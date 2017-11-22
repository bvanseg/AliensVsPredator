package org.avp.client.model.tile.rackmodules;

import com.arisux.mdx.lib.client.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelNetworkModuleRack extends Model
{
    public ModelRenderer frame1;
    public ModelRenderer frame2;
    public ModelRenderer frame3;
    public ModelRenderer frame4;
    public ModelRenderer rLattice;
    public ModelRenderer lLattice;
    public ModelRenderer upperFrameF;
    public ModelRenderer upperFrameB;
    public ModelRenderer upperFrameR;
    public ModelRenderer upperFrameL;
    public ModelRenderer lowerFrameR;
    public ModelRenderer LowerFrameL;
    public ModelRenderer lowerFrameF;
    public ModelRenderer lowerFrameB;
    public ModelRenderer light1;
    public ModelRenderer light2;
    public ModelRenderer shelf1;
    public ModelRenderer shelf2;
    public ModelRenderer shelf3;
    public ModelRenderer shelf4;

    public ModelNetworkModuleRack()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.LowerFrameL = new ModelRenderer(this, 90, 10);
        this.LowerFrameL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LowerFrameL.addBox(18.0F, 22.3F, -7.5F, 1, 1, 15, 0.0F);
        this.lLattice = new ModelRenderer(this, 20, -15);
        this.lLattice.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lLattice.addBox(18.7F, -21.5F, -7.5F, 0, 44, 15, 0.0F);
        this.upperFrameR = new ModelRenderer(this, 55, 10);
        this.upperFrameR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperFrameR.addBox(-7.5F, -22.5F, -7.5F, 1, 1, 15, 0.0F);
        this.upperFrameF = new ModelRenderer(this, 55, 5);
        this.upperFrameF.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperFrameF.addBox(-7.8F, -22.5F, -7.5F, 27, 1, 1, 0.0F);
        this.shelf3 = new ModelRenderer(this, 8, 50);
        this.shelf3.setRotationPoint(8.0F, 0.5F, 0.0F);
        this.shelf3.addBox(-15.0F, -0.5F, -6.0F, 25, 1, 12, 0.0F);
        this.rLattice = new ModelRenderer(this, 20, -15);
        this.rLattice.mirror = true;
        this.rLattice.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rLattice.addBox(-7.1F, -21.5F, -7.5F, 0, 44, 15, 0.0F);
        this.light1 = new ModelRenderer(this, 100, 0);
        this.light1.setRotationPoint(-7.0F, -1.5F, -7.3F);
        this.light1.addBox(-0.5F, -0.5F, -1.0F, 1, 2, 1, 0.0F);
        this.frame1 = new ModelRenderer(this, 0, 0);
        this.frame1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frame1.addBox(-8.0F, -23.0F, -8.0F, 2, 47, 2, 0.0F);
        this.light2 = new ModelRenderer(this, 100, 0);
        this.light2.mirror = true;
        this.light2.setRotationPoint(18.5F, -1.5F, -7.3F);
        this.light2.addBox(-0.5F, -0.5F, -1.0F, 1, 2, 1, 0.0F);
        this.lowerFrameF = new ModelRenderer(this, 55, 35);
        this.lowerFrameF.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerFrameF.addBox(-7.8F, 22.3F, -7.5F, 27, 1, 1, 0.0F);
        this.shelf2 = new ModelRenderer(this, 8, 50);
        this.shelf2.setRotationPoint(8.0F, 11.5F, 0.0F);
        this.shelf2.addBox(-15.0F, -0.5F, -6.0F, 25, 1, 12, 0.0F);
        this.frame3 = new ModelRenderer(this, 0, 0);
        this.frame3.mirror = true;
        this.frame3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frame3.addBox(17.5F, -23.0F, -8.0F, 2, 47, 2, 0.0F);
        this.frame4 = new ModelRenderer(this, 10, 0);
        this.frame4.mirror = true;
        this.frame4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frame4.addBox(17.5F, -23.0F, 6.0F, 2, 47, 2, 0.0F);
        this.lowerFrameB = new ModelRenderer(this, 55, 35);
        this.lowerFrameB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerFrameB.addBox(-7.8F, 22.3F, 6.5F, 27, 1, 1, 0.0F);
        this.shelf4 = new ModelRenderer(this, 8, 50);
        this.shelf4.setRotationPoint(8.0F, -11.5F, 0.0F);
        this.shelf4.addBox(-15.0F, -0.5F, -6.0F, 25, 1, 12, 0.0F);
        this.upperFrameB = new ModelRenderer(this, 55, 5);
        this.upperFrameB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperFrameB.addBox(-7.8F, -22.5F, 6.5F, 27, 1, 1, 0.0F);
        this.shelf1 = new ModelRenderer(this, 8, 50);
        this.shelf1.setRotationPoint(8.0F, 22.5F, 0.0F);
        this.shelf1.addBox(-15.0F, -0.5F, -6.0F, 25, 1, 12, 0.0F);
        this.upperFrameL = new ModelRenderer(this, 55, 10);
        this.upperFrameL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperFrameL.addBox(18.0F, -22.5F, -7.5F, 1, 1, 15, 0.0F);
        this.lowerFrameR = new ModelRenderer(this, 90, 10);
        this.lowerFrameR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerFrameR.addBox(-7.5F, 22.3F, -7.5F, 1, 1, 15, 0.0F);
        this.frame2 = new ModelRenderer(this, 10, 0);
        this.frame2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frame2.addBox(-8.0F, -23.0F, 6.0F, 2, 47, 2, 0.0F);
    }
    
    @Override
    public void render(Object obj)
    {
        this.LowerFrameL.render(DEFAULT_SCALE);
        this.lLattice.render(DEFAULT_SCALE);
        this.upperFrameR.render(DEFAULT_SCALE);
        this.upperFrameF.render(DEFAULT_SCALE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shelf3.offsetX, this.shelf3.offsetY, this.shelf3.offsetZ);
        GlStateManager.translate(this.shelf3.rotationPointX * DEFAULT_SCALE, this.shelf3.rotationPointY * DEFAULT_SCALE, this.shelf3.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.0D, 1.0D, 1.2D);
        GlStateManager.translate(-this.shelf3.offsetX, -this.shelf3.offsetY, -this.shelf3.offsetZ);
        GlStateManager.translate(-this.shelf3.rotationPointX * DEFAULT_SCALE, -this.shelf3.rotationPointY * DEFAULT_SCALE, -this.shelf3.rotationPointZ * DEFAULT_SCALE);
        this.shelf3.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        this.rLattice.render(DEFAULT_SCALE);
        this.light1.render(DEFAULT_SCALE);
        this.frame1.render(DEFAULT_SCALE);
        this.light2.render(DEFAULT_SCALE);
        this.lowerFrameF.render(DEFAULT_SCALE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shelf2.offsetX, this.shelf2.offsetY, this.shelf2.offsetZ);
        GlStateManager.translate(this.shelf2.rotationPointX * DEFAULT_SCALE, this.shelf2.rotationPointY * DEFAULT_SCALE, this.shelf2.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.0D, 1.0D, 1.2D);
        GlStateManager.translate(-this.shelf2.offsetX, -this.shelf2.offsetY, -this.shelf2.offsetZ);
        GlStateManager.translate(-this.shelf2.rotationPointX * DEFAULT_SCALE, -this.shelf2.rotationPointY * DEFAULT_SCALE, -this.shelf2.rotationPointZ * DEFAULT_SCALE);
        this.shelf2.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        this.frame3.render(DEFAULT_SCALE);
        this.frame4.render(DEFAULT_SCALE);
        this.lowerFrameB.render(DEFAULT_SCALE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shelf4.offsetX, this.shelf4.offsetY, this.shelf4.offsetZ);
        GlStateManager.translate(this.shelf4.rotationPointX * DEFAULT_SCALE, this.shelf4.rotationPointY * DEFAULT_SCALE, this.shelf4.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.0D, 1.0D, 1.2D);
        GlStateManager.translate(-this.shelf4.offsetX, -this.shelf4.offsetY, -this.shelf4.offsetZ);
        GlStateManager.translate(-this.shelf4.rotationPointX * DEFAULT_SCALE, -this.shelf4.rotationPointY * DEFAULT_SCALE, -this.shelf4.rotationPointZ * DEFAULT_SCALE);
        this.shelf4.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        this.upperFrameB.render(DEFAULT_SCALE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shelf1.offsetX, this.shelf1.offsetY, this.shelf1.offsetZ);
        GlStateManager.translate(this.shelf1.rotationPointX * DEFAULT_SCALE, this.shelf1.rotationPointY * DEFAULT_SCALE, this.shelf1.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.0D, 1.0D, 1.2D);
        GlStateManager.translate(-this.shelf1.offsetX, -this.shelf1.offsetY, -this.shelf1.offsetZ);
        GlStateManager.translate(-this.shelf1.rotationPointX * DEFAULT_SCALE, -this.shelf1.rotationPointY * DEFAULT_SCALE, -this.shelf1.rotationPointZ * DEFAULT_SCALE);
        this.shelf1.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        this.upperFrameL.render(DEFAULT_SCALE);
        this.lowerFrameR.render(DEFAULT_SCALE);
        this.frame2.render(DEFAULT_SCALE);
    }
}
