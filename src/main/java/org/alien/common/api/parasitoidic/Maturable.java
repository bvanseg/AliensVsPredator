package org.alien.common.api.parasitoidic;

import net.minecraft.entity.Entity;

public interface Maturable
{
    Class<? extends Entity> getMatureState();
    
    void mature();
    
    boolean isReadyToMature(RoyalOrganism ro);
    
    int getMaturityLevel();
    
    int getMaturityTime();
}
