package org.avp.client.render.item.firearm;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.AVP;
import org.avp.client.model.item.ModelSniper;
import org.avp.client.render.item.ItemFirearmRenderer;
import org.lwjgl.input.Mouse;

public class RenderItemSniper extends ItemFirearmRenderer<ModelSniper>
{
    private float defaultFOV = Game.minecraft().gameSettings.getOptionFloatValue(GameSettings.Options.FOV);

    public RenderItemSniper()
    {
        super(AVP.resources().models().SNIPER);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.1F, 0.5F, 0F);
        OpenGL.scale(1F, -1F, 1F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    public void renderZoom()
    {
        if (Game.minecraft().gameSettings.thirdPersonView == 0 && Game.minecraft().player.getHeldItemMainhand() != null)
        {
            if (Game.minecraft().player.getHeldItemMainhand().getItem() == AVP.items().itemSniper)
            {
                if (!Game.minecraft().inGameHasFocus)
                {
                    this.defaultFOV = Game.minecraft().gameSettings.getOptionFloatValue(GameSettings.Options.FOV);
                }

                if (Mouse.isButtonDown(0) && Game.minecraft().inGameHasFocus && !isDualWielding(entity))
                {
                    Game.minecraft().gameSettings.setOptionFloatValue(GameSettings.Options.FOV, 9F);
                }
                else if (Game.minecraft().inGameHasFocus)
                {
                    Game.minecraft().gameSettings.setOptionFloatValue(GameSettings.Options.FOV, defaultFOV);
                }
            }
        }
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.05F, 0.2F, -0.25F);
        GlStateManager.disableCull();
        float glScale = 1.2F;
        OpenGL.scale(glScale, -glScale, -glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.5F;
        OpenGL.translate(0F, 0.35F, -0.3F);

        if (Mouse.isButtonDown(0) && Game.minecraft().inGameHasFocus && !isDualWielding(entity))
        {
            this.getModel().getModel().setFirstPerson(true);
            OpenGL.translate(-0.5125F, 0.095F, 0.62F);
        }
        else
        {
            this.getModel().getModel().setFirstPerson(false);
        }

        GlStateManager.disableCull();
        OpenGL.scale(-glScale, -glScale, -glScale);
        this.getModel().draw();
        this.renderZoom();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.1F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
