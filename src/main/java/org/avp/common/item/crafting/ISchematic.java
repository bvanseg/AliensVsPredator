package org.avp.common.item.crafting;

import net.minecraft.item.ItemStack;

public interface ISchematic
{
    String getName();
    
    ItemStack getItemStackAssembled();
    
    ItemStack[] getItemsRequired();
}
