package org.weapon.common.reload;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.avp.client.AVPSounds;
import org.weapon.common.PlayerHandKey;
import org.weapon.common.PlayerHandUseExecutableFuture;

import java.util.HashMap;

/**
 * @author Boston Vanseghi
 */
public class ReloadHandler {

    public static final ReloadHandler instance = new ReloadHandler();

    private static final HashMap<PlayerHandKey, PlayerHandUseExecutableFuture> scheduledClientReloads = new HashMap<>();
    private static final HashMap<PlayerHandKey, PlayerHandUseExecutableFuture> scheduledServerReloads = new HashMap<>();

    private ReloadHandler() {}

    @SubscribeEvent
    public void tickServerReloadEvents(TickEvent.ServerTickEvent event) {
        scheduledServerReloads.entrySet().removeIf(entry -> {
            PlayerHandUseExecutableFuture playerHandUseExecutableFuture = entry.getValue();
            boolean flag = playerHandUseExecutableFuture.getPlayer().world.getTotalWorldTime() > playerHandUseExecutableFuture.getWorldTimeToRunAt();
            if (flag) {
                playerHandUseExecutableFuture.getRunnable().run();
            }
            return flag;
        });
    }

    @SubscribeEvent
    public void tickClientReloadEvents(TickEvent.ClientTickEvent event) {
        scheduledClientReloads.entrySet().removeIf(entry -> {
            PlayerHandUseExecutableFuture playerHandUseExecutableFuture = entry.getValue();
            boolean flag = playerHandUseExecutableFuture.getPlayer().world.getTotalWorldTime() > playerHandUseExecutableFuture.getWorldTimeToRunAt();
            if (flag) {
                playerHandUseExecutableFuture.getRunnable().run();
            }
            return flag;
        });
    }

    public void scheduleReload(EntityPlayer player, EnumHand hand, Runnable reloadTask, long worldTimeToRunAt) {
        PlayerHandKey playerHandKey = new PlayerHandKey(player, hand);
        PlayerHandUseExecutableFuture playerHandUseExecutableFuture = new PlayerHandUseExecutableFuture(player, hand, reloadTask, worldTimeToRunAt);

        // If server-side and the player is not already reloading this hand, schedule a reload.
        if (!player.world.isRemote) {
            scheduledServerReloads.computeIfAbsent(playerHandKey, key -> {
                player.world.playSound(null, player.getPosition(), AVPSounds.WEAPON_RELOAD.event(), SoundCategory.NEUTRAL, 1F, 1F);
                return playerHandUseExecutableFuture;
            });
        }
        // If client-side and the player is not already reloading this hand, schedule a reload.
        else {
            scheduledClientReloads.computeIfAbsent(playerHandKey, key -> {
                player.world.playSound(null, player.getPosition(), AVPSounds.WEAPON_RELOAD.event(), SoundCategory.NEUTRAL, 1F, 1F);
                return playerHandUseExecutableFuture;
            });
        }
    }

    public boolean isReloading(EntityPlayer player, EnumHand enumHand) {
        PlayerHandKey playerHandKey = new PlayerHandKey(player, enumHand);
        if (!player.world.isRemote) {
            return scheduledServerReloads.containsKey(playerHandKey);
        } else {
            return scheduledClientReloads.containsKey(playerHandKey);
        }
    }
}
