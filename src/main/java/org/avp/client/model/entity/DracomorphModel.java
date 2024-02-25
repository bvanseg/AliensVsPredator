package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import org.avp.common.entity.DracomorphEntity;

public class DracomorphModel extends EntityModel<DracomorphEntity> {
	private final RendererModel root;
	private final RendererModel gChest;
	private final RendererModel lShoulderBlade_r1;
	private final RendererModel lShoulderBlade_r2;
	private final RendererModel rWingArm2_r1;
	private final RendererModel rWingArm3_r1;
	private final RendererModel rWingArm3_r2;
	private final RendererModel rWingArm4_r1;
	private final RendererModel gNeck;
	private final RendererModel gNeckEnd;
	private final RendererModel gHead;
	private final RendererModel lHead_r1;
	private final RendererModel gDome;
	private final RendererModel backSpines1_r1;
	private final RendererModel gRightHorns;
	private final RendererModel lHorn6_r1;
	private final RendererModel lHorn5_r1;
	private final RendererModel lHorn7_r1;
	private final RendererModel lHorn4_r1;
	private final RendererModel lHorn6_r2;
	private final RendererModel lHorn4_r2;
	private final RendererModel lHeadFin_r1;
	private final RendererModel lHorn5_r2;
	private final RendererModel gLeftHorns;
	private final RendererModel lHorn7_r2;
	private final RendererModel lHorn6_r3;
	private final RendererModel lHorn8_r1;
	private final RendererModel lHorn5_r3;
	private final RendererModel lHorn7_r3;
	private final RendererModel lHorn5_r4;
	private final RendererModel lHeadFin_r2;
	private final RendererModel lHorn6_r4;
	private final RendererModel gMouth;
	private final RendererModel gJawLower;
	private final RendererModel gInnerJaw;
	private final RendererModel gRightArm;
	private final RendererModel gRightForearm;
	private final RendererModel gRightHand;
	private final RendererModel rClaw3_r1;
	private final RendererModel gLeftArm;
	private final RendererModel gLeftForearm;
	private final RendererModel gLeftHand;
	private final RendererModel rClaw4_r1;
	private final RendererModel gRightWingArm;
	private final RendererModel gRightWingForearm;
	private final RendererModel gRightWingHand;
	private final RendererModel gRightWingEnd;
	private final RendererModel gLeftWingArm;
	private final RendererModel gLeftWingForearm;
	private final RendererModel gLeftWingHand;
	private final RendererModel gLeftWingEnd;
	private final RendererModel gStomach;
	private final RendererModel gLeftThigh;
	private final RendererModel gLeftShin;
	private final RendererModel gLeftAnkle;
	private final RendererModel gLeftFoot;
	private final RendererModel gRightThigh;
	private final RendererModel gRightShin;
	private final RendererModel gRightAnkle;
	private final RendererModel gRightFoot;
	private final RendererModel gSack1;
	private final RendererModel gSack2;
	private final RendererModel gSack3;
	private final RendererModel gSack4;
	private final RendererModel gSack5;
	private final RendererModel gSack6;
	private final RendererModel gSack7;
	private final RendererModel gSack8;
	private final RendererModel gTail1;
	private final RendererModel gTail2;
	private final RendererModel gTail3;
	private final RendererModel gTail4;
	private final RendererModel gTail5;
	private final RendererModel gTailBlade;

	public DracomorphModel() {
		textureWidth = 256;
		textureHeight = 128;

		root = new RendererModel(this);
		root.setRotationPoint(0.0F, 0.4F, -1.0F);
		

		gChest = new RendererModel(this);
		gChest.setRotationPoint(0.0F, -2.5F, -9.0F);
		root.addChild(gChest);
		gChest.cubeList.add(new ModelBox(gChest, 0, 67, 0.0F, -5.8F, 1.5F, 0, 6, 10, 0.0F, false));
		gChest.cubeList.add(new ModelBox(gChest, 1, 55, -5.0F, 0.0F, 0.0F, 10, 8, 11, 0.0F, false));

		lShoulderBlade_r1 = new RendererModel(this);
		lShoulderBlade_r1.setRotationPoint(0.0F, 2.4507F, 0.5655F);
		gChest.addChild(lShoulderBlade_r1);
		setRotationAngle(lShoulderBlade_r1, 1.69F, 0.2196F, -0.1349F);
		lShoulderBlade_r1.cubeList.add(new ModelBox(lShoulderBlade_r1, 146, 34, -5.6424F, -2.4422F, -4.6468F, 2, 3, 10, 0.0F, true));

		lShoulderBlade_r2 = new RendererModel(this);
		lShoulderBlade_r2.setRotationPoint(0.0F, 2.4507F, 0.5655F);
		gChest.addChild(lShoulderBlade_r2);
		setRotationAngle(lShoulderBlade_r2, 1.69F, -0.2196F, 0.1349F);
		lShoulderBlade_r2.cubeList.add(new ModelBox(lShoulderBlade_r2, 146, 34, 3.6424F, -2.4422F, -4.6468F, 2, 3, 10, 0.0F, false));

		rWingArm2_r1 = new RendererModel(this);
		rWingArm2_r1.setRotationPoint(-3.9664F, -3.001F, 5.102F);
		gChest.addChild(rWingArm2_r1);
		setRotationAngle(rWingArm2_r1, 0.273F, -0.0556F, 2.6731F);
		rWingArm2_r1.cubeList.add(new ModelBox(rWingArm2_r1, 41, 27, -1.0F, -4.5F, -1.5F, 2, 9, 3, -0.25F, false));

		rWingArm3_r1 = new RendererModel(this);
		rWingArm3_r1.setRotationPoint(-3.7215F, -3.0245F, 9.2159F);
		gChest.addChild(rWingArm3_r1);
		setRotationAngle(rWingArm3_r1, 0.4912F, -0.0556F, 2.6731F);
		rWingArm3_r1.cubeList.add(new ModelBox(rWingArm3_r1, 41, 27, -1.0F, -4.5F, -1.5F, 2, 9, 3, -0.25F, false));

		rWingArm3_r2 = new RendererModel(this);
		rWingArm3_r2.setRotationPoint(3.9664F, -3.001F, 5.102F);
		gChest.addChild(rWingArm3_r2);
		setRotationAngle(rWingArm3_r2, 0.273F, 0.0556F, -2.6731F);
		rWingArm3_r2.cubeList.add(new ModelBox(rWingArm3_r2, 41, 27, -1.0F, -4.5F, -1.5F, 2, 9, 3, -0.25F, true));

		rWingArm4_r1 = new RendererModel(this);
		rWingArm4_r1.setRotationPoint(3.7215F, -3.0245F, 9.2159F);
		gChest.addChild(rWingArm4_r1);
		setRotationAngle(rWingArm4_r1, 0.4912F, 0.0556F, -2.6731F);
		rWingArm4_r1.cubeList.add(new ModelBox(rWingArm4_r1, 41, 27, -1.0F, -4.5F, -1.5F, 2, 9, 3, -0.25F, true));

		gNeck = new RendererModel(this);
		gNeck.setRotationPoint(0.0F, 3.4F, 2.3F);
		gChest.addChild(gNeck);
		setRotationAngle(gNeck, -0.7854F, 0.0F, 0.0F);
		gNeck.cubeList.add(new ModelBox(gNeck, 23, 86, -3.0F, -3.5F, -6.2F, 6, 7, 5, 0.0F, false));

		gNeckEnd = new RendererModel(this);
		gNeckEnd.setRotationPoint(0.0F, -0.2F, -6.2F);
		gNeck.addChild(gNeckEnd);
		setRotationAngle(gNeckEnd, 0.3927F, 0.0F, 0.0F);
		gNeckEnd.cubeList.add(new ModelBox(gNeckEnd, 65, 86, -2.5F, -3.0F, -4.0F, 5, 6, 4, 0.0F, false));

		gHead = new RendererModel(this);
		gHead.setRotationPoint(0.0F, -0.8F, -4.3F);
		gNeckEnd.addChild(gHead);
		gHead.cubeList.add(new ModelBox(gHead, 0, 0, -2.5F, -3.2F, -4.7F, 5, 10, 5, 0.1F, false));

		lHead_r1 = new RendererModel(this);
		lHead_r1.setRotationPoint(-2.0F, 16.2144F, 17.6692F);
		gHead.addChild(lHead_r1);
		setRotationAngle(lHead_r1, 0.5009F, 0.0F, 0.0F);
		lHead_r1.cubeList.add(new ModelBox(lHead_r1, 53, 0, -0.5F, -19.0F, -15.1F, 3, 3, 5, 0.0F, true));
		lHead_r1.cubeList.add(new ModelBox(lHead_r1, 53, 0, 1.5F, -19.0F, -15.1F, 3, 3, 5, 0.0F, false));

		gDome = new RendererModel(this);
		gDome.setRotationPoint(0.0F, -2.6476F, -3.5626F);
		gHead.addChild(gDome);
		setRotationAngle(gDome, -0.3927F, 0.0F, 0.0F);
		gDome.cubeList.add(new ModelBox(gDome, 28, 10, -2.5F, -10.1476F, -1.2626F, 5, 10, 5, 0.0F, false));

		backSpines1_r1 = new RendererModel(this);
		backSpines1_r1.setRotationPoint(0.0F, -3.4524F, -1.7374F);
		gDome.addChild(backSpines1_r1);
		setRotationAngle(backSpines1_r1, 1.5708F, 0.0F, 0.0F);
		backSpines1_r1.cubeList.add(new ModelBox(backSpines1_r1, 0, 67, 0.0F, -2.5F, -3.6F, 0, 6, 10, 0.0F, false));

		gRightHorns = new RendererModel(this);
		gRightHorns.setRotationPoint(-0.75F, -3.4894F, -2.1129F);
		gHead.addChild(gRightHorns);
		

		lHorn6_r1 = new RendererModel(this);
		lHorn6_r1.setRotationPoint(-2.8934F, -8.2082F, 1.6597F);
		gRightHorns.addChild(lHorn6_r1);
		setRotationAngle(lHorn6_r1, -0.0981F, -0.1314F, -0.067F);
		lHorn6_r1.cubeList.add(new ModelBox(lHorn6_r1, 238, 44, -0.9624F, -5.0147F, 0.0519F, 1, 4, 1, 0.0F, true));

		lHorn5_r1 = new RendererModel(this);
		lHorn5_r1.setRotationPoint(-2.8934F, -8.2082F, 1.6597F);
		gRightHorns.addChild(lHorn5_r1);
		setRotationAngle(lHorn5_r1, -0.4444F, -0.1431F, -0.1986F);
		lHorn5_r1.cubeList.add(new ModelBox(lHorn5_r1, 228, 41, -0.7588F, -1.582F, -1.0429F, 1, 3, 2, 0.1F, true));

		lHorn7_r1 = new RendererModel(this);
		lHorn7_r1.setRotationPoint(0.75F, -3.0093F, -1.287F);
		gRightHorns.addChild(lHorn7_r1);
		setRotationAngle(lHorn7_r1, -0.5333F, -0.9272F, 0.3093F);
		lHorn7_r1.cubeList.add(new ModelBox(lHorn7_r1, 238, 44, -2.9987F, -7.2762F, 4.3644F, 1, 4, 1, 0.0F, true));

		lHorn4_r1 = new RendererModel(this);
		lHorn4_r1.setRotationPoint(-2.8934F, -8.2082F, 1.6597F);
		gRightHorns.addChild(lHorn4_r1);
		setRotationAngle(lHorn4_r1, -0.0324F, -0.2126F, -0.3413F);
		lHorn4_r1.cubeList.add(new ModelBox(lHorn4_r1, 219, 42, -0.9086F, 1.0114F, -1.6094F, 1, 4, 2, 0.2F, true));

		lHorn6_r2 = new RendererModel(this);
		lHorn6_r2.setRotationPoint(0.75F, -3.0093F, -1.287F);
		gRightHorns.addChild(lHorn6_r2);
		setRotationAngle(lHorn6_r2, -0.7303F, -0.9843F, 0.1047F);
		lHorn6_r2.cubeList.add(new ModelBox(lHorn6_r2, 228, 41, -2.4825F, -5.4617F, 2.0932F, 1, 3, 2, 0.1F, true));

		lHorn4_r2 = new RendererModel(this);
		lHorn4_r2.setRotationPoint(0.75F, -3.0093F, -1.287F);
		gRightHorns.addChild(lHorn4_r2);
		setRotationAngle(lHorn4_r2, 0.3606F, -0.9877F, -1.0052F);
		lHorn4_r2.cubeList.add(new ModelBox(lHorn4_r2, 207, 41, -2.9173F, 0.1337F, 2.9863F, 2, 3, 2, 0.2F, true));

		lHeadFin_r1 = new RendererModel(this);
		lHeadFin_r1.setRotationPoint(-5.0774F, -4.4182F, 2.8454F);
		gRightHorns.addChild(lHeadFin_r1);
		setRotationAngle(lHeadFin_r1, -2.7691F, -0.1734F, 2.9829F);
		lHeadFin_r1.cubeList.add(new ModelBox(lHeadFin_r1, 43, 111, -3.5F, -7.5F, 0.0F, 7, 15, 0, 0.0F, false));

		lHorn5_r2 = new RendererModel(this);
		lHorn5_r2.setRotationPoint(0.75F, -3.0093F, -1.287F);
		gRightHorns.addChild(lHorn5_r2);
		setRotationAngle(lHorn5_r2, -0.1344F, -1.0801F, -0.1383F);
		lHorn5_r2.cubeList.add(new ModelBox(lHorn5_r2, 219, 42, -1.9927F, -1.6009F, 2.847F, 1, 4, 2, 0.2F, true));

		gLeftHorns = new RendererModel(this);
		gLeftHorns.setRotationPoint(0.75F, -3.4894F, -2.1129F);
		gHead.addChild(gLeftHorns);
		

		lHorn7_r2 = new RendererModel(this);
		lHorn7_r2.setRotationPoint(2.8934F, -8.2082F, 1.6597F);
		gLeftHorns.addChild(lHorn7_r2);
		setRotationAngle(lHorn7_r2, -0.0981F, 0.1314F, 0.067F);
		lHorn7_r2.cubeList.add(new ModelBox(lHorn7_r2, 238, 44, -0.0376F, -5.0147F, 0.0519F, 1, 4, 1, 0.0F, false));

		lHorn6_r3 = new RendererModel(this);
		lHorn6_r3.setRotationPoint(2.8934F, -8.2082F, 1.6597F);
		gLeftHorns.addChild(lHorn6_r3);
		setRotationAngle(lHorn6_r3, -0.4444F, 0.1431F, 0.1986F);
		lHorn6_r3.cubeList.add(new ModelBox(lHorn6_r3, 228, 41, -0.2412F, -1.582F, -1.0429F, 1, 3, 2, 0.1F, false));

		lHorn8_r1 = new RendererModel(this);
		lHorn8_r1.setRotationPoint(-0.75F, -3.0093F, -1.287F);
		gLeftHorns.addChild(lHorn8_r1);
		setRotationAngle(lHorn8_r1, -0.5333F, 0.9272F, -0.3093F);
		lHorn8_r1.cubeList.add(new ModelBox(lHorn8_r1, 238, 44, 1.9987F, -7.2762F, 4.3644F, 1, 4, 1, 0.0F, false));

		lHorn5_r3 = new RendererModel(this);
		lHorn5_r3.setRotationPoint(2.8934F, -8.2082F, 1.6597F);
		gLeftHorns.addChild(lHorn5_r3);
		setRotationAngle(lHorn5_r3, -0.0324F, 0.2126F, 0.3413F);
		lHorn5_r3.cubeList.add(new ModelBox(lHorn5_r3, 219, 42, -0.0914F, 1.0114F, -1.6094F, 1, 4, 2, 0.2F, false));

		lHorn7_r3 = new RendererModel(this);
		lHorn7_r3.setRotationPoint(-0.75F, -3.0093F, -1.287F);
		gLeftHorns.addChild(lHorn7_r3);
		setRotationAngle(lHorn7_r3, -0.7303F, 0.9843F, -0.1047F);
		lHorn7_r3.cubeList.add(new ModelBox(lHorn7_r3, 228, 41, 1.4825F, -5.4617F, 2.0932F, 1, 3, 2, 0.1F, false));

		lHorn5_r4 = new RendererModel(this);
		lHorn5_r4.setRotationPoint(-0.75F, -3.0093F, -1.287F);
		gLeftHorns.addChild(lHorn5_r4);
		setRotationAngle(lHorn5_r4, 0.3606F, 0.9877F, 1.0052F);
		lHorn5_r4.cubeList.add(new ModelBox(lHorn5_r4, 207, 41, 0.9173F, 0.1337F, 2.9863F, 2, 3, 2, 0.2F, false));

		lHeadFin_r2 = new RendererModel(this);
		lHeadFin_r2.setRotationPoint(5.0774F, -4.4182F, 2.8454F);
		gLeftHorns.addChild(lHeadFin_r2);
		setRotationAngle(lHeadFin_r2, -2.7691F, 0.1734F, -2.9829F);
		lHeadFin_r2.cubeList.add(new ModelBox(lHeadFin_r2, 43, 111, -3.5F, -7.5F, 0.0F, 7, 15, 0, 0.0F, true));

		lHorn6_r4 = new RendererModel(this);
		lHorn6_r4.setRotationPoint(-0.75F, -3.0093F, -1.287F);
		gLeftHorns.addChild(lHorn6_r4);
		setRotationAngle(lHorn6_r4, -0.1344F, 1.0801F, 0.1383F);
		lHorn6_r4.cubeList.add(new ModelBox(lHorn6_r4, 219, 42, 0.9927F, -1.6009F, 2.847F, 1, 4, 2, 0.2F, false));

		gMouth = new RendererModel(this);
		gMouth.setRotationPoint(0.0F, 8.1465F, -0.9455F);
		gHead.addChild(gMouth);
		setRotationAngle(gMouth, 0.6545F, 0.0F, 0.0F);
		gMouth.cubeList.add(new ModelBox(gMouth, 52, 20, -1.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, false));

		gJawLower = new RendererModel(this);
		gJawLower.setRotationPoint(0.0F, 0.3807F, 1.9717F);
		gMouth.addChild(gJawLower);
		gJawLower.cubeList.add(new ModelBox(gJawLower, 88, 1, -1.5F, 0.0193F, -4.4717F, 3, 1, 5, -0.1F, false));

		gInnerJaw = new RendererModel(this);
		gInnerJaw.setRotationPoint(0.0F, -0.0447F, -0.3182F);
		gJawLower.addChild(gInnerJaw);
		setRotationAngle(gInnerJaw, -0.3927F, 0.0F, 0.0F);
		gInnerJaw.cubeList.add(new ModelBox(gInnerJaw, 1, 19, -1.0F, -1.0F, -3.5F, 2, 2, 4, -0.25F, false));

		gRightArm = new RendererModel(this);
		gRightArm.setRotationPoint(-4.9F, 3.9F, 3.6F);
		gChest.addChild(gRightArm);
		setRotationAngle(gRightArm, 1.9635F, 0.0F, 0.0F);
		gRightArm.cubeList.add(new ModelBox(gRightArm, 103, 6, -1.5F, -1.5F, -10.5F, 3, 3, 11, 0.0F, true));

		gRightForearm = new RendererModel(this);
		gRightForearm.setRotationPoint(0.2F, 0.4F, -10.25F);
		gRightArm.addChild(gRightForearm);
		setRotationAngle(gRightForearm, -2.3562F, 0.0F, 0.0F);
		gRightForearm.cubeList.add(new ModelBox(gRightForearm, 50, 85, -1.7F, -0.3F, -1.4F, 3, 14, 3, -0.35F, true));

		gRightHand = new RendererModel(this);
		gRightHand.setRotationPoint(0.05F, 13.7F, 0.25F);
		gRightForearm.addChild(gRightHand);
		setRotationAngle(gRightHand, 0.3927F, 0.0F, 0.0F);
		gRightHand.cubeList.add(new ModelBox(gRightHand, 72, 24, -1.25F, -0.6F, -2.75F, 2, 1, 3, 0.0F, true));

		rClaw3_r1 = new RendererModel(this);
		rClaw3_r1.setRotationPoint(-0.25F, -0.2F, -1.25F);
		gRightHand.addChild(rClaw3_r1);
		setRotationAngle(rClaw3_r1, 0.0349F, 0.0F, 0.0F);
		rClaw3_r1.cubeList.add(new ModelBox(rClaw3_r1, 60, 38, -1.5F, 0.0F, -6.0F, 3, 0, 6, 0.0F, true));

		gLeftArm = new RendererModel(this);
		gLeftArm.setRotationPoint(4.9F, 3.9F, 3.6F);
		gChest.addChild(gLeftArm);
		setRotationAngle(gLeftArm, 1.9635F, 0.0F, 0.0F);
		gLeftArm.cubeList.add(new ModelBox(gLeftArm, 103, 6, -1.5F, -1.5F, -10.5F, 3, 3, 11, 0.0F, false));

		gLeftForearm = new RendererModel(this);
		gLeftForearm.setRotationPoint(-0.2F, 0.4F, -10.25F);
		gLeftArm.addChild(gLeftForearm);
		setRotationAngle(gLeftForearm, -2.3562F, 0.0F, 0.0F);
		gLeftForearm.cubeList.add(new ModelBox(gLeftForearm, 50, 85, -1.3F, -0.3F, -1.4F, 3, 14, 3, -0.35F, false));

		gLeftHand = new RendererModel(this);
		gLeftHand.setRotationPoint(-0.05F, 13.7F, 0.25F);
		gLeftForearm.addChild(gLeftHand);
		setRotationAngle(gLeftHand, 0.3927F, 0.0F, 0.0F);
		gLeftHand.cubeList.add(new ModelBox(gLeftHand, 72, 24, -0.75F, -0.6F, -2.75F, 2, 1, 3, 0.0F, false));

		rClaw4_r1 = new RendererModel(this);
		rClaw4_r1.setRotationPoint(0.25F, -0.2F, -1.25F);
		gLeftHand.addChild(rClaw4_r1);
		setRotationAngle(rClaw4_r1, 0.0349F, 0.0F, 0.0F);
		rClaw4_r1.cubeList.add(new ModelBox(rClaw4_r1, 60, 38, -1.5F, 0.0F, -6.0F, 3, 0, 6, 0.0F, false));

		gRightWingArm = new RendererModel(this);
		gRightWingArm.setRotationPoint(-4.3F, 0.2F, 4.3F);
		gChest.addChild(gRightWingArm);
		setRotationAngle(gRightWingArm, -0.7854F, 0.0F, -0.7854F);
		gRightWingArm.cubeList.add(new ModelBox(gRightWingArm, 134, 0, -1.0F, -9.0F, -1.5F, 2, 9, 3, -0.25F, false));

		gRightWingForearm = new RendererModel(this);
		gRightWingForearm.setRotationPoint(0.0F, -8.0F, 0.0F);
		gRightWingArm.addChild(gRightWingForearm);
		setRotationAngle(gRightWingForearm, 2.7489F, 0.0F, 0.0F);
		gRightWingForearm.cubeList.add(new ModelBox(gRightWingForearm, 149, 0, -0.5F, -1.0F, 0.0F, 1, 2, 10, 0.0F, false));

		gRightWingHand = new RendererModel(this);
		gRightWingHand.setRotationPoint(0.0F, 0.0F, 9.4F);
		gRightWingForearm.addChild(gRightWingHand);
		setRotationAngle(gRightWingHand, -1.5708F, 0.0F, 0.0F);
		gRightWingHand.cubeList.add(new ModelBox(gRightWingHand, 188, 8, 0.0F, 0.0F, 0.7F, 0, 15, 9, 0.0F, true));
		gRightWingHand.cubeList.add(new ModelBox(gRightWingHand, 174, 0, -0.5F, -1.1F, 0.0F, 1, 2, 9, -0.1F, false));

		gRightWingEnd = new RendererModel(this);
		gRightWingEnd.setRotationPoint(0.0F, 0.0F, 8.3F);
		gRightWingHand.addChild(gRightWingEnd);
		gRightWingEnd.cubeList.add(new ModelBox(gRightWingEnd, 208, 3, -0.1F, 0.0F, 1.4F, 0, 17, 14, 0.0F, true));
		gRightWingEnd.cubeList.add(new ModelBox(gRightWingEnd, 200, 0, -0.5F, -0.7F, 0.0F, 1, 1, 10, 0.0F, false));

		gLeftWingArm = new RendererModel(this);
		gLeftWingArm.setRotationPoint(4.3F, 0.2F, 4.3F);
		gChest.addChild(gLeftWingArm);
		setRotationAngle(gLeftWingArm, -0.7854F, 0.0F, 0.7854F);
		gLeftWingArm.cubeList.add(new ModelBox(gLeftWingArm, 134, 0, -1.0F, -9.0F, -1.5F, 2, 9, 3, -0.25F, true));

		gLeftWingForearm = new RendererModel(this);
		gLeftWingForearm.setRotationPoint(0.0F, -8.0F, 0.0F);
		gLeftWingArm.addChild(gLeftWingForearm);
		setRotationAngle(gLeftWingForearm, 2.7489F, 0.0F, 0.0F);
		gLeftWingForearm.cubeList.add(new ModelBox(gLeftWingForearm, 149, 0, -0.5F, -1.0F, 0.0F, 1, 2, 10, 0.0F, true));

		gLeftWingHand = new RendererModel(this);
		gLeftWingHand.setRotationPoint(0.0F, 0.0F, 9.4F);
		gLeftWingForearm.addChild(gLeftWingHand);
		setRotationAngle(gLeftWingHand, -1.5708F, 0.0F, 0.0F);
		gLeftWingHand.cubeList.add(new ModelBox(gLeftWingHand, 188, 8, 0.0F, 0.0F, 0.7F, 0, 15, 9, 0.0F, false));
		gLeftWingHand.cubeList.add(new ModelBox(gLeftWingHand, 174, 0, -0.5F, -1.1F, 0.0F, 1, 2, 9, -0.1F, true));

		gLeftWingEnd = new RendererModel(this);
		gLeftWingEnd.setRotationPoint(0.0F, 0.0F, 8.3F);
		gLeftWingHand.addChild(gLeftWingEnd);
		gLeftWingEnd.cubeList.add(new ModelBox(gLeftWingEnd, 208, 3, 0.1F, 0.0F, 1.4F, 0, 17, 14, 0.0F, false));
		gLeftWingEnd.cubeList.add(new ModelBox(gLeftWingEnd, 200, 0, -0.5F, -0.7F, 0.0F, 1, 1, 10, 0.0F, true));

		gStomach = new RendererModel(this);
		gStomach.setRotationPoint(0.0F, 3.5F, 11.85F);
		gChest.addChild(gStomach);
		gStomach.cubeList.add(new ModelBox(gStomach, 22, 65, 0.0F, -8.75F, -2.35F, 0, 6, 12, 0.0F, false));
		gStomach.cubeList.add(new ModelBox(gStomach, 0, 27, -3.5F, -3.0F, -2.25F, 7, 6, 12, 0.0F, false));

		gLeftThigh = new RendererModel(this);
		gLeftThigh.setRotationPoint(3.0F, 1.0F, 6.65F);
		gStomach.addChild(gLeftThigh);
		setRotationAngle(gLeftThigh, -0.3927F, 0.0F, 0.0F);
		gLeftThigh.cubeList.add(new ModelBox(gLeftThigh, 59, 45, -2.0F, -2.0F, -2.5F, 4, 14, 5, 0.0F, false));

		gLeftShin = new RendererModel(this);
		gLeftShin.setRotationPoint(0.0F, 11.5F, 0.0F);
		gLeftThigh.addChild(gLeftShin);
		gLeftShin.cubeList.add(new ModelBox(gLeftShin, 79, 33, -1.5F, -1.5F, -1.0F, 3, 3, 12, 0.0F, false));

		gLeftAnkle = new RendererModel(this);
		gLeftAnkle.setRotationPoint(0.2F, 0.0F, 10.9F);
		gLeftShin.addChild(gLeftAnkle);
		setRotationAngle(gLeftAnkle, -0.3927F, 0.0F, 0.0F);
		gLeftAnkle.cubeList.add(new ModelBox(gLeftAnkle, 113, 53, -1.0F, -0.2F, -1.1F, 2, 9, 2, 0.0F, false));

		gLeftFoot = new RendererModel(this);
		gLeftFoot.setRotationPoint(0.0F, 8.2F, 0.0F);
		gLeftAnkle.addChild(gLeftFoot);
		setRotationAngle(gLeftFoot, 0.7854F, 0.0F, 0.0F);
		gLeftFoot.cubeList.add(new ModelBox(gLeftFoot, 95, 24, -1.0F, -1.0F, -4.4F, 2, 2, 5, 0.1F, false));

		gRightThigh = new RendererModel(this);
		gRightThigh.setRotationPoint(-3.0F, 1.0F, 6.65F);
		gStomach.addChild(gRightThigh);
		setRotationAngle(gRightThigh, -0.3927F, 0.0F, 0.0F);
		gRightThigh.cubeList.add(new ModelBox(gRightThigh, 59, 45, -2.0F, -2.0F, -2.5F, 4, 14, 5, 0.0F, true));

		gRightShin = new RendererModel(this);
		gRightShin.setRotationPoint(0.0F, 11.5F, 0.0F);
		gRightThigh.addChild(gRightShin);
		gRightShin.cubeList.add(new ModelBox(gRightShin, 79, 33, -1.5F, -1.5F, -1.0F, 3, 3, 12, 0.0F, true));

		gRightAnkle = new RendererModel(this);
		gRightAnkle.setRotationPoint(-0.2F, 0.0F, 10.9F);
		gRightShin.addChild(gRightAnkle);
		setRotationAngle(gRightAnkle, -0.3927F, 0.0F, 0.0F);
		gRightAnkle.cubeList.add(new ModelBox(gRightAnkle, 113, 53, -1.0F, -0.2F, -1.1F, 2, 9, 2, 0.0F, true));

		gRightFoot = new RendererModel(this);
		gRightFoot.setRotationPoint(0.0F, 8.2F, 0.0F);
		gRightAnkle.addChild(gRightFoot);
		setRotationAngle(gRightFoot, 0.7854F, 0.0F, 0.0F);
		gRightFoot.cubeList.add(new ModelBox(gRightFoot, 95, 24, -1.0F, -1.0F, -4.4F, 2, 2, 5, 0.1F, true));

		gSack1 = new RendererModel(this);
		gSack1.setRotationPoint(0.0F, 1.7F, 5.85F);
		gStomach.addChild(gSack1);
		setRotationAngle(gSack1, -0.3927F, 0.0F, 0.0F);
		gSack1.cubeList.add(new ModelBox(gSack1, 0, 87, -2.0F, -2.0F, -0.5F, 4, 4, 5, 0.1F, false));

		gSack2 = new RendererModel(this);
		gSack2.setRotationPoint(0.0F, 0.2F, 4.5F);
		gSack1.addChild(gSack2);
		gSack2.cubeList.add(new ModelBox(gSack2, 0, 98, -3.5F, -3.0F, -0.3F, 7, 6, 6, 0.1F, false));

		gSack3 = new RendererModel(this);
		gSack3.setRotationPoint(0.0F, 0.5F, 4.75F);
		gSack2.addChild(gSack3);
		setRotationAngle(gSack3, 0.3927F, 0.0F, 0.0F);
		gSack3.cubeList.add(new ModelBox(gSack3, 0, 111, -5.0F, -4.5F, -0.5F, 10, 9, 8, 0.1F, false));

		gSack4 = new RendererModel(this);
		gSack4.setRotationPoint(0.0F, 0.2F, 7.7F);
		gSack3.addChild(gSack4);
		gSack4.cubeList.add(new ModelBox(gSack4, 84, 82, -5.5F, -5.0F, -0.1F, 11, 10, 11, 0.35F, false));

		gSack5 = new RendererModel(this);
		gSack5.setRotationPoint(0.0F, 0.1F, 10.7F);
		gSack4.addChild(gSack5);
		gSack5.cubeList.add(new ModelBox(gSack5, 132, 82, -4.5F, -5.0F, 0.1F, 9, 10, 10, 0.1F, false));

		gSack6 = new RendererModel(this);
		gSack6.setRotationPoint(0.0F, 0.0F, 10.0F);
		gSack5.addChild(gSack6);
		gSack6.cubeList.add(new ModelBox(gSack6, 177, 83, -3.5F, -4.0F, -0.1F, 7, 8, 9, 0.1F, false));

		gSack7 = new RendererModel(this);
		gSack7.setRotationPoint(-0.2F, 0.05F, 7.7F);
		gSack6.addChild(gSack7);
		setRotationAngle(gSack7, -0.3927F, 0.0F, 0.0F);
		gSack7.cubeList.add(new ModelBox(gSack7, 217, 90, -2.5F, -3.0F, 0.0F, 5, 6, 8, 0.1F, false));

		gSack8 = new RendererModel(this);
		gSack8.setRotationPoint(0.2F, -0.1F, 7.1F);
		gSack7.addChild(gSack8);
		setRotationAngle(gSack8, -0.7854F, 0.0F, 0.0F);
		gSack8.cubeList.add(new ModelBox(gSack8, 215, 108, -1.5F, -1.5F, -0.2F, 3, 3, 7, 0.1F, false));

		gTail1 = new RendererModel(this);
		gTail1.setRotationPoint(0.0F, 0.0F, 9.55F);
		gStomach.addChild(gTail1);
		gTail1.cubeList.add(new ModelBox(gTail1, 50, 66, -2.0F, -2.5F, 0.0F, 4, 4, 11, 0.0F, false));
		gTail1.cubeList.add(new ModelBox(gTail1, 58, 94, 0.0F, -5.5F, 0.0F, 0, 8, 11, 0.0F, false));

		gTail2 = new RendererModel(this);
		gTail2.setRotationPoint(0.0F, 0.0F, 11.0F);
		gTail1.addChild(gTail2);
		gTail2.cubeList.add(new ModelBox(gTail2, 85, 66, -2.0F, -2.5F, -0.1F, 4, 4, 11, -0.25F, false));
		gTail2.cubeList.add(new ModelBox(gTail2, 89, 94, 0.0F, -4.9F, -0.5F, 0, 8, 11, 0.0F, false));

		gTail3 = new RendererModel(this);
		gTail3.setRotationPoint(0.0F, -0.3F, 10.6F);
		gTail2.addChild(gTail3);
		gTail3.cubeList.add(new ModelBox(gTail3, 117, 94, 0.0F, -4.1F, 0.7F, 0, 6, 10, 0.0F, false));
		gTail3.cubeList.add(new ModelBox(gTail3, 118, 66, -1.5F, -1.8F, 0.0F, 3, 3, 11, 0.0F, false));

		gTail4 = new RendererModel(this);
		gTail4.setRotationPoint(0.0F, -0.3F, 10.9F);
		gTail3.addChild(gTail4);
		gTail4.cubeList.add(new ModelBox(gTail4, 148, 96, 0.0F, -5.5F, 0.9F, 0, 8, 10, 0.0F, false));
		gTail4.cubeList.add(new ModelBox(gTail4, 149, 66, -1.0F, -1.0F, 0.0F, 2, 2, 11, 0.25F, false));

		gTail5 = new RendererModel(this);
		gTail5.setRotationPoint(0.0F, 0.1F, 11.0F);
		gTail4.addChild(gTail5);
		gTail5.cubeList.add(new ModelBox(gTail5, 178, 96, 0.0F, -6.6F, -0.2F, 0, 8, 11, 0.0F, false));
		gTail5.cubeList.add(new ModelBox(gTail5, 178, 66, -0.5F, -0.7F, 0.0F, 1, 1, 11, 0.25F, false));

		gTailBlade = new RendererModel(this);
		gTailBlade.setRotationPoint(0.0F, -0.2F, 11.3F);
		gTail5.addChild(gTailBlade);
		gTailBlade.cubeList.add(new ModelBox(gTailBlade, 205, 66, 0.0F, -3.0F, -0.4F, 0, 6, 15, 0.0F, false));
	}

	@Override
	public void render(DracomorphEntity dracomorphEntity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}