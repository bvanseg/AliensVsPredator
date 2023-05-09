package org.power.common.tile.helper.repulsion;

import net.minecraft.item.ItemStack;
import org.avp.common.item.init.AVPItems;

import java.util.Map;

/**
 * @author Boston Vanseghi
 */
public enum SetType {
    FULL,
    UNSTABLE,
    EMPTY;

    public static SetType getSetType(Map<Integer, ItemStack> set) {
        if (isFullSet(set)) {
            return SetType.FULL;
        } else if (isEmptySet(set)) {
            return SetType.EMPTY;
        }

        return SetType.UNSTABLE;
    }

    private static boolean isEmptySet(Map<Integer, ItemStack> set) {
        return set.get(0) == null &&
                set.get(1) == null &&
                set.get(2) == null &&
                set.get(3) == null;
    }

    private static boolean isFullSet(Map<Integer, ItemStack> set) {
        return set.get(0) != null &&
                set.get(1) != null &&
                set.get(2) != null &&
                set.get(3) != null &&
                set.get(0).getItem() == AVPItems.ITEM_NEODYMIUM_MAGNET &&
                (set.get(1)).getItem() == AVPItems.ITEM_NEODYMIUM_MAGNET &&
                (set.get(2)).getItem() == AVPItems.ITEM_NEODYMIUM_MAGNET &&
                (set.get(3)).getItem() == AVPItems.ITEM_NEODYMIUM_MAGNET;
    }
}
