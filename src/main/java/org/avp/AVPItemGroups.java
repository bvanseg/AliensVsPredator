package org.avp;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * @author Boston Vanseghi
 */
public class AVPItemGroups {
    public static final ItemGroup ELECTRONICS_ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".electronics") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPElectronicItems.CPU.get());
        }
    };
    public static final ItemGroup FOOD_ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".food") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPFoodItems.DORITOS.get());
        }
    };

    public static final ItemGroup ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPItems.ROYAL_JELLY.get());
        }
    };
}
