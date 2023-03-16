package org.avp.client.render.entity;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.common.entity.EntityFlame;

public class RenderFlame extends Render<EntityFlame>
{
    public RenderFlame(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntityFlame entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        OpenGL.translate((float) posX, (float) posY, (float) posZ);
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFlame entity)
    {
        return null;
    }
}
