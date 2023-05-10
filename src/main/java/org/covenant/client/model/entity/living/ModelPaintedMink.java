package org.covenant.client.model.entity.living;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import org.covenant.common.entity.living.EntityPaintedMink;

public class ModelPaintedMink extends Model<EntityPaintedMink> {
	private final ModelRenderer root;
	private final ModelRenderer uppertorso;
	private final ModelRenderer chest;
	private final ModelRenderer rArm01;
	private final ModelRenderer rArm02;
	private final ModelRenderer rHand;
	private final ModelRenderer rClaw01;
	private final ModelRenderer rClaw02;
	private final ModelRenderer rClaw03;
	private final ModelRenderer rArm2;
	private final ModelRenderer rArm3;
	private final ModelRenderer rHand2;
	private final ModelRenderer rClaw2;
	private final ModelRenderer rClaw3;
	private final ModelRenderer rClaw4;
	private final ModelRenderer neck01;
	private final ModelRenderer neck02;
	private final ModelRenderer head;
	private final ModelRenderer upperJaw;
	private final ModelRenderer upperTeethR;
	private final ModelRenderer upperTeethR2;
	private final ModelRenderer upperTeethM;
	private final ModelRenderer upperJawb;
	private final ModelRenderer lowerJaw;
	private final ModelRenderer lowerTeethL;
	private final ModelRenderer lowerTeethL2;
	private final ModelRenderer lowerTeethM;
	private final ModelRenderer snout;
	private final ModelRenderer lEar01;
	private final ModelRenderer lEar02;
	private final ModelRenderer lEar02_r1;
	private final ModelRenderer lEar03;
	private final ModelRenderer lEar03_r1;
	private final ModelRenderer lEar2;
	private final ModelRenderer lEar3;
	private final ModelRenderer lEar03_r2;
	private final ModelRenderer lEar4;
	private final ModelRenderer lEar04_r1;
	private final ModelRenderer hips;
	private final ModelRenderer rLeg5;
	private final ModelRenderer rLeg6;
	private final ModelRenderer rLeg04_r1;
	private final ModelRenderer rLeg7;
	private final ModelRenderer rFoot3;
	private final ModelRenderer rHindClaw3;
	private final ModelRenderer rLeg2;
	private final ModelRenderer rLeg3;
	private final ModelRenderer rLeg05_r1;
	private final ModelRenderer rLeg4;
	private final ModelRenderer rFoot2;
	private final ModelRenderer rHindClaw2;
	private final ModelRenderer tail01;
	private final ModelRenderer tail02;
	private final ModelRenderer tail03;
	private final ModelRenderer tail04a;
	private final ModelRenderer tail04b;
	private final ModelRenderer tail04c;
	private final ModelRenderer tail04d;

	public ModelPaintedMink() {
		textureWidth = 64;
		textureHeight = 64;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		uppertorso = new ModelRenderer(this);
		uppertorso.setRotationPoint(0.0F, 13.9F, 4.1F);
		root.addChild(uppertorso);
		setRotationAngle(uppertorso, 0.0511F, 0.0F, 0.0F);
		uppertorso.cubeList.add(new ModelBox(uppertorso, 0, 14, -2.5F, -2.5F, -7.5F, 5, 5, 8, 0.0F, false));

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 0.0F, -6.8F);
		uppertorso.addChild(chest);
		setRotationAngle(chest, -0.2731F, 0.0F, 0.0F);
		chest.cubeList.add(new ModelBox(chest, 0, 0, -3.0F, -3.0F, -7.0F, 6, 6, 7, 0.0F, false));

		rArm01 = new ModelRenderer(this);
		rArm01.setRotationPoint(-2.85F, 0.4F, -3.8F);
		chest.addChild(rArm01);
		setRotationAngle(rArm01, 0.4554F, 0.0F, 0.1367F);
		rArm01.cubeList.add(new ModelBox(rArm01, 51, 0, -1.5F, -1.0F, -1.5F, 3, 6, 3, 0.0F, true));

		rArm02 = new ModelRenderer(this);
		rArm02.setRotationPoint(0.2F, 4.6F, 0.0F);
		rArm01.addChild(rArm02);
		setRotationAngle(rArm02, -0.4098F, 0.0F, -0.1367F);
		rArm02.cubeList.add(new ModelBox(rArm02, 50, 11, -1.0F, -0.5F, -1.5F, 2, 6, 3, 0.0F, true));

		rHand = new ModelRenderer(this);
		rHand.setRotationPoint(0.2F, 5.4F, 0.0F);
		rArm02.addChild(rHand);
		setRotationAngle(rHand, 0.1367F, 0.0F, 0.0F);
		rHand.cubeList.add(new ModelBox(rHand, 48, 22, -1.5F, -0.5F, -3.0F, 3, 1, 4, 0.0F, true));

		rClaw01 = new ModelRenderer(this);
		rClaw01.setRotationPoint(0.9F, -0.2F, -1.5F);
		rHand.addChild(rClaw01);
		setRotationAngle(rClaw01, 0.1367F, -0.182F, 0.0F);
		rClaw01.cubeList.add(new ModelBox(rClaw01, 20, 16, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F, true));

		rClaw02 = new ModelRenderer(this);
		rClaw02.setRotationPoint(0.0F, -0.2F, -1.9F);
		rHand.addChild(rClaw02);
		setRotationAngle(rClaw02, 0.1367F, 0.0F, 0.0F);
		rClaw02.cubeList.add(new ModelBox(rClaw02, 20, 16, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F, true));

		rClaw03 = new ModelRenderer(this);
		rClaw03.setRotationPoint(-0.9F, -0.2F, -1.5F);
		rHand.addChild(rClaw03);
		setRotationAngle(rClaw03, 0.1367F, 0.182F, 0.0F);
		rClaw03.cubeList.add(new ModelBox(rClaw03, 20, 16, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F, true));

		rArm2 = new ModelRenderer(this);
		rArm2.setRotationPoint(2.85F, 0.4F, -3.8F);
		chest.addChild(rArm2);
		setRotationAngle(rArm2, 0.4554F, 0.0F, -0.1367F);
		rArm2.cubeList.add(new ModelBox(rArm2, 51, 0, -1.5F, -1.0F, -1.5F, 3, 6, 3, 0.0F, false));

		rArm3 = new ModelRenderer(this);
		rArm3.setRotationPoint(-0.2F, 4.6F, 0.0F);
		rArm2.addChild(rArm3);
		setRotationAngle(rArm3, -0.4098F, 0.0F, 0.1367F);
		rArm3.cubeList.add(new ModelBox(rArm3, 50, 11, -1.0F, -0.5F, -1.5F, 2, 6, 3, 0.0F, false));

		rHand2 = new ModelRenderer(this);
		rHand2.setRotationPoint(-0.2F, 5.4F, 0.0F);
		rArm3.addChild(rHand2);
		setRotationAngle(rHand2, 0.1367F, 0.0F, 0.0F);
		rHand2.cubeList.add(new ModelBox(rHand2, 48, 22, -1.5F, -0.5F, -3.0F, 3, 1, 4, 0.0F, false));

		rClaw2 = new ModelRenderer(this);
		rClaw2.setRotationPoint(-0.9F, -0.2F, -1.5F);
		rHand2.addChild(rClaw2);
		setRotationAngle(rClaw2, 0.1367F, 0.182F, 0.0F);
		rClaw2.cubeList.add(new ModelBox(rClaw2, 20, 16, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F, false));

		rClaw3 = new ModelRenderer(this);
		rClaw3.setRotationPoint(0.0F, -0.2F, -1.9F);
		rHand2.addChild(rClaw3);
		setRotationAngle(rClaw3, 0.1367F, 0.0F, 0.0F);
		rClaw3.cubeList.add(new ModelBox(rClaw3, 20, 16, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F, false));

		rClaw4 = new ModelRenderer(this);
		rClaw4.setRotationPoint(0.9F, -0.2F, -1.5F);
		rHand2.addChild(rClaw4);
		setRotationAngle(rClaw4, 0.1367F, -0.182F, 0.0F);
		rClaw4.cubeList.add(new ModelBox(rClaw4, 20, 16, -0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F, false));

		neck01 = new ModelRenderer(this);
		neck01.setRotationPoint(0.0F, -0.1F, -5.9F);
		chest.addChild(neck01);
		setRotationAngle(neck01, -0.4098F, 0.0F, 0.0F);
		neck01.cubeList.add(new ModelBox(neck01, 0, 43, -2.5F, -2.5F, -3.0F, 5, 5, 3, 0.0F, false));

		neck02 = new ModelRenderer(this);
		neck02.setRotationPoint(0.0F, -0.9F, -2.3F);
		neck01.addChild(neck02);
		setRotationAngle(neck02, -0.2731F, 0.0F, 0.0F);
		neck02.cubeList.add(new ModelBox(neck02, 0, 53, -2.0F, -2.0F, -4.1F, 4, 5, 6, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, -4.0F);
		neck02.addChild(head);
		setRotationAngle(head, -0.6829F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 23, 36, -2.5F, -1.5F, -2.5F, 5, 5, 5, 0.0F, false));

		upperJaw = new ModelRenderer(this);
		upperJaw.setRotationPoint(0.0F, 4.0F, 0.83F);
		head.addChild(upperJaw);
		upperJaw.cubeList.add(new ModelBox(upperJaw, 16, 49, -1.35F, -1.0F, -0.5F, 3, 3, 1, 0.0F, false));

		upperTeethR = new ModelRenderer(this);
		upperTeethR.setRotationPoint(0.4F, 0.3F, 0.4F);
		upperJaw.addChild(upperTeethR);
		setRotationAngle(upperTeethR, 0.0F, 0.0F, -0.0911F);
		upperTeethR.cubeList.add(new ModelBox(upperTeethR, 31, 55, -1.99F, -0.6F, -0.2F, 1, 2, 1, 0.0F, true));

		upperTeethR2 = new ModelRenderer(this);
		upperTeethR2.setRotationPoint(-0.4F, 0.3F, 0.4F);
		upperJaw.addChild(upperTeethR2);
		setRotationAngle(upperTeethR2, 0.0F, 0.0F, 0.0911F);
		upperTeethR2.cubeList.add(new ModelBox(upperTeethR2, 31, 55, 0.99F, -0.6F, -0.2F, 1, 2, 1, 0.0F, false));

		upperTeethM = new ModelRenderer(this);
		upperTeethM.setRotationPoint(0.0F, 1.4F, 0.3F);
		upperJaw.addChild(upperTeethM);
		upperTeethM.cubeList.add(new ModelBox(upperTeethM, 35, 54, -1.47F, 0.4F, 0.0F, 3, 0, 1, 0.0F, false));

		upperJawb = new ModelRenderer(this);
		upperJawb.setRotationPoint(0.0F, 0.0F, 0.0F);
		upperJaw.addChild(upperJawb);
		upperJawb.cubeList.add(new ModelBox(upperJawb, 25, 49, -1.65F, -1.0F, -0.48F, 1, 3, 1, 0.0F, false));

		lowerJaw = new ModelRenderer(this);
		lowerJaw.setRotationPoint(0.0F, 2.9F, 1.9F);
		head.addChild(lowerJaw);
		setRotationAngle(lowerJaw, -0.0475F, 0.0F, 0.0F);
		lowerJaw.cubeList.add(new ModelBox(lowerJaw, 20, 55, -1.5F, 0.0F, -0.5F, 3, 3, 1, 0.0F, false));

		lowerTeethL = new ModelRenderer(this);
		lowerTeethL.setRotationPoint(-0.3F, 1.1F, 0.0F);
		lowerJaw.addChild(lowerTeethL);
		setRotationAngle(lowerTeethL, 0.0F, 0.0F, 0.0911F);
		lowerTeethL.cubeList.add(new ModelBox(lowerTeethL, 31, 59, 0.75F, -1.25F, -1.3F, 1, 3, 1, 0.0F, false));

		lowerTeethL2 = new ModelRenderer(this);
		lowerTeethL2.setRotationPoint(0.3F, 1.1F, 0.0F);
		lowerJaw.addChild(lowerTeethL2);
		setRotationAngle(lowerTeethL2, 0.0F, 0.0F, -0.0911F);
		lowerTeethL2.cubeList.add(new ModelBox(lowerTeethL2, 31, 59, -1.75F, -1.25F, -1.3F, 1, 3, 1, 0.0F, true));

		lowerTeethM = new ModelRenderer(this);
		lowerTeethM.setRotationPoint(0.0F, 2.3F, -0.2F);
		lowerJaw.addChild(lowerTeethM);
		lowerTeethM.cubeList.add(new ModelBox(lowerTeethM, 35, 59, -1.5F, 0.4F, -1.0F, 3, 0, 1, 0.0F, false));

		snout = new ModelRenderer(this);
		snout.setRotationPoint(0.0F, 3.7F, 0.0F);
		head.addChild(snout);
		setRotationAngle(snout, 0.182F, 0.0F, 0.0F);
		snout.cubeList.add(new ModelBox(snout, 31, 49, -1.5F, -0.5F, -0.5F, 3, 3, 1, 0.0F, false));

		lEar01 = new ModelRenderer(this);
		lEar01.setRotationPoint(-2.0F, 0.1F, -1.8F);
		head.addChild(lEar01);
		setRotationAngle(lEar01, 0.0F, -0.6374F, 0.0F);
		lEar01.cubeList.add(new ModelBox(lEar01, 20, 0, -2.2F, -0.5F, -1.4F, 3, 1, 3, 0.0F, false));

		lEar02 = new ModelRenderer(this);
		lEar02.setRotationPoint(-1.7F, -0.1F, -0.9F);
		lEar01.addChild(lEar02);
		setRotationAngle(lEar02, 0.0F, -0.3187F, 0.0F);
		

		lEar02_r1 = new ModelRenderer(this);
		lEar02_r1.setRotationPoint(-0.2F, 0.0F, 0.3F);
		lEar02.addChild(lEar02_r1);
		setRotationAngle(lEar02_r1, 0.0F, 0.0F, -0.2182F);
		lEar02_r1.cubeList.add(new ModelBox(lEar02_r1, 27, 5, -1.0F, -0.25F, -1.0F, 2, 1, 2, 0.0F, false));

		lEar03 = new ModelRenderer(this);
		lEar03.setRotationPoint(-0.7F, -0.2F, 0.0F);
		lEar01.addChild(lEar03);
		setRotationAngle(lEar03, 0.0F, 0.0F, 0.2276F);
		

		lEar03_r1 = new ModelRenderer(this);
		lEar03_r1.setRotationPoint(-0.2F, -0.2F, 0.0F);
		lEar03.addChild(lEar03_r1);
		setRotationAngle(lEar03_r1, 0.0F, 0.0F, -0.5236F);
		lEar03_r1.cubeList.add(new ModelBox(lEar03_r1, 27, 10, -1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F, false));

		lEar2 = new ModelRenderer(this);
		lEar2.setRotationPoint(2.0F, 0.1F, -1.8F);
		head.addChild(lEar2);
		setRotationAngle(lEar2, 0.0F, 0.6374F, 0.0F);
		lEar2.cubeList.add(new ModelBox(lEar2, 20, 0, -0.8F, -0.5F, -1.4F, 3, 1, 3, 0.0F, true));

		lEar3 = new ModelRenderer(this);
		lEar3.setRotationPoint(1.7F, -0.1F, -0.9F);
		lEar2.addChild(lEar3);
		setRotationAngle(lEar3, 0.0F, 0.3187F, 0.0F);
		

		lEar03_r2 = new ModelRenderer(this);
		lEar03_r2.setRotationPoint(0.2F, 0.0F, 0.3F);
		lEar3.addChild(lEar03_r2);
		setRotationAngle(lEar03_r2, 0.0F, 0.0F, 0.2182F);
		lEar03_r2.cubeList.add(new ModelBox(lEar03_r2, 27, 5, -1.0F, -0.25F, -1.0F, 2, 1, 2, 0.0F, true));

		lEar4 = new ModelRenderer(this);
		lEar4.setRotationPoint(0.7F, -0.2F, 0.0F);
		lEar2.addChild(lEar4);
		setRotationAngle(lEar4, 0.0F, 0.0F, -0.2276F);
		

		lEar04_r1 = new ModelRenderer(this);
		lEar04_r1.setRotationPoint(0.2F, -0.2F, 0.0F);
		lEar4.addChild(lEar04_r1);
		setRotationAngle(lEar04_r1, 0.0F, 0.0F, 0.5236F);
		lEar04_r1.cubeList.add(new ModelBox(lEar04_r1, 27, 10, -1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F, true));

		hips = new ModelRenderer(this);
		hips.setRotationPoint(0.0F, 14.1F, 7.5F);
		root.addChild(hips);
		setRotationAngle(hips, -0.0911F, 0.0F, 0.0F);
		hips.cubeList.add(new ModelBox(hips, 0, 30, -3.0F, -3.0F, -3.5F, 6, 5, 6, 0.0F, false));

		rLeg5 = new ModelRenderer(this);
		rLeg5.setRotationPoint(-4.25F, -0.5F, -0.5F);
		hips.addChild(rLeg5);
		setRotationAngle(rLeg5, -0.3851F, 0.1205F, 0.126F);
		rLeg5.cubeList.add(new ModelBox(rLeg5, 36, 0, 0.0F, -1.8F, -2.0F, 3, 7, 4, 0.0F, true));

		rLeg6 = new ModelRenderer(this);
		rLeg6.setRotationPoint(1.4F, 4.1F, -0.6F);
		rLeg5.addChild(rLeg6);
		setRotationAngle(rLeg6, -0.4154F, 0.16F, -0.0701F);
		

		rLeg04_r1 = new ModelRenderer(this);
		rLeg04_r1.setRotationPoint(-2.4F, 5.8F, -6.9F);
		rLeg6.addChild(rLeg04_r1);
		setRotationAngle(rLeg04_r1, 0.0F, 0.0F, 0.0436F);
		rLeg04_r1.cubeList.add(new ModelBox(rLeg04_r1, 31, 12, 0.8F, -7.3F, 6.2F, 3, 3, 5, 0.0F, true));

		rLeg7 = new ModelRenderer(this);
		rLeg7.setRotationPoint(0.1F, -0.45F, 3.6F);
		rLeg6.addChild(rLeg7);
		setRotationAngle(rLeg7, 0.8596F, 0.0753F, 0.1605F);
		rLeg7.cubeList.add(new ModelBox(rLeg7, 31, 21, -1.0F, -0.1F, -1.0F, 2, 4, 2, 0.0F, true));

		rFoot3 = new ModelRenderer(this);
		rFoot3.setRotationPoint(-0.15F, 4.0F, 0.5F);
		rLeg7.addChild(rFoot3);
		setRotationAngle(rFoot3, 0.0434F, -0.0931F, -0.0018F);
		rFoot3.cubeList.add(new ModelBox(rFoot3, 29, 28, -1.5F, -0.5F, -3.5F, 3, 1, 4, 0.0F, true));

		rHindClaw3 = new ModelRenderer(this);
		rHindClaw3.setRotationPoint(0.0F, 0.1F, -3.1F);
		rFoot3.addChild(rHindClaw3);
		setRotationAngle(rHindClaw3, 0.0911F, 0.0F, 0.0F);
		rHindClaw3.cubeList.add(new ModelBox(rHindClaw3, 38, 28, -1.5F, -0.0021F, -2.0455F, 3, 0, 3, 0.0F, true));

		rLeg2 = new ModelRenderer(this);
		rLeg2.setRotationPoint(4.25F, -0.5F, -0.5F);
		hips.addChild(rLeg2);
		setRotationAngle(rLeg2, -0.3851F, -0.1205F, -0.126F);
		rLeg2.cubeList.add(new ModelBox(rLeg2, 36, 0, -3.0F, -1.8F, -2.0F, 3, 7, 4, 0.0F, false));

		rLeg3 = new ModelRenderer(this);
		rLeg3.setRotationPoint(-1.4F, 4.1F, -0.6F);
		rLeg2.addChild(rLeg3);
		setRotationAngle(rLeg3, -0.4154F, -0.16F, 0.0701F);
		

		rLeg05_r1 = new ModelRenderer(this);
		rLeg05_r1.setRotationPoint(2.4F, 5.8F, -6.9F);
		rLeg3.addChild(rLeg05_r1);
		setRotationAngle(rLeg05_r1, 0.0F, 0.0F, -0.0436F);
		rLeg05_r1.cubeList.add(new ModelBox(rLeg05_r1, 31, 12, -3.8F, -7.3F, 6.2F, 3, 3, 5, 0.0F, false));

		rLeg4 = new ModelRenderer(this);
		rLeg4.setRotationPoint(-0.1F, -0.45F, 3.6F);
		rLeg3.addChild(rLeg4);
		setRotationAngle(rLeg4, 0.8596F, -0.0753F, -0.1605F);
		rLeg4.cubeList.add(new ModelBox(rLeg4, 31, 21, -1.0F, -0.1F, -1.0F, 2, 4, 2, 0.0F, false));

		rFoot2 = new ModelRenderer(this);
		rFoot2.setRotationPoint(0.15F, 4.0F, 0.5F);
		rLeg4.addChild(rFoot2);
		setRotationAngle(rFoot2, 0.0434F, 0.0931F, 0.0018F);
		rFoot2.cubeList.add(new ModelBox(rFoot2, 29, 28, -1.5F, -0.5F, -3.5F, 3, 1, 4, 0.0F, false));

		rHindClaw2 = new ModelRenderer(this);
		rHindClaw2.setRotationPoint(0.0F, 0.1F, -3.1F);
		rFoot2.addChild(rHindClaw2);
		setRotationAngle(rHindClaw2, 0.0911F, 0.0F, 0.0F);
		rHindClaw2.cubeList.add(new ModelBox(rHindClaw2, 38, 28, -1.5F, -0.0021F, -2.0455F, 3, 0, 3, 0.0F, false));

		tail01 = new ModelRenderer(this);
		tail01.setRotationPoint(0.0F, -1.9F, 1.7F);
		hips.addChild(tail01);
		setRotationAngle(tail01, -0.8196F, 0.0F, 0.0F);
		tail01.cubeList.add(new ModelBox(tail01, 45, 29, -1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F, false));

		tail02 = new ModelRenderer(this);
		tail02.setRotationPoint(0.0F, 0.0F, 4.7F);
		tail01.addChild(tail02);
		setRotationAngle(tail02, 0.1367F, 0.0F, 0.0F);
		tail02.cubeList.add(new ModelBox(tail02, 45, 37, -1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F, false));

		tail03 = new ModelRenderer(this);
		tail03.setRotationPoint(0.0F, 0.0F, 4.7F);
		tail02.addChild(tail03);
		setRotationAngle(tail03, 0.182F, 0.0F, 0.0F);
		tail03.cubeList.add(new ModelBox(tail03, 45, 46, -1.0F, -1.0F, 0.0F, 2, 2, 4, 0.0F, false));

		tail04a = new ModelRenderer(this);
		tail04a.setRotationPoint(0.0F, 0.0F, 3.7F);
		tail03.addChild(tail04a);
		setRotationAngle(tail04a, 0.182F, 0.0F, 0.0F);
		tail04a.cubeList.add(new ModelBox(tail04a, 45, 53, -0.8F, -0.8F, 0.0F, 1, 1, 5, 0.0F, false));

		tail04b = new ModelRenderer(this);
		tail04b.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail04a.addChild(tail04b);
		tail04b.cubeList.add(new ModelBox(tail04b, 45, 53, -0.2F, -0.8F, 0.0F, 1, 1, 5, 0.0F, false));

		tail04c = new ModelRenderer(this);
		tail04c.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail04a.addChild(tail04c);
		tail04c.cubeList.add(new ModelBox(tail04c, 45, 53, -0.8F, -0.2F, 0.0F, 1, 1, 5, 0.0F, false));

		tail04d = new ModelRenderer(this);
		tail04d.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail04a.addChild(tail04d);
		tail04d.cubeList.add(new ModelBox(tail04d, 45, 53, -0.2F, -0.2F, 0.0F, 1, 1, 5, 0.0F, false));
	}

	@Override
	public void render(EntityPaintedMink entityPaintedMink) {
		draw(root);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}