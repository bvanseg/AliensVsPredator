package org.power.client.model.tile;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.power.common.tile.TileEntitySolarPanel;

public class ModelSolarPanel extends Model<TileEntitySolarPanel>
{
    private final ModelRenderer panel;

    public ModelSolarPanel()
    {
        textureWidth = 64;
        textureHeight = 32;

        panel = new ModelRenderer(this, 0, 0);
        panel.addBox(-8F, 22F, -8F, 16, 2, 16);
        panel.setRotationPoint(0F, 0F, 0F);
        panel.mirror = true;
        setRotation(panel, 0F, 0F, 0F);
    }

    @Override
    public void render(TileEntitySolarPanel obj)
    {
        draw(panel);
    }
}
