package org.covenant.client.model.entity.living;
// Made with Blockbench 4.7.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import org.covenant.common.entity.living.EntityKetterBird;

public class ModelKetterBird extends Model<EntityKetterBird> {
	private final ModelRenderer root;
	private final ModelRenderer body;
	private final ModelRenderer chest;
	private final ModelRenderer neck01;
	private final ModelRenderer neck02;
	private final ModelRenderer head;
	private final ModelRenderer upperBeak01;
	private final ModelRenderer upperBeak02L;
	private final ModelRenderer upperBeak02R;
	private final ModelRenderer lowerBeak;
	private final ModelRenderer neckFeathers02;
	private final ModelRenderer neckFeathers01;
	private final ModelRenderer neckFeathers01_r1;
	private final ModelRenderer rArm01;
	private final ModelRenderer rArm02;
	private final ModelRenderer rArm02b;
	private final ModelRenderer rArmFeathers;
	private final ModelRenderer rArmFeathers_r1;
	private final ModelRenderer bone;
	private final ModelRenderer rClaw03a;
	private final ModelRenderer rClaw03b;
	private final ModelRenderer rClaw02a;
	private final ModelRenderer rClaw02b;
	private final ModelRenderer rClaw01a;
	private final ModelRenderer rClaw01b;
	private final ModelRenderer rArm2;
	private final ModelRenderer rArm3;
	private final ModelRenderer rArm02b2;
	private final ModelRenderer rArmFeathers2;
	private final ModelRenderer rArmFeathers_r2;
	private final ModelRenderer bone4;
	private final ModelRenderer rClaw03a2;
	private final ModelRenderer rClaw03b2;
	private final ModelRenderer rClaw02a2;
	private final ModelRenderer rClaw02b2;
	private final ModelRenderer rClaw01a2;
	private final ModelRenderer rClaw01b2;
	private final ModelRenderer feathers01;
	private final ModelRenderer rLeg01;
	private final ModelRenderer rLeg02_r1;
	private final ModelRenderer bone2;
	private final ModelRenderer rLeg02;
	private final ModelRenderer rFoot;
	private final ModelRenderer rToe01;
	private final ModelRenderer rToe02;
	private final ModelRenderer rToe03;
	private final ModelRenderer rToe04;
	private final ModelRenderer rLegFeathers;
	private final ModelRenderer rLegFeathers_r1;
	private final ModelRenderer rLeg2;
	private final ModelRenderer rLeg03_r1;
	private final ModelRenderer bone3;
	private final ModelRenderer rLeg3;
	private final ModelRenderer rFoot2;
	private final ModelRenderer rToe2;
	private final ModelRenderer rToe3;
	private final ModelRenderer rToe4;
	private final ModelRenderer rToe5;
	private final ModelRenderer rLegFeathers2;
	private final ModelRenderer rLegFeathers_r2;
	private final ModelRenderer tail;
	private final ModelRenderer bone5;
	private final ModelRenderer tail_r1;
	private final ModelRenderer bone7;
	private final ModelRenderer tail_r2;
	private final ModelRenderer bone6;
	private final ModelRenderer tail2;
	private final ModelRenderer tail4;
	private final ModelRenderer tail_r3;
	private final ModelRenderer tail3;
	private final ModelRenderer tail_r4;
	private final ModelRenderer feathers02;

	public ModelKetterBird() {
		textureWidth = 64;
		textureHeight = 64;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 13.4F, 0.0F);
		root.addChild(body);
		setRotationAngle(body, -0.0911F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -3.5F, -3.0F, 0.0F, 7, 6, 7, 0.0F, false));

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, -0.3F, -0.2F);
		body.addChild(chest);
		setRotationAngle(chest, 0.182F, 0.0F, 0.0F);
		chest.cubeList.add(new ModelBox(chest, 0, 14, -3.0F, -2.6F, -4.0F, 6, 5, 5, 0.0F, false));

		neck01 = new ModelRenderer(this);
		neck01.setRotationPoint(0.0F, 0.1F, -3.4F);
		chest.addChild(neck01);
		setRotationAngle(neck01, -0.5463F, 0.0F, 0.0F);
		neck01.cubeList.add(new ModelBox(neck01, 28, 0, -2.0F, -2.5F, -3.0F, 4, 4, 3, 0.0F, false));

		neck02 = new ModelRenderer(this);
		neck02.setRotationPoint(0.0F, -0.6F, -2.3F);
		neck01.addChild(neck02);
		setRotationAngle(neck02, -0.2276F, 0.0F, 0.0F);
		neck02.cubeList.add(new ModelBox(neck02, 28, 9, -1.5F, -1.5F, -4.0F, 3, 3, 4, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -0.6F, -2.8F);
		neck02.addChild(head);
		setRotationAngle(head, 0.8196F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 28, 21, -2.0F, -1.5F, -4.0F, 4, 3, 4, 0.0F, false));

		upperBeak01 = new ModelRenderer(this);
		upperBeak01.setRotationPoint(0.0F, 0.0F, -4.1F);
		head.addChild(upperBeak01);
		upperBeak01.cubeList.add(new ModelBox(upperBeak01, 13, 28, -0.6F, -0.5F, -4.4F, 1, 1, 5, 0.0F, false));

		upperBeak02L = new ModelRenderer(this);
		upperBeak02L.setRotationPoint(-0.7F, 0.2F, 0.2F);
		upperBeak01.addChild(upperBeak02L);
		setRotationAngle(upperBeak02L, 0.0F, -0.182F, 0.0F);
		upperBeak02L.cubeList.add(new ModelBox(upperBeak02L, 26, 30, -0.5F, -0.5F, -2.9F, 1, 1, 3, 0.0F, false));

		upperBeak02R = new ModelRenderer(this);
		upperBeak02R.setRotationPoint(0.5F, 0.2F, 0.2F);
		upperBeak01.addChild(upperBeak02R);
		setRotationAngle(upperBeak02R, 0.0F, 0.182F, 0.0F);
		upperBeak02R.cubeList.add(new ModelBox(upperBeak02R, 26, 30, -0.5F, -0.5F, -2.9F, 1, 1, 3, 0.0F, true));

		lowerBeak = new ModelRenderer(this);
		lowerBeak.setRotationPoint(0.0F, 0.6F, -3.9F);
		head.addChild(lowerBeak);
		setRotationAngle(lowerBeak, -0.0911F, 0.0F, 0.0F);
		lowerBeak.cubeList.add(new ModelBox(lowerBeak, 18, 36, -0.6F, -0.5F, -3.9F, 1, 1, 4, 0.0F, false));

		neckFeathers02 = new ModelRenderer(this);
		neckFeathers02.setRotationPoint(0.0F, 1.0F, -1.7F);
		neck02.addChild(neckFeathers02);
		setRotationAngle(neckFeathers02, 0.2276F, 0.0F, 0.0F);
		neckFeathers02.cubeList.add(new ModelBox(neckFeathers02, 50, 32, -1.0F, 0.0F, -1.5F, 2, 2, 3, 0.0F, false));

		neckFeathers01 = new ModelRenderer(this);
		neckFeathers01.setRotationPoint(0.0F, 0.8F, -1.4F);
		neck01.addChild(neckFeathers01);
		setRotationAngle(neckFeathers01, 0.1367F, 0.0F, 0.0F);
		

		neckFeathers01_r1 = new ModelRenderer(this);
		neckFeathers01_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		neckFeathers01.addChild(neckFeathers01_r1);
		setRotationAngle(neckFeathers01_r1, 0.0F, 3.1416F, 0.0F);
		neckFeathers01_r1.cubeList.add(new ModelBox(neckFeathers01_r1, 37, 32, -1.5F, -1.0F, -1.5F, 3, 2, 3, 0.0F, false));

		rArm01 = new ModelRenderer(this);
		rArm01.setRotationPoint(-4.0F, -0.4F, -2.0F);
		chest.addChild(rArm01);
		setRotationAngle(rArm01, 0.1707F, 0.0F, 0.2731F);
		rArm01.cubeList.add(new ModelBox(rArm01, 46, 0, 0.0F, -0.8F, -1.0F, 2, 4, 2, 0.0F, true));

		rArm02 = new ModelRenderer(this);
		rArm02.setRotationPoint(1.3F, 2.9F, 0.0F);
		rArm01.addChild(rArm02);
		setRotationAngle(rArm02, -1.0585F, 0.0F, -0.1367F);
		rArm02.cubeList.add(new ModelBox(rArm02, 46, 7, -0.5F, 0.0F, -0.6F, 1, 4, 1, 0.0F, true));

		rArm02b = new ModelRenderer(this);
		rArm02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rArm02.addChild(rArm02b);
		rArm02b.cubeList.add(new ModelBox(rArm02b, 51, 7, -0.51F, 0.0F, -0.1F, 1, 4, 1, 0.0F, true));

		rArmFeathers = new ModelRenderer(this);
		rArmFeathers.setRotationPoint(0.1F, -2.4F, 0.5F);
		rArm02.addChild(rArmFeathers);
		setRotationAngle(rArmFeathers, 1.1771F, -0.4279F, -0.0013F);
		

		rArmFeathers_r1 = new ModelRenderer(this);
		rArmFeathers_r1.setRotationPoint(-0.5F, 2.009F, -2.5816F);
		rArmFeathers.addChild(rArmFeathers_r1);
		setRotationAngle(rArmFeathers_r1, 2.0071F, 0.0F, 0.0F);
		rArmFeathers_r1.cubeList.add(new ModelBox(rArmFeathers_r1, 54, 40, 0.0F, -2.0F, -1.0F, 0, 4, 2, 0.0F, true));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.01F, 3.7F, -0.2F);
		rArm02.addChild(bone);
		setRotationAngle(bone, 0.8607F, 0.4F, -0.2727F);
		

		rClaw03a = new ModelRenderer(this);
		rClaw03a.setRotationPoint(-0.01F, -0.2F, 0.6F);
		bone.addChild(rClaw03a);
		setRotationAngle(rClaw03a, -0.1367F, 0.0F, -0.3187F);
		rClaw03a.cubeList.add(new ModelBox(rClaw03a, 46, 14, -0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F, true));

		rClaw03b = new ModelRenderer(this);
		rClaw03b.setRotationPoint(0.0F, 1.7F, -0.1F);
		rClaw03a.addChild(rClaw03b);
		setRotationAngle(rClaw03b, 0.5918F, 0.0F, 0.0F);
		rClaw03b.cubeList.add(new ModelBox(rClaw03b, 52, 14, -0.49F, -0.2F, -0.5F, 1, 2, 1, 0.0F, true));

		rClaw02a = new ModelRenderer(this);
		rClaw02a.setRotationPoint(-0.01F, -0.2F, 0.6F);
		bone.addChild(rClaw02a);
		setRotationAngle(rClaw02a, -0.1367F, 0.0F, 0.3187F);
		rClaw02a.cubeList.add(new ModelBox(rClaw02a, 46, 14, -0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F, true));

		rClaw02b = new ModelRenderer(this);
		rClaw02b.setRotationPoint(0.0F, 1.7F, -0.1F);
		rClaw02a.addChild(rClaw02b);
		setRotationAngle(rClaw02b, 0.5918F, 0.0F, 0.0F);
		rClaw02b.cubeList.add(new ModelBox(rClaw02b, 52, 14, -0.49F, -0.2F, -0.5F, 1, 2, 1, 0.0F, true));

		rClaw01a = new ModelRenderer(this);
		rClaw01a.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(rClaw01a);
		setRotationAngle(rClaw01a, -0.4554F, 0.0F, 0.0F);
		rClaw01a.cubeList.add(new ModelBox(rClaw01a, 46, 14, -0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F, true));

		rClaw01b = new ModelRenderer(this);
		rClaw01b.setRotationPoint(0.0F, 1.7F, -0.1F);
		rClaw01a.addChild(rClaw01b);
		setRotationAngle(rClaw01b, 0.5918F, 0.0F, 0.0F);
		rClaw01b.cubeList.add(new ModelBox(rClaw01b, 52, 14, -0.49F, -0.2F, -0.5F, 1, 2, 1, 0.0F, true));

		rArm2 = new ModelRenderer(this);
		rArm2.setRotationPoint(4.0F, -0.4F, -2.0F);
		chest.addChild(rArm2);
		setRotationAngle(rArm2, 0.1707F, 0.0F, -0.2731F);
		rArm2.cubeList.add(new ModelBox(rArm2, 46, 0, -2.0F, -0.8F, -1.0F, 2, 4, 2, 0.0F, false));

		rArm3 = new ModelRenderer(this);
		rArm3.setRotationPoint(-1.3F, 2.9F, 0.0F);
		rArm2.addChild(rArm3);
		setRotationAngle(rArm3, -1.0585F, 0.0F, 0.1367F);
		rArm3.cubeList.add(new ModelBox(rArm3, 46, 7, -0.5F, 0.0F, -0.6F, 1, 4, 1, 0.0F, false));

		rArm02b2 = new ModelRenderer(this);
		rArm02b2.setRotationPoint(0.0F, 0.0F, 0.0F);
		rArm3.addChild(rArm02b2);
		rArm02b2.cubeList.add(new ModelBox(rArm02b2, 51, 7, -0.49F, 0.0F, -0.1F, 1, 4, 1, 0.0F, false));

		rArmFeathers2 = new ModelRenderer(this);
		rArmFeathers2.setRotationPoint(-0.1F, -2.4F, 0.5F);
		rArm3.addChild(rArmFeathers2);
		setRotationAngle(rArmFeathers2, 1.1771F, 0.4279F, 0.0013F);
		

		rArmFeathers_r2 = new ModelRenderer(this);
		rArmFeathers_r2.setRotationPoint(0.5F, 2.009F, -2.5816F);
		rArmFeathers2.addChild(rArmFeathers_r2);
		setRotationAngle(rArmFeathers_r2, 2.0071F, 0.0F, 0.0F);
		rArmFeathers_r2.cubeList.add(new ModelBox(rArmFeathers_r2, 54, 40, 0.0F, -2.0F, -1.0F, 0, 4, 2, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-0.01F, 3.7F, -0.2F);
		rArm3.addChild(bone4);
		setRotationAngle(bone4, 0.8607F, -0.4F, 0.2727F);
		

		rClaw03a2 = new ModelRenderer(this);
		rClaw03a2.setRotationPoint(0.01F, -0.2F, 0.6F);
		bone4.addChild(rClaw03a2);
		setRotationAngle(rClaw03a2, -0.1367F, 0.0F, 0.3187F);
		rClaw03a2.cubeList.add(new ModelBox(rClaw03a2, 46, 14, -0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F, false));

		rClaw03b2 = new ModelRenderer(this);
		rClaw03b2.setRotationPoint(0.0F, 1.7F, -0.1F);
		rClaw03a2.addChild(rClaw03b2);
		setRotationAngle(rClaw03b2, 0.5918F, 0.0F, 0.0F);
		rClaw03b2.cubeList.add(new ModelBox(rClaw03b2, 52, 14, -0.51F, -0.2F, -0.5F, 1, 2, 1, 0.0F, false));

		rClaw02a2 = new ModelRenderer(this);
		rClaw02a2.setRotationPoint(0.01F, -0.2F, 0.6F);
		bone4.addChild(rClaw02a2);
		setRotationAngle(rClaw02a2, -0.1367F, 0.0F, -0.3187F);
		rClaw02a2.cubeList.add(new ModelBox(rClaw02a2, 46, 14, -0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F, false));

		rClaw02b2 = new ModelRenderer(this);
		rClaw02b2.setRotationPoint(0.0F, 1.7F, -0.1F);
		rClaw02a2.addChild(rClaw02b2);
		setRotationAngle(rClaw02b2, 0.5918F, 0.0F, 0.0F);
		rClaw02b2.cubeList.add(new ModelBox(rClaw02b2, 52, 14, -0.51F, -0.2F, -0.5F, 1, 2, 1, 0.0F, false));

		rClaw01a2 = new ModelRenderer(this);
		rClaw01a2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(rClaw01a2);
		setRotationAngle(rClaw01a2, -0.4554F, 0.0F, 0.0F);
		rClaw01a2.cubeList.add(new ModelBox(rClaw01a2, 46, 14, -0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F, false));

		rClaw01b2 = new ModelRenderer(this);
		rClaw01b2.setRotationPoint(0.0F, 1.7F, -0.1F);
		rClaw01a2.addChild(rClaw01b2);
		setRotationAngle(rClaw01b2, 0.5918F, 0.0F, 0.0F);
		rClaw01b2.cubeList.add(new ModelBox(rClaw01b2, 52, 14, -0.51F, -0.2F, -0.5F, 1, 2, 1, 0.0F, false));

		feathers01 = new ModelRenderer(this);
		feathers01.setRotationPoint(0.0F, 1.6F, -2.0F);
		chest.addChild(feathers01);
		setRotationAngle(feathers01, -0.0911F, 0.0F, 0.0F);
		feathers01.cubeList.add(new ModelBox(feathers01, 28, 40, -2.5F, 0.0F, -2.0F, 5, 2, 4, 0.0F, false));

		rLeg01 = new ModelRenderer(this);
		rLeg01.setRotationPoint(-4.9434F, -0.0372F, 6.1048F);
		body.addChild(rLeg01);
		setRotationAngle(rLeg01, 1.0111F, 0.0F, 0.0911F);
		

		rLeg02_r1 = new ModelRenderer(this);
		rLeg02_r1.setRotationPoint(0.3865F, -0.2958F, -3.124F);
		rLeg01.addChild(rLeg02_r1);
		setRotationAngle(rLeg02_r1, 1.3526F, 0.0F, 0.0F);
		rLeg02_r1.cubeList.add(new ModelBox(rLeg02_r1, 0, 33, -1.75F, -2.0F, -1.5F, 3, 6, 4, 0.0F, true));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.4865F, 3.0905F, -3.8282F);
		rLeg01.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 1, 34, -1.6F, -5.5F, -1.9F, 3, 6, 3, 0.0F, true));

		rLeg02 = new ModelRenderer(this);
		rLeg02.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(rLeg02);
		setRotationAngle(rLeg02, -1.4493F, 0.0F, -0.0911F);
		rLeg02.cubeList.add(new ModelBox(rLeg02, 0, 44, -1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, true));

		rFoot = new ModelRenderer(this);
		rFoot.setRotationPoint(0.0F, 4.3F, 0.4F);
		rLeg02.addChild(rFoot);
		setRotationAngle(rFoot, 0.5294F, 0.0F, 0.0F);
		rFoot.cubeList.add(new ModelBox(rFoot, 0, 52, -1.5F, 0.0F, -1.7F, 3, 1, 2, 0.0F, true));

		rToe01 = new ModelRenderer(this);
		rToe01.setRotationPoint(0.8F, 0.3F, -1.2F);
		rFoot.addChild(rToe01);
		setRotationAngle(rToe01, 0.1367F, -0.2731F, 0.0F);
		rToe01.cubeList.add(new ModelBox(rToe01, 0, 56, -0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F, true));

		rToe02 = new ModelRenderer(this);
		rToe02.setRotationPoint(0.0F, 0.3F, -1.8F);
		rFoot.addChild(rToe02);
		setRotationAngle(rToe02, 0.1367F, 0.0F, 0.0F);
		rToe02.cubeList.add(new ModelBox(rToe02, 0, 56, -0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F, true));

		rToe03 = new ModelRenderer(this);
		rToe03.setRotationPoint(-0.8F, 0.3F, -1.2F);
		rFoot.addChild(rToe03);
		setRotationAngle(rToe03, 0.1367F, 0.2731F, 0.0F);
		rToe03.cubeList.add(new ModelBox(rToe03, 0, 56, -0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F, true));

		rToe04 = new ModelRenderer(this);
		rToe04.setRotationPoint(-0.3F, 3.0F, 0.5F);
		rLeg02.addChild(rToe04);
		setRotationAngle(rToe04, 0.5918F, 0.0F, 0.0F);
		rToe04.cubeList.add(new ModelBox(rToe04, 9, 56, -0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F, true));

		rLegFeathers = new ModelRenderer(this);
		rLegFeathers.setRotationPoint(0.2F, -1.5F, 1.1F);
		bone2.addChild(rLegFeathers);
		setRotationAngle(rLegFeathers, 0.0456F, 0.0F, 0.0F);
		

		rLegFeathers_r1 = new ModelRenderer(this);
		rLegFeathers_r1.setRotationPoint(-1.0F, 1.5683F, -0.48F);
		rLegFeathers.addChild(rLegFeathers_r1);
		setRotationAngle(rLegFeathers_r1, 2.8362F, 0.0F, 0.0F);
		rLegFeathers_r1.cubeList.add(new ModelBox(rLegFeathers_r1, 11, 46, 0.75F, -1.0F, -1.5F, 0, 3, 3, 0.0F, true));

		rLeg2 = new ModelRenderer(this);
		rLeg2.setRotationPoint(4.9434F, -0.0372F, 6.1048F);
		body.addChild(rLeg2);
		setRotationAngle(rLeg2, 1.0111F, 0.0F, -0.0911F);
		

		rLeg03_r1 = new ModelRenderer(this);
		rLeg03_r1.setRotationPoint(-0.3865F, -0.2958F, -3.124F);
		rLeg2.addChild(rLeg03_r1);
		setRotationAngle(rLeg03_r1, 1.3526F, 0.0F, 0.0F);
		rLeg03_r1.cubeList.add(new ModelBox(rLeg03_r1, 0, 33, -1.25F, -2.0F, -1.5F, 3, 6, 4, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.4865F, 3.0905F, -3.8282F);
		rLeg2.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 1, 34, -1.4F, -5.5F, -1.9F, 3, 6, 3, 0.0F, false));

		rLeg3 = new ModelRenderer(this);
		rLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(rLeg3);
		setRotationAngle(rLeg3, -1.4493F, 0.0F, 0.0911F);
		rLeg3.cubeList.add(new ModelBox(rLeg3, 0, 44, -1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false));

		rFoot2 = new ModelRenderer(this);
		rFoot2.setRotationPoint(0.0F, 4.3F, 0.4F);
		rLeg3.addChild(rFoot2);
		setRotationAngle(rFoot2, 0.5294F, 0.0F, 0.0F);
		rFoot2.cubeList.add(new ModelBox(rFoot2, 0, 52, -1.5F, 0.0F, -1.7F, 3, 1, 2, 0.0F, false));

		rToe2 = new ModelRenderer(this);
		rToe2.setRotationPoint(-0.8F, 0.3F, -1.2F);
		rFoot2.addChild(rToe2);
		setRotationAngle(rToe2, 0.1367F, 0.2731F, 0.0F);
		rToe2.cubeList.add(new ModelBox(rToe2, 0, 56, -0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F, false));

		rToe3 = new ModelRenderer(this);
		rToe3.setRotationPoint(0.0F, 0.3F, -1.8F);
		rFoot2.addChild(rToe3);
		setRotationAngle(rToe3, 0.1367F, 0.0F, 0.0F);
		rToe3.cubeList.add(new ModelBox(rToe3, 0, 56, -0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F, false));

		rToe4 = new ModelRenderer(this);
		rToe4.setRotationPoint(0.8F, 0.3F, -1.2F);
		rFoot2.addChild(rToe4);
		setRotationAngle(rToe4, 0.1367F, -0.2731F, 0.0F);
		rToe4.cubeList.add(new ModelBox(rToe4, 0, 56, -0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F, false));

		rToe5 = new ModelRenderer(this);
		rToe5.setRotationPoint(0.3F, 3.0F, 0.5F);
		rLeg3.addChild(rToe5);
		setRotationAngle(rToe5, 0.5918F, 0.0F, 0.0F);
		rToe5.cubeList.add(new ModelBox(rToe5, 9, 56, -0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F, false));

		rLegFeathers2 = new ModelRenderer(this);
		rLegFeathers2.setRotationPoint(-0.2F, -1.5F, 1.1F);
		bone3.addChild(rLegFeathers2);
		setRotationAngle(rLegFeathers2, 0.0456F, 0.0F, 0.0F);
		

		rLegFeathers_r2 = new ModelRenderer(this);
		rLegFeathers_r2.setRotationPoint(1.0F, 1.5683F, -0.48F);
		rLegFeathers2.addChild(rLegFeathers_r2);
		setRotationAngle(rLegFeathers_r2, 2.8362F, 0.0F, 0.0F);
		rLegFeathers_r2.cubeList.add(new ModelBox(rLegFeathers_r2, 11, 46, -0.75F, -1.0F, -1.5F, 0, 3, 3, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -2.0F, 6.2F);
		body.addChild(tail);
		setRotationAngle(tail, -0.2731F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 26, -1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-2.0169F, -0.2223F, 3.6676F);
		tail.addChild(bone5);
		

		tail_r1 = new ModelRenderer(this);
		tail_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(tail_r1);
		setRotationAngle(tail_r1, -0.0152F, -0.6033F, -0.3645F);
		tail_r1.cubeList.add(new ModelBox(tail_r1, 13, 46, -1.0F, 0.25F, -3.0F, 2, 0, 6, 0.0F, true));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(2.0169F, -0.2223F, 3.6676F);
		tail.addChild(bone7);
		

		tail_r2 = new ModelRenderer(this);
		tail_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(tail_r2);
		setRotationAngle(tail_r2, -0.0152F, 0.6033F, 0.3645F);
		tail_r2.cubeList.add(new ModelBox(tail_r2, 13, 46, -1.0F, 0.25F, -3.0F, 2, 0, 6, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(2.0169F, -0.2223F, 3.6676F);
		tail.addChild(bone6);
		

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail.addChild(tail2);
		setRotationAngle(tail2, -0.2731F, 0.0F, 0.0F);
		tail2.cubeList.add(new ModelBox(tail2, 0, 26, -1.0F, -1.7722F, 2.619F, 2, 2, 3, 0.0F, false));

		tail4 = new ModelRenderer(this);
		tail4.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail2.addChild(tail4);
		setRotationAngle(tail4, -0.2731F, 0.0F, 0.0F);
		

		tail_r3 = new ModelRenderer(this);
		tail_r3.setRotationPoint(-1.5F, -1.9723F, 5.1826F);
		tail4.addChild(tail_r3);
		setRotationAngle(tail_r3, 0.1244F, -0.1473F, -0.4907F);
		tail_r3.cubeList.add(new ModelBox(tail_r3, 13, 46, -0.5F, 0.0F, -3.0F, 2, 0, 6, 0.0F, true));

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 0.0F, 0.0F);
		tail2.addChild(tail3);
		setRotationAngle(tail3, -0.2731F, 0.0F, 0.0F);
		

		tail_r4 = new ModelRenderer(this);
		tail_r4.setRotationPoint(1.5F, -1.9723F, 5.1826F);
		tail3.addChild(tail_r4);
		setRotationAngle(tail_r4, 0.1244F, 0.1473F, 0.4907F);
		tail_r4.cubeList.add(new ModelBox(tail_r4, 13, 46, -1.5F, 0.0F, -3.0F, 2, 0, 6, 0.0F, false));

		feathers02 = new ModelRenderer(this);
		feathers02.setRotationPoint(0.0F, 2.6F, 2.8F);
		body.addChild(feathers02);
		setRotationAngle(feathers02, -0.0456F, 0.0F, 0.0F);
		feathers02.cubeList.add(new ModelBox(feathers02, 28, 48, -3.0F, 0.0F, -2.9F, 6, 2, 7, 0.0F, false));
	}

	@Override
	public void render(EntityKetterBird entityKetterBird) {
		draw(root);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}