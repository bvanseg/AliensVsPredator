package org.avp.client.render.entities;

import org.avp.AliensVsPredator;
import org.avp.entities.EntityShuriken;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.util.ResourceLocation;

public class RenderShuriken extends Render<EntityShuriken>
{
    public RenderShuriken()
    {
        super(Game.renderManager());
    }

    @Override
    public void doRender(EntityShuriken entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.translate(posX, posY, posZ);
            OpenGL.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * renderPartialTicks, 0.0F, 0.0F, 1.0F);
            OpenGL.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * renderPartialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            OpenGL.translate(-0.5F, 0.0F, -0.5F);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
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