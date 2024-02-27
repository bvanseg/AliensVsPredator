package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

import org.avp.common.entity.BelugamorphEntity;

public class BelugamorphModel extends EntityModel<BelugamorphEntity> {

    private final RendererModel root;

    private final RendererModel gChest;

    private final RendererModel gNeck;

    private final RendererModel gHead;

    private final RendererModel chest_r1;

    private final RendererModel chest_r2;

    private final RendererModel chest_r3;

    private final RendererModel chest_r4;

    private final RendererModel chest_r5;

    private final RendererModel chest_r6;

    private final RendererModel chest_r7;

    private final RendererModel chest_r8;

    private final RendererModel chest_r9;

    private final RendererModel chest_r10;

    private final RendererModel gLowerJaw;

    private final RendererModel gLowerInnerJaw;

    private final RendererModel gUpperJaw;

    private final RendererModel gUpperInnerJaw;

    private final RendererModel gSmallDorsalTube;

    private final RendererModel quill2AChild_r1;

    private final RendererModel quill2C_r1;

    private final RendererModel gBigDorsalTube;

    private final RendererModel chest_r11;

    private final RendererModel chest_r12;

    private final RendererModel chest_r13;

    private final RendererModel gLowerLeftDorsalTube;

    private final RendererModel chest_r14;

    private final RendererModel chest_r15;

    private final RendererModel chest_r16;

    private final RendererModel gLowerRightDorsalTube;

    private final RendererModel chest_r17;

    private final RendererModel chest_r18;

    private final RendererModel chest_r19;

    private final RendererModel gLeftShoulder;

    private final RendererModel gLeftBicep;

    private final RendererModel gLeftForearm;

    private final RendererModel chest_r20;

    private final RendererModel gLeftWrist;

    private final RendererModel gLeftFinger1;

    private final RendererModel gLeftFinger2;

    private final RendererModel gLeftFinger3;

    private final RendererModel gLeftFinger4;

    private final RendererModel gLeftThumb;

    private final RendererModel gRightShoulder;

    private final RendererModel gRightBicep;

    private final RendererModel gRightForearm;

    private final RendererModel chest_r21;

    private final RendererModel gRightWrist;

    private final RendererModel gRightFinger1;

    private final RendererModel gRightFinger2;

    private final RendererModel gRightFinger3;

    private final RendererModel gRightFinger4;

    private final RendererModel gRightThumb;

    private final RendererModel gLowerChest;

    private final RendererModel chest_r22;

    private final RendererModel chest_r23;

    private final RendererModel gStomach;

    private final RendererModel gRightThigh;

    private final RendererModel gRightShin;

    private final RendererModel gRightAnkle;

    private final RendererModel gRightFoot;

    private final RendererModel gRightToes;

    private final RendererModel gLeftThigh;

    private final RendererModel gLeftShin;

    private final RendererModel gLeftAnkle;

    private final RendererModel gLeftFoot;

    private final RendererModel gLeftToes;

    public BelugamorphModel() {
        textureWidth = 128;
        textureHeight = 64;

        root = new RendererModel(this);
        root.setRotationPoint(0.0F, 22.9F, 0.0F);

        gChest = new RendererModel(this);
        gChest.setRotationPoint(0.5F, -32.2F, 0.0F);
        root.addChild(gChest);
        gChest.cubeList.add(new ModelBox(gChest, 37, 50, -0.5F, -4.9F, 2.3F, 0, 7, 3, 0.0F, false));
        gChest.cubeList.add(new ModelBox(gChest, 0, 10, -4.0F, -9.0F, -3.5F, 7, 8, 7, 0.0F, false));

        gNeck = new RendererModel(this);
        gNeck.setRotationPoint(-0.5F, -8.7F, 0.0F);
        gChest.addChild(gNeck);
        gNeck.cubeList.add(new ModelBox(gNeck, 0, 0, -2.0F, -3.2F, -2.0F, 4, 4, 4, 0.0F, false));

        gHead = new RendererModel(this);
        gHead.setRotationPoint(0.0423F, -3.7132F, -0.1814F);
        gNeck.addChild(gHead);
        gHead.cubeList.add(new ModelBox(gHead, 20, 0, -1.5423F, -1.5868F, 3.0814F, 3, 2, 4, 0.0F, false));
        gHead.cubeList.add(new ModelBox(gHead, 60, 20, -2.5423F, -3.4868F, -3.2186F, 5, 4, 7, 0.0F, false));

        chest_r1 = new RendererModel(this);
        chest_r1.setRotationPoint(-0.0423F, 41.7679F, -11.144F);
        gHead.addChild(chest_r1);
        setRotationAngle(chest_r1, -0.2731F, 0.0F, 0.0F);
        chest_r1.cubeList.add(new ModelBox(chest_r1, 106, 19, -2.5F, -44.3F, -6.65F, 5, 2, 2, 0.0F, true));

        chest_r2 = new RendererModel(this);
        chest_r2.setRotationPoint(-0.0423F, 38.054F, 21.2849F);
        gHead.addChild(chest_r2);
        setRotationAngle(chest_r2, 0.4554F, 0.0F, 0.0F);
        chest_r2.cubeList.add(new ModelBox(chest_r2, 101, 27, -2.3F, -46.9F, -7.55F, 4, 1, 3, 0.0F, false));
        chest_r2.cubeList.add(new ModelBox(chest_r2, 117, 27, 1.35F, -46.9F, -7.55F, 1, 1, 3, 0.0F, false));

        chest_r3 = new RendererModel(this);
        chest_r3.setRotationPoint(-0.0423F, 45.2116F, -6.8461F);
        gHead.addChild(chest_r3);
        setRotationAngle(chest_r3, -0.1365F, 0.0F, 0.0F);
        chest_r3.cubeList.add(new ModelBox(chest_r3, 104, 53, -2.5F, -48.7F, -3.7F, 5, 1, 1, 0.0F, false));

        chest_r4 = new RendererModel(this);
        chest_r4.setRotationPoint(-0.0423F, 37.492F, 22.2538F);
        gHead.addChild(chest_r4);
        setRotationAngle(chest_r4, 0.5009F, 0.0F, 0.0F);
        chest_r4.cubeList.add(new ModelBox(chest_r4, 101, 9, -2.65F, -48.6F, -5.1F, 2, 4, 2, 0.0F, false));

        chest_r5 = new RendererModel(this);
        chest_r5.setRotationPoint(-0.0423F, 37.492F, 22.2538F);
        gHead.addChild(chest_r5);
        setRotationAngle(chest_r5, 0.5009F, 0.0F, 0.0F);
        chest_r5.cubeList.add(new ModelBox(chest_r5, 112, 9, -1.35F, -48.6F, -5.1F, 4, 4, 2, 0.0F, false));

        chest_r6 = new RendererModel(this);
        chest_r6.setRotationPoint(-0.0423F, 43.5665F, -6.237F);
        gHead.addChild(chest_r6);
        setRotationAngle(chest_r6, -0.1367F, 0.0F, 0.0F);
        chest_r6.cubeList.add(new ModelBox(chest_r6, 28, 14, -0.5F, -45.61F, 10.1F, 1, 1, 2, 0.0F, false));

        chest_r7 = new RendererModel(this);
        chest_r7.setRotationPoint(-0.0423F, 40.8929F, -11.9853F);
        gHead.addChild(chest_r7);
        setRotationAngle(chest_r7, -0.2733F, 0.0F, 0.0F);
        chest_r7.cubeList.add(new ModelBox(chest_r7, 59, 52, -1.0F, -47.2F, 9.5F, 2, 2, 5, 0.0F, false));

        chest_r8 = new RendererModel(this);
        chest_r8.setRotationPoint(-0.0423F, 43.3597F, -6.1002F);
        gHead.addChild(chest_r8);
        setRotationAngle(chest_r8, -0.1367F, 0.0F, 0.0F);
        chest_r8.cubeList.add(new ModelBox(chest_r8, 24, 7, -1.0F, -46.31F, 7.0F, 2, 2, 3, 0.0F, false));

        chest_r9 = new RendererModel(this);
        chest_r9.setRotationPoint(-0.0423F, 42.6859F, -8.0817F);
        gHead.addChild(chest_r9);
        setRotationAngle(chest_r9, -0.1822F, 0.0F, 0.0F);
        chest_r9.cubeList.add(new ModelBox(chest_r9, 59, 44, -1.5F, -47.2F, 7.0F, 3, 2, 3, 0.0F, false));

        chest_r10 = new RendererModel(this);
        chest_r10.setRotationPoint(-0.0423F, 43.3348F, -6.0546F);
        gHead.addChild(chest_r10);
        setRotationAngle(chest_r10, -0.1367F, 0.0F, 0.0F);
        chest_r10.cubeList.add(new ModelBox(chest_r10, 58, 34, -2.0F, -47.5F, 3.3F, 4, 3, 4, 0.0F, false));

        gLowerJaw = new RendererModel(this);
        gLowerJaw.setRotationPoint(0.3577F, 0.5951F, -2.393F);
        gHead.addChild(gLowerJaw);
        setRotationAngle(gLowerJaw, 0.0115F, 0.0F, 0.0F);
        gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 110, 45, -2.2F, -0.1F, -3.0F, 1, 1, 3, 0.0F, true));
        gLowerJaw.cubeList.add(new ModelBox(gLowerJaw, 94, 45, -1.6F, -0.1F, -3.0F, 3, 1, 3, 0.0F, true));

        gLowerInnerJaw = new RendererModel(this);
        gLowerInnerJaw.setRotationPoint(-0.4F, -0.3F, -2.1F);
        gLowerJaw.addChild(gLowerInnerJaw);
        gLowerInnerJaw.cubeList.add(new ModelBox(gLowerInnerJaw, 81, 57, -1.5F, -0.8F, -0.8F, 3, 1, 2, 0.0F, false));

        gUpperJaw = new RendererModel(this);
        gUpperJaw.setRotationPoint(-0.0423F, 1.063F, -0.5407F);
        gHead.addChild(gUpperJaw);
        setRotationAngle(gUpperJaw, -0.0454F, 0.0F, 0.0F);
        gUpperJaw.cubeList.add(new ModelBox(gUpperJaw, 104, 36, -2.0F, -2.1F, -5.0F, 4, 2, 4, 0.0F, false));

        gUpperInnerJaw = new RendererModel(this);
        gUpperInnerJaw.setRotationPoint(0.9F, 0.15F, -3.11F);
        gUpperJaw.addChild(gUpperInnerJaw);
        gUpperInnerJaw.cubeList.add(new ModelBox(gUpperInnerJaw, 87, 50, -0.25F, -0.8F, -1.69F, 1, 1, 3, 0.0F, false));
        gUpperInnerJaw.cubeList.add(new ModelBox(gUpperInnerJaw, 73, 50, -2.55F, -0.8F, -1.69F, 3, 1, 3, 0.0F, false));

        gSmallDorsalTube = new RendererModel(this);
        gSmallDorsalTube.setRotationPoint(-0.5F, -7.8F, 2.7F);
        gChest.addChild(gSmallDorsalTube);
        setRotationAngle(gSmallDorsalTube, 0.6318F, 0.0F, 0.0F);
        gSmallDorsalTube.cubeList.add(
            new ModelBox(gSmallDorsalTube, 1, 51, -1.0F, -1.0F, -0.4F, 2, 2, 3, -0.1F, false)
        );

        quill2AChild_r1 = new RendererModel(this);
        quill2AChild_r1.setRotationPoint(0.0F, -0.1978F, 3.6409F);
        gSmallDorsalTube.addChild(quill2AChild_r1);
        setRotationAngle(quill2AChild_r1, -0.222F, 0.0F, 0.0F);
        quill2AChild_r1.cubeList.add(new ModelBox(quill2AChild_r1, 13, 50, -0.5F, -0.5F, -1.5F, 1, 1, 3, -0.1F, false));

        quill2C_r1 = new RendererModel(this);
        quill2C_r1.setRotationPoint(0.0F, 0.3542F, 3.0884F);
        gSmallDorsalTube.addChild(quill2C_r1);
        setRotationAngle(quill2C_r1, -0.0911F, 0.0F, 0.0F);
        quill2C_r1.cubeList.add(new ModelBox(quill2C_r1, 24, 43, -0.5F, -0.5F, -2.5F, 1, 1, 5, 0.0F, false));

        gBigDorsalTube = new RendererModel(this);
        gBigDorsalTube.setRotationPoint(-0.5F, -6.7F, 3.0F);
        gChest.addChild(gBigDorsalTube);
        setRotationAngle(gBigDorsalTube, 0.055F, 0.0F, 0.0F);
        gBigDorsalTube.cubeList.add(new ModelBox(gBigDorsalTube, 0, 42, -1.0F, -1.5F, -0.4F, 2, 3, 4, 0.0F, false));

        chest_r11 = new RendererModel(this);
        chest_r11.setRotationPoint(0.0F, 0.2169F, 8.364F);
        gBigDorsalTube.addChild(chest_r11);
        setRotationAngle(chest_r11, -0.3623F, 0.0F, 0.0F);
        chest_r11.cubeList.add(new ModelBox(chest_r11, 26, 37, -0.5F, -0.5F, -1.8F, 1, 1, 4, -0.1F, false));

        chest_r12 = new RendererModel(this);
        chest_r12.setRotationPoint(0.0F, 36.9787F, -11.7908F);
        gBigDorsalTube.addChild(chest_r12);
        setRotationAngle(chest_r12, -0.2278F, 0.0F, 0.0F);
        chest_r12.cubeList.add(new ModelBox(chest_r12, 24, 43, -0.5F, -40.4F, 9.3F, 1, 1, 5, 0.0F, false));

        chest_r13 = new RendererModel(this);
        chest_r13.setRotationPoint(0.0F, 39.1514F, -6.6218F);
        gBigDorsalTube.addChild(chest_r13);
        setRotationAngle(chest_r13, -0.0911F, 0.0F, 0.0F);
        chest_r13.cubeList.add(new ModelBox(chest_r13, 13, 43, -0.5F, -41.1F, 6.0F, 1, 2, 4, 0.0F, false));

        gLowerLeftDorsalTube = new RendererModel(this);
        gLowerLeftDorsalTube.setRotationPoint(1.2F, -4.45F, 3.1F);
        gChest.addChild(gLowerLeftDorsalTube);
        setRotationAngle(gLowerLeftDorsalTube, -0.3548F, 0.1367F, 0.0F);
        gLowerLeftDorsalTube.cubeList.add(
            new ModelBox(gLowerLeftDorsalTube, 0, 50, -1.0F, -1.0F, -0.4F, 2, 2, 4, 0.0F, true)
        );

        chest_r14 = new RendererModel(this);
        chest_r14.setRotationPoint(-1.7F, 32.0486F, -15.8397F);
        gLowerLeftDorsalTube.addChild(chest_r14);
        setRotationAngle(chest_r14, -0.3644F, 0.0F, 0.0F);
        chest_r14.cubeList.add(new ModelBox(chest_r14, 24, 57, 1.22F, -38.1F, 8.8F, 1, 1, 2, 0.0F, true));

        chest_r15 = new RendererModel(this);
        chest_r15.setRotationPoint(-1.7F, 34.7483F, -11.2953F);
        gLowerLeftDorsalTube.addChild(chest_r15);
        setRotationAngle(chest_r15, -0.2278F, 0.0F, 0.0F);
        chest_r15.cubeList.add(new ModelBox(chest_r15, 24, 50, 1.21F, -37.6F, 8.6F, 1, 1, 3, 0.0F, true));

        chest_r16 = new RendererModel(this);
        chest_r16.setRotationPoint(-1.7F, 36.1667F, -8.1209F);
        gLowerLeftDorsalTube.addChild(chest_r16);
        setRotationAngle(chest_r16, -0.1367F, 0.0F, 0.0F);
        chest_r16.cubeList.add(new ModelBox(chest_r16, 13, 50, 1.2F, -38.3F, 6.1F, 1, 2, 3, 0.0F, true));

        gLowerRightDorsalTube = new RendererModel(this);
        gLowerRightDorsalTube.setRotationPoint(-2.2F, -4.45F, 3.1F);
        gChest.addChild(gLowerRightDorsalTube);
        setRotationAngle(gLowerRightDorsalTube, -0.3548F, -0.1367F, 0.0F);
        gLowerRightDorsalTube.cubeList.add(
            new ModelBox(gLowerRightDorsalTube, 0, 50, -1.0F, -1.0F, -0.4F, 2, 2, 4, 0.0F, false)
        );

        chest_r17 = new RendererModel(this);
        chest_r17.setRotationPoint(1.7F, 34.7483F, -11.2953F);
        gLowerRightDorsalTube.addChild(chest_r17);
        setRotationAngle(chest_r17, -0.2278F, 0.0F, 0.0F);
        chest_r17.cubeList.add(new ModelBox(chest_r17, 24, 50, -2.21F, -37.6F, 8.6F, 1, 1, 3, 0.0F, false));

        chest_r18 = new RendererModel(this);
        chest_r18.setRotationPoint(1.7F, 32.0486F, -15.8397F);
        gLowerRightDorsalTube.addChild(chest_r18);
        setRotationAngle(chest_r18, -0.3644F, 0.0F, 0.0F);
        chest_r18.cubeList.add(new ModelBox(chest_r18, 24, 57, -2.22F, -38.1F, 8.8F, 1, 1, 2, 0.0F, false));

        chest_r19 = new RendererModel(this);
        chest_r19.setRotationPoint(1.7F, 36.1667F, -8.1209F);
        gLowerRightDorsalTube.addChild(chest_r19);
        setRotationAngle(chest_r19, -0.1367F, 0.0F, 0.0F);
        chest_r19.cubeList.add(new ModelBox(chest_r19, 13, 50, -2.2F, -38.3F, 6.1F, 1, 2, 3, 0.0F, false));

        gLeftShoulder = new RendererModel(this);
        gLeftShoulder.setRotationPoint(2.1F, -7.9F, 0.0F);
        gChest.addChild(gLeftShoulder);
        setRotationAngle(gLeftShoulder, 0.0F, 0.0F, -0.1309F);
        gLeftShoulder.cubeList.add(new ModelBox(gLeftShoulder, 87, 0, 0.0F, -0.5F, -1.5F, 3, 4, 3, 0.0F, true));

        gLeftBicep = new RendererModel(this);
        gLeftBicep.setRotationPoint(1.8F, 3.1F, 0.0F);
        gLeftShoulder.addChild(gLeftBicep);
        gLeftBicep.cubeList.add(new ModelBox(gLeftBicep, 90, 10, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, true));

        gLeftForearm = new RendererModel(this);
        gLeftForearm.setRotationPoint(0.05F, 8.0217F, 0.2214F);
        gLeftBicep.addChild(gLeftForearm);
        gLeftForearm.cubeList.add(new ModelBox(gLeftForearm, 85, 35, -1.05F, -0.3217F, -1.2214F, 2, 8, 2, -0.1F, true));

        chest_r20 = new RendererModel(this);
        chest_r20.setRotationPoint(-3.45F, 27.8921F, -8.1254F);
        gLeftForearm.addChild(chest_r20);
        setRotationAngle(chest_r20, -0.2731F, 0.0F, 0.0F);
        chest_r20.cubeList.add(new ModelBox(chest_r20, 102, 0, 2.5F, -29.8F, -0.4F, 2, 2, 2, 0.0F, true));

        gLeftWrist = new RendererModel(this);
        gLeftWrist.setRotationPoint(-0.05F, 7.2783F, -0.2214F);
        gLeftForearm.addChild(gLeftWrist);
        setRotationAngle(gLeftWrist, 0.0F, -1.5708F, 0.0F);
        gLeftWrist.cubeList.add(new ModelBox(gLeftWrist, 90, 23, -1.5F, 0.0F, -0.5F, 3, 4, 1, 0.0F, true));

        gLeftFinger1 = new RendererModel(this);
        gLeftFinger1.setRotationPoint(-1.15F, 3.5F, 0.0F);
        gLeftWrist.addChild(gLeftFinger1);
        gLeftFinger1.cubeList.add(new ModelBox(gLeftFinger1, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, false));

        gLeftFinger2 = new RendererModel(this);
        gLeftFinger2.setRotationPoint(-0.4F, 3.5F, 0.0F);
        gLeftWrist.addChild(gLeftFinger2);
        gLeftFinger2.cubeList.add(new ModelBox(gLeftFinger2, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, false));

        gLeftFinger3 = new RendererModel(this);
        gLeftFinger3.setRotationPoint(0.35F, 3.5F, 0.0F);
        gLeftWrist.addChild(gLeftFinger3);
        gLeftFinger3.cubeList.add(new ModelBox(gLeftFinger3, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, false));

        gLeftFinger4 = new RendererModel(this);
        gLeftFinger4.setRotationPoint(1.1F, 3.5F, 0.0F);
        gLeftWrist.addChild(gLeftFinger4);
        gLeftFinger4.cubeList.add(new ModelBox(gLeftFinger4, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, false));

        gLeftThumb = new RendererModel(this);
        gLeftThumb.setRotationPoint(-1.5F, 2.4F, -0.1F);
        gLeftWrist.addChild(gLeftThumb);
        setRotationAngle(gLeftThumb, 2.3562F, 0.0F, 3.1416F);
        gLeftThumb.cubeList.add(new ModelBox(gLeftThumb, 92, 28, 0.0F, 0.0F, -0.8F, 0, 4, 2, 0.0F, false));

        gRightShoulder = new RendererModel(this);
        gRightShoulder.setRotationPoint(-3.1F, -7.9F, 0.0F);
        gChest.addChild(gRightShoulder);
        setRotationAngle(gRightShoulder, 0.0F, 0.0F, 0.1309F);
        gRightShoulder.cubeList.add(new ModelBox(gRightShoulder, 87, 0, -3.0F, -0.5F, -1.5F, 3, 4, 3, 0.0F, false));

        gRightBicep = new RendererModel(this);
        gRightBicep.setRotationPoint(-1.8F, 3.1F, 0.0F);
        gRightShoulder.addChild(gRightBicep);
        gRightBicep.cubeList.add(new ModelBox(gRightBicep, 90, 10, -1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F, false));

        gRightForearm = new RendererModel(this);
        gRightForearm.setRotationPoint(-0.05F, 8.0217F, 0.2214F);
        gRightBicep.addChild(gRightForearm);
        gRightForearm.cubeList.add(
            new ModelBox(gRightForearm, 85, 35, -0.95F, -0.3217F, -1.2214F, 2, 8, 2, -0.1F, false)
        );

        chest_r21 = new RendererModel(this);
        chest_r21.setRotationPoint(3.45F, 27.8921F, -8.1254F);
        gRightForearm.addChild(chest_r21);
        setRotationAngle(chest_r21, -0.2731F, 0.0F, 0.0F);
        chest_r21.cubeList.add(new ModelBox(chest_r21, 102, 0, -4.5F, -29.8F, -0.4F, 2, 2, 2, 0.0F, false));

        gRightWrist = new RendererModel(this);
        gRightWrist.setRotationPoint(0.05F, 7.2783F, -0.2214F);
        gRightForearm.addChild(gRightWrist);
        setRotationAngle(gRightWrist, 0.0F, 1.5708F, 0.0F);
        gRightWrist.cubeList.add(new ModelBox(gRightWrist, 90, 23, -1.5F, 0.0F, -0.5F, 3, 4, 1, 0.0F, false));

        gRightFinger1 = new RendererModel(this);
        gRightFinger1.setRotationPoint(1.15F, 3.5F, 0.0F);
        gRightWrist.addChild(gRightFinger1);
        gRightFinger1.cubeList.add(new ModelBox(gRightFinger1, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, true));

        gRightFinger2 = new RendererModel(this);
        gRightFinger2.setRotationPoint(0.4F, 3.5F, 0.0F);
        gRightWrist.addChild(gRightFinger2);
        gRightFinger2.cubeList.add(new ModelBox(gRightFinger2, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, true));

        gRightFinger3 = new RendererModel(this);
        gRightFinger3.setRotationPoint(-0.35F, 3.5F, 0.0F);
        gRightWrist.addChild(gRightFinger3);
        gRightFinger3.cubeList.add(new ModelBox(gRightFinger3, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, true));

        gRightFinger4 = new RendererModel(this);
        gRightFinger4.setRotationPoint(-1.1F, 3.5F, 0.0F);
        gRightWrist.addChild(gRightFinger4);
        gRightFinger4.cubeList.add(new ModelBox(gRightFinger4, 92, 28, 0.0F, 0.0F, -0.5F, 0, 4, 2, 0.0F, true));

        gRightThumb = new RendererModel(this);
        gRightThumb.setRotationPoint(1.5F, 2.4F, -0.1F);
        gRightWrist.addChild(gRightThumb);
        setRotationAngle(gRightThumb, 2.3562F, 0.0F, -3.1416F);
        gRightThumb.cubeList.add(new ModelBox(gRightThumb, 92, 28, 0.0F, 0.0F, -0.8F, 0, 4, 2, 0.0F, true));

        gLowerChest = new RendererModel(this);
        gLowerChest.setRotationPoint(-0.4667F, -0.9814F, 0.4585F);
        gChest.addChild(gLowerChest);
        gLowerChest.cubeList.add(new ModelBox(gLowerChest, 21, 27, -2.9333F, -0.4289F, -2.9333F, 6, 2, 6, 0.0F, false));

        chest_r22 = new RendererModel(this);
        chest_r22.setRotationPoint(8.6038F, 32.4182F, 2.3508F);
        gLowerChest.addChild(chest_r22);
        setRotationAngle(chest_r22, 0.0911F, 0.0F, -0.3187F);
        chest_r22.cubeList.add(new ModelBox(chest_r22, 68, 0, -3.3979F, -30.6722F, -2.229F, 1, 3, 5, 0.0F, true));

        chest_r23 = new RendererModel(this);
        chest_r23.setRotationPoint(-8.6704F, 32.4182F, 2.3508F);
        gLowerChest.addChild(chest_r23);
        setRotationAngle(chest_r23, 0.0911F, 0.0F, 0.3187F);
        chest_r23.cubeList.add(new ModelBox(chest_r23, 68, 0, 2.3979F, -30.6722F, -2.229F, 1, 3, 5, 0.0F, false));

        gStomach = new RendererModel(this);
        gStomach.setRotationPoint(-0.0333F, 1.3711F, 0.0667F);
        gLowerChest.addChild(gStomach);
        gStomach.cubeList.add(new ModelBox(gStomach, 0, 27, -2.5F, 0.0F, -2.5F, 5, 6, 5, 0.0F, false));

        gRightThigh = new RendererModel(this);
        gRightThigh.setRotationPoint(-2.5F, 4.9F, 0.0F);
        gStomach.addChild(gRightThigh);
        gRightThigh.cubeList.add(new ModelBox(gRightThigh, 55, 0, -1.4F, -0.5F, -2.0F, 1, 14, 4, 0.0F, false));
        gRightThigh.cubeList.add(new ModelBox(gRightThigh, 37, 0, -0.8F, -0.5F, -2.0F, 3, 14, 4, 0.0F, false));

        gRightShin = new RendererModel(this);
        gRightShin.setRotationPoint(0.3F, 13.2F, -0.1F);
        gRightThigh.addChild(gRightShin);
        gRightShin.cubeList.add(new ModelBox(gRightShin, 47, 19, -1.5F, -0.5F, -1.5F, 3, 11, 3, 0.0F, false));

        gRightAnkle = new RendererModel(this);
        gRightAnkle.setRotationPoint(0.0F, 9.7F, 0.0F);
        gRightShin.addChild(gRightAnkle);
        gRightAnkle.cubeList.add(new ModelBox(gRightAnkle, 41, 36, -1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, false));

        gRightFoot = new RendererModel(this);
        gRightFoot.setRotationPoint(-0.1F, 4.6F, 0.2F);
        gRightAnkle.addChild(gRightFoot);
        gRightFoot.cubeList.add(new ModelBox(gRightFoot, 38, 45, -1.5F, -0.5F, -2.5F, 3, 1, 3, 0.0F, false));

        gRightToes = new RendererModel(this);
        gRightToes.setRotationPoint(0.0F, 0.0F, -2.5F);
        gRightFoot.addChild(gRightToes);
        gRightToes.cubeList.add(new ModelBox(gRightToes, 45, 53, -1.5F, -0.5F, -1.9F, 3, 1, 2, -0.1F, false));

        gLeftThigh = new RendererModel(this);
        gLeftThigh.setRotationPoint(2.5F, 4.9F, 0.0F);
        gStomach.addChild(gLeftThigh);
        gLeftThigh.cubeList.add(new ModelBox(gLeftThigh, 55, 0, 0.4F, -0.5F, -2.0F, 1, 14, 4, 0.0F, true));
        gLeftThigh.cubeList.add(new ModelBox(gLeftThigh, 37, 0, -2.2F, -0.5F, -2.0F, 3, 14, 4, 0.0F, true));

        gLeftShin = new RendererModel(this);
        gLeftShin.setRotationPoint(-0.3F, 13.2F, -0.1F);
        gLeftThigh.addChild(gLeftShin);
        gLeftShin.cubeList.add(new ModelBox(gLeftShin, 47, 19, -1.5F, -0.5F, -1.5F, 3, 11, 3, 0.0F, true));

        gLeftAnkle = new RendererModel(this);
        gLeftAnkle.setRotationPoint(0.0F, 9.7F, 0.0F);
        gLeftShin.addChild(gLeftAnkle);
        gLeftAnkle.cubeList.add(new ModelBox(gLeftAnkle, 41, 36, -1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F, true));

        gLeftFoot = new RendererModel(this);
        gLeftFoot.setRotationPoint(0.1F, 4.6F, 0.2F);
        gLeftAnkle.addChild(gLeftFoot);
        gLeftFoot.cubeList.add(new ModelBox(gLeftFoot, 38, 45, -1.5F, -0.5F, -2.5F, 3, 1, 3, 0.0F, true));

        gLeftToes = new RendererModel(this);
        gLeftToes.setRotationPoint(0.0F, 0.0F, -2.5F);
        gLeftFoot.addChild(gLeftToes);
        gLeftToes.cubeList.add(new ModelBox(gLeftToes, 45, 53, -1.5F, -0.5F, -1.9F, 3, 1, 2, -0.1F, true));
    }

    @Override
    public void render(BelugamorphEntity belugamorphEntity, float f, float f1, float f2, float f3, float f4, float f5) {
        root.render(f5);
    }

    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
