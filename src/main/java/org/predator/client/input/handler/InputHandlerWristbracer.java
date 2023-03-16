package org.predator.client.input.handler;

import com.asx.mdx.client.ClientGame;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.avp.AVP;
import org.avp.client.input.IInputHandler;
import org.avp.common.network.packet.server.PacketOpenContainer;
import org.predator.client.gui.GuiWristbracer;
import org.predator.common.PredatorItems;

public class InputHandlerWristbracer implements IInputHandler
{
    public static final InputHandlerWristbracer instance = new InputHandlerWristbracer();

    @Override
    public void handleInput()
    {
        if (ClientGame.instance.minecraft().currentScreen instanceof GuiInventory || ClientGame.instance.minecraft().currentScreen instanceof GuiContainerCreative)
        {
            if (!(ClientGame.instance.minecraft().currentScreen instanceof GuiWristbracer))
            {
                if (ClientGame.instance.minecraft().player.getHeldItemMainhand() != null && ClientGame.instance.minecraft().player.getHeldItemMainhand().getItem() == PredatorItems.ITEM_WRISTBRACER)
                {
                    AVP.network().sendToServer(new PacketOpenContainer(AVP.interfaces().GUI_WRISTBRACER));
                }
            }
        }
    }
}
