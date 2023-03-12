package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.ItemHandler;
import org.avp.URLs;
import org.avp.client.model.items.ModelM41A;
import org.avp.item.firearms.ItemFirearm;
import org.lwjgl.input.Mouse;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.Networks;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RenderItemM41A extends ItemFirearmRenderer<ModelM41A>
{
    private RenderMotionTrackerScreen motionTracker = new RenderMotionTrackerScreen();

    public RenderItemM41A()
    {
        super(AliensVsPredator.resources().models().M41A);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.3F, 1F, 0F);
        OpenGL.scale(1F, -1F, 1F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1F;
        OpenGL.translate(0.28F, 0.75F, -0.05F);
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
            OpenGL.translate(1F, 1.25F, -0.3F);

            if (Mouse.isButtonDown(0) && Game.minecraft().inGameHasFocus && !isDualWielding(entity))
            {
                OpenGL.translate(-1.16F, -0.095F, 0.52F);
            }

            GlStateManager.disableCull();
            OpenGL.scale(glScale, -glScale, -glScale);
            new Texture(Networks.downloadResource(String.format(URLs.SKIN_M41A, Game.session().getPlayerID()), this.getModel().getTexture())).bind();
            this.getModel().getModel().render();

            if (Game.minecraft().player.getHeldItemMainhand() != null && Game.minecraft().player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
            {
                OpenGL.disableLighting();
                OpenGL.translate(-0.3439F, 0.6F, 0.04F);
                OpenGL.scale(displayScale, displayScale, displayScale);
                OpenGL.rotate(90F, 0F, 1F, 0F);
                Draw.drawRect(-2, -2, 16, 11, 0xFF000000);
                OpenGL.translate(0F, 0F, -0.01F);
                Draw.drawString(getAmmoCountDisplayString(), 0, 0, 0xFFFF0000);
                OpenGL.enableLighting();
                OpenGL.color(1F, 1F, 1F, 1F);
            }
            
            if (Inventories.getAmountOfItemPlayerHas(ItemHandler.itemMotionTracker, (EntityPlayer) entity) > 0)
            {
                OpenGL.translate(-50F, -20F, -50F);
                OpenGL.rotate(-90F, 0F, 1F, 0F);
                OpenGL.scale(0.4F, 0.4F, 0.4F);
                OpenGL.disableLight();
                motionTracker.draw(0, 0, 128, 96);
                OpenGL.enableLight();
            }
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.translate(0F, -0.65F, 0F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        new Texture(Networks.downloadResource(String.format(URLs.SKIN_M41A, Game.session().getPlayerID()), this.getModel().getTexture())).bind();
        this.getModel().getModel().render();
    }

    public String getAmmoCountDisplayString()
    {
        int ammoCount = ((ItemFirearm) Game.minecraft().player.inventory.getCurrentItem().getItem()).getAmmoCount();
        return (ammoCount < 10 ? "0" + ammoCount : String.valueOf(ammoCount));
    }
}
