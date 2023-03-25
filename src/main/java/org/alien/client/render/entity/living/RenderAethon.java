package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelAethon;
import org.alien.common.entity.living.EntityAethon;

public class RenderAethon extends RenderLivingWrapper<EntityAethon, ModelAethon>
{
    public RenderAethon(RenderManager m)
    {
        super(m, AlienResources.instance.models().AETHON);
    }

    @Override
    protected void preRenderCallback(EntityAethon entityliving, float renderPartialTicks)
    {
        float scale = 1.75F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
