package org.predator.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.gui.IAction;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.predator.client.PredatorSounds;
import org.predator.common.PredatorItems;

public class VisionModeRenderEvent
{
    public static final VisionModeRenderEvent instance          = new VisionModeRenderEvent();
    public VisionMode                         currentVisionMode = VisionMode.NORMAL;
    private final IAction                           switchVisionMode  = element -> currentVisionMode = currentVisionMode.id < VisionMode.values().length - 1 ? VisionMode.get(currentVisionMode.id + 1) : VisionMode.get(0);

    private boolean playingSound = false;

    @SubscribeEvent
    public void renderTickOverlay(Pre event)
    {
        if (ClientGame.instance.minecraft().player != null)
        {
            if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR && ClientGame.instance.minecraft().gameSettings.thirdPersonView == 0)
            {
                if (Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player) != null && Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player).getItem() == PredatorItems.BIOMASK_CELTIC)
                {
                    if (this.currentVisionMode != VisionMode.NORMAL) {
                        if (!playingSound || ClientGame.instance.minecraft().player.world.getTotalWorldTime() % 105 == 0) {
                            ClientGame.instance.minecraft().player.playSound(PredatorSounds.YAUTJA_VISION_LOOP.event(), 0.4F, 1F);
                            this.playingSound = true;
                        }
                    } else {
                        this.playingSound = false;
                    }

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
        ItemStack helmSlot = Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player);

        if (ClientGame.instance.minecraft().gameSettings.thirdPersonView == 0 && helmSlot != null && helmSlot.getItem() == PredatorItems.BIOMASK_CELTIC)
        {
            if (event.getEntity() != ClientGame.instance.minecraft().player)
            {
                this.currentVisionMode.renderEntityPre(event);
            }
        }
    }

    @SubscribeEvent
    public void entityRenderEvent(RenderLivingEvent.Post event)
    {
        ItemStack helmSlot = Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player);

        if (ClientGame.instance.minecraft().gameSettings.thirdPersonView == 0 && helmSlot != null && helmSlot.getItem() == PredatorItems.BIOMASK_CELTIC)
        {
            if (event.getEntity() != ClientGame.instance.minecraft().player)
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
