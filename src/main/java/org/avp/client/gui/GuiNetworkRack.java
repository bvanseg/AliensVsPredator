package org.avp.client.gui;

import org.avp.tile.TileEntityNetworkRack;

import com.arisux.mdx.lib.client.render.Draw;

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
        drawRect(this.guiLeft, this.guiTop, this.guiLeft + this.xSize, this.guiTop + this.ySize, 0xCC000000);
        Draw.drawString(this.rack.inventory.getName(), this.guiLeft + 5, this.guiTop + 5, 0xFFFFFFFF);

        for (int idx = 3; idx >= 0; idx--)
        {
            ItemStack stack = this.rack.inventory.getStackInSlot(idx);

            int sW = 16;
            int sH = 16;
            int sP = 2;
            int sX = this.guiLeft + 5;
            int sY = this.guiTop + 26 + (sH * idx) + (sP * idx);

            drawRect(sX, sY, sX + sW, sY + sH, 0x1AFFFFFF);

            if (stack != null)
            {
                Draw.drawString(stack.getDisplayName(), sX + sW + (sP * 2), sY + (sH / 4), 0xFFFFFFFF);
            }
        }
    }
}
