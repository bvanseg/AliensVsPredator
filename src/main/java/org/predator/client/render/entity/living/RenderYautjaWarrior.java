package org.predator.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.predator.client.model.entity.living.ModelYautja;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

public class RenderYautjaWarrior extends RenderYautja<EntityYautjaWarrior, ModelYautja>
{
    public RenderYautjaWarrior(RenderManager m)
    {
        super(m, AVP.resources().models().YAUTJA_WARRIOR);
    }

}
