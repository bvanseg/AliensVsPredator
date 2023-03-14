package org.avp.common.item.expansion;

import org.avp.common.inventory.ContainerTurret.ITurretAmmunition;
import org.avp.common.item.firearm.Classification;
import org.avp.common.item.firearm.ItemAmmunition;

public class ItemSMGAmmo extends ItemAmmunition implements ITurretAmmunition
{
    public ItemSMGAmmo()
    {
        super(Classification.SUB_MACHINE_GUN);
    }
}
