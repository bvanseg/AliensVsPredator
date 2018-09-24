package org.avp.inventory;

import org.avp.tile.TileEntityLocker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLocker extends Container
{
    public IInventory       inventory;
    public EntityPlayer     player;
    public TileEntityLocker locker;

    public ContainerLocker(EntityPlayer player, TileEntityLocker locker)
    {
        this.inventory = locker.inventory;
        this.player = player;
        this.locker = locker;
        this.initialize();
        this.locker.setOpen(true);
    }

    public void initialize()
    {
        int index = 0;

        for (byte x = 0; x < 8; x++)
        {
            for (byte y = 0; y < this.inventory.getSizeInventory() / 8; y++)
            {
                addSlotToContainer(new Slot(inventory, index++, 14 + (18 * x), 26 + (18 * y)));
            }
        }

        for (byte x = 0; x < 9; x++)
        {
            addSlotToContainer(new Slot(player.inventory, x, 5 + (18 * x), 182));
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory iinventory)
    {
        super.onCraftMatrixChanged(iinventory);
    }

    @Override
    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        super.onContainerClosed(par1EntityPlayer);

        this.locker.inventory = this.inventory;
        this.locker.setOpen(!this.locker.isOpen());
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
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

}
