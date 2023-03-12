package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelDeaconShark;
import org.alien.common.entity.living.vardic.EntityDeaconShark;

public class RenderDeaconShark extends RenderLivingWrapper<EntityDeaconShark, ModelDeaconShark>
{
    public RenderDeaconShark(RenderManager m)
    {
        super(m, AVP.resources().models().DEACON_SHARK);
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
