package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelYautja;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

public class RenderYautjaWarrior extends RenderYautja<EntityYautjaWarrior, ModelYautja>
{
    public RenderYautjaWarrior(RenderManager m)
    {
        super(m, AVP.resources().models().YAUTJA_WARRIOR);
    }

}
