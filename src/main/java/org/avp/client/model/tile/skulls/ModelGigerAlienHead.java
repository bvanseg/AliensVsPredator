package org.avp.client.model.tile.skulls;

import com.arisux.mdx.lib.client.render.model.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelGigerAlienHead extends Model
{
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer upperJaw;
    public ModelRenderer lowerJaw1;
    public ModelRenderer face;
    public ModelRenderer innerJaw;
    public ModelRenderer upperTeeth01;
    public ModelRenderer upperTeeth02;
    public ModelRenderer lowerJaw2;
    public ModelRenderer lowerTeeth;
    public ModelRenderer face2;
    public ModelRenderer face3;

    public ModelGigerAlienHead()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.head2 = new ModelRenderer(this, 155, 1);
        this.head2.setRotationPoint(0.0F, -4.4F, 5.4F);
        this.head2.addBox(-3.5F, -3.04F, 0.0F, 7, 6, 12, 0.0F);
        this.setRotation(head2, -0.27314402793711257F, 0.0F, 0.0F);
        this.lowerJaw1 = new ModelRenderer(this, 219, 37);
        this.lowerJaw1.setRotationPoint(0.0F, -1.0F, -4.9F);
        this.lowerJaw1.addBox(-2.8F, -0.3F, -5.0F, 5, 1, 5, 0.0F);
        this.setRotation(lowerJaw1, 0.36425021489121656F, 0.0F, 0.0F);
        this.upperTeeth02 = new ModelRenderer(this, 241, 71);
        this.upperTeeth02.setRotationPoint(0.0F, 0.0F, -0.0F);
        this.upperTeeth02.addBox(1.65F, -0.3F, -5.0F, 1, 2, 3, 0.0F);
        this.upperJaw = new ModelRenderer(this, 225, 27);
        this.upperJaw.setRotationPoint(0.0F, -2.0F, -4.2F);
        this.upperJaw.addBox(-3.0F, -1.3F, -5.8F, 6, 2, 5, 0.0F);
        this.head = new ModelRenderer(this, 112, 1);
        this.head.setRotationPoint(0.0F, 12.1F, 4.4F);
        this.head.addBox(-3.5F, -7.3F, -6.6F, 7, 6, 13, 0.0F);
        this.setRotation(head, 1.4660765716752369F, -1.5707963267948966F, -0.5235987755982988F);
        this.lowerJaw2 = new ModelRenderer(this, 241, 36);
        this.lowerJaw2.setRotationPoint(0.0F, 0.0F, -0.0F);
        this.lowerJaw2.addBox(1.8F, -0.3F, -5.0F, 1, 1, 5, 0.0F);
        this.upperTeeth01 = new ModelRenderer(this, 219, 71);
        this.upperTeeth01.setRotationPoint(0.0F, 0.4F, -0.7F);
        this.upperTeeth01.addBox(-2.65F, -0.3F, -5.0F, 5, 2, 3, 0.0F);
        this.face = new ModelRenderer(this, 184, 20);
        this.face.setRotationPoint(0.0F, -5.0F, -7.1F);
        this.face.addBox(-3.65F, -1.6F, -2.2F, 1, 5, 4, 0.0F);
        this.setRotation(face, 0.6373942428283291F, 0.0F, 0.0F);
        this.face2 = new ModelRenderer(this, 159, 20);
        this.face2.setRotationPoint(0.0F, -0.1F, 0.0F);
        this.face2.addBox(-3.35F, -1.5F, -2.2F, 7, 5, 4, 0.0F);
        this.face3 = new ModelRenderer(this, 197, 18);
        this.face3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.face3.addBox(-3.5F, -2.6F, -2.6F, 7, 3, 2, 0.0F);
        this.setRotation(face3, 0.7740535232594852F, 0.0F, 0.0F);
        this.innerJaw = new ModelRenderer(this, 199, 54);
        this.innerJaw.setRotationPoint(0.0F, -1.5F, 4.6F);
        this.innerJaw.addBox(-1.5F, -1.6F, -9.7F, 3, 3, 10, 0.0F);
        this.setRotation(innerJaw, 0.136659280431156F, 0.0F, 0.0F);
        this.lowerTeeth = new ModelRenderer(this, 219, 81);
        this.lowerTeeth.setRotationPoint(0.0F, -0.2F, -0.5F);
        this.lowerTeeth.addBox(-2.5F, -1.4F, -4.4F, 5, 2, 3, 0.0F);
        this.head.addChild(this.head2);
        this.head.addChild(this.lowerJaw1);
        this.upperTeeth01.addChild(this.upperTeeth02);
        this.head.addChild(this.upperJaw);
        this.lowerJaw1.addChild(this.lowerJaw2);
        this.upperJaw.addChild(this.upperTeeth01);
        this.head.addChild(this.face);
        this.face.addChild(this.face2);
        this.face2.addChild(this.face3);
        this.upperJaw.addChild(this.innerJaw);
        this.lowerJaw1.addChild(this.lowerTeeth);
    }

    @Override
    public void render(Object obj)
    {
        draw(head);
    }
}
