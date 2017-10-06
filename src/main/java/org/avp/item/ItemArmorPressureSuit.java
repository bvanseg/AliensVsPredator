package org.avp.item;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorPressureSuit extends ItemAntiVacuumArmor
{
    public ItemArmorPressureSuit(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AliensVsPredator.materials().armors().pressuresuit, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
                return Draw.getResourcePath(AliensVsPredator.resources().PRESSURESUIT1);
            case LEGS:
                return Draw.getResourcePath(AliensVsPredator.resources().PRESSURESUIT2);
            case CHEST:
                return Draw.getResourcePath(AliensVsPredator.resources().PRESSURESUIT1);
            case HEAD:
                return Draw.getResourcePath(AliensVsPredator.resources().PRESSURESUIT1);
            default:
                return Draw.getResourcePath(AliensVsPredator.resources().PRESSURESUIT2);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AliensVsPredator.items().pressureMask && 
                Inventories.getChestSlotItemStack(player) != null && Inventories.getChestSlotItemStack(player).getItem() == AliensVsPredator.items().pressureChest && 
                    Inventories.getLegsSlotItemStack(player) != null && Inventories.getLegsSlotItemStack(player).getItem() == AliensVsPredator.items().pressurePants && 
                        Inventories.getBootSlotItemStack(player) != null && Inventories.getBootSlotItemStack(player).getItem() == AliensVsPredator.items().pressureBoots)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 1, 0));
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1, 0));
        }
    }
}
