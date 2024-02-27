package org.avp.client.model.entity;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

import org.avp.common.entity.OvamorphDracoEntity;

public class OvamorphDracoModel extends EntityModel<OvamorphDracoEntity> {

    private final RendererModel root;

    private final RendererModel gEgg;

    private final RendererModel webbing2_r1;

    private final RendererModel webbing2b_r1;

    private final RendererModel webbing2b_r2;

    private final RendererModel webbing4_r1;

    private final RendererModel webbing3_r1;

    private final RendererModel webbing2b_r3;

    private final RendererModel webbing2b_r4;

    private final RendererModel webbing3_r2;

    private final RendererModel sideSpikes4_r1;

    private final RendererModel sideSpikes2_r1;

    private final RendererModel sideSpikes3_r1;

    private final RendererModel sideSpikes1_r1;

    private final RendererModel gFlaps;

    private final RendererModel gFrontLeftFlap;

    private final RendererModel rFrontLobe2_r1;

    private final RendererModel gFrontLeftFlapEnd;

    private final RendererModel rFrontLobe2Child_r1;

    private final RendererModel gFrontRightFlap;

    private final RendererModel rFrontLobe3_r1;

    private final RendererModel gFrontRightFlapEnd;

    private final RendererModel rFrontLobe2Child_r2;

    private final RendererModel gBackRightFlap;

    private final RendererModel rBackLobe3_r1;

    private final RendererModel gBackRightFlapEnd;

    private final RendererModel rBackLobeChild_r1;

    private final RendererModel gBackLeftFlap;

    private final RendererModel rBackLobe4_r1;

    private final RendererModel gBackLeftFlapEnd;

    private final RendererModel rBackLobeChild_r2;

    public OvamorphDracoModel() {
        textureWidth = 64;
        textureHeight = 32;

        root = new RendererModel(this);
        root.setRotationPoint(0.0F, 24.0F, 0.0F);

        gEgg = new RendererModel(this);
        gEgg.setRotationPoint(0.0F, -0.5636F, 4.1778F);
        root.addChild(gEgg);
        gEgg.cubeList.add(new ModelBox(gEgg, 0, 15, -2.5F, -4.4364F, -6.6778F, 5, 5, 5, 0.0F, false));
        gEgg.cubeList.add(new ModelBox(gEgg, 0, 0, -3.5F, -5.4364F, -7.6778F, 7, 5, 7, 0.0F, false));

        webbing2_r1 = new RendererModel(this);
        webbing2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        gEgg.addChild(webbing2_r1);
        setRotationAngle(webbing2_r1, 2.3562F, 0.0F, 3.1416F);
        webbing2_r1.cubeList.add(new ModelBox(webbing2_r1, 26, 25, -3.5F, -1.0F, 0.0F, 7, 2, 0, 0.0F, false));

        webbing2b_r1 = new RendererModel(this);
        webbing2b_r1.setRotationPoint(0.0F, 0.7074F, 2.2078F);
        gEgg.addChild(webbing2b_r1);
        setRotationAngle(webbing2b_r1, 0.0F, 0.0F, -3.1416F);
        webbing2b_r1.cubeList.add(new ModelBox(webbing2b_r1, 39, 29, -3.5F, 0.0F, -1.5F, 7, 0, 3, 0.0F, false));

        webbing2b_r2 = new RendererModel(this);
        webbing2b_r2.setRotationPoint(0.0F, 0.7074F, -10.5634F);
        gEgg.addChild(webbing2b_r2);
        setRotationAngle(webbing2b_r2, 3.1416F, 0.0F, 0.0F);
        webbing2b_r2.cubeList.add(new ModelBox(webbing2b_r2, 39, 29, -3.5F, 0.0F, -1.5F, 7, 0, 3, 0.0F, false));

        webbing4_r1 = new RendererModel(this);
        webbing4_r1.setRotationPoint(0.0F, 0.3537F, -4.1778F);
        gEgg.addChild(webbing4_r1);
        setRotationAngle(webbing4_r1, 0.0F, -1.5708F, -0.7854F);
        webbing4_r1.cubeList.add(new ModelBox(webbing4_r1, 26, 25, -3.5F, 1.7041F, -3.2043F, 7, 2, 0, 0.0F, false));

        webbing3_r1 = new RendererModel(this);
        webbing3_r1.setRotationPoint(0.0F, 0.3537F, -4.1778F);
        gEgg.addChild(webbing3_r1);
        setRotationAngle(webbing3_r1, -0.7854F, 0.0F, 0.0F);
        webbing3_r1.cubeList.add(new ModelBox(webbing3_r1, 26, 25, -3.5F, 1.7041F, -3.2043F, 7, 2, 0, 0.0F, false));

        webbing2b_r3 = new RendererModel(this);
        webbing2b_r3.setRotationPoint(6.3856F, 0.7074F, -4.1778F);
        gEgg.addChild(webbing2b_r3);
        setRotationAngle(webbing2b_r3, 0.0F, -1.5708F, 3.1416F);
        webbing2b_r3.cubeList.add(new ModelBox(webbing2b_r3, 39, 29, -3.5F, 0.0F, -1.5F, 7, 0, 3, 0.0F, false));

        webbing2b_r4 = new RendererModel(this);
        webbing2b_r4.setRotationPoint(-6.3856F, 0.7074F, -4.1778F);
        gEgg.addChild(webbing2b_r4);
        setRotationAngle(webbing2b_r4, 0.0F, 1.5708F, 3.1416F);
        webbing2b_r4.cubeList.add(new ModelBox(webbing2b_r4, 39, 29, -3.5F, 0.0F, -1.5F, 7, 0, 3, 0.0F, false));

        webbing3_r2 = new RendererModel(this);
        webbing3_r2.setRotationPoint(-4.1778F, 0.0F, -4.1778F);
        gEgg.addChild(webbing3_r2);
        setRotationAngle(webbing3_r2, 0.0F, 1.5708F, 0.7854F);
        webbing3_r2.cubeList.add(new ModelBox(webbing3_r2, 26, 25, -3.5F, -1.0F, 0.0F, 7, 2, 0, 0.0F, false));

        sideSpikes4_r1 = new RendererModel(this);
        sideSpikes4_r1.setRotationPoint(-0.0016F, 0.5636F, -4.3932F);
        gEgg.addChild(sideSpikes4_r1);
        setRotationAngle(sideSpikes4_r1, -3.1416F, -0.7741F, 3.1416F);
        sideSpikes4_r1.cubeList.add(new ModelBox(sideSpikes4_r1, 0, 0, -5.8F, -6.0F, -0.1F, 1, 6, 0, 0.0F, false));

        sideSpikes2_r1 = new RendererModel(this);
        sideSpikes2_r1.setRotationPoint(-7.5365F, 0.5636F, -11.7073F);
        gEgg.addChild(sideSpikes2_r1);
        setRotationAngle(sideSpikes2_r1, 0.0F, -0.8196F, 0.0F);
        sideSpikes2_r1.cubeList.add(new ModelBox(sideSpikes2_r1, 0, 0, 4.7F, -6.0F, -0.2F, 1, 6, 0, 0.0F, false));

        sideSpikes3_r1 = new RendererModel(this);
        sideSpikes3_r1.setRotationPoint(7.5054F, 0.5636F, 3.3789F);
        gEgg.addChild(sideSpikes3_r1);
        setRotationAngle(sideSpikes3_r1, -3.1416F, 0.7741F, 3.1416F);
        sideSpikes3_r1.cubeList.add(new ModelBox(sideSpikes3_r1, 0, 0, 4.7F, -6.0F, 0.1F, 1, 6, 0, 0.0F, false));

        sideSpikes1_r1 = new RendererModel(this);
        sideSpikes1_r1.setRotationPoint(1.4085F, 0.5636F, -6.0822F);
        gEgg.addChild(sideSpikes1_r1);
        setRotationAngle(sideSpikes1_r1, 0.0F, 0.8196F, 0.0F);
        sideSpikes1_r1.cubeList.add(new ModelBox(sideSpikes1_r1, 0, 0, -8.3F, -6.0F, 0.1F, 1, 6, 0, 0.0F, false));

        gFlaps = new RendererModel(this);
        gFlaps.setRotationPoint(0.0303F, 0.5636F, -4.2081F);
        gEgg.addChild(gFlaps);
        setRotationAngle(gFlaps, 0.0F, -0.7854F, 0.0F);

        gFrontLeftFlap = new RendererModel(this);
        gFrontLeftFlap.setRotationPoint(0.0F, -6.0F, -2.0784F);
        gFlaps.addChild(gFrontLeftFlap);

        rFrontLobe2_r1 = new RendererModel(this);
        rFrontLobe2_r1.setRotationPoint(0.0F, -1.75F, 0.3536F);
        gFrontLeftFlap.addChild(rFrontLobe2_r1);
        setRotationAngle(rFrontLobe2_r1, 0.0F, 0.7854F, 0.0F);
        rFrontLobe2_r1.cubeList.add(new ModelBox(rFrontLobe2_r1, 22, 12, -1.25F, -0.25F, -1.75F, 3, 2, 3, 0.0F, false));

        gFrontLeftFlapEnd = new RendererModel(this);
        gFrontLeftFlapEnd.setRotationPoint(0.0F, -1.5F, 0.7071F);
        gFrontLeftFlap.addChild(gFrontLeftFlapEnd);
        setRotationAngle(gFrontLeftFlapEnd, 0.0F, 0.0F, 0.0F);

        rFrontLobe2Child_r1 = new RendererModel(this);
        rFrontLobe2Child_r1.setRotationPoint(0.0F, -0.25F, -0.3536F);
        gFrontLeftFlapEnd.addChild(rFrontLobe2Child_r1);
        setRotationAngle(rFrontLobe2Child_r1, 0.0F, 0.7854F, 0.0F);
        rFrontLobe2Child_r1.cubeList.add(
            new ModelBox(rFrontLobe2Child_r1, 28, 0, -1.25F, -1.25F, -0.75F, 2, 2, 2, 0.0F, false)
        );

        gFrontRightFlap = new RendererModel(this);
        gFrontRightFlap.setRotationPoint(-2.1213F, -6.0F, 0.0429F);
        gFlaps.addChild(gFrontRightFlap);

        rFrontLobe3_r1 = new RendererModel(this);
        rFrontLobe3_r1.setRotationPoint(0.0F, -1.75F, 0.3536F);
        gFrontRightFlap.addChild(rFrontLobe3_r1);
        setRotationAngle(rFrontLobe3_r1, 0.0F, -0.7854F, 0.0F);
        rFrontLobe3_r1.cubeList.add(new ModelBox(rFrontLobe3_r1, 22, 18, -1.75F, -0.25F, -1.75F, 3, 2, 3, 0.0F, true));

        gFrontRightFlapEnd = new RendererModel(this);
        gFrontRightFlapEnd.setRotationPoint(0.7071F, -1.5F, 0.0F);
        gFrontRightFlap.addChild(gFrontRightFlapEnd);
        setRotationAngle(gFrontRightFlapEnd, 0.0F, 0.0F, 0.0F);

        rFrontLobe2Child_r2 = new RendererModel(this);
        rFrontLobe2Child_r2.setRotationPoint(0.0F, -0.25F, -0.3536F);
        gFrontRightFlapEnd.addChild(rFrontLobe2Child_r2);
        setRotationAngle(rFrontLobe2Child_r2, 0.0F, -0.7854F, 0.0F);
        rFrontLobe2Child_r2.cubeList.add(
            new ModelBox(rFrontLobe2Child_r2, 28, 6, -0.75F, -1.25F, -0.75F, 2, 2, 2, 0.0F, true)
        );

        gBackRightFlap = new RendererModel(this);
        gBackRightFlap.setRotationPoint(0.0F, -6.0F, 2.1642F);
        gFlaps.addChild(gBackRightFlap);

        rBackLobe3_r1 = new RendererModel(this);
        rBackLobe3_r1.setRotationPoint(0.0F, -1.75F, -0.3536F);
        gBackRightFlap.addChild(rBackLobe3_r1);
        setRotationAngle(rBackLobe3_r1, 0.0F, -0.7854F, 0.0F);
        rBackLobe3_r1.cubeList.add(new ModelBox(rBackLobe3_r1, 22, 18, -1.25F, -0.25F, -1.25F, 3, 2, 3, 0.0F, false));

        gBackRightFlapEnd = new RendererModel(this);
        gBackRightFlapEnd.setRotationPoint(0.0F, -1.5F, -0.7071F);
        gBackRightFlap.addChild(gBackRightFlapEnd);
        setRotationAngle(gBackRightFlapEnd, 0.0F, 0.0F, 0.0F);

        rBackLobeChild_r1 = new RendererModel(this);
        rBackLobeChild_r1.setRotationPoint(0.0F, -0.25F, 0.3536F);
        gBackRightFlapEnd.addChild(rBackLobeChild_r1);
        setRotationAngle(rBackLobeChild_r1, 0.0F, -0.7854F, 0.0F);
        rBackLobeChild_r1.cubeList.add(
            new ModelBox(rBackLobeChild_r1, 28, 6, -1.25F, -1.25F, -1.25F, 2, 2, 2, 0.0F, false)
        );

        gBackLeftFlap = new RendererModel(this);
        gBackLeftFlap.setRotationPoint(2.1213F, -6.0F, 0.0429F);
        gFlaps.addChild(gBackLeftFlap);

        rBackLobe4_r1 = new RendererModel(this);
        rBackLobe4_r1.setRotationPoint(0.0F, -1.75F, -0.3536F);
        gBackLeftFlap.addChild(rBackLobe4_r1);
        setRotationAngle(rBackLobe4_r1, 0.0F, -0.7854F, 0.0F);
        rBackLobe4_r1.cubeList.add(new ModelBox(rBackLobe4_r1, 22, 12, -1.25F, -0.25F, -1.25F, 3, 2, 3, 0.0F, false));

        gBackLeftFlapEnd = new RendererModel(this);
        gBackLeftFlapEnd.setRotationPoint(-0.7071F, -1.5F, 0.0F);
        gBackLeftFlap.addChild(gBackLeftFlapEnd);
        setRotationAngle(gBackLeftFlapEnd, 0.0F, 0.0F, 0.0F);

        rBackLobeChild_r2 = new RendererModel(this);
        rBackLobeChild_r2.setRotationPoint(0.0F, -0.25F, 0.3536F);
        gBackLeftFlapEnd.addChild(rBackLobeChild_r2);
        setRotationAngle(rBackLobeChild_r2, 0.0F, -0.7854F, 0.0F);
        rBackLobeChild_r2.cubeList.add(
            new ModelBox(rBackLobeChild_r2, 28, 0, -1.25F, -1.25F, -1.25F, 2, 2, 2, 0.0F, false)
        );
    }

    @Override
    public void render(
        OvamorphDracoEntity ovamorphDracoEntity,
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
