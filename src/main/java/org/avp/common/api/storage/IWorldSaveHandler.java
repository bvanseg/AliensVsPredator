package org.avp.common.api.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public interface IWorldSaveHandler
{
    public boolean saveData(World world, NBTTagCompound nbt);
    
    public boolean loadData(World world, NBTTagCompound nbt);
}
