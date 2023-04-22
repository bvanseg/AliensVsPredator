package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelDrone;
import org.alien.common.entity.living.xenomorph.EntityDrone;

public class RenderDrone extends RenderXenomorph<EntityDrone, ModelDrone>
{
    public RenderDrone(RenderManager m)
    {
        super(m, AlienResources.instance.models().DRONE_ADVANCED, 0.9F);
    }
}
