package org.lib.common.inventory;

import net.minecraft.item.Item;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class ItemDropTable {

    private final List<Pair<Object, Integer>> droppablesWithWeight;

    private ItemDropTable() {
        this.droppablesWithWeight = new ArrayList<>();
    }

    public List<Pair<Object, Integer>> getDroppablesWithWeight() {
        return this.droppablesWithWeight;
    }

    public int getSumOfWeights() {
        int i = 0;
        for (Pair<Object, Integer> droppableWithWeight: this.droppablesWithWeight) {
            i += droppableWithWeight.getRight();
        }
        return i;
    }

    public int[] getCumulativeSummedWeights() {
        int[] summedWeights = new int[this.droppablesWithWeight.size()];

        int index = 0;
        int currentSum = 0;
        for (Pair<Object, Integer> droppableWithWeight: this.droppablesWithWeight) {
            currentSum += droppableWithWeight.getRight();
            summedWeights[index] = currentSum;
            index++;
        }

        return summedWeights;
    }

    public static final class Builder {
        private final ItemDropTable table;

        public Builder() {
            this.table = new ItemDropTable();
        }

        public Builder addItemDrop(Item item, int weight) {
            return this.addItemDrop(new ItemDrop.Builder(item).build(), weight);
        }

        public Builder addItemDrop(ItemDrop itemDrop, int weight) {
            this.table.droppablesWithWeight.add(Pair.of(itemDrop, weight));
            return this;
        }

        public Builder addItemDropSet(ItemDropTable table, int weight) {
            this.table.droppablesWithWeight.add(Pair.of(table, weight));
            return this;
        }

        public ItemDropTable build() {
            return this.table;
        }
    }
}
