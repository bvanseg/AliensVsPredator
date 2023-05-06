package org.power.client.model.tile;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.power.common.tile.TileEntityBlastdoor;
import org.power.common.tile.TileEntitySevastopolBlastDoor;

public class ModelSevastopolBlastdoor extends Model<TileEntitySevastopolBlastDoor>
{
    public final ModelRenderer frameL;
    public final ModelRenderer doorMain;
    public final ModelRenderer frameR;
    public final ModelRenderer frameT;
    public final ModelRenderer frameB;
    public final ModelRenderer frameTL;
    public final ModelRenderer frameTR;
    public final ModelRenderer frameTL2;
    public final ModelRenderer frameTR2;
    public final ModelRenderer frameBL;
    public final ModelRenderer frameBR;
    public final ModelRenderer frameBR2;
    public final ModelRenderer frameBL2;
    public final ModelRenderer doorTop;
    public final ModelRenderer doorBotton;
    public final ModelRenderer keypadF;
    public final ModelRenderer doorTopL;
    public final ModelRenderer doorTopR;
    public final ModelRenderer doorBottomL;
    public final ModelRenderer doorBottomR;
    public final ModelRenderer keypadB;
    public final ModelRenderer indicatorLightF;
    public final ModelRenderer indicatorLightB;

    public ModelSevastopolBlastdoor()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.frameTR = new ModelRenderer(this, 111, 33);
        this.frameTR.mirror = true;
        this.frameTR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frameTR.addBox(8.0F, -2.5F, -8.0F, 8, 11, 16, 0.0F);
        this.indicatorLightB = new ModelRenderer(this, 19, 106);
        this.indicatorLightB.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.indicatorLightB.addBox(-3.0F, 4.6F, 1.0F, 6, 3, 1, 0.0F);
        this.frameBL = new ModelRenderer(this, 111, 67);
        this.frameBL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frameBL.addBox(-16.0F, -9.5F, -8.0F, 8, 11, 16, 0.0F);
        this.frameB = new ModelRenderer(this, 112, 1);
        this.frameB.setRotationPoint(14.0F, 22.5F, 0.0F);
        this.frameB.addBox(-8.0F, -2.5F, -8.0F, 16, 4, 16, 0.0F);
        this.frameTL = new ModelRenderer(this, 111, 33);
        this.frameTL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frameTL.addBox(-16.0F, -2.5F, -8.0F, 8, 11, 16, 0.0F);
        this.frameT = new ModelRenderer(this, 44, 1);
        this.frameT.setRotationPoint(14.0F, -21.5F, 0.0F);
        this.frameT.addBox(-8.0F, -2.5F, -8.0F, 16, 4, 16, 0.0F);
        this.frameTR2 = new ModelRenderer(this, 166, 31);
        this.frameTR2.mirror = true;
        this.frameTR2.setRotationPoint(4.4F, 0.0F, 0.0F);
        this.frameTR2.addBox(-1.23F, 0.8F, -8.0F, 4, 8, 16, 0.0F);
        this.setRotation(frameTR2, 0.0F, 0.0F, -0.5918411493512771F);
        this.frameL = new ModelRenderer(this, 0, 0);
        this.frameL.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.frameL.addBox(-2.0F, -13.0F, -8.0F, 4, 26, 16, 0.0F);
        this.doorTop = new ModelRenderer(this, 73, 46);
        this.doorTop.setRotationPoint(0.0F, -1.1F, 0.0F);
        this.doorTop.addBox(4.0F, -8.3F, -4.0F, 8, 8, 8, 0.0F);
        this.frameTL2 = new ModelRenderer(this, 166, 31);
        this.frameTL2.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.frameTL2.addBox(-1.23F, -0.1F, -8.0F, 4, 8, 16, 0.0F);
        this.setRotation(frameTL2, 0.0F, 0.0F, 0.5918411493512771F);
        this.keypadF = new ModelRenderer(this, 0, 91);
        this.keypadF.setRotationPoint(8.0F, 9.9F, -3.5F);
        this.keypadF.addBox(-3.0F, -4.0F, -1.0F, 6, 8, 1, 0.0F);
        this.indicatorLightF = new ModelRenderer(this, 0, 106);
        this.indicatorLightF.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.indicatorLightF.addBox(-3.0F, 4.6F, -1.0F, 6, 3, 1, 0.0F);
        this.frameBL2 = new ModelRenderer(this, 166, 67);
        this.frameBL2.setRotationPoint(-4.4F, 0.3F, 0.0F);
        this.frameBL2.addBox(-1.83F, -9.7F, -8.0F, 4, 9, 16, 0.0F);
        this.setRotation(frameBL2, 0.0F, 0.0F, -0.5918411493512771F);
        this.doorTopL = new ModelRenderer(this, 73, 85);
        this.doorTopL.setRotationPoint(4.5F, -9.0F, 0.0F);
        this.doorTopL.addBox(0.5F, 1.1F, -4.0F, 4, 9, 8, 0.0F);
        this.setRotation(doorTopL, 0.0F, 0.0F, 0.5918411493512771F);
        this.doorBottomL = new ModelRenderer(this, 73, 106);
        this.doorBottomL.setRotationPoint(4.5F, 30.9F, 0.0F);
        this.doorBottomL.addBox(-0.1F, -9.6F, -4.0F, 4, 9, 8, 0.0F);
        this.setRotation(doorBottomL, 0.0F, 0.0F, -0.5918411493512771F);
        this.frameBR2 = new ModelRenderer(this, 166, 67);
        this.frameBR2.mirror = true;
        this.frameBR2.setRotationPoint(4.4F, 0.3F, 0.0F);
        this.frameBR2.addBox(-2.18F, -9.7F, -8.0F, 4, 9, 16, 0.0F);
        this.setRotation(frameBR2, 0.0F, 0.0F, 0.5918411493512771F);
        this.doorBotton = new ModelRenderer(this, 73, 65);
        this.doorBotton.setRotationPoint(0.0F, 0.2F, 0.0F);
        this.doorBotton.addBox(4.0F, 22.8F, -4.0F, 8, 8, 8, 0.0F);
        this.doorMain = new ModelRenderer(this, 0, 48);
        this.doorMain.setRotationPoint(0.0F, -11.0F, 0.0F);
        this.doorMain.addBox(-4.0F, -2.0F, -4.0F, 24, 26, 8, 0.0F);
        this.frameBR = new ModelRenderer(this, 111, 67);
        this.frameBR.mirror = true;
        this.frameBR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.frameBR.addBox(8.0F, -9.5F, -8.0F, 8, 11, 16, 0.0F);
        this.doorBottomR = new ModelRenderer(this, 73, 106);
        this.doorBottomR.mirror = true;
        this.doorBottomR.setRotationPoint(11.0F, 30.7F, 0.0F);
        this.doorBottomR.addBox(-3.4F, -9.7F, -4.0F, 4, 9, 8, 0.0F);
        this.setRotation(doorBottomR, 0.0F, 0.0F, 0.5918411493512771F);
        this.doorTopR = new ModelRenderer(this, 73, 85);
        this.doorTopR.mirror = true;
        this.doorTopR.setRotationPoint(11.0F, -9.0F, 0.0F);
        this.doorTopR.addBox(-4.0F, 1.4F, -4.0F, 4, 9, 8, 0.0F);
        this.setRotation(doorTopR, 0.0F, 0.0F, -0.5918411493512771F);
        this.frameR = new ModelRenderer(this, 0, 0);
        this.frameR.mirror = true;
        this.frameR.setRotationPoint(20.0F, 0.0F, 0.0F);
        this.frameR.addBox(6.0F, -13.0F, -8.0F, 4, 26, 16, 0.0F);
        this.keypadB = new ModelRenderer(this, 19, 91);
        this.keypadB.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.keypadB.addBox(-3.0F, -4.0F, 1.0F, 6, 8, 1, 0.0F);
        this.frameT.addChild(this.frameTR);
        this.keypadB.addChild(this.indicatorLightB);
        this.frameB.addChild(this.frameBL);
        this.frameL.addChild(this.frameB);
        this.frameT.addChild(this.frameTL);
        this.frameL.addChild(this.frameT);
        this.frameT.addChild(this.frameTR2);
        this.doorMain.addChild(this.doorTop);
        this.frameT.addChild(this.frameTL2);
        this.doorMain.addChild(this.keypadF);
        this.keypadF.addChild(this.indicatorLightF);
        this.frameB.addChild(this.frameBL2);
        this.doorTop.addChild(this.doorTopL);
        this.doorBotton.addChild(this.doorBottomL);
        this.frameB.addChild(this.frameBR2);
        this.doorMain.addChild(this.doorBotton);
        this.frameB.addChild(this.frameBR);
        this.doorBotton.addChild(this.doorBottomR);
        this.doorTop.addChild(this.doorTopR);
        this.frameL.addChild(this.frameR);
        this.keypadF.addChild(this.keypadB);
    }

    @Override
    public void render(TileEntitySevastopolBlastDoor obj)
    {
        TileEntityBlastdoor tile = (TileEntityBlastdoor) obj;
        
        if (tile != null)
        {
            float doorProgress = tile.getDoorProgress() * 2;
            float doorProgressPrev = tile.getDoorProgressPrev() * 2;
            doorProgress = doorProgressPrev + (doorProgress - doorProgressPrev) * ClientGame.instance.partialTicks();
            
            float doorRight = -doorProgress;

            doorMain.offsetY = doorRight;
            doorMain.offsetY = doorRight;
        }
        
        draw(frameL);
        draw(doorMain);
    }
}
