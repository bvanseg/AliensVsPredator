package org.avp.inventory;

import org.avp.tile.TileEntitySupplyCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSupplyCrate extends Container
{
    public EntityPlayer player;
    public TileEntitySupplyCrate supplyCrate;

    public ContainerSupplyCrate(EntityPlayer player, TileEntitySupplyCrate supplyCrate)
    {
        this.player = player;
        this.supplyCrate = supplyCrate;
        this.initialize();
        this.supplyCrate.setOpen(true);
    }

    public void initialize()
    {
        int index = 0;

        for (byte x = 0; x < 8; x++)
        {
            for (byte y = 0; y < this.supplyCrate.inventory.getSizeInventory() / 8; y++)
            {
                int index2 = index++;
                addSlotToContainer(new Slot(this.supplyCrate.inventory, index2, 14 + (18 * x), 26 + (18 * y)));
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
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        
        System.out.println(this.supplyCrate.inventory.getStackInSlot(0));

        this.supplyCrate.setOpen(false);
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
            else if (i != 36 || !this.mergeItemStack(stack, 36, 36 + (this.supplyCrate.inventory.getSizeInventory() - 1), false))
            {
                return null;

            }
            else
            {
                return null;
            }

            if (stack.getCount() == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            slot.onTake(null, stack);

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
