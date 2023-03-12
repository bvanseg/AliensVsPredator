package org.avp.common.world.worldgen;

import java.util.ArrayList;

import org.avp.common.api.storage.IWorldSaveHandler;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class DerelictWorldData implements IWorldSaveHandler
{
    public static final DerelictWorldData instance = new DerelictWorldData();
    private ArrayList<DerelictLocation> derelictLocations;

    public DerelictWorldData()
    {
        this.derelictLocations = new ArrayList<DerelictLocation>();
    }

    public boolean saveData(World world, NBTTagCompound tag)
    {
        if (tag != null)
        {
            NBTTagCompound tagDerelictLocations = new NBTTagCompound();

            if (this.getDerelictLocations() != null)
            {
                if (!this.getDerelictLocations().isEmpty())
                {
                    for (int i = 0; i < 3; i++)
                    {
                        DerelictLocation derelictLocation = this.getDerelictLocations().get(i);

                        if (derelictLocation != null)
                        {
                            derelictLocation.save(tagDerelictLocations);
                        }
                    }

                    tag.setTag("DerelictLocations", tagDerelictLocations);
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }

        return true;
    }

    public boolean loadData(World world, NBTTagCompound tag)
    {
        if (tag != null)
        {
            NBTTagCompound tagDerelictLocations = tag.getCompoundTag("DerelictLocations");

            for (int i = 0; i < 3; i++)
            {
                DerelictLocation derelictLocation = this.derelictLocations.size() - 1 >= i ? this.derelictLocations.get(i) : null;

                if (derelictLocation == null)
                {
                    this.derelictLocations.add(new DerelictLocation(false, i));
                }

                if (derelictLocation != null)
                {
                    derelictLocation.load(tagDerelictLocations);
                }
            }
        }
        else
        {
            return false;
        }

        return true;
    }

    public ArrayList<DerelictLocation> getDerelictLocations()
    {
        return derelictLocations;
    }
}
