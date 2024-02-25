package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.EngineerEntity;

public class EngineerModel extends EntityModel<EngineerEntity> {
	private final RendererModel root;
	private final RendererModel gChest;
	private final RendererModel chest_r1;
	private final RendererModel gNeck;
	private final RendererModel gHead;
	private final RendererModel gHelmet;
	private final RendererModel head2_r1;
	private final RendererModel nozzle4_r1;
	private final RendererModel nozzle3_r1;
	private final RendererModel nozzle2_r1;
	private final RendererModel nozzle2_r2;
	private final RendererModel nozzle1_r1;
	private final RendererModel gLeftArm;
	private final RendererModel rArmUpper_r1;
	private final RendererModel gLeftForearm;
	private final RendererModel gLeftHand;
	private final RendererModel lArmLower_3_r1;
	private final RendererModel gRightArm;
	private final RendererModel rArmUpper_r2;
	private final RendererModel gRightForearm;
	private final RendererModel gRightHand;
	private final RendererModel lArmLower_4_r1;
	private final RendererModel stomach;
	private final RendererModel gLeftThigh;
	private final RendererModel gLeftShin;
	private final RendererModel gLeftFoot;
	private final RendererModel gRightThigh;
	private final RendererModel gRightShin;
	private final RendererModel gRightFoot;

	public EngineerModel() {
		textureWidth = 128;
		textureHeight = 64;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, -4.9F, 0.0F);
		

		gChest = new RendererModel(this);
		gChest.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.addChild(gChest);
		gChest.cubeList.add(new ModelBox(gChest, 1, 24, -3.0F, -1.0F, -2.5F, 6, 6, 5, 0.3F, false));
		gChest.cubeList.add(new ModelBox(gChest, 12, 29, -3.0F, -1.0F, 2.5F, 6, 6, 0, 0.3F, false));

		chest_r1 = new RendererModel(this);
		chest_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
		gChest.addChild(chest_r1);
		setRotationAngle(chest_r1, 0.1309F, 0.0F, 0.0F);
		chest_r1.cubeList.add(new ModelBox(chest_r1, 6, 27, -1.0F, -3.0F, -2.8F, 2, 5, 2, 0.3F, false));

		gNeck = new RendererModel(this);
		gNeck.setRotationPoint(0.0F, -0.4F, 0.0F);
		gChest.addChild(gNeck);
		setRotationAngle(gNeck, 0.0F, 0.0F, 0.0F);
		gNeck.cubeList.add(new ModelBox(gNeck, 0, 15, -2.0F, -3.1F, -2.0F, 4, 3, 4, -0.3F, false));

		gHead = new RendererModel(this);
		gHead.setRotationPoint(0.0F, -1.4F, 0.0F);
		gNeck.addChild(gHead);
		gHead.cubeList.add(new ModelBox(gHead, 82, 0, -2.5F, -6.0F, -2.5F, 5, 5, 5, -0.2F, false));

		gHelmet = new RendererModel(this);
		gHelmet.setRotationPoint(0.0F, 0.6F, 1.0F);
		gHead.addChild(gHelmet);
		gHelmet.cubeList.add(new ModelBox(gHelmet, 17, 0, -2.5F, -6.0F, -3.2F, 5, 4, 4, 0.3F, false));
		gHelmet.cubeList.add(new ModelBox(gHelmet, 17, -1, -2.5F, -6.3F, -3.2F, 5, 1, 4, 0.2F, false));

		head2_r1 = new RendererModel(this);
		head2_r1.setRotationPoint(0.0F, -3.4014F, 0.0187F);
		gHelmet.addChild(head2_r1);
		setRotationAngle(head2_r1, -0.0175F, 0.0F, 0.0F);
		head2_r1.cubeList.add(new ModelBox(head2_r1, 0, 0, -2.0F, -2.7F, -2.0F, 4, 4, 4, 0.35F, false));

		nozzle4_r1 = new RendererModel(this);
		nozzle4_r1.setRotationPoint(0.5F, -0.5339F, -3.9857F);
		gHelmet.addChild(nozzle4_r1);
		setRotationAngle(nozzle4_r1, 2.0159F, 0.0F, 0.0F);
		nozzle4_r1.cubeList.add(new ModelBox(nozzle4_r1, 47, 0, -1.0F, -1.3F, -2.4F, 1, 1, 2, -0.1F, false));

		nozzle3_r1 = new RendererModel(this);
		nozzle3_r1.setRotationPoint(0.5F, -1.2395F, -3.8588F);
		gHelmet.addChild(nozzle3_r1);
		setRotationAngle(nozzle3_r1, 1.7541F, 0.0F, 0.0F);
		nozzle3_r1.cubeList.add(new ModelBox(nozzle3_r1, 47, 0, -1.0F, -1.2533F, -1.6706F, 1, 1, 2, 0.05F, false));

		nozzle2_r1 = new RendererModel(this);
		nozzle2_r1.setRotationPoint(0.5F, -1.3395F, -3.8588F);
		gHelmet.addChild(nozzle2_r1);
		setRotationAngle(nozzle2_r1, 1.3614F, 0.0F, 0.0F);
		nozzle2_r1.cubeList.add(new ModelBox(nozzle2_r1, 47, 0, -1.0F, -1.0226F, -0.2835F, 1, 1, 2, 0.3F, false));

		nozzle2_r2 = new RendererModel(this);
		nozzle2_r2.setRotationPoint(0.5F, -3.4537F, -2.9944F);
		gHelmet.addChild(nozzle2_r2);
		setRotationAngle(nozzle2_r2, 0.8378F, 0.0F, 0.0F);
		nozzle2_r2.cubeList.add(new ModelBox(nozzle2_r2, 36, 0, -1.0F, -1.0F, -0.8F, 1, 2, 2, 0.4F, false));

		nozzle1_r1 = new RendererModel(this);
		nozzle1_r1.setRotationPoint(0.5F, -2.8578F, -3.2062F);
		gHelmet.addChild(nozzle1_r1);
		setRotationAngle(nozzle1_r1, 0.5585F, 0.0F, 0.0F);
		nozzle1_r1.cubeList.add(new ModelBox(nozzle1_r1, 36, 0, -1.5F, -1.0F, -1.0F, 2, 2, 2, 0.1F, false));

		gLeftArm = new RendererModel(this);
		gLeftArm.setRotationPoint(3.1F, 0.05F, -0.2F);
		gChest.addChild(gLeftArm);
		gLeftArm.cubeList.add(new ModelBox(gLeftArm, 44, 22, 1.1F, -0.25F, -1.2F, 2, 6, 3, 0.35F, false));

		rArmUpper_r1 = new RendererModel(this);
		rArmUpper_r1.setRotationPoint(2.0F, 2.25F, 0.0F);
		gLeftArm.addChild(rArmUpper_r1);
		setRotationAngle(rArmUpper_r1, 0.0F, 0.0F, -1.309F);
		rArmUpper_r1.cubeList.add(new ModelBox(rArmUpper_r1, 56, 24, 0.7F, -2.8F, -0.8F, 2, 3, 2, 0.45F, false));

		gLeftForearm = new RendererModel(this);
		gLeftForearm.setRotationPoint(2.0F, 6.15F, 0.0F);
		gLeftArm.addChild(gLeftForearm);
		setRotationAngle(gLeftForearm, 0.0F, 0.0F, 0.0F);
		gLeftForearm.cubeList.add(new ModelBox(gLeftForearm, 44, 33, -1.0F, 0.2F, -1.0F, 2, 5, 2, 0.25F, false));

		gLeftHand = new RendererModel(this);
		gLeftHand.setRotationPoint(0.0F, 5.8F, 0.0F);
		gLeftForearm.addChild(gLeftHand);
		setRotationAngle(gLeftHand, 0.0F, 0.0F, 0.0F);
		gLeftHand.cubeList.add(new ModelBox(gLeftHand, 44, 38, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.35F, false));

		lArmLower_3_r1 = new RendererModel(this);
		lArmLower_3_r1.setRotationPoint(0.0F, 1.8F, 0.0F);
		gLeftHand.addChild(lArmLower_3_r1);
		setRotationAngle(lArmLower_3_r1, 0.0F, 0.0F, -1.7453F);
		lArmLower_3_r1.cubeList.add(new ModelBox(lArmLower_3_r1, 44, 38, -0.5F, -1.0F, -1.0F, 1, 2, 2, 0.25F, false));

		gRightArm = new RendererModel(this);
		gRightArm.setRotationPoint(-3.1F, 0.05F, -0.2F);
		gChest.addChild(gRightArm);
		gRightArm.cubeList.add(new ModelBox(gRightArm, 44, 22, -3.1F, -0.25F, -1.2F, 2, 6, 3, 0.35F, true));

		rArmUpper_r2 = new RendererModel(this);
		rArmUpper_r2.setRotationPoint(-2.0F, 2.25F, 0.0F);
		gRightArm.addChild(rArmUpper_r2);
		setRotationAngle(rArmUpper_r2, 0.0F, 0.0F, 1.309F);
		rArmUpper_r2.cubeList.add(new ModelBox(rArmUpper_r2, 56, 24, -2.7F, -2.8F, -0.8F, 2, 3, 2, 0.45F, true));

		gRightForearm = new RendererModel(this);
		gRightForearm.setRotationPoint(-2.0F, 6.15F, 0.0F);
		gRightArm.addChild(gRightForearm);
		setRotationAngle(gRightForearm, 0.0F, 0.0F, 0.0F);
		gRightForearm.cubeList.add(new ModelBox(gRightForearm, 44, 33, -1.0F, 0.2F, -1.0F, 2, 5, 2, 0.25F, true));

		gRightHand = new RendererModel(this);
		gRightHand.setRotationPoint(0.0F, 5.8F, 0.0F);
		gRightForearm.addChild(gRightHand);
		setRotationAngle(gRightHand, 0.0F, 0.0F, 0.0F);
		gRightHand.cubeList.add(new ModelBox(gRightHand, 44, 38, -1.0F, 0.0F, -1.0F, 2, 2, 2, 0.35F, true));

		lArmLower_4_r1 = new RendererModel(this);
		lArmLower_4_r1.setRotationPoint(0.0F, 1.8F, 0.0F);
		gRightHand.addChild(lArmLower_4_r1);
		setRotationAngle(lArmLower_4_r1, 0.0F, 0.0F, 1.7453F);
		lArmLower_4_r1.cubeList.add(new ModelBox(lArmLower_4_r1, 44, 38, -0.5F, -1.0F, -1.0F, 1, 2, 2, 0.25F, true));

		stomach = new RendererModel(this);
		stomach.setRotationPoint(0.0F, 1.3F, 0.0F);
		gChest.addChild(stomach);
		stomach.cubeList.add(new ModelBox(stomach, 0, 36, -2.5F, 3.0F, -2.5F, 5, 7, 5, -0.2F, false));

		gLeftThigh = new RendererModel(this);
		gLeftThigh.setRotationPoint(1.2F, 9.1F, 0.0F);
		stomach.addChild(gLeftThigh);
		setRotationAngle(gLeftThigh, 0.0F, 0.0F, 0.0F);
		gLeftThigh.cubeList.add(new ModelBox(gLeftThigh, 71, 22, -1.0F, 0.0F, -2.0F, 3, 8, 4, 0.05F, false));

		gLeftShin = new RendererModel(this);
		gLeftShin.setRotationPoint(0.476F, 8.0125F, -1.05F);
		gLeftThigh.addChild(gLeftShin);
		setRotationAngle(gLeftShin, 0.0F, 0.0F, 0.0F);
		gLeftShin.cubeList.add(new ModelBox(gLeftShin, 71, 35, -1.0F, 0.4F, -0.5F, 2, 8, 3, 0.3F, false));

		gLeftFoot = new RendererModel(this);
		gLeftFoot.setRotationPoint(0.024F, 8.6875F, 0.95F);
		gLeftShin.addChild(gLeftFoot);
		gLeftFoot.cubeList.add(new ModelBox(gLeftFoot, 88, 47, -1.0F, 0.4F, -3.5F, 2, 1, 5, 0.45F, false));

		gRightThigh = new RendererModel(this);
		gRightThigh.setRotationPoint(-1.2F, 9.1F, 0.0F);
		stomach.addChild(gRightThigh);
		setRotationAngle(gRightThigh, 0.0F, 0.0F, 0.0F);
		gRightThigh.cubeList.add(new ModelBox(gRightThigh, 71, 22, -2.0F, 0.0F, -2.0F, 3, 8, 4, 0.05F, true));

		gRightShin = new RendererModel(this);
		gRightShin.setRotationPoint(-0.476F, 8.0125F, -1.05F);
		gRightThigh.addChild(gRightShin);
		setRotationAngle(gRightShin, 0.0F, 0.0F, 0.0F);
		gRightShin.cubeList.add(new ModelBox(gRightShin, 71, 35, -1.0F, 0.4F, -0.5F, 2, 8, 3, 0.3F, true));

		gRightFoot = new RendererModel(this);
		gRightFoot.setRotationPoint(-0.024F, 8.6875F, 0.95F);
		gRightShin.addChild(gRightFoot);
		gRightFoot.cubeList.add(new ModelBox(gRightFoot, 88, 47, -1.0F, 0.4F, -3.5F, 2, 1, 5, 0.45F, true));
	}

	@Override
	public void render(EngineerEntity engineerEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}