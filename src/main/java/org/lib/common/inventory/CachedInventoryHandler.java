package org.lib.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Boston Vanseghi
 */
public class CachedInventoryHandler {

    public static final CachedInventoryHandler instance = new CachedInventoryHandler();

    private CachedInventoryHandler() {}

    private final HashMap<UUID, InventorySnapshot> cachedServerPlayerInventorySnapshots = new HashMap<>();
    private final HashMap<UUID, InventorySnapshot> cachedClientPlayerInventorySnapshots = new HashMap<>();

    @SubscribeEvent
    public void serverTickEvent(TickEvent.ServerTickEvent event) {
        cachedServerPlayerInventorySnapshots.clear();
    }

    @SubscribeEvent
    public void clientTickEvent(TickEvent.ClientTickEvent event) {
        cachedClientPlayerInventorySnapshots.clear();
    }

    public InventorySnapshot getInventorySnapshotForPlayer(EntityPlayer player) {
        if (!player.world.isRemote) {
            return cachedServerPlayerInventorySnapshots.computeIfAbsent(player.getUniqueID(), key -> {
                InventorySnapshot inventorySnapshot = new InventorySnapshot();
                inventorySnapshot.snapshot(player.inventory);
                return inventorySnapshot;
            });
        } else {
            return cachedClientPlayerInventorySnapshots.computeIfAbsent(player.getUniqueID(), key -> {
                InventorySnapshot inventorySnapshot = new InventorySnapshot();
                inventorySnapshot.snapshot(player.inventory);
                return inventorySnapshot;
            });
        }
    }
}
