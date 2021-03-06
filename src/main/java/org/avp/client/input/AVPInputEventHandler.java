package org.avp.client.input;

import com.asx.mdx.client.ClientGame;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.predator.client.input.handler.InputHandlerPlasmaCannon;
import org.predator.client.input.handler.InputHandlerWristbracer;
import org.weapon.client.input.handler.InputHandlerFirearm;
import org.weapon.client.input.handler.InputHandlerPulseRifle;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class AVPInputEventHandler
{
    public static final AVPInputEventHandler instance      = new AVPInputEventHandler();
    private ArrayList<InputHandler> inputHandlers = null;

    public AVPInputEventHandler()
    {
        this.inputHandlers = new ArrayList<>();
        this.inputHandlers.add(InputHandlerPlasmaCannon.instance);
        this.inputHandlers.add(InputHandlerFirearm.instance);
        this.inputHandlers.add(InputHandlerPulseRifle.instance);
        this.inputHandlers.add(InputHandlerWristbracer.instance);
    }

    @SubscribeEvent
    public void clientTick(ClientTickEvent event)
    {
        if (ClientGame.instance.minecraft().player != null)
        {
            for (InputHandler ih : this.inputHandlers)
            {
                ih.handleInput();
            }
        }
    }
}
