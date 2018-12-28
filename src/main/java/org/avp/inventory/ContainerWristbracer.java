package org.avp.inventory;

import org.avp.item.ItemWristbracer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class ContainerWristbracer extends Container
{
    public IInventory   inventory;
    public ItemStack    stack;
    public EntityPlayer player;
    
    public static class SlotWristbracer extends Slot
    {
        public SlotWristbracer(IInventory inventoryIn, int index, int xPosition, int yPosition)
        {
            super(inventoryIn, index, xPosition, yPosition);
        }
        
        @Override
        public boolean isItemValid(ItemStack stack)
        {
            return stack != null && !(stack.getItem() instanceof ItemWristbracer);
        }
    }

    public ContainerWristbracer(EntityPlayer player)
    {
        this.inventory = new InventoryBasic("container.wristbracer.slots", true, 5);
        this.stack = player.getHeldItemMainhand();
        this.player = player;
        this.initialize();
    }

    public void initialize()
    {
        for (byte x = 0; x < this.inventory.getSizeInventory(); x++)
        {
            addSlotToContainer(new SlotWristbracer(inventory, x, 31 + (28 * x), 16));
        }

        for (byte x = 0; x < 9; x++)
        {
            addSlotToContainer(new Slot(player.inventory, x, 15 + (18 * x), 136));
        }

        this.loadFromNBT();
    }

    public NBTTagCompound saveToNBT()
    {
        if (player.getHeldItemMainhand() != null)
        {
            NBTTagCompound wristbracerTag = player.getHeldItemMainhand().getTagCompound();
            NBTTagList items = new NBTTagList();

            if (wristbracerTag == null)
            {
                wristbracerTag = new NBTTagCompound();
            }

            for (byte slot = 0; slot < this.inventory.getSizeInventory(); slot++)
            {
                ItemStack stack = this.inventory.getStackInSlot(slot);

                if (stack != null)
                {
                    NBTTagCompound item = new NBTTagCompound();
                    item.setByte(ItemWristbracer.TAG_WRISTBRACER_ITEMS_SLOT, slot);
                    stack.writeToNBT(item);
                    items.appendTag(item);
                }
            }

            wristbracerTag.setTag(ItemWristbracer.TAG_WRISTBRACER_ITEMS, items);
            player.getHeldItemMainhand().setTagCompound(wristbracerTag);
            return wristbracerTag;
        }

        return null;
    }

    public NBTTagCompound loadFromNBT()
    {
        if (stack != null && stack.getTagCompound() != null)
        {
            NBTTagList items = stack.getTagCompound().getTagList(ItemWristbracer.TAG_WRISTBRACER_ITEMS, Constants.NBT.TAG_COMPOUND);

            for (byte x = 0; x < items.tagCount(); x++)
            {
                NBTTagCompound item = items.getCompoundTagAt(x);

                byte slot = item.getByte(ItemWristbracer.TAG_WRISTBRACER_ITEMS_SLOT);

                if (slot >= 0 && slot <= this.inventory.getSizeInventory())
                {
                    this.inventory.setInventorySlotContents(slot, new ItemStack(item));
                }
            }
        }

        return stack.getTagCompound();
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        Slot slot = getSlot(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            int inventoryLastSlot = this.inventory.getSizeInventory() - 1;
            int containerLastSlot = this.inventorySlots.size() - 1;
            ItemStack stack = slot.getStack();
            ItemStack result = stack.copy();
            
            if (slotIndex <= inventoryLastSlot)
            {
                if (!this.mergeItemStack(stack, inventoryLastSlot + 1, containerLastSlot + 1, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else
            {
                if (!this.mergeItemStack(stack, 0, inventoryLastSlot, false))
                {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            slot.onTake(player, stack);

            return result;
        }

        return ItemStack.EMPTY;
    }
    
    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        this.saveToNBT();
    }
}
