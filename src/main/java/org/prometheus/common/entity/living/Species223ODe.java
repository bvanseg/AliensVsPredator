package org.prometheus.common.entity.living;

import net.minecraft.world.World;
import org.alien.common.entity.living.SpeciesAlien;

// This class only exists to disable acid spawning, it shouldn't exist.
@Deprecated
public abstract class Species223ODe extends SpeciesAlien
{
    protected Species223ODe(World world)
    {
        super(world);
    }
    
    @Override
    protected void spawnAcidPool() { /* Do Nothing */ }
}
