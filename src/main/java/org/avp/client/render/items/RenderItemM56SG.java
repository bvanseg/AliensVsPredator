package org.avp.client.render.items;

import org.avp.AVP;
import org.avp.client.model.items.ModelM56SG;
import org.avp.common.entities.living.EntityMarine;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemM56SG extends ItemFirearmRenderer<ModelM56SG>
{
    public RenderItemM56SG()
    {
        super(AVP.resources().models().M56SG);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.1F, 0.5F, -0.5F);
        OpenGL.scale(1F, -1F, 1F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0.1F, -0.15F, 0.4F);
            OpenGL.rotate(15.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(10.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.disableCull();
            OpenGL.scale(2.0F, -2.0F, -2.0F);
            this.getModel().draw();
        }
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // Special offsets for the marine entity holding the smart gun.
    	if (entity instanceof EntityMarine) {
            OpenGL.translate(-0.135F, -0.8F, 0.4F);
            // TODO: Preferably don't use two rotations here.
            OpenGL.rotate(60.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(-10.0F, 0.0F, 0.1F, 0.0F);
            OpenGL.scale(-1.3F, -1.3F, -1.3F);
    	} else {
            OpenGL.translate(-0.035F, -0.8F, 0.3F);
            OpenGL.rotate(70.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.scale(-1.3F, -1.3F, -1.3F);
    	}
    	
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.3F, -0.2F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
