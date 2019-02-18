package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.entities.EntitySporePod;
import org.avp.packets.server.PacketSpawnEntity;

import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;

public class ItemSporePod extends HookedItem
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        Entity entity = createNewEntity(world);

        if (entity instanceof EntitySporePod)
        {
            Inventories.consumeItem(player, this);
            RayTraceResult ray = player.rayTrace(4D, 1F);

            if (world.isRemote && entity != null && ray.typeOfHit == Type.BLOCK)
            {
                
                AliensVsPredator.network().sendToServer(new PacketSpawnEntity(ray.hitVec.x, ray.hitVec.y + 0.5D, ray.hitVec.z, Entities.getEntityRegistrationId(EntitySporePod.class)));
            }
        }

        return super.onItemRightClick(world, player, hand);
    }

    public Entity createNewEntity(World world)
    {
        return Entities.constructEntity(world, EntitySporePod.class);
    }
}
