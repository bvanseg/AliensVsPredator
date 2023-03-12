package org.avp.client.render.tile;

import org.avp.AliensVsPredator;
import org.avp.common.tile.TileEntityTransformer;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;


public class RenderTransformer extends TileEntitySpecialRenderer<TileEntityTransformer>
{
    @Override
    public void render(TileEntityTransformer tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        if (tile != null && tile instanceof TileEntityTransformer)
        {
            TileEntityTransformer transformer = (TileEntityTransformer) tile;

            OpenGL.pushMatrix();
            {
                GlStateManager.disableCull();
                OpenGL.translate(x, y, z);
                OpenGL.scale(1F, -1F, 1F);
                OpenGL.translate(0.5F, -1.5F, 0.5F);

                if (transformer.getRotationYAxis() == EnumFacing.EAST)
                {
                    OpenGL.rotate(90F, 0F, 1F, 0F);
                }

                if (transformer.getRotationYAxis() == EnumFacing.WEST)
                {
                    OpenGL.rotate(-90F, 0F, 1F, 0F);
                }

                if (transformer.getRotationYAxis() == EnumFacing.NORTH)
                {
                    OpenGL.rotate(180F, 0F, 1F, 0F);
                }

                if (transformer.getRotationYAxis() == EnumFacing.SOUTH)
                {
                    OpenGL.rotate(0F, 0F, 1F, 0F);
                }

                AliensVsPredator.resources().models().TRANSFORMER.draw(transformer);
            }
            OpenGL.popMatrix();

            OpenGL.pushMatrix();
            if (Game.minecraft().objectMouseOver != null && Game.minecraft().objectMouseOver.getBlockPos() != null)
            {
                TileEntity tileOver = Game.minecraft().player.world.getTileEntity(Game.minecraft().objectMouseOver.getBlockPos());
                OpenGL.translate(x+ 0.5F, y + 2F, z + 0.5F);

                if (tileOver != null && tileOver == tile)
                {
                    float scale = 0.02F;
                    OpenGL.scale(scale, scale, scale);
                    OpenGL.disableLight();

                    OpenGL.pushMatrix();
                    {
                        OpenGL.rotate(Game.minecraft().player.rotationYaw + 180, 0F, -1F, 0F);

                        OpenGL.pushMatrix();
                        {
                            OpenGL.rotate(Game.minecraft().player.rotationPitch + 180, -1F, 0F, 0F);
                            Draw.drawString(((float) tile.getVoltage()) + "V", -20, 30, tile.getVoltage() <= 0 ? 0xFFFF0000 : 0xFF00FF00);
                            scale = 0.5F;
                            OpenGL.scale(scale, scale, scale);
                            Draw.drawString((tile + "").replace(tile.getClass().getName(), ""), -20, 80, 0xFF00AAFF);
                        }
                        OpenGL.popMatrix();
                    }
                    OpenGL.popMatrix();

                    OpenGL.enableLight();
                }
            }
            OpenGL.popMatrix();
        }
    }
}
