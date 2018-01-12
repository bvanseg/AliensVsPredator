package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDeaconAdult;
import org.avp.entities.living.EntityDeaconAdult;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDeaconAdult extends RenderXenomorph<EntityDeaconAdult, ModelDeaconAdult>
{
    public RenderDeaconAdult(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().DEACON_ADULT, 1F);
    }
}
