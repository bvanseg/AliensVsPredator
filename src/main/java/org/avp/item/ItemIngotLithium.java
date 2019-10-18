package org.avp.item;

import java.util.Random;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Worlds;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIngotLithium extends HookedItem
{
    public ItemIngotLithium()
    {
        ;
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean selected)
    {
        super.onUpdate(itemstack, world, entity, slot, selected);

        if (entity.isInWater())
        {
            Worlds.createExplosion(entity, world, new Pos(entity), 1F, true, true, !world.isRemote);
            Inventories.consumeItem((EntityPlayer) entity, this, true);
        }

        if (world.isRaining() && world.canSeeSky(entity.getPosition()))
        {
            if (world.getWorldTime() % 20 == 0)
            {
                if (new Random().nextInt(5) == 0)
                {
                    Worlds.createExplosion(entity, world, new Pos(entity), 1F, true, true, !world.isRemote);
                    Inventories.consumeItem((EntityPlayer) entity, this, true);
                }
            }
        }
    }
}
