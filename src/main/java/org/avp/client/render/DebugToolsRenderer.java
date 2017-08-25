package org.avp.client.render;

import org.avp.AliensVsPredator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DebugToolsRenderer
{
    public static final DebugToolsRenderer instance = new DebugToolsRenderer();

    public DebugToolsRenderer()
    {
        ;
    }

    @SubscribeEvent
    public void renderWorldLastEvent(RenderWorldLastEvent event)
    {
        EntityPlayer p = Minecraft.getMinecraft().player;
        Tessellator tess = Tessellator.getInstance();
        VertexBuffer buff = tess.getBuffer();

        if (AliensVsPredator.settings().areDebugToolsEnabled())
        {
            double x = p.lastTickPosX + (p.posX - p.lastTickPosX) * (double) event.getPartialTicks();
            double y = p.lastTickPosY + (p.posY - p.lastTickPosY) * (double) event.getPartialTicks();
            double z = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * (double) event.getPartialTicks();
            double sY = 0.0D - y;
            double eY = 256.0D - y;
            double sX = (double) (p.chunkCoordX << 4) - x;
            double sZ = (double) (p.chunkCoordZ << 4) - z;

            GlStateManager.disableTexture2D();
            GlStateManager.glLineWidth(1.0F);
            GlStateManager.enableBlend();
            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);

            for (int k = 1; k < 16; k += 1)
            {
                buff.pos(sX + (double) k, sY, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
                buff.pos(sX + (double) k, sY, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + (double) k, eY, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + (double) k, eY, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
                buff.pos(sX + (double) k, sY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
                buff.pos(sX + (double) k, sY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + (double) k, eY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + (double) k, eY, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            }

            for (int l = 1; l < 16; l += 1)
            {
                buff.pos(sX, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
                buff.pos(sX, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
                buff.pos(sX + 16.0D, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
                buff.pos(sX + 16.0D, sY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + 16.0D, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + 16.0D, eY, sZ + (double) l).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            }

            for (int i1 = 0; i1 <= 256; i1 += 1)
            {
                double d7 = (double) i1 - y;
                buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
                buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX, d7, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + 16.0D, d7, sZ + 16.0D).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX + 16.0D, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.6F).endVertex();
                buff.pos(sX, d7, sZ).color(0.0F, 1.0F, 0.0F, 0.0F).endVertex();
            }

            tess.draw();
            GlStateManager.glLineWidth(3.0F);
            buff.begin(3, DefaultVertexFormats.POSITION_COLOR);

            for (int j1 = 0; j1 <= 16; j1 += 16)
            {
                for (int l1 = 0; l1 <= 16; l1 += 16)
                {
                    buff.pos(sX + (double) j1, sY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 0.0F).endVertex();
                    buff.pos(sX + (double) j1, sY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                    buff.pos(sX + (double) j1, eY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                    buff.pos(sX + (double) j1, eY, sZ + (double) l1).color(0.25F, 0F, 1.0F, 0.0F).endVertex();
                }
            }

            for (int k1 = 0; k1 <= 256; k1 += 16)
            {
                double d8 = (double) k1 - y;
                buff.pos(sX, d8, sZ).color(0.25F, 0.25F, 1.0F, 0.0F).endVertex();
                buff.pos(sX, d8, sZ).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                buff.pos(sX, d8, sZ + 16.0D).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                buff.pos(sX + 16.0D, d8, sZ + 16.0D).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                buff.pos(sX + 16.0D, d8, sZ).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                buff.pos(sX, d8, sZ).color(0.25F, 0F, 1.0F, 1.0F).endVertex();
                buff.pos(sX, d8, sZ).color(0.25F, 0.25F, 1.0F, 0.0F).endVertex();
            }

            tess.draw();
            GlStateManager.glLineWidth(1.0F);
            GlStateManager.enableTexture2D();
        }
    }
}
