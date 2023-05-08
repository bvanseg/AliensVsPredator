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
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
