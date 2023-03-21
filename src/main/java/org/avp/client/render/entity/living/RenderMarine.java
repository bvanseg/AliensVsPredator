package org.avp.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.client.Resources;
import org.avp.client.model.entity.living.ModelMarine;
import org.avp.client.render.entity.layer.LayerHeldGun;
import org.avp.client.render.entity.layer.LayerMarineEyes;
import org.avp.client.render.entity.layer.LayerMarineSkin;
import org.avp.common.entity.living.EntityMarine;

/**
 * @author Ri5ux
 */
public class RenderMarine extends RenderLivingWrapper<EntityMarine, ModelMarine>
{
    public RenderMarine(RenderManager m)
    {
        super(m, Resources.instance.models().MARINE);
        this.addLayer(new LayerMarineSkin(this));
        this.addLayer(new LayerMarineEyes(this));
        this.addLayer(new LayerHeldGun(this));
    }
}
