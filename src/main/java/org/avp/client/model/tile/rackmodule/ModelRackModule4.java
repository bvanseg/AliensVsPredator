package org.avp.client.model.tile.rackmodule;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

//TODO: Use a better type than Object for Model.
public class ModelRackModule4 extends Model<Object>
{
    public final ModelRenderer chassis;
    public final ModelRenderer light01;
    public final ModelRenderer light02;
    public final ModelRenderer light03;
    public final ModelRenderer screen;
    public final ModelRenderer hinge;
    public final ModelRenderer plate;
    public final ModelRenderer faceplate;
    public final ModelRenderer light04;
    public final ModelRenderer light05;
    public final ModelRenderer light06;
    public final ModelRenderer light08;
    public final ModelRenderer light07;

    public ModelRackModule4()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.faceplate = new ModelRenderer(this, 71, 0);
        this.faceplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.faceplate.addBox(-6.8F, 0.5F, -0.2F, 7, 4, 1, 0.0F);
        this.light04 = new ModelRenderer(this, 6, 6);
        this.light04.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light04.addBox(-3.3F, 1.2F, -0.4F, 1, 1, 1, 0.0F);
        this.light05 = new ModelRenderer(this, 6, 6);
        this.light05.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light05.addBox(-1.8F, 1.2F, -0.4F, 1, 1, 1, 0.0F);
        this.chassis = new ModelRenderer(this, 0, 0);
        this.chassis.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.chassis.addBox(-11.0F, 0.0F, 0.0F, 22, 8, 12, 0.0F);
        this.light07 = new ModelRenderer(this, 6, 6);
        this.light07.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light07.addBox(-3.3F, 2.5F, -0.4F, 1, 1, 1, 0.0F);
        this.light01 = new ModelRenderer(this, 0, 0);
        this.light01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light01.addBox(-6.0F, 3.1F, -0.4F, 1, 2, 1, 0.0F);
        this.light06 = new ModelRenderer(this, 6, 6);
        this.light06.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light06.addBox(-4.6F, 2.5F, -0.4F, 1, 1, 1, 0.0F);
        this.light08 = new ModelRenderer(this, 6, 6);
        this.light08.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light08.addBox(-1.8F, 2.5F, -0.4F, 1, 1, 1, 0.0F);
        this.light03 = new ModelRenderer(this, 6, 6);
        this.light03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light03.addBox(-4.6F, 1.2F, -0.4F, 1, 1, 1, 0.0F);
        this.plate = new ModelRenderer(this, 96, 37);
        this.plate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plate.addBox(-8.9F, 4.8F, -0.8F, 2, 2, 1, 0.0F);
        this.screen = new ModelRenderer(this, 8, 22);
        this.screen.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.screen.addBox(1.2F, -0.3F, -0.9F, 9, 9, 13, 0.0F);
        this.hinge = new ModelRenderer(this, 58, 24);
        this.hinge.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.hinge.addBox(-11.5F, 0.4F, -0.6F, 4, 3, 13, 0.0F);
        this.light02 = new ModelRenderer(this, 0, 6);
        this.light02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light02.addBox(-6.0F, 1.2F, -0.4F, 1, 1, 1, 0.0F);
    }
    
    @Override
    public void render(Object obj)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.faceplate.offsetX, this.faceplate.offsetY, this.faceplate.offsetZ);
        GlStateManager.translate(this.faceplate.rotationPointX * DEFAULT_SCALE, this.faceplate.rotationPointY * DEFAULT_SCALE, this.faceplate.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(0.95D, 1.1D, 1.0D);
        GlStateManager.translate(-this.faceplate.offsetX, -this.faceplate.offsetY, -this.faceplate.offsetZ);
        GlStateManager.translate(-this.faceplate.rotationPointX * DEFAULT_SCALE, -this.faceplate.rotationPointY * DEFAULT_SCALE, -this.faceplate.rotationPointZ * DEFAULT_SCALE);
        this.faceplate.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        this.light04.render(DEFAULT_SCALE);
        this.light05.render(DEFAULT_SCALE);
        this.chassis.render(DEFAULT_SCALE);
        this.light07.render(DEFAULT_SCALE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.light01.offsetX, this.light01.offsetY, this.light01.offsetZ);
        GlStateManager.translate(this.light01.rotationPointX * DEFAULT_SCALE, this.light01.rotationPointY * DEFAULT_SCALE, this.light01.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.0D, 0.8D, 1.0D);
        GlStateManager.translate(-this.light01.offsetX, -this.light01.offsetY, -this.light01.offsetZ);
        GlStateManager.translate(-this.light01.rotationPointX * DEFAULT_SCALE, -this.light01.rotationPointY * DEFAULT_SCALE, -this.light01.rotationPointZ * DEFAULT_SCALE);
        this.light01.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        this.light06.render(DEFAULT_SCALE);
        this.light08.render(DEFAULT_SCALE);
        this.light03.render(DEFAULT_SCALE);
        this.plate.render(DEFAULT_SCALE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.screen.offsetX, this.screen.offsetY, this.screen.offsetZ);
        GlStateManager.translate(this.screen.rotationPointX * DEFAULT_SCALE, this.screen.rotationPointY * DEFAULT_SCALE, this.screen.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(1.0D, 0.95D, 1.0D);
        GlStateManager.translate(-this.screen.offsetX, -this.screen.offsetY, -this.screen.offsetZ);
        GlStateManager.translate(-this.screen.rotationPointX * DEFAULT_SCALE, -this.screen.rotationPointY * DEFAULT_SCALE, -this.screen.rotationPointZ * DEFAULT_SCALE);
        this.screen.render(DEFAULT_SCALE);
        GlStateManager.popMatrix();
        this.hinge.render(DEFAULT_SCALE);
        this.light02.render(DEFAULT_SCALE);
    }
}
