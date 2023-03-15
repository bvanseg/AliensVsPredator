package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelWarrior;
import org.alien.common.entity.living.xenomorph.EntityWarrior;
import org.avp.AVP;
import org.avp.client.Resources;

public class RenderWarrior extends RenderXenomorph<EntityWarrior, ModelWarrior>
{
    public RenderWarrior(RenderManager m)
    {
        super(m, Resources.instance.models().WARRIOR, 1F);
    }
}
