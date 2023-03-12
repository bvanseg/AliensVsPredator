package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelDrone;
import org.alien.common.entity.living.xenomorphs.EntityDrone;

public class RenderDrone extends RenderXenomorph<EntityDrone, ModelDrone>
{
    public RenderDrone(RenderManager m)
    {
        super(m, AVP.resources().models().DRONE_ADVANCED, 0.9F);
    }
}
