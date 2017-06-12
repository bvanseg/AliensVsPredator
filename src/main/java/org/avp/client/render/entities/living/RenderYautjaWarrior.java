package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelYautja;
import org.avp.entities.living.EntityYautja;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderYautjaWarrior extends RenderYautja<EntityYautja, ModelYautja>
{
    public RenderYautjaWarrior(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().YAUTJA);
    }

}
