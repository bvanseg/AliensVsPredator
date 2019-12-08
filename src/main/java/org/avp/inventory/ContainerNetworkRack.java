package org.avp.inventory;

import org.avp.tile.TileEntityNetworkRack;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerNetworkRack extends Container
{
    public EntityPlayer          player;
    public TileEntityNetworkRack rack;

    public ContainerNetworkRack(EntityPlayer player, TileEntityNetworkRack rack)
    {
        this.player = player;
        this.rack = rack;
        this.initialize();
    }

    public void initialize()
    {
        for (byte slot = 0; slot < this.rack.inventory.getSizeInventory(); slot++)
        {
            addSlotToContainer(new Slot(this.rack.inventory, slot, 26, 19 + (22 * slot)));
        }
        
        for (byte slot = 0; slot < 9; slot++)
        {
            addSlotToContainer(new Slot(player.inventory, slot, 8 + (18 * slot), 109));
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory iinventory)
    {
        super.onCraftMatrixChanged(iinventory);
    }

    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        Slot slot = getSlot(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            int inventoryLastSlot = this.rack.inventory.getSizeInventory() - 1;
            int containerLastSlot = this.inventorySlots.size() - 1;
            System.out.println(this.rack.inventory.getSizeInventory());
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
                if (!this.mergeItemStack(stack, 0, inventoryLastSlot + 1, false))
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
