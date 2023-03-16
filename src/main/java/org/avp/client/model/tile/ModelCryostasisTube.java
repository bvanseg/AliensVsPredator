package org.avp.client.model.tile;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.tile.TileEntityCryostasisTube;

public class ModelCryostasisTube extends Model<TileEntityCryostasisTube>
{
    public final ModelRenderer cap,
        capN,
        glassN,
        capNE,
        capE,
        capSE,
        supportBar,
        capSW,
        capW,
        capNW,
        glassNW,
        glassW,
        glassSW,
        glassNE,
        glassE,
        glassSE,
        baseBottom,
        baseSW,
        baseW,
        baseNW,
        baseN,
        baseNE,
        baseE,
        baseSE;

    public ModelCryostasisTube()
    {
        textureWidth = 256;
        textureHeight = 128;

        cap = new ModelRenderer(this, 0, 44);
        cap.addBox(-8.5F, -19F, -8.5F, 17, 0, 17);
        cap.setRotationPoint(0F, 1F, 0F);
        cap.setTextureSize(256, 128);
        cap.mirror = true;
        setRotation(cap, 0F, -1.570796F, 0F);
        capN = new ModelRenderer(this, 85, 26);
        capN.addBox(-3.5F, -18F, 5.5F, 7, 4, 3);
        capN.setRotationPoint(0F, 0F, 0F);
        capN.setTextureSize(256, 128);
        capN.mirror = true;
        setRotation(capN, 0F, 0F, 0F);
        glassN = new ModelRenderer(this, 36, 18);
        glassN.addBox(-3F, -14.8F, 7.2F, 6, 25, 0);
        glassN.setRotationPoint(0F, 0F, 0F);
        glassN.setTextureSize(256, 128);
        glassN.mirror = true;
        setRotation(glassN, 0F, 0F, 0F);
        capNE = new ModelRenderer(this, 106, 26);
        capNE.addBox(-3.5F, -18F, 5.5F, 7, 4, 3);
        capNE.setRotationPoint(0F, 0F, 0F);
        capNE.setTextureSize(256, 128);
        capNE.mirror = true;
        setRotation(capNE, 0F, 0.7853982F, 0F);
        capE = new ModelRenderer(this, 127, 26);
        capE.addBox(-3.5F, -18F, 5.5F, 7, 4, 3);
        capE.setRotationPoint(0F, 0F, 0F);
        capE.setTextureSize(256, 128);
        capE.mirror = true;
        setRotation(capE, 0F, 1.570796F, 0F);
        capSE = new ModelRenderer(this, 85, 34);
        capSE.addBox(-3.5F, -18F, 5.5F, 7, 4, 3);
        capSE.setRotationPoint(0F, 0F, 0F);
        capSE.setTextureSize(256, 128);
        capSE.mirror = true;
        setRotation(capSE, 0F, 2.356194F, 0F);
        supportBar = new ModelRenderer(this, 148, 0);
        supportBar.addBox(-4.5F, -18F, 6.5F, 9, 42, 3);
        supportBar.setRotationPoint(0F, 0F, 0F);
        supportBar.setTextureSize(256, 128);
        supportBar.mirror = true;
        setRotation(supportBar, 0F, 3.141593F, 0F);
        capSW = new ModelRenderer(this, 85, 18);
        capSW.addBox(-3.5F, -18F, 5.5F, 7, 4, 3);
        capSW.setRotationPoint(0F, 0F, 0F);
        capSW.setTextureSize(256, 128);
        capSW.mirror = true;
        setRotation(capSW, 0F, -2.356194F, 0F);
        capW = new ModelRenderer(this, 106, 18);
        capW.addBox(-3.5F, -18F, 5.5F, 7, 4, 3);
        capW.setRotationPoint(0F, 0F, 0F);
        capW.setTextureSize(256, 128);
        capW.mirror = true;
        setRotation(capW, 0F, -1.570796F, 0F);
        capNW = new ModelRenderer(this, 127, 18);
        capNW.addBox(-3.5F, -18F, 5.5F, 7, 4, 3);
        capNW.setRotationPoint(0F, 0F, 0F);
        capNW.setTextureSize(256, 128);
        capNW.mirror = true;
        setRotation(capNW, 0F, -0.7853982F, 0F);
        glassNW = new ModelRenderer(this, 24, 18);
        glassNW.addBox(-3F, -14.8F, 7.2F, 6, 25, 0);
        glassNW.setRotationPoint(0F, 0F, 0F);
        glassNW.setTextureSize(256, 128);
        glassNW.mirror = true;
        setRotation(glassNW, 0F, -0.7853982F, 0F);
        glassW = new ModelRenderer(this, 12, 18);
        glassW.addBox(-3F, -14.8F, 7.2F, 6, 25, 0);
        glassW.setRotationPoint(0F, 0F, 0F);
        glassW.setTextureSize(256, 128);
        glassW.mirror = true;
        setRotation(glassW, 0F, -1.570796F, 0F);
        glassSW = new ModelRenderer(this, 0, 18);
        glassSW.addBox(-3F, -14.8F, 7.2F, 6, 25, 0);
        glassSW.setRotationPoint(0F, 0F, 0F);
        glassSW.setTextureSize(256, 128);
        glassSW.mirror = true;
        setRotation(glassSW, 0F, -2.356194F, 0F);
        glassNE = new ModelRenderer(this, 48, 18);
        glassNE.addBox(-3F, -14.8F, 7.2F, 6, 25, 0);
        glassNE.setRotationPoint(0F, 0F, 0F);
        glassNE.setTextureSize(256, 128);
        glassNE.mirror = true;
        setRotation(glassNE, 0F, 0.7853982F, 0F);
        glassE = new ModelRenderer(this, 60, 18);
        glassE.addBox(-3F, -14.8F, 7.2F, 6, 25, 0);
        glassE.setRotationPoint(0F, 0F, 0F);
        glassE.setTextureSize(256, 128);
        glassE.mirror = true;
        setRotation(glassE, 0F, 1.570796F, 0F);
        glassSE = new ModelRenderer(this, 72, 18);
        glassSE.addBox(-3F, -14.8F, 7.2F, 6, 25, 0);
        glassSE.setRotationPoint(0F, 0F, 0F);
        glassSE.setTextureSize(256, 128);
        glassSE.mirror = true;
        setRotation(glassSE, 0F, 2.356194F, 0F);
        baseBottom = new ModelRenderer(this, 68, 44);
        baseBottom.addBox(-8.5F, 23F, -8.5F, 17, 0, 17);
        baseBottom.setRotationPoint(0F, 1F, 0F);
        baseBottom.setTextureSize(256, 128);
        baseBottom.mirror = true;
        setRotation(baseBottom, 0F, -1.570796F, 0F);
        baseSW = new ModelRenderer(this, 0, 0);
        baseSW.addBox(-3.5F, 10F, 5.5F, 7, 14, 3);
        baseSW.setRotationPoint(0F, 0F, 0F);
        baseSW.setTextureSize(256, 128);
        baseSW.mirror = true;
        setRotation(baseSW, 0F, -2.356194F, 0F);
        baseW = new ModelRenderer(this, 20, 0);
        baseW.addBox(-3.5F, 10F, 5.5F, 7, 14, 3);
        baseW.setRotationPoint(0F, 0F, 0F);
        baseW.setTextureSize(256, 128);
        baseW.mirror = true;
        setRotation(baseW, 0F, -1.570796F, 0F);
        baseNW = new ModelRenderer(this, 40, 0);
        baseNW.addBox(-3.5F, 10F, 5.5F, 7, 14, 3);
        baseNW.setRotationPoint(0F, 0F, 0F);
        baseNW.setTextureSize(256, 128);
        baseNW.mirror = true;
        setRotation(baseNW, 0F, -0.7853982F, 0F);
        baseN = new ModelRenderer(this, 60, 0);
        baseN.addBox(-3.5F, 10F, 5.5F, 7, 14, 3);
        baseN.setRotationPoint(0F, 0F, 0F);
        baseN.setTextureSize(256, 128);
        baseN.mirror = true;
        setRotation(baseN, 0F, 0F, 0F);
        baseNE = new ModelRenderer(this, 80, 0);
        baseNE.addBox(-3.5F, 10F, 5.5F, 7, 14, 3);
        baseNE.setRotationPoint(0F, 0F, 0F);
        baseNE.setTextureSize(256, 128);
        baseNE.mirror = true;
        setRotation(baseNE, 0F, 0.7853982F, 0F);
        baseE = new ModelRenderer(this, 100, 0);
        baseE.addBox(-3.5F, 10F, 5.5F, 7, 14, 3);
        baseE.setRotationPoint(0F, 0F, 0F);
        baseE.setTextureSize(256, 128);
        baseE.mirror = true;
        setRotation(baseE, 0F, 1.570796F, 0F);
        baseSE = new ModelRenderer(this, 120, 0);
        baseSE.addBox(-3.5F, 10F, 5.5F, 7, 14, 3);
        baseSE.setRotationPoint(0F, 0F, 0F);
        baseSE.setTextureSize(256, 128);
        baseSE.mirror = true;
        setRotation(baseSE, 0F, 2.356194F, 0F);
    }

    @Override
    public void render(TileEntityCryostasisTube obj)
    {
        cap.render(DEFAULT_SCALE);
        capN.render(DEFAULT_SCALE);
        glassN.render(DEFAULT_SCALE);
        capNE.render(DEFAULT_SCALE);
        capE.render(DEFAULT_SCALE);
        capSE.render(DEFAULT_SCALE);
        supportBar.render(DEFAULT_SCALE);
        capSW.render(DEFAULT_SCALE);
        capW.render(DEFAULT_SCALE);
        capNW.render(DEFAULT_SCALE);
        glassNW.render(DEFAULT_SCALE);
        glassW.render(DEFAULT_SCALE);
        glassSW.render(DEFAULT_SCALE);
        glassNE.render(DEFAULT_SCALE);
        glassE.render(DEFAULT_SCALE);
        glassSE.render(DEFAULT_SCALE);
        baseBottom.render(DEFAULT_SCALE);
        baseSW.render(DEFAULT_SCALE);
        baseW.render(DEFAULT_SCALE);
        baseNW.render(DEFAULT_SCALE);
        baseN.render(DEFAULT_SCALE);
        baseNE.render(DEFAULT_SCALE);
        baseE.render(DEFAULT_SCALE);
        baseSE.render(DEFAULT_SCALE);
    }
}
