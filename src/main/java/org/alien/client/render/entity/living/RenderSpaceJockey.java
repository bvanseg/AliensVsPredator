package org.alien.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;

public class RenderSpaceJockey extends RenderEngineer
{
    public RenderSpaceJockey(RenderManager m)
    {
        super(m, AlienResources.instance.models().SPACE_JOCKEY);
    }
}
