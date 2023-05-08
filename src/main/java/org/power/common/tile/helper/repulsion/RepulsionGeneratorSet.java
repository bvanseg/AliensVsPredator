package org.power.common.tile.helper.repulsion;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.HashMap;

/**
 * @author Boston Vanseghi
 */
public class RepulsionGeneratorSet {

    private final InventoryBasic inventory;
    private float proposedSpeed;

    private SetType setType;

    private final HashMap<Integer, ItemStack> set = new HashMap<>();

    public RepulsionGeneratorSet(InventorySetType inventorySetType) {
        this.inventory = new InventoryBasic("container.repulsiongenerator.slots." + inventorySetType.name().toLowerCase(), true, 5);
        this.setType = SetType.EMPTY;
    }

    public void update() {
        set.clear();

        for (int i = 0; i < this.inventory.getSizeInventory(); i++) {
            ItemStack stack = this.inventory.getStackInSlot(i);
            set.put(i, stack);
        }

        this.setType = SetType.getSetType(this.set);

        switch (this.setType) {
            case FULL:
                this.proposedSpeed = 5;
                break;
            case UNSTABLE:
                this.proposedSpeed = 2.5F;
                break;
            default:
                this.proposedSpeed = 0F;
        }
    }

    public InventoryBasic getInventory() {
        return this.inventory;
    }

    public float getProposedSpeed() {
        return this.proposedSpeed;
    }

    public void writeToNBT(NBTTagCompound nbt) {
        this.saveInventoryToNBT(nbt, this.inventory);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        this.readInventoryFromNBT(nbt, this.inventory);
    }

    private void saveInventoryToNBT(NBTTagCompound nbt, IInventory inventory) {
        NBTTagList items = new NBTTagList();

        for (byte x = 0; x < inventory.getSizeInventory(); x++) {
            ItemStack stack = inventory.getStackInSlot(x);

            NBTTagCompound item = new NBTTagCompound();
            item.setByte("Slot", x);
            stack.writeToNBT(item);
            items.appendTag(item);
        }

        nbt.setTag(inventory.getName(), items);
    }

    private void readInventoryFromNBT(NBTTagCompound nbt, IInventory inventory) {
        NBTTagList items = nbt.getTagList(inventory.getName(), Constants.NBT.TAG_COMPOUND);

        for (byte x = 0; x < items.tagCount(); x++) {
            NBTTagCompound item = items.getCompoundTagAt(x);

            byte slot = item.getByte("Slot");

            if (slot >= 0 && slot <= inventory.getSizeInventory()) {
                inventory.setInventorySlotContents(slot, new ItemStack(item));
            }
        }
    }
}
