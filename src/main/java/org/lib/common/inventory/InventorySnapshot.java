package org.lib.common.inventory;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.HashMap;

/**
 * @author Boston Vanseghi
 */
public class InventorySnapshot {

    private final HashMap<Item, ItemSnapshot> itemSnapshots;

    private IInventory inventory;

    public InventorySnapshot() {
        this.itemSnapshots = new HashMap<>();
    }

    public void snapshot(IInventory inventory) {
        // Clear before updating with fresh data.
        itemSnapshots.clear();

        // Store a reference to the inventory we are taking a snapshot of.
        this.inventory = inventory;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);

            if (itemStack.getCount() <= 0 || itemStack == ItemStack.EMPTY) {
                continue;
            }

            itemSnapshots.computeIfAbsent(itemStack.getItem(), ItemSnapshot::new).updateSlotWithStack(i, itemStack);
        }
    }

    public boolean hasItem(Item item) {
        return itemSnapshots.containsKey(item) && itemSnapshots.get(item).getTotalCount() > 0;
    }

    public int getTotalCountForItem(Item item) {
        ItemSnapshot snapshot = itemSnapshots.get(item);
        return snapshot != null ? snapshot.getTotalCount() : 0;
    }

    public int getNextNonEmptySlot(Item item) {
        ItemSnapshot snapshot = itemSnapshots.get(item);
        if (snapshot == null || snapshot.getSlots().isEmpty()) return -1;

        for (int i : snapshot.getSlots()) {
            if (!this.inventory.getStackInSlot(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }

    public @Nullable ItemStack getFirstNonEmptyStack(Item item) {
        return inventory.getStackInSlot(this.getNextNonEmptySlot(item));
    }

    public void consumeItem(Item item) {
        this.consumeItem(item, 1);
    }

    public void consumeItem(Item item, int consumeAmount) {
        // Ensure that we do not over-consume past the item total.
        int start = Math.min(consumeAmount, this.getTotalCountForItem(item));

        while (start > 0) {
            int slot = this.getNextNonEmptySlot(item);
            ItemStack itemStack = inventory.getStackInSlot(slot);

            int subAmount = Math.min(start, itemStack.getCount());
            start -= subAmount;
            itemStack.shrink(subAmount);

            if (itemStack.getCount() <= 0) {
                // Update inventory reference.
                inventory.setInventorySlotContents(slot, ItemStack.EMPTY);
                // Update item snapshot cache.
                this.itemSnapshots.compute(item, (key, value) -> {
                    if (value != null) {
                        value.updateSlotWithStack(slot, ItemStack.EMPTY);
                    }
                    return value;
                });
            }
        }
    }
}
