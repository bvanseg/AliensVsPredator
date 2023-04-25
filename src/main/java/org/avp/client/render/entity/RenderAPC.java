package org.avp.client.render.entity;

import com.asx.mdx.client.ClientGame;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.client.Resources;
import org.avp.common.entity.EntityAPC;

public class RenderAPC extends Render<EntityAPC> {
    public RenderAPC(RenderManager m) {
        super(m);
    }

    @Override
    public void doRender(EntityAPC entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y + 2.20F, (float) z);
        GlStateManager.rotate(-90, 0, 1, 0);
        GlStateManager.rotate(-((entity.rotationYaw - entity.prevRotationYaw) * ClientGame.instance.partialTicks() + entity.prevRotationYaw + 180), 0, 1, 0);
        GlStateManager.scale(-1.5F, -1.5F, 1.5F);

        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        Resources.instance.models().APC.bindTexture();
        Resources.instance.models().APC.getModel().render(entity);

        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAPC entityIn) {
        return null;
    }
}
