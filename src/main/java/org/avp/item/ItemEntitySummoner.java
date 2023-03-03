package org.avp.item;

import org.avp.AliensVsPredator;
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
import net.minecraft.world.World;

public class ItemEntitySummoner extends HookedItem
{
    private Class<? extends Entity> c;

    public ItemEntitySummoner(Class<? extends Entity> c)
    {
        super();
        this.c = c;
        this.setDescription("Summoner for " + c.getSimpleName().replace("Entity", ""));
        this.setTranslationKey(AliensVsPredator.Properties.DOMAIN + "summon." + c.getSimpleName());
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        Inventories.consumeItem(player, this);

        if (world.isRemote) {
            RayTraceResult ray = player.rayTrace(50D, 1F);
            
            if(player.isSneaking() && player.isCreative()) {
                AliensVsPredator.network().sendToServer(new PacketSpawnEntity(ray.hitVec.x + 0.5, ray.hitVec.y + 1D, ray.hitVec.z + 0.5, Entities.getEntityRegistrationId(c), 5));
            } else {
                AliensVsPredator.network().sendToServer(new PacketSpawnEntity(ray.hitVec.x + 0.5, ray.hitVec.y + 1D, ray.hitVec.z + 0.5, Entities.getEntityRegistrationId(c), 1));
            }
        
        }

        return super.onItemRightClick(world, player, hand);
    }

    public Class<? extends Entity> getEntityClass()
    {
        return c;
    }

    public Entity createNewEntity(World world)
    {
        return Entities.constructEntity(world, c);
    }
}
