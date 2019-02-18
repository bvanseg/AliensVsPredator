package org.avp.item;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Worlds;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemIngotLithium extends HookedItem
{
    public int depletionTicks = 20 * 60;

    public ItemIngotLithium()
    {
        ;
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean selected)
    {
        super.onUpdate(itemstack, world, entity, slot, selected);

        if (itemstack != null && itemstack.getTagCompound() != null)
        {
            int currentDepletion = itemstack.getTagCompound().getInteger("depletion");
            NBTTagCompound newTag = new NBTTagCompound();
            newTag.setInteger("depletion", currentDepletion + 1);
            itemstack.setTagCompound(newTag);
            currentDepletion = itemstack.getTagCompound().getInteger("depletion");

            if (currentDepletion >= depletionTicks)
            {
                Worlds.createExplosion(entity, world, new Pos(entity), 1F, true, true, !world.isRemote);
                Inventories.consumeItem((EntityPlayer) entity, this, true);
            }
        }
        else if (itemstack != null && itemstack.getTagCompound() == null)
        {
            NBTTagCompound newTag = new NBTTagCompound();
            newTag.setInteger("depletion", 1);
            itemstack.setTagCompound(newTag);
        }
    }
}
