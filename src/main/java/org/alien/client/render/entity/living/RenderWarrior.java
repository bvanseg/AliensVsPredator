package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelWarrior;
import org.alien.common.entity.living.xenomorphs.EntityWarrior;

public class RenderWarrior extends RenderXenomorph<EntityWarrior, ModelWarrior>
{
    public RenderWarrior(RenderManager m)
    {
        super(m, AVP.resources().models().WARRIOR, 1F);
    }
}
