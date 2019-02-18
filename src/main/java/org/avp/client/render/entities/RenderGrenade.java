package org.avp.client.render.entities;

import org.avp.AliensVsPredator;
import org.avp.entities.EntityGrenade;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGrenade extends Render<EntityGrenade>
{
    public RenderGrenade(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntityGrenade grenade, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        OpenGL.translate((float) posX, (float) posY + 0.75F, (float) posZ);
        OpenGL.rotate(grenade.rotationYaw, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(grenade.rotationPitch, 0.0F, 0.0F, 1.0F);
        OpenGL.rotate(180.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.translate(0.25F, 0.5F, 0.0F);
        OpenGL.scale(0.75F, 0.75F, 0.75F);
        
        if (!grenade.isFlaming())
        {
            AliensVsPredator.resources().models().M40GRENADE.draw();
        }
        else
        {
            AliensVsPredator.resources().models().M40GRENADE_INCENDIARY.draw();
        }

        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGrenade entity)
    {
        return null;
    }
}
