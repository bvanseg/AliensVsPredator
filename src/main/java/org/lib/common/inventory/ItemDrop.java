package org.lib.common.inventory;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

/**
 * @author Boston Vanseghi
 */
public class ItemDrop {

    private final Item item;

    private int dropWeight;
    private int minimumDropAmount;
    private int maximumDropAmount;

    private ItemDrop(Item item) {
        this.item = item;
        this.dropWeight = 100;
        this.minimumDropAmount = 1;
        this.maximumDropAmount = 1;
    }

    public Item getItem() {
        return this.item;
    }

    public int getDropWeight() {
        return this.dropWeight;
    }

    public int getMinimumDropAmount() {
        return this.minimumDropAmount;
    }

    public int getMaximumDropAmount() {
        return this.maximumDropAmount;
    }

    public static class Builder {
        private final ItemDrop itemDrop;

        public Builder(Block block) {
            this(Item.getItemFromBlock(block));
        }

        public Builder(Item item) {
            this.itemDrop = new ItemDrop(item);
        }

        public Builder setDropWeight(int dropWeight) {
            itemDrop.dropWeight = MathHelper.clamp(dropWeight, 1, 100);
            return this;
        }

        public Builder setMinimumDropAmount(int minimumDropAmount) {
            itemDrop.minimumDropAmount = Math.max(1, minimumDropAmount);
            itemDrop.maximumDropAmount = Math.max(minimumDropAmount, itemDrop.maximumDropAmount);
            return this;
        }

        public Builder setMaximumDropAmount(int maximumDropAmount) {
            itemDrop.maximumDropAmount = Math.min(1, maximumDropAmount);
            itemDrop.minimumDropAmount = Math.min(maximumDropAmount, itemDrop.minimumDropAmount);
            return this;
        }

        public Builder setDropAmountRange(int minimumDropAmount, int maximumDropAmount) {
            this.setMinimumDropAmount(minimumDropAmount);
            this.setMaximumDropAmount(maximumDropAmount);
            return this;
        }

        public ItemDrop build() {
            return this.itemDrop;
        }
    }
}
