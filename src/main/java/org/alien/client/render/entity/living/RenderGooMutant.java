package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelGooMutant;
import org.alien.common.entity.living.vardic.EntityGooMutant;
import org.avp.client.Resources;

public class RenderGooMutant extends RenderLivingWrapper<EntityGooMutant, ModelGooMutant>
{
    public RenderGooMutant(RenderManager m)
    {
        super(m, Resources.instance.models().GOO_MUTANT);
    }
}
