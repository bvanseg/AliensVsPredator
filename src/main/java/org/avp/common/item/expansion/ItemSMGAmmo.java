package org.avp.common.item.expansion;

import org.avp.common.inventory.ContainerTurret.ITurretAmmunition;
import org.avp.common.item.firearms.Classification;
import org.avp.common.item.firearms.ItemAmmunition;

public class ItemSMGAmmo extends ItemAmmunition implements ITurretAmmunition
{
    public ItemSMGAmmo()
    {
        super(Classification.SUB_MACHINE_GUN);
    }
}
