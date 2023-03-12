package org.avp.client.render.entities.living;

import org.avp.AVP;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSpaceJockey extends RenderEngineer
{
    public RenderSpaceJockey(RenderManager m)
    {
        super(m, AVP.resources().models().SPACE_JOCKEY);
    }
}
