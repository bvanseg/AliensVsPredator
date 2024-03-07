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
import org.avp.common.entity.living.Belugaburster;

public class BelugabursterModel extends EntityModel<Belugaburster> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("belugaburster"), "main");
	private final ModelPart root;

	public BelugabursterModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition gChest = root.addOrReplaceChild("gChest", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 15.0732F, 0.7476F, -0.1367F, 0.0F, 0.0F));

		PartDefinition cube_r1 = gChest.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.5F, -11.1F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.6418F, -2.8513F, -0.3187F, 0.0F, 0.0F));

		PartDefinition gNeck = gChest.addOrReplaceChild("gNeck", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -3.3F, -1.6F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5856F, 0.7673F));

		PartDefinition gNeckEnd = gNeck.addOrReplaceChild("gNeckEnd", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, -2.9F, -2.1F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.3F, 0.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition gHead = gNeckEnd.addOrReplaceChild("gHead", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, -0.8F, -5.4F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.45F, 0.25F, -1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r2 = gHead.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 42).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9595F, -1.2855F, -0.093F, 0.0F, 0.0F));

		PartDefinition cube_r3 = gHead.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(22, 25).addBox(-1.5F, -18.3F, -9.6F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.4844F, 4.8482F, 0.4098F, 0.0F, 0.0F));

		PartDefinition cube_r4 = gHead.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 34).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5176F, -4.6277F, 0.0456F, 0.0F, 0.0F));

		PartDefinition cube_r5 = gHead.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 15).addBox(-2.0F, -22.5F, -10.1F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.061F, 11.1772F, 1.1837F, 0.0F, 0.0F));

		PartDefinition cube_r6 = gHead.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -17.7F, -10.5F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.4804F, 7.1085F, 0.5918F, 0.0F, 0.0F));

		PartDefinition gMouth = gHead.addOrReplaceChild("gMouth", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.8596F, -9.3916F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gUpperJaw = gMouth.addOrReplaceChild("gUpperJaw", CubeListBuilder.create().texOffs(25, 49).addBox(-1.0F, 0.1F, -1.4F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.7469F, -0.5021F));

		PartDefinition gJaw = gMouth.addOrReplaceChild("gJaw", CubeListBuilder.create().texOffs(25, 55).addBox(-1.0F, -0.4F, -2.05F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.3F, 0.15F));

		PartDefinition gLowerBody = gChest.addOrReplaceChild("gLowerBody", CubeListBuilder.create().texOffs(0, 49).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.8144F, -0.5327F));

		PartDefinition gWaist = gLowerBody.addOrReplaceChild("gWaist", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.2F, -0.8F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0715F, -0.7775F, 0.1367F, 0.0F, 0.0F));

		PartDefinition RightTail = gWaist.addOrReplaceChild("RightTail", CubeListBuilder.create().texOffs(47, 2).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.8F, 2.2F, 6.0F));

		PartDefinition RightTailBase = RightTail.addOrReplaceChild("RightTailBase", CubeListBuilder.create().texOffs(47, 12).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition RightTailMiddle = RightTailBase.addOrReplaceChild("RightTailMiddle", CubeListBuilder.create().texOffs(47, 22).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 5.0F));

		PartDefinition RightTailEnd = RightTailMiddle.addOrReplaceChild("RightTailEnd", CubeListBuilder.create().texOffs(47, 29).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition gLeftTail = gWaist.addOrReplaceChild("gLeftTail", CubeListBuilder.create().texOffs(47, 2).mirror().addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.8F, 2.2F, 6.0F));

		PartDefinition gLeftTailBase = gLeftTail.addOrReplaceChild("gLeftTailBase", CubeListBuilder.create().texOffs(47, 12).mirror().addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gLeftTailMiddle = gLeftTailBase.addOrReplaceChild("gLeftTailMiddle", CubeListBuilder.create().texOffs(47, 22).mirror().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.5F, 5.0F));

		PartDefinition gLeftTailEnd = gLeftTailMiddle.addOrReplaceChild("gLeftTailEnd", CubeListBuilder.create().texOffs(47, 29).mirror().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition gRightArmBase = gChest.addOrReplaceChild("gRightArmBase", CubeListBuilder.create().texOffs(70, 0).addBox(0.0F, 0.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4531F, -0.5712F, 0.3204F, -0.3054F, 0.0F, -0.0873F));

		PartDefinition gRightArm = gRightArmBase.addOrReplaceChild("gRightArm", CubeListBuilder.create().texOffs(71, 7).addBox(-0.5F, 0.0F, -0.9F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, -0.1F, 0.2182F, 0.0F, 0.0873F));

		PartDefinition gRightArmFrontMiddle = gRightArm.addOrReplaceChild("gRightArmFrontMiddle", CubeListBuilder.create().texOffs(70, 14).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.1F, 0.2182F, 0.0F, 0.0F));

		PartDefinition gRightArmMiddle = gRightArmFrontMiddle.addOrReplaceChild("gRightArmMiddle", CubeListBuilder.create().texOffs(71, 21).addBox(-0.534F, -3.9801F, -0.9503F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.034F, -0.0497F, 3.0199F, -1.5708F, 0.0F, 0.0F));

		PartDefinition gRightArmBackMiddle = gRightArmMiddle.addOrReplaceChild("gRightArmBackMiddle", CubeListBuilder.create().texOffs(71, 29).addBox(-0.534F, -4.9801F, -0.4503F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0076F, -4.0F, 0.5F));

		PartDefinition gRightArmEnd = gRightArmBackMiddle.addOrReplaceChild("gRightArmEnd", CubeListBuilder.create().texOffs(71, 29).addBox(-0.5261F, -4.9804F, -0.4606F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0086F, -4.9991F, 0.0113F));

		PartDefinition gLeftArmBase = gChest.addOrReplaceChild("gLeftArmBase", CubeListBuilder.create().texOffs(70, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4531F, -0.5712F, 0.3204F, -0.3054F, 0.0F, 0.0873F));

		PartDefinition gLeftArm = gLeftArmBase.addOrReplaceChild("gLeftArm", CubeListBuilder.create().texOffs(71, 7).mirror().addBox(-0.5F, 0.0F, -0.9F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 5.0F, -0.1F, 0.2182F, 0.0F, -0.0873F));

		PartDefinition gLeftArmFrontMiddle = gLeftArm.addOrReplaceChild("gLeftArmFrontMiddle", CubeListBuilder.create().texOffs(70, 14).mirror().addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.0F, 0.1F, 0.2182F, 0.0F, 0.0F));

		PartDefinition gLeftArmMiddle = gLeftArmFrontMiddle.addOrReplaceChild("gLeftArmMiddle", CubeListBuilder.create().texOffs(71, 21).mirror().addBox(-0.466F, -3.9801F, -0.9503F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.034F, -0.0497F, 3.0199F, -1.5708F, 0.0F, 0.0F));

		PartDefinition gLeftArmBackMiddle = gLeftArmMiddle.addOrReplaceChild("gLeftArmBackMiddle", CubeListBuilder.create().texOffs(71, 29).mirror().addBox(-0.466F, -4.9801F, -0.4503F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0076F, -4.0F, 0.5F));

		PartDefinition gLeftArmEnd = gLeftArmBackMiddle.addOrReplaceChild("gLeftArmEnd", CubeListBuilder.create().texOffs(71, 29).mirror().addBox(-0.4739F, -4.9804F, -0.4606F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0086F, -4.9991F, 0.0113F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Belugaburster entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}