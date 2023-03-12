package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelRunnerWarrior;
import org.alien.common.entity.living.xenomorph.EntityRunnerWarrior;
import org.avp.AVP;

public class RenderRunnerWarrior extends RenderXenomorph<EntityRunnerWarrior, ModelRunnerWarrior>
{
    public RenderRunnerWarrior(RenderManager m)
    {
        super(m, AVP.resources().models().RUNNER_WARRIOR, 1F);
    }
}
