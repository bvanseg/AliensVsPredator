package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.OvamorphEntity;

public class OvamorphModel extends EntityModel<OvamorphEntity> {
	private final RendererModel root;
	private final RendererModel gFrontLeftFlap;
	private final RendererModel lFrontLobe4_r1;
	private final RendererModel gFrontLeftFlapEnd;
	private final RendererModel lFrontLobeChild_r1;
	private final RendererModel gFrontRightFlap;
	private final RendererModel lFrontLobe5_r1;
	private final RendererModel gFrontRightFlapEnd;
	private final RendererModel lFrontLobeChild_r2;
	private final RendererModel gBackRightFlap;
	private final RendererModel lBackLobe6_r1;
	private final RendererModel gBackRightFlapEnd;
	private final RendererModel lBackLobeChild_r1;
	private final RendererModel gBackLeftFlap;
	private final RendererModel lBackLobe7_r1;
	private final RendererModel gBackLeftFlapEnd;
	private final RendererModel lBackLobeChild_r2;

	public OvamorphModel() {
		textureWidth = 64;
		textureHeight = 32;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.cubeList.add(new ModelBox(root, 0, 0, -3.5F, 18.0F, -3.5F, 7, 5, 7, 0.0F, false));
		root.cubeList.add(new ModelBox(root, 0, 15, -2.5F, 19.0F, -2.5F, 5, 5, 5, 0.0F, false));

		gFrontLeftFlap = new RendererModel(this);
		gFrontLeftFlap.setRotationPoint(1.5F, 18.5F, -1.5F);
		root.addChild(gFrontLeftFlap);
		setRotationAngle(gFrontLeftFlap, 0.0F, 0.7854F, 0.0F);
		

		lFrontLobe4_r1 = new RendererModel(this);
		lFrontLobe4_r1.setRotationPoint(-0.3536F, -2.15F, 0.0F);
		gFrontLeftFlap.addChild(lFrontLobe4_r1);
		setRotationAngle(lFrontLobe4_r1, 0.0F, -0.7854F, 0.0F);
		lFrontLobe4_r1.cubeList.add(new ModelBox(lFrontLobe4_r1, 35, 12, -1.25F, -0.35F, -1.75F, 3, 2, 3, 0.0F, true));

		gFrontLeftFlapEnd = new RendererModel(this);
		gFrontLeftFlapEnd.setRotationPoint(0.0F, -1.4F, 0.0F);
		gFrontLeftFlap.addChild(gFrontLeftFlapEnd);
		

		lFrontLobeChild_r1 = new RendererModel(this);
		lFrontLobeChild_r1.setRotationPoint(-0.3536F, -0.75F, 0.0F);
		gFrontLeftFlapEnd.addChild(lFrontLobeChild_r1);
		setRotationAngle(lFrontLobeChild_r1, 0.0F, -0.7854F, 0.0F);
		lFrontLobeChild_r1.cubeList.add(new ModelBox(lFrontLobeChild_r1, 37, 0, -1.25F, -1.65F, -0.75F, 2, 2, 2, 0.0F, true));

		gFrontRightFlap = new RendererModel(this);
		gFrontRightFlap.setRotationPoint(-1.5F, 18.5F, -1.5F);
		root.addChild(gFrontRightFlap);
		setRotationAngle(gFrontRightFlap, 0.0F, -0.7854F, 0.0F);
		

		lFrontLobe5_r1 = new RendererModel(this);
		lFrontLobe5_r1.setRotationPoint(0.3536F, -2.15F, 0.0F);
		gFrontRightFlap.addChild(lFrontLobe5_r1);
		setRotationAngle(lFrontLobe5_r1, 0.0F, 0.7854F, 0.0F);
		lFrontLobe5_r1.cubeList.add(new ModelBox(lFrontLobe5_r1, 35, 12, -1.75F, -0.35F, -1.75F, 3, 2, 3, 0.0F, false));

		gFrontRightFlapEnd = new RendererModel(this);
		gFrontRightFlapEnd.setRotationPoint(0.0F, -1.4F, 0.0F);
		gFrontRightFlap.addChild(gFrontRightFlapEnd);
		

		lFrontLobeChild_r2 = new RendererModel(this);
		lFrontLobeChild_r2.setRotationPoint(0.3536F, -0.75F, 0.0F);
		gFrontRightFlapEnd.addChild(lFrontLobeChild_r2);
		setRotationAngle(lFrontLobeChild_r2, 0.0F, 0.7854F, 0.0F);
		lFrontLobeChild_r2.cubeList.add(new ModelBox(lFrontLobeChild_r2, 37, 0, -0.75F, -1.65F, -0.75F, 2, 2, 2, 0.0F, false));

		gBackRightFlap = new RendererModel(this);
		gBackRightFlap.setRotationPoint(-1.5F, 18.5F, 1.5F);
		root.addChild(gBackRightFlap);
		setRotationAngle(gBackRightFlap, 0.0F, 0.7854F, 0.0F);
		

		lBackLobe6_r1 = new RendererModel(this);
		lBackLobe6_r1.setRotationPoint(0.3536F, -2.15F, 0.0F);
		gBackRightFlap.addChild(lBackLobe6_r1);
		setRotationAngle(lBackLobe6_r1, 0.0F, -0.7854F, 0.0F);
		lBackLobe6_r1.cubeList.add(new ModelBox(lBackLobe6_r1, 35, 18, -1.75F, -0.35F, -1.25F, 3, 2, 3, 0.0F, false));

		gBackRightFlapEnd = new RendererModel(this);
		gBackRightFlapEnd.setRotationPoint(0.0F, -1.4F, 0.0F);
		gBackRightFlap.addChild(gBackRightFlapEnd);
		

		lBackLobeChild_r1 = new RendererModel(this);
		lBackLobeChild_r1.setRotationPoint(0.3536F, -0.75F, 0.0F);
		gBackRightFlapEnd.addChild(lBackLobeChild_r1);
		setRotationAngle(lBackLobeChild_r1, 0.0F, -0.7854F, 0.0F);
		lBackLobeChild_r1.cubeList.add(new ModelBox(lBackLobeChild_r1, 37, 6, -0.75F, -1.65F, -1.25F, 2, 2, 2, 0.0F, false));

		gBackLeftFlap = new RendererModel(this);
		gBackLeftFlap.setRotationPoint(1.5F, 18.5F, 1.5F);
		root.addChild(gBackLeftFlap);
		setRotationAngle(gBackLeftFlap, 0.0F, -0.7854F, 0.0F);
		

		lBackLobe7_r1 = new RendererModel(this);
		lBackLobe7_r1.setRotationPoint(-0.3536F, -2.15F, 0.0F);
		gBackLeftFlap.addChild(lBackLobe7_r1);
		setRotationAngle(lBackLobe7_r1, 0.0F, 0.7854F, 0.0F);
		lBackLobe7_r1.cubeList.add(new ModelBox(lBackLobe7_r1, 35, 18, -1.25F, -0.35F, -1.25F, 3, 2, 3, 0.0F, true));

		gBackLeftFlapEnd = new RendererModel(this);
		gBackLeftFlapEnd.setRotationPoint(0.0F, -1.4F, 0.0F);
		gBackLeftFlap.addChild(gBackLeftFlapEnd);
		

		lBackLobeChild_r2 = new RendererModel(this);
		lBackLobeChild_r2.setRotationPoint(-0.3536F, -0.75F, 0.0F);
		gBackLeftFlapEnd.addChild(lBackLobeChild_r2);
		setRotationAngle(lBackLobeChild_r2, 0.0F, 0.7854F, 0.0F);
		lBackLobeChild_r2.cubeList.add(new ModelBox(lBackLobeChild_r2, 37, 6, -1.25F, -1.65F, -1.25F, 2, 2, 2, 0.0F, true));
	}

	@Override
	public void render(OvamorphEntity ovamorphEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}