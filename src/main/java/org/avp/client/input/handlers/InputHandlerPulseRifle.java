package org.avp.client.input.handlers;

import org.avp.AliensVsPredator;
import org.avp.client.input.IInputHandler;
import org.avp.packets.server.PacketLaunchGrenade;

import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.item.ItemStack;

public class InputHandlerPulseRifle implements IInputHandler
{
    public static final InputHandlerPulseRifle instance = new InputHandlerPulseRifle();

    @Override
    public void handleInput()
    {
        ItemStack current = Game.minecraft().player.getHeldItemMainhand();

        if (current != null && current.getItem() == AliensVsPredator.items().itemM41A)
        {
            if (AliensVsPredator.keybinds().specialPrimary.isPressed())
            {
                Game.setRightClickDelayTimer(20);
                AliensVsPredator.network().sendToServer(new PacketLaunchGrenade());
            }
        }
    }
}
