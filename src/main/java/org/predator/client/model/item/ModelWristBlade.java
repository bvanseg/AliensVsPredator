package org.predator.client.model.item;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;

public class ModelWristBlade extends Model<Object>
{
    public final ModelRenderer bBase;
    public final ModelRenderer b1;
    public final ModelRenderer b2;
    public final ModelRenderer b3;
    public final ModelRenderer b4;
    public final ModelRenderer b5;
    public final ModelRenderer b6;
    public final ModelRenderer bladeLeft;
    public final ModelRenderer b7;
    public final ModelRenderer b8;
    public final ModelRenderer b9;
    public final ModelRenderer b10;
    public final ModelRenderer b11;
    public final ModelRenderer bladeRight;

    public ModelWristBlade()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.bBase = new ModelRenderer(this, 29, 0);
        this.bBase.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2);
        this.bBase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bBase.setTextureSize(128, 64);
        this.bBase.mirror = true;
        this.setRotation(this.bBase, 0.0F, 0.0F, 0.0F);
        this.b1 = new ModelRenderer(this, 7, 5);
        this.b1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
        this.b1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.b1.setTextureSize(128, 64);
        this.b1.mirror = true;
        this.setRotation(this.b1, -((float) Math.PI / 4F), 0.0F, 0.0F);
        this.b2 = new ModelRenderer(this, 7, 5);
        this.b2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
        this.b2.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.b2.setTextureSize(128, 64);
        this.b2.mirror = true;
        this.setRotation(this.b2, -((float) Math.PI / 4F), 0.0F, 0.0F);
        this.b3 = new ModelRenderer(this, 0, 0);
        this.b3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
        this.b3.setRotationPoint(0.5F, -0.2F, 0.5F);
        this.b3.setTextureSize(128, 64);
        this.b3.mirror = true;
        this.setRotation(this.b3, 0.0F, 0.0F, 0.0F);
        this.b4 = new ModelRenderer(this, 8, 14);
        this.b4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.b4.setRotationPoint(2.7F, -0.2F, 0.5F);
        this.b4.setTextureSize(128, 64);
        this.b4.mirror = true;
        this.setRotation(this.b4, 0.0F, 0.0F, 0.0F);
        this.b5 = new ModelRenderer(this, 7, 0);
        this.b5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.b5.setRotationPoint(3.7F, 0.0F, 0.5F);
        this.b5.setTextureSize(128, 64);
        this.b5.mirror = true;
        this.setRotation(this.b5, 0.0F, -((float) Math.PI / 4F), 0.0F);
        this.b6 = new ModelRenderer(this, 15, 0);
        this.b6.addBox(0.0F, 0.0F, 0.0F, 8, 2, 0);
        this.b6.setRotationPoint(3.0F, 0.0F, 0.5F);
        this.b6.setTextureSize(128, 64);
        this.b6.mirror = true;
        this.setRotation(this.b6, 0.0F, 0.0F, 0.0F);
        this.bladeLeft = new ModelRenderer(this, 15, 0);
        this.bladeLeft.addBox(0.0F, 0.0F, 0.0F, 8, 2, 0);
        this.bladeLeft.setRotationPoint(3.0F, 0.0F, 1.9F);
        this.bladeLeft.setTextureSize(128, 64);
        this.bladeLeft.mirror = true;
        this.setRotation(this.bladeLeft, 0.0F, 0.0F, 0.0F);
        this.b7 = new ModelRenderer(this, 50, 0);
        this.b7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.b7.setRotationPoint(3.0F, 0.2F, 1.0F);
        this.b7.setTextureSize(128, 64);
        this.b7.mirror = true;
        this.setRotation(this.b7, 0.0F, -((float) Math.PI / 4F), 0.0F);
        this.b8 = new ModelRenderer(this, 50, 0);
        this.b8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.b8.setRotationPoint(2.0F, 0.2F, 1.0F);
        this.b8.setTextureSize(128, 64);
        this.b8.mirror = true;
        this.setRotation(this.b8, 0.0F, -((float) Math.PI / 4F), 0.0F);
        this.b9 = new ModelRenderer(this, 50, 0);
        this.b9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.b9.setRotationPoint(1.0F, 0.2F, 1.0F);
        this.b9.setTextureSize(128, 64);
        this.b9.mirror = true;
        this.setRotation(this.b9, 0.0F, -((float) Math.PI / 4F), 0.0F);
        this.b10 = new ModelRenderer(this, 50, 0);
        this.b10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.b10.setRotationPoint(3.0F, 0.2F, -0.4F);
        this.b10.setTextureSize(128, 64);
        this.b10.mirror = true;
        this.setRotation(this.b10, 0.0F, -((float) Math.PI / 4F), 0.0F);
        this.b11 = new ModelRenderer(this, 50, 0);
        this.b11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.b11.setRotationPoint(2.0F, 0.2F, -0.4F);
        this.b11.setTextureSize(128, 64);
        this.b11.mirror = true;
        this.setRotation(this.b11, 0.0F, -((float) Math.PI / 4F), 0.0F);
        this.bladeRight = new ModelRenderer(this, 50, 0);
        this.bladeRight.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.bladeRight.setRotationPoint(1.0F, 0.2F, -0.4F);
        this.bladeRight.setTextureSize(128, 64);
        this.bladeRight.mirror = true;
        this.setRotation(this.bladeRight, 0.0F, -((float) Math.PI / 4F), 0.0F);
    }

    public void render(Object obj)
    {
        draw(bBase);
        draw(b1);
        draw(b2);
        draw(b3);
        draw(b4);
        draw(b5);
        draw(b7);
        draw(b8);
        draw(b9);
        draw(bladeRight);
        draw(b10);
        draw(b11);
    }
    
    public void renderBlades()
    {
        draw(b6);
        draw(bladeLeft);
    }
}
