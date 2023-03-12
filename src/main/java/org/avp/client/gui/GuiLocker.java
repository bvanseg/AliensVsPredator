package org.avp.client.gui;

import org.avp.AliensVsPredator;
import org.avp.common.tile.TileEntityLocker;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class GuiLocker extends GuiContainer
{
    public GuiLocker(EntityPlayer player, TileEntityLocker locker)
    {
        super(locker.getNewContainer(player));
        this.xSize = 176;
        this.ySize = 201;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
    	this.drawDefaultBackground();
        AliensVsPredator.resources().GUI_LOCKER.bind();
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
