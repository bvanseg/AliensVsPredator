package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelBatXenomorph;
import org.alien.common.entity.living.xenomorphs.EntityBatXeno;

public class RenderBatXenomorph extends RenderXenomorph<EntityBatXeno, ModelBatXenomorph>
{
    public RenderBatXenomorph(RenderManager m)
    {
        super(m, AVP.resources().models().BAT_XENO, 0.75F);
    }
}
