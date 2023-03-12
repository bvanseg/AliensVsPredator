package org.avp.client.render.tile;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityGunLocker;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.Renderers;
import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class RenderGunLocker extends TileEntitySpecialRenderer<TileEntityGunLocker>
{
	// TODO: This should be in a util or helper class in the future.
	private float lerp(float pointA, float pointB, float percentage) {
        return (pointA * (1.0f - percentage)) + (pointB * percentage);
    }
	
    @Override
    public void render(TileEntityGunLocker tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
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
            
            float openSpeed = 0.06F;
            tile.openProgress = MathHelper.clamp(tile.openProgress + (!tile.isOpen() ? -openSpeed : openSpeed), 0.0F, 1.0F);
            float lerpProgress = !tile.isOpen() ? tile.openProgress : 1 - tile.openProgress;
            float openProgress = lerp(tile.isOpen() ? -1.5F : 0F, tile.isOpen() ? 0F : -1.5F, lerpProgress);
            
            AliensVsPredator.resources().models().GUN_LOCKER.getModel().door.rotateAngleY = openProgress;
            AliensVsPredator.resources().models().GUN_LOCKER.draw(tile);

            if (tile != null)
            {
                OpenGL.pushMatrix();
                {
                    float itemScale = 0.06F;
                    OpenGL.scale(itemScale, itemScale, itemScale);
                    OpenGL.rotate(-90F, 0F, 0F, 1F);
                    OpenGL.translate(-17F, 0F, 0F);
                    OpenGL.enableLight();
                    OpenGL.blendClear();

                    ItemStack stack = null;
                    int rows = 8;
                    int stackIndex = 0;
                    boolean alternate = false;

                    for (int rowX = 0; rowX < tile.inventory.getSizeInventory() / rows; rowX++)
                    {
                        alternate = !alternate;

                        for (int rowY = 0; rowY < rows; rowY++)
                        {
                            stack = tile.inventory.getStackInSlot(stackIndex++);
                            OpenGL.pushMatrix();
                            OpenGL.translate((rowX * 3), alternate ? 2F : -2F, 0F);
                            OpenGL.disableCullFace();

                            if (stack != null && stack.getItem() != Items.AIR && rowY == 0)
                            {
                                ItemRenderer<?> renderer = Renderers.getItemRenderer(stack.getItem());

                                if (renderer != null)
                                {
                                    OpenGL.pushMatrix();
                                    {
                                        float s = 10F;
                                        OpenGL.scale(s, s, s);
                                        OpenGL.enableBlend();
                                        OpenGL.scale(-1F, alternate ? -1F : 1F, -1F);
                                        OpenGL.rotate(-50F, 0F, 1F, 0F);
                                        renderer.renderInInventory(stack, Game.minecraft().player, TransformType.GUI);
                                        OpenGL.enableLight();
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
