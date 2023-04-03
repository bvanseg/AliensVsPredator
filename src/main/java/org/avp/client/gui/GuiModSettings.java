package org.avp.client.gui;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.ScaledResolution;
import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.gui.GuiCustomButton;
import com.asx.mdx.client.render.gui.GuiCustomScreen;
import com.asx.mdx.client.render.gui.GuiCustomTextbox;
import com.asx.mdx.client.render.gui.IGuiElement;
import com.asx.mdx.common.io.config.GraphicsSetting;
import com.asx.mdx.common.minecraft.Chat;
import com.asx.mdx.common.system.SystemInfo;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.resource.ReloadRequirements;
import net.minecraftforge.fml.client.FMLClientHandler;
import org.apache.commons.lang3.text.WordUtils;
import org.avp.common.config.ConfigSettingProxy;
import org.avp.common.config.ModelConfig;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.util.ArrayList;

public class GuiModSettings extends GuiCustomScreen
{
    private final ArrayList<IGuiElement> elements = new ArrayList<>();
    private int                    scroll   = 0;

    @SuppressWarnings("unchecked")
    public GuiModSettings(GuiScreen parent)
    {
        /* Graphics Settings */
        GuiCustomButton header; //= new GuiCustomButton(0, 0, 0, 0, 10, "Graphics Settings");
//        header.fontShadow = false;
//        header.overlayColorNormal = 0x00000000;
//        header.fontColor = 0xFF111111;
//        header.enabled = false;
//        this.elements.add(header);

        GuiCustomButton element;
        GuiCustomTextbox textbox;

        /* Game Settings */
        header = new GuiCustomButton(0, 0, 0, 0, 10, "Gameplay Settings");
        header.overlayColorNormal = 0x00000000;
        header.fontColor = 0xFF111111;
        header.enabled = false;
        header.fontShadow = false;
        this.elements.add(header);

        for (ConfigSettingProxy<?> proxy: ModelConfig.instance.configSettingProxies) {
            // Graphics
            if (proxy.getType().isAssignableFrom(GraphicsSetting.class))
            {
                element = new GuiCustomButton(2, 0, 0, 0, 10, proxy.get().toString());

                if (proxy.getDescription().isEmpty())
                {
                    element.setTooltip(Chat.format(String.format("&c%s", proxy.getName())));
                }
                else
                {
                    element.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(proxy.getName().replace("_", " ")), proxy.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", proxy.getDescription())));
                }

                element.setAction(element17 -> {
                    ConfigSettingProxy<GraphicsSetting> graphicsProxy = (ConfigSettingProxy<GraphicsSetting>) proxy;
                    int nextOrdinal = (graphicsProxy.get().ordinal() + 1) % GraphicsSetting.values().length;
                    GraphicsSetting newValue = GraphicsSetting.values()[nextOrdinal];
                    graphicsProxy.set(newValue);

                    if (element17 instanceof GuiCustomButton)
                    {
                        GuiCustomButton button = (GuiCustomButton) element17;
                        button.displayString = newValue.toString();
                    }
                });
                this.elements.add(element);
                continue;
            }

            // Boolean
            if (proxy.getType().isAssignableFrom(Boolean.class) || proxy.getType().isAssignableFrom(boolean.class))
            {
                element = new GuiCustomButton(2, 0, 0, 0, 10, proxy.get().toString());

                if (proxy.getDescription().isEmpty())
                {
                    element.setTooltip(Chat.format(String.format("&c%s", proxy.getName())));
                }
                else
                {
                    element.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(proxy.getName().replace("_", " ")), proxy.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", proxy.getDescription())));
                }

                element.setAction(element14 -> {
                    ConfigSettingProxy<Boolean> booleanProxy = (ConfigSettingProxy<Boolean>) proxy;
                    boolean inversion = !booleanProxy.get();
                    booleanProxy.set(inversion);

                    if (element14 instanceof GuiCustomButton)
                    {
                        GuiCustomButton button = (GuiCustomButton) element14;
                        button.displayString = Boolean.toString(inversion);
                    }
                });
                this.elements.add(element);
                continue;
            }

            // Integer.
            if (proxy.getType().isAssignableFrom(Integer.class) || proxy.getType().isAssignableFrom(int.class)) {
                textbox = new GuiCustomTextbox(0, 0, 0, 0);
                textbox.setText(proxy.get().toString());

                if (proxy.getDescription().isEmpty())
                {
                    textbox.setTooltip(Chat.format(String.format("&c%s", proxy.getName())));
                }
                else
                {
                    textbox.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(proxy.getName().replace("_", " ")), proxy.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", proxy.getDescription())));
                }

                textbox.setAction(element16 -> {
                    if (element16 instanceof GuiCustomTextbox)
                    {
                        GuiCustomTextbox t = (GuiCustomTextbox) element16;
                        ((ConfigSettingProxy<Integer>)proxy).set(Integer.parseInt(t.getText()));
                    }
                });
                textbox.trackElement();
                this.elements.add(textbox);
            }
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        ModelConfig.instance.write();
        ClientGame.instance.minecraft().player.sendMessage(new TextComponentString("Config automatically updated."));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        ScaledResolution resolution = Screen.scaledDisplayResolution();
        float descTextScale = 0.5F;
        
        OpenGL.enableBlend();
        Draw.drawRect(0, 0, resolution.getScaledWidth(), resolution.getScaledHeight(), 0xDD000000);

        for (IGuiElement element : this.elements)
        {
            if (element instanceof GuiCustomButton)
            {
                GuiCustomButton button = (GuiCustomButton) element;
                int elementX = (button.x + button.width + 10);
                int elementY = (button.y + (button.height / 2));

                OpenGL.enableBlend();
                Draw.drawRect(button.x, button.y, resolution.getScaledWidth() - 10, button.height, !button.getTooltip().isEmpty() ? 0xFF1A1A1A : 0xFF676767);
                button.drawButton();
                OpenGL.enableBlend();

                if (button.getTooltip().contains(":s:"))
                {
                    String[] info = button.getTooltip().split(":s:");
                    Draw.drawString(info[0], elementX, elementY - 6, 0xFFFFFFFF, false);
                    OpenGL.pushMatrix();
                    OpenGL.scale(descTextScale, descTextScale, descTextScale);
                    Draw.drawString(info[1], Math.round(elementX / descTextScale), Math.round((elementY + 4) / descTextScale), 0xFFFFFFFF, false);
                    OpenGL.popMatrix();
                }
                else
                {
                    Draw.drawString(button.getTooltip(), Math.round((button.x + button.width + 10)), Math.round((button.y + (button.height / 2) - 4)), 0xFF888888, false);
                }
            }

            if (element instanceof GuiCustomTextbox)
            {
                GuiCustomTextbox textbox = (GuiCustomTextbox) element;
                int elementX = (textbox.x() + textbox.width() + 10);
                int elementY = (textbox.y() + (textbox.height() / 2));

                OpenGL.enableBlend();
                Draw.drawRect(textbox.x(), textbox.y(), resolution.getScaledWidth() - 10, textbox.height(), !textbox.getTooltip().isEmpty() ? 0xFF222222 : 0xFFFF2222);
                textbox.drawTextBox();
                OpenGL.enableBlend();

                if (textbox.getTooltip().contains(":s:"))
                {
                    String[] info = textbox.getTooltip().split(":s:");
                    Draw.drawString(info[0], elementX, elementY - 6, 0xFFFFFFFF, false);
                    OpenGL.pushMatrix();
                    OpenGL.scale(descTextScale, descTextScale, descTextScale);
                    Draw.drawString(info[1], Math.round(elementX / descTextScale), Math.round((elementY + 4) / descTextScale), 0xFFFFFFFF, false);
                    OpenGL.popMatrix();
                }
                else
                {
                    Draw.drawString(textbox.getTooltip(), Math.round((textbox.x() + textbox.width() + 10) / descTextScale), Math.round((textbox.y() + (textbox.height() / 2) - 4) / descTextScale), 0xFFFFFFFF, false);
                }
            }

            element.drawTooltip();
        }

//        int idx = 1;
//        int yStart = 15;
//        int padding = 12;
//        double memoryTotal = SystemInfo.toMBFromB(SystemInfo.vmMemoryTotalBytes());
//        double memoryFree = SystemInfo.toMBFromB(SystemInfo.vmMemoryFreeBytes());
//        double memoryMax = SystemInfo.toMBFromB(SystemInfo.vmMemoryMaxBytes());
//        double memoryUsed = memoryTotal - memoryFree;
//        int memoryPercent = (int) (memoryUsed * 100D / memoryTotal);
//        int memoryPercentMax = (int) (memoryUsed * 100D / memoryMax);
//        Draw.drawProgressBar(String.format("VM Memory [%s/%s] %s%%", memoryUsed, memoryTotal, memoryPercent), 100, memoryPercent, 5, yStart + (padding * idx++) - (15 * scroll) - 2, resolution.getScaledWidth() - 10, 5, 0, 0xFF00DDFF, false);
//        Draw.drawProgressBar(String.format("VM Memory Total [%s/%s] %s%%", memoryUsed, memoryMax, memoryPercentMax), 100, memoryPercentMax, 5, yStart + (padding * idx++) - (15 * scroll) - 2, resolution.getScaledWidth() - 10, 5, 0, 0xFF00DDFF, false);
        
        OpenGL.enableBlend();
        String menuName = "[Configuration Editor] ";
        int titleWidth = Draw.getStringRenderWidth(menuName);
        Draw.drawRect(0, 0, resolution.getScaledWidth(), 20, 0xFF898989);
        Draw.drawString(menuName, 5, 6, 0xFF222222, false);

        String title = String.format("%s", SystemInfo.cpu());
        title = String.format("%s, %s", title, SystemInfo.gpu());
        if (SystemInfo.getMemoryCapacity() != 0)
        {
            title = String.format("%s, %sGBs", title, SystemInfo.toGBFromB(SystemInfo.getMemoryCapacity()));
        }
        title = String.format("%s, %s (%s, %s)", title, SystemInfo.osName(), SystemInfo.osVersion(), SystemInfo.osArchitecture());
        title = String.format("%s, Java %s", title, SystemInfo.javaVersion());
        

        float scale = 0.5F;
        OpenGL.pushMatrix();
        OpenGL.scale(scale, scale, scale);
        Draw.drawString(Chat.format(title), Math.round(15 + titleWidth / scale), Math.round(8 / scale), 0xFF222222, false);
        OpenGL.popMatrix();
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();

        this.updateScrolling();

        int yStart = 25;
        int controlWidth = 100;
        int controlHeight = 15;
        int vPadding = 1;
        int hPadding = 5;

        for (IGuiElement element : this.elements)
        {
            int idx = this.elements.indexOf(element);

            if (element instanceof GuiCustomButton)
            {
                GuiCustomButton button = (GuiCustomButton) element;

                button.x = hPadding;
                button.y = yStart + ((idx * (controlHeight + vPadding)) - controlHeight * scroll);
                button.width = controlWidth;
                button.height = controlHeight;

                if (!button.enabled)
                {
                    button.baseColor = 0x00000000;
                }
                else
                {
                    button.overlayColorHover = 0x22FFFFFF;
                    button.overlayColorNormal = 0x66000000;
                    button.baseColor = 0x00000000;
                }
            }

            if (element instanceof GuiCustomTextbox)
            {
                GuiCustomTextbox textbox = (GuiCustomTextbox) element;

                textbox.setX(hPadding);
                textbox.setY(yStart + ((idx * (controlHeight + vPadding)) - controlHeight * scroll));
                textbox.setWidth(controlWidth);
                textbox.setHeight(controlHeight);
            }
        }
    }

    private void updateScrolling()
    {
        int dWheel = Mouse.getDWheel();

        if (dWheel > 0)
        {
            scrollDown();
        }
        else if (dWheel < 0)
        {
            scrollUp();
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
        {
            scrollDown();
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_UP))
        {
            scrollUp();
        }
    }
    
    @Override
    protected void keyTyped(char c, int i) throws IOException
    {
        super.keyTyped(c, i);

        for (IGuiElement element : this.elements)
        {
            if (element instanceof GuiCustomTextbox)
            {
                GuiCustomTextbox textbox = (GuiCustomTextbox) element;
                textbox.textboxKeyTyped(c, i);
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public void scrollDown()
    {
        if (this.scroll > 0)
        {
            this.scroll -= 1;
        }
    }

    public void scrollUp()
    {
        if (this.scroll < this.elements.size() - 1)
        {
            this.scroll += 1;
        }
    }
}
