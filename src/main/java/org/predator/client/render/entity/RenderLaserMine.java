package org.predator.client.render.entity;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.lwjgl.opengl.GL11;
import org.predator.common.entity.EntityLaserMine;

public class RenderLaserMine extends Render<EntityLaserMine>
{
    public RenderLaserMine(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntityLaserMine laserMine, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.translate((float) posX, (float) posY, (float) posZ);
            OpenGL.translate(0.0F, 0.25F, 0.0F);
            OpenGL.rotate(yaw, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glScaled(0.5F, 0.5F, 0.5F);
            AVP.resources().models().LASER_MINE.draw();
            GlStateManager.disableCull();
            OpenGL.scale(2F, -2F, 2F);
            OpenGL.translate(0.004F, -0.74F, 0.06F);

            boolean active = laserMine.hasBeenTripped();

            this.renderBeam(0, 0, Math.abs(laserMine.getLaserHitDistanceFromMine() * 2), -1, 0, 100, active ? 0x8800FF00 : 0x88FF0000, active ? 0x8800FF00 : 0x88FF0000, 90, 0, -1);
        }
        OpenGL.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLaserMine entity)
    {
        return null;
    }

    public void renderBeam(int x, int y, double w, int h, int zLevel, int scale, int color1, int color2, float rotationYaw, float rotationPitch, int l)
    {
        w = w * scale / 2;

        OpenGL.pushMatrix();
        {
            OpenGL.translate(0F, 0.75F, 0F);
            OpenGL.rotate(rotationYaw, 0F, 1F, 0F);
            OpenGL.rotate(rotationPitch, 0F, 0F, 1F);
            OpenGL.scale(1F / scale, 1F / scale, 1F / scale);
            OpenGL.disableTexture2d();
            OpenGL.enableBlend();
            OpenGL.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
            Draw.startQuadsColored();
            Draw.vertex(w, y, zLevel).color((color2 >> 16 & 255) / 255.0F, (color2 >> 8 & 255) / 255.0F, (color2 & 255) / 255.0F, (color2 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(x, y, zLevel).color((color2 >> 16 & 255) / 255.0F, (color2 >> 8 & 255) / 255.0F, (color2 & 255) / 255.0F, (color2 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(x, l, zLevel).color((color1 >> 16 & 255) / 255.0F, (color1 >> 8 & 255) / 255.0F, (color1 & 255) / 255.0F, (color1 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(w, h, zLevel).color((color1 >> 16 & 255) / 255.0F, (color1 >> 8 & 255) / 255.0F, (color1 & 255) / 255.0F, (color1 >> 24 & 255) / 255.0F).endVertex();
            Draw.tessellate();
            OpenGL.translate(0F, -0.5F, 0.5F);
            OpenGL.rotate(90F, 1F, 0F, 0F);
            Draw.startQuadsColored();
            Draw.vertex(w, y, zLevel).color((color2 >> 16 & 255) / 255.0F, (color2 >> 8 & 255) / 255.0F, (color2 & 255) / 255.0F, (color2 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(x, y, zLevel).color((color2 >> 16 & 255) / 255.0F, (color2 >> 8 & 255) / 255.0F, (color2 & 255) / 255.0F, (color2 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(x, l, zLevel).color((color1 >> 16 & 255) / 255.0F, (color1 >> 8 & 255) / 255.0F, (color1 & 255) / 255.0F, (color1 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(w, h, zLevel).color((color1 >> 16 & 255) / 255.0F, (color1 >> 8 & 255) / 255.0F, (color1 & 255) / 255.0F, (color1 >> 24 & 255) / 255.0F).endVertex();
            Draw.tessellate();
            OpenGL.blendClear();
            OpenGL.disableBlend();
            OpenGL.enableTexture2d();
        }
        OpenGL.popMatrix();
    }
}
