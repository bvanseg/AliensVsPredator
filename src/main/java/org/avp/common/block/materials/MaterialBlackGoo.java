package org.avp.common.block.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.render.material.RenderMaterialBlackGoo;
import org.avp.common.api.blocks.material.IMaterialPhysics;
import org.avp.common.api.blocks.material.IMaterialRenderer;

public class MaterialBlackGoo extends MaterialLiquid implements IMaterialPhysics
{
    private static final IMaterialRenderer renderer = new RenderMaterialBlackGoo();
    
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
    public IMaterialRenderer getMaterialRenderer()
    {
        return renderer;
    }
}