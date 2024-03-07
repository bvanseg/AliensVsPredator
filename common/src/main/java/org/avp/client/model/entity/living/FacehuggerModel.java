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
import org.avp.common.entity.living.Facehugger;

public class FacehuggerModel extends EntityModel<Facehugger> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("facehugger"),
        "main"
    );

    private final ModelPart root;

    public FacehuggerModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, -0.6F, 0.0F)
        );

        PartDefinition spine_r1 = root.addOrReplaceChild(
            "spine_r1",
            CubeListBuilder.create()
                .texOffs(0, 4)
                .addBox(-0.5F, -4.0F, -1.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 24.2976F, 1.1448F, 0.0873F, 0.0F, 0.0F)
        );

        PartDefinition bodyMain = root.addOrReplaceChild(
            "bodyMain",
            CubeListBuilder.create()
                .texOffs(0, 14)
                .addBox(-2.0F, 0.7F, -1.1F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.5F, 20.0F, -1.0F)
        );

        PartDefinition spine3_r1 = bodyMain.addOrReplaceChild(
            "spine3_r1",
            CubeListBuilder.create()
                .texOffs(0, 10)
                .addBox(-0.5F, -0.3F, 0.2F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(0, 10)
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(-0.5F, 0.8F, 3.7F, 0.0873F, 0.0F, 0.0F)
        );

        PartDefinition gTail1 = bodyMain.addOrReplaceChild(
            "gTail1",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(-0.5F, 0.7F, 6.0F)
        );

        PartDefinition gTail2 = gTail1.addOrReplaceChild(
            "gTail2",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail3 = gTail2.addOrReplaceChild(
            "gTail3",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail4 = gTail3.addOrReplaceChild(
            "gTail4",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail5 = gTail4.addOrReplaceChild(
            "gTail5",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail6 = gTail5.addOrReplaceChild(
            "gTail6",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail7 = gTail6.addOrReplaceChild(
            "gTail7",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail8 = gTail7.addOrReplaceChild(
            "gTail8",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail9 = gTail8.addOrReplaceChild(
            "gTail9",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail10 = gTail9.addOrReplaceChild(
            "gTail10",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail11 = gTail10.addOrReplaceChild(
            "gTail11",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail12 = gTail11.addOrReplaceChild(
            "gTail12",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail13 = gTail12.addOrReplaceChild(
            "gTail13",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail14 = gTail13.addOrReplaceChild(
            "gTail14",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail15 = gTail14.addOrReplaceChild(
            "gTail15",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail16 = gTail15.addOrReplaceChild(
            "gTail16",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail17 = gTail16.addOrReplaceChild(
            "gTail17",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail18 = gTail17.addOrReplaceChild(
            "gTail18",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail19 = gTail18.addOrReplaceChild(
            "gTail19",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail20 = gTail19.addOrReplaceChild(
            "gTail20",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gTail21 = gTail20.addOrReplaceChild(
            "gTail21",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 0.8F)
        );

        PartDefinition gTail22 = gTail21.addOrReplaceChild(
            "gTail22",
            CubeListBuilder.create()
                .texOffs(28, 21)
                .addBox(-0.5F, -0.5F, -0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.04F)),
            PartPose.offset(0.0F, 0.0F, 1.0F)
        );

        PartDefinition gRightLung = bodyMain.addOrReplaceChild(
            "gRightLung",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(-1.5562F, 1.1F, 3.465F, 0.0F, 0.0F, -0.1309F)
        );

        PartDefinition lAirSac_r1 = gRightLung.addOrReplaceChild(
            "lAirSac_r1",
            CubeListBuilder.create()
                .texOffs(0, 22)
                .mirror()
                .addBox(-1.3597F, -0.5F, -0.7342F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 0.0F, 0.3054F, 0.0F)
        );

        PartDefinition lAirSac_r2 = gRightLung.addOrReplaceChild(
            "lAirSac_r2",
            CubeListBuilder.create()
                .texOffs(0, 22)
                .mirror()
                .addBox(-1.5926F, -0.5F, -1.1965F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, 0.0F, 0.5672F, 0.0F)
        );

        PartDefinition gLeftLung = bodyMain.addOrReplaceChild(
            "gLeftLung",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.5562F, 1.1F, 3.465F, 0.0F, 0.0F, 0.1309F)
        );

        PartDefinition lAirSac_r3 = gLeftLung.addOrReplaceChild(
            "lAirSac_r3",
            CubeListBuilder.create()
                .texOffs(0, 22)
                .addBox(-1.6403F, -0.5F, -0.7342F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 0.0F, -0.3054F, 0.0F)
        );

        PartDefinition lAirSac_r4 = gLeftLung.addOrReplaceChild(
            "lAirSac_r4",
            CubeListBuilder.create()
                .texOffs(0, 22)
                .addBox(-1.4074F, -0.5F, -1.1965F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 0.0F, -0.5672F, 0.0F)
        );

        PartDefinition gRightLegs = root.addOrReplaceChild(
            "gRightLegs",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, 24.0F, 0.0F)
        );

        PartDefinition gRightBackLegBase = gRightLegs.addOrReplaceChild(
            "gRightBackLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(-0.9F, -3.2F, 1.7F, 0.0F, 1.5708F, 0.0F)
        );

        PartDefinition rLeg1a_r1 = gRightBackLegBase.addOrReplaceChild(
            "rLeg1a_r1",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .mirror()
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -0.5F, 0.0076F, -0.0003F, 0.0869F)
        );

        PartDefinition gRightBackLeg = gRightBackLegBase.addOrReplaceChild(
            "gRightBackLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .mirror()
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightBackLowerLeg = gRightBackLeg.addOrReplaceChild(
            "gRightBackLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .mirror()
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(38, 15)
                .mirror()
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightMiddleBackLegBase = gRightLegs.addOrReplaceChild(
            "gRightMiddleBackLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(-0.9F, -3.2F, 0.7F, 0.0F, 1.3526F, 0.0F)
        );

        PartDefinition rLeg1a_r2 = gRightMiddleBackLegBase.addOrReplaceChild(
            "rLeg1a_r2",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .mirror()
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -0.5F, 0.0189F, -0.0008F, 0.0852F)
        );

        PartDefinition gRightMiddleBackLeg = gRightMiddleBackLegBase.addOrReplaceChild(
            "gRightMiddleBackLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .mirror()
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightMiddleBackLowerLeg = gRightMiddleBackLeg.addOrReplaceChild(
            "gRightMiddleBackLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .mirror()
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(38, 15)
                .mirror()
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightMiddleFrontLegBase = gRightLegs.addOrReplaceChild(
            "gRightMiddleFrontLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(-0.7F, -3.2F, -0.3F, 0.0F, 1.1345F, 0.0F)
        );

        PartDefinition rLeg1a_r3 = gRightMiddleFrontLegBase.addOrReplaceChild(
            "rLeg1a_r3",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .mirror()
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -0.5F, 0.0368F, -0.0015F, 0.0791F)
        );

        PartDefinition gRightMiddleFrontLeg = gRightMiddleFrontLegBase.addOrReplaceChild(
            "gRightMiddleFrontLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .mirror()
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightMiddleFrontLowerLeg = gRightMiddleFrontLeg.addOrReplaceChild(
            "gRightMiddleFrontLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .mirror()
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(38, 15)
                .mirror()
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gRightFrontLegBase = gRightLegs.addOrReplaceChild(
            "gRightFrontLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(-0.4F, -3.2F, -1.1F, 0.0F, 0.7854F, 0.0F)
        );

        PartDefinition rLeg1a_r4 = gRightFrontLegBase.addOrReplaceChild(
            "rLeg1a_r4",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .mirror()
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -0.5F, 0.0617F, -0.0019F, 0.0617F)
        );

        PartDefinition gRightFrontLeg = gRightFrontLegBase.addOrReplaceChild(
            "gRightFrontLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .mirror()
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightFrontLowerLeg = gRightFrontLeg.addOrReplaceChild(
            "gRightFrontLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .mirror()
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(38, 15)
                .mirror()
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftLegs = root.addOrReplaceChild(
            "gLeftLegs",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, 24.0F, 0.0F)
        );

        PartDefinition gLeftBackLegBase = gLeftLegs.addOrReplaceChild(
            "gLeftBackLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.9F, -3.2F, 1.7F, 0.0F, -1.5708F, 0.0F)
        );

        PartDefinition rLeg1a_r5 = gLeftBackLegBase.addOrReplaceChild(
            "rLeg1a_r5",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -0.5F, 0.0076F, 0.0003F, -0.0869F)
        );

        PartDefinition gLeftBackLeg = gLeftBackLegBase.addOrReplaceChild(
            "gLeftBackLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftBackLowerLeg = gLeftBackLeg.addOrReplaceChild(
            "gLeftBackLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 15)
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftMiddleBackLegBase = gLeftLegs.addOrReplaceChild(
            "gLeftMiddleBackLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.9F, -3.2F, 0.7F, 0.0F, -1.3526F, 0.0F)
        );

        PartDefinition rLeg1a_r6 = gLeftMiddleBackLegBase.addOrReplaceChild(
            "rLeg1a_r6",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -0.5F, 0.0189F, 0.0008F, -0.0852F)
        );

        PartDefinition gLeftMiddleBackLeg = gLeftMiddleBackLegBase.addOrReplaceChild(
            "gLeftMiddleBackLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftMiddleBackLowerLeg = gLeftMiddleBackLeg.addOrReplaceChild(
            "gLeftMiddleBackLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 15)
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftMiddleFrontLegBase = gLeftLegs.addOrReplaceChild(
            "gLeftMiddleFrontLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.7F, -3.2F, -0.3F, 0.0F, -1.1345F, 0.0F)
        );

        PartDefinition rLeg1a_r7 = gLeftMiddleFrontLegBase.addOrReplaceChild(
            "rLeg1a_r7",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -0.5F, 0.0368F, 0.0015F, -0.0791F)
        );

        PartDefinition gLeftMiddleFrontLeg = gLeftMiddleFrontLegBase.addOrReplaceChild(
            "gLeftMiddleFrontLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftMiddleFrontLowerLeg = gLeftMiddleFrontLeg.addOrReplaceChild(
            "gLeftMiddleFrontLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 15)
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFrontLegBase = gLeftLegs.addOrReplaceChild(
            "gLeftFrontLegBase",
            CubeListBuilder.create(),
            PartPose.offsetAndRotation(0.4F, -3.2F, -1.1F, 0.0F, -0.7854F, 0.0F)
        );

        PartDefinition rLeg1a_r8 = gLeftFrontLegBase.addOrReplaceChild(
            "rLeg1a_r8",
            CubeListBuilder.create()
                .texOffs(38, 0)
                .addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.05F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -0.5F, 0.0617F, 0.0019F, -0.0617F)
        );

        PartDefinition gLeftFrontLeg = gLeftFrontLegBase.addOrReplaceChild(
            "gLeftFrontLeg",
            CubeListBuilder.create()
                .texOffs(38, 4)
                .addBox(-0.5F, -0.5F, -2.9F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(-0.1F, 0.2F, -1.2F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFrontLowerLeg = gLeftFrontLeg.addOrReplaceChild(
            "gLeftFrontLowerLeg",
            CubeListBuilder.create()
                .texOffs(38, 9)
                .addBox(-0.5F, -0.5F, -0.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 15)
                .addBox(-0.5F, 3.3F, -0.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, -2.8F, 0.0F, 0.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(
        Facehugger entity,
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
