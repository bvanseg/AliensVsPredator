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
import org.avp.common.entity.living.Drone;

public class DroneModel extends EntityModel<Drone> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("drone"),
        "main"
    );

    private final ModelPart root;

    public DroneModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -0.8F, 0.0F, -0.3054F, 0.0F, 0.0F)
        );

        PartDefinition gBody = root.addOrReplaceChild(
            "gBody",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -1.3328F, -3.044F)
        );

        PartDefinition gUpperBody = gBody.addOrReplaceChild(
            "gUpperBody",
            CubeListBuilder.create()
                .texOffs(0, 46)
                .addBox(-4.5F, -1.2861F, -10.2016F, 9.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -1.7812F, 0.2456F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition back1_r1 = gUpperBody.addOrReplaceChild(
            "back1_r1",
            CubeListBuilder.create()
                .texOffs(0, 65)
                .addBox(0.0F, -36.5F, -13.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 29.2076F, -2.4969F, -0.192F, 0.0F, 0.0F)
        );

        PartDefinition backhorn2_r1 = gUpperBody.addOrReplaceChild(
            "backhorn2_r1",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .mirror()
                .addBox(0.0F, -4.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(2.5F, -4.7861F, -7.2016F, 0.0F, 0.0F, 0.3927F)
        );

        PartDefinition backhorn3_r1 = gUpperBody.addOrReplaceChild(
            "backhorn3_r1",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .mirror()
                .addBox(0.0F, -5.5F, 3.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(2.5F, -4.7861F, -7.2016F, -0.3927F, 0.0F, 0.3927F)
        );

        PartDefinition backhorn2_r2 = gUpperBody.addOrReplaceChild(
            "backhorn2_r2",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .addBox(-2.0F, -5.5F, 3.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5F, -4.7861F, -7.2016F, -0.3927F, 0.0F, -0.3927F)
        );

        PartDefinition backhorn1_r1 = gUpperBody.addOrReplaceChild(
            "backhorn1_r1",
            CubeListBuilder.create()
                .texOffs(9, 86)
                .addBox(-2.0F, -4.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.5F, -4.7861F, -7.2016F, 0.0F, 0.0F, -0.3927F)
        );

        PartDefinition gNeck = gUpperBody.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(23, 86)
                .addBox(-2.0F, -3.0F, -5.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 1.8094F, -8.6648F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, 0.7488F, -4.6469F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition head5_r1 = gHead.addOrReplaceChild(
            "head5_r1",
            CubeListBuilder.create()
                .texOffs(28, 10)
                .addBox(-2.5F, -12.3562F, -4.6087F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)),
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

        PartDefinition gLeftArm = gUpperBody.addOrReplaceChild(
            "gLeftArm",
            CubeListBuilder.create()
                .texOffs(50, 29)
                .mirror()
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(4.5F, 3.2139F, -7.2016F, 0.3927F, 0.0F, -0.5236F)
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

        PartDefinition leftarm5_r1 = gLeftHand.addOrReplaceChild(
            "leftarm5_r1",
            CubeListBuilder.create()
                .texOffs(60, 38)
                .mirror()
                .addBox(0.8F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.75F, 0.0F, -3.05F, 3.1416F, 0.0F, 0.0F)
        );

        PartDefinition gRightArm = gUpperBody.addOrReplaceChild(
            "gRightArm",
            CubeListBuilder.create()
                .texOffs(50, 29)
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-4.5F, 3.2139F, -7.2016F, 0.3927F, 0.0F, 0.5236F)
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
                .texOffs(57, 94)
                .addBox(0.0F, -4.8F, 0.3F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.9328F, 11.744F, 0.3927F, 0.0F, 0.0F)
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
                .addBox(0.0F, -3.8F, 0.65F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 9.85F, 0.0F, -0.3927F, 0.0F)
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
            PartPose.offsetAndRotation(-0.0132F, -0.5F, 10.6184F, 0.0F, -0.3927F, 0.0F)
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
                .addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, 0.0F, -0.3927F, 0.0F)
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
                .addBox(0.0F, -1.4F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.1F, 10.5F, 0.0F, -0.3927F, 0.0F)
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
            CubeListBuilder.create()
                .texOffs(206, 67)
                .addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.1F, 0.0F, 10.7F, 0.0F, -0.3927F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(
        Drone entity,
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
