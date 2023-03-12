package org.avp.client.render.entities.living;

import org.avp.AVP;
import org.avp.client.model.entities.living.ModelDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityDrone;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDrone extends RenderXenomorph<EntityDrone, ModelDrone>
{
    public RenderDrone(RenderManager m)
    {
        super(m, AVP.resources().models().DRONE_ADVANCED, 0.9F);
    }
}
