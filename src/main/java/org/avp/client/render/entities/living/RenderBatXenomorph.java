package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelBatXenomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityBatXeno;

public class RenderBatXenomorph extends RenderXenomorph<EntityBatXeno, ModelBatXenomorph>
{
    public RenderBatXenomorph(RenderManager m)
    {
        super(m, AVP.resources().models().BAT_XENO, 0.75F);
    }
}
