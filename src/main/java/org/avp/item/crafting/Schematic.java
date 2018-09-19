package org.avp.item.crafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Schematic implements ISchematic
{
    private String      id;
    private ItemStack   item;
    private ItemStack[] items;

    public Schematic(String id, ItemStack item, ItemStack... items)
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

    public static boolean isComplete(Schematic schematic, EntityPlayer player)
    {
        int progress = 0;
        int maxProgress = 0;

        for (ItemStack stack : schematic.getItemsRequired())
        {
            int amountOfStack = AssemblyManager.amountForMatchingStack(player, stack);
            maxProgress += stack.getCount();

            if (amountOfStack > 0)
            {
                progress += amountOfStack > stack.getCount() ? stack.getCount() : amountOfStack;
            }
        }

        return progress == maxProgress;
    }
}
