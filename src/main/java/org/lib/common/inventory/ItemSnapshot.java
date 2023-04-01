package org.lib.common.inventory;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Boston Vanseghi
 */
public class ItemSnapshot {

    private final Item item;

    private final HashMap<Integer, ItemStack> slots;

    public ItemSnapshot(Item item) {
        this.item = item;
        this.slots = new HashMap<>();
    }

    public void updateSlotWithStack(int slot, ItemStack itemStack) {
        this.slots.put(slot, itemStack);
    }

    public int getTotalCount() {
        int i = 0;
        for (Map.Entry<Integer, ItemStack> entry: this.slots.entrySet()) {
            i += entry.getValue().getCount();
        }
        return i;
    }

    public Item getItem() {
        return this.item;
    }

    public Set<Integer> getSlots() {
        return this.slots.keySet();
    }
}
