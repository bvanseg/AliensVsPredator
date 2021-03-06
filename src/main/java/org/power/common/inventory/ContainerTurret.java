package org.power.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.avp.common.item.init.AVPItems;
import org.power.common.tile.TileEntityTurret;

public class ContainerTurret extends Container
{
    private final TileEntityTurret tile;
    
    public interface ITurretUpgrade {}
    
    public interface ITurretAmmunition {}

    public static class SlotDigitalStorage extends Slot
    {
        public SlotDigitalStorage(IInventory inventoryIn, int index, int xPosition, int yPosition)
        {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack stack)
        {
            if (stack.getItem() == AVPItems.ITEM_FLASH_DRIVE)
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

        for (byte x = 0; x < this.tile.getAmmoHelper().inventoryAmmo.getSizeInventory(); x++)
        {
            this.addSlotToContainer(new SlotAmmunition(tile.getAmmoHelper().inventoryAmmo, x, 33 + 18 * x, 114));

            ItemStack stack = this.tile.getAmmoHelper().inventoryAmmo.getStackInSlot(x);

            if (stack != null)
            {
                this.tile.getAmmoHelper().inventoryAmmo.setInventorySlotContents(x, stack);
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

        for (int id = 0; id < this.tile.getAmmoHelper().inventoryAmmo.getSizeInventory(); id++)
        {
            this.tile.getAmmoHelper().inventoryAmmo.setInventorySlotContents(id, this.tile.getAmmoHelper().inventoryAmmo.getStackInSlot(id));
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
                else if (itemstack.getItem() == AVPItems.ITEM_FLASH_DRIVE)
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
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    public IInventory getAmmoBay()
    {
        return this.tile.getAmmoHelper().inventoryAmmo;
    }
}
