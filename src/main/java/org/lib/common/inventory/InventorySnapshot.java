package org.lib.common.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.lib.common.FuncUtil;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Boston Vanseghi
 */
public class InventorySnapshot {

    private final HashMap<Item, ItemSnapshot> itemSnapshots;

    // Map of ore dictionary IDs to item snapshots.
    private final HashMap<String, Set<ItemSnapshot>> itemSnapshotsByOreDictId = new HashMap<>();

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

            ItemSnapshot itemSnapshot = itemSnapshots.computeIfAbsent(itemStack.getItem(), ItemSnapshot::new);
            itemSnapshot.updateSlotWithStack(i, itemStack);

            int[] ids = OreDictionary.getOreIDs(itemStack);

            for (int id : ids) {
                String sharedName = OreDictionary.getOreName(id);
                itemSnapshotsByOreDictId.computeIfAbsent(sharedName, key -> new HashSet<>()).add(itemSnapshot);
            }
        }
    }

    private int getOreDictItemCount(Item item) {
        return this.getOreDictItemCount(new ItemStack(item, 1));
    }

    public int getOreDictItemCount(ItemStack itemStack) {
        return this.getItemSnapshotsWithOreDict(itemStack).stream().mapToInt(ItemSnapshot::getTotalCount).sum();
    }

    public Set<ItemSnapshot> getItemSnapshotsWithOreDict(Item item) {
        return this.getItemSnapshotsWithOreDict(new ItemStack(item, 1));
    }

    public Set<ItemSnapshot> getItemSnapshotsWithOreDict(ItemStack itemStack) {
        int[] ids = OreDictionary.getOreIDs(itemStack);

        HashSet<ItemSnapshot> snapshots = new HashSet<>();

        for (int id: ids) {
            String sharedName = OreDictionary.getOreName(id);
            Set<ItemSnapshot> oreDictSnapshots = itemSnapshotsByOreDictId.getOrDefault(sharedName, Collections.emptySet());
            snapshots.addAll(oreDictSnapshots);
        }

        FuncUtil.let(itemSnapshots.get(itemStack.getItem()), snapshots::add);

        return snapshots;
    }

    public boolean hasItem(Item item) {
        return this.getOreDictItemCount(item) > 0;
    }

    public Set<Item> getItemsMatchingPredicate(Predicate<Item> itemPredicate) {
        return itemSnapshots.keySet().stream().filter(itemPredicate).collect(Collectors.toSet());
    }

    public int getTotalCountForItem(Item item) {
        return this.getOreDictItemCount(item);
    }

    public int getNextNonEmptySlot(Item item) {
        Set<ItemSnapshot> snapshots = this.getItemSnapshotsWithOreDict(item);

        if (snapshots.isEmpty() || snapshots.stream().allMatch(snapshot -> snapshot.getSlots().isEmpty())) {
            return -1;
        }

        List<Integer> slots = snapshots.stream().map(ItemSnapshot::getSlots).flatMap(Set::stream).collect(Collectors.toList());

        for (int i : slots) {
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
