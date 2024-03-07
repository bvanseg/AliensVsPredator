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
import org.avp.common.entity.living.Engineer;

public class EngineerModel extends EntityModel<Engineer> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("engineer"),
        "main"
    );

    public static final ModelLayerLocation ARMOR_LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("engineer"),
        "armor"
    );

    private final ModelPart root;

    private final ModelPart gChest;

    private final ModelPart gNeck;

    private final ModelPart gHead;

    private final ModelPart gHelmet;

    public EngineerModel(ModelPart root) {
        this.root = root.getChild("root");
        this.gChest = this.root.getChild("gChest");
        this.gNeck = gChest.getChild("gNeck");
        this.gHead = gNeck.getChild("gHead");
        this.gHelmet = gHead.getChild("gHelmet");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -4.9F, 0.0F)
        );

        PartDefinition gChest = root.addOrReplaceChild(
            "gChest",
            CubeListBuilder.create()
                .texOffs(1, 24)
                .addBox(-3.0F, -1.0F, -2.5F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.3F)),
            PartPose.offset(0.0F, 0.0F, 0.0F)
        );

        PartDefinition chest_r1 = gChest.addOrReplaceChild(
            "chest_r1",
            CubeListBuilder.create()
                .texOffs(6, 27)
                .addBox(-1.0F, -3.0F, -2.8F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)),
            PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.1309F, 0.0F, 0.0F)
        );

        PartDefinition gNeck = gChest.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(0, 15)
                .addBox(-2.0F, -2.7F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-0.3F)),
            PartPose.offsetAndRotation(0.0F, -0.9F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create()
                .texOffs(82, 0)
                .addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)),
            PartPose.offset(0.0F, -2.0F, 0.0F)
        );

        PartDefinition gHelmet = gHead.addOrReplaceChild(
            "gHelmet",
            CubeListBuilder.create()
                .texOffs(17, 0)
                .addBox(-2.5F, -4.1319F, -2.3532F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.3F))
                .texOffs(17, -1)
                .addBox(-2.5F, -4.4319F, -2.3532F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)),
            PartPose.offset(0.0F, -0.2681F, 0.1532F)
        );

        PartDefinition head2_r1 = gHelmet.addOrReplaceChild(
            "head2_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.0F, -2.7F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.35F)),
            PartPose.offsetAndRotation(0.0F, -1.5334F, 0.8655F, -0.0175F, 0.0F, 0.0F)
        );

        PartDefinition nozzle4_r1 = gHelmet.addOrReplaceChild(
            "nozzle4_r1",
            CubeListBuilder.create()
                .texOffs(47, 0)
                .addBox(-1.0F, -1.3397F, -2.4573F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.55F)),
            PartPose.offsetAndRotation(0.0F, 0.8991F, -3.3056F, 1.8239F, 0.0F, 0.0F)
        );

        PartDefinition nozzle3_r1 = gHelmet.addOrReplaceChild(
            "nozzle3_r1",
            CubeListBuilder.create()
                .texOffs(47, 0)
                .addBox(-1.0F, -1.3397F, -2.6573F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)),
            PartPose.offsetAndRotation(0.0F, -0.13F, -3.3765F, 1.7366F, 0.0F, 0.0F)
        );

        PartDefinition nozzle2_r1 = gHelmet.addOrReplaceChild(
            "nozzle2_r1",
            CubeListBuilder.create()
                .texOffs(47, 0)
                .addBox(-1.0F, -1.0397F, -1.5573F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(0.0F, -0.13F, -3.3765F, 1.5184F, 0.0F, 0.0F)
        );

        PartDefinition nozzle4_r2 = gHelmet.addOrReplaceChild(
            "nozzle4_r2",
            CubeListBuilder.create()
                .texOffs(36, 0)
                .mirror()
                .addBox(0.4F, -1.3F, -0.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(36, 0)
                .addBox(-0.4F, -1.3F, -0.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.5F, -1.5856F, -2.1476F, 0.9687F, 0.0F, 0.0F)
        );

        PartDefinition nozzle2_r2 = gHelmet.addOrReplaceChild(
            "nozzle2_r2",
            CubeListBuilder.create()
                .texOffs(36, 0)
                .addBox(-2.0F, -0.9F, -1.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.5F, -1.5856F, -2.1476F, 0.576F, 0.0F, 0.0F)
        );

        PartDefinition nozzle1_r1 = gHelmet.addOrReplaceChild(
            "nozzle1_r1",
            CubeListBuilder.create()
                .texOffs(36, 0)
                .addBox(-1.5F, -1.2221F, -0.4874F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)),
            PartPose.offsetAndRotation(0.0F, -0.13F, -3.3765F, 1.0385F, 0.0F, 0.0F)
        );

        PartDefinition gRightArm = gChest.addOrReplaceChild(
            "gRightArm",
            CubeListBuilder.create()
                .texOffs(44, 22)
                .mirror()
                .addBox(-1.6F, -0.25F, -1.2F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.35F))
                .mirror(false),
            PartPose.offsetAndRotation(-3.35F, -0.15F, -0.2F, 0.0F, 0.0F, 0.1309F)
        );

        PartDefinition rArmUpper_r1 = gRightArm.addOrReplaceChild(
            "rArmUpper_r1",
            CubeListBuilder.create()
                .texOffs(55, 23)
                .mirror()
                .addBox(-2.1F, -3.1F, -1.8F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.34F))
                .mirror(false),
            PartPose.offsetAndRotation(-1.9286F, 1.9621F, 0.6F, 0.0F, 0.0F, 1.2654F)
        );

        PartDefinition gRightForearm = gRightArm.addOrReplaceChild(
            "gRightForearm",
            CubeListBuilder.create()
                .texOffs(44, 33)
                .mirror()
                .addBox(-1.0F, 0.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.25F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.5F, 6.15F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightHand = gRightForearm.addOrReplaceChild(
            "gRightHand",
            CubeListBuilder.create()
                .texOffs(44, 38)
                .mirror()
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.35F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 5.8F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition lArmLower_4_r1 = gRightHand.addOrReplaceChild(
            "lArmLower_4_r1",
            CubeListBuilder.create()
                .texOffs(44, 38)
                .mirror()
                .addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.25F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, 0.0F, 0.0F, 1.7453F)
        );

        PartDefinition gLeftArm = gChest.addOrReplaceChild(
            "gLeftArm",
            CubeListBuilder.create()
                .texOffs(44, 22)
                .addBox(-0.4F, -0.25F, -1.2F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.35F)),
            PartPose.offsetAndRotation(3.35F, -0.15F, -0.2F, 0.0F, 0.0F, -0.1309F)
        );

        PartDefinition rArmUpper_r2 = gLeftArm.addOrReplaceChild(
            "rArmUpper_r2",
            CubeListBuilder.create()
                .texOffs(55, 23)
                .addBox(1.1F, -3.1F, -1.8F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.34F)),
            PartPose.offsetAndRotation(1.9286F, 1.9621F, 0.6F, 0.0F, 0.0F, -1.2654F)
        );

        PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild(
            "gLeftForearm",
            CubeListBuilder.create()
                .texOffs(44, 33)
                .addBox(-1.0F, 0.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.25F)),
            PartPose.offsetAndRotation(0.5F, 6.15F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild(
            "gLeftHand",
            CubeListBuilder.create()
                .texOffs(44, 38)
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.35F)),
            PartPose.offsetAndRotation(0.0F, 5.8F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition lArmLower_5_r1 = gLeftHand.addOrReplaceChild(
            "lArmLower_5_r1",
            CubeListBuilder.create()
                .texOffs(44, 38)
                .addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)),
            PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, 0.0F, 0.0F, -1.7453F)
        );

        PartDefinition stomach = gChest.addOrReplaceChild(
            "stomach",
            CubeListBuilder.create()
                .texOffs(0, 36)
                .addBox(-2.5F, -0.5F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(-0.2F)),
            PartPose.offset(0.0F, 4.8F, 0.0F)
        );

        PartDefinition gLeftThigh = stomach.addOrReplaceChild(
            "gLeftThigh",
            CubeListBuilder.create()
                .texOffs(71, 22)
                .addBox(-1.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.05F)),
            PartPose.offsetAndRotation(1.2F, 5.6F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftShin = gLeftThigh.addOrReplaceChild(
            "gLeftShin",
            CubeListBuilder.create()
                .texOffs(71, 35)
                .addBox(-1.0F, 0.4F, -0.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.3F)),
            PartPose.offsetAndRotation(0.476F, 8.0125F, -1.05F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFoot = gLeftShin.addOrReplaceChild(
            "gLeftFoot",
            CubeListBuilder.create()
                .texOffs(88, 47)
                .addBox(-1.0F, 0.4F, -3.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.45F)),
            PartPose.offset(0.024F, 8.6875F, 0.95F)
        );

        PartDefinition gRightThigh = stomach.addOrReplaceChild(
            "gRightThigh",
            CubeListBuilder.create()
                .texOffs(71, 22)
                .mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.05F))
                .mirror(false),
            PartPose.offsetAndRotation(-1.2F, 5.6F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightShin = gRightThigh.addOrReplaceChild(
            "gRightShin",
            CubeListBuilder.create()
                .texOffs(71, 35)
                .mirror()
                .addBox(-1.0F, 0.4F, -0.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.3F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.476F, 8.0125F, -1.05F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightFoot = gRightShin.addOrReplaceChild(
            "gRightFoot",
            CubeListBuilder.create()
                .texOffs(88, 47)
                .mirror()
                .addBox(-1.0F, 0.4F, -3.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.45F))
                .mirror(false),
            PartPose.offset(-0.024F, 8.6875F, 0.95F)
        );

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public void showHelmet(boolean showHelmet) {
        this.gHelmet.visible = showHelmet;
    }

    @Override
    public void setupAnim(
        Engineer entity,
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
