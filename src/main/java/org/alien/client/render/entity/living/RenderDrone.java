package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelDrone;
import org.alien.common.entity.living.xenomorph.EntityDrone;
import org.avp.AVP;

public class RenderDrone extends RenderXenomorph<EntityDrone, ModelDrone>
{
    public RenderDrone(RenderManager m)
    {
        super(m, AVP.resources().models().DRONE_ADVANCED, 0.9F);
    }
}
