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
import org.avp.common.entity.living.Ultramorph;

public class UltramorphModel extends EntityModel<Ultramorph> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("ultramorph"), "main");
	private final ModelPart root;

	public UltramorphModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 25.3F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition gBody = root.addOrReplaceChild("gBody", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -27.741F, 1.8727F, -0.7854F, 0.0F, 0.0F));

		PartDefinition gStomach = gBody.addOrReplaceChild("gStomach", CubeListBuilder.create().texOffs(23, 69).addBox(0.0F, -4.5343F, -1.0665F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(-3.5F, -3.0F, 0.0F, 7.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4422F, -1.2233F, 0.0F, 0.0F, 0.0F));

		PartDefinition gRightLeg = gStomach.addOrReplaceChild("gRightLeg", CubeListBuilder.create().texOffs(40, 45).mirror().addBox(-2.5F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 1.25F, 9.2131F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gRightShin = gRightLeg.addOrReplaceChild("gRightShin", CubeListBuilder.create().texOffs(79, 49).mirror().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 10.0494F, 1.1722F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gRightAnkle = gRightShin.addOrReplaceChild("gRightAnkle", CubeListBuilder.create().texOffs(113, 40).mirror().addBox(-1.0F, -0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.9F, 10.75F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gRightFoot = gRightAnkle.addOrReplaceChild("gRightFoot", CubeListBuilder.create().texOffs(110, 24).mirror().addBox(-1.0148F, -0.7635F, -3.9408F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0148F, 9.0635F, -0.0592F, 0.7854F, 0.3927F, 0.0F));

		PartDefinition gLeftLeg = gStomach.addOrReplaceChild("gLeftLeg", CubeListBuilder.create().texOffs(40, 45).addBox(-1.5F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.25F, 9.2131F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gLeftShin = gLeftLeg.addOrReplaceChild("gLeftShin", CubeListBuilder.create().texOffs(79, 49).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 10.0494F, 1.1722F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftAnkle = gLeftShin.addOrReplaceChild("gLeftAnkle", CubeListBuilder.create().texOffs(113, 40).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9F, 10.75F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftFoot = gLeftAnkle.addOrReplaceChild("gLeftFoot", CubeListBuilder.create().texOffs(110, 24).addBox(-0.9852F, -0.7635F, -3.9408F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0148F, 9.0635F, -0.0592F, 0.7854F, -0.3927F, 0.0F));

		PartDefinition gTail1 = gStomach.addOrReplaceChild("gTail1", CubeListBuilder.create().texOffs(58, 93).addBox(0.0F, -4.0F, -0.5F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(50, 66).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.05F, 12.0131F));

		PartDefinition gTail2 = gTail1.addOrReplaceChild("gTail2", CubeListBuilder.create().texOffs(90, 93).addBox(0.0F, -4.0F, -0.5F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(85, 66).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 10.36F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTail3 = gTail2.addOrReplaceChild("gTail3", CubeListBuilder.create().texOffs(117, 94).addBox(0.0F, -2.75F, -0.25F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(118, 66).addBox(-1.5F, -1.75F, -0.25F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.05F, 10.45F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTail4 = gTail3.addOrReplaceChild("gTail4", CubeListBuilder.create().texOffs(148, 96).addBox(0.0F, -2.0F, -0.25F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(149, 66).addBox(-1.0F, -1.0F, -0.25F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.65F, 10.7F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTail5 = gTail4.addOrReplaceChild("gTail5", CubeListBuilder.create().texOffs(178, 96).addBox(0.0F, -1.5F, 0.9F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(178, 66).addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, 10.85F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTailBlade = gTail5.addOrReplaceChild("gTailBlade", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.06F, 10.94F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r1 = gTailBlade.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(213, 64).addBox(0.0F, -10.5F, -1.5F, 0.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, -0.8F, -1.5708F, 0.0F, 0.0F));

		PartDefinition chest = gBody.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 46).addBox(-4.5F, -2.7078F, -10.1102F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gNeck = chest.addOrReplaceChild("gNeck", CubeListBuilder.create().texOffs(23, 86).mirror().addBox(-2.0F, -2.4F, -4.4F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.2922F, -10.1102F));

		PartDefinition gHead = gNeck.addOrReplaceChild("gHead", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -4.9F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.3F, -3.4F));

		PartDefinition cube_r2 = gHead.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 10).addBox(-2.5F, -44.6F, -14.9F, 5.0F, 10.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 32.3666F, -0.1143F, -0.2793F, 0.0F, 0.0F));

		PartDefinition gFace = gHead.addOrReplaceChild("gFace", CubeListBuilder.create(), PartPose.offset(0.0F, 4.8999F, -4.8862F));

		PartDefinition cube_r3 = gFace.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(53, 0).addBox(-0.35F, -27.7F, -15.6F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.01F))
		.texOffs(34, 0).addBox(-2.35F, -27.7F, -15.6F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-0.15F, 16.764F, 27.0595F, 0.5061F, 0.0F, 0.0F));

		PartDefinition gMouth = gFace.addOrReplaceChild("gMouth", CubeListBuilder.create().texOffs(52, 20).addBox(-1.5F, -0.5F, -2.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3195F, 3.6906F, 0.6981F, 0.0F, 0.0F));

		PartDefinition gLowerJaw = gMouth.addOrReplaceChild("gLowerJaw", CubeListBuilder.create().texOffs(88, 1).addBox(-1.5F, 0.4F, -4.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.0694F, 1.9957F, 0.0F, 0.0F, 0.0F));

		PartDefinition gInnerJaw = gLowerJaw.addOrReplaceChild("gInnerJaw", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -0.7F, -4.6F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.15F, 0.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition gRightArm = chest.addOrReplaceChild("gRightArm", CubeListBuilder.create().texOffs(40, 29).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.9922F, -6.5102F, 0.7854F, -0.3927F, 0.0F));

		PartDefinition gRightForearm = gRightArm.addOrReplaceChild("gRightForearm", CubeListBuilder.create().texOffs(71, 9).mirror().addBox(-1.0F, -1.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(0.0F, 11.9F, 0.0F));

		PartDefinition gRightHand = gRightForearm.addOrReplaceChild("gRightHand", CubeListBuilder.create().texOffs(60, 30).addBox(-1.45F, -0.05F, -6.45F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(83, 24).addBox(-1.05F, -0.45F, -3.05F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.05F, -0.45F, -10.85F));

		PartDefinition gLeftArm = chest.addOrReplaceChild("gLeftArm", CubeListBuilder.create().texOffs(40, 29).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 0.9922F, -6.5102F, 0.7854F, 0.3927F, 0.0F));

		PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild("gLeftForearm", CubeListBuilder.create().texOffs(71, 9).addBox(-1.0F, -1.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 11.9F, 0.0F));

		PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild("gLeftHand", CubeListBuilder.create().texOffs(60, 30).mirror().addBox(-1.55F, -0.05F, -6.45F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(83, 24).mirror().addBox(-0.95F, -0.45F, -3.05F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.05F, -0.45F, -10.85F));

		PartDefinition gBackSpines = chest.addOrReplaceChild("gBackSpines", CubeListBuilder.create(), PartPose.offset(0.0F, -4.2139F, -6.9333F));

		PartDefinition cube_r4 = gBackSpines.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(155, 25).mirror().addBox(-4.1351F, -0.1461F, -6.4604F, 2.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1613F, 0.3526F, -0.0557F));

		PartDefinition cube_r5 = gBackSpines.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(155, 25).addBox(2.1351F, -0.1461F, -6.4604F, 2.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1613F, -0.3526F, 0.0557F));

		PartDefinition cube_r6 = gBackSpines.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(9, 86).mirror().addBox(-1.0F, -3.5F, 2.7F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9454F, -1.4137F, 0.0232F, 0.2618F, 0.0F, 0.3927F));

		PartDefinition cube_r7 = gBackSpines.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(9, 86).mirror().addBox(-1.0F, -5.4F, -2.1F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.9454F, -1.4137F, 0.0232F, 0.3927F, 0.0F, 0.3927F));

		PartDefinition cube_r8 = gBackSpines.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(9, 86).addBox(-1.0F, -3.5F, 2.7F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9454F, -1.4137F, 0.0232F, 0.2618F, 0.0F, -0.3927F));

		PartDefinition cube_r9 = gBackSpines.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 86).addBox(-1.0F, -5.4F, -2.1F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9454F, -1.4137F, 0.0232F, 0.3927F, 0.0F, -0.3927F));

		PartDefinition cube_r10 = gBackSpines.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(190, 0).addBox(0.0F, -3.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1226F, -0.7079F, -2.1455F, -0.0905F, -0.1042F, 0.4382F));

		PartDefinition cube_r11 = gBackSpines.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(190, 0).addBox(0.0F, -3.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.27F, -1.2844F, -0.7458F, -0.0905F, -0.1042F, 0.4382F));

		PartDefinition cube_r12 = gBackSpines.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(190, 0).mirror().addBox(0.0F, -3.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.1226F, -0.7079F, -2.1455F, -0.0905F, 0.1042F, -0.4382F));

		PartDefinition cube_r13 = gBackSpines.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(190, 0).mirror().addBox(0.0F, -3.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.27F, -1.2844F, -0.7458F, -0.0905F, 0.1042F, -0.4382F));

		PartDefinition cube_r14 = gBackSpines.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 65).addBox(-0.2F, -6.5303F, -4.7113F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Ultramorph entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}