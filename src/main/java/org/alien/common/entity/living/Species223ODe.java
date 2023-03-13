package org.alien.common.entity.living;

import net.minecraft.world.World;

// This class only exists to disable acid spawning, it shouldn't exist.
@Deprecated
public abstract class Species223ODe extends SpeciesAlien
{
    public Species223ODe(World world)
    {
        super(world);
    }
    
    @Override
    protected void spawnAcidPool() { /* Do Nothing */ }
}
