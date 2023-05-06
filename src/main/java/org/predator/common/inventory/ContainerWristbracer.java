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
import org.predator.common.PredatorItems;
import org.predator.common.item.*;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Ri5ux
 */
public class ContainerWristbracer extends Container {
    private final IInventory inventory;
    private final ItemStack stack;
    private final EntityPlayer player;

    private static class SlotWristbracer extends Slot {
        private SlotWristbracer(IInventory inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        // The wristbracer shouldn't ever hold items that aren't predator tech. It's not meant to be a storage device.
        @Override
        public boolean isItemValid(ItemStack stack) {
            return !(stack.getItem() instanceof ItemWristbracer) &&
                    (
                        stack.getItem() instanceof ItemPlasmaCannon ||
                        stack.getItem() instanceof ItemLaserMine ||
                        stack.getItem() instanceof ItemSpear ||
                        stack.getItem() instanceof ItemShuriken ||
                        stack.getItem() instanceof ItemDisc ||
                        stack.getItem() == PredatorItems.ITEM_WRISTBRACER_BLADES ||
                        stack.getItem() == PredatorItems.ITEM_ARTIFACT_TECH ||
                        stack.getItem() == PredatorItems.PICKAXE_CELTIC ||
                        stack.getItem() == PredatorItems.AXE_CELTIC ||
                        stack.getItem() == PredatorItems.SHOVEL_CELTIC ||
                        stack.getItem() == PredatorItems.SWORD_CELTIC ||
                        stack.getItem() == PredatorItems.HOE_CELTIC
                    );
        }
    }

    private static class SlotPlayerHotbar extends Slot {

        private SlotPlayerHotbar(IInventory inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        // Prevents the player from moving the source wristbracer for the container. Otherwise, duping glitches can occur.
        @Override
        public boolean canTakeStack(EntityPlayer playerIn) {
            return playerIn.getHeldItemMainhand() != this.getStack();
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
            addSlotToContainer(new SlotPlayerHotbar(player.inventory, x, 15 + (18 * x), 136));
        }

        this.loadFromNBT();
    }

    private static final String ID_NBT_KEY = "id";

    public void saveToNBT() {
        NBTTagCompound wristbracerTag = this.stack.getTagCompound();
        NBTTagList items = new NBTTagList();

        if (wristbracerTag == null) {
            wristbracerTag = new NBTTagCompound();
            wristbracerTag.setUniqueId(ID_NBT_KEY, UUID.randomUUID());
            this.stack.setTagCompound(wristbracerTag);
        }

        UUID wristbracerId = wristbracerTag.getUniqueId(ID_NBT_KEY);

        for (byte slot = 0; slot < this.inventory.getSizeInventory(); slot++) {
            ItemStack stk = this.inventory.getStackInSlot(slot);
            NBTTagCompound item = new NBTTagCompound();
            item.setByte(ItemWristbracer.TAG_WRISTBRACER_ITEMS_SLOT, slot);
            stk.writeToNBT(item);
            items.appendTag(item);
        }

        wristbracerTag.setTag(ItemWristbracer.TAG_WRISTBRACER_ITEMS, items);

        // Originally we were trying to save to the original stack stored as a field in this class, but that might cause
        // an inventory duping bug if the player moves the wristbracer around while the wristbracer's inventory is open.
        // The workaround here is to store a unique identifier to the wristbracer, and then once we save the wristbracer's NBT,
        // we find the stack again in case the player has moved it prior to saving.
        Optional<ItemStack> wristbracerStack = this.player.inventory.mainInventory.stream().filter(s -> {
            if (!s.hasTagCompound()) return false;
            NBTTagCompound tag = s.getTagCompound();
            if (tag == null) return false;
            UUID uuid = tag.getUniqueId(ID_NBT_KEY);
            if (uuid == null) return false;
            return uuid.equals(wristbracerId);
        }).findFirst();

        NBTTagCompound finalWristbracerTag = wristbracerTag;
        wristbracerStack.ifPresent(s -> s.setTagCompound(finalWristbracerTag));
    }

    public void loadFromNBT() {
        if (this.stack.getTagCompound() == null) return;

        NBTTagList items = this.stack.getTagCompound().getTagList(ItemWristbracer.TAG_WRISTBRACER_ITEMS, Constants.NBT.TAG_COMPOUND);

        for (byte x = 0; x < items.tagCount(); x++) {
            NBTTagCompound item = items.getCompoundTagAt(x);

            byte slot = item.getByte(ItemWristbracer.TAG_WRISTBRACER_ITEMS_SLOT);

            if (slot >= 0 && slot <= this.inventory.getSizeInventory()) {
                this.inventory.setInventorySlotContents(slot, new ItemStack(item));
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
