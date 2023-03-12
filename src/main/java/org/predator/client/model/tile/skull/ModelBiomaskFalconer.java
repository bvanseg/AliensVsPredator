package org.predator.client.model.tile.skull;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.tile.TileEntitySkull;

public class ModelBiomaskFalconer extends Model<TileEntitySkull>
{
    public final ModelRenderer biomaskMouth;
    public final ModelRenderer biomaskVisor;
    public final ModelRenderer biomaskSlope;
    public final ModelRenderer biomaskHeadPlate;
    public final ModelRenderer rBiomaskRidge;
    public final ModelRenderer lBiomaskRidge;
    public final ModelRenderer rBiomaskSide3;
    public final ModelRenderer rBiomaskSide4;
    public final ModelRenderer rBiomaskSide2;
    public final ModelRenderer rBiomaskSide1;
    public final ModelRenderer rBiomaskEye;
    public final ModelRenderer lBiomaskSide4;
    public final ModelRenderer lBiomaskSide3;
    public final ModelRenderer lBiomaskSide2;
    public final ModelRenderer lBiomaskSide1;
    public final ModelRenderer lBiomaskEye;
    public final ModelRenderer sights;
    public final ModelRenderer biomaskBeak1;
    public final ModelRenderer biomaskBeak2;
    public final ModelRenderer rBiomaskRidge02;
    public final ModelRenderer rBiomaskRidge03;
    public final ModelRenderer rBiomaskRidge04;
    public final ModelRenderer lBiomaskRidge02;
    public final ModelRenderer lBiomaskRidge03;
    public final ModelRenderer lBiomaskRidge04;

    public ModelBiomaskFalconer()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.biomaskVisor = new ModelRenderer(this, 176, 82);
        this.biomaskVisor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskVisor.addBox(-3.5F, -6.5F, -5.3F, 7, 3, 1, 0.0F);
        this.setRotation(biomaskVisor, -0.22689280275926282F, -0.0F, 0.0F);
        this.lBiomaskSide2 = new ModelRenderer(this, 221, 98);
        this.lBiomaskSide2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide2.addBox(-3.0F, -4.0F, -4.0F, 3, 3, 1, 0.0F);
        this.setRotation(lBiomaskSide2, 0.0F, -1.413716694115407F, 0.0F);
        this.rBiomaskSide4 = new ModelRenderer(this, 207, 88);
        this.rBiomaskSide4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide4.addBox(-1.0F, -5.0F, -5.3F, 3, 2, 2, 0.0F);
        this.setRotation(rBiomaskSide4, 0.0F, 0.6457718232379019F, 0.0F);
        this.biomaskBeak2 = new ModelRenderer(this, 188, 89);
        this.biomaskBeak2.mirror = true;
        this.biomaskBeak2.setRotationPoint(-1.1F, -4.8F, -4.7F);
        this.biomaskBeak2.addBox(-1.0F, -0.2F, -0.5F, 2, 5, 1, 0.0F);
        this.setRotation(biomaskBeak2, 0.0F, 0.0F, -0.17453292519943295F);
        this.biomaskSlope = new ModelRenderer(this, 174, 69);
        this.biomaskSlope.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskSlope.addBox(-4.0F, 0.0F, -8.9F, 8, 1, 1, 0.0F);
        this.setRotation(biomaskSlope, -1.2217304763960306F, -0.0F, 0.0F);
        this.biomaskHeadPlate = new ModelRenderer(this, 173, 57);
        this.biomaskHeadPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.biomaskHeadPlate.addBox(-3.5F, -8.0F, -10.0F, 7, 8, 2, 0.0F);
        this.setRotation(biomaskHeadPlate, -1.2217304763960306F, -0.0F, 0.0F);
        this.rBiomaskSide1 = new ModelRenderer(this, 207, 104);
        this.rBiomaskSide1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide1.addBox(0.3F, -5.0F, -4.3F, 3, 1, 1, 0.0F);
        this.setRotation(rBiomaskSide1, 0.0F, 1.48352986419518F, 0.0F);
        this.lBiomaskRidge03 = new ModelRenderer(this, 170, 119);
        this.lBiomaskRidge03.setRotationPoint(-0.2F, -1.2F, 0.1F);
        this.lBiomaskRidge03.addBox(-0.8F, -2.9F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotation(lBiomaskRidge03, 0.0F, 0.0F, 0.3490658503988659F);
        this.lBiomaskEye = new ModelRenderer(this, 219, 78);
        this.lBiomaskEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskEye.addBox(3.2F, -8.0F, -3.2F, 1, 4, 4, 0.0F);
        this.setRotation(lBiomaskEye, 0.0F, 0.17453292519943295F, 0.0F);
        this.lBiomaskRidge = new ModelRenderer(this, 180, 115);
        this.lBiomaskRidge.setRotationPoint(0.1F, 0.0F, 0.0F);
        this.lBiomaskRidge.addBox(1.5F, -9.5F, -8.7F, 3, 9, 1, 0.0F);
        this.setRotation(lBiomaskRidge, -1.1344640137963142F, 0.06981317007977318F, 0.0F);
        this.lBiomaskSide4 = new ModelRenderer(this, 219, 88);
        this.lBiomaskSide4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide4.addBox(-2.0F, -5.0F, -5.3F, 3, 2, 2, 0.0F);
        this.setRotation(lBiomaskSide4, 0.0F, -0.6457718232379019F, 0.0F);
        this.rBiomaskRidge = new ModelRenderer(this, 180, 101);
        this.rBiomaskRidge.setRotationPoint(-0.1F, 0.0F, 0.0F);
        this.rBiomaskRidge.addBox(-4.5F, -9.5F, -8.7F, 3, 9, 1, 0.0F);
        this.setRotation(rBiomaskRidge, -1.1344640137963142F, -0.06981317007977318F, 0.0F);
        this.rBiomaskRidge03 = new ModelRenderer(this, 170, 119);
        this.rBiomaskRidge03.mirror = true;
        this.rBiomaskRidge03.setRotationPoint(0.2F, -1.2F, 0.1F);
        this.rBiomaskRidge03.addBox(-0.2F, -2.9F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotation(rBiomaskRidge03, 0.0F, 0.0F, -0.3490658503988659F);
        this.rBiomaskEye = new ModelRenderer(this, 207, 78);
        this.rBiomaskEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskEye.addBox(-4.2F, -8.0F, -3.2F, 1, 4, 4, 0.0F);
        this.setRotation(rBiomaskEye, 0.0F, -0.17453292519943295F, 0.0F);
        this.rBiomaskSide2 = new ModelRenderer(this, 207, 98);
        this.rBiomaskSide2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide2.addBox(0.0F, -4.0F, -4.0F, 3, 3, 1, 0.0F);
        this.setRotation(rBiomaskSide2, 0.0F, 1.413716694115407F, 0.0F);
        this.lBiomaskSide1 = new ModelRenderer(this, 221, 104);
        this.lBiomaskSide1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide1.addBox(-3.0F, -5.0F, -4.3F, 3, 1, 1, 0.0F);
        this.setRotation(lBiomaskSide1, 0.0F, -1.48352986419518F, 0.0F);
        this.biomaskMouth = new ModelRenderer(this, 180, 87);
        this.biomaskMouth.setRotationPoint(0.0F, 21.1F, 8.1F);
        this.biomaskMouth.addBox(-0.5F, -5.2F, -5.5F, 1, 6, 1, 0.0F);
        this.setRotation(biomaskMouth, 0.5235987755982988F, -0.0F, 0.0F);
        this.lBiomaskRidge04 = new ModelRenderer(this, 170, 119);
        this.lBiomaskRidge04.setRotationPoint(0.4F, -0.6F, 0.1F);
        this.lBiomaskRidge04.addBox(-0.5F, -2.3F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotation(lBiomaskRidge04, 0.0F, 0.0F, -0.08726646259971647F);
        this.lBiomaskRidge02 = new ModelRenderer(this, 170, 115);
        this.lBiomaskRidge02.setRotationPoint(3.3F, -8.9F, -8.3F);
        this.lBiomaskRidge02.addBox(-1.0F, -2.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotation(lBiomaskRidge02, 0.0F, 0.0F, -0.2792526803190927F);
        this.rBiomaskRidge04 = new ModelRenderer(this, 170, 119);
        this.rBiomaskRidge04.mirror = true;
        this.rBiomaskRidge04.setRotationPoint(-0.4F, -0.6F, 0.1F);
        this.rBiomaskRidge04.addBox(-0.5F, -2.3F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotation(rBiomaskRidge04, 0.0F, 0.0F, 0.08726646259971647F);
        this.sights = new ModelRenderer(this, 214, 55);
        this.sights.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sights.addBox(-3.5F, -8.9F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotation(sights, 0.2241002759560719F, -0.10367255756846318F, -0.14032447186034408F);
        this.rBiomaskSide3 = new ModelRenderer(this, 207, 93);
        this.rBiomaskSide3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBiomaskSide3.addBox(-1.0F, -4.0F, -5.0F, 3, 3, 1, 0.0F);
        this.setRotation(rBiomaskSide3, 0.0F, 0.6457718232379019F, 0.0F);
        this.lBiomaskSide3 = new ModelRenderer(this, 221, 93);
        this.lBiomaskSide3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBiomaskSide3.addBox(-2.0F, -4.0F, -5.0F, 3, 3, 1, 0.0F);
        this.setRotation(lBiomaskSide3, 0.0F, -0.6457718232379019F, 0.0F);
        this.biomaskBeak1 = new ModelRenderer(this, 188, 89);
        this.biomaskBeak1.setRotationPoint(1.1F, -4.8F, -4.7F);
        this.biomaskBeak1.addBox(-1.0F, -0.2F, -0.5F, 2, 5, 1, 0.0F);
        this.setRotation(biomaskBeak1, 0.0F, 0.0F, 0.17453292519943295F);
        this.rBiomaskRidge02 = new ModelRenderer(this, 170, 115);
        this.rBiomaskRidge02.mirror = true;
        this.rBiomaskRidge02.setRotationPoint(-3.3F, -8.9F, -8.3F);
        this.rBiomaskRidge02.addBox(-1.0F, -2.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotation(rBiomaskRidge02, 0.0F, 0.0F, 0.2792526803190927F);
        this.biomaskMouth.addChild(this.biomaskVisor);
        this.biomaskMouth.addChild(this.lBiomaskSide2);
        this.biomaskMouth.addChild(this.rBiomaskSide4);
        this.biomaskMouth.addChild(this.biomaskBeak2);
        this.biomaskMouth.addChild(this.biomaskSlope);
        this.biomaskMouth.addChild(this.biomaskHeadPlate);
        this.biomaskMouth.addChild(this.rBiomaskSide1);
        this.lBiomaskRidge02.addChild(this.lBiomaskRidge03);
        this.biomaskMouth.addChild(this.lBiomaskEye);
        this.biomaskMouth.addChild(this.lBiomaskRidge);
        this.biomaskMouth.addChild(this.lBiomaskSide4);
        this.biomaskMouth.addChild(this.rBiomaskRidge);
        this.rBiomaskRidge02.addChild(this.rBiomaskRidge03);
        this.biomaskMouth.addChild(this.rBiomaskEye);
        this.biomaskMouth.addChild(this.rBiomaskSide2);
        this.biomaskMouth.addChild(this.lBiomaskSide1);
        this.lBiomaskRidge02.addChild(this.lBiomaskRidge04);
        this.lBiomaskRidge.addChild(this.lBiomaskRidge02);
        this.rBiomaskRidge02.addChild(this.rBiomaskRidge04);
        this.biomaskMouth.addChild(this.sights);
        this.biomaskMouth.addChild(this.rBiomaskSide3);
        this.biomaskMouth.addChild(this.lBiomaskSide3);
        this.biomaskMouth.addChild(this.biomaskBeak1);
        this.rBiomaskRidge.addChild(this.rBiomaskRidge02);
    }

    @Override
    public void render(TileEntitySkull obj)
    {
        draw(biomaskMouth);
    }
}
