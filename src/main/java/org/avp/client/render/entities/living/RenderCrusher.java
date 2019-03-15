package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelCrusher;
import org.avp.entities.living.species.xenomorphs.EntityCrusher;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCrusher extends RenderXenomorph<EntityCrusher, ModelCrusher>
{
    public RenderCrusher(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().CRUSHER, 1F);
    }
}
