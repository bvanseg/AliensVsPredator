package org.avp.client.model.tile.skulls;

import org.avp.tile.TileEntitySkull;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelBiomaskBerserker extends Model<TileEntitySkull>
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
    public ModelRenderer biomaskJawBone;
    public ModelRenderer lBiomaskJawBone;
    public ModelRenderer biomaskJawBone2;
    public ModelRenderer biomaskFangsFront;
    public ModelRenderer lBiomaskJawBone2;
    public ModelRenderer rBiomaskJawBone;
    public ModelRenderer lBiomaskJawBone3;
    public ModelRenderer lBiomaskTeeth;
    public ModelRenderer lBiomaskJawBone2b;
    public ModelRenderer lBiomaskJawBone4;
    public ModelRenderer rBiomaskJawBone2;
    public ModelRenderer rBiomaskJawBone2b;
    public ModelRenderer rBiomaskTeeth;
    public ModelRenderer rBiomaskJawBone3;
    public ModelRenderer rBiomaskJawBone4;

    public ModelBiomaskBerserker()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.lBiomaskJawBone3 = new ModelRenderer(this, 238, 69);
        this.lBiomaskJawBone3.setRotationPoint(-0.4F, 0.3F, 2.0F);
        this.lBiomaskJawBone3.addBox(-0.4F, -0.9F, -0.1F, 1, 1, 3, 0.0F);
        this.setRotation(lBiomaskJawBone3, 0.18203784098300857F, -0.27314402793711257F, 0.0F);
        this.rBiomaskJawBone2 = new ModelRenderer(this, 227, 69);
        this.rBiomaskJawBone2.mirror = true;
        this.rBiomaskJawBone2.setRotationPoint(-1.5F, 0.5F, 2.4F);
        this.rBiomaskJawBone2.addBox(-0.7F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotation(rBiomaskJawBone2, 0.27314402793711257F, 0.18203784098300857F, 0.0F);
        this.mBiomaskJaw = new ModelRenderer(this, 16, 0);
        this.mBiomaskJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mBiomaskJaw.addBox(-1.0F, -2.5F, -4.3F, 2, 2, 5, 0.0F);
        this.biomaskHeadPlate = new ModelRenderer(this, 173, 57);
        this.biomaskHeadPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskHeadPlate.addBox(-3.5F, -8.0F, -10.0F, 7, 8, 2, 0.0F);
        this.setRotation(biomaskHeadPlate, -1.2217304763960306F, -0.0F, 0.0F);
        this.lBiomaskTeeth = new ModelRenderer(this, 222, 74);
        this.lBiomaskTeeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskTeeth.addBox(0.16F, -1.5F, -0.1F, 0, 1, 2, 0.0F);
        this.rBiomaskRidge = new ModelRenderer(this, 180, 101);
        this.rBiomaskRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskRidge.addBox(-4.5F, -10.5F, -8.7F, 3, 10, 1, 0.0F);
        this.setRotation(rBiomaskRidge, -1.1344640137963142F, -0.12217304763960307F, 0.0F);
        this.rBiomaskJawBone3 = new ModelRenderer(this, 238, 69);
        this.rBiomaskJawBone3.mirror = true;
        this.rBiomaskJawBone3.setRotationPoint(0.9F, 0.3F, 1.7F);
        this.rBiomaskJawBone3.addBox(-1.5F, -0.9F, -0.1F, 1, 1, 3, 0.0F);
        this.setRotation(rBiomaskJawBone3, 0.18203784098300857F, 0.27314402793711257F, 0.0F);
        this.lBiomaskRidge = new ModelRenderer(this, 180, 115);
        this.lBiomaskRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskRidge.addBox(1.5F, -10.5F, -8.7F, 3, 10, 1, 0.0F);
        this.setRotation(lBiomaskRidge, -1.1344640137963142F, 0.12217304763960307F, 0.0F);
        this.rBiomaskTeeth = new ModelRenderer(this, 222, 74);
        this.rBiomaskTeeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskTeeth.addBox(-0.55F, -1.5F, -0.1F, 0, 1, 2, 0.0F);
        this.lBiomaskJawBone2b = new ModelRenderer(this, 227, 69);
        this.lBiomaskJawBone2b.mirror = true;
        this.lBiomaskJawBone2b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskJawBone2b.addBox(-0.8F, -0.8F, 0.3F, 1, 1, 2, 0.0F);
        this.lBiomaskSide2 = new ModelRenderer(this, 221, 98);
        this.lBiomaskSide2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide2.addBox(-3.0F, -4.0F, -4.0F, 3, 3, 1, 0.0F);
        this.setRotation(lBiomaskSide2, 0.0F, -1.413716694115407F, 0.0F);
        this.rBiomaskSide1 = new ModelRenderer(this, 207, 104);
        this.rBiomaskSide1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide1.addBox(0.3F, -5.0F, -4.3F, 3, 1, 1, 0.0F);
        this.setRotation(rBiomaskSide1, 0.0F, 1.48352986419518F, 0.0F);
        this.lBiomaskSide1 = new ModelRenderer(this, 221, 104);
        this.lBiomaskSide1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide1.addBox(-3.0F, -5.0F, -4.3F, 3, 1, 1, 0.0F);
        this.setRotation(lBiomaskSide1, 0.0F, -1.48352986419518F, 0.0F);
        this.biomaskVisor = new ModelRenderer(this, 176, 82);
        this.biomaskVisor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskVisor.addBox(-3.5F, -6.5F, -5.3F, 7, 3, 1, 0.0F);
        this.setRotation(biomaskVisor, -0.22689280275926282F, -0.0F, 0.0F);
        this.rBiomaskSide2 = new ModelRenderer(this, 207, 98);
        this.rBiomaskSide2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide2.addBox(0.0F, -4.0F, -4.0F, 3, 3, 1, 0.0F);
        this.setRotation(rBiomaskSide2, 0.0F, 1.413716694115407F, 0.0F);
        this.biomaskSlope = new ModelRenderer(this, 174, 69);
        this.biomaskSlope.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskSlope.addBox(-4.0F, 0.0F, -8.9F, 8, 1, 1, 0.0F);
        this.setRotation(biomaskSlope, -1.2217304763960306F, -0.0F, 0.0F);
        this.rBiomaskJawBone = new ModelRenderer(this, 216, 69);
        this.rBiomaskJawBone.mirror = true;
        this.rBiomaskJawBone.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskJawBone.addBox(-2.2F, 0.0F, 0.6F, 1, 1, 2, 0.0F);
        this.setRotation(rBiomaskJawBone, 0.0F, -1.4570008595648662F, 0.0F);
        this.sights = new ModelRenderer(this, 214, 55);
        this.sights.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sights.addBox(-3.5F, -8.9F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotation(sights, 0.2241002759560719F, -0.10367255756846318F, -0.14032447186034408F);
        this.biomaskFangsFront = new ModelRenderer(this, 222, 63);
        this.biomaskFangsFront.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskFangsFront.addBox(-2.0F, -1.6F, -0.3F, 4, 1, 0, 0.0F);
        this.biomaskMouth = new ModelRenderer(this, 180, 87);
        this.biomaskMouth.setRotationPoint(0.0F, 20.9F, 9.1F);
        this.biomaskMouth.addBox(-1.5F, -4.9F, -5.5F, 3, 5, 2, 0.0F);
        this.setRotation(biomaskMouth, 0.5235987755982988F, -0.0F, 0.0F);
        this.lBiomaskEye = new ModelRenderer(this, 219, 78);
        this.lBiomaskEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskEye.addBox(3.2F, -8.0F, -3.2F, 1, 4, 4, 0.0F);
        this.setRotation(lBiomaskEye, 0.0F, 0.17453292519943295F, 0.0F);
        this.lBiomaskJaw = new ModelRenderer(this, 65, 0);
        this.lBiomaskJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskJaw.addBox(0.5F, -2.5F, -4.0F, 1, 2, 5, 0.0F);
        this.setRotation(lBiomaskJaw, 0.0F, 0.12217304763960307F, 0.0F);
        this.rBiomaskSide4 = new ModelRenderer(this, 207, 88);
        this.rBiomaskSide4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide4.addBox(-1.0F, -5.0F, -5.3F, 3, 2, 2, 0.0F);
        this.setRotation(rBiomaskSide4, 0.0F, 0.6457718232379019F, 0.0F);
        this.lBiomaskSide4 = new ModelRenderer(this, 219, 88);
        this.lBiomaskSide4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide4.addBox(-2.0F, -5.0F, -5.3F, 3, 2, 2, 0.0F);
        this.setRotation(lBiomaskSide4, 0.0F, -0.6457718232379019F, 0.0F);
        this.biomaskJawBone = new ModelRenderer(this, 200, 69);
        this.biomaskJawBone.setRotationPoint(0.0F, -0.9F, -5.4F);
        this.biomaskJawBone.addBox(-2.0F, -0.7F, -0.5F, 4, 1, 1, 0.0F);
        this.setRotation(biomaskJawBone, 0.136659280431156F, 0.0F, 0.0F);
        this.rBiomaskJawBone2b = new ModelRenderer(this, 227, 69);
        this.rBiomaskJawBone2b.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskJawBone2b.addBox(-0.6F, -0.8F, 0.3F, 1, 1, 2, 0.0F);
        this.lBiomaskSide3 = new ModelRenderer(this, 221, 93);
        this.lBiomaskSide3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide3.addBox(-2.0F, -4.0F, -5.0F, 3, 3, 1, 0.0F);
        this.setRotation(lBiomaskSide3, 0.0F, -0.6457718232379019F, 0.0F);
        this.lBiomaskJawBone4 = new ModelRenderer(this, 238, 76);
        this.lBiomaskJawBone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskJawBone4.addBox(-0.5F, -1.6F, 0.9F, 1, 1, 2, 0.0F);
        this.rBiomaskSide3 = new ModelRenderer(this, 207, 93);
        this.rBiomaskSide3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide3.addBox(-1.0F, -4.0F, -5.0F, 3, 3, 1, 0.0F);
        this.setRotation(rBiomaskSide3, 0.0F, 0.6457718232379019F, 0.0F);
        this.biomaskJawBone2 = new ModelRenderer(this, 200, 75);
        this.biomaskJawBone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskJawBone2.addBox(-2.0F, 0.1F, -0.4F, 4, 1, 1, 0.0F);
        this.lBiomaskJawBone2 = new ModelRenderer(this, 227, 69);
        this.lBiomaskJawBone2.setRotationPoint(1.9F, 0.5F, 2.4F);
        this.lBiomaskJawBone2.addBox(-0.7F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotation(lBiomaskJawBone2, 0.27314402793711257F, -0.18203784098300857F, 0.0F);
        this.rBiomaskEye = new ModelRenderer(this, 207, 78);
        this.rBiomaskEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskEye.addBox(-4.2F, -8.0F, -3.2F, 1, 4, 4, 0.0F);
        this.setRotation(rBiomaskEye, 0.0F, -0.17453292519943295F, 0.0F);
        this.lBiomaskJawBone = new ModelRenderer(this, 216, 69);
        this.lBiomaskJawBone.setRotationPoint(0.0F, 0.0F, 0.6F);
        this.lBiomaskJawBone.addBox(1.2F, 0.0F, 0.6F, 1, 1, 2, 0.0F);
        this.setRotation(lBiomaskJawBone, 0.0F, 0.7285004297824331F, 0.0F);
        this.rBiomaskJawBone4 = new ModelRenderer(this, 238, 76);
        this.rBiomaskJawBone4.mirror = true;
        this.rBiomaskJawBone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskJawBone4.addBox(-1.4F, -1.6F, 0.9F, 1, 1, 2, 0.0F);
        this.lBiomaskJawBone2.addChild(this.lBiomaskJawBone3);
        this.rBiomaskJawBone.addChild(this.rBiomaskJawBone2);
        this.biomaskMouth.addChild(this.mBiomaskJaw);
        this.biomaskMouth.addChild(this.biomaskHeadPlate);
        this.lBiomaskJawBone2.addChild(this.lBiomaskTeeth);
        this.biomaskMouth.addChild(this.rBiomaskRidge);
        this.rBiomaskJawBone2.addChild(this.rBiomaskJawBone3);
        this.biomaskMouth.addChild(this.lBiomaskRidge);
        this.rBiomaskJawBone2.addChild(this.rBiomaskTeeth);
        this.lBiomaskJawBone2.addChild(this.lBiomaskJawBone2b);
        this.biomaskMouth.addChild(this.lBiomaskSide2);
        this.biomaskMouth.addChild(this.rBiomaskSide1);
        this.biomaskMouth.addChild(this.lBiomaskSide1);
        this.biomaskMouth.addChild(this.biomaskVisor);
        this.biomaskMouth.addChild(this.rBiomaskSide2);
        this.biomaskMouth.addChild(this.biomaskSlope);
        this.lBiomaskJawBone.addChild(this.rBiomaskJawBone);
        this.biomaskMouth.addChild(this.sights);
        this.biomaskJawBone.addChild(this.biomaskFangsFront);
        this.biomaskMouth.addChild(this.lBiomaskEye);
        this.biomaskMouth.addChild(this.lBiomaskJaw);
        this.biomaskMouth.addChild(this.rBiomaskSide4);
        this.biomaskMouth.addChild(this.lBiomaskSide4);
        this.biomaskMouth.addChild(this.biomaskJawBone);
        this.rBiomaskJawBone2.addChild(this.rBiomaskJawBone2b);
        this.biomaskMouth.addChild(this.lBiomaskSide3);
        this.lBiomaskJawBone3.addChild(this.lBiomaskJawBone4);
        this.biomaskMouth.addChild(this.rBiomaskSide3);
        this.biomaskJawBone.addChild(this.biomaskJawBone2);
        this.lBiomaskJawBone.addChild(this.lBiomaskJawBone2);
        this.biomaskMouth.addChild(this.rBiomaskEye);
        this.biomaskJawBone.addChild(this.lBiomaskJawBone);
        this.rBiomaskJawBone3.addChild(this.rBiomaskJawBone4);
    }

    @Override
    public void render(TileEntitySkull obj)
    {
        draw(biomaskMouth);
    }
}
