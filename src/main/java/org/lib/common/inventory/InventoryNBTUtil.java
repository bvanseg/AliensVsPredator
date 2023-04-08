package org.lib.common.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

/**
 * @author Boston Vanseghi
 */
public class InventoryNBTUtil {

    private InventoryNBTUtil() {}

    public static NBTTagCompound writeInventoryToNBT(String key, IInventory inventory) {
        NBTTagCompound tagCompound = new NBTTagCompound();
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < inventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack = inventory.getStackInSlot(i);

            if (!itemstack.isEmpty())
            {
                nbttaglist.appendTag(itemstack.writeToNBT(new NBTTagCompound()));
            }
        }

        tagCompound.setTag(key, nbttaglist);
        return tagCompound;
    }

    public static void readInventoryFromNBT(String key, NBTTagCompound inventoryTag, IInventory inventory) {
        NBTTagList tagList = inventoryTag.getTagList(key, Constants.NBT.TAG_COMPOUND);

        for (int i = 0; i < inventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack = new ItemStack(tagList.getCompoundTagAt(i));
            inventory.setInventorySlotContents(i, itemstack);
        }
    }
}
