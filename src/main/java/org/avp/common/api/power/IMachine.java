package org.avp.common.api.power;

public interface IMachine
{
    public int getMachineDamage();

    public int getMaxMachineDamage();

    public void damageMachine(int amount);
    
    public int repairMachine(int amount);
}
