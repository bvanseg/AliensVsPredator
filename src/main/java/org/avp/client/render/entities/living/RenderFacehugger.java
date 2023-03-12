package org.avp.client.render.entities.living;

import org.avp.AVP;
import org.avp.client.model.entities.living.ModelFacehugger;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityFacehugger;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderFacehugger extends RenderFacehuggers<EntityFacehugger, ModelFacehugger>
{
    public RenderFacehugger(RenderManager m)
    {
        super(m, AVP.resources().models().FACEHUGGER);
    }
}
