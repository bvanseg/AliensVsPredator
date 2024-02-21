package org.avp;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * @author Boston Vanseghi
 */
public class AVPItemGroups {
    public static final ItemGroup ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPItems.CPU.get());
        }
    };
}
