package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelPraetorian;
import org.alien.common.entity.living.xenomorph.EntityPraetorian;
import org.avp.AVP;

public class RenderPraetorian extends RenderXenomorph<EntityPraetorian, ModelPraetorian>
{
    public RenderPraetorian(RenderManager m)
    {
        super(m, AVP.resources().models().PRAETORIAN, 1.4F);
    }
}
