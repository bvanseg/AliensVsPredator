package org.avp.common.api.power;

public interface IMachine
{
    int getMachineDamage();

    int getMaxMachineDamage();

    void damageMachine(int amount);
    
    int repairMachine(int amount);
}
