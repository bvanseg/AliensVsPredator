package org.avp.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.common.item.firearm.ItemFirearm;

public class AmmoIndicatorRenderEvent
{
    public static final AmmoIndicatorRenderEvent instance = new AmmoIndicatorRenderEvent();
    public ItemStack helmSlot, chestplateSlot, leggingsSlot, bootsSlot;

    @SubscribeEvent
    public void renderTick(RenderGameOverlayEvent.Pre event)
    {
        if (ClientGame.instance.minecraft().player != null && event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR)
        {
            helmSlot = Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player);
            chestplateSlot = Inventories.getChestSlotItemStack(ClientGame.instance.minecraft().player);
            leggingsSlot = Inventories.getLegsSlotItemStack(ClientGame.instance.minecraft().player);
            bootsSlot = Inventories.getBootSlotItemStack(ClientGame.instance.minecraft().player);

            if (ClientGame.instance.minecraft().player.getHeldItemMainhand() != null && ClientGame.instance.minecraft().player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
            {
                ItemFirearm itemFireArm = (ItemFirearm) ClientGame.instance.minecraft().player.getHeldItemMainhand().getItem();
                String displayStatus = " " + itemFireArm.getAmmoCount() + "/" + itemFireArm.getProfile().getAmmoMax();
                int barWidth = 0;

                if (!ClientGame.instance.minecraft().player.capabilities.isCreativeMode && isWearingArmor())
                {
                    barWidth = 90;
                    Draw.drawProgressBar(displayStatus, itemFireArm.getProfile().getAmmoMax(), itemFireArm.getAmmoCount(), (Screen.scaledDisplayResolution().getScaledWidth() / 2), Screen.scaledDisplayResolution().getScaledHeight() - 48, barWidth, 1, 0, 0xFFFF0000, false);
                    //Draw.drawItemIcon(itemFireArm.getAmmoType(), (Screen.scaledDisplayResolution().getScaledWidth() / 2) + barWidth / 2 - Draw.getStringRenderWidth(displayStatus) - 2, Screen.scaledDisplayResolution().getScaledHeight() - 53, 16, 16);
                }
                else if (!ClientGame.instance.minecraft().player.capabilities.isCreativeMode && !isWearingArmor())
                {
                    barWidth = 182;
                    Draw.drawProgressBar(displayStatus, itemFireArm.getProfile().getAmmoMax(), itemFireArm.getAmmoCount(), (Screen.scaledDisplayResolution().getScaledWidth() / 2) - (182 / 2), Screen.scaledDisplayResolution().getScaledHeight() - 48, barWidth, 1, 0, 0xFF00DDFF, false);
                    //Draw.drawItemIcon(itemFireArm.getAmmoType(), (Screen.scaledDisplayResolution().getScaledWidth() / 2) - (barWidth / 2) + barWidth / 2 - Draw.getStringRenderWidth(displayStatus) - 2, Screen.scaledDisplayResolution().getScaledHeight() - 53, 16, 16);
                }
                else
                {
                    barWidth = 182;
                    displayStatus = "\u221e";
                    Draw.drawProgressBar("", 1, 1, (Screen.scaledDisplayResolution().getScaledWidth() / 2) - (barWidth / 2), Screen.scaledDisplayResolution().getScaledHeight() - 35, barWidth, 1, 0, 0xFF00DDFF, false);
                    //Draw.drawItemIcon(itemFireArm.getAmmoType(), (Screen.scaledDisplayResolution().getScaledWidth() / 2) - (barWidth / 2) + barWidth / 2 - Draw.getStringRenderWidth(displayStatus), Screen.scaledDisplayResolution().getScaledHeight() - 40, 16, 16);
                }
            }
        }
    }

    public boolean isWearingArmor()
    {
        return helmSlot != null || chestplateSlot != null || leggingsSlot != null || bootsSlot != null;
    }
}
