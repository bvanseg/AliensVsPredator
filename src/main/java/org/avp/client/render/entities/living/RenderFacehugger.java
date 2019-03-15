package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelFacehugger;
import org.avp.entities.living.species.xenomorphs.parasites.EntityFacehugger;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderFacehugger extends RenderFacehuggers<EntityFacehugger, ModelFacehugger>
{
    public RenderFacehugger(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().FACEHUGGER);
    }
}
