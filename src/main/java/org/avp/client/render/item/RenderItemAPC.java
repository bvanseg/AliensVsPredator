package org.avp.client.render.item;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import com.asx.mdx.client.render.model.Model;
import com.asx.mdx.client.render.model.wavefront.Part;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;

public class RenderItemAPC extends ItemRenderer<Model>
{
    public RenderItemAPC()
    {
        super(null);
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.25F;
            OpenGL.rotate(90, 0F, 1F, 0F);
            OpenGL.scale(scale, scale, scale);
            GlStateManager.disableCull();

            for (Part p : Resources.instance.models().M577_APC.parts.values())
            {
                p.draw();
            }
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.5F;
            OpenGL.scale(-scale, scale, scale);
            OpenGL.translate(-0.5F, 4.0F, 0F);
            OpenGL.rotate(110F, 0F, 0F, 1F);
            OpenGL.rotate(16F, 1F, 0F, 0F);
            GlStateManager.disableCull();

            for (Part p : Resources.instance.models().M577_APC.parts.values())
            {
                p.draw();
            }
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.3F;
            OpenGL.scale(scale, scale, scale);
            OpenGL.translate(0F, -1.3F, 0F);
            OpenGL.rotate(-90F, 0.0F, 1.0F, 0.0F);

            for (Part p : Resources.instance.models().M577_APC.parts.values())
            {
                p.draw();
            }
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.scale(0.2F, 0.2F, 0.2F);
            OpenGL.translate(0, -1F, 0);
            OpenGL.rotate((ClientGame.instance.minecraft().world.getTotalWorldTime() + ClientGame.instance.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);

            for (Part p : Resources.instance.models().M577_APC.parts.values())
            {
                p.draw();
            }
        }
        OpenGL.popMatrix();
    }
}
