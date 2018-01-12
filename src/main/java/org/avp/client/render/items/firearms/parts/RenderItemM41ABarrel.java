package org.avp.client.render.items.firearms.parts;

import org.avp.client.model.items.ModelM41A;
import org.avp.client.render.items.ItemRendererGroup;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.model.Model;
import com.arisux.mdx.lib.client.render.model.MapModelTexture;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemM41ABarrel extends ItemRendererGroup<ModelM41A>
{
    public RenderItemM41ABarrel(MapModelTexture<ModelM41A> model, ModelRenderer... modelRenderers)
    {
        super(model, modelRenderers);
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float glScale = 32F * Model.DEFAULT_SCALE;
            OpenGL.scale(glScale, -glScale, glScale);
            OpenGL.rotate(45F, -1F, 1F, 0F);
            OpenGL.translate(0.25F, -0.65F, -0.6F);
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
    
    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            GlStateManager.disableCull();
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
}
