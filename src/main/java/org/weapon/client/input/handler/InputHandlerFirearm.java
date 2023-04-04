package org.weapon.client.input.handler;

import com.asx.mdx.client.ClientGame;
import net.minecraft.item.Item;
import org.avp.client.KeybindHandler;
import org.avp.client.input.InputHandler;
import org.avp.common.AVPNetworking;
import org.weapon.common.item.firearm.ItemFirearm;
import org.weapon.common.network.packet.server.PacketReloadFirearm;

public class InputHandlerFirearm implements InputHandler
{
    public static final InputHandlerFirearm instance   = new InputHandlerFirearm();
    private int                             lastReload = 0;

    @Override
    public void handleInput()
    {
        if (ClientGame.instance.minecraft().player != null)
        {
            this.lastReload++;
            
            Item mainHand = ClientGame.instance.minecraft().player.getHeldItemMainhand().getItem();
            Item offHand = ClientGame.instance.minecraft().player.getHeldItemOffhand().getItem();

            if (ClientGame.instance.minecraft().inGameHasFocus && mainHand != null && mainHand instanceof ItemFirearm)
            {
                ItemFirearm fireArm = (ItemFirearm) mainHand;

                if (KeybindHandler.instance.specialSecondary.isPressed() && this.lastReload > fireArm.getFirearmProperties().getReloadTimeInTicks())
                {
                    this.lastReload = 0;
                    AVPNetworking.instance.sendToServer(new PacketReloadFirearm());
                }
            }
            else if (ClientGame.instance.minecraft().inGameHasFocus && offHand != null && offHand instanceof ItemFirearm)
            {
            	ItemFirearm fireArm = (ItemFirearm) offHand;

                if (KeybindHandler.instance.specialSecondary.isPressed() && this.lastReload > fireArm.getFirearmProperties().getReloadTimeInTicks())
                {
                    this.lastReload = 0;
                    AVPNetworking.instance.sendToServer(new PacketReloadFirearm());
                }
            }
        }
    }
}
