package org.avp.client.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.text.WordUtils;
import org.avp.AVP;
import org.avp.common.Settings;
import org.avp.common.Settings.ClientSettings;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.asx.mdx.config.ConfigSetting;
import com.asx.mdx.config.ConfigSettingBoolean;
import com.asx.mdx.config.ConfigSettingGraphics;
import com.asx.mdx.config.ConfigSettingInteger;
import com.asx.mdx.lib.client.gui.GuiCustomButton;
import com.asx.mdx.lib.client.gui.GuiCustomScreen;
import com.asx.mdx.lib.client.gui.GuiCustomTextbox;
import com.asx.mdx.lib.client.gui.IAction;
import com.asx.mdx.lib.client.gui.IGuiElement;
import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.ScaledResolution;
import com.asx.mdx.lib.client.util.Screen;
import com.asx.mdx.lib.util.Chat;
import com.asx.mdx.lib.util.system.SystemInfo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class GuiModSettings extends GuiCustomScreen
{
    private ArrayList<IGuiElement> elements = new ArrayList<IGuiElement>();
    private int                    scroll   = 0;
    private long                   lastApplyTime;

    public GuiModSettings(GuiScreen parent)
    {
        /** Graphics Settings **/
        GuiCustomButton header = new GuiCustomButton(0, 0, 0, 0, 10, "Graphics Settings");
        header.fontShadow = false;
        header.overlayColorNormal = 0x00000000;
        header.fontColor = 0xFF111111;
        header.enabled = false;
        this.elements.add(header);

        GuiCustomButton element = null;
        GuiCustomTextbox textbox = null;

        for (ConfigSetting setting : ClientSettings.instance.allSettings())
        {
            if (setting instanceof ConfigSettingGraphics)
            {
                element = new GuiCustomButton(2, 0, 0, 0, 10, setting.getStringValue());

                if (setting.property().getComment() == null || setting.property().getComment() != null && setting.property().getComment().isEmpty())
                {
                    element.tooltip = Chat.format(String.format("&c%s", setting.property().getLanguageKey()));
                }
                else
                {
                    element.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(setting.property().getLanguageKey().replace("_", " ")), setting.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", setting.property().getComment())));
                }

                element.setAction(new IAction()
                {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        setting.toggle();

                        if (element instanceof GuiCustomButton)
                        {
                            GuiCustomButton button = (GuiCustomButton) element;
                            button.displayString = setting.getStringValue();
                        }
                    }
                });
                this.elements.add(element);
            }

            if (setting instanceof ConfigSettingInteger)
            {
                textbox = new GuiCustomTextbox(0, 0, 0, 0);
                textbox.setText(setting.getStringValue());

                if (setting.property().getComment() == null || setting.property().getComment() != null && setting.property().getComment().isEmpty())
                {
                    textbox.setTooltip(Chat.format(String.format("&c%s", setting.property().getLanguageKey())));
                }
                else
                {
                    element.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(setting.property().getLanguageKey().replace("_", " ")), setting.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", setting.property().getComment())));
                }

                textbox.setAction(new IAction()
                {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        if (element instanceof GuiCustomTextbox)
                        {
                            GuiCustomTextbox t = (GuiCustomTextbox) element;
                            setting.property().set(t.getText());
                        }
                    }
                });
                textbox.trackElement();
                this.elements.add(textbox);
            }

            if (setting instanceof ConfigSettingBoolean)
            {
                element = new GuiCustomButton(2, 0, 0, 0, 10, setting.getStringValue());

                if (setting.property().getComment() == null || setting.property().getComment() != null && setting.property().getComment().isEmpty())
                {
                    element.tooltip = Chat.format(String.format("&c%s", setting.property().getLanguageKey()));
                }
                else
                {
                    element.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(setting.property().getLanguageKey().replace("_", " ")), setting.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", setting.property().getComment())));
                }

                element.setAction(new IAction()
                {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        setting.toggle();

                        if (element instanceof GuiCustomButton)
                        {
                            GuiCustomButton button = (GuiCustomButton) element;
                            button.displayString = setting.getStringValue();
                        }
                    }
                });
                this.elements.add(element);
            }
        }

        /** Game Settings **/
        header = new GuiCustomButton(0, 0, 0, 0, 10, "Gameplay Settings");
        header.overlayColorNormal = 0x00000000;
        header.fontColor = 0xFF111111;
        header.enabled = false;
        header.fontShadow = false;
        this.elements.add(header);

        for (ConfigSetting setting : AVP.settings().allSettings())
        {
            if (setting instanceof ConfigSettingBoolean)
            {
                element = new GuiCustomButton(2, 0, 0, 0, 10, setting.getStringValue());

                if (setting.property().getComment() == null || setting.property().getComment() != null && setting.property().getComment().isEmpty())
                {
                    element.tooltip = Chat.format(String.format("&c%s", setting.property().getLanguageKey()));
                }
                else
                {
                    element.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(setting.property().getLanguageKey().replace("_", " ")), setting.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", setting.property().getComment())));
                }

                element.setAction(new IAction()
                {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        setting.toggle();

                        if (element instanceof GuiCustomButton)
                        {
                            GuiCustomButton button = (GuiCustomButton) element;
                            button.displayString = setting.getStringValue();
                        }
                    }
                });
                this.elements.add(element);
            }

            if (setting instanceof ConfigSettingInteger)
            {
                textbox = new GuiCustomTextbox(0, 0, 0, 0);
                textbox.setText(setting.getStringValue());

                if (setting.property().getComment() == null || setting.property().getComment() != null && setting.property().getComment().isEmpty())
                {
                    textbox.setTooltip(Chat.format(String.format("&c%s", setting.property().getLanguageKey())));
                }
                else
                {
                    textbox.setTooltip(Chat.format(String.format("&f%s&f:s:&b%s&7%s", WordUtils.capitalize(setting.property().getLanguageKey().replace("_", " ")), setting.getRequiresRestart() ? "&c[RESTART REQUIRED] " : "&b", setting.property().getComment())));
                }

                textbox.setAction(new IAction()
                {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        if (element instanceof GuiCustomTextbox)
                        {
                            GuiCustomTextbox t = (GuiCustomTextbox) element;
                            setting.property().set(t.getText());
                        }
                    }
                });
                textbox.trackElement();
                this.elements.add(textbox);
            }
        }

        element = new GuiCustomButton(2, 0, 0, 0, 10, "");
        element.visible = false;
        element.enabled = false;
        element.overlayColorNormal = 0x00000000;
        this.elements.add(element);

        element = new GuiCustomButton(2, 0, 0, 0, 10, "Apply");
        element.tooltip = "Applies settings without saving them to the config. Changes will be lost after restarting the game.";
        element.overlayColorHover = 0xAA444444;
        element.fontColor = 0xFF00CCFF;
        element.fontShadow = false;
        element.setAction(new IAction()
        {
            @Override
            public void perform(IGuiElement element)
            {
                applySettings();
            }
        });
        this.elements.add(element);

        element = new GuiCustomButton(2, 0, 0, 0, 10, "Save and Apply");
        element.tooltip = "Applies settings and saves them to the config.";
        element.overlayColorHover = 0xAA444444;
        element.fontColor = 0xFF00CCFF;
        element.fontShadow = false;
        element.setAction(new IAction()
        {
            @Override
            public void perform(IGuiElement element)
            {
                applyAndSaveSettings();
            }
        });
        this.elements.add(element);
    }

    private void applyAndSaveSettings()
    {
        this.applySettings();
        this.saveSettings();
    }

    private void saveSettings()
    {
        Settings.instance.saveSettings();
        ClientSettings.instance.saveSettings();
    }

    private void applySettings()
    {
        for (IGuiElement e : elements)
        {
            if (e instanceof GuiCustomTextbox)
            {
                GuiCustomTextbox textbox = (GuiCustomTextbox) e;
                textbox.getAction().perform(textbox);
            }
        }
        this.lastApplyTime = System.currentTimeMillis();
    }

    @Override
    public void initGui()
    {
        super.initGui();
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

        if (System.currentTimeMillis() - lastApplyTime <= 3000)
        {
            OpenGL.enableBlend();
            Draw.drawRect(0, 0, resolution.getScaledWidth(), resolution.getScaledHeight(), 0xDD000000);
            
            scale = 2F;
            OpenGL.pushMatrix();
            OpenGL.scale(scale, scale, scale);
            Draw.drawStringAlignCenter("Please wait... Applying your settings.", Math.round(resolution.getScaledWidth() / 2 / scale), Math.round(resolution.getScaledHeight() / 2 / scale), 0xFF00CCFF, false);
            OpenGL.popMatrix();
        }
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();

        if (lastApplyTime != 0)
        {
            long time = System.currentTimeMillis() - this.lastApplyTime;

            if (time < 1000 && time > 500)
            {
                this.lastApplyTime = 0;
                Minecraft.getMinecraft().refreshResources();
            }
        }

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

    public int getScroll()
    {
        return this.scroll;
    }
}
