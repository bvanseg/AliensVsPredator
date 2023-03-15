package org.avp.client.input.handler;

import com.asx.mdx.lib.util.Game;
import net.minecraft.item.Item;
import org.avp.AVP;
import org.avp.client.input.IInputHandler;
import org.avp.common.AVPNetworking;
import org.avp.common.item.firearm.ItemFirearm;
import org.avp.common.network.packet.server.PacketReloadFirearm;

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
            
            Item mainHand = Game.minecraft().player.getHeldItemMainhand().getItem();
            Item offHand = Game.minecraft().player.getHeldItemOffhand().getItem();

            if (Game.minecraft().inGameHasFocus && mainHand != null && mainHand instanceof ItemFirearm)
            {
                ItemFirearm fireArm = (ItemFirearm) mainHand;

                if (AVP.keybinds().specialSecondary.isPressed() && this.lastReload > fireArm.getProfile().getReloadTime())
                {
                    this.lastReload = 0;
                    AVPNetworking.instance.sendToServer(new PacketReloadFirearm());
                }
            }
            else if (Game.minecraft().inGameHasFocus && offHand != null && offHand instanceof ItemFirearm)
            {
            	ItemFirearm fireArm = (ItemFirearm) offHand;

                if (AVP.keybinds().specialSecondary.isPressed() && this.lastReload > fireArm.getProfile().getReloadTime())
                {
                    this.lastReload = 0;
                    AVPNetworking.instance.sendToServer(new PacketReloadFirearm());
                }
            }
        }
    }
}
