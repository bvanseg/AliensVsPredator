package org.prometheus.common.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.prometheus.client.render.material.RenderMaterialBlackGoo;
import org.avp.common.api.blocks.material.MaterialPhysics;
import org.avp.common.api.blocks.material.MaterialRenderer;

public class MaterialBlackGoo extends MaterialLiquid implements MaterialPhysics
{
    private static final MaterialRenderer renderer = new RenderMaterialBlackGoo();
    
    public MaterialBlackGoo()
    {
        super(MapColor.BLACK);
        this.setNoPushMobility();
    }
    
    public boolean blocksMovement()
    {
        return true;
    }
    
    @Override
    public double getForceVelocity()
    {
        return 0.01D;
    }
    
    @Override
    public double getVelocity()
    {
        return 0.275D;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public MaterialRenderer getMaterialRenderer()
    {
        return renderer;
    }
}