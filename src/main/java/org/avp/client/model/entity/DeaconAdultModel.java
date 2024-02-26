package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.DeaconAdultEntity;

public class DeaconAdultModel extends EntityModel<DeaconAdultEntity> {
	private final RendererModel root;
	private final RendererModel gChest;
	private final RendererModel lShoulderRidge02_r1;
	private final RendererModel lShoulderRidge04_r1;
	private final RendererModel lShoulderRidge03_r1;
	private final RendererModel lShoulderRidge02_r2;
	private final RendererModel lShoulderRidge03_r2;
	private final RendererModel lShoulderRidge01_r1;
	private final RendererModel neck;
	private final RendererModel gHead;
	private final RendererModel headLower03_r1;
	private final RendererModel head04_r1;
	private final RendererModel head03_r1;
	private final RendererModel head02_r1;
	private final RendererModel head01_r1;
	private final RendererModel muzzle_r1;
	private final RendererModel gLowerJaw;
	private final RendererModel jawTendon02_r1;
	private final RendererModel innerJaw01;
	private final RendererModel innerJaw02;
	private final RendererModel gAbs;
	private final RendererModel gStomach;
	private final RendererModel lHipBone_r1;
	private final RendererModel lHipBone_r2;
	private final RendererModel gHips;
	private final RendererModel gLeftThigh;
	private final RendererModel gLeftShin;
	private final RendererModel gLeftAnkle;
	private final RendererModel gLeftFoot;
	private final RendererModel gRightThigh;
	private final RendererModel gRightShin;
	private final RendererModel gRightAnkle;
	private final RendererModel gRightFoot;
	private final RendererModel gTail1;
	private final RendererModel gTail2;
	private final RendererModel gTail3;
	private final RendererModel gTailBlade;
	private final RendererModel tailBlade02_r1;
	private final RendererModel gRightShoulder;
	private final RendererModel gRightBicep;
	private final RendererModel gRightForearm;
	private final RendererModel lArmSpike_r1;
	private final RendererModel gRightHand;
	private final RendererModel gRightFinger1;
	private final RendererModel gRightFinger2;
	private final RendererModel gRightFinger3;
	private final RendererModel gRightFinger4;
	private final RendererModel gRightFinger5;
	private final RendererModel lFinger05;
	private final RendererModel gLeftShoulder;
	private final RendererModel gLeftBicep;
	private final RendererModel gLeftForearm;
	private final RendererModel lArmSpike_r2;
	private final RendererModel gLeftHand;
	private final RendererModel gLeftFinger1;
	private final RendererModel gLeftFinger2;
	private final RendererModel gLeftFinger3;
	private final RendererModel gLeftFinger4;
	private final RendererModel gLeftFinger5;
	private final RendererModel lFinger2;

	public DeaconAdultModel() {
		textureWidth = 128;
		textureHeight = 64;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		gChest = new RendererModel(this);
		gChest.setRotationPoint(0.0F, -10.5F, 1.0F);
		root.addChild(gChest);
		gChest.cubeList.add(new ModelBox(gChest, 0, 0, -4.0F, -9.0F, -4.3F, 8, 8, 8, 0.0F, false));

		lShoulderRidge02_r1 = new RendererModel(this);
		lShoulderRidge02_r1.setRotationPoint(22.1863F, 23.1826F, 14.4378F);
		gChest.addChild(lShoulderRidge02_r1);
		setRotationAngle(lShoulderRidge02_r1, 0.3643F, 0.0F, -0.7741F);
		lShoulderRidge02_r1.cubeList.add(new ModelBox(lShoulderRidge02_r1, 31, 25, 2.5F, -45.5F, -2.9F, 2, 2, 4, 0.0F, true));

		lShoulderRidge04_r1 = new RendererModel(this);
		lShoulderRidge04_r1.setRotationPoint(38.3539F, -3.0F, -8.6419F);
		gChest.addChild(lShoulderRidge04_r1);
		setRotationAngle(lShoulderRidge04_r1, -0.182F, 0.182F, -1.5595F);
		lShoulderRidge04_r1.cubeList.add(new ModelBox(lShoulderRidge04_r1, 31, 41, 2.5F, -45.5F, 4.4F, 2, 2, 3, 0.0F, true));

		lShoulderRidge03_r1 = new RendererModel(this);
		lShoulderRidge03_r1.setRotationPoint(24.0574F, 25.0968F, -1.4968F);
		gChest.addChild(lShoulderRidge03_r1);
		setRotationAngle(lShoulderRidge03_r1, 0.0F, 0.0F, -0.7741F);
		lShoulderRidge03_r1.cubeList.add(new ModelBox(lShoulderRidge03_r1, 31, 33, 2.5F, -45.6F, 0.7F, 2, 2, 4, 0.0F, true));

		lShoulderRidge02_r2 = new RendererModel(this);
		lShoulderRidge02_r2.setRotationPoint(-24.0574F, 25.0968F, -1.4968F);
		gChest.addChild(lShoulderRidge02_r2);
		setRotationAngle(lShoulderRidge02_r2, 0.0F, 0.0F, 0.7741F);
		lShoulderRidge02_r2.cubeList.add(new ModelBox(lShoulderRidge02_r2, 31, 33, -4.5F, -45.6F, 0.7F, 2, 2, 4, 0.0F, false));

		lShoulderRidge03_r2 = new RendererModel(this);
		lShoulderRidge03_r2.setRotationPoint(-38.3539F, -3.0F, -8.6419F);
		gChest.addChild(lShoulderRidge03_r2);
		setRotationAngle(lShoulderRidge03_r2, -0.182F, -0.182F, 1.5595F);
		lShoulderRidge03_r2.cubeList.add(new ModelBox(lShoulderRidge03_r2, 31, 41, -4.5F, -45.5F, 4.4F, 2, 2, 3, 0.0F, false));

		lShoulderRidge01_r1 = new RendererModel(this);
		lShoulderRidge01_r1.setRotationPoint(-22.1863F, 23.1826F, 14.4378F);
		gChest.addChild(lShoulderRidge01_r1);
		setRotationAngle(lShoulderRidge01_r1, 0.3643F, 0.0F, 0.7741F);
		lShoulderRidge01_r1.cubeList.add(new ModelBox(lShoulderRidge01_r1, 31, 25, -4.5F, -45.5F, -2.9F, 2, 2, 4, 0.0F, false));

		neck = new RendererModel(this);
		neck.setRotationPoint(0.0F, -8.6F, 0.0F);
		gChest.addChild(neck);
		neck.cubeList.add(new ModelBox(neck, 33, 0, -2.5F, -3.7F, -3.0F, 5, 4, 6, -0.5F, false));

		gHead = new RendererModel(this);
		gHead.setRotationPoint(0.0F, -3.1F, 0.0F);
		neck.addChild(gHead);
		gHead.cubeList.add(new ModelBox(gHead, 89, 37, -2.0F, -3.5441F, -7.8826F, 4, 2, 4, 0.0F, false));
		gHead.cubeList.add(new ModelBox(gHead, 73, 58, -2.0F, -1.1F, 2.7F, 4, 1, 4, 0.0F, false));
		gHead.cubeList.add(new ModelBox(gHead, 91, 59, -1.5F, -1.2F, 5.6F, 3, 1, 4, 0.0F, false));
		gHead.cubeList.add(new ModelBox(gHead, 92, 20, -3.0F, -5.0F, -4.0F, 6, 5, 7, 0.0F, false));

		headLower03_r1 = new RendererModel(this);
		headLower03_r1.setRotationPoint(0.0F, 45.9552F, -5.3148F);
		gHead.addChild(headLower03_r1);
		setRotationAngle(headLower03_r1, -0.0911F, 0.0F, 0.0F);
		headLower03_r1.cubeList.add(new ModelBox(headLower03_r1, 109, 59, -1.0F, -48.4F, 10.4F, 2, 1, 4, -0.1F, false));

		head04_r1 = new RendererModel(this);
		head04_r1.setRotationPoint(0.0F, 43.3319F, -14.1986F);
		gHead.addChild(head04_r1);
		setRotationAngle(head04_r1, -0.2733F, 0.0F, 0.0F);
		head04_r1.cubeList.add(new ModelBox(head04_r1, 76, 39, -1.0F, -51.2F, 13.4F, 2, 2, 3, 0.0F, false));

		head03_r1 = new RendererModel(this);
		head03_r1.setRotationPoint(0.0F, 44.4901F, -12.1348F);
		gHead.addChild(head03_r1);
		setRotationAngle(head03_r1, -0.2278F, 0.0F, 0.0F);
		head03_r1.cubeList.add(new ModelBox(head03_r1, 62, 39, -1.5F, -51.3F, 10.5F, 3, 2, 3, 0.0F, false));

		head02_r1 = new RendererModel(this);
		head02_r1.setRotationPoint(0.0F, 45.4248F, -9.989F);
		gHead.addChild(head02_r1);
		setRotationAngle(head02_r1, -0.1822F, 0.0F, 0.0F);
		head02_r1.cubeList.add(new ModelBox(head02_r1, 66, 31, -2.0F, -51.6F, 7.6F, 4, 3, 3, 0.0F, false));

		head01_r1 = new RendererModel(this);
		head01_r1.setRotationPoint(0.0F, 46.1288F, -7.7908F);
		gHead.addChild(head01_r1);
		setRotationAngle(head01_r1, -0.1367F, 0.0F, 0.0F);
		head01_r1.cubeList.add(new ModelBox(head01_r1, 73, 21, -2.5F, -51.8F, 3.7F, 5, 4, 4, 0.0F, false));

		muzzle_r1 = new RendererModel(this);
		muzzle_r1.setRotationPoint(0.0F, -3.2533F, -5.6978F);
		gHead.addChild(muzzle_r1);
		setRotationAngle(muzzle_r1, 0.3032F, 0.0F, 0.0F);
		muzzle_r1.cubeList.add(new ModelBox(muzzle_r1, 112, 49, -2.0F, -0.9F, -1.9F, 4, 2, 4, 0.05F, false));

		gLowerJaw = new RendererModel(this);
		gLowerJaw.setRotationPoint(-0.605F, -1.35F, -3.9F);
		gHead.addChild(gLowerJaw);
		gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 104, 53, 1.43F, -0.25F, -3.95F, 1, 1, 4, 0.0F, false));
		gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 30, 54, -1.12F, -0.95F, -3.95F, 3, 1, 2, -0.1F, false));
		gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 30, 59, 1.33F, -0.95F, -3.95F, 1, 1, 2, -0.1F, false));
		gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 86, 53, -1.22F, -0.25F, -3.95F, 3, 1, 4, 0.0F, false));

		jawTendon02_r1 = new RendererModel(this);
		jawTendon02_r1.setRotationPoint(0.605F, -0.85F, -2.3F);
		gLowerJaw.addChild(jawTendon02_r1);
		setRotationAngle(jawTendon02_r1, -3.1416F, 0.0F, 3.1416F);
		jawTendon02_r1.cubeList.add(new ModelBox(jawTendon02_r1, 104, 45, 0.725F, -0.9F, -3.8F, 1, 2, 4, 0.0F, false));
		jawTendon02_r1.cubeList.add(new ModelBox(jawTendon02_r1, 86, 45, -1.725F, -0.9F, -3.8F, 3, 2, 4, 0.0F, false));

		innerJaw01 = new RendererModel(this);
		innerJaw01.setRotationPoint(-0.12F, -2.072F, -4.2413F);
		gHead.addChild(innerJaw01);
		innerJaw01.cubeList.add(new ModelBox(innerJaw01, 106, 36, -1.5F, -1.0F, -3.5F, 3, 2, 5, -0.2F, false));

		innerJaw02 = new RendererModel(this);
		innerJaw02.setRotationPoint(0.12F, 3.772F, 1.1913F);
		innerJaw01.addChild(innerJaw02);
		innerJaw02.cubeList.add(new ModelBox(innerJaw02, 115, 28, 0.72F, -4.772F, -4.6913F, 1, 2, 5, -0.2F, false));

		gAbs = new RendererModel(this);
		gAbs.setRotationPoint(0.0F, -1.9F, 0.0F);
		gChest.addChild(gAbs);
		gAbs.cubeList.add(new ModelBox(gAbs, 0, 20, -3.5F, 0.3F, -3.7F, 7, 2, 7, 0.0F, false));

		gStomach = new RendererModel(this);
		gStomach.setRotationPoint(0.0F, 1.5F, 0.0F);
		gAbs.addChild(gStomach);
		gStomach.cubeList.add(new ModelBox(gStomach, 0, 33, -3.0F, 0.0F, -3.0F, 6, 9, 6, 0.0F, false));

		lHipBone_r1 = new RendererModel(this);
		lHipBone_r1.setRotationPoint(14.8338F, 30.1829F, 0.313F);
		gStomach.addChild(lHipBone_r1);
		setRotationAngle(lHipBone_r1, 0.0456F, 0.0F, -0.7285F);
		lHipBone_r1.cubeList.add(new ModelBox(lHipBone_r1, 46, 26, 2.0F, -31.8F, -1.5F, 2, 3, 6, 0.0F, true));

		lHipBone_r2 = new RendererModel(this);
		lHipBone_r2.setRotationPoint(-14.8338F, 30.1829F, 0.313F);
		gStomach.addChild(lHipBone_r2);
		setRotationAngle(lHipBone_r2, 0.0456F, 0.0F, 0.7285F);
		lHipBone_r2.cubeList.add(new ModelBox(lHipBone_r2, 46, 26, -4.0F, -31.8F, -1.5F, 2, 3, 6, 0.0F, false));

		gHips = new RendererModel(this);
		gHips.setRotationPoint(0.0F, 10.0F, 1.7F);
		gStomach.addChild(gHips);
		gHips.cubeList.add(new ModelBox(gHips, 30, 13, -3.5F, -4.7F, -4.2F, 7, 4, 6, 0.0F, false));

		gLeftThigh = new RendererModel(this);
		gLeftThigh.setRotationPoint(1.3F, -1.8F, -1.5F);
		gHips.addChild(gLeftThigh);
		setRotationAngle(gLeftThigh, -0.3927F, 0.0F, 0.0F);
		gLeftThigh.cubeList.add(new ModelBox(gLeftThigh, 57, 0, -1.0F, -1.0F, -2.5F, 4, 15, 5, 0.0F, true));

		gLeftShin = new RendererModel(this);
		gLeftShin.setRotationPoint(0.9F, 13.4F, 0.5F);
		gLeftThigh.addChild(gLeftShin);
		setRotationAngle(gLeftShin, 1.1781F, 0.0F, 0.0F);
		gLeftShin.cubeList.add(new ModelBox(gLeftShin, 88, 0, -1.5F, -1.0F, -2.0F, 3, 13, 4, 0.0F, true));

		gLeftAnkle = new RendererModel(this);
		gLeftAnkle.setRotationPoint(0.1F, 11.9F, 0.0F);
		gLeftShin.addChild(gLeftAnkle);
		setRotationAngle(gLeftAnkle, -1.1781F, 0.0F, 0.0F);
		gLeftAnkle.cubeList.add(new ModelBox(gLeftAnkle, 117, 0, -1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F, true));

		gLeftFoot = new RendererModel(this);
		gLeftFoot.setRotationPoint(0.0F, 4.4F, -0.7F);
		gLeftAnkle.addChild(gLeftFoot);
		setRotationAngle(gLeftFoot, 0.3927F, 0.0F, 0.0F);
		gLeftFoot.cubeList.add(new ModelBox(gLeftFoot, 107, 10, -1.5F, 0.0F, -4.5F, 3, 2, 7, 0.0F, true));

		gRightThigh = new RendererModel(this);
		gRightThigh.setRotationPoint(-1.3F, -1.8F, -1.5F);
		gHips.addChild(gRightThigh);
		setRotationAngle(gRightThigh, -0.3927F, 0.0F, 0.0F);
		gRightThigh.cubeList.add(new ModelBox(gRightThigh, 57, 0, -3.0F, -1.0F, -2.5F, 4, 15, 5, 0.0F, false));

		gRightShin = new RendererModel(this);
		gRightShin.setRotationPoint(-0.9F, 13.4F, 0.5F);
		gRightThigh.addChild(gRightShin);
		setRotationAngle(gRightShin, 1.1781F, 0.0F, 0.0F);
		gRightShin.cubeList.add(new ModelBox(gRightShin, 88, 0, -1.5F, -1.0F, -2.0F, 3, 13, 4, 0.0F, false));

		gRightAnkle = new RendererModel(this);
		gRightAnkle.setRotationPoint(-0.1F, 11.9F, 0.0F);
		gRightShin.addChild(gRightAnkle);
		setRotationAngle(gRightAnkle, -1.1781F, 0.0F, 0.0F);
		gRightAnkle.cubeList.add(new ModelBox(gRightAnkle, 117, 0, -1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F, false));

		gRightFoot = new RendererModel(this);
		gRightFoot.setRotationPoint(0.0F, 4.4F, -0.7F);
		gRightAnkle.addChild(gRightFoot);
		setRotationAngle(gRightFoot, 0.3927F, 0.0F, 0.0F);
		gRightFoot.cubeList.add(new ModelBox(gRightFoot, 107, 10, -1.5F, 0.0F, -4.5F, 3, 2, 7, 0.0F, false));

		gTail1 = new RendererModel(this);
		gTail1.setRotationPoint(0.0F, -1.3F, 1.2F);
		gHips.addChild(gTail1);
		setRotationAngle(gTail1, 0.2276F, 0.0F, 0.0F);
		gTail1.cubeList.add(new ModelBox(gTail1, 0, 49, -0.25F, 0.0F, -0.2F, 1, 3, 1, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 5, 54, -0.75F, 0.0F, -0.8F, 1, 3, 1, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 0, 54, -0.25F, 0.0F, -0.8F, 1, 3, 1, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 5, 49, -0.75F, 0.0F, -0.2F, 1, 3, 1, 0.0F, false));

		gTail2 = new RendererModel(this);
		gTail2.setRotationPoint(0.0F, 2.9F, 0.1F);
		gTail1.addChild(gTail2);
		setRotationAngle(gTail2, -0.3927F, 0.0F, 0.0F);
		gTail2.cubeList.add(new ModelBox(gTail2, 11, 49, -0.25F, -0.1F, -0.3F, 1, 4, 1, -0.1F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 16, 55, -0.75F, -0.1F, -0.8F, 1, 4, 1, -0.1F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 11, 55, -0.25F, -0.1F, -0.8F, 1, 4, 1, -0.1F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 16, 49, -0.75F, -0.1F, -0.3F, 1, 4, 1, -0.1F, false));

		gTail3 = new RendererModel(this);
		gTail3.setRotationPoint(0.0F, 3.8F, 0.0F);
		gTail2.addChild(gTail3);
		setRotationAngle(gTail3, 0.3927F, 0.0F, 0.0F);
		gTail3.cubeList.add(new ModelBox(gTail3, 22, 49, -0.5F, -0.3F, -0.5F, 1, 5, 1, 0.0F, false));

		gTailBlade = new RendererModel(this);
		gTailBlade.setRotationPoint(0.0F, 4.8F, 0.0F);
		gTail3.addChild(gTailBlade);
		setRotationAngle(gTailBlade, 0.3927F, 0.0F, 0.0F);
		gTailBlade.cubeList.add(new ModelBox(gTailBlade, 22, 56, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.1F, false));

		tailBlade02_r1 = new RendererModel(this);
		tailBlade02_r1.setRotationPoint(0.0F, 1.7F, 0.0F);
		gTailBlade.addChild(tailBlade02_r1);
		setRotationAngle(tailBlade02_r1, 0.0F, 0.7854F, 0.0F);
		tailBlade02_r1.cubeList.add(new ModelBox(tailBlade02_r1, 21, 60, -0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false));

		gRightShoulder = new RendererModel(this);
		gRightShoulder.setRotationPoint(-3.0F, -6.6F, 0.0F);
		gChest.addChild(gRightShoulder);
		setRotationAngle(gRightShoulder, 0.0F, 0.0F, 0.7854F);
		gRightShoulder.cubeList.add(new ModelBox(gRightShoulder, 45, 38, -3.0F, -1.0F, -2.0F, 3, 5, 4, 0.0F, false));

		gRightBicep = new RendererModel(this);
		gRightBicep.setRotationPoint(-1.5F, 2.85F, 0.0F);
		gRightShoulder.addChild(gRightBicep);
		setRotationAngle(gRightBicep, 0.0F, 0.0F, -0.7854F);
		gRightBicep.cubeList.add(new ModelBox(gRightBicep, 45, 49, -1.0F, 0.0F, -1.5F, 2, 7, 3, 0.0F, false));

		gRightForearm = new RendererModel(this);
		gRightForearm.setRotationPoint(0.0F, 6.8F, 0.0F);
		gRightBicep.addChild(gRightForearm);
		setRotationAngle(gRightForearm, -0.7854F, 0.0F, 0.0F);
		gRightForearm.cubeList.add(new ModelBox(gRightForearm, 58, 49, -1.0F, 0.0F, -1.0F, 2, 10, 2, -0.1F, false));

		lArmSpike_r1 = new RendererModel(this);
		lArmSpike_r1.setRotationPoint(-0.9557F, -0.4625F, 0.5433F);
		gRightForearm.addChild(lArmSpike_r1);
		setRotationAngle(lArmSpike_r1, -0.4456F, 0.0844F, -0.1413F);
		lArmSpike_r1.cubeList.add(new ModelBox(lArmSpike_r1, 32, 47, -0.4F, -1.5F, -0.7F, 2, 3, 2, 0.0F, false));

		gRightHand = new RendererModel(this);
		gRightHand.setRotationPoint(0.0F, 9.5F, 0.0F);
		gRightForearm.addChild(gRightHand);
		setRotationAngle(gRightHand, 0.3927F, 0.0F, 0.0F);
		gRightHand.cubeList.add(new ModelBox(gRightHand, 67, 49, -1.5F, 0.0F, -1.0F, 3, 4, 1, 0.0F, false));

		gRightFinger1 = new RendererModel(this);
		gRightFinger1.setRotationPoint(1.2F, 3.95F, -1.0F);
		gRightHand.addChild(gRightFinger1);
		gRightFinger1.cubeList.add(new ModelBox(gRightFinger1, 67, 53, 0.0F, -1.1F, -1.0F, 0, 6, 2, 0.0F, false));

		gRightFinger2 = new RendererModel(this);
		gRightFinger2.setRotationPoint(0.6F, 4.0F, -1.0F);
		gRightHand.addChild(gRightFinger2);
		gRightFinger2.cubeList.add(new ModelBox(gRightFinger2, 67, 53, 0.0F, -0.9F, -1.0F, 0, 6, 2, 0.0F, false));

		gRightFinger3 = new RendererModel(this);
		gRightFinger3.setRotationPoint(-0.05F, 3.95F, -1.0F);
		gRightHand.addChild(gRightFinger3);
		gRightFinger3.cubeList.add(new ModelBox(gRightFinger3, 67, 53, 0.0F, -1.1F, -1.0F, 0, 6, 2, 0.0F, false));

		gRightFinger4 = new RendererModel(this);
		gRightFinger4.setRotationPoint(-0.8F, 3.95F, -1.0F);
		gRightHand.addChild(gRightFinger4);
		gRightFinger4.cubeList.add(new ModelBox(gRightFinger4, 67, 53, 0.0F, -1.6F, -1.0F, 0, 6, 2, 0.0F, false));

		gRightFinger5 = new RendererModel(this);
		gRightFinger5.setRotationPoint(-1.3F, 4.0F, -1.0F);
		gRightHand.addChild(gRightFinger5);
		gRightFinger5.cubeList.add(new ModelBox(gRightFinger5, 67, 53, 0.0F, -1.9F, -1.0F, 0, 6, 2, 0.0F, false));

		lFinger05 = new RendererModel(this);
		lFinger05.setRotationPoint(1.4F, 1.5F, -0.6F);
		gRightHand.addChild(lFinger05);
		setRotationAngle(lFinger05, 2.3562F, 0.0F, 3.1416F);
		lFinger05.cubeList.add(new ModelBox(lFinger05, 72, 53, 0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F, false));

		gLeftShoulder = new RendererModel(this);
		gLeftShoulder.setRotationPoint(3.0F, -6.6F, 0.0F);
		gChest.addChild(gLeftShoulder);
		setRotationAngle(gLeftShoulder, 0.0F, 0.0F, -0.7854F);
		gLeftShoulder.cubeList.add(new ModelBox(gLeftShoulder, 45, 38, 0.0F, -1.0F, -2.0F, 3, 5, 4, 0.0F, true));

		gLeftBicep = new RendererModel(this);
		gLeftBicep.setRotationPoint(1.5F, 2.85F, 0.0F);
		gLeftShoulder.addChild(gLeftBicep);
		setRotationAngle(gLeftBicep, 0.0F, 0.0F, 0.7854F);
		gLeftBicep.cubeList.add(new ModelBox(gLeftBicep, 45, 49, -1.0F, 0.0F, -1.5F, 2, 7, 3, 0.0F, true));

		gLeftForearm = new RendererModel(this);
		gLeftForearm.setRotationPoint(0.0F, 6.8F, 0.0F);
		gLeftBicep.addChild(gLeftForearm);
		setRotationAngle(gLeftForearm, -0.7854F, 0.0F, 0.0F);
		gLeftForearm.cubeList.add(new ModelBox(gLeftForearm, 58, 49, -1.0F, 0.0F, -1.0F, 2, 10, 2, -0.1F, true));

		lArmSpike_r2 = new RendererModel(this);
		lArmSpike_r2.setRotationPoint(0.9557F, -0.4625F, 0.5433F);
		gLeftForearm.addChild(lArmSpike_r2);
		setRotationAngle(lArmSpike_r2, -0.4456F, -0.0844F, 0.1413F);
		lArmSpike_r2.cubeList.add(new ModelBox(lArmSpike_r2, 32, 47, -1.6F, -1.5F, -0.7F, 2, 3, 2, 0.0F, true));

		gLeftHand = new RendererModel(this);
		gLeftHand.setRotationPoint(0.0F, 9.5F, 0.0F);
		gLeftForearm.addChild(gLeftHand);
		setRotationAngle(gLeftHand, 0.3927F, 0.0F, 0.0F);
		gLeftHand.cubeList.add(new ModelBox(gLeftHand, 67, 49, -1.5F, 0.0F, -1.0F, 3, 4, 1, 0.0F, true));

		gLeftFinger1 = new RendererModel(this);
		gLeftFinger1.setRotationPoint(-1.2F, 3.95F, -1.0F);
		gLeftHand.addChild(gLeftFinger1);
		gLeftFinger1.cubeList.add(new ModelBox(gLeftFinger1, 67, 53, 0.0F, -1.1F, -1.0F, 0, 6, 2, 0.0F, true));

		gLeftFinger2 = new RendererModel(this);
		gLeftFinger2.setRotationPoint(-0.6F, 4.0F, -1.0F);
		gLeftHand.addChild(gLeftFinger2);
		gLeftFinger2.cubeList.add(new ModelBox(gLeftFinger2, 67, 53, 0.0F, -0.9F, -1.0F, 0, 6, 2, 0.0F, true));

		gLeftFinger3 = new RendererModel(this);
		gLeftFinger3.setRotationPoint(0.05F, 3.95F, -1.0F);
		gLeftHand.addChild(gLeftFinger3);
		gLeftFinger3.cubeList.add(new ModelBox(gLeftFinger3, 67, 53, 0.0F, -1.1F, -1.0F, 0, 6, 2, 0.0F, true));

		gLeftFinger4 = new RendererModel(this);
		gLeftFinger4.setRotationPoint(0.8F, 3.95F, -1.0F);
		gLeftHand.addChild(gLeftFinger4);
		gLeftFinger4.cubeList.add(new ModelBox(gLeftFinger4, 67, 53, 0.0F, -1.6F, -1.0F, 0, 6, 2, 0.0F, true));

		gLeftFinger5 = new RendererModel(this);
		gLeftFinger5.setRotationPoint(1.3F, 4.0F, -1.0F);
		gLeftHand.addChild(gLeftFinger5);
		gLeftFinger5.cubeList.add(new ModelBox(gLeftFinger5, 67, 53, 0.0F, -1.9F, -1.0F, 0, 6, 2, 0.0F, true));

		lFinger2 = new RendererModel(this);
		lFinger2.setRotationPoint(-1.4F, 1.5F, -0.6F);
		gLeftHand.addChild(lFinger2);
		setRotationAngle(lFinger2, 2.3562F, 0.0F, -3.1416F);
		lFinger2.cubeList.add(new ModelBox(lFinger2, 72, 53, 0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F, true));
	}

	@Override
	public void render(DeaconAdultEntity deaconAdultEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}