package org.weapon.common.delay;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.weapon.common.PlayerHandKey;
import org.weapon.common.PlayerHandUseFuture;

import java.util.HashMap;

/**
 * @author Boston Vanseghi
 */
public class DelayHandler {
    public static final DelayHandler instance = new DelayHandler();

    // Used to manage the fire delay in-between shots.
    private static final HashMap<PlayerHandKey, PlayerHandUseFuture> clientFireDelays = new HashMap<>();
    private static final HashMap<PlayerHandKey, PlayerHandUseFuture> serverFireDelays = new HashMap<>();

    private DelayHandler() {}

    @SubscribeEvent
    public void tickServerDelayEvent(TickEvent.ServerTickEvent event) {
        serverFireDelays.entrySet().removeIf(entry -> {
            PlayerHandUseFuture playerHandUseFuture = entry.getValue();
            return playerHandUseFuture.getPlayer().world.getTotalWorldTime() > playerHandUseFuture.getWorldTimeToRunAt();
        });
    }

    @SubscribeEvent
    public void tickClientDelayEvent(TickEvent.ClientTickEvent event) {
        clientFireDelays.entrySet().removeIf(entry -> {
            PlayerHandUseFuture playerHandUseFuture = entry.getValue();
            return playerHandUseFuture.getPlayer().world.getTotalWorldTime() > playerHandUseFuture.getWorldTimeToRunAt();
        });
    }

    public void setDelay(EntityPlayer player, EnumHand hand, long delay) {
        // If the delay difference is zero, do not bother setting a delay.
        if (player.world.getTotalWorldTime() == delay) return;

        PlayerHandKey playerHandKey = new PlayerHandKey(player, hand);
        PlayerHandUseFuture playerHandUseFuture = new PlayerHandUseFuture(player, hand, delay);

        if (!player.world.isRemote) {
            serverFireDelays.putIfAbsent(playerHandKey, playerHandUseFuture);
        } else {
            clientFireDelays.putIfAbsent(playerHandKey, playerHandUseFuture);
        }
    }

    public boolean hasDelay(EntityPlayer player, EnumHand hand) {
        PlayerHandKey playerHandKey = new PlayerHandKey(player, hand);

        if (!player.world.isRemote) {
            return serverFireDelays.containsKey(playerHandKey);
        } else {
            return clientFireDelays.containsKey(playerHandKey);
        }
    }
}
