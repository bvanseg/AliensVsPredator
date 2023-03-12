package org.avp.client.model.tile;

import org.avp.common.tile.TileEntityAmpule;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelAmpule extends Model<TileEntityAmpule>
{
    public ModelRenderer canisterBase2;
    public ModelRenderer canisterMiddle1;
    public ModelRenderer canisterLid1;
    public ModelRenderer canisterBase1;
    public ModelRenderer canisterLid2;
    public ModelRenderer phialTop1;
    public ModelRenderer phialTip1;
    public ModelRenderer phialStem1;
    public ModelRenderer phailBase;
    public ModelRenderer phialTop2;
    public ModelRenderer phialTip2;
    public ModelRenderer phialStem2;
    public ModelRenderer phailBase2;
    public ModelRenderer phialTop3;
    public ModelRenderer phialTip3;
    public ModelRenderer phialStem3;
    public ModelRenderer phailBase3;
    public ModelRenderer phialTop4;
    public ModelRenderer phialTip4;
    public ModelRenderer phialStem4;
    public ModelRenderer phailBase4;

    public ModelAmpule()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.phialStem3 = new ModelRenderer(this, 32, 45);
        this.phialStem3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialStem3.addBox(-2.3F, 10.1F, -2.3F, 1, 2, 1, 0.0F);
        this.phialTip4 = new ModelRenderer(this, 46, 33);
        this.phialTip4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTip4.addBox(1.5F, 4.7F, -2.3F, 1, 3, 1, 0.0F);
        this.phialStem2 = new ModelRenderer(this, 18, 45);
        this.phialStem2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialStem2.addBox(1.7F, 10.1F, 1.8F, 1, 2, 1, 0.0F);
        this.phialTop3 = new ModelRenderer(this, 30, 39);
        this.phialTop3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTop3.addBox(-2.8F, 7.7F, -2.8F, 2, 3, 2, 0.0F);
        this.phialTip2 = new ModelRenderer(this, 18, 33);
        this.phialTip2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTip2.addBox(1.7F, 4.7F, 1.8F, 1, 3, 1, 0.0F);
        this.canisterBase2 = new ModelRenderer(this, 81, 0);
        this.canisterBase2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.canisterBase2.addBox(-4.5F, 13.0F, -4.5F, 9, 8, 9, 0.0F);
        this.phailBase3 = new ModelRenderer(this, 29, 50);
        this.phailBase3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phailBase3.addBox(-3.3F, 11.7F, -3.3F, 3, 8, 3, 0.0F);
        this.phialStem4 = new ModelRenderer(this, 46, 45);
        this.phialStem4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialStem4.addBox(1.5F, 10.1F, -2.3F, 1, 2, 1, 0.0F);
        this.phialTip1 = new ModelRenderer(this, 5, 33);
        this.phialTip1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTip1.addBox(-2.3F, 4.7F, 1.8F, 1, 3, 1, 0.0F);
        this.canisterLid2 = new ModelRenderer(this, 0, 0);
        this.canisterLid2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.canisterLid2.addBox(-4.5F, -1.0F, -4.5F, 9, 5, 9, 0.0F);
        this.phailBase4 = new ModelRenderer(this, 43, 50);
        this.phailBase4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phailBase4.addBox(0.5F, 11.7F, -3.3F, 3, 8, 3, 0.0F);
        this.phailBase = new ModelRenderer(this, 1, 50);
        this.phailBase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phailBase.addBox(-3.3F, 11.7F, 0.8F, 3, 8, 3, 0.0F);
        this.canisterLid1 = new ModelRenderer(this, 37, 0);
        this.canisterLid1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.canisterLid1.addBox(-5.0F, 4.0F, -5.0F, 10, 5, 10, 0.0F);
        this.canisterMiddle1 = new ModelRenderer(this, 37, 16);
        this.canisterMiddle1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.canisterMiddle1.addBox(-5.0F, 9.0F, -5.0F, 10, 4, 10, 0.0F);
        this.phialTop4 = new ModelRenderer(this, 44, 39);
        this.phialTop4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTop4.addBox(1.0F, 7.7F, -2.8F, 2, 3, 2, 0.0F);
        this.phialStem1 = new ModelRenderer(this, 5, 45);
        this.phialStem1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialStem1.addBox(-2.3F, 10.1F, 1.8F, 1, 2, 1, 0.0F);
        this.canisterBase1 = new ModelRenderer(this, 81, 22);
        this.canisterBase1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.canisterBase1.addBox(-4.0F, 18.0F, -4.0F, 8, 6, 8, 0.0F);
        this.phialTip3 = new ModelRenderer(this, 32, 33);
        this.phialTip3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTip3.addBox(-2.3F, 4.7F, -2.3F, 1, 3, 1, 0.0F);
        this.phialTop2 = new ModelRenderer(this, 16, 39);
        this.phialTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTop2.addBox(1.2F, 7.7F, 1.3F, 2, 3, 2, 0.0F);
        this.phailBase2 = new ModelRenderer(this, 15, 50);
        this.phailBase2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phailBase2.addBox(0.7F, 11.7F, 0.8F, 3, 8, 3, 0.0F);
        this.phialTop1 = new ModelRenderer(this, 3, 39);
        this.phialTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.phialTop1.addBox(-2.8F, 7.7F, 1.3F, 2, 3, 2, 0.0F);
    }

    @Override
    public void render(TileEntityAmpule obj)
    {
        draw(phialStem3);
        draw(phialTip4);
        draw(phialStem2);
        draw(phialTop3);
        draw(phialTip2);
        draw(canisterBase2);
        draw(phailBase3);
        draw(phialStem4);
        draw(phialTip1);
        draw(canisterLid2);
        draw(phailBase4);
        draw(phailBase);
        draw(canisterLid1);
        draw(canisterMiddle1);
        draw(phialTop4);
        draw(phialStem1);
        draw(canisterBase1);
        draw(phialTip3);
        draw(phialTop2);
        draw(phailBase2);
        draw(phialTop1);
    }
}
