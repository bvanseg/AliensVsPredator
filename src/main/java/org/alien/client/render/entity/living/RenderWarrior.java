package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelWarrior;
import org.alien.common.entity.living.xenomorph.EntityWarrior;

public class RenderWarrior extends RenderXenomorph<EntityWarrior, ModelWarrior>
{
    public RenderWarrior(RenderManager m)
    {
        super(m, AlienResources.instance.models().WARRIOR, 1F);
    }
}
