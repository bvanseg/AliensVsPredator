package org.weapon.client.render.item.firearm;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import com.asx.mdx.common.net.Networks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.avp.client.render.item.RenderMotionTrackerScreen;
import org.avp.common.URLs;
import org.avp.common.item.init.AVPItems;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;
import org.lwjgl.input.Mouse;
import org.weapon.client.model.item.ModelM41A;
import org.weapon.client.render.item.ItemFirearmRenderer;
import org.weapon.common.item.firearm.ItemFirearm;

public class RenderItemM41A extends ItemFirearmRenderer<ModelM41A>
{
    private final RenderMotionTrackerScreen motionTracker = new RenderMotionTrackerScreen();

    public RenderItemM41A()
    {
        super(Resources.instance.models().M41A);
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

            if (Mouse.isButtonDown(0) && ClientGame.instance.minecraft().inGameHasFocus && this.canAimWeapon(entity))
            {
                OpenGL.translate(-1.16F, -0.095F, 0.52F);
            }

            GlStateManager.disableCull();
            OpenGL.scale(glScale, -glScale, -glScale);
            new Texture(Networks.downloadResource(String.format(URLs.SKIN_M41A, ClientGame.instance.session().getPlayerID()), this.getModel().getTexture())).bind();
            this.getModel().getModel().render();

            if (ClientGame.instance.minecraft().player.getHeldItemMainhand() != null && ClientGame.instance.minecraft().player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
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

            InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer((EntityPlayer) entity);
            if (inventorySnapshot.hasItem(AVPItems.ITEM_MOTION_TRACKER))
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
        new Texture(Networks.downloadResource(String.format(URLs.SKIN_M41A, ClientGame.instance.session().getPlayerID()), this.getModel().getTexture())).bind();
        this.getModel().getModel().render();
    }

    public String getAmmoCountDisplayString()
    {
        ItemStack itemStack = ClientGame.instance.minecraft().player.inventory.getCurrentItem();
        int ammoCount = ((ItemFirearm)itemStack.getItem()).getAmmoCount(itemStack);
        return (ammoCount < 10 ? "0" + ammoCount : String.valueOf(ammoCount));
    }
}
