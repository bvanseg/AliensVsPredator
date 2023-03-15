package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelRunnerDrone;
import org.alien.common.entity.living.xenomorph.EntityRunnerDrone;
import org.avp.AVP;
import org.avp.client.Resources;

public class RenderRunnerDrone extends RenderXenomorph<EntityRunnerDrone, ModelRunnerDrone>
{
    public RenderRunnerDrone(RenderManager m)
    {
        super(m, Resources.instance.models().RUNNER_DRONE, 0.8F);
    }
}
