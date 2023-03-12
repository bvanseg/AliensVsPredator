package org.avp.common.item;

import org.avp.AVP;

import com.asx.mdx.lib.client.util.Draw;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemArmorMK50 extends ItemAntiVacuumArmor
{
    public ItemArmorMK50(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AVP.materials().armors().mk50, renderIndex, armorType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot) {
            case FEET:
            case LEGS:
            case HEAD:
                return Draw.getPath(AVP.resources().MK501);
            default:
                return Draw.getPath(AVP.resources().MK502);
        }
    }
    
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        ;
    }
}
