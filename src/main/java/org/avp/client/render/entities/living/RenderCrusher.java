package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelCrusherQuad;
import org.avp.common.entities.living.species.xenomorphs.EntityCrusher;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCrusher extends RenderXenomorph<EntityCrusher, ModelCrusherQuad>
{
    public RenderCrusher(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().CRUSHER_QUAD, 1.6F);
    }
}
