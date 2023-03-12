package org.avp.client.model.tile.rackmodule;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;

//TODO: Use a better type than Object for Model.
public class ModelRackModule5 extends Model<Object>
{
    public final ModelRenderer faceplate;
    public final ModelRenderer light01;
    public final ModelRenderer light02;
    public final ModelRenderer light03;
    public final ModelRenderer chassis;
    public final ModelRenderer dial1;
    public final ModelRenderer dial2;
    public final ModelRenderer lhandle;
    public final ModelRenderer rhandle;

    public ModelRackModule5()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.light02 = new ModelRenderer(this, 0, 0);
        this.light02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light02.addBox(2.2F, 1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.light03 = new ModelRenderer(this, 0, 0);
        this.light03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light03.addBox(3.4F, 1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.lhandle = new ModelRenderer(this, 36, 1);
        this.lhandle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lhandle.addBox(-11.0F, 1.0F, -2.1F, 1, 4, 2, 0.0F);
        this.light01 = new ModelRenderer(this, 0, 4);
        this.light01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.light01.addBox(0.0F, 1.0F, -1.0F, 2, 1, 1, 0.0F);
        this.dial1 = new ModelRenderer(this, 12, 0);
        this.dial1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dial1.addBox(-4.7F, 1.4F, -1.0F, 3, 3, 1, 0.0F);
        this.dial2 = new ModelRenderer(this, 22, 0);
        this.dial2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dial2.addBox(-4.2F, 1.9F, -1.6F, 2, 2, 2, 0.0F);
        this.chassis = new ModelRenderer(this, 0, 18);
        this.chassis.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.chassis.addBox(-6.5F, 0.9F, -0.3F, 13, 4, 9, 0.0F);
        this.rhandle = new ModelRenderer(this, 36, 1);
        this.rhandle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rhandle.addBox(10.0F, 1.0F, -2.1F, 1, 4, 2, 0.0F);
        this.faceplate = new ModelRenderer(this, 0, 10);
        this.faceplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.faceplate.addBox(-12.5F, 0.1F, -0.1F, 25, 6, 1, 0.0F);
    }

    @Override
    public void render(Object obj)
    {
        this.light02.render(DEFAULT_SCALE);
        this.light03.render(DEFAULT_SCALE);
        this.lhandle.render(DEFAULT_SCALE);
        this.light01.render(DEFAULT_SCALE);
        this.dial1.render(DEFAULT_SCALE);
        this.dial2.render(DEFAULT_SCALE);
        this.chassis.render(DEFAULT_SCALE);
        this.rhandle.render(DEFAULT_SCALE);
        this.faceplate.render(DEFAULT_SCALE);
    }
}
