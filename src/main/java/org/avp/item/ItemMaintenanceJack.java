package org.avp.item;

import java.util.List;

import com.arisux.mdx.lib.world.item.HookedItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMaintenanceJack extends HookedItem
{
    public ItemMaintenanceJack()
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(100);
    }

    public void onPryBlastDoor(EntityPlayer player, ItemStack currentEquippedItem)
    {
        currentEquippedItem.damageItem(1, player);
    }

    public void onOpenBlastDoor(EntityPlayer player, ItemStack currentEquippedItem)
    {
        ;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("all")
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Use this to forcefully open blast doors.");
    }
}
