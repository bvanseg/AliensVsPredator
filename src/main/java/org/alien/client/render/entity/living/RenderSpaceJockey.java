package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.Resources;

public class RenderSpaceJockey extends RenderEngineer
{
    public RenderSpaceJockey(RenderManager m)
    {
        super(m, Resources.instance.models().SPACE_JOCKEY);
    }
}
