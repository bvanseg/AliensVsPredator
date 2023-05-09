package org.power.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.power.common.tile.TileEntityRepulsionGenerator;
import org.power.common.tile.helper.repulsion.InventorySetType;

/**
 * @author Ri5ux
 */
public class ContainerRepulsionGenerator extends Container {
    private final EntityPlayer player;
    public final TileEntityRepulsionGenerator generator;

    public ContainerRepulsionGenerator(EntityPlayer player, TileEntityRepulsionGenerator generator) {
        this.player = player;
        this.generator = generator;
        this.initialize();
    }

    public void initialize() {
        this.initializeMagnetSetSlots();
        this.initializePlayerHotbarSlots();
    }

    private void initializeMagnetSetSlots() {
        int offset = 53;
        for (int i = 0; i < InventorySetType.values().length; i++) {
            int y = offset * i;
            int slot = 0;
            InventoryBasic inventory = this.generator.getInventory(InventorySetType.values()[i]);
            addSlotToContainer(new Slot(inventory, slot++, 26, y + 33));
            addSlotToContainer(new Slot(inventory, slot++, 60, y + 20));
            addSlotToContainer(new Slot(inventory, slot++, 94, y + 33));
            addSlotToContainer(new Slot(inventory, slot++, 60, y + 46));
            addSlotToContainer(new Slot(inventory, slot, 134, y + 33) {
                @Override
                public boolean isItemValid(ItemStack stack) {
                    if (this.getSlotIndex() == 4 || this.getSlotIndex() == 9) {
                        return false;
                    }

                    return super.isItemValid(stack);
                }
            });
        }
    }

    private void initializePlayerHotbarSlots() {
        for (int s = 0; s < 9; s++) {
            addSlotToContainer(new Slot(player.inventory, s, 8 + (18 * s), 142));
        }
    }

    @Override
    public void onCraftMatrixChanged(IInventory iinventory) {
        super.onCraftMatrixChanged(iinventory);
        this.generator.markDirty();
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        this.generator.markDirty();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        Slot slot = getSlot(slotIndex);

        if (!slot.getHasStack()) return ItemStack.EMPTY;

        ItemStack stack = slot.getStack();
        ItemStack result = stack.copy();

        int inventoryLastSlot = this.generator.getInventory(InventorySetType.PRIMARY).getSizeInventory() - 1;
        int secondaryInventoryLastSlot = (this.generator.getInventory(InventorySetType.SECONDARY).getSizeInventory() * 2) - 1;
        int containerLastSlot = this.inventorySlots.size() - 1;

        if (slotIndex <= inventoryLastSlot)
        {
            if (!this.mergeItemStack(stack, secondaryInventoryLastSlot + 1, containerLastSlot + 1, false))
            {
                return ItemStack.EMPTY;
            }
        }

        if (slotIndex <= secondaryInventoryLastSlot)
        {
            if (!this.mergeItemStack(stack, secondaryInventoryLastSlot + 1, containerLastSlot + 1, false))
            {
                return ItemStack.EMPTY;
            }
        }
        else
        {
            if (!this.mergeItemStack(stack, 0, secondaryInventoryLastSlot, false))
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

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
