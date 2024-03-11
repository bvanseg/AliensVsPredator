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
import org.avp.common.entity.living.DeaconAdultEngineer;

public class DeaconAdultEngineerModel extends EntityModel<DeaconAdultEngineer> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("deacon_adult_engineer"),
        "main"
    );

    private final ModelPart root;

    public DeaconAdultEngineerModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, 0.7F, 0.0F)
        );

        PartDefinition gBody = root.addOrReplaceChild(
            "gBody",
            CubeListBuilder.create()
                .texOffs(0, 18)
                .addBox(-3.5F, -1.0F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -20.8105F, 2.241F)
        );

        PartDefinition gChest = gBody.addOrReplaceChild(
            "gChest",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-4.0F, -9.0F, -4.3F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.3105F, 0.259F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition rShoulderRidge05_r1 = gChest.addOrReplaceChild(
            "rShoulderRidge05_r1",
            CubeListBuilder.create()
                .texOffs(29, 40)
                .mirror()
                .addBox(-0.9F, -1.1F, -2.1F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-4.2169F, -9.2426F, 4.8032F, 0.0F, 0.0F, -2.3448F)
        );

        PartDefinition rShoulderRidge04_r1 = gChest.addOrReplaceChild(
            "rShoulderRidge04_r1",
            CubeListBuilder.create()
                .texOffs(29, 40)
                .addBox(-1.1F, -1.1F, -2.1F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.2169F, -9.2426F, 4.8032F, 0.0F, 0.0F, 2.3448F)
        );

        PartDefinition rShoulderRidge03_r1 = gChest.addOrReplaceChild(
            "rShoulderRidge03_r1",
            CubeListBuilder.create()
                .texOffs(31, 33)
                .addBox(1.1506F, -4.8325F, 1.7297F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -8.0054F, -2.9265F, 0.0F, 0.0F, 0.7741F)
        );

        PartDefinition rShoulderRidge02_r1 = gChest.addOrReplaceChild(
            "rShoulderRidge02_r1",
            CubeListBuilder.create()
                .texOffs(31, 25)
                .addBox(1.1506F, -3.8649F, -0.6185F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, -8.0054F, -2.9265F, 0.3643F, 0.0F, 0.7741F)
        );

        PartDefinition rShoulderRidge02_r2 = gChest.addOrReplaceChild(
            "rShoulderRidge02_r2",
            CubeListBuilder.create()
                .texOffs(31, 33)
                .mirror()
                .addBox(-3.1506F, -4.8325F, 1.7297F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -8.0054F, -2.9265F, 0.0F, 0.0F, -0.7741F)
        );

        PartDefinition rShoulderRidge01_r1 = gChest.addOrReplaceChild(
            "rShoulderRidge01_r1",
            CubeListBuilder.create()
                .texOffs(31, 25)
                .mirror()
                .addBox(-3.1506F, -3.8649F, -0.6185F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -8.0054F, -2.9265F, 0.3643F, 0.0F, -0.7741F)
        );

        PartDefinition gNeck = gChest.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(33, 0)
                .addBox(-2.5F, -4.1F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -8.8F, 0.0F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create()
                .texOffs(91, 12)
                .addBox(-3.0F, -5.0F, -4.5F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -3.0F, 0.0F)
        );

        PartDefinition headLower03_r1 = gHead.addOrReplaceChild(
            "headLower03_r1",
            CubeListBuilder.create()
                .texOffs(116, 46)
                .addBox(-1.0F, -0.1926F, -2.9155F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 2.9802F, 21.5728F, -0.4458F, 0.0F, 0.0F)
        );

        PartDefinition headLower03_r2 = gHead.addOrReplaceChild(
            "headLower03_r2",
            CubeListBuilder.create()
                .texOffs(113, 13)
                .addBox(-1.5F, -0.4F, -2.1F, 3.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 1.4639F, 17.2966F, -0.3129F, 0.0F, 0.0F)
        );

        PartDefinition headLower02_r1 = gHead.addOrReplaceChild(
            "headLower02_r1",
            CubeListBuilder.create()
                .texOffs(113, 13)
                .addBox(-1.5F, -0.8168F, 0.7211F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.019F, 10.7335F, -0.2693F, 0.0F, 0.0F)
        );

        PartDefinition headLower01_r1 = gHead.addOrReplaceChild(
            "headLower01_r1",
            CubeListBuilder.create()
                .texOffs(67, 56)
                .addBox(-2.0F, -0.5F, -3.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.4288F, 8.1258F, -0.1047F, 0.0F, 0.0F)
        );

        PartDefinition head04_r1 = gHead.addOrReplaceChild(
            "head04_r1",
            CubeListBuilder.create()
                .texOffs(78, 41)
                .addBox(-1.0F, -1.4343F, 0.0254F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.8802F, 21.5728F, -0.6737F, 0.0F, 0.0F)
        );

        PartDefinition head03_r1 = gHead.addOrReplaceChild(
            "head03_r1",
            CubeListBuilder.create()
                .texOffs(63, 41)
                .addBox(-1.5F, -1.5302F, -3.5352F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.8802F, 21.5728F, -0.5826F, 0.0F, 0.0F)
        );

        PartDefinition head03_r2 = gHead.addOrReplaceChild(
            "head03_r2",
            CubeListBuilder.create()
                .texOffs(66, 32)
                .addBox(-2.0F, -1.5F, -2.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, -0.0806F, 16.7955F, -0.4042F, 0.0F, 0.0F)
        );

        PartDefinition head02_r1 = gHead.addOrReplaceChild(
            "head02_r1",
            CubeListBuilder.create()
                .texOffs(66, 32)
                .addBox(-2.0F, -61.6F, 12.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 52.1861F, -18.2991F, -0.2733F, 0.0F, 0.0F)
        );

        PartDefinition head01_r1 = gHead.addOrReplaceChild(
            "head01_r1",
            CubeListBuilder.create()
                .texOffs(73, 21)
                .addBox(-2.5F, -61.7F, 6.7F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 55.5278F, -10.6116F, -0.1367F, 0.0F, 0.0F)
        );

        PartDefinition gUpperJaw = gHead.addOrReplaceChild(
            "gUpperJaw",
            CubeListBuilder.create()
                .texOffs(87, 36)
                .addBox(-2.0F, -2.3517F, -5.291F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -1.2F, -5.0F)
        );

        PartDefinition muzzle_r1 = gUpperJaw.addOrReplaceChild(
            "muzzle_r1",
            CubeListBuilder.create()
                .texOffs(108, 55)
                .addBox(-2.0F, -62.4089F, -5.3797F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.01F)),
            PartPose.offsetAndRotation(0.0F, 57.234F, 14.0314F, 0.2276F, 0.0F, 0.0F)
        );

        PartDefinition gUpperInnerJaw = gUpperJaw.addOrReplaceChild(
            "gUpperInnerJaw",
            CubeListBuilder.create()
                .texOffs(116, 29)
                .addBox(0.8F, -1.8F, -5.2F, 1.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F))
                .texOffs(109, 36)
                .addBox(-1.65F, -1.8F, -5.2F, 3.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)),
            PartPose.offset(0.0F, -0.2F, 0.1F)
        );

        PartDefinition gLowerJaw = gHead.addOrReplaceChild(
            "gLowerJaw",
            CubeListBuilder.create()
                .texOffs(98, 52)
                .addBox(0.8375F, 0.2F, -6.05F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(83, 54)
                .addBox(-1.8125F, 0.2F, -6.05F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0625F, -1.8F, -4.15F)
        );

        PartDefinition jawTendon01_r1 = gLowerJaw.addOrReplaceChild(
            "jawTendon01_r1",
            CubeListBuilder.create()
                .texOffs(86, 45)
                .addBox(-1.75F, -1.0F, -3.6F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(104, 45)
                .addBox(0.75F, -1.0F, -3.6F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.0125F, -0.7F, -2.95F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition lowerTeeth01 = gLowerJaw.addOrReplaceChild(
            "lowerTeeth01",
            CubeListBuilder.create()
                .texOffs(30, 59)
                .addBox(0.725F, -0.5F, -4.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .texOffs(30, 54)
                .addBox(-1.725F, -0.5F, -4.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offset(0.0125F, 0.15F, -1.55F)
        );

        PartDefinition gRightShoulder = gChest.addOrReplaceChild(
            "gRightShoulder",
            CubeListBuilder.create()
                .texOffs(41, 37)
                .addBox(-3.0F, -1.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.9F, -6.6F, 0.0F, 0.0F, 0.0F, 0.7854F)
        );

        PartDefinition gRightUpperArm = gRightShoulder.addOrReplaceChild(
            "gRightUpperArm",
            CubeListBuilder.create()
                .texOffs(43, 51)
                .addBox(-1.0F, 0.0F, -2.0F, 2.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.5F, 3.6F, 0.0F, 0.0F, 0.0F, -0.7854F)
        );

        PartDefinition gRightLowerArm = gRightUpperArm.addOrReplaceChild(
            "gRightLowerArm",
            CubeListBuilder.create()
                .texOffs(56, 46)
                .addBox(-1.0F, 0.0F, -1.5F, 2.0F, 14.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 7.7F, 0.0F, -0.7854F, 0.0F, 0.0F)
        );

        PartDefinition rArmSpike_r1 = gRightLowerArm.addOrReplaceChild(
            "rArmSpike_r1",
            CubeListBuilder.create()
                .texOffs(32, 47)
                .addBox(-0.9082F, -3.8481F, -1.7622F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0562F, 3.049F, 1.3651F, -0.8188F, -0.0051F, -0.0108F)
        );

        PartDefinition gRightHand = gRightLowerArm.addOrReplaceChild(
            "gRightHand",
            CubeListBuilder.create()
                .texOffs(67, 49)
                .mirror()
                .addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 13.3F, -0.75F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightFinger1 = gRightHand.addOrReplaceChild(
            "gRightFinger1",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .mirror()
                .addBox(0.0F, -0.25F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(1.45F, 3.9F, -1.0F)
        );

        PartDefinition gRightFinger2 = gRightHand.addOrReplaceChild(
            "gRightFinger2",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .mirror()
                .addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(0.7F, 3.9F, -1.0F)
        );

        PartDefinition gRightFinger3 = gRightHand.addOrReplaceChild(
            "gRightFinger3",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .mirror()
                .addBox(0.0F, -0.25F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(0.1F, 3.9F, -1.0F)
        );

        PartDefinition gRightFinger4 = gRightHand.addOrReplaceChild(
            "gRightFinger4",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .mirror()
                .addBox(0.0F, -0.5F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(-0.55F, 3.9F, -1.0F)
        );

        PartDefinition gRightFinger5 = gRightHand.addOrReplaceChild(
            "gRightFinger5",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .mirror()
                .addBox(0.0F, -1.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(-1.3F, 3.9F, -1.0F)
        );

        PartDefinition gRightThumb = gRightHand.addOrReplaceChild(
            "gRightThumb",
            CubeListBuilder.create()
                .texOffs(80, 47)
                .mirror()
                .addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(1.4F, 1.5F, -0.6F, 2.7489F, 0.0F, -3.1416F)
        );

        PartDefinition gLeftShoulder = gChest.addOrReplaceChild(
            "gLeftShoulder",
            CubeListBuilder.create()
                .texOffs(41, 37)
                .mirror()
                .addBox(0.0F, -1.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(2.9F, -6.6F, 0.0F, 0.0F, 0.0F, -0.7854F)
        );

        PartDefinition gLeftUpperArm = gLeftShoulder.addOrReplaceChild(
            "gLeftUpperArm",
            CubeListBuilder.create()
                .texOffs(43, 51)
                .mirror()
                .addBox(-1.0F, 0.0F, -2.0F, 2.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(1.5F, 3.6F, 0.0F, 0.0F, 0.0F, 0.7854F)
        );

        PartDefinition gLeftLowerArm = gLeftUpperArm.addOrReplaceChild(
            "gLeftLowerArm",
            CubeListBuilder.create()
                .texOffs(56, 46)
                .mirror()
                .addBox(-1.0F, 0.0F, -1.5F, 2.0F, 14.0F, 3.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 7.7F, 0.0F, -0.7854F, 0.0F, 0.0F)
        );

        PartDefinition rArmSpike_r2 = gLeftLowerArm.addOrReplaceChild(
            "rArmSpike_r2",
            CubeListBuilder.create()
                .texOffs(32, 47)
                .mirror()
                .addBox(-1.0918F, -3.8481F, -1.7622F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.0562F, 3.049F, 1.3651F, -0.8188F, 0.0051F, 0.0108F)
        );

        PartDefinition gLeftHand = gLeftLowerArm.addOrReplaceChild(
            "gLeftHand",
            CubeListBuilder.create()
                .texOffs(67, 49)
                .addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 13.3F, -0.75F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFinger1 = gLeftHand.addOrReplaceChild(
            "gLeftFinger1",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .addBox(0.0F, -0.25F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-1.45F, 3.9F, -1.0F)
        );

        PartDefinition gLeftFinger2 = gLeftHand.addOrReplaceChild(
            "gLeftFinger2",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-0.7F, 3.9F, -1.0F)
        );

        PartDefinition gLeftFinger3 = gLeftHand.addOrReplaceChild(
            "gLeftFinger3",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .addBox(0.0F, -0.25F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-0.1F, 3.9F, -1.0F)
        );

        PartDefinition gLeftFinger4 = gLeftHand.addOrReplaceChild(
            "gLeftFinger4",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .addBox(0.0F, -0.5F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.55F, 3.9F, -1.0F)
        );

        PartDefinition gLeftFinger5 = gLeftHand.addOrReplaceChild(
            "gLeftFinger5",
            CubeListBuilder.create()
                .texOffs(67, 53)
                .addBox(0.0F, -1.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(1.3F, 3.9F, -1.0F)
        );

        PartDefinition gLeftThumb = gLeftHand.addOrReplaceChild(
            "gLeftThumb",
            CubeListBuilder.create()
                .texOffs(80, 47)
                .addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.4F, 1.5F, -0.6F, 2.7489F, 0.0F, 3.1416F)
        );

        PartDefinition gStomach = gBody.addOrReplaceChild(
            "gStomach",
            CubeListBuilder.create()
                .texOffs(0, 28)
                .addBox(-3.0F, 0.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.3088F, 0.1861F)
        );

        PartDefinition lHipBone_r1 = gStomach.addOrReplaceChild(
            "lHipBone_r1",
            CubeListBuilder.create()
                .texOffs(44, 25)
                .mirror()
                .addBox(1.1F, -38.4F, -0.3F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(19.1671F, 36.9872F, -0.8849F, 0.0456F, 0.0F, -0.7285F)
        );

        PartDefinition lHipBone_r2 = gStomach.addOrReplaceChild(
            "lHipBone_r2",
            CubeListBuilder.create()
                .texOffs(44, 25)
                .addBox(-4.1F, -38.4F, -0.3F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-19.1671F, 36.9872F, -0.8849F, 0.0456F, 0.0F, 0.7285F)
        );

        PartDefinition gHips = gStomach.addOrReplaceChild(
            "gHips",
            CubeListBuilder.create()
                .texOffs(28, 12)
                .addBox(-4.0F, -4.7F, -4.2F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 11.5F, 1.7F)
        );

        PartDefinition gLeftThigh = gHips.addOrReplaceChild(
            "gLeftThigh",
            CubeListBuilder.create()
                .texOffs(57, 0)
                .mirror()
                .addBox(0.0F, -1.0F, -3.0F, 4.0F, 19.0F, 6.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.55F, -1.5F, -1.0F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftShin = gLeftThigh.addOrReplaceChild(
            "gLeftShin",
            CubeListBuilder.create()
                .texOffs(84, 0)
                .mirror()
                .addBox(-1.5F, 1.0F, -1.5F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(2.2F, 16.1741F, -1.3304F, 1.1781F, 0.0F, 0.0F)
        );

        PartDefinition lKneeSpike_r1 = gLeftShin.addOrReplaceChild(
            "lKneeSpike_r1",
            CubeListBuilder.create()
                .texOffs(101, 0)
                .mirror()
                .addBox(0.3738F, -3.3719F, -1.9147F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.75F, 1.5704F, -1.2426F, -1.4048F, 0.7818F, 0.085F)
        );

        PartDefinition gLeftAnkle = gLeftShin.addOrReplaceChild(
            "gLeftAnkle",
            CubeListBuilder.create()
                .texOffs(117, 0)
                .mirror()
                .addBox(-1.0F, 0.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 15.45F, 0.1F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFoot = gLeftAnkle.addOrReplaceChild(
            "gLeftFoot",
            CubeListBuilder.create()
                .texOffs(95, 27)
                .mirror()
                .addBox(-1.5F, 0.0F, -4.5F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 7.2F, -0.1F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightThigh = gHips.addOrReplaceChild(
            "gRightThigh",
            CubeListBuilder.create()
                .texOffs(57, 0)
                .addBox(-4.0F, -1.0F, -3.0F, 4.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.55F, -1.5F, -1.0F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightShin = gRightThigh.addOrReplaceChild(
            "gRightShin",
            CubeListBuilder.create()
                .texOffs(84, 0)
                .addBox(-1.5F, 1.0F, -1.5F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.2F, 16.1741F, -1.3304F, 1.1781F, 0.0F, 0.0F)
        );

        PartDefinition lKneeSpike_r2 = gRightShin.addOrReplaceChild(
            "lKneeSpike_r2",
            CubeListBuilder.create()
                .texOffs(101, 0)
                .addBox(-3.3738F, -3.3719F, -1.9147F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.75F, 1.5704F, -1.2426F, -1.4048F, -0.7818F, -0.085F)
        );

        PartDefinition gRightAnkle = gRightShin.addOrReplaceChild(
            "gRightAnkle",
            CubeListBuilder.create()
                .texOffs(117, 0)
                .addBox(-1.0F, 0.5F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.1F, 15.45F, 0.1F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gRightFoot = gRightAnkle.addOrReplaceChild(
            "gRightFoot",
            CubeListBuilder.create()
                .texOffs(95, 27)
                .addBox(-1.5F, 0.0F, -4.5F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 7.2F, -0.1F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTail1 = gHips.addOrReplaceChild(
            "gTail1",
            CubeListBuilder.create()
                .texOffs(5, 49)
                .addBox(-0.8F, 0.0F, -0.2F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 54)
                .addBox(-0.2F, 0.0F, -0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 54)
                .addBox(-0.8F, 0.0F, -0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 49)
                .addBox(-0.2F, 0.0F, -0.2F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.4537F, 0.9842F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTail2 = gTail1.addOrReplaceChild(
            "gTail2",
            CubeListBuilder.create()
                .texOffs(16, 49)
                .addBox(-0.75F, -0.1F, -0.2F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F))
                .texOffs(11, 55)
                .addBox(-0.25F, -0.1F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F))
                .texOffs(16, 55)
                .addBox(-0.75F, -0.1F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F))
                .texOffs(11, 49)
                .addBox(-0.25F, -0.1F, -0.2F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 2.65F, 0.0F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTail3 = gTail2.addOrReplaceChild(
            "gTail3",
            CubeListBuilder.create()
                .texOffs(22, 49)
                .addBox(-0.5F, -0.1F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 3.6745F, 0.0937F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTailBlade = gTail3.addOrReplaceChild(
            "gTailBlade",
            CubeListBuilder.create()
                .texOffs(22, 56)
                .addBox(-0.5F, -0.0336F, -0.5493F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 4.5836F, 0.0493F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tailBlade02_r1 = gTailBlade.addOrReplaceChild(
            "tailBlade02_r1",
            CubeListBuilder.create()
                .texOffs(21, 60)
                .addBox(-0.1466F, -2.0141F, -0.8534F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 3.4664F, -0.0493F, -0.3622F, 0.7519F, -0.2533F)
        );

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(
        DeaconAdultEngineer entity,
        float limbSwing,
        float limbSwingAmount,
        float ageInTicks,
        float netHeadYaw,
        float headPitch
    ) {}

    @Override
    public void renderToBuffer(
        PoseStack poseStack,
        VertexConsumer vertexConsumer,
        int packedLight,
        int packedOverlay,
        float red,
        float green,
        float blue,
        float alpha
    ) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
