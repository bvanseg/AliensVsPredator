package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelPraetorian;
import org.avp.common.entities.living.species.xenomorphs.EntityPraetorian;

public class RenderPraetorian extends RenderXenomorph<EntityPraetorian, ModelPraetorian>
{
    public RenderPraetorian(RenderManager m)
    {
        super(m, AVP.resources().models().PRAETORIAN, 1.4F);
    }
}
