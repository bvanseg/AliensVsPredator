package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDeaconShark;
import org.avp.entities.living.EntityDeaconShark;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDeaconShark extends RenderLivingWrapper<EntityDeaconShark, ModelDeaconShark>
{
    public RenderDeaconShark(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().DEACON_SHARK);
    }

    @Override
    protected void preRenderCallback(EntityDeaconShark entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        float scale = 1.7F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0, 1, 0);
    }
}
