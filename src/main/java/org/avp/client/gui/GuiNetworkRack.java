package org.avp.client.gui;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityNetworkRack;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class GuiNetworkRack extends GuiContainer
{
    private TileEntityNetworkRack rack;

    public GuiNetworkRack(EntityPlayer player, TileEntityNetworkRack rack)
    {
        super(rack.getNewContainer(player));
        this.rack = rack;
        this.xSize = 170;
        this.ySize = 203;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
        Draw.drawResource(AliensVsPredator.resources().GUI_NETWORK_RACK, this.guiLeft, this.guiTop, 256, 256);

        for (int idx = 3; idx >= 0; idx--)
        {
            ItemStack stack = this.rack.inventory.getStackInSlot(idx);

            int sW = 16;
            int sH = 16;
            int sP = 6;
            int sPH = 4;
            int sX = this.guiLeft + 26;
            int sY = this.guiTop + 19 + (sH * idx) + (sP * idx);

            if (stack != null)
            {
                float s = 0.5F;
                
                OpenGL.pushMatrix();
                OpenGL.scale(s, s, s);
                Draw.drawString(stack.getDisplayName(), (sX + sW + (sPH * 2)) * 2, (sY + (sH / 4) + 2) * 2, 0xFFFFFFFF);
                OpenGL.popMatrix();
            }
        }
    }
}
