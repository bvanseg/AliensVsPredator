package org.avp.client.model.tile;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ModelCCFL extends Model
{
    public ModelRenderer middleRod;
    public ModelRenderer lightAura;
    public ModelRenderer lightTube;
    public ModelRenderer lCap;
    public ModelRenderer rCap;

    public ModelCCFL()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.middleRod = new ModelRenderer(this, 0, 0);
        this.middleRod.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.middleRod.addBox(-7.5F, -0.5F, -0.5F, 15, 1, 1, 0.0F);
        this.lightTube = new ModelRenderer(this, 0, 5);
        this.lightTube.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.lightTube.addBox(-6.0F, -0.5F, -0.5F, 12, 1, 1, 0.0F);
        this.lCap = new ModelRenderer(this, 0, 9);
        this.lCap.setRotationPoint(-7.3F, 9.0F, 0.0F);
        this.lCap.addBox(-1.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.lightAura = new ModelRenderer(this, 0, 18);
        this.lightAura.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.lightAura.addBox(-5.5F, -0.5F, -0.5F, 11, 1, 1, 0.0F);
        this.rCap = new ModelRenderer(this, 0, 9);
        this.rCap.mirror = true;
        this.rCap.setRotationPoint(7.3F, 9.0F, 0.0F);
        this.rCap.addBox(0.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
    }
    
    @Override
    public void render(Object obj)
    {
        this.middleRod.render(DEFAULT_SCALE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.lightTube.offsetX, this.lightTube.offsetY, this.lightTube.offsetZ);
        GlStateManager.translate(this.lightTube.rotationPointX * DEFAULT_SCALE, this.lightTube.rotationPointY * DEFAULT_SCALE, this.lightTube.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.15D, 1.2D, 1.2D);
        GlStateManager.translate(-this.lightTube.offsetX, -this.lightTube.offsetY, -this.lightTube.offsetZ);
        GlStateManager.translate(-this.lightTube.rotationPointX * DEFAULT_SCALE, -this.lightTube.rotationPointY * DEFAULT_SCALE, -this.lightTube.rotationPointZ * DEFAULT_SCALE);
        this.lightTube.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.lCap.offsetX, this.lCap.offsetY, this.lCap.offsetZ);
        GlStateManager.translate(this.lCap.rotationPointX * DEFAULT_SCALE, this.lCap.rotationPointY * DEFAULT_SCALE, this.lCap.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(0.7D, 0.6D, 0.6D);
        GlStateManager.translate(-this.lCap.offsetX, -this.lCap.offsetY, -this.lCap.offsetZ);
        GlStateManager.translate(-this.lCap.rotationPointX * DEFAULT_SCALE, -this.lCap.rotationPointY * DEFAULT_SCALE, -this.lCap.rotationPointZ * DEFAULT_SCALE);
        this.lCap.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.lightAura.offsetX, this.lightAura.offsetY, this.lightAura.offsetZ);
        GlStateManager.translate(this.lightAura.rotationPointX * DEFAULT_SCALE, this.lightAura.rotationPointY * DEFAULT_SCALE, this.lightAura.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.3D, 1.5D, 1.5D);
        GlStateManager.translate(-this.lightAura.offsetX, -this.lightAura.offsetY, -this.lightAura.offsetZ);
        GlStateManager.translate(-this.lightAura.rotationPointX * DEFAULT_SCALE, -this.lightAura.rotationPointY * DEFAULT_SCALE, -this.lightAura.rotationPointZ * DEFAULT_SCALE);
        this.lightAura.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rCap.offsetX, this.rCap.offsetY, this.rCap.offsetZ);
        GlStateManager.translate(this.rCap.rotationPointX * DEFAULT_SCALE, this.rCap.rotationPointY * DEFAULT_SCALE, this.rCap.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(0.7D, 0.6D, 0.6D);
        GlStateManager.translate(-this.rCap.offsetX, -this.rCap.offsetY, -this.rCap.offsetZ);
        GlStateManager.translate(-this.rCap.rotationPointX * DEFAULT_SCALE, -this.rCap.rotationPointY * DEFAULT_SCALE, -this.rCap.rotationPointZ * DEFAULT_SCALE);
        this.rCap.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
    }
}
