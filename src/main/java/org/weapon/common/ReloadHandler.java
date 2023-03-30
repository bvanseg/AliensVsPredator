package org.weapon.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.avp.client.AVPSounds;

import java.util.HashMap;

/**
 * @author Boston Vanseghi
 */
public class ReloadHandler {

    public static final ReloadHandler instance = new ReloadHandler();

    private static final HashMap<ReloadKey, ReloadData> scheduledClientReloads = new HashMap<>();
    private static final HashMap<ReloadKey, ReloadData> scheduledServerReloads = new HashMap<>();

    private ReloadHandler() {}

    @SubscribeEvent
    public void tickServerReloadEvents(TickEvent.ServerTickEvent event) {
        scheduledServerReloads.entrySet().removeIf(entry -> {
            ReloadData reloadData = entry.getValue();
            boolean flag = reloadData.getPlayer().world.getTotalWorldTime() > reloadData.getWorldTimeToRunAt();
            if (flag) {
                reloadData.getRunnable().run();
            }
            return flag;
        });
    }

    @SubscribeEvent
    public void tickClientReloadEvents(TickEvent.ClientTickEvent event) {
        scheduledClientReloads.entrySet().removeIf(entry -> {
            ReloadData reloadData = entry.getValue();
            boolean flag = reloadData.getPlayer().world.getTotalWorldTime() > reloadData.getWorldTimeToRunAt();
            if (flag) {
                reloadData.getRunnable().run();
            }
            return flag;
        });
    }

    public void scheduleReload(EntityPlayer player, EnumHand hand, Runnable reloadTask, long worldTimeToRunAt) {
        ReloadKey reloadKey = new ReloadKey(player, hand);
        ReloadData reloadData = new ReloadData(player, hand, reloadTask, worldTimeToRunAt);

        // If server-side and the player is not already reloading this hand, schedule a reload.
        if (!player.world.isRemote) {
            scheduledServerReloads.computeIfAbsent(reloadKey, key -> {
                player.world.playSound(null, player.getPosition(), AVPSounds.WEAPON_RELOAD.event(), SoundCategory.NEUTRAL, 1F, 1F);
                return reloadData;
            });
        }
        // If client-side and the player is not already reloading this hand, schedule a reload.
        else {
            scheduledClientReloads.computeIfAbsent(reloadKey, key -> {
                player.world.playSound(null, player.getPosition(), AVPSounds.WEAPON_RELOAD.event(), SoundCategory.NEUTRAL, 1F, 1F);
                return reloadData;
            });
        }
    }

    public boolean isReloading(EntityPlayer player, EnumHand enumHand) {
        ReloadKey reloadKey = new ReloadKey(player, enumHand);
        if (!player.world.isRemote) {
            return scheduledServerReloads.containsKey(reloadKey);
        } else {
            return scheduledClientReloads.containsKey(reloadKey);
        }
    }
}
