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
import org.avp.common.entity.living.Dracomorph;

public class DracomorphModel extends EntityModel<Dracomorph> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into
    // this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        AVPResources.location("dracomorph"),
        "main"
    );

    private final ModelPart root;

    public DracomorphModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
            "root",
            CubeListBuilder.create(),
            PartPose.offset(0.0F, 0.4F, -1.0F)
        );

        PartDefinition gChest = root.addOrReplaceChild(
            "gChest",
            CubeListBuilder.create()
                .texOffs(0, 67)
                .addBox(0.0F, -5.8F, 1.5F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(1, 55)
                .addBox(-5.0F, 0.0F, 0.0F, 10.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -2.5F, -9.0F)
        );

        PartDefinition lShoulderBlade_r1 = gChest.addOrReplaceChild(
            "lShoulderBlade_r1",
            CubeListBuilder.create()
                .texOffs(146, 34)
                .mirror()
                .addBox(-5.6424F, -2.4422F, -4.6468F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 2.4507F, 0.5655F, 1.69F, 0.2196F, -0.1349F)
        );

        PartDefinition lShoulderBlade_r2 = gChest.addOrReplaceChild(
            "lShoulderBlade_r2",
            CubeListBuilder.create()
                .texOffs(146, 34)
                .addBox(3.6424F, -2.4422F, -4.6468F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 2.4507F, 0.5655F, 1.69F, -0.2196F, 0.1349F)
        );

        PartDefinition rWingArm2_r1 = gChest.addOrReplaceChild(
            "rWingArm2_r1",
            CubeListBuilder.create()
                .texOffs(41, 27)
                .addBox(-1.0F, -4.5F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(-3.9664F, -3.001F, 5.102F, 0.273F, -0.0556F, 2.6731F)
        );

        PartDefinition rWingArm3_r1 = gChest.addOrReplaceChild(
            "rWingArm3_r1",
            CubeListBuilder.create()
                .texOffs(41, 27)
                .addBox(-1.0F, -4.5F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(-3.7215F, -3.0245F, 9.2159F, 0.4912F, -0.0556F, 2.6731F)
        );

        PartDefinition rWingArm3_r2 = gChest.addOrReplaceChild(
            "rWingArm3_r2",
            CubeListBuilder.create()
                .texOffs(41, 27)
                .mirror()
                .addBox(-1.0F, -4.5F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(-0.25F))
                .mirror(false),
            PartPose.offsetAndRotation(3.9664F, -3.001F, 5.102F, 0.273F, 0.0556F, -2.6731F)
        );

        PartDefinition rWingArm4_r1 = gChest.addOrReplaceChild(
            "rWingArm4_r1",
            CubeListBuilder.create()
                .texOffs(41, 27)
                .mirror()
                .addBox(-1.0F, -4.5F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(-0.25F))
                .mirror(false),
            PartPose.offsetAndRotation(3.7215F, -3.0245F, 9.2159F, 0.4912F, 0.0556F, -2.6731F)
        );

        PartDefinition gNeck = gChest.addOrReplaceChild(
            "gNeck",
            CubeListBuilder.create()
                .texOffs(23, 86)
                .addBox(-3.0F, -3.5F, -6.2F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 3.4F, 2.3F, -0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gNeckEnd = gNeck.addOrReplaceChild(
            "gNeckEnd",
            CubeListBuilder.create()
                .texOffs(65, 86)
                .addBox(-2.5F, -3.0F, -4.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -0.2F, -6.2F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gHead = gNeckEnd.addOrReplaceChild(
            "gHead",
            CubeListBuilder.create()
                .texOffs(0, 0)
                .addBox(-2.5F, -3.2F, -4.7F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offset(0.0F, -0.8F, -4.3F)
        );

        PartDefinition lHead_r1 = gHead.addOrReplaceChild(
            "lHead_r1",
            CubeListBuilder.create()
                .texOffs(53, 0)
                .mirror()
                .addBox(-0.5F, -19.0F, -15.1F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(53, 0)
                .addBox(1.5F, -19.0F, -15.1F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-2.0F, 16.2144F, 17.6692F, 0.5009F, 0.0F, 0.0F)
        );

        PartDefinition gDome = gHead.addOrReplaceChild(
            "gDome",
            CubeListBuilder.create()
                .texOffs(28, 10)
                .addBox(-2.5F, -10.1476F, -1.2626F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -2.6476F, -3.5626F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition backSpines1_r1 = gDome.addOrReplaceChild(
            "backSpines1_r1",
            CubeListBuilder.create()
                .texOffs(0, 67)
                .addBox(0.0F, -2.5F, -3.6F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -3.4524F, -1.7374F, 1.5708F, 0.0F, 0.0F)
        );

        PartDefinition gRightHorns = gHead.addOrReplaceChild(
            "gRightHorns",
            CubeListBuilder.create(),
            PartPose.offset(-0.75F, -3.4894F, -2.1129F)
        );

        PartDefinition lHorn6_r1 = gRightHorns.addOrReplaceChild(
            "lHorn6_r1",
            CubeListBuilder.create()
                .texOffs(238, 44)
                .mirror()
                .addBox(-0.9624F, -5.0147F, 0.0519F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.8934F, -8.2082F, 1.6597F, -0.0981F, -0.1314F, -0.067F)
        );

        PartDefinition lHorn5_r1 = gRightHorns.addOrReplaceChild(
            "lHorn5_r1",
            CubeListBuilder.create()
                .texOffs(228, 41)
                .mirror()
                .addBox(-0.7588F, -1.582F, -1.0429F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.8934F, -8.2082F, 1.6597F, -0.4444F, -0.1431F, -0.1986F)
        );

        PartDefinition lHorn7_r1 = gRightHorns.addOrReplaceChild(
            "lHorn7_r1",
            CubeListBuilder.create()
                .texOffs(238, 44)
                .mirror()
                .addBox(-2.9987F, -7.2762F, 4.3644F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.75F, -3.0093F, -1.287F, -0.5333F, -0.9272F, 0.3093F)
        );

        PartDefinition lHorn4_r1 = gRightHorns.addOrReplaceChild(
            "lHorn4_r1",
            CubeListBuilder.create()
                .texOffs(219, 42)
                .mirror()
                .addBox(-0.9086F, 1.0114F, -1.6094F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F))
                .mirror(false),
            PartPose.offsetAndRotation(-2.8934F, -8.2082F, 1.6597F, -0.0324F, -0.2126F, -0.3413F)
        );

        PartDefinition lHorn6_r2 = gRightHorns.addOrReplaceChild(
            "lHorn6_r2",
            CubeListBuilder.create()
                .texOffs(228, 41)
                .mirror()
                .addBox(-2.4825F, -5.4617F, 2.0932F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.75F, -3.0093F, -1.287F, -0.7303F, -0.9843F, 0.1047F)
        );

        PartDefinition lHorn4_r2 = gRightHorns.addOrReplaceChild(
            "lHorn4_r2",
            CubeListBuilder.create()
                .texOffs(207, 41)
                .mirror()
                .addBox(-2.9173F, 0.1337F, 2.9863F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F))
                .mirror(false),
            PartPose.offsetAndRotation(0.75F, -3.0093F, -1.287F, 0.3606F, -0.9877F, -1.0052F)
        );

        PartDefinition lHeadFin_r1 = gRightHorns.addOrReplaceChild(
            "lHeadFin_r1",
            CubeListBuilder.create()
                .texOffs(43, 111)
                .addBox(-3.5F, -7.5F, 0.0F, 7.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-5.0774F, -4.4182F, 2.8454F, -2.7691F, -0.1734F, 2.9829F)
        );

        PartDefinition lHorn5_r2 = gRightHorns.addOrReplaceChild(
            "lHorn5_r2",
            CubeListBuilder.create()
                .texOffs(219, 42)
                .mirror()
                .addBox(-1.9927F, -1.6009F, 2.847F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F))
                .mirror(false),
            PartPose.offsetAndRotation(0.75F, -3.0093F, -1.287F, -0.1344F, -1.0801F, -0.1383F)
        );

        PartDefinition gLeftHorns = gHead.addOrReplaceChild(
            "gLeftHorns",
            CubeListBuilder.create(),
            PartPose.offset(0.75F, -3.4894F, -2.1129F)
        );

        PartDefinition lHorn7_r2 = gLeftHorns.addOrReplaceChild(
            "lHorn7_r2",
            CubeListBuilder.create()
                .texOffs(238, 44)
                .addBox(-0.0376F, -5.0147F, 0.0519F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(2.8934F, -8.2082F, 1.6597F, -0.0981F, 0.1314F, 0.067F)
        );

        PartDefinition lHorn6_r3 = gLeftHorns.addOrReplaceChild(
            "lHorn6_r3",
            CubeListBuilder.create()
                .texOffs(228, 41)
                .addBox(-0.2412F, -1.582F, -1.0429F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(2.8934F, -8.2082F, 1.6597F, -0.4444F, 0.1431F, 0.1986F)
        );

        PartDefinition lHorn8_r1 = gLeftHorns.addOrReplaceChild(
            "lHorn8_r1",
            CubeListBuilder.create()
                .texOffs(238, 44)
                .addBox(1.9987F, -7.2762F, 4.3644F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.75F, -3.0093F, -1.287F, -0.5333F, 0.9272F, -0.3093F)
        );

        PartDefinition lHorn5_r3 = gLeftHorns.addOrReplaceChild(
            "lHorn5_r3",
            CubeListBuilder.create()
                .texOffs(219, 42)
                .addBox(-0.0914F, 1.0114F, -1.6094F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F)),
            PartPose.offsetAndRotation(2.8934F, -8.2082F, 1.6597F, -0.0324F, 0.2126F, 0.3413F)
        );

        PartDefinition lHorn7_r3 = gLeftHorns.addOrReplaceChild(
            "lHorn7_r3",
            CubeListBuilder.create()
                .texOffs(228, 41)
                .addBox(1.4825F, -5.4617F, 2.0932F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(-0.75F, -3.0093F, -1.287F, -0.7303F, 0.9843F, -0.1047F)
        );

        PartDefinition lHorn5_r4 = gLeftHorns.addOrReplaceChild(
            "lHorn5_r4",
            CubeListBuilder.create()
                .texOffs(207, 41)
                .addBox(0.9173F, 0.1337F, 2.9863F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)),
            PartPose.offsetAndRotation(-0.75F, -3.0093F, -1.287F, 0.3606F, 0.9877F, 1.0052F)
        );

        PartDefinition lHeadFin_r2 = gLeftHorns.addOrReplaceChild(
            "lHeadFin_r2",
            CubeListBuilder.create()
                .texOffs(43, 111)
                .mirror()
                .addBox(-3.5F, -7.5F, 0.0F, 7.0F, 15.0F, 0.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(5.0774F, -4.4182F, 2.8454F, -2.7691F, 0.1734F, -2.9829F)
        );

        PartDefinition lHorn6_r4 = gLeftHorns.addOrReplaceChild(
            "lHorn6_r4",
            CubeListBuilder.create()
                .texOffs(219, 42)
                .addBox(0.9927F, -1.6009F, 2.847F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F)),
            PartPose.offsetAndRotation(-0.75F, -3.0093F, -1.287F, -0.1344F, 1.0801F, 0.1383F)
        );

        PartDefinition gMouth = gHead.addOrReplaceChild(
            "gMouth",
            CubeListBuilder.create()
                .texOffs(52, 20)
                .addBox(-1.5F, -0.5F, -2.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, 8.1465F, -0.9455F, 0.6545F, 0.0F, 0.0F)
        );

        PartDefinition gJawLower = gMouth.addOrReplaceChild(
            "gJawLower",
            CubeListBuilder.create()
                .texOffs(88, 1)
                .addBox(-1.5F, 0.0193F, -4.4717F, 3.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)),
            PartPose.offset(0.0F, 0.3807F, 1.9717F)
        );

        PartDefinition gInnerJaw = gJawLower.addOrReplaceChild(
            "gInnerJaw",
            CubeListBuilder.create()
                .texOffs(1, 19)
                .addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(0.0F, -0.0447F, -0.3182F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightArm = gChest.addOrReplaceChild(
            "gRightArm",
            CubeListBuilder.create()
                .texOffs(103, 6)
                .mirror()
                .addBox(-1.5F, -1.5F, -10.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-4.9F, 3.9F, 3.6F, 1.9635F, 0.0F, 0.0F)
        );

        PartDefinition gRightForearm = gRightArm.addOrReplaceChild(
            "gRightForearm",
            CubeListBuilder.create()
                .texOffs(50, 85)
                .mirror()
                .addBox(-1.7F, -0.3F, -1.4F, 3.0F, 14.0F, 3.0F, new CubeDeformation(-0.35F))
                .mirror(false),
            PartPose.offsetAndRotation(0.2F, 0.4F, -10.25F, -2.3562F, 0.0F, 0.0F)
        );

        PartDefinition gRightHand = gRightForearm.addOrReplaceChild(
            "gRightHand",
            CubeListBuilder.create()
                .texOffs(72, 24)
                .mirror()
                .addBox(-1.25F, -0.6F, -2.75F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.05F, 13.7F, 0.25F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition rClaw3_r1 = gRightHand.addOrReplaceChild(
            "rClaw3_r1",
            CubeListBuilder.create()
                .texOffs(60, 38)
                .mirror()
                .addBox(-1.5F, 0.0F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.25F, -0.2F, -1.25F, 0.0349F, 0.0F, 0.0F)
        );

        PartDefinition gLeftArm = gChest.addOrReplaceChild(
            "gLeftArm",
            CubeListBuilder.create()
                .texOffs(103, 6)
                .addBox(-1.5F, -1.5F, -10.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(4.9F, 3.9F, 3.6F, 1.9635F, 0.0F, 0.0F)
        );

        PartDefinition gLeftForearm = gLeftArm.addOrReplaceChild(
            "gLeftForearm",
            CubeListBuilder.create()
                .texOffs(50, 85)
                .addBox(-1.3F, -0.3F, -1.4F, 3.0F, 14.0F, 3.0F, new CubeDeformation(-0.35F)),
            PartPose.offsetAndRotation(-0.2F, 0.4F, -10.25F, -2.3562F, 0.0F, 0.0F)
        );

        PartDefinition gLeftHand = gLeftForearm.addOrReplaceChild(
            "gLeftHand",
            CubeListBuilder.create()
                .texOffs(72, 24)
                .addBox(-0.75F, -0.6F, -2.75F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(-0.05F, 13.7F, 0.25F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition rClaw4_r1 = gLeftHand.addOrReplaceChild(
            "rClaw4_r1",
            CubeListBuilder.create()
                .texOffs(60, 38)
                .addBox(-1.5F, 0.0F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.25F, -0.2F, -1.25F, 0.0349F, 0.0F, 0.0F)
        );

        PartDefinition gRightWingArm = gChest.addOrReplaceChild(
            "gRightWingArm",
            CubeListBuilder.create()
                .texOffs(134, 0)
                .addBox(-1.0F, -9.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(-0.25F)),
            PartPose.offsetAndRotation(-4.3F, 0.2F, 4.3F, -0.7854F, 0.0F, -0.7854F)
        );

        PartDefinition gRightWingForearm = gRightWingArm.addOrReplaceChild(
            "gRightWingForearm",
            CubeListBuilder.create()
                .texOffs(149, 0)
                .addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 2.7489F, 0.0F, 0.0F)
        );

        PartDefinition gRightWingHand = gRightWingForearm.addOrReplaceChild(
            "gRightWingHand",
            CubeListBuilder.create()
                .texOffs(188, 8)
                .mirror()
                .addBox(0.0F, 0.0F, 0.7F, 0.0F, 15.0F, 9.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(174, 0)
                .addBox(-0.5F, -1.1F, 0.0F, 1.0F, 2.0F, 9.0F, new CubeDeformation(-0.1F)),
            PartPose.offsetAndRotation(0.0F, 0.0F, 9.4F, -1.5708F, 0.0F, 0.0F)
        );

        PartDefinition gRightWingEnd = gRightWingHand.addOrReplaceChild(
            "gRightWingEnd",
            CubeListBuilder.create()
                .texOffs(208, 3)
                .mirror()
                .addBox(-0.1F, 0.0F, 1.4F, 0.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(200, 0)
                .addBox(-0.5F, -0.7F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 8.3F)
        );

        PartDefinition gLeftWingArm = gChest.addOrReplaceChild(
            "gLeftWingArm",
            CubeListBuilder.create()
                .texOffs(134, 0)
                .mirror()
                .addBox(-1.0F, -9.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(-0.25F))
                .mirror(false),
            PartPose.offsetAndRotation(4.3F, 0.2F, 4.3F, -0.7854F, 0.0F, 0.7854F)
        );

        PartDefinition gLeftWingForearm = gLeftWingArm.addOrReplaceChild(
            "gLeftWingForearm",
            CubeListBuilder.create()
                .texOffs(149, 0)
                .mirror()
                .addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 2.7489F, 0.0F, 0.0F)
        );

        PartDefinition gLeftWingHand = gLeftWingForearm.addOrReplaceChild(
            "gLeftWingHand",
            CubeListBuilder.create()
                .texOffs(188, 8)
                .addBox(0.0F, 0.0F, 0.7F, 0.0F, 15.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(174, 0)
                .mirror()
                .addBox(-0.5F, -1.1F, 0.0F, 1.0F, 2.0F, 9.0F, new CubeDeformation(-0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 0.0F, 9.4F, -1.5708F, 0.0F, 0.0F)
        );

        PartDefinition gLeftWingEnd = gLeftWingHand.addOrReplaceChild(
            "gLeftWingEnd",
            CubeListBuilder.create()
                .texOffs(208, 3)
                .addBox(0.1F, 0.0F, 1.4F, 0.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(200, 0)
                .mirror()
                .addBox(-0.5F, -0.7F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(0.0F, 0.0F, 8.3F)
        );

        PartDefinition gStomach = gChest.addOrReplaceChild(
            "gStomach",
            CubeListBuilder.create()
                .texOffs(22, 65)
                .addBox(0.0F, -8.75F, -2.35F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 27)
                .addBox(-3.5F, -3.0F, -2.25F, 7.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 3.5F, 11.85F)
        );

        PartDefinition gLeftThigh = gStomach.addOrReplaceChild(
            "gLeftThigh",
            CubeListBuilder.create()
                .texOffs(59, 45)
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(3.0F, 1.0F, 6.65F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftShin = gLeftThigh.addOrReplaceChild(
            "gLeftShin",
            CubeListBuilder.create()
                .texOffs(79, 33)
                .addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 11.5F, 0.0F)
        );

        PartDefinition gLeftAnkle = gLeftShin.addOrReplaceChild(
            "gLeftAnkle",
            CubeListBuilder.create()
                .texOffs(113, 53)
                .addBox(-1.0F, -0.2F, -1.1F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
            PartPose.offsetAndRotation(0.2F, 0.0F, 10.9F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gLeftFoot = gLeftAnkle.addOrReplaceChild(
            "gLeftFoot",
            CubeListBuilder.create()
                .texOffs(95, 24)
                .addBox(-1.0F, -1.0F, -4.4F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gRightThigh = gStomach.addOrReplaceChild(
            "gRightThigh",
            CubeListBuilder.create()
                .texOffs(59, 45)
                .mirror()
                .addBox(-2.0F, -2.0F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-3.0F, 1.0F, 6.65F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightShin = gRightThigh.addOrReplaceChild(
            "gRightShin",
            CubeListBuilder.create()
                .texOffs(79, 33)
                .mirror()
                .addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offset(0.0F, 11.5F, 0.0F)
        );

        PartDefinition gRightAnkle = gRightShin.addOrReplaceChild(
            "gRightAnkle",
            CubeListBuilder.create()
                .texOffs(113, 53)
                .mirror()
                .addBox(-1.0F, -0.2F, -1.1F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
                .mirror(false),
            PartPose.offsetAndRotation(-0.2F, 0.0F, 10.9F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gRightFoot = gRightAnkle.addOrReplaceChild(
            "gRightFoot",
            CubeListBuilder.create()
                .texOffs(95, 24)
                .mirror()
                .addBox(-1.0F, -1.0F, -4.4F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.1F))
                .mirror(false),
            PartPose.offsetAndRotation(0.0F, 8.2F, 0.0F, 0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gSack1 = gStomach.addOrReplaceChild(
            "gSack1",
            CubeListBuilder.create()
                .texOffs(0, 87)
                .addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.0F, 1.7F, 5.85F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gSack2 = gSack1.addOrReplaceChild(
            "gSack2",
            CubeListBuilder.create()
                .texOffs(0, 98)
                .addBox(-3.5F, -3.0F, -0.3F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.1F)),
            PartPose.offset(0.0F, 0.2F, 4.5F)
        );

        PartDefinition gSack3 = gSack2.addOrReplaceChild(
            "gSack3",
            CubeListBuilder.create()
                .texOffs(0, 111)
                .addBox(-5.0F, -4.5F, -0.5F, 10.0F, 9.0F, 8.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.0F, 0.5F, 4.75F, 0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gSack4 = gSack3.addOrReplaceChild(
            "gSack4",
            CubeListBuilder.create()
                .texOffs(84, 82)
                .addBox(-5.5F, -5.0F, -0.1F, 11.0F, 10.0F, 11.0F, new CubeDeformation(0.35F)),
            PartPose.offset(0.0F, 0.2F, 7.7F)
        );

        PartDefinition gSack5 = gSack4.addOrReplaceChild(
            "gSack5",
            CubeListBuilder.create()
                .texOffs(132, 82)
                .addBox(-4.5F, -5.0F, 0.1F, 9.0F, 10.0F, 10.0F, new CubeDeformation(0.1F)),
            PartPose.offset(0.0F, 0.1F, 10.7F)
        );

        PartDefinition gSack6 = gSack5.addOrReplaceChild(
            "gSack6",
            CubeListBuilder.create()
                .texOffs(177, 83)
                .addBox(-3.5F, -4.0F, -0.1F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.1F)),
            PartPose.offset(0.0F, 0.0F, 10.0F)
        );

        PartDefinition gSack7 = gSack6.addOrReplaceChild(
            "gSack7",
            CubeListBuilder.create()
                .texOffs(217, 90)
                .addBox(-2.5F, -3.0F, 0.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(-0.2F, 0.05F, 7.7F, -0.3927F, 0.0F, 0.0F)
        );

        PartDefinition gSack8 = gSack7.addOrReplaceChild(
            "gSack8",
            CubeListBuilder.create()
                .texOffs(215, 108)
                .addBox(-1.5F, -1.5F, -0.2F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)),
            PartPose.offsetAndRotation(0.2F, -0.1F, 7.1F, -0.7854F, 0.0F, 0.0F)
        );

        PartDefinition gTail1 = gStomach.addOrReplaceChild(
            "gTail1",
            CubeListBuilder.create()
                .texOffs(50, 66)
                .addBox(-2.0F, -2.5F, 0.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(58, 94)
                .addBox(0.0F, -5.5F, 0.0F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 9.55F)
        );

        PartDefinition gTail2 = gTail1.addOrReplaceChild(
            "gTail2",
            CubeListBuilder.create()
                .texOffs(85, 66)
                .addBox(-2.0F, -2.5F, -0.1F, 4.0F, 4.0F, 11.0F, new CubeDeformation(-0.25F))
                .texOffs(89, 94)
                .addBox(0.0F, -4.9F, -0.5F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, 0.0F, 11.0F)
        );

        PartDefinition gTail3 = gTail2.addOrReplaceChild(
            "gTail3",
            CubeListBuilder.create()
                .texOffs(117, 94)
                .addBox(0.0F, -4.1F, 0.7F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(118, 66)
                .addBox(-1.5F, -1.8F, 0.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -0.3F, 10.6F)
        );

        PartDefinition gTail4 = gTail3.addOrReplaceChild(
            "gTail4",
            CubeListBuilder.create()
                .texOffs(148, 96)
                .addBox(0.0F, -5.5F, 0.9F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(149, 66)
                .addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.25F)),
            PartPose.offset(0.0F, -0.3F, 10.9F)
        );

        PartDefinition gTail5 = gTail4.addOrReplaceChild(
            "gTail5",
            CubeListBuilder.create()
                .texOffs(178, 96)
                .addBox(0.0F, -6.6F, -0.2F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(178, 66)
                .addBox(-0.5F, -0.7F, 0.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.25F)),
            PartPose.offset(0.0F, 0.1F, 11.0F)
        );

        PartDefinition gTailBlade = gTail5.addOrReplaceChild(
            "gTailBlade",
            CubeListBuilder.create()
                .texOffs(205, 66)
                .addBox(0.0F, -3.0F, -0.4F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)),
            PartPose.offset(0.0F, -0.2F, 11.3F)
        );

        return LayerDefinition.create(meshdefinition, 256, 128);
    }

    @Override
    public void setupAnim(
        Dracomorph entity,
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
