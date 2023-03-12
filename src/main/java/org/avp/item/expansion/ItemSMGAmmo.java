package org.avp.item.expansion;

import org.avp.inventory.ContainerTurret.ITurretAmmunition;
import org.avp.item.firearms.Classification;
import org.avp.item.firearms.ItemAmmunition;

public class ItemSMGAmmo extends ItemAmmunition implements ITurretAmmunition
{
    public ItemSMGAmmo()
    {
        super(Classification.SUB_MACHINE_GUN);
    }
}
