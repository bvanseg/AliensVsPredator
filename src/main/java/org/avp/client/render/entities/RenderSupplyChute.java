package org.avp.client.render.entities;

import org.avp.entities.EntitySupplyChute;

import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSupplyChute extends Render<EntitySupplyChute>
{
    public RenderSupplyChute(RenderManager m)
    {
        super(m);
    }
    
    @Override
    public void doRender(EntitySupplyChute chute, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        double renderX = (chute.posX - chute.lastTickPosX) * (double) renderPartialTicks;
        double renderY = (chute.posY - chute.lastTickPosY) * (double) renderPartialTicks;
        double renderZ = (chute.posZ - chute.lastTickPosZ) * (double) renderPartialTicks;
        
        OpenGL.pushMatrix();
        OpenGL.translate((float) posX, (float) posY + 0.75F, (float) posZ);
        OpenGL.translate((float) renderX, (float) renderY, (float) renderZ);
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.disableCullFace();
        OpenGL.rotate(chute.rotationYaw, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(chute.rotationPitch, 0.0F, 0.0F, 1.0F);
        chute.getType().getModel().draw();
        OpenGL.enableCullFace();
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySupplyChute entity)
    {
        return null;
    }
}
