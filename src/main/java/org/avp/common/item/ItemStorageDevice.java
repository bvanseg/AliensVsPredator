package org.avp.common.item;

import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.nbt.NBTTagList;

public class ItemStorageDevice extends HookedItem
{
    private final NBTTagList storedNBTTags = new NBTTagList();

    public ItemStorageDevice() { /* Do Nothing */ }

    public NBTTagList getStoredNBTTags()
    {
        return storedNBTTags;
    }
}
