package org.predator.client.render.entity;

import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.predator.client.PredatorResources;
import org.predator.common.entity.EntitySmartDisc;

public class RenderDisc extends Render<EntitySmartDisc>
{
    public RenderDisc(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntitySmartDisc entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.translate(posX, posY, posZ);
            OpenGL.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * renderPartialTicks, 0.0F, 0.0F, 1.0F);
            OpenGL.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * renderPartialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.disableCull();
            OpenGL.translate(-0.5F, 0.0F, -0.5F);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            OpenGL.rotate(90F, 1F, 0F, 0F);
            PredatorResources.instance.DISC.bind();
            Draw.drawQuad(0, 0, 1, 1, 0, 0.5F, 0F, 0F, 0.5F);
            OpenGL.enable(GL11.GL_CULL_FACE);
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySmartDisc entity)
    {
        return null;
    }
}
