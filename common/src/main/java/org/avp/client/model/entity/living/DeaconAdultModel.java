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
import org.avp.common.entity.living.DeaconAdult;

public class DeaconAdultModel extends EntityModel<DeaconAdult> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AVPResources.location("deacon_adult"), "main");
	private final ModelPart root;

	public DeaconAdultModel(ModelPart root) {
		this.root = root.getChild("root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition gBody = root.addOrReplaceChild("gBody", CubeListBuilder.create().texOffs(0, 20).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.1F, 0.8F));

		PartDefinition gChest = gBody.addOrReplaceChild("gChest", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.4F, -0.1F));

		PartDefinition neck = gChest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(33, 0).addBox(-2.5F, -3.7F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, -7.6F, 0.3F));

		PartDefinition gHead = neck.addOrReplaceChild("gHead", CubeListBuilder.create().texOffs(89, 37).addBox(-2.0F, -3.5441F, -7.8826F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(73, 58).addBox(-2.0F, -1.1F, 2.7F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(91, 59).addBox(-1.5F, -1.2F, 5.6F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(92, 20).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.1F, 0.0F));

		PartDefinition headLower03_r1 = gHead.addOrReplaceChild("headLower03_r1", CubeListBuilder.create().texOffs(109, 59).addBox(-1.0F, -48.4F, 10.4F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 45.9552F, -5.3148F, -0.0911F, 0.0F, 0.0F));

		PartDefinition head04_r1 = gHead.addOrReplaceChild("head04_r1", CubeListBuilder.create().texOffs(76, 39).addBox(-1.0F, -51.2F, 13.4F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 43.3319F, -14.1986F, -0.2733F, 0.0F, 0.0F));

		PartDefinition head03_r1 = gHead.addOrReplaceChild("head03_r1", CubeListBuilder.create().texOffs(62, 39).addBox(-1.5F, -51.3F, 10.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 44.4901F, -12.1348F, -0.2278F, 0.0F, 0.0F));

		PartDefinition head02_r1 = gHead.addOrReplaceChild("head02_r1", CubeListBuilder.create().texOffs(66, 31).addBox(-2.0F, -51.6F, 7.6F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 45.4248F, -9.989F, -0.1822F, 0.0F, 0.0F));

		PartDefinition head01_r1 = gHead.addOrReplaceChild("head01_r1", CubeListBuilder.create().texOffs(73, 21).addBox(-2.5F, -51.8F, 3.7F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 46.1288F, -7.7908F, -0.1367F, 0.0F, 0.0F));

		PartDefinition muzzle_r1 = gHead.addOrReplaceChild("muzzle_r1", CubeListBuilder.create().texOffs(112, 49).addBox(-2.0F, -0.9F, -1.9F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -3.2533F, -5.6978F, 0.3032F, 0.0F, 0.0F));

		PartDefinition gLowerJaw = gHead.addOrReplaceChild("gLowerJaw", CubeListBuilder.create().texOffs(104, 53).addBox(1.43F, -0.25F, -3.95F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 54).addBox(-1.12F, -0.95F, -3.95F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F))
		.texOffs(30, 59).addBox(1.33F, -0.95F, -3.95F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F))
		.texOffs(86, 53).addBox(-1.22F, -0.25F, -3.95F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.605F, -1.35F, -3.9F));

		PartDefinition jawTendon02_r1 = gLowerJaw.addOrReplaceChild("jawTendon02_r1", CubeListBuilder.create().texOffs(104, 45).addBox(0.725F, -0.9F, -3.8F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(86, 45).addBox(-1.725F, -0.9F, -3.8F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.605F, -0.85F, -2.3F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition innerJaw01 = gHead.addOrReplaceChild("innerJaw01", CubeListBuilder.create().texOffs(106, 36).addBox(-1.5F, -1.0F, -3.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(-0.12F, -2.072F, -4.2413F));

		PartDefinition innerJaw02 = innerJaw01.addOrReplaceChild("innerJaw02", CubeListBuilder.create().texOffs(115, 28).addBox(0.72F, -4.772F, -4.6913F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.12F, 3.772F, 1.1913F));

		PartDefinition gBodyBase = gChest.addOrReplaceChild("gBodyBase", CubeListBuilder.create(), PartPose.offset(0.0F, -7.5559F, 1.2003F));

		PartDefinition lShoulderRidge02_r1 = gBodyBase.addOrReplaceChild("lShoulderRidge02_r1", CubeListBuilder.create().texOffs(31, 25).mirror().addBox(2.5F, -45.5F, -2.9F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.1863F, 31.7386F, 13.5375F, 0.3643F, 0.0F, -0.7741F));

		PartDefinition lShoulderRidge04_r1 = gBodyBase.addOrReplaceChild("lShoulderRidge04_r1", CubeListBuilder.create().texOffs(31, 41).mirror().addBox(2.5F, -45.5F, 4.4F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(38.3539F, 5.5559F, -9.5422F, -0.182F, 0.182F, -1.5595F));

		PartDefinition lShoulderRidge03_r1 = gBodyBase.addOrReplaceChild("lShoulderRidge03_r1", CubeListBuilder.create().texOffs(31, 33).mirror().addBox(2.5F, -45.6F, 0.7F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.0574F, 33.6527F, -2.3971F, 0.0F, 0.0F, -0.7741F));

		PartDefinition lShoulderRidge02_r2 = gBodyBase.addOrReplaceChild("lShoulderRidge02_r2", CubeListBuilder.create().texOffs(31, 33).addBox(-4.5F, -45.6F, 0.7F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0574F, 33.6527F, -2.3971F, 0.0F, 0.0F, 0.7741F));

		PartDefinition lShoulderRidge03_r2 = gBodyBase.addOrReplaceChild("lShoulderRidge03_r2", CubeListBuilder.create().texOffs(31, 41).addBox(-4.5F, -45.5F, 4.4F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.3539F, 5.5559F, -9.5422F, -0.182F, -0.182F, 1.5595F));

		PartDefinition lShoulderRidge01_r1 = gBodyBase.addOrReplaceChild("lShoulderRidge01_r1", CubeListBuilder.create().texOffs(31, 25).addBox(-4.5F, -45.5F, -2.9F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.1863F, 31.7386F, 13.5375F, 0.3643F, 0.0F, 0.7741F));

		PartDefinition gRightShoulder = gChest.addOrReplaceChild("gRightShoulder", CubeListBuilder.create().texOffs(45, 38).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -5.6F, 0.3F, 0.0F, 0.0F, 0.7854F));

		PartDefinition gRightBicep = gRightShoulder.addOrReplaceChild("gRightBicep", CubeListBuilder.create().texOffs(45, 49).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.85F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition gRightForearm = gRightBicep.addOrReplaceChild("gRightForearm", CubeListBuilder.create().texOffs(58, 49).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 6.3F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition lArmSpike_r1 = gRightForearm.addOrReplaceChild("lArmSpike_r1", CubeListBuilder.create().texOffs(32, 47).addBox(-0.4F, -1.5F, -0.7F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9557F, -0.4625F, 0.5433F, -0.4456F, 0.0844F, -0.1413F));

		PartDefinition gRightHand = gRightForearm.addOrReplaceChild("gRightHand", CubeListBuilder.create().texOffs(67, 49).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gRightFinger1 = gRightHand.addOrReplaceChild("gRightFinger1", CubeListBuilder.create().texOffs(67, 53).addBox(0.0F, -1.1F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.2F, 3.95F, -1.0F));

		PartDefinition gRightFinger2 = gRightHand.addOrReplaceChild("gRightFinger2", CubeListBuilder.create().texOffs(67, 53).addBox(0.0F, -0.9F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.6F, 4.0F, -1.0F));

		PartDefinition gRightFinger3 = gRightHand.addOrReplaceChild("gRightFinger3", CubeListBuilder.create().texOffs(67, 53).addBox(0.0F, -1.1F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.05F, 3.95F, -1.0F));

		PartDefinition gRightFinger4 = gRightHand.addOrReplaceChild("gRightFinger4", CubeListBuilder.create().texOffs(67, 53).addBox(0.0F, -1.6F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.8F, 3.95F, -1.0F));

		PartDefinition gRightFinger5 = gRightHand.addOrReplaceChild("gRightFinger5", CubeListBuilder.create().texOffs(67, 53).addBox(0.0F, -1.9F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.3F, 4.0F, -1.0F));

		PartDefinition lFinger3 = gRightHand.addOrReplaceChild("lFinger3", CubeListBuilder.create().texOffs(72, 53).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 1.5F, -0.6F, 2.3562F, 0.0F, 3.1416F));

		PartDefinition gLeftShoulder = gChest.addOrReplaceChild("gLeftShoulder", CubeListBuilder.create().texOffs(45, 38).mirror().addBox(0.0F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -5.6F, 0.3F, 0.0F, 0.0F, -0.7854F));

		PartDefinition gLeftBicep = gLeftShoulder.addOrReplaceChild("gLeftBicep", CubeListBuilder.create().texOffs(45, 49).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.85F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition gLeftForearm = gLeftBicep.addOrReplaceChild("gLeftForearm", CubeListBuilder.create().texOffs(58, 49).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.3F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition lArmSpike_r2 = gLeftForearm.addOrReplaceChild("lArmSpike_r2", CubeListBuilder.create().texOffs(32, 47).mirror().addBox(-1.6F, -1.5F, -0.7F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9557F, -0.4625F, 0.5433F, -0.4456F, -0.0844F, 0.1413F));

		PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild("gLeftHand", CubeListBuilder.create().texOffs(67, 49).mirror().addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.5F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gLeftFinger1 = gLeftHand.addOrReplaceChild("gLeftFinger1", CubeListBuilder.create().texOffs(67, 53).mirror().addBox(0.0F, -1.1F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.2F, 3.95F, -1.0F));

		PartDefinition gLeftFinger2 = gLeftHand.addOrReplaceChild("gLeftFinger2", CubeListBuilder.create().texOffs(67, 53).mirror().addBox(0.0F, -0.9F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.6F, 4.0F, -1.0F));

		PartDefinition gLeftFinger3 = gLeftHand.addOrReplaceChild("gLeftFinger3", CubeListBuilder.create().texOffs(67, 53).mirror().addBox(0.0F, -1.1F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.05F, 3.95F, -1.0F));

		PartDefinition gLeftFinger4 = gLeftHand.addOrReplaceChild("gLeftFinger4", CubeListBuilder.create().texOffs(67, 53).mirror().addBox(0.0F, -1.6F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.8F, 3.95F, -1.0F));

		PartDefinition gLeftFinger5 = gLeftHand.addOrReplaceChild("gLeftFinger5", CubeListBuilder.create().texOffs(67, 53).mirror().addBox(0.0F, -1.9F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.3F, 4.0F, -1.0F));

		PartDefinition lFinger2 = gLeftHand.addOrReplaceChild("lFinger2", CubeListBuilder.create().texOffs(72, 53).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4F, 1.5F, -0.6F, 2.3562F, 0.0F, -3.1416F));

		PartDefinition gStomach = gBody.addOrReplaceChild("gStomach", CubeListBuilder.create().texOffs(0, 33).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2F, 0.2F));

		PartDefinition lHipBone_r1 = gStomach.addOrReplaceChild("lHipBone_r1", CubeListBuilder.create().texOffs(46, 26).mirror().addBox(2.0F, -31.8F, -1.5F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.8338F, 30.1829F, 0.313F, 0.0456F, 0.0F, -0.7285F));

		PartDefinition lHipBone_r2 = gStomach.addOrReplaceChild("lHipBone_r2", CubeListBuilder.create().texOffs(46, 26).addBox(-4.0F, -31.8F, -1.5F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.8338F, 30.1829F, 0.313F, 0.0456F, 0.0F, 0.7285F));

		PartDefinition gHips = gStomach.addOrReplaceChild("gHips", CubeListBuilder.create().texOffs(30, 13).addBox(-3.5F, -4.7F, -4.2F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 1.7F));

		PartDefinition gRightThigh = gHips.addOrReplaceChild("gRightThigh", CubeListBuilder.create().texOffs(57, 0).addBox(-3.0F, -1.0F, -2.5F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -1.8F, -1.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition gRightShin = gRightThigh.addOrReplaceChild("gRightShin", CubeListBuilder.create().texOffs(88, 0).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 13.4F, 0.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gRightAnkle = gRightShin.addOrReplaceChild("gRightAnkle", CubeListBuilder.create().texOffs(117, 0).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 10.9F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition gRightFoot = gRightAnkle.addOrReplaceChild("gRightFoot", CubeListBuilder.create().texOffs(107, 10).addBox(-1.5F, 0.0F, -4.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.4F, -0.7F, 0.3054F, 0.0F, 0.0F));

		PartDefinition gLeftThigh = gHips.addOrReplaceChild("gLeftThigh", CubeListBuilder.create().texOffs(57, 0).mirror().addBox(-1.0F, -1.0F, -2.5F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.3F, -1.8F, -1.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition gLeftShin = gLeftThigh.addOrReplaceChild("gLeftShin", CubeListBuilder.create().texOffs(88, 0).mirror().addBox(-1.5F, -1.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.9F, 13.4F, 0.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition gLeftAnkle = gLeftShin.addOrReplaceChild("gLeftAnkle", CubeListBuilder.create().texOffs(117, 0).mirror().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, 10.9F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition gLeftFoot = gLeftAnkle.addOrReplaceChild("gLeftFoot", CubeListBuilder.create().texOffs(107, 10).mirror().addBox(-1.5F, 0.0F, -4.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 4.4F, -0.7F, 0.3054F, 0.0F, 0.0F));

		PartDefinition gTail1 = gHips.addOrReplaceChild("gTail1", CubeListBuilder.create().texOffs(0, 49).addBox(-0.25F, 0.0F, -0.2F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 54).addBox(-0.75F, 0.0F, -0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-0.25F, 0.0F, -0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 49).addBox(-0.75F, 0.0F, -0.2F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.3F, 1.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTail2 = gTail1.addOrReplaceChild("gTail2", CubeListBuilder.create().texOffs(11, 49).addBox(-0.25F, -0.1F, -0.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(16, 55).addBox(-0.75F, -0.1F, -0.8F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(11, 55).addBox(-0.25F, -0.1F, -0.8F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(16, 49).addBox(-0.75F, -0.1F, -0.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 2.9F, 0.1F, -0.3927F, 0.0F, 0.0F));

		PartDefinition gTail3 = gTail2.addOrReplaceChild("gTail3", CubeListBuilder.create().texOffs(22, 49).addBox(-0.5F, -0.3F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.8F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition gTailBlade = gTail3.addOrReplaceChild("gTailBlade", CubeListBuilder.create().texOffs(22, 56).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.55F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tailBlade02_r1 = gTailBlade.addOrReplaceChild("tailBlade02_r1", CubeListBuilder.create().texOffs(21, 60).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(DeaconAdult entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}