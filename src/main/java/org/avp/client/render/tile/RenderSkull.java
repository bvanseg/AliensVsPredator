package org.avp.client.render.tile;

import org.avp.tile.TileEntitySkull;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderSkull extends TileEntitySpecialRenderer<TileEntitySkull>
{
    @Override
    public void renderTileEntityAt(TileEntitySkull skull, double posX, double posY, double posZ, float renderPartialTicks, int destroyStage)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.64F;
            GlStateManager.disableCull();
            OpenGL.translate(posX + 0.5F, posY, posZ + 0.5F);
            OpenGL.scale(scale, -scale, scale);
            OpenGL.enable(GL11.GL_ALPHA_TEST);
            OpenGL.disableCullFace();
            OpenGL.rotate(skull);

            if (skull.getSkullBlock().getSkullTexture() != null)
            {
                skull.getSkullBlock().getSkullTexture().bind();
            }
            
            skull.getSkullBlock().preRenderTransforms();

            for (ModelRenderer renderer : skull.getSkullBlock().getSkullModelRenderers())
            {
                renderer.render(Model.DEFAULT_SCALE);
            }
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }
}
