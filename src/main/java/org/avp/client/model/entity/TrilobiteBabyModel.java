package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.TrilobiteBabyEntity;

public class TrilobiteBabyModel extends EntityModel<TrilobiteBabyEntity> {
	private final RendererModel root;
	private final RendererModel gBody;
	private final RendererModel gBackLeftTentacle1;
	private final RendererModel gBackLeftTentacle2;
	private final RendererModel gBackLeftTentacle3;
	private final RendererModel gBackRightTentacle1;
	private final RendererModel gBackRightTentacle2;
	private final RendererModel gBackRightTentacle3;
	private final RendererModel gFrontLeftTentacle1;
	private final RendererModel gFrontLeftTentacle2;
	private final RendererModel gFrontLeftTentacle3;
	private final RendererModel gFrontRightTentacle1;
	private final RendererModel gFrontRightTentacle2;
	private final RendererModel gFrontRightTentacle3;
	private final RendererModel gUpperBody;
	private final RendererModel gUpperBodyMiddle;
	private final RendererModel gUpperBodyEnd;

	public TrilobiteBabyModel() {
		textureWidth = 64;
		textureHeight = 32;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 21.8F, 18.0F);
		setRotationAngle(root, 1.5708F, 0.0F, 0.0F);
		

		gBody = new RendererModel(this);
		gBody.setRotationPoint(0.0F, -13.0F, 0.0F);
		root.addChild(gBody);
		gBody.cubeList.add(new ModelBox(gBody, 0, 0, -2.0F, -3.1F, -2.0F, 4, 3, 4, 0.0F, false));

		gBackLeftTentacle1 = new RendererModel(this);
		gBackLeftTentacle1.setRotationPoint(1.0F, -0.2F, -1.0F);
		gBody.addChild(gBackLeftTentacle1);
		gBackLeftTentacle1.cubeList.add(new ModelBox(gBackLeftTentacle1, 0, 13, -1.0F, 0.0F, -1.0F, 2, 5, 2, -0.1F, false));

		gBackLeftTentacle2 = new RendererModel(this);
		gBackLeftTentacle2.setRotationPoint(0.0F, 4.9F, 0.0F);
		gBackLeftTentacle1.addChild(gBackLeftTentacle2);
		gBackLeftTentacle2.cubeList.add(new ModelBox(gBackLeftTentacle2, 0, 13, -1.0F, -0.3F, -1.0F, 2, 5, 2, -0.25F, false));

		gBackLeftTentacle3 = new RendererModel(this);
		gBackLeftTentacle3.setRotationPoint(0.0F, 4.4F, 0.0F);
		gBackLeftTentacle2.addChild(gBackLeftTentacle3);
		gBackLeftTentacle3.cubeList.add(new ModelBox(gBackLeftTentacle3, 0, 13, -1.0F, -0.5F, -1.0F, 2, 5, 2, -0.4F, false));

		gBackRightTentacle1 = new RendererModel(this);
		gBackRightTentacle1.setRotationPoint(-1.0F, -0.2F, -1.0F);
		gBody.addChild(gBackRightTentacle1);
		gBackRightTentacle1.cubeList.add(new ModelBox(gBackRightTentacle1, 0, 13, -1.0F, 0.0F, -1.0F, 2, 5, 2, -0.1F, true));

		gBackRightTentacle2 = new RendererModel(this);
		gBackRightTentacle2.setRotationPoint(0.0F, 4.9F, 0.0F);
		gBackRightTentacle1.addChild(gBackRightTentacle2);
		gBackRightTentacle2.cubeList.add(new ModelBox(gBackRightTentacle2, 0, 13, -1.0F, -0.3F, -1.0F, 2, 5, 2, -0.25F, true));

		gBackRightTentacle3 = new RendererModel(this);
		gBackRightTentacle3.setRotationPoint(0.0F, 4.4F, 0.0F);
		gBackRightTentacle2.addChild(gBackRightTentacle3);
		gBackRightTentacle3.cubeList.add(new ModelBox(gBackRightTentacle3, 0, 13, -1.0F, -0.5F, -1.0F, 2, 5, 2, -0.4F, true));

		gFrontLeftTentacle1 = new RendererModel(this);
		gFrontLeftTentacle1.setRotationPoint(1.0F, -0.2F, 1.0F);
		gBody.addChild(gFrontLeftTentacle1);
		gFrontLeftTentacle1.cubeList.add(new ModelBox(gFrontLeftTentacle1, 0, 13, -1.0F, 0.0F, -1.0F, 2, 5, 2, -0.1F, false));

		gFrontLeftTentacle2 = new RendererModel(this);
		gFrontLeftTentacle2.setRotationPoint(0.0F, 4.9F, 0.0F);
		gFrontLeftTentacle1.addChild(gFrontLeftTentacle2);
		gFrontLeftTentacle2.cubeList.add(new ModelBox(gFrontLeftTentacle2, 0, 13, -1.0F, -0.3F, -1.0F, 2, 5, 2, -0.25F, false));

		gFrontLeftTentacle3 = new RendererModel(this);
		gFrontLeftTentacle3.setRotationPoint(0.0F, 4.4F, 0.0F);
		gFrontLeftTentacle2.addChild(gFrontLeftTentacle3);
		gFrontLeftTentacle3.cubeList.add(new ModelBox(gFrontLeftTentacle3, 0, 13, -1.0F, -0.5F, -1.0F, 2, 5, 2, -0.4F, false));

		gFrontRightTentacle1 = new RendererModel(this);
		gFrontRightTentacle1.setRotationPoint(-1.0F, -0.2F, 1.0F);
		gBody.addChild(gFrontRightTentacle1);
		gFrontRightTentacle1.cubeList.add(new ModelBox(gFrontRightTentacle1, 0, 13, -1.0F, 0.0F, -1.0F, 2, 5, 2, -0.1F, true));

		gFrontRightTentacle2 = new RendererModel(this);
		gFrontRightTentacle2.setRotationPoint(0.0F, 4.9F, 0.0F);
		gFrontRightTentacle1.addChild(gFrontRightTentacle2);
		gFrontRightTentacle2.cubeList.add(new ModelBox(gFrontRightTentacle2, 0, 13, -1.0F, -0.3F, -1.0F, 2, 5, 2, -0.25F, true));

		gFrontRightTentacle3 = new RendererModel(this);
		gFrontRightTentacle3.setRotationPoint(0.0F, 4.4F, 0.0F);
		gFrontRightTentacle2.addChild(gFrontRightTentacle3);
		gFrontRightTentacle3.cubeList.add(new ModelBox(gFrontRightTentacle3, 0, 13, -1.0F, -0.5F, -1.0F, 2, 5, 2, -0.4F, true));

		gUpperBody = new RendererModel(this);
		gUpperBody.setRotationPoint(0.0F, -2.9F, 0.0F);
		gBody.addChild(gUpperBody);
		gUpperBody.cubeList.add(new ModelBox(gUpperBody, 17, 0, -2.5F, -6.0F, -2.0F, 5, 6, 4, 0.1F, false));

		gUpperBodyMiddle = new RendererModel(this);
		gUpperBodyMiddle.setRotationPoint(0.0F, -6.0F, 0.0F);
		gUpperBody.addChild(gUpperBodyMiddle);
		gUpperBodyMiddle.cubeList.add(new ModelBox(gUpperBodyMiddle, 37, 5, -2.0F, -3.3F, -1.5F, 4, 3, 3, 0.2F, false));

		gUpperBodyEnd = new RendererModel(this);
		gUpperBodyEnd.setRotationPoint(0.0F, -3.0F, 0.0F);
		gUpperBodyMiddle.addChild(gUpperBodyEnd);
		gUpperBodyEnd.cubeList.add(new ModelBox(gUpperBodyEnd, 37, 0, -1.5F, -2.7F, -1.0F, 3, 2, 2, 0.2F, false));
	}

	@Override
	public void render(TrilobiteBabyEntity trilobiteBabyEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}