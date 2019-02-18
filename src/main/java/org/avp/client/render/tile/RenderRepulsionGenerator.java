package org.avp.client.render.tile;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityRepulsionGenerator;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderRepulsionGenerator extends TileEntitySpecialRenderer<TileEntityRepulsionGenerator>
{
    @Override
    public void render(TileEntityRepulsionGenerator tile, double posX, double posY, double posZ, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        OpenGL.enableCullFace();
        OpenGL.enable(GL_BLEND);
        OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        OpenGL.translate(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        AliensVsPredator.resources().models().REPULSION_GENERATOR.draw(tile);
        OpenGL.popMatrix();
    }
}
