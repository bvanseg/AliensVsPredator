package org.avp.client.render.entities;

import org.avp.AliensVsPredator;
import org.avp.entities.EntityShuriken;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderShuriken extends Render<EntityShuriken>
{
    public RenderShuriken(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntityShuriken entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.translate(posX, posY, posZ);
            OpenGL.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * renderPartialTicks, 0.0F, 0.0F, 1.0F);
            OpenGL.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * renderPartialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.disableCull();
            
            if (!entity.isInGround())
            {
                OpenGL.rotate(360 - (entity.world.getWorldTime() % 360 + Game.partialTicks()) * 60, 0, 1, 0);
            }
            
            OpenGL.translate(-0.5F, 0.0F, -0.5F);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            OpenGL.rotate(90, 1, 0, 0);
            AliensVsPredator.resources().SHURIKEN.bind();
            Draw.drawQuad(0, 0, 1, 1, 0, 0.5F, 0F, 0F, 0.5F);
            OpenGL.enable(GL11.GL_CULL_FACE);
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShuriken entity)
    {
        return null;
    }
}
