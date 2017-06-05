package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.entity.EntityLivingBase;

public class RenderYautja extends RenderLivingWrapper
{
    public RenderYautja(TexturedModel<? extends Model> model)
    {
        super(model);
    }
    
    public RenderYautja()
    {
        super(AliensVsPredator.resources().models().YAUTJA);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entityliving, float renderPartialTicks)
    {
        OpenGL.scale(0.85F, 0.85F, 0.85F);
    }
}
