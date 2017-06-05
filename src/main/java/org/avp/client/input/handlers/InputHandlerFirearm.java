package org.avp.client.input.handlers;

import org.avp.AliensVsPredator;
import org.avp.client.input.IInputHandler;
import org.avp.item.ItemFirearm;
import org.avp.packets.server.PacketReloadFirearm;

import com.arisux.mdx.lib.game.Game;

public class InputHandlerFirearm implements IInputHandler
{
    public static final InputHandlerFirearm instance   = new InputHandlerFirearm();
    private int                             lastReload = 0;

    @Override
    public void handleInput()
    {
        if (Game.minecraft().player != null)
        {
            this.lastReload++;

            if (Game.minecraft().inGameHasFocus && Game.minecraft().player.inventory.getCurrentItem() != null && Game.minecraft().player.inventory.getCurrentItem().getItem() instanceof ItemFirearm)
            {
                ItemFirearm fireArm = (ItemFirearm) Game.minecraft().player.inventory.getCurrentItem().getItem();

                if (AliensVsPredator.keybinds().specialSecondary.isPressed() && this.lastReload > fireArm.getProfile().getReloadTime())
                {
                    this.lastReload = 0;
                    AliensVsPredator.network().sendToServer(new PacketReloadFirearm());
                }
            }
        }
    }
}
