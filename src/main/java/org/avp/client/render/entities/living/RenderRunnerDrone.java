package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelRunnerDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerDrone;

public class RenderRunnerDrone extends RenderXenomorph<EntityRunnerDrone, ModelRunnerDrone>
{
    public RenderRunnerDrone(RenderManager m)
    {
        super(m, AVP.resources().models().RUNNER_DRONE, 0.8F);
    }
}
