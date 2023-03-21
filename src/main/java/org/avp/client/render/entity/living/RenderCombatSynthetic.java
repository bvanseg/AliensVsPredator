package org.avp.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import com.asx.mdx.client.render.model.SpecialModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.client.Resources;
import org.avp.client.render.entity.layer.LayerHeldGun;
import org.avp.common.entity.living.EntityCombatSynthetic;

public class RenderCombatSynthetic extends RenderLivingWrapper<EntityCombatSynthetic, SpecialModelBiped>
{
    public RenderCombatSynthetic(RenderManager m)
    {
        super(m, Resources.instance.models().COMBAT_SYNTHETIC);
        this.addLayer(new LayerHeldGun(this));
    }
}
