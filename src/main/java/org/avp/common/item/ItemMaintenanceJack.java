package org.avp.common.item;

import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

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
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Use this to forcefully open blast doors.");
    }
}
