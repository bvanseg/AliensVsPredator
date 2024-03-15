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
import org.avp.common.entity.living.Crusher;

public class CrusherModel extends EntityModel<Crusher> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("crusher"),
        "main"
    );

    private final ModelPart root;

    public CrusherModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(-0.15F, 2.4F, 0.0F)
        );

        PartDefinition gBody = root.addOrReplaceChild(
            "gBody",
            CubeListBuilder.create(),
            PartPose.offset(0.125F, -1.3328F, -3.044F)
        );

        PartDefinition gUpperBody = gBody.addOrReplaceChild(
            "gUpperBody",
            CubeListBuilder.create()
                .texOffs(50, 0)
                .addBox(-4.975F, -2.0861F, -5.2016F, 10.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -1.7812F, 0.2456F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition rShoulderRidge_r1 = gUpperBody.addOrReplaceChild(
            "rShoulderRidge_r1",
            CubeListBuilder.create()
                .texOffs(195, 36)
                .addBox(-5.4359F, -5.5514F, -2.704F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.025F, 1.3959F, -4.7369F, 0.2367F, 0.1751F, 0.0288F)
        );

        PartDefinition rShoulderRidge_r2 = gUpperBody.addOrReplaceChild(
            "rShoulderRidge_r2",
            CubeListBuilder.create()
                .texOffs(195, 36)
                .mirror()
                .addBox(2.4359F, -5.9514F, -3.704F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.25F))
                .mirror(false),
            PartPose.offsetAndRotation(0.025F, 1.3959F, -4.7369F, 0.196F, -0.4585F, 0.0457F)
        );

        PartDefinition lDorsalTube1_r1 = gUpperBody.addOrReplaceChild(
            "lDorsalTube1_r1",
            CubeListBuilder.create()
                .texOffs(0, 43)
                .mirror()
                .addBox(-0.2F, -6.9687F, -2.6988F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(4.3951F, -3.5034F, 1.0735F, -0.5094F, 0.1174F, 0.9959F)
        );

        PartDefinition lDorsalTube2_r1 = gUpperBody.addOrReplaceChild(
            "lDorsalTube2_r1",
            CubeListBuilder.create()
                .texOffs(0, 43)
                .mirror()
                .addBox(-0.8F, -5.5638F, 0.7611F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(4.3951F, -3.5034F, 1.0735F, -0.8148F, 0.1174F, 0.9959F)
        );

        PartDefinition lDorsalTube1_r2 = gUpperBody.addOrReplaceChild(
            "lDorsalTube1_r2",
            CubeListBuilder.create()
                .texOffs(0, 43)
                .addBox(-0.2F, -5.5638F, 0.7611F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-4.3451F, -3.5034F, 1.0735F, -0.8148F, -0.1174F, -0.9959F)
        );

        PartDefinition lDorsalTube0_r1 = gUpperBody.addOrReplaceChild(
            "lDorsalTube0_r1",
            CubeListBuilder.create()
                .texOffs(0, 43)
                .addBox(-0.8F, -6.9687F, -2.6988F, 1.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-4.3451F, -3.5034F, 1.0735F, -0.5094F, -0.1174F, -0.9959F)
        );

        PartDefinition gNeck = gUpperBody.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(23, 86)
                .addBox(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.35F))
                .texOffs(23, 86)
                .addBox(-2.0F, -11.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.025F, 0.4139F, -4.2016F, 1.9635F, 0.0F, 0.0F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -7.6384F, -0.0717F, -0.7854F, 0.0F, 0.0F)
        );

        PartDefinition headTop_r1 = gHead.addOrReplaceChild(
            "headTop_r1",
            CubeListBuilder.create()
                .texOffs(36, 47)
                .addBox(-2.5F, -9.7796F, -3.5098F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.6168F, 6.09F, -1.9373F, 0.0F, 0.0F)
        );

        PartDefinition Head_r1 = gHead.addOrReplaceChild(
            "Head_r1",
            CubeListBuilder.create()
                .texOffs(131, 21)
                .addBox(-2.5F, -1.8F, -2.3F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.0721F, -5.5205F, -0.9338F, 0.0F, 0.0F)
        );

        PartDefinition headBase_r1 = gHead.addOrReplaceChild(
            "headBase_r1",
            CubeListBuilder.create()
                .texOffs(152, 21)
                .addBox(-3.0F, 2.2641F, -4.776F, 6.0F, 10.0F, 7.0F, new CubeDeformation(-0.6F)),
            PartPose.offsetAndRotation(0.0F, -0.6168F, 6.09F, -1.5708F, 0.0F, 0.0F)
        );

        PartDefinition gMouth = gHead.addOrReplaceChild(
            "gMouth",
            CubeListBuilder.create()
                .texOffs(95, 19)
                .addBox(-1.5F, -0.5F, -2.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.9616F, -6.5283F, -0.8552F, 0.0F, 0.0F)
        );

        PartDefinition gBottomJaw = gMouth.addOrReplaceChild(
            "gBottomJaw",
            CubeListBuilder.create()
                .texOffs(88, 1)
                .addBox(-1.5F, 0.0F, -4.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.5F, 2.0F)
        );

        PartDefinition gInnerJaw = gBottomJaw.addOrReplaceChild(
            "gInnerJaw",
            CubeListBuilder.create()
                .texOffs(0, 7)
                .addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.25F)),
            PartPose.offset(0.0F, -0.6F, -1.5F)
        );

        PartDefinition gCrest = gHead.addOrReplaceChild(
            "gCrest",
            CubeListBuilder.create(),
            PartPose.offset(2.5944F, -1.2837F, 2.4264F)
        );

        PartDefinition crest4_r1 = gCrest.addOrReplaceChild(
            "crest4_r1",
            CubeListBuilder.create()
                .texOffs(143, 57)
                .addBox(-8.0F, -3.0F, -1.0F, 16.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5944F, -1.0151F, 11.3757F, -1.9024F, 0.0F, 0.0F)
        );

        PartDefinition crest3_r1 = gCrest.addOrReplaceChild(
            "crest3_r1",
            CubeListBuilder.create()
                .texOffs(109, 57)
                .addBox(-7.0F, -2.0F, -1.0F, 14.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5944F, -2.2837F, 6.7735F, -1.7279F, 0.0F, 0.0F)
        );

        PartDefinition crest2_r1 = gCrest.addOrReplaceChild(
            "crest2_r1",
            CubeListBuilder.create()
                .texOffs(80, 60)
                .addBox(-6.0F, -1.5F, -1.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5944F, -2.7836F, 3.4962F, -1.6842F, 0.0F, 0.0F)
        );

        PartDefinition crest1_r1 = gCrest.addOrReplaceChild(
            "crest1_r1",
            CubeListBuilder.create()
                .texOffs(80, 53)
                .addBox(-5.0F, -1.5F, -1.0F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5944F, -3.0856F, 0.6395F, -1.6319F, 0.0F, 0.0F)
        );

        PartDefinition crest0_r1 = gCrest.addOrReplaceChild(
            "crest0_r1",
            CubeListBuilder.create()
                .texOffs(5, 20)
                .addBox(-4.0F, -1.5F, -1.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5944F, -3.157F, -2.125F, -1.5097F, 0.0F, 0.0F)
        );

        PartDefinition crest5_r1 = gCrest.addOrReplaceChild(
            "crest5_r1",
            CubeListBuilder.create()
                .texOffs(182, 57)
                .addBox(-7.0F, -2.5F, -1.0F, 14.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5944F, 1.0432F, 15.9623F, -2.0769F, 0.0F, 0.0F)
        );

        PartDefinition headBase_r2 = gCrest.addOrReplaceChild(
            "headBase_r2",
            CubeListBuilder.create()
                .texOffs(156, 25)
                .addBox(-3.0F, 1.5111F, -4.6901F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5944F, 0.6669F, 3.6636F, -1.5533F, 0.0F, 0.0F)
        );

        PartDefinition gRightArm = gUpperBody.addOrReplaceChild(
            "gRightArm",
            CubeListBuilder.create()
                .texOffs(229, 12)
                .mirror()
                .addBox(-1.5F, -0.5F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-4.975F, 2.9139F, -2.7016F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightForearm = gRightArm.addOrReplaceChild(
            "gRightForearm",
            CubeListBuilder.create()
                .texOffs(198, 17)
                .mirror()
                .addBox(-1.5F, -2.5F, -12.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 12.2F, 1.0F, 0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gRightHand = gRightForearm.addOrReplaceChild(
            "gRightHand",
            CubeListBuilder.create()
                .texOffs(158, 16)
                .mirror()
                .addBox(-1.0F, -0.325F, -2.8F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.2F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.05F, -1.075F, -12.0F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition rClaw3_r1 = gRightHand.addOrReplaceChild(
            "rClaw3_r1",
            CubeListBuilder.create()
                .texOffs(26, 20)
                .addBox(-1.5F, -0.1F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.025F, -3.3F, 0.0873F, 0.0F, 0.0F)
        );

        PartDefinition gLeftArm = gUpperBody.addOrReplaceChild(
            "gLeftArm",
            CubeListBuilder.create()
                .texOffs(229, 12)
                .addBox(-1.5F, -0.5F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(5.025F, 2.9139F, -2.7016F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild(
            "gLeftForearm",
            CubeListBuilder.create()
                .texOffs(198, 17)
                .addBox(-1.5F, -2.5F, -12.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 12.2F, 1.0F, 0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild(
            "gLeftHand",
            CubeListBuilder.create()
                .texOffs(158, 16)
                .addBox(-1.0F, -0.325F, -2.8F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.2F)),
            PartPose.offsetAndRotation(0.05F, -1.075F, -12.0F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition rClaw4_r1 = gLeftHand.addOrReplaceChild(
            "rClaw4_r1",
            CubeListBuilder.create()
                .texOffs(26, 20)
                .mirror()
                .addBox(-1.5F, -0.1F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 0.025F, -3.3F, 0.0873F, 0.0F, 0.0F)
        );

        PartDefinition gLowerBody = gBody.addOrReplaceChild(
            "gLowerBody",
            CubeListBuilder.create()
                .texOffs(93, 0)
                .addBox(-3.5F, -1.0F, 0.0F, 7.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.025F, -2.6172F, 5.944F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightLeg = gLowerBody.addOrReplaceChild(
            "gRightLeg",
            CubeListBuilder.create()
                .texOffs(132, 0)
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-3.9F, 2.5F, 8.5F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightMiddleLeg = gRightLeg.addOrReplaceChild(
            "gRightMiddleLeg",
            CubeListBuilder.create()
                .texOffs(155, 0)
                .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightLowerLeg = gRightMiddleLeg.addOrReplaceChild(
            "gRightLowerLeg",
            CubeListBuilder.create()
                .texOffs(217, 0)
                .addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.2F, 0.3F, 10.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightFoot = gRightLowerLeg.addOrReplaceChild(
            "gRightFoot",
            CubeListBuilder.create()
                .texOffs(235, 0)
                .addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.0F, 8.5F, 0.25F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftLeg = gLowerBody.addOrReplaceChild(
            "gLeftLeg",
            CubeListBuilder.create()
                .texOffs(132, 0)
                .mirror()
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(3.9F, 2.5F, 8.5F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftMiddleLeg = gLeftLeg.addOrReplaceChild(
            "gLeftMiddleLeg",
            CubeListBuilder.create()
                .texOffs(155, 0)
                .mirror()
                .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftLowerLeg = gLeftMiddleLeg.addOrReplaceChild(
            "gLeftLowerLeg",
            CubeListBuilder.create()
                .texOffs(217, 0)
                .mirror()
                .addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.2F, 0.3F, 10.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFoot = gLeftLowerLeg.addOrReplaceChild(
            "gLeftFoot",
            CubeListBuilder.create()
                .texOffs(235, 0)
                .mirror()
                .addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 8.5F, 0.25F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTail1 = gLowerBody.addOrReplaceChild(
            "gTail1",
            CubeListBuilder.create()
                .texOffs(51, 67)
                .addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 2.0115F, 11.9722F)
        );

        PartDefinition gTail2 = gTail1.addOrReplaceChild(
            "gTail2",
            CubeListBuilder.create()
                .texOffs(5, 27)
                .addBox(-2.0F, -2.0F, -0.25F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.1048F, 9.4939F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTail3 = gTail2.addOrReplaceChild(
            "gTail3",
            CubeListBuilder.create()
                .texOffs(7, 43)
                .addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0215F, 10.6863F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTail4 = gTail3.addOrReplaceChild(
            "gTail4",
            CubeListBuilder.create()
                .texOffs(64, 37)
                .addBox(-1.0F, -0.7123F, -0.1584F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(103, 39)
                .addBox(0.0F, -3.2877F, 0.6584F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.3405F, 10.4892F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gTail5 = gTail4.addOrReplaceChild(
            "gTail5",
            CubeListBuilder.create()
                .texOffs(127, 39)
                .addBox(0.0F, -2.05F, 0.3F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(124, 30)
                .addBox(-0.5F, -0.45F, -0.1F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.1623F, 10.8584F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gStabber = gTail5.addOrReplaceChild(
            "gStabber",
            CubeListBuilder.create()
                .texOffs(95, 27)
                .addBox(-1.5F, 0.0F, -0.5F, 3.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.05F, 10.4F, 0.3927F, 0.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(
        Crusher entity,
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
