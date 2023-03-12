package org.avp.client.model.tile.rackmodules;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

//TODO: Use a better type than Object for Model.
public class ModelRackModule3 extends Model<Object>
{
    public ModelRenderer faceplate;
    public ModelRenderer light01;
    public ModelRenderer light02;
    public ModelRenderer light03;
    public ModelRenderer dial1;
    public ModelRenderer dial2;
    public ModelRenderer lfaceplate;
    public ModelRenderer lhandle;
    public ModelRenderer rhandle;

    public ModelRackModule3()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.faceplate = new ModelRenderer(this, 0, 7);
        this.faceplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.faceplate.addBox(-8.0F, 0.0F, 0.0F, 16, 8, 12, 0.0F);
        this.lhandle = new ModelRenderer(this, 71, 0);
        this.lhandle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lhandle.addBox(-10.8F, 0.0F, -2.5F, 1, 8, 3, 0.0F);
        this.rhandle = new ModelRenderer(this, 71, 0);
        this.rhandle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rhandle.addBox(9.8F, 0.0F, -2.5F, 1, 8, 3, 0.0F);
        this.light02 = new ModelRenderer(this, 0, 0);
        this.light02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light02.addBox(-5.5F, 1.2F, -0.5F, 1, 2, 1, 0.0F);
        this.light03 = new ModelRenderer(this, 0, 0);
        this.light03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light03.addBox(-4.1F, 1.2F, -0.5F, 1, 2, 1, 0.0F);
        this.dial1 = new ModelRenderer(this, 8, 0);
        this.dial1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dial1.addBox(3.5F, 2.7F, -0.9F, 2, 2, 1, 0.0F);
        this.lfaceplate = new ModelRenderer(this, 0, 33);
        this.lfaceplate.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.lfaceplate.addBox(-12.5F, -4.5F, 0.1F, 25, 9, 1, 0.0F);
        this.light01 = new ModelRenderer(this, 0, 0);
        this.light01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light01.addBox(-6.9F, 1.2F, -0.5F, 1, 2, 1, 0.0F);
        this.dial2 = new ModelRenderer(this, 18, 0);
        this.dial2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dial2.addBox(3.1F, 2.1F, -1.0F, 3, 3, 1, 0.0F);
    }
    
    @Override
    public void render(Object obj)
    {
        this.faceplate.render(DEFAULT_SCALE);
        this.lhandle.render(DEFAULT_SCALE);
        this.rhandle.render(DEFAULT_SCALE);
        this.light02.render(DEFAULT_SCALE);
        this.light03.render(DEFAULT_SCALE);
        this.dial1.render(DEFAULT_SCALE);
        this.lfaceplate.render(DEFAULT_SCALE);
        this.light01.render(DEFAULT_SCALE);
        this.dial2.render(DEFAULT_SCALE);
    }
}
