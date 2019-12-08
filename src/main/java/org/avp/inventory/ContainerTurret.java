package org.avp.inventory;

import org.avp.item.ItemStorageDevice;
import org.avp.tile.TileEntityTurret;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerTurret extends Container
{
    private TileEntityTurret tile;
    
    public static interface ITurretUpgrade
    {
        ;
    }
    
    public static interface ITurretAmmunition
    {
        ;
    }

    public static class SlotDigitalStorage extends Slot
    {
        public SlotDigitalStorage(IInventory inventoryIn, int index, int xPosition, int yPosition)
        {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack)
        {
            if (stack.getItem() instanceof ItemStorageDevice)
            {
                return true;
            }

            return false;
        }
    }

    public static class SlotExpansion extends Slot
    {
        public SlotExpansion(IInventory inventoryIn, int index, int xPosition, int yPosition)
        {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack)
        {
            if (stack.getItem() instanceof ITurretUpgrade)
            {
                return true;
            }

            return false;
        }
    }

    public static class SlotAmmunition extends Slot
    {
        public SlotAmmunition(IInventory inventoryIn, int index, int xPosition, int yPosition)
        {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack)
        {
            if (stack.getItem() instanceof ITurretAmmunition)
            {
                return true;
            }

            return false;
        }
    }

    public ContainerTurret(EntityPlayer player, TileEntityTurret turret, World world, int posX, int posY, int posZ)
    {
        this.tile = turret;

        for (byte x = 0; x < 9; x++)
        {
            this.addSlotToContainer(new Slot(player.inventory, x, 33 + 18 * x, 141));
        }

        this.addSlotToContainer(new SlotDigitalStorage(tile.inventoryDrive, 0, 161, 21));

        for (byte x = 0; x < this.tile.inventoryExpansion.getSizeInventory(); x++)
        {
            this.addSlotToContainer(new SlotExpansion(tile.inventoryExpansion, x, 146 + 25 * x, 62));

            ItemStack stack = this.tile.inventoryExpansion.getStackInSlot(x);

            if (stack != null)
            {
                this.tile.inventoryExpansion.setInventorySlotContents(x, stack);
            }
        }

        for (byte x = 0; x < this.tile.inventoryAmmo.getSizeInventory(); x++)
        {
            this.addSlotToContainer(new SlotAmmunition(tile.inventoryAmmo, x, 33 + 18 * x, 114));

            ItemStack stack = this.tile.inventoryAmmo.getStackInSlot(x);

            if (stack != null)
            {
                this.tile.inventoryAmmo.setInventorySlotContents(x, stack);
            }
        }
    }

    @Override
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

        for (int id = 0; id < tile.inventoryExpansion.getSizeInventory(); id++)
        {
            this.tile.inventoryExpansion.setInventorySlotContents(id, this.tile.inventoryExpansion.getStackInSlot(id));
        }

        for (int id = 0; id < this.tile.inventoryAmmo.getSizeInventory(); id++)
        {
            this.tile.inventoryAmmo.setInventorySlotContents(id, this.tile.inventoryAmmo.getStackInSlot(id));
        }

        tile.applyUpgrades();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotId)
    {
        Slot slot = (Slot) this.inventorySlots.get(slotId);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack = slot.getStack();

            if (slotId <= 8)
            {
                if (itemstack.getItem() instanceof ITurretAmmunition)
                {
                    if (!this.mergeItemStack(itemstack, 13, 22, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (itemstack.getItem() instanceof ItemStorageDevice)
                {
                    if (!this.mergeItemStack(itemstack, 9, 10, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (itemstack.getItem() instanceof ITurretUpgrade)
                {
                    if (!this.mergeItemStack(itemstack, 10, 13, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
            }
            else
            {
                if (!this.mergeItemStack(itemstack, 0, 8, false))
                {
                    return ItemStack.EMPTY;
                }
            }

            if (itemstack.getCount() == 0)
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            slot.onTake(player, itemstack);

            return ItemStack.EMPTY;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player)
    {
        return super.slotClick(slotId, dragType, clickTypeIn, player);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    public IInventory getAmmoBay()
    {
        return this.tile.inventoryAmmo;
    }
}
