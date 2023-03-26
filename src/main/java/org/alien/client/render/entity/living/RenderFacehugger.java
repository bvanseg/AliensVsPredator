package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;

public class RenderFacehugger extends RenderFacehuggers<EntityFacehugger, ModelFacehugger>
{
    public RenderFacehugger(RenderManager m)
    {
        super(m, AlienResources.instance.models().FACEHUGGER);
    }
}
