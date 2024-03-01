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
import org.avp.common.entity.living.Ovamorph;

public class OvamorphModel extends EntityModel<Ovamorph> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("ovamorph"), "main");
	private final ModelPart root;

	public OvamorphModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 18.0F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-2.5F, 19.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition gFrontLeftFlap = root.addOrReplaceChild("gFrontLeftFlap", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, 18.5F, -1.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition lFrontLobe4_r1 = gFrontLeftFlap.addOrReplaceChild("lFrontLobe4_r1", CubeListBuilder.create().texOffs(35, 12).mirror().addBox(-1.25F, -0.35F, -1.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3536F, -2.15F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition gFrontLeftFlapEnd = gFrontLeftFlap.addOrReplaceChild("gFrontLeftFlapEnd", CubeListBuilder.create(), PartPose.offset(0.0F, -1.4F, 0.0F));

		PartDefinition lFrontLobeChild_r1 = gFrontLeftFlapEnd.addOrReplaceChild("lFrontLobeChild_r1", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-1.25F, -1.65F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3536F, -0.75F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition gFrontRightFlap = root.addOrReplaceChild("gFrontRightFlap", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, 18.5F, -1.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition lFrontLobe5_r1 = gFrontRightFlap.addOrReplaceChild("lFrontLobe5_r1", CubeListBuilder.create().texOffs(35, 12).addBox(-1.75F, -0.35F, -1.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3536F, -2.15F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition gFrontRightFlapEnd = gFrontRightFlap.addOrReplaceChild("gFrontRightFlapEnd", CubeListBuilder.create(), PartPose.offset(0.0F, -1.4F, 0.0F));

		PartDefinition lFrontLobeChild_r2 = gFrontRightFlapEnd.addOrReplaceChild("lFrontLobeChild_r2", CubeListBuilder.create().texOffs(37, 0).addBox(-0.75F, -1.65F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3536F, -0.75F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition gBackRightFlap = root.addOrReplaceChild("gBackRightFlap", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, 18.5F, 1.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition lBackLobe6_r1 = gBackRightFlap.addOrReplaceChild("lBackLobe6_r1", CubeListBuilder.create().texOffs(35, 18).addBox(-1.75F, -0.35F, -1.25F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3536F, -2.15F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition gBackRightFlapEnd = gBackRightFlap.addOrReplaceChild("gBackRightFlapEnd", CubeListBuilder.create(), PartPose.offset(0.0F, -1.4F, 0.0F));

		PartDefinition lBackLobeChild_r1 = gBackRightFlapEnd.addOrReplaceChild("lBackLobeChild_r1", CubeListBuilder.create().texOffs(37, 6).addBox(-0.75F, -1.65F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3536F, -0.75F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition gBackLeftFlap = root.addOrReplaceChild("gBackLeftFlap", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, 18.5F, 1.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition lBackLobe7_r1 = gBackLeftFlap.addOrReplaceChild("lBackLobe7_r1", CubeListBuilder.create().texOffs(35, 18).mirror().addBox(-1.25F, -0.35F, -1.25F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3536F, -2.15F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition gBackLeftFlapEnd = gBackLeftFlap.addOrReplaceChild("gBackLeftFlapEnd", CubeListBuilder.create(), PartPose.offset(0.0F, -1.4F, 0.0F));

		PartDefinition lBackLobeChild_r2 = gBackLeftFlapEnd.addOrReplaceChild("lBackLobeChild_r2", CubeListBuilder.create().texOffs(37, 6).mirror().addBox(-1.25F, -1.65F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3536F, -0.75F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Ovamorph entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}