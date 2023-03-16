package org.alien.common.item;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import org.alien.common.entity.living.EntitySporePod;
import org.avp.AVP;
import org.avp.common.network.packet.server.PacketSpawnEntity;

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
                
                AVP.network().sendToServer(new PacketSpawnEntity(ray.hitVec.x, ray.hitVec.y + 0.5D, ray.hitVec.z, Entities.getEntityRegistrationId(EntitySporePod.class)));
            }
        }

        return super.onItemRightClick(world, player, hand);
    }

    public Entity createNewEntity(World world)
    {
        return Entities.constructEntity(world, EntitySporePod.class);
    }
}
