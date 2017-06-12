package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderSpaceJockey extends RenderEngineer
{
    public RenderSpaceJockey(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().SPACE_JOCKEY);
    }
}
