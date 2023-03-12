package org.avp.client.render;

import com.asx.mdx.lib.client.gui.IAction;
import com.asx.mdx.lib.client.gui.IGuiElement;
import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Screen;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.AVP;

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
                if (Inventories.getHelmSlotItemStack(Game.minecraft().player) != null && Inventories.getHelmSlotItemStack(Game.minecraft().player).getItem() == AVP.items().biomaskCeltic)
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

        if (Game.minecraft().gameSettings.thirdPersonView == 0 && helmSlot != null && helmSlot.getItem() == AVP.items().biomaskCeltic)
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

        if (Game.minecraft().gameSettings.thirdPersonView == 0 && helmSlot != null && helmSlot.getItem() == AVP.items().biomaskCeltic)
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
