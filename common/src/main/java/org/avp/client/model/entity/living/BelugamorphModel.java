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
import org.avp.common.entity.living.Belugamorph;

public class BelugamorphModel extends EntityModel<Belugamorph> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("belugamorph"), "main");
	private final ModelPart root;

	public BelugamorphModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.1F, 2.0F));

		PartDefinition gChest = root.addOrReplaceChild("gChest", CubeListBuilder.create().texOffs(37, 50).addBox(-0.5F, -5.9F, 3.3F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-4.0F, -9.0F, -3.5F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -32.2F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gNeck = gChest.addOrReplaceChild("gNeck", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.2F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -8.7F, 0.0F));

		PartDefinition gHead = gNeck.addOrReplaceChild("gHead", CubeListBuilder.create().texOffs(20, 0).addBox(-1.5423F, -1.5868F, 3.0814F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 20).addBox(-2.5423F, -3.4868F, -3.2186F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0423F, -3.7132F, -0.1814F));

		PartDefinition chest_r1 = gHead.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(106, 19).mirror().addBox(-2.5F, -44.3F, -6.65F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0423F, 41.7679F, -11.144F, -0.2731F, 0.0F, 0.0F));

		PartDefinition chest_r2 = gHead.addOrReplaceChild("chest_r2", CubeListBuilder.create().texOffs(101, 27).addBox(-2.3F, -46.9F, -7.55F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(117, 27).addBox(1.35F, -46.9F, -7.55F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 38.054F, 21.2849F, 0.4554F, 0.0F, 0.0F));

		PartDefinition chest_r3 = gHead.addOrReplaceChild("chest_r3", CubeListBuilder.create().texOffs(104, 53).addBox(-2.5F, -48.7F, -3.7F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 45.2116F, -6.8461F, -0.1365F, 0.0F, 0.0F));

		PartDefinition chest_r4 = gHead.addOrReplaceChild("chest_r4", CubeListBuilder.create().texOffs(101, 9).addBox(-2.65F, -48.6F, -5.1F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 37.492F, 22.2538F, 0.5009F, 0.0F, 0.0F));

		PartDefinition chest_r5 = gHead.addOrReplaceChild("chest_r5", CubeListBuilder.create().texOffs(112, 9).addBox(-1.35F, -48.6F, -5.1F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 37.492F, 22.2538F, 0.5009F, 0.0F, 0.0F));

		PartDefinition chest_r6 = gHead.addOrReplaceChild("chest_r6", CubeListBuilder.create().texOffs(28, 14).addBox(-0.5F, -45.61F, 10.1F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 43.5665F, -6.237F, -0.1367F, 0.0F, 0.0F));

		PartDefinition chest_r7 = gHead.addOrReplaceChild("chest_r7", CubeListBuilder.create().texOffs(59, 52).addBox(-1.0F, -47.2F, 9.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 40.8929F, -11.9853F, -0.2733F, 0.0F, 0.0F));

		PartDefinition chest_r8 = gHead.addOrReplaceChild("chest_r8", CubeListBuilder.create().texOffs(24, 7).addBox(-1.0F, -46.31F, 7.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 43.3597F, -6.1002F, -0.1367F, 0.0F, 0.0F));

		PartDefinition chest_r9 = gHead.addOrReplaceChild("chest_r9", CubeListBuilder.create().texOffs(59, 44).addBox(-1.5F, -47.2F, 7.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 42.6859F, -8.0817F, -0.1822F, 0.0F, 0.0F));

		PartDefinition chest_r10 = gHead.addOrReplaceChild("chest_r10", CubeListBuilder.create().texOffs(58, 34).addBox(-2.0F, -47.5F, 3.3F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 43.3348F, -6.0546F, -0.1367F, 0.0F, 0.0F));

		PartDefinition gLowerJaw = gHead.addOrReplaceChild("gLowerJaw", CubeListBuilder.create().texOffs(110, 45).mirror().addBox(-2.2F, -0.1F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(94, 45).mirror().addBox(-1.6F, -0.1F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3577F, 0.5951F, -2.393F, 0.0115F, 0.0F, 0.0F));

		PartDefinition gLowerInnerJaw = gLowerJaw.addOrReplaceChild("gLowerInnerJaw", CubeListBuilder.create().texOffs(81, 57).addBox(-1.5F, -0.8F, -0.8F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4F, -0.3F, -2.1F));

		PartDefinition gUpperJaw = gHead.addOrReplaceChild("gUpperJaw", CubeListBuilder.create().texOffs(104, 36).addBox(-2.0F, -2.1F, -5.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0423F, 1.063F, -0.5407F, -0.0454F, 0.0F, 0.0F));

		PartDefinition gUpperInnerJaw = gUpperJaw.addOrReplaceChild("gUpperInnerJaw", CubeListBuilder.create().texOffs(87, 50).addBox(-0.25F, -0.8F, -1.69F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(73, 50).addBox(-2.55F, -0.8F, -1.69F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 0.15F, -3.11F));

		PartDefinition gSmallDorsalTube = gChest.addOrReplaceChild("gSmallDorsalTube", CubeListBuilder.create().texOffs(1, 51).addBox(-1.0F, -1.0F, -0.4F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.5F, -8.3F, 2.7F, 0.2391F, 0.0F, 0.0F));

		PartDefinition quill2AChild_r1 = gSmallDorsalTube.addOrReplaceChild("quill2AChild_r1", CubeListBuilder.create().texOffs(13, 50).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.1978F, 3.6409F, -0.222F, 0.0F, 0.0F));

		PartDefinition quill2C_r1 = gSmallDorsalTube.addOrReplaceChild("quill2C_r1", CubeListBuilder.create().texOffs(24, 43).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3542F, 3.0884F, -0.0911F, 0.0F, 0.0F));

		PartDefinition gBigDorsalTube = gChest.addOrReplaceChild("gBigDorsalTube", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -1.5F, -0.4F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -6.7F, 3.0F, -0.3377F, 0.0F, 0.0F));

		PartDefinition chest_r11 = gBigDorsalTube.addOrReplaceChild("chest_r11", CubeListBuilder.create().texOffs(26, 37).addBox(-0.5F, -0.5F, -1.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.2169F, 8.364F, -0.3623F, 0.0F, 0.0F));

		PartDefinition chest_r12 = gBigDorsalTube.addOrReplaceChild("chest_r12", CubeListBuilder.create().texOffs(24, 43).addBox(-0.5F, -40.4F, 9.3F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 36.9787F, -11.7908F, -0.2278F, 0.0F, 0.0F));

		PartDefinition chest_r13 = gBigDorsalTube.addOrReplaceChild("chest_r13", CubeListBuilder.create().texOffs(13, 43).addBox(-0.5F, -41.1F, 6.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 39.1514F, -6.6218F, -0.0911F, 0.0F, 0.0F));

		PartDefinition gLowerLeftDorsalTube = gChest.addOrReplaceChild("gLowerLeftDorsalTube", CubeListBuilder.create().texOffs(0, 50).mirror().addBox(-1.0F, -1.0F, -0.4F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.2F, -4.45F, 3.1F, -0.7475F, 0.1367F, 0.0F));

		PartDefinition chest_r14 = gLowerLeftDorsalTube.addOrReplaceChild("chest_r14", CubeListBuilder.create().texOffs(24, 57).mirror().addBox(1.22F, -38.1F, 8.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7F, 32.0486F, -15.8397F, -0.3644F, 0.0F, 0.0F));

		PartDefinition chest_r15 = gLowerLeftDorsalTube.addOrReplaceChild("chest_r15", CubeListBuilder.create().texOffs(24, 50).mirror().addBox(1.21F, -37.6F, 8.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7F, 34.7483F, -11.2953F, -0.2278F, 0.0F, 0.0F));

		PartDefinition chest_r16 = gLowerLeftDorsalTube.addOrReplaceChild("chest_r16", CubeListBuilder.create().texOffs(13, 50).mirror().addBox(1.2F, -38.3F, 6.1F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7F, 36.1667F, -8.1209F, -0.1367F, 0.0F, 0.0F));

		PartDefinition gLowerRightDorsalTube = gChest.addOrReplaceChild("gLowerRightDorsalTube", CubeListBuilder.create().texOffs(0, 50).addBox(-1.0F, -1.0F, -0.4F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -4.45F, 3.1F, -0.7475F, -0.1367F, 0.0F));

		PartDefinition chest_r17 = gLowerRightDorsalTube.addOrReplaceChild("chest_r17", CubeListBuilder.create().texOffs(24, 50).addBox(-2.21F, -37.6F, 8.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 34.7483F, -11.2953F, -0.2278F, 0.0F, 0.0F));

		PartDefinition chest_r18 = gLowerRightDorsalTube.addOrReplaceChild("chest_r18", CubeListBuilder.create().texOffs(24, 57).addBox(-2.22F, -38.1F, 8.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 32.0486F, -15.8397F, -0.3644F, 0.0F, 0.0F));

		PartDefinition chest_r19 = gLowerRightDorsalTube.addOrReplaceChild("chest_r19", CubeListBuilder.create().texOffs(13, 50).addBox(-2.2F, -38.3F, 6.1F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 36.1667F, -8.1209F, -0.1367F, 0.0F, 0.0F));

		PartDefinition gLeftShoulder = gChest.addOrReplaceChild("gLeftShoulder", CubeListBuilder.create().texOffs(87, 0).mirror().addBox(0.0F, -0.5F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1F, -7.9F, 0.0F, 0.3927F, 0.0F, -0.3927F));

		PartDefinition gLeftBicep = gLeftShoulder.addOrReplaceChild("gLeftBicep", CubeListBuilder.create().texOffs(90, 10).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8F, 3.1F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition gLeftForearm = gLeftBicep.addOrReplaceChild("gLeftForearm", CubeListBuilder.create().texOffs(85, 35).mirror().addBox(-1.05F, -0.3217F, -1.2214F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.05F, 8.0217F, 0.2214F, -1.9635F, 0.0F, 0.0F));

		PartDefinition chest_r20 = gLeftForearm.addOrReplaceChild("chest_r20", CubeListBuilder.create().texOffs(102, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.05F, 0.0328F, 0.3024F, -0.6658F, 0.0F, 0.0F));

		PartDefinition gLeftWrist = gLeftForearm.addOrReplaceChild("gLeftWrist", CubeListBuilder.create().texOffs(90, 23).mirror().addBox(-1.5F, 0.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.05F, 7.2783F, -0.2214F, 0.7854F, -0.7854F, 0.0F));

		PartDefinition gLeftFinger1 = gLeftWrist.addOrReplaceChild("gLeftFinger1", CubeListBuilder.create().texOffs(92, 28).addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.15F, 3.5F, 0.0F));

		PartDefinition gLeftFinger2 = gLeftWrist.addOrReplaceChild("gLeftFinger2", CubeListBuilder.create().texOffs(92, 28).addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4F, 3.5F, 0.0F));

		PartDefinition gLeftFinger3 = gLeftWrist.addOrReplaceChild("gLeftFinger3", CubeListBuilder.create().texOffs(92, 28).addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.35F, 3.5F, 0.0F));

		PartDefinition gLeftFinger4 = gLeftWrist.addOrReplaceChild("gLeftFinger4", CubeListBuilder.create().texOffs(92, 28).addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.1F, 3.5F, 0.0F));

		PartDefinition gLeftThumb = gLeftWrist.addOrReplaceChild("gLeftThumb", CubeListBuilder.create().texOffs(92, 28).addBox(0.0F, 0.0F, -0.8F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.4F, -0.1F, 2.3562F, 0.0F, 3.1416F));

		PartDefinition gRightShoulder = gChest.addOrReplaceChild("gRightShoulder", CubeListBuilder.create().texOffs(87, 0).addBox(-3.0F, -0.5F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1F, -7.9F, 0.0F, 0.3927F, 0.0F, 0.3927F));

		PartDefinition gRightBicep = gRightShoulder.addOrReplaceChild("gRightBicep", CubeListBuilder.create().texOffs(90, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, 3.1F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition gRightForearm = gRightBicep.addOrReplaceChild("gRightForearm", CubeListBuilder.create().texOffs(85, 35).addBox(-0.95F, -0.3217F, -1.2214F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.05F, 8.0217F, 0.2214F, -1.9635F, 0.0F, 0.0F));

		PartDefinition chest_r21 = gRightForearm.addOrReplaceChild("chest_r21", CubeListBuilder.create().texOffs(102, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.05F, 0.0328F, 0.3024F, -0.6658F, 0.0F, 0.0F));

		PartDefinition gRightWrist = gRightForearm.addOrReplaceChild("gRightWrist", CubeListBuilder.create().texOffs(90, 23).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.05F, 7.2783F, -0.2214F, 0.7854F, 0.7854F, 0.0F));

		PartDefinition gRightFinger1 = gRightWrist.addOrReplaceChild("gRightFinger1", CubeListBuilder.create().texOffs(92, 28).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.15F, 3.5F, 0.0F));

		PartDefinition gRightFinger2 = gRightWrist.addOrReplaceChild("gRightFinger2", CubeListBuilder.create().texOffs(92, 28).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.4F, 3.5F, 0.0F));

		PartDefinition gRightFinger3 = gRightWrist.addOrReplaceChild("gRightFinger3", CubeListBuilder.create().texOffs(92, 28).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.35F, 3.5F, 0.0F));

		PartDefinition gRightFinger4 = gRightWrist.addOrReplaceChild("gRightFinger4", CubeListBuilder.create().texOffs(92, 28).mirror().addBox(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.1F, 3.5F, 0.0F));

		PartDefinition gRightThumb = gRightWrist.addOrReplaceChild("gRightThumb", CubeListBuilder.create().texOffs(92, 28).mirror().addBox(0.0F, 0.0F, -0.8F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.4F, -0.1F, 2.3562F, 0.0F, -3.1416F));

		PartDefinition gLowerChest = gChest.addOrReplaceChild("gLowerChest", CubeListBuilder.create().texOffs(21, 27).addBox(-2.9333F, -0.4289F, -2.9333F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4667F, -0.9814F, 0.4585F));

		PartDefinition chest_r22 = gLowerChest.addOrReplaceChild("chest_r22", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(-0.5F, -1.5F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.2585F, 5.7144F, -0.0333F, 0.0897F, -0.0158F, -0.1449F));

		PartDefinition chest_r23 = gLowerChest.addOrReplaceChild("chest_r23", CubeListBuilder.create().texOffs(68, 0).addBox(-0.5F, -1.5F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1918F, 5.7144F, -0.0333F, 0.0897F, 0.0158F, 0.1449F));

		PartDefinition gStomach = gLowerChest.addOrReplaceChild("gStomach", CubeListBuilder.create().texOffs(0, 27).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0333F, 1.3711F, 0.0667F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gRightThigh = gStomach.addOrReplaceChild("gRightThigh", CubeListBuilder.create().texOffs(55, 0).addBox(-1.4F, -0.5F, -2.0F, 1.0F, 14.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(37, 0).addBox(-0.8F, -0.5F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 4.9F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gRightShin = gRightThigh.addOrReplaceChild("gRightShin", CubeListBuilder.create().texOffs(47, 19).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 13.2F, -0.1F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gRightAnkle = gRightShin.addOrReplaceChild("gRightAnkle", CubeListBuilder.create().texOffs(41, 36).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.7F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gRightFoot = gRightAnkle.addOrReplaceChild("gRightFoot", CubeListBuilder.create().texOffs(38, 45).addBox(-1.5F, -0.5F, -2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 4.6F, 0.2F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gRightToes = gRightFoot.addOrReplaceChild("gRightToes", CubeListBuilder.create().texOffs(45, 53).addBox(-1.5F, -0.5F, -1.9F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftThigh = gStomach.addOrReplaceChild("gLeftThigh", CubeListBuilder.create().texOffs(55, 0).mirror().addBox(0.4F, -0.5F, -2.0F, 1.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(37, 0).mirror().addBox(-2.2F, -0.5F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 4.9F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftShin = gLeftThigh.addOrReplaceChild("gLeftShin", CubeListBuilder.create().texOffs(47, 19).mirror().addBox(-1.5F, -0.5F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3F, 13.2F, -0.1F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gLeftAnkle = gLeftShin.addOrReplaceChild("gLeftAnkle", CubeListBuilder.create().texOffs(41, 36).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.7F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftFoot = gLeftAnkle.addOrReplaceChild("gLeftFoot", CubeListBuilder.create().texOffs(38, 45).mirror().addBox(-1.5F, -0.5F, -2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, 4.6F, 0.2F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftToes = gLeftFoot.addOrReplaceChild("gLeftToes", CubeListBuilder.create().texOffs(45, 53).mirror().addBox(-1.5F, -0.5F, -1.9F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Belugamorph entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}