package org.avp.inventory;

import org.avp.tile.TileEntityRepulsionGenerator;

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
            addSlotToContainer(new Slot(this.generator.inventory, slot++, 134, y + 33));
        }

        for (byte s = 0; s < 9; s++)
        {
            addSlotToContainer(new Slot(player.inventory, s, 8 + (18 * s), 142));
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
            else if (i != 36 || !this.mergeItemStack(stack, 36, 36 + (this.generator.inventory.getSizeInventory() - 1), false))
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
