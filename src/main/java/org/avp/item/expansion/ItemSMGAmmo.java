package org.avp.item.expansion;

import org.avp.inventory.ContainerTurret.SlotAmmunition.ITurretAmmunition;
import org.avp.item.ItemFirearm.Classification;
import org.avp.item.ItemFirearm.ItemAmmunition;

public class ItemSMGAmmo extends ItemAmmunition implements ITurretAmmunition
{
    public ItemSMGAmmo()
    {
        super(Classification.SUB_MACHINE_GUN);
    }
}
