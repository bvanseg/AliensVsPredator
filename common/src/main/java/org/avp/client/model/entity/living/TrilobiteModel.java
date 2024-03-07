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
import org.avp.common.entity.living.Trilobite;

public class TrilobiteModel extends EntityModel<Trilobite> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("trilobite"), "main");
	private final ModelPart root;

	public TrilobiteModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 22.1F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(25, 0).addBox(-2.5F, -1.5F, 2.2F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.5F))
		.texOffs(1, 1).addBox(-3.0F, -0.9F, -3.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(1.0F))
		.texOffs(1, 0).addBox(-2.0F, -2.3F, -4.1F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -12.6F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(6, 6).addBox(-2.0F, -1.5F, -1.2F, 4.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.4467F, -3.6852F, 0.3054F, 0.0F, 0.0F));

		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(6, 5).addBox(-2.0F, -1.5F, -1.2F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -4.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition rFrontTenticle4_r1 = body.addOrReplaceChild("rFrontTenticle4_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-1.8F, -0.9F, -1.75F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(4.8F, 0.0F, 1.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition rFrontTenticle3_r1 = body.addOrReplaceChild("rFrontTenticle3_r1", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-2.2F, -0.9F, -1.75F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(-4.8F, 0.0F, 1.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition lowerBody_r1 = body.addOrReplaceChild("lowerBody_r1", CubeListBuilder.create().texOffs(26, 0).addBox(-1.5F, -0.4F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -1.3F, 4.2F, -0.0436F, 0.0F, 0.0F));

		PartDefinition gRightFrontFlapbase = body.addOrReplaceChild("gRightFrontFlapbase", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1332F, 0.0F, -2.6535F, 0.0F, -0.3927F, 0.0F));

		PartDefinition rFrontTenticle2_r1 = gRightFrontFlapbase.addOrReplaceChild("rFrontTenticle2_r1", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-1.7F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2668F, -0.1F, -0.5465F, 0.0F, 0.0F, -0.1309F));

		PartDefinition gRightFrontFlap = gRightFrontFlapbase.addOrReplaceChild("gRightFrontFlap", CubeListBuilder.create().texOffs(81, 37).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2332F, 0.9F, 0.3035F, 0.0F, 0.0F, -2.7489F));

		PartDefinition gLeftFrontFlapbase = body.addOrReplaceChild("gLeftFrontFlapbase", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1332F, 0.0F, -2.6535F, 0.0F, 0.3927F, 0.0F));

		PartDefinition rFrontTenticle3_r2 = gLeftFrontFlapbase.addOrReplaceChild("rFrontTenticle3_r2", CubeListBuilder.create().texOffs(0, 53).addBox(-2.3F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2668F, -0.1F, -0.5465F, 0.0F, 0.0F, 0.1309F));

		PartDefinition gLeftFrontFlap = gLeftFrontFlapbase.addOrReplaceChild("gLeftFrontFlap", CubeListBuilder.create().texOffs(81, 37).mirror().addBox(0.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.2332F, 0.9F, 0.3035F, 0.0F, 0.0F, 2.7489F));

		PartDefinition gLeftBackFlapbase = body.addOrReplaceChild("gLeftBackFlapbase", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1332F, 0.0F, 4.6535F, 0.0F, -0.3927F, 0.0F));

		PartDefinition rBackTenticle4_r1 = gLeftBackFlapbase.addOrReplaceChild("rBackTenticle4_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-2.55F, -1.0F, -2.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2668F, -0.1F, 0.5465F, 0.0F, 0.0F, 0.1309F));

		PartDefinition gLeftBackFlap = gLeftBackFlapbase.addOrReplaceChild("gLeftBackFlap", CubeListBuilder.create().texOffs(81, 37).mirror().addBox(0.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.2332F, 0.9F, -0.5535F, 0.0F, 0.0F, 2.7489F));

		PartDefinition gRightBackFlapbase = body.addOrReplaceChild("gRightBackFlapbase", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1332F, 0.0F, 4.6535F, 0.0F, 0.3927F, 0.0F));

		PartDefinition rBackTenticle5_r1 = gRightBackFlapbase.addOrReplaceChild("rBackTenticle5_r1", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-1.45F, -1.0F, -2.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2668F, -0.1F, 0.5465F, 0.0F, 0.0F, -0.1309F));

		PartDefinition gRightBackFlap = gRightBackFlapbase.addOrReplaceChild("gRightBackFlap", CubeListBuilder.create().texOffs(81, 37).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2332F, 0.9F, -0.5535F, 0.0F, 0.0F, -2.7489F));

		PartDefinition tailPetal = body.addOrReplaceChild("tailPetal", CubeListBuilder.create().texOffs(89, 50).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2F, 6.2F, -2.8513F, 0.0F, 0.0F));

		PartDefinition gTail1 = body.addOrReplaceChild("gTail1", CubeListBuilder.create().texOffs(60, 0).addBox(-1.5F, -1.0F, 0.55F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.15F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gTail2 = gTail1.addOrReplaceChild("gTail2", CubeListBuilder.create().texOffs(54, 7).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.55F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gTail3 = gTail2.addOrReplaceChild("gTail3", CubeListBuilder.create().texOffs(56, 18).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTail4 = gTail3.addOrReplaceChild("gTail4", CubeListBuilder.create().texOffs(56, 28).addBox(-1.5F, -1.0F, -0.25F, 3.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.95F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTail5 = gTail4.addOrReplaceChild("gTail5", CubeListBuilder.create().texOffs(56, 38).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.45F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTailClaw = gTail5.addOrReplaceChild("gTailClaw", CubeListBuilder.create().texOffs(57, 49).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition gFrontRightTentacleInner = body.addOrReplaceChild("gFrontRightTentacleInner", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-7.0F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-5.1531F, -0.05F, -3.9925F, 0.2849F, -0.274F, -0.8249F));

		PartDefinition gFrontRightTentacleMiddle = gFrontRightTentacleInner.addOrReplaceChild("gFrontRightTentacleMiddle", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-5.85F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.05F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gFrontRightTentacleOuter = gFrontRightTentacleMiddle.addOrReplaceChild("gFrontRightTentacleOuter", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(-5.75F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-5.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gFrontRightTentacleEnd = gFrontRightTentacleOuter.addOrReplaceChild("gFrontRightTentacleEnd", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-7.0F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.45F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition gFrontRightTentacleClaw = gFrontRightTentacleEnd.addOrReplaceChild("gFrontRightTentacleClaw", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-4.8F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition gFrontLeftTentacleInner = body.addOrReplaceChild("gFrontLeftTentacleInner", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(5.1531F, -0.05F, -3.9925F, 0.2849F, 0.274F, 0.8249F));

		PartDefinition gFrontLeftTentacleMiddle = gFrontLeftTentacleInner.addOrReplaceChild("gFrontLeftTentacleMiddle", CubeListBuilder.create().texOffs(0, 22).addBox(-0.15F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gFrontLeftTentacleOuter = gFrontLeftTentacleMiddle.addOrReplaceChild("gFrontLeftTentacleOuter", CubeListBuilder.create().texOffs(0, 28).addBox(-0.25F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.8F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gFrontLeftTentacleEnd = gFrontLeftTentacleOuter.addOrReplaceChild("gFrontLeftTentacleEnd", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.45F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition gFrontLeftTentacleClaw = gFrontLeftTentacleEnd.addOrReplaceChild("gFrontLeftTentacleClaw", CubeListBuilder.create().texOffs(0, 39).addBox(-0.2F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, 0.0F));

		PartDefinition gMiddleRightTentacleInner = body.addOrReplaceChild("gMiddleRightTentacleInner", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-7.0F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-6.7F, -0.05F, 0.75F, 0.0F, 0.0F, -0.7854F));

		PartDefinition gMiddleRightTentacleMiddle = gMiddleRightTentacleInner.addOrReplaceChild("gMiddleRightTentacleMiddle", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-5.85F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.05F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gMiddleRightTentacleOuter = gMiddleRightTentacleMiddle.addOrReplaceChild("gMiddleRightTentacleOuter", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(-5.8F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-5.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gMiddleRightTentacleEnd = gMiddleRightTentacleOuter.addOrReplaceChild("gMiddleRightTentacleEnd", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-7.0F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition gMiddleRightTentacleClaw = gMiddleRightTentacleEnd.addOrReplaceChild("gMiddleRightTentacleClaw", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-4.8F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition gMiddleLeftTentacleInner = body.addOrReplaceChild("gMiddleLeftTentacleInner", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(6.7F, -0.05F, 0.75F, 0.0F, 0.0F, 0.7854F));

		PartDefinition gMiddleLeftTentacleMiddle = gMiddleLeftTentacleInner.addOrReplaceChild("gMiddleLeftTentacleMiddle", CubeListBuilder.create().texOffs(0, 22).addBox(-0.15F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gMiddleLeftTentacleOuter = gMiddleLeftTentacleMiddle.addOrReplaceChild("gMiddleLeftTentacleOuter", CubeListBuilder.create().texOffs(0, 28).addBox(-0.2F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.75F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gMiddleLeftTentacleEnd = gMiddleLeftTentacleOuter.addOrReplaceChild("gMiddleLeftTentacleEnd", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition gMiddleLeftTentacleClaw = gMiddleLeftTentacleEnd.addOrReplaceChild("gMiddleLeftTentacleClaw", CubeListBuilder.create().texOffs(0, 39).addBox(-0.2F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, 0.0F));

		PartDefinition gBackRightTentacleInner = body.addOrReplaceChild("gBackRightTentacleInner", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-7.0F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-5.2858F, -0.15F, 5.0686F, -0.2849F, 0.274F, -0.8249F));

		PartDefinition gBackRightTentacleMiddle = gBackRightTentacleInner.addOrReplaceChild("gBackRightTentacleMiddle", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-5.85F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.05F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gBackRightTentacleOuter = gBackRightTentacleMiddle.addOrReplaceChild("gBackRightTentacleOuter", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(-5.8F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(-5.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gBackRightTentacleEnd = gBackRightTentacleOuter.addOrReplaceChild("gBackRightTentacleEnd", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-7.0F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition gBackRightTentacleClaw = gBackRightTentacleEnd.addOrReplaceChild("gBackRightTentacleClaw", CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-4.8F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition gBackLeftTentacleInner = body.addOrReplaceChild("gBackLeftTentacleInner", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(5.2858F, -0.15F, 5.0686F, -0.2849F, -0.274F, 0.8249F));

		PartDefinition gBackLeftTentacleMiddle = gBackLeftTentacleInner.addOrReplaceChild("gBackLeftTentacleMiddle", CubeListBuilder.create().texOffs(0, 22).addBox(-0.15F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gBackLeftTentacleOuter = gBackLeftTentacleMiddle.addOrReplaceChild("gBackLeftTentacleOuter", CubeListBuilder.create().texOffs(0, 28).addBox(-0.2F, -1.0F, -1.5F, 6.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.75F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gBackLeftTentacleEnd = gBackLeftTentacleOuter.addOrReplaceChild("gBackLeftTentacleEnd", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -0.5F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition gBackLeftTentacleClaw = gBackLeftTentacleEnd.addOrReplaceChild("gBackLeftTentacleClaw", CubeListBuilder.create().texOffs(0, 39).addBox(-0.2F, 0.0F, -1.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, 0.0F));

		PartDefinition gLeftJaw = body.addOrReplaceChild("gLeftJaw", CubeListBuilder.create(), PartPose.offset(0.95F, 0.9F, 0.5F));

		PartDefinition lJaw_r1 = gLeftJaw.addOrReplaceChild("lJaw_r1", CubeListBuilder.create().texOffs(5, 48).addBox(-0.5F, -0.3977F, -0.066F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.6477F, -0.266F, 0.1309F, 0.0F, 0.0F));

		PartDefinition lJaw_r2 = gLeftJaw.addOrReplaceChild("lJaw_r2", CubeListBuilder.create().texOffs(5, 48).addBox(-0.5F, -0.3977F, -1.934F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.6477F, -0.266F, -0.0873F, 0.0F, 0.0F));

		PartDefinition gRightJaw = body.addOrReplaceChild("gRightJaw", CubeListBuilder.create(), PartPose.offset(-0.95F, 0.9F, 0.5F));

		PartDefinition lJaw_r3 = gRightJaw.addOrReplaceChild("lJaw_r3", CubeListBuilder.create().texOffs(5, 48).mirror().addBox(-0.5F, -0.3977F, -0.066F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2F, 0.6477F, -0.266F, 0.1309F, 0.0F, 0.0F));

		PartDefinition lJaw_r4 = gRightJaw.addOrReplaceChild("lJaw_r4", CubeListBuilder.create().texOffs(5, 48).mirror().addBox(-0.5F, -0.3977F, -1.934F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.2F, 0.6477F, -0.266F, -0.0873F, 0.0F, 0.0F));

		PartDefinition gRightMiddleFlap = body.addOrReplaceChild("gRightMiddleFlap", CubeListBuilder.create().texOffs(81, 37).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, 0.9F, 0.8F, 0.0F, 0.0F, -2.7489F));

		PartDefinition gLeftMiddleFlap = body.addOrReplaceChild("gLeftMiddleFlap", CubeListBuilder.create().texOffs(81, 37).mirror().addBox(0.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.9F, 0.9F, 0.8F, 0.0F, 0.0F, 2.7489F));

		PartDefinition gRightFrontSmallTube = body.addOrReplaceChild("gRightFrontSmallTube", CubeListBuilder.create().texOffs(92, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.4F, 0.4F, -2.0F));

		PartDefinition gMainToob1 = body.addOrReplaceChild("gMainToob1", CubeListBuilder.create().texOffs(92, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.95F, 0.15F));

		PartDefinition gLeftFrontSmallTube = body.addOrReplaceChild("gLeftFrontSmallTube", CubeListBuilder.create().texOffs(92, 6).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.4F, 0.4F, -2.0F));

		PartDefinition gRightMiddleSmallTube = body.addOrReplaceChild("gRightMiddleSmallTube", CubeListBuilder.create().texOffs(92, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.7F, 0.4F, 1.1F));

		PartDefinition gLeftMiddleSmallTube = body.addOrReplaceChild("gLeftMiddleSmallTube", CubeListBuilder.create().texOffs(92, 6).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.7F, 0.4F, 1.1F));

		PartDefinition gRightBackSmallTube = body.addOrReplaceChild("gRightBackSmallTube", CubeListBuilder.create().texOffs(92, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.4F, 3.9F));

		PartDefinition gLeftBackSmallTube = body.addOrReplaceChild("gLeftBackSmallTube", CubeListBuilder.create().texOffs(92, 6).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 0.4F, 3.9F));

		PartDefinition gBackSmallTube2 = body.addOrReplaceChild("gBackSmallTube2", CubeListBuilder.create().texOffs(92, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.3F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Trilobite entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}