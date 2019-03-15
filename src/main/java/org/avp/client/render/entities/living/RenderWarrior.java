package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelWarrior;
import org.avp.entities.living.species.xenomorphs.EntityWarrior;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderWarrior extends RenderXenomorph<EntityWarrior, ModelWarrior>
{
    public RenderWarrior(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().WARRIOR, 1F);
    }
}
