package org.alien.common.api.parasitoidic;

public interface RoyalOrganism
{
    void setJellyLevel(int level);
    
    void produceJelly();
    
    boolean canProduceJelly();
    
    int getJellyLevel();
    
    int getJellyProductionRate();
}
