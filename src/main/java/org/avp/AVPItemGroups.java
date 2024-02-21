package org.avp;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.avp.common.item.AVPArmorItems;
import org.avp.common.item.AVPElectronicItems;
import org.avp.common.item.AVPFoodItems;
import org.avp.common.item.AVPItems;

/**
 * @author Boston Vanseghi
 */
public class AVPItemGroups {
    public static final ItemGroup ARMOR_ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".armor") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPArmorItems.CELTIC_HELMET.get());
        }
    };
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
