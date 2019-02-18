package org.avp.client.model.tile.skulls;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelBiomaskClassic extends Model
{
    public ModelRenderer biomaskMouth;
    public ModelRenderer biomaskVisor;
    public ModelRenderer biomaskSlope;
    public ModelRenderer biomaskHeadPlate;
    public ModelRenderer rBiomaskRidge;
    public ModelRenderer lBiomaskRidge;
    public ModelRenderer rBiomaskSide3;
    public ModelRenderer rBiomaskSide4;
    public ModelRenderer rBiomaskSide2;
    public ModelRenderer rBiomaskSide1;
    public ModelRenderer rBiomaskEye;
    public ModelRenderer lBiomaskSide4;
    public ModelRenderer lBiomaskSide3;
    public ModelRenderer lBiomaskSide2;
    public ModelRenderer lBiomaskSide1;
    public ModelRenderer lBiomaskEye;
    public ModelRenderer sights;
    public ModelRenderer mBiomaskJaw;
    public ModelRenderer lBiomaskJaw;

    public ModelBiomaskClassic()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.rBiomaskSide2 = new ModelRenderer(this, 207, 98);
        this.rBiomaskSide2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide2.addBox(0.0F, -4.0F, -4.0F, 3, 3, 1, 0.0F);
        this.setRotation(rBiomaskSide2, 0.0F, 1.413716694115407F, 0.0F);
        this.biomaskSlope = new ModelRenderer(this, 174, 69);
        this.biomaskSlope.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskSlope.addBox(-4.0F, 0.0F, -8.9F, 8, 1, 1, 0.0F);
        this.setRotation(biomaskSlope, -1.2217304763960306F, -0.0F, 0.0F);
        this.lBiomaskSide2 = new ModelRenderer(this, 221, 98);
        this.lBiomaskSide2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide2.addBox(-3.0F, -4.0F, -4.0F, 3, 3, 1, 0.0F);
        this.setRotation(lBiomaskSide2, 0.0F, -1.413716694115407F, 0.0F);
        this.rBiomaskSide4 = new ModelRenderer(this, 207, 88);
        this.rBiomaskSide4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide4.addBox(-1.0F, -5.0F, -5.3F, 3, 2, 2, 0.0F);
        this.setRotation(rBiomaskSide4, 0.0F, 0.6457718232379019F, 0.0F);
        this.lBiomaskSide3 = new ModelRenderer(this, 221, 93);
        this.lBiomaskSide3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide3.addBox(-2.0F, -4.0F, -5.0F, 3, 3, 1, 0.0F);
        this.setRotation(lBiomaskSide3, 0.0F, -0.6457718232379019F, 0.0F);
        this.rBiomaskSide1 = new ModelRenderer(this, 207, 104);
        this.rBiomaskSide1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide1.addBox(0.3F, -5.0F, -4.3F, 3, 1, 1, 0.0F);
        this.setRotation(rBiomaskSide1, 0.0F, 1.48352986419518F, 0.0F);
        this.biomaskVisor = new ModelRenderer(this, 176, 82);
        this.biomaskVisor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskVisor.addBox(-3.5F, -6.5F, -5.3F, 7, 3, 1, 0.0F);
        this.setRotation(biomaskVisor, -0.22689280275926282F, -0.0F, 0.0F);
        this.lBiomaskSide1 = new ModelRenderer(this, 221, 104);
        this.lBiomaskSide1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide1.addBox(-3.0F, -5.0F, -4.3F, 3, 1, 1, 0.0F);
        this.setRotation(lBiomaskSide1, 0.0F, -1.48352986419518F, 0.0F);
        this.rBiomaskRidge = new ModelRenderer(this, 180, 101);
        this.rBiomaskRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskRidge.addBox(-4.5F, -10.5F, -8.7F, 3, 10, 1, 0.0F);
        this.setRotation(rBiomaskRidge, -1.1344640137963142F, -0.12217304763960307F, 0.0F);
        this.lBiomaskJaw = new ModelRenderer(this, 65, 0);
        this.lBiomaskJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskJaw.addBox(0.5F, -2.5F, -4.0F, 1, 2, 5, 0.0F);
        this.setRotation(lBiomaskJaw, 0.0F, 0.12217304763960307F, 0.0F);
        this.biomaskHeadPlate = new ModelRenderer(this, 173, 57);
        this.biomaskHeadPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskHeadPlate.addBox(-3.5F, -8.0F, -10.0F, 7, 8, 2, 0.0F);
        this.setRotation(biomaskHeadPlate, -1.2217304763960306F, -0.0F, 0.0F);
        this.lBiomaskSide4 = new ModelRenderer(this, 219, 88);
        this.lBiomaskSide4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide4.addBox(-2.0F, -5.0F, -5.3F, 3, 2, 2, 0.0F);
        this.setRotation(lBiomaskSide4, 0.0F, -0.6457718232379019F, 0.0F);
        this.rBiomaskEye = new ModelRenderer(this, 207, 78);
        this.rBiomaskEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskEye.addBox(-4.2F, -8.0F, -3.2F, 1, 4, 4, 0.0F);
        this.setRotation(rBiomaskEye, 0.0F, -0.17453292519943295F, 0.0F);
        this.lBiomaskRidge = new ModelRenderer(this, 180, 115);
        this.lBiomaskRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskRidge.addBox(1.5F, -10.5F, -8.7F, 3, 10, 1, 0.0F);
        this.setRotation(lBiomaskRidge, -1.1344640137963142F, 0.12217304763960307F, 0.0F);
        this.rBiomaskSide3 = new ModelRenderer(this, 207, 93);
        this.rBiomaskSide3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide3.addBox(-1.0F, -4.0F, -5.0F, 3, 3, 1, 0.0F);
        this.setRotation(rBiomaskSide3, 0.0F, 0.6457718232379019F, 0.0F);
        this.sights = new ModelRenderer(this, 214, 55);
        this.sights.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sights.addBox(-3.5F, -8.9F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotation(sights, 0.2241002759560719F, -0.10367255756846318F, -0.14032447186034408F);
        this.lBiomaskEye = new ModelRenderer(this, 219, 78);
        this.lBiomaskEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskEye.addBox(3.2F, -8.0F, -3.2F, 1, 4, 4, 0.0F);
        this.setRotation(lBiomaskEye, 0.0F, 0.17453292519943295F, 0.0F);
        this.biomaskMouth = new ModelRenderer(this, 180, 87);
        this.biomaskMouth.setRotationPoint(0.0F, 20.9F, 9.1F);
        this.biomaskMouth.addBox(-1.5F, -4.9F, -5.5F, 3, 5, 2, 0.0F);
        this.setRotation(biomaskMouth, 0.5235987755982988F, -0.0F, 0.0F);
        this.mBiomaskJaw = new ModelRenderer(this, 16, 0);
        this.mBiomaskJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mBiomaskJaw.addBox(-1.0F, -2.5F, -4.3F, 2, 2, 5, 0.0F);
        this.biomaskMouth.addChild(this.rBiomaskSide2);
        this.biomaskMouth.addChild(this.biomaskSlope);
        this.biomaskMouth.addChild(this.lBiomaskSide2);
        this.biomaskMouth.addChild(this.rBiomaskSide4);
        this.biomaskMouth.addChild(this.lBiomaskSide3);
        this.biomaskMouth.addChild(this.rBiomaskSide1);
        this.biomaskMouth.addChild(this.biomaskVisor);
        this.biomaskMouth.addChild(this.lBiomaskSide1);
        this.biomaskMouth.addChild(this.rBiomaskRidge);
        this.biomaskMouth.addChild(this.lBiomaskJaw);
        this.biomaskMouth.addChild(this.biomaskHeadPlate);
        this.biomaskMouth.addChild(this.lBiomaskSide4);
        this.biomaskMouth.addChild(this.rBiomaskEye);
        this.biomaskMouth.addChild(this.lBiomaskRidge);
        this.biomaskMouth.addChild(this.rBiomaskSide3);
        this.biomaskMouth.addChild(this.sights);
        this.biomaskMouth.addChild(this.lBiomaskEye);
        this.biomaskMouth.addChild(this.mBiomaskJaw);
    }

    @Override
    public void render(Object obj)
    {
        draw(biomaskMouth);
    }
}
