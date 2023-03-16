package org.avp.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.avp.client.model.tile.ModelCryostasisTube;
import org.lwjgl.opengl.GL11;

public class RenderItemCryostasisTube extends ItemRenderer<ModelCryostasisTube>
{
    public RenderItemCryostasisTube()
    {
        super(Resources.instance.models().CRYOSTASIS_TUBE);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.75F;

        OpenGL.translate(0F, -0.3F, -0.35F);
        OpenGL.disableCullFace();
        OpenGL.scale(glScale, -glScale, -glScale);
        this.getModel().draw();

        OpenGL.pushMatrix();
        {
            Resources.instance.models().CRYOSTASIS_TUBE_MASK.draw();
        }
        OpenGL.popMatrix();
        OpenGL.enableCullFace();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;

        OpenGL.translate(0.1F, 0.4F, -0.1F);
        OpenGL.disableCullFace();
        OpenGL.scale(glScale, -glScale, glScale);
        this.getModel().draw();

        OpenGL.pushMatrix();
        {
            Resources.instance.models().CRYOSTASIS_TUBE_MASK.draw();
        }
        OpenGL.popMatrix();
        OpenGL.enableCullFace();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.4F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.15F, 0.1F, 0F);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(90F + this.getIconRotation(), 0.0F, 1.0F, 0.0F);
        OpenGL.disableCullFace();
        this.getModel().draw();
        Resources.instance.models().CRYOSTASIS_TUBE_MASK.draw();
        OpenGL.enableCullFace();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(0.5F, -0.5F, 0.5F);
        OpenGL.translate(0F, -1.5F, 0F);
        OpenGL.disableCullFace();
        this.getModel().draw();

        OpenGL.pushMatrix();
        {
            OpenGL.enable(GL11.GL_BLEND);
            Resources.instance.models().CRYOSTASIS_TUBE_MASK.draw();
            OpenGL.disableBlend();
        }
        OpenGL.popMatrix();
        OpenGL.enableCullFace();
    }
}
