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
import org.avp.common.entity.living.Deacon;

public class DeaconModel extends EntityModel<Deacon> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("deacon"),
        "main"
    );

    private final ModelPart root;

    public DeaconModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, 2.5F, 0.0F)
        );

        PartDefinition gBody = root.addOrReplaceChild(
            "gBody",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -14.4F, 0.0F)
        );

        PartDefinition gChest = gBody.addOrReplaceChild(
            "gChest",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-3.0F, -7.0958F, -4.0063F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 6.8249F, 2.3775F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftShoulder = gChest.addOrReplaceChild(
            "gLeftShoulder",
            CubeListBuilder.create()
                .texOffs(59, 0)
                .mirror()
                .addBox(-1.8F, -1.0F, -1.3F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(3.4F, -6.0958F, -0.6063F, 0.0F, 0.0F, -0.7854F)
        );

        PartDefinition gLeftBicep = gLeftShoulder.addOrReplaceChild(
            "gLeftBicep",
            CubeListBuilder.create()
                .texOffs(62, 10)
                .mirror()
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 2.4F, 0.2F, 0.0F, 0.0F, 0.7854F)
        );

        PartDefinition gLeftForearm = gLeftBicep.addOrReplaceChild(
            "gLeftForearm",
            CubeListBuilder.create()
                .texOffs(62, 21)
                .mirror()
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild(
            "gLeftHand",
            CubeListBuilder.create()
                .texOffs(63, 33)
                .mirror()
                .addBox(-1.5F, 0.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 7.8F, -0.4F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFinger = gLeftHand.addOrReplaceChild(
            "gLeftFinger",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .addBox(0.0F, -0.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-1.3F, 3.95F, -0.4F)
        );

        PartDefinition gLeftFinger2 = gLeftHand.addOrReplaceChild(
            "gLeftFinger2",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .addBox(0.0F, -0.3F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-0.7F, 4.0F, -0.4F)
        );

        PartDefinition gLeftFinger3 = gLeftHand.addOrReplaceChild(
            "gLeftFinger3",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .addBox(0.0F, -0.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-0.1F, 3.95F, -0.4F)
        );

        PartDefinition gLeftFinger4 = gLeftHand.addOrReplaceChild(
            "gLeftFinger4",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .addBox(0.0F, -1.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.65F, 3.95F, -0.4F)
        );

        PartDefinition gLeftFinger5 = gLeftHand.addOrReplaceChild(
            "gLeftFinger5",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .addBox(0.0F, -1.3F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offset(1.2F, 4.0F, -0.4F)
        );

        PartDefinition gLeftThumb = gLeftHand.addOrReplaceChild(
            "gLeftThumb",
            CubeListBuilder.create()
                .texOffs(71, 39)
                .addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.45F, 2.0F, 0.0F, 2.7489F, 0.0F, 3.1416F)
        );

        PartDefinition gRightShoulder = gChest.addOrReplaceChild(
            "gRightShoulder",
            CubeListBuilder.create()
                .texOffs(59, 0)
                .addBox(-1.2F, -1.0F, -1.3F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-3.4F, -6.0958F, -0.6063F, 0.0F, 0.0F, 0.7854F)
        );

        PartDefinition gRightBicep = gRightShoulder.addOrReplaceChild(
            "gRightBicep",
            CubeListBuilder.create()
                .texOffs(62, 10)
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.4F, 0.2F, 0.0F, 0.0F, -0.7854F)
        );

        PartDefinition gRightForearm = gRightBicep.addOrReplaceChild(
            "gRightForearm",
            CubeListBuilder.create()
                .texOffs(62, 21)
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 6.2F, 0.0F, -1.1781F, 0.0F, 0.0F)
        );

        PartDefinition gRightHand = gRightForearm.addOrReplaceChild(
            "gRightHand",
            CubeListBuilder.create()
                .texOffs(63, 33)
                .addBox(-1.5F, 0.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 7.8F, -0.4F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightFinger = gRightHand.addOrReplaceChild(
            "gRightFinger",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .mirror()
                .addBox(0.0F, -0.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(1.3F, 3.95F, -0.4F)
        );

        PartDefinition gRightFinger2 = gRightHand.addOrReplaceChild(
            "gRightFinger2",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .mirror()
                .addBox(0.0F, -0.3F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(0.7F, 4.0F, -0.4F)
        );

        PartDefinition gRightFinger3 = gRightHand.addOrReplaceChild(
            "gRightFinger3",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .mirror()
                .addBox(0.0F, -0.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(0.1F, 3.95F, -0.4F)
        );

        PartDefinition gRightFinger4 = gRightHand.addOrReplaceChild(
            "gRightFinger4",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .mirror()
                .addBox(0.0F, -1.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(-0.65F, 3.95F, -0.4F)
        );

        PartDefinition gRightFinger5 = gRightHand.addOrReplaceChild(
            "gRightFinger5",
            CubeListBuilder.create()
                .texOffs(65, 39)
                .mirror()
                .addBox(0.0F, -1.3F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(-1.2F, 4.0F, -0.4F)
        );

        PartDefinition gRightThumb = gRightHand.addOrReplaceChild(
            "gRightThumb",
            CubeListBuilder.create()
                .texOffs(71, 39)
                .mirror()
                .addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(1.45F, 2.0F, 0.0F, 2.7489F, 0.0F, -3.1416F)
        );

        PartDefinition gNeck = gChest.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(0, 38)
                .addBox(-2.0F, -3.1F, -2.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -6.5958F, -0.4063F, 0.2182F, 0.0F, 0.0F)
        );

        PartDefinition gHead = gNeck.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create()
                .texOffs(89, 14)
                .addBox(-2.5F, -4.9F, 2.6F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(118, 45)
                .addBox(-1.0F, -2.4311F, 7.0059F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(103, 45)
                .addBox(-1.5F, -3.3311F, 4.7059F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 55)
                .addBox(-2.0F, -3.33F, -5.6266F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(85, 0)
                .addBox(-2.5F, -5.0F, -3.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.6F, -0.5F, -0.3054F, 0.0F, 0.0F)
        );

        PartDefinition muzzle_r1 = gHead.addOrReplaceChild(
            "muzzle_r1",
            CubeListBuilder.create()
                .texOffs(0, 49)
                .addBox(-2.0F, -46.1146F, -3.5196F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 35.4201F, 19.6294F, 0.5009F, 0.0F, 0.0F)
        );

        PartDefinition headSlope04_r1 = gHead.addOrReplaceChild(
            "headSlope04_r1",
            CubeListBuilder.create()
                .texOffs(118, 52)
                .addBox(-0.5F, -39.5F, 8.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 36.0883F, -3.205F, -0.0911F, 0.0F, 0.0F)
        );

        PartDefinition headSlope01_r1 = gHead.addOrReplaceChild(
            "headSlope01_r1",
            CubeListBuilder.create()
                .texOffs(85, 45)
                .addBox(-2.0F, -40.3F, 0.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 37.3412F, 7.5229F, 0.182F, 0.0F, 0.0F)
        );

        PartDefinition head05_r1 = gHead.addOrReplaceChild(
            "head05_r1",
            CubeListBuilder.create()
                .texOffs(92, 38)
                .addBox(-1.0F, -42.4F, 9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 33.5384F, -12.1734F, -0.3189F, 0.0F, 0.0F)
        );

        PartDefinition head04_r1 = gHead.addOrReplaceChild(
            "head04_r1",
            CubeListBuilder.create()
                .texOffs(91, 31)
                .addBox(-1.5F, -42.5F, 7.2F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 36.1374F, -6.9748F, -0.1822F, 0.0F, 0.0F)
        );

        PartDefinition head03_r1 = gHead.addOrReplaceChild(
            "head03_r1",
            CubeListBuilder.create()
                .texOffs(90, 24)
                .addBox(-2.0F, -42.6F, 4.4F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 37.3019F, -3.3198F, -0.0911F, 0.0F, 0.0F)
        );

        PartDefinition gLowerJaw = gHead.addOrReplaceChild(
            "gLowerJaw",
            CubeListBuilder.create()
                .texOffs(19, 56)
                .addBox(0.325F, 0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(19, 48)
                .addBox(-2.325F, 0.5F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.525F, -1.83F, -1.5266F)
        );

        PartDefinition gInnerJaw = gHead.addOrReplaceChild(
            "gInnerJaw",
            CubeListBuilder.create()
                .texOffs(41, 56)
                .addBox(0.75F, -1.0F, -3.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F))
                .texOffs(39, 48)
                .addBox(-1.75F, -1.0F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(-0.1F)),
            PartPose.offset(0.0F, -2.13F, -2.4266F)
        );

        PartDefinition gStomach = gBody.addOrReplaceChild(
            "gStomach",
            CubeListBuilder.create()
                .texOffs(0, 18)
                .addBox(-2.5F, 0.0F, -3.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 5.5F, 3.4F)
        );

        PartDefinition rHipBone_r1 = gStomach.addOrReplaceChild(
            "rHipBone_r1",
            CubeListBuilder.create()
                .texOffs(69, 52)
                .addBox(-1.0F, -1.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-1.6098F, 6.1278F, -1.0762F, 0.0F, 0.0F, 2.7489F)
        );

        PartDefinition rHipBone_r2 = gStomach.addOrReplaceChild(
            "rHipBone_r2",
            CubeListBuilder.create()
                .texOffs(69, 52)
                .mirror()
                .addBox(-1.0F, -1.0F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(1.6098F, 6.1278F, -1.0762F, 0.0F, 0.0F, -2.7489F)
        );

        PartDefinition gRightLeg = gStomach.addOrReplaceChild(
            "gRightLeg",
            CubeListBuilder.create()
                .texOffs(35, 0)
                .mirror()
                .addBox(-1.5F, -1.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-1.75F, 6.5F, -1.05F, -0.3491F, 0.0F, 0.0F)
        );

        PartDefinition gRightShin = gRightLeg.addOrReplaceChild(
            "gRightShin",
            CubeListBuilder.create()
                .texOffs(31, 19)
                .mirror()
                .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.1F, 11.3F, -0.7F, -0.7418F, 0.0F, 0.0F)
        );

        PartDefinition gRightFoot = gRightShin.addOrReplaceChild(
            "gRightFoot",
            CubeListBuilder.create()
                .texOffs(38, 33)
                .mirror()
                .addBox(-1.5F, -0.7F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 0.0F, 10.6F, 0.6109F, 0.0F, 0.0F)
        );

        PartDefinition gRightToes = gRightFoot.addOrReplaceChild(
            "gRightToes",
            CubeListBuilder.create()
                .texOffs(36, 42)
                .mirror()
                .addBox(-1.5F, -1.1F, -2.6F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 3.7F, 0.4F, 0.48F, 0.0F, 0.0F)
        );

        PartDefinition gLeftLeg = gStomach.addOrReplaceChild(
            "gLeftLeg",
            CubeListBuilder.create()
                .texOffs(35, 0)
                .addBox(-1.5F, -1.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(1.75F, 6.5F, -1.05F, -0.3491F, 0.0F, 0.0F)
        );

        PartDefinition gLeftShin = gLeftLeg.addOrReplaceChild(
            "gLeftShin",
            CubeListBuilder.create()
                .texOffs(31, 19)
                .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.1F, 11.3F, -0.7F, -0.7418F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFoot = gLeftShin.addOrReplaceChild(
            "gLeftFoot",
            CubeListBuilder.create()
                .texOffs(38, 33)
                .addBox(-1.5F, -0.7F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 10.6F, 0.6109F, 0.0F, 0.0F)
        );

        PartDefinition gLeftToes = gLeftFoot.addOrReplaceChild(
            "gLeftToes",
            CubeListBuilder.create()
                .texOffs(36, 42)
                .addBox(-1.5F, -1.1F, -2.6F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 3.7F, 0.4F, 0.48F, 0.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(
        Deacon entity,
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
