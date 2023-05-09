package org.weapon.client.input.handler;

import com.asx.mdx.client.ClientGame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumHand;
import org.avp.client.KeybindHandler;
import org.avp.client.input.InputHandler;
import org.avp.common.AVPNetworking;
import org.weapon.common.delay.DelayHandler;
import org.weapon.common.item.firearm.ItemFirearm;
import org.weapon.common.network.packet.server.PacketReloadFirearm;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class InputHandlerFirearm implements InputHandler
{
    public static final InputHandlerFirearm instance   = new InputHandlerFirearm();

    @Override
    public void handleInput()
    {
        EntityPlayer player = ClientGame.instance.minecraft().player;

        if (player == null) return;
        if (!ClientGame.instance.minecraft().inGameHasFocus) return;
        if (!KeybindHandler.instance.specialSecondary.isPressed()) return;

        handleReload(player, EnumHand.MAIN_HAND);
        handleReload(player, EnumHand.OFF_HAND);
    }

    private static void handleReload(EntityPlayer player, EnumHand hand) {
        Item handItem = player.getHeldItem(hand).getItem();

        if (!(handItem instanceof ItemFirearm)) return;

        ItemFirearm firearm = (ItemFirearm) handItem;
        long reloadTime = player.world.getTotalWorldTime() + firearm.getFirearmProperties().getReloadTimeInTicks();
        DelayHandler.instance.setDelay(player, hand, reloadTime);
        AVPNetworking.instance.sendToServer(new PacketReloadFirearm());
    }
}
