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
import org.avp.common.entity.living.OvamorphDraco;

public class OvamorphDracoModel extends EntityModel<OvamorphDraco> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("ovamorph_draco"),
        "main"
    );

    private final ModelPart root;

    public OvamorphDracoModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, 24.0F, 0.0F)
        );

        PartDefinition gEgg = root.addOrReplaceChild(
            "gEgg",
            CubeListBuilder.create()
                .texOffs(0, 15)
                .addBox(-2.5F, -4.4364F, -6.6778F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-3.5F, -5.4364F, -7.6778F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -0.5636F, 4.1778F)
        );

        PartDefinition webbing2_r1 = gEgg.addOrReplaceChild(
            "webbing2_r1",
            CubeListBuilder.create()
                .texOffs(26, 25)
                .addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 3.1416F)
        );

        PartDefinition webbing2b_r1 = gEgg.addOrReplaceChild(
            "webbing2b_r1",
            CubeListBuilder.create()
                .texOffs(39, 29)
                .addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.7074F, 2.2078F, 0.0F, 0.0F, -3.1416F)
        );

        PartDefinition webbing2b_r2 = gEgg.addOrReplaceChild(
            "webbing2b_r2",
            CubeListBuilder.create()
                .texOffs(39, 29)
                .addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.7074F, -10.5634F, 3.1416F, 0.0F, 0.0F)
        );

        PartDefinition webbing4_r1 = gEgg.addOrReplaceChild(
            "webbing4_r1",
            CubeListBuilder.create()
                .texOffs(26, 25)
                .addBox(-3.5F, 1.7041F, -3.2043F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.3537F, -4.1778F, 0.0F, -1.5708F, -0.7854F)
        );

        PartDefinition webbing3_r1 = gEgg.addOrReplaceChild(
            "webbing3_r1",
            CubeListBuilder.create()
                .texOffs(26, 25)
                .addBox(-3.5F, 1.7041F, -3.2043F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.3537F, -4.1778F, -0.7854F, 0.0F, 0.0F)
        );

        PartDefinition webbing2b_r3 = gEgg.addOrReplaceChild(
            "webbing2b_r3",
            CubeListBuilder.create()
                .texOffs(39, 29)
                .addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(6.3856F, 0.7074F, -4.1778F, 0.0F, -1.5708F, 3.1416F)
        );

        PartDefinition webbing2b_r4 = gEgg.addOrReplaceChild(
            "webbing2b_r4",
            CubeListBuilder.create()
                .texOffs(39, 29)
                .addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-6.3856F, 0.7074F, -4.1778F, 0.0F, 1.5708F, 3.1416F)
        );

        PartDefinition webbing3_r2 = gEgg.addOrReplaceChild(
            "webbing3_r2",
            CubeListBuilder.create()
                .texOffs(26, 25)
                .addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-4.1778F, 0.0F, -4.1778F, 0.0F, 1.5708F, 0.7854F)
        );

        PartDefinition sideSpikes4_r1 = gEgg.addOrReplaceChild(
            "sideSpikes4_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-5.8F, -6.0F, -0.1F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.0016F, 0.5636F, -4.3932F, -3.1416F, -0.7741F, 3.1416F)
        );

        PartDefinition sideSpikes2_r1 = gEgg.addOrReplaceChild(
            "sideSpikes2_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(4.7F, -6.0F, -0.2F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-7.5365F, 0.5636F, -11.7073F, 0.0F, -0.8196F, 0.0F)
        );

        PartDefinition sideSpikes3_r1 = gEgg.addOrReplaceChild(
            "sideSpikes3_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(4.7F, -6.0F, 0.1F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(7.5054F, 0.5636F, 3.3789F, -3.1416F, 0.7741F, 3.1416F)
        );

        PartDefinition sideSpikes1_r1 = gEgg.addOrReplaceChild(
            "sideSpikes1_r1",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-8.3F, -6.0F, 0.1F, 1.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(1.4085F, 0.5636F, -6.0822F, 0.0F, 0.8196F, 0.0F)
        );

        PartDefinition gFlaps = gEgg.addOrReplaceChild(
            "gFlaps",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0303F, 0.5636F, -4.2081F, 0.0F, -0.7854F, 0.0F)
        );

        PartDefinition gFrontLeftFlap = gFlaps.addOrReplaceChild(
            "gFrontLeftFlap",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -6.0F, -2.0784F)
        );

        PartDefinition rFrontLobe2_r1 = gFrontLeftFlap.addOrReplaceChild(
            "rFrontLobe2_r1",
            CubeListBuilder.create()
                .texOffs(22, 12)
                .addBox(-1.25F, -0.25F, -1.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -1.75F, 0.3536F, 0.0F, 0.7854F, 0.0F)
        );

        PartDefinition gFrontLeftFlapEnd = gFrontLeftFlap.addOrReplaceChild(
            "gFrontLeftFlapEnd",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -1.5F, 0.7071F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition rFrontLobe2Child_r1 = gFrontLeftFlapEnd.addOrReplaceChild(
            "rFrontLobe2Child_r1",
            CubeListBuilder.create()
                .texOffs(28, 0)
                .addBox(-1.25F, -1.25F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.25F, -0.3536F, 0.0F, 0.7854F, 0.0F)
        );

        PartDefinition gFrontRightFlap = gFlaps.addOrReplaceChild(
            "gFrontRightFlap",
            CubeListBuilder.create(),
            PartPose.offset(-2.1213F, -6.0F, 0.0429F)
        );

        PartDefinition rFrontLobe3_r1 = gFrontRightFlap.addOrReplaceChild(
            "rFrontLobe3_r1",
            CubeListBuilder.create()
                .texOffs(22, 18)
                .mirror()
                .addBox(-1.75F, -0.25F, -1.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -1.75F, 0.3536F, 0.0F, -0.7854F, 0.0F)
        );

        PartDefinition gFrontRightFlapEnd = gFrontRightFlap.addOrReplaceChild(
            "gFrontRightFlapEnd",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.7071F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition rFrontLobe2Child_r2 = gFrontRightFlapEnd.addOrReplaceChild(
            "rFrontLobe2Child_r2",
            CubeListBuilder.create()
                .texOffs(28, 6)
                .mirror()
                .addBox(-0.75F, -1.25F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -0.25F, -0.3536F, 0.0F, -0.7854F, 0.0F)
        );

        PartDefinition gBackRightFlap = gFlaps.addOrReplaceChild(
            "gBackRightFlap",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -6.0F, 2.1642F)
        );

        PartDefinition rBackLobe3_r1 = gBackRightFlap.addOrReplaceChild(
            "rBackLobe3_r1",
            CubeListBuilder.create()
                .texOffs(22, 18)
                .addBox(-1.25F, -0.25F, -1.25F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -1.75F, -0.3536F, 0.0F, -0.7854F, 0.0F)
        );

        PartDefinition gBackRightFlapEnd = gBackRightFlap.addOrReplaceChild(
            "gBackRightFlapEnd",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.0F, -1.5F, -0.7071F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition rBackLobeChild_r1 = gBackRightFlapEnd.addOrReplaceChild(
            "rBackLobeChild_r1",
            CubeListBuilder.create()
                .texOffs(28, 6)
                .addBox(-1.25F, -1.25F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.25F, 0.3536F, 0.0F, -0.7854F, 0.0F)
        );

        PartDefinition gBackLeftFlap = gFlaps.addOrReplaceChild(
            "gBackLeftFlap",
            CubeListBuilder.create(),
            PartPose.offset(2.1213F, -6.0F, 0.0429F)
        );

        PartDefinition rBackLobe4_r1 = gBackLeftFlap.addOrReplaceChild(
            "rBackLobe4_r1",
            CubeListBuilder.create()
                .texOffs(22, 12)
                .addBox(-1.25F, -0.25F, -1.25F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -1.75F, -0.3536F, 0.0F, -0.7854F, 0.0F)
        );

        PartDefinition gBackLeftFlapEnd = gBackLeftFlap.addOrReplaceChild(
            "gBackLeftFlapEnd",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(-0.7071F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition rBackLobeChild_r2 = gBackLeftFlapEnd.addOrReplaceChild(
            "rBackLobeChild_r2",
            CubeListBuilder.create()
                .texOffs(28, 0)
                .addBox(-1.25F, -1.25F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.25F, 0.3536F, 0.0F, -0.7854F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(
        OvamorphDraco entity,
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
