package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

import org.avp.common.entity.OctohuggerEntity;

public class OctohuggerModel extends EntityModel<OctohuggerEntity> {

    private final RendererModel root;

    private final RendererModel gBody;

    private final RendererModel gUpperBody;

    private final RendererModel gUpperBodyBase;

    private final RendererModel gUpperBodyMiddle;

    private final RendererModel gUpperBodyEnd;

    private final RendererModel gSouthFlap;

    private final RendererModel gSouthFlapEnd;

    private final RendererModel gNorthFlap;

    private final RendererModel gNorthFlapEnd;

    private final RendererModel gEastFlap;

    private final RendererModel gEastFlapEnd;

    private final RendererModel gWestFlap;

    private final RendererModel gWestFlapEnd;

    public OctohuggerModel() {
        textureWidth = 64;
        textureHeight = 32;

        root = new RendererModel(this);
        root.setRotationPoint(0.0F, 0.0F, 0.0F);

        gBody = new RendererModel(this);
        gBody.setRotationPoint(0.0F, 16.275F, 0.0F);
        root.addChild(gBody);
        gBody.cubeList.add(new ModelBox(gBody, 0, 17, -1.5F, -2.275F, -1.5F, 3, 5, 3, 0.0F, false));
        gBody.cubeList.add(new ModelBox(gBody, 0, 20, -1.5F, -1.225F, -1.5F, 3, 2, 3, 0.15F, false));

        gUpperBody = new RendererModel(this);
        gUpperBody.setRotationPoint(0.0F, -0.025F, 0.0F);
        gBody.addChild(gUpperBody);
        gUpperBody.cubeList.add(new ModelBox(gUpperBody, 0, 13, -1.0F, -3.0F, -1.0F, 2, 1, 2, -0.1F, false));

        gUpperBodyBase = new RendererModel(this);
        gUpperBodyBase.setRotationPoint(0.0F, 25.1F, 0.0F);
        gUpperBody.addChild(gUpperBodyBase);
        gUpperBodyBase.cubeList.add(new ModelBox(gUpperBodyBase, 0, 7, -1.5F, -29.4F, -1.5F, 3, 2, 3, -0.25F, false));

        gUpperBodyMiddle = new RendererModel(this);
        gUpperBodyMiddle.setRotationPoint(0.0F, -28.75F, 0.0F);
        gUpperBodyBase.addChild(gUpperBodyMiddle);
        gUpperBodyMiddle.cubeList.add(new ModelBox(gUpperBodyMiddle, 0, 3, -1.0F, -1.0F, -1.0F, 2, 1, 2, 0.0F, false));

        gUpperBodyEnd = new RendererModel(this);
        gUpperBodyEnd.setRotationPoint(0.0F, 4.0F, 0.0F);
        gUpperBodyMiddle.addChild(gUpperBodyEnd);
        gUpperBodyEnd.cubeList.add(new ModelBox(gUpperBodyEnd, 0, 0, -0.5F, -5.6F, -0.5F, 1, 1, 1, 0.0F, false));

        gSouthFlap = new RendererModel(this);
        gSouthFlap.setRotationPoint(0.0F, 2.475F, 0.9F);
        gBody.addChild(gSouthFlap);
        setRotationAngle(gSouthFlap, 0.0F, 0.0F, 0.0F);
        gSouthFlap.cubeList.add(new ModelBox(gSouthFlap, 17, 12, -1.0F, 0.25F, -0.5F, 2, 3, 1, 0.0F, false));

        gSouthFlapEnd = new RendererModel(this);
        gSouthFlapEnd.setRotationPoint(0.0F, 3.0F, 0.0F);
        gSouthFlap.addChild(gSouthFlapEnd);
        setRotationAngle(gSouthFlapEnd, 0.0F, 0.0F, 0.0F);
        gSouthFlapEnd.cubeList.add(new ModelBox(gSouthFlapEnd, 17, 18, -0.5F, 0.25F, -0.5F, 1, 2, 1, 0.0F, false));

        gNorthFlap = new RendererModel(this);
        gNorthFlap.setRotationPoint(0.0F, 2.475F, -0.9F);
        gBody.addChild(gNorthFlap);
        setRotationAngle(gNorthFlap, 0.0F, 0.0F, 0.0F);
        gNorthFlap.cubeList.add(new ModelBox(gNorthFlap, 17, 0, -1.0F, 0.25F, -0.5F, 2, 3, 1, 0.0F, false));

        gNorthFlapEnd = new RendererModel(this);
        gNorthFlapEnd.setRotationPoint(0.0F, 3.0F, 0.0F);
        gNorthFlap.addChild(gNorthFlapEnd);
        setRotationAngle(gNorthFlapEnd, 0.0F, 0.0F, 0.0F);
        gNorthFlapEnd.cubeList.add(new ModelBox(gNorthFlapEnd, 17, 5, -0.5F, 0.25F, -0.5F, 1, 2, 1, 0.0F, false));

        gEastFlap = new RendererModel(this);
        gEastFlap.setRotationPoint(-0.9F, 2.475F, 0.0F);
        gBody.addChild(gEastFlap);
        setRotationAngle(gEastFlap, 0.0F, 0.0F, 0.0F);
        gEastFlap.cubeList.add(new ModelBox(gEastFlap, 27, 0, -0.5F, 0.25F, -1.0F, 1, 3, 2, 0.0F, true));

        gEastFlapEnd = new RendererModel(this);
        gEastFlapEnd.setRotationPoint(0.0F, 3.0F, 0.0F);
        gEastFlap.addChild(gEastFlapEnd);
        setRotationAngle(gEastFlapEnd, 0.0F, 0.0F, 0.0F);
        gEastFlapEnd.cubeList.add(new ModelBox(gEastFlapEnd, 27, 6, -0.5F, 0.25F, -0.5F, 1, 2, 1, 0.0F, true));

        gWestFlap = new RendererModel(this);
        gWestFlap.setRotationPoint(0.9F, 2.475F, 0.0F);
        gBody.addChild(gWestFlap);
        setRotationAngle(gWestFlap, 0.0F, 0.0F, 0.0F);
        gWestFlap.cubeList.add(new ModelBox(gWestFlap, 27, 0, -0.5F, 0.25F, -1.0F, 1, 3, 2, 0.0F, false));

        gWestFlapEnd = new RendererModel(this);
        gWestFlapEnd.setRotationPoint(0.0F, 3.0F, 0.0F);
        gWestFlap.addChild(gWestFlapEnd);
        setRotationAngle(gWestFlapEnd, 0.0F, 0.0F, 0.0F);
        gWestFlapEnd.cubeList.add(new ModelBox(gWestFlapEnd, 27, 6, -0.5F, 0.25F, -0.5F, 1, 2, 1, 0.0F, false));
    }

    @Override
    public void render(OctohuggerEntity octohuggerEntity, float f, float f1, float f2, float f3, float f4, float f5) {
        root.render(f5);
    }

    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
