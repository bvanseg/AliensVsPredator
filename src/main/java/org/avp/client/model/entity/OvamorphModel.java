package org.avp.client.model.entity;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.OvamorphEntity;

public class OvamorphModel extends EntityModel<OvamorphEntity> {
	private final RendererModel root;
	private final RendererModel gBackRightFlap;
	private final RendererModel gBackRightFlapEnd;
	private final RendererModel gBackLeftFlap;
	private final RendererModel gBackLeftFlapEnd;
	private final RendererModel gFrontLeftFlap;
	private final RendererModel gFrontLeftFlapEnd;
	private final RendererModel gFrontRightFlap;
	private final RendererModel gFrontRightFlapEnd;

	public OvamorphModel() {
		textureWidth = 64;
		textureHeight = 32;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		root.cubeList.add(new ModelBox(root, 0, 0, -3.5F, 18.0F, -3.5F, 7, 5, 7, 0.0F, false));
		root.cubeList.add(new ModelBox(root, 0, 15, -2.5F, 19.0F, -2.5F, 5, 5, 5, 0.0F, false));

		gBackRightFlap = new RendererModel(this);
		gBackRightFlap.setRotationPoint(-1.5F, 18.0F, 1.5F);
		root.addChild(gBackRightFlap);
		gBackRightFlap.cubeList.add(new ModelBox(gBackRightFlap, 35, 18, -1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F, false));

		gBackRightFlapEnd = new RendererModel(this);
		gBackRightFlapEnd.setRotationPoint(0.0F, -0.9F, 0.0F);
		gBackRightFlap.addChild(gBackRightFlapEnd);
		gBackRightFlapEnd.cubeList.add(new ModelBox(gBackRightFlapEnd, 37, 6, -0.5F, -2.4F, -1.5F, 2, 2, 2, 0.0F, false));

		gBackLeftFlap = new RendererModel(this);
		gBackLeftFlap.setRotationPoint(1.5F, 18.0F, 1.5F);
		root.addChild(gBackLeftFlap);
		gBackLeftFlap.cubeList.add(new ModelBox(gBackLeftFlap, 35, 18, -1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F, true));

		gBackLeftFlapEnd = new RendererModel(this);
		gBackLeftFlapEnd.setRotationPoint(0.0F, -0.9F, 0.0F);
		gBackLeftFlap.addChild(gBackLeftFlapEnd);
		gBackLeftFlapEnd.cubeList.add(new ModelBox(gBackLeftFlapEnd, 37, 6, -1.5F, -2.4F, -1.5F, 2, 2, 2, 0.0F, true));

		gFrontLeftFlap = new RendererModel(this);
		gFrontLeftFlap.setRotationPoint(1.5F, 18.0F, -1.5F);
		root.addChild(gFrontLeftFlap);
		gFrontLeftFlap.cubeList.add(new ModelBox(gFrontLeftFlap, 35, 12, -1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F, true));

		gFrontLeftFlapEnd = new RendererModel(this);
		gFrontLeftFlapEnd.setRotationPoint(0.0F, -0.9F, 0.0F);
		gFrontLeftFlap.addChild(gFrontLeftFlapEnd);
		gFrontLeftFlapEnd.cubeList.add(new ModelBox(gFrontLeftFlapEnd, 37, 0, -1.5F, -2.4F, -0.5F, 2, 2, 2, 0.0F, true));

		gFrontRightFlap = new RendererModel(this);
		gFrontRightFlap.setRotationPoint(-1.5F, 18.0F, -1.5F);
		root.addChild(gFrontRightFlap);
		gFrontRightFlap.cubeList.add(new ModelBox(gFrontRightFlap, 35, 12, -1.5F, -2.0F, -1.5F, 3, 2, 3, 0.0F, false));

		gFrontRightFlapEnd = new RendererModel(this);
		gFrontRightFlapEnd.setRotationPoint(0.0F, -0.9F, 0.0F);
		gFrontRightFlap.addChild(gFrontRightFlapEnd);
		gFrontRightFlapEnd.cubeList.add(new ModelBox(gFrontRightFlapEnd, 37, 0, -0.5F, -2.4F, -0.5F, 2, 2, 2, 0.0F, false));
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