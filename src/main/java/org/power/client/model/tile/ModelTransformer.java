package org.power.client.model.tile;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.power.common.tile.TileEntityTransformer;

public class ModelTransformer extends Model<TileEntityTransformer>
{
    public final ModelRenderer powerOutput;
    public final ModelRenderer rightSupport;
    public final ModelRenderer leftSupport;
    public final ModelRenderer base;
    public final ModelRenderer topSupport;
    public final ModelRenderer core;
    public final ModelRenderer powerInput;

    public ModelTransformer()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.core = new ModelRenderer(this, 36, 17);
        this.core.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.core.addBox(-4.0F, -13.0F, -4.0F, 8, 13, 8, 0.0F);
        this.base = new ModelRenderer(this, 44, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.powerInput = new ModelRenderer(this, 44, 0);
        this.powerInput.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.powerInput.addBox(-2.0F, -9.0F, -8.0F, 4, 9, 2, 0.0F);
        this.powerOutput = new ModelRenderer(this, 0, 0);
        this.powerOutput.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.powerOutput.addBox(-2.0F, -9.0F, 6.0F, 4, 9, 2, 0.0F);
        this.rightSupport = new ModelRenderer(this, 12, 0);
        this.rightSupport.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.rightSupport.addBox(4.0F, -15.0F, -2.0F, 4, 16, 4, 0.0F);
        this.leftSupport = new ModelRenderer(this, 28, 0);
        this.leftSupport.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.leftSupport.addBox(-8.0F, -15.0F, -2.0F, 4, 16, 4, 0.0F);
        this.topSupport = new ModelRenderer(this, 92, 0);
        this.topSupport.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.topSupport.addBox(-4.0F, -15.0F, -2.0F, 8, 2, 4, 0.0F);
    }

    @Override
    public void render(TileEntityTransformer obj)
    {
        draw(core);
        draw(base);
        draw(powerInput);
        draw(powerOutput);
        draw(rightSupport);
        draw(leftSupport);
        draw(topSupport);
    }
}
