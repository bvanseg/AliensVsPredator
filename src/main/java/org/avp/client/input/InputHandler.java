package org.avp.client.input;

import com.asx.mdx.lib.util.Game;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.input.handler.InputHandlerFirearm;
import org.avp.client.input.handler.InputHandlerPlasmaCannon;
import org.avp.client.input.handler.InputHandlerPulseRifle;
import org.avp.client.input.handler.InputHandlerWristbracer;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class InputHandler
{
    public static final InputHandler instance      = new InputHandler();
    private ArrayList<IInputHandler> inputHandlers = null;

    public InputHandler()
    {
        this.inputHandlers = new ArrayList<IInputHandler>();
        this.inputHandlers.add(InputHandlerPlasmaCannon.instance);
        this.inputHandlers.add(InputHandlerFirearm.instance);
        this.inputHandlers.add(InputHandlerPulseRifle.instance);
        this.inputHandlers.add(InputHandlerWristbracer.instance);
    }

    @SubscribeEvent
    public void clientTick(ClientTickEvent event)
    {
        if (Game.minecraft().player != null)
        {
            for (IInputHandler ih : this.inputHandlers)
            {
                ih.handleInput();
            }
        }
    }
}
