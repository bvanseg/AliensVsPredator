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
import org.avp.common.entity.living.Dracoburster;

public class DracobursterModel extends EntityModel<Dracoburster> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("dracoburster"), "main");
	private final ModelPart root;

	public DracobursterModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -8.6969F));

		PartDefinition gBody = root.addOrReplaceChild("gBody", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 8.6969F));

		PartDefinition abdomen = gBody.addOrReplaceChild("abdomen", CubeListBuilder.create().texOffs(0, 27).addBox(-3.5F, -1.0F, -2.25F, 7.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(23, 65).addBox(0.0F, -7.0F, -1.75F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 1.5531F));

		PartDefinition gRightLeg = abdomen.addOrReplaceChild("gRightLeg", CubeListBuilder.create().texOffs(61, 47).mirror().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 2.6F, 7.55F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gRightShin = gRightLeg.addOrReplaceChild("gRightShin", CubeListBuilder.create().texOffs(79, 33).mirror().addBox(-1.0F, -0.9F, -0.3F, 2.0F, 2.0F, 12.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.95F, 1.1F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gRightAnkle = gRightShin.addOrReplaceChild("gRightAnkle", CubeListBuilder.create().texOffs(113, 53).mirror().addBox(-1.0F, -0.2F, -1.1F, 2.0F, 9.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.2F, 10.85F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gRightFoot = gRightAnkle.addOrReplaceChild("gRightFoot", CubeListBuilder.create().texOffs(95, 24).mirror().addBox(-1.0F, -1.0F, -4.4F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftLeg = abdomen.addOrReplaceChild("gLeftLeg", CubeListBuilder.create().texOffs(61, 47).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 2.6F, 7.55F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftShin = gLeftLeg.addOrReplaceChild("gLeftShin", CubeListBuilder.create().texOffs(79, 33).addBox(-1.0F, -0.9F, -0.3F, 2.0F, 2.0F, 12.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 10.95F, 1.1F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftAnkle = gLeftShin.addOrReplaceChild("gLeftAnkle", CubeListBuilder.create().texOffs(113, 53).addBox(-1.0F, -0.2F, -1.1F, 2.0F, 9.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.2F, 10.85F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftFoot = gLeftAnkle.addOrReplaceChild("gLeftFoot", CubeListBuilder.create().texOffs(95, 24).addBox(-1.0F, -1.0F, -4.4F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTail1 = abdomen.addOrReplaceChild("gTail1", CubeListBuilder.create().texOffs(58, 93).addBox(0.0F, -4.7F, 0.0F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(50, 66).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 8.25F, -0.0087F, 0.0F, 0.0F));

		PartDefinition gTail2 = gTail1.addOrReplaceChild("gTail2", CubeListBuilder.create().texOffs(90, 93).addBox(0.0F, -4.5F, 0.2F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(85, 66).addBox(-2.0F, -2.5F, -0.1F, 4.0F, 4.0F, 11.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition gTail3 = gTail2.addOrReplaceChild("gTail3", CubeListBuilder.create().texOffs(118, 66).addBox(-1.5F, -1.8F, 0.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(116, 93).addBox(0.0F, -2.9F, 0.3F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.4F));

		PartDefinition gTail4 = gTail3.addOrReplaceChild("gTail4", CubeListBuilder.create().texOffs(149, 66).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(147, 95).addBox(0.0F, -2.1F, 0.1F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition gTail5 = gTail4.addOrReplaceChild("gTail5", CubeListBuilder.create().texOffs(177, 96).addBox(0.0F, -0.9F, 0.4F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(178, 66).addBox(-0.5F, -0.2F, 0.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition gTailClaw = gTail5.addOrReplaceChild("gTailClaw", CubeListBuilder.create().texOffs(205, 66).addBox(0.0F, -1.4F, 0.0F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.3F, 10.2F));

		PartDefinition gChest = root.addOrReplaceChild("gChest", CubeListBuilder.create().texOffs(0, 67).addBox(0.0F, -8.4F, -10.0F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-4.5F, -2.6F, -10.0F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1F, 10.0F));

		PartDefinition gNeck = gChest.addOrReplaceChild("gNeck", CubeListBuilder.create().texOffs(23, 86).addBox(-2.5F, -3.0F, -5.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 0.65F, -8.15F, -0.7854F, 0.0F, 0.0F));

		PartDefinition gNeckEnd = gNeck.addOrReplaceChild("gNeckEnd", CubeListBuilder.create().texOffs(23, 100).addBox(-1.5F, -2.0F, -2.8F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -4.4F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gHead = gNeckEnd.addOrReplaceChild("gHead", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0478F, -4.6654F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2F, -2.15F, -0.3927F, 0.0F, 0.0F));

		PartDefinition lHead_r1 = gHead.addOrReplaceChild("lHead_r1", CubeListBuilder.create().texOffs(53, 0).mirror().addBox(-2.05F, -1.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(53, 0).addBox(-0.55F, -1.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 4.6862F, -1.7621F, 0.6318F, 0.0F, 0.0F));

		PartDefinition headTop_r1 = gHead.addOrReplaceChild("headTop_r1", CubeListBuilder.create().texOffs(28, 10).addBox(-2.5F, -36.6F, -9.3F, 5.0F, 10.0F, 5.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 23.3983F, -4.3565F, -0.3187F, 0.0F, 0.0F));

		PartDefinition bone = gHead.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(52, 20).addBox(-1.6F, 10.0971F, -13.3638F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.2449F, -0.6016F, 0.7854F, 0.0F, 0.0F));

		PartDefinition jawLower = bone.addOrReplaceChild("jawLower", CubeListBuilder.create().texOffs(88, 1).addBox(-1.5F, -0.1F, -4.4F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 11.0971F, -9.0638F));

		PartDefinition gNinnerJaw = jawLower.addOrReplaceChild("gNinnerJaw", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -0.7F, -4.6F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.4F, 0.9F, -0.2182F, 0.0F, 0.0F));

		PartDefinition gRightArm = gChest.addOrReplaceChild("gRightArm", CubeListBuilder.create().texOffs(50, 29).mirror().addBox(-1.0F, -1.5F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, 2.0F, -6.4F));

		PartDefinition gRightForearm = gRightArm.addOrReplaceChild("gRightForearm", CubeListBuilder.create().texOffs(98, 9).mirror().addBox(-1.2F, -1.1F, -10.6F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.2F, 11.15F, 0.1F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gRightClaw = gRightForearm.addOrReplaceChild("gRightClaw", CubeListBuilder.create().texOffs(72, 24).mirror().addBox(-1.1F, 0.0F, -3.1F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, -0.1F, -9.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition rClaw3_r1 = gRightClaw.addOrReplaceChild("rClaw3_r1", CubeListBuilder.create().texOffs(60, 38).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 0.4F, -3.9F, 0.1745F, 0.0F, 0.0F));

		PartDefinition gLeftArm = gChest.addOrReplaceChild("gLeftArm", CubeListBuilder.create().texOffs(50, 29).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 2.0F, -6.4F));

		PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild("gLeftForearm", CubeListBuilder.create().texOffs(98, 9).addBox(-0.8F, -1.1F, -10.6F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.2F, 11.15F, 0.1F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gLeftClaw = gLeftForearm.addOrReplaceChild("gLeftClaw", CubeListBuilder.create().texOffs(72, 24).addBox(-0.9F, 0.0F, -3.1F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.1F, -9.8F, -0.7854F, 0.0F, 0.0F));

		PartDefinition rClaw4_r1 = gLeftClaw.addOrReplaceChild("rClaw4_r1", CubeListBuilder.create().texOffs(60, 38).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.4F, -3.9F, 0.1745F, 0.0F, 0.0F));

		PartDefinition gLeftWing = gChest.addOrReplaceChild("gLeftWing", CubeListBuilder.create().texOffs(133, 15).addBox(-1.0F, -7.8F, -0.9F, 2.0F, 9.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(3.9F, -2.5F, -6.4F, -0.7854F, 0.0F, 0.3927F));

		PartDefinition gLeftWingBone = gLeftWing.addOrReplaceChild("gLeftWingBone", CubeListBuilder.create().texOffs(143, 14).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.1F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition gLeftWingEnd = gLeftWingBone.addOrReplaceChild("gLeftWingEnd", CubeListBuilder.create().texOffs(162, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(166, 17).addBox(-0.5F, -0.6F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.1F, 7.9F, -1.5708F, 0.0F, 0.0F));

		PartDefinition gRightWing = gChest.addOrReplaceChild("gRightWing", CubeListBuilder.create().texOffs(133, 15).mirror().addBox(-1.0F, -7.8F, -0.9F, 2.0F, 9.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-3.9F, -2.5F, -6.4F, -0.7854F, 0.0F, -0.3927F));

		PartDefinition gRightWingBone = gRightWing.addOrReplaceChild("gRightWingBone", CubeListBuilder.create().texOffs(143, 14).mirror().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.1F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition gRightWingEnd = gRightWingBone.addOrReplaceChild("gRightWingEnd", CubeListBuilder.create().texOffs(162, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(166, 17).mirror().addBox(-0.5F, -0.6F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.1F, 7.9F, -1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Dracoburster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}