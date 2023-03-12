package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelFacehugger;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityFacehugger;

public class RenderFacehugger extends RenderFacehuggers<EntityFacehugger, ModelFacehugger>
{
    public RenderFacehugger(RenderManager m)
    {
        super(m, AVP.resources().models().FACEHUGGER);
    }
}
