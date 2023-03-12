package org.avp.common.item.crafting;

import net.minecraft.item.ItemStack;

public interface ISchematic
{
    public String getName();
    
    public ItemStack getItemStackAssembled();
    
    public ItemStack[] getItemsRequired();
}
