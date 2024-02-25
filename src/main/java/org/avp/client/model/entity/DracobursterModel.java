package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.DracobursterEntity;

public class DracobursterModel extends EntityModel<DracobursterEntity> {
	private final RendererModel root;
	private final RendererModel chest;
	private final RendererModel abdomen;
	private final RendererModel backSpines1;
	private final RendererModel backSpines2;
	private final RendererModel gNeck;
	private final RendererModel gNeckEnd;
	private final RendererModel gHead;
	private final RendererModel jaw2_r1;
	private final RendererModel lHead_r1;
	private final RendererModel headTop_r1;
	private final RendererModel jawLower;
	private final RendererModel gNinnerJaw;
	private final RendererModel gLeftLeg;
	private final RendererModel gLeftShin;
	private final RendererModel gLeftAnkle;
	private final RendererModel gLeftFoot;
	private final RendererModel gRightLeg;
	private final RendererModel gRightShin;
	private final RendererModel gRightAnkle;
	private final RendererModel gRightFoot;
	private final RendererModel gLeftArm;
	private final RendererModel gLeftForearm;
	private final RendererModel gLeftClaw;
	private final RendererModel gRightArm;
	private final RendererModel gRightForearm;
	private final RendererModel gRightClaw;
	private final RendererModel rClaw3_r1;
	private final RendererModel gTail1;
	private final RendererModel gTail2;
	private final RendererModel gTail3;
	private final RendererModel gTail4;
	private final RendererModel gTail5;
	private final RendererModel gTailClaw;
	private final RendererModel gLeftWing;
	private final RendererModel gLeftWingBone;
	private final RendererModel gLeftWingEnd;
	private final RendererModel gRightWing;
	private final RendererModel gRightWingBone;
	private final RendererModel gRightWingEnd;

	public DracobursterModel() {
		textureWidth = 256;
		textureHeight = 128;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 0.0F, -8.6969F);
		

		chest = new RendererModel(this);
		chest.setRotationPoint(0.0F, -1.5F, 0.0F);
		root.addChild(chest);
		chest.cubeList.add(new ModelBox(chest, 0, 46, -4.5F, 0.0F, 0.0F, 9, 8, 10, 0.0F, false));

		abdomen = new RendererModel(this);
		abdomen.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(abdomen);
		abdomen.cubeList.add(new ModelBox(abdomen, 0, 27, -3.5F, 0.5F, 8.0F, 7, 6, 12, 0.0F, false));

		backSpines1 = new RendererModel(this);
		backSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(backSpines1);
		backSpines1.cubeList.add(new ModelBox(backSpines1, 0, 67, 0.0F, -5.8F, 0.0F, 0, 6, 10, 0.0F, false));

		backSpines2 = new RendererModel(this);
		backSpines2.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(backSpines2);
		backSpines2.cubeList.add(new ModelBox(backSpines2, 23, 65, 0.0F, -5.5F, 8.5F, 0, 6, 12, 0.0F, false));

		gNeck = new RendererModel(this);
		gNeck.setRotationPoint(0.0F, 3.0F, 1.1F);
		chest.addChild(gNeck);
		setRotationAngle(gNeck, -0.7854F, 0.0F, 0.0F);
		gNeck.cubeList.add(new ModelBox(gNeck, 23, 86, -2.5F, -3.0F, -5.5F, 5, 5, 5, -0.5F, false));

		gNeckEnd = new RendererModel(this);
		gNeckEnd.setRotationPoint(0.0F, -0.5F, -4.9F);
		gNeck.addChild(gNeckEnd);
		setRotationAngle(gNeckEnd, 0.3927F, 0.0F, 0.0F);
		gNeckEnd.cubeList.add(new ModelBox(gNeckEnd, 23, 100, -1.5F, -2.0F, -2.8F, 3, 4, 3, 0.0F, false));

		gHead = new RendererModel(this);
		gHead.setRotationPoint(0.0F, -2.2F, -2.9F);
		gNeckEnd.addChild(gHead);
		setRotationAngle(gHead, -0.3927F, 0.0F, 0.0F);
		gHead.cubeList.add(new ModelBox(gHead, 0, 0, -2.5F, -3.2F, -3.9F, 5, 10, 5, 0.0F, false));

		jaw2_r1 = new RendererModel(this);
		jaw2_r1.setRotationPoint(0.0F, 14.8029F, 20.7638F);
		gHead.addChild(jaw2_r1);
		setRotationAngle(jaw2_r1, 0.7741F, 0.0F, 0.0F);
		jaw2_r1.cubeList.add(new ModelBox(jaw2_r1, 52, 20, -1.5F, -20.1F, -12.9F, 3, 1, 5, 0.0F, false));

		lHead_r1 = new RendererModel(this);
		lHead_r1.setRotationPoint(-2.0F, 19.8416F, 16.0087F);
		gHead.addChild(lHead_r1);
		setRotationAngle(lHead_r1, 0.5009F, 0.0F, 0.0F);
		lHead_r1.cubeList.add(new ModelBox(lHead_r1, 53, 0, -0.3F, -21.0F, -11.2F, 3, 3, 5, 0.0F, true));
		lHead_r1.cubeList.add(new ModelBox(lHead_r1, 53, 0, 1.3F, -21.0F, -11.2F, 3, 3, 5, 0.0F, false));

		headTop_r1 = new RendererModel(this);
		headTop_r1.setRotationPoint(0.0F, 25.2461F, -3.5912F);
		gHead.addChild(headTop_r1);
		setRotationAngle(headTop_r1, -0.3187F, 0.0F, 0.0F);
		headTop_r1.cubeList.add(new ModelBox(headTop_r1, 28, 10, -2.5F, -36.6F, -9.3F, 5, 10, 5, -0.25F, false));

		jawLower = new RendererModel(this);
		jawLower.setRotationPoint(0.0F, 6.7F, 2.3F);
		gHead.addChild(jawLower);
		setRotationAngle(jawLower, 0.7741F, 0.0F, 0.0F);
		jawLower.cubeList.add(new ModelBox(jawLower, 88, 1, -1.5F, -0.5F, -5.4F, 3, 1, 5, -0.1F, false));

		gNinnerJaw = new RendererModel(this);
		gNinnerJaw.setRotationPoint(0.0F, -0.8F, -0.1F);
		jawLower.addChild(gNinnerJaw);
		setRotationAngle(gNinnerJaw, -0.2182F, 0.0F, 0.0F);
		gNinnerJaw.cubeList.add(new ModelBox(gNinnerJaw, 0, 18, -1.0F, -0.7F, -4.6F, 2, 2, 5, -0.2F, false));

		gLeftLeg = new RendererModel(this);
		gLeftLeg.setRotationPoint(3.5F, 4.1F, 17.8F);
		chest.addChild(gLeftLeg);
		setRotationAngle(gLeftLeg, -0.3927F, 0.0F, 0.0F);
		gLeftLeg.cubeList.add(new ModelBox(gLeftLeg, 61, 47, -1.0F, -2.0F, -1.5F, 2, 14, 3, 0.0F, false));

		gLeftShin = new RendererModel(this);
		gLeftShin.setRotationPoint(0.0F, 11.6F, 0.1F);
		gLeftLeg.addChild(gLeftShin);
		setRotationAngle(gLeftShin, 0.3927F, 0.0F, 0.0F);
		gLeftShin.cubeList.add(new ModelBox(gLeftShin, 79, 33, -1.0F, -0.9F, -0.3F, 2, 2, 12, -0.1F, false));

		gLeftAnkle = new RendererModel(this);
		gLeftAnkle.setRotationPoint(0.0F, 0.2F, 11.1F);
		gLeftShin.addChild(gLeftAnkle);
		setRotationAngle(gLeftAnkle, -0.3927F, 0.0F, 0.0F);
		gLeftAnkle.cubeList.add(new ModelBox(gLeftAnkle, 113, 53, -1.0F, -0.2F, -1.1F, 2, 9, 2, -0.2F, false));

		gLeftFoot = new RendererModel(this);
		gLeftFoot.setRotationPoint(0.0F, 8.2F, 0.0F);
		gLeftAnkle.addChild(gLeftFoot);
		setRotationAngle(gLeftFoot, 0.3927F, 0.0F, 0.0F);
		gLeftFoot.cubeList.add(new ModelBox(gLeftFoot, 95, 24, -1.0F, -1.0F, -4.4F, 2, 2, 5, 0.0F, false));

		gRightLeg = new RendererModel(this);
		gRightLeg.setRotationPoint(-3.5F, 4.1F, 17.8F);
		chest.addChild(gRightLeg);
		setRotationAngle(gRightLeg, -0.3927F, 0.0F, 0.0F);
		gRightLeg.cubeList.add(new ModelBox(gRightLeg, 61, 47, -1.0F, -2.0F, -1.5F, 2, 14, 3, 0.0F, true));

		gRightShin = new RendererModel(this);
		gRightShin.setRotationPoint(0.0F, 11.6F, 0.1F);
		gRightLeg.addChild(gRightShin);
		setRotationAngle(gRightShin, 0.3927F, 0.0F, 0.0F);
		gRightShin.cubeList.add(new ModelBox(gRightShin, 79, 33, -1.0F, -0.9F, -0.3F, 2, 2, 12, -0.1F, true));

		gRightAnkle = new RendererModel(this);
		gRightAnkle.setRotationPoint(0.0F, 0.2F, 11.1F);
		gRightShin.addChild(gRightAnkle);
		setRotationAngle(gRightAnkle, -0.3927F, 0.0F, 0.0F);
		gRightAnkle.cubeList.add(new ModelBox(gRightAnkle, 113, 53, -1.0F, -0.2F, -1.1F, 2, 9, 2, -0.2F, true));

		gRightFoot = new RendererModel(this);
		gRightFoot.setRotationPoint(0.0F, 8.2F, 0.0F);
		gRightAnkle.addChild(gRightFoot);
		setRotationAngle(gRightFoot, 0.3927F, 0.0F, 0.0F);
		gRightFoot.cubeList.add(new ModelBox(gRightFoot, 95, 24, -1.0F, -1.0F, -4.4F, 2, 2, 5, 0.0F, true));

		gLeftArm = new RendererModel(this);
		gLeftArm.setRotationPoint(4.5F, 4.3F, 3.6F);
		chest.addChild(gLeftArm);
		gLeftArm.cubeList.add(new ModelBox(gLeftArm, 50, 29, -1.0F, -1.5F, -1.0F, 2, 13, 2, 0.0F, false));

		gLeftForearm = new RendererModel(this);
		gLeftForearm.setRotationPoint(-0.2F, 11.4F, 0.1F);
		gLeftArm.addChild(gLeftForearm);
		setRotationAngle(gLeftForearm, 0.7854F, 0.0F, 0.0F);
		gLeftForearm.cubeList.add(new ModelBox(gLeftForearm, 98, 9, -0.8F, -1.1F, -10.6F, 2, 2, 11, -0.1F, false));

		gLeftClaw = new RendererModel(this);
		gLeftClaw.setRotationPoint(0.1F, -0.1F, -9.8F);
		gLeftForearm.addChild(gLeftClaw);
		setRotationAngle(gLeftClaw, -0.7854F, 0.0F, 0.0F);
		gLeftClaw.cubeList.add(new ModelBox(gLeftClaw, 72, 24, -0.9F, 0.0F, -3.1F, 2, 1, 3, 0.0F, false));
		gLeftClaw.cubeList.add(new ModelBox(gLeftClaw, 60, 38, -1.4F, 0.4F, -6.9F, 3, 0, 6, 0.0F, false));

		gRightArm = new RendererModel(this);
		gRightArm.setRotationPoint(-4.5F, 4.3F, 3.6F);
		chest.addChild(gRightArm);
		gRightArm.cubeList.add(new ModelBox(gRightArm, 50, 29, -1.0F, -1.5F, -1.0F, 2, 13, 2, 0.0F, true));

		gRightForearm = new RendererModel(this);
		gRightForearm.setRotationPoint(0.2F, 11.4F, 0.1F);
		gRightArm.addChild(gRightForearm);
		setRotationAngle(gRightForearm, 0.7854F, 0.0F, 0.0F);
		gRightForearm.cubeList.add(new ModelBox(gRightForearm, 98, 9, -1.2F, -1.1F, -10.6F, 2, 2, 11, -0.1F, true));

		gRightClaw = new RendererModel(this);
		gRightClaw.setRotationPoint(-0.1F, -0.1F, -9.8F);
		gRightForearm.addChild(gRightClaw);
		setRotationAngle(gRightClaw, -0.7854F, 0.0F, 0.0F);
		gRightClaw.cubeList.add(new ModelBox(gRightClaw, 72, 24, -1.1F, 0.0F, -3.1F, 2, 1, 3, 0.0F, true));

		rClaw3_r1 = new RendererModel(this);
		rClaw3_r1.setRotationPoint(-0.1F, 0.4F, -3.9F);
		gRightClaw.addChild(rClaw3_r1);
		setRotationAngle(rClaw3_r1, 0.1745F, 0.0F, 0.0F);
		rClaw3_r1.cubeList.add(new ModelBox(rClaw3_r1, 60, 38, -1.5F, 0.0F, -3.0F, 3, 0, 6, 0.0F, true));

		gTail1 = new RendererModel(this);
		gTail1.setRotationPoint(0.0F, 3.5F, 18.5F);
		chest.addChild(gTail1);
		setRotationAngle(gTail1, -0.0087F, 0.0F, 0.0F);
		gTail1.cubeList.add(new ModelBox(gTail1, 58, 93, 0.0F, -4.7F, 0.0F, 0, 8, 11, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 50, 66, -2.0F, -2.5F, 0.0F, 4, 4, 11, 0.0F, false));

		gTail2 = new RendererModel(this);
		gTail2.setRotationPoint(0.0F, 0.0F, 11.0F);
		gTail1.addChild(gTail2);
		gTail2.cubeList.add(new ModelBox(gTail2, 90, 93, 0.0F, -4.5F, 0.2F, 0, 8, 11, 0.0F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 85, 66, -2.0F, -2.5F, -0.1F, 4, 4, 11, -0.1F, false));

		gTail3 = new RendererModel(this);
		gTail3.setRotationPoint(0.0F, 0.0F, 10.4F);
		gTail2.addChild(gTail3);
		gTail3.cubeList.add(new ModelBox(gTail3, 118, 66, -1.5F, -1.8F, 0.0F, 3, 3, 11, 0.0F, false));
		gTail3.cubeList.add(new ModelBox(gTail3, 118, 94, 0.0F, -2.9F, 1.3F, 0, 6, 10, 0.0F, false));

		gTail4 = new RendererModel(this);
		gTail4.setRotationPoint(0.0F, 0.0F, 11.0F);
		gTail3.addChild(gTail4);
		gTail4.cubeList.add(new ModelBox(gTail4, 149, 66, -1.0F, -1.0F, 0.0F, 2, 2, 11, 0.0F, false));
		gTail4.cubeList.add(new ModelBox(gTail4, 149, 96, 0.0F, -2.1F, 1.1F, 0, 4, 10, 0.0F, false));

		gTail5 = new RendererModel(this);
		gTail5.setRotationPoint(0.0F, 0.0F, 11.0F);
		gTail4.addChild(gTail5);
		gTail5.cubeList.add(new ModelBox(gTail5, 177, 96, 0.0F, -0.9F, 0.4F, 0, 3, 11, 0.0F, false));
		gTail5.cubeList.add(new ModelBox(gTail5, 178, 66, -0.5F, -0.2F, 0.0F, 1, 1, 11, 0.0F, false));

		gTailClaw = new RendererModel(this);
		gTailClaw.setRotationPoint(0.0F, 0.3F, 10.2F);
		gTail5.addChild(gTailClaw);
		gTailClaw.cubeList.add(new ModelBox(gTailClaw, 205, 66, 0.0F, -1.4F, 0.0F, 0, 3, 11, 0.0F, false));

		gLeftWing = new RendererModel(this);
		gLeftWing.setRotationPoint(3.9F, 0.1F, 3.6F);
		chest.addChild(gLeftWing);
		setRotationAngle(gLeftWing, -0.7854F, 0.0F, 0.3927F);
		gLeftWing.cubeList.add(new ModelBox(gLeftWing, 133, 15, -1.0F, -7.8F, -0.9F, 2, 9, 2, -0.25F, false));

		gLeftWingBone = new RendererModel(this);
		gLeftWingBone.setRotationPoint(0.0F, -7.1F, 0.0F);
		gLeftWing.addChild(gLeftWingBone);
		setRotationAngle(gLeftWingBone, -2.3562F, 0.0F, 0.0F);
		gLeftWingBone.cubeList.add(new ModelBox(gLeftWingBone, 143, 14, -0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F, false));

		gLeftWingEnd = new RendererModel(this);
		gLeftWingEnd.setRotationPoint(0.0F, 0.1F, 7.9F);
		gLeftWingBone.addChild(gLeftWingEnd);
		setRotationAngle(gLeftWingEnd, -1.5708F, 0.0F, 0.0F);
		gLeftWingEnd.cubeList.add(new ModelBox(gLeftWingEnd, 162, 0, 0.0F, 0.0F, 0.0F, 0, 7, 6, 0.0F, false));
		gLeftWingEnd.cubeList.add(new ModelBox(gLeftWingEnd, 166, 17, -0.5F, -0.6F, 0.0F, 1, 1, 5, -0.1F, false));

		gRightWing = new RendererModel(this);
		gRightWing.setRotationPoint(-3.9F, 0.1F, 3.6F);
		chest.addChild(gRightWing);
		setRotationAngle(gRightWing, -0.7854F, 0.0F, -0.3927F);
		gRightWing.cubeList.add(new ModelBox(gRightWing, 133, 15, -1.0F, -7.8F, -0.9F, 2, 9, 2, -0.25F, true));

		gRightWingBone = new RendererModel(this);
		gRightWingBone.setRotationPoint(0.0F, -7.1F, 0.0F);
		gRightWing.addChild(gRightWingBone);
		setRotationAngle(gRightWingBone, -2.3562F, 0.0F, 0.0F);
		gRightWingBone.cubeList.add(new ModelBox(gRightWingBone, 143, 14, -0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F, true));

		gRightWingEnd = new RendererModel(this);
		gRightWingEnd.setRotationPoint(0.0F, 0.1F, 7.9F);
		gRightWingBone.addChild(gRightWingEnd);
		setRotationAngle(gRightWingEnd, -1.5708F, 0.0F, 0.0F);
		gRightWingEnd.cubeList.add(new ModelBox(gRightWingEnd, 162, 0, 0.0F, 0.0F, 0.0F, 0, 7, 6, 0.0F, true));
		gRightWingEnd.cubeList.add(new ModelBox(gRightWingEnd, 166, 17, -0.5F, -0.6F, 0.0F, 1, 1, 5, -0.1F, true));
	}

	@Override
	public void render(DracobursterEntity dracobursterEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}