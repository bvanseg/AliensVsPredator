package org.avp.client.gui;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityRepulsionGenerator;

import com.arisux.mdx.lib.client.render.Draw;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class GuiRepulsionGenerator extends GuiContainer
{
    private TileEntityRepulsionGenerator generator;

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
        Draw.drawResource(AliensVsPredator.resources().GUI_REPULSION_GENERATOR, this.guiLeft, this.guiTop, 256, 256, 255F, 255F, 255F, 255F, 1F, 1F);
        Draw.drawString(this.generator.getProposedSpeed() + "", this.guiLeft, this.guiTop + this.ySize + 10, 0xFFFF0000);
        Draw.drawString(this.generator.getRotationSpeed() + "", this.guiLeft, this.guiTop + this.ySize + 20, 0xFFFF0000);
    }
}
