package org.avp.common.item;

import com.asx.mdx.lib.world.item.HookedItem;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ItemStorageDevice extends HookedItem
{
    private NBTTagList storedNBTTags = new NBTTagList();

    public ItemStorageDevice()
    {
        ;
    }

    public NBTTagList getStoredNBTTags()
    {
        return storedNBTTags;
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5)
    {
        super.onUpdate(itemstack, world, entity, par4, par5);
    }
}
