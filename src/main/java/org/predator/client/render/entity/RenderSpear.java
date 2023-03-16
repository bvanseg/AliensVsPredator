package org.predator.client.render.entity;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.client.Resources;
import org.lwjgl.opengl.GL12;
import org.predator.common.entity.EntitySpear;

public class RenderSpear extends Render<EntitySpear>
{
    public RenderSpear(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntitySpear entity, double posX, double posY, double posZ, float rotationYaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.translate((float) posX, (float) posY, (float) posZ);
            OpenGL.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * renderPartialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * renderPartialTicks, 0.0F, 0.0F, 1.0F);
            Resources.instance.models().SPEAR.draw();
            OpenGL.disable(GL12.GL_RESCALE_NORMAL);
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySpear entity)
    {
        return null;
    }
}
