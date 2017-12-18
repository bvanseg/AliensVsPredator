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
            addSlotToContainer(new Slot(this.rack.inventory, slot, 5, 26 + (18 * slot)));
        }
        
        for (byte slot = 0; slot < 9; slot++)
        {
            addSlotToContainer(new Slot(player.inventory, slot, 5 + (18 * slot), 182));
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
    public ItemStack transferStackInSlot(EntityPlayer player, int i)
    {
        Slot slot = getSlot(i);

        if (slot != null && slot.getHasStack())
        {
            ItemStack stack = slot.getStack();
            ItemStack result = stack.copy();

            if (i >= 36)
            {
                if (!super.mergeItemStack(stack, 0, 36, false))
                {
                    return null;

                }
            }
            else if (i != 36 || !this.mergeItemStack(stack, 36, 36 + (this.rack.inventory.getSizeInventory() - 1), false))
            {
                return null;

            }
            else
            {
                return null;
            }

            if (stack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            slot.onPickupFromSlot(null, stack);

            return result;
        }

        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
