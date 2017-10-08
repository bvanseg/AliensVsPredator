package org.avp.client.render;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.gui.IAction;
import com.arisux.mdx.lib.client.gui.IGuiElement;
import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.Screen;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VisionModeRenderEvent
{
    public static final VisionModeRenderEvent instance          = new VisionModeRenderEvent();
    public VisionMode                         currentVisionMode = VisionMode.NORMAL;
    private IAction                           switchVisionMode  = new IAction() {
                                                                    @Override
                                                                    public void perform(IGuiElement element)
                                                                    {
                                                                        currentVisionMode = currentVisionMode.id < VisionMode.values().length - 1 ? VisionMode.get(currentVisionMode.id + 1) : VisionMode.get(0);
                                                                    }
                                                                };

    @SubscribeEvent
    public void renderTickOverlay(Pre event)
    {
        if (Game.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR && Game.minecraft().gameSettings.thirdPersonView == 0)
            {
                if (Inventories.getHelmSlotItemStack(Game.minecraft().player) != null && Inventories.getHelmSlotItemStack(Game.minecraft().player).getItem() == AliensVsPredator.items().helmTitanium)
                {
                    OpenGL.pushMatrix();
                    this.currentVisionMode.render();
                    Draw.drawStringAlignCenter(currentVisionMode.modeName, Screen.scaledDisplayResolution().getScaledWidth() / 2, 5, currentVisionMode.color, false);
                    OpenGL.color4i(0xFFFFFFFF);
                    OpenGL.popMatrix();
                }
            }
        }
    }

    @SubscribeEvent
    public void entityRenderEvent(RenderLivingEvent.Pre event)
    {
        ItemStack helmSlot = Inventories.getHelmSlotItemStack(Game.minecraft().player);

        if (Game.minecraft().gameSettings.thirdPersonView == 0 && helmSlot != null && helmSlot.getItem() == AliensVsPredator.items().helmTitanium)
        {
            if (event.getEntity() != Game.minecraft().player)
            {
                this.currentVisionMode.renderEntityPre(event);
            }
        }
    }

    @SubscribeEvent
    public void entityRenderEvent(RenderLivingEvent.Post event)
    {
        ItemStack helmSlot = Inventories.getHelmSlotItemStack(Game.minecraft().player);

        if (Game.minecraft().gameSettings.thirdPersonView == 0 && helmSlot != null && helmSlot.getItem() == AliensVsPredator.items().helmTitanium)
        {
            if (event.getEntity() != Game.minecraft().player)
            {
                this.currentVisionMode.renderEntityPost(event);
            }
        }
    }

    public void switchMode()
    {
        this.switchVisionMode.perform(null);
    }
}
