package org.avp.common.block.materials;

import org.avp.common.api.blocks.material.IMaterialPhysics;
import org.avp.common.api.blocks.material.IMaterialRenderer;
import org.avp.client.render.materials.RenderMaterialMist;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialTransparent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MaterialMist extends MaterialTransparent implements IMaterialPhysics
{
    private static final IMaterialRenderer renderer = new RenderMaterialMist();

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
    public IMaterialRenderer getMaterialRenderer()
    {
        return renderer;
    }
}
