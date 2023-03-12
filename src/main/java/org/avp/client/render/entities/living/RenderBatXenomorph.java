package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelBatXenomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityBatXeno;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderBatXenomorph extends RenderXenomorph<EntityBatXeno, ModelBatXenomorph>
{
    public RenderBatXenomorph(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().BAT_XENO, 0.75F);
    }
}
