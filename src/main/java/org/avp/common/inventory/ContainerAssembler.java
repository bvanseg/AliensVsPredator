package org.avp.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.avp.common.tile.TileEntityAssembler;

public class ContainerAssembler extends Container
{
    private TileEntityAssembler tile;

    public ContainerAssembler(InventoryPlayer invPlayer, TileEntityAssembler assembler, int posX, int posY, int posZ)
    {
        this.tile = assembler;

        /** Add the 9 hotbar slots to the container **/
        for (byte x = 0; x < 9; x++)
        {
            addSlotToContainer(new Slot(invPlayer, x, 28 + 18 * x, 146));
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
            else if (i != 36 || !this.mergeItemStack(stack, 36, 36 + (tile.getSizeInventory() - 1), false))
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
        return tile.isUsableByPlayer(player);
    }
}
