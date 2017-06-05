package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelPredatorHound;
import org.avp.entities.living.EntityPredatorHound;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;

public class RenderPredatorHound extends RenderLivingWrapper<EntityPredatorHound, ModelPredatorHound>
{
    public RenderPredatorHound()
    {
        super(AliensVsPredator.resources().models().PREDATOR_HOUND);
    }
    
    public RenderPredatorHound(TexturedModel<ModelPredatorHound> model)
    {
        super(model);
    }

    @Override
    public void doRender(EntityPredatorHound entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPredatorHound entityliving, float renderPartialTicks)
    {
        float scale = 1.5F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
