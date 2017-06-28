package org.avp.item;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.Draw;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemArmorMK50 extends ItemAntiVacuumArmor
{
    public ItemArmorMK50(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AliensVsPredator.materials().armors().mk50, renderIndex, armorType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
                return Draw.getResourcePath(AliensVsPredator.resources().MK501);
            case LEGS:
                return Draw.getResourcePath(AliensVsPredator.resources().MK501);
            case CHEST:
                return Draw.getResourcePath(AliensVsPredator.resources().MK502);
            case HEAD:
                return Draw.getResourcePath(AliensVsPredator.resources().MK501);
            default:
                return Draw.getResourcePath(AliensVsPredator.resources().MK502);
        }
    }
    
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        ;
    }
}
