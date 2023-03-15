package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.avp.AVP;
import org.avp.client.Resources;

public class RenderFacehugger extends RenderFacehuggers<EntityFacehugger, ModelFacehugger>
{
    public RenderFacehugger(RenderManager m)
    {
        super(m, Resources.instance.models().FACEHUGGER);
    }
}
