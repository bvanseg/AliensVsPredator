package org.alien.common.api.parasitoidic;

import net.minecraft.entity.Entity;

public interface IMaturable
{
    Class<? extends Entity> getMatureState();
    
    void mature();
    
    boolean isReadyToMature(IRoyalOrganism ro);
    
    int getMaturityLevel();
    
    int getMaturityTime();
}
