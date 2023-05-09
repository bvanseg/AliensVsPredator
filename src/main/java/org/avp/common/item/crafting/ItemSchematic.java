package org.avp.common.item.crafting;

import net.minecraft.item.ItemStack;

public class ItemSchematic implements IItemSchematic
{
    private final String      id;
    private final ItemStack   item;
    private final ItemStack[] items;

    public ItemSchematic(ItemStack item, ItemStack... items)
    {
        this.id = item.getItem().getRegistryName().getPath();
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
}
