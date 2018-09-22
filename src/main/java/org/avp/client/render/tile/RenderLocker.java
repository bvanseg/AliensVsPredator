package org.avp.client.render.tile;

import org.avp.AliensVsPredator;
import org.avp.client.model.tile.ModelLocker;
import org.avp.tile.TileEntityLocker;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.Renderers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RenderLocker extends TileEntitySpecialRenderer<TileEntityLocker>
{
    @Override
    public void render(TileEntityLocker tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.95F;
            GlStateManager.disableCull();
            OpenGL.translate(x + 0.5F, y + 1.41F, z + 0.5F);
            OpenGL.scale(scale, -scale, scale);
            OpenGL.enable(GL11.GL_ALPHA_TEST);
            OpenGL.disableCullFace();
            OpenGL.rotate(tile);
            ((ModelLocker) AliensVsPredator.resources().models().LOCKER.getModel()).door.rotateAngleY = !tile.isOpen() ? 0 : -1.5F;
            AliensVsPredator.resources().models().LOCKER.draw(tile);

            if (tile != null)
            {
                OpenGL.pushMatrix();
                {
                    float itemScale = 0.009F;
                    OpenGL.scale(itemScale, itemScale, itemScale);
                    OpenGL.translate(-55F, -125F, 24F);
                    OpenGL.enableLight();
                    OpenGL.blendClear();

                    int rows = 8;
                    int stackIndex = 0;

                    for (int rowX = 0; rowX < tile.inventory.getSizeInventory() / rows; rowX++)
                    {
                        for (int rowY = 0; rowY < rows; rowY++)
                        {
                            ItemStack stack = tile.inventory.getStackInSlot(stackIndex++);
                            OpenGL.pushMatrix();
                            OpenGL.translate((rowX * 13), (rowY * 28), 0F);
                            OpenGL.disableCullFace();

                            if (stack != null && stack.getItem() != Items.AIR)
                            {
                                ItemRenderer<?> renderer = Renderers.getItemRenderer(stack.getItem());

                                if (renderer != null)
                                {
                                    OpenGL.pushMatrix();
                                    {
                                        float s = 15F;
                                        OpenGL.translate(8F, 75F, -45F);
                                        OpenGL.scale(s, s, s);
                                        OpenGL.enableBlend();
                                        OpenGL.scale(-1F, -1F, -1F);
                                        renderer.renderInInventory(stack, Game.minecraft().player, TransformType.GUI);
                                        OpenGL.enableLight();
                                    }
                                    OpenGL.popMatrix();
                                }
                                else
                                {
                                    OpenGL.pushMatrix();
                                    {
                                        OpenGL.translate(0, 0, -100);
                                        OpenGL.rotate(-45, 1F, 0F, 0F);
                                        Draw.drawItem(stack, 0, 0, 32, 32);
                                    }
                                    OpenGL.popMatrix();
                                }
                            }
                            OpenGL.enableCullFace();
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
