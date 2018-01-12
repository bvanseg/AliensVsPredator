package org.avp.client.model.tile.rackmodules;

import com.arisux.mdx.lib.client.render.model.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelRackModule8 extends Model
{
    public ModelRenderer faceplate;
    public ModelRenderer body;
    public ModelRenderer light01;
    public ModelRenderer light02;
    public ModelRenderer light03;
    public ModelRenderer light04;
    public ModelRenderer light05;
    public ModelRenderer light06;
    public ModelRenderer light07;
    public ModelRenderer light08;
    public ModelRenderer lhandle;
    public ModelRenderer rhandle;

    public ModelRackModule8()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.lhandle = new ModelRenderer(this, 54, 0);
        this.lhandle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lhandle.addBox(10.0F, 0.4F, -2.1F, 1, 6, 3, 0.0F);
        this.light04 = new ModelRenderer(this, 0, 8);
        this.light04.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light04.addBox(-4.3F, 4.4F, -0.3F, 1, 1, 1, 0.0F);
        this.light05 = new ModelRenderer(this, 0, 4);
        this.light05.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light05.addBox(-2.9F, 0.5F, -0.3F, 1, 1, 1, 0.0F);
        this.light06 = new ModelRenderer(this, 0, 0);
        this.light06.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light06.addBox(-2.9F, 1.8F, -0.3F, 1, 1, 1, 0.0F);
        this.light01 = new ModelRenderer(this, 0, 4);
        this.light01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light01.addBox(-4.3F, 0.5F, -0.3F, 1, 1, 1, 0.0F);
        this.rhandle = new ModelRenderer(this, 54, 0);
        this.rhandle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rhandle.addBox(-11.0F, 0.4F, -2.1F, 1, 6, 3, 0.0F);
        this.light08 = new ModelRenderer(this, 0, 8);
        this.light08.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light08.addBox(-2.9F, 4.4F, -0.3F, 1, 1, 1, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-7.0F, 0.5F, 0.3F, 14, 6, 12, 0.0F);
        this.light02 = new ModelRenderer(this, 0, 0);
        this.light02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light02.addBox(-4.3F, 1.8F, -0.3F, 1, 1, 1, 0.0F);
        this.faceplate = new ModelRenderer(this, 0, 20);
        this.faceplate.setRotationPoint(0.0F, 0.0F, 0.8F);
        this.faceplate.addBox(-12.5F, 0.0F, 0.0F, 25, 7, 1, 0.0F);
        this.light07 = new ModelRenderer(this, 0, 8);
        this.light07.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light07.addBox(-2.9F, 3.1F, -0.3F, 1, 1, 1, 0.0F);
        this.light03 = new ModelRenderer(this, 0, 0);
        this.light03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light03.addBox(-4.3F, 3.1F, -0.3F, 1, 1, 1, 0.0F);
    }
    
    @Override
    public void render(Object obj)
    {
        this.lhandle.render(DEFAULT_SCALE);
        this.light04.render(DEFAULT_SCALE);
        this.light05.render(DEFAULT_SCALE);
        this.light06.render(DEFAULT_SCALE);
        this.light01.render(DEFAULT_SCALE);
        this.rhandle.render(DEFAULT_SCALE);
        this.light08.render(DEFAULT_SCALE);
        this.body.render(DEFAULT_SCALE);
        this.light02.render(DEFAULT_SCALE);
        this.faceplate.render(DEFAULT_SCALE);
        this.light07.render(DEFAULT_SCALE);
        this.light03.render(DEFAULT_SCALE);
    }
}
