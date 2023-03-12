package org.avp.client.render.item.firearm;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.AVP;
import org.avp.client.model.item.ModelM240ICU;
import org.avp.client.render.item.ItemFirearmRenderer;
import org.avp.common.item.firearm.ItemFirearm;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class RenderItemM240ICU extends ItemFirearmRenderer<ModelM240ICU>
{
    public RenderItemM240ICU()
    {
        super(AVP.resources().models().M240ICU);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.5F, 0F);
        OpenGL.scale(1F, -1F, 1F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.15F, -0.3F);
        float glScale = 0.75F;
        OpenGL.scale(glScale, -glScale, -glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float displayScale = 0.005F;
        float glScale = 1.6F;

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0F, 0.15F, -0.4F);

            if (Mouse.isButtonDown(0) && Game.minecraft().inGameHasFocus && !isDualWielding(entity))
            {
                OpenGL.translate(-0.6495F, 0F, 0F);
            }

            GlStateManager.disableCull();
            OpenGL.scale(-glScale, -glScale, -glScale);
            this.getModel().draw();

            if (Game.minecraft().player.getHeldItemMainhand() != null && Game.minecraft().player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
            {
                OpenGL.disable(GL11.GL_LIGHTING);
                OpenGL.translate(-0.3439F, 0.6F, 0.04F);
                OpenGL.scale(displayScale, displayScale, displayScale);
                OpenGL.rotate(90F, 0F, 1F, 0F);
                Draw.drawRect(-2, -2, 16, 11, 0xFF000000);
                OpenGL.translate(0F, 0F, -0.01F);
                OpenGL.disableLightMapping();
                Draw.drawString(getAmmoCountDisplayString(), 0, 0, 0xFFFF0000);
                OpenGL.enable(GL11.GL_LIGHTING);
                OpenGL.color(1F, 1F, 1F, 1F);
            }
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.enableBlend();
        OpenGL.translate(0F, 0F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    public String getAmmoCountDisplayString()
    {
        int ammoCount = ((ItemFirearm) Game.minecraft().player.inventory.getCurrentItem().getItem()).getAmmoCount();
        return (ammoCount < 10 ? "0" + ammoCount : String.valueOf(ammoCount));
    }
}
