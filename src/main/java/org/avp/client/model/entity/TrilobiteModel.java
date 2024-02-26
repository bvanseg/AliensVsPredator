package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.TrilobiteEntity;

public class TrilobiteModel extends EntityModel<TrilobiteEntity> {
	private final RendererModel root;
	private final RendererModel body;
	private final RendererModel body_r1;
	private final RendererModel body_r2;
	private final RendererModel rFrontTenticle4_r1;
	private final RendererModel rFrontTenticle3_r1;
	private final RendererModel lowerBody_r1;
	private final RendererModel gRightFrontFlapbase;
	private final RendererModel rFrontTenticle2_r1;
	private final RendererModel gRightFrontFlap;
	private final RendererModel gLeftFrontFlapbase;
	private final RendererModel rFrontTenticle3_r2;
	private final RendererModel gLeftFrontFlap;
	private final RendererModel gLeftBackFlapbase;
	private final RendererModel rBackTenticle4_r1;
	private final RendererModel gLeftBackFlap;
	private final RendererModel gRightBackFlapbase;
	private final RendererModel rBackTenticle5_r1;
	private final RendererModel gRightBackFlap;
	private final RendererModel tailPetal;
	private final RendererModel gTail1;
	private final RendererModel gTail2;
	private final RendererModel gTail3;
	private final RendererModel gTail4;
	private final RendererModel gTail5;
	private final RendererModel gTailClaw;
	private final RendererModel gFrontRightTentacleInner;
	private final RendererModel gFrontRightTentacleMiddle;
	private final RendererModel gFrontRightTentacleOuter;
	private final RendererModel gFrontRightTentacleEnd;
	private final RendererModel gFrontRightTentacleClaw;
	private final RendererModel gFrontLeftTentacleInner;
	private final RendererModel gFrontLeftTentacleMiddle;
	private final RendererModel gFrontLeftTentacleOuter;
	private final RendererModel gFrontLeftTentacleEnd;
	private final RendererModel gFrontLeftTentacleClaw;
	private final RendererModel gMiddleRightTentacleInner;
	private final RendererModel gMiddleRightTentacleMiddle;
	private final RendererModel gMiddleRightTentacleOuter;
	private final RendererModel gMiddleRightTentacleEnd;
	private final RendererModel gMiddleRightTentacleClaw;
	private final RendererModel gMiddleLeftTentacleInner;
	private final RendererModel gMiddleLeftTentacleMiddle;
	private final RendererModel gMiddleLeftTentacleOuter;
	private final RendererModel gMiddleLeftTentacleEnd;
	private final RendererModel gMiddleLeftTentacleClaw;
	private final RendererModel gBackRightTentacleInner;
	private final RendererModel gBackRightTentacleMiddle;
	private final RendererModel gBackRightTentacleOuter;
	private final RendererModel gBackRightTentacleEnd;
	private final RendererModel gBackRightTentacleClaw;
	private final RendererModel gBackLeftTentacleInner;
	private final RendererModel gBackLeftTentacleMiddle;
	private final RendererModel gBackLeftTentacleOuter;
	private final RendererModel gBackLeftTentacleEnd;
	private final RendererModel gBackLeftTentacleClaw;
	private final RendererModel gLeftJaw;
	private final RendererModel lJaw_r1;
	private final RendererModel lJaw_r2;
	private final RendererModel gRightJaw;
	private final RendererModel lJaw_r3;
	private final RendererModel lJaw_r4;
	private final RendererModel gRightMiddleFlap;
	private final RendererModel gLeftMiddleFlap;
	private final RendererModel gRightFrontSmallTube;
	private final RendererModel gMainToob1;
	private final RendererModel gLeftFrontSmallTube;
	private final RendererModel gRightMiddleSmallTube;
	private final RendererModel gLeftMiddleSmallTube;
	private final RendererModel gRightBackSmallTube;
	private final RendererModel gLeftBackSmallTube;
	private final RendererModel gBackSmallTube2;

	public TrilobiteModel() {
		textureWidth = 128;
		textureHeight = 64;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 22.1F, 0.0F);
		

		body = new RendererModel(this);
		body.setRotationPoint(0.0F, -12.6F, 0.0F);
		root.addChild(body);
		body.cubeList.add(new ModelBox(body, 25, 0, -2.5F, -1.5F, 2.2F, 5, 2, 4, 0.5F, false));
		body.cubeList.add(new ModelBox(body, 1, 1, -3.0F, -0.9F, -3.0F, 6, 1, 5, 1.0F, false));
		body.cubeList.add(new ModelBox(body, 1, 0, -2.0F, -2.3F, -4.1F, 4, 1, 6, 0.1F, false));

		body_r1 = new RendererModel(this);
		body_r1.setRotationPoint(0.0F, 0.4467F, -3.6852F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 0.3054F, 0.0F, 0.0F);
		body_r1.cubeList.add(new ModelBox(body_r1, 6, 6, -2.0F, -1.5F, -1.2F, 4, 2, 1, -0.1F, false));

		body_r2 = new RendererModel(this);
		body_r2.setRotationPoint(0.0F, -0.4F, -4.0F);
		body.addChild(body_r2);
		setRotationAngle(body_r2, -0.5672F, 0.0F, 0.0F);
		body_r2.cubeList.add(new ModelBox(body_r2, 6, 5, -2.0F, -1.5F, -1.2F, 4, 2, 1, 0.0F, false));

		rFrontTenticle4_r1 = new RendererModel(this);
		rFrontTenticle4_r1.setRotationPoint(4.8F, 0.0F, 1.0F);
		body.addChild(rFrontTenticle4_r1);
		setRotationAngle(rFrontTenticle4_r1, 0.0F, 0.0F, 0.1309F);
		rFrontTenticle4_r1.cubeList.add(new ModelBox(rFrontTenticle4_r1, 0, 53, -1.8F, -0.9F, -1.75F, 4, 2, 3, 0.3F, false));

		rFrontTenticle3_r1 = new RendererModel(this);
		rFrontTenticle3_r1.setRotationPoint(-4.8F, 0.0F, 1.0F);
		body.addChild(rFrontTenticle3_r1);
		setRotationAngle(rFrontTenticle3_r1, 0.0F, 0.0F, -0.1309F);
		rFrontTenticle3_r1.cubeList.add(new ModelBox(rFrontTenticle3_r1, 0, 53, -2.2F, -0.9F, -1.75F, 4, 2, 3, 0.3F, true));

		lowerBody_r1 = new RendererModel(this);
		lowerBody_r1.setRotationPoint(0.0F, -1.3F, 4.2F);
		body.addChild(lowerBody_r1);
		setRotationAngle(lowerBody_r1, -0.0436F, 0.0F, 0.0F);
		lowerBody_r1.cubeList.add(new ModelBox(lowerBody_r1, 26, 0, -1.5F, -0.4F, -2.0F, 3, 1, 4, 0.5F, false));

		gRightFrontFlapbase = new RendererModel(this);
		gRightFrontFlapbase.setRotationPoint(-3.1332F, 0.0F, -2.6535F);
		body.addChild(gRightFrontFlapbase);
		setRotationAngle(gRightFrontFlapbase, 0.0F, -0.3927F, 0.0F);
		

		rFrontTenticle2_r1 = new RendererModel(this);
		rFrontTenticle2_r1.setRotationPoint(-1.2668F, -0.1F, -0.5465F);
		gRightFrontFlapbase.addChild(rFrontTenticle2_r1);
		setRotationAngle(rFrontTenticle2_r1, 0.0F, 0.0F, -0.1309F);
		rFrontTenticle2_r1.cubeList.add(new ModelBox(rFrontTenticle2_r1, 0, 53, -1.7F, -1.0F, -1.5F, 4, 2, 3, 0.0F, true));

		gRightFrontFlap = new RendererModel(this);
		gRightFrontFlap.setRotationPoint(0.2332F, 0.9F, 0.3035F);
		gRightFrontFlapbase.addChild(gRightFrontFlap);
		setRotationAngle(gRightFrontFlap, 0.0F, 0.0F, -2.7489F);
		gRightFrontFlap.cubeList.add(new ModelBox(gRightFrontFlap, 81, 37, -4.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, false));

		gLeftFrontFlapbase = new RendererModel(this);
		gLeftFrontFlapbase.setRotationPoint(3.1332F, 0.0F, -2.6535F);
		body.addChild(gLeftFrontFlapbase);
		setRotationAngle(gLeftFrontFlapbase, 0.0F, 0.3927F, 0.0F);
		

		rFrontTenticle3_r2 = new RendererModel(this);
		rFrontTenticle3_r2.setRotationPoint(1.2668F, -0.1F, -0.5465F);
		gLeftFrontFlapbase.addChild(rFrontTenticle3_r2);
		setRotationAngle(rFrontTenticle3_r2, 0.0F, 0.0F, 0.1309F);
		rFrontTenticle3_r2.cubeList.add(new ModelBox(rFrontTenticle3_r2, 0, 53, -2.3F, -1.0F, -1.5F, 4, 2, 3, 0.0F, false));

		gLeftFrontFlap = new RendererModel(this);
		gLeftFrontFlap.setRotationPoint(-0.2332F, 0.9F, 0.3035F);
		gLeftFrontFlapbase.addChild(gLeftFrontFlap);
		setRotationAngle(gLeftFrontFlap, 0.0F, 0.0F, 2.7489F);
		gLeftFrontFlap.cubeList.add(new ModelBox(gLeftFrontFlap, 81, 37, 0.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, true));

		gLeftBackFlapbase = new RendererModel(this);
		gLeftBackFlapbase.setRotationPoint(3.1332F, 0.0F, 4.6535F);
		body.addChild(gLeftBackFlapbase);
		setRotationAngle(gLeftBackFlapbase, 0.0F, -0.3927F, 0.0F);
		

		rBackTenticle4_r1 = new RendererModel(this);
		rBackTenticle4_r1.setRotationPoint(1.2668F, -0.1F, 0.5465F);
		gLeftBackFlapbase.addChild(rBackTenticle4_r1);
		setRotationAngle(rBackTenticle4_r1, 0.0F, 0.0F, 0.1309F);
		rBackTenticle4_r1.cubeList.add(new ModelBox(rBackTenticle4_r1, 0, 53, -2.55F, -1.0F, -2.5F, 4, 2, 3, 0.0F, false));

		gLeftBackFlap = new RendererModel(this);
		gLeftBackFlap.setRotationPoint(-0.2332F, 0.9F, -0.5535F);
		gLeftBackFlapbase.addChild(gLeftBackFlap);
		setRotationAngle(gLeftBackFlap, 0.0F, 0.0F, 2.7489F);
		gLeftBackFlap.cubeList.add(new ModelBox(gLeftBackFlap, 81, 37, 0.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, true));

		gRightBackFlapbase = new RendererModel(this);
		gRightBackFlapbase.setRotationPoint(-3.1332F, 0.0F, 4.6535F);
		body.addChild(gRightBackFlapbase);
		setRotationAngle(gRightBackFlapbase, 0.0F, 0.3927F, 0.0F);
		

		rBackTenticle5_r1 = new RendererModel(this);
		rBackTenticle5_r1.setRotationPoint(-1.2668F, -0.1F, 0.5465F);
		gRightBackFlapbase.addChild(rBackTenticle5_r1);
		setRotationAngle(rBackTenticle5_r1, 0.0F, 0.0F, -0.1309F);
		rBackTenticle5_r1.cubeList.add(new ModelBox(rBackTenticle5_r1, 0, 53, -1.45F, -1.0F, -2.5F, 4, 2, 3, 0.0F, true));

		gRightBackFlap = new RendererModel(this);
		gRightBackFlap.setRotationPoint(0.2332F, 0.9F, -0.5535F);
		gRightBackFlapbase.addChild(gRightBackFlap);
		setRotationAngle(gRightBackFlap, 0.0F, 0.0F, -2.7489F);
		gRightBackFlap.cubeList.add(new ModelBox(gRightBackFlap, 81, 37, -4.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, false));

		tailPetal = new RendererModel(this);
		tailPetal.setRotationPoint(0.0F, 1.2F, 6.2F);
		body.addChild(tailPetal);
		setRotationAngle(tailPetal, -2.8513F, 0.0F, 0.0F);
		tailPetal.cubeList.add(new ModelBox(tailPetal, 89, 50, -1.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F, false));

		gTail1 = new RendererModel(this);
		gTail1.setRotationPoint(0.0F, 0.0F, 6.15F);
		body.addChild(gTail1);
		setRotationAngle(gTail1, -0.3927F, 0.0F, 0.0F);
		gTail1.cubeList.add(new ModelBox(gTail1, 60, 0, -1.5F, -1.0F, 0.55F, 3, 2, 3, 0.5F, false));

		gTail2 = new RendererModel(this);
		gTail2.setRotationPoint(0.0F, 0.0F, 3.55F);
		gTail1.addChild(gTail2);
		setRotationAngle(gTail2, -0.3927F, 0.0F, 0.0F);
		gTail2.cubeList.add(new ModelBox(gTail2, 54, 7, -2.0F, -1.0F, 0.0F, 4, 2, 7, 0.2F, false));

		gTail3 = new RendererModel(this);
		gTail3.setRotationPoint(0.0F, 0.0F, 7.0F);
		gTail2.addChild(gTail3);
		setRotationAngle(gTail3, 0.3927F, 0.0F, 0.0F);
		gTail3.cubeList.add(new ModelBox(gTail3, 56, 18, -1.5F, -1.0F, 0.0F, 3, 2, 6, 0.0F, false));

		gTail4 = new RendererModel(this);
		gTail4.setRotationPoint(0.0F, 0.0F, 5.95F);
		gTail3.addChild(gTail4);
		setRotationAngle(gTail4, 0.3927F, 0.0F, 0.0F);
		gTail4.cubeList.add(new ModelBox(gTail4, 56, 28, -1.5F, -1.0F, -0.25F, 3, 2, 6, -0.25F, false));

		gTail5 = new RendererModel(this);
		gTail5.setRotationPoint(0.0F, 0.0F, 5.45F);
		gTail4.addChild(gTail5);
		setRotationAngle(gTail5, 0.3927F, 0.0F, 0.0F);
		gTail5.cubeList.add(new ModelBox(gTail5, 56, 38, -1.0F, -0.5F, 0.0F, 2, 1, 7, 0.0F, false));

		gTailClaw = new RendererModel(this);
		gTailClaw.setRotationPoint(0.0F, 0.0F, 7.0F);
		gTail5.addChild(gTailClaw);
		gTailClaw.cubeList.add(new ModelBox(gTailClaw, 57, 49, -1.5F, 0.0F, 0.0F, 3, 0, 5, 0.0F, false));

		gFrontRightTentacleInner = new RendererModel(this);
		gFrontRightTentacleInner.setRotationPoint(-5.1531F, -0.05F, -3.9925F);
		body.addChild(gFrontRightTentacleInner);
		setRotationAngle(gFrontRightTentacleInner, 0.2849F, -0.274F, -0.8249F);
		gFrontRightTentacleInner.cubeList.add(new ModelBox(gFrontRightTentacleInner, 0, 15, -7.0F, -1.0F, -2.0F, 7, 2, 4, 0.1F, true));

		gFrontRightTentacleMiddle = new RendererModel(this);
		gFrontRightTentacleMiddle.setRotationPoint(-7.05F, 0.0F, 0.0F);
		gFrontRightTentacleInner.addChild(gFrontRightTentacleMiddle);
		setRotationAngle(gFrontRightTentacleMiddle, 0.0F, 0.0F, -0.3927F);
		gFrontRightTentacleMiddle.cubeList.add(new ModelBox(gFrontRightTentacleMiddle, 0, 22, -5.85F, -1.0F, -1.5F, 6, 2, 3, 0.0F, true));

		gFrontRightTentacleOuter = new RendererModel(this);
		gFrontRightTentacleOuter.setRotationPoint(-5.8F, 0.0F, 0.0F);
		gFrontRightTentacleMiddle.addChild(gFrontRightTentacleOuter);
		setRotationAngle(gFrontRightTentacleOuter, 0.0F, 0.0F, 0.3927F);
		gFrontRightTentacleOuter.cubeList.add(new ModelBox(gFrontRightTentacleOuter, 0, 28, -5.75F, -1.0F, -1.5F, 6, 2, 3, -0.25F, true));

		gFrontRightTentacleEnd = new RendererModel(this);
		gFrontRightTentacleEnd.setRotationPoint(-5.45F, 0.0F, 0.0F);
		gFrontRightTentacleOuter.addChild(gFrontRightTentacleEnd);
		setRotationAngle(gFrontRightTentacleEnd, 0.0F, 0.0F, 0.7854F);
		gFrontRightTentacleEnd.cubeList.add(new ModelBox(gFrontRightTentacleEnd, 0, 35, -7.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F, true));

		gFrontRightTentacleClaw = new RendererModel(this);
		gFrontRightTentacleClaw.setRotationPoint(-7.0F, 0.0F, 0.0F);
		gFrontRightTentacleEnd.addChild(gFrontRightTentacleClaw);
		gFrontRightTentacleClaw.cubeList.add(new ModelBox(gFrontRightTentacleClaw, 0, 39, -4.8F, 0.0F, -1.5F, 5, 0, 3, 0.0F, true));

		gFrontLeftTentacleInner = new RendererModel(this);
		gFrontLeftTentacleInner.setRotationPoint(5.1531F, -0.05F, -3.9925F);
		body.addChild(gFrontLeftTentacleInner);
		setRotationAngle(gFrontLeftTentacleInner, 0.2849F, 0.274F, 0.8249F);
		gFrontLeftTentacleInner.cubeList.add(new ModelBox(gFrontLeftTentacleInner, 0, 15, 0.0F, -1.0F, -2.0F, 7, 2, 4, 0.1F, false));

		gFrontLeftTentacleMiddle = new RendererModel(this);
		gFrontLeftTentacleMiddle.setRotationPoint(7.05F, 0.0F, 0.0F);
		gFrontLeftTentacleInner.addChild(gFrontLeftTentacleMiddle);
		setRotationAngle(gFrontLeftTentacleMiddle, 0.0F, 0.0F, 0.3927F);
		gFrontLeftTentacleMiddle.cubeList.add(new ModelBox(gFrontLeftTentacleMiddle, 0, 22, -0.15F, -1.0F, -1.5F, 6, 2, 3, 0.0F, false));

		gFrontLeftTentacleOuter = new RendererModel(this);
		gFrontLeftTentacleOuter.setRotationPoint(5.8F, 0.0F, 0.0F);
		gFrontLeftTentacleMiddle.addChild(gFrontLeftTentacleOuter);
		setRotationAngle(gFrontLeftTentacleOuter, 0.0F, 0.0F, -0.3927F);
		gFrontLeftTentacleOuter.cubeList.add(new ModelBox(gFrontLeftTentacleOuter, 0, 28, -0.25F, -1.0F, -1.5F, 6, 2, 3, -0.25F, false));

		gFrontLeftTentacleEnd = new RendererModel(this);
		gFrontLeftTentacleEnd.setRotationPoint(5.45F, 0.0F, 0.0F);
		gFrontLeftTentacleOuter.addChild(gFrontLeftTentacleEnd);
		setRotationAngle(gFrontLeftTentacleEnd, 0.0F, 0.0F, -0.7854F);
		gFrontLeftTentacleEnd.cubeList.add(new ModelBox(gFrontLeftTentacleEnd, 0, 35, 0.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F, false));

		gFrontLeftTentacleClaw = new RendererModel(this);
		gFrontLeftTentacleClaw.setRotationPoint(7.0F, 0.0F, 0.0F);
		gFrontLeftTentacleEnd.addChild(gFrontLeftTentacleClaw);
		gFrontLeftTentacleClaw.cubeList.add(new ModelBox(gFrontLeftTentacleClaw, 0, 39, -0.2F, 0.0F, -1.5F, 5, 0, 3, 0.0F, false));

		gMiddleRightTentacleInner = new RendererModel(this);
		gMiddleRightTentacleInner.setRotationPoint(-6.7F, -0.05F, 0.75F);
		body.addChild(gMiddleRightTentacleInner);
		setRotationAngle(gMiddleRightTentacleInner, 0.0F, 0.0F, -0.7854F);
		gMiddleRightTentacleInner.cubeList.add(new ModelBox(gMiddleRightTentacleInner, 0, 15, -7.0F, -1.0F, -2.0F, 7, 2, 4, 0.1F, true));

		gMiddleRightTentacleMiddle = new RendererModel(this);
		gMiddleRightTentacleMiddle.setRotationPoint(-7.05F, 0.0F, 0.0F);
		gMiddleRightTentacleInner.addChild(gMiddleRightTentacleMiddle);
		setRotationAngle(gMiddleRightTentacleMiddle, 0.0F, 0.0F, -0.3927F);
		gMiddleRightTentacleMiddle.cubeList.add(new ModelBox(gMiddleRightTentacleMiddle, 0, 22, -5.85F, -1.0F, -1.5F, 6, 2, 3, 0.0F, true));

		gMiddleRightTentacleOuter = new RendererModel(this);
		gMiddleRightTentacleOuter.setRotationPoint(-5.75F, 0.0F, 0.0F);
		gMiddleRightTentacleMiddle.addChild(gMiddleRightTentacleOuter);
		setRotationAngle(gMiddleRightTentacleOuter, 0.0F, 0.0F, 0.3927F);
		gMiddleRightTentacleOuter.cubeList.add(new ModelBox(gMiddleRightTentacleOuter, 0, 28, -5.8F, -1.0F, -1.5F, 6, 2, 3, -0.25F, true));

		gMiddleRightTentacleEnd = new RendererModel(this);
		gMiddleRightTentacleEnd.setRotationPoint(-5.5F, 0.0F, 0.0F);
		gMiddleRightTentacleOuter.addChild(gMiddleRightTentacleEnd);
		setRotationAngle(gMiddleRightTentacleEnd, 0.0F, 0.0F, 0.7854F);
		gMiddleRightTentacleEnd.cubeList.add(new ModelBox(gMiddleRightTentacleEnd, 0, 35, -7.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F, true));

		gMiddleRightTentacleClaw = new RendererModel(this);
		gMiddleRightTentacleClaw.setRotationPoint(-7.0F, 0.0F, 0.0F);
		gMiddleRightTentacleEnd.addChild(gMiddleRightTentacleClaw);
		gMiddleRightTentacleClaw.cubeList.add(new ModelBox(gMiddleRightTentacleClaw, 0, 39, -4.8F, 0.0F, -1.5F, 5, 0, 3, 0.0F, true));

		gMiddleLeftTentacleInner = new RendererModel(this);
		gMiddleLeftTentacleInner.setRotationPoint(6.7F, -0.05F, 0.75F);
		body.addChild(gMiddleLeftTentacleInner);
		setRotationAngle(gMiddleLeftTentacleInner, 0.0F, 0.0F, 0.7854F);
		gMiddleLeftTentacleInner.cubeList.add(new ModelBox(gMiddleLeftTentacleInner, 0, 15, 0.0F, -1.0F, -2.0F, 7, 2, 4, 0.1F, false));

		gMiddleLeftTentacleMiddle = new RendererModel(this);
		gMiddleLeftTentacleMiddle.setRotationPoint(7.05F, 0.0F, 0.0F);
		gMiddleLeftTentacleInner.addChild(gMiddleLeftTentacleMiddle);
		setRotationAngle(gMiddleLeftTentacleMiddle, 0.0F, 0.0F, 0.3927F);
		gMiddleLeftTentacleMiddle.cubeList.add(new ModelBox(gMiddleLeftTentacleMiddle, 0, 22, -0.15F, -1.0F, -1.5F, 6, 2, 3, 0.0F, false));

		gMiddleLeftTentacleOuter = new RendererModel(this);
		gMiddleLeftTentacleOuter.setRotationPoint(5.75F, 0.0F, 0.0F);
		gMiddleLeftTentacleMiddle.addChild(gMiddleLeftTentacleOuter);
		setRotationAngle(gMiddleLeftTentacleOuter, 0.0F, 0.0F, -0.3927F);
		gMiddleLeftTentacleOuter.cubeList.add(new ModelBox(gMiddleLeftTentacleOuter, 0, 28, -0.2F, -1.0F, -1.5F, 6, 2, 3, -0.25F, false));

		gMiddleLeftTentacleEnd = new RendererModel(this);
		gMiddleLeftTentacleEnd.setRotationPoint(5.5F, 0.0F, 0.0F);
		gMiddleLeftTentacleOuter.addChild(gMiddleLeftTentacleEnd);
		setRotationAngle(gMiddleLeftTentacleEnd, 0.0F, 0.0F, -0.7854F);
		gMiddleLeftTentacleEnd.cubeList.add(new ModelBox(gMiddleLeftTentacleEnd, 0, 35, 0.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F, false));

		gMiddleLeftTentacleClaw = new RendererModel(this);
		gMiddleLeftTentacleClaw.setRotationPoint(7.0F, 0.0F, 0.0F);
		gMiddleLeftTentacleEnd.addChild(gMiddleLeftTentacleClaw);
		gMiddleLeftTentacleClaw.cubeList.add(new ModelBox(gMiddleLeftTentacleClaw, 0, 39, -0.2F, 0.0F, -1.5F, 5, 0, 3, 0.0F, false));

		gBackRightTentacleInner = new RendererModel(this);
		gBackRightTentacleInner.setRotationPoint(-5.2858F, -0.15F, 5.0686F);
		body.addChild(gBackRightTentacleInner);
		setRotationAngle(gBackRightTentacleInner, -0.2849F, 0.274F, -0.8249F);
		gBackRightTentacleInner.cubeList.add(new ModelBox(gBackRightTentacleInner, 0, 15, -7.0F, -1.0F, -2.0F, 7, 2, 4, 0.1F, true));

		gBackRightTentacleMiddle = new RendererModel(this);
		gBackRightTentacleMiddle.setRotationPoint(-7.05F, 0.0F, 0.0F);
		gBackRightTentacleInner.addChild(gBackRightTentacleMiddle);
		setRotationAngle(gBackRightTentacleMiddle, 0.0F, 0.0F, -0.3927F);
		gBackRightTentacleMiddle.cubeList.add(new ModelBox(gBackRightTentacleMiddle, 0, 22, -5.85F, -1.0F, -1.5F, 6, 2, 3, 0.0F, true));

		gBackRightTentacleOuter = new RendererModel(this);
		gBackRightTentacleOuter.setRotationPoint(-5.75F, 0.0F, 0.0F);
		gBackRightTentacleMiddle.addChild(gBackRightTentacleOuter);
		setRotationAngle(gBackRightTentacleOuter, 0.0F, 0.0F, 0.3927F);
		gBackRightTentacleOuter.cubeList.add(new ModelBox(gBackRightTentacleOuter, 0, 28, -5.8F, -1.0F, -1.5F, 6, 2, 3, -0.25F, true));

		gBackRightTentacleEnd = new RendererModel(this);
		gBackRightTentacleEnd.setRotationPoint(-5.5F, 0.0F, 0.0F);
		gBackRightTentacleOuter.addChild(gBackRightTentacleEnd);
		setRotationAngle(gBackRightTentacleEnd, 0.0F, 0.0F, 0.7854F);
		gBackRightTentacleEnd.cubeList.add(new ModelBox(gBackRightTentacleEnd, 0, 35, -7.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F, true));

		gBackRightTentacleClaw = new RendererModel(this);
		gBackRightTentacleClaw.setRotationPoint(-7.0F, 0.0F, 0.0F);
		gBackRightTentacleEnd.addChild(gBackRightTentacleClaw);
		gBackRightTentacleClaw.cubeList.add(new ModelBox(gBackRightTentacleClaw, 0, 39, -4.8F, 0.0F, -1.5F, 5, 0, 3, 0.0F, true));

		gBackLeftTentacleInner = new RendererModel(this);
		gBackLeftTentacleInner.setRotationPoint(5.2858F, -0.15F, 5.0686F);
		body.addChild(gBackLeftTentacleInner);
		setRotationAngle(gBackLeftTentacleInner, -0.2849F, -0.274F, 0.8249F);
		gBackLeftTentacleInner.cubeList.add(new ModelBox(gBackLeftTentacleInner, 0, 15, 0.0F, -1.0F, -2.0F, 7, 2, 4, 0.1F, false));

		gBackLeftTentacleMiddle = new RendererModel(this);
		gBackLeftTentacleMiddle.setRotationPoint(7.05F, 0.0F, 0.0F);
		gBackLeftTentacleInner.addChild(gBackLeftTentacleMiddle);
		setRotationAngle(gBackLeftTentacleMiddle, 0.0F, 0.0F, 0.3927F);
		gBackLeftTentacleMiddle.cubeList.add(new ModelBox(gBackLeftTentacleMiddle, 0, 22, -0.15F, -1.0F, -1.5F, 6, 2, 3, 0.0F, false));

		gBackLeftTentacleOuter = new RendererModel(this);
		gBackLeftTentacleOuter.setRotationPoint(5.75F, 0.0F, 0.0F);
		gBackLeftTentacleMiddle.addChild(gBackLeftTentacleOuter);
		setRotationAngle(gBackLeftTentacleOuter, 0.0F, 0.0F, -0.3927F);
		gBackLeftTentacleOuter.cubeList.add(new ModelBox(gBackLeftTentacleOuter, 0, 28, -0.2F, -1.0F, -1.5F, 6, 2, 3, -0.25F, false));

		gBackLeftTentacleEnd = new RendererModel(this);
		gBackLeftTentacleEnd.setRotationPoint(5.5F, 0.0F, 0.0F);
		gBackLeftTentacleOuter.addChild(gBackLeftTentacleEnd);
		setRotationAngle(gBackLeftTentacleEnd, 0.0F, 0.0F, -0.7854F);
		gBackLeftTentacleEnd.cubeList.add(new ModelBox(gBackLeftTentacleEnd, 0, 35, 0.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F, false));

		gBackLeftTentacleClaw = new RendererModel(this);
		gBackLeftTentacleClaw.setRotationPoint(7.0F, 0.0F, 0.0F);
		gBackLeftTentacleEnd.addChild(gBackLeftTentacleClaw);
		gBackLeftTentacleClaw.cubeList.add(new ModelBox(gBackLeftTentacleClaw, 0, 39, -0.2F, 0.0F, -1.5F, 5, 0, 3, 0.0F, false));

		gLeftJaw = new RendererModel(this);
		gLeftJaw.setRotationPoint(0.95F, 0.9F, 0.5F);
		body.addChild(gLeftJaw);
		

		lJaw_r1 = new RendererModel(this);
		lJaw_r1.setRotationPoint(-0.2F, 0.6477F, -0.266F);
		gLeftJaw.addChild(lJaw_r1);
		setRotationAngle(lJaw_r1, 0.1309F, 0.0F, 0.0F);
		lJaw_r1.cubeList.add(new ModelBox(lJaw_r1, 5, 48, -0.5F, -0.3977F, -0.066F, 1, 1, 2, 0.0F, false));

		lJaw_r2 = new RendererModel(this);
		lJaw_r2.setRotationPoint(-0.2F, 0.6477F, -0.266F);
		gLeftJaw.addChild(lJaw_r2);
		setRotationAngle(lJaw_r2, -0.0873F, 0.0F, 0.0F);
		lJaw_r2.cubeList.add(new ModelBox(lJaw_r2, 5, 48, -0.5F, -0.3977F, -1.934F, 1, 1, 2, 0.0F, false));

		gRightJaw = new RendererModel(this);
		gRightJaw.setRotationPoint(-0.95F, 0.9F, 0.5F);
		body.addChild(gRightJaw);
		

		lJaw_r3 = new RendererModel(this);
		lJaw_r3.setRotationPoint(0.2F, 0.6477F, -0.266F);
		gRightJaw.addChild(lJaw_r3);
		setRotationAngle(lJaw_r3, 0.1309F, 0.0F, 0.0F);
		lJaw_r3.cubeList.add(new ModelBox(lJaw_r3, 5, 48, -0.5F, -0.3977F, -0.066F, 1, 1, 2, 0.0F, true));

		lJaw_r4 = new RendererModel(this);
		lJaw_r4.setRotationPoint(0.2F, 0.6477F, -0.266F);
		gRightJaw.addChild(lJaw_r4);
		setRotationAngle(lJaw_r4, -0.0873F, 0.0F, 0.0F);
		lJaw_r4.cubeList.add(new ModelBox(lJaw_r4, 5, 48, -0.5F, -0.3977F, -1.934F, 1, 1, 2, 0.0F, true));

		gRightMiddleFlap = new RendererModel(this);
		gRightMiddleFlap.setRotationPoint(-3.9F, 0.9F, 0.8F);
		body.addChild(gRightMiddleFlap);
		setRotationAngle(gRightMiddleFlap, 0.0F, 0.0F, -2.7489F);
		gRightMiddleFlap.cubeList.add(new ModelBox(gRightMiddleFlap, 81, 37, -4.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, false));

		gLeftMiddleFlap = new RendererModel(this);
		gLeftMiddleFlap.setRotationPoint(3.9F, 0.9F, 0.8F);
		body.addChild(gLeftMiddleFlap);
		setRotationAngle(gLeftMiddleFlap, 0.0F, 0.0F, 2.7489F);
		gLeftMiddleFlap.cubeList.add(new ModelBox(gLeftMiddleFlap, 81, 37, 0.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, true));

		gRightFrontSmallTube = new RendererModel(this);
		gRightFrontSmallTube.setRotationPoint(-2.4F, 0.4F, -2.0F);
		body.addChild(gRightFrontSmallTube);
		gRightFrontSmallTube.cubeList.add(new ModelBox(gRightFrontSmallTube, 92, 6, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, false));

		gMainToob1 = new RendererModel(this);
		gMainToob1.setRotationPoint(0.0F, 0.95F, 0.15F);
		body.addChild(gMainToob1);
		gMainToob1.cubeList.add(new ModelBox(gMainToob1, 92, 0, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, false));

		gLeftFrontSmallTube = new RendererModel(this);
		gLeftFrontSmallTube.setRotationPoint(2.4F, 0.4F, -2.0F);
		body.addChild(gLeftFrontSmallTube);
		gLeftFrontSmallTube.cubeList.add(new ModelBox(gLeftFrontSmallTube, 92, 6, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, true));

		gRightMiddleSmallTube = new RendererModel(this);
		gRightMiddleSmallTube.setRotationPoint(-2.7F, 0.4F, 1.1F);
		body.addChild(gRightMiddleSmallTube);
		gRightMiddleSmallTube.cubeList.add(new ModelBox(gRightMiddleSmallTube, 92, 6, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, false));

		gLeftMiddleSmallTube = new RendererModel(this);
		gLeftMiddleSmallTube.setRotationPoint(2.7F, 0.4F, 1.1F);
		body.addChild(gLeftMiddleSmallTube);
		gLeftMiddleSmallTube.cubeList.add(new ModelBox(gLeftMiddleSmallTube, 92, 6, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, true));

		gRightBackSmallTube = new RendererModel(this);
		gRightBackSmallTube.setRotationPoint(-2.0F, 0.4F, 3.9F);
		body.addChild(gRightBackSmallTube);
		gRightBackSmallTube.cubeList.add(new ModelBox(gRightBackSmallTube, 92, 6, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, false));

		gLeftBackSmallTube = new RendererModel(this);
		gLeftBackSmallTube.setRotationPoint(2.0F, 0.4F, 3.9F);
		body.addChild(gLeftBackSmallTube);
		gLeftBackSmallTube.cubeList.add(new ModelBox(gLeftBackSmallTube, 92, 6, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, true));

		gBackSmallTube2 = new RendererModel(this);
		gBackSmallTube2.setRotationPoint(0.0F, 0.0F, 5.3F);
		body.addChild(gBackSmallTube2);
		gBackSmallTube2.cubeList.add(new ModelBox(gBackSmallTube2, 92, 6, -0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(TrilobiteEntity trilobiteEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}