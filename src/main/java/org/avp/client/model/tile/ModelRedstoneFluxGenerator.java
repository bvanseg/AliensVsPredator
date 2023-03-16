package org.avp.client.model.tile;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.tile.TileEntityRedstoneFluxGenerator;

/**
 * fluxconverter - cybercat5555
 * Created using Tabula 5.1.0
 */
public class ModelRedstoneFluxGenerator extends Model<TileEntityRedstoneFluxGenerator>
{
    public final ModelRenderer base;
    public final ModelRenderer fluxLightOutput;
    public final ModelRenderer fluxLightInput;
    public final ModelRenderer electicityNode;
    public final ModelRenderer fluxNode;
    public final ModelRenderer coil;
    public final ModelRenderer fluxFaceplate;
    public final ModelRenderer electricityLightInput;
    public final ModelRenderer electricityLightOutput;

    public ModelRedstoneFluxGenerator()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.electicityNode = new ModelRenderer(this, 21, 0);
        this.electicityNode.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.electicityNode.addBox(-2.0F, -9.5F, 6.0F, 4, 9, 2, 0.0F);
        this.electricityLightInput = new ModelRenderer(this, 13, 0);
        this.electricityLightInput.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.electricityLightInput.addBox(-0.5F, -0.5F, 7.2F, 1, 1, 1, 0.0F);
        this.base = new ModelRenderer(this, 0, 12);
        this.base.setRotationPoint(0.0F, 23.5F, 0.0F);
        this.base.addBox(-8.0F, -0.5F, -8.0F, 16, 1, 16, 0.0F);
        this.fluxLightOutput = new ModelRenderer(this, 34, 0);
        this.fluxLightOutput.setRotationPoint(0.0F, 14.4F, 0.0F);
        this.fluxLightOutput.addBox(-0.5F, -0.5F, -8.2F, 1, 1, 1, 0.0F);
        this.fluxNode = new ModelRenderer(this, 0, 0);
        this.fluxNode.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.fluxNode.addBox(-2.0F, -9.5F, -8.0F, 4, 9, 2, 0.0F);
        this.fluxLightInput = new ModelRenderer(this, 34, 5);
        this.fluxLightInput.setRotationPoint(0.0F, 14.4F, 0.0F);
        this.fluxLightInput.addBox(-0.5F, -0.5F, -8.2F, 1, 1, 1, 0.0F);
        this.electricityLightOutput = new ModelRenderer(this, 13, 5);
        this.electricityLightOutput.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.electricityLightOutput.addBox(-0.5F, -0.5F, 7.2F, 1, 1, 1, 0.0F);
        this.coil = new ModelRenderer(this, 0, 31);
        this.coil.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.coil.addBox(-4.0F, -13.5F, 0.0F, 8, 13, 4, 0.0F);
        this.fluxFaceplate = new ModelRenderer(this, 30, 31);
        this.fluxFaceplate.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.fluxFaceplate.addBox(-4.5F, -14.5F, -3.8F, 9, 14, 5, 0.0F);
        this.base.addChild(this.electicityNode);
        this.fluxLightOutput.addChild(this.electricityLightInput);
        this.base.addChild(this.fluxNode);
        this.fluxLightInput.addChild(this.electricityLightOutput);
        this.base.addChild(this.coil);
        this.base.addChild(this.fluxFaceplate);
    }
    @Override
    public void render(TileEntityRedstoneFluxGenerator obj)
    {
        draw(base);
        draw(fluxLightOutput);
        draw(fluxLightInput);
    }
}
