package org.avp.client.model.items;

import com.arisux.mdx.lib.client.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * stunBaton - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelStunBaton extends Model {
    public ModelRenderer centralRod;
    public ModelRenderer grip;
    public ModelRenderer rodTip;
    public ModelRenderer rodCone01;
    public ModelRenderer rodCone02;
    public ModelRenderer rodCone03;
    public ModelRenderer coilBase;
    public ModelRenderer handGuard;
    public ModelRenderer handGuardU;
    public ModelRenderer lateralRod010;
    public ModelRenderer lateralRod020;
    public ModelRenderer coil01;
    public ModelRenderer coil02;
    public ModelRenderer coil03;
    public ModelRenderer coil04;
    public ModelRenderer coil05;
    public ModelRenderer coil06;
    public ModelRenderer coil07;
    public ModelRenderer coil08;
    public ModelRenderer handGuardLower;
    public ModelRenderer handGuardLowerU;
    public ModelRenderer lateralRod01A;
    public ModelRenderer lateralRod01B;
    public ModelRenderer lateralRod01C;
    public ModelRenderer lateralRod02A;
    public ModelRenderer lateralRod02B;
    public ModelRenderer lateralRod02C;

    //TODO: Something appears to be goin wrong with the renderin of this model, duplicates one of the handles
    public ModelStunBaton() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.coil06 = new ModelRenderer(this, 25, 5);
        this.coil06.setRotationPoint(0.0F, -0.9F, 0.0F);
        this.coil06.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.grip = new ModelRenderer(this, 7, 0);
        this.grip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.grip.addBox(-0.5F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.coil04 = new ModelRenderer(this, 25, 5);
        this.coil04.setRotationPoint(0.0F, -1.1F, 0.0F);
        this.coil04.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.rodCone02 = new ModelRenderer(this, 28, 12);
        this.rodCone02.setRotationPoint(0.0F, -10.85F, 0.0F);
        this.rodCone02.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.coil02 = new ModelRenderer(this, 25, 5);
        this.coil02.setRotationPoint(0.0F, -1.3F, 0.0F);
        this.coil02.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.lateralRod01B = new ModelRenderer(this, 22, 3);
        this.lateralRod01B.setRotationPoint(-1.8F, 0.2F, 0.0F);
        this.lateralRod01B.addBox(-0.5F, -0.5F, -0.5F, 1, 12, 1, 0.0F);
        this.setRotation(lateralRod01B, 0.0F, 0.0F, 0.5462880558742251F);
        this.rodCone01 = new ModelRenderer(this, 28, 9);
        this.rodCone01.setRotationPoint(0.0F, -10.65F, 0.0F);
        this.rodCone01.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.handGuardLowerU = new ModelRenderer(this, 7, 13);
        this.handGuardLowerU.setRotationPoint(0.0F, 13.1F, 0.1F);
        this.handGuardLowerU.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.lateralRod020 = new ModelRenderer(this, 0, 0);
        this.lateralRod020.setRotationPoint(0.0F, -7.9F, -0.1F);
        this.lateralRod020.addBox(-0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F);
        this.setRotation(lateralRod020, 0.0F, -1.5707963267948966F, 0.0F);
        this.coil01 = new ModelRenderer(this, 25, 5);
        this.coil01.setRotationPoint(0.0F, -1.4F, 0.0F);
        this.coil01.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.lateralRod01A = new ModelRenderer(this, 15, 0);
        this.lateralRod01A.setRotationPoint(-0.1F, 0.0F, 0.0F);
        this.lateralRod01A.addBox(-1.9F, -0.5F, -0.49F, 2, 1, 1, 0.0F);
        this.setRotation(lateralRod01A, 0.0F, 0.0F, -0.5462880558742251F);
        this.centralRod = new ModelRenderer(this, 0, 0);
        this.centralRod.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.centralRod.addBox(-0.5F, -9.0F, -0.5F, 1, 9, 1, 0.0F);
        this.lateralRod010 = new ModelRenderer(this, 0, 0);
        this.lateralRod010.setRotationPoint(-0.1F, -6.9F, 0.0F);
        this.lateralRod010.addBox(-0.5F, 0.0F, -0.5F, 1, 0, 1, 0.0F);
        this.handGuard = new ModelRenderer(this, 7, 7);
        this.handGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handGuard.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.handGuardLower = new ModelRenderer(this, 7, 7);
        this.handGuardLower.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.handGuardLower.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.coil03 = new ModelRenderer(this, 25, 5);
        this.coil03.setRotationPoint(0.0F, -1.2F, 0.0F);
        this.coil03.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.lateralRod02C = new ModelRenderer(this, 15, 0);
        this.lateralRod02C.setRotationPoint(-0.2F, 11.1F, 0.0F);
        this.lateralRod02C.addBox(0.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotation(lateralRod02C, 0.0F, 0.0F, 0.5462880558742251F);
        this.handGuardU = new ModelRenderer(this, 7, 10);
        this.handGuardU.setRotationPoint(0.0F, 0.0F, -0.4F);
        this.handGuardU.addBox(-0.5F, -0.5F, -0.6F, 1, 1, 1, 0.0F);
        this.coilBase = new ModelRenderer(this, 28, 9);
        this.coilBase.setRotationPoint(0.0F, -9.65F, 0.0F);
        this.coilBase.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.lateralRod01C = new ModelRenderer(this, 15, 0);
        this.lateralRod01C.setRotationPoint(-0.2F, 11.1F, 0.0F);
        this.lateralRod01C.addBox(0.0F, -0.5F, -0.49F, 2, 1, 1, 0.0F);
        this.setRotation(lateralRod01C, 0.0F, 0.0F, 0.5462880558742251F);
        this.lateralRod02B = new ModelRenderer(this, 16, 3);
        this.lateralRod02B.setRotationPoint(-1.8F, 0.2F, 0.0F);
        this.lateralRod02B.addBox(-0.5F, -0.5F, -0.5F, 1, 12, 1, 0.0F);
        this.setRotation(lateralRod02B, 0.0F, 0.0F, 0.5462880558742251F);
        this.rodTip = new ModelRenderer(this, 28, 0);
        this.rodTip.setRotationPoint(0.0F, -9.1F, 0.0F);
        this.rodTip.addBox(-0.5F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
        this.coil05 = new ModelRenderer(this, 25, 5);
        this.coil05.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.coil05.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.lateralRod02A = new ModelRenderer(this, 15, 0);
        this.lateralRod02A.setRotationPoint(-0.1F, 0.0F, 0.0F);
        this.lateralRod02A.addBox(-1.9F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotation(lateralRod02A, 0.0F, 0.0F, -0.5462880558742251F);
        this.coil07 = new ModelRenderer(this, 25, 5);
        this.coil07.setRotationPoint(0.0F, -0.8F, 0.0F);
        this.coil07.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.rodCone03 = new ModelRenderer(this, 28, 15);
        this.rodCone03.setRotationPoint(0.0F, -11.05F, 0.0F);
        this.rodCone03.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.coil08 = new ModelRenderer(this, 25, 5);
        this.coil08.setRotationPoint(0.0F, -0.7F, 0.0F);
        this.coil08.addBox(-1.5F, 0.0F, -1.4F, 3, 0, 3, 0.0F);
        this.rodTip.addChild(this.coil06);
        this.rodTip.addChild(this.coil04);
        this.rodTip.addChild(this.coil02);
        this.lateralRod01A.addChild(this.lateralRod01B);
        this.handGuardU.addChild(this.handGuardLowerU);
        this.rodTip.addChild(this.coil01);
        this.lateralRod010.addChild(this.lateralRod01A);
        this.handGuard.addChild(this.handGuardLower);
        this.rodTip.addChild(this.coil03);
        this.lateralRod02B.addChild(this.lateralRod02C);
        this.lateralRod01B.addChild(this.lateralRod01C);
        this.lateralRod02A.addChild(this.lateralRod02B);
        this.rodTip.addChild(this.coil05);
        this.lateralRod020.addChild(this.lateralRod02A);
        this.rodTip.addChild(this.coil07);
        this.rodTip.addChild(this.coil08);
    }

    @Override
    public void render(Object obj)
    {
    	draw(rodTip);
        draw(handGuardU);
        draw(lateralRod010);
        draw(lateralRod020);
        draw(lateralRod01A);
        draw(lateralRod01B);
        draw(lateralRod02A);
        draw(lateralRod02B);
    }
}
