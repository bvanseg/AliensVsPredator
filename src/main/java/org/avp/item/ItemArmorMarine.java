package org.avp.item;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.Draw;

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
                return Draw.getResourcePath(AliensVsPredator.resources().MARINE1);
            case LEGS:
                return Draw.getResourcePath(AliensVsPredator.resources().MARINE1);
            case CHEST:
                return Draw.getResourcePath(AliensVsPredator.resources().MARINE2);
            case HEAD:
                return Draw.getResourcePath(AliensVsPredator.resources().MARINE1);
            default:
                return Draw.getResourcePath(AliensVsPredator.resources().MARINE1);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        // if you are wearing the set, you will receive resistance and damageBoost
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == AliensVsPredator.items().helmMarine && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == AliensVsPredator.items().plateMarine && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == AliensVsPredator.items().legsMarine && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == AliensVsPredator.items().bootsMarine)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 1));
        }
    }
}
