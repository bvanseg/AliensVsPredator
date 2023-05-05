package org.predator.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import org.predator.common.item.ItemWristbracer;

/**
 * @author Ri5ux
 */
public class ContainerWristbracer extends Container {
    private final IInventory inventory;
    private final ItemStack stack;
    private final EntityPlayer player;

    public static class SlotWristbracer extends Slot {
        public SlotWristbracer(IInventory inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return !(stack.getItem() instanceof ItemWristbracer);
        }
    }

    public ContainerWristbracer(EntityPlayer player) {
        this.inventory = new InventoryBasic("container.wristbracer.slots", true, 5);
        this.stack = player.getHeldItemMainhand();
        this.player = player;
        this.initialize();
    }

    public void initialize() {
        for (byte x = 0; x < this.inventory.getSizeInventory(); x++) {
            addSlotToContainer(new SlotWristbracer(inventory, x, 31 + (28 * x), 16));
        }

        for (byte x = 0; x < 9; x++) {
            addSlotToContainer(new Slot(player.inventory, x, 15 + (18 * x), 136));
        }

        this.loadFromNBT();
    }

    public void saveToNBT() {
        NBTTagCompound wristbracerTag = this.stack.getTagCompound();
        NBTTagList items = new NBTTagList();

        if (wristbracerTag == null) {
            wristbracerTag = new NBTTagCompound();
        }

        for (byte slot = 0; slot < this.inventory.getSizeInventory(); slot++) {
            ItemStack stk = this.inventory.getStackInSlot(slot);
            NBTTagCompound item = new NBTTagCompound();
            item.setByte(ItemWristbracer.TAG_WRISTBRACER_ITEMS_SLOT, slot);
            stk.writeToNBT(item);
            items.appendTag(item);
        }

        wristbracerTag.setTag(ItemWristbracer.TAG_WRISTBRACER_ITEMS, items);
        this.stack.setTagCompound(wristbracerTag);
    }

    public void loadFromNBT() {
        if (this.stack != null && this.stack.getTagCompound() != null) {
            NBTTagList items = this.stack.getTagCompound().getTagList(ItemWristbracer.TAG_WRISTBRACER_ITEMS, Constants.NBT.TAG_COMPOUND);

            for (byte x = 0; x < items.tagCount(); x++) {
                NBTTagCompound item = items.getCompoundTagAt(x);

                byte slot = item.getByte(ItemWristbracer.TAG_WRISTBRACER_ITEMS_SLOT);

                if (slot >= 0 && slot <= this.inventory.getSizeInventory()) {
                    this.inventory.setInventorySlotContents(slot, new ItemStack(item));
                }
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        Slot slot = getSlot(slotIndex);

        if (slot.getHasStack()) {
            int inventoryLastSlot = this.inventory.getSizeInventory() - 1;
            int containerLastSlot = this.inventorySlots.size() - 1;
            ItemStack slotStack = slot.getStack();
            ItemStack result = slotStack.copy();

            if (slotIndex <= inventoryLastSlot) {
                if (!this.mergeItemStack(slotStack, inventoryLastSlot + 1, containerLastSlot + 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.mergeItemStack(slotStack, 0, inventoryLastSlot, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (slotStack.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            slot.onTake(player, slotStack);

            return result;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        this.saveToNBT();
    }
}
