package org.predator.client.render.item;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.avp.AVP;
import org.avp.client.model.items.ModelWristBlade;
import org.predator.common.item.ItemWristbracer;

public class RenderItemWristbracer extends ItemRenderer<ModelWristBlade>
{
    public RenderItemWristbracer()
    {
        super(AVP.resources().models().WRISTBLADES);
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        EntityPlayer playerToRender = (EntityPlayer) entity;

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0.4F, -0.1F, 0.2F);
            OpenGL.rotate(186.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(-120.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(-55.0F, 0.0F, 0.0F, 1.0F);

            GlStateManager.disableCull();
            OpenGL.scale(1.6F, 1.6F, 1.6F);
            this.getModel().draw();

            if (playerToRender != null && ItemWristbracer.equippedHasBlades(playerToRender))
            {
                this.getModel().getModel().renderBlades();
            }
            GlStateManager.enableCull();
        }
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        EntityPlayer playerToRender = (EntityPlayer) entity;

        OpenGL.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.translate(0.35F, 0.1F, -0.1F);
        OpenGL.scale(-1.5F, -1.5F, 1.5F);
        this.getModel().draw();

        if (playerToRender != null && ItemWristbracer.equippedHasBlades(playerToRender))
        {
            this.getModel().getModel().renderBlades();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 2F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(-0.25F, -0.15F, 0F);
        OpenGL.rotate(220F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.disableCullFace();
        this.getModel().draw();
        Model.draw(this.getModel().getModel().b6);
        Model.draw(this.getModel().getModel().bladeLeft);
        OpenGL.enableCullFace();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(-180F, 0F, 0F, 1F);
        OpenGL.translate(-0.3F, 0F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
        Model.draw(this.getModel().getModel().b6);
        Model.draw(this.getModel().getModel().bladeLeft);
        OpenGL.enableCullFace();
    }
}
