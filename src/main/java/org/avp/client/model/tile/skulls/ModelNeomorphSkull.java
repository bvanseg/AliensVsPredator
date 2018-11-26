package org.avp.client.model.tile.skulls;

import com.arisux.mdx.lib.client.render.model.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelNeomorphSkull extends Model
{
    public ModelRenderer head;
    public ModelRenderer muzzle01;
    public ModelRenderer jawLower;
    public ModelRenderer head2;
    public ModelRenderer headLower01;
    public ModelRenderer face01;
    public ModelRenderer muzzle03;
    public ModelRenderer jawUpper01;
    public ModelRenderer face02;
    public ModelRenderer muzzle04;
    public ModelRenderer jawUpperInner1;
    public ModelRenderer jawUpper02;
    public ModelRenderer JawUpperInner02;
    public ModelRenderer jawLowerInner;
    public ModelRenderer jawLowerInner02;
    public ModelRenderer head5;
    public ModelRenderer head3;
    public ModelRenderer head6;
    public ModelRenderer head4;
    public ModelRenderer headLower02;

    public ModelNeomorphSkull()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.head = new ModelRenderer(this, 124, 0);
        this.head.setRotationPoint(0.0F, 24.0F, -3.0F);
        this.head.addBox(-3.0F, -5.0F, -3.1F, 6, 3, 6, 0.0F);
        this.head5 = new ModelRenderer(this, 157, 12);
        this.head5.setRotationPoint(0.0F, 0.1F, 4.1F);
        this.head5.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 4, 0.0F);
        this.setRotation(head5, -0.136659280431156F, 0.0F, 0.0F);
        this.jawLowerInner02 = new ModelRenderer(this, 195, 51);
        this.jawLowerInner02.setRotationPoint(0.0F, -0.0F, 0.0F);
        this.jawLowerInner02.addBox(0.35F, -0.9F, -1.0F, 1, 1, 2, 0.0F);
        this.jawUpper01 = new ModelRenderer(this, 151, 37);
        this.jawUpper01.setRotationPoint(1.0F, -0.1F, 2.4F);
        this.jawUpper01.addBox(-2.83F, -0.7F, -3.9F, 3, 1, 4, 0.0F);
        this.setRotation(jawUpper01, 0.40980330836826856F, 0.0F, 0.0F);
        this.head6 = new ModelRenderer(this, 157, 25);
        this.head6.setRotationPoint(0.0F, -0.1F, 3.4F);
        this.head6.addBox(-1.5F, -0.9F, 0.2F, 3, 2, 2, 0.0F);
        this.setRotation(head6, -0.091106186954104F, 0.0F, 0.0F);
        this.jawUpper02 = new ModelRenderer(this, 168, 37);
        this.jawUpper02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.jawUpper02.addBox(-0.15F, -0.7F, -3.9F, 1, 1, 4, 0.0F);
        this.face02 = new ModelRenderer(this, 139, 16);
        this.face02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.face02.addBox(1.65F, -2.5F, 0.1F, 1, 3, 2, 0.0F);
        this.headLower02 = new ModelRenderer(this, 131, 40);
        this.headLower02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headLower02.addBox(1.83F, 0.0F, -3.1F, 1, 2, 6, 0.0F);
        this.head2 = new ModelRenderer(this, 157, 0);
        this.head2.setRotationPoint(0.0F, -3.6F, 2.4F);
        this.head2.addBox(-2.5F, -1.0F, -0.8F, 5, 2, 6, 0.0F);
        this.setRotation(head2, 0.091106186954104F, 0.0F, 0.0F);
        this.headLower01 = new ModelRenderer(this, 118, 29);
        this.headLower01.setRotationPoint(0.0F, -2.2F, 0.0F);
        this.headLower01.addBox(-2.83F, 0.0F, -3.1F, 5, 2, 6, 0.0F);
        this.head3 = new ModelRenderer(this, 184, 0);
        this.head3.setRotationPoint(0.0F, 2.1F, 0.2F);
        this.head3.addBox(-2.0F, -1.2F, 0.0F, 4, 2, 5, 0.0F);
        this.setRotation(head3, 0.18203784098300857F, 0.0F, 0.0F);
        this.jawLowerInner = new ModelRenderer(this, 183, 51);
        this.jawLowerInner.setRotationPoint(0.1F, -0.2F, -1.0F);
        this.jawLowerInner.addBox(-1.5F, -0.9F, -1.0F, 2, 1, 2, 0.0F);
        this.muzzle04 = new ModelRenderer(this, 193, 38);
        this.muzzle04.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.muzzle04.addBox(1.44F, -1.2F, -1.6F, 1, 1, 2, 0.0F);
        this.jawLower = new ModelRenderer(this, 181, 58);
        this.jawLower.setRotationPoint(0.0F, -0.4F, -2.8F);
        this.jawLower.addBox(-1.5F, -0.3F, -2.2F, 3, 1, 3, 0.0F);
        this.face01 = new ModelRenderer(this, 124, 16);
        this.face01.setRotationPoint(0.0F, -0.1F, -0.1F);
        this.face01.addBox(-2.65F, -2.5F, 0.1F, 5, 3, 2, 0.0F);
        this.setRotation(face01, 0.9105382707654417F, 0.0F, 0.0F);
        this.muzzle03 = new ModelRenderer(this, 179, 38);
        this.muzzle03.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.muzzle03.addBox(-2.45F, -1.2F, -1.6F, 4, 1, 2, 0.0F);
        this.setRotation(muzzle03, 0.5918411493512771F, 0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 185, 12);
        this.head4.setRotationPoint(0.0F, 0.1F, 4.7F);
        this.head4.addBox(-1.5F, -0.4F, 0.0F, 3, 1, 3, 0.0F);
        this.setRotation(head4, -0.136659280431156F, 0.0F, 0.0F);
        this.muzzle01 = new ModelRenderer(this, 175, 25);
        this.muzzle01.setRotationPoint(0.0F, -1.8F, -3.5F);
        this.muzzle01.addBox(-2.5F, -1.6F, -2.0F, 5, 2, 3, 0.0F);
        this.setRotation(muzzle01, -0.36425021489121656F, 0.0F, 0.0F);
        this.jawUpperInner1 = new ModelRenderer(this, 179, 44);
        this.jawUpperInner1.setRotationPoint(0.0F, 0.6F, -1.6F);
        this.jawUpperInner1.addBox(-2.49F, -0.5F, -2.1F, 2, 1, 2, 0.0F);
        this.JawUpperInner02 = new ModelRenderer(this, 189, 44);
        this.JawUpperInner02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.JawUpperInner02.addBox(-0.51F, -0.5F, -2.1F, 1, 1, 2, 0.0F);
        this.head2.addChild(this.head5);
        this.jawLowerInner.addChild(this.jawLowerInner02);
        this.muzzle01.addChild(this.jawUpper01);
        this.head5.addChild(this.head6);
        this.jawUpper01.addChild(this.jawUpper02);
        this.face01.addChild(this.face02);
        this.headLower01.addChild(this.headLower02);
        this.head.addChild(this.head2);
        this.head.addChild(this.headLower01);
        this.head2.addChild(this.head3);
        this.jawLower.addChild(this.jawLowerInner);
        this.muzzle03.addChild(this.muzzle04);
        this.head.addChild(this.jawLower);
        this.muzzle01.addChild(this.face01);
        this.muzzle01.addChild(this.muzzle03);
        this.head3.addChild(this.head4);
        this.head.addChild(this.muzzle01);
        this.jawUpper01.addChild(this.jawUpperInner1);
        this.jawUpperInner1.addChild(this.JawUpperInner02);
    }

    @Override
    public void render(Object obj)
    {
        draw(head);
    }
}
