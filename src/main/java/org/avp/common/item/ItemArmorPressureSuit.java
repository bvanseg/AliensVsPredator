package org.avp.common.item;

import org.avp.AVP;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;

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
        super(AVP.materials().armors().pressuresuit, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
            case CHEST:
            case HEAD:
                return Draw.getPath(AVP.resources().PRESSURESUIT1);
            default:
                return Draw.getPath(AVP.resources().PRESSURESUIT2);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AVP.items().pressureMask &&
                Inventories.getChestSlotItemStack(player) != null && Inventories.getChestSlotItemStack(player).getItem() == AVP.items().pressureChest &&
                    Inventories.getLegsSlotItemStack(player) != null && Inventories.getLegsSlotItemStack(player).getItem() == AVP.items().pressurePants &&
                        Inventories.getBootSlotItemStack(player) != null && Inventories.getBootSlotItemStack(player).getItem() == AVP.items().pressureBoots)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 1, 0));
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1, 0));
        }
    }
}
