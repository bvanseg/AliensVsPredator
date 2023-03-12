package org.avp.common.inventory;

import org.avp.common.tile.TileEntityRepulsionGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerRepulsionGenerator extends Container
{
    public EntityPlayer                 player;
    public TileEntityRepulsionGenerator generator;

    public ContainerRepulsionGenerator(EntityPlayer player, TileEntityRepulsionGenerator generator)
    {
        this.player = player;
        this.generator = generator;
        this.initialize();
    }

    public void initialize()
    {
        int offset = 53;
        int slot = 0;

        for (int i = 1; i >= 0; i--)
        {
            int y = offset * i;
            addSlotToContainer(new Slot(this.generator.inventory, slot++, 26, y + 33));
            addSlotToContainer(new Slot(this.generator.inventory, slot++, 60, y + 20));
            addSlotToContainer(new Slot(this.generator.inventory, slot++, 94, y + 33));
            addSlotToContainer(new Slot(this.generator.inventory, slot++, 60, y + 46));
            addSlotToContainer(new Slot(this.generator.inventory, slot++, 134, y + 33) {
                @Override
                public boolean isItemValid(ItemStack stack)
                {
                    if (this.getSlotIndex() == 4 || this.getSlotIndex() == 9)
                    {
                        return false;
                    }
                    
                    return super.isItemValid(stack);
                }
            });
        }
        
        slot = 0;

        for (byte s = 0; s < 9; s++)
        {
            int tmp = 0;
            addSlotToContainer(new Slot(player.inventory, tmp = slot++, 8 + (18 * s), 142));
            System.out.println(tmp);
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory iinventory)
    {
        super.onCraftMatrixChanged(iinventory);
        this.generator.markDirty();
    }

    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        this.generator.markDirty();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        Slot slot = getSlot(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            int inventoryLastSlot = this.generator.inventory.getSizeInventory() - 1;
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
