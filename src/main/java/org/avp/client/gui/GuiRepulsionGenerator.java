package org.avp.client.gui;

import com.asx.mdx.client.render.Draw;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import org.avp.client.Resources;
import org.avp.common.tile.TileEntityRepulsionGenerator;

public class GuiRepulsionGenerator extends GuiContainer
{
    private final TileEntityRepulsionGenerator generator;

    public GuiRepulsionGenerator(EntityPlayer player, TileEntityRepulsionGenerator generator)
    {
        super(generator.getNewContainer(player));
        this.generator = generator;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
    	this.drawDefaultBackground();
        Draw.drawResource(Resources.instance.GUI_REPULSION_GENERATOR, this.guiLeft, this.guiTop, 256, 256, 255F, 255F, 255F, 255F, 1F, 1F);
        Draw.drawString(Math.round(this.generator.getVoltage()) + "V", this.guiLeft + 50, this.guiTop + this.ySize - 40, 0xFFCC44, false);
        Draw.drawString(Math.round(this.generator.getRotationSpeed() * 1000) + " RPM", this.guiLeft + 125, this.guiTop + this.ySize - 40, 0xFFCC44, false);
    }
}
