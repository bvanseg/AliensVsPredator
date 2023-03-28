package org.lib.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Boston Vanseghi
 */
public class CachedInventoryHandler {

    public static final CachedInventoryHandler instance = new CachedInventoryHandler();

    private CachedInventoryHandler() {}

    private final HashMap<UUID, InventorySnapshot> cachedPlayerInventorySnapshots = new HashMap<>();

    @SubscribeEvent
    public void worldTickEvent(TickEvent.WorldTickEvent event) {
        cachedPlayerInventorySnapshots.clear();
    }

    public @Nullable InventorySnapshot getInventorySnapshotForPlayer(EntityPlayer player) {
        return cachedPlayerInventorySnapshots.computeIfAbsent(player.getUniqueID(), key -> {
            InventorySnapshot inventorySnapshot = new InventorySnapshot();
            inventorySnapshot.snapshot(player.inventory);
            return inventorySnapshot;
        });
    }
}
