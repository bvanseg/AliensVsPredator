package org.avp.common.item.crafting;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;

import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public class AssemblyResult {

    private final EntityPlayer player;
    private final ItemSchematic schematic;
    private final boolean canAssemble;

    private final int desiredAmount;

    private AssemblyResult(EntityPlayer player, ItemSchematic schematic, boolean canAssemble, int desiredAmount) {
        this.player = player;
        this.schematic = schematic;
        this.canAssemble = canAssemble;
        this.desiredAmount = desiredAmount;
    }

    public void assemble() {
        if (!this.canAssemble) return;
        ItemStack assembledItemStack = this.schematic.getItemStackAssembled();

        // Consume Items
        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(this.player);
        for (ItemStack requirement: schematic.getItemsRequired()) {
            int cost = requirement.getCount() * this.desiredAmount;
            inventorySnapshot.consumeItem(requirement.getItem(), cost);
        }

        ItemStack resultingItemStack = new ItemStack(assembledItemStack.getItem(), assembledItemStack.getCount() * this.desiredAmount);

        // If we failed to add the item to the player's inventory, drop it on the ground at their feet.
        if (!player.inventory.addItemStackToInventory(resultingItemStack)) {
            this.dropItemFromPlayer(resultingItemStack);
        }
    }

    private void dropItemFromPlayer(ItemStack resultingItemStack) {
        EntityItem entityitem = this.player.dropItem(resultingItemStack, false);

        if (entityitem != null)
        {
            entityitem.setNoPickupDelay();
            entityitem.setOwner(this.player.getName());
        }
    }

    public boolean canAssembleSchematic() {
        return this.canAssemble;
    }

    public static AssemblyResult getResult(EntityPlayer player, ItemSchematic schematic, int desiredAmount) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(schematic);

        // Players should always be able to assemble in creative mode.
        if (player.isCreative())
            return new AssemblyResult(player, schematic, true, desiredAmount);

        // The required items to craft the schematic.
        ItemStack[] itemsRequired = schematic.getItemsRequired();
        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

        // For every requirement, check if the player has the required count.
        for (ItemStack requirement : itemsRequired) {
            // Return if any of the items required are invalid.
            if (requirement == null || requirement == ItemStack.EMPTY || requirement.getCount() <= 0) {
                return new AssemblyResult(player, schematic, false, desiredAmount);
            }

            int requiredItemCountPlayerHas = inventorySnapshot.getOreDictItemCount(requirement);

            if (requiredItemCountPlayerHas < requirement.getCount() * desiredAmount) {
                return new AssemblyResult(player, schematic, false, desiredAmount);
            }
        }

        return new AssemblyResult(player, schematic, true, desiredAmount);
    }

    public static int getMaximumPossibleAssembleCount(EntityPlayer player, ItemSchematic schematic) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(schematic);

        // Players should always be able to assemble in creative mode.
        if (player.isCreative())
            return Integer.MAX_VALUE;

        // The required items to craft the schematic.
        ItemStack[] itemsRequired = schematic.getItemsRequired();
        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

        int mostThatCanBeAssembled = Integer.MAX_VALUE;

        // For every requirement, check if the player has the required count.
        for (ItemStack requirement : itemsRequired) {
            // Return if any of the items required are invalid.
            if (requirement == null || requirement == ItemStack.EMPTY || requirement.getCount() <= 0) {
                return 0;
            }

            int requiredItemCountPlayerHas = inventorySnapshot.getOreDictItemCount(requirement);
            mostThatCanBeAssembled = Math.min(mostThatCanBeAssembled, requiredItemCountPlayerHas / requirement.getCount());
        }

        return mostThatCanBeAssembled;
    }
}
