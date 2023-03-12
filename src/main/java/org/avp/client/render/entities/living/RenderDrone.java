package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityDrone;

public class RenderDrone extends RenderXenomorph<EntityDrone, ModelDrone>
{
    public RenderDrone(RenderManager m)
    {
        super(m, AVP.resources().models().DRONE_ADVANCED, 0.9F);
    }
}
