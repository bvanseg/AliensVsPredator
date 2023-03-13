package org.avp.client.gui;

import com.asx.mdx.lib.client.gui.*;
import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.util.Game;
import net.minecraft.client.renderer.GlStateManager;
import org.avp.AVP;
import org.avp.common.network.packet.server.PacketBlastdoorCommon;
import org.avp.common.network.packet.server.PacketBlastdoorCommon.PacketMode;
import org.avp.common.tile.TileEntityBlastdoor;

import java.io.IOException;

public class GuiBlastdoor extends GuiCustomScreen
{
    private final TileEntityBlastdoor door;
    private final GuiCustomTextbox    password;
    private GuiCustomButton     autolock;
    private GuiCustomButton     bindTuner;
    private String              status;
    private final boolean             frontEnd;

    public GuiBlastdoor(TileEntityBlastdoor door)
    {
        this(door, true);
    }

    public GuiBlastdoor(TileEntityBlastdoor door, boolean frontEnd)
    {
        super();
        this.door = door;
        this.status = "";
        this.password = new GuiCustomTextbox(0, 0, 0, 0);
        this.password.setFocused(true);
        this.frontEnd = frontEnd;

        if (door != null)
        {
            if (!this.frontEnd)
            {
                this.password.setText(door.getPassword());
                this.autolock = new GuiCustomButton(0, 0, 0, 0, 0, "");
                this.autolock.setAction(new IAction() {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        boolean value = !door.isAutolockEnabled();
                        AVP.network().sendToServer(new PacketBlastdoorCommon(PacketMode.SETAUTOLOCK, door.getPos(), value));
                        status = "Auto-Lock " + (door.isAutolockEnabled() ? "Disabled" : "Enabled");
                    }
                });
                this.bindTuner = new GuiCustomButton(0, 0, 0, 0, 0, "");
                this.bindTuner.setAction(new IAction() {
                    @Override
                    public void perform(IGuiElement element)
                    {
                        AVP.network().sendToServer(new PacketBlastdoorCommon(PacketMode.BIND, door.getPos()));
                        status = String.format("Bound %s to security tuner.", door.getIdentifier());
                    }
                });
            }
        }
        else
        {
            status = "CRITICAL ERROR";
        }
    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        int guiWidth = 200;
        int headerHeight = 33;
        int padding = 3;
        int screenX = this.width / 2 - (guiWidth / 2);
        int screenY = this.height / 2 - (headerHeight / 2) - 50;

        Draw.drawRect(screenX, screenY, guiWidth, 15, 0xCC000000);
        Draw.drawString(String.format("%s%s", "", door.getIdentifier()), screenX + padding, screenY + padding, 0xFFFFFFFF);

        String statusSecurity = door.isLocked() ? "LOCKED" : "UNLOCKED";
        String statusState = (door.isOpen() ? "OPEN" : "CLOSED");
        String statusText = frontEnd ? String.format("[ %s ] [ %s ]", statusSecurity, statusState) : "[ SETTINGS ]";
        int color = !frontEnd ? 0xFFFFFFFF : (door.isLocked() ? 0xFFFF0000 : 0xFF00FF00);
        Draw.drawString(statusText, screenX + guiWidth - Draw.getStringRenderWidth(statusText) - padding, screenY + padding, color);

        if (frontEnd)
        {
            this.password.setX(screenX);
            this.password.setY(screenY + padding + 12);
            this.password.setWidth(guiWidth);
            this.password.setHeight(18);
            this.password.setBackgroundColor(0xFF000000);
            this.password.setTextColor(0xFF00AA00);
            this.password.drawTextBox();

            if (!this.status.isEmpty())
            {
                GlStateManager.enableBlend();
                Draw.drawRect(screenX, screenY + headerHeight, guiWidth, 13, 0xEE000000);

                if (Game.minecraft().world.getTotalWorldTime() % 20 <= 10)
                {
                    Draw.drawString(status, screenX + padding, screenY + headerHeight + padding, 0xFFFF0000, false);
                }
            }
        }
        else
        {
            this.password.setX(screenX);
            this.password.setY(screenY + padding + 12);
            this.password.setWidth(guiWidth);
            this.password.setHeight(18);
            this.password.setBackgroundColor(0xFF000000);
            this.password.setTextColor(0xFF00AA00);
            this.password.setTooltip("The pass key for this door. [ENTER] to set.");
            this.password.drawTextBox();
            this.password.drawTooltip();
            GlStateManager.enableBlend();

            this.autolock.setX(screenX);
            this.autolock.setY(screenY + 15 + this.password.height());
            this.autolock.setWidth(guiWidth);
            this.autolock.setHeight(15);
            this.autolock.baseColor = 0xAA000000;
            this.autolock.displayString = this.door.isAutolockEnabled() ? "Disable Auto-Lock" : "Enable Auto-Lock";
            this.autolock.drawButton();

            this.bindTuner.setX(screenX);
            this.bindTuner.setY(this.autolock.y() + this.autolock.height());
            this.bindTuner.setWidth(guiWidth);
            this.bindTuner.setHeight(15);
            this.bindTuner.baseColor = 0xAA000000;
            this.bindTuner.displayString = "Bind to Security Tuner";
            this.bindTuner.drawButton();

            if (!this.status.isEmpty())
            {
                GlStateManager.enableBlend();
                Draw.drawRect(screenX, this.bindTuner.y() + this.bindTuner.height, guiWidth, 13, 0xEE000000);
                Draw.drawString(">" + status, screenX + padding, this.bindTuner.y() + this.bindTuner.height + padding, 0xFF00AA00, false);
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    protected void keyTyped(char c, int key) throws IOException
    {
        this.password.textboxKeyTyped(c, key);

        if (key == 28)
        {
            if (frontEnd)
            {
                if (!this.password.getText().isEmpty())
                {
                    AVP.network().sendToServer(new PacketBlastdoorCommon(PacketMode.AUTH, this.door.getPos(), this.password.getText()));
                    Game.minecraft().displayGuiScreen(null);
                }
                else
                {
                    this.status = "PASSWORD FIELD CANNOT BE EMPTY";
                }
            }
            else
            {
                AVP.network().sendToServer(new PacketBlastdoorCommon(PacketMode.SETPSWD, this.door.getPos(), this.password.getText()));
                this.status = "PASSWORD SET";
            }
        }

        if (key == 1)
        {
            Game.minecraft().displayGuiScreen(null);
        }
    }
}
