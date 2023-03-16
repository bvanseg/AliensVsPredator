package org.avp.client.model.tile;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.tile.TileEntityLightPanel;

public class ModelLightPanel extends Model<TileEntityLightPanel>
{
    ModelRenderer side0;
    ModelRenderer side1;
    ModelRenderer side2;
    ModelRenderer side3;
    ModelRenderer side4;
    ModelRenderer side5;
    ModelRenderer side6;
    ModelRenderer side7;
    ModelRenderer side8;
    ModelRenderer side9;
    ModelRenderer side10;
    ModelRenderer side11;

    public ModelLightPanel()
    {
        textureWidth = 64;
        textureHeight = 32;

        side0 = new ModelRenderer(this, 0, 0);
        side0.addBox(-8F, 0F, 6F, 16, 16, 0);
        side0.setRotationPoint(0F, 8F, 0F);
        side0.setTextureSize(64, 32);
        side0.mirror = true;
        setRotation(side0, 0F, 0F, 0F);
        side1 = new ModelRenderer(this, 0, 0);
        side1.addBox(-8F, 0F, -2F, 16, 16, 0);
        side1.setRotationPoint(0F, 8F, 0F);
        side1.setTextureSize(64, 32);
        side1.mirror = true;
        setRotation(side1, 0F, 0F, 0F);
        side2 = new ModelRenderer(this, 0, 0);
        side2.addBox(-8F, 0F, 2F, 16, 16, 0);
        side2.setRotationPoint(0F, 8F, 0F);
        side2.setTextureSize(64, 32);
        side2.mirror = true;
        setRotation(side2, 0F, 0F, 0F);
        side3 = new ModelRenderer(this, 0, 0);
        side3.addBox(-8F, 0F, -6F, 16, 16, 0);
        side3.setRotationPoint(0F, 8F, 0F);
        side3.setTextureSize(64, 32);
        side3.mirror = true;
        setRotation(side3, 0F, 0F, 0F);
        side4 = new ModelRenderer(this, 0, 0);
        side4.addBox(-8F, 0F, -2F, 16, 16, 0);
        side4.setRotationPoint(0F, 8F, 0F);
        side4.setTextureSize(64, 32);
        side4.mirror = true;
        setRotation(side4, 0F, 1.570796F, 0F);
        side5 = new ModelRenderer(this, 0, 0);
        side5.addBox(-8F, 0F, 2F, 16, 16, 0);
        side5.setRotationPoint(0F, 8F, 0F);
        side5.setTextureSize(64, 32);
        side5.mirror = true;
        setRotation(side5, 0F, 1.570796F, 0F);
        side6 = new ModelRenderer(this, 0, 0);
        side6.addBox(-8F, 0F, 6F, 16, 16, 0);
        side6.setRotationPoint(0F, 8F, 0F);
        side6.setTextureSize(64, 32);
        side6.mirror = true;
        setRotation(side6, 0F, 1.570796F, 0F);
        side7 = new ModelRenderer(this, 0, 0);
        side7.addBox(-8F, 0F, -6F, 16, 16, 0);
        side7.setRotationPoint(0F, 8F, 0F);
        side7.setTextureSize(64, 32);
        side7.mirror = true;
        setRotation(side7, 0F, 1.570796F, 0F);
        side8 = new ModelRenderer(this, 0, 0);
        side8.addBox(-8F, -8F, -6F, 16, 16, 0);
        side8.setRotationPoint(0F, 8F, 0F);
        side8.setTextureSize(64, 32);
        side8.mirror = true;
        setRotation(side8, 1.570796F, 0F, 0F);
        side9 = new ModelRenderer(this, 0, 0);
        side9.addBox(-8F, -8F, -2F, 16, 16, 0);
        side9.setRotationPoint(0F, 8F, 0F);
        side9.setTextureSize(64, 32);
        side9.mirror = true;
        setRotation(side9, 1.570796F, 0F, 0F);
        side10 = new ModelRenderer(this, 0, 0);
        side10.addBox(-8F, -8F, -10F, 16, 16, 0);
        side10.setRotationPoint(0F, 8F, 0F);
        side10.setTextureSize(64, 32);
        side10.mirror = true;
        setRotation(side10, 1.570796F, 0F, 0F);
        side11 = new ModelRenderer(this, 0, 0);
        side11.addBox(-8F, -8F, -14F, 16, 16, 0);
        side11.setRotationPoint(0F, 8F, 0F);
        side11.setTextureSize(64, 32);
        side11.mirror = true;
        setRotation(side11, 1.570796F, 0F, 0F);
    }

    @Override
    public void render(TileEntityLightPanel obj)
    {
        side0.render(DEFAULT_SCALE);
        side1.render(DEFAULT_SCALE);
        side2.render(DEFAULT_SCALE);
        side3.render(DEFAULT_SCALE);
        side4.render(DEFAULT_SCALE);
        side5.render(DEFAULT_SCALE);
        side6.render(DEFAULT_SCALE);
        side7.render(DEFAULT_SCALE);
        side8.render(DEFAULT_SCALE);
        side9.render(DEFAULT_SCALE);
        side10.render(DEFAULT_SCALE);
        side11.render(DEFAULT_SCALE);
    }
}
