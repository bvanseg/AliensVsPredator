package org.alien.client.model.tile.plant;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import org.alien.common.tile.plant.TileEntityTreeFern;

public class ModelTreeFern extends Model<TileEntityTreeFern>
{
    public final ModelRenderer trunk01;
    public final ModelRenderer trunk04;
    public final ModelRenderer trunk03;
    public final ModelRenderer crown01;
    public final ModelRenderer crown02;
    public final ModelRenderer trunk02;
    public final ModelRenderer trunk05;
    public final ModelRenderer lowerLeaf01a;
    public final ModelRenderer lowerLeaf02a;
    public final ModelRenderer lowerLeaf03a;
    public final ModelRenderer lowerLeaf04a;
    public final ModelRenderer lowerLeaf05a;
    public final ModelRenderer lowerLeaf06a;
    public final ModelRenderer lowerLeaf07a;
    public final ModelRenderer lowerLeaf08a;
    public final ModelRenderer lowerLeaf01b;
    public final ModelRenderer lowerLeaf02b;
    public final ModelRenderer lowerLeaf03b;
    public final ModelRenderer lowerLeaf04b;
    public final ModelRenderer lowerLeaf05b;
    public final ModelRenderer lowerLeaf06b;
    public final ModelRenderer lowerLeaf07b;
    public final ModelRenderer lowerLeaf08b;
    public final ModelRenderer upperLeaf01a;
    public final ModelRenderer upperLeaf02a;
    public final ModelRenderer upperLeaf03a;
    public final ModelRenderer upperLeaf04a;
    public final ModelRenderer upperLeaf05a;
    public final ModelRenderer upperLeaf06a;
    public final ModelRenderer upperLeaf01b;
    public final ModelRenderer upperLeaf02b;
    public final ModelRenderer upperLeaf03b;
    public final ModelRenderer upperLeaf04b;
    public final ModelRenderer upperLeaf05b;
    public final ModelRenderer upperLeaf06b;

    public ModelTreeFern()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.lowerLeaf01a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf01a.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.lowerLeaf01a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf01a, 0.136659280431156F, 0.0F, 0.0F);
        this.upperLeaf03a = new ModelRenderer(this, 18, 15);
        this.upperLeaf03a.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.upperLeaf03a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(upperLeaf03a, -0.36425021489121656F, -2.0943951023931953F, 0.0F);
        this.trunk04 = new ModelRenderer(this, 0, 20);
        this.trunk04.setRotationPoint(0.0F, 1.1F, 0.0F);
        this.trunk04.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3, 0.0F);
        this.trunk02 = new ModelRenderer(this, 0, 11);
        this.trunk02.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.trunk02.addBox(-1.5F, -5.0F, -1.5F, 3, 5, 3, 0.0F);
        this.trunk03 = new ModelRenderer(this, 19, 0);
        this.trunk03.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.trunk03.addBox(-1.0F, -14.0F, -1.0F, 2, 14, 2, 0.0F);
        this.lowerLeaf07a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf07a.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.lowerLeaf07a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf07a, 0.18203784098300857F, 2.356194490192345F, 0.0F);
        this.trunk05 = new ModelRenderer(this, 0, 25);
        this.trunk05.setRotationPoint(0.0F, -0.9F, 0.0F);
        this.trunk05.addBox(-2.0F, -2.1F, -2.0F, 4, 2, 4, 0.0F);
        this.lowerLeaf04a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf04a.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.lowerLeaf04a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf04a, 0.136659280431156F, 3.141592653589793F, 0.0F);
        this.lowerLeaf05b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf05b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf05b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf05b, 0.136659280431156F, 0.0F, 0.0F);
        this.crown01 = new ModelRenderer(this, 28, 0);
        this.crown01.setRotationPoint(0.0F, -1.9F, 0.0F);
        this.crown01.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3, 0.0F);
        this.lowerLeaf05a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf05a.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.lowerLeaf05a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf05a, 0.18203784098300857F, 0.7853981633974483F, 0.0F);
        this.crown02 = new ModelRenderer(this, 31, 6);
        this.crown02.setRotationPoint(0.0F, -2.9F, 0.0F);
        this.crown02.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F);
        this.lowerLeaf02a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf02a.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerLeaf02a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf02a, 0.27314402793711257F, 1.5707963267948966F, 0.0F);
        this.lowerLeaf03b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf03b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf03b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf03b, 0.22759093446006054F, 0.0F, 0.0F);
        this.lowerLeaf06b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf06b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf06b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf06b, 0.136659280431156F, 0.0F, 0.0F);
        this.lowerLeaf06a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf06a.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.lowerLeaf06a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf06a, 0.18203784098300857F, -0.7853981633974483F, 0.0F);
        this.upperLeaf02b = new ModelRenderer(this, 22, 25);
        this.upperLeaf02b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.upperLeaf02b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(upperLeaf02b, 0.18203784098300857F, 0.0F, 0.0F);
        this.lowerLeaf08b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf08b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf08b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf08b, 0.136659280431156F, 0.0F, 0.0F);
        this.upperLeaf05b = new ModelRenderer(this, 22, 25);
        this.upperLeaf05b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.upperLeaf05b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(upperLeaf05b, 0.18203784098300857F, 0.0F, 0.0F);
        this.upperLeaf06b = new ModelRenderer(this, 22, 25);
        this.upperLeaf06b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.upperLeaf06b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(upperLeaf06b, 0.18203784098300857F, 0.0F, 0.0F);
        this.lowerLeaf08a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf08a.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.lowerLeaf08a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf08a, 0.18203784098300857F, -2.356194490192345F, 0.0F);
        this.lowerLeaf03a = new ModelRenderer(this, 34, 0);
        this.lowerLeaf03a.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowerLeaf03a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(lowerLeaf03a, 0.27314402793711257F, -1.5707963267948966F, 0.0F);
        this.upperLeaf04b = new ModelRenderer(this, 22, 25);
        this.upperLeaf04b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.upperLeaf04b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(upperLeaf04b, 0.18203784098300857F, 0.0F, 0.0F);
        this.lowerLeaf01b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf01b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf01b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf01b, 0.18203784098300857F, 0.0F, 0.0F);
        this.upperLeaf01b = new ModelRenderer(this, 22, 25);
        this.upperLeaf01b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.upperLeaf01b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(upperLeaf01b, 0.18203784098300857F, 0.0F, 0.0F);
        this.trunk01 = new ModelRenderer(this, 0, 0);
        this.trunk01.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.trunk01.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4, 0.0F);
        this.upperLeaf04a = new ModelRenderer(this, 18, 15);
        this.upperLeaf04a.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperLeaf04a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(upperLeaf04a, -0.36425021489121656F, 1.0471975511965976F, 0.0F);
        this.lowerLeaf07b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf07b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf07b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf07b, 0.136659280431156F, 0.0F, 0.0F);
        this.upperLeaf06a = new ModelRenderer(this, 18, 15);
        this.upperLeaf06a.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperLeaf06a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(upperLeaf06a, -0.36425021489121656F, 3.141592653589793F, 0.0F);
        this.upperLeaf02a = new ModelRenderer(this, 18, 15);
        this.upperLeaf02a.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.upperLeaf02a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(upperLeaf02a, -0.36425021489121656F, 2.0943951023931953F, 0.0F);
        this.upperLeaf01a = new ModelRenderer(this, 18, 15);
        this.upperLeaf01a.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.upperLeaf01a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(upperLeaf01a, -0.36425021489121656F, 0.0F, 0.0F);
        this.lowerLeaf02b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf02b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf02b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf02b, 0.22759093446006054F, 0.0F, 0.0F);
        this.lowerLeaf04b = new ModelRenderer(this, 38, 10);
        this.lowerLeaf04b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.lowerLeaf04b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(lowerLeaf04b, 0.18203784098300857F, 0.0F, 0.0F);
        this.upperLeaf03b = new ModelRenderer(this, 22, 25);
        this.upperLeaf03b.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.upperLeaf03b.addBox(-3.5F, 0.0F, -6.0F, 7, 0, 6, 0.0F);
        this.setRotation(upperLeaf03b, 0.18203784098300857F, 0.0F, 0.0F);
        this.upperLeaf05a = new ModelRenderer(this, 18, 15);
        this.upperLeaf05a.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperLeaf05a.addBox(-3.5F, 0.0F, -10.0F, 7, 0, 10, 0.0F);
        this.setRotation(upperLeaf05a, -0.36425021489121656F, -1.0471975511965976F, 0.0F);
        this.crown01.addChild(this.lowerLeaf01a);
        this.crown02.addChild(this.upperLeaf03a);
        this.trunk01.addChild(this.trunk02);
        this.crown01.addChild(this.lowerLeaf07a);
        this.trunk04.addChild(this.trunk05);
        this.crown01.addChild(this.lowerLeaf04a);
        this.lowerLeaf05a.addChild(this.lowerLeaf05b);
        this.crown01.addChild(this.lowerLeaf05a);
        this.crown01.addChild(this.lowerLeaf02a);
        this.lowerLeaf03a.addChild(this.lowerLeaf03b);
        this.lowerLeaf06a.addChild(this.lowerLeaf06b);
        this.crown01.addChild(this.lowerLeaf06a);
        this.upperLeaf02a.addChild(this.upperLeaf02b);
        this.lowerLeaf08a.addChild(this.lowerLeaf08b);
        this.upperLeaf05a.addChild(this.upperLeaf05b);
        this.upperLeaf06a.addChild(this.upperLeaf06b);
        this.crown01.addChild(this.lowerLeaf08a);
        this.crown01.addChild(this.lowerLeaf03a);
        this.upperLeaf04a.addChild(this.upperLeaf04b);
        this.lowerLeaf01a.addChild(this.lowerLeaf01b);
        this.upperLeaf01a.addChild(this.upperLeaf01b);
        this.crown02.addChild(this.upperLeaf04a);
        this.lowerLeaf07a.addChild(this.lowerLeaf07b);
        this.crown02.addChild(this.upperLeaf06a);
        this.crown02.addChild(this.upperLeaf02a);
        this.crown02.addChild(this.upperLeaf01a);
        this.lowerLeaf02a.addChild(this.lowerLeaf02b);
        this.lowerLeaf04a.addChild(this.lowerLeaf04b);
        this.upperLeaf03a.addChild(this.upperLeaf03b);
        this.crown02.addChild(this.upperLeaf05a);
    }

    @Override
    public void render(TileEntityTreeFern obj)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.trunk04.offsetX, this.trunk04.offsetY, this.trunk04.offsetZ);
        GlStateManager.translate(this.trunk04.rotationPointX * DEFAULT_SCALE, this.trunk04.rotationPointY * DEFAULT_SCALE, this.trunk04.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(0.8D, 1.0D, 0.8D);
        GlStateManager.translate(-this.trunk04.offsetX, -this.trunk04.offsetY, -this.trunk04.offsetZ);
        GlStateManager.translate(-this.trunk04.rotationPointX * DEFAULT_SCALE, -this.trunk04.rotationPointY * DEFAULT_SCALE, -this.trunk04.rotationPointZ * DEFAULT_SCALE);
        draw(trunk04);
        GlStateManager.popMatrix();
        draw(trunk03);
        draw(crown01);
        draw(crown02);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.trunk01.offsetX, this.trunk01.offsetY, this.trunk01.offsetZ);
        GlStateManager.translate(this.trunk01.rotationPointX * DEFAULT_SCALE, this.trunk01.rotationPointY * DEFAULT_SCALE, this.trunk01.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(0.85D, 1.0D, 0.85D);
        GlStateManager.translate(-this.trunk01.offsetX, -this.trunk01.offsetY, -this.trunk01.offsetZ);
        GlStateManager.translate(-this.trunk01.rotationPointX * DEFAULT_SCALE, -this.trunk01.rotationPointY * DEFAULT_SCALE, -this.trunk01.rotationPointZ * DEFAULT_SCALE);
        draw(trunk01);
        GlStateManager.popMatrix();
        draw(crown02);
        draw(crown01);
    }
}
