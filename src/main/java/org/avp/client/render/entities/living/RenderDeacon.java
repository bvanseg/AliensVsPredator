package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDeacon;
import org.avp.entities.living.EntityDeacon;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDeacon extends RenderXenomorph<EntityDeacon, ModelDeacon>
{
    public RenderDeacon(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().DEACON, 0.75F);
    }
}
