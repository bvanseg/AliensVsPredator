package org.alien.client.render.material;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.Vec3d;
import org.avp.common.api.blocks.material.MaterialRenderer;
import org.lwjgl.opengl.GL11;


public class RenderMaterialMist implements MaterialRenderer
{
    @Override
    public void renderMaterialOverlay(Material material)
    {
        ;
    }
    
    @Override
    public Vec3d getFogColor()
    {
        return new Vec3d(0.55, 0.7, 0.9);
    }
    
    @Override
    public void renderFog(Material material)
    {
        GlStateManager.setFog(GlStateManager.FogMode.EXP);
        GL11.glFogf(GL11.GL_FOG_DENSITY, 0.2F);
    }
}
