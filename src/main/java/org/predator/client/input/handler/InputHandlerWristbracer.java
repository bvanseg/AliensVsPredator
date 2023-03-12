package org.predator.client.input.handler;

import com.asx.mdx.lib.util.Game;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.avp.AVP;
import org.predator.client.gui.GuiWristbracer;
import org.avp.client.input.IInputHandler;
import org.avp.common.network.packet.server.PacketOpenContainer;

public class InputHandlerWristbracer implements IInputHandler
{
    public static final InputHandlerWristbracer instance = new InputHandlerWristbracer();

    @Override
    public void handleInput()
    {
        if (Game.minecraft().currentScreen instanceof GuiInventory || Game.minecraft().currentScreen instanceof GuiContainerCreative)
        {
            if (!(Game.minecraft().currentScreen instanceof GuiWristbracer))
            {
                if (Game.minecraft().player.getHeldItemMainhand() != null && Game.minecraft().player.getHeldItemMainhand().getItem() == AVP.items().itemWristbracer)
                {
                    AVP.network().sendToServer(new PacketOpenContainer(AVP.interfaces().GUI_WRISTBRACER));
                }
            }
        }
    }
}
