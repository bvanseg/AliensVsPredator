package org.avp.common.item;

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
import org.avp.AVP;
import org.avp.common.AVPItems;

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
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AVPItems.HELM_MARINE &&
                Inventories.getChestSlotItemStack(player) != null && Inventories.getChestSlotItemStack(player).getItem() == AVPItems.PLATE_MARINE &&
                Inventories.getLegsSlotItemStack(player) != null && Inventories.getLegsSlotItemStack(player).getItem() == AVPItems.LEGS_MARINE &&
                Inventories.getBootSlotItemStack(player) != null && Inventories.getBootSlotItemStack(player).getItem() == AVPItems.BOOTS_MARINE)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 1));
        }
    }
}
