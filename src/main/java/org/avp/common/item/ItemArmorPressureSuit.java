package org.avp.common.item;

import com.asx.mdx.client.render.Draw;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import org.avp.client.Resources;
import org.avp.common.AVPItems;
import org.avp.common.AVPMaterials;

public class ItemArmorPressureSuit extends ItemAntiVacuumArmor
{
    public ItemArmorPressureSuit(int renderIndex, EntityEquipmentSlot armorType)
    {
        super(AVPMaterials.Armors.PRESSURE_SUIT, renderIndex, armorType);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        switch (slot)
        {
            case FEET:
            case CHEST:
            case HEAD:
                return Draw.getPath(Resources.instance.PRESSURESUIT1);
            default:
                return Draw.getPath(Resources.instance.PRESSURESUIT2);
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (Inventories.getHelmSlotItemStack(player) != null && Inventories.getHelmSlotItemStack(player).getItem() == AVPItems.PRESSURE_MASK &&
                Inventories.getChestSlotItemStack(player) != null && Inventories.getChestSlotItemStack(player).getItem() == AVPItems.PRESSURE_CHEST &&
                    Inventories.getLegsSlotItemStack(player) != null && Inventories.getLegsSlotItemStack(player).getItem() == AVPItems.PRESSURE_PANTS &&
                        Inventories.getBootSlotItemStack(player) != null && Inventories.getBootSlotItemStack(player).getItem() == AVPItems.PRESSURE_BOOTS)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 1, 0));
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 1, 0));
        }
    }
}
