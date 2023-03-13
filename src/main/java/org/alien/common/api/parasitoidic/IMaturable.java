package org.alien.common.api.parasitoidic;

import net.minecraft.entity.Entity;

public interface IMaturable
{
    public Class<? extends Entity> getMatureState();
    
    public void mature();
    
    public boolean isReadyToMature(IRoyalOrganism ro);
    
    public int getMaturityLevel();
    
    public int getMaturityTime();
}
