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
import org.avp.common.entity.living.Praetorian;

public class PraetorianModel extends EntityModel<Praetorian> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("praetorian"),
        "main"
    );

    private final ModelPart root;

    public PraetorianModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, -0.3054F, 0.0F, 0.0F)
        );

        PartDefinition gBody = root.addOrReplaceChild(
            "gBody",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -0.3328F, -3.044F)
        );

        PartDefinition gUpperBody = gBody.addOrReplaceChild(
            "gUpperBody",
            CubeListBuilder.create()
                .texOffs(0, 46)
                .addBox(-4.5F, -1.2861F, -10.2016F, 9.0F, 8.0F, 10.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, -1.7812F, 0.2456F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition back1_r1 = gUpperBody.addOrReplaceChild(
            "back1_r1",
            CubeListBuilder.create()
                .texOffs(0, 65)
                .addBox(0.0F, -36.5F, -13.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 29.2076F, -2.4969F, -0.192F, 0.0F, 0.0F)
        );

        PartDefinition backhorn8_r1 = gUpperBody.addOrReplaceChild(
            "backhorn8_r1",
            CubeListBuilder.create()
                .texOffs(9, 82)
                .mirror()
                .addBox(0.0F, -7.5F, -2.0F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(6.8068F, -5.4932F, -7.9982F, 2.9543F, -0.1841F, -2.3389F)
        );

        PartDefinition backhorn7_r1 = gUpperBody.addOrReplaceChild(
            "backhorn7_r1",
            CubeListBuilder.create()
                .texOffs(1, 81)
                .mirror()
                .addBox(0.25F, -11.9794F, -1.7197F, 0.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(6.6315F, -5.5891F, -3.5589F, -0.2054F, 0.1841F, 0.8027F)
        );

        PartDefinition backhorn6_r1 = gUpperBody.addOrReplaceChild(
            "backhorn6_r1",
            CubeListBuilder.create()
                .texOffs(9, 82)
                .mirror()
                .addBox(0.1708F, -7.3335F, -2.075F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(6.383F, -4.5486F, 0.9F, -2.5434F, -0.1841F, -2.3389F)
        );

        PartDefinition backhorn7_r2 = gUpperBody.addOrReplaceChild(
            "backhorn7_r2",
            CubeListBuilder.create()
                .texOffs(9, 82)
                .addBox(0.0F, -7.5F, -2.0F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-6.8068F, -5.4932F, -7.9982F, 2.9543F, 0.1841F, 2.3389F)
        );

        PartDefinition backhorn6_r2 = gUpperBody.addOrReplaceChild(
            "backhorn6_r2",
            CubeListBuilder.create()
                .texOffs(1, 81)
                .addBox(-0.25F, -11.9794F, -1.7197F, 0.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-6.6315F, -5.5891F, -3.5589F, -0.2054F, -0.1841F, -0.8027F)
        );

        PartDefinition backhorn5_r1 = gUpperBody.addOrReplaceChild(
            "backhorn5_r1",
            CubeListBuilder.create()
                .texOffs(9, 82)
                .addBox(-0.1708F, -7.3335F, -2.075F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-6.383F, -4.5486F, 0.9F, -2.5434F, 0.1841F, 2.3389F)
        );

        PartDefinition gNeck = gUpperBody.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(23, 86)
                .addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.3094F, -7.7648F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, 0.7488F, -5.6469F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition headSide3_r1 = gHead.addOrReplaceChild(
            "headSide3_r1",
            CubeListBuilder.create()
                .texOffs(169, 10)
                .addBox(-2.0301F, -8.3544F, -1.0892F, 5.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.553F, -14.633F, -1.1777F, -0.2342F, -0.2511F, -0.2443F)
        );

        PartDefinition headSide2_r1 = gHead.addOrReplaceChild(
            "headSide2_r1",
            CubeListBuilder.create()
                .texOffs(169, 10)
                .mirror()
                .addBox(-2.9699F, -8.3544F, -1.0892F, 5.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(2.553F, -14.633F, -1.1777F, -0.2342F, 0.2511F, 0.2443F)
        );

        PartDefinition head5_r1 = gHead.addOrReplaceChild(
            "head5_r1",
            CubeListBuilder.create()
                .texOffs(127, 10)
                .addBox(-2.5F, -19.3562F, -4.6087F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -3.5601F, -1.0133F, -0.3054F, 0.0F, 0.0F)
        );

        PartDefinition head1_r1 = gHead.addOrReplaceChild(
            "head1_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.5F, -3.6007F, -3.7184F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -3.5601F, -1.0133F, -0.0087F, 0.0F, 0.0F)
        );

        PartDefinition head7_r1 = gHead.addOrReplaceChild(
            "head7_r1",
            CubeListBuilder.create()
                .texOffs(34, 0)
                .addBox(-2.5F, 3.9045F, -6.2874F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.02F))
                .texOffs(53, 0)
                .addBox(-0.5F, 3.9045F, -6.2874F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.02F)),
            PartPose.offsetAndRotation(0.0F, -3.5601F, -1.0133F, 0.48F, 0.0F, 0.0F)
        );

        PartDefinition head4_r1 = gHead.addOrReplaceChild(
            "head4_r1",
            CubeListBuilder.create()
                .texOffs(52, 20)
                .addBox(-1.5F, 4.9963F, -7.7195F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -3.5601F, -1.0133F, 0.7243F, 0.0F, 0.0F)
        );

        PartDefinition gRightArm = gUpperBody.addOrReplaceChild(
            "gRightArm",
            CubeListBuilder.create()
                .texOffs(50, 29)
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-4.25F, 2.7139F, -6.7016F, 0.3927F, 0.0F, 0.5236F)
        );

        PartDefinition gRightForearm = gRightArm.addOrReplaceChild(
            "gRightForearm",
            CubeListBuilder.create()
                .texOffs(98, 9)
                .addBox(-1.0F, -1.0F, -10.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 11.5F, 0.0F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightHand = gRightForearm.addOrReplaceChild(
            "gRightHand",
            CubeListBuilder.create()
                .texOffs(72, 24)
                .addBox(-0.75F, -0.5F, -3.05F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.25F, 0.0F, -10.45F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition rightarm6_r1 = gRightHand.addOrReplaceChild(
            "rightarm6_r1",
            CubeListBuilder.create()
                .texOffs(60, 38)
                .addBox(-3.8F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.75F, 0.0F, -3.05F, 3.1416F, 0.0F, 0.0F)
        );

        PartDefinition gLeftArm = gUpperBody.addOrReplaceChild(
            "gLeftArm",
            CubeListBuilder.create()
                .texOffs(50, 29)
                .mirror()
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(4.25F, 2.7139F, -6.7016F, 0.3927F, 0.0F, -0.5236F)
        );

        PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild(
            "gLeftForearm",
            CubeListBuilder.create()
                .texOffs(98, 9)
                .mirror()
                .addBox(-1.0F, -1.0F, -10.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 11.5F, 0.0F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild(
            "gLeftHand",
            CubeListBuilder.create()
                .texOffs(72, 24)
                .mirror()
                .addBox(-1.25F, -0.5F, -3.05F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.25F, 0.0F, -10.45F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition leftarm7_r1 = gLeftHand.addOrReplaceChild(
            "leftarm7_r1",
            CubeListBuilder.create()
                .texOffs(60, 38)
                .mirror()
                .addBox(0.8F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.75F, 0.0F, -3.05F, 3.1416F, 0.0F, 0.0F)
        );

        PartDefinition gLowerBody = gBody.addOrReplaceChild(
            "gLowerBody",
            CubeListBuilder.create()
                .texOffs(23, 65)
                .addBox(0.0F, -5.9328F, 0.756F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27)
                .addBox(-3.5F, -0.0672F, 0.044F, 7.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -3.0F, -0.25F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightLeg = gLowerBody.addOrReplaceChild(
            "gRightLeg",
            CubeListBuilder.create()
                .texOffs(40, 45)
                .mirror()
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.0F, 3.4328F, 8.544F, 0.0F, 0.0F, 0.3927F)
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
            PartPose.offsetAndRotation(0.0F, -0.25F, 11.5F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightFoot = gRightLowerLeg.addOrReplaceChild(
            "gRightFoot",
            CubeListBuilder.create()
                .texOffs(110, 24)
                .mirror()
                .addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.7854F, 0.3927F, 0.0F)
        );

        PartDefinition gLeftLeg = gLowerBody.addOrReplaceChild(
            "gLeftLeg",
            CubeListBuilder.create()
                .texOffs(40, 45)
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.0F, 3.4328F, 8.544F, 0.0F, 0.0F, -0.3927F)
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
            PartPose.offsetAndRotation(0.0F, -0.25F, 11.5F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFoot = gLeftLowerLeg.addOrReplaceChild(
            "gLeftFoot",
            CubeListBuilder.create()
                .texOffs(110, 24)
                .addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.7854F, -0.3927F, 0.0F)
        );

        PartDefinition gTail1 = gLowerBody.addOrReplaceChild(
            "gTail1",
            CubeListBuilder.create()
                .texOffs(90, 94)
                .addBox(0.0F, -4.7402F, 0.0475F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.9328F, 11.744F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition tailSpikes4_r1 = gTail1.addOrReplaceChild(
            "tailSpikes4_r1",
            CubeListBuilder.create()
                .texOffs(90, 94)
                .mirror()
                .addBox(0.0F, -4.0F, -5.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -0.7402F, 5.0475F, 0.0F, 0.0F, 1.9635F)
        );

        PartDefinition tailSpikes3_r1 = gTail1.addOrReplaceChild(
            "tailSpikes3_r1",
            CubeListBuilder.create()
                .texOffs(90, 94)
                .addBox(0.0F, -4.0F, -5.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.7402F, 5.0475F, 0.0F, 0.0F, -1.9635F)
        );

        PartDefinition tail2_r1 = gTail1.addOrReplaceChild(
            "tail2_r1",
            CubeListBuilder.create()
                .texOffs(50, 66)
                .addBox(-2.0F, -2.0F, -5.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(0.0F, -0.5F, 5.2F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail2 = gTail1.addOrReplaceChild(
            "gTail2",
            CubeListBuilder.create()
                .texOffs(116, 92)
                .addBox(0.0F, -4.4402F, -0.3525F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 9.5F, 0.0F, -0.3927F, 0.0F)
        );

        PartDefinition tailSpikes5_r1 = gTail2.addOrReplaceChild(
            "tailSpikes5_r1",
            CubeListBuilder.create()
                .texOffs(116, 92)
                .mirror()
                .addBox(0.0F, -3.75F, -5.5F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -0.4402F, 5.1475F, 0.0F, 0.0F, 1.9635F)
        );

        PartDefinition tailSpikes4_r2 = gTail2.addOrReplaceChild(
            "tailSpikes4_r2",
            CubeListBuilder.create()
                .texOffs(116, 92)
                .addBox(0.0F, -3.75F, -5.5F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.4402F, 5.1475F, 0.0F, 0.0F, -1.9635F)
        );

        PartDefinition tail3_r1 = gTail2.addOrReplaceChild(
            "tail3_r1",
            CubeListBuilder.create()
                .texOffs(50, 66)
                .addBox(-2.0F, -2.0F, -5.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(-0.5F)),
            PartPose.offsetAndRotation(0.0F, -0.5F, 5.2F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail3 = gTail2.addOrReplaceChild(
            "gTail3",
            CubeListBuilder.create()
                .texOffs(147, 92)
                .addBox(0.0F, -5.4701F, -0.3263F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.4701F, 9.7737F, 0.0F, -0.3927F, 0.0F)
        );

        PartDefinition tail5_r1 = gTail3.addOrReplaceChild(
            "tail5_r1",
            CubeListBuilder.create()
                .texOffs(149, 66)
                .addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.0299F, 5.1263F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition tailSpikes6_r1 = gTail3.addOrReplaceChild(
            "tailSpikes6_r1",
            CubeListBuilder.create()
                .texOffs(147, 92)
                .mirror()
                .addBox(3.0F, -6.5F, -5.5F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -2.9701F, 5.1737F, 0.0F, 0.0F, 1.9635F)
        );

        PartDefinition tailSpikes5_r2 = gTail3.addOrReplaceChild(
            "tailSpikes5_r2",
            CubeListBuilder.create()
                .texOffs(147, 92)
                .addBox(-3.0F, -6.5F, -5.5F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.9701F, 5.1737F, 0.0F, 0.0F, -1.9635F)
        );

        PartDefinition gTail4 = gTail3.addOrReplaceChild(
            "gTail4",
            CubeListBuilder.create()
                .texOffs(149, 93)
                .addBox(0.0F, -4.6201F, 0.7237F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.15F, 9.85F, 0.0F, -0.3927F, 0.0F)
        );

        PartDefinition tailSpikes7_r1 = gTail4.addOrReplaceChild(
            "tailSpikes7_r1",
            CubeListBuilder.create()
                .texOffs(149, 93)
                .mirror()
                .addBox(-2.0F, -5.75F, -5.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -2.1201F, 5.7237F, 0.0F, 0.0F, -1.9635F)
        );

        PartDefinition tailSpikes6_r2 = gTail4.addOrReplaceChild(
            "tailSpikes6_r2",
            CubeListBuilder.create()
                .texOffs(149, 93)
                .addBox(2.0F, -5.75F, -5.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.1201F, 5.7237F, 0.0F, 0.0F, 1.9635F)
        );

        PartDefinition tail5_r2 = gTail4.addOrReplaceChild(
            "tail5_r2",
            CubeListBuilder.create()
                .texOffs(149, 66)
                .addBox(-1.0F, -1.0F, -5.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(0.0F, 0.1201F, 5.2763F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail5 = gTail4.addOrReplaceChild(
            "gTail5",
            CubeListBuilder.create()
                .texOffs(148, 92)
                .addBox(0.0F, -4.4701F, 0.4737F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.15F, 9.85F, 0.0F, -0.3927F, 0.0F)
        );

        PartDefinition tailSpikes7_r2 = gTail5.addOrReplaceChild(
            "tailSpikes7_r2",
            CubeListBuilder.create()
                .texOffs(149, 93)
                .mirror()
                .addBox(-2.0F, -5.25F, -5.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -2.2701F, 5.3737F, 0.0F, 0.0F, -1.9635F)
        );

        PartDefinition tailSpikes6_r3 = gTail5.addOrReplaceChild(
            "tailSpikes6_r3",
            CubeListBuilder.create()
                .texOffs(149, 93)
                .addBox(2.0F, -5.25F, -5.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.2701F, 5.3737F, 0.0F, 0.0F, 1.9635F)
        );

        PartDefinition tail7_r1 = gTail5.addOrReplaceChild(
            "tail7_r1",
            CubeListBuilder.create()
                .texOffs(178, 66)
                .addBox(-0.5F, -0.5F, -5.5F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.0F, -0.0299F, 5.5263F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gTail6 = gTail5.addOrReplaceChild(
            "gTail6",
            CubeListBuilder.create()
                .texOffs(177, 93)
                .addBox(0.0F, -4.3201F, 0.2237F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.05F, 10.25F, 0.0F, -0.3927F, 0.0F)
        );

        PartDefinition tailSpikes9_r1 = gTail6.addOrReplaceChild(
            "tailSpikes9_r1",
            CubeListBuilder.create()
                .texOffs(177, 93)
                .mirror()
                .addBox(-2.0F, -5.0F, -5.5F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -2.1201F, 5.7237F, 0.0F, 0.0F, -1.9635F)
        );

        PartDefinition tailSpikes8_r1 = gTail6.addOrReplaceChild(
            "tailSpikes8_r1",
            CubeListBuilder.create()
                .texOffs(177, 93)
                .addBox(2.0F, -5.0F, -5.5F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.1201F, 5.7237F, 0.0F, 0.0F, 1.9635F)
        );

        PartDefinition tail7_r2 = gTail6.addOrReplaceChild(
            "tail7_r2",
            CubeListBuilder.create()
                .texOffs(178, 66)
                .addBox(-0.5F, -0.5F, -5.5F, 1.0F, 1.0F, 11.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, -0.0799F, 5.7763F, 0.0F, 3.1416F, 0.0F)
        );

        PartDefinition gStabber = gTail6.addOrReplaceChild(
            "gStabber",
            CubeListBuilder.create()
                .texOffs(206, 67)
                .addBox(-1.5F, 0.0F, -0.25F, 3.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.0799F, 10.9763F, 0.0F, -0.3927F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(
        Praetorian entity,
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
