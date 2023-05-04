package org.power.client.model.tile;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.power.common.tile.TileEntityTurret;

public class ModelTurret extends Model<TileEntityTurret>
{
    private final ModelRenderer barrel;
    private final ModelRenderer supportLeft;
    private final ModelRenderer headBase2;
    private final ModelRenderer neckBase;
    private final ModelRenderer headBase3;
    private final ModelRenderer headBase;
    private final ModelRenderer barrelGuard;
    private final ModelRenderer sightBase3;
    private final ModelRenderer rightFoot;
    private final ModelRenderer supportRight;
    private final ModelRenderer supportCenter;
    private final ModelRenderer centerFoot;
    private final ModelRenderer legHub;
    private final ModelRenderer LeftFoot;
    private final ModelRenderer neck;
    private final ModelRenderer leftLeg;
    private final ModelRenderer rightLeg;
    private final ModelRenderer centerLeg;

    public ModelTurret()
    {
        textureWidth = 64;
        textureHeight = 32;

        barrel = new ModelRenderer(this, 19, 22);
        barrel.addBox(-0.5F, -1.2F, 10F, 1, 1, 6);
        barrel.setRotationPoint(0F, 11F, 0F);
        barrel.mirror = true;
        setRotation(barrel, 0F, 0F, 0F);
        supportLeft = new ModelRenderer(this, 43, 22);
        supportLeft.addBox(-0.5F, -0.8F, -3F, 1, 4, 1);
        supportLeft.setRotationPoint(0F, 11F, 0F);
        supportLeft.mirror = true;
        setRotation(supportLeft, 0.6108652F, -2.617994F, 0F);
        headBase2 = new ModelRenderer(this, 19, 0);
        headBase2.addBox(-2F, -3F, -3.5F, 4, 4, 7);
        headBase2.setRotationPoint(0F, 11F, 0F);
        headBase2.mirror = true;
        setRotation(headBase2, 0F, 0F, 0F);
        neckBase = new ModelRenderer(this, 42, 0);
        neckBase.addBox(-1.5F, 3.6F, -1.5F, 3, 1, 3);
        neckBase.setRotationPoint(0F, 11F, 0F);
        neckBase.mirror = true;
        setRotation(neckBase, 0F, 0.7853982F, 0F);
        headBase3 = new ModelRenderer(this, 19, 12);
        headBase3.addBox(-2.5F, -1F, -4F, 5, 1, 8);
        headBase3.setRotationPoint(0F, 11F, 0F);
        headBase3.mirror = true;
        setRotation(headBase3, 0F, 0F, 0F);
        headBase = new ModelRenderer(this, 0, 0);
        headBase.addBox(-1.5F, -1F, -1.5F, 3, 3, 3);
        headBase.setRotationPoint(0F, 11F, 0F);
        headBase.mirror = true;
        setRotation(headBase, 0F, 0F, 0F);
        barrelGuard = new ModelRenderer(this, 0, 9);
        barrelGuard.addBox(-1F, -1.5F, 3.5F, 2, 2, 7);
        barrelGuard.setRotationPoint(0F, 11F, 0F);
        barrelGuard.mirror = true;
        setRotation(barrelGuard, 0F, 0F, 0F);
        sightBase3 = new ModelRenderer(this, 0, 19);
        sightBase3.addBox(-0.5F, -2.2F, 3.5F, 1, 2, 8);
        sightBase3.setRotationPoint(0F, 11F, 0F);
        sightBase3.mirror = true;
        setRotation(sightBase3, 0F, 0F, 0F);
        rightFoot = new ModelRenderer(this, 53, 5);
        rightFoot.addBox(2.1F, 12F, 0F, 2, 1, 3);
        rightFoot.setRotationPoint(0F, 11F, 0F);
        rightFoot.mirror = true;
        setRotation(rightFoot, 0F, -2.495821F, 0F);
        supportRight = new ModelRenderer(this, 43, 22);
        supportRight.addBox(-0.5F, -0.8F, -3F, 1, 4, 1);
        supportRight.setRotationPoint(0F, 11F, 0F);
        supportRight.mirror = true;
        setRotation(supportRight, 0.6108652F, 2.617994F, 0F);
        supportCenter = new ModelRenderer(this, 34, 22);
        supportCenter.addBox(-0.5F, -0.8F, -3F, 1, 4, 3);
        supportCenter.setRotationPoint(0F, 11F, 0F);
        supportCenter.mirror = true;
        setRotation(supportCenter, 0.6108652F, 0F, 0F);
        centerFoot = new ModelRenderer(this, 53, 5);
        centerFoot.addBox(-1F, 12F, 6.1F, 2, 1, 3);
        centerFoot.setRotationPoint(0F, 11F, 0F);
        centerFoot.mirror = true;
        setRotation(centerFoot, 0F, 0F, 0F);
        legHub = new ModelRenderer(this, 42, 5);
        legHub.addBox(-1.5F, 8.2F, -4.5F, 3, 3, 2);
        legHub.setRotationPoint(0F, 11F, 0F);
        legHub.mirror = true;
        setRotation(legHub, 0.8726646F, 0F, 0F);
        LeftFoot = new ModelRenderer(this, 53, 5);
        LeftFoot.addBox(-3.9F, 12F, 0F, 2, 1, 3);
        LeftFoot.setRotationPoint(0F, 11F, 0F);
        LeftFoot.mirror = true;
        setRotation(LeftFoot, 0F, 2.530727F, 0F);
        neck = new ModelRenderer(this, 46, 12);
        neck.addBox(-1F, 2.2F, -4F, 2, 8, 1);
        neck.setRotationPoint(0F, 11F, 0F);
        neck.mirror = true;
        setRotation(neck, 0.8726646F, 0F, 0F);
        leftLeg = new ModelRenderer(this, 53, 12);
        leftLeg.addBox(-3.4F, 2.8F, -10F, 1, 7, 2);
        leftLeg.setRotationPoint(0F, 11F, 0F);
        leftLeg.mirror = true;
        setRotation(leftLeg, 0.8726646F, 2.530727F, 0F);
        rightLeg = new ModelRenderer(this, 53, 12);
        rightLeg.addBox(2.6F, 2.8F, -10F, 1, 7, 2);
        rightLeg.setRotationPoint(0F, 11F, 0F);
        rightLeg.mirror = true;
        setRotation(rightLeg, 0.8726646F, -2.495821F, 0F);
        centerLeg = new ModelRenderer(this, 48, 22);
        centerLeg.addBox(-1F, 10.4F, 0.1F, 2, 5, 1);
        centerLeg.setRotationPoint(0F, 11F, 0F);
        centerLeg.mirror = true;
        setRotation(centerLeg, 0.4712389F, 0F, 0F);
    }

    @Override
    public void render(TileEntityTurret obj)
    {
        if (obj != null)
        {
        	float yawOffset = 0F;
        	
        	switch (obj.getRotationYAxis()) {
	        	case SOUTH:
	        		yawOffset = 0F;
	        		break;
	        	case NORTH:
	        		yawOffset = 180F * ((float)Math.PI / 180F);
	        		break;
	        	case EAST:
	        		yawOffset = -90F * ((float)Math.PI / 180F);
	        		break;
	        	case WEST:
	        		yawOffset = 90F * ((float)Math.PI / 180F);
	        		break;
	    		default:
	    			break;
        	}
        	
            float rotationYaw = -obj.getLookHelper().getRotationYaw() / (180F / (float) Math.PI);
            float rotationYawPrev = -obj.getLookHelper().getRotationPrev().yaw / (180F / (float) Math.PI);
            
            float rotationPitch = -obj.getLookHelper().getRotationPitch() / (180F / (float) Math.PI);
            float rotationPitchPrev = -obj.getLookHelper().getRotationPrev().pitch / (180F / (float) Math.PI);

            rotationYaw = yawOffset + rotationYawPrev + (rotationYaw - rotationYawPrev) * ClientGame.instance.partialTicks();
            rotationPitch = rotationPitchPrev + (rotationPitch - rotationPitchPrev) * ClientGame.instance.partialTicks();

            barrel.rotateAngleY = rotationYaw;
            barrel.rotateAngleX = rotationPitch;
            headBase.rotateAngleY = rotationYaw;
            headBase.rotateAngleX = rotationPitch;
            headBase3.rotateAngleY = rotationYaw;
            headBase3.rotateAngleX = rotationPitch;
            barrelGuard.rotateAngleY = rotationYaw;
            barrelGuard.rotateAngleX = rotationPitch;
            sightBase3.rotateAngleY = rotationYaw;
            sightBase3.rotateAngleX = rotationPitch;
            headBase2.rotateAngleY = rotationYaw;
            headBase2.rotateAngleX = rotationPitch;
        }

        barrel.render(DEFAULT_SCALE);
        supportLeft.render(DEFAULT_SCALE);
        headBase2.render(DEFAULT_SCALE);
        neckBase.render(DEFAULT_SCALE);
        headBase3.render(DEFAULT_SCALE);
        headBase.render(DEFAULT_SCALE);
        barrelGuard.render(DEFAULT_SCALE);
        sightBase3.render(DEFAULT_SCALE);
        rightFoot.render(DEFAULT_SCALE);
        supportRight.render(DEFAULT_SCALE);
        supportCenter.render(DEFAULT_SCALE);
        centerFoot.render(DEFAULT_SCALE);
        legHub.render(DEFAULT_SCALE);
        LeftFoot.render(DEFAULT_SCALE);
        neck.render(DEFAULT_SCALE);
        leftLeg.render(DEFAULT_SCALE);
        rightLeg.render(DEFAULT_SCALE);
        centerLeg.render(DEFAULT_SCALE);
    }
}
