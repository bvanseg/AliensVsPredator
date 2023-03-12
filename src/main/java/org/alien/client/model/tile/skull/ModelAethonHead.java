package org.alien.client.model.tile.skull;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.tile.TileEntitySkull;

public class ModelAethonHead extends Model<TileEntitySkull>
{
    public ModelRenderer head;
    public ModelRenderer beakMouthSlope;
    public ModelRenderer headSlope;
    public ModelRenderer beakLower;
    public ModelRenderer beak01;
    public ModelRenderer beak02;
    public ModelRenderer beak03;
    public ModelRenderer beak04;
    public ModelRenderer beakLower02;
    public ModelRenderer rbeakLower;
    public ModelRenderer rbeakLower02;

    public ModelAethonHead()
    {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.beak03 = new ModelRenderer(this, 27, 99);
        this.beak03.setRotationPoint(0.0F, 0.1F, -0.2F);
        this.beak03.addBox(-1.0F, -0.5F, -1.6F, 2, 1, 2, 0.0F);
        this.setRotation(beak03, 0.045553093477052F, 0.0F, 0.0F);
        this.rbeakLower = new ModelRenderer(this, 6, 98);
        this.rbeakLower.mirror = true;
        this.rbeakLower.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.rbeakLower.addBox(-0.7F, -0.9F, -5.0F, 2, 2, 5, 0.0F);
        this.headSlope = new ModelRenderer(this, 3, 79);
        this.headSlope.setRotationPoint(0.0F, 0.0F, 1.1F);
        this.headSlope.addBox(-2.5F, -5.3F, -9.4F, 5, 2, 4, 0.0F);
        this.setRotation(headSlope, 0.44872415068774213F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 65);
        this.head.setRotationPoint(0.0F, 21.5F, 4.5F);
        this.head.addBox(-3.5F, -2.5F, -7.0F, 7, 5, 7, 0.0F);
        this.beakMouthSlope = new ModelRenderer(this, 4, 87);
        this.beakMouthSlope.setRotationPoint(0.0F, -1.1F, 1.4F);
        this.beakMouthSlope.addBox(-1.5F, -2.7F, -12.1F, 3, 1, 2, 0.0F);
        this.setRotation(beakMouthSlope, 0.36425021489121656F, 0.0F, 0.0F);
        this.beak02 = new ModelRenderer(this, 26, 94);
        this.beak02.setRotationPoint(0.0F, -0.4F, -1.9F);
        this.beak02.addBox(-1.5F, -0.5F, -0.6F, 3, 1, 1, 0.0F);
        this.setRotation(beak02, 0.091106186954104F, 0.0F, 0.0F);
        this.rbeakLower02 = new ModelRenderer(this, 31, 80);
        this.rbeakLower02.mirror = true;
        this.rbeakLower02.setRotationPoint(0.0F, 0.5F, -5.0F);
        this.rbeakLower02.addBox(-0.5F, -0.5F, -1.8F, 1, 1, 2, 0.0F);
        this.setRotation(rbeakLower02, -0.22689280275926282F, 0.0F, 0.0F);
        this.beak04 = new ModelRenderer(this, 28, 104);
        this.beak04.setRotationPoint(0.0F, 0.1F, -1.4F);
        this.beak04.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotation(beak04, 0.091106186954104F, 0.0F, 0.0F);
        this.beakLower02 = new ModelRenderer(this, 31, 80);
        this.beakLower02.setRotationPoint(-0.5F, 0.5F, -5.0F);
        this.beakLower02.addBox(-0.7F, -0.5F, -1.8F, 1, 1, 2, 0.0F);
        this.setRotation(beakLower02, -0.22689280275926282F, 0.0F, 0.0F);
        this.beak01 = new ModelRenderer(this, 26, 87);
        this.beak01.setRotationPoint(0.0F, -2.6F, -10.2F);
        this.beak01.addBox(-2.0F, -1.0F, -1.7F, 4, 1, 2, 0.0F);
        this.setRotation(beak01, 0.27314402793711257F, 0.0F, 0.0F);
        this.beakLower = new ModelRenderer(this, 6, 98);
        this.beakLower.setRotationPoint(1.6F, 0.6F, -5.3F);
        this.beakLower.addBox(-1.7F, -0.9F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotation(beakLower, 0.22689280275926282F, 0.0F, 0.0F);
        this.beak02.addChild(this.beak03);
        this.beakLower.addChild(this.rbeakLower);
        this.head.addChild(this.headSlope);
        this.head.addChild(this.beakMouthSlope);
        this.beak01.addChild(this.beak02);
        this.rbeakLower.addChild(this.rbeakLower02);
        this.beak03.addChild(this.beak04);
        this.beakLower.addChild(this.beakLower02);
        this.beakMouthSlope.addChild(this.beak01);
        this.head.addChild(this.beakLower);
    }
    
    @Override
    public void render(TileEntitySkull obj)
    {
        draw(head);
    }
}
