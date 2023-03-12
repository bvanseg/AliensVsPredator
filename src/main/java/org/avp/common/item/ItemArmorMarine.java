package org.avp.common.item;

import org.avp.AVP;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorMarine extends ItemArmor
{
    public ItemArmorMarine(int renderIndex, EntityEquipmentSlot slot)
    {
        super(AVP.materials().armors().kevlar, renderIndex, slot);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot) {
            case FEET:
            case LEGS:
                return Draw.getPath(AVP.resources().MARINE2);
            default:
                return Draw.getPath(AVP.resources().MARINE1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AVP.items().helmMarine &&
                Inventories.getChestSlotItemStack(player) != null && Inventories.getChestSlotItemStack(player).getItem() == AVP.items().plateMarine &&
                Inventories.getLegsSlotItemStack(player) != null && Inventories.getLegsSlotItemStack(player).getItem() == AVP.items().legsMarine &&
                Inventories.getBootSlotItemStack(player) != null && Inventories.getBootSlotItemStack(player).getItem() == AVP.items().bootsMarine)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 1));
        }
    }
}
