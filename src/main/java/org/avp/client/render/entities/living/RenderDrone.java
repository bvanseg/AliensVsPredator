package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDrone;
import org.avp.entities.living.species.xenomorphs.EntityDrone;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDrone extends RenderXenomorph<EntityDrone, ModelDrone>
{
    public RenderDrone(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().DRONE_ADVANCED, 0.9F);
    }
}
