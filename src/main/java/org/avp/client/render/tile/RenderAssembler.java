package org.avp.client.render.tile;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import org.avp.common.tile.TileEntityAssembler;
import org.lib.client.AnimationUtil;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class RenderAssembler extends TileEntitySpecialRenderer<TileEntityAssembler>
{
    @Override
    public void render(TileEntityAssembler tile, double posX, double posY, double posZ, float renderPartialTicks, int destroy, float alpha)
    {
    	tile.rotateProgress = MathHelper.clamp(tile.rotateProgress + 0.01F, 0F, 1F);
    	
    	// Once a full rotation is done, we can safely reset back to 0.
    	if (tile.rotateProgress == 1F) {
    		tile.rotateProgress = 0F;
    	}
    	
        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL_CULL_FACE);
            OpenGL.enable(GL_BLEND);
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            OpenGL.translate(posX + 0.5F, posY + 0.95F, posZ + 0.5F);
            OpenGL.rotate(360 * AnimationUtil.lerp(0F, 1F, tile.rotateProgress), 0, 1, 0);

            OpenGL.pushMatrix();
            {
                OpenGL.scale(0.025F, -0.025F, 0.025F);
                OpenGL.disableLight();
                OpenGL.color4i(0xFFFF0000);
                OpenGL.enable(GL_BLEND);
                OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_SRC_COLOR);
                renderItem(new ItemStack(((TileEntityAssembler) tile).getRandomItem(), 1), -8, -32);
                OpenGL.disable(GL_BLEND);
                OpenGL.enableLight();
            }
            OpenGL.popMatrix();

            OpenGL.rotate(-15, 1, 0, 0);

            OpenGL.pushMatrix();
            {
                OpenGL.scale(0.05F, 0.05F, 0.05F);
                OpenGL.enable(GL11.GL_BLEND);

                for (int x = 32; x > 0; x--)
                {
                    OpenGL.rotate(x * 1, 0, 1, 0);
                    OpenGL.rotate(10, 0, 0, 1);
                    Draw.drawRect(-1, 0, 2, 1 + x / 2, 0x22FF0000);
                }
            }
            OpenGL.popMatrix();

            OpenGL.disable(GL_BLEND);
        }
        OpenGL.popMatrix();
    }

    public static void renderItem(ItemStack stack, int x, int y)
    {
        OpenGL.pushMatrix();
        OpenGL.translate(0F, 0F, -100F);

        GlStateManager.pushMatrix();
        ClientGame.instance.minecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        ClientGame.instance.minecraft().getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        GlStateManager.translate((float) x, (float) y, 100F);
        GlStateManager.translate(8.0F, 8.0F, 0.0F);
        GlStateManager.scale(1.0F, -1.0F, 1.0F);
        GlStateManager.scale(16.0F, 16.0F, 16.0F);

        IBakedModel ibakedmodel = ClientGame.instance.minecraft().getRenderItem().getItemModelMesher().getItemModel(stack);
        ibakedmodel = ibakedmodel.getOverrides().handleItemState(ibakedmodel, stack, ClientGame.instance.minecraft().world, ClientGame.instance.minecraft().player);
        ibakedmodel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(ibakedmodel, ItemCameraTransforms.TransformType.GUI, false);

        ClientGame.instance.minecraft().getRenderItem().renderItem(stack, ibakedmodel);
        GlStateManager.popMatrix();
        ClientGame.instance.minecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        ClientGame.instance.minecraft().getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();

        OpenGL.popMatrix();
    }
}
