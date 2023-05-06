package org.avp.client.render.tactical;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.gui.GuiCustomButton;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.avp.client.gui.GuiTacticalHUDSettings;
import org.avp.common.item.init.AVPArmorItems;

public class TacticalHelmetSettingsRenderEvent
{
    public static final TacticalHelmetSettingsRenderEvent instance = new TacticalHelmetSettingsRenderEvent();
    private GuiTacticalHUDSettings guiSettings;
    private final GuiCustomButton buttonMarineHelmConfig;

    private TacticalHelmetSettingsRenderEvent() {
        this.buttonMarineHelmConfig = new GuiCustomButton(0, 0, 0, 50, 20, "");
    }

    @SubscribeEvent
    public void renderTick(RenderGameOverlayEvent event)
    {
        if (buttonMarineHelmConfig.getAction() == null)
        {
            guiSettings = new GuiTacticalHUDSettings(ClientGame.instance.minecraft().currentScreen);
            buttonMarineHelmConfig.setAction(element -> ClientGame.instance.minecraft().displayGuiScreen(guiSettings));
        }

        if (ClientGame.instance.minecraft().player != null && event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR)
        {
            this.renderInventoryElements(event);
        }
    }

    public void renderInventoryElements(RenderGameOverlayEvent event)
    {
        if (Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player) != null && Inventories.getHelmSlotItemStack(ClientGame.instance.minecraft().player).getItem() == AVPArmorItems.HELM_MARINE)
        {
            if (ClientGame.instance.minecraft().currentScreen instanceof GuiInventory || ClientGame.instance.minecraft().currentScreen instanceof GuiChat)
            {
                buttonMarineHelmConfig.displayString = "Configure";
                buttonMarineHelmConfig.tooltip = "Click to configure the Tactical HUD.";
                buttonMarineHelmConfig.width = 70;
                buttonMarineHelmConfig.baseColor = 0x44000000;
                buttonMarineHelmConfig.x = Screen.scaledDisplayResolution().getScaledWidth() - buttonMarineHelmConfig.width;
                buttonMarineHelmConfig.y = 0;
                buttonMarineHelmConfig.drawButton();
            }
        }
    }
}
