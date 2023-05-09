package org.power.client.render.tile;

import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.common.system.SystemInfo;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.apache.commons.lang3.SystemUtils;
import org.avp.client.Resources;
import org.lwjgl.opengl.GL12;
import org.power.common.tile.TileEntityWorkstation;

import static org.lwjgl.opengl.GL11.*;

public class RenderWorkstation extends TileEntitySpecialRenderer<TileEntityWorkstation>
{
    private final int lines = 12;
    private final String[] displayText = new String[lines];

    @Override
    public void render(TileEntityWorkstation tile, double posX, double posY, double posZ, float partialTicks, int destroyStage, float alpha)
    {

        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL_CULL_FACE);
            OpenGL.enable(GL_BLEND);
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            OpenGL.translate(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
            OpenGL.rotate(tile.rotation * (-90F), 0F, 1F, 0F);
            OpenGL.enable(GL12.GL_RESCALE_NORMAL);
            OpenGL.scale(1.0F, -1.0F, 1.0F);
            OpenGL.enable(GL_ALPHA_TEST);
            Resources.instance.models().WORKSTATION.draw(tile);

            if (tile.isOperational())
            {
                OpenGL.disableLightMapping();
                OpenGL.disableLight();
                OpenGL.enable(GL_BLEND);
                OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
                Resources.instance.models().WORKSTATION_MASK.draw(tile);

                this.renderDisplay(tile);

                OpenGL.disable(GL_BLEND);
                OpenGL.enableLight();
                OpenGL.enableLightMapping();
            }
        }
        OpenGL.popMatrix();
    }

    public void renderDisplay(TileEntityWorkstation tile)
    {
        OpenGL.pushMatrix();
        {
            float textscale = 0.004F;
            OpenGL.translate(0.45F, -0.58F, 0.254F);
            OpenGL.rotate(6.5F, 1F, 0F, 0F);
            OpenGL.scale(-textscale, textscale, textscale);

            if (tile.getWorld().getTotalWorldTime() % 40 == 0)
            {
                try
                {
                    int linestart = 0;
                    displayText[linestart++] = "OS: \u00A77 Cake OS 9001";
                    displayText[linestart++] = "User:  \u00A77 Ri5ux was here.";
                    displayText[linestart++] = "Country:  \u00A77" + SystemUtils.USER_COUNTRY;
                    displayText[linestart++] = "Language:  \u00A77" + SystemUtils.USER_LANGUAGE;
                    displayText[linestart++] = "Java:  \u00A77" + SystemInfo.javaVersion();
                    displayText[linestart++] = "CPU Cores:  \u00A77" + SystemInfo.cpuCores();
                    displayText[linestart++] = "GPU:  \u00A77" + SystemInfo.gpu();
                    displayText[linestart++] = "GPU Vendor:  \u00A77" + (SystemInfo.gpuVendor().contains("NVIDIA") ? "\u00A7a" : (SystemInfo.gpuVendor().contains("AMD") || (SystemInfo.gpuVendor()).contains("ATI") ? "\u00A7c" : "\u00A7b")) + SystemInfo.gpuVendor();
                    displayText[linestart++] = "VMRAM:  \u00A77" + (SystemInfo.toMBFromB(SystemInfo.vmMemoryTotalBytes()) - SystemInfo.toMBFromB(SystemInfo.vmMemoryFreeBytes())) + "MB/" + SystemInfo.toMBFromB(SystemInfo.vmMemoryTotalBytes()) + "MB";
                    displayText[linestart++] = "VOLTAGE:  \u00A77" + tile.getVoltage();
                }
                catch (Exception e)
                {
                }
            }

            for (int l = 0; l < lines - 2; l++)
            {
                Draw.drawString(String.format("%s", displayText[l]), 0, l * 10, 0xFFFFFFFF);
            }
        }
        OpenGL.popMatrix();
    }
}
