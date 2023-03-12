package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelRunnerWarrior;
import org.alien.common.entity.living.xenomorphs.EntityRunnerWarrior;

public class RenderRunnerWarrior extends RenderXenomorph<EntityRunnerWarrior, ModelRunnerWarrior>
{
    public RenderRunnerWarrior(RenderManager m)
    {
        super(m, AVP.resources().models().RUNNER_WARRIOR, 1F);
    }
}
