package org.avp.client.gui;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.ScaledResolution;
import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.gui.GuiCustomButton;
import com.asx.mdx.client.render.gui.GuiCustomScreen;
import com.asx.mdx.client.render.gui.GuiCustomSlider;
import com.asx.mdx.client.render.gui.GuiCustomTextbox;
import net.minecraft.client.gui.GuiScreen;
import org.avp.client.render.tactical.TacticalHelmetHUDRenderEvent;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;

import java.io.IOException;

public class GuiTacticalHUDSettings extends GuiCustomScreen
{
    protected final SpecialPlayerImpl player;
    private final GuiCustomTextbox channel;
    private final GuiCustomButton save;
    private final GuiCustomButton nightvision;
    private final GuiCustomButton entityCulling;
    private final GuiCustomSlider txPower;
    private final GuiCustomSlider viewportThreshold;

    public GuiTacticalHUDSettings(GuiScreen parent)
    {
        this.player = (SpecialPlayerImpl) ClientGame.instance.minecraft().player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);
        this.channel = new GuiCustomTextbox(this, 0, 0, 100, 15);
        this.save = new GuiCustomButton(0, 0, 0, 100, 15, "");
        this.nightvision = new GuiCustomButton(0, 0, 0, 100, 15, "");
        this.entityCulling = new GuiCustomButton(0, 0, 0, 100, 15, "");
        this.txPower = new GuiCustomSlider(0, 100, 100, "", 1, 1024);
        this.viewportThreshold = new GuiCustomSlider(0, 100, 100, "", 1, 32);
        this.channel.trackElement();
    }

    @Override
    public void initGui()
    {
        super.initGui();

        this.channel.setText(this.player.getBroadcastChannel());
        this.txPower.sliderValue = player.getBroadcastRadius() / txPower.sliderMaxValue;
        this.txPower.displayString = "Transmit Power: " + (int) (txPower.sliderValue * txPower.sliderMaxValue);

        this.viewportThreshold.sliderValue = TacticalHelmetHUDRenderEvent.instance.getViewportThreshold() / viewportThreshold.sliderMaxValue;
        this.viewportThreshold.displayString = "Threshold: " + (int) (viewportThreshold.sliderValue * viewportThreshold.sliderMaxValue);

        this.nightvision.setAction(element -> {
            player.setNightvisionEnabled(!player.isNightvisionEnabled());
            player.syncWithServer(ClientGame.instance.minecraft().player);
        });

        this.entityCulling.setAction(element -> {
            player.setEntityCullingEnabled(!player.isEntityCullingEnabled());
            player.syncWithServer(ClientGame.instance.minecraft().player);
        });

        this.save.setAction(element -> {
            String newChannel = channel.getText();
            int newRadius = (int) (txPower.sliderValue * txPower.sliderMaxValue);
            int newThreshold = (int) (viewportThreshold.sliderValue * viewportThreshold.sliderMaxValue);

            if (player.getBroadcastChannel() != newChannel || player.getBroadcastRadius() != newRadius || TacticalHelmetHUDRenderEvent.instance.getViewportThreshold() != newThreshold)
            {
                player.setBroadcastRadius(newRadius);
                player.setBroadcastChannel(newChannel);
                TacticalHelmetHUDRenderEvent.instance.setViewportThreshold(newThreshold);
                player.syncWithServer(ClientGame.instance.minecraft().player);
                channel.setText(newChannel);
            }

            mc.displayGuiScreen(null);
        });
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        ScaledResolution resolution = Screen.scaledDisplayResolution();

        int interfaceWidth = 250;
        int interfaceStartX = resolution.getScaledWidth() - interfaceWidth;
        int elementStart = 30;
        int elementSpacing = 21;

        Draw.drawRect(interfaceStartX, 0, interfaceWidth, height, 0x66000000);
        Draw.drawString("Tactical HUD Configuration", interfaceStartX + 10, 10, 0xCC00DDFF, false);

        channel.setMaxStringLength(18);
        channel.setX(interfaceStartX + 10);
        channel.setY(elementStart);;
        channel.setHeight(15);
        channel.setWidth(120);
        Draw.drawString("Broadcast Channel", channel.x() + channel.width() + 10, channel.y() + 3, 0xFFCCCCCC);
        channel.drawTextBox();

        txPower.label = "TX Power";
        txPower.x = interfaceStartX + 10;
        txPower.y = elementStart += elementSpacing;
        txPower.width = 120;
        txPower.height = 15;
        txPower.sliderMaxValue = 1024;
        txPower.sliderButtonColor = 0xCC00DDFF;
        txPower.tooltip = "The distance this tactical HUD will connect to other tactical HUDs.";
        Draw.drawString("Transmit Power", txPower.x + txPower.width + 10, txPower.y + 3, 0xFFCCCCCC);
        txPower.drawButton();

        viewportThreshold.label = "Threshold";
        viewportThreshold.x = interfaceStartX + 10;
        viewportThreshold.y = elementStart += elementSpacing;
        viewportThreshold.width = 120;
        viewportThreshold.height = 15;
        viewportThreshold.sliderMaxValue = 32;
        viewportThreshold.sliderButtonColor = 0xCC00DDFF;
        viewportThreshold.tooltip = "The amount of users with tactical HUDs to display in the viewport.";
        Draw.drawString("Viewport Threshold", viewportThreshold.x + viewportThreshold.width + 10, viewportThreshold.y + 3, 0xFFCCCCCC);
        viewportThreshold.drawButton();

        nightvision.displayString = player.isNightvisionEnabled() ? "Disable Nightvision" : "Enable Nightvision";
        nightvision.x = interfaceStartX + 10;
        nightvision.y = elementStart += elementSpacing;
        nightvision.width = 120;
        nightvision.height = 18;
        nightvision.baseColor = 0xCC00DDFF;
        nightvision.drawButton();
        nightvision.tooltip = "Toggle nightvision on or off.";

        entityCulling.displayString = player.isEntityCullingEnabled() ? "Disable Entity Culling" : "Enable Entity Culling";
        entityCulling.x = interfaceStartX + 10;
        entityCulling.y = elementStart += elementSpacing;
        entityCulling.width = 120;
        entityCulling.height = 18;
        entityCulling.baseColor = 0xCC00DDFF;
        entityCulling.drawButton();
        entityCulling.tooltip = "";

        save.displayString = "Save";
        save.x = interfaceStartX + 10;
        save.y = Screen.scaledDisplayResolution().getScaledHeight() - save.height - 10;
        save.width = 50;
        save.height = 20;
        save.baseColor = 0xCC00DDFF;
        save.drawButton();
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
    }

    @Override
    protected void keyTyped(char c, int i) throws IOException
    {
        super.keyTyped(c, i);
        channel.textboxKeyTyped(c, i);
    }

    @Override
    public void drawBackground(int i)
    {
        super.drawBackground(i);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }
}
