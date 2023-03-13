package org.alien.common.api.parasitoidic;

public interface IRoyalOrganism
{
    public void setJellyLevel(int level);
    
    public void produceJelly();
    
    public boolean canProduceJelly();
    
    public int getJellyLevel();
    
    public int getJellyProductionRate();
}
