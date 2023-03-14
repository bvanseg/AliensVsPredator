package org.predator.client.model.entity;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

public class ModelSpear extends Model<Object>
{
    private final float scale = 0.08F;

    @Override
    public void render(Object obj)
    {
        float s = 3F;
        OpenGL.scale(s, s, s);
//        OpenGL.disableCullFace();
        OpenGL.translate(-0.5F, 0F, 0F);

        for (int x = 0; x < 4; ++x)
        {
            OpenGL.rotate(90.0F, 1.0F, 0.0F, 0.0F);
//            Draw.drawQuad(-20, 3, 40, -6, 0, 0F, 1F, 0, 0.155F);
            OpenGL.pushMatrix();
            OpenGL.translate(0F, -0.08F, 0F);
            GL11.glNormal3f(0.0F, 0.0F, scale);
            Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 1, 1, 1, 1);
            OpenGL.popMatrix();
//            Draw.drawQuad(0, 0, 100, 100, 0, 0, 10, 0, 10);
        }
    }
}
