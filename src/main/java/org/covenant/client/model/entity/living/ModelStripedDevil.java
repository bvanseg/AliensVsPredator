package org.covenant.client.model.entity.living;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import org.covenant.common.entity.living.EntityStripedDevil;

public class ModelStripedDevil extends Model<EntityStripedDevil> {
	private final ModelRenderer root;
	private final ModelRenderer chest;
	private final ModelRenderer stomach;
	private final ModelRenderer rear;
	private final ModelRenderer tail01;
	private final ModelRenderer tail02;
	private final ModelRenderer lLeg01;
	private final ModelRenderer lLeg02;
	private final ModelRenderer lLeg03;
	private final ModelRenderer lHindPaw;
	private final ModelRenderer lHindPawToes;
	private final ModelRenderer lLeg2;
	private final ModelRenderer lLeg3;
	private final ModelRenderer lLeg4;
	private final ModelRenderer lHindPaw2;
	private final ModelRenderer lHindPawToes2;
	private final ModelRenderer neck01;
	private final ModelRenderer neck02;
	private final ModelRenderer head;
	private final ModelRenderer lowerJaw;
	private final ModelRenderer upperJaw;
	private final ModelRenderer upperJawL;
	private final ModelRenderer lFang;
	private final ModelRenderer upperJawR;
	private final ModelRenderer upperJawR_r1;
	private final ModelRenderer rFang;
	private final ModelRenderer upperJawR2;
	private final ModelRenderer upperJawR_r2;
	private final ModelRenderer rFang2;
	private final ModelRenderer snout;
	private final ModelRenderer lEar01;
	private final ModelRenderer lEar01_r1;
	private final ModelRenderer lEar02;
	private final ModelRenderer lEar2;
	private final ModelRenderer lEar02_r1;
	private final ModelRenderer lEar3;
	private final ModelRenderer lArm01;
	private final ModelRenderer lArm02;
	private final ModelRenderer lArm03;
	private final ModelRenderer lForepaw;
	private final ModelRenderer lArm2;
	private final ModelRenderer lArm3;
	private final ModelRenderer lArm4;
	private final ModelRenderer lForepaw2;

	public ModelStripedDevil() {
		textureWidth = 128;
		textureHeight = 64;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 12.6F, -2.4F);
		root.addChild(chest);
		chest.cubeList.add(new ModelBox(chest, 0, 0, -3.5F, -3.5F, -4.5F, 7, 7, 8, 0.0F, false));

		stomach = new ModelRenderer(this);
		stomach.setRotationPoint(0.0F, 0.0F, 3.2F);
		chest.addChild(stomach);
		setRotationAngle(stomach, 0.0456F, 0.0F, 0.0F);
		stomach.cubeList.add(new ModelBox(stomach, 0, 17, -3.0F, -3.0F, 0.0F, 6, 6, 6, 0.0F, false));

		rear = new ModelRenderer(this);
		rear.setRotationPoint(0.0F, -0.4F, 5.4F);
		stomach.addChild(rear);
		setRotationAngle(rear, -0.2276F, 0.0F, 0.0F);
		rear.cubeList.add(new ModelBox(rear, 0, 31, -3.5F, -2.5F, 0.0F, 7, 5, 4, 0.0F, false));

		tail01 = new ModelRenderer(this);
		tail01.setRotationPoint(0.0F, -1.2F, 3.5F);
		rear.addChild(tail01);
		setRotationAngle(tail01, -0.5463F, 0.0F, 0.0F);
		tail01.cubeList.add(new ModelBox(tail01, 0, 42, -1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F, false));

		tail02 = new ModelRenderer(this);
		tail02.setRotationPoint(0.0F, -0.1F, 2.7F);
		tail01.addChild(tail02);
		setRotationAngle(tail02, -0.2731F, 0.0F, 0.0F);
		tail02.cubeList.add(new ModelBox(tail02, 12, 42, -0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F, false));

		lLeg01 = new ModelRenderer(this);
		lLeg01.setRotationPoint(4.55F, -0.2F, 1.1F);
		rear.addChild(lLeg01);
		setRotationAngle(lLeg01, -0.182F, 0.0F, 0.0F);
		lLeg01.cubeList.add(new ModelBox(lLeg01, 99, 0, -3.0F, -1.1F, -2.5F, 3, 7, 5, 0.0F, false));

		lLeg02 = new ModelRenderer(this);
		lLeg02.setRotationPoint(-1.8F, 4.7F, -1.0F);
		lLeg01.addChild(lLeg02);
		setRotationAngle(lLeg02, 1.0016F, 0.0F, 0.0F);
		lLeg02.cubeList.add(new ModelBox(lLeg02, 99, 14, -1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F, false));

		lLeg03 = new ModelRenderer(this);
		lLeg03.setRotationPoint(0.1F, 4.3F, 0.3F);
		lLeg02.addChild(lLeg03);
		setRotationAngle(lLeg03, -0.8652F, 0.0F, 0.0F);
		lLeg03.cubeList.add(new ModelBox(lLeg03, 99, 24, -1.0F, -0.2F, -1.0F, 2, 4, 2, 0.0F, false));

		lHindPaw = new ModelRenderer(this);
		lHindPaw.setRotationPoint(0.1F, 3.2F, -0.3F);
		lLeg03.addChild(lHindPaw);
		setRotationAngle(lHindPaw, 0.2276F, 0.0F, 0.0F);
		lHindPaw.cubeList.add(new ModelBox(lHindPaw, 89, 32, -1.5F, -0.1F, -1.1F, 3, 2, 2, 0.0F, false));

		lHindPawToes = new ModelRenderer(this);
		lHindPawToes.setRotationPoint(0.1F, 0.8F, -0.7F);
		lHindPaw.addChild(lHindPawToes);
		setRotationAngle(lHindPawToes, 0.3643F, 0.0F, 0.0F);
		lHindPawToes.cubeList.add(new ModelBox(lHindPawToes, 103, 34, -1.5F, -1.1F, -1.7F, 3, 2, 2, 0.0F, false));

		lLeg2 = new ModelRenderer(this);
		lLeg2.setRotationPoint(-4.55F, -0.2F, 1.1F);
		rear.addChild(lLeg2);
		setRotationAngle(lLeg2, -0.182F, 0.0F, 0.0F);
		lLeg2.cubeList.add(new ModelBox(lLeg2, 99, 0, 0.0F, -1.1F, -2.5F, 3, 7, 5, 0.0F, true));

		lLeg3 = new ModelRenderer(this);
		lLeg3.setRotationPoint(1.8F, 4.7F, -1.0F);
		lLeg2.addChild(lLeg3);
		setRotationAngle(lLeg3, 1.0016F, 0.0F, 0.0F);
		lLeg3.cubeList.add(new ModelBox(lLeg3, 99, 14, -1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F, true));

		lLeg4 = new ModelRenderer(this);
		lLeg4.setRotationPoint(-0.1F, 4.3F, 0.3F);
		lLeg3.addChild(lLeg4);
		setRotationAngle(lLeg4, -0.8652F, 0.0F, 0.0F);
		lLeg4.cubeList.add(new ModelBox(lLeg4, 99, 24, -1.0F, -0.2F, -1.0F, 2, 4, 2, 0.0F, true));

		lHindPaw2 = new ModelRenderer(this);
		lHindPaw2.setRotationPoint(-0.1F, 3.2F, -0.3F);
		lLeg4.addChild(lHindPaw2);
		setRotationAngle(lHindPaw2, 0.2276F, 0.0F, 0.0F);
		lHindPaw2.cubeList.add(new ModelBox(lHindPaw2, 89, 32, -1.5F, -0.1F, -1.1F, 3, 2, 2, 0.0F, true));

		lHindPawToes2 = new ModelRenderer(this);
		lHindPawToes2.setRotationPoint(-0.1F, 0.8F, -0.7F);
		lHindPaw2.addChild(lHindPawToes2);
		setRotationAngle(lHindPawToes2, 0.3643F, 0.0F, 0.0F);
		lHindPawToes2.cubeList.add(new ModelBox(lHindPawToes2, 103, 34, -1.5F, -1.1F, -1.7F, 3, 2, 2, 0.0F, true));

		neck01 = new ModelRenderer(this);
		neck01.setRotationPoint(0.0F, 0.2F, -2.9F);
		chest.addChild(neck01);
		setRotationAngle(neck01, -0.5009F, 0.0F, 0.0F);
		neck01.cubeList.add(new ModelBox(neck01, 35, 0, -3.0F, -3.5F, -3.6F, 6, 7, 4, 0.0F, false));

		neck02 = new ModelRenderer(this);
		neck02.setRotationPoint(0.0F, -0.1F, -3.4F);
		neck01.addChild(neck02);
		setRotationAngle(neck02, -0.1367F, 0.0F, 0.0F);
		neck02.cubeList.add(new ModelBox(neck02, 35, 14, -2.5F, -3.0F, -4.0F, 5, 6, 5, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -1.1F, -2.6F);
		neck02.addChild(head);
		setRotationAngle(head, 0.6374F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 36, 29, -3.0F, -2.5F, -5.0F, 6, 5, 5, 0.0F, false));

		lowerJaw = new ModelRenderer(this);
		lowerJaw.setRotationPoint(0.0F, 1.8F, -4.4F);
		head.addChild(lowerJaw);
		setRotationAngle(lowerJaw, 0.0436F, 0.0F, 0.0F);
		lowerJaw.cubeList.add(new ModelBox(lowerJaw, 36, 52, -1.5F, -0.5F, -3.7F, 3, 1, 5, 0.0F, false));

		upperJaw = new ModelRenderer(this);
		upperJaw.setRotationPoint(0.0F, 0.1F, -4.1F);
		head.addChild(upperJaw);
		upperJaw.cubeList.add(new ModelBox(upperJaw, 36, 42, -1.5F, 0.3F, -4.3F, 3, 1, 4, 0.0F, false));

		upperJawL = new ModelRenderer(this);
		upperJawL.setRotationPoint(-0.6F, 0.0F, 0.0F);
		upperJaw.addChild(upperJawL);
		setRotationAngle(upperJawL, 0.0F, -0.1367F, 0.0F);
		

		lFang = new ModelRenderer(this);
		lFang.setRotationPoint(-1.6F, 0.5F, -2.9F);
		upperJawL.addChild(lFang);
		

		upperJawR = new ModelRenderer(this);
		upperJawR.setRotationPoint(1.2F, 0.0F, 0.0F);
		upperJaw.addChild(upperJawR);
		setRotationAngle(upperJawR, 0.0F, 0.1367F, 0.0F);
		

		upperJawR_r1 = new ModelRenderer(this);
		upperJawR_r1.setRotationPoint(-1.2F, 12.3F, 15.4F);
		upperJawR.addChild(upperJawR_r1);
		setRotationAngle(upperJawR_r1, 0.0F, -0.3927F, 0.0F);
		upperJawR_r1.cubeList.add(new ModelBox(upperJawR_r1, 51, 42, -8.6F, -12.9F, -18.45F, 1, 2, 4, 0.0F, true));

		rFang = new ModelRenderer(this);
		rFang.setRotationPoint(1.1F, 0.5F, -2.9F);
		upperJawR.addChild(rFang);
		rFang.cubeList.add(new ModelBox(rFang, 0, 0, 0.0F, 0.0F, -0.5F, 0, 2, 1, 0.0F, true));

		upperJawR2 = new ModelRenderer(this);
		upperJawR2.setRotationPoint(-1.2F, 0.0F, 0.0F);
		upperJaw.addChild(upperJawR2);
		setRotationAngle(upperJawR2, 0.0F, -0.1367F, 0.0F);
		

		upperJawR_r2 = new ModelRenderer(this);
		upperJawR_r2.setRotationPoint(1.2F, 12.3F, 15.4F);
		upperJawR2.addChild(upperJawR_r2);
		setRotationAngle(upperJawR_r2, 0.0F, 0.3927F, 0.0F);
		upperJawR_r2.cubeList.add(new ModelBox(upperJawR_r2, 51, 42, 7.6F, -12.9F, -18.45F, 1, 2, 4, 0.0F, false));

		rFang2 = new ModelRenderer(this);
		rFang2.setRotationPoint(-1.1F, 0.5F, -2.9F);
		upperJawR2.addChild(rFang2);
		rFang2.cubeList.add(new ModelBox(rFang2, 0, 0, 0.0F, 0.0F, -0.5F, 0, 2, 1, 0.0F, false));

		snout = new ModelRenderer(this);
		snout.setRotationPoint(0.0F, -1.1F, -4.7F);
		head.addChild(snout);
		setRotationAngle(snout, 0.182F, 0.0F, 0.0F);
		snout.cubeList.add(new ModelBox(snout, 63, 42, -1.5F, -0.7F, -3.9F, 3, 2, 4, 0.0F, false));

		lEar01 = new ModelRenderer(this);
		lEar01.setRotationPoint(1.75F, -2.3F, -1.45F);
		head.addChild(lEar01);
		setRotationAngle(lEar01, 0.0F, -0.6868F, 0.2731F);
		

		lEar01_r1 = new ModelRenderer(this);
		lEar01_r1.setRotationPoint(-0.1F, -0.5748F, 0.137F);
		lEar01.addChild(lEar01_r1);
		setRotationAngle(lEar01_r1, 0.3927F, 0.0F, 0.0F);
		lEar01_r1.cubeList.add(new ModelBox(lEar01_r1, 66, 0, -1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F, false));

		lEar02 = new ModelRenderer(this);
		lEar02.setRotationPoint(0.3F, 0.2F, 0.7F);
		lEar01.addChild(lEar02);
		setRotationAngle(lEar02, 0.2731F, 0.0F, 0.0F);
		lEar02.cubeList.add(new ModelBox(lEar02, 66, 0, -1.0F, -3.0F, -1.0F, 2, 3, 1, 0.0F, false));

		lEar2 = new ModelRenderer(this);
		lEar2.setRotationPoint(-1.75F, -2.3F, -1.45F);
		head.addChild(lEar2);
		setRotationAngle(lEar2, 0.0F, 0.6868F, -0.2731F);
		

		lEar02_r1 = new ModelRenderer(this);
		lEar02_r1.setRotationPoint(0.1F, -0.5748F, 0.137F);
		lEar2.addChild(lEar02_r1);
		setRotationAngle(lEar02_r1, 0.3927F, 0.0F, 0.0F);
		lEar02_r1.cubeList.add(new ModelBox(lEar02_r1, 66, 0, -1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F, true));

		lEar3 = new ModelRenderer(this);
		lEar3.setRotationPoint(-0.3F, 0.2F, 0.7F);
		lEar2.addChild(lEar3);
		setRotationAngle(lEar3, 0.2731F, 0.0F, 0.0F);
		lEar3.cubeList.add(new ModelBox(lEar3, 66, 0, -1.0F, -3.0F, -1.0F, 2, 3, 1, 0.0F, true));

		lArm01 = new ModelRenderer(this);
		lArm01.setRotationPoint(5.0F, -0.3F, -2.5F);
		chest.addChild(lArm01);
		setRotationAngle(lArm01, 0.0911F, 0.0F, -0.0911F);
		lArm01.cubeList.add(new ModelBox(lArm01, 77, 0, -3.0F, -1.5F, -1.5F, 3, 6, 4, 0.0F, false));

		lArm02 = new ModelRenderer(this);
		lArm02.setRotationPoint(-1.5F, 3.9F, -0.2F);
		lArm01.addChild(lArm02);
		lArm02.cubeList.add(new ModelBox(lArm02, 77, 11, -1.0F, 0.0F, -1.0F, 2, 2, 3, 0.0F, false));

		lArm03 = new ModelRenderer(this);
		lArm03.setRotationPoint(0.0F, 1.6F, 0.4F);
		lArm02.addChild(lArm03);
		setRotationAngle(lArm03, -0.2276F, 0.0F, 0.0911F);
		lArm03.cubeList.add(new ModelBox(lArm03, 77, 18, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		lForepaw = new ModelRenderer(this);
		lForepaw.setRotationPoint(0.0F, 5.5F, 0.0F);
		lArm03.addChild(lForepaw);
		setRotationAngle(lForepaw, 0.1367F, 0.0F, 0.0F);
		lForepaw.cubeList.add(new ModelBox(lForepaw, 72, 28, -1.5F, 0.0F, -2.9F, 3, 1, 4, 0.0F, false));

		lArm2 = new ModelRenderer(this);
		lArm2.setRotationPoint(-5.0F, -0.3F, -2.5F);
		chest.addChild(lArm2);
		setRotationAngle(lArm2, 0.0911F, 0.0F, 0.0911F);
		lArm2.cubeList.add(new ModelBox(lArm2, 77, 0, 0.0F, -1.5F, -1.5F, 3, 6, 4, 0.0F, true));

		lArm3 = new ModelRenderer(this);
		lArm3.setRotationPoint(1.5F, 3.9F, -0.2F);
		lArm2.addChild(lArm3);
		lArm3.cubeList.add(new ModelBox(lArm3, 77, 11, -1.0F, 0.0F, -1.0F, 2, 2, 3, 0.0F, true));

		lArm4 = new ModelRenderer(this);
		lArm4.setRotationPoint(0.0F, 1.6F, 0.4F);
		lArm3.addChild(lArm4);
		setRotationAngle(lArm4, -0.2276F, 0.0F, -0.0911F);
		lArm4.cubeList.add(new ModelBox(lArm4, 77, 18, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, true));

		lForepaw2 = new ModelRenderer(this);
		lForepaw2.setRotationPoint(0.0F, 5.5F, 0.0F);
		lArm4.addChild(lForepaw2);
		setRotationAngle(lForepaw2, 0.1367F, 0.0F, 0.0F);
		lForepaw2.cubeList.add(new ModelBox(lForepaw2, 72, 28, -1.5F, 0.0F, -2.9F, 3, 1, 4, 0.0F, true));
	}

	@Override
	public void render(EntityStripedDevil entityStripedDevil) {
		draw(root);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}