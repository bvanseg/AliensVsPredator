package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.URLs;
import org.avp.client.model.items.ModelAK47;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.client.render.Texture;
import com.arisux.mdxlib.lib.game.Game;
import com.arisux.mdxlib.lib.util.Remote;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemAK47 extends ItemRenderer<ModelAK47>
{
    public RenderItemAK47()
    {
        super(AliensVsPredator.resources().models().AK47);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.translate(-0.1F, 0.5F, -0.5F);
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.2F, 0.3F, -0.17F);
        OpenGL.rotate(97.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(130.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(80.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        OpenGL.scale(1.3F, 1.3F, 1.3F);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
            {
                OpenGL.translate(-0.5F, 0.44F, -1.23F);
                OpenGL.rotate(101.3F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(117.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(80.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.disable(GL11.GL_CULL_FACE);
            }
            else
            {
                OpenGL.translate(0.1F, 0.35F, -0.1F);
                OpenGL.rotate(95.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(80.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.disable(GL11.GL_CULL_FACE);
            }

            float glScale = 2.0F;
            OpenGL.scale(glScale, glScale, glScale);
            this.getModel().draw();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.4F, -0.3F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        new Texture(Remote.downloadResource(String.format(URLs.SKIN_AK47, Game.session().getPlayerID()), this.getModel().getTexture())).bind();
        this.getModel().getModel().render();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

    }
}
