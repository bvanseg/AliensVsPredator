package org.avp.client.model.tile;

import org.avp.common.tile.TileEntitySatelliteDish;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelSatelliteDish extends Model<TileEntitySatelliteDish>
{
    public ModelRenderer discBaseN;
    public ModelRenderer swivelJoint;
    public ModelRenderer swivelJointConnector;
    public ModelRenderer base;
    public ModelRenderer baseLatticeN;
    public ModelRenderer baseLatticeW;
    public ModelRenderer baseLatticeS;
    public ModelRenderer baseLatticeE;
    public ModelRenderer baseLatticeN2;
    public ModelRenderer baseLatticeW2;
    public ModelRenderer baseLatticeS2;
    public ModelRenderer baseLatticeE2;
    public ModelRenderer spokeN;
    public ModelRenderer discBaseE;
    public ModelRenderer discBaseS;
    public ModelRenderer discBaseW;
    public ModelRenderer discBaseNE;
    public ModelRenderer discBaseSE;
    public ModelRenderer discBaseSW;
    public ModelRenderer discBaseNW;
    public ModelRenderer panelENE;
    public ModelRenderer panelNNW;
    public ModelRenderer panelESE;
    public ModelRenderer panelWSW;
    public ModelRenderer panelNNE;
    public ModelRenderer panelWNW;
    public ModelRenderer panelSSE;
    public ModelRenderer panelSSW;
    public ModelRenderer latticeN;
    public ModelRenderer latticeE;
    public ModelRenderer latticeS;
    public ModelRenderer latticeW;
    public ModelRenderer subreflector;
    public ModelRenderer spokeE;
    public ModelRenderer spokeS;
    public ModelRenderer spokeW;
    public ModelRenderer spokeNE;
    public ModelRenderer spokeSE;
    public ModelRenderer spokeSW;
    public ModelRenderer spokeNW;

    public ModelSatelliteDish()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.spokeSE = new ModelRenderer(this, 0, 0);
        this.spokeSE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeSE.addBox(-1.0F, 3.1F, 3.5F, 2, 1, 18, 0.0F);
        this.setRotation(spokeSE, 0.7285004297824331F, 0.0F, 0.0F);
        this.latticeW = new ModelRenderer(this, 0, 44);
        this.latticeW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.latticeW.addBox(-1.0F, -16.9F, 9.3F, 2, 17, 0, 0.0F);
        this.setRotation(latticeW, 0.3839724354387525F, -1.5707963267948966F, 0.0F);
        this.latticeN = new ModelRenderer(this, 0, 44);
        this.latticeN.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.latticeN.addBox(-1.0F, -16.9F, 9.3F, 2, 17, 0, 0.0F);
        this.setRotation(latticeN, 0.3839724354387525F, 0.0F, 0.0F);
        this.discBaseW = new ModelRenderer(this, 0, 0);
        this.discBaseW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.discBaseW.addBox(-2.5F, 0.0F, 4.0F, 5, 2, 2, 0.0F);
        this.setRotation(discBaseW, 0.0F, -1.5707963267948966F, 0.0F);
        this.spokeSW = new ModelRenderer(this, 0, 0);
        this.spokeSW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeSW.addBox(-1.0F, 3.1F, 3.5F, 2, 1, 18, 0.0F);
        this.setRotation(spokeSW, 0.7285004297824331F, 3.141592653589793F, 0.0F);
        this.spokeNW = new ModelRenderer(this, 0, 0);
        this.spokeNW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeNW.addBox(-1.0F, 3.1F, 3.5F, 2, 1, 18, 0.0F);
        this.setRotation(spokeNW, 0.7285004297824331F, 3.141592653589793F, 0.0F);
        this.discBaseN = new ModelRenderer(this, 0, 0);
        this.discBaseN.setRotationPoint(0.0F, -1.7F, 0.0F);
        this.discBaseN.addBox(-2.5F, 0.0F, 4.0F, 5, 2, 2, 0.0F);
        this.latticeE = new ModelRenderer(this, 0, 44);
        this.latticeE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.latticeE.addBox(-1.0F, -16.9F, 9.3F, 2, 17, 0, 0.0F);
        this.setRotation(latticeE, 0.3839724354387525F, 1.5707963267948966F, 0.0F);
        this.discBaseE = new ModelRenderer(this, 0, 0);
        this.discBaseE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.discBaseE.addBox(-2.5F, 0.0F, 4.0F, 5, 2, 2, 0.0F);
        this.setRotation(discBaseE, 0.0F, 1.5707963267948966F, 0.0F);
        this.base = new ModelRenderer(this, 46, 31);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-4.0F, 10.4F, -4.0F, 8, 14, 8, 0.0F);
        this.baseLatticeE2 = new ModelRenderer(this, 84, 26);
        this.baseLatticeE2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeE2.addBox(0.0F, 9.4F, -14.0F, 0, 23, 4, 0.0F);
        this.setRotation(baseLatticeE2, 1.0927506446736497F, 1.5707963267948966F, 0.0F);
        this.panelNNW = new ModelRenderer(this, 0, 23);
        this.panelNNW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelNNW.addBox(-5.5F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelNNW, -0.8196066167365371F, -0.41887902047863906F, 0.0F);
        this.swivelJointConnector = new ModelRenderer(this, 75, 0);
        this.swivelJointConnector.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.swivelJointConnector.addBox(-4.0F, -1.6F, -4.0F, 8, 4, 8, 0.0F);
        this.discBaseNW = new ModelRenderer(this, 0, 0);
        this.discBaseNW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.discBaseNW.addBox(-2.5F, 0.0F, -6.0F, 5, 2, 2, 0.0F);
        this.setRotation(discBaseNW, 0.0F, 2.356194490192345F, 0.0F);
        this.subreflector = new ModelRenderer(this, 47, 18);
        this.subreflector.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.subreflector.addBox(-2.5F, -21.3F, -2.5F, 5, 3, 5, 0.0F);
        this.baseLatticeW2 = new ModelRenderer(this, 84, 26);
        this.baseLatticeW2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeW2.addBox(0.0F, 9.4F, -14.0F, 0, 23, 4, 0.0F);
        this.setRotation(baseLatticeW2, 1.0927506446736497F, -1.5707963267948966F, 0.0F);
        this.baseLatticeS2 = new ModelRenderer(this, 84, 26);
        this.baseLatticeS2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeS2.addBox(0.0F, 9.4F, -14.0F, 0, 23, 4, 0.0F);
        this.setRotation(baseLatticeS2, 1.0927506446736497F, 3.141592653589793F, 0.0F);
        this.panelENE = new ModelRenderer(this, 0, 23);
        this.panelENE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelENE.addBox(-5.8F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelENE, -0.8196066167365371F, 1.1693705988362009F, 0.0F);
        this.baseLatticeN2 = new ModelRenderer(this, 84, 26);
        this.baseLatticeN2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeN2.addBox(0.0F, 9.4F, -14.0F, 0, 23, 4, 0.0F);
        this.setRotation(baseLatticeN2, 1.0927506446736497F, 0.0F, 0.0F);
        this.baseLatticeS = new ModelRenderer(this, 28, 22);
        this.baseLatticeS.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeS.addBox(-1.5F, 9.4F, -11.0F, 3, 23, 1, 0.0F);
        this.setRotation(baseLatticeS, 1.0927506446736497F, 3.141592653589793F, 0.0F);
        this.discBaseSW = new ModelRenderer(this, 0, 0);
        this.discBaseSW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.discBaseSW.addBox(-2.5F, 0.0F, -6.0F, 5, 2, 2, 0.0F);
        this.setRotation(discBaseSW, 0.0F, 0.7853981633974483F, 0.0F);
        this.spokeN = new ModelRenderer(this, 0, 0);
        this.spokeN.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeN.addBox(-1.0F, 3.1F, 3.5F, 2, 1, 18, 0.0F);
        this.setRotation(spokeN, 0.7285004297824331F, 0.0F, 0.0F);
        this.spokeNE = new ModelRenderer(this, 0, 0);
        this.spokeNE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeNE.addBox(-1.0F, 3.1F, 3.2F, 2, 1, 18, 0.0F);
        this.setRotation(spokeNE, 0.7285004297824331F, 0.0F, 0.0F);
        this.panelWNW = new ModelRenderer(this, 0, 23);
        this.panelWNW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelWNW.addBox(-5.9F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelWNW, -0.8196066167365371F, -1.1838568316277536F, 0.0F);
        this.baseLatticeE = new ModelRenderer(this, 28, 22);
        this.baseLatticeE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeE.addBox(-1.5F, 9.4F, -11.0F, 3, 23, 1, 0.0F);
        this.setRotation(baseLatticeE, 1.0927506446736497F, 1.5707963267948966F, 0.0F);
        this.baseLatticeW = new ModelRenderer(this, 28, 22);
        this.baseLatticeW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeW.addBox(-1.5F, 9.4F, -11.0F, 3, 23, 1, 0.0F);
        this.setRotation(baseLatticeW, 1.0927506446736497F, -1.5707963267948966F, 0.0F);
        this.panelESE = new ModelRenderer(this, 0, 23);
        this.panelESE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelESE.addBox(-6.2F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelESE, -0.8196066167365371F, 1.9722220547535922F, 0.0F);
        this.panelNNE = new ModelRenderer(this, 0, 23);
        this.panelNNE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelNNE.addBox(-7.0F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelNNE, -0.8196066167365371F, 0.4363323129985824F, 0.0F);
        this.spokeE = new ModelRenderer(this, 0, 0);
        this.spokeE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeE.addBox(-1.0F, 3.1F, 3.5F, 2, 1, 18, 0.0F);
        this.setRotation(spokeE, 0.7285004297824331F, 0.0F, 0.0F);
        this.latticeS = new ModelRenderer(this, 0, 44);
        this.latticeS.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.latticeS.addBox(-1.0F, -16.9F, 9.3F, 2, 17, 0, 0.0F);
        this.setRotation(latticeS, 0.3839724354387525F, 3.141592653589793F, 0.0F);
        this.swivelJoint = new ModelRenderer(this, 46, 0);
        this.swivelJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.swivelJoint.addBox(-3.0F, 2.4F, -3.0F, 6, 8, 6, 0.0F);
        this.panelSSE = new ModelRenderer(this, 0, 23);
        this.panelSSE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelSSE.addBox(-5.5F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelSSE, -0.8196066167365371F, 2.7227136331111543F, 0.0F);
        this.panelSSW = new ModelRenderer(this, 0, 23);
        this.panelSSW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelSSW.addBox(-5.8F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelSSW, -0.8196066167365371F, 3.5255650890285457F, 0.0F);
        this.discBaseS = new ModelRenderer(this, 0, 0);
        this.discBaseS.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.discBaseS.addBox(-2.5F, 0.0F, 4.0F, 5, 2, 2, 0.0F);
        this.setRotation(discBaseS, 0.0F, 3.141592653589793F, 0.0F);
        this.panelWSW = new ModelRenderer(this, 0, 23);
        this.panelWSW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.panelWSW.addBox(-5.8F, -20.1F, 3.7F, 12, 17, 0, 0.0F);
        this.setRotation(panelWSW, -0.8196066167365371F, -1.9722220547535922F, 0.0F);
        this.spokeS = new ModelRenderer(this, 0, 0);
        this.spokeS.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeS.addBox(-1.0F, 3.1F, 3.5F, 2, 1, 18, 0.0F);
        this.setRotation(spokeS, 0.7285004297824331F, 0.0F, 0.0F);
        this.spokeW = new ModelRenderer(this, 0, 0);
        this.spokeW.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.spokeW.addBox(-1.0F, 3.1F, 3.5F, 2, 1, 18, 0.0F);
        this.setRotation(spokeW, 0.7285004297824331F, 0.0F, 0.0F);
        this.discBaseNE = new ModelRenderer(this, 0, 0);
        this.discBaseNE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.discBaseNE.addBox(-2.5F, 0.0F, 4.0F, 5, 2, 2, 0.0F);
        this.setRotation(discBaseNE, 0.0F, 0.7853981633974483F, 0.0F);
        this.baseLatticeN = new ModelRenderer(this, 28, 22);
        this.baseLatticeN.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.baseLatticeN.addBox(-1.5F, 9.4F, -11.0F, 3, 23, 1, 0.0F);
        this.setRotation(baseLatticeN, 1.0927506446736497F, 0.0F, 0.0F);
        this.discBaseSE = new ModelRenderer(this, 0, 0);
        this.discBaseSE.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.discBaseSE.addBox(-2.5F, 0.0F, 4.0F, 5, 2, 2, 0.0F);
        this.setRotation(discBaseSE, 0.0F, 2.356194490192345F, 0.0F);
        this.discBaseSE.addChild(this.spokeSE);
        this.discBaseN.addChild(this.latticeW);
        this.discBaseN.addChild(this.latticeN);
        this.discBaseN.addChild(this.discBaseW);
        this.discBaseSW.addChild(this.spokeSW);
        this.discBaseNW.addChild(this.spokeNW);
        this.discBaseN.addChild(this.latticeE);
        this.discBaseN.addChild(this.discBaseE);
        this.discBaseN.addChild(this.panelNNW);
        this.discBaseN.addChild(this.discBaseNW);
        this.discBaseN.addChild(this.subreflector);
        this.discBaseN.addChild(this.panelENE);
        this.discBaseN.addChild(this.discBaseSW);
        this.discBaseN.addChild(this.spokeN);
        this.discBaseNE.addChild(this.spokeNE);
        this.discBaseN.addChild(this.panelWNW);
        this.discBaseN.addChild(this.panelESE);
        this.discBaseN.addChild(this.panelNNE);
        this.discBaseE.addChild(this.spokeE);
        this.discBaseN.addChild(this.latticeS);
        this.discBaseN.addChild(this.panelSSE);
        this.discBaseN.addChild(this.panelSSW);
        this.discBaseN.addChild(this.discBaseS);
        this.discBaseN.addChild(this.panelWSW);
        this.discBaseS.addChild(this.spokeS);
        this.discBaseW.addChild(this.spokeW);
        this.discBaseN.addChild(this.discBaseNE);
        this.discBaseN.addChild(this.discBaseSE);
    }

    @Override
    public void render(TileEntitySatelliteDish obj)
    {
        draw(discBaseN);
        draw(base);
        draw(baseLatticeE2);
        draw(swivelJointConnector);
        draw(baseLatticeW2);
        draw(baseLatticeS2);
        draw(baseLatticeN2);
        draw(baseLatticeS);
        draw(baseLatticeE);
        draw(baseLatticeW);
        draw(swivelJoint);
        draw(baseLatticeN);        
    }
}
