package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelCrusherQuad;
import org.alien.common.entity.living.xenomorphs.EntityCrusher;

public class RenderCrusher extends RenderXenomorph<EntityCrusher, ModelCrusherQuad>
{
    public RenderCrusher(RenderManager m)
    {
        super(m, AVP.resources().models().CRUSHER_QUAD, 1.6F);
    }
}
