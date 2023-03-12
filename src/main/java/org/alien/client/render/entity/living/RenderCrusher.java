package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelCrusherQuad;
import org.alien.common.entity.living.xenomorphs.EntityCrusher;
import org.avp.AVP;

public class RenderCrusher extends RenderXenomorph<EntityCrusher, ModelCrusherQuad>
{
    public RenderCrusher(RenderManager m)
    {
        super(m, AVP.resources().models().CRUSHER_QUAD, 1.6F);
    }
}
