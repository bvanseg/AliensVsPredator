package org.avp.common.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

//TODO: API compatability
public abstract class ItemAntiVacuumArmor extends ItemArmor
{
    public ItemAntiVacuumArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equiptmentSlot)
    {
        super(material, renderIndex, equiptmentSlot);
    }
}
