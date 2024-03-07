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
import org.avp.common.entity.living.Octohugger;

public class OctohuggerModel extends EntityModel<Octohugger> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("octohugger"), "main");
	private final ModelPart root;

	public OctohuggerModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition gBody = root.addOrReplaceChild("gBody", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, -2.275F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.5F, -1.225F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.15F)), PartPose.offset(0.0F, 16.275F, 0.0F));

		PartDefinition gUpperBody = gBody.addOrReplaceChild("gUpperBody", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -0.025F, 0.0F));

		PartDefinition gUpperBodyBase = gUpperBody.addOrReplaceChild("gUpperBodyBase", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -29.4F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 25.1F, 0.0F));

		PartDefinition gUpperBodyMiddle = gUpperBodyBase.addOrReplaceChild("gUpperBodyMiddle", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.75F, 0.0F));

		PartDefinition gUpperBodyEnd = gUpperBodyMiddle.addOrReplaceChild("gUpperBodyEnd", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -5.6F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition gSouthFlap = gBody.addOrReplaceChild("gSouthFlap", CubeListBuilder.create().texOffs(17, 12).addBox(-1.0F, 0.25F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.475F, 0.9F, 0.0F, 0.0F, 0.0F));

		PartDefinition gSouthFlapEnd = gSouthFlap.addOrReplaceChild("gSouthFlapEnd", CubeListBuilder.create().texOffs(17, 18).addBox(-0.5F, 0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gNorthFlap = gBody.addOrReplaceChild("gNorthFlap", CubeListBuilder.create().texOffs(17, 0).addBox(-1.0F, 0.25F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.475F, -0.9F, 0.0F, 0.0F, 0.0F));

		PartDefinition gNorthFlapEnd = gNorthFlap.addOrReplaceChild("gNorthFlapEnd", CubeListBuilder.create().texOffs(17, 5).addBox(-0.5F, 0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gEastFlap = gBody.addOrReplaceChild("gEastFlap", CubeListBuilder.create().texOffs(27, 0).mirror().addBox(-0.5F, 0.25F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.9F, 2.475F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gEastFlapEnd = gEastFlap.addOrReplaceChild("gEastFlapEnd", CubeListBuilder.create().texOffs(27, 6).mirror().addBox(-0.5F, 0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gWestFlap = gBody.addOrReplaceChild("gWestFlap", CubeListBuilder.create().texOffs(27, 0).addBox(-0.5F, 0.25F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 2.475F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition gWestFlapEnd = gWestFlap.addOrReplaceChild("gWestFlapEnd", CubeListBuilder.create().texOffs(27, 6).addBox(-0.5F, 0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Octohugger entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}