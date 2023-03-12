package org.avp.client.input.handlers;

import org.avp.AVP;
import org.avp.client.input.IInputHandler;
import org.avp.common.packets.server.PacketLaunchGrenade;

import com.asx.mdx.lib.util.Game;

import net.minecraft.item.ItemStack;

public class InputHandlerPulseRifle implements IInputHandler
{
    public static final InputHandlerPulseRifle instance = new InputHandlerPulseRifle();

    @Override
    public void handleInput()
    {
        ItemStack current = Game.minecraft().player.getHeldItemMainhand();

        if (current != null && current.getItem() == AVP.items().itemM41A)
        {
            if (AVP.keybinds().specialPrimary.isPressed())
            {
                Game.setRightClickDelayTimer(20);
                AVP.network().sendToServer(new PacketLaunchGrenade());
            }
        }
    }
}
