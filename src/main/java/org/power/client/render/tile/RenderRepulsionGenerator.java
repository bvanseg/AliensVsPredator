package org.power.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.client.Resources;
import org.power.common.tile.TileEntityRepulsionGenerator;

import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;

public class RenderRepulsionGenerator extends TileEntitySpecialRenderer<TileEntityRepulsionGenerator>
{
    @Override
    public void render(TileEntityRepulsionGenerator tile, double posX, double posY, double posZ, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        OpenGL.enableCullFace();
        OpenGL.enableBlend();
        OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        OpenGL.translate(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        Resources.instance.models().REPULSION_GENERATOR.draw(tile);
        OpenGL.disableCullFace();
        OpenGL.blendClear();
        OpenGL.disableBlend();
        OpenGL.popMatrix();
    }
}
