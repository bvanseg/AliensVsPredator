package org.avp.item.crafting;

import net.minecraft.item.ItemStack;

public interface ISchematic
{
    public String getName();
    
    public ItemStack getItemStackAssembled();
    
    public ItemStack[] getItemsRequired();
}
