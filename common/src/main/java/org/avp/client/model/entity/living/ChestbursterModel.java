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
import org.avp.common.entity.living.Chestburster;

public class ChestbursterModel extends EntityModel<Chestburster> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("chestburster"),
        "main"
    );

    private final ModelPart root;

    public ChestbursterModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, 22.0F, 0.0F)
        );

        PartDefinition body1 = root.addOrReplaceChild(
            "body1",
            CubeListBuilder.create()
                .texOffs(14, 0)
                .addBox(-2.0F, -1.5F, 0.1F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.1F)),
            PartPose.offset(0.0F, 0.4F, -1.1F)
        );

        PartDefinition gTail1 = body1.addOrReplaceChild(
            "gTail1",
            CubeListBuilder.create()
                .texOffs(12, 13)
                .addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.1F, 4.1F)
        );

        PartDefinition gTail2 = gTail1.addOrReplaceChild(
            "gTail2",
            CubeListBuilder.create()
                .texOffs(12, 13)
                .addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 4.0F)
        );

        PartDefinition gTail3 = gTail2.addOrReplaceChild(
            "gTail3",
            CubeListBuilder.create()
                .texOffs(28, 12)
                .addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.5F, 4.0F)
        );

        PartDefinition gTail4 = gTail3.addOrReplaceChild(
            "gTail4",
            CubeListBuilder.create()
                .texOffs(28, 12)
                .addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 4.0F)
        );

        PartDefinition gTail5 = gTail4.addOrReplaceChild(
            "gTail5",
            CubeListBuilder.create()
                .texOffs(42, 12)
                .addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.5F, 4.0F)
        );

        PartDefinition gTail6 = gTail5.addOrReplaceChild(
            "gTail6",
            CubeListBuilder.create()
                .texOffs(42, 12)
                .addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 4.0F)
        );

        PartDefinition gTorso = root.addOrReplaceChild(
            "gTorso",
            CubeListBuilder.create()
                .texOffs(14, 7)
                .addBox(-2.0F, -0.5F, -3.3F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.3F, 0.0F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition body5_r1 = gTorso.addOrReplaceChild(
            "body5_r1",
            CubeListBuilder.create()
                .texOffs(15, 8)
                .addBox(-2.0F, -3.8F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.05F)),
            PartPose.offsetAndRotation(0.0F, 4.1914F, 0.3156F, 0.3491F, 0.0F, 0.0F)
        );

        PartDefinition gLeftArm = gTorso.addOrReplaceChild(
            "gLeftArm",
            CubeListBuilder.create()
                .texOffs(58, 6)
                .addBox(-0.5F, -0.3F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.1272F, 0.9117F, -2.7F, 1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild(
            "gLeftForearm",
            CubeListBuilder.create()
                .texOffs(54, 6)
                .addBox(-0.5F, -2.65F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 1.95F, 0.0F, 1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gLeftCLaw = gLeftForearm.addOrReplaceChild(
            "gLeftCLaw",
            CubeListBuilder.create()
                .texOffs(48, 10)
                .addBox(-0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.55F, 0.0F, 0.0F, 0.3927F, 0.0F)
        );

        PartDefinition gRightArm = gTorso.addOrReplaceChild(
            "gRightArm",
            CubeListBuilder.create()
                .texOffs(58, 6)
                .mirror()
                .addBox(-0.5F, -0.3F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.1272F, 0.9117F, -2.7F, 1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gRightForearm = gRightArm.addOrReplaceChild(
            "gRightForearm",
            CubeListBuilder.create()
                .texOffs(54, 6)
                .mirror()
                .addBox(-0.5F, -2.65F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 1.95F, 0.0F, 1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gRightCLaw = gRightForearm.addOrReplaceChild(
            "gRightCLaw",
            CubeListBuilder.create()
                .texOffs(48, 10)
                .mirror()
                .addBox(-0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -2.55F, 0.0F, 0.0F, -0.3927F, 0.0F)
        );

        PartDefinition gNeck = gTorso.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, 0.8272F, -2.0429F, 1.9635F, 0.0F, 0.0F)
        );

        PartDefinition body3_r1 = gNeck.addOrReplaceChild(
            "body3_r1",
            CubeListBuilder.create()
                .texOffs(42, 0)
                .addBox(-1.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.55F, 0.0F, 0.0F, 0.0F, -3.1416F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.0F, -7.8991F, -0.9222F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 12)
                .addBox(-1.5F, -8.1118F, -0.6467F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.1858F, 0.2006F, 0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gJaw = gHead.addOrReplaceChild(
            "gJaw",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -3.6991F, -0.9722F)
        );

        PartDefinition mouth_r1 = gJaw.addOrReplaceChild(
            "mouth_r1",
            CubeListBuilder.create()
                .texOffs(54, 0)
                .addBox(-1.5F, -12.3F, 1.1F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 8.8F, -0.85F, 0.0873F, 0.0F, 0.0F)
        );

        PartDefinition body5 = root.addOrReplaceChild(
            "body5",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.8378F, 0.0F, 0.0F)
        );

        PartDefinition body7 = root.addOrReplaceChild(
            "body7",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 1.309F, 0.0F, 0.0F)
        );

        PartDefinition mouth = root.addOrReplaceChild(
            "mouth",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 1.4137F, 0.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(
        Chestburster entity,
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
