package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelSniper;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSniper extends ItemRenderer<ModelSniper>
{
    private float defaultFOV = mc.gameSettings.getOptionFloatValue(GameSettings.Options.FOV);

    public RenderItemSniper()
    {
        super(AliensVsPredator.resources().models().SNIPER);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.1F, 0.5F, 0F);
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    public void renderZoom()
    {
        if (mc.gameSettings.thirdPersonView == 0 && mc.player.getHeldItemMainhand() != null)
        {
            if (mc.player.getHeldItemMainhand().getItem() == AliensVsPredator.items().itemSniper)
            {
                if (!mc.inGameHasFocus)
                {
                    this.defaultFOV = mc.gameSettings.getOptionFloatValue(GameSettings.Options.FOV);
                }

                if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
                {
                    mc.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, 9F);
                }
                else if (mc.inGameHasFocus)
                {
                    mc.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, defaultFOV);
                }
            }
        }
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.05F, 0.2F, -0.25F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        float glScale = 1.2F;
        OpenGL.scale(glScale, -glScale, -glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            float glScale = 1.5F;
            OpenGL.translate(0F, 0.35F, -0.3F);

            if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
            {
                this.getModel().getModel().setFirstPerson(true);
                OpenGL.translate(-0.5125F, 0.095F, 0.62F);
            }
            else
            {
                this.getModel().getModel().setFirstPerson(false);
            }

            OpenGL.disable(GL11.GL_CULL_FACE);
            OpenGL.scale(-glScale, -glScale, -glScale);
            this.getModel().draw();
        }
        this.renderZoom();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.1F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }
}
