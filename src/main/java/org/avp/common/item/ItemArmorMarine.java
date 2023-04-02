package org.avp.common.item;

import com.asx.mdx.client.render.Draw;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import org.avp.client.Resources;
import org.avp.common.AVPArmorMaterials;
import org.avp.common.AVPItems;

public class ItemArmorMarine extends ItemArmor
{
    public ItemArmorMarine(int renderIndex, EntityEquipmentSlot slot)
    {
        super(AVPArmorMaterials.KEVLAR, renderIndex, slot);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot) {
            case FEET:
            case LEGS:
                return Draw.getPath(Resources.instance.MARINE2);
            default:
                return Draw.getPath(Resources.instance.MARINE1);
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
