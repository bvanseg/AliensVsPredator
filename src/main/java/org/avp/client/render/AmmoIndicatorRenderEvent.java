package org.avp.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.common.item.firearm.ItemFirearm;

public class AmmoIndicatorRenderEvent
{
    public static final AmmoIndicatorRenderEvent instance = new AmmoIndicatorRenderEvent();

    @SubscribeEvent
    public void renderTick(RenderGameOverlayEvent.Pre event)
    {
        if (ClientGame.instance.minecraft().player == null) return;
        if (event.getType() != RenderGameOverlayEvent.ElementType.HOTBAR) return;

        boolean mainhandCheck = ClientGame.instance.minecraft().player.getHeldItemMainhand() != null && ClientGame.instance.minecraft().player.getHeldItemMainhand().getItem() instanceof ItemFirearm;
        boolean offhandCheck = ClientGame.instance.minecraft().player.getHeldItemOffhand() != null && ClientGame.instance.minecraft().player.getHeldItemOffhand().getItem() instanceof ItemFirearm;
        if (!ClientGame.instance.minecraft().player.capabilities.isCreativeMode)
        {
            if (mainhandCheck)
            {
                this.drawAmmoIndicator(ClientGame.instance.minecraft().player.getHeldItemMainhand(), Screen.scaledDisplayResolution().getScaledWidth() - 85, 10);
            }

            if (offhandCheck)
            {
                this.drawAmmoIndicator(ClientGame.instance.minecraft().player.getHeldItemOffhand(), 5, 10);
            }
        } else if (mainhandCheck || offhandCheck) {
            int barWidth = 182;
            int scaledHeight = Screen.scaledDisplayResolution().getScaledHeight();
            int scaledWidth = (Screen.scaledDisplayResolution().getScaledWidth() / 2);
            Draw.drawProgressBar("", 1, 1, scaledWidth - (barWidth / 2), scaledHeight - 35, barWidth, 1, 0, 0xFF00DDFF, false);
            //Draw.drawItemIcon(itemFireArm.getAmmoType(), (Screen.scaledDisplayResolution().getScaledWidth() / 2) - (barWidth / 2) + barWidth / 2 - Draw.getStringRenderWidth(displayStatus), Screen.scaledDisplayResolution().getScaledHeight() - 40, 16, 16);
        }
    }

    private void drawAmmoIndicator(ItemStack itemStack, int xOffset, int yOffset) {
        ItemFirearm itemFireArm = (ItemFirearm) itemStack.getItem();
        String displayStatus = " " + itemFireArm.getAmmoCount(itemStack) + "/" + itemFireArm.getFirearmProfile().getAmmoMax();
        int barWidth = 80;

        int scaledHeight = Screen.scaledDisplayResolution().getScaledHeight();
        Draw.drawProgressBar(displayStatus, itemFireArm.getFirearmProfile().getAmmoMax(), itemFireArm.getAmmoCount(itemStack), xOffset, scaledHeight - yOffset, barWidth, 1, 0, 0xFFFF0000, false);
        //Draw.drawItemIcon(itemFireArm.getAmmoType(), (Screen.scaledDisplayResolution().getScaledWidth() / 2) + barWidth / 2 - Draw.getStringRenderWidth(displayStatus) - 2, Screen.scaledDisplayResolution().getScaledHeight() - 53, 16, 16);
    }
}
