package org.avp.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.common.block.BlockSkull;
import org.avp.common.tile.TileEntitySkull;
import org.avp.common.tile.TileEntitySkull.EnumOrientation;
import org.lwjgl.opengl.GL11;

public class RenderSkull extends TileEntitySpecialRenderer<TileEntitySkull>
{
    @Override
    public void render(TileEntitySkull skull, double posX, double posY, double posZ, float renderPartialTicks, int destroyStage, float alpha)
    {
        if (skull != null && skull.getBlockType() instanceof BlockSkull)
        {
            BlockSkull block = (BlockSkull) skull.getBlockType();

            OpenGL.pushMatrix();
            float scale = 0.64F;

            OpenGL.translate(posX + 0.5F, posY, posZ + 0.5F);
            OpenGL.scale(scale, -scale, scale);
            OpenGL.enable(GL11.GL_ALPHA_TEST);
            OpenGL.disableCullFace();
            OpenGL.rotate(skull);

            if (skull.getSkullBlock() != null)
            {
                if (skull.getSkullBlock().getSkullTexture() != null)
                {
                    skull.getSkullBlock().getSkullTexture().bind();
                }

                skull.getSkullBlock().preRenderTransforms();

                if (block.canChangeOrientation())
                {
                    if (skull.getOrientation() == EnumOrientation.FLAT)
                    {
                        OpenGL.translate(-0.4, 0.71F, 0);
                        OpenGL.rotate(-53.5F, 0, 0, 1);
                    }

                    if (skull.getOrientation() == EnumOrientation.WALL)
                    {
                        OpenGL.translate(-0.25, -0.1, 0);
                        OpenGL.rotate(37.5F, 0, 0, 1);
                    }
                }

                for (ModelRenderer m : skull.getSkullBlock().getSkullModelRenderers())
                {
                    m.render(Model.DEFAULT_SCALE);
                }
            }
            OpenGL.enableCullFace();
            OpenGL.popMatrix();
        }
    }
}
