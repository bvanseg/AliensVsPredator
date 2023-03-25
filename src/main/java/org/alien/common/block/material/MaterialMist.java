package org.alien.common.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialTransparent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.render.material.RenderMaterialMist;
import org.avp.common.api.blocks.material.MaterialPhysics;
import org.avp.common.api.blocks.material.MaterialRenderer;

public class MaterialMist extends MaterialTransparent implements MaterialPhysics
{
    private static final MaterialRenderer renderer = new RenderMaterialMist();

    public MaterialMist()
    {
        super(MapColor.LIGHT_BLUE);
    }
    
    @Override
    public double getForceVelocity()
    {
        return 0D;
    }
    
    @Override
    public double getVelocity()
    {
        return 0D;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public MaterialRenderer getMaterialRenderer()
    {
        return renderer;
    }
}
