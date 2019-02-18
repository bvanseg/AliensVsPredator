package org.avp.client.model.tile;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelDNASynthesizer extends Model
{
    public ModelRenderer tankFloor;
    public ModelRenderer supportBar;
    public ModelRenderer baseN;
    public ModelRenderer glassN;
    public ModelRenderer capN;
    public ModelRenderer tankLid;
    public ModelRenderer base;
    public ModelRenderer frame;
    public ModelRenderer lFrameSupport;
    public ModelRenderer rFrameSupport;
    public ModelRenderer vial1;
    public ModelRenderer vial2;
    public ModelRenderer vial3;
    public ModelRenderer injector;
    public ModelRenderer injectorNeedle;
    public ModelRenderer injectorFluid;
    public ModelRenderer tube1;
    public ModelRenderer tube2;
    public ModelRenderer tube3;
    public ModelRenderer tube4;
    public ModelRenderer tube5;
    public ModelRenderer vial1Fluid;
    public ModelRenderer vial2Fluid;
    public ModelRenderer vial3Fluid;
    public ModelRenderer baseNE;
    public ModelRenderer baseE;
    public ModelRenderer baseSE;
    public ModelRenderer baseNW;
    public ModelRenderer baseW;
    public ModelRenderer baseSW;
    public ModelRenderer glassNE;
    public ModelRenderer glassE;
    public ModelRenderer glassSE;
    public ModelRenderer glassNW;
    public ModelRenderer glassW;
    public ModelRenderer glassSW;
    public ModelRenderer capNE;
    public ModelRenderer capE;
    public ModelRenderer capSE;
    public ModelRenderer capNW;
    public ModelRenderer capW;
    public ModelRenderer capSW;

    public ModelDNASynthesizer()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.capNE = new ModelRenderer(this, 0, 50);
        this.capNE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.capNE.addBox(-3.5F, -18.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(capNE, 0.0F, 0.7853981633974483F, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-7.5F, 16.0F, -3.0F, 15, 8, 10, 0.0F);
        this.capNW = new ModelRenderer(this, 0, 50);
        this.capNW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.capNW.addBox(-3.5F, -18.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(capNW, 0.0F, -0.7853981633974483F, 0.0F);
        this.tankLid = new ModelRenderer(this, 52, 21);
        this.tankLid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tankLid.addBox(7.5F, 5.3F, -8.5F, 17, 0, 17, 0.0F);
        this.glassNE = new ModelRenderer(this, 107, 47);
        this.glassNE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.glassNE.addBox(-3.0F, -14.8F, 7.2F, 6, 15, 0, 0.0F);
        this.setRotation(glassNE, 0.0F, 0.7853981633974483F, 0.0F);
        this.tankFloor = new ModelRenderer(this, 52, 21);
        this.tankFloor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tankFloor.addBox(7.5F, 24.0F, -8.5F, 17, 0, 17, 0.0F);
        this.glassE = new ModelRenderer(this, 93, 47);
        this.glassE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.glassE.addBox(-3.0F, -14.8F, 7.2F, 6, 15, 0, 0.0F);
        this.setRotation(glassE, 0.0F, 1.5707963267948966F, 0.0F);
        this.vial1 = new ModelRenderer(this, 15, 29);
        this.vial1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.vial1.addBox(-5.0F, 9.5F, 2.5F, 2, 5, 2, 0.0F);
        this.baseE = new ModelRenderer(this, 0, 50);
        this.baseE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseE.addBox(-3.5F, 10.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(baseE, 0.0F, 1.5707963267948966F, 0.0F);
        this.tube3 = new ModelRenderer(this, 92, 0);
        this.tube3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tube3.addBox(1.1F, 8.5F, -0.2F, 4, 8, 0, 0.0F);
        this.setRotation(tube3, 0.0F, -0.7853981633974483F, 0.0F);
        this.vial1Fluid = new ModelRenderer(this, 17, 37);
        this.vial1Fluid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.vial1Fluid.addBox(-4.5F, 11.0F, 3.0F, 1, 3, 1, 0.0F);
        this.rFrameSupport = new ModelRenderer(this, 0, 32);
        this.rFrameSupport.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rFrameSupport.addBox(5.9F, 10.7F, 1.5F, 1, 6, 4, 0.0F);
        this.lFrameSupport = new ModelRenderer(this, 0, 32);
        this.lFrameSupport.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lFrameSupport.addBox(-7.1F, 10.7F, 1.5F, 1, 6, 4, 0.0F);
        this.baseNW = new ModelRenderer(this, 0, 50);
        this.baseNW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseNW.addBox(-3.5F, 10.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(baseNW, 0.0F, -0.7853981633974483F, 0.0F);
        this.vial3 = new ModelRenderer(this, 37, 29);
        this.vial3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.vial3.addBox(3.0F, 9.5F, 2.5F, 2, 5, 2, 0.0F);
        this.baseSW = new ModelRenderer(this, 0, 50);
        this.baseSW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseSW.addBox(-3.5F, 10.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(baseSW, 0.0F, -2.356194490192345F, 0.0F);
        this.tube1 = new ModelRenderer(this, 74, 0);
        this.tube1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tube1.addBox(-4.4F, 8.5F, 5.3F, 4, 8, 0, 0.0F);
        this.setRotation(tube1, 0.0F, -0.7853981633974483F, 0.0F);
        this.glassSE = new ModelRenderer(this, 79, 47);
        this.glassSE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.glassSE.addBox(-3.0F, -14.8F, 7.2F, 6, 15, 0, 0.0F);
        this.setRotation(glassSE, 0.0F, 2.356194490192345F, 0.0F);
        this.injectorNeedle = new ModelRenderer(this, 62, 22);
        this.injectorNeedle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.injectorNeedle.addBox(15.5F, 9.1F, 1.0F, 1, 2, 0, 0.0F);
        this.supportBar = new ModelRenderer(this, 52, 0);
        this.supportBar.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.supportBar.addBox(12.5F, 6.0F, 6.3F, 8, 18, 2, 0.0F);
        this.glassN = new ModelRenderer(this, 65, 47);
        this.glassN.setRotationPoint(16.0F, 22.0F, 0.0F);
        this.glassN.addBox(-3.0F, -14.8F, -7.2F, 6, 15, 0, 0.0F);
        this.glassNW = new ModelRenderer(this, 23, 47);
        this.glassNW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.glassNW.addBox(-3.0F, -14.8F, 7.2F, 6, 15, 0, 0.0F);
        this.setRotation(glassNW, 0.0F, -0.7853981633974483F, 0.0F);
        this.tube4 = new ModelRenderer(this, 102, 0);
        this.tube4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tube4.addBox(3.1F, 3.8F, 4.2F, 4, 12, 0, 0.0F);
        this.setRotation(tube4, 0.0F, 0.22759093446006054F, 0.0F);
        this.injector = new ModelRenderer(this, 51, 22);
        this.injector.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.injector.addBox(15.0F, 5.2F, 0.0F, 2, 4, 2, 0.0F);
        this.tube5 = new ModelRenderer(this, 74, 12);
        this.tube5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tube5.addBox(7.0F, 3.8F, 4.2F, 8, 2, 0, 0.0F);
        this.setRotation(tube5, 0.0F, 0.22759093446006054F, 0.0F);
        this.vial3Fluid = new ModelRenderer(this, 40, 37);
        this.vial3Fluid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.vial3Fluid.addBox(3.5F, 11.0F, 3.0F, 1, 3, 1, 0.0F);
        this.capE = new ModelRenderer(this, 0, 50);
        this.capE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.capE.addBox(-3.5F, -18.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(capE, 0.0F, 1.5707963267948966F, 0.0F);
        this.capSE = new ModelRenderer(this, 0, 50);
        this.capSE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.capSE.addBox(-3.5F, -18.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(capSE, 0.0F, 2.356194490192345F, 0.0F);
        this.vial2 = new ModelRenderer(this, 26, 29);
        this.vial2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.vial2.addBox(-2.0F, 9.5F, 2.5F, 2, 5, 2, 0.0F);
        this.injectorFluid = new ModelRenderer(this, 53, 31);
        this.injectorFluid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.injectorFluid.addBox(15.5F, 5.8F, 0.5F, 1, 3, 1, 0.0F);
        this.baseNE = new ModelRenderer(this, 0, 50);
        this.baseNE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseNE.addBox(-3.5F, 10.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(baseNE, 0.0F, 0.7853981633974483F, 0.0F);
        this.capN = new ModelRenderer(this, 0, 50);
        this.capN.setRotationPoint(16.0F, 23.3F, 0.0F);
        this.capN.addBox(-3.5F, -18.0F, -8.5F, 7, 2, 3, 0.0F);
        this.baseW = new ModelRenderer(this, 0, 50);
        this.baseW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseW.addBox(-3.5F, 10.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(baseW, 0.0F, -1.5707963267948966F, 0.0F);
        this.glassSW = new ModelRenderer(this, 51, 47);
        this.glassSW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.glassSW.addBox(-3.0F, -14.8F, 7.2F, 6, 15, 0, 0.0F);
        this.setRotation(glassSW, 0.0F, -2.356194490192345F, 0.0F);
        this.tube2 = new ModelRenderer(this, 83, 0);
        this.tube2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tube2.addBox(-3.4F, 8.5F, 1.7F, 4, 8, 0, 0.0F);
        this.setRotation(tube2, 0.0F, 0.7853981633974483F, 0.0F);
        this.vial2Fluid = new ModelRenderer(this, 28, 37);
        this.vial2Fluid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.vial2Fluid.addBox(-1.5F, 11.0F, 3.0F, 1, 3, 1, 0.0F);
        this.capW = new ModelRenderer(this, 0, 50);
        this.capW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.capW.addBox(-3.5F, -18.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(capW, 0.0F, -1.5707963267948966F, 0.0F);
        this.baseN = new ModelRenderer(this, 0, 50);
        this.baseN.setRotationPoint(16.0F, 12.0F, 0.0F);
        this.baseN.addBox(-3.5F, 10.0F, -8.5F, 7, 2, 3, 0.0F);
        this.glassW = new ModelRenderer(this, 37, 47);
        this.glassW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.glassW.addBox(-3.0F, -14.8F, 7.2F, 6, 15, 0, 0.0F);
        this.setRotation(glassW, 0.0F, -1.5707963267948966F, 0.0F);
        this.baseSE = new ModelRenderer(this, 0, 50);
        this.baseSE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseSE.addBox(-3.5F, 10.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(baseSE, 0.0F, 2.356194490192345F, 0.0F);
        this.capSW = new ModelRenderer(this, 0, 50);
        this.capSW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.capSW.addBox(-3.5F, -18.0F, 5.5F, 7, 2, 3, 0.0F);
        this.setRotation(capSW, 0.0F, -2.356194490192345F, 0.0F);
        this.frame = new ModelRenderer(this, 0, 22);
        this.frame.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frame.addBox(-7.1F, 10.7F, 1.5F, 14, 1, 4, 0.0F);
        this.capN.addChild(this.capNE);
        this.capN.addChild(this.capNW);
        this.glassN.addChild(this.glassNE);
        this.glassN.addChild(this.glassE);
        this.baseN.addChild(this.baseE);
        this.baseN.addChild(this.baseNW);
        this.baseN.addChild(this.baseSW);
        this.glassN.addChild(this.glassSE);
        this.glassN.addChild(this.glassNW);
        this.capN.addChild(this.capE);
        this.capN.addChild(this.capSE);
        this.baseN.addChild(this.baseNE);
        this.baseN.addChild(this.baseW);
        this.glassN.addChild(this.glassSW);
        this.capN.addChild(this.capW);
        this.glassN.addChild(this.glassW);
        this.baseN.addChild(this.baseSE);
        this.capN.addChild(this.capSW);
    }
    
    @Override
    public void render(Object obj)
    {
        draw(base);
        draw(tankLid);
        draw(tankFloor);
        draw(vial1);
        draw(tube3);
        draw(vial1Fluid);
        draw(rFrameSupport);
        draw(lFrameSupport);
        draw(vial3);
        draw(tube1);
        draw(injectorNeedle);
        draw(supportBar);
        draw(glassN);
        draw(tube4);
        draw(injector);
        draw(tube5);
        draw(vial3Fluid);
        draw(vial2);
        draw(injectorFluid);
        draw(capN);
        draw(tube2);
        draw(vial2Fluid);
        draw(baseN);
        draw(frame);
    }
}
