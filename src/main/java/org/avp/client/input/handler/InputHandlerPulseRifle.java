package org.avp.client.input.handler;

import com.asx.mdx.lib.util.Game;
import net.minecraft.item.ItemStack;
import org.avp.AVP;
import org.avp.client.input.IInputHandler;
import org.avp.common.AVPItems;
import org.avp.common.network.packet.server.PacketLaunchGrenade;

public class InputHandlerPulseRifle implements IInputHandler
{
    public static final InputHandlerPulseRifle instance = new InputHandlerPulseRifle();

    @Override
    public void handleInput()
    {
        ItemStack current = Game.minecraft().player.getHeldItemMainhand();

        if (current != null && current.getItem() == AVPItems.ITEM_M41A)
        {
            if (AVP.keybinds().specialPrimary.isPressed())
            {
                Game.setRightClickDelayTimer(20);
                AVP.network().sendToServer(new PacketLaunchGrenade());
            }
        }
    }
}
