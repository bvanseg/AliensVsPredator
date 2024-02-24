package org.avp;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.avp.common.block.AVPTempleBlocks;
import org.avp.common.item.*;

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
    public static final ItemGroup BLOCK_ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPTempleBlocks.TEMPLE_BRICK.get());
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

    public static final ItemGroup MISCELLANEOUS_ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPItems.ROYAL_JELLY.get());
        }
    };
    public static final ItemGroup WEAPON_ITEM_GROUP = new ItemGroup(AVPConstants.MOD_ID + ".weapons") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPWeaponItems.WEAPON_M41A_PULSE_RIFLE.get());
        }
    };
}
