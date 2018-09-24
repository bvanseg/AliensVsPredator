package org.avp.item;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

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
        super(AliensVsPredator.materials().armors().kevlar, renderIndex, slot);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
                return Draw.getPath(AliensVsPredator.resources().MARINE2);
            case LEGS:
                return Draw.getPath(AliensVsPredator.resources().MARINE2);
            case CHEST:
                return Draw.getPath(AliensVsPredator.resources().MARINE1);
            case HEAD:
                return Draw.getPath(AliensVsPredator.resources().MARINE1);
            default:
                return Draw.getPath(AliensVsPredator.resources().MARINE1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AliensVsPredator.items().helmMarine &&
                Inventories.getChestSlotItemStack(player) != null && Inventories.getChestSlotItemStack(player).getItem() == AliensVsPredator.items().plateMarine &&
                Inventories.getLegsSlotItemStack(player) != null && Inventories.getLegsSlotItemStack(player).getItem() == AliensVsPredator.items().legsMarine &&
                Inventories.getBootSlotItemStack(player) != null && Inventories.getBootSlotItemStack(player).getItem() == AliensVsPredator.items().bootsMarine)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1, 1));
        }
    }
}
