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
import org.avp.common.entity.living.WarriorRunner;

public class WarriorRunnerModel extends EntityModel<WarriorRunner> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("warrior_runner"),
        "main"
    );

    private final ModelPart root;

    public WarriorRunnerModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(-0.15F, 3.2F, 0.0F)
        );

        PartDefinition gBody = root.addOrReplaceChild(
            "gBody",
            CubeListBuilder.create(),
            PartPose.offset(0.125F, -1.3328F, -3.044F)
        );

        PartDefinition gUpperBody = gBody.addOrReplaceChild(
            "gUpperBody",
            CubeListBuilder.create()
                .texOffs(0, 46)
                .addBox(-4.475F, -1.2861F, -10.2016F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -1.7812F, 0.2456F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition back1_r1 = gUpperBody.addOrReplaceChild(
            "back1_r1",
            CubeListBuilder.create()
                .texOffs(0, 65)
                .addBox(0.0F, -5.0F, -5.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -4.2218F, -4.1486F, -0.0175F, 0.0F, 0.0F)
        );

        PartDefinition cube_r1 = gUpperBody.addOrReplaceChild(
            "cube_r1",
            CubeListBuilder.create()
                .texOffs(146, 34)
                .addBox(-1.2473F, -1.4695F, -5.0205F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3679F, 1.4457F, -9.1305F, 1.5936F, -0.1246F, 0.0793F)
        );

        PartDefinition cube_r2 = gUpperBody.addOrReplaceChild(
            "cube_r2",
            CubeListBuilder.create()
                .texOffs(146, 34)
                .mirror()
                .addBox(-1.0F, -1.5F, -5.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-4.0679F, 1.4457F, -9.1305F, 1.5936F, 0.1246F, -0.0793F)
        );

        PartDefinition body3_r1 = gUpperBody.addOrReplaceChild(
            "body3_r1",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .mirror()
                .addBox(-1.125F, -4.5545F, -2.5018F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.8159F, -2.1231F, -4.0686F, -0.421F, 0.0806F, -0.5552F)
        );

        PartDefinition body4_r1 = gUpperBody.addOrReplaceChild(
            "body4_r1",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .mirror()
                .addBox(-0.875F, -4.0624F, 0.5997F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.8159F, -2.1231F, -4.0686F, -0.8137F, 0.0806F, -0.5552F)
        );

        PartDefinition body3_r2 = gUpperBody.addOrReplaceChild(
            "body3_r2",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .addBox(-1.125F, -4.0624F, 0.5997F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.8659F, -2.1231F, -4.0686F, -0.8137F, -0.0806F, 0.5552F)
        );

        PartDefinition body2_r1 = gUpperBody.addOrReplaceChild(
            "body2_r1",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .addBox(-0.875F, -4.5545F, -2.5018F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.8659F, -2.1231F, -4.0686F, -0.421F, -0.0806F, 0.5552F)
        );

        PartDefinition gNeck = gUpperBody.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(23, 86)
                .addBox(-2.0F, -3.0F, -3.4F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(23, 86)
                .addBox(-2.0F, -3.0F, -7.4F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 1.8094F, -8.4648F, -0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -0.2512F, -6.9469F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition head5_r1 = gHead.addOrReplaceChild(
            "head5_r1",
            CubeListBuilder.create()
                .texOffs(28, 10)
                .addBox(-2.5F, -12.1062F, -4.7087F, 5.0F, 10.0F, 5.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(0.0F, -0.5043F, -0.0572F, -0.3054F, 0.0F, 0.0F)
        );

        PartDefinition head1_r1 = gHead.addOrReplaceChild(
            "head1_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.5F, -3.6007F, -3.7184F, 5.0F, 10.0F, 5.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, -0.5601F, -0.0133F, -0.0087F, 0.0F, 0.0F)
        );

        PartDefinition head7_r1 = gHead.addOrReplaceChild(
            "head7_r1",
            CubeListBuilder.create()
                .texOffs(34, 0)
                .addBox(-2.5F, -1.6F, -2.6F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F))
                .texOffs(53, 0)
                .addBox(-0.5F, -1.6F, -2.6F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 5.7564F, -0.7715F, 0.5236F, 0.0F, 0.0F)
        );

        PartDefinition gMouth = gHead.addOrReplaceChild(
            "gMouth",
            CubeListBuilder.create()
                .texOffs(52, 20)
                .addBox(-1.5F, 2.378F, -6.1864F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 1.8894F, 0.1508F, 0.829F, 0.0F, 0.0F)
        );

        PartDefinition gBottomJaw = gMouth.addOrReplaceChild(
            "gBottomJaw",
            CubeListBuilder.create()
                .texOffs(88, 1)
                .addBox(-1.5F, 0.5F, -4.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 2.878F, -1.6864F)
        );

        PartDefinition gInnerJaw = gBottomJaw.addOrReplaceChild(
            "gInnerJaw",
            CubeListBuilder.create()
                .texOffs(0, 18)
                .addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.25F)),
            PartPose.offset(0.0F, -0.5F, -2.0F)
        );

        PartDefinition gRightArm = gUpperBody.addOrReplaceChild(
            "gRightArm",
            CubeListBuilder.create()
                .texOffs(50, 29)
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-4.45F, 3.2139F, -6.2016F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightForearm = gRightArm.addOrReplaceChild(
            "gRightForearm",
            CubeListBuilder.create()
                .texOffs(98, 9)
                .addBox(-1.0F, -1.0F, -10.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 11.5F, 0.0F, 0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gRightHand = gRightForearm.addOrReplaceChild(
            "gRightHand",
            CubeListBuilder.create()
                .texOffs(72, 24)
                .addBox(-0.75F, -0.5F, -3.05F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.25F, 0.0F, -10.45F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition cube_r3 = gRightHand.addOrReplaceChild(
            "cube_r3",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .mirror()
                .addBox(0.2F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(1.0F, -1.0F, -3.6F, -0.3054F, -0.1309F, 0.0F)
        );

        PartDefinition cube_r4 = gRightHand.addOrReplaceChild(
            "cube_r4",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .mirror()
                .addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.6F, -1.0F, -4.1F, -0.3054F, -0.0436F, 0.0F)
        );

        PartDefinition cube_r5 = gRightHand.addOrReplaceChild(
            "cube_r5",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .mirror()
                .addBox(-0.1F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.5F, -1.0F, -3.35F, -0.3054F, 0.1309F, 0.0F)
        );

        PartDefinition cube_r6 = gRightHand.addOrReplaceChild(
            "cube_r6",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .mirror()
                .addBox(-0.2F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, -1.0F, -3.85F, -0.3054F, 0.0873F, 0.0F)
        );

        PartDefinition gLeftArm = gUpperBody.addOrReplaceChild(
            "gLeftArm",
            CubeListBuilder.create()
                .texOffs(50, 29)
                .mirror()
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(4.5F, 3.2139F, -6.2016F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild(
            "gLeftForearm",
            CubeListBuilder.create()
                .texOffs(98, 9)
                .mirror()
                .addBox(-1.0F, -1.0F, -10.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 11.5F, 0.0F, 0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild(
            "gLeftHand",
            CubeListBuilder.create()
                .texOffs(72, 24)
                .mirror()
                .addBox(-1.25F, -0.5F, -3.05F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.25F, 0.0F, -10.45F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition cube_r7 = gLeftHand.addOrReplaceChild(
            "cube_r7",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .addBox(-0.2F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.0F, -1.0F, -3.6F, -0.3054F, 0.1309F, 0.0F)
        );

        PartDefinition cube_r8 = gLeftHand.addOrReplaceChild(
            "cube_r8",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .addBox(0.0F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.6F, -1.0F, -4.1F, -0.3054F, 0.0436F, 0.0F)
        );

        PartDefinition cube_r9 = gLeftHand.addOrReplaceChild(
            "cube_r9",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .addBox(0.1F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.5F, -1.0F, -3.35F, -0.3054F, -0.1309F, 0.0F)
        );

        PartDefinition cube_r10 = gLeftHand.addOrReplaceChild(
            "cube_r10",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .addBox(0.2F, -1.5F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.1F, -1.0F, -3.85F, -0.3054F, -0.0873F, 0.0F)
        );

        PartDefinition gLowerBody = gBody.addOrReplaceChild(
            "gLowerBody",
            CubeListBuilder.create()
                .texOffs(23, 69)
                .addBox(0.0F, -2.3328F, -0.244F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27)
                .addBox(-3.475F, -0.0672F, 0.044F, 7.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -3.0F, -0.25F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftLeg = gLowerBody.addOrReplaceChild(
            "gLeftLeg",
            CubeListBuilder.create()
                .texOffs(40, 45)
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.3F, 3.4328F, 8.544F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftMiddleLeg = gLeftLeg.addOrReplaceChild(
            "gLeftMiddleLeg",
            CubeListBuilder.create()
                .texOffs(79, 49)
                .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 9.75F, 1.5F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftLowerLeg = gLeftMiddleLeg.addOrReplaceChild(
            "gLeftLowerLeg",
            CubeListBuilder.create()
                .texOffs(113, 40)
                .addBox(-1.0F, -0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.25F, 10.5F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFoot = gLeftLowerLeg.addOrReplaceChild(
            "gLeftFoot",
            CubeListBuilder.create()
                .texOffs(110, 24)
                .addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition cube_r11 = gLeftFoot.addOrReplaceChild(
            "cube_r11",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .mirror()
                .addBox(-0.875F, -0.9424F, -0.7756F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(177, 118)
                .mirror()
                .addBox(0.875F, -1.0175F, -0.5372F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(177, 118)
                .mirror()
                .addBox(0.125F, -0.8672F, -1.0141F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.075F, -0.9F, -5.55F, -0.3054F, 0.0F, 0.0F)
        );

        PartDefinition gRightLeg = gLowerBody.addOrReplaceChild(
            "gRightLeg",
            CubeListBuilder.create()
                .texOffs(40, 45)
                .mirror()
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-4.25F, 3.4328F, 8.544F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightMiddleLeg = gRightLeg.addOrReplaceChild(
            "gRightMiddleLeg",
            CubeListBuilder.create()
                .texOffs(79, 49)
                .mirror()
                .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 9.75F, 1.5F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightLowerLeg = gRightMiddleLeg.addOrReplaceChild(
            "gRightLowerLeg",
            CubeListBuilder.create()
                .texOffs(113, 40)
                .mirror()
                .addBox(-1.0F, -0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -0.25F, 10.5F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightFoot = gRightLowerLeg.addOrReplaceChild(
            "gRightFoot",
            CubeListBuilder.create()
                .texOffs(110, 24)
                .mirror()
                .addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition cube_r12 = gRightFoot.addOrReplaceChild(
            "cube_r12",
            CubeListBuilder.create()
                .texOffs(177, 118)
                .addBox(0.875F, -0.9424F, -0.7756F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(177, 118)
                .addBox(-0.875F, -1.0175F, -0.5372F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(177, 118)
                .addBox(-0.125F, -0.8672F, -1.0141F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.075F, -0.9F, -5.55F, -0.3054F, 0.0F, 0.0F)
        );

        PartDefinition gTail1 = gLowerBody.addOrReplaceChild(
            "gTail1",
            CubeListBuilder.create()
                .texOffs(57, 94)
                .addBox(0.0F, -4.8F, 0.3F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0316F, 2.6828F, 11.244F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tail3_r1 = gTail1.addOrReplaceChild(
            "tail3_r1",
            CubeListBuilder.create()
                .texOffs(50, 66)
                .addBox(-2.0F, -2.0F, -5.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.5F, 5.2F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail2 = gTail1.addOrReplaceChild(
            "gTail2",
            CubeListBuilder.create()
                .texOffs(90, 95)
                .addBox(0.0F, -4.3F, 0.65F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 9.85F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tail4_r1 = gTail2.addOrReplaceChild(
            "tail4_r1",
            CubeListBuilder.create()
                .texOffs(85, 66)
                .addBox(-2.0F, -2.0F, -5.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, -0.5F, 5.6F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail3 = gTail2.addOrReplaceChild(
            "gTail3",
            CubeListBuilder.create()
                .texOffs(116, 92)
                .addBox(0.0F, -3.8F, 0.0F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.0132F, -0.5F, 10.6184F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tail4_r2 = gTail3.addOrReplaceChild(
            "tail4_r2",
            CubeListBuilder.create()
                .texOffs(118, 66)
                .addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail4 = gTail3.addOrReplaceChild(
            "gTail4",
            CubeListBuilder.create()
                .texOffs(147, 95)
                .addBox(0.0F, -2.75F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tail5_r1 = gTail4.addOrReplaceChild(
            "tail5_r1",
            CubeListBuilder.create()
                .texOffs(149, 66)
                .addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail5 = gTail4.addOrReplaceChild(
            "gTail5",
            CubeListBuilder.create()
                .texOffs(176, 96)
                .addBox(0.0F, -2.15F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.1F, 10.5F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tail6_r1 = gTail5.addOrReplaceChild(
            "tail6_r1",
            CubeListBuilder.create()
                .texOffs(177, 66)
                .addBox(-0.5F, -0.5F, -5.5F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gStabber = gTail5.addOrReplaceChild(
            "gStabber",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.1F, 0.0F, 10.7F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tail7_r1 = gStabber.addOrReplaceChild(
            "tail7_r1",
            CubeListBuilder.create()
                .texOffs(204, 75)
                .addBox(-11.2F, 0.5F, -1.1F, 20.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.4F, 0.3181F, 10.4102F, 0.0F, -1.5708F, 1.5708F)
        );

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(
        WarriorRunner entity,
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
