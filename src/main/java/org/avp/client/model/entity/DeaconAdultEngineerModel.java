package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.DeaconAdultEngineerEntity;

public class DeaconAdultEngineerModel extends EntityModel<DeaconAdultEngineerEntity> {
	private final RendererModel root;
	private final RendererModel gChest;
	private final RendererModel rShoulderRidge03_r1;
	private final RendererModel rShoulderRidge04_r1;
	private final RendererModel rShoulderRidge02_r1;
	private final RendererModel rShoulderRidge02_r2;
	private final RendererModel rShoulderRidge03_r2;
	private final RendererModel rShoulderRidge01_r1;
	private final RendererModel chest02_r1;
	private final RendererModel gNeck;
	private final RendererModel gHead;
	private final RendererModel headLower03_r1;
	private final RendererModel headLower02_r1;
	private final RendererModel head04_r1;
	private final RendererModel head03_r1;
	private final RendererModel head02_r1;
	private final RendererModel head01_r1;
	private final RendererModel gUpperJaw;
	private final RendererModel muzzle_r1;
	private final RendererModel gUpperInnerJaw;
	private final RendererModel gLowerJaw;
	private final RendererModel jawTendon01_r1;
	private final RendererModel lowerTeeth01;
	private final RendererModel gLeftShoulder;
	private final RendererModel gLeftUpperArm;
	private final RendererModel gLeftLowerArm;
	private final RendererModel rArmSpike_r1;
	private final RendererModel gLeftHand;
	private final RendererModel gLeftFinger1;
	private final RendererModel gLeftFinger2;
	private final RendererModel gLeftFinger3;
	private final RendererModel gLeftFinger4;
	private final RendererModel gLeftFinger5;
	private final RendererModel gLeftThumb;
	private final RendererModel gRightShoulder;
	private final RendererModel gRightUpperArm;
	private final RendererModel gRightLowerArm;
	private final RendererModel rArmSpike_r2;
	private final RendererModel gRightHand;
	private final RendererModel gRightFinger1;
	private final RendererModel gRightFinger2;
	private final RendererModel gRightFinger3;
	private final RendererModel gRightFinger4;
	private final RendererModel gRightFinger5;
	private final RendererModel gRightThumb;
	private final RendererModel gStomach;
	private final RendererModel lHipBone_r1;
	private final RendererModel lHipBone_r2;
	private final RendererModel gHips;
	private final RendererModel gRightThigh;
	private final RendererModel gRightShin;
	private final RendererModel lKneeSpike_r1;
	private final RendererModel gRightAnkle;
	private final RendererModel gRightFoot;
	private final RendererModel gLeftThigh;
	private final RendererModel gLeftShin;
	private final RendererModel lKneeSpike_r2;
	private final RendererModel gLeftAnkle;
	private final RendererModel gLeftFoot;
	private final RendererModel gTail1;
	private final RendererModel gTail2;
	private final RendererModel gTail3;
	private final RendererModel gTailBlade;
	private final RendererModel tailBlade02_r1;

	public DeaconAdultEngineerModel() {
		textureWidth = 128;
		textureHeight = 64;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, -0.1F, 0.0F);
		

		gChest = new RendererModel(this);
		gChest.setRotationPoint(0.0F, -21.5F, 2.5F);
		root.addChild(gChest);
		setRotationAngle(gChest, 0.3927F, 0.0F, 0.0F);
		gChest.cubeList.add(new ModelBox(gChest, 0, 0, -4.0F, -9.0F, -4.3F, 8, 9, 8, 0.0F, false));

		rShoulderRidge03_r1 = new RendererModel(this);
		rShoulderRidge03_r1.setRotationPoint(-31.5177F, 32.3191F, -2.9968F);
		gChest.addChild(rShoulderRidge03_r1);
		setRotationAngle(rShoulderRidge03_r1, 0.0F, 0.0F, 0.7741F);
		rShoulderRidge03_r1.cubeList.add(new ModelBox(rShoulderRidge03_r1, 31, 33, -4.5F, -55.7F, 1.8F, 2, 2, 4, 0.0F, false));

		rShoulderRidge04_r1 = new RendererModel(this);
		rShoulderRidge04_r1.setRotationPoint(-48.4813F, -2.3628F, -11.9041F);
		gChest.addChild(rShoulderRidge04_r1);
		setRotationAngle(rShoulderRidge04_r1, -0.182F, -0.182F, 1.5595F);
		rShoulderRidge04_r1.cubeList.add(new ModelBox(rShoulderRidge04_r1, 30, 41, -4.5F, -55.6F, 5.5F, 2, 2, 3, 0.0F, false));

		rShoulderRidge02_r1 = new RendererModel(this);
		rShoulderRidge02_r1.setRotationPoint(-29.4573F, 30.2113F, 16.6081F);
		gChest.addChild(rShoulderRidge02_r1);
		setRotationAngle(rShoulderRidge02_r1, 0.3643F, 0.0F, 0.7741F);
		rShoulderRidge02_r1.cubeList.add(new ModelBox(rShoulderRidge02_r1, 31, 25, -4.5F, -55.6F, -1.8F, 2, 2, 4, 0.0F, false));

		rShoulderRidge02_r2 = new RendererModel(this);
		rShoulderRidge02_r2.setRotationPoint(31.5177F, 32.3191F, -2.9968F);
		gChest.addChild(rShoulderRidge02_r2);
		setRotationAngle(rShoulderRidge02_r2, 0.0F, 0.0F, -0.7741F);
		rShoulderRidge02_r2.cubeList.add(new ModelBox(rShoulderRidge02_r2, 31, 33, 2.5F, -55.7F, 1.8F, 2, 2, 4, 0.0F, true));

		rShoulderRidge03_r2 = new RendererModel(this);
		rShoulderRidge03_r2.setRotationPoint(48.4813F, -2.3628F, -11.9041F);
		gChest.addChild(rShoulderRidge03_r2);
		setRotationAngle(rShoulderRidge03_r2, -0.182F, 0.182F, -1.5595F);
		rShoulderRidge03_r2.cubeList.add(new ModelBox(rShoulderRidge03_r2, 30, 41, 2.5F, -55.6F, 5.5F, 2, 2, 3, 0.0F, true));

		rShoulderRidge01_r1 = new RendererModel(this);
		rShoulderRidge01_r1.setRotationPoint(29.4573F, 30.2113F, 16.6081F);
		gChest.addChild(rShoulderRidge01_r1);
		setRotationAngle(rShoulderRidge01_r1, 0.3643F, 0.0F, -0.7741F);
		rShoulderRidge01_r1.cubeList.add(new ModelBox(rShoulderRidge01_r1, 31, 25, 2.5F, -55.6F, -1.8F, 2, 2, 4, 0.0F, true));

		chest02_r1 = new RendererModel(this);
		chest02_r1.setRotationPoint(0.0F, 45.3383F, -4.5967F);
		gChest.addChild(chest02_r1);
		setRotationAngle(chest02_r1, -0.0456F, 0.0F, 0.0F);
		chest02_r1.cubeList.add(new ModelBox(chest02_r1, 0, 18, -3.5F, -45.8F, -1.2F, 7, 2, 7, 0.0F, false));

		gNeck = new RendererModel(this);
		gNeck.setRotationPoint(0.0F, -8.8F, 0.0F);
		gChest.addChild(gNeck);
		setRotationAngle(gNeck, 0.3927F, 0.0F, 0.0F);
		gNeck.cubeList.add(new ModelBox(gNeck, 33, 0, -2.5F, -4.1F, -3.0F, 5, 4, 6, 0.0F, false));

		gHead = new RendererModel(this);
		gHead.setRotationPoint(0.0F, -4.0F, 0.0F);
		gNeck.addChild(gHead);
		setRotationAngle(gHead, -0.3927F, 0.0F, 0.0F);
		gHead.cubeList.add(new ModelBox(gHead, 67, 56, -2.0F, -0.9F, 4.5F, 4, 1, 7, 0.0F, false));
		gHead.cubeList.add(new ModelBox(gHead, 91, 12, -3.0F, -5.0F, -4.5F, 6, 5, 9, 0.0F, false));

		headLower03_r1 = new RendererModel(this);
		headLower03_r1.setRotationPoint(0.0F, 0.064F, 12.3583F);
		gHead.addChild(headLower03_r1);
		setRotationAngle(headLower03_r1, -0.2276F, 0.0F, 0.0F);
		headLower03_r1.cubeList.add(new ModelBox(headLower03_r1, 116, 46, -1.0F, -1.0313F, 2.8506F, 2, 1, 3, 0.0F, false));

		headLower02_r1 = new RendererModel(this);
		headLower02_r1.setRotationPoint(0.0F, 0.064F, 12.3583F);
		gHead.addChild(headLower02_r1);
		setRotationAngle(headLower02_r1, -0.182F, 0.0F, 0.0F);
		headLower02_r1.cubeList.add(new ModelBox(headLower02_r1, 113, 13, -1.5F, -0.801F, -0.9281F, 3, 1, 4, 0.0F, false));

		head04_r1 = new RendererModel(this);
		head04_r1.setRotationPoint(0.0F, 45.0137F, -27.3003F);
		gHead.addChild(head04_r1);
		setRotationAngle(head04_r1, -0.4555F, 0.0F, 0.0F);
		head04_r1.cubeList.add(new ModelBox(head04_r1, 78, 41, -1.0F, -61.3F, 21.0F, 2, 2, 3, 0.0F, false));

		head03_r1 = new RendererModel(this);
		head03_r1.setRotationPoint(0.0F, 48.9568F, -23.026F);
		gHead.addChild(head03_r1);
		setRotationAngle(head03_r1, -0.3644F, 0.0F, 0.0F);
		head03_r1.cubeList.add(new ModelBox(head03_r1, 63, 41, -1.5F, -61.4F, 17.4F, 3, 2, 4, 0.0F, false));

		head02_r1 = new RendererModel(this);
		head02_r1.setRotationPoint(0.0F, 52.1861F, -18.2991F);
		gHead.addChild(head02_r1);
		setRotationAngle(head02_r1, -0.2733F, 0.0F, 0.0F);
		head02_r1.cubeList.add(new ModelBox(head02_r1, 66, 32, -2.0F, -61.6F, 12.5F, 4, 3, 5, 0.0F, false));

		head01_r1 = new RendererModel(this);
		head01_r1.setRotationPoint(0.0F, 55.5278F, -10.6116F);
		gHead.addChild(head01_r1);
		setRotationAngle(head01_r1, -0.1367F, 0.0F, 0.0F);
		head01_r1.cubeList.add(new ModelBox(head01_r1, 73, 21, -2.5F, -61.7F, 6.7F, 5, 4, 6, 0.0F, false));

		gUpperJaw = new RendererModel(this);
		gUpperJaw.setRotationPoint(0.0F, -1.2F, -5.0F);
		gHead.addChild(gUpperJaw);
		gUpperJaw.cubeList.add(new ModelBox(gUpperJaw, 87, 36, -2.0F, -2.3517F, -5.291F, 4, 2, 6, 0.0F, false));

		muzzle_r1 = new RendererModel(this);
		muzzle_r1.setRotationPoint(0.0F, 57.234F, 14.0314F);
		gUpperJaw.addChild(muzzle_r1);
		setRotationAngle(muzzle_r1, 0.2276F, 0.0F, 0.0F);
		muzzle_r1.cubeList.add(new ModelBox(muzzle_r1, 108, 55, -2.0F, -62.4089F, -5.3797F, 4, 2, 6, 0.01F, false));

		gUpperInnerJaw = new RendererModel(this);
		gUpperInnerJaw.setRotationPoint(0.0F, -0.2F, 0.1F);
		gUpperJaw.addChild(gUpperInnerJaw);
		gUpperInnerJaw.cubeList.add(new ModelBox(gUpperInnerJaw, 116, 29, 0.8F, -1.8F, -5.2F, 1, 2, 5, -0.1F, false));
		gUpperInnerJaw.cubeList.add(new ModelBox(gUpperInnerJaw, 109, 36, -1.65F, -1.8F, -5.2F, 3, 2, 5, -0.1F, false));

		gLowerJaw = new RendererModel(this);
		gLowerJaw.setRotationPoint(0.0625F, -1.8F, -4.15F);
		gHead.addChild(gLowerJaw);
		gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 98, 52, 0.8375F, 0.2F, -6.05F, 1, 1, 6, 0.0F, false));
		gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 83, 54, -1.8125F, 0.2F, -6.05F, 3, 1, 6, 0.0F, false));

		jawTendon01_r1 = new RendererModel(this);
		jawTendon01_r1.setRotationPoint(-0.0125F, -0.7F, -2.95F);
		gLowerJaw.addChild(jawTendon01_r1);
		setRotationAngle(jawTendon01_r1, 0.0F, 3.1416F, 0.0F);
		jawTendon01_r1.cubeList.add(new ModelBox(jawTendon01_r1, 86, 45, -1.75F, -1.0F, -3.6F, 3, 2, 4, 0.0F, false));
		jawTendon01_r1.cubeList.add(new ModelBox(jawTendon01_r1, 104, 45, 0.75F, -1.0F, -3.6F, 1, 2, 4, 0.0F, false));

		lowerTeeth01 = new RendererModel(this);
		lowerTeeth01.setRotationPoint(0.0125F, 0.15F, -1.55F);
		gLowerJaw.addChild(lowerTeeth01);
		lowerTeeth01.cubeList.add(new ModelBox(lowerTeeth01, 30, 59, 0.725F, -0.5F, -4.5F, 1, 1, 3, -0.1F, false));
		lowerTeeth01.cubeList.add(new ModelBox(lowerTeeth01, 30, 54, -1.725F, -0.5F, -4.5F, 3, 1, 3, -0.1F, false));

		gLeftShoulder = new RendererModel(this);
		gLeftShoulder.setRotationPoint(2.9F, -6.6F, 0.0F);
		gChest.addChild(gLeftShoulder);
		setRotationAngle(gLeftShoulder, 0.0F, 0.0F, -0.7854F);
		gLeftShoulder.cubeList.add(new ModelBox(gLeftShoulder, 41, 37, 0.0F, -1.0F, -2.5F, 3, 6, 5, 0.0F, true));

		gLeftUpperArm = new RendererModel(this);
		gLeftUpperArm.setRotationPoint(1.5F, 3.6F, 0.0F);
		gLeftShoulder.addChild(gLeftUpperArm);
		setRotationAngle(gLeftUpperArm, 0.0F, 0.0F, 0.7854F);
		gLeftUpperArm.cubeList.add(new ModelBox(gLeftUpperArm, 43, 51, -1.0F, 0.0F, -2.0F, 2, 9, 4, 0.0F, true));

		gLeftLowerArm = new RendererModel(this);
		gLeftLowerArm.setRotationPoint(0.0F, 7.7F, 0.0F);
		gLeftUpperArm.addChild(gLeftLowerArm);
		setRotationAngle(gLeftLowerArm, -1.1781F, 0.0F, 0.0F);
		gLeftLowerArm.cubeList.add(new ModelBox(gLeftLowerArm, 56, 46, -1.0F, 0.0F, -1.5F, 2, 14, 3, -0.1F, true));

		rArmSpike_r1 = new RendererModel(this);
		rArmSpike_r1.setRotationPoint(-0.0562F, 3.049F, 1.3651F);
		gLeftLowerArm.addChild(rArmSpike_r1);
		setRotationAngle(rArmSpike_r1, -0.8278F, 0.1431F, 0.3123F);
		rArmSpike_r1.cubeList.add(new ModelBox(rArmSpike_r1, 32, 47, -1.0918F, -3.8481F, -1.7622F, 2, 4, 2, 0.0F, true));

		gLeftHand = new RendererModel(this);
		gLeftHand.setRotationPoint(0.0F, 13.3F, 0.0F);
		gLeftLowerArm.addChild(gLeftHand);
		setRotationAngle(gLeftHand, 0.7854F, 0.0F, 0.0F);
		gLeftHand.cubeList.add(new ModelBox(gLeftHand, 67, 49, -1.5F, 0.0F, -1.0F, 3, 4, 1, 0.0F, false));

		gLeftFinger1 = new RendererModel(this);
		gLeftFinger1.setRotationPoint(-1.45F, 3.9F, -1.0F);
		gLeftHand.addChild(gLeftFinger1);
		gLeftFinger1.cubeList.add(new ModelBox(gLeftFinger1, 67, 53, 0.0F, -0.25F, -1.0F, 0, 6, 2, 0.0F, false));

		gLeftFinger2 = new RendererModel(this);
		gLeftFinger2.setRotationPoint(-0.7F, 3.9F, -1.0F);
		gLeftHand.addChild(gLeftFinger2);
		gLeftFinger2.cubeList.add(new ModelBox(gLeftFinger2, 67, 53, 0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F, false));

		gLeftFinger3 = new RendererModel(this);
		gLeftFinger3.setRotationPoint(-0.1F, 3.9F, -1.0F);
		gLeftHand.addChild(gLeftFinger3);
		gLeftFinger3.cubeList.add(new ModelBox(gLeftFinger3, 67, 53, 0.0F, -0.25F, -1.0F, 0, 6, 2, 0.0F, false));

		gLeftFinger4 = new RendererModel(this);
		gLeftFinger4.setRotationPoint(0.55F, 3.9F, -1.0F);
		gLeftHand.addChild(gLeftFinger4);
		gLeftFinger4.cubeList.add(new ModelBox(gLeftFinger4, 67, 53, 0.0F, -0.5F, -1.0F, 0, 6, 2, 0.0F, false));

		gLeftFinger5 = new RendererModel(this);
		gLeftFinger5.setRotationPoint(1.3F, 3.9F, -1.0F);
		gLeftHand.addChild(gLeftFinger5);
		gLeftFinger5.cubeList.add(new ModelBox(gLeftFinger5, 67, 53, 0.0F, -1.0F, -1.0F, 0, 6, 2, 0.0F, false));

		gLeftThumb = new RendererModel(this);
		gLeftThumb.setRotationPoint(-1.4F, 1.5F, -0.6F);
		gLeftHand.addChild(gLeftThumb);
		setRotationAngle(gLeftThumb, 2.7489F, 0.0F, 3.1416F);
		gLeftThumb.cubeList.add(new ModelBox(gLeftThumb, 80, 47, 0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F, false));

		gRightShoulder = new RendererModel(this);
		gRightShoulder.setRotationPoint(-2.9F, -6.6F, 0.0F);
		gChest.addChild(gRightShoulder);
		setRotationAngle(gRightShoulder, 0.0F, 0.0F, 0.7854F);
		gRightShoulder.cubeList.add(new ModelBox(gRightShoulder, 41, 37, -3.0F, -1.0F, -2.5F, 3, 6, 5, 0.0F, false));

		gRightUpperArm = new RendererModel(this);
		gRightUpperArm.setRotationPoint(-1.5F, 3.6F, 0.0F);
		gRightShoulder.addChild(gRightUpperArm);
		setRotationAngle(gRightUpperArm, 0.0F, 0.0F, -0.7854F);
		gRightUpperArm.cubeList.add(new ModelBox(gRightUpperArm, 43, 51, -1.0F, 0.0F, -2.0F, 2, 9, 4, 0.0F, false));

		gRightLowerArm = new RendererModel(this);
		gRightLowerArm.setRotationPoint(0.0F, 7.7F, 0.0F);
		gRightUpperArm.addChild(gRightLowerArm);
		setRotationAngle(gRightLowerArm, -1.1781F, 0.0F, 0.0F);
		gRightLowerArm.cubeList.add(new ModelBox(gRightLowerArm, 56, 46, -1.0F, 0.0F, -1.5F, 2, 14, 3, -0.1F, false));

		rArmSpike_r2 = new RendererModel(this);
		rArmSpike_r2.setRotationPoint(0.0562F, 3.049F, 1.3651F);
		gRightLowerArm.addChild(rArmSpike_r2);
		setRotationAngle(rArmSpike_r2, -0.8278F, -0.1431F, -0.3123F);
		rArmSpike_r2.cubeList.add(new ModelBox(rArmSpike_r2, 32, 47, -0.9082F, -3.8481F, -1.7622F, 2, 4, 2, 0.0F, false));

		gRightHand = new RendererModel(this);
		gRightHand.setRotationPoint(0.0F, 13.3F, 0.0F);
		gRightLowerArm.addChild(gRightHand);
		setRotationAngle(gRightHand, 0.7854F, 0.0F, 0.0F);
		gRightHand.cubeList.add(new ModelBox(gRightHand, 67, 49, -1.5F, 0.0F, -1.0F, 3, 4, 1, 0.0F, true));

		gRightFinger1 = new RendererModel(this);
		gRightFinger1.setRotationPoint(1.45F, 3.9F, -1.0F);
		gRightHand.addChild(gRightFinger1);
		gRightFinger1.cubeList.add(new ModelBox(gRightFinger1, 67, 53, 0.0F, -0.25F, -1.0F, 0, 6, 2, 0.0F, true));

		gRightFinger2 = new RendererModel(this);
		gRightFinger2.setRotationPoint(0.7F, 3.9F, -1.0F);
		gRightHand.addChild(gRightFinger2);
		gRightFinger2.cubeList.add(new ModelBox(gRightFinger2, 67, 53, 0.0F, 0.0F, -1.0F, 0, 6, 2, 0.0F, true));

		gRightFinger3 = new RendererModel(this);
		gRightFinger3.setRotationPoint(0.1F, 3.9F, -1.0F);
		gRightHand.addChild(gRightFinger3);
		gRightFinger3.cubeList.add(new ModelBox(gRightFinger3, 67, 53, 0.0F, -0.25F, -1.0F, 0, 6, 2, 0.0F, true));

		gRightFinger4 = new RendererModel(this);
		gRightFinger4.setRotationPoint(-0.55F, 3.9F, -1.0F);
		gRightHand.addChild(gRightFinger4);
		gRightFinger4.cubeList.add(new ModelBox(gRightFinger4, 67, 53, 0.0F, -0.5F, -1.0F, 0, 6, 2, 0.0F, true));

		gRightFinger5 = new RendererModel(this);
		gRightFinger5.setRotationPoint(-1.3F, 3.9F, -1.0F);
		gRightHand.addChild(gRightFinger5);
		gRightFinger5.cubeList.add(new ModelBox(gRightFinger5, 67, 53, 0.0F, -1.0F, -1.0F, 0, 6, 2, 0.0F, true));

		gRightThumb = new RendererModel(this);
		gRightThumb.setRotationPoint(1.4F, 1.5F, -0.6F);
		gRightHand.addChild(gRightThumb);
		setRotationAngle(gRightThumb, 2.7489F, 0.0F, -3.1416F);
		gRightThumb.cubeList.add(new ModelBox(gRightThumb, 80, 47, 0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F, true));

		gStomach = new RendererModel(this);
		gStomach.setRotationPoint(0.0F, 0.9983F, -0.0729F);
		gChest.addChild(gStomach);
		setRotationAngle(gStomach, -0.3927F, 0.0F, 0.0F);
		gStomach.cubeList.add(new ModelBox(gStomach, 0, 28, -3.0F, 0.0F, -3.0F, 6, 11, 6, 0.0F, false));

		lHipBone_r1 = new RendererModel(this);
		lHipBone_r1.setRotationPoint(19.1671F, 36.9872F, -0.8849F);
		gStomach.addChild(lHipBone_r1);
		setRotationAngle(lHipBone_r1, 0.0456F, 0.0F, -0.7285F);
		lHipBone_r1.cubeList.add(new ModelBox(lHipBone_r1, 44, 25, 1.1F, -38.4F, -0.3F, 3, 4, 7, 0.0F, true));

		lHipBone_r2 = new RendererModel(this);
		lHipBone_r2.setRotationPoint(-19.1671F, 36.9872F, -0.8849F);
		gStomach.addChild(lHipBone_r2);
		setRotationAngle(lHipBone_r2, 0.0456F, 0.0F, 0.7285F);
		lHipBone_r2.cubeList.add(new ModelBox(lHipBone_r2, 44, 25, -4.1F, -38.4F, -0.3F, 3, 4, 7, 0.0F, false));

		gHips = new RendererModel(this);
		gHips.setRotationPoint(0.0F, 11.5F, 1.7F);
		gStomach.addChild(gHips);
		gHips.cubeList.add(new ModelBox(gHips, 28, 12, -4.0F, -4.7F, -4.2F, 8, 4, 6, 0.0F, false));

		gRightThigh = new RendererModel(this);
		gRightThigh.setRotationPoint(-0.55F, -1.5F, -1.0F);
		gHips.addChild(gRightThigh);
		setRotationAngle(gRightThigh, -0.3927F, 0.0F, 0.0F);
		gRightThigh.cubeList.add(new ModelBox(gRightThigh, 57, 0, -4.0F, -1.0F, -3.0F, 4, 19, 6, 0.0F, false));

		gRightShin = new RendererModel(this);
		gRightShin.setRotationPoint(-2.2F, 16.7241F, -1.3304F);
		gRightThigh.addChild(gRightShin);
		setRotationAngle(gRightShin, 1.1781F, 0.0F, 0.0F);
		gRightShin.cubeList.add(new ModelBox(gRightShin, 84, 0, -1.5F, 1.0F, -1.5F, 3, 16, 4, 0.0F, false));

		lKneeSpike_r1 = new RendererModel(this);
		lKneeSpike_r1.setRotationPoint(0.0F, 2.5F, -3.5F);
		gRightShin.addChild(lKneeSpike_r1);
		setRotationAngle(lKneeSpike_r1, -1.2835F, -0.7706F, -0.1701F);
		lKneeSpike_r1.cubeList.add(new ModelBox(lKneeSpike_r1, 101, 0, 0.2561F, -3.1371F, -2.454F, 3, 3, 4, 0.0F, false));

		gRightAnkle = new RendererModel(this);
		gRightAnkle.setRotationPoint(-0.1F, 15.7F, 0.1F);
		gRightShin.addChild(gRightAnkle);
		setRotationAngle(gRightAnkle, -1.1781F, 0.0F, 0.0F);
		gRightAnkle.cubeList.add(new ModelBox(gRightAnkle, 117, 0, -1.0F, 0.5F, -1.5F, 2, 7, 3, 0.0F, false));

		gRightFoot = new RendererModel(this);
		gRightFoot.setRotationPoint(0.0F, 7.2F, -0.1F);
		gRightAnkle.addChild(gRightFoot);
		setRotationAngle(gRightFoot, 0.3927F, 0.0F, 0.0F);
		gRightFoot.cubeList.add(new ModelBox(gRightFoot, 95, 27, -1.5F, 0.0F, -4.5F, 3, 2, 6, 0.0F, false));

		gLeftThigh = new RendererModel(this);
		gLeftThigh.setRotationPoint(0.55F, -1.5F, -1.0F);
		gHips.addChild(gLeftThigh);
		setRotationAngle(gLeftThigh, -0.3927F, 0.0F, 0.0F);
		gLeftThigh.cubeList.add(new ModelBox(gLeftThigh, 57, 0, 0.0F, -1.0F, -3.0F, 4, 19, 6, 0.0F, true));

		gLeftShin = new RendererModel(this);
		gLeftShin.setRotationPoint(2.2F, 16.7241F, -1.3304F);
		gLeftThigh.addChild(gLeftShin);
		setRotationAngle(gLeftShin, 1.1781F, 0.0F, 0.0F);
		gLeftShin.cubeList.add(new ModelBox(gLeftShin, 84, 0, -1.5F, 1.0F, -1.5F, 3, 16, 4, 0.0F, true));

		lKneeSpike_r2 = new RendererModel(this);
		lKneeSpike_r2.setRotationPoint(0.0F, 2.5F, -3.5F);
		gLeftShin.addChild(lKneeSpike_r2);
		setRotationAngle(lKneeSpike_r2, -1.2835F, 0.7706F, 0.1701F);
		lKneeSpike_r2.cubeList.add(new ModelBox(lKneeSpike_r2, 101, 0, -3.2561F, -3.1371F, -2.454F, 3, 3, 4, 0.0F, true));

		gLeftAnkle = new RendererModel(this);
		gLeftAnkle.setRotationPoint(0.1F, 15.7F, 0.1F);
		gLeftShin.addChild(gLeftAnkle);
		setRotationAngle(gLeftAnkle, -1.1781F, 0.0F, 0.0F);
		gLeftAnkle.cubeList.add(new ModelBox(gLeftAnkle, 117, 0, -1.0F, 0.5F, -1.5F, 2, 7, 3, 0.0F, true));

		gLeftFoot = new RendererModel(this);
		gLeftFoot.setRotationPoint(0.0F, 7.2F, -0.1F);
		gLeftAnkle.addChild(gLeftFoot);
		setRotationAngle(gLeftFoot, 0.3927F, 0.0F, 0.0F);
		gLeftFoot.cubeList.add(new ModelBox(gLeftFoot, 95, 27, -1.5F, 0.0F, -4.5F, 3, 2, 6, 0.0F, true));

		gTail1 = new RendererModel(this);
		gTail1.setRotationPoint(0.0F, -2.4537F, 1.7342F);
		gHips.addChild(gTail1);
		setRotationAngle(gTail1, 0.7854F, 0.0F, 0.0F);
		gTail1.cubeList.add(new ModelBox(gTail1, 5, 49, -0.8F, 0.0F, -0.2F, 1, 3, 1, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 0, 54, -0.2F, 0.0F, -0.8F, 1, 3, 1, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 5, 54, -0.8F, 0.0F, -0.8F, 1, 3, 1, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 0, 49, -0.2F, 0.0F, -0.2F, 1, 3, 1, 0.0F, false));

		gTail2 = new RendererModel(this);
		gTail2.setRotationPoint(0.0F, 2.9F, 0.0F);
		gTail1.addChild(gTail2);
		setRotationAngle(gTail2, -0.3927F, 0.0F, 0.0F);
		gTail2.cubeList.add(new ModelBox(gTail2, 16, 49, -0.75F, -0.1F, -0.2F, 1, 4, 1, -0.1F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 11, 55, -0.25F, -0.1F, -0.7F, 1, 4, 1, -0.1F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 16, 55, -0.75F, -0.1F, -0.7F, 1, 4, 1, -0.1F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 11, 49, -0.25F, -0.1F, -0.2F, 1, 4, 1, -0.1F, false));

		gTail3 = new RendererModel(this);
		gTail3.setRotationPoint(0.0F, 3.9245F, 0.0937F);
		gTail2.addChild(gTail3);
		setRotationAngle(gTail3, -0.3927F, 0.0F, 0.0F);
		gTail3.cubeList.add(new ModelBox(gTail3, 22, 49, -0.5F, -0.1F, -0.5F, 1, 5, 1, 0.0F, false));

		gTailBlade = new RendererModel(this);
		gTailBlade.setRotationPoint(0.0F, 4.8336F, 0.0493F);
		gTail3.addChild(gTailBlade);
		setRotationAngle(gTailBlade, -0.3927F, 0.0F, 0.0F);
		gTailBlade.cubeList.add(new ModelBox(gTailBlade, 22, 56, -0.5F, -0.0336F, -0.5493F, 1, 2, 1, -0.1F, false));

		tailBlade02_r1 = new RendererModel(this);
		tailBlade02_r1.setRotationPoint(0.0F, 3.4664F, -0.0493F);
		gTailBlade.addChild(tailBlade02_r1);
		setRotationAngle(tailBlade02_r1, -0.3622F, 0.7519F, -0.2533F);
		tailBlade02_r1.cubeList.add(new ModelBox(tailBlade02_r1, 21, 60, -0.1466F, -2.0141F, -0.8534F, 1, 3, 1, -0.1F, false));
	}

	@Override
	public void render(DeaconAdultEngineerEntity deaconAdultEngineerEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}