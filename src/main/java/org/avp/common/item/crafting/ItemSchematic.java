package org.avp.common.item.crafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemSchematic implements IItemSchematic
{
    private final String      id;
    private final ItemStack   item;
    private final ItemStack[] items;

    public ItemSchematic(String id, ItemStack item, ItemStack... items)
    {
        this.id = id;
        this.item = item;
        this.items = items;
    }

    public String getName()
    {
        return id;
    }

    public ItemStack getItemStackAssembled()
    {
        return item;
    }

    public ItemStack[] getItemsRequired()
    {
        return items;
    }

    public static boolean isComplete(ItemSchematic schematic, EntityPlayer player)
    {
        int progress = 0;
        int maxProgress = 0;

        for (ItemStack stack : schematic.getItemsRequired())
        {
            int amountOfStack = AssemblyManager.amountForMatchingStack(player, stack);
            maxProgress += stack.getCount();

            if (amountOfStack > 0)
            {
                progress += Math.min(amountOfStack, stack.getCount());
            }
        }

        return progress == maxProgress;
    }
}
