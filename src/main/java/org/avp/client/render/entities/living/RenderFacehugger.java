package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelFacehugger;
import org.alien.common.entity.living.xenomorphs.parasites.EntityFacehugger;

public class RenderFacehugger extends RenderFacehuggers<EntityFacehugger, ModelFacehugger>
{
    public RenderFacehugger(RenderManager m)
    {
        super(m, AVP.resources().models().FACEHUGGER);
    }
}
