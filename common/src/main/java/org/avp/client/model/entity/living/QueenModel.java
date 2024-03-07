package org.avp.client.model.entity.living;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Queen;

public class QueenModel extends EntityModel<Queen> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("queen"), "main");
	private final ModelPart root;

	public QueenModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 25.5F, 10.0F));

		PartDefinition gBody = root.addOrReplaceChild("gBody", CubeListBuilder.create(), PartPose.offset(0.0F, -31.2025F, -20.2555F));

		PartDefinition gWaist = gBody.addOrReplaceChild("gWaist", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, -0.3627F, -0.1511F, 7.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(185, 23).addBox(0.0F, -5.6235F, -1.3597F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7496F, 9.7602F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gTail1 = gWaist.addOrReplaceChild("gTail1", CubeListBuilder.create().texOffs(162, 24).addBox(0.0F, -5.7F, 0.1F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(175, 47).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0373F, 10.9489F, 0.1745F, 0.0F, 0.0F));

		PartDefinition gTail2 = gTail1.addOrReplaceChild("gTail2", CubeListBuilder.create().texOffs(139, 24).addBox(0.0F, -4.7F, 0.6F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(144, 47).addBox(-2.0F, -1.8F, -0.2F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, 10.25F, 0.2182F, 0.0F, 0.0F));

		PartDefinition gTail3 = gTail2.addOrReplaceChild("gTail3", CubeListBuilder.create().texOffs(118, 25).addBox(0.0259F, -4.0F, 1.392F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(115, 47).addBox(-1.5F, -1.5F, -0.2F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, 10.15F, 0.0873F, 0.0F, 0.0F));

		PartDefinition gTail4 = gTail3.addOrReplaceChild("gTail4", CubeListBuilder.create().texOffs(97, 25).addBox(-0.0259F, -3.7F, 1.1888F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(88, 47).addBox(-1.0F, -1.0F, -0.2F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, 10.4F, -0.0436F, 0.0F, 0.0F));

		PartDefinition gTail5 = gTail4.addOrReplaceChild("gTail5", CubeListBuilder.create().texOffs(74, 24).addBox(0.0F, -2.5F, -0.1173F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(63, 47).addBox(-0.5F, -0.9F, -0.2F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition gTail6 = gTail5.addOrReplaceChild("gTail6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 11.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r1 = gTail6.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(211, 0).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.4F, 0.0F, 0.0F, 1.5708F));

		PartDefinition gRightLeg = gWaist.addOrReplaceChild("gRightLeg", CubeListBuilder.create().texOffs(204, 0).mirror().addBox(-1.5F, -2.0F, -2.5F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 2.7373F, 8.4489F, -0.3927F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = gRightLeg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(176, 18).mirror().addBox(0.9F, -2.0F, -1.7F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.6716F, -3.7545F, -0.5283F, -0.0323F, 0.0F, -0.4189F));

		PartDefinition gRightShin = gRightLeg.addOrReplaceChild("gRightShin", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-1.0F, -1.5F, 0.6F, 3.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.8F, 1.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r3 = gRightShin.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(150, 17).mirror().addBox(0.0F, -0.5F, -4.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -4.4F, 10.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition gRightAnkle = gRightShin.addOrReplaceChild("gRightAnkle", CubeListBuilder.create().texOffs(148, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -0.5F, 14.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gRightFoot = gRightAnkle.addOrReplaceChild("gRightFoot", CubeListBuilder.create().texOffs(166, 0).mirror().addBox(-1.5F, -1.0F, -4.5F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.3927F, 0.0F, -0.3927F));

		PartDefinition gLeftLeg = gWaist.addOrReplaceChild("gLeftLeg", CubeListBuilder.create().texOffs(204, 0).addBox(-2.5F, -2.0F, -2.5F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 2.7373F, 8.4489F, -0.3927F, 0.0F, -0.3927F));

		PartDefinition cube_r4 = gLeftLeg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(176, 18).addBox(-0.9F, -2.0F, -1.7F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6716F, -3.7545F, -0.5283F, -0.0323F, 0.0F, 0.4189F));

		PartDefinition gLeftShin = gLeftLeg.addOrReplaceChild("gLeftShin", CubeListBuilder.create().texOffs(78, 0).addBox(-2.0F, -1.5F, 0.6F, 3.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.8F, 1.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r5 = gLeftShin.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(150, 17).addBox(0.0F, -0.5F, -4.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -4.4F, 10.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition gLeftAnkle = gLeftShin.addOrReplaceChild("gLeftAnkle", CubeListBuilder.create().texOffs(148, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 14.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gLeftFoot = gLeftAnkle.addOrReplaceChild("gLeftFoot", CubeListBuilder.create().texOffs(166, 0).addBox(-1.5F, -1.0F, -4.5F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.3927F, 0.0F, 0.3927F));

		PartDefinition gSack1 = gWaist.addOrReplaceChild("gSack1", CubeListBuilder.create().texOffs(229, 64).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9496F, 6.2398F, -0.7854F, 0.0F, 0.0F));

		PartDefinition gSack2 = gSack1.addOrReplaceChild("gSack2", CubeListBuilder.create().texOffs(192, 64).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1F, 4.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gSack3 = gSack2.addOrReplaceChild("gSack3", CubeListBuilder.create().texOffs(149, 64).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition gSack4 = gSack3.addOrReplaceChild("gSack4", CubeListBuilder.create().texOffs(104, 64).addBox(-5.5F, -7.5257F, -0.3916F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 10.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition gSack5 = gSack4.addOrReplaceChild("gSack5", CubeListBuilder.create().texOffs(63, 64).addBox(-4.5F, -4.5F, 0.0F, 9.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.1257F, 9.7084F, 0.0873F, 0.0F, 0.0F));

		PartDefinition gSack6 = gSack5.addOrReplaceChild("gSack6", CubeListBuilder.create().texOffs(223, 47).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition gSack7 = gSack6.addOrReplaceChild("gSack7", CubeListBuilder.create().texOffs(38, 75).addBox(-2.5F, -3.0F, 0.0F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 7.6F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gSack8 = gSack7.addOrReplaceChild("gSack8", CubeListBuilder.create().texOffs(42, 64).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition gChest = gBody.addOrReplaceChild("gChest", CubeListBuilder.create().texOffs(210, 25).addBox(0.0F, -6.4134F, -9.5002F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.5F, -1.4134F, -9.9002F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5866F, 9.9002F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r6 = gChest.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(248, -2).mirror().addBox(0.0F, -10.5F, -2.0F, 0.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.6976F, -7.3499F, -1.8436F, -0.2182F, 0.0F, -0.7854F));

		PartDefinition cube_r7 = gChest.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(234, 6).mirror().addBox(0.0F, -12.3F, -1.0F, 0.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.1373F, -6.5396F, -7.6048F, 0.1309F, 0.0F, -0.7854F));

		PartDefinition cube_r8 = gChest.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(249, 20).mirror().addBox(0.25F, -7.5F, -0.9F, 0.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0847F, -5.7371F, 0.8622F, -0.5236F, 0.0F, -0.7854F));

		PartDefinition cube_r9 = gChest.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(249, 20).addBox(-0.25F, -7.5F, -0.9F, 0.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0847F, -5.7371F, 0.8622F, -0.5236F, 0.0F, 0.7854F));

		PartDefinition cube_r10 = gChest.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(248, -2).addBox(0.0F, -10.5F, -2.0F, 0.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6976F, -7.3499F, -1.8436F, -0.2182F, 0.0F, 0.7854F));

		PartDefinition cube_r11 = gChest.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(234, 6).addBox(0.0F, -12.3F, -1.0F, 0.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1373F, -6.5396F, -7.6048F, 0.1309F, 0.0F, 0.7854F));

		PartDefinition gNeck = gChest.addOrReplaceChild("gNeck", CubeListBuilder.create().texOffs(0, 77).addBox(-2.0F, -1.6F, -4.8F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5866F, -9.9002F));

		PartDefinition gHead = gNeck.addOrReplaceChild("gHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -5.4F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = gHead.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(44, 19).addBox(-2.5F, 6.8754F, -9.0593F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5509F, 1.9083F, 0.5009F, 0.0F, 0.0F));

		PartDefinition gMouth = gHead.addOrReplaceChild("gMouth", CubeListBuilder.create().texOffs(19, 77).addBox(-1.5F, -0.1515F, -6.0463F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.2504F, 3.3961F, 0.9774F, 0.0F, 0.0F));

		PartDefinition gBottomJaw = gMouth.addOrReplaceChild("gBottomJaw", CubeListBuilder.create().texOffs(19, 90).addBox(-1.5F, -0.4F, -6.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.2485F, -0.0463F));

		PartDefinition gInnerJaw = gBottomJaw.addOrReplaceChild("gInnerJaw", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, -1.0F, -4.6F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.8F, -0.5F));

		PartDefinition gCrest = gHead.addOrReplaceChild("gCrest", CubeListBuilder.create().texOffs(19, 19).addBox(-3.5F, -0.4491F, -4.9083F, 7.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5509F, 1.9083F));

		PartDefinition cube_r13 = gCrest.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(112, 18).mirror().addBox(0.5392F, -7.5311F, -5.5453F, 0.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2754F, -0.3417F, 0.2931F));

		PartDefinition cube_r14 = gCrest.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(112, 18).addBox(-0.5392F, -7.5311F, -5.5453F, 0.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2754F, 0.3417F, -0.2931F));

		PartDefinition cube_r15 = gCrest.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(15, 70).addBox(-4.8692F, -3.1864F, -3.343F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1651F, 0.2482F, -0.1866F));

		PartDefinition cube_r16 = gCrest.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(44, 47).addBox(-4.8432F, -17.9811F, -4.9233F, 7.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3766F, 0.1865F, -0.3178F));

		PartDefinition cube_r17 = gCrest.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(15, 61).addBox(-2.0646F, -7.1994F, -4.2984F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3842F, 0.0099F, -0.873F));

		PartDefinition cube_r18 = gCrest.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 67).addBox(-8.4639F, -1.3102F, -3.1488F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1704F, -0.0626F, -0.8289F));

		PartDefinition cube_r19 = gCrest.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(15, 70).mirror().addBox(1.8692F, -3.1864F, -3.343F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1651F, -0.2482F, 0.1866F));

		PartDefinition cube_r20 = gCrest.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(44, 47).mirror().addBox(-2.1568F, -17.9811F, -4.9233F, 7.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3766F, -0.1865F, 0.3178F));

		PartDefinition cube_r21 = gCrest.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(15, 61).mirror().addBox(-1.9354F, -7.1994F, -4.2984F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3842F, -0.0099F, 0.873F));

		PartDefinition cube_r22 = gCrest.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(19, 36).addBox(-3.5F, -18.0994F, -4.7799F, 7.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2793F, 0.0F, 0.0F));

		PartDefinition cube_r23 = gCrest.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 67).mirror().addBox(3.4639F, -1.3102F, -3.1488F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1704F, 0.0626F, 0.8289F));

		PartDefinition cube_r24 = gCrest.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(112, 18).addBox(0.0F, -7.0473F, -4.9199F, 0.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3701F, 0.0F, 0.0F));

		PartDefinition gLeftArm = gChest.addOrReplaceChild("gLeftArm", CubeListBuilder.create().texOffs(76, 19).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.5F, 4.0866F, -6.4002F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild("gLeftForearm", CubeListBuilder.create().texOffs(96, 19).mirror().addBox(-0.99F, -1.0F, -10.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.5F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild("gLeftHand", CubeListBuilder.create().texOffs(204, 23).mirror().addBox(-1.55F, -0.2F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(85, 24).mirror().addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -10.5F));

		PartDefinition gRightArm = gChest.addOrReplaceChild("gRightArm", CubeListBuilder.create().texOffs(76, 19).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 4.0866F, -6.4002F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gRightForearm = gRightArm.addOrReplaceChild("gRightForearm", CubeListBuilder.create().texOffs(96, 19).addBox(-1.01F, -1.0F, -10.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gRightHand = gRightForearm.addOrReplaceChild("gRightHand", CubeListBuilder.create().texOffs(204, 23).addBox(-1.45F, -0.2F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(85, 24).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.5F));

		PartDefinition gLeftMiniArm = gChest.addOrReplaceChild("gLeftMiniArm", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -0.4F, -0.9F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 6.7865F, -4.9002F, 0.0F, 0.0F, 0.0F));

		PartDefinition gLeftMiniForearm = gLeftMiniArm.addOrReplaceChild("gLeftMiniForearm", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.3F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition gLeftMiniHand = gLeftMiniForearm.addOrReplaceChild("gLeftMiniHand", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.2F, 0.0F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 49).mirror().addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, 1.9635F, 0.0F, 0.0F));

		PartDefinition gRightMiniArm = gChest.addOrReplaceChild("gRightMiniArm", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-1.0F, -0.4F, -0.9F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 6.7865F, -4.9002F, 0.0F, 0.0F, 0.0F));

		PartDefinition gRightMiniForearm = gRightMiniArm.addOrReplaceChild("gRightMiniForearm", CubeListBuilder.create().texOffs(0, 34).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.3F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition gRightMiniHand = gRightMiniForearm.addOrReplaceChild("gRightMiniHand", CubeListBuilder.create().texOffs(0, 19).addBox(-1.8F, 0.0F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, 1.9635F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Queen entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}