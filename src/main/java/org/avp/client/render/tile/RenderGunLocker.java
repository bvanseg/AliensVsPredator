package org.avp.client.render.tile;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityGunLocker;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.Renderers;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;

public class RenderGunLocker extends TileEntitySpecialRenderer<TileEntityGunLocker>
{
    @Override
    public void renderTileEntityAt(TileEntityGunLocker tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.95F;
            OpenGL.enable(GL11.GL_CULL_FACE);
            OpenGL.translate(x + 0.5F, y + 1.41F, z + 0.5F);
            OpenGL.scale(scale, -scale, scale);
            OpenGL.enable(GL11.GL_ALPHA_TEST);
            OpenGL.disableCullFace();
            OpenGL.rotate(tile);
            
            AliensVsPredator.resources().models().GUN_LOCKER.getModel().door.rotateAngleY = !tile.isOpen() ? 0 : -1.5F;
            AliensVsPredator.resources().models().GUN_LOCKER.draw(tile);

            if (tile != null)
            {
                OpenGL.pushMatrix();
                {
                    float itemScale = 0.06F;
                    OpenGL.scale(itemScale, itemScale, itemScale);
                    OpenGL.rotate(-90F, 0F, 0F, 1F);
                    OpenGL.translate(-27F, -7.5F, -4F);
                    OpenGL.rotate(-50F, 0F, 1F, 0F);
                    OpenGL.enableLight();
                    OpenGL.blendClear();

                    ItemStack stack = null;
                    int rows = 21;
                    int stackIndex = 0;

                    for (int rowX = 0; rowX < tile.inventory.getSizeInventory() / rows; rowX++)
                    {
                        for (int rowY = 0; rowY < rows; rowY++)
                        {
                            stack = tile.inventory.getStackInSlot(stackIndex++);

                            if (stack != null)
                            {
                                break;
                            }
                        }

                        if (stack != null)
                        {
                            break;
                        }
                    }

                    if (stack != null)
                    {
                        ItemRenderer<?> renderer = Renderers.getItemRenderer(stack.getItem());

                        if (renderer != null)
                        {
                            OpenGL.pushMatrix();
                            {
                                OpenGL.translate(8F, 0F, 0F);
                                renderer.renderInInventory(stack, Game.minecraft().player, TransformType.GUI);
                                OpenGL.enableLight();
                            }
                            OpenGL.popMatrix();
                        }
                    }
                }
                OpenGL.popMatrix();
            }
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }
}
