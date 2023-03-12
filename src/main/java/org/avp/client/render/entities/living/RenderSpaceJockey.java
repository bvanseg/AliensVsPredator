package org.avp.client.render.entities.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;

public class RenderSpaceJockey extends RenderEngineer
{
    public RenderSpaceJockey(RenderManager m)
    {
        super(m, AVP.resources().models().SPACE_JOCKEY);
    }
}
