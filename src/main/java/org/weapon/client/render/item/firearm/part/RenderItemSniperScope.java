package org.weapon.client.render.item.firearm.part;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.render.item.ItemRendererGroup;
import org.weapon.client.model.item.ModelSniper;

public class RenderItemSniperScope extends ItemRendererGroup<ModelSniper>
{
    public RenderItemSniperScope(MapModelTexture<ModelSniper> model, ModelRenderer... modelRenderers)
    {
        super(model, modelRenderers);
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float glScale = 38F * Model.DEFAULT_SCALE;
            OpenGL.rotate(45, 1F, 0F, 0F);
            OpenGL.scale(glScale, -glScale, glScale);
            OpenGL.rotate(45F, -1F, 1F, 0F);
            OpenGL.translate(0F, 0F, 0.1F);
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
    
    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.rotate((ClientGame.instance.minecraft().world.getTotalWorldTime() + ClientGame.instance.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            GlStateManager.disableCull();
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
}
