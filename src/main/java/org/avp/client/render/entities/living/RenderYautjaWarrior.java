package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelYautja;
import org.avp.entities.living.species.yautja.EntityYautjaWarrior;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderYautjaWarrior extends RenderYautja<EntityYautjaWarrior, ModelYautja>
{
    public RenderYautjaWarrior(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().YAUTJA_WARRIOR);
    }

}
