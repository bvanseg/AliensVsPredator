package org.avp.common.item.expansion;

import org.avp.common.inventory.ContainerTurret.ITurretAmmunition;
import org.weapon.common.item.firearm.Classification;
import org.weapon.common.item.firearm.ItemAmmunition;

public class ItemSMGAmmo extends ItemAmmunition implements ITurretAmmunition
{
    public ItemSMGAmmo()
    {
        super(Classification.SUB_MACHINE_GUN);
    }
}
