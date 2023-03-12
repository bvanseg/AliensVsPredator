package org.avp.client.model.tile.skulls;

import org.avp.common.tile.TileEntitySkull;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;

public class ModelQueenSkull extends Model<TileEntitySkull>
{
    public ModelRenderer head0;
    public ModelRenderer head1;
    public ModelRenderer Jaw1;
    public ModelRenderer headFinL0;
    public ModelRenderer headFinR0;
    public ModelRenderer headBase0;
    public ModelRenderer headWebL;
    public ModelRenderer headWebR;
    public ModelRenderer headFinL1;
    public ModelRenderer headFinR1;
    public ModelRenderer headFinL2;
    public ModelRenderer headFinR2;
    public ModelRenderer headSpinesM;
    public ModelRenderer headSpinesL;
    public ModelRenderer headSpinesR;

    public ModelQueenSkull()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.headWebR = new ModelRenderer(this, 22, 70);
        this.headWebR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headWebR.addBox(-4.8F, -5.0F, -1.2F, 3, 6, 0, 0.0F);
        this.setRotation(headWebR, 0.0F, 0.12217304763960307F, -0.091106186954104F);
        this.headSpinesM = new ModelRenderer(this, 112, 18);
        this.headSpinesM.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headSpinesM.addBox(0.0F, -6.0F, -1.0F, 0, 4, 24, 0.0F);
        this.setRotation(headSpinesM, 1.3264502315156905F, 0.0F, 0.0F);
        this.head0 = new ModelRenderer(this, 19, 19);
        this.head0.setRotationPoint(0.0F, 11.3F, 4.0F);
        this.head0.addBox(-3.5F, -5.0F, -3.0F, 7, 11, 5, 0.0F);
        this.headWebL = new ModelRenderer(this, 15, 70);
        this.headWebL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headWebL.addBox(1.8F, -5.0F, -1.2F, 3, 6, 0, 0.0F);
        this.setRotation(headWebL, 0.0F, -0.12217304763960307F, 0.091106186954104F);
        this.Jaw1 = new ModelRenderer(this, 19, 77);
        this.Jaw1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw1.addBox(-1.5F, 5.6F, -8.5F, 3, 4, 6, 0.0F);
        this.setRotation(Jaw1, 0.9773843811168246F, 0.0F, 0.0F);
        this.headFinL0 = new ModelRenderer(this, 0, 59);
        this.headFinL0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinL0.addBox(0.0F, -4.0F, -2.0F, 5, 5, 2, 0.0F);
        this.setRotation(headFinL0, -0.15707963267948966F, -0.091106186954104F, 1.0016444577195458F);
        this.headSpinesL = new ModelRenderer(this, 63, 18);
        this.headSpinesL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headSpinesL.addBox(1.0F, -6.0F, -1.0F, 0, 4, 24, 0.0F);
        this.setRotation(headSpinesL, 1.3264502315156905F, 0.0F, 0.296705972839036F);
        this.headFinR0 = new ModelRenderer(this, 0, 67);
        this.headFinR0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinR0.addBox(-5.0F, -4.0F, -2.0F, 5, 5, 2, 0.0F);
        this.setRotation(headFinR0, -0.15707963267948966F, 0.091106186954104F, -1.0016444577195458F);
        this.headFinR1 = new ModelRenderer(this, 28, 61);
        this.headFinR1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinR1.addBox(-6.0F, -9.6F, -3.1F, 4, 6, 2, 0.0F);
        this.setRotation(headFinR1, -0.27314402793711257F, 0.18203784098300857F, -0.091106186954104F);
        this.headFinR2 = new ModelRenderer(this, 44, 47);
        this.headFinR2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinR2.addBox(-3.6F, -23.0F, -3.0F, 7, 13, 2, 0.0F);
        this.setRotation(headFinR2, -0.31869712141416456F, 0.18203784098300857F, -0.31869712141416456F);
        this.head1 = new ModelRenderer(this, 44, 19);
        this.head1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head1.addBox(-2.5F, 3.8F, -5.2F, 5, 5, 6, 0.0F);
        this.setRotation(head1, 0.5009094953223726F, 0.0F, 0.0F);
        this.headFinL2 = new ModelRenderer(this, 44, 31);
        this.headFinL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinL2.addBox(-4.3F, -23.0F, -3.0F, 7, 13, 2, 0.0F);
        this.setRotation(headFinL2, -0.31869712141416456F, -0.18203784098300857F, 0.36425021489121656F);
        this.headSpinesR = new ModelRenderer(this, 161, 18);
        this.headSpinesR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headSpinesR.addBox(-1.0F, -6.0F, -1.0F, 0, 4, 24, 0.0F);
        this.setRotation(headSpinesR, 1.3264502315156905F, 0.0F, -0.296705972839036F);
        this.headBase0 = new ModelRenderer(this, 19, 36);
        this.headBase0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headBase0.addBox(-3.5F, -23.0F, -4.2F, 7, 19, 5, 0.0F);
        this.setRotation(headBase0, -0.2792526803190927F, 0.0F, 0.0F);
        this.headFinL1 = new ModelRenderer(this, 15, 61);
        this.headFinL1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headFinL1.addBox(2.5F, -9.6F, -3.1F, 4, 6, 2, 0.0F);
        this.setRotation(headFinL1, -0.27314402793711257F, -0.18203784098300857F, 0.0F);
        this.head0.addChild(this.headWebR);
        this.head0.addChild(this.headSpinesM);
        this.head0.addChild(this.headWebL);
        this.head0.addChild(this.Jaw1);
        this.head0.addChild(this.headFinL0);
        this.head0.addChild(this.headSpinesL);
        this.head0.addChild(this.headFinR0);
        this.head0.addChild(this.headFinR1);
        this.head0.addChild(this.headFinR2);
        this.head0.addChild(this.head1);
        this.head0.addChild(this.headFinL2);
        this.head0.addChild(this.headSpinesR);
        this.head0.addChild(this.headBase0);
        this.head0.addChild(this.headFinL1);
    }

    @Override
    public void render(TileEntitySkull obj)
    {
        draw(head0);
    }
}
