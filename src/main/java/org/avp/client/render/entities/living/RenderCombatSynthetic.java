package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.entities.living.EntityCombatSynthetic;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.model.Model;
import com.arisux.mdx.lib.client.render.model.SpecialModelBiped;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderCombatSynthetic extends RenderLivingWrapper<EntityCombatSynthetic, SpecialModelBiped>
{
    public RenderCombatSynthetic(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().COMBAT_SYNTHETIC);
    }

    @Override
    protected void preRenderCallback(EntityCombatSynthetic base, float partialTicks)
    {
        super.preRenderCallback(base, partialTicks);
    }

    //TODO: FIX
    protected void renderEquippedItems(EntityCombatSynthetic entityLiving, float partialTicks)
    {
        //super.renderEquippedItems(entityLiving, partialTicks);

        float glScale = 1.2F;

        if (this.mainModel != null && this.mainModel instanceof SpecialModelBiped)
        {
            SpecialModelBiped model = (SpecialModelBiped) this.mainModel;

            OpenGL.pushMatrix();
            {
                model.aimedBow = true;
                model.bipedRightArm.postRender(Model.DEFAULT_SCALE);
                OpenGL.translate(-0.35F, 0.8F, -0.85F);
                OpenGL.rotate(270.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(0.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                GlStateManager.disableCull();
                OpenGL.scale(glScale, glScale, glScale);
                AliensVsPredator.resources().models().M41A.draw();
            }
            OpenGL.popMatrix();
        }
    }
}
