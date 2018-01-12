package org.avp.client.model.tile.rackmodules;

import com.arisux.mdx.lib.client.render.model.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelRackModule6 extends Model
{
    public ModelRenderer frame;
    public ModelRenderer base;
    public ModelRenderer plate;
    public ModelRenderer light01;
    public ModelRenderer light02;
    public ModelRenderer light03;
    public ModelRenderer light04;
    public ModelRenderer light05;
    public ModelRenderer light06;
    public ModelRenderer toggle;

    public ModelRackModule6()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.light02 = new ModelRenderer(this, 0, 3);
        this.light02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light02.addBox(2.7F, 1.4F, 3.7F, 1, 1, 1, 0.0F);
        this.setRotation(light02, -0.5759586531581287F, 0.0F, 0.0F);
        this.light01 = new ModelRenderer(this, 0, 0);
        this.light01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light01.addBox(1.2F, 1.4F, 3.7F, 1, 1, 1, 0.0F);
        this.setRotation(light01, -0.5759586531581287F, 0.0F, 0.0F);
        this.plate = new ModelRenderer(this, 53, 0);
        this.plate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plate.addBox(-2.1F, 0.2F, 3.7F, 3, 4, 1, 0.0F);
        this.setRotation(plate, -0.5759586531581287F, 0.0F, 0.0F);
        this.light04 = new ModelRenderer(this, 5, 0);
        this.light04.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light04.addBox(5.9F, 1.4F, 3.7F, 1, 1, 1, 0.0F);
        this.setRotation(light04, -0.5759586531581287F, 0.0F, 0.0F);
        this.base = new ModelRenderer(this, 0, 18);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-9.8F, -0.5F, 4.3F, 19, 7, 3, 0.0F);
        this.setRotation(base, -0.5759586531581287F, 0.0F, 0.0F);
        this.light06 = new ModelRenderer(this, 0, 0);
        this.light06.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light06.addBox(-0.3F, 1.1F, 3.6F, 1, 1, 1, 0.0F);
        this.setRotation(light06, -0.5759586531581287F, 0.0F, 0.0F);
        this.frame = new ModelRenderer(this, 2, 0);
        this.frame.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frame.addBox(-10.3F, 1.2F, 0.0F, 20, 8, 9, 0.0F);
        this.light05 = new ModelRenderer(this, 0, 0);
        this.light05.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light05.addBox(7.4F, 1.4F, 3.7F, 1, 1, 1, 0.0F);
        this.setRotation(light05, -0.5759586531581287F, 0.0F, 0.0F);
        this.toggle = new ModelRenderer(this, 6, 5);
        this.toggle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.toggle.addBox(-1.7F, 2.8F, 3.0F, 1, 0, 1, 0.0F);
        this.setRotation(toggle, -0.5759586531581287F, 0.0F, 0.0F);
        this.light03 = new ModelRenderer(this, 0, 3);
        this.light03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light03.addBox(4.3F, 1.4F, 3.7F, 1, 1, 1, 0.0F);
        this.setRotation(light03, -0.5759586531581287F, 0.0F, 0.0F);
    }
    
    @Override
    public void render(Object obj)
    {
        this.light02.render(DEFAULT_SCALE);
        this.light01.render(DEFAULT_SCALE);
        this.plate.render(DEFAULT_SCALE);
        this.light04.render(DEFAULT_SCALE);
        this.base.render(DEFAULT_SCALE);
        this.light06.render(DEFAULT_SCALE);
        this.frame.render(DEFAULT_SCALE);
        this.light05.render(DEFAULT_SCALE);
        this.toggle.render(DEFAULT_SCALE);
        this.light03.render(DEFAULT_SCALE);
    }
}
