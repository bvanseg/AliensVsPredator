package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelGooMutant;
import org.alien.common.entity.living.vardic.EntityGooMutant;

public class RenderGooMutant extends RenderLivingWrapper<EntityGooMutant, ModelGooMutant>
{
    public RenderGooMutant(RenderManager m)
    {
        super(m, AlienResources.instance.models().GOO_MUTANT);
    }
}
