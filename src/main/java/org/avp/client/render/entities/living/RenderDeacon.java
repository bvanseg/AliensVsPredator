package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelProtomorph;
import org.avp.entities.living.EntityDeacon;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDeacon extends RenderXenomorph<EntityDeacon, ModelProtomorph>
{
    public RenderDeacon(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().PROTOMORPH, 1.4F);
    }
}
