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
import org.avp.common.entity.living.TrilobiteBaby;

public class TrilobiteBabyModel extends EntityModel<TrilobiteBaby> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("trilobite_baby"),
        "main"
    );

    private final ModelPart root;

    public TrilobiteBabyModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, 21.8F, 18.0F, 1.5708F, 0.0F, 0.0F)
        );

        PartDefinition gBody = root.addOrReplaceChild(
            "gBody",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.0F, -3.1F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -13.0F, 0.0F)
        );

        PartDefinition gBackLeftTentacle1 = gBody.addOrReplaceChild(
            "gBackLeftTentacle1",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)),
            PartPose.offset(1.0F, -0.2F, -1.0F)
        );

        PartDefinition gBackLeftTentacle2 = gBackLeftTentacle1.addOrReplaceChild(
            "gBackLeftTentacle2",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .addBox(-1.0F, -0.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)),
            PartPose.offset(0.0F, 4.9F, 0.0F)
        );

        PartDefinition gBackLeftTentacle3 = gBackLeftTentacle2.addOrReplaceChild(
            "gBackLeftTentacle3",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.4F)),
            PartPose.offset(0.0F, 4.4F, 0.0F)
        );

        PartDefinition gBackRightTentacle1 = gBody.addOrReplaceChild(
            "gBackRightTentacle1",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .mirror()
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offset(-1.0F, -0.2F, -1.0F)
        );

        PartDefinition gBackRightTentacle2 = gBackRightTentacle1.addOrReplaceChild(
            "gBackRightTentacle2",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .mirror()
                .addBox(-1.0F, -0.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F))
                .mirror(false),
            PartPose.offset(0.0F, 4.9F, 0.0F)
        );

        PartDefinition gBackRightTentacle3 = gBackRightTentacle2.addOrReplaceChild(
            "gBackRightTentacle3",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .mirror()
                .addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.4F))
                .mirror(false),
            PartPose.offset(0.0F, 4.4F, 0.0F)
        );

        PartDefinition gFrontLeftTentacle1 = gBody.addOrReplaceChild(
            "gFrontLeftTentacle1",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F)),
            PartPose.offset(1.0F, -0.2F, 1.0F)
        );

        PartDefinition gFrontLeftTentacle2 = gFrontLeftTentacle1.addOrReplaceChild(
            "gFrontLeftTentacle2",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .addBox(-1.0F, -0.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F)),
            PartPose.offset(0.0F, 4.9F, 0.0F)
        );

        PartDefinition gFrontLeftTentacle3 = gFrontLeftTentacle2.addOrReplaceChild(
            "gFrontLeftTentacle3",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.4F)),
            PartPose.offset(0.0F, 4.4F, 0.0F)
        );

        PartDefinition gFrontRightTentacle1 = gBody.addOrReplaceChild(
            "gFrontRightTentacle1",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .mirror()
                .addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offset(-1.0F, -0.2F, 1.0F)
        );

        PartDefinition gFrontRightTentacle2 = gFrontRightTentacle1.addOrReplaceChild(
            "gFrontRightTentacle2",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .mirror()
                .addBox(-1.0F, -0.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.25F))
                .mirror(false),
            PartPose.offset(0.0F, 4.9F, 0.0F)
        );

        PartDefinition gFrontRightTentacle3 = gFrontRightTentacle2.addOrReplaceChild(
            "gFrontRightTentacle3",
            CubeListBuilder.create()
                .texOffs(0, 13)
                .mirror()
                .addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.4F))
                .mirror(false),
            PartPose.offset(0.0F, 4.4F, 0.0F)
        );

        PartDefinition gUpperBody = gBody.addOrReplaceChild(
            "gUpperBody",
            CubeListBuilder.create()
                .texOffs(17, 0)
                .addBox(-2.5F, -6.0F, -2.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)),
            PartPose.offset(0.0F, -2.9F, 0.0F)
        );

        PartDefinition gUpperBodyMiddle = gUpperBody.addOrReplaceChild(
            "gUpperBodyMiddle",
            CubeListBuilder.create()
                .texOffs(37, 5)
                .addBox(-2.0F, -3.3F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)),
            PartPose.offset(0.0F, -6.0F, 0.0F)
        );

        PartDefinition gUpperBodyEnd = gUpperBodyMiddle.addOrReplaceChild(
            "gUpperBodyEnd",
            CubeListBuilder.create()
                .texOffs(37, 0)
                .addBox(-1.5F, -2.7F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)),
            PartPose.offset(0.0F, -3.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(
        TrilobiteBaby entity,
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
