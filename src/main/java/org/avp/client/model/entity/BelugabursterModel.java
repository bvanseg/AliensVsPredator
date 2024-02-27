package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

import org.avp.common.entity.BelugabursterEntity;

public class BelugabursterModel extends EntityModel<BelugabursterEntity> {

    private final RendererModel root;

    private final RendererModel gChest;

    private final RendererModel cube_r1;

    private final RendererModel gNeck;

    private final RendererModel gNeckEnd;

    private final RendererModel gHead;

    private final RendererModel cube_r2;

    private final RendererModel cube_r3;

    private final RendererModel cube_r4;

    private final RendererModel cube_r5;

    private final RendererModel cube_r6;

    private final RendererModel gMouth;

    private final RendererModel gUpperJaw;

    private final RendererModel gJaw;

    private final RendererModel gLowerBody;

    private final RendererModel gWaist;

    private final RendererModel RightTail;

    private final RendererModel RightTailBase;

    private final RendererModel RightTailMiddle;

    private final RendererModel RightTailEnd;

    private final RendererModel gLeftTail;

    private final RendererModel gLeftTailBase;

    private final RendererModel gLeftTailMiddle;

    private final RendererModel gLeftTailEnd;

    private final RendererModel gRightArmBase;

    private final RendererModel gRightArm;

    private final RendererModel gRightArmFrontMiddle;

    private final RendererModel gRightArmMiddle;

    private final RendererModel gRightArmBackMiddle;

    private final RendererModel gRightArmEnd;

    private final RendererModel gLeftArmBase;

    private final RendererModel gLeftArm;

    private final RendererModel gLeftArmFrontMiddle;

    private final RendererModel gLeftArmMiddle;

    private final RendererModel gLeftArmBackMiddle;

    private final RendererModel gLeftArmEnd;

    public BelugabursterModel() {
        textureWidth = 128;
        textureHeight = 64;

        root = new RendererModel(this);
        root.setRotationPoint(0.0F, 0.0F, 0.0F);

        gChest = new RendererModel(this);
        gChest.setRotationPoint(0.0F, 15.0732F, 0.7476F);
        root.addChild(gChest);
        setRotationAngle(gChest, -0.1367F, 0.0F, 0.0F);

        cube_r1 = new RendererModel(this);
        cube_r1.setRotationPoint(0.0F, 8.6418F, -2.8513F);
        gChest.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.3187F, 0.0F, 0.0F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 40, -1.5F, -11.1F, -1.5F, 3, 4, 3, 0.0F, false));

        gNeck = new RendererModel(this);
        gNeck.setRotationPoint(0.0F, -1.5856F, 0.7673F);
        gChest.addChild(gNeck);
        gNeck.cubeList.add(new ModelBox(gNeck, 0, 31, -1.5F, -3.3F, -1.6F, 3, 4, 3, 0.0F, false));

        gNeckEnd = new RendererModel(this);
        gNeckEnd.setRotationPoint(0.0F, -3.3F, 0.0F);
        gNeck.addChild(gNeckEnd);
        setRotationAngle(gNeckEnd, 0.8727F, 0.0F, 0.0F);
        gNeckEnd.cubeList.add(new ModelBox(gNeckEnd, 0, 22, -1.5F, -2.9F, -2.1F, 3, 4, 3, 0.0F, false));

        gHead = new RendererModel(this);
        gHead.setRotationPoint(0.0F, -2.45F, 0.25F);
        gNeckEnd.addChild(gHead);
        setRotationAngle(gHead, -1.0472F, 0.0F, 0.0F);
        gHead.cubeList.add(new ModelBox(gHead, 0, 12, -1.5F, -0.8F, -5.4F, 3, 3, 6, 0.0F, false));

        cube_r2 = new RendererModel(this);
        cube_r2.setRotationPoint(0.0F, -0.9595F, -1.2855F);
        gHead.addChild(cube_r2);
        setRotationAngle(cube_r2, -0.093F, 0.0F, 0.0F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 24, 42, -1.0F, -0.5F, -1.5F, 2, 1, 3, 0.0F, false));

        cube_r3 = new RendererModel(this);
        cube_r3.setRotationPoint(0.0F, 13.4844F, 4.8482F);
        gHead.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.4098F, 0.0F, 0.0F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 22, 25, -1.5F, -18.3F, -9.6F, 3, 2, 5, 0.0F, false));

        cube_r4 = new RendererModel(this);
        cube_r4.setRotationPoint(0.0F, -0.5176F, -4.6277F);
        gHead.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0456F, 0.0F, 0.0F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 24, 34, -1.0F, -1.0F, -2.0F, 2, 2, 4, 0.0F, false));

        cube_r5 = new RendererModel(this);
        cube_r5.setRotationPoint(0.0F, 3.061F, 11.1772F);
        gHead.addChild(cube_r5);
        setRotationAngle(cube_r5, 1.1837F, 0.0F, 0.0F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 22, 15, -2.0F, -22.5F, -10.1F, 4, 3, 4, 0.0F, false));

        cube_r6 = new RendererModel(this);
        cube_r6.setRotationPoint(0.0F, 11.4804F, 7.1085F);
        gHead.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.5918F, 0.0F, 0.0F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 0, -1.5F, -17.7F, -10.5F, 3, 3, 7, 0.0F, false));

        gMouth = new RendererModel(this);
        gMouth.setRotationPoint(0.0F, 3.8596F, -9.3916F);
        gHead.addChild(gMouth);
        setRotationAngle(gMouth, 0.7854F, 0.0F, 0.0F);

        gUpperJaw = new RendererModel(this);
        gUpperJaw.setRotationPoint(0.0F, -0.7469F, -0.5021F);
        gMouth.addChild(gUpperJaw);
        gUpperJaw.cubeList.add(new ModelBox(gUpperJaw, 25, 49, -1.0F, 0.1F, -1.4F, 2, 1, 2, 0.0F, false));

        gJaw = new RendererModel(this);
        gJaw.setRotationPoint(0.0F, 0.3F, 0.15F);
        gMouth.addChild(gJaw);
        gJaw.cubeList.add(new ModelBox(gJaw, 25, 55, -1.0F, -0.4F, -2.05F, 2, 1, 2, 0.0F, false));

        gLowerBody = new RendererModel(this);
        gLowerBody.setRotationPoint(0.0F, 1.8144F, -0.5327F);
        gChest.addChild(gLowerBody);
        gLowerBody.cubeList.add(new ModelBox(gLowerBody, 0, 49, -1.5F, -0.5F, -1.5F, 3, 5, 3, 0.0F, false));

        gWaist = new RendererModel(this);
        gWaist.setRotationPoint(0.0F, 4.0715F, -0.7775F);
        gLowerBody.addChild(gWaist);
        setRotationAngle(gWaist, 0.1367F, 0.0F, 0.0F);
        gWaist.cubeList.add(new ModelBox(gWaist, 22, 0, -1.5F, 0.2F, -0.8F, 3, 3, 7, 0.0F, false));

        RightTail = new RendererModel(this);
        RightTail.setRotationPoint(-0.8F, 2.2F, 6.0F);
        gWaist.addChild(RightTail);
        RightTail.cubeList.add(new ModelBox(RightTail, 47, 2, -0.5F, -1.0F, 0.0F, 1, 2, 7, 0.0F, false));

        RightTailBase = new RendererModel(this);
        RightTailBase.setRotationPoint(0.0F, 0.0F, 7.0F);
        RightTail.addChild(RightTailBase);
        setRotationAngle(RightTailBase, 0.0F, 0.0F, 0.0F);
        RightTailBase.cubeList.add(new ModelBox(RightTailBase, 47, 12, -0.5F, -1.0F, 0.0F, 1, 2, 5, 0.0F, false));

        RightTailMiddle = new RendererModel(this);
        RightTailMiddle.setRotationPoint(0.0F, 0.5F, 5.0F);
        RightTailBase.addChild(RightTailMiddle);
        RightTailMiddle.cubeList.add(new ModelBox(RightTailMiddle, 47, 22, -0.5F, -0.5F, 0.0F, 1, 1, 4, 0.0F, false));

        RightTailEnd = new RendererModel(this);
        RightTailEnd.setRotationPoint(0.0F, 0.0F, 4.0F);
        RightTailMiddle.addChild(RightTailEnd);
        RightTailEnd.cubeList.add(new ModelBox(RightTailEnd, 47, 29, -0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F, false));

        gLeftTail = new RendererModel(this);
        gLeftTail.setRotationPoint(0.8F, 2.2F, 6.0F);
        gWaist.addChild(gLeftTail);
        gLeftTail.cubeList.add(new ModelBox(gLeftTail, 47, 2, -0.5F, -1.0F, 0.0F, 1, 2, 7, 0.0F, true));

        gLeftTailBase = new RendererModel(this);
        gLeftTailBase.setRotationPoint(0.0F, 0.0F, 7.0F);
        gLeftTail.addChild(gLeftTailBase);
        setRotationAngle(gLeftTailBase, 0.0F, 0.0F, 0.0F);
        gLeftTailBase.cubeList.add(new ModelBox(gLeftTailBase, 47, 12, -0.5F, -1.0F, 0.0F, 1, 2, 5, 0.0F, true));

        gLeftTailMiddle = new RendererModel(this);
        gLeftTailMiddle.setRotationPoint(0.0F, 0.5F, 5.0F);
        gLeftTailBase.addChild(gLeftTailMiddle);
        gLeftTailMiddle.cubeList.add(new ModelBox(gLeftTailMiddle, 47, 22, -0.5F, -0.5F, 0.0F, 1, 1, 4, 0.0F, true));

        gLeftTailEnd = new RendererModel(this);
        gLeftTailEnd.setRotationPoint(0.0F, 0.0F, 4.0F);
        gLeftTailMiddle.addChild(gLeftTailEnd);
        gLeftTailEnd.cubeList.add(new ModelBox(gLeftTailEnd, 47, 29, -0.5F, -0.5F, 0.0F, 1, 1, 5, 0.0F, true));

        gRightArmBase = new RendererModel(this);
        gRightArmBase.setRotationPoint(1.4531F, -0.5712F, 0.3204F);
        gChest.addChild(gRightArmBase);
        setRotationAngle(gRightArmBase, -0.3054F, 0.0F, -0.0873F);
        gRightArmBase.cubeList.add(new ModelBox(gRightArmBase, 70, 0, 0.0F, 0.0F, -1.0F, 1, 5, 2, 0.0F, false));

        gRightArm = new RendererModel(this);
        gRightArm.setRotationPoint(0.5F, 5.0F, -0.1F);
        gRightArmBase.addChild(gRightArm);
        setRotationAngle(gRightArm, 0.2182F, 0.0F, 0.0873F);
        gRightArm.cubeList.add(new ModelBox(gRightArm, 71, 7, -0.5F, 0.0F, -0.9F, 1, 4, 2, 0.0F, false));

        gRightArmFrontMiddle = new RendererModel(this);
        gRightArmFrontMiddle.setRotationPoint(0.0F, 4.0F, 0.1F);
        gRightArm.addChild(gRightArmFrontMiddle);
        setRotationAngle(gRightArmFrontMiddle, 0.2182F, 0.0F, 0.0F);
        gRightArmFrontMiddle.cubeList.add(
            new ModelBox(gRightArmFrontMiddle, 70, 14, -0.5F, -1.0F, 0.0F, 1, 2, 3, 0.0F, false)
        );

        gRightArmMiddle = new RendererModel(this);
        gRightArmMiddle.setRotationPoint(0.034F, -0.0497F, 3.0199F);
        gRightArmFrontMiddle.addChild(gRightArmMiddle);
        setRotationAngle(gRightArmMiddle, -1.5708F, 0.0F, 0.0F);
        gRightArmMiddle.cubeList.add(
            new ModelBox(gRightArmMiddle, 71, 21, -0.534F, -3.9801F, -0.9503F, 1, 4, 2, 0.0F, false)
        );

        gRightArmBackMiddle = new RendererModel(this);
        gRightArmBackMiddle.setRotationPoint(-0.0076F, -4.0F, 0.5F);
        gRightArmMiddle.addChild(gRightArmBackMiddle);
        gRightArmBackMiddle.cubeList.add(
            new ModelBox(gRightArmBackMiddle, 71, 29, -0.534F, -4.9801F, -0.4503F, 1, 5, 1, 0.0F, false)
        );

        gRightArmEnd = new RendererModel(this);
        gRightArmEnd.setRotationPoint(-0.0086F, -4.9991F, 0.0113F);
        gRightArmBackMiddle.addChild(gRightArmEnd);
        gRightArmEnd.cubeList.add(
            new ModelBox(gRightArmEnd, 71, 29, -0.5261F, -4.9804F, -0.4606F, 1, 5, 1, 0.0F, false)
        );

        gLeftArmBase = new RendererModel(this);
        gLeftArmBase.setRotationPoint(-1.4531F, -0.5712F, 0.3204F);
        gChest.addChild(gLeftArmBase);
        setRotationAngle(gLeftArmBase, -0.3054F, 0.0F, 0.0873F);
        gLeftArmBase.cubeList.add(new ModelBox(gLeftArmBase, 70, 0, -1.0F, 0.0F, -1.0F, 1, 5, 2, 0.0F, true));

        gLeftArm = new RendererModel(this);
        gLeftArm.setRotationPoint(-0.5F, 5.0F, -0.1F);
        gLeftArmBase.addChild(gLeftArm);
        setRotationAngle(gLeftArm, 0.2182F, 0.0F, -0.0873F);
        gLeftArm.cubeList.add(new ModelBox(gLeftArm, 71, 7, -0.5F, 0.0F, -0.9F, 1, 4, 2, 0.0F, true));

        gLeftArmFrontMiddle = new RendererModel(this);
        gLeftArmFrontMiddle.setRotationPoint(0.0F, 4.0F, 0.1F);
        gLeftArm.addChild(gLeftArmFrontMiddle);
        setRotationAngle(gLeftArmFrontMiddle, 0.2182F, 0.0F, 0.0F);
        gLeftArmFrontMiddle.cubeList.add(
            new ModelBox(gLeftArmFrontMiddle, 70, 14, -0.5F, -1.0F, 0.0F, 1, 2, 3, 0.0F, true)
        );

        gLeftArmMiddle = new RendererModel(this);
        gLeftArmMiddle.setRotationPoint(-0.034F, -0.0497F, 3.0199F);
        gLeftArmFrontMiddle.addChild(gLeftArmMiddle);
        setRotationAngle(gLeftArmMiddle, -1.5708F, 0.0F, 0.0F);
        gLeftArmMiddle.cubeList.add(
            new ModelBox(gLeftArmMiddle, 71, 21, -0.466F, -3.9801F, -0.9503F, 1, 4, 2, 0.0F, true)
        );

        gLeftArmBackMiddle = new RendererModel(this);
        gLeftArmBackMiddle.setRotationPoint(0.0076F, -4.0F, 0.5F);
        gLeftArmMiddle.addChild(gLeftArmBackMiddle);
        gLeftArmBackMiddle.cubeList.add(
            new ModelBox(gLeftArmBackMiddle, 71, 29, -0.466F, -4.9801F, -0.4503F, 1, 5, 1, 0.0F, true)
        );

        gLeftArmEnd = new RendererModel(this);
        gLeftArmEnd.setRotationPoint(0.0086F, -4.9991F, 0.0113F);
        gLeftArmBackMiddle.addChild(gLeftArmEnd);
        gLeftArmEnd.cubeList.add(new ModelBox(gLeftArmEnd, 71, 29, -0.4739F, -4.9804F, -0.4606F, 1, 5, 1, 0.0F, true));
    }

    @Override
    public void render(
        BelugabursterEntity belugabursterEntity,
        float f,
        float f1,
        float f2,
        float f3,
        float f4,
        float f5
    ) {
        root.render(f5);
    }

    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
