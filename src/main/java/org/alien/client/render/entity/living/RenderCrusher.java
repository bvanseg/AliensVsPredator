package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelCrusherQuad;
import org.alien.common.entity.living.xenomorph.EntityCrusher;
import org.avp.client.Resources;

public class RenderCrusher extends RenderXenomorph<EntityCrusher, ModelCrusherQuad>
{
    public RenderCrusher(RenderManager m)
    {
        super(m, Resources.instance.models().CRUSHER_QUAD, 1.6F);
    }
}
