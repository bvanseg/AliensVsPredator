package org.avp.common.item.crafting;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public class AssemblyResult {

    private final EntityPlayer player;
    private final Schematic schematic;
    private final boolean canAssemble;

    private final int desiredAmount;

    private AssemblyResult(EntityPlayer player, Schematic schematic, boolean canAssemble, int desiredAmount) {
        this.player = player;
        this.schematic = schematic;
        this.canAssemble = canAssemble;
        this.desiredAmount = desiredAmount;
    }

    public void assemble() {
        if (!canAssemble) return;

        // TODO: Instead of using a for loop here, just create itemStacks with the desired amount (if stackable).
        for (int i = 0; i < this.desiredAmount; i++) {
            ItemStack assembledStack = schematic.getItemStackAssembled().copy();
            if (!player.inventory.addItemStackToInventory(assembledStack))
            {
                new EntityItem(player.world, player.posX, player.posY, player.posZ, assembledStack);
            }
        }
    }

    public boolean canAssembleSchematic() {
        return canAssemble;
    }

    public static AssemblyResult getResult(EntityPlayer player, Schematic schematic, int desiredAmount) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(schematic);

        // Players should always be able to assemble in creative mode.
        if (player.isCreative())
            return new AssemblyResult(player, schematic, true, desiredAmount);

        // The required items to craft the schematic.
        ItemStack[] itemsRequired = schematic.getItemsRequired();

        // For every requirement, check if the player has the required count.
        for (ItemStack requirement : itemsRequired) {
            // Return if any of the items required are invalid.
            if (requirement == null || requirement == ItemStack.EMPTY || requirement.getCount() <= 0) {
                return new AssemblyResult(player, schematic, false, desiredAmount);
            }

            Item requiredItem = AssemblyManager.findInventoryItemStackMatchOreDict(player, requirement).getItem();

            if (Inventories.getAmountOfItemPlayerHas(requiredItem, player) < requirement.getCount() * desiredAmount) {
                return new AssemblyResult(player, schematic, false, desiredAmount);
            }
        }

        return new AssemblyResult(player, schematic, true, desiredAmount);
    }

    public static int getMaximumPossibleAssembleCount(EntityPlayer player, Schematic schematic) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(schematic);

        // Players should always be able to assemble in creative mode.
        if (player.isCreative())
            return Integer.MAX_VALUE;

        // The required items to craft the schematic.
        ItemStack[] itemsRequired = schematic.getItemsRequired();

        int mostThatCanBeAssembled = Integer.MAX_VALUE;

        // For every requirement, check if the player has the required count.
        for (ItemStack requirement : itemsRequired) {
            // Return if any of the items required are invalid.
            if (requirement == null || requirement == ItemStack.EMPTY || requirement.getCount() <= 0) {
                return 0;
            }

            Item requiredItem = AssemblyManager.findInventoryItemStackMatchOreDict(player, requirement).getItem();

            int amountPlayerHas = Inventories.getAmountOfItemPlayerHas(requiredItem, player);
            mostThatCanBeAssembled = Math.min(mostThatCanBeAssembled, amountPlayerHas / requirement.getCount());
        }

        return mostThatCanBeAssembled;
    }
}
