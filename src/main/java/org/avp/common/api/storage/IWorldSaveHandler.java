package org.avp.common.api.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public interface IWorldSaveHandler
{
    boolean saveData(World world, NBTTagCompound nbt);
    
    boolean loadData(World world, NBTTagCompound nbt);
}
