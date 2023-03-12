package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelPraetorian;
import org.avp.common.entities.living.species.xenomorphs.EntityPraetorian;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderPraetorian extends RenderXenomorph<EntityPraetorian, ModelPraetorian>
{
    public RenderPraetorian(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().PRAETORIAN, 1.4F);
    }
}
