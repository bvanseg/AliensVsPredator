package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelRunnerDrone;
import org.alien.common.entity.living.xenomorphs.EntityRunnerDrone;
import org.avp.AVP;

public class RenderRunnerDrone extends RenderXenomorph<EntityRunnerDrone, ModelRunnerDrone>
{
    public RenderRunnerDrone(RenderManager m)
    {
        super(m, AVP.resources().models().RUNNER_DRONE, 0.8F);
    }
}
