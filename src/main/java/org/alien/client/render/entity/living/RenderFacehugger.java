package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelFacehugger;
import org.alien.common.entity.living.xenomorphs.parasites.EntityFacehugger;

public class RenderFacehugger extends RenderFacehuggers<EntityFacehugger, ModelFacehugger>
{
    public RenderFacehugger(RenderManager m)
    {
        super(m, AVP.resources().models().FACEHUGGER);
    }
}
