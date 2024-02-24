package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.UltramorphEntity;

public class UltramorphModel extends EntityModel<UltramorphEntity> {
	private final RendererModel root;
	private final RendererModel chest;
	private final RendererModel gNeck;
	private final RendererModel gHead;
	private final RendererModel cube_r1;
	private final RendererModel gFace;
	private final RendererModel cube_r2;
	private final RendererModel gMouth;
	private final RendererModel gLowerJaw;
	private final RendererModel gInnerJaw;
	private final RendererModel gRightArm;
	private final RendererModel gRightForearm;
	private final RendererModel gRightHand;
	private final RendererModel gLeftArm;
	private final RendererModel gLeftForearm;
	private final RendererModel gLeftHand;
	private final RendererModel gBackSpines;
	private final RendererModel cube_r3;
	private final RendererModel cube_r4;
	private final RendererModel cube_r5;
	private final RendererModel cube_r6;
	private final RendererModel cube_r7;
	private final RendererModel cube_r8;
	private final RendererModel cube_r9;
	private final RendererModel cube_r10;
	private final RendererModel cube_r11;
	private final RendererModel cube_r12;
	private final RendererModel cube_r13;
	private final RendererModel gStomach;
	private final RendererModel gLeftLeg;
	private final RendererModel gLeftShin;
	private final RendererModel gLeftAnkle;
	private final RendererModel gFoot;
	private final RendererModel gRightLeg;
	private final RendererModel gRightShin;
	private final RendererModel gRightAnkle;
	private final RendererModel gFoot2;
	private final RendererModel gTail1;
	private final RendererModel gTail2;
	private final RendererModel gTail3;
	private final RendererModel gTail4;
	private final RendererModel gTail5;
	private final RendererModel gTailBlade;
	private final RendererModel cube_r14;

	public UltramorphModel() {
		textureWidth = 256;
		textureHeight = 128;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		chest = new RendererModel(this);
		chest.setRotationPoint(0.0F, -3.741F, 1.8727F);
		root.addChild(chest);
		setRotationAngle(chest, -0.3927F, 0.0F, 0.0F);
		chest.cubeList.add(new ModelBox(chest, 0, 46, -4.5F, -2.7078F, -10.1102F, 9, 8, 10, 0.0F, false));

		gNeck = new RendererModel(this);
		gNeck.setRotationPoint(0.0F, 0.2922F, -10.1102F);
		chest.addChild(gNeck);
		gNeck.cubeList.add(new ModelBox(gNeck, 23, 86, -2.0F, -2.4F, -4.4F, 4, 6, 5, 0.0F, true));

		gHead = new RendererModel(this);
		gHead.setRotationPoint(0.0F, 1.3F, -3.4F);
		gNeck.addChild(gHead);
		gHead.cubeList.add(new ModelBox(gHead, 0, 0, -2.5F, -5.0F, -4.9F, 5, 10, 5, 0.0F, false));

		cube_r1 = new RendererModel(this);
		cube_r1.setRotationPoint(0.0F, 32.3666F, -0.1143F);
		gHead.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2793F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 28, 10, -2.5F, -44.6F, -14.9F, 5, 10, 5, -0.01F, false));

		gFace = new RendererModel(this);
		gFace.setRotationPoint(0.0F, 4.8999F, -4.8862F);
		gHead.addChild(gFace);
		

		cube_r2 = new RendererModel(this);
		cube_r2.setRotationPoint(-0.15F, 16.764F, 27.0595F);
		gFace.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.5061F, 0.0F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 53, 0, -0.35F, -27.7F, -15.6F, 3, 3, 5, 0.01F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 34, 0, -2.35F, -27.7F, -15.6F, 3, 3, 5, 0.01F, false));

		gMouth = new RendererModel(this);
		gMouth.setRotationPoint(0.0F, 1.3195F, 3.6906F);
		gFace.addChild(gMouth);
		setRotationAngle(gMouth, 0.6981F, 0.0F, 0.0F);
		gMouth.cubeList.add(new ModelBox(gMouth, 52, 20, -1.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, false));

		gLowerJaw = new RendererModel(this);
		gLowerJaw.setRotationPoint(0.0F, -0.0694F, 1.9957F);
		gMouth.addChild(gLowerJaw);
		setRotationAngle(gLowerJaw, 0.0F, 0.0F, 0.0F);
		gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 88, 1, -1.5F, 0.4F, -4.5F, 3, 1, 5, -0.1F, false));

		gInnerJaw = new RendererModel(this);
		gInnerJaw.setRotationPoint(0.0F, -0.15F, 0.5F);
		gLowerJaw.addChild(gInnerJaw);
		setRotationAngle(gInnerJaw, -0.1309F, 0.0F, 0.0F);
		gInnerJaw.cubeList.add(new ModelBox(gInnerJaw, 0, 18, -1.0F, -0.7F, -4.6F, 2, 2, 5, 0.0F, true));

		gRightArm = new RendererModel(this);
		gRightArm.setRotationPoint(-5.0F, 0.9922F, -6.5102F);
		chest.addChild(gRightArm);
		setRotationAngle(gRightArm, 0.7854F, -0.3927F, 0.0F);
		gRightArm.cubeList.add(new ModelBox(gRightArm, 40, 29, -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, false));

		gRightForearm = new RendererModel(this);
		gRightForearm.setRotationPoint(0.0F, 11.9F, 0.0F);
		gRightArm.addChild(gRightForearm);
		gRightForearm.cubeList.add(new ModelBox(gRightForearm, 71, 9, -1.0F, -1.0F, -11.0F, 2, 2, 11, -0.1F, true));

		gRightHand = new RendererModel(this);
		gRightHand.setRotationPoint(0.05F, -0.45F, -10.85F);
		gRightForearm.addChild(gRightHand);
		gRightHand.cubeList.add(new ModelBox(gRightHand, 60, 30, -1.45F, -0.05F, -6.45F, 3, 0, 6, 0.0F, false));
		gRightHand.cubeList.add(new ModelBox(gRightHand, 83, 24, -1.05F, -0.45F, -3.05F, 2, 1, 3, 0.0F, false));

		gLeftArm = new RendererModel(this);
		gLeftArm.setRotationPoint(5.0F, 0.9922F, -6.5102F);
		chest.addChild(gLeftArm);
		setRotationAngle(gLeftArm, 0.7854F, 0.3927F, 0.0F);
		gLeftArm.cubeList.add(new ModelBox(gLeftArm, 40, 29, -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, true));

		gLeftForearm = new RendererModel(this);
		gLeftForearm.setRotationPoint(0.0F, 11.9F, 0.0F);
		gLeftArm.addChild(gLeftForearm);
		gLeftForearm.cubeList.add(new ModelBox(gLeftForearm, 71, 9, -1.0F, -1.0F, -11.0F, 2, 2, 11, -0.1F, false));

		gLeftHand = new RendererModel(this);
		gLeftHand.setRotationPoint(-0.05F, -0.45F, -10.85F);
		gLeftForearm.addChild(gLeftHand);
		gLeftHand.cubeList.add(new ModelBox(gLeftHand, 60, 30, -1.55F, -0.05F, -6.45F, 3, 0, 6, 0.0F, true));
		gLeftHand.cubeList.add(new ModelBox(gLeftHand, 83, 24, -0.95F, -0.45F, -3.05F, 2, 1, 3, 0.0F, true));

		gBackSpines = new RendererModel(this);
		gBackSpines.setRotationPoint(0.0F, -4.2139F, -6.9333F);
		chest.addChild(gBackSpines);
		

		cube_r3 = new RendererModel(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		gBackSpines.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.1613F, 0.3526F, -0.0557F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 155, 25, -4.1351F, -0.1461F, -6.4604F, 2, 9, 5, 0.0F, true));

		cube_r4 = new RendererModel(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		gBackSpines.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.1613F, -0.3526F, 0.0557F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 155, 25, 2.1351F, -0.1461F, -6.4604F, 2, 9, 5, 0.0F, false));

		cube_r5 = new RendererModel(this);
		cube_r5.setRotationPoint(2.9454F, -1.4137F, 0.0232F);
		gBackSpines.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.2618F, 0.0F, 0.3927F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 9, 86, -1.0F, -3.5F, 2.7F, 2, 9, 2, 0.0F, true));

		cube_r6 = new RendererModel(this);
		cube_r6.setRotationPoint(2.9454F, -1.4137F, 0.0232F);
		gBackSpines.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.3927F, 0.0F, 0.3927F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 9, 86, -1.0F, -5.4F, -2.1F, 2, 9, 2, 0.0F, true));

		cube_r7 = new RendererModel(this);
		cube_r7.setRotationPoint(-2.9454F, -1.4137F, 0.0232F);
		gBackSpines.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.2618F, 0.0F, -0.3927F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 9, 86, -1.0F, -3.5F, 2.7F, 2, 9, 2, 0.0F, false));

		cube_r8 = new RendererModel(this);
		cube_r8.setRotationPoint(-2.9454F, -1.4137F, 0.0232F);
		gBackSpines.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.3927F, 0.0F, -0.3927F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 9, 86, -1.0F, -5.4F, -2.1F, 2, 9, 2, 0.0F, false));

		cube_r9 = new RendererModel(this);
		cube_r9.setRotationPoint(6.1226F, -0.7079F, 1.0545F);
		gBackSpines.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.0905F, -0.1042F, 0.4382F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 190, 0, 0.0F, -3.0F, -8.0F, 0, 6, 16, 0.0F, false));

		cube_r10 = new RendererModel(this);
		cube_r10.setRotationPoint(5.27F, -1.2844F, 0.0542F);
		gBackSpines.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.0905F, -0.1042F, 0.4382F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 190, 0, 0.0F, -3.0F, -8.0F, 0, 6, 16, 0.0F, false));

		cube_r11 = new RendererModel(this);
		cube_r11.setRotationPoint(-6.1226F, -0.7079F, 1.0545F);
		gBackSpines.addChild(cube_r11);
		setRotationAngle(cube_r11, -0.0905F, 0.1042F, -0.4382F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 190, 0, 0.0F, -3.0F, -8.0F, 0, 6, 16, 0.0F, true));

		cube_r12 = new RendererModel(this);
		cube_r12.setRotationPoint(-5.27F, -1.2844F, 0.0542F);
		gBackSpines.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.0905F, 0.1042F, -0.4382F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 190, 0, 0.0F, -3.0F, -8.0F, 0, 6, 16, 0.0F, true));

		cube_r13 = new RendererModel(this);
		cube_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
		gBackSpines.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.3054F, 0.0F, 0.0F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 0, 65, -0.2F, -6.5303F, -4.7113F, 0, 8, 10, 0.0F, false));

		gStomach = new RendererModel(this);
		gStomach.setRotationPoint(0.0F, 0.4422F, -0.3233F);
		chest.addChild(gStomach);
		setRotationAngle(gStomach, -0.3927F, 0.0F, 0.0F);
		gStomach.cubeList.add(new ModelBox(gStomach, 23, 69, 0.0F, -4.5343F, -1.0665F, 0, 2, 12, 0.0F, false));
		gStomach.cubeList.add(new ModelBox(gStomach, 0, 27, -3.5F, -3.0F, 0.0F, 7, 6, 12, 0.0F, false));

		gLeftLeg = new RendererModel(this);
		gLeftLeg.setRotationPoint(2.5F, 1.25F, 9.2131F);
		gStomach.addChild(gLeftLeg);
		gLeftLeg.cubeList.add(new ModelBox(gLeftLeg, 40, 45, -1.5F, -2.0F, -2.5F, 4, 14, 5, 0.0F, false));

		gLeftShin = new RendererModel(this);
		gLeftShin.setRotationPoint(0.5F, 11.5494F, 0.1722F);
		gLeftLeg.addChild(gLeftShin);
		setRotationAngle(gLeftShin, 0.3927F, 0.0F, 0.0F);
		gLeftShin.cubeList.add(new ModelBox(gLeftShin, 79, 49, -1.5F, -1.5F, 0.0F, 3, 3, 12, 0.0F, false));

		gLeftAnkle = new RendererModel(this);
		gLeftAnkle.setRotationPoint(0.0F, 0.0F, 12.0F);
		gLeftShin.addChild(gLeftAnkle);
		setRotationAngle(gLeftAnkle, -0.3927F, 0.0F, 0.0F);
		gLeftAnkle.cubeList.add(new ModelBox(gLeftAnkle, 113, 40, -1.0F, -0.5F, -1.0F, 2, 9, 2, 0.0F, false));

		gFoot = new RendererModel(this);
		gFoot.setRotationPoint(-0.0148F, 9.0635F, -0.0592F);
		gLeftAnkle.addChild(gFoot);
		setRotationAngle(gFoot, 0.7854F, 0.0F, 0.0F);
		gFoot.cubeList.add(new ModelBox(gFoot, 110, 24, -0.9852F, -0.7635F, -3.9408F, 2, 2, 5, 0.1F, false));

		gRightLeg = new RendererModel(this);
		gRightLeg.setRotationPoint(-2.5F, 1.25F, 9.2131F);
		gStomach.addChild(gRightLeg);
		gRightLeg.cubeList.add(new ModelBox(gRightLeg, 40, 45, -2.5F, -2.0F, -2.5F, 4, 14, 5, 0.0F, true));

		gRightShin = new RendererModel(this);
		gRightShin.setRotationPoint(-0.5F, 11.5494F, 0.1722F);
		gRightLeg.addChild(gRightShin);
		setRotationAngle(gRightShin, 0.3927F, 0.0F, 0.0F);
		gRightShin.cubeList.add(new ModelBox(gRightShin, 79, 49, -1.5F, -1.5F, 0.0F, 3, 3, 12, 0.0F, true));

		gRightAnkle = new RendererModel(this);
		gRightAnkle.setRotationPoint(0.0F, 0.0F, 12.0F);
		gRightShin.addChild(gRightAnkle);
		setRotationAngle(gRightAnkle, -0.3927F, 0.0F, 0.0F);
		gRightAnkle.cubeList.add(new ModelBox(gRightAnkle, 113, 40, -1.0F, -0.5F, -1.0F, 2, 9, 2, 0.0F, true));

		gFoot2 = new RendererModel(this);
		gFoot2.setRotationPoint(0.0148F, 9.0635F, -0.0592F);
		gRightAnkle.addChild(gFoot2);
		setRotationAngle(gFoot2, 0.7854F, 0.0F, 0.0F);
		gFoot2.cubeList.add(new ModelBox(gFoot2, 110, 24, -1.0148F, -0.7635F, -3.9408F, 2, 2, 5, 0.1F, true));

		gTail1 = new RendererModel(this);
		gTail1.setRotationPoint(0.0F, -1.05F, 12.0131F);
		gStomach.addChild(gTail1);
		setRotationAngle(gTail1, 0.3927F, 0.0F, 0.0F);
		gTail1.cubeList.add(new ModelBox(gTail1, 58, 93, 0.0F, -4.0F, -0.5F, 0, 8, 11, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 50, 66, -2.0F, -2.0F, -0.5F, 4, 4, 11, 0.0F, false));

		gTail2 = new RendererModel(this);
		gTail2.setRotationPoint(0.0F, 0.0F, 10.36F);
		gTail1.addChild(gTail2);
		setRotationAngle(gTail2, 0.0F, 0.0F, 0.0F);
		gTail2.cubeList.add(new ModelBox(gTail2, 90, 93, 0.0F, -4.0F, -0.5F, 0, 8, 11, 0.0F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 85, 66, -2.0F, -2.0F, -0.5F, 4, 4, 11, -0.1F, false));

		gTail3 = new RendererModel(this);
		gTail3.setRotationPoint(0.0F, 0.05F, 10.45F);
		gTail2.addChild(gTail3);
		setRotationAngle(gTail3, 0.0F, 0.0F, 0.0F);
		gTail3.cubeList.add(new ModelBox(gTail3, 117, 94, 0.0F, -2.75F, -0.25F, 0, 6, 10, 0.0F, false));
		gTail3.cubeList.add(new ModelBox(gTail3, 118, 66, -1.5F, -1.75F, -0.25F, 3, 3, 11, 0.0F, false));

		gTail4 = new RendererModel(this);
		gTail4.setRotationPoint(0.0F, -0.65F, 10.7F);
		gTail3.addChild(gTail4);
		setRotationAngle(gTail4, 0.0F, 0.0F, 0.0F);
		gTail4.cubeList.add(new ModelBox(gTail4, 148, 96, 0.0F, -2.0F, -0.25F, 0, 4, 10, 0.0F, false));
		gTail4.cubeList.add(new ModelBox(gTail4, 149, 66, -1.0F, -1.0F, -0.25F, 2, 2, 11, 0.0F, false));

		gTail5 = new RendererModel(this);
		gTail5.setRotationPoint(0.0F, -0.4F, 10.85F);
		gTail4.addChild(gTail5);
		setRotationAngle(gTail5, 0.0F, 0.0F, 0.0F);
		gTail5.cubeList.add(new ModelBox(gTail5, 178, 96, 0.0F, -1.5F, 0.9F, 0, 3, 11, 0.0F, false));
		gTail5.cubeList.add(new ModelBox(gTail5, 178, 66, -0.5F, -0.5F, -0.1F, 1, 1, 11, 0.0F, false));

		gTailBlade = new RendererModel(this);
		gTailBlade.setRotationPoint(0.0F, 0.06F, 10.94F);
		gTail5.addChild(gTailBlade);
		

		cube_r14 = new RendererModel(this);
		cube_r14.setRotationPoint(0.0F, 0.3F, -0.8F);
		gTailBlade.addChild(cube_r14);
		setRotationAngle(cube_r14, -1.5708F, 0.0F, 0.0F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 213, 64, 0.0F, -10.5F, -1.5F, 0, 11, 3, 0.0F, false));
	}

	@Override
	public void render(UltramorphEntity ultramorphEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}