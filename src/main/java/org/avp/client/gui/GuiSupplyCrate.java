package org.avp.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import org.avp.client.Resources;
import org.avp.common.tile.TileEntitySupplyCrate;

public class GuiSupplyCrate extends GuiContainer
{
    public GuiSupplyCrate(EntityPlayer player, TileEntitySupplyCrate tile)
    {
        super(tile.getNewContainer(player));
        this.xSize = 176;
        this.ySize = 201;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
    	this.drawDefaultBackground();
        Resources.instance.GUI_SUPPLYCRATE.bind();
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
