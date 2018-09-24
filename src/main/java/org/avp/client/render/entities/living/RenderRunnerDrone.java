package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelRunnerDrone;
import org.avp.entities.living.EntityRunnerDrone;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRunnerDrone extends RenderXenomorph<EntityRunnerDrone, ModelRunnerDrone>
{
    public RenderRunnerDrone(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().RUNNER_DRONE, 0.8F);
    }
}
