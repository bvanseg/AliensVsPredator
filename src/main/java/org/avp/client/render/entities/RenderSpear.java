package org.avp.client.render.entities;

import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.avp.common.entities.EntitySpear;
import org.lwjgl.opengl.GL12;

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
            AVP.resources().models().SPEAR.draw();
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
